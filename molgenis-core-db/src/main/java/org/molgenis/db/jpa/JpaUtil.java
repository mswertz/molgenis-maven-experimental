package org.molgenis.db.jpa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.molgenis.db.Database;

public class JpaUtil
{
	/** Logger */
	protected final static Logger logger = Logger.getLogger(JpaUtil.class);

	public static void createTables(final Database db, final Map<String, Object> configOverwrites)
	{
		JpaUtil.createTables((JpaDatabase) db, true, configOverwrites);
	}

	public static void createTables(final Database db, final boolean clearEm, final Map<String, Object> configOverwrites)
	{
		JpaUtil.createTables((JpaDatabase) db, clearEm, configOverwrites);
	}

	public static void createTables(final JpaDatabase db, final boolean clearEm, final Map<String, Object> configOverwrites)
	{
		if (clearEm)
		{
			db.getEntityManager().clear();
		}
		JpaFrameworkFactory.createFramework().createTables(
				db.getPersistenceUnitName(), configOverwrites);
	}

	public static void updateTables(final Database db, final Map<String, Object> configOverwrites)
	{
		JpaUtil.updateTables((JpaDatabase) db, true, configOverwrites);
	}

	public static void updateTables(final Database db, final boolean clearEm, final Map<String, Object> configOverwrites)
	{
		JpaUtil.updateTables((JpaDatabase) db, clearEm, configOverwrites);
	}

	public static void updateTables(final JpaDatabase db, final boolean clearEm, final Map<String, Object> configOverwrites)
	{
		if (clearEm)
		{
			db.getEntityManager().clear();
		}
		JpaFrameworkFactory.createFramework().updateTables(
				db.getPersistenceUnitName(), configOverwrites);
	}

	public static void dropAndCreateTables(final Database db, final Map<String, Object> configOverwrites)
	{
		JpaUtil.dropAndCreateTables((JpaDatabase) db, true, configOverwrites);
	}

	public static void dropAndCreateTables(final Database db, final boolean clear, final Map<String, Object> configOverwrites)
	{
		JpaUtil.dropAndCreateTables((JpaDatabase) db, clear, configOverwrites);
	}

	public static void dropAndCreateTables(final JpaDatabase db, final boolean clear, final Map<String, Object> configOverwrites)
	{
		if (clear)
		{
			db.getEntityManager().clear();
		}
		JpaFrameworkFactory.createFramework().dropTables(
				db.getPersistenceUnitName(), configOverwrites);
		JpaFrameworkFactory.createFramework().createTables(
				db.getPersistenceUnitName(), configOverwrites);
	}

	public static void dropTables(Database db, final Map<String, Object> configOverwrites)
	{
		JpaUtil.dropTables((JpaDatabase) db, true, configOverwrites);
	}

	public static void dropTables(Database db, boolean clear, final Map<String, Object> configOverwrites)
	{
		JpaUtil.dropTables((JpaDatabase) db, clear, configOverwrites);
	}

	public static void dropTables(final JpaDatabase db, final boolean clear, final Map<String, Object> configOverwrites)
	{
		if (clear)
		{
			db.getEntityManager().clear();
		}
		JpaFrameworkFactory.createFramework().dropTables(db.getPersistenceUnitName(), configOverwrites);

	}

	public static void executeSQLScript(final String path, final Database db)
	{
		executeSQLScript(new File(path), db);
	}

	public static void executeSQLScript(final File file, final Database db)
	{
		if (!(db instanceof JpaDatabase))
		{
			throw new IllegalArgumentException("!(db instanceof JpaDatabase)");
		}

		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(file));

			EntityManager em = ((JpaDatabase) db).getEntityManager();
			em.getTransaction().begin();
			while (br.ready())
			{
				String sql = br.readLine();
				if (StringUtils.isEmpty(sql))
				{
					continue;
				}
				int result = -1;
				try {
					 result = em.createNativeQuery(sql).executeUpdate();
				} catch (Exception ex) {
					logger.error(String.format("Error executing '%s'\n %s", sql,
							ex.getMessage()));
					throw ex;
				}
				logger.info(String.format("Got result %d from '%s'\n", result, sql));
			}
			em.getTransaction().commit();
			br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				br.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
