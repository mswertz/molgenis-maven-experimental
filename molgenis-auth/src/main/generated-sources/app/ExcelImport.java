
/* Date:        October 22, 2012
 * 
 * generator:   org.molgenis.generators.excel.ExcelImportGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package app;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jxl.Workbook;

import org.apache.log4j.Logger;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.CsvToDatabase.ImportResult;
import org.molgenis.framework.db.Database.DatabaseAction;
import org.molgenis.util.Tuple;

import org.molgenis.auth.excel.MolgenisRoleExcelReader;
import org.molgenis.auth.excel.MolgenisGroupExcelReader;
import org.molgenis.auth.excel.MolgenisRoleGroupLinkExcelReader;
import org.molgenis.auth.excel.PersonExcelReader;
import org.molgenis.auth.excel.InstituteExcelReader;
import org.molgenis.auth.excel.MolgenisUserExcelReader;
import org.molgenis.auth.excel.MolgenisPermissionExcelReader;
import org.molgenis.core.excel.OntologyTermExcelReader;
import org.molgenis.core.excel.OntologyExcelReader;
import org.molgenis.core.excel.MolgenisFileExcelReader;
import org.molgenis.core.excel.RuntimePropertyExcelReader;
import org.molgenis.core.excel.PublicationExcelReader;
import org.molgenis.core.excel.UseCaseExcelReader;
import org.molgenis.core.excel.MolgenisEntityExcelReader;

public class ExcelImport
{
	static Logger logger = Logger.getLogger(ExcelImport.class.getSimpleName());
	
	public static void importAll(File excelFile, Database db, Tuple defaults) throws Exception
	{
		importAll(excelFile, db, defaults, null, DatabaseAction.ADD, "", true);
	}
	
	public static ImportResult importAll(File excelFile, Database db, Tuple defaults, List<String> components, DatabaseAction dbAction, String missingValue) throws Exception
	{
		return importAll(excelFile, db, defaults, components, dbAction, missingValue, true);
	}
	
	public static void importAll(File excelFile, Database db, Tuple defaults, boolean useDbTransaction) throws Exception
	{
		//set default missing value to ""
		importAll(excelFile, db, defaults, null, DatabaseAction.ADD, "", useDbTransaction);
	}

	public static ImportResult importAll(File excelFile, Database db, Tuple defaults, List<String> components, DatabaseAction dbAction, String missingValue, boolean useDbTransaction) throws Exception
	{
		//fixes the problem where, even though decimals have a "." they are still read as "," because of the locale!
		//TODO: dangerous: entire application locale changes! but workbook locale settings don't seem to have an effect...
		Locale saveTheDefault = Locale.getDefault();
		Locale.setDefault(Locale.US);
		
		Workbook workbook = Workbook.getWorkbook(excelFile);
		ArrayList<String> sheetNames = new ArrayList<String>();
		for(String sheetName : workbook.getSheetNames()){
			sheetNames.add(sheetName.toLowerCase());
		}
		
		ImportResult result = new ImportResult();

		try
		{
			if (useDbTransaction)
			{
				if (!db.inTx())
				{
					db.beginTx();
				}
				else
				{
					throw new DatabaseException("Cannot continue ExcelImport: database already in transaction.");
				}
			}
						
			if(dbAction.toString().startsWith("REMOVE"))
			{
				//reverse xref dependency order for remove
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("molgenispermission")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("molgenispermission")){
							count = new MolgenisPermissionExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenispermission")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("molgenisentity")){
							count = new MolgenisEntityExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisentity")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("usecase")){
							count = new UseCaseExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("usecase")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("publication")){
							count = new PublicationExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("publication")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("runtimeproperty")){
							count = new RuntimePropertyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("runtimeproperty")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("molgenisfile")){
							count = new MolgenisFileExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisfile")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("molgenisrolegrouplink")){
							count = new MolgenisRoleGroupLinkExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisrolegrouplink")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("molgenisuser")){
							count = new MolgenisUserExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisuser")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("person")){
							count = new PersonExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("person")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("ontologyterm")){
							count = new OntologyTermExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("ontologyterm")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("ontology")){
							count = new OntologyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("ontology")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("institute")){
							count = new InstituteExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("institute")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("molgenisgroup")){
							count = new MolgenisGroupExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisgroup")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("molgenisrole")){
							count = new MolgenisRoleExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisrole")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("molgenisrole")){
							count = new MolgenisRoleExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisrole")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("molgenisgroup")){
							count = new MolgenisGroupExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisgroup")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("institute")){
							count = new InstituteExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("institute")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("ontology")){
							count = new OntologyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("ontology")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("ontologyterm")){
							count = new OntologyTermExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("ontologyterm")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("person")){
							count = new PersonExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("person")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("molgenisuser")){
							count = new MolgenisUserExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisuser")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("molgenisrolegrouplink")){
							count = new MolgenisRoleGroupLinkExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisrolegrouplink")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("molgenisfile")){
							count = new MolgenisFileExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisfile")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("runtimeproperty")){
							count = new RuntimePropertyExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("runtimeproperty")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("publication")){
							count = new PublicationExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("publication")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("usecase")){
							count = new UseCaseExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("usecase")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("molgenisentity")){
							count = new MolgenisEntityExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenisentity")), defaults, dbAction, missingValue);
						}
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
						int count = 0;
						if(sheetNames.contains("molgenispermission")){
							count = new MolgenisPermissionExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("molgenispermission")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("molgenispermission");
						result.getMessages().put("molgenispermission",  "evaluated "+count+" molgenispermission elements");
					} catch (Exception e) {
						result.setErrorItem("molgenispermission");
						result.getMessages().put("molgenispermission", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
			}			
			
			if (useDbTransaction)
			{
				logger.debug("commiting transactions...");
				if (db.inTx()){
					db.commitTx();
				}else{
					throw new DatabaseException("Cannot commit ExcelImport: database not in transaction.");
				}
			}
		}
		catch (Exception e)
		{
			logger.error("Import failed: " + e.getMessage());
			if (useDbTransaction)
			{
				if (db.inTx()){
					logger.debug("Db in transaction, rolling back...");
					db.rollbackTx();
				}else{
					logger.debug("Db not in transaction");
				}
			}
			throw e;
		}finally{
			//restore the locale settings (important!)
			Locale.setDefault(saveTheDefault);
			workbook.close();
		}
		return result;
	}
}