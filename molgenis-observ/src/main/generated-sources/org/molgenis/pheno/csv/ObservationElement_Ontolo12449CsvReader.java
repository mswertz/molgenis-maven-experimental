
/* File:        observ/model/ObservationElement_ontolo12449.java
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

import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.ObservationElement;
import org.molgenis.pheno.ObservationElement_Ontolo12449;


/**
 * Reads ObservationElement_Ontolo12449 from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ObservationElement_Ontolo12449CsvReader extends CsvToDatabase<ObservationElement_Ontolo12449>
{
	public static final transient Logger logger = Logger.getLogger(ObservationElement_Ontolo12449CsvReader.class);
	
	//foreign key map for xref 'ontologyReference' (maps ontologyTerm.name -> ontologyTerm.id)			
	final Map<String,Integer> ontologyReferenceKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'investigationElement' (maps observationElement.name -> observationElement.id)			
	final Map<String,Integer> investigationElementKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports ObservationElement_Ontolo12449 from tab/comma delimited File
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
		final List<ObservationElement_Ontolo12449> observationElement_ontolo12449sMissingRefs = new ArrayList<ObservationElement_Ontolo12449>();
	
		//cache for objects to be imported from file (in batch)
		final List<ObservationElement_Ontolo12449> observationElement_ontolo12449List = new ArrayList<ObservationElement_Ontolo12449>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			ObservationElement_Ontolo12449 object = new ObservationElement_Ontolo12449();
			object.set(defaults, false); 
			object.set(tuple, false);				
			observationElement_ontolo12449List.add(object);		
			
			//add to db when batch size is reached
			if(observationElement_ontolo12449List.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				observationElement_ontolo12449sMissingRefs.addAll(resolveForeignKeys(db, observationElement_ontolo12449List));
				
				//update objects in the database using xref_label defined secondary key(s) 'ontologyReference,InvestigationElement' defined in xref_label
				db.update(observationElement_ontolo12449List,dbAction, "ontologyReference", "InvestigationElement");
				
				//clear for next batch						
				observationElement_ontolo12449List.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!observationElement_ontolo12449List.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			observationElement_ontolo12449sMissingRefs.addAll(resolveForeignKeys(db, observationElement_ontolo12449List));
			//update objects in the database using xref_label defined secondary key(s) 'ontologyReference,InvestigationElement' defined in xref_label
			db.update(observationElement_ontolo12449List,dbAction, "ontologyReference", "InvestigationElement");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<ObservationElement_Ontolo12449> observationElement_ontolo12449sStillMissingRefs = resolveForeignKeys(db, observationElement_ontolo12449sMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(observationElement_ontolo12449sStillMissingRefs.size() > 0){
			throw new Exception("Import of 'ObservationElement_Ontolo12449' objects failed: attempting to resolve in-list references, but there are still ObservationElement_Ontolo12449s referring to ObservationElement_Ontolo12449s that are neither in the database nor in the list of to-be imported ObservationElement_Ontolo12449s. (the first one being: "+observationElement_ontolo12449sStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(observationElement_ontolo12449sMissingRefs,DatabaseAction.UPDATE, "ontologyReference", "InvestigationElement");
		
			//output count
			total.set(total.get() + observationElement_ontolo12449List.size());
			logger.info("imported "+total.get()+" observationElement_ontolo12449 from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param observationElement_ontolo12449List 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<ObservationElement_Ontolo12449> resolveForeignKeys(Database db, List<ObservationElement_Ontolo12449> observationElement_ontolo12449List) throws Exception
	{
		//keep a list of ObservationElement_ontolo12449 instances that miss a reference which might be resolvable later
		List<ObservationElement_Ontolo12449> observationElement_ontolo12449sMissingRefs = new ArrayList<ObservationElement_Ontolo12449>();
	
		//resolve xref 'ontologyReference' from ontologyTerm.name -> ontologyTerm.id
		for(ObservationElement_Ontolo12449 o: observationElement_ontolo12449List) 
		{
			if(o.getOntologyReference_Name() != null) 
				ontologyReferenceKeymap.put(o.getOntologyReference_Name(), null);
		}
		
		if(ontologyReferenceKeymap.size() > 0) 
		{
			List<OntologyTerm> ontologyReferenceList = db.query(OntologyTerm.class).in("name",new ArrayList<Object>(ontologyReferenceKeymap.keySet())).find();
			for(OntologyTerm xref :  ontologyReferenceList)
			{
				ontologyReferenceKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'investigationElement' from observationElement.name -> observationElement.id
		for(ObservationElement_Ontolo12449 o: observationElement_ontolo12449List) 
		{
			if(o.getInvestigationElement_Name() != null) 
				investigationElementKeymap.put(o.getInvestigationElement_Name(), null);
		}
		
		if(investigationElementKeymap.size() > 0) 
		{
			List<ObservationElement> investigationElementList = db.query(ObservationElement.class).in("name",new ArrayList<Object>(investigationElementKeymap.keySet())).find();
			for(ObservationElement xref :  investigationElementList)
			{
				investigationElementKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(ObservationElement_Ontolo12449 o:  observationElement_ontolo12449List)
		{
			while(true){
				//update xref ontologyReference
				if(o.getOntologyReference_Name() != null) 
				{
					String key = o.getOntologyReference_Name();
					if(ontologyReferenceKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ObservationElement_ontolo12449' objects failed: cannot find OntologyTerm for ontologyReference_name='"+o.getOntologyReference_Name()+"'");
					}
					o.setOntologyReference_Id(ontologyReferenceKeymap.get(key));
				}
				//update xref InvestigationElement
				if(o.getInvestigationElement_Name() != null) 
				{
					String key = o.getInvestigationElement_Name();
					if(investigationElementKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ObservationElement_ontolo12449' objects failed: cannot find ObservationElement for investigationElement_name='"+o.getInvestigationElement_Name()+"'");
					}
					o.setInvestigationElement_Id(investigationElementKeymap.get(key));
				}
				break;
			}
		}
		
		ontologyReferenceKeymap.clear();
		investigationElementKeymap.clear();
		
		return observationElement_ontolo12449sMissingRefs;
	}
}

