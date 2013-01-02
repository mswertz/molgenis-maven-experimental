
/* Date:        October 11, 2012
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

import org.molgenis.pheno.csv.SpeciesCsvReader;
import org.molgenis.pheno.csv.AlternateIdCsvReader;
import org.molgenis.pheno.csv.ObservationElementCsvReader;
import org.molgenis.pheno.csv.ObservationTargetCsvReader;
import org.molgenis.pheno.csv.ObservableFeatureCsvReader;
import org.molgenis.pheno.csv.MeasurementCsvReader;
import org.molgenis.pheno.csv.CategoryCsvReader;
import org.molgenis.pheno.csv.IndividualCsvReader;
import org.molgenis.pheno.csv.LocationCsvReader;
import org.molgenis.pheno.csv.PanelCsvReader;
import org.molgenis.pheno.csv.ObservedValueCsvReader;
import org.molgenis.organization.csv.InvestigationCsvReader;
import org.molgenis.core.csv.OntologyTermCsvReader;
import org.molgenis.core.csv.OntologyCsvReader;
import org.molgenis.core.csv.MolgenisFileCsvReader;
import org.molgenis.core.csv.RuntimePropertyCsvReader;
import org.molgenis.core.csv.PublicationCsvReader;
import org.molgenis.core.csv.UseCaseCsvReader;
import org.molgenis.core.csv.MolgenisEntityCsvReader;
import org.molgenis.protocol.csv.ProtocolCsvReader;
import org.molgenis.protocol.csv.ProtocolApplicationCsvReader;
import org.molgenis.protocol.csv.ProtocolDocumentCsvReader;
import org.molgenis.protocol.csv.WorkflowCsvReader;
import org.molgenis.protocol.csv.WorkflowElementCsvReader;
import org.molgenis.protocol.csv.WorkflowElementParameterCsvReader;
import org.molgenis.auth.csv.MolgenisRoleCsvReader;
import org.molgenis.auth.csv.MolgenisGroupCsvReader;
import org.molgenis.auth.csv.MolgenisRoleGroupLinkCsvReader;
import org.molgenis.auth.csv.PersonCsvReader;
import org.molgenis.auth.csv.InstituteCsvReader;
import org.molgenis.auth.csv.MolgenisUserCsvReader;
import org.molgenis.auth.csv.MolgenisPermissionCsvReader;
import org.molgenis.pheno.csv.ObservationElement_Ontolo12449CsvReader;
import org.molgenis.pheno.csv.ObservationElement_AlternateIdCsvReader;
import org.molgenis.pheno.csv.Measurement_CategoriesCsvReader;
import org.molgenis.pheno.csv.Panel_IndividualsCsvReader;
import org.molgenis.pheno.csv.Panel_FounderPanelsCsvReader;
import org.molgenis.organization.csv.Investigation_ContactsCsvReader;
import org.molgenis.protocol.csv.Protocol_OntologyReferenceCsvReader;
import org.molgenis.protocol.csv.Protocol_FeaturesCsvReader;
import org.molgenis.protocol.csv.Protocol_SubprotocolsCsvReader;
import org.molgenis.protocol.csv.ProtocolApplication_Ontol11768CsvReader;
import org.molgenis.protocol.csv.ProtocolApplication_PerformerCsvReader;
import org.molgenis.protocol.csv.WorkflowElement_PreviousStepsCsvReader;

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
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("workflowelement_previoussteps")))
				{
					try {
						int count = new WorkflowElement_PreviousStepsCsvReader().importCsv(db, new File(directory+"/workflowelement_previoussteps.txt"), defaults, dbAction, missingValue);
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
						int count = new ProtocolApplication_PerformerCsvReader().importCsv(db, new File(directory+"/protocolapplication_performer.txt"), defaults, dbAction, missingValue);
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
						int count = new ProtocolApplication_Ontol11768CsvReader().importCsv(db, new File(directory+"/protocolapplication_ontol11768.txt"), defaults, dbAction, missingValue);
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
						int count = new Protocol_SubprotocolsCsvReader().importCsv(db, new File(directory+"/protocol_subprotocols.txt"), defaults, dbAction, missingValue);
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
						int count = new Protocol_FeaturesCsvReader().importCsv(db, new File(directory+"/protocol_features.txt"), defaults, dbAction, missingValue);
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
						int count = new Protocol_OntologyReferenceCsvReader().importCsv(db, new File(directory+"/protocol_ontologyreference.txt"), defaults, dbAction, missingValue);
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
						int count = new Investigation_ContactsCsvReader().importCsv(db, new File(directory+"/investigation_contacts.txt"), defaults, dbAction, missingValue);
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
						int count = new Panel_FounderPanelsCsvReader().importCsv(db, new File(directory+"/panel_founderpanels.txt"), defaults, dbAction, missingValue);
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
						int count = new Panel_IndividualsCsvReader().importCsv(db, new File(directory+"/panel_individuals.txt"), defaults, dbAction, missingValue);
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
						int count = new Measurement_CategoriesCsvReader().importCsv(db, new File(directory+"/measurement_categories.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservationElement_AlternateIdCsvReader().importCsv(db, new File(directory+"/observationelement_alternateid.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservationElement_Ontolo12449CsvReader().importCsv(db, new File(directory+"/observationelement_ontolo12449.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisPermissionCsvReader().importCsv(db, new File(directory+"/molgenispermission.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisRoleGroupLinkCsvReader().importCsv(db, new File(directory+"/molgenisrolegrouplink.txt"), defaults, dbAction, missingValue);
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
						int count = new WorkflowElementParameterCsvReader().importCsv(db, new File(directory+"/workflowelementparameter.txt"), defaults, dbAction, missingValue);
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
						int count = new WorkflowElementCsvReader().importCsv(db, new File(directory+"/workflowelement.txt"), defaults, dbAction, missingValue);
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
						int count = new ProtocolDocumentCsvReader().importCsv(db, new File(directory+"/protocoldocument.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservedValueCsvReader().importCsv(db, new File(directory+"/observedvalue.txt"), defaults, dbAction, missingValue);
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
						int count = new ProtocolApplicationCsvReader().importCsv(db, new File(directory+"/protocolapplication.txt"), defaults, dbAction, missingValue);
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
						int count = new WorkflowCsvReader().importCsv(db, new File(directory+"/workflow.txt"), defaults, dbAction, missingValue);
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
						int count = new ProtocolCsvReader().importCsv(db, new File(directory+"/protocol.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisUserCsvReader().importCsv(db, new File(directory+"/molgenisuser.txt"), defaults, dbAction, missingValue);
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
						int count = new PanelCsvReader().importCsv(db, new File(directory+"/panel.txt"), defaults, dbAction, missingValue);
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
						int count = new LocationCsvReader().importCsv(db, new File(directory+"/location.txt"), defaults, dbAction, missingValue);
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
						int count = new IndividualCsvReader().importCsv(db, new File(directory+"/individual.txt"), defaults, dbAction, missingValue);
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
						int count = new MeasurementCsvReader().importCsv(db, new File(directory+"/measurement.txt"), defaults, dbAction, missingValue);
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
						int count = new CategoryCsvReader().importCsv(db, new File(directory+"/category.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservableFeatureCsvReader().importCsv(db, new File(directory+"/observablefeature.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservationTargetCsvReader().importCsv(db, new File(directory+"/observationtarget.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservationElementCsvReader().importCsv(db, new File(directory+"/observationelement.txt"), defaults, dbAction, missingValue);
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
						int count = new InvestigationCsvReader().importCsv(db, new File(directory+"/investigation.txt"), defaults, dbAction, missingValue);
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
						int count = new PersonCsvReader().importCsv(db, new File(directory+"/person.txt"), defaults, dbAction, missingValue);
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
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("alternateid")))
				{
					try {
						int count = new AlternateIdCsvReader().importCsv(db, new File(directory+"/alternateid.txt"), defaults, dbAction, missingValue);
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
						int count = new SpeciesCsvReader().importCsv(db, new File(directory+"/species.txt"), defaults, dbAction, missingValue);
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
						int count = new OntologyCsvReader().importCsv(db, new File(directory+"/ontology.txt"), defaults, dbAction, missingValue);
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
						int count = new OntologyCsvReader().importCsv(db, new File(directory+"/ontology.txt"), defaults, dbAction, missingValue);
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
						int count = new SpeciesCsvReader().importCsv(db, new File(directory+"/species.txt"), defaults, dbAction, missingValue);
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
						int count = new AlternateIdCsvReader().importCsv(db, new File(directory+"/alternateid.txt"), defaults, dbAction, missingValue);
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
						int count = new OntologyTermCsvReader().importCsv(db, new File(directory+"/ontologyterm.txt"), defaults, dbAction, missingValue);
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
				if (result.getErrorItem().equals("no error found") && (components == null || components.contains("investigation")))
				{
					try {
						int count = new InvestigationCsvReader().importCsv(db, new File(directory+"/investigation.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservationElementCsvReader().importCsv(db, new File(directory+"/observationelement.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservationTargetCsvReader().importCsv(db, new File(directory+"/observationtarget.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservableFeatureCsvReader().importCsv(db, new File(directory+"/observablefeature.txt"), defaults, dbAction, missingValue);
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
						int count = new CategoryCsvReader().importCsv(db, new File(directory+"/category.txt"), defaults, dbAction, missingValue);
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
						int count = new MeasurementCsvReader().importCsv(db, new File(directory+"/measurement.txt"), defaults, dbAction, missingValue);
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
						int count = new IndividualCsvReader().importCsv(db, new File(directory+"/individual.txt"), defaults, dbAction, missingValue);
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
						int count = new LocationCsvReader().importCsv(db, new File(directory+"/location.txt"), defaults, dbAction, missingValue);
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
						int count = new PanelCsvReader().importCsv(db, new File(directory+"/panel.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisUserCsvReader().importCsv(db, new File(directory+"/molgenisuser.txt"), defaults, dbAction, missingValue);
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
						int count = new ProtocolCsvReader().importCsv(db, new File(directory+"/protocol.txt"), defaults, dbAction, missingValue);
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
						int count = new WorkflowCsvReader().importCsv(db, new File(directory+"/workflow.txt"), defaults, dbAction, missingValue);
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
						int count = new ProtocolApplicationCsvReader().importCsv(db, new File(directory+"/protocolapplication.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservedValueCsvReader().importCsv(db, new File(directory+"/observedvalue.txt"), defaults, dbAction, missingValue);
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
						int count = new ProtocolDocumentCsvReader().importCsv(db, new File(directory+"/protocoldocument.txt"), defaults, dbAction, missingValue);
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
						int count = new WorkflowElementCsvReader().importCsv(db, new File(directory+"/workflowelement.txt"), defaults, dbAction, missingValue);
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
						int count = new WorkflowElementParameterCsvReader().importCsv(db, new File(directory+"/workflowelementparameter.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisRoleGroupLinkCsvReader().importCsv(db, new File(directory+"/molgenisrolegrouplink.txt"), defaults, dbAction, missingValue);
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
						int count = new MolgenisPermissionCsvReader().importCsv(db, new File(directory+"/molgenispermission.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservationElement_Ontolo12449CsvReader().importCsv(db, new File(directory+"/observationelement_ontolo12449.txt"), defaults, dbAction, missingValue);
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
						int count = new ObservationElement_AlternateIdCsvReader().importCsv(db, new File(directory+"/observationelement_alternateid.txt"), defaults, dbAction, missingValue);
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
						int count = new Measurement_CategoriesCsvReader().importCsv(db, new File(directory+"/measurement_categories.txt"), defaults, dbAction, missingValue);
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
						int count = new Panel_IndividualsCsvReader().importCsv(db, new File(directory+"/panel_individuals.txt"), defaults, dbAction, missingValue);
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
						int count = new Panel_FounderPanelsCsvReader().importCsv(db, new File(directory+"/panel_founderpanels.txt"), defaults, dbAction, missingValue);
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
						int count = new Investigation_ContactsCsvReader().importCsv(db, new File(directory+"/investigation_contacts.txt"), defaults, dbAction, missingValue);
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
						int count = new Protocol_OntologyReferenceCsvReader().importCsv(db, new File(directory+"/protocol_ontologyreference.txt"), defaults, dbAction, missingValue);
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
						int count = new Protocol_FeaturesCsvReader().importCsv(db, new File(directory+"/protocol_features.txt"), defaults, dbAction, missingValue);
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
						int count = new Protocol_SubprotocolsCsvReader().importCsv(db, new File(directory+"/protocol_subprotocols.txt"), defaults, dbAction, missingValue);
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
						int count = new ProtocolApplication_Ontol11768CsvReader().importCsv(db, new File(directory+"/protocolapplication_ontol11768.txt"), defaults, dbAction, missingValue);
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
						int count = new ProtocolApplication_PerformerCsvReader().importCsv(db, new File(directory+"/protocolapplication_performer.txt"), defaults, dbAction, missingValue);
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
						int count = new WorkflowElement_PreviousStepsCsvReader().importCsv(db, new File(directory+"/workflowelement_previoussteps.txt"), defaults, dbAction, missingValue);
						result.getProgressLog().add("workflowelement_previoussteps");
						result.getMessages().put("workflowelement_previoussteps",  "evaluated "+count+" workflowelement_previoussteps elements");
					} catch (Exception e) {
						result.setErrorItem("workflowelement_previoussteps");
						result.getMessages().put("workflowelement_previoussteps", e.getMessage() != null ? e.getMessage() : "null");
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