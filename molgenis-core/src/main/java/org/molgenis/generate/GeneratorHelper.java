package org.molgenis.generate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.molgenis.MolgenisModel;
import org.molgenis.MolgenisOptions;
import org.molgenis.MolgenisTypes;
import org.molgenis.model.EntityModel;
import org.molgenis.model.FieldModel;
import org.molgenis.model.MolgenisModelException;
import org.molgenis.model.UniqueModel;
import org.molgenis.types.EnumField;
import org.molgenis.types.FieldType;
import org.molgenis.types.FileField;
import org.molgenis.types.ImageField;
import org.molgenis.types.IntField;
import org.molgenis.types.MrefField;
import org.molgenis.types.XrefField;

public class GeneratorHelper
{
	private static final transient Logger logger = Logger.getLogger(GeneratorHelper.class.getSimpleName());
	MolgenisOptions options;
	MolgenisTypes typeRegistry;

	public GeneratorHelper(MolgenisOptions options)
	{
		this.options = options;
		this.typeRegistry = new MolgenisTypes();

	}

	/**
	 * Convert string with first character to uppercase.
	 * 
	 * @param string
	 * @return string with first character in uppercase.
	 */
	public static String firstToUpper(String string)
	{
		if (string == null) return " NULL ";
		if (string.length() > 0) return string.substring(0, 1).toUpperCase() + string.substring(1);
		else
			return " ERROR[STRING EMPTY] ";
	}

	/**
	 * Convert string with first character to lowercase.
	 * 
	 * @param string
	 * @return string with first character in lowercase.
	 */
	public static String firstToLower(String string)
	{
		if (string == null) return " NULL ";
		if (string.length() > 1) return string.substring(0, 1).toLowerCase() + string.substring(1);
		return string;
	}

	/**
	 * Convert string to full uppercase
	 * 
	 * @param string
	 * @return uppercase string
	 */
	public static String toUpper(String string)
	{
		if (string == null) return " NULL ";
		return string.toUpperCase();
	}

	/**
	 * Convert string to full lowercase
	 * 
	 * @param string
	 * @return lowercase string
	 */
	public static String toLower(String string)
	{
		if (string == null) return " NULL ";
		return string.toLowerCase();
	}

	/**
	 * Get the java type for a field.
	 * 
	 * @return the java type or UKNOWN
	 */
	public String getType(FieldModel field) throws Exception
	{
		if (field == null) return "NULLPOINTER";
		try
		{
			return MolgenisTypes.get(field).getJavaPropertyType();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "EXCEPTION";
		}
	}

	/**
	 * Get the cpp type for a field.
	 * 
	 * @return the java type or UKNOWN
	 */
	public String getCppType(FieldModel field) throws Exception
	{
		if (field == null) return "void*";
		try
		{
			return MolgenisTypes.get(field).getCppPropertyType();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "EXCEPTION";
		}
	}

	/**
	 * Get the cpp type for a field.
	 * 
	 * @return the java type or UKNOWN
	 */
	public String getCppJavaType(FieldModel field) throws Exception
	{
		if (field == null) return "Ljava/lang/NULL;";
		try
		{
			return MolgenisTypes.get(field).getCppJavaPropertyType();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "EXCEPTION";
		}
	}

	/**
	 * Java setter type of the field, e.g. getString() returns "String".
	 * 
	 * @param model
	 * @param field
	 * @return setter type
	 * @throws Exception
	 */
	public String getSetType(MolgenisModel model, FieldModel field) throws Exception
	{
		return MolgenisTypes.get(field).getJavaSetterType();
	}

	/**
	 * Creates a default value based on the default values set in the model. If
	 * no defaultValue is provided and if the field is not "automatic" then the
	 * default value is set to "null" so the user has to decide.
	 * 
	 * @param model
	 *            Meta model
	 * @param field
	 *            Meta model of a field (question: couldn't we ask the field for
	 *            this??)
	 * @return the default value as String
	 * @throws Exception
	 */
	public String getDefault(MolgenisModel model, FieldModel field) throws Exception
	{
		return MolgenisTypes.get(field).getJavaPropertyDefault();
	}

	/**
	 * Convert a list of string to comma separated values.
	 * 
	 * @param elements
	 * @return csv
	 */
	public String toCsv(List<String> elements)
	{
		StringBuilder strBuilder = new StringBuilder();

		if (elements != null) for (String str : elements)
		{
			if (elements.get(0) != str) strBuilder.append(',');
			strBuilder.append('\'').append(str).append('\'');
		}

		return strBuilder.toString();
	}

