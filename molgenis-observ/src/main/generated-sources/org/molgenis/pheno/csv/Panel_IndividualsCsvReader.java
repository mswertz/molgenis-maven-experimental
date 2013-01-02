
/* File:        observ/model/Panel_Individuals.java
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

import org.molgenis.pheno.Individual;
import org.molgenis.pheno.Panel;
import org.molgenis.pheno.Panel_Individuals;


/**
 * Reads Panel_Individuals from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class Panel_IndividualsCsvReader extends CsvToDatabase<Panel_Individuals>
{
	public static final transient Logger logger = Logger.getLogger(Panel_IndividualsCsvReader.class);
	
	//foreign key map for xref 'individuals' (maps individual.name -> individual.id)			
	final Map<String,Integer> individualsKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'panel' (maps panel.name -> panel.id)			
	final Map<String,Integer> panelKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Panel_Individuals from tab/comma delimited File
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
		final List<Panel_Individuals> panel_IndividualssMissingRefs = new ArrayList<Panel_Individuals>();
	
		//cache for objects to be imported from file (in batch)
		final List<Panel_Individuals> panel_IndividualsList = new ArrayList<Panel_Individuals>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Panel_Individuals object = new Panel_Individuals();
			object.set(defaults, false); 
			object.set(tuple, false);				
			panel_IndividualsList.add(object);		
			
			//add to db when batch size is reached
			if(panel_IndividualsList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				panel_IndividualssMissingRefs.addAll(resolveForeignKeys(db, panel_IndividualsList));
				
				//update objects in the database using xref_label defined secondary key(s) 'Individuals,Panel' defined in xref_label
				db.update(panel_IndividualsList,dbAction, "Individuals", "Panel");
				
				//clear for next batch						
				panel_IndividualsList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!panel_IndividualsList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			panel_IndividualssMissingRefs.addAll(resolveForeignKeys(db, panel_IndividualsList));
			//update objects in the database using xref_label defined secondary key(s) 'Individuals,Panel' defined in xref_label
			db.update(panel_IndividualsList,dbAction, "Individuals", "Panel");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<Panel_Individuals> panel_IndividualssStillMissingRefs = resolveForeignKeys(db, panel_IndividualssMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(panel_IndividualssStillMissingRefs.size() > 0){
			throw new Exception("Import of 'Panel_Individuals' objects failed: attempting to resolve in-list references, but there are still Panel_Individualss referring to Panel_Individualss that are neither in the database nor in the list of to-be imported Panel_Individualss. (the first one being: "+panel_IndividualssStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(panel_IndividualssMissingRefs,DatabaseAction.UPDATE, "Individuals", "Panel");
		
			//output count
			total.set(total.get() + panel_IndividualsList.size());
			logger.info("imported "+total.get()+" panel_Individuals from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param panel_IndividualsList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Panel_Individuals> resolveForeignKeys(Database db, List<Panel_Individuals> panel_IndividualsList) throws Exception
	{
		//keep a list of Panel_Individuals instances that miss a reference which might be resolvable later
		List<Panel_Individuals> panel_IndividualssMissingRefs = new ArrayList<Panel_Individuals>();
	
		//resolve xref 'individuals' from individual.name -> individual.id
		for(Panel_Individuals o: panel_IndividualsList) 
		{
			if(o.getIndividuals_Name() != null) 
				individualsKeymap.put(o.getIndividuals_Name(), null);
		}
		
		if(individualsKeymap.size() > 0) 
		{
			List<Individual> individualsList = db.query(Individual.class).in("name",new ArrayList<Object>(individualsKeymap.keySet())).find();
			for(Individual xref :  individualsList)
			{
				individualsKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'panel' from panel.name -> panel.id
		for(Panel_Individuals o: panel_IndividualsList) 
		{
			if(o.getPanel_Name() != null) 
				panelKeymap.put(o.getPanel_Name(), null);
		}
		
		if(panelKeymap.size() > 0) 
		{
			List<Panel> panelList = db.query(Panel.class).in("name",new ArrayList<Object>(panelKeymap.keySet())).find();
			for(Panel xref :  panelList)
			{
				panelKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Panel_Individuals o:  panel_IndividualsList)
		{
			while(true){
				//update xref Individuals
				if(o.getIndividuals_Name() != null) 
				{
					String key = o.getIndividuals_Name();
					if(individualsKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Panel_Individuals' objects failed: cannot find Individual for individuals_name='"+o.getIndividuals_Name()+"'");
					}
					o.setIndividuals_Id(individualsKeymap.get(key));
				}
				//update xref Panel
				if(o.getPanel_Name() != null) 
				{
					String key = o.getPanel_Name();
					if(panelKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Panel_Individuals' objects failed: cannot find Panel for panel_name='"+o.getPanel_Name()+"'");
					}
					o.setPanel_Id(panelKeymap.get(key));
				}
				break;
			}
		}
		
		individualsKeymap.clear();
		panelKeymap.clear();
		
		return panel_IndividualssMissingRefs;
	}
}

