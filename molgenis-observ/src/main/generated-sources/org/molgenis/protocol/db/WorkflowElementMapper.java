/* File:        observ/model/WorkflowElement.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Template:	MultiqueryMapperGen.java.ftl
 * generator:   org.molgenis.generators.db.MultiqueryMapperGen 4.0.0-testing
 *
 * Using "subclass per table" strategy
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.protocol.db;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.QueryRule;
import org.molgenis.framework.db.QueryRule.Operator;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.jdbc.AbstractJDBCMapper;
import org.molgenis.MolgenisFieldTypes;
import org.molgenis.fieldtypes.*;


import org.molgenis.framework.db.jdbc.JDBCDatabase;
import org.molgenis.framework.db.QueryRule;
import org.molgenis.util.ValueLabel;
import org.molgenis.protocol.WorkflowElement;

import org.molgenis.protocol.Workflow;
import org.molgenis.protocol.Protocol;
import org.molgenis.protocol.WorkflowElement;
import org.molgenis.protocol.WorkflowElement_PreviousSteps;

public class WorkflowElementMapper extends AbstractJDBCMapper<WorkflowElement>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends WorkflowElement> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO WorkflowElement (name,Workflow,protocol) VALUES ");
		{
		
			boolean first = true;
			for(WorkflowElement e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//name
				if(e.getName() != null){
								
					sql.append("'"+this.escapeSql(e.getName().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//workflow
				if(e.getWorkflow_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getWorkflow_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//protocol
				if(e.getProtocol_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getProtocol_Id().toString())+"'"
				);
				}
				else{
					sql.append("null");
				}
				sql.append(")");
			}
		}		
		
		//execute sql
		Statement stmt = null; 		
		try
		{			
			stmt = conn.createStatement();
			//logger.debug("created statement: "+sql.toString());
			int updatedRows = stmt.executeUpdate(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			getGeneratedKeys(entities, stmt, 0);
			return updatedRows;			
		} catch (SQLException sqlEx) {
                    throw new DatabaseException(sqlEx);
                }
		finally
		{
			JDBCDatabase.closeStatement(stmt);
		}
	}

	@Override
	public int executeUpdate(List<? extends WorkflowElement> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO WorkflowElement (id,name,Workflow,protocol) VALUES ");		
		boolean first = true;
		for(WorkflowElement e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//id


			if(e.getId() != null){
                sql.append("'"+this.escapeSql(e.getId()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//name


			if(e.getName() != null){
                sql.append("'"+this.escapeSql(e.getName()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//workflow


			if(e.getWorkflow_Id() != null){
                sql.append("'"+this.escapeSql(e.getWorkflow_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//protocol


			if(e.getProtocol_Id() != null){
                sql.append("'"+this.escapeSql(e.getProtocol_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE Workflow=VALUES(Workflow),protocol=VALUES(protocol),name=VALUES(name),id=LAST_INSERT_ID(id)");

		//execute sql
		Statement stmt = null;	
		try
		{
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql.toString())/2;	
		}
		catch(SQLException sqlEx){
                    logger.debug("Query that caused exception:" + sql.toString());                    
                    throw new DatabaseException(sqlEx);
		}
		finally
		{
			JDBCDatabase.closeStatement(stmt);
		}		
	}

	@Override
	public int executeRemove(List<? extends WorkflowElement> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM WorkflowElement WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(WorkflowElement e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");			
				sql.append("'"+this.escapeSql(e.getId().toString())+"'");
			}				
			sql.append(") ");
		}
	
		//execute sql
		Statement stmt = null;
		try
		{	
			stmt = conn.createStatement();
			rowsAffected = stmt.executeUpdate(sql.toString());	
		} 
		catch (SQLException sqlEx) 
		{
			throw new DatabaseException(sqlEx);
		}
		finally
		{
			JDBCDatabase.closeStatement(stmt);
		}		
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public WorkflowElementMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT WorkflowElement.id"
			+", WorkflowElement.name"
			+", WorkflowElement.Workflow"
			+", WorkflowElement.protocol"
			//parent is SimpleTree(name='Workflow')
			+", xref_Workflow.name AS Workflow_Name"
			//parent is SimpleTree(name='protocol')
			+", xref_protocol.name AS protocol_Name"
			+" FROM WorkflowElement "

			
			//label for Workflow=name
//path==Workflow. type==xref.
//path==Workflow_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Workflow AS xref_Workflow " 
			+" ON xref_Workflow.id = WorkflowElement.Workflow"
			
			//label for protocol=name
//path==protocol. type==xref.
//path==protocol_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Protocol AS xref_protocol " 
			+" ON xref_protocol.id = WorkflowElement.protocol"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM WorkflowElement "
			
			//label for Workflow=name
//Workflow
//Workflow_Name
		   	+" LEFT JOIN Workflow AS xref_Workflow " 
			+" ON xref_Workflow.id = WorkflowElement.Workflow"
			
			//label for protocol=name
//protocol
//protocol_Name
		   	+" LEFT JOIN Protocol AS xref_protocol " 
			+" ON xref_protocol.id = WorkflowElement.protocol"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "WorkflowElement.id";
		if("WorkflowElement_id".equalsIgnoreCase(fieldName)) return "WorkflowElement.id";
		if("name".equalsIgnoreCase(fieldName)) return "WorkflowElement.name";
		if("WorkflowElement_name".equalsIgnoreCase(fieldName)) return "WorkflowElement.name";
		if("Workflow".equalsIgnoreCase(fieldName)) return "WorkflowElement.Workflow";
		if("WorkflowElement_Workflow".equalsIgnoreCase(fieldName)) return "WorkflowElement.Workflow";
		if("protocol".equalsIgnoreCase(fieldName)) return "WorkflowElement.protocol";
		if("WorkflowElement_protocol".equalsIgnoreCase(fieldName)) return "WorkflowElement.protocol";
		if("Workflow_id".equalsIgnoreCase(fieldName)) return "WorkflowElement.Workflow";
		if("WorkflowElement_Workflow_id".equalsIgnoreCase(fieldName)) return "WorkflowElement.Workflow";
		if("Workflow_Name".equalsIgnoreCase(fieldName)) return "xref_Workflow.name";	
		if("WorkflowElement_Workflow_Name".equalsIgnoreCase(fieldName)) return "xref_Workflow.name";
		if("protocol_id".equalsIgnoreCase(fieldName)) return "WorkflowElement.protocol";
		if("WorkflowElement_protocol_id".equalsIgnoreCase(fieldName)) return "WorkflowElement.protocol";
		if("protocol_Name".equalsIgnoreCase(fieldName)) return "xref_protocol.name";	
		if("WorkflowElement_protocol_Name".equalsIgnoreCase(fieldName)) return "xref_protocol.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.protocol.WorkflowElement> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.protocol.WorkflowElement>(size); 
	}			

	public org.molgenis.protocol.WorkflowElement create()
	{
		return new org.molgenis.protocol.WorkflowElement();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.protocol.WorkflowElement> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'workflow' to workflow.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> workflowRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'protocol' to protocol.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> protocolRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'previousSteps' to workflowElement.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> previousStepsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.protocol.WorkflowElement object: entities)
		{
			//create xref/mref rule filtering Workflow on the label name
			if(object.getWorkflow_Id() == null && object.getWorkflow_Name() != null)
			{
				Object label = object.getWorkflow_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !workflowRules.containsKey(label))
					{
						workflowRules.put(""+label, xrefFilter);
						workflowRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Protocol on the label name
			if(object.getProtocol_Id() == null && object.getProtocol_Name() != null)
			{
				Object label = object.getProtocol_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !protocolRules.containsKey(label))
					{
						protocolRules.put(""+label, xrefFilter);
						protocolRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering WorkflowElement on the label name
			if(object.getPreviousSteps_Id().size() == 0 && object.getPreviousSteps_Name().size() > 0)
			{
				for(String label: object.getPreviousSteps_Name())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !previousStepsRules.containsKey(label))
					{
						previousStepsRules.put(""+label, xrefFilter);
						previousStepsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'workflow' to workflow.id using name)
		final java.util.Map<String,Integer> workflow_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(workflowRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.protocol.Workflow> workflowList = null;
			try
			{
				workflowList = getDatabase().find(org.molgenis.protocol.Workflow.class, workflowRules.values().toArray(new org.molgenis.framework.db.QueryRule[workflowRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.protocol.Workflow xref :  workflowList)
			{
				String key = "";
				key += 	xref.getName();
				
				workflow_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'protocol' to protocol.id using name)
		final java.util.Map<String,Integer> protocol_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(protocolRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.protocol.Protocol> protocolList = null;
			try
			{
				protocolList = getDatabase().find(org.molgenis.protocol.Protocol.class, protocolRules.values().toArray(new org.molgenis.framework.db.QueryRule[protocolRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.protocol.Protocol xref :  protocolList)
			{
				String key = "";
				key += 	xref.getName();
				
				protocol_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'previousSteps' to workflowElement.id using name)
		final java.util.Map<String,Integer> previousSteps_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(previousStepsRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.protocol.WorkflowElement> previousStepsList = null;
			try
			{
				previousStepsList = getDatabase().find(org.molgenis.protocol.WorkflowElement.class, previousStepsRules.values().toArray(new org.molgenis.framework.db.QueryRule[previousStepsRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.protocol.WorkflowElement xref :  previousStepsList)
			{
				String key = "";
				key += 	xref.getName();
				
				previousSteps_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.protocol.WorkflowElement object = entities.get(i);		
			//update object using label fields name
			if(object.getWorkflow_Id() == null )
			{
					String key = "";
					if(object.getWorkflow_Name() != null)
						key += 	object.getWorkflow_Name();
					
					if(!"".equals(key) && workflow_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Workflow_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setWorkflow_Id(workflow_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getProtocol_Id() == null )
			{
					String key = "";
					if(object.getProtocol_Name() != null)
						key += 	object.getProtocol_Name();
					
					if(!"".equals(key) && protocol_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("protocol_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setProtocol_Id(protocol_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getPreviousSteps_Id() == null || object.getPreviousSteps_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getPreviousSteps_Name().size(); j++)
				{
					String key = "";
					if(object.getPreviousSteps_Name().get(j) != null)
						key += 	object.getPreviousSteps_Name().get(j);
					
					if(!"".equals(key) && previousSteps_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("PreviousSteps_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(previousSteps_Labels_to_IdMap.get(key));
					}
				}
				object.setPreviousSteps_Id(idList);
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "workflowElement.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("name".equalsIgnoreCase(fieldName) || "workflowElement.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("workflow".equalsIgnoreCase(fieldName) || "workflowElement.workflow".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("protocol".equalsIgnoreCase(fieldName) || "workflowElement.protocol".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, WorkflowElement entity)
	{
		entity.setId(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		if("PreviousSteps".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// WorkflowElement_PreviousSteps
			List<WorkflowElement_PreviousSteps> mref_mapping_entities = db.find(WorkflowElement_PreviousSteps.class, new QueryRule(
					"PreviousSteps", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (WorkflowElement_PreviousSteps mref : mref_mapping_entities) mref_ids.add(mref.getWorkflowElement_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("PreviousSteps_name".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// WorkflowElement_PreviousSteps
			List<WorkflowElement_PreviousSteps> mref_mapping_entities = db.find(WorkflowElement_PreviousSteps.class, new QueryRule(
					"PreviousSteps_name", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (WorkflowElement_PreviousSteps mref : mref_mapping_entities) mref_ids.add(mref.getWorkflowElement_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}
		}
		else
		{
			return rule;
		}
	}

//Generated by MapperFileAttachments.java.ftl
	public void prepareFileAttachements(java.util.List<org.molgenis.protocol.WorkflowElement> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.protocol.WorkflowElement> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<WorkflowElement> entities ) throws DatabaseException			
	{
		try
		{
			//list the workflowElement ids to query
			List<Integer> workflowElementIds = new ArrayList<Integer>();
			for(WorkflowElement entity: entities)
			{
				workflowElementIds.add(entity.getId());
			}
			
			//map the PreviousSteps mrefs
			List<WorkflowElement_PreviousSteps> previousSteps_mrefs = this.getDatabase().query(WorkflowElement_PreviousSteps.class).in("WorkflowElement", workflowElementIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> previousSteps_previousSteps_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> previousSteps_name_map = new LinkedHashMap<Integer,List<String>>();
			
			for(WorkflowElement_PreviousSteps ref: previousSteps_mrefs)
			{
				if(previousSteps_previousSteps_map.get(ref.getWorkflowElement_Id()) == null) previousSteps_previousSteps_map.put(ref.getWorkflowElement_Id(),new ArrayList<Integer>()); 
				previousSteps_previousSteps_map.get(ref.getWorkflowElement_Id()).add(ref.getPreviousSteps_Id());
				if(previousSteps_name_map.get(ref.getWorkflowElement_Id()) == null)	previousSteps_name_map.put(ref.getWorkflowElement_Id(),new ArrayList<String>());
				previousSteps_name_map.get(ref.getWorkflowElement_Id()).add(ref.getPreviousSteps_Name());
			}
			
			//load the mapped data into the entities
			for(WorkflowElement entity: entities)
			{
				Integer id = entity.getId();
				if(previousSteps_previousSteps_map.get(id) != null)
				{
					entity.setPreviousSteps_Id(previousSteps_previousSteps_map.get(id));
				}
				if(previousSteps_name_map.get(id) != null)
				{
					entity.setPreviousSteps_Name(previousSteps_name_map.get(id));
				}
			}
		} 
		catch(Exception e)
		{	
			throw new DatabaseException(e);
		}
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<WorkflowElement> entities ) throws DatabaseException, IOException, ParseException	
	{
		//create an List of WorkflowElement ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (WorkflowElement entity : entities) 
		{
			entityIds.add(entity.getId());		
		}
		
		//delete existing mrefs
		getDatabase().remove(getDatabase().query( WorkflowElement_PreviousSteps.class).in("WorkflowElement", entityIds).find());
		List<WorkflowElement_PreviousSteps> workflowElement_PreviousStepsToAdd = new ArrayList<WorkflowElement_PreviousSteps>();


		//check for each mref what needs to be added
		for(WorkflowElement entity: entities)
		{
			//remove duplicates using Set
			entity.setPreviousSteps(new ArrayList(new LinkedHashSet(entity.getPreviousSteps_Id())));
			for(Integer id: entity.getPreviousSteps_Id())
			{
				WorkflowElement_PreviousSteps new_mref = new WorkflowElement_PreviousSteps();
				new_mref.setWorkflowElement( entity.getId() );
				new_mref.setPreviousSteps( id );
				workflowElement_PreviousStepsToAdd.add(new_mref);
			}
			
		}
		
		//process changes to WorkflowElement_PreviousSteps
		getDatabase().add( workflowElement_PreviousStepsToAdd );
	}
		
	
	public void removeMrefs( List<WorkflowElement> entities ) throws DatabaseException, IOException, ParseException
	{
		//create an list of WorkflowElement ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (WorkflowElement entity : entities) 
		{
			entityIds.add(entity.getId());		
		}	
	
		//remove all WorkflowElement_PreviousSteps elements for field entity.PreviousSteps
		getDatabase().remove( getDatabase().query( WorkflowElement_PreviousSteps.class).in("WorkflowElement", entityIds).find() );
	}	
}
