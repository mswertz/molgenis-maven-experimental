package org.molgenis.db.generators;

import org.molgenis.generate.ForEachEntityGenerator;
import org.molgenis.model.EntityModel;

public class DataTypeGen extends ForEachEntityGenerator
{
	public DataTypeGen()
	{
		// include abstract entities
		super(true);
	}

	@Override
	public String getDescription()
	{
		return "Generates classes for each entity (simple 'bean's or 'pojo's).";
	}

	public String getType()
	{
		return "";
	}

	public String getPackageName(EntityModel entity)
	{
		return entity.getNamespace().toLowerCase();
	}

}
