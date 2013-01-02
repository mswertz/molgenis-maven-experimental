
/* Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvImportByIdGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.util.CsvReader;
import org.molgenis.util.CsvFileReader;

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


public class CsvImportById
{
	static Logger logger = Logger.getLogger(CsvImport.class.getSimpleName());
	//mappings between imported and internally assigned ids
	//only necessary for automatic ids
	static Map<Integer,Integer> identifiableIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> nameableIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> ontologyIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> speciesIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> alternateIdIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> ontologyTermIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisFileIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> runtimePropertyIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> publicationIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> useCaseIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisEntityIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisRoleIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisGroupIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> contactIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> instituteIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> personIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> investigationIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> observationElementIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> observationTargetIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> observableFeatureIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> categoryIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> measurementIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> individualIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> locationIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> panelIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> investigationElementIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisUserIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> protocolIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> workflowIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> protocolApplicationIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> observationIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> observedValueIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> protocolDocumentIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> workflowElementIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> workflowElementParameterIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisRoleGroupLinkIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisPermissionIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> observationElement_ontolo12449IdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> observationElement_AlternateIdIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> measurement_categoriesIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> panel_IndividualsIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> panel_FounderPanelsIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> investigation_contactsIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> protocol_ontologyReferenceIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> protocol_FeaturesIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> protocol_subprotocolsIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> protocolApplication_ontol11768IdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> protocolApplication_PerformerIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> workflowElement_PreviousStepsIdMap = new TreeMap<Integer,Integer>(); 

	/**
	 * Csv import of whole database.
	 * TODO: add filter parameters...
	 */
	public static void importData(File directory, Database db) throws Exception
	{
		try
		{
			db.beginTx();
						
			importOntology(db, new File(directory + "/ontology.txt"));
			importSpecies(db, new File(directory + "/species.txt"));
			importAlternateId(db, new File(directory + "/alternateid.txt"));
			importOntologyTerm(db, new File(directory + "/ontologyterm.txt"));
			importMolgenisFile(db, new File(directory + "/molgenisfile.txt"));
			importRuntimeProperty(db, new File(directory + "/runtimeproperty.txt"));
			importPublication(db, new File(directory + "/publication.txt"));
			importUseCase(db, new File(directory + "/usecase.txt"));
			importMolgenisEntity(db, new File(directory + "/molgenisentity.txt"));
			importMolgenisRole(db, new File(directory + "/molgenisrole.txt"));
			importMolgenisGroup(db, new File(directory + "/molgenisgroup.txt"));
			importInstitute(db, new File(directory + "/institute.txt"));
			importPerson(db, new File(directory + "/person.txt"));
			importInvestigation(db, new File(directory + "/investigation.txt"));
			importObservationElement(db, new File(directory + "/observationelement.txt"));
			importObservationTarget(db, new File(directory + "/observationtarget.txt"));
			importObservableFeature(db, new File(directory + "/observablefeature.txt"));
			importCategory(db, new File(directory + "/category.txt"));
			importMeasurement(db, new File(directory + "/measurement.txt"));
			importIndividual(db, new File(directory + "/individual.txt"));
			importLocation(db, new File(directory + "/location.txt"));
			importPanel(db, new File(directory + "/panel.txt"));
			importMolgenisUser(db, new File(directory + "/molgenisuser.txt"));
			importProtocol(db, new File(directory + "/protocol.txt"));
			importWorkflow(db, new File(directory + "/workflow.txt"));
			importProtocolApplication(db, new File(directory + "/protocolapplication.txt"));
			importObservedValue(db, new File(directory + "/observedvalue.txt"));
			importProtocolDocument(db, new File(directory + "/protocoldocument.txt"));
			importWorkflowElement(db, new File(directory + "/workflowelement.txt"));
			importWorkflowElementParameter(db, new File(directory + "/workflowelementparameter.txt"));
			importMolgenisRoleGroupLink(db, new File(directory + "/molgenisrolegrouplink.txt"));
			importMolgenisPermission(db, new File(directory + "/molgenispermission.txt"));
			importObservationElement_Ontolo12449(db, new File(directory + "/observationelement_ontolo12449.txt"));
			importObservationElement_AlternateId(db, new File(directory + "/observationelement_alternateid.txt"));
			importMeasurement_Categories(db, new File(directory + "/measurement_categories.txt"));
			importPanel_Individuals(db, new File(directory + "/panel_individuals.txt"));
			importPanel_FounderPanels(db, new File(directory + "/panel_founderpanels.txt"));
			importInvestigation_Contacts(db, new File(directory + "/investigation_contacts.txt"));
			importProtocol_OntologyReference(db, new File(directory + "/protocol_ontologyreference.txt"));
			importProtocol_Features(db, new File(directory + "/protocol_features.txt"));
			importProtocol_Subprotocols(db, new File(directory + "/protocol_subprotocols.txt"));
			importProtocolApplication_Ontol11768(db, new File(directory + "/protocolapplication_ontol11768.txt"));
			importProtocolApplication_Performer(db, new File(directory + "/protocolapplication_performer.txt"));
			importWorkflowElement_PreviousSteps(db, new File(directory + "/workflowelement_previoussteps.txt"));
			
			// insert back again...
			logger.debug("commiting transactions...");
			
			db.commitTx();
		}
		catch (Exception e)
		{
			logger.error("import failed: " + e.getMessage());
			logger.debug("rolling back transactions...");
			db.rollbackTx();

			throw e;
		}

		logger.debug("done");
	}
	
	/**
	 * Imports Ontology from tab/comma delimited File.
	 * @param OntologyFile a tab delimited file with Ontology data.
	 */
	private static void importOntology(Database db, File OntologyFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+OntologyFile);
		if(	!OntologyFile.exists() )
		{
			logger.warn("Ontology.txt file is missing, skipped import");
		}
		else
		{
			//read Ontology from file
			CsvReader reader = new CsvFileReader(OntologyFile);
			List<Ontology> ontologyList = db.toList(Ontology.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+ontologyList.size()+" Ontology objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> ontologyIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < ontologyList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Ontology object = ontologyList.get(i);
				
				//remember index of this id for incoming fkeys
				ontologyIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				ontologyList.set(i, object);
			}
			//add to database
			db.add(ontologyList);
			for(int i = 0; i < ontologyList.size(); i++)
			{
				ontologyIdMap.put(ontologyIds.get(i), ontologyList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Species from tab/comma delimited File.
	 * @param SpeciesFile a tab delimited file with Species data.
	 */
	private static void importSpecies(Database db, File SpeciesFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+SpeciesFile);
		if(	!SpeciesFile.exists() )
		{
			logger.warn("Species.txt file is missing, skipped import");
		}
		else
		{
			//read Species from file
			CsvReader reader = new CsvFileReader(SpeciesFile);
			List<Species> speciesList = db.toList(Species.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+speciesList.size()+" Species objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> speciesIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < speciesList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Species object = speciesList.get(i);
				
				//remember index of this id for incoming fkeys
				speciesIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getOntology() != null) object.setOntology_Id(ontologyIdMap.get(object.getOntology_Id()));
				
				//add assay back to list
				speciesList.set(i, object);
			}
			//add to database
			db.add(speciesList);
			for(int i = 0; i < speciesList.size(); i++)
			{
				speciesIdMap.put(speciesIds.get(i), speciesList.get(i).getId());
				ontologyTermIdMap.put(speciesIds.get(i), speciesList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports AlternateId from tab/comma delimited File.
	 * @param AlternateIdFile a tab delimited file with AlternateId data.
	 */
	private static void importAlternateId(Database db, File AlternateIdFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+AlternateIdFile);
		if(	!AlternateIdFile.exists() )
		{
			logger.warn("AlternateId.txt file is missing, skipped import");
		}
		else
		{
			//read AlternateId from file
			CsvReader reader = new CsvFileReader(AlternateIdFile);
			List<AlternateId> alternateIdList = db.toList(AlternateId.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+alternateIdList.size()+" AlternateId objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> alternateIdIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < alternateIdList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				AlternateId object = alternateIdList.get(i);
				
				//remember index of this id for incoming fkeys
				alternateIdIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getOntology() != null) object.setOntology_Id(ontologyIdMap.get(object.getOntology_Id()));
				
				//add assay back to list
				alternateIdList.set(i, object);
			}
			//add to database
			db.add(alternateIdList);
			for(int i = 0; i < alternateIdList.size(); i++)
			{
				alternateIdIdMap.put(alternateIdIds.get(i), alternateIdList.get(i).getId());
				ontologyTermIdMap.put(alternateIdIds.get(i), alternateIdList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports OntologyTerm from tab/comma delimited File.
	 * @param OntologyTermFile a tab delimited file with OntologyTerm data.
	 */
	private static void importOntologyTerm(Database db, File OntologyTermFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+OntologyTermFile);
		if(	!OntologyTermFile.exists() )
		{
			logger.warn("OntologyTerm.txt file is missing, skipped import");
		}
		else
		{
			//read OntologyTerm from file
			CsvReader reader = new CsvFileReader(OntologyTermFile);
			List<OntologyTerm> ontologyTermList = db.toList(OntologyTerm.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+ontologyTermList.size()+" OntologyTerm objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> ontologyTermIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < ontologyTermList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				OntologyTerm object = ontologyTermList.get(i);
				
				//remember index of this id for incoming fkeys
				ontologyTermIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getOntology() != null) object.setOntology_Id(ontologyIdMap.get(object.getOntology_Id()));
				
				//add assay back to list
				ontologyTermList.set(i, object);
			}
			//add to database
			db.add(ontologyTermList);
			for(int i = 0; i < ontologyTermList.size(); i++)
			{
				ontologyTermIdMap.put(ontologyTermIds.get(i), ontologyTermList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports MolgenisFile from tab/comma delimited File.
	 * @param MolgenisFileFile a tab delimited file with MolgenisFile data.
	 */
	private static void importMolgenisFile(Database db, File MolgenisFileFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+MolgenisFileFile);
		if(	!MolgenisFileFile.exists() )
		{
			logger.warn("MolgenisFile.txt file is missing, skipped import");
		}
		else
		{
			//read MolgenisFile from file
			CsvReader reader = new CsvFileReader(MolgenisFileFile);
			List<MolgenisFile> molgenisFileList = db.toList(MolgenisFile.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+molgenisFileList.size()+" MolgenisFile objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> molgenisFileIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < molgenisFileList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				MolgenisFile object = molgenisFileList.get(i);
				
				//remember index of this id for incoming fkeys
				molgenisFileIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				molgenisFileList.set(i, object);
			}
			//add to database
			db.add(molgenisFileList);
			for(int i = 0; i < molgenisFileList.size(); i++)
			{
				molgenisFileIdMap.put(molgenisFileIds.get(i), molgenisFileList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports RuntimeProperty from tab/comma delimited File.
	 * @param RuntimePropertyFile a tab delimited file with RuntimeProperty data.
	 */
	private static void importRuntimeProperty(Database db, File RuntimePropertyFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+RuntimePropertyFile);
		if(	!RuntimePropertyFile.exists() )
		{
			logger.warn("RuntimeProperty.txt file is missing, skipped import");
		}
		else
		{
			//read RuntimeProperty from file
			CsvReader reader = new CsvFileReader(RuntimePropertyFile);
			List<RuntimeProperty> runtimePropertyList = db.toList(RuntimeProperty.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+runtimePropertyList.size()+" RuntimeProperty objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> runtimePropertyIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < runtimePropertyList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				RuntimeProperty object = runtimePropertyList.get(i);
				
				//remember index of this id for incoming fkeys
				runtimePropertyIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				runtimePropertyList.set(i, object);
			}
			//add to database
			db.add(runtimePropertyList);
			for(int i = 0; i < runtimePropertyList.size(); i++)
			{
				runtimePropertyIdMap.put(runtimePropertyIds.get(i), runtimePropertyList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Publication from tab/comma delimited File.
	 * @param PublicationFile a tab delimited file with Publication data.
	 */
	private static void importPublication(Database db, File PublicationFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+PublicationFile);
		if(	!PublicationFile.exists() )
		{
			logger.warn("Publication.txt file is missing, skipped import");
		}
		else
		{
			//read Publication from file
			CsvReader reader = new CsvFileReader(PublicationFile);
			List<Publication> publicationList = db.toList(Publication.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+publicationList.size()+" Publication objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> publicationIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < publicationList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Publication object = publicationList.get(i);
				
				//remember index of this id for incoming fkeys
				publicationIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getPubmedID() != null) object.setPubmedID_Id(ontologyTermIdMap.get(object.getPubmedID_Id()));
				if(object.getDOI() != null) object.setDOI_Id(ontologyTermIdMap.get(object.getDOI_Id()));
				if(object.getStatus() != null) object.setStatus_Id(ontologyTermIdMap.get(object.getStatus_Id()));
				
				//add assay back to list
				publicationList.set(i, object);
			}
			//add to database
			db.add(publicationList);
			for(int i = 0; i < publicationList.size(); i++)
			{
				publicationIdMap.put(publicationIds.get(i), publicationList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports UseCase from tab/comma delimited File.
	 * @param UseCaseFile a tab delimited file with UseCase data.
	 */
	private static void importUseCase(Database db, File UseCaseFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+UseCaseFile);
		if(	!UseCaseFile.exists() )
		{
			logger.warn("UseCase.txt file is missing, skipped import");
		}
		else
		{
			//read UseCase from file
			CsvReader reader = new CsvFileReader(UseCaseFile);
			List<UseCase> useCaseList = db.toList(UseCase.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+useCaseList.size()+" UseCase objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> useCaseIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < useCaseList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				UseCase object = useCaseList.get(i);
				
				//remember index of this id for incoming fkeys
				useCaseIds.add(object.getUseCaseId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				useCaseList.set(i, object);
			}
			//add to database
			db.add(useCaseList);
			for(int i = 0; i < useCaseList.size(); i++)
			{
				useCaseIdMap.put(useCaseIds.get(i), useCaseList.get(i).getUseCaseId());
			}
		}	 
	}
	/**
	 * Imports MolgenisEntity from tab/comma delimited File.
	 * @param MolgenisEntityFile a tab delimited file with MolgenisEntity data.
	 */
	private static void importMolgenisEntity(Database db, File MolgenisEntityFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+MolgenisEntityFile);
		if(	!MolgenisEntityFile.exists() )
		{
			logger.warn("MolgenisEntity.txt file is missing, skipped import");
		}
		else
		{
			//read MolgenisEntity from file
			CsvReader reader = new CsvFileReader(MolgenisEntityFile);
			List<MolgenisEntity> molgenisEntityList = db.toList(MolgenisEntity.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+molgenisEntityList.size()+" MolgenisEntity objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> molgenisEntityIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < molgenisEntityList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				MolgenisEntity object = molgenisEntityList.get(i);
				
				//remember index of this id for incoming fkeys
				molgenisEntityIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				molgenisEntityList.set(i, object);
			}
			//add to database
			db.add(molgenisEntityList);
			for(int i = 0; i < molgenisEntityList.size(); i++)
			{
				molgenisEntityIdMap.put(molgenisEntityIds.get(i), molgenisEntityList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports MolgenisRole from tab/comma delimited File.
	 * @param MolgenisRoleFile a tab delimited file with MolgenisRole data.
	 */
	private static void importMolgenisRole(Database db, File MolgenisRoleFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+MolgenisRoleFile);
		if(	!MolgenisRoleFile.exists() )
		{
			logger.warn("MolgenisRole.txt file is missing, skipped import");
		}
		else
		{
			//read MolgenisRole from file
			CsvReader reader = new CsvFileReader(MolgenisRoleFile);
			List<MolgenisRole> molgenisRoleList = db.toList(MolgenisRole.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+molgenisRoleList.size()+" MolgenisRole objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> molgenisRoleIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < molgenisRoleList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				MolgenisRole object = molgenisRoleList.get(i);
				
				//remember index of this id for incoming fkeys
				molgenisRoleIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				molgenisRoleList.set(i, object);
			}
			//add to database
			db.add(molgenisRoleList);
			for(int i = 0; i < molgenisRoleList.size(); i++)
			{
				molgenisRoleIdMap.put(molgenisRoleIds.get(i), molgenisRoleList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports MolgenisGroup from tab/comma delimited File.
	 * @param MolgenisGroupFile a tab delimited file with MolgenisGroup data.
	 */
	private static void importMolgenisGroup(Database db, File MolgenisGroupFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+MolgenisGroupFile);
		if(	!MolgenisGroupFile.exists() )
		{
			logger.warn("MolgenisGroup.txt file is missing, skipped import");
		}
		else
		{
			//read MolgenisGroup from file
			CsvReader reader = new CsvFileReader(MolgenisGroupFile);
			List<MolgenisGroup> molgenisGroupList = db.toList(MolgenisGroup.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+molgenisGroupList.size()+" MolgenisGroup objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> molgenisGroupIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < molgenisGroupList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				MolgenisGroup object = molgenisGroupList.get(i);
				
				//remember index of this id for incoming fkeys
				molgenisGroupIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				molgenisGroupList.set(i, object);
			}
			//add to database
			db.add(molgenisGroupList);
			for(int i = 0; i < molgenisGroupList.size(); i++)
			{
				molgenisGroupIdMap.put(molgenisGroupIds.get(i), molgenisGroupList.get(i).getId());
				molgenisRoleIdMap.put(molgenisGroupIds.get(i), molgenisGroupList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Institute from tab/comma delimited File.
	 * @param InstituteFile a tab delimited file with Institute data.
	 */
	private static void importInstitute(Database db, File InstituteFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+InstituteFile);
		if(	!InstituteFile.exists() )
		{
			logger.warn("Institute.txt file is missing, skipped import");
		}
		else
		{
			//read Institute from file
			CsvReader reader = new CsvFileReader(InstituteFile);
			List<Institute> instituteList = db.toList(Institute.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+instituteList.size()+" Institute objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> instituteIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < instituteList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Institute object = instituteList.get(i);
				
				//remember index of this id for incoming fkeys
				instituteIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				
				//add assay back to list
				instituteList.set(i, object);
			}
			//add to database
			db.add(instituteList);
			for(int i = 0; i < instituteList.size(); i++)
			{
				instituteIdMap.put(instituteIds.get(i), instituteList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Person from tab/comma delimited File.
	 * @param PersonFile a tab delimited file with Person data.
	 */
	private static void importPerson(Database db, File PersonFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+PersonFile);
		if(	!PersonFile.exists() )
		{
			logger.warn("Person.txt file is missing, skipped import");
		}
		else
		{
			//read Person from file
			CsvReader reader = new CsvFileReader(PersonFile);
			List<Person> personList = db.toList(Person.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+personList.size()+" Person objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> personIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < personList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Person object = personList.get(i);
				
				//remember index of this id for incoming fkeys
				personIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getAffiliation() != null) object.setAffiliation_Id(instituteIdMap.get(object.getAffiliation_Id()));
				if(object.getRoles() != null) object.setRoles_Id(ontologyTermIdMap.get(object.getRoles_Id()));
				
				//add assay back to list
				personList.set(i, object);
			}
			//add to database
			db.add(personList);
			for(int i = 0; i < personList.size(); i++)
			{
				personIdMap.put(personIds.get(i), personList.get(i).getId());
				molgenisRoleIdMap.put(personIds.get(i), personList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Investigation from tab/comma delimited File.
	 * @param InvestigationFile a tab delimited file with Investigation data.
	 */
	private static void importInvestigation(Database db, File InvestigationFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+InvestigationFile);
		if(	!InvestigationFile.exists() )
		{
			logger.warn("Investigation.txt file is missing, skipped import");
		}
		else
		{
			//read Investigation from file
			CsvReader reader = new CsvFileReader(InvestigationFile);
			List<Investigation> investigationList = db.toList(Investigation.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+investigationList.size()+" Investigation objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> investigationIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < investigationList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Investigation object = investigationList.get(i);
				
				//remember index of this id for incoming fkeys
				investigationIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				List<Integer > contactsIds = new ArrayList<Integer>();
				for(Integer id: object.getContacts_Id())
				{
					contactsIds.add(personIdMap.get(id));
				}
				
				//add assay back to list
				investigationList.set(i, object);
			}
			//add to database
			db.add(investigationList);
			for(int i = 0; i < investigationList.size(); i++)
			{
				investigationIdMap.put(investigationIds.get(i), investigationList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports ObservationElement from tab/comma delimited File.
	 * @param ObservationElementFile a tab delimited file with ObservationElement data.
	 */
	private static void importObservationElement(Database db, File ObservationElementFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ObservationElementFile);
		if(	!ObservationElementFile.exists() )
		{
			logger.warn("ObservationElement.txt file is missing, skipped import");
		}
		else
		{
			//read ObservationElement from file
			CsvReader reader = new CsvFileReader(ObservationElementFile);
			List<ObservationElement> observationElementList = db.toList(ObservationElement.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+observationElementList.size()+" ObservationElement objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> observationElementIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < observationElementList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				ObservationElement object = observationElementList.get(i);
				
				//remember index of this id for incoming fkeys
				observationElementIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getInvestigation() != null) object.setInvestigation_Id(investigationIdMap.get(object.getInvestigation_Id()));
				List<Integer > ontologyReferenceIds = new ArrayList<Integer>();
				for(Integer id: object.getOntologyReference_Id())
				{
					ontologyReferenceIds.add(ontologyTermIdMap.get(id));
				}
				List<Integer > alternateIdIds = new ArrayList<Integer>();
				for(Integer id: object.getAlternateId_Id())
				{
					alternateIdIds.add(alternateIdIdMap.get(id));
				}
				
				//add assay back to list
				observationElementList.set(i, object);
			}
			//add to database
			db.add(observationElementList);
			for(int i = 0; i < observationElementList.size(); i++)
			{
				observationElementIdMap.put(observationElementIds.get(i), observationElementList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports ObservationTarget from tab/comma delimited File.
	 * @param ObservationTargetFile a tab delimited file with ObservationTarget data.
	 */
	private static void importObservationTarget(Database db, File ObservationTargetFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ObservationTargetFile);
		if(	!ObservationTargetFile.exists() )
		{
			logger.warn("ObservationTarget.txt file is missing, skipped import");
		}
		else
		{
			//read ObservationTarget from file
			CsvReader reader = new CsvFileReader(ObservationTargetFile);
			List<ObservationTarget> observationTargetList = db.toList(ObservationTarget.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+observationTargetList.size()+" ObservationTarget objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> observationTargetIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < observationTargetList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				ObservationTarget object = observationTargetList.get(i);
				
				//remember index of this id for incoming fkeys
				observationTargetIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getInvestigation() != null) object.setInvestigation_Id(investigationIdMap.get(object.getInvestigation_Id()));
				List<Integer > ontologyReferenceIds = new ArrayList<Integer>();
				for(Integer id: object.getOntologyReference_Id())
				{
					ontologyReferenceIds.add(ontologyTermIdMap.get(id));
				}
				List<Integer > alternateIdIds = new ArrayList<Integer>();
				for(Integer id: object.getAlternateId_Id())
				{
					alternateIdIds.add(alternateIdIdMap.get(id));
				}
				
				//add assay back to list
				observationTargetList.set(i, object);
			}
			//add to database
			db.add(observationTargetList);
			for(int i = 0; i < observationTargetList.size(); i++)
			{
				observationTargetIdMap.put(observationTargetIds.get(i), observationTargetList.get(i).getId());
				observationElementIdMap.put(observationTargetIds.get(i), observationTargetList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports ObservableFeature from tab/comma delimited File.
	 * @param ObservableFeatureFile a tab delimited file with ObservableFeature data.
	 */
	private static void importObservableFeature(Database db, File ObservableFeatureFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ObservableFeatureFile);
		if(	!ObservableFeatureFile.exists() )
		{
			logger.warn("ObservableFeature.txt file is missing, skipped import");
		}
		else
		{
			//read ObservableFeature from file
			CsvReader reader = new CsvFileReader(ObservableFeatureFile);
			List<ObservableFeature> observableFeatureList = db.toList(ObservableFeature.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+observableFeatureList.size()+" ObservableFeature objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> observableFeatureIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < observableFeatureList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				ObservableFeature object = observableFeatureList.get(i);
				
				//remember index of this id for incoming fkeys
				observableFeatureIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getInvestigation() != null) object.setInvestigation_Id(investigationIdMap.get(object.getInvestigation_Id()));
				List<Integer > ontologyReferenceIds = new ArrayList<Integer>();
				for(Integer id: object.getOntologyReference_Id())
				{
					ontologyReferenceIds.add(ontologyTermIdMap.get(id));
				}
				List<Integer > alternateIdIds = new ArrayList<Integer>();
				for(Integer id: object.getAlternateId_Id())
				{
					alternateIdIds.add(alternateIdIdMap.get(id));
				}
				
				//add assay back to list
				observableFeatureList.set(i, object);
			}
			//add to database
			db.add(observableFeatureList);
			for(int i = 0; i < observableFeatureList.size(); i++)
			{
				observableFeatureIdMap.put(observableFeatureIds.get(i), observableFeatureList.get(i).getId());
				observationElementIdMap.put(observableFeatureIds.get(i), observableFeatureList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Category from tab/comma delimited File.
	 * @param CategoryFile a tab delimited file with Category data.
	 */
	private static void importCategory(Database db, File CategoryFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+CategoryFile);
		if(	!CategoryFile.exists() )
		{
			logger.warn("Category.txt file is missing, skipped import");
		}
		else
		{
			//read Category from file
			CsvReader reader = new CsvFileReader(CategoryFile);
			List<Category> categoryList = db.toList(Category.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+categoryList.size()+" Category objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> categoryIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < categoryList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Category object = categoryList.get(i);
				
				//remember index of this id for incoming fkeys
				categoryIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getInvestigation() != null) object.setInvestigation_Id(investigationIdMap.get(object.getInvestigation_Id()));
				List<Integer > ontologyReferenceIds = new ArrayList<Integer>();
				for(Integer id: object.getOntologyReference_Id())
				{
					ontologyReferenceIds.add(ontologyTermIdMap.get(id));
				}
				List<Integer > alternateIdIds = new ArrayList<Integer>();
				for(Integer id: object.getAlternateId_Id())
				{
					alternateIdIds.add(alternateIdIdMap.get(id));
				}
				
				//add assay back to list
				categoryList.set(i, object);
			}
			//add to database
			db.add(categoryList);
			for(int i = 0; i < categoryList.size(); i++)
			{
				categoryIdMap.put(categoryIds.get(i), categoryList.get(i).getId());
				observationElementIdMap.put(categoryIds.get(i), categoryList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Measurement from tab/comma delimited File.
	 * @param MeasurementFile a tab delimited file with Measurement data.
	 */
	private static void importMeasurement(Database db, File MeasurementFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+MeasurementFile);
		if(	!MeasurementFile.exists() )
		{
			logger.warn("Measurement.txt file is missing, skipped import");
		}
		else
		{
			//read Measurement from file
			CsvReader reader = new CsvFileReader(MeasurementFile);
			List<Measurement> measurementList = db.toList(Measurement.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+measurementList.size()+" Measurement objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> measurementIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < measurementList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Measurement object = measurementList.get(i);
				
				//remember index of this id for incoming fkeys
				measurementIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getInvestigation() != null) object.setInvestigation_Id(investigationIdMap.get(object.getInvestigation_Id()));
				List<Integer > ontologyReferenceIds = new ArrayList<Integer>();
				for(Integer id: object.getOntologyReference_Id())
				{
					ontologyReferenceIds.add(ontologyTermIdMap.get(id));
				}
				List<Integer > alternateIdIds = new ArrayList<Integer>();
				for(Integer id: object.getAlternateId_Id())
				{
					alternateIdIds.add(alternateIdIdMap.get(id));
				}
				if(object.getUnit() != null) object.setUnit_Id(ontologyTermIdMap.get(object.getUnit_Id()));
				List<Integer > categoriesIds = new ArrayList<Integer>();
				for(Integer id: object.getCategories_Id())
				{
					categoriesIds.add(categoryIdMap.get(id));
				}
				if(object.getTargettypeAllowedForRelation() != null) object.setTargettypeAllowedForRelation_Id(molgenisEntityIdMap.get(object.getTargettypeAllowedForRelation_Id()));
				
				//add assay back to list
				measurementList.set(i, object);
			}
			//add to database
			db.add(measurementList);
			for(int i = 0; i < measurementList.size(); i++)
			{
				measurementIdMap.put(measurementIds.get(i), measurementList.get(i).getId());
				observationElementIdMap.put(measurementIds.get(i), measurementList.get(i).getId());
				observableFeatureIdMap.put(measurementIds.get(i), measurementList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Individual from tab/comma delimited File.
	 * @param IndividualFile a tab delimited file with Individual data.
	 */
	private static void importIndividual(Database db, File IndividualFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+IndividualFile);
		if(	!IndividualFile.exists() )
		{
			logger.warn("Individual.txt file is missing, skipped import");
		}
		else
		{
			//read Individual from file
			CsvReader reader = new CsvFileReader(IndividualFile);
			List<Individual> individualList = db.toList(Individual.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+individualList.size()+" Individual objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> individualIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < individualList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Individual object = individualList.get(i);
				
				//remember index of this id for incoming fkeys
				individualIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getInvestigation() != null) object.setInvestigation_Id(investigationIdMap.get(object.getInvestigation_Id()));
				List<Integer > ontologyReferenceIds = new ArrayList<Integer>();
				for(Integer id: object.getOntologyReference_Id())
				{
					ontologyReferenceIds.add(ontologyTermIdMap.get(id));
				}
				List<Integer > alternateIdIds = new ArrayList<Integer>();
				for(Integer id: object.getAlternateId_Id())
				{
					alternateIdIds.add(alternateIdIdMap.get(id));
				}
				if(object.getMother() != null) object.setMother_Id(individualIdMap.get(object.getMother_Id()));
				if(object.getFather() != null) object.setFather_Id(individualIdMap.get(object.getFather_Id()));
				
				//add assay back to list
				individualList.set(i, object);
			}
			//add to database
			db.add(individualList);
			for(int i = 0; i < individualList.size(); i++)
			{
				individualIdMap.put(individualIds.get(i), individualList.get(i).getId());
				observationElementIdMap.put(individualIds.get(i), individualList.get(i).getId());
				observationTargetIdMap.put(individualIds.get(i), individualList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Location from tab/comma delimited File.
	 * @param LocationFile a tab delimited file with Location data.
	 */
	private static void importLocation(Database db, File LocationFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+LocationFile);
		if(	!LocationFile.exists() )
		{
			logger.warn("Location.txt file is missing, skipped import");
		}
		else
		{
			//read Location from file
			CsvReader reader = new CsvFileReader(LocationFile);
			List<Location> locationList = db.toList(Location.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+locationList.size()+" Location objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> locationIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < locationList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Location object = locationList.get(i);
				
				//remember index of this id for incoming fkeys
				locationIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getInvestigation() != null) object.setInvestigation_Id(investigationIdMap.get(object.getInvestigation_Id()));
				List<Integer > ontologyReferenceIds = new ArrayList<Integer>();
				for(Integer id: object.getOntologyReference_Id())
				{
					ontologyReferenceIds.add(ontologyTermIdMap.get(id));
				}
				List<Integer > alternateIdIds = new ArrayList<Integer>();
				for(Integer id: object.getAlternateId_Id())
				{
					alternateIdIds.add(alternateIdIdMap.get(id));
				}
				
				//add assay back to list
				locationList.set(i, object);
			}
			//add to database
			db.add(locationList);
			for(int i = 0; i < locationList.size(); i++)
			{
				locationIdMap.put(locationIds.get(i), locationList.get(i).getId());
				observationElementIdMap.put(locationIds.get(i), locationList.get(i).getId());
				observationTargetIdMap.put(locationIds.get(i), locationList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Panel from tab/comma delimited File.
	 * @param PanelFile a tab delimited file with Panel data.
	 */
	private static void importPanel(Database db, File PanelFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+PanelFile);
		if(	!PanelFile.exists() )
		{
			logger.warn("Panel.txt file is missing, skipped import");
		}
		else
		{
			//read Panel from file
			CsvReader reader = new CsvFileReader(PanelFile);
			List<Panel> panelList = db.toList(Panel.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+panelList.size()+" Panel objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> panelIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < panelList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Panel object = panelList.get(i);
				
				//remember index of this id for incoming fkeys
				panelIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getInvestigation() != null) object.setInvestigation_Id(investigationIdMap.get(object.getInvestigation_Id()));
				List<Integer > ontologyReferenceIds = new ArrayList<Integer>();
				for(Integer id: object.getOntologyReference_Id())
				{
					ontologyReferenceIds.add(ontologyTermIdMap.get(id));
				}
				List<Integer > alternateIdIds = new ArrayList<Integer>();
				for(Integer id: object.getAlternateId_Id())
				{
					alternateIdIds.add(alternateIdIdMap.get(id));
				}
				List<Integer > individualsIds = new ArrayList<Integer>();
				for(Integer id: object.getIndividuals_Id())
				{
					individualsIds.add(individualIdMap.get(id));
				}
				if(object.getSpecies() != null) object.setSpecies_Id(speciesIdMap.get(object.getSpecies_Id()));
				if(object.getPanelType() != null) object.setPanelType_Id(ontologyTermIdMap.get(object.getPanelType_Id()));
				List<Integer > founderPanelsIds = new ArrayList<Integer>();
				for(Integer id: object.getFounderPanels_Id())
				{
					founderPanelsIds.add(panelIdMap.get(id));
				}
				
				//add assay back to list
				panelList.set(i, object);
			}
			//add to database
			db.add(panelList);
			for(int i = 0; i < panelList.size(); i++)
			{
				panelIdMap.put(panelIds.get(i), panelList.get(i).getId());
				observationElementIdMap.put(panelIds.get(i), panelList.get(i).getId());
				observationTargetIdMap.put(panelIds.get(i), panelList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports MolgenisUser from tab/comma delimited File.
	 * @param MolgenisUserFile a tab delimited file with MolgenisUser data.
	 */
	private static void importMolgenisUser(Database db, File MolgenisUserFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+MolgenisUserFile);
		if(	!MolgenisUserFile.exists() )
		{
			logger.warn("MolgenisUser.txt file is missing, skipped import");
		}
		else
		{
			//read MolgenisUser from file
			CsvReader reader = new CsvFileReader(MolgenisUserFile);
			List<MolgenisUser> molgenisUserList = db.toList(MolgenisUser.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+molgenisUserList.size()+" MolgenisUser objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> molgenisUserIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < molgenisUserList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				MolgenisUser object = molgenisUserList.get(i);
				
				//remember index of this id for incoming fkeys
				molgenisUserIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getAffiliation() != null) object.setAffiliation_Id(instituteIdMap.get(object.getAffiliation_Id()));
				if(object.getRoles() != null) object.setRoles_Id(ontologyTermIdMap.get(object.getRoles_Id()));
				
				//add assay back to list
				molgenisUserList.set(i, object);
			}
			//add to database
			db.add(molgenisUserList);
			for(int i = 0; i < molgenisUserList.size(); i++)
			{
				molgenisUserIdMap.put(molgenisUserIds.get(i), molgenisUserList.get(i).getId());
				molgenisRoleIdMap.put(molgenisUserIds.get(i), molgenisUserList.get(i).getId());
				personIdMap.put(molgenisUserIds.get(i), molgenisUserList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Protocol from tab/comma delimited File.
	 * @param ProtocolFile a tab delimited file with Protocol data.
	 */
	private static void importProtocol(Database db, File ProtocolFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ProtocolFile);
		if(	!ProtocolFile.exists() )
		{
			logger.warn("Protocol.txt file is missing, skipped import");
		}
		else
		{
			//read Protocol from file
			CsvReader reader = new CsvFileReader(ProtocolFile);
			List<Protocol> protocolList = db.toList(Protocol.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+protocolList.size()+" Protocol objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> protocolIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < protocolList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Protocol object = protocolList.get(i);
				
				//remember index of this id for incoming fkeys
				protocolIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getInvestigation() != null) object.setInvestigation_Id(investigationIdMap.get(object.getInvestigation_Id()));
				List<Integer > ontologyReferenceIds = new ArrayList<Integer>();
				for(Integer id: object.getOntologyReference_Id())
				{
					ontologyReferenceIds.add(ontologyTermIdMap.get(id));
				}
				if(object.getProtocolType() != null) object.setProtocolType_Id(ontologyTermIdMap.get(object.getProtocolType_Id()));
				List<Integer > featuresIds = new ArrayList<Integer>();
				for(Integer id: object.getFeatures_Id())
				{
					featuresIds.add(observableFeatureIdMap.get(id));
				}
				if(object.getContact() != null) object.setContact_Id(personIdMap.get(object.getContact_Id()));
				List<Integer > subprotocolsIds = new ArrayList<Integer>();
				for(Integer id: object.getSubprotocols_Id())
				{
					subprotocolsIds.add(protocolIdMap.get(id));
				}
				
				//add assay back to list
				protocolList.set(i, object);
			}
			//add to database
			db.add(protocolList);
			for(int i = 0; i < protocolList.size(); i++)
			{
				protocolIdMap.put(protocolIds.get(i), protocolList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports Workflow from tab/comma delimited File.
	 * @param WorkflowFile a tab delimited file with Workflow data.
	 */
	private static void importWorkflow(Database db, File WorkflowFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+WorkflowFile);
		if(	!WorkflowFile.exists() )
		{
			logger.warn("Workflow.txt file is missing, skipped import");
		}
		else
		{
			//read Workflow from file
			CsvReader reader = new CsvFileReader(WorkflowFile);
			List<Workflow> workflowList = db.toList(Workflow.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+workflowList.size()+" Workflow objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> workflowIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < workflowList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Workflow object = workflowList.get(i);
				
				//remember index of this id for incoming fkeys
				workflowIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getInvestigation() != null) object.setInvestigation_Id(investigationIdMap.get(object.getInvestigation_Id()));
				List<Integer > ontologyReferenceIds = new ArrayList<Integer>();
				for(Integer id: object.getOntologyReference_Id())
				{
					ontologyReferenceIds.add(ontologyTermIdMap.get(id));
				}
				if(object.getProtocolType() != null) object.setProtocolType_Id(ontologyTermIdMap.get(object.getProtocolType_Id()));
				List<Integer > featuresIds = new ArrayList<Integer>();
				for(Integer id: object.getFeatures_Id())
				{
					featuresIds.add(observableFeatureIdMap.get(id));
				}
				if(object.getContact() != null) object.setContact_Id(personIdMap.get(object.getContact_Id()));
				List<Integer > subprotocolsIds = new ArrayList<Integer>();
				for(Integer id: object.getSubprotocols_Id())
				{
					subprotocolsIds.add(protocolIdMap.get(id));
				}
				
				//add assay back to list
				workflowList.set(i, object);
			}
			//add to database
			db.add(workflowList);
			for(int i = 0; i < workflowList.size(); i++)
			{
				workflowIdMap.put(workflowIds.get(i), workflowList.get(i).getId());
				protocolIdMap.put(workflowIds.get(i), workflowList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports ProtocolApplication from tab/comma delimited File.
	 * @param ProtocolApplicationFile a tab delimited file with ProtocolApplication data.
	 */
	private static void importProtocolApplication(Database db, File ProtocolApplicationFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ProtocolApplicationFile);
		if(	!ProtocolApplicationFile.exists() )
		{
			logger.warn("ProtocolApplication.txt file is missing, skipped import");
		}
		else
		{
			//read ProtocolApplication from file
			CsvReader reader = new CsvFileReader(ProtocolApplicationFile);
			List<ProtocolApplication> protocolApplicationList = db.toList(ProtocolApplication.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+protocolApplicationList.size()+" ProtocolApplication objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> protocolApplicationIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < protocolApplicationList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				ProtocolApplication object = protocolApplicationList.get(i);
				
				//remember index of this id for incoming fkeys
				protocolApplicationIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getInvestigation() != null) object.setInvestigation_Id(investigationIdMap.get(object.getInvestigation_Id()));
				List<Integer > ontologyReferenceIds = new ArrayList<Integer>();
				for(Integer id: object.getOntologyReference_Id())
				{
					ontologyReferenceIds.add(ontologyTermIdMap.get(id));
				}
				if(object.getProtocol() != null) object.setProtocol_Id(protocolIdMap.get(object.getProtocol_Id()));
				List<Integer > performerIds = new ArrayList<Integer>();
				for(Integer id: object.getPerformer_Id())
				{
					performerIds.add(personIdMap.get(id));
				}
				
				//add assay back to list
				protocolApplicationList.set(i, object);
			}
			//add to database
			db.add(protocolApplicationList);
			for(int i = 0; i < protocolApplicationList.size(); i++)
			{
				protocolApplicationIdMap.put(protocolApplicationIds.get(i), protocolApplicationList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports ObservedValue from tab/comma delimited File.
	 * @param ObservedValueFile a tab delimited file with ObservedValue data.
	 */
	private static void importObservedValue(Database db, File ObservedValueFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ObservedValueFile);
		if(	!ObservedValueFile.exists() )
		{
			logger.warn("ObservedValue.txt file is missing, skipped import");
		}
		else
		{
			//read ObservedValue from file
			CsvReader reader = new CsvFileReader(ObservedValueFile);
			List<ObservedValue> observedValueList = db.toList(ObservedValue.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+observedValueList.size()+" ObservedValue objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> observedValueIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < observedValueList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				ObservedValue object = observedValueList.get(i);
				
				//remember index of this id for incoming fkeys
				observedValueIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getInvestigation() != null) object.setInvestigation_Id(investigationIdMap.get(object.getInvestigation_Id()));
				if(object.getProtocolApplication() != null) object.setProtocolApplication_Id(protocolApplicationIdMap.get(object.getProtocolApplication_Id()));
				if(object.getFeature() != null) object.setFeature_Id(observationElementIdMap.get(object.getFeature_Id()));
				if(object.getTarget() != null) object.setTarget_Id(observationElementIdMap.get(object.getTarget_Id()));
				if(object.getOntologyReference() != null) object.setOntologyReference_Id(ontologyTermIdMap.get(object.getOntologyReference_Id()));
				if(object.getRelation() != null) object.setRelation_Id(observationElementIdMap.get(object.getRelation_Id()));
				
				//add assay back to list
				observedValueList.set(i, object);
			}
			//add to database
			db.add(observedValueList);
			for(int i = 0; i < observedValueList.size(); i++)
			{
				observedValueIdMap.put(observedValueIds.get(i), observedValueList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports ProtocolDocument from tab/comma delimited File.
	 * @param ProtocolDocumentFile a tab delimited file with ProtocolDocument data.
	 */
	private static void importProtocolDocument(Database db, File ProtocolDocumentFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ProtocolDocumentFile);
		if(	!ProtocolDocumentFile.exists() )
		{
			logger.warn("ProtocolDocument.txt file is missing, skipped import");
		}
		else
		{
			//read ProtocolDocument from file
			CsvReader reader = new CsvFileReader(ProtocolDocumentFile);
			List<ProtocolDocument> protocolDocumentList = db.toList(ProtocolDocument.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+protocolDocumentList.size()+" ProtocolDocument objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> protocolDocumentIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < protocolDocumentList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				ProtocolDocument object = protocolDocumentList.get(i);
				
				//remember index of this id for incoming fkeys
				protocolDocumentIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getProtocol() != null) object.setProtocol_Id(protocolIdMap.get(object.getProtocol_Id()));
				
				//add assay back to list
				protocolDocumentList.set(i, object);
			}
			//add to database
			db.add(protocolDocumentList);
			for(int i = 0; i < protocolDocumentList.size(); i++)
			{
				protocolDocumentIdMap.put(protocolDocumentIds.get(i), protocolDocumentList.get(i).getId());
				molgenisFileIdMap.put(protocolDocumentIds.get(i), protocolDocumentList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports WorkflowElement from tab/comma delimited File.
	 * @param WorkflowElementFile a tab delimited file with WorkflowElement data.
	 */
	private static void importWorkflowElement(Database db, File WorkflowElementFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+WorkflowElementFile);
		if(	!WorkflowElementFile.exists() )
		{
			logger.warn("WorkflowElement.txt file is missing, skipped import");
		}
		else
		{
			//read WorkflowElement from file
			CsvReader reader = new CsvFileReader(WorkflowElementFile);
			List<WorkflowElement> workflowElementList = db.toList(WorkflowElement.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+workflowElementList.size()+" WorkflowElement objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> workflowElementIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < workflowElementList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				WorkflowElement object = workflowElementList.get(i);
				
				//remember index of this id for incoming fkeys
				workflowElementIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getWorkflow() != null) object.setWorkflow_Id(workflowIdMap.get(object.getWorkflow_Id()));
				if(object.getProtocol() != null) object.setProtocol_Id(protocolIdMap.get(object.getProtocol_Id()));
				List<Integer > previousStepsIds = new ArrayList<Integer>();
				for(Integer id: object.getPreviousSteps_Id())
				{
					previousStepsIds.add(workflowElementIdMap.get(id));
				}
				
				//add assay back to list
				workflowElementList.set(i, object);
			}
			//add to database
			db.add(workflowElementList);
			for(int i = 0; i < workflowElementList.size(); i++)
			{
				workflowElementIdMap.put(workflowElementIds.get(i), workflowElementList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports WorkflowElementParameter from tab/comma delimited File.
	 * @param WorkflowElementParameterFile a tab delimited file with WorkflowElementParameter data.
	 */
	private static void importWorkflowElementParameter(Database db, File WorkflowElementParameterFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+WorkflowElementParameterFile);
		if(	!WorkflowElementParameterFile.exists() )
		{
			logger.warn("WorkflowElementParameter.txt file is missing, skipped import");
		}
		else
		{
			//read WorkflowElementParameter from file
			CsvReader reader = new CsvFileReader(WorkflowElementParameterFile);
			List<WorkflowElementParameter> workflowElementParameterList = db.toList(WorkflowElementParameter.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+workflowElementParameterList.size()+" WorkflowElementParameter objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> workflowElementParameterIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < workflowElementParameterList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				WorkflowElementParameter object = workflowElementParameterList.get(i);
				
				//remember index of this id for incoming fkeys
				workflowElementParameterIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getWorkflowElement() != null) object.setWorkflowElement_Id(workflowElementIdMap.get(object.getWorkflowElement_Id()));
				if(object.getParameter() != null) object.setParameter_Id(observableFeatureIdMap.get(object.getParameter_Id()));
				
				//add assay back to list
				workflowElementParameterList.set(i, object);
			}
			//add to database
			db.add(workflowElementParameterList);
			for(int i = 0; i < workflowElementParameterList.size(); i++)
			{
				workflowElementParameterIdMap.put(workflowElementParameterIds.get(i), workflowElementParameterList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports MolgenisRoleGroupLink from tab/comma delimited File.
	 * @param MolgenisRoleGroupLinkFile a tab delimited file with MolgenisRoleGroupLink data.
	 */
	private static void importMolgenisRoleGroupLink(Database db, File MolgenisRoleGroupLinkFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+MolgenisRoleGroupLinkFile);
		if(	!MolgenisRoleGroupLinkFile.exists() )
		{
			logger.warn("MolgenisRoleGroupLink.txt file is missing, skipped import");
		}
		else
		{
			//read MolgenisRoleGroupLink from file
			CsvReader reader = new CsvFileReader(MolgenisRoleGroupLinkFile);
			List<MolgenisRoleGroupLink> molgenisRoleGroupLinkList = db.toList(MolgenisRoleGroupLink.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+molgenisRoleGroupLinkList.size()+" MolgenisRoleGroupLink objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> molgenisRoleGroupLinkIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < molgenisRoleGroupLinkList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				MolgenisRoleGroupLink object = molgenisRoleGroupLinkList.get(i);
				
				//remember index of this id for incoming fkeys
				molgenisRoleGroupLinkIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getGroup() != null) object.setGroup_Id(molgenisGroupIdMap.get(object.getGroup_Id()));
				if(object.getRole() != null) object.setRole_Id(molgenisRoleIdMap.get(object.getRole_Id()));
				
				//add assay back to list
				molgenisRoleGroupLinkList.set(i, object);
			}
			//add to database
			db.add(molgenisRoleGroupLinkList);
			for(int i = 0; i < molgenisRoleGroupLinkList.size(); i++)
			{
				molgenisRoleGroupLinkIdMap.put(molgenisRoleGroupLinkIds.get(i), molgenisRoleGroupLinkList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports MolgenisPermission from tab/comma delimited File.
	 * @param MolgenisPermissionFile a tab delimited file with MolgenisPermission data.
	 */
	private static void importMolgenisPermission(Database db, File MolgenisPermissionFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+MolgenisPermissionFile);
		if(	!MolgenisPermissionFile.exists() )
		{
			logger.warn("MolgenisPermission.txt file is missing, skipped import");
		}
		else
		{
			//read MolgenisPermission from file
			CsvReader reader = new CsvFileReader(MolgenisPermissionFile);
			List<MolgenisPermission> molgenisPermissionList = db.toList(MolgenisPermission.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+molgenisPermissionList.size()+" MolgenisPermission objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> molgenisPermissionIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < molgenisPermissionList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				MolgenisPermission object = molgenisPermissionList.get(i);
				
				//remember index of this id for incoming fkeys
				molgenisPermissionIds.add(object.getId()); 
				
				//redirect outgoing fkeys
				if(object.getRole() != null) object.setRole_Id(molgenisRoleIdMap.get(object.getRole_Id()));
				if(object.getEntity() != null) object.setEntity_Id(molgenisEntityIdMap.get(object.getEntity_Id()));
				
				//add assay back to list
				molgenisPermissionList.set(i, object);
			}
			//add to database
			db.add(molgenisPermissionList);
			for(int i = 0; i < molgenisPermissionList.size(); i++)
			{
				molgenisPermissionIdMap.put(molgenisPermissionIds.get(i), molgenisPermissionList.get(i).getId());
			}
		}	 
	}
	/**
	 * Imports ObservationElement_Ontolo12449 from tab/comma delimited File.
	 * @param ObservationElement_ontolo12449File a tab delimited file with ObservationElement_Ontolo12449 data.
	 */
	private static void importObservationElement_Ontolo12449(Database db, File ObservationElement_ontolo12449File)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ObservationElement_ontolo12449File);
		if(	!ObservationElement_ontolo12449File.exists() )
		{
			logger.warn("ObservationElement_ontolo12449.txt file is missing, skipped import");
		}
		else
		{
			//read ObservationElement_ontolo12449 from file
			CsvReader reader = new CsvFileReader(ObservationElement_ontolo12449File);
			List<ObservationElement_Ontolo12449> observationElement_ontolo12449List = db.toList(ObservationElement_Ontolo12449.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+observationElement_ontolo12449List.size()+" ObservationElement_ontolo12449 objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> observationElement_ontolo12449Ids = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < observationElement_ontolo12449List.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				ObservationElement_Ontolo12449 object = observationElement_ontolo12449List.get(i);
				
				//remember index of this id for incoming fkeys
				observationElement_ontolo12449Ids.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getOntologyReference() != null) object.setOntologyReference_Id(ontologyTermIdMap.get(object.getOntologyReference_Id()));
				if(object.getInvestigationElement() != null) object.setInvestigationElement_Id(observationElementIdMap.get(object.getInvestigationElement_Id()));
				
				//add assay back to list
				observationElement_ontolo12449List.set(i, object);
			}
			//add to database
			db.add(observationElement_ontolo12449List);
			for(int i = 0; i < observationElement_ontolo12449List.size(); i++)
			{
				observationElement_ontolo12449IdMap.put(observationElement_ontolo12449Ids.get(i), observationElement_ontolo12449List.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports ObservationElement_AlternateId from tab/comma delimited File.
	 * @param ObservationElement_AlternateIdFile a tab delimited file with ObservationElement_AlternateId data.
	 */
	private static void importObservationElement_AlternateId(Database db, File ObservationElement_AlternateIdFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ObservationElement_AlternateIdFile);
		if(	!ObservationElement_AlternateIdFile.exists() )
		{
			logger.warn("ObservationElement_AlternateId.txt file is missing, skipped import");
		}
		else
		{
			//read ObservationElement_AlternateId from file
			CsvReader reader = new CsvFileReader(ObservationElement_AlternateIdFile);
			List<ObservationElement_AlternateId> observationElement_AlternateIdList = db.toList(ObservationElement_AlternateId.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+observationElement_AlternateIdList.size()+" ObservationElement_AlternateId objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> observationElement_AlternateIdIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < observationElement_AlternateIdList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				ObservationElement_AlternateId object = observationElement_AlternateIdList.get(i);
				
				//remember index of this id for incoming fkeys
				observationElement_AlternateIdIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getAlternateId() != null) object.setAlternateId_Id(alternateIdIdMap.get(object.getAlternateId_Id()));
				if(object.getObservationElement() != null) object.setObservationElement_Id(observationElementIdMap.get(object.getObservationElement_Id()));
				
				//add assay back to list
				observationElement_AlternateIdList.set(i, object);
			}
			//add to database
			db.add(observationElement_AlternateIdList);
			for(int i = 0; i < observationElement_AlternateIdList.size(); i++)
			{
				observationElement_AlternateIdIdMap.put(observationElement_AlternateIdIds.get(i), observationElement_AlternateIdList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports Measurement_Categories from tab/comma delimited File.
	 * @param Measurement_categoriesFile a tab delimited file with Measurement_Categories data.
	 */
	private static void importMeasurement_Categories(Database db, File Measurement_categoriesFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+Measurement_categoriesFile);
		if(	!Measurement_categoriesFile.exists() )
		{
			logger.warn("Measurement_categories.txt file is missing, skipped import");
		}
		else
		{
			//read Measurement_categories from file
			CsvReader reader = new CsvFileReader(Measurement_categoriesFile);
			List<Measurement_Categories> measurement_categoriesList = db.toList(Measurement_Categories.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+measurement_categoriesList.size()+" Measurement_categories objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> measurement_categoriesIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < measurement_categoriesList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Measurement_Categories object = measurement_categoriesList.get(i);
				
				//remember index of this id for incoming fkeys
				measurement_categoriesIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getCategories() != null) object.setCategories_Id(categoryIdMap.get(object.getCategories_Id()));
				if(object.getMeasurement() != null) object.setMeasurement_Id(measurementIdMap.get(object.getMeasurement_Id()));
				
				//add assay back to list
				measurement_categoriesList.set(i, object);
			}
			//add to database
			db.add(measurement_categoriesList);
			for(int i = 0; i < measurement_categoriesList.size(); i++)
			{
				measurement_categoriesIdMap.put(measurement_categoriesIds.get(i), measurement_categoriesList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports Panel_Individuals from tab/comma delimited File.
	 * @param Panel_IndividualsFile a tab delimited file with Panel_Individuals data.
	 */
	private static void importPanel_Individuals(Database db, File Panel_IndividualsFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+Panel_IndividualsFile);
		if(	!Panel_IndividualsFile.exists() )
		{
			logger.warn("Panel_Individuals.txt file is missing, skipped import");
		}
		else
		{
			//read Panel_Individuals from file
			CsvReader reader = new CsvFileReader(Panel_IndividualsFile);
			List<Panel_Individuals> panel_IndividualsList = db.toList(Panel_Individuals.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+panel_IndividualsList.size()+" Panel_Individuals objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> panel_IndividualsIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < panel_IndividualsList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Panel_Individuals object = panel_IndividualsList.get(i);
				
				//remember index of this id for incoming fkeys
				panel_IndividualsIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getIndividuals() != null) object.setIndividuals_Id(individualIdMap.get(object.getIndividuals_Id()));
				if(object.getPanel() != null) object.setPanel_Id(panelIdMap.get(object.getPanel_Id()));
				
				//add assay back to list
				panel_IndividualsList.set(i, object);
			}
			//add to database
			db.add(panel_IndividualsList);
			for(int i = 0; i < panel_IndividualsList.size(); i++)
			{
				panel_IndividualsIdMap.put(panel_IndividualsIds.get(i), panel_IndividualsList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports Panel_FounderPanels from tab/comma delimited File.
	 * @param Panel_FounderPanelsFile a tab delimited file with Panel_FounderPanels data.
	 */
	private static void importPanel_FounderPanels(Database db, File Panel_FounderPanelsFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+Panel_FounderPanelsFile);
		if(	!Panel_FounderPanelsFile.exists() )
		{
			logger.warn("Panel_FounderPanels.txt file is missing, skipped import");
		}
		else
		{
			//read Panel_FounderPanels from file
			CsvReader reader = new CsvFileReader(Panel_FounderPanelsFile);
			List<Panel_FounderPanels> panel_FounderPanelsList = db.toList(Panel_FounderPanels.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+panel_FounderPanelsList.size()+" Panel_FounderPanels objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> panel_FounderPanelsIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < panel_FounderPanelsList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Panel_FounderPanels object = panel_FounderPanelsList.get(i);
				
				//remember index of this id for incoming fkeys
				panel_FounderPanelsIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getFounderPanels() != null) object.setFounderPanels_Id(panelIdMap.get(object.getFounderPanels_Id()));
				if(object.getPanel() != null) object.setPanel_Id(panelIdMap.get(object.getPanel_Id()));
				
				//add assay back to list
				panel_FounderPanelsList.set(i, object);
			}
			//add to database
			db.add(panel_FounderPanelsList);
			for(int i = 0; i < panel_FounderPanelsList.size(); i++)
			{
				panel_FounderPanelsIdMap.put(panel_FounderPanelsIds.get(i), panel_FounderPanelsList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports Investigation_Contacts from tab/comma delimited File.
	 * @param Investigation_contactsFile a tab delimited file with Investigation_Contacts data.
	 */
	private static void importInvestigation_Contacts(Database db, File Investigation_contactsFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+Investigation_contactsFile);
		if(	!Investigation_contactsFile.exists() )
		{
			logger.warn("Investigation_contacts.txt file is missing, skipped import");
		}
		else
		{
			//read Investigation_contacts from file
			CsvReader reader = new CsvFileReader(Investigation_contactsFile);
			List<Investigation_Contacts> investigation_contactsList = db.toList(Investigation_Contacts.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+investigation_contactsList.size()+" Investigation_contacts objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> investigation_contactsIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < investigation_contactsList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Investigation_Contacts object = investigation_contactsList.get(i);
				
				//remember index of this id for incoming fkeys
				investigation_contactsIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getContacts() != null) object.setContacts_Id(personIdMap.get(object.getContacts_Id()));
				if(object.getInvestigation() != null) object.setInvestigation_Id(investigationIdMap.get(object.getInvestigation_Id()));
				
				//add assay back to list
				investigation_contactsList.set(i, object);
			}
			//add to database
			db.add(investigation_contactsList);
			for(int i = 0; i < investigation_contactsList.size(); i++)
			{
				investigation_contactsIdMap.put(investigation_contactsIds.get(i), investigation_contactsList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports Protocol_OntologyReference from tab/comma delimited File.
	 * @param Protocol_ontologyReferenceFile a tab delimited file with Protocol_OntologyReference data.
	 */
	private static void importProtocol_OntologyReference(Database db, File Protocol_ontologyReferenceFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+Protocol_ontologyReferenceFile);
		if(	!Protocol_ontologyReferenceFile.exists() )
		{
			logger.warn("Protocol_ontologyReference.txt file is missing, skipped import");
		}
		else
		{
			//read Protocol_ontologyReference from file
			CsvReader reader = new CsvFileReader(Protocol_ontologyReferenceFile);
			List<Protocol_OntologyReference> protocol_ontologyReferenceList = db.toList(Protocol_OntologyReference.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+protocol_ontologyReferenceList.size()+" Protocol_ontologyReference objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> protocol_ontologyReferenceIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < protocol_ontologyReferenceList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Protocol_OntologyReference object = protocol_ontologyReferenceList.get(i);
				
				//remember index of this id for incoming fkeys
				protocol_ontologyReferenceIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getOntologyReference() != null) object.setOntologyReference_Id(ontologyTermIdMap.get(object.getOntologyReference_Id()));
				if(object.getInvestigationElement() != null) object.setInvestigationElement_Id(protocolIdMap.get(object.getInvestigationElement_Id()));
				
				//add assay back to list
				protocol_ontologyReferenceList.set(i, object);
			}
			//add to database
			db.add(protocol_ontologyReferenceList);
			for(int i = 0; i < protocol_ontologyReferenceList.size(); i++)
			{
				protocol_ontologyReferenceIdMap.put(protocol_ontologyReferenceIds.get(i), protocol_ontologyReferenceList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports Protocol_Features from tab/comma delimited File.
	 * @param Protocol_FeaturesFile a tab delimited file with Protocol_Features data.
	 */
	private static void importProtocol_Features(Database db, File Protocol_FeaturesFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+Protocol_FeaturesFile);
		if(	!Protocol_FeaturesFile.exists() )
		{
			logger.warn("Protocol_Features.txt file is missing, skipped import");
		}
		else
		{
			//read Protocol_Features from file
			CsvReader reader = new CsvFileReader(Protocol_FeaturesFile);
			List<Protocol_Features> protocol_FeaturesList = db.toList(Protocol_Features.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+protocol_FeaturesList.size()+" Protocol_Features objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> protocol_FeaturesIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < protocol_FeaturesList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Protocol_Features object = protocol_FeaturesList.get(i);
				
				//remember index of this id for incoming fkeys
				protocol_FeaturesIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getFeatures() != null) object.setFeatures_Id(observableFeatureIdMap.get(object.getFeatures_Id()));
				if(object.getProtocol() != null) object.setProtocol_Id(protocolIdMap.get(object.getProtocol_Id()));
				
				//add assay back to list
				protocol_FeaturesList.set(i, object);
			}
			//add to database
			db.add(protocol_FeaturesList);
			for(int i = 0; i < protocol_FeaturesList.size(); i++)
			{
				protocol_FeaturesIdMap.put(protocol_FeaturesIds.get(i), protocol_FeaturesList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports Protocol_Subprotocols from tab/comma delimited File.
	 * @param Protocol_subprotocolsFile a tab delimited file with Protocol_Subprotocols data.
	 */
	private static void importProtocol_Subprotocols(Database db, File Protocol_subprotocolsFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+Protocol_subprotocolsFile);
		if(	!Protocol_subprotocolsFile.exists() )
		{
			logger.warn("Protocol_subprotocols.txt file is missing, skipped import");
		}
		else
		{
			//read Protocol_subprotocols from file
			CsvReader reader = new CsvFileReader(Protocol_subprotocolsFile);
			List<Protocol_Subprotocols> protocol_subprotocolsList = db.toList(Protocol_Subprotocols.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+protocol_subprotocolsList.size()+" Protocol_subprotocols objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> protocol_subprotocolsIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < protocol_subprotocolsList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				Protocol_Subprotocols object = protocol_subprotocolsList.get(i);
				
				//remember index of this id for incoming fkeys
				protocol_subprotocolsIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getSubprotocols() != null) object.setSubprotocols_Id(protocolIdMap.get(object.getSubprotocols_Id()));
				if(object.getProtocol() != null) object.setProtocol_Id(protocolIdMap.get(object.getProtocol_Id()));
				
				//add assay back to list
				protocol_subprotocolsList.set(i, object);
			}
			//add to database
			db.add(protocol_subprotocolsList);
			for(int i = 0; i < protocol_subprotocolsList.size(); i++)
			{
				protocol_subprotocolsIdMap.put(protocol_subprotocolsIds.get(i), protocol_subprotocolsList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports ProtocolApplication_Ontol11768 from tab/comma delimited File.
	 * @param ProtocolApplication_ontol11768File a tab delimited file with ProtocolApplication_Ontol11768 data.
	 */
	private static void importProtocolApplication_Ontol11768(Database db, File ProtocolApplication_ontol11768File)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ProtocolApplication_ontol11768File);
		if(	!ProtocolApplication_ontol11768File.exists() )
		{
			logger.warn("ProtocolApplication_ontol11768.txt file is missing, skipped import");
		}
		else
		{
			//read ProtocolApplication_ontol11768 from file
			CsvReader reader = new CsvFileReader(ProtocolApplication_ontol11768File);
			List<ProtocolApplication_Ontol11768> protocolApplication_ontol11768List = db.toList(ProtocolApplication_Ontol11768.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+protocolApplication_ontol11768List.size()+" ProtocolApplication_ontol11768 objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> protocolApplication_ontol11768Ids = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < protocolApplication_ontol11768List.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				ProtocolApplication_Ontol11768 object = protocolApplication_ontol11768List.get(i);
				
				//remember index of this id for incoming fkeys
				protocolApplication_ontol11768Ids.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getOntologyReference() != null) object.setOntologyReference_Id(ontologyTermIdMap.get(object.getOntologyReference_Id()));
				if(object.getInvestigationElement() != null) object.setInvestigationElement_Id(protocolApplicationIdMap.get(object.getInvestigationElement_Id()));
				
				//add assay back to list
				protocolApplication_ontol11768List.set(i, object);
			}
			//add to database
			db.add(protocolApplication_ontol11768List);
			for(int i = 0; i < protocolApplication_ontol11768List.size(); i++)
			{
				protocolApplication_ontol11768IdMap.put(protocolApplication_ontol11768Ids.get(i), protocolApplication_ontol11768List.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports ProtocolApplication_Performer from tab/comma delimited File.
	 * @param ProtocolApplication_PerformerFile a tab delimited file with ProtocolApplication_Performer data.
	 */
	private static void importProtocolApplication_Performer(Database db, File ProtocolApplication_PerformerFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+ProtocolApplication_PerformerFile);
		if(	!ProtocolApplication_PerformerFile.exists() )
		{
			logger.warn("ProtocolApplication_Performer.txt file is missing, skipped import");
		}
		else
		{
			//read ProtocolApplication_Performer from file
			CsvReader reader = new CsvFileReader(ProtocolApplication_PerformerFile);
			List<ProtocolApplication_Performer> protocolApplication_PerformerList = db.toList(ProtocolApplication_Performer.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+protocolApplication_PerformerList.size()+" ProtocolApplication_Performer objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> protocolApplication_PerformerIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < protocolApplication_PerformerList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				ProtocolApplication_Performer object = protocolApplication_PerformerList.get(i);
				
				//remember index of this id for incoming fkeys
				protocolApplication_PerformerIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getPerformer() != null) object.setPerformer_Id(personIdMap.get(object.getPerformer_Id()));
				if(object.getProtocolApplication() != null) object.setProtocolApplication_Id(protocolApplicationIdMap.get(object.getProtocolApplication_Id()));
				
				//add assay back to list
				protocolApplication_PerformerList.set(i, object);
			}
			//add to database
			db.add(protocolApplication_PerformerList);
			for(int i = 0; i < protocolApplication_PerformerList.size(); i++)
			{
				protocolApplication_PerformerIdMap.put(protocolApplication_PerformerIds.get(i), protocolApplication_PerformerList.get(i).getAutoid());
			}
		}	 
	}
	/**
	 * Imports WorkflowElement_PreviousSteps from tab/comma delimited File.
	 * @param WorkflowElement_PreviousStepsFile a tab delimited file with WorkflowElement_PreviousSteps data.
	 */
	private static void importWorkflowElement_PreviousSteps(Database db, File WorkflowElement_PreviousStepsFile)	throws DatabaseException, IOException, Exception 
	{
		logger.debug("trying to import "+WorkflowElement_PreviousStepsFile);
		if(	!WorkflowElement_PreviousStepsFile.exists() )
		{
			logger.warn("WorkflowElement_PreviousSteps.txt file is missing, skipped import");
		}
		else
		{
			//read WorkflowElement_PreviousSteps from file
			CsvReader reader = new CsvFileReader(WorkflowElement_PreviousStepsFile);
			List<WorkflowElement_PreviousSteps> workflowElement_PreviousStepsList = db.toList(WorkflowElement_PreviousSteps.class, reader, Integer.MAX_VALUE); //should have no limit 
			logger.debug("loaded "+workflowElement_PreviousStepsList.size()+" WorkflowElement_PreviousSteps objects");
			
			//redirect incoming and outgoing fkeys
			List<Integer> workflowElement_PreviousStepsIds = new ArrayList<Integer>(); //also doesn't scale
			for(int i = 0; i < workflowElement_PreviousStepsList.size(); i++ ) //sorry, not a real list so need to put back!!
			{
				WorkflowElement_PreviousSteps object = workflowElement_PreviousStepsList.get(i);
				
				//remember index of this id for incoming fkeys
				workflowElement_PreviousStepsIds.add(object.getAutoid()); 
				
				//redirect outgoing fkeys
				if(object.getPreviousSteps() != null) object.setPreviousSteps_Id(workflowElementIdMap.get(object.getPreviousSteps_Id()));
				if(object.getWorkflowElement() != null) object.setWorkflowElement_Id(workflowElementIdMap.get(object.getWorkflowElement_Id()));
				
				//add assay back to list
				workflowElement_PreviousStepsList.set(i, object);
			}
			//add to database
			db.add(workflowElement_PreviousStepsList);
			for(int i = 0; i < workflowElement_PreviousStepsList.size(); i++)
			{
				workflowElement_PreviousStepsIdMap.put(workflowElement_PreviousStepsIds.get(i), workflowElement_PreviousStepsList.get(i).getAutoid());
			}
		}	 
	}
}