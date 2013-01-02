
/* File:        observ/model/Publication.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.core.csv;

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

import org.molgenis.core.OntologyTerm;
import org.molgenis.core.Publication;


/**
 * Reads Publication from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class PublicationCsvReader extends CsvToDatabase<Publication>
{
	public static final transient Logger logger = Logger.getLogger(PublicationCsvReader.class);
	
	//foreign key map for xref 'pubmedID' (maps ontologyTerm.name -> ontologyTerm.id)			
	final Map<String,Integer> pubmedIDKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'dOI' (maps ontologyTerm.name -> ontologyTerm.id)			
	final Map<String,Integer> dOIKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'status' (maps ontologyTerm.name -> ontologyTerm.id)			
	final Map<String,Integer> statusKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Publication from tab/comma delimited File
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
		final List<Publication> publicationsMissingRefs = new ArrayList<Publication>();
	
		//cache for objects to be imported from file (in batch)
		final List<Publication> publicationList = new ArrayList<Publication>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Publication object = new Publication();
			object.set(defaults, false); 
			object.set(tuple, false);				
			publicationList.add(object);		
			
			//add to db when batch size is reached
			if(publicationList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				publicationsMissingRefs.addAll(resolveForeignKeys(db, publicationList));
				
				//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
				db.update(publicationList,dbAction, "id");
				
				//clear for next batch						
				publicationList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!publicationList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			publicationsMissingRefs.addAll(resolveForeignKeys(db, publicationList));
			//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
			db.update(publicationList,dbAction, "id");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<Publication> publicationsStillMissingRefs = resolveForeignKeys(db, publicationsMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(publicationsStillMissingRefs.size() > 0){
			throw new Exception("Import of 'Publication' objects failed: attempting to resolve in-list references, but there are still Publications referring to Publications that are neither in the database nor in the list of to-be imported Publications. (the first one being: "+publicationsStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(publicationsMissingRefs,DatabaseAction.UPDATE, "id");
		
			//output count
			total.set(total.get() + publicationList.size());
			logger.info("imported "+total.get()+" publication from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param publicationList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Publication> resolveForeignKeys(Database db, List<Publication> publicationList) throws Exception
	{
		//keep a list of Publication instances that miss a reference which might be resolvable later
		List<Publication> publicationsMissingRefs = new ArrayList<Publication>();
	
		//resolve xref 'pubmedID' from ontologyTerm.name -> ontologyTerm.id
		for(Publication o: publicationList) 
		{
			if(o.getPubmedID_Name() != null) 
				pubmedIDKeymap.put(o.getPubmedID_Name(), null);
		}
		
		if(pubmedIDKeymap.size() > 0) 
		{
			List<OntologyTerm> pubmedIDList = db.query(OntologyTerm.class).in("name",new ArrayList<Object>(pubmedIDKeymap.keySet())).find();
			for(OntologyTerm xref :  pubmedIDList)
			{
				pubmedIDKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'dOI' from ontologyTerm.name -> ontologyTerm.id
		for(Publication o: publicationList) 
		{
			if(o.getDOI_Name() != null) 
				dOIKeymap.put(o.getDOI_Name(), null);
		}
		
		if(dOIKeymap.size() > 0) 
		{
			List<OntologyTerm> dOIList = db.query(OntologyTerm.class).in("name",new ArrayList<Object>(dOIKeymap.keySet())).find();
			for(OntologyTerm xref :  dOIList)
			{
				dOIKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'status' from ontologyTerm.name -> ontologyTerm.id
		for(Publication o: publicationList) 
		{
			if(o.getStatus_Name() != null) 
				statusKeymap.put(o.getStatus_Name(), null);
		}
		
		if(statusKeymap.size() > 0) 
		{
			List<OntologyTerm> statusList = db.query(OntologyTerm.class).in("name",new ArrayList<Object>(statusKeymap.keySet())).find();
			for(OntologyTerm xref :  statusList)
			{
				statusKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Publication o:  publicationList)
		{
			while(true){
				//update xref PubmedID
				if(o.getPubmedID_Name() != null) 
				{
					String key = o.getPubmedID_Name();
					if(pubmedIDKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Publication' objects failed: cannot find OntologyTerm for pubmedID_name='"+o.getPubmedID_Name()+"'");
					}
					o.setPubmedID_Id(pubmedIDKeymap.get(key));
				}
				//update xref DOI
				if(o.getDOI_Name() != null) 
				{
					String key = o.getDOI_Name();
					if(dOIKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Publication' objects failed: cannot find OntologyTerm for dOI_name='"+o.getDOI_Name()+"'");
					}
					o.setDOI_Id(dOIKeymap.get(key));
				}
				//update xref Status
				if(o.getStatus_Name() != null) 
				{
					String key = o.getStatus_Name();
					if(statusKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Publication' objects failed: cannot find OntologyTerm for status_name='"+o.getStatus_Name()+"'");
					}
					o.setStatus_Id(statusKeymap.get(key));
				}
				break;
			}
		}
		
		pubmedIDKeymap.clear();
		dOIKeymap.clear();
		statusKeymap.clear();
		
		return publicationsMissingRefs;
	}
}

