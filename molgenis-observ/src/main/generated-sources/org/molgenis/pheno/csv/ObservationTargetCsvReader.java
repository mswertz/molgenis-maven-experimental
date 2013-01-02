
/* File:        observ/model/ObservationTarget.java
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

import org.molgenis.organization.Investigation;
import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.AlternateId;
import org.molgenis.pheno.ObservationTarget;


/**
 * Reads ObservationTarget from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ObservationTargetCsvReader extends CsvToDatabase<ObservationTarget>
{
	public static final transient Logger logger = Logger.getLogger(ObservationTargetCsvReader.class);
	
	//foreign key map for xref 'investigation' (maps investigation.name -> investigation.id)			
	final Map<String,Integer> investigationKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'ontologyReference' (maps ontologyTerm.name -> ontologyTerm.id)			
	final Map<String,Integer> ontologyReferenceKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'alternateId' (maps alternateId.name -> alternateId.id)			
	final Map<String,Integer> alternateIdKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports ObservationTarget from tab/comma delimited File
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
		final List<ObservationTarget> observationTargetsMissingRefs = new ArrayList<ObservationTarget>();
	
		//cache for objects to be imported from file (in batch)
		final List<ObservationTarget> observationTargetList = new ArrayList<ObservationTarget>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			ObservationTarget object = new ObservationTarget();
			object.set(defaults, false); 
			object.set(tuple, false);				
			observationTargetList.add(object);		
			
			//add to db when batch size is reached
			if(observationTargetList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				observationTargetsMissingRefs.addAll(resolveForeignKeys(db, observationTargetList));
				
				//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
				db.update(observationTargetList,dbAction, "name");
				
				//clear for next batch						
				observationTargetList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!observationTargetList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			observationTargetsMissingRefs.addAll(resolveForeignKeys(db, observationTargetList));
			//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
			db.update(observationTargetList,dbAction, "name");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<ObservationTarget> observationTargetsStillMissingRefs = resolveForeignKeys(db, observationTargetsMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(observationTargetsStillMissingRefs.size() > 0){
			throw new Exception("Import of 'ObservationTarget' objects failed: attempting to resolve in-list references, but there are still ObservationTargets referring to ObservationTargets that are neither in the database nor in the list of to-be imported ObservationTargets. (the first one being: "+observationTargetsStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(observationTargetsMissingRefs,DatabaseAction.UPDATE, "name");
		
			//output count
			total.set(total.get() + observationTargetList.size());
			logger.info("imported "+total.get()+" observationTarget from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param observationTargetList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<ObservationTarget> resolveForeignKeys(Database db, List<ObservationTarget> observationTargetList) throws Exception
	{
		//keep a list of ObservationTarget instances that miss a reference which might be resolvable later
		List<ObservationTarget> observationTargetsMissingRefs = new ArrayList<ObservationTarget>();
	
		//resolve xref 'investigation' from investigation.name -> investigation.id
		for(ObservationTarget o: observationTargetList) 
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
		//resolve xref 'ontologyReference' from ontologyTerm.name -> ontologyTerm.id
		for(ObservationTarget o: observationTargetList) for(String xref_label: o.getOntologyReference_Name())
		{
			if(xref_label != null) 
				ontologyReferenceKeymap.put(xref_label, null);
		}
		
		if(ontologyReferenceKeymap.size() > 0) 
		{
			List<OntologyTerm> ontologyReferenceList = db.query(OntologyTerm.class).in("name",new ArrayList<Object>(ontologyReferenceKeymap.keySet())).find();
			for(OntologyTerm xref :  ontologyReferenceList)
			{
				ontologyReferenceKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'alternateId' from alternateId.name -> alternateId.id
		for(ObservationTarget o: observationTargetList) for(String xref_label: o.getAlternateId_Name())
		{
			if(xref_label != null) 
				alternateIdKeymap.put(xref_label, null);
		}
		
		if(alternateIdKeymap.size() > 0) 
		{
			List<AlternateId> alternateIdList = db.query(AlternateId.class).in("name",new ArrayList<Object>(alternateIdKeymap.keySet())).find();
			for(AlternateId xref :  alternateIdList)
			{
				alternateIdKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(ObservationTarget o:  observationTargetList)
		{
			while(true){
				//update xref Investigation
				if(o.getInvestigation_Name() != null) 
				{
					String key = o.getInvestigation_Name();
					if(investigationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ObservationTarget' objects failed: cannot find Investigation for investigation_name='"+o.getInvestigation_Name()+"'");
					}
					o.setInvestigation_Id(investigationKeymap.get(key));
				}
				//update mref ontologyReference
				if(o.getOntologyReference_Name() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextObservationTarget = false;

					int listSize = 0;
					if(o.getOntologyReference_Name() != null) listSize = Math.max(o.getOntologyReference_Name().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getOntologyReference_Name().get(i);
						if(ontologyReferenceKeymap.get(key) == null){
							logger.error("Import of 'ObservationTarget' objects failed: "+o);
							throw new Exception("Import of 'ObservationTarget' objects failed: cannot find ontologyReference_name='"+(o.getOntologyReference_Name() != null && i < o.getOntologyReference_Name().size() ? o.getOntologyReference_Name().get(i) : "null")+"'");
						}
						mrefs.add(ontologyReferenceKeymap.get(key));
					}
					if(breakToNextObservationTarget){
						break;
					}
					o.setOntologyReference_Id(mrefs);
				}
				//update mref AlternateId
				if(o.getAlternateId_Name() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextObservationTarget = false;

					int listSize = 0;
					if(o.getAlternateId_Name() != null) listSize = Math.max(o.getAlternateId_Name().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getAlternateId_Name().get(i);
						if(alternateIdKeymap.get(key) == null){
							logger.error("Import of 'ObservationTarget' objects failed: "+o);
							throw new Exception("Import of 'ObservationTarget' objects failed: cannot find alternateId_name='"+(o.getAlternateId_Name() != null && i < o.getAlternateId_Name().size() ? o.getAlternateId_Name().get(i) : "null")+"'");
						}
						mrefs.add(alternateIdKeymap.get(key));
					}
					if(breakToNextObservationTarget){
						break;
					}
					o.setAlternateId_Id(mrefs);
				}
				break;
			}
		}
		
		investigationKeymap.clear();
		ontologyReferenceKeymap.clear();
		alternateIdKeymap.clear();
		
		return observationTargetsMissingRefs;
	}
}

