
/* File:        auth/model/OntologyTerm.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
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

import org.molgenis.core.Ontology;
import org.molgenis.core.OntologyTerm;


/**
 * Reads OntologyTerm from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class OntologyTermCsvReader extends CsvToDatabase<OntologyTerm>
{
	public static final transient Logger logger = Logger.getLogger(OntologyTermCsvReader.class);
	
	//foreign key map for xref 'ontology' (maps ontology.name -> ontology.id)			
	final Map<String,Integer> ontologyKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports OntologyTerm from tab/comma delimited File
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
		final List<OntologyTerm> ontologyTermsMissingRefs = new ArrayList<OntologyTerm>();
	
		//cache for objects to be imported from file (in batch)
		final List<OntologyTerm> ontologyTermList = new ArrayList<OntologyTerm>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			OntologyTerm object = new OntologyTerm();
			object.set(defaults, false); 
			object.set(tuple, false);				
			ontologyTermList.add(object);		
			
			//add to db when batch size is reached
			if(ontologyTermList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				ontologyTermsMissingRefs.addAll(resolveForeignKeys(db, ontologyTermList));
				
				//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
				db.update(ontologyTermList,dbAction, "name");
				
				//clear for next batch						
				ontologyTermList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!ontologyTermList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			ontologyTermsMissingRefs.addAll(resolveForeignKeys(db, ontologyTermList));
			//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
			db.update(ontologyTermList,dbAction, "name");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<OntologyTerm> ontologyTermsStillMissingRefs = resolveForeignKeys(db, ontologyTermsMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(ontologyTermsStillMissingRefs.size() > 0){
			throw new Exception("Import of 'OntologyTerm' objects failed: attempting to resolve in-list references, but there are still OntologyTerms referring to OntologyTerms that are neither in the database nor in the list of to-be imported OntologyTerms. (the first one being: "+ontologyTermsStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(ontologyTermsMissingRefs,DatabaseAction.UPDATE, "name");
		
			//output count
			total.set(total.get() + ontologyTermList.size());
			logger.info("imported "+total.get()+" ontologyTerm from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param ontologyTermList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<OntologyTerm> resolveForeignKeys(Database db, List<OntologyTerm> ontologyTermList) throws Exception
	{
		//keep a list of OntologyTerm instances that miss a reference which might be resolvable later
		List<OntologyTerm> ontologyTermsMissingRefs = new ArrayList<OntologyTerm>();
	
		//resolve xref 'ontology' from ontology.name -> ontology.id
		for(OntologyTerm o: ontologyTermList) 
		{
			if(o.getOntology_Name() != null) 
				ontologyKeymap.put(o.getOntology_Name(), null);
		}
		
		if(ontologyKeymap.size() > 0) 
		{
			List<Ontology> ontologyList = db.query(Ontology.class).in("name",new ArrayList<Object>(ontologyKeymap.keySet())).find();
			for(Ontology xref :  ontologyList)
			{
				ontologyKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(OntologyTerm o:  ontologyTermList)
		{
			while(true){
				//update xref ontology
				if(o.getOntology_Name() != null) 
				{
					String key = o.getOntology_Name();
					if(ontologyKeymap.get(key) == null)
					{
						throw new Exception("Import of 'OntologyTerm' objects failed: cannot find Ontology for ontology_name='"+o.getOntology_Name()+"'");
					}
					o.setOntology_Id(ontologyKeymap.get(key));
				}
				break;
			}
		}
		
		ontologyKeymap.clear();
		
		return ontologyTermsMissingRefs;
	}
}

