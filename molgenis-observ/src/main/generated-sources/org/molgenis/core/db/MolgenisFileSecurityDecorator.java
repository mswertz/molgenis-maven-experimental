/* Date:        October 7, 2012
 * Template:	MapperSecurityDecoratorGen.java.ftl
 * generator:   org.molgenis.generators.db.MapperSecurityDecoratorGen 4.0.0-testing
 */

package org.molgenis.core.db;

import java.util.ArrayList;
import java.util.List;

import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.Mapper;
import org.molgenis.framework.db.QueryRule;
import org.molgenis.util.TupleReader;
import org.molgenis.util.TupleWriter;

import java.text.ParseException;

import org.molgenis.auth.MolgenisUser;
import org.molgenis.auth.service.MolgenisUserService;
import org.molgenis.framework.security.SimpleLogin;

import org.molgenis.framework.db.MapperDecorator;

public class MolgenisFileSecurityDecorator<E extends org.molgenis.core.MolgenisFile> extends MapperDecorator<E>
{
	public MolgenisFileSecurityDecorator(Mapper<E> generatedMapper)
	{
		super(generatedMapper);
	}

	@Override
	public int add(List<E> entities) throws DatabaseException
	{
		if (this.getDatabase().getLogin() != null && !(this.getDatabase().getLogin() instanceof SimpleLogin))
		{
			if (!this.getDatabase().getLogin().canWrite(org.molgenis.core.MolgenisFile.class))
				throw new DatabaseException("No write permission on org.molgenis.core.MolgenisFile");

			//TODO: Add column level security filters
		}
		return super.add(entities);
	}

	@Override
	public int update(List<E> entities) throws DatabaseException
	{
		if (this.getDatabase().getLogin() != null && !(this.getDatabase().getLogin() instanceof SimpleLogin))
		{
			if (!this.getDatabase().getLogin().canWrite(org.molgenis.core.MolgenisFile.class))
				throw new DatabaseException("No write permission on org.molgenis.core.MolgenisFile");

			//TODO: Add column level security filters
		}
		return super.update(entities);
	}

	@Override
	public int remove(List<E> entities) throws DatabaseException
	{
		if (this.getDatabase().getLogin() != null && !(this.getDatabase().getLogin() instanceof SimpleLogin))
		{
			if (!this.getDatabase().getLogin().canWrite(org.molgenis.core.MolgenisFile.class))
				throw new DatabaseException("No write permission on org.molgenis.core.MolgenisFile");
				
		}
		return super.remove(entities);
	}

	@Override
	public int add(TupleReader reader, TupleWriter writer) throws DatabaseException
	{
		if (this.getDatabase().getLogin() != null && !(this.getDatabase().getLogin() instanceof SimpleLogin))
		{
			if (!this.getDatabase().getLogin().canWrite(org.molgenis.core.MolgenisFile.class))
				throw new DatabaseException("No write permission on org.molgenis.core.MolgenisFile");

			//TODO: Add column level security filters
		}
		return super.add(reader, writer);
	}

	@Override
	public int count(QueryRule... rules) throws DatabaseException
	{
		if (this.getDatabase().getLogin() != null && !(this.getDatabase().getLogin() instanceof SimpleLogin))
		{
			if (!this.getDatabase().getLogin().canRead(org.molgenis.core.MolgenisFile.class))
				return 0;

		}
		return super.count(rules);
	}

	@Override
	public List<E> find(QueryRule ...rules) throws DatabaseException
	{
		if (this.getDatabase().getLogin() != null && !(this.getDatabase().getLogin() instanceof SimpleLogin))
		{
			if (!this.getDatabase().getLogin().canRead(org.molgenis.core.MolgenisFile.class))
				return new ArrayList<E>();

		}

		List<E> result = super.find(rules);

		//TODO: Add column level security filters

		return result;
	}

	@Override
	public void find(TupleWriter writer, QueryRule ...rules) throws DatabaseException
	{
		if (this.getDatabase().getLogin() != null && !(this.getDatabase().getLogin() instanceof SimpleLogin))
		{
			if (!this.getDatabase().getLogin().canRead(org.molgenis.core.MolgenisFile.class))
				return;

		}

		super.find(writer, rules);
		//TODO: Add column level security filters. How???
	}

	@Override
	public int remove(TupleReader reader) throws DatabaseException
	{
		if (this.getDatabase().getLogin() != null && !(this.getDatabase().getLogin() instanceof SimpleLogin))
		{
			if (!this.getDatabase().getLogin().canWrite(org.molgenis.core.MolgenisFile.class))
				throw new DatabaseException("No write permission on org.molgenis.core.MolgenisFile");

			//TODO: Add row level security filters
		}
		return super.remove(reader);
	}

	@Override
	public int update(TupleReader reader) throws DatabaseException
	{
		if (this.getDatabase().getLogin() != null && !(this.getDatabase().getLogin() instanceof SimpleLogin))
		{
			if (!this.getDatabase().getLogin().canWrite(org.molgenis.core.MolgenisFile.class))
				throw new DatabaseException("No write permission on org.molgenis.core.MolgenisFile");

			//TODO: Add row level security filters
			//TODO: Add column level security filters
		}
		return super.update(reader);
	}

	@Override
	public void find(TupleWriter writer, List<String> fieldsToExport, QueryRule ...rules) throws DatabaseException
	{
		if (this.getDatabase().getLogin() != null && !(this.getDatabase().getLogin() instanceof SimpleLogin))
		{
			if (!this.getDatabase().getLogin().canRead(org.molgenis.core.MolgenisFile.class))
				return;

		}

		super.find(writer, fieldsToExport, rules);
		//TODO: Add column level security filters. How???
	}

}