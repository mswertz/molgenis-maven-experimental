/* File:        app/JUnitTest.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
 * 
 * generator:   org.molgenis.generators.tests.TestCsvGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package test;

import app.CsvExport;
import app.CsvImport;
import app.DatabaseFactory;

import app.JDBCDatabase;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Arrays;

import org.apache.log4j.Logger;

import org.molgenis.Molgenis;
import org.molgenis.util.*;
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

/**
 * This procecure tests file import and export
 * - create csv set1 in tmp
 * - TEST load set1 via CsvImport (should be error free)
 * - export it to set2 via CsvExport
 * - query all of set1 into memory (as lists)
 * - empty the database
 * - import set2 via CsvImport
 * - query all of set2 into memory (as lists)
 * - TEST set1 and set2 should be 'Set' equivalent 
 * - export it to set3 via CsvExport
 * - TEST files of set2 and set3 to be identical on disk
 */
public class TestCsv
{
	private static int total = 10;
	private static Database db;
	public static final transient Logger logger = Logger.getLogger(TestCsv.class);
	DateFormat dateFormat = new SimpleDateFormat(SimpleTuple.DATEFORMAT, Locale.US);
	DateFormat dateTimeFormat = new SimpleDateFormat(SimpleTuple.DATETIMEFORMAT, Locale.US);	 

	
	@BeforeTest
	public static void oneTimeSetUp()   
	{
		try
		{
        		
			db = DatabaseFactory.createTest("/Users/mswertz/Documents/MavenWorkspace/molgenis-project/molgenis-auth/src/main/resources/auth_molgenis.properties");
			new Molgenis("/Users/mswertz/Documents/MavenWorkspace/molgenis-project/molgenis-auth/src/main/resources/auth_molgenis.properties");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		logger.info("Database created");
	}

	@AfterTest
	public static void destory() {
            
	}
	
	@Test
	public void testCsv1()  throws Exception
	{	
		//create tem working directory
		File dir = File.createTempFile("molgenis","");		
		dir.delete(); //delete the file, need dir
		
		//create a test set1
        TestDataSet set1 = new TestDataSet(50,5);
                



		//export set1 from memory to dir1
		File dir1 = new File(dir + "/dir1");
		dir1.mkdirs();
		new CsvExport().exportAll(dir1, set1.molgenisRole,set1.molgenisGroup,set1.molgenisRoleGroupLink,set1.contact,set1.person,set1.institute,set1.molgenisUser,set1.molgenisPermission,set1.authorizable,set1.identifiable,set1.nameable,set1.describable,set1.ontologyTerm,set1.ontology,set1.molgenisFile,set1.runtimeProperty,set1.publication,set1.useCase,set1.molgenisEntity);
	
		//import dir1 into database
		new CsvImport().importAll(dir1, db, null);
		
		//copy database into memory as set2
		TestDataSet set2 = copyDb(db);
		
		//TODO compare set1 and set2 except automatic fields
		
		//export set1 from database to dir2
		File dir2 = new File(dir + "/dir2");
		dir2.mkdirs();
		new CsvExport().exportAll(dir2,db);
	
		//clean database
			new Molgenis("/Users/mswertz/Documents/MavenWorkspace/molgenis-project/molgenis-auth/src/main/resources/auth_molgenis.properties").updateDb();
		
		//import dir2 into database
		new CsvImport().importAll(dir2, db, null);
		
		//copy database into memory as set3
		TestDataSet set3 = copyDb(db);

		//TODO compare set2 and set3			
		
		//export database to dir3
		File dir3 = new File(dir + "/dir3");
		dir3.mkdirs();
		new CsvExport().exportAll(dir3,db);
		
		//clean database
			new Molgenis("/Users/mswertz/Documents/MavenWorkspace/molgenis-project/molgenis-auth/src/main/resources/auth_molgenis.properties").updateDb();
		
		//import dir3 into database
		new CsvImport().importAll(dir3, db, null);
		
		//copy database into memory as set4
		TestDataSet set4 = copyDb(db);

		//TODO compare set3 and set4			
		
		//export database to dir4
		File dir4 = new File(dir + "/dir4");
		dir4.mkdirs();
		new CsvExport().exportAll(dir4,db);
		
		//compare dir3 and dir4 cause should be equals because roundtrip
		logger.debug("Comparing "+dir3+" to "+dir4);
//		assertTrue(compareDirs(dir3,dir4));
//		assertEquals(set3,set4);
	}
	
	private TestDataSet copyDb(Database db) throws DatabaseException
	{
		TestDataSet copy = new TestDataSet();
		copy.molgenisRole = db.find(MolgenisRole.class);
		copy.molgenisGroup = db.find(MolgenisGroup.class);
		copy.molgenisRoleGroupLink = db.find(MolgenisRoleGroupLink.class);
		copy.person = db.find(Person.class);
		copy.institute = db.find(Institute.class);
		copy.molgenisUser = db.find(MolgenisUser.class);
		copy.molgenisPermission = db.find(MolgenisPermission.class);
		copy.ontologyTerm = db.find(OntologyTerm.class);
		copy.ontology = db.find(Ontology.class);
		copy.molgenisFile = db.find(MolgenisFile.class);
		copy.runtimeProperty = db.find(RuntimeProperty.class);
		copy.publication = db.find(Publication.class);
		copy.useCase = db.find(UseCase.class);
		copy.molgenisEntity = db.find(MolgenisEntity.class);
		return copy;	
	}
	
	private boolean compareDirs(File dir1, File dir2) throws IOException
	{
		if(dir1.listFiles().length != dir2.listFiles().length) {
			logger.error(String.format("Difference amount of files in between %s and %s",dir1.getName(), dir2.getName()));
			return false;
		}
		if(!Arrays.equals(dir1.list(), dir2.list())) {
			logger.error(String.format("Difference files in %s and %s",dir1.getName(), dir2.getName()));
			return false;
		}
		
		
		
		String errorMessage = "";
		for(File f: dir1.listFiles())
		{
			File f2 = new File(dir2.getAbsolutePath()+File.separator+f.getName());
			boolean result = CompareCSV.compareCSVFilesByContent(f, f2, errorMessage);
			if(!result) {
				logger.error("Difference between "+f+" and "+f2 + "\t" + errorMessage);
				return false;
			}
		}
		return true;
	}
	
    public static void main(String[] args) throws Exception
    {
        oneTimeSetUp();
	new TestCsv().testCsv1();
        destory();
    }
}