	/**
	 * Get the mysql type of a field: VARCHAR, INT, etc.
	 * 
	 * @param model
	 * @param field
	 * @return string that represents the mysql value of a fieldtype.
	 * @throws Exception
	 */
	public String getMysqlType(MolgenisModel model, FieldModel field) throws Exception
	{
		return MolgenisTypes.get(field).getMysqlType();
	}

	public String getOracleType(MolgenisModel model, FieldModel field) throws Exception
	{
		return MolgenisTypes.get(field).getOracleType();
	}

	public String getXsdType(MolgenisModel model, FieldModel field) throws Exception
	{
		return MolgenisTypes.get(field).getXsdType();
	}

	public String getHsqlType(FieldModel field) throws Exception
	{
		Logger.getLogger("TEST").debug("trying " + field);
		return MolgenisTypes.get(field).getHsqlType();
	}

	public List<FieldModel> getAddFields(EntityModel e) throws Exception
	{
		return this.getAddFields(e, false);
	}

	/**
	 * Get the fields that participate in an insert (so excluding automatic
	 * fields).
	 * 
	 * @param e
	 * @param includeKey
	 * @return vector of fields that are not automatic values
	 * @throws Exception
	 */
	public List<FieldModel> getAddFields(EntityModel e, boolean includeKey) throws Exception
	{
		List<FieldModel> add_fields = new ArrayList<FieldModel>();

		if (options.object_relational_mapping.equals(MolgenisOptions.CLASS_PER_TABLE))
		{
			for (FieldModel f : getAllFields(e))
			{
				// get rid of mref,
				// get rid of automatic id
				// get rid of "type" enum field when not root ancestor
				if (!isMref(f) && (!isAutoId(f, e) || includeKey))
				// TODO: fix automatic fields
				// MAJOR error, arghhhh!!! &&
				// !getKeyFields(PRIMARY_KEY).contains(f))
				{
					add_fields.add(f);
				}
			}
		}
		else if (options.object_relational_mapping.equals(MolgenisOptions.SUBCLASS_PER_TABLE))
		{
			for (FieldModel f : e.getImplementedFields())
			{
				// get rid of mref,
				// get rid of automatic id
				// get rid of "type" enum field when not root ancestor
				boolean inheritedField = (f.getEntity().getExtends() != null && f.getEntity().getExtends()
						.getAllFields().contains(f));
				if (!isMref(f) && (!isAutoId(f, e) || includeKey || inheritedField))
				// TODO: fix automatic fields
				// MAJOR error, arghhhh!!! &&
				// !getKeyFields(PRIMARY_KEY).contains(f))
				{

					add_fields.add(f);
				}
			}
			// if(e.hasAncestor()) {
			// add_fields.add(e.getPrimaryKey());
			// }
		}

		return add_fields;
	}

	/**
	 * Test wether the field is an mref.
	 * 
	 * @param f
	 * @return
	 */
	private boolean isMref(FieldModel f)
	{
		return f.getType() instanceof MrefField;
	}

	/**
	 * Test wether the field as a "type" field.
	 * 
	 * @param f
	 * @param e
	 * @return
	 */
	private boolean isTypeField(FieldModel f, EntityModel e)
	{
		return !e.isRootAncestor() && f.getType() instanceof EnumField && f.getName() == FieldModel.TYPE_FIELD;
	}

	private boolean isAutoId(FieldModel f, EntityModel e)
	{
		return f.getType() instanceof IntField && f.getAuto();
		// SOLVED BY TRIGGERS && f.getEntity() == e;
	}

	public List<FieldModel> getAllFields(EntityModel e) throws Exception
	{
		return getAllFields(e, "");
	}

	public List<FieldModel> getAllFields(EntityModel e, String type) throws Exception
	{
		List<FieldModel> all_fields = e.getAllFields();

		for (FieldModel f : e.getAllFields())
		{
			if (!all_fields.contains(f) && (type.equals("") || f.getType().toString().equals(type)))
			{
				all_fields.add(f);
			}
		}

		return all_fields;
	}

