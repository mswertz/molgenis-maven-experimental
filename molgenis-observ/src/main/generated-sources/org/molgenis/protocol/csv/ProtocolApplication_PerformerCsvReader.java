
/* File:        observ/model/ProtocolApplication_Performer.java
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

import org.molgenis.auth.Person;
import org.molgenis.protocol.ProtocolApplication;
import org.molgenis.protocol.ProtocolApplication_Performer;


/**
 * Reads ProtocolApplication_Performer from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ProtocolApplication_PerformerCsvReader extends CsvToDatabase<ProtocolApplication_Performer>
{
	public static final transient Logger logger = Logger.getLogger(ProtocolApplication_PerformerCsvReader.class);
	
	//foreign key map for xref 'performer' (maps person.name -> person.id)			
	final Map<String,Integer> performerKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'protocolApplication' (maps protocolApplication.name -> protocolApplication.id)			
	final Map<String,Integer> protocolApplicationKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports ProtocolApplication_Performer from tab/comma delimited File
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
		final List<ProtocolApplication_Performer> protocolApplication_PerformersMissingRefs = new ArrayList<ProtocolApplication_Performer>();
	
		//cache for objects to be imported from file (in batch)
		final List<ProtocolApplication_Performer> protocolApplication_PerformerList = new ArrayList<ProtocolApplication_Performer>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			ProtocolApplication_Performer object = new ProtocolApplication_Performer();
			object.set(defaults, false); 
			object.set(tuple, false);				
			protocolApplication_PerformerList.add(object);		
			
			//add to db when batch size is reached
			if(protocolApplication_PerformerList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				protocolApplication_PerformersMissingRefs.addAll(resolveForeignKeys(db, protocolApplication_PerformerList));
				
				//update objects in the database using xref_label defined secondary key(s) 'Performer,ProtocolApplication' defined in xref_label
				db.update(protocolApplication_PerformerList,dbAction, "Performer", "ProtocolApplication");
				
				//clear for next batch						
				protocolApplication_PerformerList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!protocolApplication_PerformerList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			protocolApplication_PerformersMissingRefs.addAll(resolveForeignKeys(db, protocolApplication_PerformerList));
			//update objects in the database using xref_label defined secondary key(s) 'Performer,ProtocolApplication' defined in xref_label
			db.update(protocolApplication_PerformerList,dbAction, "Performer", "ProtocolApplication");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<ProtocolApplication_Performer> protocolApplication_PerformersStillMissingRefs = resolveForeignKeys(db, protocolApplication_PerformersMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(protocolApplication_PerformersStillMissingRefs.size() > 0){
			throw new Exception("Import of 'ProtocolApplication_Performer' objects failed: attempting to resolve in-list references, but there are still ProtocolApplication_Performers referring to ProtocolApplication_Performers that are neither in the database nor in the list of to-be imported ProtocolApplication_Performers. (the first one being: "+protocolApplication_PerformersStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(protocolApplication_PerformersMissingRefs,DatabaseAction.UPDATE, "Performer", "ProtocolApplication");
		
			//output count
			total.set(total.get() + protocolApplication_PerformerList.size());
			logger.info("imported "+total.get()+" protocolApplication_Performer from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param protocolApplication_PerformerList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<ProtocolApplication_Performer> resolveForeignKeys(Database db, List<ProtocolApplication_Performer> protocolApplication_PerformerList) throws Exception
	{
		//keep a list of ProtocolApplication_Performer instances that miss a reference which might be resolvable later
		List<ProtocolApplication_Performer> protocolApplication_PerformersMissingRefs = new ArrayList<ProtocolApplication_Performer>();
	
		//resolve xref 'performer' from person.name -> person.id
		for(ProtocolApplication_Performer o: protocolApplication_PerformerList) 
		{
			if(o.getPerformer_Name() != null) 
				performerKeymap.put(o.getPerformer_Name(), null);
		}
		
		if(performerKeymap.size() > 0) 
		{
			List<Person> performerList = db.query(Person.class).in("name",new ArrayList<Object>(performerKeymap.keySet())).find();
			for(Person xref :  performerList)
			{
				performerKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'protocolApplication' from protocolApplication.name -> protocolApplication.id
		for(ProtocolApplication_Performer o: protocolApplication_PerformerList) 
		{
			if(o.getProtocolApplication_Name() != null) 
				protocolApplicationKeymap.put(o.getProtocolApplication_Name(), null);
		}
		
		if(protocolApplicationKeymap.size() > 0) 
		{
			List<ProtocolApplication> protocolApplicationList = db.query(ProtocolApplication.class).in("name",new ArrayList<Object>(protocolApplicationKeymap.keySet())).find();
			for(ProtocolApplication xref :  protocolApplicationList)
			{
				protocolApplicationKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(ProtocolApplication_Performer o:  protocolApplication_PerformerList)
		{
			while(true){
				//update xref Performer
				if(o.getPerformer_Name() != null) 
				{
					String key = o.getPerformer_Name();
					if(performerKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ProtocolApplication_Performer' objects failed: cannot find Person for performer_name='"+o.getPerformer_Name()+"'");
					}
					o.setPerformer_Id(performerKeymap.get(key));
				}
				//update xref ProtocolApplication
				if(o.getProtocolApplication_Name() != null) 
				{
					String key = o.getProtocolApplication_Name();
					if(protocolApplicationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ProtocolApplication_Performer' objects failed: cannot find ProtocolApplication for protocolApplication_name='"+o.getProtocolApplication_Name()+"'");
					}
					o.setProtocolApplication_Id(protocolApplicationKeymap.get(key));
				}
				break;
			}
		}
		
		performerKeymap.clear();
		protocolApplicationKeymap.clear();
		
		return protocolApplication_PerformersMissingRefs;
	}
}

