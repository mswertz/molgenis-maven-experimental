
/* Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvExportGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package app;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.Query;
import org.molgenis.framework.db.QueryRule;
import org.molgenis.framework.db.QueryRule.Operator;
import org.molgenis.model.MolgenisModelException;
import org.molgenis.util.Entity;
import org.molgenis.util.CsvFileWriter;


	import org.molgenis.core.Ontology;
	import org.molgenis.pheno.Species;
	import org.molgenis.pheno.AlternateId;
	import org.molgenis.core.OntologyTerm;
	import org.molgenis.core.MolgenisFile;
	import org.molgenis.core.RuntimeProperty;
	import org.molgenis.core.Publication;
	import org.molgenis.core.UseCase;
	import org.molgenis.core.MolgenisEntity;
	import org.molgenis.auth.MolgenisRole;
	import org.molgenis.auth.MolgenisGroup;
	import org.molgenis.auth.Institute;
	import org.molgenis.auth.Person;
	import org.molgenis.organization.Investigation;
	import org.molgenis.pheno.ObservationElement;
	import org.molgenis.pheno.ObservationTarget;
	import org.molgenis.pheno.ObservableFeature;
	import org.molgenis.pheno.Category;
	import org.molgenis.pheno.Measurement;
	import org.molgenis.pheno.Individual;
	import org.molgenis.pheno.Location;
	import org.molgenis.pheno.Panel;
	import org.molgenis.auth.MolgenisUser;
	import org.molgenis.protocol.Protocol;
	import org.molgenis.protocol.Workflow;
	import org.molgenis.protocol.ProtocolApplication;
	import org.molgenis.pheno.ObservedValue;
	import org.molgenis.protocol.ProtocolDocument;
	import org.molgenis.protocol.WorkflowElement;
	import org.molgenis.protocol.WorkflowElementParameter;
	import org.molgenis.auth.MolgenisRoleGroupLink;
	import org.molgenis.auth.MolgenisPermission;

public class CsvExport
{
	static Logger logger = Logger.getLogger(CsvExport.class.getSimpleName());
		
		/**
	 * Default export all using a target directory and a database to export
	 * @param directory
	 * @param db
	 * @throws Exception
	 */
	public void exportAll(File directory, Database db) throws Exception
	{
		exportAll(directory, db, true, new QueryRule[]{});
	}
	
	/**
	 * Export all using a set of QueryRules used for all entities if applicable to that entity
	 * @param directory
	 * @param db
	 * @param rules
	 * @throws Exception
	 */
	public void exportAll(File directory, Database db, QueryRule ... rules) throws Exception
	{
		exportAll(directory, db, true, rules);
	}
	
	/**
	 * Export all where a boolean skip autoid fields forces an ignore of the auto id field ("id")
	 * @param directory
	 * @param db
	 * @param skipAutoId
	 * @throws Exception
	 */
	public void exportAll(File directory, Database db, boolean skipAutoId) throws Exception
	{
		exportAll(directory, db, skipAutoId, new QueryRule[]{});
	}
	
	/**
	 * Export all with both a boolean skipAutoId and a set of QueryRules to specify both the skipping of auto id, and applying of a filter
	 * @param directory
	 * @param db
	 * @param skipAutoId
	 * @param rules
	 * @throws Exception
	 */
	public void exportAll(File directory, Database db, boolean skipAutoId, QueryRule ... rules) throws Exception
	{				
		exportOntology(db, new File(directory+"/ontology.txt"), skipAutoId ? Arrays.asList(new String[]{"name","ontologyAccession","ontologyURI"}) : null, rules);		
		exportSpecies(db, new File(directory+"/species.txt"), skipAutoId ? Arrays.asList(new String[]{"name","__Type","ontology_name","termAccession","definition","termPath"}) : null, rules);		
		exportAlternateId(db, new File(directory+"/alternateid.txt"), skipAutoId ? Arrays.asList(new String[]{"name","__Type","ontology_name","termAccession","definition","termPath"}) : null, rules);		
		exportOntologyTerm(db, new File(directory+"/ontologyterm.txt"), skipAutoId ? Arrays.asList(new String[]{"name","__Type","ontology_name","termAccession","definition","termPath"}) : null, rules);		
		exportMolgenisFile(db, new File(directory+"/molgenisfile.txt"), skipAutoId ? Arrays.asList(new String[]{"name","__Type","Extension"}) : null, rules);		
		exportRuntimeProperty(db, new File(directory+"/runtimeproperty.txt"), skipAutoId ? Arrays.asList(new String[]{"name","Value"}) : null, rules);		
		exportPublication(db, new File(directory+"/publication.txt"), skipAutoId ? Arrays.asList(new String[]{"name","PubmedID_name","DOI_name","authorList","Title","Status_name","Year","Journal"}) : null, rules);		
		exportUseCase(db, new File(directory+"/usecase.txt"), skipAutoId ? Arrays.asList(new String[]{"UseCaseName","SearchType"}) : null, rules);		
		exportMolgenisEntity(db, new File(directory+"/molgenisentity.txt"), skipAutoId ? Arrays.asList(new String[]{"name","type_","className"}) : null, rules);		
		exportMolgenisRole(db, new File(directory+"/molgenisrole.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name"}) : null, rules);		
		exportMolgenisGroup(db, new File(directory+"/molgenisgroup.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name"}) : null, rules);		
		exportInstitute(db, new File(directory+"/institute.txt"), skipAutoId ? Arrays.asList(new String[]{"Address","Phone","Email","Fax","tollFreePhone","City","Country","name"}) : null, rules);		
		exportPerson(db, new File(directory+"/person.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name","Address","Phone","Email","Fax","tollFreePhone","City","Country","FirstName","MidInitials","LastName","Title","Affiliation_name","Department","Roles_name"}) : null, rules);		
		exportInvestigation(db, new File(directory+"/investigation.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","startDate","endDate","contacts_name","accession"}) : null, rules);		
		exportObservationElement(db, new File(directory+"/observationelement.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label"}) : null, rules);		
		exportObservationTarget(db, new File(directory+"/observationtarget.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label"}) : null, rules);		
		exportObservableFeature(db, new File(directory+"/observablefeature.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label"}) : null, rules);		
		exportCategory(db, new File(directory+"/category.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label","code_string","isMissing"}) : null, rules);		
		exportMeasurement(db, new File(directory+"/measurement.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label","unit_name","dataType","temporal","categories_name","targettypeAllowedForRelation_className","panelLabelAllowedForRelation"}) : null, rules);		
		exportIndividual(db, new File(directory+"/individual.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label","Mother_name","Father_name"}) : null, rules);		
		exportLocation(db, new File(directory+"/location.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label"}) : null, rules);		
		exportPanel(db, new File(directory+"/panel.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label","Individuals_name","Species_name","PanelType_name","FounderPanels_name"}) : null, rules);		
		exportMolgenisUser(db, new File(directory+"/molgenisuser.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name","Address","Phone","Email","Fax","tollFreePhone","City","Country","FirstName","MidInitials","LastName","Title","Affiliation_name","Department","Roles_name","password_","activationCode","active","superuser"}) : null, rules);		
		exportProtocol(db, new File(directory+"/protocol.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","ProtocolType_name","Features_name","TargetFilter","Contact_name","subprotocols_name"}) : null, rules);		
		exportWorkflow(db, new File(directory+"/workflow.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","ProtocolType_name","Features_name","TargetFilter","Contact_name","subprotocols_name"}) : null, rules);		
		exportProtocolApplication(db, new File(directory+"/protocolapplication.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","time","protocol_name","Performer_name"}) : null, rules);		
		exportObservedValue(db, new File(directory+"/observedvalue.txt"), skipAutoId ? Arrays.asList(new String[]{"Investigation_name","protocolApplication_name","Feature_name","Target_name","ontologyReference_name","value","relation_name","time","endtime"}) : null, rules);		
		exportProtocolDocument(db, new File(directory+"/protocoldocument.txt"), skipAutoId ? Arrays.asList(new String[]{"name","__Type","Extension","protocol_name","document"}) : null, rules);		
		exportWorkflowElement(db, new File(directory+"/workflowelement.txt"), skipAutoId ? Arrays.asList(new String[]{"name","Workflow_name","protocol_name","PreviousSteps_name"}) : null, rules);		
		exportWorkflowElementParameter(db, new File(directory+"/workflowelementparameter.txt"), skipAutoId ? Arrays.asList(new String[]{"WorkflowElement_name","Parameter_name","Value"}) : null, rules);		
		exportMolgenisRoleGroupLink(db, new File(directory+"/molgenisrolegrouplink.txt"), skipAutoId ? Arrays.asList(new String[]{"group__name","role__name"}) : null, rules);		
		exportMolgenisPermission(db, new File(directory+"/molgenispermission.txt"), skipAutoId ? Arrays.asList(new String[]{"role__name","entity_className","permission"}) : null, rules);		
			
		logger.debug("done");
	}
	
   /**
	* Export without system tables.
	*/
	public void exportRegular(File directory, Database db, boolean skipAutoId) throws Exception
	{
		exportRegular(directory, db, skipAutoId, new QueryRule[]{});
	}
	
   /**
	* Export without system tables.
	*/
	public void exportRegular(File directory, Database db, boolean skipAutoId, QueryRule ... rules) throws Exception
	{				
		exportOntology(db, new File(directory+"/ontology.txt"), skipAutoId ? Arrays.asList(new String[]{"name","ontologyAccession","ontologyURI"}) : null, rules);		
		exportSpecies(db, new File(directory+"/species.txt"), skipAutoId ? Arrays.asList(new String[]{"name","__Type","ontology_name","termAccession","definition","termPath"}) : null, rules);		
		exportAlternateId(db, new File(directory+"/alternateid.txt"), skipAutoId ? Arrays.asList(new String[]{"name","__Type","ontology_name","termAccession","definition","termPath"}) : null, rules);		
		exportOntologyTerm(db, new File(directory+"/ontologyterm.txt"), skipAutoId ? Arrays.asList(new String[]{"name","__Type","ontology_name","termAccession","definition","termPath"}) : null, rules);		
		exportMolgenisFile(db, new File(directory+"/molgenisfile.txt"), skipAutoId ? Arrays.asList(new String[]{"name","__Type","Extension"}) : null, rules);		
		exportRuntimeProperty(db, new File(directory+"/runtimeproperty.txt"), skipAutoId ? Arrays.asList(new String[]{"name","Value"}) : null, rules);		
		exportPublication(db, new File(directory+"/publication.txt"), skipAutoId ? Arrays.asList(new String[]{"name","PubmedID_name","DOI_name","authorList","Title","Status_name","Year","Journal"}) : null, rules);		
		exportUseCase(db, new File(directory+"/usecase.txt"), skipAutoId ? Arrays.asList(new String[]{"UseCaseName","SearchType"}) : null, rules);		
		exportInstitute(db, new File(directory+"/institute.txt"), skipAutoId ? Arrays.asList(new String[]{"Address","Phone","Email","Fax","tollFreePhone","City","Country","name"}) : null, rules);		
		exportPerson(db, new File(directory+"/person.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name","Address","Phone","Email","Fax","tollFreePhone","City","Country","FirstName","MidInitials","LastName","Title","Affiliation_name","Department","Roles_name"}) : null, rules);		
		exportInvestigation(db, new File(directory+"/investigation.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","startDate","endDate","contacts_name","accession"}) : null, rules);		
		exportObservationElement(db, new File(directory+"/observationelement.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label"}) : null, rules);		
		exportObservationTarget(db, new File(directory+"/observationtarget.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label"}) : null, rules);		
		exportObservableFeature(db, new File(directory+"/observablefeature.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label"}) : null, rules);		
		exportCategory(db, new File(directory+"/category.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label","code_string","isMissing"}) : null, rules);		
		exportMeasurement(db, new File(directory+"/measurement.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label","unit_name","dataType","temporal","categories_name","targettypeAllowedForRelation_className","panelLabelAllowedForRelation"}) : null, rules);		
		exportIndividual(db, new File(directory+"/individual.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label","Mother_name","Father_name"}) : null, rules);		
		exportLocation(db, new File(directory+"/location.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label"}) : null, rules);		
		exportPanel(db, new File(directory+"/panel.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label","Individuals_name","Species_name","PanelType_name","FounderPanels_name"}) : null, rules);		
		exportProtocol(db, new File(directory+"/protocol.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","ProtocolType_name","Features_name","TargetFilter","Contact_name","subprotocols_name"}) : null, rules);		
		exportWorkflow(db, new File(directory+"/workflow.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","ProtocolType_name","Features_name","TargetFilter","Contact_name","subprotocols_name"}) : null, rules);		
		exportProtocolApplication(db, new File(directory+"/protocolapplication.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","time","protocol_name","Performer_name"}) : null, rules);		
		exportObservedValue(db, new File(directory+"/observedvalue.txt"), skipAutoId ? Arrays.asList(new String[]{"Investigation_name","protocolApplication_name","Feature_name","Target_name","ontologyReference_name","value","relation_name","time","endtime"}) : null, rules);		
		exportProtocolDocument(db, new File(directory+"/protocoldocument.txt"), skipAutoId ? Arrays.asList(new String[]{"name","__Type","Extension","protocol_name","document"}) : null, rules);		
		exportWorkflowElement(db, new File(directory+"/workflowelement.txt"), skipAutoId ? Arrays.asList(new String[]{"name","Workflow_name","protocol_name","PreviousSteps_name"}) : null, rules);		
		exportWorkflowElementParameter(db, new File(directory+"/workflowelementparameter.txt"), skipAutoId ? Arrays.asList(new String[]{"WorkflowElement_name","Parameter_name","Value"}) : null, rules);		
			
		logger.debug("done");
	}
	
	public void exportAll(File directory, List ... entityLists) throws Exception
	{				
		for(List<? extends Entity> l: entityLists) if(l.size()>0)
		{
			if(l.get(0).getClass().equals(Ontology.class))
				exportOntology(l, new File(directory+"/ontology.txt"));		
			if(l.get(0).getClass().equals(Species.class))
				exportSpecies(l, new File(directory+"/species.txt"));		
			if(l.get(0).getClass().equals(AlternateId.class))
				exportAlternateId(l, new File(directory+"/alternateid.txt"));		
			if(l.get(0).getClass().equals(OntologyTerm.class))
				exportOntologyTerm(l, new File(directory+"/ontologyterm.txt"));		
			if(l.get(0).getClass().equals(MolgenisFile.class))
				exportMolgenisFile(l, new File(directory+"/molgenisfile.txt"));		
			if(l.get(0).getClass().equals(RuntimeProperty.class))
				exportRuntimeProperty(l, new File(directory+"/runtimeproperty.txt"));		
			if(l.get(0).getClass().equals(Publication.class))
				exportPublication(l, new File(directory+"/publication.txt"));		
			if(l.get(0).getClass().equals(UseCase.class))
				exportUseCase(l, new File(directory+"/usecase.txt"));		
			if(l.get(0).getClass().equals(MolgenisEntity.class))
				exportMolgenisEntity(l, new File(directory+"/molgenisentity.txt"));		
			if(l.get(0).getClass().equals(MolgenisRole.class))
				exportMolgenisRole(l, new File(directory+"/molgenisrole.txt"));		
			if(l.get(0).getClass().equals(MolgenisGroup.class))
				exportMolgenisGroup(l, new File(directory+"/molgenisgroup.txt"));		
			if(l.get(0).getClass().equals(Institute.class))
				exportInstitute(l, new File(directory+"/institute.txt"));		
			if(l.get(0).getClass().equals(Person.class))
				exportPerson(l, new File(directory+"/person.txt"));		
			if(l.get(0).getClass().equals(Investigation.class))
				exportInvestigation(l, new File(directory+"/investigation.txt"));		
			if(l.get(0).getClass().equals(ObservationElement.class))
				exportObservationElement(l, new File(directory+"/observationelement.txt"));		
			if(l.get(0).getClass().equals(ObservationTarget.class))
				exportObservationTarget(l, new File(directory+"/observationtarget.txt"));		
			if(l.get(0).getClass().equals(ObservableFeature.class))
				exportObservableFeature(l, new File(directory+"/observablefeature.txt"));		
			if(l.get(0).getClass().equals(Category.class))
				exportCategory(l, new File(directory+"/category.txt"));		
			if(l.get(0).getClass().equals(Measurement.class))
				exportMeasurement(l, new File(directory+"/measurement.txt"));		
			if(l.get(0).getClass().equals(Individual.class))
				exportIndividual(l, new File(directory+"/individual.txt"));		
			if(l.get(0).getClass().equals(Location.class))
				exportLocation(l, new File(directory+"/location.txt"));		
			if(l.get(0).getClass().equals(Panel.class))
				exportPanel(l, new File(directory+"/panel.txt"));		
			if(l.get(0).getClass().equals(MolgenisUser.class))
				exportMolgenisUser(l, new File(directory+"/molgenisuser.txt"));		
			if(l.get(0).getClass().equals(Protocol.class))
				exportProtocol(l, new File(directory+"/protocol.txt"));		
			if(l.get(0).getClass().equals(Workflow.class))
				exportWorkflow(l, new File(directory+"/workflow.txt"));		
			if(l.get(0).getClass().equals(ProtocolApplication.class))
				exportProtocolApplication(l, new File(directory+"/protocolapplication.txt"));		
			if(l.get(0).getClass().equals(ObservedValue.class))
				exportObservedValue(l, new File(directory+"/observedvalue.txt"));		
			if(l.get(0).getClass().equals(ProtocolDocument.class))
				exportProtocolDocument(l, new File(directory+"/protocoldocument.txt"));		
			if(l.get(0).getClass().equals(WorkflowElement.class))
				exportWorkflowElement(l, new File(directory+"/workflowelement.txt"));		
			if(l.get(0).getClass().equals(WorkflowElementParameter.class))
				exportWorkflowElementParameter(l, new File(directory+"/workflowelementparameter.txt"));		
			if(l.get(0).getClass().equals(MolgenisRoleGroupLink.class))
				exportMolgenisRoleGroupLink(l, new File(directory+"/molgenisrolegrouplink.txt"));		
			if(l.get(0).getClass().equals(MolgenisPermission.class))
				exportMolgenisPermission(l, new File(directory+"/molgenispermission.txt"));		
		}
			
		logger.debug("done");
	}
	
	/**
	* Export while excluding or including certain entity types. Defaults set: skip autoId, no QueryRules.
	* If exclusion is set to true, the specialCases are used to exlude those entities from the export (entities not in list are exported).
	* If exclusion is set to false, the specialCases are used to include those entities in the export (only entities in list are exported).
	*/
	public void exportSpecial(File directory, Database db, List<Class<? extends Entity>> specialCases, boolean exclusion) throws Exception
	{
		exportSpecial(directory, db, true, specialCases, exclusion, new QueryRule[]{});
	}
	
	/**
	* Export while excluding or including certain entity types.
	* If exclusion is set to true, the specialCases are used to exlude those entities from the export (entities not in list are exported).
	* If exclusion is set to false, the specialCases are used to include those entities in the export (only entities in list are exported).
	* TODO: Could maybe replace exportAll(File directory, List ... entityLists) ?
	*/
	public void exportSpecial(File directory, Database db, boolean skipAutoId, List<Class<? extends Entity>> specialCases, boolean exclusion, QueryRule ... rules) throws Exception
	{
		if((exclusion && !specialCases.contains(Ontology.class)) || (!exclusion && specialCases.contains(Ontology.class)))
			{ exportOntology(db, new File(directory+"/ontology.txt"), skipAutoId ? Arrays.asList(new String[]{"name","ontologyAccession","ontologyURI"}) : null, rules); }
		if((exclusion && !specialCases.contains(Species.class)) || (!exclusion && specialCases.contains(Species.class)))
			{ exportSpecies(db, new File(directory+"/species.txt"), skipAutoId ? Arrays.asList(new String[]{"name","__Type","ontology_name","termAccession","definition","termPath"}) : null, rules); }
		if((exclusion && !specialCases.contains(AlternateId.class)) || (!exclusion && specialCases.contains(AlternateId.class)))
			{ exportAlternateId(db, new File(directory+"/alternateid.txt"), skipAutoId ? Arrays.asList(new String[]{"name","__Type","ontology_name","termAccession","definition","termPath"}) : null, rules); }
		if((exclusion && !specialCases.contains(OntologyTerm.class)) || (!exclusion && specialCases.contains(OntologyTerm.class)))
			{ exportOntologyTerm(db, new File(directory+"/ontologyterm.txt"), skipAutoId ? Arrays.asList(new String[]{"name","__Type","ontology_name","termAccession","definition","termPath"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisFile.class)) || (!exclusion && specialCases.contains(MolgenisFile.class)))
			{ exportMolgenisFile(db, new File(directory+"/molgenisfile.txt"), skipAutoId ? Arrays.asList(new String[]{"name","__Type","Extension"}) : null, rules); }
		if((exclusion && !specialCases.contains(RuntimeProperty.class)) || (!exclusion && specialCases.contains(RuntimeProperty.class)))
			{ exportRuntimeProperty(db, new File(directory+"/runtimeproperty.txt"), skipAutoId ? Arrays.asList(new String[]{"name","Value"}) : null, rules); }
		if((exclusion && !specialCases.contains(Publication.class)) || (!exclusion && specialCases.contains(Publication.class)))
			{ exportPublication(db, new File(directory+"/publication.txt"), skipAutoId ? Arrays.asList(new String[]{"name","PubmedID_name","DOI_name","authorList","Title","Status_name","Year","Journal"}) : null, rules); }
		if((exclusion && !specialCases.contains(UseCase.class)) || (!exclusion && specialCases.contains(UseCase.class)))
			{ exportUseCase(db, new File(directory+"/usecase.txt"), skipAutoId ? Arrays.asList(new String[]{"UseCaseName","SearchType"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisEntity.class)) || (!exclusion && specialCases.contains(MolgenisEntity.class)))
			{ exportMolgenisEntity(db, new File(directory+"/molgenisentity.txt"), skipAutoId ? Arrays.asList(new String[]{"name","type_","className"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisRole.class)) || (!exclusion && specialCases.contains(MolgenisRole.class)))
			{ exportMolgenisRole(db, new File(directory+"/molgenisrole.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisGroup.class)) || (!exclusion && specialCases.contains(MolgenisGroup.class)))
			{ exportMolgenisGroup(db, new File(directory+"/molgenisgroup.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name"}) : null, rules); }
		if((exclusion && !specialCases.contains(Institute.class)) || (!exclusion && specialCases.contains(Institute.class)))
			{ exportInstitute(db, new File(directory+"/institute.txt"), skipAutoId ? Arrays.asList(new String[]{"Address","Phone","Email","Fax","tollFreePhone","City","Country","name"}) : null, rules); }
		if((exclusion && !specialCases.contains(Person.class)) || (!exclusion && specialCases.contains(Person.class)))
			{ exportPerson(db, new File(directory+"/person.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name","Address","Phone","Email","Fax","tollFreePhone","City","Country","FirstName","MidInitials","LastName","Title","Affiliation_name","Department","Roles_name"}) : null, rules); }
		if((exclusion && !specialCases.contains(Investigation.class)) || (!exclusion && specialCases.contains(Investigation.class)))
			{ exportInvestigation(db, new File(directory+"/investigation.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","startDate","endDate","contacts_name","accession"}) : null, rules); }
		if((exclusion && !specialCases.contains(ObservationElement.class)) || (!exclusion && specialCases.contains(ObservationElement.class)))
			{ exportObservationElement(db, new File(directory+"/observationelement.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label"}) : null, rules); }
		if((exclusion && !specialCases.contains(ObservationTarget.class)) || (!exclusion && specialCases.contains(ObservationTarget.class)))
			{ exportObservationTarget(db, new File(directory+"/observationtarget.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label"}) : null, rules); }
		if((exclusion && !specialCases.contains(ObservableFeature.class)) || (!exclusion && specialCases.contains(ObservableFeature.class)))
			{ exportObservableFeature(db, new File(directory+"/observablefeature.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label"}) : null, rules); }
		if((exclusion && !specialCases.contains(Category.class)) || (!exclusion && specialCases.contains(Category.class)))
			{ exportCategory(db, new File(directory+"/category.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label","code_string","isMissing"}) : null, rules); }
		if((exclusion && !specialCases.contains(Measurement.class)) || (!exclusion && specialCases.contains(Measurement.class)))
			{ exportMeasurement(db, new File(directory+"/measurement.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label","unit_name","dataType","temporal","categories_name","targettypeAllowedForRelation_className","panelLabelAllowedForRelation"}) : null, rules); }
		if((exclusion && !specialCases.contains(Individual.class)) || (!exclusion && specialCases.contains(Individual.class)))
			{ exportIndividual(db, new File(directory+"/individual.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label","Mother_name","Father_name"}) : null, rules); }
		if((exclusion && !specialCases.contains(Location.class)) || (!exclusion && specialCases.contains(Location.class)))
			{ exportLocation(db, new File(directory+"/location.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label"}) : null, rules); }
		if((exclusion && !specialCases.contains(Panel.class)) || (!exclusion && specialCases.contains(Panel.class)))
			{ exportPanel(db, new File(directory+"/panel.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","AlternateId_name","label","Individuals_name","Species_name","PanelType_name","FounderPanels_name"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisUser.class)) || (!exclusion && specialCases.contains(MolgenisUser.class)))
			{ exportMolgenisUser(db, new File(directory+"/molgenisuser.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name","Address","Phone","Email","Fax","tollFreePhone","City","Country","FirstName","MidInitials","LastName","Title","Affiliation_name","Department","Roles_name","password_","activationCode","active","superuser"}) : null, rules); }
		if((exclusion && !specialCases.contains(Protocol.class)) || (!exclusion && specialCases.contains(Protocol.class)))
			{ exportProtocol(db, new File(directory+"/protocol.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","ProtocolType_name","Features_name","TargetFilter","Contact_name","subprotocols_name"}) : null, rules); }
		if((exclusion && !specialCases.contains(Workflow.class)) || (!exclusion && specialCases.contains(Workflow.class)))
			{ exportWorkflow(db, new File(directory+"/workflow.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","__Type","ProtocolType_name","Features_name","TargetFilter","Contact_name","subprotocols_name"}) : null, rules); }
		if((exclusion && !specialCases.contains(ProtocolApplication.class)) || (!exclusion && specialCases.contains(ProtocolApplication.class)))
			{ exportProtocolApplication(db, new File(directory+"/protocolapplication.txt"), skipAutoId ? Arrays.asList(new String[]{"name","description","Investigation_name","ontologyReference_name","time","protocol_name","Performer_name"}) : null, rules); }
		if((exclusion && !specialCases.contains(ObservedValue.class)) || (!exclusion && specialCases.contains(ObservedValue.class)))
			{ exportObservedValue(db, new File(directory+"/observedvalue.txt"), skipAutoId ? Arrays.asList(new String[]{"Investigation_name","protocolApplication_name","Feature_name","Target_name","ontologyReference_name","value","relation_name","time","endtime"}) : null, rules); }
		if((exclusion && !specialCases.contains(ProtocolDocument.class)) || (!exclusion && specialCases.contains(ProtocolDocument.class)))
			{ exportProtocolDocument(db, new File(directory+"/protocoldocument.txt"), skipAutoId ? Arrays.asList(new String[]{"name","__Type","Extension","protocol_name","document"}) : null, rules); }
		if((exclusion && !specialCases.contains(WorkflowElement.class)) || (!exclusion && specialCases.contains(WorkflowElement.class)))
			{ exportWorkflowElement(db, new File(directory+"/workflowelement.txt"), skipAutoId ? Arrays.asList(new String[]{"name","Workflow_name","protocol_name","PreviousSteps_name"}) : null, rules); }
		if((exclusion && !specialCases.contains(WorkflowElementParameter.class)) || (!exclusion && specialCases.contains(WorkflowElementParameter.class)))
			{ exportWorkflowElementParameter(db, new File(directory+"/workflowelementparameter.txt"), skipAutoId ? Arrays.asList(new String[]{"WorkflowElement_name","Parameter_name","Value"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisRoleGroupLink.class)) || (!exclusion && specialCases.contains(MolgenisRoleGroupLink.class)))
			{ exportMolgenisRoleGroupLink(db, new File(directory+"/molgenisrolegrouplink.txt"), skipAutoId ? Arrays.asList(new String[]{"group__name","role__name"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisPermission.class)) || (!exclusion && specialCases.contains(MolgenisPermission.class)))
			{ exportMolgenisPermission(db, new File(directory+"/molgenispermission.txt"), skipAutoId ? Arrays.asList(new String[]{"role__name","entity_className","permission"}) : null, rules); }
	
		logger.debug("done");
	}
	
		private QueryRule[] matchQueryRulesToEntity(org.molgenis.model.elements.Entity e, QueryRule ... rules) throws MolgenisModelException
	{
		ArrayList<QueryRule> tmpResult = new ArrayList<QueryRule>();
		for(QueryRule q : rules){
			if(!(e.getAllField(q.getField()) == null)){
				tmpResult.add(q); //field is okay for this entity
			}
			//special case: eg. investigation.name -> if current entity is 'investigation', use field 'name'
			String[] splitField = q.getField().split("\\.");
			if(splitField.length == 2){
				if(e.getName().equals(splitField[0])){
					QueryRule copy = new QueryRule(q);
					copy.setField(splitField[1]);
					tmpResult.add(copy);
				}
			}
		}
		QueryRule[] result = new QueryRule[tmpResult.size()];
		for(int i=0; i<result.length; i++){
			result[i] = tmpResult.get(i);
		}
		return result;
	}

	/**
	 *	export Ontology to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportOntology(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Ontology.class) > 0)
		{
			
			Query<Ontology> query = db.query(Ontology.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Ontology"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter ontologyWriter = new CsvFileWriter(f);
				query.find(ontologyWriter, fieldsToExport);
				ontologyWriter.close();
			}
		}
	}
	
	public void exportOntology(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter ontologyWriter = new CsvFileWriter(file, notNulls);
			ontologyWriter.writeHeader();
			for(Entity e: entities)
			{
				ontologyWriter.writeRow((org.molgenis.util.Entity)e);
			}
			ontologyWriter.close();
		}
	}
	/**
	 *	export Species to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportSpecies(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Species.class, new QueryRule("__Type",Operator.EQUALS, "Species")) > 0)
		{
			
			Query<Species> query = db.query(Species.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Species");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Species"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter speciesWriter = new CsvFileWriter(f);
				query.find(speciesWriter, fieldsToExport);
				speciesWriter.close();
			}
		}
	}
	
	public void exportSpecies(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter speciesWriter = new CsvFileWriter(file, notNulls);
			speciesWriter.writeHeader();
			for(Entity e: entities)
			{
				speciesWriter.writeRow((org.molgenis.util.Entity)e);
			}
			speciesWriter.close();
		}
	}
	/**
	 *	export AlternateId to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportAlternateId(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(AlternateId.class, new QueryRule("__Type",Operator.EQUALS, "AlternateId")) > 0)
		{
			
			Query<AlternateId> query = db.query(AlternateId.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "AlternateId");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("AlternateId"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter alternateIdWriter = new CsvFileWriter(f);
				query.find(alternateIdWriter, fieldsToExport);
				alternateIdWriter.close();
			}
		}
	}
	
	public void exportAlternateId(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter alternateIdWriter = new CsvFileWriter(file, notNulls);
			alternateIdWriter.writeHeader();
			for(Entity e: entities)
			{
				alternateIdWriter.writeRow((org.molgenis.util.Entity)e);
			}
			alternateIdWriter.close();
		}
	}
	/**
	 *	export OntologyTerm to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportOntologyTerm(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(OntologyTerm.class, new QueryRule("__Type",Operator.EQUALS, "OntologyTerm")) > 0)
		{
			
			Query<OntologyTerm> query = db.query(OntologyTerm.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "OntologyTerm");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("OntologyTerm"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter ontologyTermWriter = new CsvFileWriter(f);
				query.find(ontologyTermWriter, fieldsToExport);
				ontologyTermWriter.close();
			}
		}
	}
	
	public void exportOntologyTerm(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter ontologyTermWriter = new CsvFileWriter(file, notNulls);
			ontologyTermWriter.writeHeader();
			for(Entity e: entities)
			{
				ontologyTermWriter.writeRow((org.molgenis.util.Entity)e);
			}
			ontologyTermWriter.close();
		}
	}
	/**
	 *	export MolgenisFile to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisFile(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisFile.class, new QueryRule("__Type",Operator.EQUALS, "MolgenisFile")) > 0)
		{
			
			Query<MolgenisFile> query = db.query(MolgenisFile.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "MolgenisFile");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisFile"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisFileWriter = new CsvFileWriter(f);
				query.find(molgenisFileWriter, fieldsToExport);
				molgenisFileWriter.close();
			}
		}
	}
	
	public void exportMolgenisFile(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisFileWriter = new CsvFileWriter(file, notNulls);
			molgenisFileWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisFileWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisFileWriter.close();
		}
	}
	/**
	 *	export RuntimeProperty to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportRuntimeProperty(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(RuntimeProperty.class) > 0)
		{
			
			Query<RuntimeProperty> query = db.query(RuntimeProperty.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("RuntimeProperty"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter runtimePropertyWriter = new CsvFileWriter(f);
				query.find(runtimePropertyWriter, fieldsToExport);
				runtimePropertyWriter.close();
			}
		}
	}
	
	public void exportRuntimeProperty(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter runtimePropertyWriter = new CsvFileWriter(file, notNulls);
			runtimePropertyWriter.writeHeader();
			for(Entity e: entities)
			{
				runtimePropertyWriter.writeRow((org.molgenis.util.Entity)e);
			}
			runtimePropertyWriter.close();
		}
	}
	/**
	 *	export Publication to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportPublication(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Publication.class) > 0)
		{
			
			Query<Publication> query = db.query(Publication.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Publication"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter publicationWriter = new CsvFileWriter(f);
				query.find(publicationWriter, fieldsToExport);
				publicationWriter.close();
			}
		}
	}
	
	public void exportPublication(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter publicationWriter = new CsvFileWriter(file, notNulls);
			publicationWriter.writeHeader();
			for(Entity e: entities)
			{
				publicationWriter.writeRow((org.molgenis.util.Entity)e);
			}
			publicationWriter.close();
		}
	}
	/**
	 *	export UseCase to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportUseCase(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(UseCase.class) > 0)
		{
			
			Query<UseCase> query = db.query(UseCase.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("UseCase"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter useCaseWriter = new CsvFileWriter(f);
				query.find(useCaseWriter, fieldsToExport);
				useCaseWriter.close();
			}
		}
	}
	
	public void exportUseCase(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter useCaseWriter = new CsvFileWriter(file, notNulls);
			useCaseWriter.writeHeader();
			for(Entity e: entities)
			{
				useCaseWriter.writeRow((org.molgenis.util.Entity)e);
			}
			useCaseWriter.close();
		}
	}
	/**
	 *	export MolgenisEntity to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisEntity(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisEntity.class) > 0)
		{
			
			Query<MolgenisEntity> query = db.query(MolgenisEntity.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisEntity"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisEntityWriter = new CsvFileWriter(f);
				query.find(molgenisEntityWriter, fieldsToExport);
				molgenisEntityWriter.close();
			}
		}
	}
	
	public void exportMolgenisEntity(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisEntityWriter = new CsvFileWriter(file, notNulls);
			molgenisEntityWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisEntityWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisEntityWriter.close();
		}
	}
	/**
	 *	export MolgenisRole to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisRole(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisRole.class, new QueryRule("__Type",Operator.EQUALS, "MolgenisRole")) > 0)
		{
			
			Query<MolgenisRole> query = db.query(MolgenisRole.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "MolgenisRole");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisRole"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisRoleWriter = new CsvFileWriter(f);
				query.find(molgenisRoleWriter, fieldsToExport);
				molgenisRoleWriter.close();
			}
		}
	}
	
	public void exportMolgenisRole(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisRoleWriter = new CsvFileWriter(file, notNulls);
			molgenisRoleWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisRoleWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisRoleWriter.close();
		}
	}
	/**
	 *	export MolgenisGroup to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisGroup(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisGroup.class, new QueryRule("__Type",Operator.EQUALS, "MolgenisGroup")) > 0)
		{
			
			Query<MolgenisGroup> query = db.query(MolgenisGroup.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "MolgenisGroup");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisGroup"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisGroupWriter = new CsvFileWriter(f);
				query.find(molgenisGroupWriter, fieldsToExport);
				molgenisGroupWriter.close();
			}
		}
	}
	
	public void exportMolgenisGroup(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisGroupWriter = new CsvFileWriter(file, notNulls);
			molgenisGroupWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisGroupWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisGroupWriter.close();
		}
	}
	/**
	 *	export Institute to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportInstitute(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Institute.class) > 0)
		{
			
			Query<Institute> query = db.query(Institute.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Institute"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter instituteWriter = new CsvFileWriter(f);
				query.find(instituteWriter, fieldsToExport);
				instituteWriter.close();
			}
		}
	}
	
	public void exportInstitute(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter instituteWriter = new CsvFileWriter(file, notNulls);
			instituteWriter.writeHeader();
			for(Entity e: entities)
			{
				instituteWriter.writeRow((org.molgenis.util.Entity)e);
			}
			instituteWriter.close();
		}
	}
	/**
	 *	export Person to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportPerson(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Person.class, new QueryRule("__Type",Operator.EQUALS, "Person")) > 0)
		{
			
			Query<Person> query = db.query(Person.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Person");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Person"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter personWriter = new CsvFileWriter(f);
				query.find(personWriter, fieldsToExport);
				personWriter.close();
			}
		}
	}
	
	public void exportPerson(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter personWriter = new CsvFileWriter(file, notNulls);
			personWriter.writeHeader();
			for(Entity e: entities)
			{
				personWriter.writeRow((org.molgenis.util.Entity)e);
			}
			personWriter.close();
		}
	}
	/**
	 *	export Investigation to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportInvestigation(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Investigation.class) > 0)
		{
			
			Query<Investigation> query = db.query(Investigation.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Investigation"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter investigationWriter = new CsvFileWriter(f);
				query.find(investigationWriter, fieldsToExport);
				investigationWriter.close();
			}
		}
	}
	
	public void exportInvestigation(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter investigationWriter = new CsvFileWriter(file, notNulls);
			investigationWriter.writeHeader();
			for(Entity e: entities)
			{
				investigationWriter.writeRow((org.molgenis.util.Entity)e);
			}
			investigationWriter.close();
		}
	}
	/**
	 *	export ObservationElement to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportObservationElement(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(ObservationElement.class, new QueryRule("__Type",Operator.EQUALS, "ObservationElement")) > 0)
		{
			
			Query<ObservationElement> query = db.query(ObservationElement.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "ObservationElement");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("ObservationElement"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter observationElementWriter = new CsvFileWriter(f);
				query.find(observationElementWriter, fieldsToExport);
				observationElementWriter.close();
			}
		}
	}
	
	public void exportObservationElement(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter observationElementWriter = new CsvFileWriter(file, notNulls);
			observationElementWriter.writeHeader();
			for(Entity e: entities)
			{
				observationElementWriter.writeRow((org.molgenis.util.Entity)e);
			}
			observationElementWriter.close();
		}
	}
	/**
	 *	export ObservationTarget to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportObservationTarget(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(ObservationTarget.class, new QueryRule("__Type",Operator.EQUALS, "ObservationTarget")) > 0)
		{
			
			Query<ObservationTarget> query = db.query(ObservationTarget.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "ObservationTarget");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("ObservationTarget"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter observationTargetWriter = new CsvFileWriter(f);
				query.find(observationTargetWriter, fieldsToExport);
				observationTargetWriter.close();
			}
		}
	}
	
	public void exportObservationTarget(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter observationTargetWriter = new CsvFileWriter(file, notNulls);
			observationTargetWriter.writeHeader();
			for(Entity e: entities)
			{
				observationTargetWriter.writeRow((org.molgenis.util.Entity)e);
			}
			observationTargetWriter.close();
		}
	}
	/**
	 *	export ObservableFeature to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportObservableFeature(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(ObservableFeature.class, new QueryRule("__Type",Operator.EQUALS, "ObservableFeature")) > 0)
		{
			
			Query<ObservableFeature> query = db.query(ObservableFeature.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "ObservableFeature");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("ObservableFeature"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter observableFeatureWriter = new CsvFileWriter(f);
				query.find(observableFeatureWriter, fieldsToExport);
				observableFeatureWriter.close();
			}
		}
	}
	
	public void exportObservableFeature(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter observableFeatureWriter = new CsvFileWriter(file, notNulls);
			observableFeatureWriter.writeHeader();
			for(Entity e: entities)
			{
				observableFeatureWriter.writeRow((org.molgenis.util.Entity)e);
			}
			observableFeatureWriter.close();
		}
	}
	/**
	 *	export Category to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportCategory(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Category.class, new QueryRule("__Type",Operator.EQUALS, "Category")) > 0)
		{
			
			Query<Category> query = db.query(Category.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Category");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Category"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter categoryWriter = new CsvFileWriter(f);
				query.find(categoryWriter, fieldsToExport);
				categoryWriter.close();
			}
		}
	}
	
	public void exportCategory(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter categoryWriter = new CsvFileWriter(file, notNulls);
			categoryWriter.writeHeader();
			for(Entity e: entities)
			{
				categoryWriter.writeRow((org.molgenis.util.Entity)e);
			}
			categoryWriter.close();
		}
	}
	/**
	 *	export Measurement to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMeasurement(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Measurement.class, new QueryRule("__Type",Operator.EQUALS, "Measurement")) > 0)
		{
			
			Query<Measurement> query = db.query(Measurement.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Measurement");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Measurement"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter measurementWriter = new CsvFileWriter(f);
				query.find(measurementWriter, fieldsToExport);
				measurementWriter.close();
			}
		}
	}
	
	public void exportMeasurement(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter measurementWriter = new CsvFileWriter(file, notNulls);
			measurementWriter.writeHeader();
			for(Entity e: entities)
			{
				measurementWriter.writeRow((org.molgenis.util.Entity)e);
			}
			measurementWriter.close();
		}
	}
	/**
	 *	export Individual to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportIndividual(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Individual.class, new QueryRule("__Type",Operator.EQUALS, "Individual")) > 0)
		{
			
			Query<Individual> query = db.query(Individual.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Individual");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Individual"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter individualWriter = new CsvFileWriter(f);
				query.find(individualWriter, fieldsToExport);
				individualWriter.close();
			}
		}
	}
	
	public void exportIndividual(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter individualWriter = new CsvFileWriter(file, notNulls);
			individualWriter.writeHeader();
			for(Entity e: entities)
			{
				individualWriter.writeRow((org.molgenis.util.Entity)e);
			}
			individualWriter.close();
		}
	}
	/**
	 *	export Location to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportLocation(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Location.class, new QueryRule("__Type",Operator.EQUALS, "Location")) > 0)
		{
			
			Query<Location> query = db.query(Location.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Location");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Location"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter locationWriter = new CsvFileWriter(f);
				query.find(locationWriter, fieldsToExport);
				locationWriter.close();
			}
		}
	}
	
	public void exportLocation(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter locationWriter = new CsvFileWriter(file, notNulls);
			locationWriter.writeHeader();
			for(Entity e: entities)
			{
				locationWriter.writeRow((org.molgenis.util.Entity)e);
			}
			locationWriter.close();
		}
	}
	/**
	 *	export Panel to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportPanel(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Panel.class, new QueryRule("__Type",Operator.EQUALS, "Panel")) > 0)
		{
			
			Query<Panel> query = db.query(Panel.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Panel");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Panel"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter panelWriter = new CsvFileWriter(f);
				query.find(panelWriter, fieldsToExport);
				panelWriter.close();
			}
		}
	}
	
	public void exportPanel(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter panelWriter = new CsvFileWriter(file, notNulls);
			panelWriter.writeHeader();
			for(Entity e: entities)
			{
				panelWriter.writeRow((org.molgenis.util.Entity)e);
			}
			panelWriter.close();
		}
	}
	/**
	 *	export MolgenisUser to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisUser(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisUser.class, new QueryRule("__Type",Operator.EQUALS, "MolgenisUser")) > 0)
		{
			
			Query<MolgenisUser> query = db.query(MolgenisUser.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "MolgenisUser");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisUser"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisUserWriter = new CsvFileWriter(f);
				query.find(molgenisUserWriter, fieldsToExport);
				molgenisUserWriter.close();
			}
		}
	}
	
	public void exportMolgenisUser(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisUserWriter = new CsvFileWriter(file, notNulls);
			molgenisUserWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisUserWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisUserWriter.close();
		}
	}
	/**
	 *	export Protocol to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportProtocol(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Protocol.class, new QueryRule("__Type",Operator.EQUALS, "Protocol")) > 0)
		{
			
			Query<Protocol> query = db.query(Protocol.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Protocol");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Protocol"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter protocolWriter = new CsvFileWriter(f);
				query.find(protocolWriter, fieldsToExport);
				protocolWriter.close();
			}
		}
	}
	
	public void exportProtocol(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter protocolWriter = new CsvFileWriter(file, notNulls);
			protocolWriter.writeHeader();
			for(Entity e: entities)
			{
				protocolWriter.writeRow((org.molgenis.util.Entity)e);
			}
			protocolWriter.close();
		}
	}
	/**
	 *	export Workflow to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportWorkflow(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Workflow.class, new QueryRule("__Type",Operator.EQUALS, "Workflow")) > 0)
		{
			
			Query<Workflow> query = db.query(Workflow.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Workflow");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Workflow"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter workflowWriter = new CsvFileWriter(f);
				query.find(workflowWriter, fieldsToExport);
				workflowWriter.close();
			}
		}
	}
	
	public void exportWorkflow(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter workflowWriter = new CsvFileWriter(file, notNulls);
			workflowWriter.writeHeader();
			for(Entity e: entities)
			{
				workflowWriter.writeRow((org.molgenis.util.Entity)e);
			}
			workflowWriter.close();
		}
	}
	/**
	 *	export ProtocolApplication to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportProtocolApplication(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(ProtocolApplication.class) > 0)
		{
			
			Query<ProtocolApplication> query = db.query(ProtocolApplication.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("ProtocolApplication"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter protocolApplicationWriter = new CsvFileWriter(f);
				query.find(protocolApplicationWriter, fieldsToExport);
				protocolApplicationWriter.close();
			}
		}
	}
	
	public void exportProtocolApplication(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter protocolApplicationWriter = new CsvFileWriter(file, notNulls);
			protocolApplicationWriter.writeHeader();
			for(Entity e: entities)
			{
				protocolApplicationWriter.writeRow((org.molgenis.util.Entity)e);
			}
			protocolApplicationWriter.close();
		}
	}
	/**
	 *	export ObservedValue to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportObservedValue(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(ObservedValue.class) > 0)
		{
			
			Query<ObservedValue> query = db.query(ObservedValue.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("ObservedValue"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter observedValueWriter = new CsvFileWriter(f);
				query.find(observedValueWriter, fieldsToExport);
				observedValueWriter.close();
			}
		}
	}
	
	public void exportObservedValue(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter observedValueWriter = new CsvFileWriter(file, notNulls);
			observedValueWriter.writeHeader();
			for(Entity e: entities)
			{
				observedValueWriter.writeRow((org.molgenis.util.Entity)e);
			}
			observedValueWriter.close();
		}
	}
	/**
	 *	export ProtocolDocument to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportProtocolDocument(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(ProtocolDocument.class, new QueryRule("__Type",Operator.EQUALS, "ProtocolDocument")) > 0)
		{
			
			Query<ProtocolDocument> query = db.query(ProtocolDocument.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "ProtocolDocument");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("ProtocolDocument"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter protocolDocumentWriter = new CsvFileWriter(f);
				query.find(protocolDocumentWriter, fieldsToExport);
				protocolDocumentWriter.close();
			}
		}
	}
	
	public void exportProtocolDocument(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter protocolDocumentWriter = new CsvFileWriter(file, notNulls);
			protocolDocumentWriter.writeHeader();
			for(Entity e: entities)
			{
				protocolDocumentWriter.writeRow((org.molgenis.util.Entity)e);
			}
			protocolDocumentWriter.close();
		}
	}
	/**
	 *	export WorkflowElement to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportWorkflowElement(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(WorkflowElement.class) > 0)
		{
			
			Query<WorkflowElement> query = db.query(WorkflowElement.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("WorkflowElement"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter workflowElementWriter = new CsvFileWriter(f);
				query.find(workflowElementWriter, fieldsToExport);
				workflowElementWriter.close();
			}
		}
	}
	
	public void exportWorkflowElement(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter workflowElementWriter = new CsvFileWriter(file, notNulls);
			workflowElementWriter.writeHeader();
			for(Entity e: entities)
			{
				workflowElementWriter.writeRow((org.molgenis.util.Entity)e);
			}
			workflowElementWriter.close();
		}
	}
	/**
	 *	export WorkflowElementParameter to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportWorkflowElementParameter(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(WorkflowElementParameter.class) > 0)
		{
			
			Query<WorkflowElementParameter> query = db.query(WorkflowElementParameter.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("WorkflowElementParameter"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter workflowElementParameterWriter = new CsvFileWriter(f);
				query.find(workflowElementParameterWriter, fieldsToExport);
				workflowElementParameterWriter.close();
			}
		}
	}
	
	public void exportWorkflowElementParameter(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter workflowElementParameterWriter = new CsvFileWriter(file, notNulls);
			workflowElementParameterWriter.writeHeader();
			for(Entity e: entities)
			{
				workflowElementParameterWriter.writeRow((org.molgenis.util.Entity)e);
			}
			workflowElementParameterWriter.close();
		}
	}
	/**
	 *	export MolgenisRoleGroupLink to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisRoleGroupLink(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisRoleGroupLink.class) > 0)
		{
			
			Query<MolgenisRoleGroupLink> query = db.query(MolgenisRoleGroupLink.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisRoleGroupLink"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisRoleGroupLinkWriter = new CsvFileWriter(f);
				query.find(molgenisRoleGroupLinkWriter, fieldsToExport);
				molgenisRoleGroupLinkWriter.close();
			}
		}
	}
	
	public void exportMolgenisRoleGroupLink(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisRoleGroupLinkWriter = new CsvFileWriter(file, notNulls);
			molgenisRoleGroupLinkWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisRoleGroupLinkWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisRoleGroupLinkWriter.close();
		}
	}
	/**
	 *	export MolgenisPermission to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisPermission(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisPermission.class) > 0)
		{
			
			Query<MolgenisPermission> query = db.query(MolgenisPermission.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisPermission"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisPermissionWriter = new CsvFileWriter(f);
				query.find(molgenisPermissionWriter, fieldsToExport);
				molgenisPermissionWriter.close();
			}
		}
	}
	
	public void exportMolgenisPermission(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisPermissionWriter = new CsvFileWriter(file, notNulls);
			molgenisPermissionWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisPermissionWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisPermissionWriter.close();
		}
	}
}