	/**
	 * The table fields of this entity
	 */
	public List<FieldModel> getDbFields(EntityModel e, String type) throws Exception
	{
		List<FieldModel> db_fields = new ArrayList<FieldModel>();
		if (options.object_relational_mapping.equals(MolgenisOptions.CLASS_PER_TABLE))
		{
			List<FieldModel> all_fields = getAllFields(e, type);

			for (FieldModel f : all_fields)
			{
				if (!(f.getType() instanceof MrefField) // && (f.getName() !=
														// "type" ||
														// e.isRootAncestor())
						&& (type.equals("") || f.getType().toString().equals(type)))
				{
					db_fields.add(f);
				}
			}
		}
		else if (options.object_relational_mapping.equals(MolgenisOptions.SUBCLASS_PER_TABLE))
		{
			List<FieldModel> local_fields = e.getImplementedFields();

			for (FieldModel f : local_fields)
			{
				if (!(f.getType() instanceof MrefField) // && (f.getName() !=
														// "type" ||
														// e.isRootAncestor())
						&& (type.equals("") || f.getType().toString().equals(type)))
				{
					db_fields.add(f);
				}
			}

			// if(e.hasAncestor()) {
			// db_fields.add(e.getPrimaryKey());
			// }
		}
		// String field_names = "";
		// for(FieldModel f: db_fields) field_names += f.getName()+" ";
		// logger.error("dbFields for "+e.getName()+": "+field_names);
		return db_fields;
	}

	/**
	 * The queryable fields of the entity (in case of inheritance from the view
	 * join)
	 * 
	 * @param e
	 * @param type
	 * @throws Exception
	 */
	public List<FieldModel> getViewFields(EntityModel e, String type) throws Exception
	{
		List<FieldModel> view_fields = new ArrayList<FieldModel>();

		List<FieldModel> all_fields = getAllFields(e, type);

		for (FieldModel f : all_fields)
		{
			if (!(f.getType() instanceof MrefField) && (type.equals("") || f.getType().toString().equals(type)))
			{
				view_fields.add(f);
			}
		}

		return view_fields;
	}

	public List<FieldModel> getUpdateFields(EntityModel e) throws Exception
	{
		List<FieldModel> all_update_fields = new ArrayList<FieldModel>();

		List<FieldModel> fields = null;
		if (e.getImplementedFields().size() > e.getFields().size())
		{
			fields = e.getImplementedFields();
		}
		else
		{
			fields = e.getFields();
		}

		for (FieldModel f : fields)
		{
			// exclude readonly, unless it is the id or a file filed
			if (!isMref(f)
					&& !isTypeField(f, e)
					&& (!f.getReadonly() || isPrimaryKey(f, e) || f.getType() instanceof FileField || f.getType() instanceof ImageField))
			{
				all_update_fields.add(f);
			}
		}

		return all_update_fields;
	}

	public boolean isPrimaryKey(FieldModel f, EntityModel e) throws MolgenisModelException
	{
		return e.getKeyFields(0).contains(f);
	}

	public List<FieldModel> getKeyFields(EntityModel e) throws MolgenisModelException
	{
		return e.getKeyFields(0);
	}

	public List<UniqueModel> getAllKeys(EntityModel e) throws MolgenisModelException
	{
		List<UniqueModel> all_keys = new ArrayList<UniqueModel>();

		if (e.getExtends() != null)
		{
			all_keys.addAll(getAllKeys(e.getExtends()));
		}
		for (UniqueModel u : e.getUniques())
		{
			if (!all_keys.contains(u))
			{
				all_keys.add(u);
			}
		}

		return all_keys;
	}

	/**
	 * Return all secondary keys for an entity
	 * 
	 * @param e
	 *            entity
	 * @return list of unique
	 * @throws MolgenisModelException
	 */
	public List<UniqueModel> getSecondaryKeys(EntityModel e) throws MolgenisModelException
	{
		List<UniqueModel> allkeys = getAllKeys(e);
		List<UniqueModel> skeys = new ArrayList<UniqueModel>();
		if (allkeys.size() > 1) for (int i = 1; i < allkeys.size(); i++)
		{
			skeys.add(allkeys.get(i));
		}
		return skeys;
	}

	/**
	 * Return all secondary key fields. If two secondary keys share a field, its
	 * only returned once.
	 * 
	 * @param keys
	 *            list of UniqueModel definitions
	 * @return vector of fields that are part of a unique constraint
	 * @throws MolgenisModelException
	 */
	public List<FieldModel> getKeyFields(List<UniqueModel> keys) throws MolgenisModelException
	{
		Map<String, FieldModel> result = new LinkedHashMap<String, FieldModel>();
		for (UniqueModel u : keys)
		{
			for (FieldModel f : u.getFields())
			{
				if (result.get(f.getName()) == null)
				{
					result.put(f.getName(), f);
				}
			}
		}
		return new ArrayList<FieldModel>(result.values());
	}

