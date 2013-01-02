package org.molgenis.db.generators;

import org.molgenis.generate.ForEachEntityGenerator;

public class MultiqueryMapperGen extends ForEachEntityGenerator
{
	@Override
	public String getDescription()
	{
		return "Generates database mappers for each entity (concrete class per table). Uses prepared statements.";
	}

	@Override
	public String getType()
	{
		return "Mapper";
	}

}
