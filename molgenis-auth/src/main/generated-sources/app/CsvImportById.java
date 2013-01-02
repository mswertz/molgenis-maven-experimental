
/* Date:        October 22, 2012
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

	import org.molgenis.auth.MolgenisRole;
	import org.molgenis.auth.MolgenisGroup;
	import org.molgenis.auth.Institute;
	import org.molgenis.core.Ontology;
	import org.molgenis.core.OntologyTerm;
	import org.molgenis.auth.Person;
	import org.molgenis.auth.MolgenisUser;
	import org.molgenis.auth.MolgenisRoleGroupLink;
	import org.molgenis.core.MolgenisFile;
	import org.molgenis.core.RuntimeProperty;
	import org.molgenis.core.Publication;
	import org.molgenis.core.UseCase;
	import org.molgenis.core.MolgenisEntity;
	import org.molgenis.auth.MolgenisPermission;


public class CsvImportById
{
	static Logger logger = Logger.getLogger(CsvImport.class.getSimpleName());
	//mappings between imported and internally assigned ids
	//only necessary for automatic ids
	static Map<Integer,Integer> molgenisRoleIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisGroupIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> contactIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> instituteIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> identifiableIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> nameableIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> ontologyIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> ontologyTermIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> personIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisUserIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisRoleGroupLinkIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisFileIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> runtimePropertyIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> publicationIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> useCaseIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisEntityIdMap = new TreeMap<Integer,Integer>(); 
	static Map<Integer,Integer> molgenisPermissionIdMap = new TreeMap<Integer,Integer>(); 

	/**
	 * Csv import of whole database.
	 * TODO: add filter parameters...
	 */
	public static void importData(File directory, Database db) throws Exception
	{
		try
		{
			db.beginTx();
						
			importMolgenisRole(db, new File(directory + "/molgenisrole.txt"));
			importMolgenisGroup(db, new File(directory + "/molgenisgroup.txt"));
			importInstitute(db, new File(directory + "/institute.txt"));
			importOntology(db, new File(directory + "/ontology.txt"));
			importOntologyTerm(db, new File(directory + "/ontologyterm.txt"));
			importPerson(db, new File(directory + "/person.txt"));
			importMolgenisUser(db, new File(directory + "/molgenisuser.txt"));
			importMolgenisRoleGroupLink(db, new File(directory + "/molgenisrolegrouplink.txt"));
			importMolgenisFile(db, new File(directory + "/molgenisfile.txt"));
			importRuntimeProperty(db, new File(directory + "/runtimeproperty.txt"));
			importPublication(db, new File(directory + "/publication.txt"));
			importUseCase(db, new File(directory + "/usecase.txt"));
			importMolgenisEntity(db, new File(directory + "/molgenisentity.txt"));
			importMolgenisPermission(db, new File(directory + "/molgenispermission.txt"));
			
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
}