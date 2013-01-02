package org.molgenis.db.generators;

import org.apache.log4j.Logger;
import org.molgenis.generate.ForEachEntityGenerator;

public class JpaEntityListenerGen extends ForEachEntityGenerator
{
	public static final transient Logger logger = Logger.getLogger(JpaEntityListenerGen.class);

	public JpaEntityListenerGen()
	{
		super(true); // include abstract entities
	}

	@Override
	public String getDescription()
	{
		return "Generates Entity Listener Skeleton for JPA";
	}

	@Override
	public String getType()
	{
		return "EntityListener";
	}
}