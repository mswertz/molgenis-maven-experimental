
/* File:        observ/model/Workflow.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.protocol.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.log4j.Logger;
import org.molgenis.framework.db.CsvToDatabase;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.Query;
import org.molgenis.framework.db.Database.DatabaseAction;
import org.molgenis.util.CsvReader;
import org.molgenis.util.Tuple;

import org.molgenis.organization.Investigation;
import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.ObservableFeature;
import org.molgenis.auth.Person;
import org.molgenis.protocol.Protocol;
import org.molgenis.protocol.Workflow;


/**
 * Reads Workflow from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class WorkflowCsvReader extends CsvToDatabase<Workflow>
{
	public static final transient Logger logger = Logger.getLogger(WorkflowCsvReader.class);
	
	//foreign key map for xref 'investigation' (maps investigation.name -> investigation.id)			
	final Map<String,Integer> investigationKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'ontologyReference' (maps ontologyTerm.name -> ontologyTerm.id)			
	final Map<String,Integer> ontologyReferenceKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'protocolType' (maps ontologyTerm.name -> ontologyTerm.id)			
	final Map<String,Integer> protocolTypeKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'features' (maps observableFeature.name -> observableFeature.id)			
	final Map<String,Integer> featuresKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'contact' (maps person.name -> person.id)			
	final Map<String,Integer> contactKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'subprotocols' (maps protocol.name -> protocol.id)			
	final Map<String,Integer> subprotocolsKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Workflow from tab/comma delimited File
	 * @param db database to import into
	 * @param reader csv reader to load data from
	 * @param defaults to set default values for each row
	 * @param dbAction indicating wether to add,update,remove etc
	 * @param missingValues indicating what value in the csv is treated as 'null' (e.g. "" or "NA")
	 * @return number of elements imported
	 */
	public int importCsv(final Database db, CsvReader reader, final Tuple defaults, final DatabaseAction dbAction, final String missingValues) throws DatabaseException, IOException, Exception 
	{
		//cache for entities of which xrefs couldn't be resolved (e.g. if there is a self-refence)
		//these entities can be updated with their xrefs in a second round when all entities are in the database
		final List<Workflow> workflowsMissingRefs = new ArrayList<Workflow>();
	
		//cache for objects to be imported from file (in batch)
		final List<Workflow> workflowList = new ArrayList<Workflow>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Workflow object = new Workflow();
			object.set(defaults, false); 
			object.set(tuple, false);				
			workflowList.add(object);		
			
			//add to db when batch size is reached
			if(workflowList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				workflowsMissingRefs.addAll(resolveForeignKeys(db, workflowList));
				
				//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
				db.update(workflowList,dbAction, "name");
				
				//clear for next batch						
				workflowList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!workflowList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			workflowsMissingRefs.addAll(resolveForeignKeys(db, workflowList));
			//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
			db.update(workflowList,dbAction, "name");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<Workflow> workflowsStillMissingRefs = resolveForeignKeys(db, workflowsMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(workflowsStillMissingRefs.size() > 0){
			throw new Exception("Import of 'Workflow' objects failed: attempting to resolve in-list references, but there are still Workflows referring to Workflows that are neither in the database nor in the list of to-be imported Workflows. (the first one being: "+workflowsStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(workflowsMissingRefs,DatabaseAction.UPDATE, "name");
		
			//output count
			total.set(total.get() + workflowList.size());
			logger.info("imported "+total.get()+" workflow from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param workflowList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Workflow> resolveForeignKeys(Database db, List<Workflow> workflowList) throws Exception
	{
		//keep a list of Workflow instances that miss a reference which might be resolvable later
		List<Workflow> workflowsMissingRefs = new ArrayList<Workflow>();
	
		//resolve xref 'investigation' from investigation.name -> investigation.id
		for(Workflow o: workflowList) 
		{
			if(o.getInvestigation_Name() != null) 
				investigationKeymap.put(o.getInvestigation_Name(), null);
		}
		
		if(investigationKeymap.size() > 0) 
		{
			List<Investigation> investigationList = db.query(Investigation.class).in("name",new ArrayList<Object>(investigationKeymap.keySet())).find();
			for(Investigation xref :  investigationList)
			{
				investigationKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'ontologyReference' from ontologyTerm.name -> ontologyTerm.id
		for(Workflow o: workflowList) for(String xref_label: o.getOntologyReference_Name())
		{
			if(xref_label != null) 
				ontologyReferenceKeymap.put(xref_label, null);
		}
		
		if(ontologyReferenceKeymap.size() > 0) 
		{
			List<OntologyTerm> ontologyReferenceList = db.query(OntologyTerm.class).in("name",new ArrayList<Object>(ontologyReferenceKeymap.keySet())).find();
			for(OntologyTerm xref :  ontologyReferenceList)
			{
				ontologyReferenceKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'protocolType' from ontologyTerm.name -> ontologyTerm.id
		for(Workflow o: workflowList) 
		{
			if(o.getProtocolType_Name() != null) 
				protocolTypeKeymap.put(o.getProtocolType_Name(), null);
		}
		
		if(protocolTypeKeymap.size() > 0) 
		{
			List<OntologyTerm> protocolTypeList = db.query(OntologyTerm.class).in("name",new ArrayList<Object>(protocolTypeKeymap.keySet())).find();
			for(OntologyTerm xref :  protocolTypeList)
			{
				protocolTypeKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'features' from observableFeature.name -> observableFeature.id
		for(Workflow o: workflowList) for(String xref_label: o.getFeatures_Name())
		{
			if(xref_label != null) 
				featuresKeymap.put(xref_label, null);
		}
		
		if(featuresKeymap.size() > 0) 
		{
			List<ObservableFeature> featuresList = db.query(ObservableFeature.class).in("name",new ArrayList<Object>(featuresKeymap.keySet())).find();
			for(ObservableFeature xref :  featuresList)
			{
				featuresKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'contact' from person.name -> person.id
		for(Workflow o: workflowList) 
		{
			if(o.getContact_Name() != null) 
				contactKeymap.put(o.getContact_Name(), null);
		}
		
		if(contactKeymap.size() > 0) 
		{
			List<Person> contactList = db.query(Person.class).in("name",new ArrayList<Object>(contactKeymap.keySet())).find();
			for(Person xref :  contactList)
			{
				contactKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'subprotocols' from protocol.name -> protocol.id
		for(Workflow o: workflowList) for(String xref_label: o.getSubprotocols_Name())
		{
			if(xref_label != null) 
				subprotocolsKeymap.put(xref_label, null);
		}
		
		if(subprotocolsKeymap.size() > 0) 
		{
			List<Protocol> subprotocolsList = db.query(Protocol.class).in("name",new ArrayList<Object>(subprotocolsKeymap.keySet())).find();
			for(Protocol xref :  subprotocolsList)
			{
				subprotocolsKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Workflow o:  workflowList)
		{
			while(true){
				//update xref Investigation
				if(o.getInvestigation_Name() != null) 
				{
					String key = o.getInvestigation_Name();
					if(investigationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Workflow' objects failed: cannot find Investigation for investigation_name='"+o.getInvestigation_Name()+"'");
					}
					o.setInvestigation_Id(investigationKeymap.get(key));
				}
				//update mref ontologyReference
				if(o.getOntologyReference_Name() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextWorkflow = false;

					int listSize = 0;
					if(o.getOntologyReference_Name() != null) listSize = Math.max(o.getOntologyReference_Name().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getOntologyReference_Name().get(i);
						if(ontologyReferenceKeymap.get(key) == null){
							logger.error("Import of 'Workflow' objects failed: "+o);
							throw new Exception("Import of 'Workflow' objects failed: cannot find ontologyReference_name='"+(o.getOntologyReference_Name() != null && i < o.getOntologyReference_Name().size() ? o.getOntologyReference_Name().get(i) : "null")+"'");
						}
						mrefs.add(ontologyReferenceKeymap.get(key));
					}
					if(breakToNextWorkflow){
						break;
					}
					o.setOntologyReference_Id(mrefs);
				}
				//update xref ProtocolType
				if(o.getProtocolType_Name() != null) 
				{
					String key = o.getProtocolType_Name();
					if(protocolTypeKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Workflow' objects failed: cannot find OntologyTerm for protocolType_name='"+o.getProtocolType_Name()+"'");
					}
					o.setProtocolType_Id(protocolTypeKeymap.get(key));
				}
				//update mref Features
				if(o.getFeatures_Name() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextWorkflow = false;

					int listSize = 0;
					if(o.getFeatures_Name() != null) listSize = Math.max(o.getFeatures_Name().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getFeatures_Name().get(i);
						if(featuresKeymap.get(key) == null){
							logger.error("Import of 'Workflow' objects failed: "+o);
							throw new Exception("Import of 'Workflow' objects failed: cannot find features_name='"+(o.getFeatures_Name() != null && i < o.getFeatures_Name().size() ? o.getFeatures_Name().get(i) : "null")+"'");
						}
						mrefs.add(featuresKeymap.get(key));
					}
					if(breakToNextWorkflow){
						break;
					}
					o.setFeatures_Id(mrefs);
				}
				//update xref Contact
				if(o.getContact_Name() != null) 
				{
					String key = o.getContact_Name();
					if(contactKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Workflow' objects failed: cannot find Person for contact_name='"+o.getContact_Name()+"'");
					}
					o.setContact_Id(contactKeymap.get(key));
				}
				//update mref subprotocols
				if(o.getSubprotocols_Name() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextWorkflow = false;

					int listSize = 0;
					if(o.getSubprotocols_Name() != null) listSize = Math.max(o.getSubprotocols_Name().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getSubprotocols_Name().get(i);
						if(subprotocolsKeymap.get(key) == null){
							logger.error("Import of 'Workflow' objects failed: "+o);
							throw new Exception("Import of 'Workflow' objects failed: cannot find subprotocols_name='"+(o.getSubprotocols_Name() != null && i < o.getSubprotocols_Name().size() ? o.getSubprotocols_Name().get(i) : "null")+"'");
						}
						mrefs.add(subprotocolsKeymap.get(key));
					}
					if(breakToNextWorkflow){
						break;
					}
					o.setSubprotocols_Id(mrefs);
				}
				break;
			}
		}
		
		investigationKeymap.clear();
		ontologyReferenceKeymap.clear();
		protocolTypeKeymap.clear();
		featuresKeymap.clear();
		contactKeymap.clear();
		subprotocolsKeymap.clear();
		
		return workflowsMissingRefs;
	}
}

