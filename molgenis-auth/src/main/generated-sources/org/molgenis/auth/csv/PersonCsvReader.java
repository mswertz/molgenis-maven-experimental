
/* File:        auth/model/Person.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.auth.csv;

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

import org.molgenis.auth.Institute;
import org.molgenis.core.OntologyTerm;
import org.molgenis.auth.Person;


/**
 * Reads Person from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class PersonCsvReader extends CsvToDatabase<Person>
{
	public static final transient Logger logger = Logger.getLogger(PersonCsvReader.class);
	
	//foreign key map for xref 'affiliation' (maps institute.name -> institute.id)			
	final Map<String,Integer> affiliationKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'roles' (maps ontologyTerm.name -> ontologyTerm.id)			
	final Map<String,Integer> rolesKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Person from tab/comma delimited File
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
		final List<Person> personsMissingRefs = new ArrayList<Person>();
	
		//cache for objects to be imported from file (in batch)
		final List<Person> personList = new ArrayList<Person>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Person object = new Person();
			object.set(defaults, false); 
			object.set(tuple, false);				
			personList.add(object);		
			
			//add to db when batch size is reached
			if(personList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				personsMissingRefs.addAll(resolveForeignKeys(db, personList));
				
				//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
				db.update(personList,dbAction, "name");
				
				//clear for next batch						
				personList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!personList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			personsMissingRefs.addAll(resolveForeignKeys(db, personList));
			//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
			db.update(personList,dbAction, "name");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<Person> personsStillMissingRefs = resolveForeignKeys(db, personsMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(personsStillMissingRefs.size() > 0){
			throw new Exception("Import of 'Person' objects failed: attempting to resolve in-list references, but there are still Persons referring to Persons that are neither in the database nor in the list of to-be imported Persons. (the first one being: "+personsStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(personsMissingRefs,DatabaseAction.UPDATE, "name");
		
			//output count
			total.set(total.get() + personList.size());
			logger.info("imported "+total.get()+" person from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param personList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Person> resolveForeignKeys(Database db, List<Person> personList) throws Exception
	{
		//keep a list of Person instances that miss a reference which might be resolvable later
		List<Person> personsMissingRefs = new ArrayList<Person>();
	
		//resolve xref 'affiliation' from institute.name -> institute.id
		for(Person o: personList) 
		{
			if(o.getAffiliation_Name() != null) 
				affiliationKeymap.put(o.getAffiliation_Name(), null);
		}
		
		if(affiliationKeymap.size() > 0) 
		{
			List<Institute> affiliationList = db.query(Institute.class).in("name",new ArrayList<Object>(affiliationKeymap.keySet())).find();
			for(Institute xref :  affiliationList)
			{
				affiliationKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'roles' from ontologyTerm.name -> ontologyTerm.id
		for(Person o: personList) 
		{
			if(o.getRoles_Name() != null) 
				rolesKeymap.put(o.getRoles_Name(), null);
		}
		
		if(rolesKeymap.size() > 0) 
		{
			List<OntologyTerm> rolesList = db.query(OntologyTerm.class).in("name",new ArrayList<Object>(rolesKeymap.keySet())).find();
			for(OntologyTerm xref :  rolesList)
			{
				rolesKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Person o:  personList)
		{
			while(true){
				//update xref Affiliation
				if(o.getAffiliation_Name() != null) 
				{
					String key = o.getAffiliation_Name();
					if(affiliationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Person' objects failed: cannot find Institute for affiliation_name='"+o.getAffiliation_Name()+"'");
					}
					o.setAffiliation_Id(affiliationKeymap.get(key));
				}
				//update xref Roles
				if(o.getRoles_Name() != null) 
				{
					String key = o.getRoles_Name();
					if(rolesKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Person' objects failed: cannot find OntologyTerm for roles_name='"+o.getRoles_Name()+"'");
					}
					o.setRoles_Id(rolesKeymap.get(key));
				}
				break;
			}
		}
		
		affiliationKeymap.clear();
		rolesKeymap.clear();
		
		return personsMissingRefs;
	}
}

