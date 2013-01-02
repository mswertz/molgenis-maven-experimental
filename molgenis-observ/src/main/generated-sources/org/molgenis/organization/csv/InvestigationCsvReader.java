
/* File:        observ/model/Investigation.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.organization.csv;

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
import org.molgenis.organization.Investigation;


/**
 * Reads Investigation from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class InvestigationCsvReader extends CsvToDatabase<Investigation>
{
	public static final transient Logger logger = Logger.getLogger(InvestigationCsvReader.class);
	
	//foreign key map for xref 'contacts' (maps person.name -> person.id)			
	final Map<String,Integer> contactsKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Investigation from tab/comma delimited File
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
		final List<Investigation> investigationsMissingRefs = new ArrayList<Investigation>();
	
		//cache for objects to be imported from file (in batch)
		final List<Investigation> investigationList = new ArrayList<Investigation>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Investigation object = new Investigation();
			object.set(defaults, false); 
			object.set(tuple, false);				
			investigationList.add(object);		
			
			//add to db when batch size is reached
			if(investigationList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				investigationsMissingRefs.addAll(resolveForeignKeys(db, investigationList));
				
				//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
				db.update(investigationList,dbAction, "name");
				
				//clear for next batch						
				investigationList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!investigationList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			investigationsMissingRefs.addAll(resolveForeignKeys(db, investigationList));
			//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
			db.update(investigationList,dbAction, "name");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<Investigation> investigationsStillMissingRefs = resolveForeignKeys(db, investigationsMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(investigationsStillMissingRefs.size() > 0){
			throw new Exception("Import of 'Investigation' objects failed: attempting to resolve in-list references, but there are still Investigations referring to Investigations that are neither in the database nor in the list of to-be imported Investigations. (the first one being: "+investigationsStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(investigationsMissingRefs,DatabaseAction.UPDATE, "name");
		
			//output count
			total.set(total.get() + investigationList.size());
			logger.info("imported "+total.get()+" investigation from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param investigationList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Investigation> resolveForeignKeys(Database db, List<Investigation> investigationList) throws Exception
	{
		//keep a list of Investigation instances that miss a reference which might be resolvable later
		List<Investigation> investigationsMissingRefs = new ArrayList<Investigation>();
	
		//resolve xref 'contacts' from person.name -> person.id
		for(Investigation o: investigationList) for(String xref_label: o.getContacts_Name())
		{
			if(xref_label != null) 
				contactsKeymap.put(xref_label, null);
		}
		
		if(contactsKeymap.size() > 0) 
		{
			List<Person> contactsList = db.query(Person.class).in("name",new ArrayList<Object>(contactsKeymap.keySet())).find();
			for(Person xref :  contactsList)
			{
				contactsKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Investigation o:  investigationList)
		{
			while(true){
				//update mref contacts
				if(o.getContacts_Name() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextInvestigation = false;

					int listSize = 0;
					if(o.getContacts_Name() != null) listSize = Math.max(o.getContacts_Name().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getContacts_Name().get(i);
						if(contactsKeymap.get(key) == null){
							logger.error("Import of 'Investigation' objects failed: "+o);
							throw new Exception("Import of 'Investigation' objects failed: cannot find contacts_name='"+(o.getContacts_Name() != null && i < o.getContacts_Name().size() ? o.getContacts_Name().get(i) : "null")+"'");
						}
						mrefs.add(contactsKeymap.get(key));
					}
					if(breakToNextInvestigation){
						break;
					}
					o.setContacts_Id(mrefs);
				}
				break;
			}
		}
		
		contactsKeymap.clear();
		
		return investigationsMissingRefs;
	}
}

