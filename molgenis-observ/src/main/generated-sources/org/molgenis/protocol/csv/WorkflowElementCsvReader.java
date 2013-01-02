
/* File:        observ/model/WorkflowElement.java
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

import org.molgenis.protocol.Workflow;
import org.molgenis.protocol.Protocol;
import org.molgenis.protocol.WorkflowElement;


/**
 * Reads WorkflowElement from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class WorkflowElementCsvReader extends CsvToDatabase<WorkflowElement>
{
	public static final transient Logger logger = Logger.getLogger(WorkflowElementCsvReader.class);
	
	//foreign key map for xref 'workflow' (maps workflow.name -> workflow.id)			
	final Map<String,Integer> workflowKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'protocol' (maps protocol.name -> protocol.id)			
	final Map<String,Integer> protocolKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'previousSteps' (maps workflowElement.name -> workflowElement.id)			
	final Map<String,Integer> previousStepsKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports WorkflowElement from tab/comma delimited File
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
		final List<WorkflowElement> workflowElementsMissingRefs = new ArrayList<WorkflowElement>();
	
		//cache for objects to be imported from file (in batch)
		final List<WorkflowElement> workflowElementList = new ArrayList<WorkflowElement>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			WorkflowElement object = new WorkflowElement();
			object.set(defaults, false); 
			object.set(tuple, false);				
			workflowElementList.add(object);		
			
			//add to db when batch size is reached
			if(workflowElementList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				workflowElementsMissingRefs.addAll(resolveForeignKeys(db, workflowElementList));
				
				//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
				db.update(workflowElementList,dbAction, "name");
				
				//clear for next batch						
				workflowElementList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!workflowElementList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			workflowElementsMissingRefs.addAll(resolveForeignKeys(db, workflowElementList));
			//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
			db.update(workflowElementList,dbAction, "name");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<WorkflowElement> workflowElementsStillMissingRefs = resolveForeignKeys(db, workflowElementsMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(workflowElementsStillMissingRefs.size() > 0){
			throw new Exception("Import of 'WorkflowElement' objects failed: attempting to resolve in-list references, but there are still WorkflowElements referring to WorkflowElements that are neither in the database nor in the list of to-be imported WorkflowElements. (the first one being: "+workflowElementsStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(workflowElementsMissingRefs,DatabaseAction.UPDATE, "name");
		
			//output count
			total.set(total.get() + workflowElementList.size());
			logger.info("imported "+total.get()+" workflowElement from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param workflowElementList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<WorkflowElement> resolveForeignKeys(Database db, List<WorkflowElement> workflowElementList) throws Exception
	{
		//keep a list of WorkflowElement instances that miss a reference which might be resolvable later
		List<WorkflowElement> workflowElementsMissingRefs = new ArrayList<WorkflowElement>();
	
		//resolve xref 'workflow' from workflow.name -> workflow.id
		for(WorkflowElement o: workflowElementList) 
		{
			if(o.getWorkflow_Name() != null) 
				workflowKeymap.put(o.getWorkflow_Name(), null);
		}
		
		if(workflowKeymap.size() > 0) 
		{
			List<Workflow> workflowList = db.query(Workflow.class).in("name",new ArrayList<Object>(workflowKeymap.keySet())).find();
			for(Workflow xref :  workflowList)
			{
				workflowKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'protocol' from protocol.name -> protocol.id
		for(WorkflowElement o: workflowElementList) 
		{
			if(o.getProtocol_Name() != null) 
				protocolKeymap.put(o.getProtocol_Name(), null);
		}
		
		if(protocolKeymap.size() > 0) 
		{
			List<Protocol> protocolList = db.query(Protocol.class).in("name",new ArrayList<Object>(protocolKeymap.keySet())).find();
			for(Protocol xref :  protocolList)
			{
				protocolKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'previousSteps' from workflowElement.name -> workflowElement.id
		for(WorkflowElement o: workflowElementList) for(String xref_label: o.getPreviousSteps_Name())
		{
			if(xref_label != null) 
				previousStepsKeymap.put(xref_label, null);
		}
		
		if(previousStepsKeymap.size() > 0) 
		{
			List<WorkflowElement> previousStepsList = db.query(WorkflowElement.class).in("name",new ArrayList<Object>(previousStepsKeymap.keySet())).find();
			for(WorkflowElement xref :  previousStepsList)
			{
				previousStepsKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(WorkflowElement o:  workflowElementList)
		{
			while(true){
				//update xref Workflow
				if(o.getWorkflow_Name() != null) 
				{
					String key = o.getWorkflow_Name();
					if(workflowKeymap.get(key) == null)
					{
						throw new Exception("Import of 'WorkflowElement' objects failed: cannot find Workflow for workflow_name='"+o.getWorkflow_Name()+"'");
					}
					o.setWorkflow_Id(workflowKeymap.get(key));
				}
				//update xref protocol
				if(o.getProtocol_Name() != null) 
				{
					String key = o.getProtocol_Name();
					if(protocolKeymap.get(key) == null)
					{
						throw new Exception("Import of 'WorkflowElement' objects failed: cannot find Protocol for protocol_name='"+o.getProtocol_Name()+"'");
					}
					o.setProtocol_Id(protocolKeymap.get(key));
				}
				//update mref PreviousSteps
				if(o.getPreviousSteps_Name() != null) 
				{
					List<Integer> mrefs = new ArrayList<Integer>();
					boolean breakToNextWorkflowElement = false;

					int listSize = 0;
					if(o.getPreviousSteps_Name() != null) listSize = Math.max(o.getPreviousSteps_Name().size(), listSize);
					for(int i = 0; i < listSize; i++)
					{
						String key = o.getPreviousSteps_Name().get(i);
						if(previousStepsKeymap.get(key) == null){
							workflowElementsMissingRefs.add(o);
							breakToNextWorkflowElement = true;
							break;
						}
						mrefs.add(previousStepsKeymap.get(key));
					}
					if(breakToNextWorkflowElement){
						break;
					}
					o.setPreviousSteps_Id(mrefs);
				}
				break;
			}
		}
		
		workflowKeymap.clear();
		protocolKeymap.clear();
		previousStepsKeymap.clear();
		
		return workflowElementsMissingRefs;
	}
}

