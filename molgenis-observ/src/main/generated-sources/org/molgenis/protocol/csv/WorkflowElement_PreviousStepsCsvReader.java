
/* File:        observ/model/WorkflowElement_PreviousSteps.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.protocol.csv;

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

import org.molgenis.protocol.WorkflowElement;
import org.molgenis.protocol.WorkflowElement_PreviousSteps;


/**
 * Reads WorkflowElement_PreviousSteps from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class WorkflowElement_PreviousStepsCsvReader extends CsvToDatabase<WorkflowElement_PreviousSteps>
{
	public static final transient Logger logger = Logger.getLogger(WorkflowElement_PreviousStepsCsvReader.class);
	
	//foreign key map for xref 'previousSteps' (maps workflowElement.name -> workflowElement.id)			
	final Map<String,Integer> previousStepsKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'workflowElement' (maps workflowElement.name -> workflowElement.id)			
	final Map<String,Integer> workflowElementKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports WorkflowElement_PreviousSteps from tab/comma delimited File
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
		final List<WorkflowElement_PreviousSteps> workflowElement_PreviousStepssMissingRefs = new ArrayList<WorkflowElement_PreviousSteps>();
	
		//cache for objects to be imported from file (in batch)
		final List<WorkflowElement_PreviousSteps> workflowElement_PreviousStepsList = new ArrayList<WorkflowElement_PreviousSteps>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			WorkflowElement_PreviousSteps object = new WorkflowElement_PreviousSteps();
			object.set(defaults, false); 
			object.set(tuple, false);				
			workflowElement_PreviousStepsList.add(object);		
			
			//add to db when batch size is reached
			if(workflowElement_PreviousStepsList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				workflowElement_PreviousStepssMissingRefs.addAll(resolveForeignKeys(db, workflowElement_PreviousStepsList));
				
				//update objects in the database using xref_label defined secondary key(s) 'PreviousSteps,WorkflowElement' defined in xref_label
				db.update(workflowElement_PreviousStepsList,dbAction, "PreviousSteps", "WorkflowElement");
				
				//clear for next batch						
				workflowElement_PreviousStepsList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!workflowElement_PreviousStepsList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			workflowElement_PreviousStepssMissingRefs.addAll(resolveForeignKeys(db, workflowElement_PreviousStepsList));
			//update objects in the database using xref_label defined secondary key(s) 'PreviousSteps,WorkflowElement' defined in xref_label
			db.update(workflowElement_PreviousStepsList,dbAction, "PreviousSteps", "WorkflowElement");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<WorkflowElement_PreviousSteps> workflowElement_PreviousStepssStillMissingRefs = resolveForeignKeys(db, workflowElement_PreviousStepssMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(workflowElement_PreviousStepssStillMissingRefs.size() > 0){
			throw new Exception("Import of 'WorkflowElement_PreviousSteps' objects failed: attempting to resolve in-list references, but there are still WorkflowElement_PreviousStepss referring to WorkflowElement_PreviousStepss that are neither in the database nor in the list of to-be imported WorkflowElement_PreviousStepss. (the first one being: "+workflowElement_PreviousStepssStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(workflowElement_PreviousStepssMissingRefs,DatabaseAction.UPDATE, "PreviousSteps", "WorkflowElement");
		
			//output count
			total.set(total.get() + workflowElement_PreviousStepsList.size());
			logger.info("imported "+total.get()+" workflowElement_PreviousSteps from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param workflowElement_PreviousStepsList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<WorkflowElement_PreviousSteps> resolveForeignKeys(Database db, List<WorkflowElement_PreviousSteps> workflowElement_PreviousStepsList) throws Exception
	{
		//keep a list of WorkflowElement_PreviousSteps instances that miss a reference which might be resolvable later
		List<WorkflowElement_PreviousSteps> workflowElement_PreviousStepssMissingRefs = new ArrayList<WorkflowElement_PreviousSteps>();
	
		//resolve xref 'previousSteps' from workflowElement.name -> workflowElement.id
		for(WorkflowElement_PreviousSteps o: workflowElement_PreviousStepsList) 
		{
			if(o.getPreviousSteps_Name() != null) 
				previousStepsKeymap.put(o.getPreviousSteps_Name(), null);
		}
		
		if(previousStepsKeymap.size() > 0) 
		{
			List<WorkflowElement> previousStepsList = db.query(WorkflowElement.class).in("name",new ArrayList<Object>(previousStepsKeymap.keySet())).find();
			for(WorkflowElement xref :  previousStepsList)
			{
				previousStepsKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'workflowElement' from workflowElement.name -> workflowElement.id
		for(WorkflowElement_PreviousSteps o: workflowElement_PreviousStepsList) 
		{
			if(o.getWorkflowElement_Name() != null) 
				workflowElementKeymap.put(o.getWorkflowElement_Name(), null);
		}
		
		if(workflowElementKeymap.size() > 0) 
		{
			List<WorkflowElement> workflowElementList = db.query(WorkflowElement.class).in("name",new ArrayList<Object>(workflowElementKeymap.keySet())).find();
			for(WorkflowElement xref :  workflowElementList)
			{
				workflowElementKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(WorkflowElement_PreviousSteps o:  workflowElement_PreviousStepsList)
		{
			while(true){
				//update xref PreviousSteps
				if(o.getPreviousSteps_Name() != null) 
				{
					String key = o.getPreviousSteps_Name();
					if(previousStepsKeymap.get(key) == null)
					{
						throw new Exception("Import of 'WorkflowElement_PreviousSteps' objects failed: cannot find WorkflowElement for previousSteps_name='"+o.getPreviousSteps_Name()+"'");
					}
					o.setPreviousSteps_Id(previousStepsKeymap.get(key));
				}
				//update xref WorkflowElement
				if(o.getWorkflowElement_Name() != null) 
				{
					String key = o.getWorkflowElement_Name();
					if(workflowElementKeymap.get(key) == null)
					{
						throw new Exception("Import of 'WorkflowElement_PreviousSteps' objects failed: cannot find WorkflowElement for workflowElement_name='"+o.getWorkflowElement_Name()+"'");
					}
					o.setWorkflowElement_Id(workflowElementKeymap.get(key));
				}
				break;
			}
		}
		
		previousStepsKeymap.clear();
		workflowElementKeymap.clear();
		
		return workflowElement_PreviousStepssMissingRefs;
	}
}

