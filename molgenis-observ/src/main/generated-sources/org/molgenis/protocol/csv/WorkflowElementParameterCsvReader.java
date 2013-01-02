
/* File:        observ/model/WorkflowElementParameter.java
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
import org.molgenis.pheno.ObservableFeature;
import org.molgenis.protocol.WorkflowElementParameter;


/**
 * Reads WorkflowElementParameter from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class WorkflowElementParameterCsvReader extends CsvToDatabase<WorkflowElementParameter>
{
	public static final transient Logger logger = Logger.getLogger(WorkflowElementParameterCsvReader.class);
	
	//foreign key map for xref 'workflowElement' (maps workflowElement.name -> workflowElement.id)			
	final Map<String,Integer> workflowElementKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'parameter' (maps observableFeature.name -> observableFeature.id)			
	final Map<String,Integer> parameterKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports WorkflowElementParameter from tab/comma delimited File
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
		final List<WorkflowElementParameter> workflowElementParametersMissingRefs = new ArrayList<WorkflowElementParameter>();
	
		//cache for objects to be imported from file (in batch)
		final List<WorkflowElementParameter> workflowElementParameterList = new ArrayList<WorkflowElementParameter>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			WorkflowElementParameter object = new WorkflowElementParameter();
			object.set(defaults, false); 
			object.set(tuple, false);				
			workflowElementParameterList.add(object);		
			
			//add to db when batch size is reached
			if(workflowElementParameterList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				workflowElementParametersMissingRefs.addAll(resolveForeignKeys(db, workflowElementParameterList));
				
				//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
				db.update(workflowElementParameterList,dbAction, "id");
				
				//clear for next batch						
				workflowElementParameterList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!workflowElementParameterList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			workflowElementParametersMissingRefs.addAll(resolveForeignKeys(db, workflowElementParameterList));
			//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
			db.update(workflowElementParameterList,dbAction, "id");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<WorkflowElementParameter> workflowElementParametersStillMissingRefs = resolveForeignKeys(db, workflowElementParametersMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(workflowElementParametersStillMissingRefs.size() > 0){
			throw new Exception("Import of 'WorkflowElementParameter' objects failed: attempting to resolve in-list references, but there are still WorkflowElementParameters referring to WorkflowElementParameters that are neither in the database nor in the list of to-be imported WorkflowElementParameters. (the first one being: "+workflowElementParametersStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(workflowElementParametersMissingRefs,DatabaseAction.UPDATE, "id");
		
			//output count
			total.set(total.get() + workflowElementParameterList.size());
			logger.info("imported "+total.get()+" workflowElementParameter from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param workflowElementParameterList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<WorkflowElementParameter> resolveForeignKeys(Database db, List<WorkflowElementParameter> workflowElementParameterList) throws Exception
	{
		//keep a list of WorkflowElementParameter instances that miss a reference which might be resolvable later
		List<WorkflowElementParameter> workflowElementParametersMissingRefs = new ArrayList<WorkflowElementParameter>();
	
		//resolve xref 'workflowElement' from workflowElement.name -> workflowElement.id
		for(WorkflowElementParameter o: workflowElementParameterList) 
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
		//resolve xref 'parameter' from observableFeature.name -> observableFeature.id
		for(WorkflowElementParameter o: workflowElementParameterList) 
		{
			if(o.getParameter_Name() != null) 
				parameterKeymap.put(o.getParameter_Name(), null);
		}
		
		if(parameterKeymap.size() > 0) 
		{
			List<ObservableFeature> parameterList = db.query(ObservableFeature.class).in("name",new ArrayList<Object>(parameterKeymap.keySet())).find();
			for(ObservableFeature xref :  parameterList)
			{
				parameterKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(WorkflowElementParameter o:  workflowElementParameterList)
		{
			while(true){
				//update xref WorkflowElement
				if(o.getWorkflowElement_Name() != null) 
				{
					String key = o.getWorkflowElement_Name();
					if(workflowElementKeymap.get(key) == null)
					{
						throw new Exception("Import of 'WorkflowElementParameter' objects failed: cannot find WorkflowElement for workflowElement_name='"+o.getWorkflowElement_Name()+"'");
					}
					o.setWorkflowElement_Id(workflowElementKeymap.get(key));
				}
				//update xref Parameter
				if(o.getParameter_Name() != null) 
				{
					String key = o.getParameter_Name();
					if(parameterKeymap.get(key) == null)
					{
						throw new Exception("Import of 'WorkflowElementParameter' objects failed: cannot find ObservableFeature for parameter_name='"+o.getParameter_Name()+"'");
					}
					o.setParameter_Id(parameterKeymap.get(key));
				}
				break;
			}
		}
		
		workflowElementKeymap.clear();
		parameterKeymap.clear();
		
		return workflowElementParametersMissingRefs;
	}
}

