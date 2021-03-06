package org.molgenis.types;

import java.text.ParseException;

import org.molgenis.model.FieldModel;
import org.molgenis.model.MolgenisModelException;

/**
 * Many to many reference.
 * 
 * Example MOLGENIS DSL, 
 * <pre><field name="myfield" type="mref" xref_entity="OtherEntity" xref_field="id" xref_label="name"/>
 *</pre>
 * This example would in the UI show a seletion box with 'name' elements.
 */
public class MrefField extends FieldType
{
	@Override
	public String getJavaAssignment(String value)
	{
		return "NOT IMPLEMENTED";
	}
	
	@Override
	public String getJavaPropertyType() throws MolgenisModelException
	{
		//Entity e_ref = f.getXrefEntity();
		FieldModel f_ref = f.getXrefField();
		return "java.util.List<"+getFieldType(f_ref).getJavaPropertyType()+">";
	}
	
	@Override
	public String getJavaPropertyDefault() throws MolgenisModelException
	{
		//Entity e_ref = f.getXrefEntity();
		FieldModel f_ref = f.getXrefField();
		//if(f.getDefaultValue() == null || f.getDefaultValue() == "") "new java.util.ArrayList<"+getFieldType(f_ref).getJavaPropertyType(f_ref)+">()";
		//FIXME can there be defaults here?
		return "new java.util.ArrayList<"+getFieldType(f_ref).getJavaPropertyType()+">()";
	}
	
	@Override
	public String getJavaSetterType() throws MolgenisModelException
	{
		//Entity e_ref = f.getXrefEntity();
		FieldModel f_ref = f.getXrefField();
		return "new java.util.ArrayList<"+getFieldType(f_ref).getJavaSetterType()+">()";
	}
	
	@Override
	public String getMysqlType() throws MolgenisModelException
	{
		//FIXME this function should be never called???
		return getFieldType(f.getXrefField()).getMysqlType();
	}
	
	@Override
	public String getOracleType() throws MolgenisModelException
	{
		//FIXME this function should be never called???
		return getFieldType(f.getXrefField()).getOracleType();
	}

	@Override
	public String getHsqlType() throws MolgenisModelException
	{
		return getFieldType(f.getXrefField()).getHsqlType();
	}
	
	@Override
	public String getXsdType() throws MolgenisModelException
	{
		return getFieldType(f.getXrefField()).getXsdType();
	}

	@Override
	public String getFormatString()
	{
		return "";
	}
	
//	@Override
//	public HtmlInput<?> createInput(String name, Class<? extends Entity> xrefEntityClassName) throws HtmlInputException
//	{
//		return new MrefInput(name, xrefEntityClassName);
//	}

	@Override
	public String getCppPropertyType() throws MolgenisModelException
	{
		FieldModel f_ref = f.getXrefField();
		return "vector<"+getFieldType(f_ref).getCppPropertyType()+">";
	}
	
	@Override
	public String getCppJavaPropertyType() throws MolgenisModelException
	{
		return "Ljava/util/List;";
	}

	public Class<?> getJavaType()
	{
		return java.util.List.class;
	}

	@Override
	public Object getTypedValue(String value) throws ParseException
	{
		throw new UnsupportedOperationException("Conversion of MRef not supported.");
	}
	
	public String getName()
	{
		return "mref";
	}

}
