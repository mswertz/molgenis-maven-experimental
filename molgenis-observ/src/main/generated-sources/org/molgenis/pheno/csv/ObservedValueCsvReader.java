
/* File:        observ/model/ObservedValue.java
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
import org.molgenis.protocol.ProtocolApplication;
import org.molgenis.pheno.ObservationElement;
import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.ObservedValue;


/**
 * Reads ObservedValue from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ObservedValueCsvReader extends CsvToDatabase<ObservedValue>
{
	public static final transient Logger logger = Logger.getLogger(ObservedValueCsvReader.class);
	
	//foreign key map for xref 'investigation' (maps investigation.name -> investigation.id)			
	final Map<String,Integer> investigationKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'protocolApplication' (maps protocolApplication.name -> protocolApplication.id)			
	final Map<String,Integer> protocolApplicationKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'feature' (maps observationElement.name -> observationElement.id)			
	final Map<String,Integer> featureKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'target' (maps observationElement.name -> observationElement.id)			
	final Map<String,Integer> targetKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'ontologyReference' (maps ontologyTerm.name -> ontologyTerm.id)			
	final Map<String,Integer> ontologyReferenceKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'relation' (maps observationElement.name -> observationElement.id)			
	final Map<String,Integer> relationKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports ObservedValue from tab/comma delimited File
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
		final List<ObservedValue> observedValuesMissingRefs = new ArrayList<ObservedValue>();
	
		//cache for objects to be imported from file (in batch)
		final List<ObservedValue> observedValueList = new ArrayList<ObservedValue>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			ObservedValue object = new ObservedValue();
			object.set(defaults, false); 
			object.set(tuple, false);				
			observedValueList.add(object);		
			
			//add to db when batch size is reached
			if(observedValueList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				observedValuesMissingRefs.addAll(resolveForeignKeys(db, observedValueList));
				
				//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
				db.update(observedValueList,dbAction, "id");
				
				//clear for next batch						
				observedValueList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!observedValueList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			observedValuesMissingRefs.addAll(resolveForeignKeys(db, observedValueList));
			//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
			db.update(observedValueList,dbAction, "id");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<ObservedValue> observedValuesStillMissingRefs = resolveForeignKeys(db, observedValuesMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(observedValuesStillMissingRefs.size() > 0){
			throw new Exception("Import of 'ObservedValue' objects failed: attempting to resolve in-list references, but there are still ObservedValues referring to ObservedValues that are neither in the database nor in the list of to-be imported ObservedValues. (the first one being: "+observedValuesStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(observedValuesMissingRefs,DatabaseAction.UPDATE, "id");
		
			//output count
			total.set(total.get() + observedValueList.size());
			logger.info("imported "+total.get()+" observedValue from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param observedValueList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<ObservedValue> resolveForeignKeys(Database db, List<ObservedValue> observedValueList) throws Exception
	{
		//keep a list of ObservedValue instances that miss a reference which might be resolvable later
		List<ObservedValue> observedValuesMissingRefs = new ArrayList<ObservedValue>();
	
		//resolve xref 'investigation' from investigation.name -> investigation.id
		for(ObservedValue o: observedValueList) 
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
		//resolve xref 'protocolApplication' from protocolApplication.name -> protocolApplication.id
		for(ObservedValue o: observedValueList) 
		{
			if(o.getProtocolApplication_Name() != null) 
				protocolApplicationKeymap.put(o.getProtocolApplication_Name(), null);
		}
		
		if(protocolApplicationKeymap.size() > 0) 
		{
			List<ProtocolApplication> protocolApplicationList = db.query(ProtocolApplication.class).in("name",new ArrayList<Object>(protocolApplicationKeymap.keySet())).find();
			for(ProtocolApplication xref :  protocolApplicationList)
			{
				protocolApplicationKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'feature' from observationElement.name -> observationElement.id
		for(ObservedValue o: observedValueList) 
		{
			if(o.getFeature_Name() != null) 
				featureKeymap.put(o.getFeature_Name(), null);
		}
		
		if(featureKeymap.size() > 0) 
		{
			List<ObservationElement> featureList = db.query(ObservationElement.class).in("name",new ArrayList<Object>(featureKeymap.keySet())).find();
			for(ObservationElement xref :  featureList)
			{
				featureKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'target' from observationElement.name -> observationElement.id
		for(ObservedValue o: observedValueList) 
		{
			if(o.getTarget_Name() != null) 
				targetKeymap.put(o.getTarget_Name(), null);
		}
		
		if(targetKeymap.size() > 0) 
		{
			List<ObservationElement> targetList = db.query(ObservationElement.class).in("name",new ArrayList<Object>(targetKeymap.keySet())).find();
			for(ObservationElement xref :  targetList)
			{
				targetKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'ontologyReference' from ontologyTerm.name -> ontologyTerm.id
		for(ObservedValue o: observedValueList) 
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
		//resolve xref 'relation' from observationElement.name -> observationElement.id
		for(ObservedValue o: observedValueList) 
		{
			if(o.getRelation_Name() != null) 
				relationKeymap.put(o.getRelation_Name(), null);
		}
		
		if(relationKeymap.size() > 0) 
		{
			List<ObservationElement> relationList = db.query(ObservationElement.class).in("name",new ArrayList<Object>(relationKeymap.keySet())).find();
			for(ObservationElement xref :  relationList)
			{
				relationKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(ObservedValue o:  observedValueList)
		{
			while(true){
				//update xref Investigation
				if(o.getInvestigation_Name() != null) 
				{
					String key = o.getInvestigation_Name();
					if(investigationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ObservedValue' objects failed: cannot find Investigation for investigation_name='"+o.getInvestigation_Name()+"'");
					}
					o.setInvestigation_Id(investigationKeymap.get(key));
				}
				//update xref protocolApplication
				if(o.getProtocolApplication_Name() != null) 
				{
					String key = o.getProtocolApplication_Name();
					if(protocolApplicationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ObservedValue' objects failed: cannot find ProtocolApplication for protocolApplication_name='"+o.getProtocolApplication_Name()+"'");
					}
					o.setProtocolApplication_Id(protocolApplicationKeymap.get(key));
				}
				//update xref Feature
				if(o.getFeature_Name() != null) 
				{
					String key = o.getFeature_Name();
					if(featureKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ObservedValue' objects failed: cannot find ObservationElement for feature_name='"+o.getFeature_Name()+"'");
					}
					o.setFeature_Id(featureKeymap.get(key));
				}
				//update xref Target
				if(o.getTarget_Name() != null) 
				{
					String key = o.getTarget_Name();
					if(targetKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ObservedValue' objects failed: cannot find ObservationElement for target_name='"+o.getTarget_Name()+"'");
					}
					o.setTarget_Id(targetKeymap.get(key));
				}
				//update xref ontologyReference
				if(o.getOntologyReference_Name() != null) 
				{
					String key = o.getOntologyReference_Name();
					if(ontologyReferenceKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ObservedValue' objects failed: cannot find OntologyTerm for ontologyReference_name='"+o.getOntologyReference_Name()+"'");
					}
					o.setOntologyReference_Id(ontologyReferenceKeymap.get(key));
				}
				//update xref relation
				if(o.getRelation_Name() != null) 
				{
					String key = o.getRelation_Name();
					if(relationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ObservedValue' objects failed: cannot find ObservationElement for relation_name='"+o.getRelation_Name()+"'");
					}
					o.setRelation_Id(relationKeymap.get(key));
				}
				break;
			}
		}
		
		investigationKeymap.clear();
		protocolApplicationKeymap.clear();
		featureKeymap.clear();
		targetKeymap.clear();
		ontologyReferenceKeymap.clear();
		relationKeymap.clear();
		
		return observedValuesMissingRefs;
	}
}

