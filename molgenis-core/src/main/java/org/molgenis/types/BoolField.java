package org.molgenis.types;

import org.molgenis.model.MolgenisModelException;

public class BoolField extends FieldType
{
	@Override
	public String getJavaPropertyType()
	{
		return "Boolean";
	}
	
	@Override
	public String getJavaAssignment(String value)
	{
		if(value == null || value.equals("")) return "null";
		return ""+Boolean.parseBoolean(value.toString());
	}
	
	@Override
	public String getJavaPropertyDefault()
	{
		return getJavaAssignment(f.getDefaultValue());
	}

	@Override
	public String getMysqlType() throws MolgenisModelException
	{
		return "BOOL";
	}
	
	@Override
	public String getOracleType() throws MolgenisModelException
	{
		return "CHAR";
	}

	@Override
	public String getHsqlType()
	{
		return "INTEGER";
	}
	
	@Override
	public String getXsdType()
	{
		return "boolean";
	}

	@Override
	public String getFormatString()
	{
		return "%d";
	}

	@Override
	public String getCppPropertyType() throws MolgenisModelException
	{
		return "bool";
	}

	@Override
	public String getCppJavaPropertyType()
	{
		return "Ljava/lang/Boolean;";
	}

	public Class<?> getJavaType()
	{
		return Boolean.class;
	}
	
	public Boolean getTypedValue(String value) {
		return Boolean.parseBoolean(value);
	}

	public String getName()
	{
		return "bool";
	}
}
