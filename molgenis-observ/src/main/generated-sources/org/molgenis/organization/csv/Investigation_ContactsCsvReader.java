
/* File:        observ/model/Investigation_contacts.java
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
import org.molgenis.organization.Investigation_Contacts;


/**
 * Reads Investigation_Contacts from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class Investigation_ContactsCsvReader extends CsvToDatabase<Investigation_Contacts>
{
	public static final transient Logger logger = Logger.getLogger(Investigation_ContactsCsvReader.class);
	
	//foreign key map for xref 'contacts' (maps person.name -> person.id)			
	final Map<String,Integer> contactsKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'investigation' (maps investigation.name -> investigation.id)			
	final Map<String,Integer> investigationKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Investigation_Contacts from tab/comma delimited File
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
		final List<Investigation_Contacts> investigation_contactssMissingRefs = new ArrayList<Investigation_Contacts>();
	
		//cache for objects to be imported from file (in batch)
		final List<Investigation_Contacts> investigation_contactsList = new ArrayList<Investigation_Contacts>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Investigation_Contacts object = new Investigation_Contacts();
			object.set(defaults, false); 
			object.set(tuple, false);				
			investigation_contactsList.add(object);		
			
			//add to db when batch size is reached
			if(investigation_contactsList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				investigation_contactssMissingRefs.addAll(resolveForeignKeys(db, investigation_contactsList));
				
				//update objects in the database using xref_label defined secondary key(s) 'contacts,Investigation' defined in xref_label
				db.update(investigation_contactsList,dbAction, "contacts", "Investigation");
				
				//clear for next batch						
				investigation_contactsList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!investigation_contactsList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			investigation_contactssMissingRefs.addAll(resolveForeignKeys(db, investigation_contactsList));
			//update objects in the database using xref_label defined secondary key(s) 'contacts,Investigation' defined in xref_label
			db.update(investigation_contactsList,dbAction, "contacts", "Investigation");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<Investigation_Contacts> investigation_contactssStillMissingRefs = resolveForeignKeys(db, investigation_contactssMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(investigation_contactssStillMissingRefs.size() > 0){
			throw new Exception("Import of 'Investigation_Contacts' objects failed: attempting to resolve in-list references, but there are still Investigation_Contactss referring to Investigation_Contactss that are neither in the database nor in the list of to-be imported Investigation_Contactss. (the first one being: "+investigation_contactssStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(investigation_contactssMissingRefs,DatabaseAction.UPDATE, "contacts", "Investigation");
		
			//output count
			total.set(total.get() + investigation_contactsList.size());
			logger.info("imported "+total.get()+" investigation_contacts from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param investigation_contactsList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Investigation_Contacts> resolveForeignKeys(Database db, List<Investigation_Contacts> investigation_contactsList) throws Exception
	{
		//keep a list of Investigation_contacts instances that miss a reference which might be resolvable later
		List<Investigation_Contacts> investigation_contactssMissingRefs = new ArrayList<Investigation_Contacts>();
	
		//resolve xref 'contacts' from person.name -> person.id
		for(Investigation_Contacts o: investigation_contactsList) 
		{
			if(o.getContacts_Name() != null) 
				contactsKeymap.put(o.getContacts_Name(), null);
		}
		
		if(contactsKeymap.size() > 0) 
		{
			List<Person> contactsList = db.query(Person.class).in("name",new ArrayList<Object>(contactsKeymap.keySet())).find();
			for(Person xref :  contactsList)
			{
				contactsKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'investigation' from investigation.name -> investigation.id
		for(Investigation_Contacts o: investigation_contactsList) 
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
		//update objects with foreign key values
		for(Investigation_Contacts o:  investigation_contactsList)
		{
			while(true){
				//update xref contacts
				if(o.getContacts_Name() != null) 
				{
					String key = o.getContacts_Name();
					if(contactsKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Investigation_contacts' objects failed: cannot find Person for contacts_name='"+o.getContacts_Name()+"'");
					}
					o.setContacts_Id(contactsKeymap.get(key));
				}
				//update xref Investigation
				if(o.getInvestigation_Name() != null) 
				{
					String key = o.getInvestigation_Name();
					if(investigationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Investigation_contacts' objects failed: cannot find Investigation for investigation_name='"+o.getInvestigation_Name()+"'");
					}
					o.setInvestigation_Id(investigationKeymap.get(key));
				}
				break;
			}
		}
		
		contactsKeymap.clear();
		investigationKeymap.clear();
		
		return investigation_contactssMissingRefs;
	}
}

