
/* File:        observ/model/ObservationElement_AlternateId.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.pheno.csv;

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

import org.molgenis.pheno.AlternateId;
import org.molgenis.pheno.ObservationElement;
import org.molgenis.pheno.ObservationElement_AlternateId;


/**
 * Reads ObservationElement_AlternateId from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ObservationElement_AlternateIdCsvReader extends CsvToDatabase<ObservationElement_AlternateId>
{
	public static final transient Logger logger = Logger.getLogger(ObservationElement_AlternateIdCsvReader.class);
	
	//foreign key map for xref 'alternateId' (maps alternateId.name -> alternateId.id)			
	final Map<String,Integer> alternateIdKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'observationElement' (maps observationElement.name -> observationElement.id)			
	final Map<String,Integer> observationElementKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports ObservationElement_AlternateId from tab/comma delimited File
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
		final List<ObservationElement_AlternateId> observationElement_AlternateIdsMissingRefs = new ArrayList<ObservationElement_AlternateId>();
	
		//cache for objects to be imported from file (in batch)
		final List<ObservationElement_AlternateId> observationElement_AlternateIdList = new ArrayList<ObservationElement_AlternateId>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			ObservationElement_AlternateId object = new ObservationElement_AlternateId();
			object.set(defaults, false); 
			object.set(tuple, false);				
			observationElement_AlternateIdList.add(object);		
			
			//add to db when batch size is reached
			if(observationElement_AlternateIdList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				observationElement_AlternateIdsMissingRefs.addAll(resolveForeignKeys(db, observationElement_AlternateIdList));
				
				//update objects in the database using xref_label defined secondary key(s) 'AlternateId,ObservationElement' defined in xref_label
				db.update(observationElement_AlternateIdList,dbAction, "AlternateId", "ObservationElement");
				
				//clear for next batch						
				observationElement_AlternateIdList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!observationElement_AlternateIdList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			observationElement_AlternateIdsMissingRefs.addAll(resolveForeignKeys(db, observationElement_AlternateIdList));
			//update objects in the database using xref_label defined secondary key(s) 'AlternateId,ObservationElement' defined in xref_label
			db.update(observationElement_AlternateIdList,dbAction, "AlternateId", "ObservationElement");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<ObservationElement_AlternateId> observationElement_AlternateIdsStillMissingRefs = resolveForeignKeys(db, observationElement_AlternateIdsMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(observationElement_AlternateIdsStillMissingRefs.size() > 0){
			throw new Exception("Import of 'ObservationElement_AlternateId' objects failed: attempting to resolve in-list references, but there are still ObservationElement_AlternateIds referring to ObservationElement_AlternateIds that are neither in the database nor in the list of to-be imported ObservationElement_AlternateIds. (the first one being: "+observationElement_AlternateIdsStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(observationElement_AlternateIdsMissingRefs,DatabaseAction.UPDATE, "AlternateId", "ObservationElement");
		
			//output count
			total.set(total.get() + observationElement_AlternateIdList.size());
			logger.info("imported "+total.get()+" observationElement_AlternateId from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param observationElement_AlternateIdList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<ObservationElement_AlternateId> resolveForeignKeys(Database db, List<ObservationElement_AlternateId> observationElement_AlternateIdList) throws Exception
	{
		//keep a list of ObservationElement_AlternateId instances that miss a reference which might be resolvable later
		List<ObservationElement_AlternateId> observationElement_AlternateIdsMissingRefs = new ArrayList<ObservationElement_AlternateId>();
	
		//resolve xref 'alternateId' from alternateId.name -> alternateId.id
		for(ObservationElement_AlternateId o: observationElement_AlternateIdList) 
		{
			if(o.getAlternateId_Name() != null) 
				alternateIdKeymap.put(o.getAlternateId_Name(), null);
		}
		
		if(alternateIdKeymap.size() > 0) 
		{
			List<AlternateId> alternateIdList = db.query(AlternateId.class).in("name",new ArrayList<Object>(alternateIdKeymap.keySet())).find();
			for(AlternateId xref :  alternateIdList)
			{
				alternateIdKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'observationElement' from observationElement.name -> observationElement.id
		for(ObservationElement_AlternateId o: observationElement_AlternateIdList) 
		{
			if(o.getObservationElement_Name() != null) 
				observationElementKeymap.put(o.getObservationElement_Name(), null);
		}
		
		if(observationElementKeymap.size() > 0) 
		{
			List<ObservationElement> observationElementList = db.query(ObservationElement.class).in("name",new ArrayList<Object>(observationElementKeymap.keySet())).find();
			for(ObservationElement xref :  observationElementList)
			{
				observationElementKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(ObservationElement_AlternateId o:  observationElement_AlternateIdList)
		{
			while(true){
				//update xref AlternateId
				if(o.getAlternateId_Name() != null) 
				{
					String key = o.getAlternateId_Name();
					if(alternateIdKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ObservationElement_AlternateId' objects failed: cannot find AlternateId for alternateId_name='"+o.getAlternateId_Name()+"'");
					}
					o.setAlternateId_Id(alternateIdKeymap.get(key));
				}
				//update xref ObservationElement
				if(o.getObservationElement_Name() != null) 
				{
					String key = o.getObservationElement_Name();
					if(observationElementKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ObservationElement_AlternateId' objects failed: cannot find ObservationElement for observationElement_name='"+o.getObservationElement_Name()+"'");
					}
					o.setObservationElement_Id(observationElementKeymap.get(key));
				}
				break;
			}
		}
		
		alternateIdKeymap.clear();
		observationElementKeymap.clear();
		
		return observationElement_AlternateIdsMissingRefs;
	}
}

