package org.molgenis.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import org.molgenis.MolgenisTypes;
import org.molgenis.types.CharField;
import org.molgenis.types.FieldType;
import org.molgenis.types.MrefField;
import org.molgenis.types.StringField;
import org.molgenis.types.XrefField;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "field")
public class FieldModel
{
	public static final String TYPE_FIELD = "__type";

	// this value will be set after parsing
	private EntityModel entity = null;

	@XmlAttribute(name = "name")
	private String name;

	@XmlAttribute(name = "label")
	private String label;

	@XmlAttribute(name = "type")
	private String type;

	@XmlAttribute(name = "auto")
	private Boolean auto = false;

	@XmlAttribute(name = "nillable")
	private Boolean nillable = false;

	@XmlAttribute(name = "readonly")
	private Boolean readonly = false;

	@XmlAttribute(name = "readonly")
	private Boolean hidden = false;

	@XmlAttribute(name = "readonly")
	private Boolean system = false;

	@XmlAttribute(name = "xref_entity")
	private String xref_entity;

	@XmlAttribute(name = "xref_label")
	private String xref_label;

	@XmlAttribute(name = "xref_cascade")
	private Boolean xref_cascade = false;

	@XmlAttribute(name = "unique")
	private Boolean unique = false;

	@XmlAttribute(name = "length")
	private Integer length;

	@XmlAttribute(name = "default")
	private String defaultValue = null;

	@XmlAttribute(name = "description")
	private String description = "No description provided";

	@XmlAttribute(name = "enum_options")
	private String enum_options;

	@XmlAttribute(name = "mref_remoteid")
	private String mref_remoteid;

	@XmlAttribute(name = "mref_localid")
	private String mref_localid;

	@XmlAttribute(name = "mref_name")
	private String mref_name;

	public FieldModel()
	{

	}

	public FieldModel(FieldModel f)
	{
		this.setAuto(f.getAuto());
		this.setDefaultValue(f.getDefaultValue());
		this.setDescription(f.getDescription());
		this.setEntity(f.getEntity());
		this.setEnumOptions(f.getEnumOptions());
		this.setHidden(f.getHidden());
		this.setLabel(f.getLabel());
		this.setLength(f.getLength());
		this.setMrefLocalid(f.getMrefLocalid());
		this.setMrefRemoteid(f.getMrefRemoteid());
		this.setMrefName(f.getMrefName());
		this.setName(f.getName());
		this.setNillable(f.getNillable());
		this.setReadonly(f.getReadonly());
		this.setSystem(f.getSystem());
		this.setType(f.getType());
		this.setUnique(f.getUnique());
		this.setXrefCascade(f.getXrefCascade());
		this.setXrefEntity(f.getXrefEntity());
		this.setXrefLabel(f.xref_label);
	}

	public void setXrefEntity(EntityModel xrefEntity)
	{
		if (xrefEntity != null) this.xref_entity = xrefEntity.getName();
		else
			this.xref_entity = null;
	}

	public void setXrefLabel(FieldModel xrefLabel)
	{
		this.setXrefLabel(xrefLabel.getName());
	}

	public String getXrefFieldName()
	{
		if (getEntity().getKeyFields(0) != null && getEntity().getKeyFields(0).size() > 0)
		{
			return getEntity().getKeyFields(0).get(0).getName();
		}
		return null;
	}

	public void setEnumOptions(List<String> enumOptions)
	{
		this.setEnumOptions(enumOptions.toString());
	}