	public List<FieldModel> getSecondaryKeyFields(EntityModel e) throws MolgenisModelException
	{
		List<UniqueModel> keys = this.getSecondaryKeys(e);
		Map<String, FieldModel> result = new LinkedHashMap<String, FieldModel>();
		for (UniqueModel u : keys)
		{
			for (FieldModel f : u.getFields())
			{
				if (result.get(f.getName()) == null)
				{
					result.put(f.getName(), f);
				}
			}
			break;
		}
		return new ArrayList<FieldModel>(result.values());
	}

	public List<FieldModel> getKeyFields(UniqueModel u) throws MolgenisModelException
	{
		return u.getFields();
	}

	/**
	 * A table can only contain the keys for columns that are actually in the
	 * table. In subclass_per_table mapping this requirement is not satisfied.
	 * These keys are ommited, and a warning is shown that these keys are not
	 * enforced.
	 * 
	 * @param e
	 * @return List of UniqueModel (singular or complex keys)
	 * @throws MolgenisModelException
	 */
	public List<UniqueModel> getTableKeys(EntityModel e) throws MolgenisModelException
	{
		List<UniqueModel> all_keys = getAllKeys(e);
		List<UniqueModel> table_keys = new ArrayList<UniqueModel>();

		if (options.object_relational_mapping.equals(MolgenisOptions.SUBCLASS_PER_TABLE))
		{

			for (UniqueModel aKey : all_keys)
			{
				boolean inTable = true;
				String field = null;
				for (FieldModel f : aKey.getFields())
				{
					if (!e.getFields().contains(f))
					{
						inTable = false;
						field = f.getName();
					}
				}
				if (inTable) table_keys.add(aKey);
				else
					logger.warn("key " + aKey + " cannot be enforced on entity " + e.getName() + ": column '" + field
							+ "' is not in the subclass table.");
			}
		}

		return table_keys;
	}

	public FieldModel getXrefField(MolgenisModel model, FieldModel f) throws Exception
	{
		return f.getXrefEntity().getField(f.getXrefFieldName());
	}

	public FieldType getFieldType(MolgenisModel model, FieldModel field) throws Exception
	{
		FieldType type = field.getType();
		if (type instanceof XrefField || type instanceof MrefField)
		{
			// EntityModel e_ref = field.getXrefEntity();
			FieldModel f_ref = field.getXrefField();
			return getFieldType(model, f_ref);
		}
		else
		{
			return type;
		}

	}

	/**
	 * First character to upercase. And also when following "_";
	 * 
	 * @param name
	 * @return
	 */
	public static String getJavaName(String name)
	{
		if (name == null) return " NULL ";

		String[] split = name.split("_");
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < split.length; i++)
		{
			if (i > 0) strBuilder.append('_');
			if (!split[i].isEmpty()) strBuilder.append(firstToUpper(split[i]));
		}

