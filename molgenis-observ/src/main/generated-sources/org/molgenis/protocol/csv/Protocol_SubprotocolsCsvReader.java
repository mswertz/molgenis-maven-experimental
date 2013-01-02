
/* File:        observ/model/Protocol_subprotocols.java
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

import org.molgenis.protocol.Protocol;
import org.molgenis.protocol.Protocol_Subprotocols;


/**
 * Reads Protocol_Subprotocols from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class Protocol_SubprotocolsCsvReader extends CsvToDatabase<Protocol_Subprotocols>
{
	public static final transient Logger logger = Logger.getLogger(Protocol_SubprotocolsCsvReader.class);
	
	//foreign key map for xref 'subprotocols' (maps protocol.name -> protocol.id)			
	final Map<String,Integer> subprotocolsKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'protocol' (maps protocol.name -> protocol.id)			
	final Map<String,Integer> protocolKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Protocol_Subprotocols from tab/comma delimited File
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
		final List<Protocol_Subprotocols> protocol_subprotocolssMissingRefs = new ArrayList<Protocol_Subprotocols>();
	
		//cache for objects to be imported from file (in batch)
		final List<Protocol_Subprotocols> protocol_subprotocolsList = new ArrayList<Protocol_Subprotocols>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Protocol_Subprotocols object = new Protocol_Subprotocols();
			object.set(defaults, false); 
			object.set(tuple, false);				
			protocol_subprotocolsList.add(object);		
			
			//add to db when batch size is reached
			if(protocol_subprotocolsList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				protocol_subprotocolssMissingRefs.addAll(resolveForeignKeys(db, protocol_subprotocolsList));
				
				//update objects in the database using xref_label defined secondary key(s) 'subprotocols,Protocol' defined in xref_label
				db.update(protocol_subprotocolsList,dbAction, "subprotocols", "Protocol");
				
				//clear for next batch						
				protocol_subprotocolsList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!protocol_subprotocolsList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			protocol_subprotocolssMissingRefs.addAll(resolveForeignKeys(db, protocol_subprotocolsList));
			//update objects in the database using xref_label defined secondary key(s) 'subprotocols,Protocol' defined in xref_label
			db.update(protocol_subprotocolsList,dbAction, "subprotocols", "Protocol");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<Protocol_Subprotocols> protocol_subprotocolssStillMissingRefs = resolveForeignKeys(db, protocol_subprotocolssMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(protocol_subprotocolssStillMissingRefs.size() > 0){
			throw new Exception("Import of 'Protocol_Subprotocols' objects failed: attempting to resolve in-list references, but there are still Protocol_Subprotocolss referring to Protocol_Subprotocolss that are neither in the database nor in the list of to-be imported Protocol_Subprotocolss. (the first one being: "+protocol_subprotocolssStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(protocol_subprotocolssMissingRefs,DatabaseAction.UPDATE, "subprotocols", "Protocol");
		
			//output count
			total.set(total.get() + protocol_subprotocolsList.size());
			logger.info("imported "+total.get()+" protocol_subprotocols from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param protocol_subprotocolsList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Protocol_Subprotocols> resolveForeignKeys(Database db, List<Protocol_Subprotocols> protocol_subprotocolsList) throws Exception
	{
		//keep a list of Protocol_subprotocols instances that miss a reference which might be resolvable later
		List<Protocol_Subprotocols> protocol_subprotocolssMissingRefs = new ArrayList<Protocol_Subprotocols>();
	
		//resolve xref 'subprotocols' from protocol.name -> protocol.id
		for(Protocol_Subprotocols o: protocol_subprotocolsList) 
		{
			if(o.getSubprotocols_Name() != null) 
				subprotocolsKeymap.put(o.getSubprotocols_Name(), null);
		}
		
		if(subprotocolsKeymap.size() > 0) 
		{
			List<Protocol> subprotocolsList = db.query(Protocol.class).in("name",new ArrayList<Object>(subprotocolsKeymap.keySet())).find();
			for(Protocol xref :  subprotocolsList)
			{
				subprotocolsKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'protocol' from protocol.name -> protocol.id
		for(Protocol_Subprotocols o: protocol_subprotocolsList) 
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
		//update objects with foreign key values
		for(Protocol_Subprotocols o:  protocol_subprotocolsList)
		{
			while(true){
				//update xref subprotocols
				if(o.getSubprotocols_Name() != null) 
				{
					String key = o.getSubprotocols_Name();
					if(subprotocolsKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Protocol_subprotocols' objects failed: cannot find Protocol for subprotocols_name='"+o.getSubprotocols_Name()+"'");
					}
					o.setSubprotocols_Id(subprotocolsKeymap.get(key));
				}
				//update xref Protocol
				if(o.getProtocol_Name() != null) 
				{
					String key = o.getProtocol_Name();
					if(protocolKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Protocol_subprotocols' objects failed: cannot find Protocol for protocol_name='"+o.getProtocol_Name()+"'");
					}
					o.setProtocol_Id(protocolKeymap.get(key));
				}
				break;
			}
		}
		
		subprotocolsKeymap.clear();
		protocolKeymap.clear();
		
		return protocol_subprotocolssMissingRefs;
	}
}