	// GETTERS and SETTERS
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLabel()
	{
		if(label == null) return getName();
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public FieldType getType()
	{
		// default string
		if (this.type == null || "varchar".equals(this.type)) return new StringField();

		// accomdate autoid
		if ("autoid".equals(this.type))
		{
			this.unique = true;
			this.auto = true;
			this.type = "int";
		}
		return MolgenisTypes.getType(type);
	}

	public void setType(FieldType type)
	{
		this.setType(type.getName());
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public EntityModel getXrefEntity()
	{
		return this.entity.getModel().getEntity(this.xref_entity);
	}

	public void setXrefEntity(String xrefEntity)
	{
		this.xref_entity = xrefEntity;
	}

	public FieldModel getXrefLabel()
	{
		if (xref_label != null)
		{
			return getXrefEntity().getField(xref_label);
		}
		else
		{
			return getXrefEntity().getField(getXrefEntity().getXrefLabel());
		}
	}

	public void setXrefLabel(String xref_label)
	{
		this.xref_label = xref_label;
	}

	public Boolean getAuto()
	{
		if ("autoid".equals(this.type))
		{
			this.unique = true;
			this.type = "int";
			this.auto = true;
		}
		return this.auto;
	}

	public void setAuto(Boolean auto)
	{
		this.auto = auto;
	}

	public Boolean getNillable()
	{
		return this.nillable;
	}

	public void setNillable(Boolean nillable)
	{
		this.nillable = nillable;
	}

	public Boolean getUnique()
	{
		if ("autoid".equals(this.type))
		{
			this.unique = true;
			this.type = "int";
			this.auto = true;
		}
		return unique;
	}

	public void setUnique(Boolean unique)
	{
		this.unique = unique;
	}

	public Boolean getReadonly()
	{
		return readonly;
	}

	public void setReadonly(Boolean readonly)
	{
		this.readonly = readonly;
	}

	public void setEnumOptions(String enumoptions)
	{
		this.enum_options = enumoptions;
	}

	public Integer getLength()
	{
		return length;
	}

	public void setLength(Integer length)
	{
		this.length = length;
	}

	public String getMrefName()
	{
		return mref_name;
	}

	public void setMrefName(String mref_name)
	{
		this.mref_name = mref_name;
	}

	public String getMrefLocalid()
	{
		return mref_localid;
	}

	public void setMrefLocalid(String mref_localid)
	{
		this.mref_localid = mref_localid;
	}

	public String getMrefRemoteid()
	{
		return mref_remoteid;
	}

	public void setMrefRemoteid(String mref_remoteid)
	{
		this.mref_remoteid = mref_remoteid;
	}

	public String getDefaultValue()
	{
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue)
	{
		this.defaultValue = defaultValue;
	}

	public Boolean getHidden()
	{
		return hidden;
	}

	public void setHidden(Boolean hidden)
	{
		this.hidden = hidden;
	}

	public List<String> getEnumOptions()
	{
		List<String> result = new ArrayList<String>();
		if (this.enum_options != null)
		{
			for (String str : this.enum_options.split(","))
			{
				result.add(str);
			}
		}
		return result;
	}

	public void setType(StringField stringField)
	{
		assert stringField != null;
		this.setName(stringField.getName());
	}

	public FieldModel getXrefField()
	{
		return getXrefEntity().getPrimaryKey();
	}

	public Boolean getSystem()
	{
		return system;
	}

	public void setSystem(Boolean system)
	{
		this.system = system;
	}

	public String getEntityName()
	{
		throw new UnsupportedOperationException("TODO");
	}

	public EntityModel getEntity()
	{
		return entity;
	}

	public void setEntity(EntityModel entity)
	{
		this.entity = entity;
	}

	public Boolean getXrefCascade()
	{
		return xref_cascade;
	}

	public void setXrefCascade(Boolean xref_cascade)
	{
		this.xref_cascade = xref_cascade;
	}

	/**
	 * Returns a string representation of the FieldModel.
	 * 
	 * @return The string-representation.
	 */
	public String toString()
	{
		String str = "FieldModel(";

		// entity
		str += "entity=" + entity.getName();

		// name/label
		str += ", name=" + name;

		// type
		str += ", type=" + type;
		if (getType() instanceof StringField || getType() instanceof CharField)
		{
			str += "[" + this.length + "]";
		}
		else if (getType() instanceof XrefField || getType() instanceof MrefField)
		{
			str += "[" + this.getXrefEntity().getName() + "." + this.getXrefFieldName() + "]";
		}
		if (getType() instanceof MrefField)
		{
			str += ", mref_name=" + this.mref_name + ", mref_localid=" + this.mref_localid + ", mref_remoteid=" + this.mref_remoteid;
		}
		if (getType() instanceof XrefField || getType() instanceof MrefField)
		{
			str += ", xref_label=TODO!!";
		}

		// settings
		str += ", auto=" + auto;
		str += ", nillable=" + nillable;
		str += ", readonly=" + readonly;
		str += ", unique=" + unique;

		// default
		str += ", default=" + this.defaultValue;

		if (this.enum_options != null)
		{
			str += ", enum_options=" + this.enum_options;
		}

		// closure
		str += ")";

		return str;
	}

	public Map<String, List<FieldModel>> allPossibleXrefLabels() throws MolgenisModelException
	{
		if (!(this.getType() instanceof XrefField) && !(this.getType() instanceof MrefField))
		{
			throw new MolgenisModelException("asking xref labels for non-xref field");
		}

		Map<String, List<FieldModel>> result = new LinkedHashMap<String, List<FieldModel>>();
		for (UniqueModel key : getXrefEntity().getAllUniques()) // get all
																// except
		// primary key
		// if (!key.equals(getXrefEntity().getAllKeys().firstElement()))
		// {
		{
			for (FieldModel f : key.getFields())
			{
				if (f.getType() instanceof XrefField || f.getType() instanceof MrefField)
				{
					f = getXrefEntity().getAllField(f.getName());

					Map<String, List<FieldModel>> subpaths = f.allPossibleXrefLabels();
					for (Entry<String, List<FieldModel>> pair : subpaths.entrySet())
					{
						List<FieldModel> path = pair.getValue();
						path.add(0, f);
						String label = f.getName() + "_" + pair.getKey();
						result.put(label, path);

						// if
						// (!f.getEntity().getName().equals(getXrefEntity().getName()))
						// {
						//
						// System.out.println("PATH FOR " +
						// this.getEntity().getName() + "." + this.getName()
						// + "=" + this.getName() + "_" + label + " " + "field="
						// + f.getEntity().getName()
						// + " " + getXrefEntity().getName());
						// System.out.print(this.getEntity().getName() + "." +
						// this.getName());
						// for (FieldModel pathField : path)
						// {
						// System.out
						// .print("->" + pathField.getEntity().getName() + "." +
						// pathField.getName());
						// }
						// System.out.println();
						// }
						//
						// else
						// {
						result.put(label, path);
						// }

					}
				}
				else
				{
					List<FieldModel> path = new ArrayList<FieldModel>();
					path.add(f);
					result.put(f.getName(), path);
				}
				// }
			}
		}

		return result;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		FieldModel other = (FieldModel) obj;
		if (entity == null)
		{
			if (other.entity != null) return false;
		}
		else if (!entity.equals(other.entity)) return false;
		if (name == null)
		{
			if (other.name != null) return false;
		}
		else if (!name.equals(other.name)) return false;
		return true;
	}
}