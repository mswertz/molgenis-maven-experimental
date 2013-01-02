
/* Date:        October 22, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvImportGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package app;

import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.Database.DatabaseAction;
import org.molgenis.framework.db.DatabaseException;
//import org.molgenis.framework.db.QueryRule;
//import org.molgenis.framework.db.QueryRule.Operator;
import org.molgenis.util.Tuple;
//import org.molgenis.util.*;
//import org.molgenis.util.CsvFileReader;
//import org.molgenis.util.CsvReaderListener;
//import org.molgenis.util.SimpleTuple;

import org.molgenis.framework.db.CsvToDatabase.ImportResult;

import org.molgenis.auth.csv.MolgenisRoleCsvReader;
import org.molgenis.auth.csv.MolgenisGroupCsvReader;
import org.molgenis.auth.csv.MolgenisRoleGroupLinkCsvReader;
import org.molgenis.auth.csv.PersonCsvReader;
import org.molgenis.auth.csv.InstituteCsvReader;
import org.molgenis.auth.csv.MolgenisUserCsvReader;
import org.molgenis.auth.csv.MolgenisPermissionCsvReader;
import org.molgenis.core.csv.OntologyTermCsvReader;
import org.molgenis.core.csv.OntologyCsvReader;
import org.molgenis.core.csv.MolgenisFileCsvReader;
import org.molgenis.core.csv.RuntimePropertyCsvReader;
import org.molgenis.core.csv.PublicationCsvReader;
import org.molgenis.core.csv.UseCaseCsvReader;
import org.molgenis.core.csv.MolgenisEntityCsvReader;

public class CsvImport
{
	static int BATCH_SIZE = 10000;
	static int SMALL_BATCH_SIZE = 2500;
	static Logger logger = Logger.getLogger(CsvImport.class.getSimpleName());
	
	/**wrapper to use int inside anonymous classes (requires final, so cannot update directly)*/
	//FIXME move to value type elsewhere?
	public static class IntegerWrapper
	{
		private int value;
		
		public IntegerWrapper(int value)
		{
			this.value = value;
		}
		public void set(int value)
		{
			this.value = value;
		}
		public int get()
		{
			return this.value;
		}
	}
	
	public static ImportResult importAll(File directory, Database db, Tuple defaults) throws Exception
	{
		return importAll(directory, db, defaults, true);
	}
	
	public static ImportResult importAll(File directory, Database db, Tuple defaults, List<String> components, DatabaseAction dbAction, String missingValue) throws Exception
	{
		return importAll(directory, db, defaults, components, dbAction, missingValue, true);
	}
	
	public static ImportResult importAll(File directory, Database db, Tuple defaults, boolean useDbTransaction) throws Exception
	{
		//set default missing value to ""
		return importAll(directory, db, defaults, null, DatabaseAction.ADD, "", useDbTransaction);
	}

	/**
	 * Csv import of whole database.
	 * TODO: add filter parameters...
	 */
	public static ImportResult importAll(File directory, Database db, Tuple defaults, List<String> components, DatabaseAction dbAction, String missingValue, boolean useDbTransaction) throws Exception
	{
		ImportResult result = new ImportResult();
		boolean alreadyInTx = false;
		try
		{
			if (useDbTransaction)
			{
				if (!db.inTx())
				{
					db.beginTx();
				}else{
					alreadyInTx = true; 
					//throw new DatabaseException("Cannot continue CsvImport: database already in transaction.");
				}
			}
						
			if(dbAction.toString().startsWith("REMOVE"))
			{
				//reverse xref dependency order for remove
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenispermission")))
				{
					try {
						int count = new MolgenisPermissionCsvReader().importCsv(db, new File(directory+"/molgenispermission.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("molgenispermission");
						result.getMessages().put("molgenispermission", "evaluated "+count+" molgenispermission elements");
					} catch (Exception e) {
						result.setErrorItem("molgenispermission");
						result.getMessages().put("molgenispermission", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisentity")))
				{
					try {
						int count = new MolgenisEntityCsvReader().importCsv(db, new File(directory+"/molgenisentity.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("molgenisentity");
						result.getMessages().put("molgenisentity", "evaluated "+count+" molgenisentity elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisentity");
						result.getMessages().put("molgenisentity", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("usecase")))
				{
					try {
						int count = new UseCaseCsvReader().importCsv(db, new File(directory+"/usecase.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("usecase");
						result.getMessages().put("usecase", "evaluated "+count+" usecase elements");
					} catch (Exception e) {
						result.setErrorItem("usecase");
						result.getMessages().put("usecase", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("publication")))
				{
					try {
						int count = new PublicationCsvReader().importCsv(db, new File(directory+"/publication.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("publication");
						result.getMessages().put("publication", "evaluated "+count+" publication elements");
					} catch (Exception e) {
						result.setErrorItem("publication");
						result.getMessages().put("publication", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("runtimeproperty")))
				{
					try {
						int count = new RuntimePropertyCsvReader().importCsv(db, new File(directory+"/runtimeproperty.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("runtimeproperty");
						result.getMessages().put("runtimeproperty", "evaluated "+count+" runtimeproperty elements");
					} catch (Exception e) {
						result.setErrorItem("runtimeproperty");
						result.getMessages().put("runtimeproperty", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisfile")))
				{
					try {
						int count = new MolgenisFileCsvReader().importCsv(db, new File(directory+"/molgenisfile.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("molgenisfile");
						result.getMessages().put("molgenisfile", "evaluated "+count+" molgenisfile elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisfile");
						result.getMessages().put("molgenisfile", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisrolegrouplink")))
				{
					try {
						int count = new MolgenisRoleGroupLinkCsvReader().importCsv(db, new File(directory+"/molgenisrolegrouplink.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("molgenisrolegrouplink");
						result.getMessages().put("molgenisrolegrouplink", "evaluated "+count+" molgenisrolegrouplink elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisrolegrouplink");
						result.getMessages().put("molgenisrolegrouplink", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisuser")))
				{
					try {
						int count = new MolgenisUserCsvReader().importCsv(db, new File(directory+"/molgenisuser.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("molgenisuser");
						result.getMessages().put("molgenisuser", "evaluated "+count+" molgenisuser elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisuser");
						result.getMessages().put("molgenisuser", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("person")))
				{
					try {
						int count = new PersonCsvReader().importCsv(db, new File(directory+"/person.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("person");
						result.getMessages().put("person", "evaluated "+count+" person elements");
					} catch (Exception e) {
						result.setErrorItem("person");
						result.getMessages().put("person", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("ontologyterm")))
				{
					try {
						int count = new OntologyTermCsvReader().importCsv(db, new File(directory+"/ontologyterm.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("ontologyterm");
						result.getMessages().put("ontologyterm", "evaluated "+count+" ontologyterm elements");
					} catch (Exception e) {
						result.setErrorItem("ontologyterm");
						result.getMessages().put("ontologyterm", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("ontology")))
				{
					try {
						int count = new OntologyCsvReader().importCsv(db, new File(directory+"/ontology.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("ontology");
						result.getMessages().put("ontology", "evaluated "+count+" ontology elements");
					} catch (Exception e) {
						result.setErrorItem("ontology");
						result.getMessages().put("ontology", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("institute")))
				{
					try {
						int count = new InstituteCsvReader().importCsv(db, new File(directory+"/institute.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("institute");
						result.getMessages().put("institute", "evaluated "+count+" institute elements");
					} catch (Exception e) {
						result.setErrorItem("institute");
						result.getMessages().put("institute", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisgroup")))
				{
					try {
						int count = new MolgenisGroupCsvReader().importCsv(db, new File(directory+"/molgenisgroup.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("molgenisgroup");
						result.getMessages().put("molgenisgroup", "evaluated "+count+" molgenisgroup elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisgroup");
						result.getMessages().put("molgenisgroup", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisrole")))
				{
					try {
						int count = new MolgenisRoleCsvReader().importCsv(db, new File(directory+"/molgenisrole.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("molgenisrole");
						result.getMessages().put("molgenisrole", "evaluated "+count+" molgenisrole elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisrole");
						result.getMessages().put("molgenisrole", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
			}
			else
			{
				//follow xref dependency order
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisrole")))
				{
					try {
						int count = new MolgenisRoleCsvReader().importCsv(db, new File(directory+"/molgenisrole.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("molgenisrole");
						result.getMessages().put("molgenisrole",  "evaluated "+count+" molgenisrole elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisrole");
						result.getMessages().put("molgenisrole", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisgroup")))
				{
					try {
						int count = new MolgenisGroupCsvReader().importCsv(db, new File(directory+"/molgenisgroup.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("molgenisgroup");
						result.getMessages().put("molgenisgroup",  "evaluated "+count+" molgenisgroup elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisgroup");
						result.getMessages().put("molgenisgroup", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("institute")))
				{
					try {
						int count = new InstituteCsvReader().importCsv(db, new File(directory+"/institute.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("institute");
						result.getMessages().put("institute",  "evaluated "+count+" institute elements");
					} catch (Exception e) {
						result.setErrorItem("institute");
						result.getMessages().put("institute", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("ontology")))
				{
					try {
						int count = new OntologyCsvReader().importCsv(db, new File(directory+"/ontology.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("ontology");
						result.getMessages().put("ontology",  "evaluated "+count+" ontology elements");
					} catch (Exception e) {
						result.setErrorItem("ontology");
						result.getMessages().put("ontology", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("ontologyterm")))
				{
					try {
						int count = new OntologyTermCsvReader().importCsv(db, new File(directory+"/ontologyterm.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("ontologyterm");
						result.getMessages().put("ontologyterm",  "evaluated "+count+" ontologyterm elements");
					} catch (Exception e) {
						result.setErrorItem("ontologyterm");
						result.getMessages().put("ontologyterm", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("person")))
				{
					try {
						int count = new PersonCsvReader().importCsv(db, new File(directory+"/person.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("person");
						result.getMessages().put("person",  "evaluated "+count+" person elements");
					} catch (Exception e) {
						result.setErrorItem("person");
						result.getMessages().put("person", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisuser")))
				{
					try {
						int count = new MolgenisUserCsvReader().importCsv(db, new File(directory+"/molgenisuser.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("molgenisuser");
						result.getMessages().put("molgenisuser",  "evaluated "+count+" molgenisuser elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisuser");
						result.getMessages().put("molgenisuser", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisrolegrouplink")))
				{
					try {
						int count = new MolgenisRoleGroupLinkCsvReader().importCsv(db, new File(directory+"/molgenisrolegrouplink.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("molgenisrolegrouplink");
						result.getMessages().put("molgenisrolegrouplink",  "evaluated "+count+" molgenisrolegrouplink elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisrolegrouplink");
						result.getMessages().put("molgenisrolegrouplink", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisfile")))
				{
					try {
						int count = new MolgenisFileCsvReader().importCsv(db, new File(directory+"/molgenisfile.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("molgenisfile");
						result.getMessages().put("molgenisfile",  "evaluated "+count+" molgenisfile elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisfile");
						result.getMessages().put("molgenisfile", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("runtimeproperty")))
				{
					try {
						int count = new RuntimePropertyCsvReader().importCsv(db, new File(directory+"/runtimeproperty.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("runtimeproperty");
						result.getMessages().put("runtimeproperty",  "evaluated "+count+" runtimeproperty elements");
					} catch (Exception e) {
						result.setErrorItem("runtimeproperty");
						result.getMessages().put("runtimeproperty", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("publication")))
				{
					try {
						int count = new PublicationCsvReader().importCsv(db, new File(directory+"/publication.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("publication");
						result.getMessages().put("publication",  "evaluated "+count+" publication elements");
					} catch (Exception e) {
						result.setErrorItem("publication");
						result.getMessages().put("publication", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("usecase")))
				{
					try {
						int count = new UseCaseCsvReader().importCsv(db, new File(directory+"/usecase.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("usecase");
						result.getMessages().put("usecase",  "evaluated "+count+" usecase elements");
					} catch (Exception e) {
						result.setErrorItem("usecase");
						result.getMessages().put("usecase", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenisentity")))
				{
					try {
						int count = new MolgenisEntityCsvReader().importCsv(db, new File(directory+"/molgenisentity.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("molgenisentity");
						result.getMessages().put("molgenisentity",  "evaluated "+count+" molgenisentity elements");
					} catch (Exception e) {
						result.setErrorItem("molgenisentity");
						result.getMessages().put("molgenisentity", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenispermission")))
				{
					try {
						int count = new MolgenisPermissionCsvReader().importCsv(db, new File(directory+"/molgenispermission.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("molgenispermission");
						result.getMessages().put("molgenispermission",  "evaluated "+count+" molgenispermission elements");
					} catch (Exception e) {
						result.setErrorItem("molgenispermission");
						result.getMessages().put("molgenispermission", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
			}			
			
			if (useDbTransaction &! alreadyInTx)
			{
				logger.debug("commiting transactions...");
				if (db.inTx()){
					db.commitTx();
				}else{
					throw new DatabaseException("Cannot commit CsvImport: database not in transaction.");
				}
			}
		}
		catch (Exception e)
		{
			logger.error("Import failed: " + e.getMessage());
			if (useDbTransaction &! alreadyInTx)
			{
				if (db.inTx()){
					logger.debug("Db in transaction, rolling back...");
					db.rollbackTx();
				}else{
					logger.debug("Db not in transaction");
				}
			}
			e.printStackTrace();
			
			//Don't throw to avoid 'try-catch' on usage. No harm done.
			//throw e;
		}
		return result;
	}
}