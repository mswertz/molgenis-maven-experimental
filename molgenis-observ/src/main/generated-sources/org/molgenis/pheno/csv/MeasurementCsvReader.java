
/* File:        observ/model/Measurement.java
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
import org.molgenis.pheno.Category;
import org.molgenis.core.MolgenisEntity;
import org.molgenis.pheno.Measurement;


/**
 * Reads Measurement from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class MeasurementCsvReader extends CsvToDatabase<Measurement>
{
	public static final transient Logger logger = Logger.getLogger(MeasurementCsvReader.class);
	
	//foreign key map for xref 'investigation' (maps investigation.name -> investigation.id)			
	final Map<String,Integer> investigationKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'ontologyReference' (maps ontologyTerm.name -> ontologyTerm.id)			
	final Map<String,Integer> ontologyReferenceKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'alternateId' (maps alternateId.name -> alternateId.id)			
	final Map<String,Integer> alternateIdKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'unit' (maps ontologyTerm.name -> ontologyTerm.id)			
	final Map<String,Integer> unitKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'categories' (maps category.name -> category.id)			
	final Map<String,Integer> categoriesKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'targettypeAllowedForRelation' (maps molgenisEntity.className -> molgenisEntity.id)			
	final Map<String,Integer> targettypeAllowedForRelationKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Measurement from tab/comma delimited File
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
		final List<Measurement> measurementsMissingRefs = new ArrayList<Measurement>();
	
		//cache for objects to be imported from file (in batch)
		final List<Measurement> measurementList = new ArrayList<Measurement>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Measurement object = new Measurement();
			object.set(defaults, false); 
			object.set(tuple, false);				
			measurementList.add(object);		
			
			//add to db when batch size is reached
			if(measurementList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				measurementsMissingRefs.addAll(resolveForeignKeys(db, measurementList));
				
				//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
				db.update(measurementList,dbAction, "name");
				
				//clear for next batch						
				measurementList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!measurementList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			measurementsMissingRefs.addAll(resolveForeignKeys(db, measurementList));
			//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
			db.update(measurementList,dbAction, "name");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<Measurement> measurementsStillMissingRefs = resolveForeignKeys(db, measurementsMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(measurementsStillMissingRefs.size() > 0){
			throw new Exception("Import of 'Measurement' objects failed: attempting to resolve in-list references, but there are still Measurements referring to Measurements that are neither in the database nor in the list of to-be imported Measurements. (the first one being: "+measurementsStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(measurementsMissingRefs,DatabaseAction.UPDATE, "name");
		
			//output count
			total.set(total.get() + measurementList.size());
			logger.info("imported "+total.get()+" measurement from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param measurementList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Measurement> resolveForeignKeys(Database db, List<Measurement> measurementList) throws Exception
	{
		//keep a list of Measurement instances that miss a reference which might be resolvable later
		List<Measurement> measurementsMissingRefs = new ArrayList<Measurement>();
	
		//resolve xref 'investigation' from investigation.name -> investigation.id
		for(Measurement o: measurementList) 
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
		for(Measurement o: measurementList) for(String xref_label: o.getOntologyReference_Name())
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
		for(Measurement o: measurementList) for(String xref_label: o.getAlternateId_Name())
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
		//resolve xref 'unit' from ontologyTerm.name -> ontologyTerm.id
		for(Measurement o: measurementList) 
		{
			if(o.getUnit_Name() != null) 
				unitKeymap.put(o.getUnit_Name(), null);
		}
		
		if(unitKeymap.size() > 0) 
		{
			List<OntologyTerm> unitList = db.query(OntologyTerm.class).in("name",new ArrayList<Object>(unitKeymap.keySet())).find();
			for(OntologyTerm xref :  unitList)
			{
				unitKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'categories' from category.name -> category.id
		for(Measurement o: measurementList) for(String xref_label: o.getCategories_Name())
		{
			if(xref_label != null) 
				categoriesKeymap.put(xref_label, null);
		}
		
		if(categoriesKeymap.size() > 0) 
		{
			List<Category> categoriesList = db.query(Category.class).in("name",new ArrayList<Object>(categoriesKeymap.keySet())).find();
			for(Category xref :  categoriesList)
			{
				categoriesKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'targettypeAllowedForRelation' from molgenisEntity.className -> molgenisEntity.id
		for(Measurement o: measurementList) 
		{
			if(o.getTargettypeAllowedForRelation_ClassName() != null) 
				targettypeAllowedForRelationKeymap.put(o.getTargettypeAllowedForRelation_ClassName(), null);
		}
		
		if(targettypeAllowedForRelationKeymap.size() > 0) 
		{
			List<MolgenisEntity> targettypeAllowedForRelationList = db.query(MolgenisEntity.class).in("className",new ArrayList<Object>(targettypeAllowedForRelationKeymap.keySet())).find();
			for(MolgenisEntity xref :  targettypeAllowedForRelationList)
			{
				targettypeAllowedForRelationKeymap.put(xref.getClassName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Measurement o:  measurementList)
		{
			while(true){
				//update xref Investigation
				if(o.getInvestigation_Name() != null) 
				{
					String key = o.getInvestigation_Name();
					if(investigationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Measurement' objects failed: cannot find Investigation for investigation_name='"+o.getInvestigation_Name()+"'");
					}
					o.setInvestigation_Id(investigationKeymap.get(key));
				}
				//update mref ontologyReference
				if(o.getOntologyReference_Name() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextMeasurement = false;

					int listSize = 0;
					if(o.getOntologyReference_Name() != null) listSize = Math.max(o.getOntologyReference_Name().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getOntologyReference_Name().get(i);
						if(ontologyReferenceKeymap.get(key) == null){
							logger.error("Import of 'Measurement' objects failed: "+o);
							throw new Exception("Import of 'Measurement' objects failed: cannot find ontologyReference_name='"+(o.getOntologyReference_Name() != null && i < o.getOntologyReference_Name().size() ? o.getOntologyReference_Name().get(i) : "null")+"'");
						}
						mrefs.add(ontologyReferenceKeymap.get(key));
					}
					if(breakToNextMeasurement){
						break;
					}
					o.setOntologyReference_Id(mrefs);
				}
				//update mref AlternateId
				if(o.getAlternateId_Name() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextMeasurement = false;

					int listSize = 0;
					if(o.getAlternateId_Name() != null) listSize = Math.max(o.getAlternateId_Name().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getAlternateId_Name().get(i);
						if(alternateIdKeymap.get(key) == null){
							logger.error("Import of 'Measurement' objects failed: "+o);
							throw new Exception("Import of 'Measurement' objects failed: cannot find alternateId_name='"+(o.getAlternateId_Name() != null && i < o.getAlternateId_Name().size() ? o.getAlternateId_Name().get(i) : "null")+"'");
						}
						mrefs.add(alternateIdKeymap.get(key));
					}
					if(breakToNextMeasurement){
						break;
					}
					o.setAlternateId_Id(mrefs);
				}
				//update xref unit
				if(o.getUnit_Name() != null) 
				{
					String key = o.getUnit_Name();
					if(unitKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Measurement' objects failed: cannot find OntologyTerm for unit_name='"+o.getUnit_Name()+"'");
					}
					o.setUnit_Id(unitKeymap.get(key));
				}
				//update mref categories
				if(o.getCategories_Name() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextMeasurement = false;

					int listSize = 0;
					if(o.getCategories_Name() != null) listSize = Math.max(o.getCategories_Name().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getCategories_Name().get(i);
						if(categoriesKeymap.get(key) == null){
							logger.error("Import of 'Measurement' objects failed: "+o);
							throw new Exception("Import of 'Measurement' objects failed: cannot find categories_name='"+(o.getCategories_Name() != null && i < o.getCategories_Name().size() ? o.getCategories_Name().get(i) : "null")+"'");
						}
						mrefs.add(categoriesKeymap.get(key));
					}
					if(breakToNextMeasurement){
						break;
					}
					o.setCategories_Id(mrefs);
				}
				//update xref targettypeAllowedForRelation
				if(o.getTargettypeAllowedForRelation_ClassName() != null) 
				{
					String key = o.getTargettypeAllowedForRelation_ClassName();
					if(targettypeAllowedForRelationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Measurement' objects failed: cannot find MolgenisEntity for targettypeAllowedForRelation_className='"+o.getTargettypeAllowedForRelation_ClassName()+"'");
					}
					o.setTargettypeAllowedForRelation_Id(targettypeAllowedForRelationKeymap.get(key));
				}
				break;
			}
		}
		
		investigationKeymap.clear();
		ontologyReferenceKeymap.clear();
		alternateIdKeymap.clear();
		unitKeymap.clear();
		categoriesKeymap.clear();
		targettypeAllowedForRelationKeymap.clear();
		
		return measurementsMissingRefs;
	}
}

