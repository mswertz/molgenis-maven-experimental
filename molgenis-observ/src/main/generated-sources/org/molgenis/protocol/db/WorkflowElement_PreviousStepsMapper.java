/* File:        observ/model/WorkflowElement_PreviousSteps.java
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
import org.molgenis.protocol.WorkflowElement_PreviousSteps;

import org.molgenis.protocol.WorkflowElement;
import org.molgenis.protocol.WorkflowElement;

public class WorkflowElement_PreviousStepsMapper extends AbstractJDBCMapper<WorkflowElement_PreviousSteps>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends WorkflowElement_PreviousSteps> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO WorkflowElement_PreviousSteps (PreviousSteps,WorkflowElement) VALUES ");
		{
		
			boolean first = true;
			for(WorkflowElement_PreviousSteps e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//previousSteps
				if(e.getPreviousSteps_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getPreviousSteps_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//workflowElement
				if(e.getWorkflowElement_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getWorkflowElement_Id().toString())+"'"
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
	public int executeUpdate(List<? extends WorkflowElement_PreviousSteps> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO WorkflowElement_PreviousSteps (autoid,PreviousSteps,WorkflowElement) VALUES ");		
		boolean first = true;
		for(WorkflowElement_PreviousSteps e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//autoid


			if(e.getAutoid() != null){
                sql.append("'"+this.escapeSql(e.getAutoid()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//previousSteps


			if(e.getPreviousSteps_Id() != null){
                sql.append("'"+this.escapeSql(e.getPreviousSteps_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//workflowElement


			if(e.getWorkflowElement_Id() != null){
                sql.append("'"+this.escapeSql(e.getWorkflowElement_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE autoid=LAST_INSERT_ID(autoid),PreviousSteps=VALUES(PreviousSteps),WorkflowElement=VALUES(WorkflowElement)");

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
	public int executeRemove(List<? extends WorkflowElement_PreviousSteps> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM WorkflowElement_PreviousSteps WHERE ");
		
		//key $f_index: autoid
		{
			sql.append("autoid in (");
			boolean first = true;
			for(WorkflowElement_PreviousSteps e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");			
				sql.append("'"+this.escapeSql(e.getAutoid().toString())+"'");
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
	
	public WorkflowElement_PreviousStepsMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT WorkflowElement_PreviousSteps.autoid"
			+", WorkflowElement_PreviousSteps.PreviousSteps"
			+", WorkflowElement_PreviousSteps.WorkflowElement"
			//parent is SimpleTree(name='PreviousSteps')
			+", xref_PreviousSteps.name AS PreviousSteps_Name"
			//parent is SimpleTree(name='WorkflowElement')
			+", xref_WorkflowElement.name AS WorkflowElement_Name"
			+" FROM WorkflowElement_PreviousSteps "

			
			//label for PreviousSteps=name
//path==PreviousSteps. type==xref.
//path==PreviousSteps_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN WorkflowElement AS xref_PreviousSteps " 
			+" ON xref_PreviousSteps.id = WorkflowElement_PreviousSteps.PreviousSteps"
			
			//label for WorkflowElement=name
//path==WorkflowElement. type==xref.
//path==WorkflowElement_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN WorkflowElement AS xref_WorkflowElement " 
			+" ON xref_WorkflowElement.id = WorkflowElement_PreviousSteps.WorkflowElement"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM WorkflowElement_PreviousSteps "
			
			//label for PreviousSteps=name
//PreviousSteps
//PreviousSteps_Name
		   	+" LEFT JOIN WorkflowElement AS xref_PreviousSteps " 
			+" ON xref_PreviousSteps.id = WorkflowElement_PreviousSteps.PreviousSteps"
			
			//label for WorkflowElement=name
//WorkflowElement
//WorkflowElement_Name
		   	+" LEFT JOIN WorkflowElement AS xref_WorkflowElement " 
			+" ON xref_WorkflowElement.id = WorkflowElement_PreviousSteps.WorkflowElement"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("autoid".equalsIgnoreCase(fieldName)) return "WorkflowElement_PreviousSteps.autoid";
		if("WorkflowElement_PreviousSteps_autoid".equalsIgnoreCase(fieldName)) return "WorkflowElement_PreviousSteps.autoid";
		if("PreviousSteps".equalsIgnoreCase(fieldName)) return "WorkflowElement_PreviousSteps.PreviousSteps";
		if("WorkflowElement_PreviousSteps_PreviousSteps".equalsIgnoreCase(fieldName)) return "WorkflowElement_PreviousSteps.PreviousSteps";
		if("WorkflowElement".equalsIgnoreCase(fieldName)) return "WorkflowElement_PreviousSteps.WorkflowElement";
		if("WorkflowElement_PreviousSteps_WorkflowElement".equalsIgnoreCase(fieldName)) return "WorkflowElement_PreviousSteps.WorkflowElement";
		if("PreviousSteps_id".equalsIgnoreCase(fieldName)) return "WorkflowElement_PreviousSteps.PreviousSteps";
		if("WorkflowElement_PreviousSteps_PreviousSteps_id".equalsIgnoreCase(fieldName)) return "WorkflowElement_PreviousSteps.PreviousSteps";
		if("PreviousSteps_Name".equalsIgnoreCase(fieldName)) return "xref_PreviousSteps.name";	
		if("WorkflowElement_PreviousSteps_PreviousSteps_Name".equalsIgnoreCase(fieldName)) return "xref_PreviousSteps.name";
		if("WorkflowElement_id".equalsIgnoreCase(fieldName)) return "WorkflowElement_PreviousSteps.WorkflowElement";
		if("WorkflowElement_PreviousSteps_WorkflowElement_id".equalsIgnoreCase(fieldName)) return "WorkflowElement_PreviousSteps.WorkflowElement";
		if("WorkflowElement_Name".equalsIgnoreCase(fieldName)) return "xref_WorkflowElement.name";	
		if("WorkflowElement_PreviousSteps_WorkflowElement_Name".equalsIgnoreCase(fieldName)) return "xref_WorkflowElement.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.protocol.WorkflowElement_PreviousSteps> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.protocol.WorkflowElement_PreviousSteps>(size); 
	}			

	public org.molgenis.protocol.WorkflowElement_PreviousSteps create()
	{
		return new org.molgenis.protocol.WorkflowElement_PreviousSteps();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.protocol.WorkflowElement_PreviousSteps> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'previousSteps' to workflowElement.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> previousStepsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'workflowElement' to workflowElement.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> workflowElementRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.protocol.WorkflowElement_PreviousSteps object: entities)
		{
			//create xref/mref rule filtering WorkflowElement on the label name
			if(object.getPreviousSteps_Id() == null && object.getPreviousSteps_Name() != null)
			{
				Object label = object.getPreviousSteps_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !previousStepsRules.containsKey(label))
					{
						previousStepsRules.put(""+label, xrefFilter);
						previousStepsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering WorkflowElement on the label name
			if(object.getWorkflowElement_Id() == null && object.getWorkflowElement_Name() != null)
			{
				Object label = object.getWorkflowElement_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !workflowElementRules.containsKey(label))
					{
						workflowElementRules.put(""+label, xrefFilter);
						workflowElementRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
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
		//resolve foreign key field 'workflowElement' to workflowElement.id using name)
		final java.util.Map<String,Integer> workflowElement_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(workflowElementRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.protocol.WorkflowElement> workflowElementList = null;
			try
			{
				workflowElementList = getDatabase().find(org.molgenis.protocol.WorkflowElement.class, workflowElementRules.values().toArray(new org.molgenis.framework.db.QueryRule[workflowElementRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.protocol.WorkflowElement xref :  workflowElementList)
			{
				String key = "";
				key += 	xref.getName();
				
				workflowElement_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.protocol.WorkflowElement_PreviousSteps object = entities.get(i);		
			//update object using label fields name
			if(object.getPreviousSteps_Id() == null )
			{
					String key = "";
					if(object.getPreviousSteps_Name() != null)
						key += 	object.getPreviousSteps_Name();
					
					if(!"".equals(key) && previousSteps_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("PreviousSteps_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setPreviousSteps_Id(previousSteps_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getWorkflowElement_Id() == null )
			{
					String key = "";
					if(object.getWorkflowElement_Name() != null)
						key += 	object.getWorkflowElement_Name();
					
					if(!"".equals(key) && workflowElement_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("WorkflowElement_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setWorkflowElement_Id(workflowElement_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("autoid".equalsIgnoreCase(fieldName) || "workflowElement_PreviousSteps.autoid".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("previousSteps".equalsIgnoreCase(fieldName) || "workflowElement_PreviousSteps.previousSteps".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("workflowElement".equalsIgnoreCase(fieldName) || "workflowElement_PreviousSteps.workflowElement".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, WorkflowElement_PreviousSteps entity)
	{
		entity.setAutoid(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		
		{
			return rule;
		}
	}

//Generated by MapperFileAttachments.java.ftl
	public void prepareFileAttachements(java.util.List<org.molgenis.protocol.WorkflowElement_PreviousSteps> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.protocol.WorkflowElement_PreviousSteps> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<WorkflowElement_PreviousSteps> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<WorkflowElement_PreviousSteps> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<WorkflowElement_PreviousSteps> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
