/* File:        app/JUnitTest.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
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

import org.molgenis.pheno.Species;
import org.molgenis.pheno.AlternateId;
import org.molgenis.pheno.ObservationElement;
import org.molgenis.pheno.ObservationTarget;
import org.molgenis.pheno.ObservableFeature;
import org.molgenis.pheno.Measurement;
import org.molgenis.pheno.Category;
import org.molgenis.pheno.Individual;
import org.molgenis.pheno.Location;
import org.molgenis.pheno.Panel;
import org.molgenis.pheno.Observation;
import org.molgenis.pheno.ObservedValue;
import org.molgenis.organization.Investigation;
import org.molgenis.organization.InvestigationElement;
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
import org.molgenis.protocol.Protocol;
import org.molgenis.protocol.ProtocolApplication;
import org.molgenis.protocol.ProtocolDocument;
import org.molgenis.protocol.Workflow;
import org.molgenis.protocol.WorkflowElement;
import org.molgenis.protocol.WorkflowElementParameter;
import org.molgenis.auth.MolgenisRole;
import org.molgenis.auth.MolgenisGroup;
import org.molgenis.auth.MolgenisRoleGroupLink;
import org.molgenis.auth.Contact;
import org.molgenis.auth.Person;
import org.molgenis.auth.Institute;
import org.molgenis.auth.MolgenisUser;
import org.molgenis.auth.MolgenisPermission;
import org.molgenis.auth.Authorizable;
import org.molgenis.pheno.ObservationElement_Ontolo12449;
import org.molgenis.pheno.ObservationElement_AlternateId;
import org.molgenis.pheno.Measurement_Categories;
import org.molgenis.pheno.Panel_Individuals;
import org.molgenis.pheno.Panel_FounderPanels;
import org.molgenis.organization.Investigation_Contacts;
import org.molgenis.protocol.Protocol_OntologyReference;
import org.molgenis.protocol.Protocol_Features;
import org.molgenis.protocol.Protocol_Subprotocols;
import org.molgenis.protocol.ProtocolApplication_Ontol11768;
import org.molgenis.protocol.ProtocolApplication_Performer;
import org.molgenis.protocol.WorkflowElement_PreviousSteps;

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
                        db = DatabaseFactory.createTest("src/main/resources/observ_molgenis.properties"); //correct?	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		logger.info("Database created");
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
	public void testSpecies() throws DatabaseException
	{
		//create entities
		List<Species> entities = new ArrayList<Species>();

		//retrieve xref entity candidates
		List<Ontology> ontologyXrefs = db.query(Ontology.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			Species e = new Species();
			e.setName(truncate("species_name_"+i, 127));
			if(ontologyXrefs.size() > 0) e.setOntology_Id( ontologyXrefs.get(i).getId() );
			e.setTermAccession(truncate("species_termaccession_"+i, 255));
			e.setDefinition(truncate("species_definition_"+i, 255));
			e.setTermPath(truncate("species_termpath_"+i, 1024));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Species> q = db.query(Species.class).eq("__Type",Species.class.getSimpleName());
		assertEquals(total, q.count());
		List<Species> entitiesDb = q.sortASC("id").find();
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
		for(Species entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.equals("id",entity.getId());
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Species> q2 = db.query(Species.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.equals("name",entity.getName());
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<Species> q2 = db.query(Species.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'ontology', type 'xref'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.equals("ontology",entity.getOntology_Id());
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'in' for field 'ontology'
			{
				Query<Species> q2 = db.query(Species.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntology_Id());
				q2.in("ontology", inList);
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ontology_name'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.equals("ontology_name",entity.getOntology_Name());
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'in' for implicit join field 'ontology_name'
			{
				Query<Species> q2 = db.query(Species.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntology_Name());
				q2.in("ontology_name", inList);
				q2.sortDESC("ontology_name");
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}

			//test field 'termAccession', type 'string'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.equals("termAccession",entity.getTermAccession());
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getTermAccession(),entity.getTermAccession());
				}
			}
			//test operator 'in' for field 'termAccession'
			{
				Query<Species> q2 = db.query(Species.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTermAccession());
				q2.in("termAccession", inList);
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getTermAccession(),entity.getTermAccession());
				}
			}
			//test operator 'like' for field 'termAccession'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.like("termAccession", entity.getTermAccession() + "%");
				q2.sortASC("termAccession");
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTermAccession(), entity.getTermAccession()));
				}
			}

			//test field 'definition', type 'string'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.equals("definition",entity.getDefinition());
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getDefinition(),entity.getDefinition());
				}
			}
			//test operator 'in' for field 'definition'
			{
				Query<Species> q2 = db.query(Species.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDefinition());
				q2.in("definition", inList);
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getDefinition(),entity.getDefinition());
				}
			}
			//test operator 'like' for field 'definition'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.like("definition", entity.getDefinition() + "%");
				q2.sortASC("definition");
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDefinition(), entity.getDefinition()));
				}
			}

			//test field 'termPath', type 'string'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.equals("termPath",entity.getTermPath());
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getTermPath(),entity.getTermPath());
				}
			}
			//test operator 'in' for field 'termPath'
			{
				Query<Species> q2 = db.query(Species.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTermPath());
				q2.in("termPath", inList);
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertEquals(r.getTermPath(),entity.getTermPath());
				}
			}
			//test operator 'like' for field 'termPath'
			{
				Query<Species> q2 = db.query(Species.class);
				q2.like("termPath", entity.getTermPath() + "%");
				q2.sortASC("termPath");
				List<Species> results = q2.find();
				for(Species r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTermPath(), entity.getTermPath()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testOntology"})
	public void testAlternateId() throws DatabaseException
	{
		//create entities
		List<AlternateId> entities = new ArrayList<AlternateId>();

		//retrieve xref entity candidates
		List<Ontology> ontologyXrefs = db.query(Ontology.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			AlternateId e = new AlternateId();
			e.setName(truncate("alternateid_name_"+i, 127));
			if(ontologyXrefs.size() > 0) e.setOntology_Id( ontologyXrefs.get(i).getId() );
			e.setTermAccession(truncate("alternateid_termaccession_"+i, 255));
			e.setDefinition(truncate("alternateid_definition_"+i, 255));
			e.setTermPath(truncate("alternateid_termpath_"+i, 1024));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<AlternateId> q = db.query(AlternateId.class).eq("__Type",AlternateId.class.getSimpleName());
		assertEquals(total, q.count());
		List<AlternateId> entitiesDb = q.sortASC("id").find();
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
		for(AlternateId entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				q2.equals("id",entity.getId());
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				q2.equals("name",entity.getName());
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'ontology', type 'xref'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				q2.equals("ontology",entity.getOntology_Id());
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'in' for field 'ontology'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntology_Id());
				q2.in("ontology", inList);
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ontology_name'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				q2.equals("ontology_name",entity.getOntology_Name());
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}
			//test operator 'in' for implicit join field 'ontology_name'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntology_Name());
				q2.in("ontology_name", inList);
				q2.sortDESC("ontology_name");
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertEquals(r.getOntology_Id(), entity.getOntology_Id());
				}
			}

			//test field 'termAccession', type 'string'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				q2.equals("termAccession",entity.getTermAccession());
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertEquals(r.getTermAccession(),entity.getTermAccession());
				}
			}
			//test operator 'in' for field 'termAccession'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTermAccession());
				q2.in("termAccession", inList);
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertEquals(r.getTermAccession(),entity.getTermAccession());
				}
			}
			//test operator 'like' for field 'termAccession'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				q2.like("termAccession", entity.getTermAccession() + "%");
				q2.sortASC("termAccession");
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTermAccession(), entity.getTermAccession()));
				}
			}

			//test field 'definition', type 'string'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				q2.equals("definition",entity.getDefinition());
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertEquals(r.getDefinition(),entity.getDefinition());
				}
			}
			//test operator 'in' for field 'definition'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDefinition());
				q2.in("definition", inList);
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertEquals(r.getDefinition(),entity.getDefinition());
				}
			}
			//test operator 'like' for field 'definition'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				q2.like("definition", entity.getDefinition() + "%");
				q2.sortASC("definition");
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDefinition(), entity.getDefinition()));
				}
			}

			//test field 'termPath', type 'string'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				q2.equals("termPath",entity.getTermPath());
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertEquals(r.getTermPath(),entity.getTermPath());
				}
			}
			//test operator 'in' for field 'termPath'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTermPath());
				q2.in("termPath", inList);
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertEquals(r.getTermPath(),entity.getTermPath());
				}
			}
			//test operator 'like' for field 'termPath'
			{
				Query<AlternateId> q2 = db.query(AlternateId.class);
				q2.like("termPath", entity.getTermPath() + "%");
				q2.sortASC("termPath");
				List<AlternateId> results = q2.find();
				for(AlternateId r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTermPath(), entity.getTermPath()));
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
		Query<OntologyTerm> q = db.query(OntologyTerm.class).eq("__Type",OntologyTerm.class.getSimpleName());
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
		Query<MolgenisFile> q = db.query(MolgenisFile.class).eq("__Type",MolgenisFile.class.getSimpleName());
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
				assertEquals(results.size(),1);
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

	@Test
	public void testInvestigation() throws DatabaseException
	{
		//create entities
		List<Investigation> entities = new ArrayList<Investigation>();

		//retrieve xref entity candidates
		List<Person> contactsXrefs = db.query(Person.class).eq("__Type",Person.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Investigation e = new Investigation();
			e.setName(truncate("investigation_name_"+i, 127));
			e.setDescription("investigation_description_"+i);
			e.setEndDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			if(contactsXrefs.size() > 0)
			{
				e.getContacts_Id().add( contactsXrefs.get(i).getId() );
				//e.getContacts().add( random(contactsXrefs).getId() );
			}
			e.setAccession("investigation_accession_"+i);
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Investigation> q = db.query(Investigation.class);
		assertEquals(total, q.count());
		List<Investigation> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			//check formatted because of milliseconds rounding
			assertEquals(dateTimeFormat.format(entities.get(i).getEndDate()),dateTimeFormat.format(entitiesDb.get(i).getEndDate()));
			assertEquals(entities.get(i).getContacts_Id(), entitiesDb.get(i).getContacts_Id());
			assertEquals(entities.get(i).getAccession(), entitiesDb.get(i).getAccession());
		}	
		
		//test the query capabilities by finding on all fields
		for(Investigation entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.equals("id",entity.getId());
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.equals("name",entity.getName());
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.equals("description",entity.getDescription());
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Investigation> q2 = db.query(Investigation.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Investigation> results = q2.find();
				for(Investigation r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testInvestigation"})
	public void testObservationElement() throws DatabaseException
	{
		//create entities
		List<ObservationElement> entities = new ArrayList<ObservationElement>();

		//retrieve xref entity candidates
		List<Investigation> investigationXrefs = db.query(Investigation.class).find();	
		List<OntologyTerm> ontologyReferenceXrefs = db.query(OntologyTerm.class).find();	
		List<AlternateId> alternateIdXrefs = db.query(AlternateId.class).eq("__Type",AlternateId.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			ObservationElement e = new ObservationElement();
			e.setName(truncate("observationelement_name_"+i, 127));
			e.setDescription("observationelement_description_"+i);
			if(investigationXrefs.size() > 0) e.setInvestigation_Id( investigationXrefs.get(i).getId() );
			if(ontologyReferenceXrefs.size() > 0)
			{
				e.getOntologyReference_Id().add( ontologyReferenceXrefs.get(i).getId() );
				//e.getOntologyReference().add( random(ontologyReferenceXrefs).getId() );
			}
			if(alternateIdXrefs.size() > 0)
			{
				e.getAlternateId_Id().add( alternateIdXrefs.get(i).getId() );
				//e.getAlternateId().add( random(alternateIdXrefs).getId() );
			}
			e.setLabel(truncate("observationelement_label_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<ObservationElement> q = db.query(ObservationElement.class).eq("__Type",ObservationElement.class.getSimpleName());
		assertEquals(total, q.count());
		List<ObservationElement> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getInvestigation_Id(), entitiesDb.get(i).getInvestigation_Id());
			assertEquals(entities.get(i).getOntologyReference_Id(), entitiesDb.get(i).getOntologyReference_Id());
			assertEquals(entities.get(i).getAlternateId_Id(), entitiesDb.get(i).getAlternateId_Id());
			assertEquals(entities.get(i).getLabel(), entitiesDb.get(i).getLabel());
		}	
		
		//test the query capabilities by finding on all fields
		for(ObservationElement entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				q2.equals("id",entity.getId());
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				q2.equals("name",entity.getName());
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				q2.equals("description",entity.getDescription());
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'Investigation', type 'xref'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				q2.equals("investigation",entity.getInvestigation_Id());
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for field 'Investigation'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Id());
				q2.in("investigation", inList);
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Investigation_name'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				q2.equals("investigation_name",entity.getInvestigation_Name());
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for implicit join field 'Investigation_name'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Name());
				q2.in("investigation_name", inList);
				q2.sortDESC("investigation_name");
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}

			//test field 'label', type 'string'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				q2.equals("label",entity.getLabel());
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'in' for field 'label'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getLabel());
				q2.in("label", inList);
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'like' for field 'label'
			{
				Query<ObservationElement> q2 = db.query(ObservationElement.class);
				q2.like("label", entity.getLabel() + "%");
				q2.sortASC("label");
				List<ObservationElement> results = q2.find();
				for(ObservationElement r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getLabel(), entity.getLabel()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testInvestigation"})
	public void testObservationTarget() throws DatabaseException
	{
		//create entities
		List<ObservationTarget> entities = new ArrayList<ObservationTarget>();

		//retrieve xref entity candidates
		List<Investigation> investigationXrefs = db.query(Investigation.class).find();	
		List<OntologyTerm> ontologyReferenceXrefs = db.query(OntologyTerm.class).find();	
		List<AlternateId> alternateIdXrefs = db.query(AlternateId.class).eq("__Type",AlternateId.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			ObservationTarget e = new ObservationTarget();
			e.setName(truncate("observationtarget_name_"+i, 127));
			e.setDescription("observationtarget_description_"+i);
			if(investigationXrefs.size() > 0) e.setInvestigation_Id( investigationXrefs.get(i).getId() );
			if(ontologyReferenceXrefs.size() > 0)
			{
				e.getOntologyReference_Id().add( ontologyReferenceXrefs.get(i).getId() );
				//e.getOntologyReference().add( random(ontologyReferenceXrefs).getId() );
			}
			if(alternateIdXrefs.size() > 0)
			{
				e.getAlternateId_Id().add( alternateIdXrefs.get(i).getId() );
				//e.getAlternateId().add( random(alternateIdXrefs).getId() );
			}
			e.setLabel(truncate("observationtarget_label_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<ObservationTarget> q = db.query(ObservationTarget.class).eq("__Type",ObservationTarget.class.getSimpleName());
		assertEquals(total, q.count());
		List<ObservationTarget> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getInvestigation_Id(), entitiesDb.get(i).getInvestigation_Id());
			assertEquals(entities.get(i).getOntologyReference_Id(), entitiesDb.get(i).getOntologyReference_Id());
			assertEquals(entities.get(i).getAlternateId_Id(), entitiesDb.get(i).getAlternateId_Id());
			assertEquals(entities.get(i).getLabel(), entitiesDb.get(i).getLabel());
		}	
		
		//test the query capabilities by finding on all fields
		for(ObservationTarget entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.equals("id",entity.getId());
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.equals("name",entity.getName());
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.equals("description",entity.getDescription());
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'Investigation', type 'xref'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.equals("investigation",entity.getInvestigation_Id());
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for field 'Investigation'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Id());
				q2.in("investigation", inList);
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Investigation_name'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.equals("investigation_name",entity.getInvestigation_Name());
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for implicit join field 'Investigation_name'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Name());
				q2.in("investigation_name", inList);
				q2.sortDESC("investigation_name");
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}

			//test field 'label', type 'string'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.equals("label",entity.getLabel());
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'in' for field 'label'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getLabel());
				q2.in("label", inList);
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'like' for field 'label'
			{
				Query<ObservationTarget> q2 = db.query(ObservationTarget.class);
				q2.like("label", entity.getLabel() + "%");
				q2.sortASC("label");
				List<ObservationTarget> results = q2.find();
				for(ObservationTarget r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getLabel(), entity.getLabel()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testInvestigation"})
	public void testObservableFeature() throws DatabaseException
	{
		//create entities
		List<ObservableFeature> entities = new ArrayList<ObservableFeature>();

		//retrieve xref entity candidates
		List<Investigation> investigationXrefs = db.query(Investigation.class).find();	
		List<OntologyTerm> ontologyReferenceXrefs = db.query(OntologyTerm.class).find();	
		List<AlternateId> alternateIdXrefs = db.query(AlternateId.class).eq("__Type",AlternateId.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			ObservableFeature e = new ObservableFeature();
			e.setName(truncate("observablefeature_name_"+i, 127));
			e.setDescription("observablefeature_description_"+i);
			if(investigationXrefs.size() > 0) e.setInvestigation_Id( investigationXrefs.get(i).getId() );
			if(ontologyReferenceXrefs.size() > 0)
			{
				e.getOntologyReference_Id().add( ontologyReferenceXrefs.get(i).getId() );
				//e.getOntologyReference().add( random(ontologyReferenceXrefs).getId() );
			}
			if(alternateIdXrefs.size() > 0)
			{
				e.getAlternateId_Id().add( alternateIdXrefs.get(i).getId() );
				//e.getAlternateId().add( random(alternateIdXrefs).getId() );
			}
			e.setLabel(truncate("observablefeature_label_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<ObservableFeature> q = db.query(ObservableFeature.class).eq("__Type",ObservableFeature.class.getSimpleName());
		assertEquals(total, q.count());
		List<ObservableFeature> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getInvestigation_Id(), entitiesDb.get(i).getInvestigation_Id());
			assertEquals(entities.get(i).getOntologyReference_Id(), entitiesDb.get(i).getOntologyReference_Id());
			assertEquals(entities.get(i).getAlternateId_Id(), entitiesDb.get(i).getAlternateId_Id());
			assertEquals(entities.get(i).getLabel(), entitiesDb.get(i).getLabel());
		}	
		
		//test the query capabilities by finding on all fields
		for(ObservableFeature entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.equals("id",entity.getId());
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.equals("name",entity.getName());
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.equals("description",entity.getDescription());
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'Investigation', type 'xref'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.equals("investigation",entity.getInvestigation_Id());
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for field 'Investigation'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Id());
				q2.in("investigation", inList);
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Investigation_name'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.equals("investigation_name",entity.getInvestigation_Name());
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for implicit join field 'Investigation_name'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Name());
				q2.in("investigation_name", inList);
				q2.sortDESC("investigation_name");
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}

			//test field 'label', type 'string'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.equals("label",entity.getLabel());
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'in' for field 'label'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getLabel());
				q2.in("label", inList);
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'like' for field 'label'
			{
				Query<ObservableFeature> q2 = db.query(ObservableFeature.class);
				q2.like("label", entity.getLabel() + "%");
				q2.sortASC("label");
				List<ObservableFeature> results = q2.find();
				for(ObservableFeature r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getLabel(), entity.getLabel()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testInvestigation"})
	public void testCategory() throws DatabaseException
	{
		//create entities
		List<Category> entities = new ArrayList<Category>();

		//retrieve xref entity candidates
		List<Investigation> investigationXrefs = db.query(Investigation.class).find();	
		List<OntologyTerm> ontologyReferenceXrefs = db.query(OntologyTerm.class).find();	
		List<AlternateId> alternateIdXrefs = db.query(AlternateId.class).eq("__Type",AlternateId.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Category e = new Category();
			e.setName(truncate("category_name_"+i, 127));
			e.setDescription("category_description_"+i);
			if(investigationXrefs.size() > 0) e.setInvestigation_Id( investigationXrefs.get(i).getId() );
			if(ontologyReferenceXrefs.size() > 0)
			{
				e.getOntologyReference_Id().add( ontologyReferenceXrefs.get(i).getId() );
				//e.getOntologyReference().add( random(ontologyReferenceXrefs).getId() );
			}
			if(alternateIdXrefs.size() > 0)
			{
				e.getAlternateId_Id().add( alternateIdXrefs.get(i).getId() );
				//e.getAlternateId().add( random(alternateIdXrefs).getId() );
			}
			e.setLabel(truncate("category_label_"+i, 255));
			e.setCode_String(truncate("category_code_string_"+i, 255));
			e.setIsMissing(randomBool(i));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Category> q = db.query(Category.class).eq("__Type",Category.class.getSimpleName());
		assertEquals(total, q.count());
		List<Category> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getInvestigation_Id(), entitiesDb.get(i).getInvestigation_Id());
			assertEquals(entities.get(i).getOntologyReference_Id(), entitiesDb.get(i).getOntologyReference_Id());
			assertEquals(entities.get(i).getAlternateId_Id(), entitiesDb.get(i).getAlternateId_Id());
			assertEquals(entities.get(i).getLabel(), entitiesDb.get(i).getLabel());
			assertEquals(entities.get(i).getCode_String(), entitiesDb.get(i).getCode_String());
			assertEquals(entities.get(i).getIsMissing(), entitiesDb.get(i).getIsMissing());
		}	
		
		//test the query capabilities by finding on all fields
		for(Category entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.equals("id",entity.getId());
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Category> q2 = db.query(Category.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.equals("name",entity.getName());
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<Category> q2 = db.query(Category.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.equals("description",entity.getDescription());
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Category> q2 = db.query(Category.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'Investigation', type 'xref'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.equals("investigation",entity.getInvestigation_Id());
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for field 'Investigation'
			{
				Query<Category> q2 = db.query(Category.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Id());
				q2.in("investigation", inList);
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Investigation_name'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.equals("investigation_name",entity.getInvestigation_Name());
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for implicit join field 'Investigation_name'
			{
				Query<Category> q2 = db.query(Category.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Name());
				q2.in("investigation_name", inList);
				q2.sortDESC("investigation_name");
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}

			//test field 'label', type 'string'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.equals("label",entity.getLabel());
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'in' for field 'label'
			{
				Query<Category> q2 = db.query(Category.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getLabel());
				q2.in("label", inList);
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'like' for field 'label'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.like("label", entity.getLabel() + "%");
				q2.sortASC("label");
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getLabel(), entity.getLabel()));
				}
			}

			//test field 'code_string', type 'string'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.equals("code_string",entity.getCode_String());
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getCode_String(),entity.getCode_String());
				}
			}
			//test operator 'in' for field 'code_string'
			{
				Query<Category> q2 = db.query(Category.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getCode_String());
				q2.in("code_string", inList);
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertEquals(r.getCode_String(),entity.getCode_String());
				}
			}
			//test operator 'like' for field 'code_string'
			{
				Query<Category> q2 = db.query(Category.class);
				q2.like("code_string", entity.getCode_String() + "%");
				q2.sortASC("code_string");
				List<Category> results = q2.find();
				for(Category r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getCode_String(), entity.getCode_String()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testInvestigation","testOntologyTerm","testMolgenisEntity"})
	public void testMeasurement() throws DatabaseException
	{
		//create entities
		List<Measurement> entities = new ArrayList<Measurement>();

		//retrieve xref entity candidates
		List<Investigation> investigationXrefs = db.query(Investigation.class).find();	
		List<OntologyTerm> ontologyReferenceXrefs = db.query(OntologyTerm.class).find();	
		List<AlternateId> alternateIdXrefs = db.query(AlternateId.class).eq("__Type",AlternateId.class.getSimpleName()).find();	
		List<OntologyTerm> unitXrefs = db.query(OntologyTerm.class).find();	
		List<Category> categoriesXrefs = db.query(Category.class).eq("__Type",Category.class.getSimpleName()).find();	
		List<MolgenisEntity> targettypeAllowedForRelationXrefs = db.query(MolgenisEntity.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			Measurement e = new Measurement();
			e.setName(truncate("measurement_name_"+i, 127));
			e.setDescription("measurement_description_"+i);
			if(investigationXrefs.size() > 0) e.setInvestigation_Id( investigationXrefs.get(i).getId() );
			if(ontologyReferenceXrefs.size() > 0)
			{
				e.getOntologyReference_Id().add( ontologyReferenceXrefs.get(i).getId() );
				//e.getOntologyReference().add( random(ontologyReferenceXrefs).getId() );
			}
			if(alternateIdXrefs.size() > 0)
			{
				e.getAlternateId_Id().add( alternateIdXrefs.get(i).getId() );
				//e.getAlternateId().add( random(alternateIdXrefs).getId() );
			}
			e.setLabel(truncate("measurement_label_"+i, 255));
			if(unitXrefs.size() > 0) e.setUnit_Id( unitXrefs.get(i).getId() );
			e.setDataType(randomEnum(new String[]{"xref","string","categorical","date","datetime","int","code","image","decimal","bool","file","log","data","exe"}));
			e.setTemporal(randomBool(i));
			if(categoriesXrefs.size() > 0)
			{
				e.getCategories_Id().add( categoriesXrefs.get(i).getId() );
				//e.getCategories().add( random(categoriesXrefs).getId() );
			}
			if(targettypeAllowedForRelationXrefs.size() > 0) e.setTargettypeAllowedForRelation_Id( targettypeAllowedForRelationXrefs.get(i).getId() );
			e.setPanelLabelAllowedForRelation(truncate("measurement_panellabelallowedforrelation_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Measurement> q = db.query(Measurement.class).eq("__Type",Measurement.class.getSimpleName());
		assertEquals(total, q.count());
		List<Measurement> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getInvestigation_Id(), entitiesDb.get(i).getInvestigation_Id());
			assertEquals(entities.get(i).getOntologyReference_Id(), entitiesDb.get(i).getOntologyReference_Id());
			assertEquals(entities.get(i).getAlternateId_Id(), entitiesDb.get(i).getAlternateId_Id());
			assertEquals(entities.get(i).getLabel(), entitiesDb.get(i).getLabel());
			assertEquals(entities.get(i).getUnit_Id(), entitiesDb.get(i).getUnit_Id());
			assertEquals(entities.get(i).getDataType(), entitiesDb.get(i).getDataType());
			assertEquals(entities.get(i).getTemporal(), entitiesDb.get(i).getTemporal());
			assertEquals(entities.get(i).getCategories_Id(), entitiesDb.get(i).getCategories_Id());
			assertEquals(entities.get(i).getTargettypeAllowedForRelation_Id(), entitiesDb.get(i).getTargettypeAllowedForRelation_Id());
			assertEquals(entities.get(i).getPanelLabelAllowedForRelation(), entitiesDb.get(i).getPanelLabelAllowedForRelation());
		}	
		
		//test the query capabilities by finding on all fields
		for(Measurement entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.equals("id",entity.getId());
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.equals("name",entity.getName());
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.equals("description",entity.getDescription());
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'Investigation', type 'xref'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.equals("investigation",entity.getInvestigation_Id());
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for field 'Investigation'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Id());
				q2.in("investigation", inList);
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Investigation_name'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.equals("investigation_name",entity.getInvestigation_Name());
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for implicit join field 'Investigation_name'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Name());
				q2.in("investigation_name", inList);
				q2.sortDESC("investigation_name");
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}

			//test field 'label', type 'string'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.equals("label",entity.getLabel());
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'in' for field 'label'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getLabel());
				q2.in("label", inList);
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'like' for field 'label'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.like("label", entity.getLabel() + "%");
				q2.sortASC("label");
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getLabel(), entity.getLabel()));
				}
			}

			//test field 'unit', type 'xref'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.equals("unit",entity.getUnit_Id());
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}
			//test operator 'in' for field 'unit'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUnit_Id());
				q2.in("unit", inList);
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}
			//test operator 'equals' for implicit join field 'unit_name'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.equals("unit_name",entity.getUnit_Name());
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}
			//test operator 'in' for implicit join field 'unit_name'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getUnit_Name());
				q2.in("unit_name", inList);
				q2.sortDESC("unit_name");
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getUnit_Id(), entity.getUnit_Id());
				}
			}

			//test field 'targettypeAllowedForRelation', type 'xref'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.equals("targettypeAllowedForRelation",entity.getTargettypeAllowedForRelation_Id());
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getTargettypeAllowedForRelation_Id(), entity.getTargettypeAllowedForRelation_Id());
				}
			}
			//test operator 'in' for field 'targettypeAllowedForRelation'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTargettypeAllowedForRelation_Id());
				q2.in("targettypeAllowedForRelation", inList);
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getTargettypeAllowedForRelation_Id(), entity.getTargettypeAllowedForRelation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'targettypeAllowedForRelation_className'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.equals("targettypeAllowedForRelation_className",entity.getTargettypeAllowedForRelation_ClassName());
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getTargettypeAllowedForRelation_Id(), entity.getTargettypeAllowedForRelation_Id());
				}
			}
			//test operator 'in' for implicit join field 'targettypeAllowedForRelation_className'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTargettypeAllowedForRelation_ClassName());
				q2.in("targettypeAllowedForRelation_className", inList);
				q2.sortDESC("targettypeAllowedForRelation_className");
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getTargettypeAllowedForRelation_Id(), entity.getTargettypeAllowedForRelation_Id());
				}
			}

			//test field 'panelLabelAllowedForRelation', type 'string'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.equals("panelLabelAllowedForRelation",entity.getPanelLabelAllowedForRelation());
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getPanelLabelAllowedForRelation(),entity.getPanelLabelAllowedForRelation());
				}
			}
			//test operator 'in' for field 'panelLabelAllowedForRelation'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPanelLabelAllowedForRelation());
				q2.in("panelLabelAllowedForRelation", inList);
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertEquals(r.getPanelLabelAllowedForRelation(),entity.getPanelLabelAllowedForRelation());
				}
			}
			//test operator 'like' for field 'panelLabelAllowedForRelation'
			{
				Query<Measurement> q2 = db.query(Measurement.class);
				q2.like("panelLabelAllowedForRelation", entity.getPanelLabelAllowedForRelation() + "%");
				q2.sortASC("panelLabelAllowedForRelation");
				List<Measurement> results = q2.find();
				for(Measurement r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getPanelLabelAllowedForRelation(), entity.getPanelLabelAllowedForRelation()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testInvestigation"})
	public void testIndividual() throws DatabaseException
	{
		//create entities
		List<Individual> entities = new ArrayList<Individual>();

		//retrieve xref entity candidates
		List<Investigation> investigationXrefs = db.query(Investigation.class).find();	
		List<OntologyTerm> ontologyReferenceXrefs = db.query(OntologyTerm.class).find();	
		List<AlternateId> alternateIdXrefs = db.query(AlternateId.class).eq("__Type",AlternateId.class.getSimpleName()).find();	
		List<Individual> motherXrefs = db.query(Individual.class).eq("__Type",Individual.class.getSimpleName()).find();	
		List<Individual> fatherXrefs = db.query(Individual.class).eq("__Type",Individual.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Individual e = new Individual();
			e.setName(truncate("individual_name_"+i, 127));
			e.setDescription("individual_description_"+i);
			if(investigationXrefs.size() > 0) e.setInvestigation_Id( investigationXrefs.get(i).getId() );
			if(ontologyReferenceXrefs.size() > 0)
			{
				e.getOntologyReference_Id().add( ontologyReferenceXrefs.get(i).getId() );
				//e.getOntologyReference().add( random(ontologyReferenceXrefs).getId() );
			}
			if(alternateIdXrefs.size() > 0)
			{
				e.getAlternateId_Id().add( alternateIdXrefs.get(i).getId() );
				//e.getAlternateId().add( random(alternateIdXrefs).getId() );
			}
			e.setLabel(truncate("individual_label_"+i, 255));
			if(motherXrefs.size() > 0) e.setMother_Id( motherXrefs.get(i).getId() );
			if(fatherXrefs.size() > 0) e.setFather_Id( fatherXrefs.get(i).getId() );
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Individual> q = db.query(Individual.class).eq("__Type",Individual.class.getSimpleName());
		assertEquals(total, q.count());
		List<Individual> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getInvestigation_Id(), entitiesDb.get(i).getInvestigation_Id());
			assertEquals(entities.get(i).getOntologyReference_Id(), entitiesDb.get(i).getOntologyReference_Id());
			assertEquals(entities.get(i).getAlternateId_Id(), entitiesDb.get(i).getAlternateId_Id());
			assertEquals(entities.get(i).getLabel(), entitiesDb.get(i).getLabel());
			assertEquals(entities.get(i).getMother_Id(), entitiesDb.get(i).getMother_Id());
			assertEquals(entities.get(i).getFather_Id(), entitiesDb.get(i).getFather_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(Individual entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("id",entity.getId());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("name",entity.getName());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("description",entity.getDescription());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'Investigation', type 'xref'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("investigation",entity.getInvestigation_Id());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for field 'Investigation'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Id());
				q2.in("investigation", inList);
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Investigation_name'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("investigation_name",entity.getInvestigation_Name());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for implicit join field 'Investigation_name'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Name());
				q2.in("investigation_name", inList);
				q2.sortDESC("investigation_name");
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}

			//test field 'label', type 'string'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("label",entity.getLabel());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'in' for field 'label'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getLabel());
				q2.in("label", inList);
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'like' for field 'label'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.like("label", entity.getLabel() + "%");
				q2.sortASC("label");
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getLabel(), entity.getLabel()));
				}
			}

			//test field 'Mother', type 'xref'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("mother",entity.getMother_Id());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getMother_Id(), entity.getMother_Id());
				}
			}
			//test operator 'in' for field 'Mother'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getMother_Id());
				q2.in("mother", inList);
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getMother_Id(), entity.getMother_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Mother_name'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("mother_name",entity.getMother_Name());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getMother_Id(), entity.getMother_Id());
				}
			}
			//test operator 'in' for implicit join field 'Mother_name'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getMother_Name());
				q2.in("mother_name", inList);
				q2.sortDESC("mother_name");
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getMother_Id(), entity.getMother_Id());
				}
			}

			//test field 'Father', type 'xref'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("father",entity.getFather_Id());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getFather_Id(), entity.getFather_Id());
				}
			}
			//test operator 'in' for field 'Father'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFather_Id());
				q2.in("father", inList);
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getFather_Id(), entity.getFather_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Father_name'
			{
				Query<Individual> q2 = db.query(Individual.class);
				q2.equals("father_name",entity.getFather_Name());
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getFather_Id(), entity.getFather_Id());
				}
			}
			//test operator 'in' for implicit join field 'Father_name'
			{
				Query<Individual> q2 = db.query(Individual.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFather_Name());
				q2.in("father_name", inList);
				q2.sortDESC("father_name");
				List<Individual> results = q2.find();
				for(Individual r: results)
				{
					assertEquals(r.getFather_Id(), entity.getFather_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testInvestigation"})
	public void testLocation() throws DatabaseException
	{
		//create entities
		List<Location> entities = new ArrayList<Location>();

		//retrieve xref entity candidates
		List<Investigation> investigationXrefs = db.query(Investigation.class).find();	
		List<OntologyTerm> ontologyReferenceXrefs = db.query(OntologyTerm.class).find();	
		List<AlternateId> alternateIdXrefs = db.query(AlternateId.class).eq("__Type",AlternateId.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Location e = new Location();
			e.setName(truncate("location_name_"+i, 127));
			e.setDescription("location_description_"+i);
			if(investigationXrefs.size() > 0) e.setInvestigation_Id( investigationXrefs.get(i).getId() );
			if(ontologyReferenceXrefs.size() > 0)
			{
				e.getOntologyReference_Id().add( ontologyReferenceXrefs.get(i).getId() );
				//e.getOntologyReference().add( random(ontologyReferenceXrefs).getId() );
			}
			if(alternateIdXrefs.size() > 0)
			{
				e.getAlternateId_Id().add( alternateIdXrefs.get(i).getId() );
				//e.getAlternateId().add( random(alternateIdXrefs).getId() );
			}
			e.setLabel(truncate("location_label_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Location> q = db.query(Location.class).eq("__Type",Location.class.getSimpleName());
		assertEquals(total, q.count());
		List<Location> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getInvestigation_Id(), entitiesDb.get(i).getInvestigation_Id());
			assertEquals(entities.get(i).getOntologyReference_Id(), entitiesDb.get(i).getOntologyReference_Id());
			assertEquals(entities.get(i).getAlternateId_Id(), entitiesDb.get(i).getAlternateId_Id());
			assertEquals(entities.get(i).getLabel(), entitiesDb.get(i).getLabel());
		}	
		
		//test the query capabilities by finding on all fields
		for(Location entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Location> q2 = db.query(Location.class);
				q2.equals("id",entity.getId());
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Location> q2 = db.query(Location.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Location> q2 = db.query(Location.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Location> q2 = db.query(Location.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<Location> q2 = db.query(Location.class);
				q2.equals("name",entity.getName());
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<Location> q2 = db.query(Location.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<Location> q2 = db.query(Location.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Location> q2 = db.query(Location.class);
				q2.equals("description",entity.getDescription());
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Location> q2 = db.query(Location.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Location> q2 = db.query(Location.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'Investigation', type 'xref'
			{
				Query<Location> q2 = db.query(Location.class);
				q2.equals("investigation",entity.getInvestigation_Id());
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for field 'Investigation'
			{
				Query<Location> q2 = db.query(Location.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Id());
				q2.in("investigation", inList);
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Investigation_name'
			{
				Query<Location> q2 = db.query(Location.class);
				q2.equals("investigation_name",entity.getInvestigation_Name());
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for implicit join field 'Investigation_name'
			{
				Query<Location> q2 = db.query(Location.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Name());
				q2.in("investigation_name", inList);
				q2.sortDESC("investigation_name");
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}

			//test field 'label', type 'string'
			{
				Query<Location> q2 = db.query(Location.class);
				q2.equals("label",entity.getLabel());
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'in' for field 'label'
			{
				Query<Location> q2 = db.query(Location.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getLabel());
				q2.in("label", inList);
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'like' for field 'label'
			{
				Query<Location> q2 = db.query(Location.class);
				q2.like("label", entity.getLabel() + "%");
				q2.sortASC("label");
				List<Location> results = q2.find();
				for(Location r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getLabel(), entity.getLabel()));
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testInvestigation","testSpecies","testOntologyTerm"})
	public void testPanel() throws DatabaseException
	{
		//create entities
		List<Panel> entities = new ArrayList<Panel>();

		//retrieve xref entity candidates
		List<Investigation> investigationXrefs = db.query(Investigation.class).find();	
		List<OntologyTerm> ontologyReferenceXrefs = db.query(OntologyTerm.class).find();	
		List<AlternateId> alternateIdXrefs = db.query(AlternateId.class).eq("__Type",AlternateId.class.getSimpleName()).find();	
		List<Individual> individualsXrefs = db.query(Individual.class).eq("__Type",Individual.class.getSimpleName()).find();	
		List<Species> speciesXrefs = db.query(Species.class).eq("__Type",Species.class.getSimpleName()).find();	
		List<OntologyTerm> panelTypeXrefs = db.query(OntologyTerm.class).find();	
		List<Panel> founderPanelsXrefs = db.query(Panel.class).eq("__Type",Panel.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			Panel e = new Panel();
			e.setName(truncate("panel_name_"+i, 127));
			e.setDescription("panel_description_"+i);
			if(investigationXrefs.size() > 0) e.setInvestigation_Id( investigationXrefs.get(i).getId() );
			if(ontologyReferenceXrefs.size() > 0)
			{
				e.getOntologyReference_Id().add( ontologyReferenceXrefs.get(i).getId() );
				//e.getOntologyReference().add( random(ontologyReferenceXrefs).getId() );
			}
			if(alternateIdXrefs.size() > 0)
			{
				e.getAlternateId_Id().add( alternateIdXrefs.get(i).getId() );
				//e.getAlternateId().add( random(alternateIdXrefs).getId() );
			}
			e.setLabel(truncate("panel_label_"+i, 255));
			if(individualsXrefs.size() > 0)
			{
				e.getIndividuals_Id().add( individualsXrefs.get(i).getId() );
				//e.getIndividuals().add( random(individualsXrefs).getId() );
			}
			if(speciesXrefs.size() > 0) e.setSpecies_Id( speciesXrefs.get(i).getId() );
			if(panelTypeXrefs.size() > 0) e.setPanelType_Id( panelTypeXrefs.get(i).getId() );
			if(founderPanelsXrefs.size() > 0)
			{
				e.getFounderPanels_Id().add( founderPanelsXrefs.get(i).getId() );
				//e.getFounderPanels().add( random(founderPanelsXrefs).getId() );
			}
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Panel> q = db.query(Panel.class).eq("__Type",Panel.class.getSimpleName());
		assertEquals(total, q.count());
		List<Panel> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getInvestigation_Id(), entitiesDb.get(i).getInvestigation_Id());
			assertEquals(entities.get(i).getOntologyReference_Id(), entitiesDb.get(i).getOntologyReference_Id());
			assertEquals(entities.get(i).getAlternateId_Id(), entitiesDb.get(i).getAlternateId_Id());
			assertEquals(entities.get(i).getLabel(), entitiesDb.get(i).getLabel());
			assertEquals(entities.get(i).getIndividuals_Id(), entitiesDb.get(i).getIndividuals_Id());
			assertEquals(entities.get(i).getSpecies_Id(), entitiesDb.get(i).getSpecies_Id());
			assertEquals(entities.get(i).getPanelType_Id(), entitiesDb.get(i).getPanelType_Id());
			assertEquals(entities.get(i).getFounderPanels_Id(), entitiesDb.get(i).getFounderPanels_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(Panel entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("id",entity.getId());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("name",entity.getName());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("description",entity.getDescription());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'Investigation', type 'xref'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("investigation",entity.getInvestigation_Id());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for field 'Investigation'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Id());
				q2.in("investigation", inList);
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Investigation_name'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("investigation_name",entity.getInvestigation_Name());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for implicit join field 'Investigation_name'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Name());
				q2.in("investigation_name", inList);
				q2.sortDESC("investigation_name");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}

			//test field 'label', type 'string'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("label",entity.getLabel());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'in' for field 'label'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getLabel());
				q2.in("label", inList);
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getLabel(),entity.getLabel());
				}
			}
			//test operator 'like' for field 'label'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.like("label", entity.getLabel() + "%");
				q2.sortASC("label");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getLabel(), entity.getLabel()));
				}
			}

			//test field 'Species', type 'xref'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("species",entity.getSpecies_Id());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}
			//test operator 'in' for field 'Species'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSpecies_Id());
				q2.in("species", inList);
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Species_name'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("species_name",entity.getSpecies_Name());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}
			//test operator 'in' for implicit join field 'Species_name'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getSpecies_Name());
				q2.in("species_name", inList);
				q2.sortDESC("species_name");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getSpecies_Id(), entity.getSpecies_Id());
				}
			}

			//test field 'PanelType', type 'xref'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("panelType",entity.getPanelType_Id());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
				}
			}
			//test operator 'in' for field 'PanelType'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPanelType_Id());
				q2.in("panelType", inList);
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
				}
			}
			//test operator 'equals' for implicit join field 'PanelType_name'
			{
				Query<Panel> q2 = db.query(Panel.class);
				q2.equals("panelType_name",entity.getPanelType_Name());
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
				}
			}
			//test operator 'in' for implicit join field 'PanelType_name'
			{
				Query<Panel> q2 = db.query(Panel.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getPanelType_Name());
				q2.in("panelType_name", inList);
				q2.sortDESC("panelType_name");
				List<Panel> results = q2.find();
				for(Panel r: results)
				{
					assertEquals(r.getPanelType_Id(), entity.getPanelType_Id());
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

	@Test(dependsOnMethods = {"testInvestigation","testOntologyTerm","testPerson"})
	public void testProtocol() throws DatabaseException
	{
		//create entities
		List<Protocol> entities = new ArrayList<Protocol>();

		//retrieve xref entity candidates
		List<Investigation> investigationXrefs = db.query(Investigation.class).find();	
		List<OntologyTerm> ontologyReferenceXrefs = db.query(OntologyTerm.class).find();	
		List<OntologyTerm> protocolTypeXrefs = db.query(OntologyTerm.class).find();	
		List<ObservableFeature> featuresXrefs = db.query(ObservableFeature.class).eq("__Type",ObservableFeature.class.getSimpleName()).find();	
		List<Person> contactXrefs = db.query(Person.class).eq("__Type",Person.class.getSimpleName()).find();	
		List<Protocol> subprotocolsXrefs = db.query(Protocol.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			Protocol e = new Protocol();
			e.setName(truncate("protocol_name_"+i, 127));
			e.setDescription("protocol_description_"+i);
			if(investigationXrefs.size() > 0) e.setInvestigation_Id( investigationXrefs.get(i).getId() );
			if(ontologyReferenceXrefs.size() > 0)
			{
				e.getOntologyReference_Id().add( ontologyReferenceXrefs.get(i).getId() );
				//e.getOntologyReference().add( random(ontologyReferenceXrefs).getId() );
			}
			if(protocolTypeXrefs.size() > 0) e.setProtocolType_Id( protocolTypeXrefs.get(i).getId() );
			if(featuresXrefs.size() > 0)
			{
				e.getFeatures_Id().add( featuresXrefs.get(i).getId() );
				//e.getFeatures().add( random(featuresXrefs).getId() );
			}
			e.setTargetFilter(truncate("protocol_targetfilter_"+i, 255));
			if(contactXrefs.size() > 0) e.setContact_Id( contactXrefs.get(i).getId() );
			if(subprotocolsXrefs.size() > 0)
			{
				e.getSubprotocols_Id().add( subprotocolsXrefs.get(i).getId() );
				//e.getSubprotocols().add( random(subprotocolsXrefs).getId() );
			}
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Protocol> q = db.query(Protocol.class).eq("__Type",Protocol.class.getSimpleName());
		assertEquals(total, q.count());
		List<Protocol> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getInvestigation_Id(), entitiesDb.get(i).getInvestigation_Id());
			assertEquals(entities.get(i).getOntologyReference_Id(), entitiesDb.get(i).getOntologyReference_Id());
			assertEquals(entities.get(i).getProtocolType_Id(), entitiesDb.get(i).getProtocolType_Id());
			assertEquals(entities.get(i).getFeatures_Id(), entitiesDb.get(i).getFeatures_Id());
			assertEquals(entities.get(i).getTargetFilter(), entitiesDb.get(i).getTargetFilter());
			assertEquals(entities.get(i).getContact_Id(), entitiesDb.get(i).getContact_Id());
			assertEquals(entities.get(i).getSubprotocols_Id(), entitiesDb.get(i).getSubprotocols_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(Protocol entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.equals("id",entity.getId());
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.equals("name",entity.getName());
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Investigation', type 'xref'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.equals("investigation",entity.getInvestigation_Id());
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for field 'Investigation'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Id());
				q2.in("investigation", inList);
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Investigation_name'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.equals("investigation_name",entity.getInvestigation_Name());
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for implicit join field 'Investigation_name'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Name());
				q2.in("investigation_name", inList);
				q2.sortDESC("investigation_name");
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}

			//test field 'ProtocolType', type 'xref'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.equals("protocolType",entity.getProtocolType_Id());
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getProtocolType_Id(), entity.getProtocolType_Id());
				}
			}
			//test operator 'in' for field 'ProtocolType'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolType_Id());
				q2.in("protocolType", inList);
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getProtocolType_Id(), entity.getProtocolType_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ProtocolType_name'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.equals("protocolType_name",entity.getProtocolType_Name());
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getProtocolType_Id(), entity.getProtocolType_Id());
				}
			}
			//test operator 'in' for implicit join field 'ProtocolType_name'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolType_Name());
				q2.in("protocolType_name", inList);
				q2.sortDESC("protocolType_name");
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getProtocolType_Id(), entity.getProtocolType_Id());
				}
			}

			//test field 'TargetFilter', type 'string'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.equals("targetFilter",entity.getTargetFilter());
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getTargetFilter(),entity.getTargetFilter());
				}
			}
			//test operator 'in' for field 'TargetFilter'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTargetFilter());
				q2.in("targetFilter", inList);
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getTargetFilter(),entity.getTargetFilter());
				}
			}
			//test operator 'like' for field 'TargetFilter'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.like("targetFilter", entity.getTargetFilter() + "%");
				q2.sortASC("targetFilter");
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTargetFilter(), entity.getTargetFilter()));
				}
			}

			//test field 'Contact', type 'xref'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.equals("contact",entity.getContact_Id());
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getContact_Id(), entity.getContact_Id());
				}
			}
			//test operator 'in' for field 'Contact'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getContact_Id());
				q2.in("contact", inList);
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getContact_Id(), entity.getContact_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Contact_name'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				q2.equals("contact_name",entity.getContact_Name());
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getContact_Id(), entity.getContact_Id());
				}
			}
			//test operator 'in' for implicit join field 'Contact_name'
			{
				Query<Protocol> q2 = db.query(Protocol.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getContact_Name());
				q2.in("contact_name", inList);
				q2.sortDESC("contact_name");
				List<Protocol> results = q2.find();
				for(Protocol r: results)
				{
					assertEquals(r.getContact_Id(), entity.getContact_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testInvestigation","testOntologyTerm","testPerson"})
	public void testWorkflow() throws DatabaseException
	{
		//create entities
		List<Workflow> entities = new ArrayList<Workflow>();

		//retrieve xref entity candidates
		List<Investigation> investigationXrefs = db.query(Investigation.class).find();	
		List<OntologyTerm> ontologyReferenceXrefs = db.query(OntologyTerm.class).find();	
		List<OntologyTerm> protocolTypeXrefs = db.query(OntologyTerm.class).find();	
		List<ObservableFeature> featuresXrefs = db.query(ObservableFeature.class).eq("__Type",ObservableFeature.class.getSimpleName()).find();	
		List<Person> contactXrefs = db.query(Person.class).eq("__Type",Person.class.getSimpleName()).find();	
		List<Protocol> subprotocolsXrefs = db.query(Protocol.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			Workflow e = new Workflow();
			e.setName(truncate("workflow_name_"+i, 127));
			e.setDescription("workflow_description_"+i);
			if(investigationXrefs.size() > 0) e.setInvestigation_Id( investigationXrefs.get(i).getId() );
			if(ontologyReferenceXrefs.size() > 0)
			{
				e.getOntologyReference_Id().add( ontologyReferenceXrefs.get(i).getId() );
				//e.getOntologyReference().add( random(ontologyReferenceXrefs).getId() );
			}
			if(protocolTypeXrefs.size() > 0) e.setProtocolType_Id( protocolTypeXrefs.get(i).getId() );
			if(featuresXrefs.size() > 0)
			{
				e.getFeatures_Id().add( featuresXrefs.get(i).getId() );
				//e.getFeatures().add( random(featuresXrefs).getId() );
			}
			e.setTargetFilter(truncate("workflow_targetfilter_"+i, 255));
			if(contactXrefs.size() > 0) e.setContact_Id( contactXrefs.get(i).getId() );
			if(subprotocolsXrefs.size() > 0)
			{
				e.getSubprotocols_Id().add( subprotocolsXrefs.get(i).getId() );
				//e.getSubprotocols().add( random(subprotocolsXrefs).getId() );
			}
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<Workflow> q = db.query(Workflow.class).eq("__Type",Workflow.class.getSimpleName());
		assertEquals(total, q.count());
		List<Workflow> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getInvestigation_Id(), entitiesDb.get(i).getInvestigation_Id());
			assertEquals(entities.get(i).getOntologyReference_Id(), entitiesDb.get(i).getOntologyReference_Id());
			assertEquals(entities.get(i).getProtocolType_Id(), entitiesDb.get(i).getProtocolType_Id());
			assertEquals(entities.get(i).getFeatures_Id(), entitiesDb.get(i).getFeatures_Id());
			assertEquals(entities.get(i).getTargetFilter(), entitiesDb.get(i).getTargetFilter());
			assertEquals(entities.get(i).getContact_Id(), entitiesDb.get(i).getContact_Id());
			assertEquals(entities.get(i).getSubprotocols_Id(), entitiesDb.get(i).getSubprotocols_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(Workflow entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				q2.equals("id",entity.getId());
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				q2.equals("name",entity.getName());
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Investigation', type 'xref'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				q2.equals("investigation",entity.getInvestigation_Id());
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for field 'Investigation'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Id());
				q2.in("investigation", inList);
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Investigation_name'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				q2.equals("investigation_name",entity.getInvestigation_Name());
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for implicit join field 'Investigation_name'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Name());
				q2.in("investigation_name", inList);
				q2.sortDESC("investigation_name");
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}

			//test field 'ProtocolType', type 'xref'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				q2.equals("protocolType",entity.getProtocolType_Id());
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getProtocolType_Id(), entity.getProtocolType_Id());
				}
			}
			//test operator 'in' for field 'ProtocolType'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolType_Id());
				q2.in("protocolType", inList);
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getProtocolType_Id(), entity.getProtocolType_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ProtocolType_name'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				q2.equals("protocolType_name",entity.getProtocolType_Name());
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getProtocolType_Id(), entity.getProtocolType_Id());
				}
			}
			//test operator 'in' for implicit join field 'ProtocolType_name'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolType_Name());
				q2.in("protocolType_name", inList);
				q2.sortDESC("protocolType_name");
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getProtocolType_Id(), entity.getProtocolType_Id());
				}
			}

			//test field 'TargetFilter', type 'string'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				q2.equals("targetFilter",entity.getTargetFilter());
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getTargetFilter(),entity.getTargetFilter());
				}
			}
			//test operator 'in' for field 'TargetFilter'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTargetFilter());
				q2.in("targetFilter", inList);
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getTargetFilter(),entity.getTargetFilter());
				}
			}
			//test operator 'like' for field 'TargetFilter'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				q2.like("targetFilter", entity.getTargetFilter() + "%");
				q2.sortASC("targetFilter");
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getTargetFilter(), entity.getTargetFilter()));
				}
			}

			//test field 'Contact', type 'xref'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				q2.equals("contact",entity.getContact_Id());
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getContact_Id(), entity.getContact_Id());
				}
			}
			//test operator 'in' for field 'Contact'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getContact_Id());
				q2.in("contact", inList);
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getContact_Id(), entity.getContact_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Contact_name'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				q2.equals("contact_name",entity.getContact_Name());
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getContact_Id(), entity.getContact_Id());
				}
			}
			//test operator 'in' for implicit join field 'Contact_name'
			{
				Query<Workflow> q2 = db.query(Workflow.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getContact_Name());
				q2.in("contact_name", inList);
				q2.sortDESC("contact_name");
				List<Workflow> results = q2.find();
				for(Workflow r: results)
				{
					assertEquals(r.getContact_Id(), entity.getContact_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testInvestigation","testProtocol"})
	public void testProtocolApplication() throws DatabaseException
	{
		//create entities
		List<ProtocolApplication> entities = new ArrayList<ProtocolApplication>();

		//retrieve xref entity candidates
		List<Investigation> investigationXrefs = db.query(Investigation.class).find();	
		List<OntologyTerm> ontologyReferenceXrefs = db.query(OntologyTerm.class).find();	
		List<Protocol> protocolXrefs = db.query(Protocol.class).find();	
		List<Person> performerXrefs = db.query(Person.class).eq("__Type",Person.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			ProtocolApplication e = new ProtocolApplication();
			e.setName(truncate("protocolapplication_name_"+i, 127));
			e.setDescription("protocolapplication_description_"+i);
			if(investigationXrefs.size() > 0) e.setInvestigation_Id( investigationXrefs.get(i).getId() );
			if(ontologyReferenceXrefs.size() > 0)
			{
				e.getOntologyReference_Id().add( ontologyReferenceXrefs.get(i).getId() );
				//e.getOntologyReference().add( random(ontologyReferenceXrefs).getId() );
			}
			if(protocolXrefs.size() > 0) e.setProtocol_Id( protocolXrefs.get(i).getId() );
			if(performerXrefs.size() > 0)
			{
				e.getPerformer_Id().add( performerXrefs.get(i).getId() );
				//e.getPerformer().add( random(performerXrefs).getId() );
			}
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<ProtocolApplication> q = db.query(ProtocolApplication.class);
		assertEquals(total, q.count());
		List<ProtocolApplication> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getDescription(), entitiesDb.get(i).getDescription());
			assertEquals(entities.get(i).getInvestigation_Id(), entitiesDb.get(i).getInvestigation_Id());
			assertEquals(entities.get(i).getOntologyReference_Id(), entitiesDb.get(i).getOntologyReference_Id());
			assertEquals(entities.get(i).getProtocol_Id(), entitiesDb.get(i).getProtocol_Id());
			assertEquals(entities.get(i).getPerformer_Id(), entitiesDb.get(i).getPerformer_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(ProtocolApplication entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				q2.equals("id",entity.getId());
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				q2.equals("name",entity.getName());
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'description', type 'text'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				q2.equals("description",entity.getDescription());
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'in' for field 'description'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getDescription());
				q2.in("description", inList);
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertEquals(r.getDescription(),entity.getDescription());
				}
			}
			//test operator 'like' for field 'description'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				q2.like("description", entity.getDescription() + "%");
				q2.sortASC("description");
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getDescription(), entity.getDescription()));
				}
			}

			//test field 'Investigation', type 'xref'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				q2.equals("investigation",entity.getInvestigation_Id());
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for field 'Investigation'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Id());
				q2.in("investigation", inList);
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Investigation_name'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				q2.equals("investigation_name",entity.getInvestigation_Name());
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for implicit join field 'Investigation_name'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Name());
				q2.in("investigation_name", inList);
				q2.sortDESC("investigation_name");
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}

			//test field 'protocol', type 'xref'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				q2.equals("protocol",entity.getProtocol_Id());
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertEquals(r.getProtocol_Id(), entity.getProtocol_Id());
				}
			}
			//test operator 'in' for field 'protocol'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocol_Id());
				q2.in("protocol", inList);
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertEquals(r.getProtocol_Id(), entity.getProtocol_Id());
				}
			}
			//test operator 'equals' for implicit join field 'protocol_name'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				q2.equals("protocol_name",entity.getProtocol_Name());
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertEquals(r.getProtocol_Id(), entity.getProtocol_Id());
				}
			}
			//test operator 'in' for implicit join field 'protocol_name'
			{
				Query<ProtocolApplication> q2 = db.query(ProtocolApplication.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocol_Name());
				q2.in("protocol_name", inList);
				q2.sortDESC("protocol_name");
				List<ProtocolApplication> results = q2.find();
				for(ProtocolApplication r: results)
				{
					assertEquals(r.getProtocol_Id(), entity.getProtocol_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testInvestigation","testProtocolApplication","testObservationElement","testObservationElement","testOntologyTerm","testObservationElement"})
	public void testObservedValue() throws DatabaseException
	{
		//create entities
		List<ObservedValue> entities = new ArrayList<ObservedValue>();

		//retrieve xref entity candidates
		List<Investigation> investigationXrefs = db.query(Investigation.class).find();	
		List<ProtocolApplication> protocolApplicationXrefs = db.query(ProtocolApplication.class).find();	
		List<ObservationElement> featureXrefs = db.query(ObservationElement.class).find();	
		List<ObservationElement> targetXrefs = db.query(ObservationElement.class).find();	
		List<OntologyTerm> ontologyReferenceXrefs = db.query(OntologyTerm.class).find();	
		List<ObservationElement> relationXrefs = db.query(ObservationElement.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			ObservedValue e = new ObservedValue();
			if(investigationXrefs.size() > 0) e.setInvestigation_Id( investigationXrefs.get(i).getId() );
			if(protocolApplicationXrefs.size() > 0) e.setProtocolApplication_Id( protocolApplicationXrefs.get(i).getId() );
			if(featureXrefs.size() > 0) e.setFeature_Id( featureXrefs.get(i).getId() );
			if(targetXrefs.size() > 0) e.setTarget_Id( targetXrefs.get(i).getId() );
			if(ontologyReferenceXrefs.size() > 0) e.setOntologyReference_Id( ontologyReferenceXrefs.get(i).getId() );
			e.setValue(truncate("observedvalue_value_"+i, 255));
			if(relationXrefs.size() > 0) e.setRelation_Id( relationXrefs.get(i).getId() );
			e.setTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			e.setEndtime(new java.sql.Timestamp(new java.util.Date().getTime()));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<ObservedValue> q = db.query(ObservedValue.class);
		assertEquals(total, q.count());
		List<ObservedValue> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getInvestigation_Id(), entitiesDb.get(i).getInvestigation_Id());
			assertEquals(entities.get(i).getProtocolApplication_Id(), entitiesDb.get(i).getProtocolApplication_Id());
			assertEquals(entities.get(i).getFeature_Id(), entitiesDb.get(i).getFeature_Id());
			assertEquals(entities.get(i).getTarget_Id(), entitiesDb.get(i).getTarget_Id());
			assertEquals(entities.get(i).getOntologyReference_Id(), entitiesDb.get(i).getOntologyReference_Id());
			assertEquals(entities.get(i).getValue(), entitiesDb.get(i).getValue());
			assertEquals(entities.get(i).getRelation_Id(), entitiesDb.get(i).getRelation_Id());
			//check formatted because of milliseconds rounding
			assertEquals(dateTimeFormat.format(entities.get(i).getTime()),dateTimeFormat.format(entitiesDb.get(i).getTime()));
			//check formatted because of milliseconds rounding
			assertEquals(dateTimeFormat.format(entities.get(i).getEndtime()),dateTimeFormat.format(entitiesDb.get(i).getEndtime()));
		}	
		
		//test the query capabilities by finding on all fields
		for(ObservedValue entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("id",entity.getId());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'Investigation', type 'xref'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("investigation",entity.getInvestigation_Id());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for field 'Investigation'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Id());
				q2.in("investigation", inList);
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Investigation_name'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("investigation_name",entity.getInvestigation_Name());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}
			//test operator 'in' for implicit join field 'Investigation_name'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getInvestigation_Name());
				q2.in("investigation_name", inList);
				q2.sortDESC("investigation_name");
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getInvestigation_Id(), entity.getInvestigation_Id());
				}
			}

			//test field 'protocolApplication', type 'xref'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("protocolApplication",entity.getProtocolApplication_Id());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getProtocolApplication_Id(), entity.getProtocolApplication_Id());
				}
			}
			//test operator 'in' for field 'protocolApplication'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolApplication_Id());
				q2.in("protocolApplication", inList);
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getProtocolApplication_Id(), entity.getProtocolApplication_Id());
				}
			}
			//test operator 'equals' for implicit join field 'protocolApplication_name'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("protocolApplication_name",entity.getProtocolApplication_Name());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getProtocolApplication_Id(), entity.getProtocolApplication_Id());
				}
			}
			//test operator 'in' for implicit join field 'protocolApplication_name'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocolApplication_Name());
				q2.in("protocolApplication_name", inList);
				q2.sortDESC("protocolApplication_name");
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getProtocolApplication_Id(), entity.getProtocolApplication_Id());
				}
			}

			//test field 'Feature', type 'xref'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("feature",entity.getFeature_Id());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getFeature_Id(), entity.getFeature_Id());
				}
			}
			//test operator 'in' for field 'Feature'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFeature_Id());
				q2.in("feature", inList);
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getFeature_Id(), entity.getFeature_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Feature_name'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("feature_name",entity.getFeature_Name());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getFeature_Id(), entity.getFeature_Id());
				}
			}
			//test operator 'in' for implicit join field 'Feature_name'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getFeature_Name());
				q2.in("feature_name", inList);
				q2.sortDESC("feature_name");
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getFeature_Id(), entity.getFeature_Id());
				}
			}

			//test field 'Target', type 'xref'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("target",entity.getTarget_Id());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getTarget_Id(), entity.getTarget_Id());
				}
			}
			//test operator 'in' for field 'Target'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTarget_Id());
				q2.in("target", inList);
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getTarget_Id(), entity.getTarget_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Target_name'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("target_name",entity.getTarget_Name());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getTarget_Id(), entity.getTarget_Id());
				}
			}
			//test operator 'in' for implicit join field 'Target_name'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getTarget_Name());
				q2.in("target_name", inList);
				q2.sortDESC("target_name");
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getTarget_Id(), entity.getTarget_Id());
				}
			}

			//test field 'ontologyReference', type 'xref'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("ontologyReference",entity.getOntologyReference_Id());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getOntologyReference_Id(), entity.getOntologyReference_Id());
				}
			}
			//test operator 'in' for field 'ontologyReference'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntologyReference_Id());
				q2.in("ontologyReference", inList);
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getOntologyReference_Id(), entity.getOntologyReference_Id());
				}
			}
			//test operator 'equals' for implicit join field 'ontologyReference_name'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("ontologyReference_name",entity.getOntologyReference_Name());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getOntologyReference_Id(), entity.getOntologyReference_Id());
				}
			}
			//test operator 'in' for implicit join field 'ontologyReference_name'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getOntologyReference_Name());
				q2.in("ontologyReference_name", inList);
				q2.sortDESC("ontologyReference_name");
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getOntologyReference_Id(), entity.getOntologyReference_Id());
				}
			}

			//test field 'value', type 'string'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("value",entity.getValue());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getValue(),entity.getValue());
				}
			}
			//test operator 'in' for field 'value'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getValue());
				q2.in("value", inList);
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getValue(),entity.getValue());
				}
			}
			//test operator 'like' for field 'value'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.like("value", entity.getValue() + "%");
				q2.sortASC("value");
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getValue(), entity.getValue()));
				}
			}

			//test field 'relation', type 'xref'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("relation",entity.getRelation_Id());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getRelation_Id(), entity.getRelation_Id());
				}
			}
			//test operator 'in' for field 'relation'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getRelation_Id());
				q2.in("relation", inList);
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getRelation_Id(), entity.getRelation_Id());
				}
			}
			//test operator 'equals' for implicit join field 'relation_name'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				q2.equals("relation_name",entity.getRelation_Name());
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getRelation_Id(), entity.getRelation_Id());
				}
			}
			//test operator 'in' for implicit join field 'relation_name'
			{
				Query<ObservedValue> q2 = db.query(ObservedValue.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getRelation_Name());
				q2.in("relation_name", inList);
				q2.sortDESC("relation_name");
				List<ObservedValue> results = q2.find();
				for(ObservedValue r: results)
				{
					assertEquals(r.getRelation_Id(), entity.getRelation_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testProtocol"})
	public void testProtocolDocument() throws DatabaseException
	{
		//create entities
		List<ProtocolDocument> entities = new ArrayList<ProtocolDocument>();

		//retrieve xref entity candidates
		List<Protocol> protocolXrefs = db.query(Protocol.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			ProtocolDocument e = new ProtocolDocument();
			e.setName(truncate("protocoldocument_name_"+i, 127));
			e.setExtension(truncate("protocoldocument_extension_"+i, 8));
			if(protocolXrefs.size() > 0) e.setProtocol_Id( protocolXrefs.get(i).getId() );
			e.setDocument("protocoldocument_document_"+i);
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<ProtocolDocument> q = db.query(ProtocolDocument.class).eq("__Type",ProtocolDocument.class.getSimpleName());
		assertEquals(total, q.count());
		List<ProtocolDocument> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getExtension(), entitiesDb.get(i).getExtension());
			assertEquals(entities.get(i).getProtocol_Id(), entitiesDb.get(i).getProtocol_Id());
			assertEquals(entities.get(i).getDocument(), entitiesDb.get(i).getDocument());
		}	
		
		//test the query capabilities by finding on all fields
		for(ProtocolDocument entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<ProtocolDocument> q2 = db.query(ProtocolDocument.class);
				q2.equals("id",entity.getId());
				List<ProtocolDocument> results = q2.find();
				for(ProtocolDocument r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<ProtocolDocument> q2 = db.query(ProtocolDocument.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<ProtocolDocument> results = q2.find();
				for(ProtocolDocument r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<ProtocolDocument> q2 = db.query(ProtocolDocument.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<ProtocolDocument> results = q2.find();
				for(ProtocolDocument r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<ProtocolDocument> q2 = db.query(ProtocolDocument.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<ProtocolDocument> results = q2.find();
				for(ProtocolDocument r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<ProtocolDocument> q2 = db.query(ProtocolDocument.class);
				q2.equals("name",entity.getName());
				List<ProtocolDocument> results = q2.find();
				for(ProtocolDocument r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<ProtocolDocument> q2 = db.query(ProtocolDocument.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<ProtocolDocument> results = q2.find();
				for(ProtocolDocument r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<ProtocolDocument> q2 = db.query(ProtocolDocument.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<ProtocolDocument> results = q2.find();
				for(ProtocolDocument r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Extension', type 'string'
			{
				Query<ProtocolDocument> q2 = db.query(ProtocolDocument.class);
				q2.equals("extension",entity.getExtension());
				List<ProtocolDocument> results = q2.find();
				for(ProtocolDocument r: results)
				{
					assertEquals(r.getExtension(),entity.getExtension());
				}
			}
			//test operator 'in' for field 'Extension'
			{
				Query<ProtocolDocument> q2 = db.query(ProtocolDocument.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getExtension());
				q2.in("extension", inList);
				List<ProtocolDocument> results = q2.find();
				for(ProtocolDocument r: results)
				{
					assertEquals(r.getExtension(),entity.getExtension());
				}
			}
			//test operator 'like' for field 'Extension'
			{
				Query<ProtocolDocument> q2 = db.query(ProtocolDocument.class);
				q2.like("extension", entity.getExtension() + "%");
				q2.sortASC("extension");
				List<ProtocolDocument> results = q2.find();
				for(ProtocolDocument r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getExtension(), entity.getExtension()));
				}
			}

			//test field 'protocol', type 'xref'
			{
				Query<ProtocolDocument> q2 = db.query(ProtocolDocument.class);
				q2.equals("protocol",entity.getProtocol_Id());
				List<ProtocolDocument> results = q2.find();
				for(ProtocolDocument r: results)
				{
					assertEquals(r.getProtocol_Id(), entity.getProtocol_Id());
				}
			}
			//test operator 'in' for field 'protocol'
			{
				Query<ProtocolDocument> q2 = db.query(ProtocolDocument.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocol_Id());
				q2.in("protocol", inList);
				List<ProtocolDocument> results = q2.find();
				for(ProtocolDocument r: results)
				{
					assertEquals(r.getProtocol_Id(), entity.getProtocol_Id());
				}
			}
			//test operator 'equals' for implicit join field 'protocol_name'
			{
				Query<ProtocolDocument> q2 = db.query(ProtocolDocument.class);
				q2.equals("protocol_name",entity.getProtocol_Name());
				List<ProtocolDocument> results = q2.find();
				for(ProtocolDocument r: results)
				{
					assertEquals(r.getProtocol_Id(), entity.getProtocol_Id());
				}
			}
			//test operator 'in' for implicit join field 'protocol_name'
			{
				Query<ProtocolDocument> q2 = db.query(ProtocolDocument.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocol_Name());
				q2.in("protocol_name", inList);
				q2.sortDESC("protocol_name");
				List<ProtocolDocument> results = q2.find();
				for(ProtocolDocument r: results)
				{
					assertEquals(r.getProtocol_Id(), entity.getProtocol_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testWorkflow","testProtocol"})
	public void testWorkflowElement() throws DatabaseException
	{
		//create entities
		List<WorkflowElement> entities = new ArrayList<WorkflowElement>();

		//retrieve xref entity candidates
		List<Workflow> workflowXrefs = db.query(Workflow.class).eq("__Type",Workflow.class.getSimpleName()).find();	
		List<Protocol> protocolXrefs = db.query(Protocol.class).find();	
		List<WorkflowElement> previousStepsXrefs = db.query(WorkflowElement.class).find();	

		for(Integer i = 0; i < total; i++)
		{
			WorkflowElement e = new WorkflowElement();
			e.setName(truncate("workflowelement_name_"+i, 127));
			if(workflowXrefs.size() > 0) e.setWorkflow_Id( workflowXrefs.get(i).getId() );
			if(protocolXrefs.size() > 0) e.setProtocol_Id( protocolXrefs.get(i).getId() );
			if(previousStepsXrefs.size() > 0)
			{
				e.getPreviousSteps_Id().add( previousStepsXrefs.get(i).getId() );
				//e.getPreviousSteps().add( random(previousStepsXrefs).getId() );
			}
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<WorkflowElement> q = db.query(WorkflowElement.class);
		assertEquals(total, q.count());
		List<WorkflowElement> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getName(), entitiesDb.get(i).getName());
			assertEquals(entities.get(i).getWorkflow_Id(), entitiesDb.get(i).getWorkflow_Id());
			assertEquals(entities.get(i).getProtocol_Id(), entitiesDb.get(i).getProtocol_Id());
			assertEquals(entities.get(i).getPreviousSteps_Id(), entitiesDb.get(i).getPreviousSteps_Id());
		}	
		
		//test the query capabilities by finding on all fields
		for(WorkflowElement entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<WorkflowElement> q2 = db.query(WorkflowElement.class);
				q2.equals("id",entity.getId());
				List<WorkflowElement> results = q2.find();
				for(WorkflowElement r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<WorkflowElement> q2 = db.query(WorkflowElement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<WorkflowElement> results = q2.find();
				for(WorkflowElement r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<WorkflowElement> q2 = db.query(WorkflowElement.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<WorkflowElement> results = q2.find();
				for(WorkflowElement r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<WorkflowElement> q2 = db.query(WorkflowElement.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<WorkflowElement> results = q2.find();
				for(WorkflowElement r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'name', type 'string'
			{
				Query<WorkflowElement> q2 = db.query(WorkflowElement.class);
				q2.equals("name",entity.getName());
				List<WorkflowElement> results = q2.find();
				for(WorkflowElement r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'in' for field 'name'
			{
				Query<WorkflowElement> q2 = db.query(WorkflowElement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getName());
				q2.in("name", inList);
				List<WorkflowElement> results = q2.find();
				for(WorkflowElement r: results)
				{
					assertEquals(r.getName(),entity.getName());
				}
			}
			//test operator 'like' for field 'name'
			{
				Query<WorkflowElement> q2 = db.query(WorkflowElement.class);
				q2.like("name", entity.getName() + "%");
				q2.sortASC("name");
				List<WorkflowElement> results = q2.find();
				for(WorkflowElement r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getName(), entity.getName()));
				}
			}

			//test field 'Workflow', type 'xref'
			{
				Query<WorkflowElement> q2 = db.query(WorkflowElement.class);
				q2.equals("workflow",entity.getWorkflow_Id());
				List<WorkflowElement> results = q2.find();
				for(WorkflowElement r: results)
				{
					assertEquals(r.getWorkflow_Id(), entity.getWorkflow_Id());
				}
			}
			//test operator 'in' for field 'Workflow'
			{
				Query<WorkflowElement> q2 = db.query(WorkflowElement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getWorkflow_Id());
				q2.in("workflow", inList);
				List<WorkflowElement> results = q2.find();
				for(WorkflowElement r: results)
				{
					assertEquals(r.getWorkflow_Id(), entity.getWorkflow_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Workflow_name'
			{
				Query<WorkflowElement> q2 = db.query(WorkflowElement.class);
				q2.equals("workflow_name",entity.getWorkflow_Name());
				List<WorkflowElement> results = q2.find();
				for(WorkflowElement r: results)
				{
					assertEquals(r.getWorkflow_Id(), entity.getWorkflow_Id());
				}
			}
			//test operator 'in' for implicit join field 'Workflow_name'
			{
				Query<WorkflowElement> q2 = db.query(WorkflowElement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getWorkflow_Name());
				q2.in("workflow_name", inList);
				q2.sortDESC("workflow_name");
				List<WorkflowElement> results = q2.find();
				for(WorkflowElement r: results)
				{
					assertEquals(r.getWorkflow_Id(), entity.getWorkflow_Id());
				}
			}

			//test field 'protocol', type 'xref'
			{
				Query<WorkflowElement> q2 = db.query(WorkflowElement.class);
				q2.equals("protocol",entity.getProtocol_Id());
				List<WorkflowElement> results = q2.find();
				for(WorkflowElement r: results)
				{
					assertEquals(r.getProtocol_Id(), entity.getProtocol_Id());
				}
			}
			//test operator 'in' for field 'protocol'
			{
				Query<WorkflowElement> q2 = db.query(WorkflowElement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocol_Id());
				q2.in("protocol", inList);
				List<WorkflowElement> results = q2.find();
				for(WorkflowElement r: results)
				{
					assertEquals(r.getProtocol_Id(), entity.getProtocol_Id());
				}
			}
			//test operator 'equals' for implicit join field 'protocol_name'
			{
				Query<WorkflowElement> q2 = db.query(WorkflowElement.class);
				q2.equals("protocol_name",entity.getProtocol_Name());
				List<WorkflowElement> results = q2.find();
				for(WorkflowElement r: results)
				{
					assertEquals(r.getProtocol_Id(), entity.getProtocol_Id());
				}
			}
			//test operator 'in' for implicit join field 'protocol_name'
			{
				Query<WorkflowElement> q2 = db.query(WorkflowElement.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getProtocol_Name());
				q2.in("protocol_name", inList);
				q2.sortDESC("protocol_name");
				List<WorkflowElement> results = q2.find();
				for(WorkflowElement r: results)
				{
					assertEquals(r.getProtocol_Id(), entity.getProtocol_Id());
				}
			}

		}
	}

	@Test(dependsOnMethods = {"testWorkflowElement","testObservableFeature"})
	public void testWorkflowElementParameter() throws DatabaseException
	{
		//create entities
		List<WorkflowElementParameter> entities = new ArrayList<WorkflowElementParameter>();

		//retrieve xref entity candidates
		List<WorkflowElement> workflowElementXrefs = db.query(WorkflowElement.class).find();	
		List<ObservableFeature> parameterXrefs = db.query(ObservableFeature.class).eq("__Type",ObservableFeature.class.getSimpleName()).find();	

		for(Integer i = 0; i < total; i++)
		{
			WorkflowElementParameter e = new WorkflowElementParameter();
			if(workflowElementXrefs.size() > 0) e.setWorkflowElement_Id( workflowElementXrefs.get(i).getId() );
			if(parameterXrefs.size() > 0) e.setParameter_Id( parameterXrefs.get(i).getId() );
			e.setValue(truncate("workflowelementparameter_value_"+i, 255));
				
			entities.add(e);
		}

			
		//add entities and check counts
		db.add(entities);
		Query<WorkflowElementParameter> q = db.query(WorkflowElementParameter.class);
		assertEquals(total, q.count());
		List<WorkflowElementParameter> entitiesDb = q.sortASC("id").find();
		assertEquals(total, entitiesDb.size());
		//compare entities against insert (assumes sorting by id)
		for(int i = 0; i < total; i++)
		{
			assertNotNull(entities.get(i).getId());
			assertEquals(entities.get(i).getWorkflowElement_Id(), entitiesDb.get(i).getWorkflowElement_Id());
			assertEquals(entities.get(i).getParameter_Id(), entitiesDb.get(i).getParameter_Id());
			assertEquals(entities.get(i).getValue(), entitiesDb.get(i).getValue());
		}	
		
		//test the query capabilities by finding on all fields
		for(WorkflowElementParameter entity: entitiesDb)
		{
			//test field 'id', type 'int'
			{
				Query<WorkflowElementParameter> q2 = db.query(WorkflowElementParameter.class);
				q2.equals("id",entity.getId());
				List<WorkflowElementParameter> results = q2.find();
				assertEquals(results.size(),1);
				for(WorkflowElementParameter r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'in' for field 'id'
			{
				Query<WorkflowElementParameter> q2 = db.query(WorkflowElementParameter.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getId());
				q2.in("id", inList);
				List<WorkflowElementParameter> results = q2.find();
				assertEquals(results.size(),1);
				for(WorkflowElementParameter r: results)
				{
					assertEquals(r.getId(),entity.getId());
				}
			}
			//test operator 'lessOrEqual' for field 'id'
			{
				Query<WorkflowElementParameter> q2 = db.query(WorkflowElementParameter.class);
				q2.lessOrEqual("id", entity.getId());
				q2.sortASC("id");
				List<WorkflowElementParameter> results = q2.find();
				for(WorkflowElementParameter r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) < 1);
				}
			}
			//test operator 'greaterOrEqual' for field 'id'
			{
				Query<WorkflowElementParameter> q2 = db.query(WorkflowElementParameter.class);
				q2.greaterOrEqual("id", entity.getId());
				q2.sortDESC("id");
				List<WorkflowElementParameter> results = q2.find();
				for(WorkflowElementParameter r: results)
				{
					assertTrue(r.getId().compareTo(entity.getId()) > -1);
				}
			}

			//test field 'WorkflowElement', type 'xref'
			{
				Query<WorkflowElementParameter> q2 = db.query(WorkflowElementParameter.class);
				q2.equals("workflowElement",entity.getWorkflowElement_Id());
				List<WorkflowElementParameter> results = q2.find();
				for(WorkflowElementParameter r: results)
				{
					assertEquals(r.getWorkflowElement_Id(), entity.getWorkflowElement_Id());
				}
			}
			//test operator 'in' for field 'WorkflowElement'
			{
				Query<WorkflowElementParameter> q2 = db.query(WorkflowElementParameter.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getWorkflowElement_Id());
				q2.in("workflowElement", inList);
				List<WorkflowElementParameter> results = q2.find();
				for(WorkflowElementParameter r: results)
				{
					assertEquals(r.getWorkflowElement_Id(), entity.getWorkflowElement_Id());
				}
			}
			//test operator 'equals' for implicit join field 'WorkflowElement_name'
			{
				Query<WorkflowElementParameter> q2 = db.query(WorkflowElementParameter.class);
				q2.equals("workflowElement_name",entity.getWorkflowElement_Name());
				List<WorkflowElementParameter> results = q2.find();
				for(WorkflowElementParameter r: results)
				{
					assertEquals(r.getWorkflowElement_Id(), entity.getWorkflowElement_Id());
				}
			}
			//test operator 'in' for implicit join field 'WorkflowElement_name'
			{
				Query<WorkflowElementParameter> q2 = db.query(WorkflowElementParameter.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getWorkflowElement_Name());
				q2.in("workflowElement_name", inList);
				q2.sortDESC("workflowElement_name");
				List<WorkflowElementParameter> results = q2.find();
				for(WorkflowElementParameter r: results)
				{
					assertEquals(r.getWorkflowElement_Id(), entity.getWorkflowElement_Id());
				}
			}

			//test field 'Parameter', type 'xref'
			{
				Query<WorkflowElementParameter> q2 = db.query(WorkflowElementParameter.class);
				q2.equals("parameter",entity.getParameter_Id());
				List<WorkflowElementParameter> results = q2.find();
				for(WorkflowElementParameter r: results)
				{
					assertEquals(r.getParameter_Id(), entity.getParameter_Id());
				}
			}
			//test operator 'in' for field 'Parameter'
			{
				Query<WorkflowElementParameter> q2 = db.query(WorkflowElementParameter.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getParameter_Id());
				q2.in("parameter", inList);
				List<WorkflowElementParameter> results = q2.find();
				for(WorkflowElementParameter r: results)
				{
					assertEquals(r.getParameter_Id(), entity.getParameter_Id());
				}
			}
			//test operator 'equals' for implicit join field 'Parameter_name'
			{
				Query<WorkflowElementParameter> q2 = db.query(WorkflowElementParameter.class);
				q2.equals("parameter_name",entity.getParameter_Name());
				List<WorkflowElementParameter> results = q2.find();
				for(WorkflowElementParameter r: results)
				{
					assertEquals(r.getParameter_Id(), entity.getParameter_Id());
				}
			}
			//test operator 'in' for implicit join field 'Parameter_name'
			{
				Query<WorkflowElementParameter> q2 = db.query(WorkflowElementParameter.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getParameter_Name());
				q2.in("parameter_name", inList);
				q2.sortDESC("parameter_name");
				List<WorkflowElementParameter> results = q2.find();
				for(WorkflowElementParameter r: results)
				{
					assertEquals(r.getParameter_Id(), entity.getParameter_Id());
				}
			}

			//test field 'Value', type 'string'
			{
				Query<WorkflowElementParameter> q2 = db.query(WorkflowElementParameter.class);
				q2.equals("value",entity.getValue());
				List<WorkflowElementParameter> results = q2.find();
				for(WorkflowElementParameter r: results)
				{
					assertEquals(r.getValue(),entity.getValue());
				}
			}
			//test operator 'in' for field 'Value'
			{
				Query<WorkflowElementParameter> q2 = db.query(WorkflowElementParameter.class);
				java.util.List<Object> inList = new ArrayList<Object>();
				inList.add(entity.getValue());
				q2.in("value", inList);
				List<WorkflowElementParameter> results = q2.find();
				for(WorkflowElementParameter r: results)
				{
					assertEquals(r.getValue(),entity.getValue());
				}
			}
			//test operator 'like' for field 'Value'
			{
				Query<WorkflowElementParameter> q2 = db.query(WorkflowElementParameter.class);
				q2.like("value", entity.getValue() + "%");
				q2.sortASC("value");
				List<WorkflowElementParameter> results = q2.find();
				for(WorkflowElementParameter r: results)
				{
					assertTrue(org.apache.commons.lang.StringUtils.startsWith(r.getValue(), entity.getValue()));
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
				assertEquals(results.size(),1);
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
				assertEquals(results.size(),1);
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
				assertEquals(results.size(),1);
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