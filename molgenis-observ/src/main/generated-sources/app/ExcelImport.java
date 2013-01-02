
/* Date:        October 11, 2012
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

import org.molgenis.pheno.excel.SpeciesExcelReader;
import org.molgenis.pheno.excel.AlternateIdExcelReader;
import org.molgenis.pheno.excel.ObservationElementExcelReader;
import org.molgenis.pheno.excel.ObservationTargetExcelReader;
import org.molgenis.pheno.excel.ObservableFeatureExcelReader;
import org.molgenis.pheno.excel.MeasurementExcelReader;
import org.molgenis.pheno.excel.CategoryExcelReader;
import org.molgenis.pheno.excel.IndividualExcelReader;
import org.molgenis.pheno.excel.LocationExcelReader;
import org.molgenis.pheno.excel.PanelExcelReader;
import org.molgenis.pheno.excel.ObservedValueExcelReader;
import org.molgenis.organization.excel.InvestigationExcelReader;
import org.molgenis.core.excel.OntologyTermExcelReader;
import org.molgenis.core.excel.OntologyExcelReader;
import org.molgenis.core.excel.MolgenisFileExcelReader;
import org.molgenis.core.excel.RuntimePropertyExcelReader;
import org.molgenis.core.excel.PublicationExcelReader;
import org.molgenis.core.excel.UseCaseExcelReader;
import org.molgenis.core.excel.MolgenisEntityExcelReader;
import org.molgenis.protocol.excel.ProtocolExcelReader;
import org.molgenis.protocol.excel.ProtocolApplicationExcelReader;
import org.molgenis.protocol.excel.ProtocolDocumentExcelReader;
import org.molgenis.protocol.excel.WorkflowExcelReader;
import org.molgenis.protocol.excel.WorkflowElementExcelReader;
import org.molgenis.protocol.excel.WorkflowElementParameterExcelReader;
import org.molgenis.auth.excel.MolgenisRoleExcelReader;
import org.molgenis.auth.excel.MolgenisGroupExcelReader;
import org.molgenis.auth.excel.MolgenisRoleGroupLinkExcelReader;
import org.molgenis.auth.excel.PersonExcelReader;
import org.molgenis.auth.excel.InstituteExcelReader;
import org.molgenis.auth.excel.MolgenisUserExcelReader;
import org.molgenis.auth.excel.MolgenisPermissionExcelReader;
import org.molgenis.pheno.excel.ObservationElement_Ontolo12449ExcelReader;
import org.molgenis.pheno.excel.ObservationElement_AlternateIdExcelReader;
import org.molgenis.pheno.excel.Measurement_CategoriesExcelReader;
import org.molgenis.pheno.excel.Panel_IndividualsExcelReader;
import org.molgenis.pheno.excel.Panel_FounderPanelsExcelReader;
import org.molgenis.organization.excel.Investigation_ContactsExcelReader;
import org.molgenis.protocol.excel.Protocol_OntologyReferenceExcelReader;
import org.molgenis.protocol.excel.Protocol_FeaturesExcelReader;
import org.molgenis.protocol.excel.Protocol_SubprotocolsExcelReader;
import org.molgenis.protocol.excel.ProtocolApplication_Ontol11768ExcelReader;
import org.molgenis.protocol.excel.ProtocolApplication_PerformerExcelReader;
import org.molgenis.protocol.excel.WorkflowElement_PreviousStepsExcelReader;

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
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("workflowelement_previoussteps")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("workflowelement_previoussteps")){
							count = new WorkflowElement_PreviousStepsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("workflowelement_previoussteps")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("workflowelement_previoussteps");
						result.getMessages().put("workflowelement_previoussteps", "evaluated "+count+" workflowelement_previoussteps elements");
					} catch (Exception e) {
						result.setErrorItem("workflowelement_previoussteps");
						result.getMessages().put("workflowelement_previoussteps", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocolapplication_performer")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocolapplication_performer")){
							count = new ProtocolApplication_PerformerExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocolapplication_performer")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocolapplication_performer");
						result.getMessages().put("protocolapplication_performer", "evaluated "+count+" protocolapplication_performer elements");
					} catch (Exception e) {
						result.setErrorItem("protocolapplication_performer");
						result.getMessages().put("protocolapplication_performer", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocolapplication_ontol11768")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocolapplication_ontol11768")){
							count = new ProtocolApplication_Ontol11768ExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocolapplication_ontol11768")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocolapplication_ontol11768");
						result.getMessages().put("protocolapplication_ontol11768", "evaluated "+count+" protocolapplication_ontol11768 elements");
					} catch (Exception e) {
						result.setErrorItem("protocolapplication_ontol11768");
						result.getMessages().put("protocolapplication_ontol11768", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocol_subprotocols")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocol_subprotocols")){
							count = new Protocol_SubprotocolsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocol_subprotocols")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocol_subprotocols");
						result.getMessages().put("protocol_subprotocols", "evaluated "+count+" protocol_subprotocols elements");
					} catch (Exception e) {
						result.setErrorItem("protocol_subprotocols");
						result.getMessages().put("protocol_subprotocols", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocol_features")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocol_features")){
							count = new Protocol_FeaturesExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocol_features")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocol_features");
						result.getMessages().put("protocol_features", "evaluated "+count+" protocol_features elements");
					} catch (Exception e) {
						result.setErrorItem("protocol_features");
						result.getMessages().put("protocol_features", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocol_ontologyreference")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocol_ontologyreference")){
							count = new Protocol_OntologyReferenceExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocol_ontologyreference")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocol_ontologyreference");
						result.getMessages().put("protocol_ontologyreference", "evaluated "+count+" protocol_ontologyreference elements");
					} catch (Exception e) {
						result.setErrorItem("protocol_ontologyreference");
						result.getMessages().put("protocol_ontologyreference", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("investigation_contacts")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("investigation_contacts")){
							count = new Investigation_ContactsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("investigation_contacts")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("investigation_contacts");
						result.getMessages().put("investigation_contacts", "evaluated "+count+" investigation_contacts elements");
					} catch (Exception e) {
						result.setErrorItem("investigation_contacts");
						result.getMessages().put("investigation_contacts", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("panel_founderpanels")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("panel_founderpanels")){
							count = new Panel_FounderPanelsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("panel_founderpanels")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("panel_founderpanels");
						result.getMessages().put("panel_founderpanels", "evaluated "+count+" panel_founderpanels elements");
					} catch (Exception e) {
						result.setErrorItem("panel_founderpanels");
						result.getMessages().put("panel_founderpanels", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("panel_individuals")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("panel_individuals")){
							count = new Panel_IndividualsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("panel_individuals")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("panel_individuals");
						result.getMessages().put("panel_individuals", "evaluated "+count+" panel_individuals elements");
					} catch (Exception e) {
						result.setErrorItem("panel_individuals");
						result.getMessages().put("panel_individuals", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("measurement_categories")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("measurement_categories")){
							count = new Measurement_CategoriesExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("measurement_categories")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("measurement_categories");
						result.getMessages().put("measurement_categories", "evaluated "+count+" measurement_categories elements");
					} catch (Exception e) {
						result.setErrorItem("measurement_categories");
						result.getMessages().put("measurement_categories", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observationelement_alternateid")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observationelement_alternateid")){
							count = new ObservationElement_AlternateIdExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observationelement_alternateid")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observationelement_alternateid");
						result.getMessages().put("observationelement_alternateid", "evaluated "+count+" observationelement_alternateid elements");
					} catch (Exception e) {
						result.setErrorItem("observationelement_alternateid");
						result.getMessages().put("observationelement_alternateid", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observationelement_ontolo12449")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observationelement_ontolo12449")){
							count = new ObservationElement_Ontolo12449ExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observationelement_ontolo12449")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observationelement_ontolo12449");
						result.getMessages().put("observationelement_ontolo12449", "evaluated "+count+" observationelement_ontolo12449 elements");
					} catch (Exception e) {
						result.setErrorItem("observationelement_ontolo12449");
						result.getMessages().put("observationelement_ontolo12449", e.getMessage() != null ? e.getMessage() : "null");
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
						result.getMessages().put("molgenispermission", "evaluated "+count+" molgenispermission elements");
					} catch (Exception e) {
						result.setErrorItem("molgenispermission");
						result.getMessages().put("molgenispermission", e.getMessage() != null ? e.getMessage() : "null");
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
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("workflowelementparameter")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("workflowelementparameter")){
							count = new WorkflowElementParameterExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("workflowelementparameter")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("workflowelementparameter");
						result.getMessages().put("workflowelementparameter", "evaluated "+count+" workflowelementparameter elements");
					} catch (Exception e) {
						result.setErrorItem("workflowelementparameter");
						result.getMessages().put("workflowelementparameter", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("workflowelement")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("workflowelement")){
							count = new WorkflowElementExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("workflowelement")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("workflowelement");
						result.getMessages().put("workflowelement", "evaluated "+count+" workflowelement elements");
					} catch (Exception e) {
						result.setErrorItem("workflowelement");
						result.getMessages().put("workflowelement", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocoldocument")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocoldocument")){
							count = new ProtocolDocumentExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocoldocument")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocoldocument");
						result.getMessages().put("protocoldocument", "evaluated "+count+" protocoldocument elements");
					} catch (Exception e) {
						result.setErrorItem("protocoldocument");
						result.getMessages().put("protocoldocument", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observedvalue")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observedvalue")){
							count = new ObservedValueExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observedvalue")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observedvalue");
						result.getMessages().put("observedvalue", "evaluated "+count+" observedvalue elements");
					} catch (Exception e) {
						result.setErrorItem("observedvalue");
						result.getMessages().put("observedvalue", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocolapplication")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocolapplication")){
							count = new ProtocolApplicationExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocolapplication")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocolapplication");
						result.getMessages().put("protocolapplication", "evaluated "+count+" protocolapplication elements");
					} catch (Exception e) {
						result.setErrorItem("protocolapplication");
						result.getMessages().put("protocolapplication", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("workflow")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("workflow")){
							count = new WorkflowExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("workflow")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("workflow");
						result.getMessages().put("workflow", "evaluated "+count+" workflow elements");
					} catch (Exception e) {
						result.setErrorItem("workflow");
						result.getMessages().put("workflow", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocol")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocol")){
							count = new ProtocolExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocol")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocol");
						result.getMessages().put("protocol", "evaluated "+count+" protocol elements");
					} catch (Exception e) {
						result.setErrorItem("protocol");
						result.getMessages().put("protocol", e.getMessage() != null ? e.getMessage() : "null");
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
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("panel")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("panel")){
							count = new PanelExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("panel")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("panel");
						result.getMessages().put("panel", "evaluated "+count+" panel elements");
					} catch (Exception e) {
						result.setErrorItem("panel");
						result.getMessages().put("panel", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("location")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("location")){
							count = new LocationExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("location")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("location");
						result.getMessages().put("location", "evaluated "+count+" location elements");
					} catch (Exception e) {
						result.setErrorItem("location");
						result.getMessages().put("location", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("individual")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("individual")){
							count = new IndividualExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("individual")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("individual");
						result.getMessages().put("individual", "evaluated "+count+" individual elements");
					} catch (Exception e) {
						result.setErrorItem("individual");
						result.getMessages().put("individual", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("measurement")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("measurement")){
							count = new MeasurementExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("measurement")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("measurement");
						result.getMessages().put("measurement", "evaluated "+count+" measurement elements");
					} catch (Exception e) {
						result.setErrorItem("measurement");
						result.getMessages().put("measurement", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("category")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("category")){
							count = new CategoryExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("category")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("category");
						result.getMessages().put("category", "evaluated "+count+" category elements");
					} catch (Exception e) {
						result.setErrorItem("category");
						result.getMessages().put("category", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observablefeature")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observablefeature")){
							count = new ObservableFeatureExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observablefeature")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observablefeature");
						result.getMessages().put("observablefeature", "evaluated "+count+" observablefeature elements");
					} catch (Exception e) {
						result.setErrorItem("observablefeature");
						result.getMessages().put("observablefeature", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observationtarget")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observationtarget")){
							count = new ObservationTargetExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observationtarget")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observationtarget");
						result.getMessages().put("observationtarget", "evaluated "+count+" observationtarget elements");
					} catch (Exception e) {
						result.setErrorItem("observationtarget");
						result.getMessages().put("observationtarget", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observationelement")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observationelement")){
							count = new ObservationElementExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observationelement")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observationelement");
						result.getMessages().put("observationelement", "evaluated "+count+" observationelement elements");
					} catch (Exception e) {
						result.setErrorItem("observationelement");
						result.getMessages().put("observationelement", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("investigation")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("investigation")){
							count = new InvestigationExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("investigation")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("investigation");
						result.getMessages().put("investigation", "evaluated "+count+" investigation elements");
					} catch (Exception e) {
						result.setErrorItem("investigation");
						result.getMessages().put("investigation", e.getMessage() != null ? e.getMessage() : "null");
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
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("alternateid")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("alternateid")){
							count = new AlternateIdExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("alternateid")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("alternateid");
						result.getMessages().put("alternateid", "evaluated "+count+" alternateid elements");
					} catch (Exception e) {
						result.setErrorItem("alternateid");
						result.getMessages().put("alternateid", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("species")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("species")){
							count = new SpeciesExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("species")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("species");
						result.getMessages().put("species", "evaluated "+count+" species elements");
					} catch (Exception e) {
						result.setErrorItem("species");
						result.getMessages().put("species", e.getMessage() != null ? e.getMessage() : "null");
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
			}
			else
			{
				//follow xref dependency order
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
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("species")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("species")){
							count = new SpeciesExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("species")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("species");
						result.getMessages().put("species",  "evaluated "+count+" species elements");
					} catch (Exception e) {
						result.setErrorItem("species");
						result.getMessages().put("species", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("alternateid")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("alternateid")){
							count = new AlternateIdExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("alternateid")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("alternateid");
						result.getMessages().put("alternateid",  "evaluated "+count+" alternateid elements");
					} catch (Exception e) {
						result.setErrorItem("alternateid");
						result.getMessages().put("alternateid", e.getMessage() != null ? e.getMessage() : "null");
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
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("investigation")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("investigation")){
							count = new InvestigationExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("investigation")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("investigation");
						result.getMessages().put("investigation",  "evaluated "+count+" investigation elements");
					} catch (Exception e) {
						result.setErrorItem("investigation");
						result.getMessages().put("investigation", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observationelement")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observationelement")){
							count = new ObservationElementExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observationelement")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observationelement");
						result.getMessages().put("observationelement",  "evaluated "+count+" observationelement elements");
					} catch (Exception e) {
						result.setErrorItem("observationelement");
						result.getMessages().put("observationelement", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observationtarget")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observationtarget")){
							count = new ObservationTargetExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observationtarget")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observationtarget");
						result.getMessages().put("observationtarget",  "evaluated "+count+" observationtarget elements");
					} catch (Exception e) {
						result.setErrorItem("observationtarget");
						result.getMessages().put("observationtarget", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observablefeature")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observablefeature")){
							count = new ObservableFeatureExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observablefeature")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observablefeature");
						result.getMessages().put("observablefeature",  "evaluated "+count+" observablefeature elements");
					} catch (Exception e) {
						result.setErrorItem("observablefeature");
						result.getMessages().put("observablefeature", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("category")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("category")){
							count = new CategoryExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("category")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("category");
						result.getMessages().put("category",  "evaluated "+count+" category elements");
					} catch (Exception e) {
						result.setErrorItem("category");
						result.getMessages().put("category", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("measurement")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("measurement")){
							count = new MeasurementExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("measurement")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("measurement");
						result.getMessages().put("measurement",  "evaluated "+count+" measurement elements");
					} catch (Exception e) {
						result.setErrorItem("measurement");
						result.getMessages().put("measurement", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("individual")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("individual")){
							count = new IndividualExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("individual")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("individual");
						result.getMessages().put("individual",  "evaluated "+count+" individual elements");
					} catch (Exception e) {
						result.setErrorItem("individual");
						result.getMessages().put("individual", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("location")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("location")){
							count = new LocationExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("location")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("location");
						result.getMessages().put("location",  "evaluated "+count+" location elements");
					} catch (Exception e) {
						result.setErrorItem("location");
						result.getMessages().put("location", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("panel")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("panel")){
							count = new PanelExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("panel")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("panel");
						result.getMessages().put("panel",  "evaluated "+count+" panel elements");
					} catch (Exception e) {
						result.setErrorItem("panel");
						result.getMessages().put("panel", e.getMessage() != null ? e.getMessage() : "null");
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
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocol")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocol")){
							count = new ProtocolExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocol")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocol");
						result.getMessages().put("protocol",  "evaluated "+count+" protocol elements");
					} catch (Exception e) {
						result.setErrorItem("protocol");
						result.getMessages().put("protocol", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("workflow")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("workflow")){
							count = new WorkflowExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("workflow")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("workflow");
						result.getMessages().put("workflow",  "evaluated "+count+" workflow elements");
					} catch (Exception e) {
						result.setErrorItem("workflow");
						result.getMessages().put("workflow", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocolapplication")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocolapplication")){
							count = new ProtocolApplicationExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocolapplication")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocolapplication");
						result.getMessages().put("protocolapplication",  "evaluated "+count+" protocolapplication elements");
					} catch (Exception e) {
						result.setErrorItem("protocolapplication");
						result.getMessages().put("protocolapplication", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observedvalue")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observedvalue")){
							count = new ObservedValueExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observedvalue")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observedvalue");
						result.getMessages().put("observedvalue",  "evaluated "+count+" observedvalue elements");
					} catch (Exception e) {
						result.setErrorItem("observedvalue");
						result.getMessages().put("observedvalue", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocoldocument")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocoldocument")){
							count = new ProtocolDocumentExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocoldocument")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocoldocument");
						result.getMessages().put("protocoldocument",  "evaluated "+count+" protocoldocument elements");
					} catch (Exception e) {
						result.setErrorItem("protocoldocument");
						result.getMessages().put("protocoldocument", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("workflowelement")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("workflowelement")){
							count = new WorkflowElementExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("workflowelement")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("workflowelement");
						result.getMessages().put("workflowelement",  "evaluated "+count+" workflowelement elements");
					} catch (Exception e) {
						result.setErrorItem("workflowelement");
						result.getMessages().put("workflowelement", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("workflowelementparameter")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("workflowelementparameter")){
							count = new WorkflowElementParameterExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("workflowelementparameter")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("workflowelementparameter");
						result.getMessages().put("workflowelementparameter",  "evaluated "+count+" workflowelementparameter elements");
					} catch (Exception e) {
						result.setErrorItem("workflowelementparameter");
						result.getMessages().put("workflowelementparameter", e.getMessage() != null ? e.getMessage() : "null");
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
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observationelement_ontolo12449")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observationelement_ontolo12449")){
							count = new ObservationElement_Ontolo12449ExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observationelement_ontolo12449")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observationelement_ontolo12449");
						result.getMessages().put("observationelement_ontolo12449",  "evaluated "+count+" observationelement_ontolo12449 elements");
					} catch (Exception e) {
						result.setErrorItem("observationelement_ontolo12449");
						result.getMessages().put("observationelement_ontolo12449", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("observationelement_alternateid")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("observationelement_alternateid")){
							count = new ObservationElement_AlternateIdExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("observationelement_alternateid")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("observationelement_alternateid");
						result.getMessages().put("observationelement_alternateid",  "evaluated "+count+" observationelement_alternateid elements");
					} catch (Exception e) {
						result.setErrorItem("observationelement_alternateid");
						result.getMessages().put("observationelement_alternateid", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("measurement_categories")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("measurement_categories")){
							count = new Measurement_CategoriesExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("measurement_categories")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("measurement_categories");
						result.getMessages().put("measurement_categories",  "evaluated "+count+" measurement_categories elements");
					} catch (Exception e) {
						result.setErrorItem("measurement_categories");
						result.getMessages().put("measurement_categories", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("panel_individuals")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("panel_individuals")){
							count = new Panel_IndividualsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("panel_individuals")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("panel_individuals");
						result.getMessages().put("panel_individuals",  "evaluated "+count+" panel_individuals elements");
					} catch (Exception e) {
						result.setErrorItem("panel_individuals");
						result.getMessages().put("panel_individuals", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("panel_founderpanels")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("panel_founderpanels")){
							count = new Panel_FounderPanelsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("panel_founderpanels")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("panel_founderpanels");
						result.getMessages().put("panel_founderpanels",  "evaluated "+count+" panel_founderpanels elements");
					} catch (Exception e) {
						result.setErrorItem("panel_founderpanels");
						result.getMessages().put("panel_founderpanels", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("investigation_contacts")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("investigation_contacts")){
							count = new Investigation_ContactsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("investigation_contacts")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("investigation_contacts");
						result.getMessages().put("investigation_contacts",  "evaluated "+count+" investigation_contacts elements");
					} catch (Exception e) {
						result.setErrorItem("investigation_contacts");
						result.getMessages().put("investigation_contacts", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocol_ontologyreference")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocol_ontologyreference")){
							count = new Protocol_OntologyReferenceExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocol_ontologyreference")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocol_ontologyreference");
						result.getMessages().put("protocol_ontologyreference",  "evaluated "+count+" protocol_ontologyreference elements");
					} catch (Exception e) {
						result.setErrorItem("protocol_ontologyreference");
						result.getMessages().put("protocol_ontologyreference", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocol_features")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocol_features")){
							count = new Protocol_FeaturesExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocol_features")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocol_features");
						result.getMessages().put("protocol_features",  "evaluated "+count+" protocol_features elements");
					} catch (Exception e) {
						result.setErrorItem("protocol_features");
						result.getMessages().put("protocol_features", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocol_subprotocols")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocol_subprotocols")){
							count = new Protocol_SubprotocolsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocol_subprotocols")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocol_subprotocols");
						result.getMessages().put("protocol_subprotocols",  "evaluated "+count+" protocol_subprotocols elements");
					} catch (Exception e) {
						result.setErrorItem("protocol_subprotocols");
						result.getMessages().put("protocol_subprotocols", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocolapplication_ontol11768")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocolapplication_ontol11768")){
							count = new ProtocolApplication_Ontol11768ExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocolapplication_ontol11768")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocolapplication_ontol11768");
						result.getMessages().put("protocolapplication_ontol11768",  "evaluated "+count+" protocolapplication_ontol11768 elements");
					} catch (Exception e) {
						result.setErrorItem("protocolapplication_ontol11768");
						result.getMessages().put("protocolapplication_ontol11768", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("protocolapplication_performer")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("protocolapplication_performer")){
							count = new ProtocolApplication_PerformerExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("protocolapplication_performer")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("protocolapplication_performer");
						result.getMessages().put("protocolapplication_performer",  "evaluated "+count+" protocolapplication_performer elements");
					} catch (Exception e) {
						result.setErrorItem("protocolapplication_performer");
						result.getMessages().put("protocolapplication_performer", e.getMessage() != null ? e.getMessage() : "null");
						throw e;
					}					
				}
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("workflowelement_previoussteps")))
				{
					try {
						int count = 0;
						if(sheetNames.contains("workflowelement_previoussteps")){
							count = new WorkflowElement_PreviousStepsExcelReader().importSheet(db, workbook.getSheet(sheetNames.indexOf("workflowelement_previoussteps")), defaults, dbAction, missingValue);
						}
						result.getProgressLog().add("workflowelement_previoussteps");
						result.getMessages().put("workflowelement_previoussteps",  "evaluated "+count+" workflowelement_previoussteps elements");
					} catch (Exception e) {
						result.setErrorItem("workflowelement_previoussteps");
						result.getMessages().put("workflowelement_previoussteps", e.getMessage() != null ? e.getMessage() : "null");
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