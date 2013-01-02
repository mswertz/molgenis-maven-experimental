
/* File:        observ/model/ProtocolApplication.java
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
import org.molgenis.protocol.Protocol;
import org.molgenis.auth.Person;
import org.molgenis.protocol.ProtocolApplication;


/**
 * Reads ProtocolApplication from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ProtocolApplicationCsvReader extends CsvToDatabase<ProtocolApplication>
{
	public static final transient Logger logger = Logger.getLogger(ProtocolApplicationCsvReader.class);
	
	//foreign key map for xref 'investigation' (maps investigation.name -> investigation.id)			
	final Map<String,Integer> investigationKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'ontologyReference' (maps ontologyTerm.name -> ontologyTerm.id)			
	final Map<String,Integer> ontologyReferenceKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'protocol' (maps protocol.name -> protocol.id)			
	final Map<String,Integer> protocolKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'performer' (maps person.name -> person.id)			
	final Map<String,Integer> performerKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports ProtocolApplication from tab/comma delimited File
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
		final List<ProtocolApplication> protocolApplicationsMissingRefs = new ArrayList<ProtocolApplication>();
	
		//cache for objects to be imported from file (in batch)
		final List<ProtocolApplication> protocolApplicationList = new ArrayList<ProtocolApplication>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			ProtocolApplication object = new ProtocolApplication();
			object.set(defaults, false); 
			object.set(tuple, false);				
			protocolApplicationList.add(object);		
			
			//add to db when batch size is reached
			if(protocolApplicationList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				protocolApplicationsMissingRefs.addAll(resolveForeignKeys(db, protocolApplicationList));
				
				//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
				db.update(protocolApplicationList,dbAction, "name");
				
				//clear for next batch						
				protocolApplicationList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!protocolApplicationList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			protocolApplicationsMissingRefs.addAll(resolveForeignKeys(db, protocolApplicationList));
			//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
			db.update(protocolApplicationList,dbAction, "name");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<ProtocolApplication> protocolApplicationsStillMissingRefs = resolveForeignKeys(db, protocolApplicationsMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(protocolApplicationsStillMissingRefs.size() > 0){
			throw new Exception("Import of 'ProtocolApplication' objects failed: attempting to resolve in-list references, but there are still ProtocolApplications referring to ProtocolApplications that are neither in the database nor in the list of to-be imported ProtocolApplications. (the first one being: "+protocolApplicationsStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(protocolApplicationsMissingRefs,DatabaseAction.UPDATE, "name");
		
			//output count
			total.set(total.get() + protocolApplicationList.size());
			logger.info("imported "+total.get()+" protocolApplication from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param protocolApplicationList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<ProtocolApplication> resolveForeignKeys(Database db, List<ProtocolApplication> protocolApplicationList) throws Exception
	{
		//keep a list of ProtocolApplication instances that miss a reference which might be resolvable later
		List<ProtocolApplication> protocolApplicationsMissingRefs = new ArrayList<ProtocolApplication>();
	
		//resolve xref 'investigation' from investigation.name -> investigation.id
		for(ProtocolApplication o: protocolApplicationList) 
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
		for(ProtocolApplication o: protocolApplicationList) for(String xref_label: o.getOntologyReference_Name())
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
		//resolve xref 'protocol' from protocol.name -> protocol.id
		for(ProtocolApplication o: protocolApplicationList) 
		{
			if(o.getProtocol_Name() != null) 
				protocolKeymap.put(o.getProtocol_Name(), null);
		}
		
		if(protocolKeymap.size() > 0) 
		{
			List<Protocol> protocolList = db.query(Protocol.class).in("name",new ArrayList<Object>(protocolKeymap.keySet())).find();
			for(Protocol xref :  protocolList)
			{
				protocolKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'performer' from person.name -> person.id
		for(ProtocolApplication o: protocolApplicationList) for(String xref_label: o.getPerformer_Name())
		{
			if(xref_label != null) 
				performerKeymap.put(xref_label, null);
		}
		
		if(performerKeymap.size() > 0) 
		{
			List<Person> performerList = db.query(Person.class).in("name",new ArrayList<Object>(performerKeymap.keySet())).find();
			for(Person xref :  performerList)
			{
				performerKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(ProtocolApplication o:  protocolApplicationList)
		{
			while(true){
				//update xref Investigation
				if(o.getInvestigation_Name() != null) 
				{
					String key = o.getInvestigation_Name();
					if(investigationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ProtocolApplication' objects failed: cannot find Investigation for investigation_name='"+o.getInvestigation_Name()+"'");
					}
					o.setInvestigation_Id(investigationKeymap.get(key));
				}
				//update mref ontologyReference
				if(o.getOntologyReference_Name() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextProtocolApplication = false;

					int listSize = 0;
					if(o.getOntologyReference_Name() != null) listSize = Math.max(o.getOntologyReference_Name().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getOntologyReference_Name().get(i);
						if(ontologyReferenceKeymap.get(key) == null){
							logger.error("Import of 'ProtocolApplication' objects failed: "+o);
							throw new Exception("Import of 'ProtocolApplication' objects failed: cannot find ontologyReference_name='"+(o.getOntologyReference_Name() != null && i < o.getOntologyReference_Name().size() ? o.getOntologyReference_Name().get(i) : "null")+"'");
						}
						mrefs.add(ontologyReferenceKeymap.get(key));
					}
					if(breakToNextProtocolApplication){
						break;
					}
					o.setOntologyReference_Id(mrefs);
				}
				//update xref protocol
				if(o.getProtocol_Name() != null) 
				{
					String key = o.getProtocol_Name();
					if(protocolKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ProtocolApplication' objects failed: cannot find Protocol for protocol_name='"+o.getProtocol_Name()+"'");
					}
					o.setProtocol_Id(protocolKeymap.get(key));
				}
				//update mref Performer
				if(o.getPerformer_Name() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextProtocolApplication = false;

					int listSize = 0;
					if(o.getPerformer_Name() != null) listSize = Math.max(o.getPerformer_Name().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getPerformer_Name().get(i);
						if(performerKeymap.get(key) == null){
							logger.error("Import of 'ProtocolApplication' objects failed: "+o);
							throw new Exception("Import of 'ProtocolApplication' objects failed: cannot find performer_name='"+(o.getPerformer_Name() != null && i < o.getPerformer_Name().size() ? o.getPerformer_Name().get(i) : "null")+"'");
						}
						mrefs.add(performerKeymap.get(key));
					}
					if(breakToNextProtocolApplication){
						break;
					}
					o.setPerformer_Id(mrefs);
				}
				break;
			}
		}
		
		investigationKeymap.clear();
		ontologyReferenceKeymap.clear();
		protocolKeymap.clear();
		performerKeymap.clear();
		
		return protocolApplicationsMissingRefs;
	}
}