		return strBuilder.toString();
	}

	public List<EntityModel> getSubclasses(EntityModel superclass, MolgenisModel m)
	{
		List<EntityModel> result = new ArrayList<EntityModel>();
		result.add(superclass);

		String name = superclass.getName();
		for (EntityModel e : m.getEntities())
		{
			if (name.equals(e.getExtends().getName()))
			{
				result.addAll(getSubclasses(e, m));
			}
		}
		// logger.debug("found "+result.size()+ " subclases");
		return result;
	}

	public List<EntityModel> getSuperclasses(EntityModel subclass, MolgenisModel m)
	{
		List<EntityModel> result = new ArrayList<EntityModel>(subclass.getAllExtends());
		result.add(subclass);
		// Collections.reverse(result);
		return result;
	}

	public String pluralOf(String string)
	{
		return string + "s";
		// return Noun.pluralOf(string,Locale.ENGLISH);
	}

	/**
	 * Thank you, AndroMDA project... Linguistically pluralizes a singular noun.
	 * <p/>
	 * <ul>
	 * <li><code>noun</code> becomes <code>nouns</code></li>
	 * <li><code>key</code> becomes <code>keys</code></li>
	 * <li><code>word</code> becomes <code>words</code></li>
	 * <li><code>property</code> becomes <code>properties</code></li>
	 * <li><code>bus</code> becomes <code>busses</code></li>
	 * <li><code>boss</code> becomes <code>bosses</code></li>
	 * </ul>
	 * <p>
	 * Whitespace as well as <code>null></code> arguments will return an empty
	 * String.
	 * </p>
	 * 
	 * @param singularNoun
	 *            A singularNoun to pluralize
	 * @return The plural of the argument singularNoun
	 */
	public static String pluralize(String singularNoun)
	{
		throw new UnsupportedOperationException();
		// return Pluralizer.getInstance().pluralize(singularNoun);

		/*
		 * String pluralNoun = singularNoun;
		 * 
		 * int nounLength = pluralNoun.length();
		 * 
		 * if (nounLength == 1) { pluralNoun = pluralNoun + 's'; } else if
		 * (nounLength > 1) { char secondToLastChar =
		 * pluralNoun.charAt(nounLength - 2);
		 * 
		 * if (pluralNoun.endsWith("y")) { switch (secondToLastChar) { case 'a'
		 * : // fall-through case 'e' : // fall-through case 'i' : //
		 * fall-through case 'o' : // fall-through case 'u' : pluralNoun =
		 * pluralNoun + 's'; break; default : pluralNoun =
		 * pluralNoun.substring(0, nounLength - 1) + "ies"; } } else if
		 * (pluralNoun.endsWith("s")) { switch (secondToLastChar) { case 's' :
		 * pluralNoun = pluralNoun + "es"; break; default : pluralNoun =
		 * pluralNoun + "ses"; } } else { pluralNoun = pluralNoun + 's'; } }
		 * return pluralNoun;
		 */
	}

	public String parseQueryOperator(String label)
	{
		if (label.equals("EQUALS")) return "EQUALS";
		else if (label.equals("IN")) return "IN";
		else if (label.equals("LESS")) return "LESS";
		else if (label.equals("LESS_EQUAL")) return "LESS_EQUAL";
		else if (label.equals("GREATER")) return "GREATER";
		else if (label.equals("GREATER_EQUAL")) return "GREATER_EQUAL";
		else if (label.equals("LIKE")) return "LIKE";
		else if (label.equals("NOT")) return "NOT";
		else if (label.equals("LIMIT")) return "LIMIT";
		else if (label.equals("OFFSET")) return "OFFSET";
		else if (label.equals("SORTASC")) return "SORTASC";
		else if (label.equals("SORTDESC")) return "SORTDESC";
		else if (label.equals("NESTED")) return "NESTED";
		else if (label.equals("LAST")) return "LAST";

		return "UNKNOWN";
	}

	public static String escapeXml(String nonXml)
	{
		return StringEscapeUtils.escapeXml(nonXml);
	}

	public String getImports(MolgenisModel m, EntityModel e, String subpackage, String suffix)
			throws MolgenisModelException
	{
		String sfx = suffix;
		String subPkg = subpackage;
		if (sfx == null) sfx = "";
		if (subPkg != null)
		{
			subPkg = subPkg.trim();
			if (!subPkg.equals(""))
			{
				if (!subPkg.startsWith(".")) subPkg = "." + subPkg;
				if (!subPkg.endsWith(".")) subPkg = subPkg + ".";
			}
			else
			{
				subPkg = ".";
			}

		}
		else
		{
			subPkg = ".";
		}

		// import referenced fields
		List<String> imports = new ArrayList<String>();
		for (FieldModel f : e.getAllFields())
		{
			if (f.getType() instanceof XrefField || f.getType() instanceof MrefField)
			{

				String fullClassName = f.getXrefEntity().getNamespace() + subPkg
						+ getJavaName(f.getXrefEntity().getName()) + sfx;
				if (!imports.contains(fullClassName))
				{
					imports.add(fullClassName);
				}
			}

			// import link tables
			// if (f.getType().equals(FieldModel.Type.XREF_MULTIPLE))
			// {
			//
			// EntityModel linktable = m.getEntity(f.getMrefName());
			// if(linktable != null)
			// {
			// String fullClassName = linktable.getNamespace() + subPkg
			// + this.firstToUpper(linktable.getName())+sfx;
			// if (!imports.contains(fullClassName))
			// {
			// imports.add(fullClassName);
			// }
			// }
			// }
		}

		// import self
		String fullClassName = e.getNamespace() + subPkg + getJavaName(e.getName()) + sfx;
		if (!imports.contains(fullClassName))
		{
			imports.add(fullClassName);
		}

		// import parents
		// for(String superclass: e.getParents())
		// {
		// EntityModel parentEntity = m.getEntity(superclass);
		// fullClassName = parentEntity.getNamespace() + subPkg +
		// this.firstToUpper(parentEntity.getName())+sfx;
		// if (!imports.contains(fullClassName))
		// {
		// imports.add(fullClassName);
		// }
		// }

		StringBuilder strBuilder = new StringBuilder();
		for (String i : imports)
		{
			strBuilder.append("import ").append(i).append(";\n");
		}
		return strBuilder.toString();
	}

	public String getTypeFieldName()
	{
		return FieldModel.TYPE_FIELD;
	}
}
