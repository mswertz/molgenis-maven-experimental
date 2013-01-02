
/* File:        observ/model/Individual.java
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
import org.molgenis.pheno.Individual;


/**
 * Reads Individual from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class IndividualCsvReader extends CsvToDatabase<Individual>
{
	public static final transient Logger logger = Logger.getLogger(IndividualCsvReader.class);
	
	//foreign key map for xref 'investigation' (maps investigation.name -> investigation.id)			
	final Map<String,Integer> investigationKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'ontologyReference' (maps ontologyTerm.name -> ontologyTerm.id)			
	final Map<String,Integer> ontologyReferenceKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'alternateId' (maps alternateId.name -> alternateId.id)			
	final Map<String,Integer> alternateIdKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'mother' (maps individual.name -> individual.id)			
	final Map<String,Integer> motherKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'father' (maps individual.name -> individual.id)			
	final Map<String,Integer> fatherKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Individual from tab/comma delimited File
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
		final List<Individual> individualsMissingRefs = new ArrayList<Individual>();
	
		//cache for objects to be imported from file (in batch)
		final List<Individual> individualList = new ArrayList<Individual>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Individual object = new Individual();
			object.set(defaults, false); 
			object.set(tuple, false);				
			individualList.add(object);		
			
			//add to db when batch size is reached
			if(individualList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				individualsMissingRefs.addAll(resolveForeignKeys(db, individualList));
				
				//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
				db.update(individualList,dbAction, "name");
				
				//clear for next batch						
				individualList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!individualList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			individualsMissingRefs.addAll(resolveForeignKeys(db, individualList));
			//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
			db.update(individualList,dbAction, "name");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<Individual> individualsStillMissingRefs = resolveForeignKeys(db, individualsMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(individualsStillMissingRefs.size() > 0){
			throw new Exception("Import of 'Individual' objects failed: attempting to resolve in-list references, but there are still Individuals referring to Individuals that are neither in the database nor in the list of to-be imported Individuals. (the first one being: "+individualsStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(individualsMissingRefs,DatabaseAction.UPDATE, "name");
		
			//output count
			total.set(total.get() + individualList.size());
			logger.info("imported "+total.get()+" individual from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param individualList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Individual> resolveForeignKeys(Database db, List<Individual> individualList) throws Exception
	{
		//keep a list of Individual instances that miss a reference which might be resolvable later
		List<Individual> individualsMissingRefs = new ArrayList<Individual>();
	
		//resolve xref 'investigation' from investigation.name -> investigation.id
		for(Individual o: individualList) 
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
		for(Individual o: individualList) for(String xref_label: o.getOntologyReference_Name())
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
		for(Individual o: individualList) for(String xref_label: o.getAlternateId_Name())
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
		//resolve xref 'mother' from individual.name -> individual.id
		for(Individual o: individualList) 
		{
			if(o.getMother_Name() != null) 
				motherKeymap.put(o.getMother_Name(), null);
		}
		
		if(motherKeymap.size() > 0) 
		{
			List<Individual> motherList = db.query(Individual.class).in("name",new ArrayList<Object>(motherKeymap.keySet())).find();
			for(Individual xref :  motherList)
			{
				motherKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'father' from individual.name -> individual.id
		for(Individual o: individualList) 
		{
			if(o.getFather_Name() != null) 
				fatherKeymap.put(o.getFather_Name(), null);
		}
		
		if(fatherKeymap.size() > 0) 
		{
			List<Individual> fatherList = db.query(Individual.class).in("name",new ArrayList<Object>(fatherKeymap.keySet())).find();
			for(Individual xref :  fatherList)
			{
				fatherKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Individual o:  individualList)
		{
			while(true){
				//update xref Investigation
				if(o.getInvestigation_Name() != null) 
				{
					String key = o.getInvestigation_Name();
					if(investigationKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Individual' objects failed: cannot find Investigation for investigation_name='"+o.getInvestigation_Name()+"'");
					}
					o.setInvestigation_Id(investigationKeymap.get(key));
				}
				//update mref ontologyReference
				if(o.getOntologyReference_Name() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextIndividual = false;

					int listSize = 0;
					if(o.getOntologyReference_Name() != null) listSize = Math.max(o.getOntologyReference_Name().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getOntologyReference_Name().get(i);
						if(ontologyReferenceKeymap.get(key) == null){
							logger.error("Import of 'Individual' objects failed: "+o);
							throw new Exception("Import of 'Individual' objects failed: cannot find ontologyReference_name='"+(o.getOntologyReference_Name() != null && i < o.getOntologyReference_Name().size() ? o.getOntologyReference_Name().get(i) : "null")+"'");
						}
						mrefs.add(ontologyReferenceKeymap.get(key));
					}
					if(breakToNextIndividual){
						break;
					}
					o.setOntologyReference_Id(mrefs);
				}
				//update mref AlternateId
				if(o.getAlternateId_Name() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextIndividual = false;

					int listSize = 0;
					if(o.getAlternateId_Name() != null) listSize = Math.max(o.getAlternateId_Name().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getAlternateId_Name().get(i);
						if(alternateIdKeymap.get(key) == null){
							logger.error("Import of 'Individual' objects failed: "+o);
							throw new Exception("Import of 'Individual' objects failed: cannot find alternateId_name='"+(o.getAlternateId_Name() != null && i < o.getAlternateId_Name().size() ? o.getAlternateId_Name().get(i) : "null")+"'");
						}
						mrefs.add(alternateIdKeymap.get(key));
					}
					if(breakToNextIndividual){
						break;
					}
					o.setAlternateId_Id(mrefs);
				}
				//update xref Mother
				if(o.getMother_Name() != null) 
				{
					String key = o.getMother_Name();
					if(motherKeymap.get(key) == null)
					{
						individualsMissingRefs.add(o);
						break;
					}
					o.setMother_Id(motherKeymap.get(key));
				}
				//update xref Father
				if(o.getFather_Name() != null) 
				{
					String key = o.getFather_Name();
					if(fatherKeymap.get(key) == null)
					{
						individualsMissingRefs.add(o);
						break;
					}
					o.setFather_Id(fatherKeymap.get(key));
				}
				break;
			}
		}
		
		investigationKeymap.clear();
		ontologyReferenceKeymap.clear();
		alternateIdKeymap.clear();
		motherKeymap.clear();
		fatherKeymap.clear();
		
		return individualsMissingRefs;
	}
}

