/* File:        app/JUnitTest.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
 * 
 * generator:   org.molgenis.generators.tests.TestDatabaseGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package test;

import app.DatabaseFactory;
import app.JDBCDatabase;

import app.servlet.MolgenisServlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;

import org.molgenis.Molgenis;
import org.molgenis.util.Entity;
import org.molgenis.util.SimpleTuple;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.Query;
import org.molgenis.framework.db.DatabaseException;

import static  org.testng.AssertJUnit.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.molgenis.auth.MolgenisRole;
import org.molgenis.auth.MolgenisGroup;
import org.molgenis.auth.MolgenisRoleGroupLink;
import org.molgenis.auth.Contact;
import org.molgenis.auth.Person;
import org.molgenis.auth.Institute;
import org.molgenis.auth.MolgenisUser;
import org.molgenis.auth.MolgenisPermission;
import org.molgenis.auth.Authorizable;
import org.molgenis.core.Identifiable;
import org.molgenis.core.Nameable;
import org.molgenis.core.Describable;
import org.molgenis.core.OntologyTerm;
import org.molgenis.core.Ontology;
import org.molgenis.core.MolgenisFile;
import org.molgenis.core.RuntimeProperty;
import org.molgenis.core.Publication;
import org.molgenis.core.UseCase;
import org.molgenis.core.MolgenisEntity;

public class TestDatabase
{
	private static int total = 10;
	private static Database db;
	public static final transient Logger logger = Logger.getLogger(TestDatabase.class);
	DateFormat dateFormat = new SimpleDateFormat(SimpleTuple.DATEFORMAT, Locale.US);
	DateFormat dateTimeFormat = new SimpleDateFormat(SimpleTuple.DATETIMEFORMAT, Locale.US);	 


	/*
	 * Create a database to use
	 */
	@BeforeTest
	public static void oneTimeSetUp()   
	{
		try
		{
		//bad: test expects an existing, but empty database.
		//this means the previous test will need to end with e.g.
		//new emptyDatabase(new MolgenisServlet().getDatabase(), false);	
			//db = new MolgenisServlet().getDatabase();
                        db = DatabaseFactory.createTest("/Users/mswertz/Documents/MavenWorkspace/molgenis-project/molgenis-auth/src/main/resources/auth_molgenis.properties"); //correct?	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		logger.info("Database created");
	}
		
	@Test
	public void testMolgenisRole() throws DatabaseException
	{
		//create entities
		List<MolgenisRole> entities = new ArrayList<MolgenisRole>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			MolgenisRole e = new MolgenisRole();
			e.setName(truncate("molgenisrole_name_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<MolgenisRole> q = db.query(MolgenisRole.class).eq("__Type",MolgenisRole.class.getSimpleName());
		assertEquals(total, q.count());
		List<MolgenisRole> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
		}	
		
		//test the query capabilities by finding on all fields
		for(MolgenisRole entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<MolgenisRole> q2 = db.query(MolgenisRole.class);
				q2.equals("id",entity.getId());
				List<MolgenisRole> results = q2.find();
				assertEquals(results.size(),1);
				for(MolgenisRole r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<MolgenisRole> q2 = db.query(MolgenisRole.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<MolgenisRole> results = q2.find();
				assertEquals(results.size(),1);
				for(MolgenisRole r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<MolgenisRole> q2 = db.query(MolgenisRole.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<MolgenisRole> results = q2.find();
				for(MolgenisRole r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<MolgenisRole> q2 = db.query(MolgenisRole.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<MolgenisRole> results = q2.find();
				for(MolgenisRole r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<MolgenisRole> q2 = db.query(MolgenisRole.class);
				q2.equals("name",entity.getName());
				List<MolgenisRole> results = q2.find();
				for(MolgenisRole r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<MolgenisRole> q2 = db.query(MolgenisRole.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<MolgenisRole> results = q2.find();
				for(MolgenisRole r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<MolgenisRole> q2 = db.query(MolgenisRole.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<MolgenisRole> results = q2.find();
				for(MolgenisRole r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

		}
	}

	@Test
	public void testMolgenisGroup() throws DatabaseException
	{
		//create entities
		List<MolgenisGroup> entities = new ArrayList<MolgenisGroup>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			MolgenisGroup e = new MolgenisGroup();
			e.setName(truncate("molgenisgroup_name_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<MolgenisGroup> q = db.query(MolgenisGroup.class).eq("__Type",MolgenisGroup.class.getSimpleName());
		assertEquals(total, q.count());
		List<MolgenisGroup> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
		}	
		
		//test the query capabilities by finding on all fields
		for(MolgenisGroup entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<MolgenisGroup> q2 = db.query(MolgenisGroup.class);
				q2.equals("id",entity.getId());
				List<MolgenisGroup> results = q2.find();
				for(MolgenisGroup r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<MolgenisGroup> q2 = db.query(MolgenisGroup.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<MolgenisGroup> results = q2.find();
				for(MolgenisGroup r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<MolgenisGroup> q2 = db.query(MolgenisGroup.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<MolgenisGroup> results = q2.find();
				for(MolgenisGroup r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<MolgenisGroup> q2 = db.query(MolgenisGroup.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<MolgenisGroup> results = q2.find();
				for(MolgenisGroup r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<MolgenisGroup> q2 = db.query(MolgenisGroup.class);
				q2.equals("name",entity.getName());
				List<MolgenisGroup> results = q2.find();
				for(MolgenisGroup r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<MolgenisGroup> q2 = db.query(MolgenisGroup.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<MolgenisGroup> results = q2.find();
				for(MolgenisGroup r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<MolgenisGroup> q2 = db.query(MolgenisGroup.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<MolgenisGroup> results = q2.find();
				for(MolgenisGroup r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

		}
	}

	@Test
	public void testInstitute() throws DatabaseException
	{
		//create entities
		List<Institute> entities = new ArrayList<Institute>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			Institute e = new Institute();
			e.setAddress("institute_address_"+i);
			e.setPhone(truncate("institute_phone_"+i, 255));
			e.setEmail(truncate("institute_email_"+i, 255));
			e.setFax(truncate("institute_fax_"+i, 255));
			e.setTollFreePhone(truncate("institute_tollfreephone_"+i, 255));
			e.setCity(truncate("institute_city_"+i, 255));
			e.setCountry(truncate("institute_country_"+i, 255));
			e.setName(truncate("institute_name_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Institute> q = db.query(Institute.class);
		assertEquals(total, q.count());
		List<Institute> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getAddress(), entitiesDb.get(i).getAddress());
			assertEquals(entities.get(i).getPhone(), entitiesDb.get(i).getPhone());
			assertEquals(entities.get(i).getEmail(), entitiesDb.get(i).getEmail());
			assertEquals(entities.get(i).getFax(), entitiesDb.get(i).getFax());
			assertEquals(entities.get(i).getTollFreePhone(), entitiesDb.get(i).getTollFreePhone());
			assertEquals(entities.get(i).getCity(), entitiesDb.get(i).getCity());
			assertEquals(entities.get(i).getCountry(), entitiesDb.get(i).getCountry());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
		}	
		
		//test the query capabilities by finding on all fields
		for(Institute entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("id",entity.getId());
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Address', type 'text'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("address",entity.getAddress());
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getAddress(),entity.getAddress());
				}
			}
			//test operator 'in' for field 'Address'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAddress());
				q2.in("address", inList);
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getAddress(),entity.getAddress());
				}
			}
			//test operator 'like' for field 'Address'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.like("address", entity.getAddress() + "%");
				q2.sortASC("address");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getAddress(), entity.getAddress()));
				}
			}

			//test field 'Phone', type 'string'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("phone",entity.getPhone());
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getPhone(),entity.getPhone());
				}
			}
			//test operator 'in' for field 'Phone'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPhone());
				q2.in("phone", inList);
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getPhone(),entity.getPhone());
				}
			}
			//test operator 'like' for field 'Phone'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.like("phone", entity.getPhone() + "%");
				q2.sortASC("phone");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getPhone(), entity.getPhone()));
				}
			}

			//test field 'Email', type 'string'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("email",entity.getEmail());
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getEmail(),entity.getEmail());
				}
			}
			//test operator 'in' for field 'Email'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getEmail());
				q2.in("email", inList);
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getEmail(),entity.getEmail());
				}
			}
			//test operator 'like' for field 'Email'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.like("email", entity.getEmail() + "%");
				q2.sortASC("email");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getEmail(), entity.getEmail()));
				}
			}

			//test field 'Fax', type 'string'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("fax",entity.getFax());
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getFax(),entity.getFax());
				}
			}
			//test operator 'in' for field 'Fax'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFax());
				q2.in("fax", inList);
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getFax(),entity.getFax());
				}
			}
			//test operator 'like' for field 'Fax'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.like("fax", entity.getFax() + "%");
				q2.sortASC("fax");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getFax(), entity.getFax()));
				}
			}

			//test field 'tollFreePhone', type 'string'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("tollFreePhone",entity.getTollFreePhone());
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getTollFreePhone(),entity.getTollFreePhone());
				}
			}
			//test operator 'in' for field 'tollFreePhone'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTollFreePhone());
				q2.in("tollFreePhone", inList);
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getTollFreePhone(),entity.getTollFreePhone());
				}
			}
			//test operator 'like' for field 'tollFreePhone'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.like("tollFreePhone", entity.getTollFreePhone() + "%");
				q2.sortASC("tollFreePhone");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTollFreePhone(), entity.getTollFreePhone()));
				}
			}

			//test field 'City', type 'string'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("city",entity.getCity());
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getCity(),entity.getCity());
				}
			}
			//test operator 'in' for field 'City'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCity());
				q2.in("city", inList);
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getCity(),entity.getCity());
				}
			}
			//test operator 'like' for field 'City'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.like("city", entity.getCity() + "%");
				q2.sortASC("city");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getCity(), entity.getCity()));
				}
			}

			//test field 'Country', type 'string'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("country",entity.getCountry());
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getCountry(),entity.getCountry());
				}
			}
			//test operator 'in' for field 'Country'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCountry());
				q2.in("country", inList);
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getCountry(),entity.getCountry());
				}
			}
			//test operator 'like' for field 'Country'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.like("country", entity.getCountry() + "%");
				q2.sortASC("country");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getCountry(), entity.getCountry()));
				}
			}

			//test field 'name', type 'string'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.equals("name",entity.getName());
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<Institute> q2 = db.query(Institute.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<Institute> q2 = db.query(Institute.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Institute> results = q2.find();
				for(Institute r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

		}
	}

	@Test
	public void testOntology() throws DatabaseException
	{
		//create entities
		List<Ontology> entities = new ArrayList<Ontology>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			Ontology e = new Ontology();
			e.setName(truncate("ontology_name_"+i, 127));
			e.setOntologyAccession(truncate("ontology_ontologyaccession_"+i, 255));
			e.setOntologyURI("ontology_ontologyuri_"+i);
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Ontology> q = db.query(Ontology.class);
		assertEquals(total, q.count());
		List<Ontology> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getOntologyAccession(), entitiesDb.get(i).getOntologyAccession());
			assertEquals(entities.get(i).getOntologyURI(), entitiesDb.get(i).getOntologyURI());
		}	
		
		//test the query capabilities by finding on all fields
		for(Ontology entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.equals("id",entity.getId());
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.equals("name",entity.getName());
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'ontologyAccession', type 'string'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.equals("ontologyAccession",entity.getOntologyAccession());
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertEquals(r.getOntologyAccession(),entity.getOntologyAccession());
				}
			}
			//test operator 'in' for field 'ontologyAccession'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntologyAccession());
				q2.in("ontologyAccession", inList);
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertEquals(r.getOntologyAccession(),entity.getOntologyAccession());
				}
			}
			//test operator 'like' for field 'ontologyAccession'
			{
				Query<Ontology> q2 = db.query(Ontology.class);
				q2.like("ontologyAccession", entity.getOntologyAccession() + "%");
				q2.sortASC("ontologyAccession");
				List<Ontology> results = q2.find();
				for(Ontology r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getOntologyAccession(), entity.getOntologyAccession()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testOntology"})
	public void testOntologyTerm() throws DatabaseException
	{
		//create entities
		List<OntologyTerm> entities = new ArrayList<OntologyTerm>();

		//retrieve xref entity candidates
		List<Ontology> ontologyXrefs = db.query(Ontology.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			OntologyTerm e = new OntologyTerm();
			e.setName(truncate("ontologyterm_name_"+i, 127));
			if(ontologyXrefs.size() > 0) e.setOntology_Id( ontologyXrefs.get(i).getId() );
			e.setTermAccession(truncate("ontologyterm_termaccession_"+i, 255));
			e.setDefinition(truncate("ontologyterm_definition_"+i, 255));
			e.setTermPath(truncate("ontologyterm_termpath_"+i, 1024));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<OntologyTerm> q = db.query(OntologyTerm.class);
		assertEquals(total, q.count());
		List<OntologyTerm> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getOntology_Id(), entitiesDb.get(i).getOntology_Id());
			assertEquals(entities.get(i).getTermAccession(), entitiesDb.get(i).getTermAccession());
			assertEquals(entities.get(i).getDefinition(), entitiesDb.get(i).getDefinition());
			assertEquals(entities.get(i).getTermPath(), entitiesDb.get(i).getTermPath());
		}	
		
		//test the query capabilities by finding on all fields
		for(OntologyTerm entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.equals("id",entity.getId());
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.equals("name",entity.getName());
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'ontology', type 'xref'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.equals("ontology",entity.getOntology_Id());
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'in' for field 'ontology'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntology_Id());
				q2.in("ontology", inList);
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ontology_name'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.equals("ontology_name",entity.getOntology_Name());
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'in' for implicit join field 'ontology_name'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntology_Name());
				q2.in("ontology_name", inList);
				q2.sortDESC("ontology_name");
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}

			//test field 'termAccession', type 'string'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.equals("termAccession",entity.getTermAccession());
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getTermAccession(),entity.getTermAccession());
				}
			}
			//test operator 'in' for field 'termAccession'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTermAccession());
				q2.in("termAccession", inList);
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getTermAccession(),entity.getTermAccession());
				}
			}
			//test operator 'like' for field 'termAccession'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.like("termAccession", entity.getTermAccession() + "%");
				q2.sortASC("termAccession");
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTermAccession(), entity.getTermAccession()));
				}
			}

			//test field 'definition', type 'string'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.equals("definition",entity.getDefinition());
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getDefinition(),entity.getDefinition());
				}
			}
			//test operator 'in' for field 'definition'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDefinition());
				q2.in("definition", inList);
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getDefinition(),entity.getDefinition());
				}
			}
			//test operator 'like' for field 'definition'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.like("definition", entity.getDefinition() + "%");
				q2.sortASC("definition");
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDefinition(), entity.getDefinition()));
				}
			}

			//test field 'termPath', type 'string'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.equals("termPath",entity.getTermPath());
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getTermPath(),entity.getTermPath());
				}
			}
			//test operator 'in' for field 'termPath'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTermPath());
				q2.in("termPath", inList);
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertEquals(r.getTermPath(),entity.getTermPath());
				}
			}
			//test operator 'like' for field 'termPath'
			{
				Query<OntologyTerm> q2 = db.query(OntologyTerm.class);
				q2.like("termPath", entity.getTermPath() + "%");
				q2.sortASC("termPath");
				List<OntologyTerm> results = q2.find();
				for(OntologyTerm r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTermPath(), entity.getTermPath()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testInstitute","testOntologyTerm"})
	public void testPerson() throws DatabaseException
	{
		//create entities
		List<Person> entities = new ArrayList<Person>();

		//retrieve xref entity candidates
		List<Institute> affiliationXrefs = db.query(Institute.class).find();	
		List<OntologyTerm> rolesXrefs = db.query(OntologyTerm.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			Person e = new Person();
			e.setName(truncate("person_name_"+i, 255));
			e.setAddress("person_address_"+i);
			e.setPhone(truncate("person_phone_"+i, 255));
			e.setEmail(truncate("person_email_"+i, 255));
			e.setFax(truncate("person_fax_"+i, 255));
			e.setTollFreePhone(truncate("person_tollfreephone_"+i, 255));
			e.setCity(truncate("person_city_"+i, 255));
			e.setCountry(truncate("person_country_"+i, 255));
			e.setFirstName(truncate("person_firstname_"+i, 255));
			e.setMidInitials(truncate("person_midinitials_"+i, 255));
			e.setLastName(truncate("person_lastname_"+i, 255));
			e.setTitle(truncate("person_title_"+i, 255));
			if(affiliationXrefs.size() > 0) e.setAffiliation_Id( affiliationXrefs.get(i).getId() );
			e.setDepartment(truncate("person_department_"+i, 255));
			if(rolesXrefs.size() > 0) e.setRoles_Id( rolesXrefs.get(i).getId() );
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Person> q = db.query(Person.class).eq("__Type",Person.class.getSimpleName());
		assertEquals(total, q.count());
		List<Person> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getAddress(), entitiesDb.get(i).getAddress());
			assertEquals(entities.get(i).getPhone(), entitiesDb.get(i).getPhone());
			assertEquals(entities.get(i).getEmail(), entitiesDb.get(i).getEmail());
			assertEquals(entities.get(i).getFax(), entitiesDb.get(i).getFax());
			assertEquals(entities.get(i).getTollFreePhone(), entitiesDb.get(i).getTollFreePhone());
			assertEquals(entities.get(i).getCity(), entitiesDb.get(i).getCity());
			assertEquals(entities.get(i).getCountry(), entitiesDb.get(i).getCountry());
			assertEquals(entities.get(i).getFirstName(), entitiesDb.get(i).getFirstName());
			assertEquals(entities.get(i).getMidInitials(), entitiesDb.get(i).getMidInitials());
			assertEquals(entities.get(i).getLastName(), entitiesDb.get(i).getLastName());
			assertEquals(entities.get(i).getTitle(), entitiesDb.get(i).getTitle());
			assertEquals(entities.get(i).getAffiliation_Id(), entitiesDb.get(i).getAffiliation_Id());
			assertEquals(entities.get(i).getDepartment(), entitiesDb.get(i).getDepartment());
			assertEquals(entities.get(i).getRoles_Id(), entitiesDb.get(i).getRoles_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(Person entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("id",entity.getId());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("name",entity.getName());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Address', type 'text'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("address",entity.getAddress());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getAddress(),entity.getAddress());
				}
			}
			//test operator 'in' for field 'Address'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAddress());
				q2.in("address", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getAddress(),entity.getAddress());
				}
			}
			//test operator 'like' for field 'Address'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("address", entity.getAddress() + "%");
				q2.sortASC("address");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getAddress(), entity.getAddress()));
				}
			}

			//test field 'Phone', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("phone",entity.getPhone());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getPhone(),entity.getPhone());
				}
			}
			//test operator 'in' for field 'Phone'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPhone());
				q2.in("phone", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getPhone(),entity.getPhone());
				}
			}
			//test operator 'like' for field 'Phone'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("phone", entity.getPhone() + "%");
				q2.sortASC("phone");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getPhone(), entity.getPhone()));
				}
			}

			//test field 'Email', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("email",entity.getEmail());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getEmail(),entity.getEmail());
				}
			}
			//test operator 'in' for field 'Email'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getEmail());
				q2.in("email", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getEmail(),entity.getEmail());
				}
			}
			//test operator 'like' for field 'Email'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("email", entity.getEmail() + "%");
				q2.sortASC("email");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getEmail(), entity.getEmail()));
				}
			}

			//test field 'Fax', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("fax",entity.getFax());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getFax(),entity.getFax());
				}
			}
			//test operator 'in' for field 'Fax'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFax());
				q2.in("fax", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getFax(),entity.getFax());
				}
			}
			//test operator 'like' for field 'Fax'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("fax", entity.getFax() + "%");
				q2.sortASC("fax");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getFax(), entity.getFax()));
				}
			}

			//test field 'tollFreePhone', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("tollFreePhone",entity.getTollFreePhone());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getTollFreePhone(),entity.getTollFreePhone());
				}
			}
			//test operator 'in' for field 'tollFreePhone'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTollFreePhone());
				q2.in("tollFreePhone", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getTollFreePhone(),entity.getTollFreePhone());
				}
			}
			//test operator 'like' for field 'tollFreePhone'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("tollFreePhone", entity.getTollFreePhone() + "%");
				q2.sortASC("tollFreePhone");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTollFreePhone(), entity.getTollFreePhone()));
				}
			}

			//test field 'City', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("city",entity.getCity());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getCity(),entity.getCity());
				}
			}
			//test operator 'in' for field 'City'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCity());
				q2.in("city", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getCity(),entity.getCity());
				}
			}
			//test operator 'like' for field 'City'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("city", entity.getCity() + "%");
				q2.sortASC("city");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getCity(), entity.getCity()));
				}
			}

			//test field 'Country', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("country",entity.getCountry());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getCountry(),entity.getCountry());
				}
			}
			//test operator 'in' for field 'Country'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCountry());
				q2.in("country", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getCountry(),entity.getCountry());
				}
			}
			//test operator 'like' for field 'Country'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("country", entity.getCountry() + "%");
				q2.sortASC("country");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getCountry(), entity.getCountry()));
				}
			}

			//test field 'FirstName', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("firstName",entity.getFirstName());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getFirstName(),entity.getFirstName());
				}
			}
			//test operator 'in' for field 'FirstName'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFirstName());
				q2.in("firstName", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getFirstName(),entity.getFirstName());
				}
			}
			//test operator 'like' for field 'FirstName'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("firstName", entity.getFirstName() + "%");
				q2.sortASC("firstName");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getFirstName(), entity.getFirstName()));
				}
			}

			//test field 'MidInitials', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("midInitials",entity.getMidInitials());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getMidInitials(),entity.getMidInitials());
				}
			}
			//test operator 'in' for field 'MidInitials'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getMidInitials());
				q2.in("midInitials", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getMidInitials(),entity.getMidInitials());
				}
			}
			//test operator 'like' for field 'MidInitials'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("midInitials", entity.getMidInitials() + "%");
				q2.sortASC("midInitials");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getMidInitials(), entity.getMidInitials()));
				}
			}

			//test field 'LastName', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("lastName",entity.getLastName());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getLastName(),entity.getLastName());
				}
			}
			//test operator 'in' for field 'LastName'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getLastName());
				q2.in("lastName", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getLastName(),entity.getLastName());
				}
			}
			//test operator 'like' for field 'LastName'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("lastName", entity.getLastName() + "%");
				q2.sortASC("lastName");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getLastName(), entity.getLastName()));
				}
			}

			//test field 'Title', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("title",entity.getTitle());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getTitle(),entity.getTitle());
				}
			}
			//test operator 'in' for field 'Title'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTitle());
				q2.in("title", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getTitle(),entity.getTitle());
				}
			}
			//test operator 'like' for field 'Title'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("title", entity.getTitle() + "%");
				q2.sortASC("title");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTitle(), entity.getTitle()));
				}
			}

			//test field 'Affiliation', type 'xref'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("affiliation",entity.getAffiliation_Id());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getAffiliation_Id(), entity.getAffiliation_Id());
				}
			}
			//test operator 'in' for field 'Affiliation'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAffiliation_Id());
				q2.in("affiliation", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getAffiliation_Id(), entity.getAffiliation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Affiliation_name'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("affiliation_name",entity.getAffiliation_Name());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getAffiliation_Id(), entity.getAffiliation_Id());
				}
			}
			//test operator 'in' for implicit join field 'Affiliation_name'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAffiliation_Name());
				q2.in("affiliation_name", inList);
				q2.sortDESC("affiliation_name");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getAffiliation_Id(), entity.getAffiliation_Id());
				}
			}

			//test field 'Department', type 'string'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("department",entity.getDepartment());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getDepartment(),entity.getDepartment());
				}
			}
			//test operator 'in' for field 'Department'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDepartment());
				q2.in("department", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getDepartment(),entity.getDepartment());
				}
			}
			//test operator 'like' for field 'Department'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.like("department", entity.getDepartment() + "%");
				q2.sortASC("department");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDepartment(), entity.getDepartment()));
				}
			}

			//test field 'Roles', type 'xref'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("roles",entity.getRoles_Id());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getRoles_Id(), entity.getRoles_Id());
				}
			}
			//test operator 'in' for field 'Roles'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getRoles_Id());
				q2.in("roles", inList);
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getRoles_Id(), entity.getRoles_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Roles_name'
			{
				Query<Person> q2 = db.query(Person.class);
				q2.equals("roles_name",entity.getRoles_Name());
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getRoles_Id(), entity.getRoles_Id());
				}
			}
			//test operator 'in' for implicit join field 'Roles_name'
			{
				Query<Person> q2 = db.query(Person.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getRoles_Name());
				q2.in("roles_name", inList);
				q2.sortDESC("roles_name");
				List<Person> results = q2.find();
				for(Person r: results)
				{
					assertEquals(r.getRoles_Id(), entity.getRoles_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testInstitute","testOntologyTerm"})
	public void testMolgenisUser() throws DatabaseException
	{
		//create entities
		List<MolgenisUser> entities = new ArrayList<MolgenisUser>();

		//retrieve xref entity candidates
		List<Institute> affiliationXrefs = db.query(Institute.class).find();	
		List<OntologyTerm> rolesXrefs = db.query(OntologyTerm.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			MolgenisUser e = new MolgenisUser();
			e.setName(truncate("molgenisuser_name_"+i, 255));
			e.setAddress("molgenisuser_address_"+i);
			e.setPhone(truncate("molgenisuser_phone_"+i, 255));
			e.setEmail(truncate("molgenisuser_email_"+i, 255));
			e.setFax(truncate("molgenisuser_fax_"+i, 255));
			e.setTollFreePhone(truncate("molgenisuser_tollfreephone_"+i, 255));
			e.setCity(truncate("molgenisuser_city_"+i, 255));
			e.setCountry(truncate("molgenisuser_country_"+i, 255));
			e.setFirstName(truncate("molgenisuser_firstname_"+i, 255));
			e.setMidInitials(truncate("molgenisuser_midinitials_"+i, 255));
			e.setLastName(truncate("molgenisuser_lastname_"+i, 255));
			e.setTitle(truncate("molgenisuser_title_"+i, 255));
			if(affiliationXrefs.size() > 0) e.setAffiliation_Id( affiliationXrefs.get(i).getId() );
			e.setDepartment(truncate("molgenisuser_department_"+i, 255));
			if(rolesXrefs.size() > 0) e.setRoles_Id( rolesXrefs.get(i).getId() );
			e.setPassword(truncate("molgenisuser_password__"+i, 255));
			e.setActivationCode(truncate("molgenisuser_activationcode_"+i, 255));
			e.setActive(randomBool(i));
			e.setSuperuser(randomBool(i));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<MolgenisUser> q = db.query(MolgenisUser.class).eq("__Type",MolgenisUser.class.getSimpleName());
		assertEquals(total, q.count());
		List<MolgenisUser> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getAddress(), entitiesDb.get(i).getAddress());
			assertEquals(entities.get(i).getPhone(), entitiesDb.get(i).getPhone());
			assertEquals(entities.get(i).getEmail(), entitiesDb.get(i).getEmail());
			assertEquals(entities.get(i).getFax(), entitiesDb.get(i).getFax());
			assertEquals(entities.get(i).getTollFreePhone(), entitiesDb.get(i).getTollFreePhone());
			assertEquals(entities.get(i).getCity(), entitiesDb.get(i).getCity());
			assertEquals(entities.get(i).getCountry(), entitiesDb.get(i).getCountry());
			assertEquals(entities.get(i).getFirstName(), entitiesDb.get(i).getFirstName());
			assertEquals(entities.get(i).getMidInitials(), entitiesDb.get(i).getMidInitials());
			assertEquals(entities.get(i).getLastName(), entitiesDb.get(i).getLastName());
			assertEquals(entities.get(i).getTitle(), entitiesDb.get(i).getTitle());
			assertEquals(entities.get(i).getAffiliation_Id(), entitiesDb.get(i).getAffiliation_Id());
			assertEquals(entities.get(i).getDepartment(), entitiesDb.get(i).getDepartment());
			assertEquals(entities.get(i).getRoles_Id(), entitiesDb.get(i).getRoles_Id());
			assertEquals(entities.get(i).getPassword(), entitiesDb.get(i).getPassword());
			assertEquals(entities.get(i).getActivationCode(), entitiesDb.get(i).getActivationCode());
			assertEquals(entities.get(i).getActive(), entitiesDb.get(i).getActive());
			assertEquals(entities.get(i).getSuperuser(), entitiesDb.get(i).getSuperuser());
		}	
		
		//test the query capabilities by finding on all fields
		for(MolgenisUser entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("id",entity.getId());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("name",entity.getName());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Address', type 'text'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("address",entity.getAddress());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getAddress(),entity.getAddress());
				}
			}
			//test operator 'in' for field 'Address'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAddress());
				q2.in("address", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getAddress(),entity.getAddress());
				}
			}
			//test operator 'like' for field 'Address'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("address", entity.getAddress() + "%");
				q2.sortASC("address");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getAddress(), entity.getAddress()));
				}
			}

			//test field 'Phone', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("phone",entity.getPhone());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getPhone(),entity.getPhone());
				}
			}
			//test operator 'in' for field 'Phone'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPhone());
				q2.in("phone", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getPhone(),entity.getPhone());
				}
			}
			//test operator 'like' for field 'Phone'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("phone", entity.getPhone() + "%");
				q2.sortASC("phone");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getPhone(), entity.getPhone()));
				}
			}

			//test field 'Email', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("email",entity.getEmail());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getEmail(),entity.getEmail());
				}
			}
			//test operator 'in' for field 'Email'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getEmail());
				q2.in("email", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getEmail(),entity.getEmail());
				}
			}
			//test operator 'like' for field 'Email'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("email", entity.getEmail() + "%");
				q2.sortASC("email");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getEmail(), entity.getEmail()));
				}
			}

			//test field 'Fax', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("fax",entity.getFax());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getFax(),entity.getFax());
				}
			}
			//test operator 'in' for field 'Fax'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFax());
				q2.in("fax", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getFax(),entity.getFax());
				}
			}
			//test operator 'like' for field 'Fax'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("fax", entity.getFax() + "%");
				q2.sortASC("fax");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getFax(), entity.getFax()));
				}
			}

			//test field 'tollFreePhone', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("tollFreePhone",entity.getTollFreePhone());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getTollFreePhone(),entity.getTollFreePhone());
				}
			}
			//test operator 'in' for field 'tollFreePhone'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTollFreePhone());
				q2.in("tollFreePhone", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getTollFreePhone(),entity.getTollFreePhone());
				}
			}
			//test operator 'like' for field 'tollFreePhone'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("tollFreePhone", entity.getTollFreePhone() + "%");
				q2.sortASC("tollFreePhone");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTollFreePhone(), entity.getTollFreePhone()));
				}
			}

			//test field 'City', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("city",entity.getCity());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getCity(),entity.getCity());
				}
			}
			//test operator 'in' for field 'City'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCity());
				q2.in("city", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getCity(),entity.getCity());
				}
			}
			//test operator 'like' for field 'City'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("city", entity.getCity() + "%");
				q2.sortASC("city");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getCity(), entity.getCity()));
				}
			}

			//test field 'Country', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("country",entity.getCountry());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getCountry(),entity.getCountry());
				}
			}
			//test operator 'in' for field 'Country'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCountry());
				q2.in("country", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getCountry(),entity.getCountry());
				}
			}
			//test operator 'like' for field 'Country'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("country", entity.getCountry() + "%");
				q2.sortASC("country");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getCountry(), entity.getCountry()));
				}
			}

			//test field 'FirstName', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("firstName",entity.getFirstName());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getFirstName(),entity.getFirstName());
				}
			}
			//test operator 'in' for field 'FirstName'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFirstName());
				q2.in("firstName", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getFirstName(),entity.getFirstName());
				}
			}
			//test operator 'like' for field 'FirstName'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("firstName", entity.getFirstName() + "%");
				q2.sortASC("firstName");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getFirstName(), entity.getFirstName()));
				}
			}

			//test field 'MidInitials', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("midInitials",entity.getMidInitials());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getMidInitials(),entity.getMidInitials());
				}
			}
			//test operator 'in' for field 'MidInitials'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getMidInitials());
				q2.in("midInitials", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getMidInitials(),entity.getMidInitials());
				}
			}
			//test operator 'like' for field 'MidInitials'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("midInitials", entity.getMidInitials() + "%");
				q2.sortASC("midInitials");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getMidInitials(), entity.getMidInitials()));
				}
			}

			//test field 'LastName', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("lastName",entity.getLastName());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getLastName(),entity.getLastName());
				}
			}
			//test operator 'in' for field 'LastName'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getLastName());
				q2.in("lastName", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getLastName(),entity.getLastName());
				}
			}
			//test operator 'like' for field 'LastName'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("lastName", entity.getLastName() + "%");
				q2.sortASC("lastName");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getLastName(), entity.getLastName()));
				}
			}

			//test field 'Title', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("title",entity.getTitle());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getTitle(),entity.getTitle());
				}
			}
			//test operator 'in' for field 'Title'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTitle());
				q2.in("title", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getTitle(),entity.getTitle());
				}
			}
			//test operator 'like' for field 'Title'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("title", entity.getTitle() + "%");
				q2.sortASC("title");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTitle(), entity.getTitle()));
				}
			}

			//test field 'Affiliation', type 'xref'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("affiliation",entity.getAffiliation_Id());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getAffiliation_Id(), entity.getAffiliation_Id());
				}
			}
			//test operator 'in' for field 'Affiliation'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAffiliation_Id());
				q2.in("affiliation", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getAffiliation_Id(), entity.getAffiliation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Affiliation_name'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("affiliation_name",entity.getAffiliation_Name());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getAffiliation_Id(), entity.getAffiliation_Id());
				}
			}
			//test operator 'in' for implicit join field 'Affiliation_name'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAffiliation_Name());
				q2.in("affiliation_name", inList);
				q2.sortDESC("affiliation_name");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getAffiliation_Id(), entity.getAffiliation_Id());
				}
			}

			//test field 'Department', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("department",entity.getDepartment());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getDepartment(),entity.getDepartment());
				}
			}
			//test operator 'in' for field 'Department'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDepartment());
				q2.in("department", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getDepartment(),entity.getDepartment());
				}
			}
			//test operator 'like' for field 'Department'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("department", entity.getDepartment() + "%");
				q2.sortASC("department");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDepartment(), entity.getDepartment()));
				}
			}

			//test field 'Roles', type 'xref'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("roles",entity.getRoles_Id());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getRoles_Id(), entity.getRoles_Id());
				}
			}
			//test operator 'in' for field 'Roles'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getRoles_Id());
				q2.in("roles", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getRoles_Id(), entity.getRoles_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Roles_name'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("roles_name",entity.getRoles_Name());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getRoles_Id(), entity.getRoles_Id());
				}
			}
			//test operator 'in' for implicit join field 'Roles_name'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getRoles_Name());
				q2.in("roles_name", inList);
				q2.sortDESC("roles_name");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getRoles_Id(), entity.getRoles_Id());
				}
			}

			//test field 'password_', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("password_",entity.getPassword());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getPassword(),entity.getPassword());
				}
			}
			//test operator 'in' for field 'password_'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPassword());
				q2.in("password_", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getPassword(),entity.getPassword());
				}
			}
			//test operator 'like' for field 'password_'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("password_", entity.getPassword() + "%");
				q2.sortASC("password_");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getPassword(), entity.getPassword()));
				}
			}

			//test field 'activationCode', type 'string'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.equals("activationCode",entity.getActivationCode());
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getActivationCode(),entity.getActivationCode());
				}
			}
			//test operator 'in' for field 'activationCode'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getActivationCode());
				q2.in("activationCode", inList);
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertEquals(r.getActivationCode(),entity.getActivationCode());
				}
			}
			//test operator 'like' for field 'activationCode'
			{
				Query<MolgenisUser> q2 = db.query(MolgenisUser.class);
				q2.like("activationCode", entity.getActivationCode() + "%");
				q2.sortASC("activationCode");
				List<MolgenisUser> results = q2.find();
				for(MolgenisUser r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getActivationCode(), entity.getActivationCode()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testMolgenisGroup","testMolgenisRole"})
	public void testMolgenisRoleGroupLink() throws DatabaseException
	{
		//create entities
		List<MolgenisRoleGroupLink> entities = new ArrayList<MolgenisRoleGroupLink>();

		//retrieve xref entity candidates
		List<MolgenisGroup> group_Xrefs = db.query(MolgenisGroup.class).eq("__Type",MolgenisGroup.class.getSimpleName()).find();	
		List<MolgenisRole> role_Xrefs = db.query(MolgenisRole.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			MolgenisRoleGroupLink e = new MolgenisRoleGroupLink();
			if(group_Xrefs.size() > 0) e.setGroup_Id( group_Xrefs.get(i).getId() );
			if(role_Xrefs.size() > 0) e.setRole_Id( role_Xrefs.get(i).getId() );
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<MolgenisRoleGroupLink> q = db.query(MolgenisRoleGroupLink.class);
		assertEquals(total, q.count());
		List<MolgenisRoleGroupLink> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getGroup_Id(), entitiesDb.get(i).getGroup_Id());
			assertEquals(entities.get(i).getRole_Id(), entitiesDb.get(i).getRole_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(MolgenisRoleGroupLink entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.equals("id",entity.getId());
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'group_', type 'xref'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.equals("group_",entity.getGroup_Id());
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getGroup_Id(), entity.getGroup_Id());
				}
			}
			//test operator 'in' for field 'group_'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGroup_Id());
				q2.in("group_", inList);
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getGroup_Id(), entity.getGroup_Id());
				}
			}
			//test operator 'equals' for implicit join field 'group__name'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.equals("group__name",entity.getGroup_Name());
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getGroup_Id(), entity.getGroup_Id());
				}
			}
			//test operator 'in' for implicit join field 'group__name'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getGroup_Name());
				q2.in("group__name", inList);
				q2.sortDESC("group__name");
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getGroup_Id(), entity.getGroup_Id());
				}
			}

			//test field 'role_', type 'xref'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.equals("role_",entity.getRole_Id());
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}
			//test operator 'in' for field 'role_'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getRole_Id());
				q2.in("role_", inList);
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}
			//test operator 'equals' for implicit join field 'role__name'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				q2.equals("role__name",entity.getRole_Name());
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}
			//test operator 'in' for implicit join field 'role__name'
			{
				Query<MolgenisRoleGroupLink> q2 = db.query(MolgenisRoleGroupLink.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getRole_Name());
				q2.in("role__name", inList);
				q2.sortDESC("role__name");
				List<MolgenisRoleGroupLink> results = q2.find();
				for(MolgenisRoleGroupLink r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}

		}
	}

	@Test
	public void testMolgenisFile() throws DatabaseException
	{
		//create entities
		List<MolgenisFile> entities = new ArrayList<MolgenisFile>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			MolgenisFile e = new MolgenisFile();
			e.setName(truncate("molgenisfile_name_"+i, 127));
			e.setExtension(truncate("molgenisfile_extension_"+i, 8));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<MolgenisFile> q = db.query(MolgenisFile.class);
		assertEquals(total, q.count());
		List<MolgenisFile> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getExtension(), entitiesDb.get(i).getExtension());
		}	
		
		//test the query capabilities by finding on all fields
		for(MolgenisFile entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.equals("id",entity.getId());
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.equals("name",entity.getName());
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Extension', type 'string'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.equals("extension",entity.getExtension());
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertEquals(r.getExtension(),entity.getExtension());
				}
			}
			//test operator 'in' for field 'Extension'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getExtension());
				q2.in("extension", inList);
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertEquals(r.getExtension(),entity.getExtension());
				}
			}
			//test operator 'like' for field 'Extension'
			{
				Query<MolgenisFile> q2 = db.query(MolgenisFile.class);
				q2.like("extension", entity.getExtension() + "%");
				q2.sortASC("extension");
				List<MolgenisFile> results = q2.find();
				for(MolgenisFile r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getExtension(), entity.getExtension()));
				}
			}

		}
	}

	@Test
	public void testRuntimeProperty() throws DatabaseException
	{
		//create entities
		List<RuntimeProperty> entities = new ArrayList<RuntimeProperty>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			RuntimeProperty e = new RuntimeProperty();
			e.setName(truncate("runtimeproperty_name_"+i, 127));
			e.setValue(truncate("runtimeproperty_value_"+i, 127));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<RuntimeProperty> q = db.query(RuntimeProperty.class);
		assertEquals(total, q.count());
		List<RuntimeProperty> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getValue(), entitiesDb.get(i).getValue());
		}	
		
		//test the query capabilities by finding on all fields
		for(RuntimeProperty entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.equals("id",entity.getId());
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.equals("name",entity.getName());
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Value', type 'string'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.equals("value",entity.getValue());
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertEquals(r.getValue(),entity.getValue());
				}
			}
			//test operator 'in' for field 'Value'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getValue());
				q2.in("value", inList);
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertEquals(r.getValue(),entity.getValue());
				}
			}
			//test operator 'like' for field 'Value'
			{
				Query<RuntimeProperty> q2 = db.query(RuntimeProperty.class);
				q2.like("value", entity.getValue() + "%");
				q2.sortASC("value");
				List<RuntimeProperty> results = q2.find();
				for(RuntimeProperty r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getValue(), entity.getValue()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testOntologyTerm","testOntologyTerm","testOntologyTerm"})
	public void testPublication() throws DatabaseException
	{
		//create entities
		List<Publication> entities = new ArrayList<Publication>();

		//retrieve xref entity candidates
		List<OntologyTerm> pubmedIDXrefs = db.query(OntologyTerm.class).find();	
		List<OntologyTerm> dOIXrefs = db.query(OntologyTerm.class).find();	
		List<OntologyTerm> statusXrefs = db.query(OntologyTerm.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			Publication e = new Publication();
			e.setName(truncate("publication_name_"+i, 127));
			if(pubmedIDXrefs.size() > 0) e.setPubmedID_Id( pubmedIDXrefs.get(i).getId() );
			if(dOIXrefs.size() > 0) e.setDOI_Id( dOIXrefs.get(i).getId() );
			e.setAuthorList("publication_authorlist_"+i);
			e.setTitle(truncate("publication_title_"+i, 255));
			if(statusXrefs.size() > 0) e.setStatus_Id( statusXrefs.get(i).getId() );
			e.setYear(truncate("publication_year_"+i, 255));
			e.setJournal(truncate("publication_journal_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Publication> q = db.query(Publication.class);
		assertEquals(total, q.count());
		List<Publication> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getPubmedID_Id(), entitiesDb.get(i).getPubmedID_Id());
			assertEquals(entities.get(i).getDOI_Id(), entitiesDb.get(i).getDOI_Id());
			assertEquals(entities.get(i).getAuthorList(), entitiesDb.get(i).getAuthorList());
			assertEquals(entities.get(i).getTitle(), entitiesDb.get(i).getTitle());
			assertEquals(entities.get(i).getStatus_Id(), entitiesDb.get(i).getStatus_Id());
			assertEquals(entities.get(i).getYear(), entitiesDb.get(i).getYear());
			assertEquals(entities.get(i).getJournal(), entitiesDb.get(i).getJournal());
		}	
		
		//test the query capabilities by finding on all fields
		for(Publication entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.equals("id",entity.getId());
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Publication> q2 = db.query(Publication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.equals("name",entity.getName());
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<Publication> q2 = db.query(Publication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'PubmedID', type 'xref'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.equals("pubmedID",entity.getPubmedID_Id());
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getPubmedID_Id(), entity.getPubmedID_Id());
				}
			}
			//test operator 'in' for field 'PubmedID'
			{
				Query<Publication> q2 = db.query(Publication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPubmedID_Id());
				q2.in("pubmedID", inList);
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getPubmedID_Id(), entity.getPubmedID_Id());
				}
			}
			//test operator 'equals' for implicit join field 'PubmedID_name'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.equals("pubmedID_name",entity.getPubmedID_Name());
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getPubmedID_Id(), entity.getPubmedID_Id());
				}
			}
			//test operator 'in' for implicit join field 'PubmedID_name'
			{
				Query<Publication> q2 = db.query(Publication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPubmedID_Name());
				q2.in("pubmedID_name", inList);
				q2.sortDESC("pubmedID_name");
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getPubmedID_Id(), entity.getPubmedID_Id());
				}
			}

			//test field 'DOI', type 'xref'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.equals("dOI",entity.getDOI_Id());
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getDOI_Id(), entity.getDOI_Id());
				}
			}
			//test operator 'in' for field 'DOI'
			{
				Query<Publication> q2 = db.query(Publication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDOI_Id());
				q2.in("dOI", inList);
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getDOI_Id(), entity.getDOI_Id());
				}
			}
			//test operator 'equals' for implicit join field 'DOI_name'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.equals("dOI_name",entity.getDOI_Name());
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getDOI_Id(), entity.getDOI_Id());
				}
			}
			//test operator 'in' for implicit join field 'DOI_name'
			{
				Query<Publication> q2 = db.query(Publication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDOI_Name());
				q2.in("dOI_name", inList);
				q2.sortDESC("dOI_name");
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getDOI_Id(), entity.getDOI_Id());
				}
			}

			//test field 'authorList', type 'text'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.equals("authorList",entity.getAuthorList());
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getAuthorList(),entity.getAuthorList());
				}
			}
			//test operator 'in' for field 'authorList'
			{
				Query<Publication> q2 = db.query(Publication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getAuthorList());
				q2.in("authorList", inList);
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getAuthorList(),entity.getAuthorList());
				}
			}
			//test operator 'like' for field 'authorList'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.like("authorList", entity.getAuthorList() + "%");
				q2.sortASC("authorList");
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getAuthorList(), entity.getAuthorList()));
				}
			}

			//test field 'Title', type 'string'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.equals("title",entity.getTitle());
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getTitle(),entity.getTitle());
				}
			}
			//test operator 'in' for field 'Title'
			{
				Query<Publication> q2 = db.query(Publication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTitle());
				q2.in("title", inList);
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getTitle(),entity.getTitle());
				}
			}
			//test operator 'like' for field 'Title'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.like("title", entity.getTitle() + "%");
				q2.sortASC("title");
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTitle(), entity.getTitle()));
				}
			}

			//test field 'Status', type 'xref'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.equals("status",entity.getStatus_Id());
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getStatus_Id(), entity.getStatus_Id());
				}
			}
			//test operator 'in' for field 'Status'
			{
				Query<Publication> q2 = db.query(Publication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStatus_Id());
				q2.in("status", inList);
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getStatus_Id(), entity.getStatus_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Status_name'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.equals("status_name",entity.getStatus_Name());
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getStatus_Id(), entity.getStatus_Id());
				}
			}
			//test operator 'in' for implicit join field 'Status_name'
			{
				Query<Publication> q2 = db.query(Publication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getStatus_Name());
				q2.in("status_name", inList);
				q2.sortDESC("status_name");
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getStatus_Id(), entity.getStatus_Id());
				}
			}

			//test field 'Year', type 'string'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.equals("year",entity.getYear());
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getYear(),entity.getYear());
				}
			}
			//test operator 'in' for field 'Year'
			{
				Query<Publication> q2 = db.query(Publication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getYear());
				q2.in("year", inList);
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getYear(),entity.getYear());
				}
			}
			//test operator 'like' for field 'Year'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.like("year", entity.getYear() + "%");
				q2.sortASC("year");
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getYear(), entity.getYear()));
				}
			}

			//test field 'Journal', type 'string'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.equals("journal",entity.getJournal());
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getJournal(),entity.getJournal());
				}
			}
			//test operator 'in' for field 'Journal'
			{
				Query<Publication> q2 = db.query(Publication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getJournal());
				q2.in("journal", inList);
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertEquals(r.getJournal(),entity.getJournal());
				}
			}
			//test operator 'like' for field 'Journal'
			{
				Query<Publication> q2 = db.query(Publication.class);
				q2.like("journal", entity.getJournal() + "%");
				q2.sortASC("journal");
				List<Publication> results = q2.find();
				for(Publication r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getJournal(), entity.getJournal()));
				}
			}

		}
	}

	@Test
	public void testUseCase() throws DatabaseException
	{
		//create entities
		List<UseCase> entities = new ArrayList<UseCase>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			UseCase e = new UseCase();
			e.setUseCaseName(truncate("usecase_usecasename_"+i, 255));
			e.setSearchType(truncate("usecase_searchtype_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<UseCase> q = db.query(UseCase.class);
		assertEquals(total, q.count());
		List<UseCase> entitiesDb = q.sortASC("UseCaseId").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getUseCaseId());
			assertEquals(entities.get(i).getUseCaseName(), entitiesDb.get(i).getUseCaseName());
			assertEquals(entities.get(i).getSearchType(), entitiesDb.get(i).getSearchType());
		}	
		
		//test the query capabilities by finding on all fields
		for(UseCase entity: entitiesDb)
		{
			//test field 'UseCaseId', type 'int'
			{
				Query<UseCase> q2 = db.query(UseCase.class);
				q2.equals("useCaseId",entity.getUseCaseId());
				List<UseCase> results = q2.find();
				assertEquals(results.size(),1);
				for(UseCase r: results)
				{
					assertEquals(r.getUseCaseId(),entity.getUseCaseId());
				}
			}
			//test operator 'in' for field 'UseCaseId'
			{
				Query<UseCase> q2 = db.query(UseCase.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUseCaseId());
				q2.in("useCaseId", inList);
				List<UseCase> results = q2.find();
				assertEquals(results.size(),1);
				for(UseCase r: results)
				{
					assertEquals(r.getUseCaseId(),entity.getUseCaseId());
				}
			}
			//test operator 'lessOrEqual' for field 'UseCaseId'
			{
				Query<UseCase> q2 = db.query(UseCase.class);
				q2.lessOrEqual("useCaseId", entity.getUseCaseId());
				q2.sortASC("useCaseId");
				List<UseCase> results = q2.find();
				for(UseCase r: results)
				{
					assertTrue(r.getUseCaseId().compareTo(entity.getUseCaseId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'UseCaseId'
			{
				Query<UseCase> q2 = db.query(UseCase.class);
				q2.greaterOrEqual("useCaseId", entity.getUseCaseId());
				q2.sortDESC("useCaseId");
				List<UseCase> results = q2.find();
				for(UseCase r: results)
				{
					assertTrue(r.getUseCaseId().compareTo(entity.getUseCaseId()) > -1);
				}
			}

			//test field 'UseCaseName', type 'string'
			{
				Query<UseCase> q2 = db.query(UseCase.class);
				q2.equals("useCaseName",entity.getUseCaseName());
				List<UseCase> results = q2.find();
				for(UseCase r: results)
				{
					assertEquals(r.getUseCaseName(),entity.getUseCaseName());
				}
			}
			//test operator 'in' for field 'UseCaseName'
			{
				Query<UseCase> q2 = db.query(UseCase.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUseCaseName());
				q2.in("useCaseName", inList);
				List<UseCase> results = q2.find();
				for(UseCase r: results)
				{
					assertEquals(r.getUseCaseName(),entity.getUseCaseName());
				}
			}
			//test operator 'like' for field 'UseCaseName'
			{
				Query<UseCase> q2 = db.query(UseCase.class);
				q2.like("useCaseName", entity.getUseCaseName() + "%");
				q2.sortASC("useCaseName");
				List<UseCase> results = q2.find();
				for(UseCase r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getUseCaseName(), entity.getUseCaseName()));
				}
			}

			//test field 'SearchType', type 'string'
			{
				Query<UseCase> q2 = db.query(UseCase.class);
				q2.equals("searchType",entity.getSearchType());
				List<UseCase> results = q2.find();
				for(UseCase r: results)
				{
					assertEquals(r.getSearchType(),entity.getSearchType());
				}
			}
			//test operator 'in' for field 'SearchType'
			{
				Query<UseCase> q2 = db.query(UseCase.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSearchType());
				q2.in("searchType", inList);
				List<UseCase> results = q2.find();
				for(UseCase r: results)
				{
					assertEquals(r.getSearchType(),entity.getSearchType());
				}
			}
			//test operator 'like' for field 'SearchType'
			{
				Query<UseCase> q2 = db.query(UseCase.class);
				q2.like("searchType", entity.getSearchType() + "%");
				q2.sortASC("searchType");
				List<UseCase> results = q2.find();
				for(UseCase r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getSearchType(), entity.getSearchType()));
				}
			}

		}
	}

	@Test
	public void testMolgenisEntity() throws DatabaseException
	{
		//create entities
		List<MolgenisEntity> entities = new ArrayList<MolgenisEntity>();

		//retrieve xref entity candidates

		for(Integer i = 0; i < total; i++)
		{
			MolgenisEntity e = new MolgenisEntity();
			e.setName(truncate("molgenisentity_name_"+i, 255));
			e.setType(truncate("molgenisentity_type__"+i, 255));
			e.setClassName(truncate("molgenisentity_classname_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<MolgenisEntity> q = db.query(MolgenisEntity.class);
		assertEquals(total, q.count());
		List<MolgenisEntity> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getType(), entitiesDb.get(i).getType());
			assertEquals(entities.get(i).getClassName(), entitiesDb.get(i).getClassName());
		}	
		
		//test the query capabilities by finding on all fields
		for(MolgenisEntity entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.equals("id",entity.getId());
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<MolgenisEntity> results = q2.find();
				assertEquals(results.size(),1);
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.equals("name",entity.getName());
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'type_', type 'string'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.equals("type_",entity.getType());
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getType(),entity.getType());
				}
			}
			//test operator 'in' for field 'type_'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getType());
				q2.in("type_", inList);
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getType(),entity.getType());
				}
			}
			//test operator 'like' for field 'type_'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.like("type_", entity.getType() + "%");
				q2.sortASC("type_");
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getType(), entity.getType()));
				}
			}

			//test field 'className', type 'string'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.equals("className",entity.getClassName());
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getClassName(),entity.getClassName());
				}
			}
			//test operator 'in' for field 'className'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getClassName());
				q2.in("className", inList);
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertEquals(r.getClassName(),entity.getClassName());
				}
			}
			//test operator 'like' for field 'className'
			{
				Query<MolgenisEntity> q2 = db.query(MolgenisEntity.class);
				q2.like("className", entity.getClassName() + "%");
				q2.sortASC("className");
				List<MolgenisEntity> results = q2.find();
				for(MolgenisEntity r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getClassName(), entity.getClassName()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testMolgenisRole","testMolgenisEntity"})
	public void testMolgenisPermission() throws DatabaseException
	{
		//create entities
		List<MolgenisPermission> entities = new ArrayList<MolgenisPermission>();

		//retrieve xref entity candidates
		List<MolgenisRole> role_Xrefs = db.query(MolgenisRole.class).find();	
		List<MolgenisEntity> entityXrefs = db.query(MolgenisEntity.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			MolgenisPermission e = new MolgenisPermission();
			if(role_Xrefs.size() > 0) e.setRole_Id( role_Xrefs.get(i).getId() );
			if(entityXrefs.size() > 0) e.setEntity_Id( entityXrefs.get(i).getId() );
			e.setPermission(randomEnum(new String[]{"read","write","own"}));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<MolgenisPermission> q = db.query(MolgenisPermission.class);
		assertEquals(total, q.count());
		List<MolgenisPermission> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getRole_Id(), entitiesDb.get(i).getRole_Id());
			assertEquals(entities.get(i).getEntity_Id(), entitiesDb.get(i).getEntity_Id());
			assertEquals(entities.get(i).getPermission(), entitiesDb.get(i).getPermission());
		}	
		
		//test the query capabilities by finding on all fields
		for(MolgenisPermission entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				q2.equals("id",entity.getId());
				List<MolgenisPermission> results = q2.find();
				assertEquals(results.size(),1);
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'role_', type 'xref'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				q2.equals("role_",entity.getRole_Id());
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}
			//test operator 'in' for field 'role_'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getRole_Id());
				q2.in("role_", inList);
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}
			//test operator 'equals' for implicit join field 'role__name'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				q2.equals("role__name",entity.getRole_Name());
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}
			//test operator 'in' for implicit join field 'role__name'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getRole_Name());
				q2.in("role__name", inList);
				q2.sortDESC("role__name");
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getRole_Id(), entity.getRole_Id());
				}
			}

			//test field 'entity', type 'xref'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				q2.equals("entity",entity.getEntity_Id());
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getEntity_Id(), entity.getEntity_Id());
				}
			}
			//test operator 'in' for field 'entity'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getEntity_Id());
				q2.in("entity", inList);
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getEntity_Id(), entity.getEntity_Id());
				}
			}
			//test operator 'equals' for implicit join field 'entity_className'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				q2.equals("entity_className",entity.getEntity_ClassName());
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getEntity_Id(), entity.getEntity_Id());
				}
			}
			//test operator 'in' for implicit join field 'entity_className'
			{
				Query<MolgenisPermission> q2 = db.query(MolgenisPermission.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getEntity_ClassName());
				q2.in("entity_className", inList);
				q2.sortDESC("entity_className");
				List<MolgenisPermission> results = q2.find();
				for(MolgenisPermission r: results)
				{
					assertEquals(r.getEntity_Id(), entity.getEntity_Id());
				}
			}

		}
	}

	
	/** Helper to get random element from a list */
	public <E extends Entity> E random(List<E> entities)
	{
		return entities.get( Long.valueOf( Math.round( Math.random() * (entities.size() - 1) )).intValue() );
	}
	
	public Boolean randomBool(int i)
	{
		return i % 2 == 0 ? true : false;
	}
	
	public String randomEnum(String[] options)
	{
		Integer index = Long.valueOf(Math.round(Math.random() * (options.length - 1) )).intValue();
		return options[index];
	}
	
	public String truncate(String value, int length)
	{
	   if (value != null && value.length() > length)
          value = value.substring(0, length-1);
       return value;
	}
	
	 
	 
}