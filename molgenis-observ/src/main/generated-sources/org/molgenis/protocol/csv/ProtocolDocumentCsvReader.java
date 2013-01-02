
/* File:        observ/model/ProtocolDocument.java
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
import org.molgenis.protocol.ProtocolDocument;


/**
 * Reads ProtocolDocument from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ProtocolDocumentCsvReader extends CsvToDatabase<ProtocolDocument>
{
	public static final transient Logger logger = Logger.getLogger(ProtocolDocumentCsvReader.class);
	
	//foreign key map for xref 'protocol' (maps protocol.name -> protocol.id)			
	final Map<String,Integer> protocolKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports ProtocolDocument from tab/comma delimited File
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
		final List<ProtocolDocument> protocolDocumentsMissingRefs = new ArrayList<ProtocolDocument>();
	
		//cache for objects to be imported from file (in batch)
		final List<ProtocolDocument> protocolDocumentList = new ArrayList<ProtocolDocument>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			ProtocolDocument object = new ProtocolDocument();
			object.set(defaults, false); 
			object.set(tuple, false);				
			protocolDocumentList.add(object);		
			
			//add to db when batch size is reached
			if(protocolDocumentList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				protocolDocumentsMissingRefs.addAll(resolveForeignKeys(db, protocolDocumentList));
				
				//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
				db.update(protocolDocumentList,dbAction, "name");
				
				//clear for next batch						
				protocolDocumentList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!protocolDocumentList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			protocolDocumentsMissingRefs.addAll(resolveForeignKeys(db, protocolDocumentList));
			//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
			db.update(protocolDocumentList,dbAction, "name");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<ProtocolDocument> protocolDocumentsStillMissingRefs = resolveForeignKeys(db, protocolDocumentsMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(protocolDocumentsStillMissingRefs.size() > 0){
			throw new Exception("Import of 'ProtocolDocument' objects failed: attempting to resolve in-list references, but there are still ProtocolDocuments referring to ProtocolDocuments that are neither in the database nor in the list of to-be imported ProtocolDocuments. (the first one being: "+protocolDocumentsStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(protocolDocumentsMissingRefs,DatabaseAction.UPDATE, "name");
		
			//output count
			total.set(total.get() + protocolDocumentList.size());
			logger.info("imported "+total.get()+" protocolDocument from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param protocolDocumentList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<ProtocolDocument> resolveForeignKeys(Database db, List<ProtocolDocument> protocolDocumentList) throws Exception
	{
		//keep a list of ProtocolDocument instances that miss a reference which might be resolvable later
		List<ProtocolDocument> protocolDocumentsMissingRefs = new ArrayList<ProtocolDocument>();
	
		//resolve xref 'protocol' from protocol.name -> protocol.id
		for(ProtocolDocument o: protocolDocumentList) 
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
		for(ProtocolDocument o:  protocolDocumentList)
		{
			while(true){
				//update xref protocol
				if(o.getProtocol_Name() != null) 
				{
					String key = o.getProtocol_Name();
					if(protocolKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ProtocolDocument' objects failed: cannot find Protocol for protocol_name='"+o.getProtocol_Name()+"'");
					}
					o.setProtocol_Id(protocolKeymap.get(key));
				}
				break;
			}
		}
		
		protocolKeymap.clear();
		
		return protocolDocumentsMissingRefs;
	}
}

