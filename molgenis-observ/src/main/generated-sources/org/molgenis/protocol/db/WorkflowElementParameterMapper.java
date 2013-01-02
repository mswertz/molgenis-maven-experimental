/* File:        observ/model/WorkflowElementParameter.java
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
import org.molgenis.protocol.WorkflowElementParameter;

import org.molgenis.protocol.WorkflowElement;
import org.molgenis.pheno.ObservableFeature;

public class WorkflowElementParameterMapper extends AbstractJDBCMapper<WorkflowElementParameter>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends WorkflowElementParameter> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO WorkflowElementParameter (WorkflowElement,Parameter,Value) VALUES ");
		{
		
			boolean first = true;
			for(WorkflowElementParameter e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//workflowElement
				if(e.getWorkflowElement_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getWorkflowElement_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//parameter
				if(e.getParameter_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getParameter_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//value
				if(e.getValue() != null){
								
					sql.append("'"+this.escapeSql(e.getValue().toString())+"'"
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
	public int executeUpdate(List<? extends WorkflowElementParameter> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO WorkflowElementParameter (id,WorkflowElement,Parameter,Value) VALUES ");		
		boolean first = true;
		for(WorkflowElementParameter e: entities)
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
		
			//workflowElement


			if(e.getWorkflowElement_Id() != null){
                sql.append("'"+this.escapeSql(e.getWorkflowElement_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//parameter


			if(e.getParameter_Id() != null){
                sql.append("'"+this.escapeSql(e.getParameter_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//value


			if(e.getValue() != null){
                sql.append("'"+this.escapeSql(e.getValue()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE WorkflowElement=VALUES(WorkflowElement),Parameter=VALUES(Parameter),Value=VALUES(Value),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends WorkflowElementParameter> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM WorkflowElementParameter WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(WorkflowElementParameter e: entities)
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
	
	public WorkflowElementParameterMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT WorkflowElementParameter.id"
			+", WorkflowElementParameter.WorkflowElement"
			+", WorkflowElementParameter.Parameter"
			+", WorkflowElementParameter.Value"
			//parent is SimpleTree(name='WorkflowElement')
			+", xref_WorkflowElement.name AS WorkflowElement_Name"
			//parent is SimpleTree(name='Parameter')
			+", xref_Parameter.name AS Parameter_Name"
			+" FROM WorkflowElementParameter "

			
			//label for WorkflowElement=name
//path==WorkflowElement. type==xref.
//path==WorkflowElement_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN WorkflowElement AS xref_WorkflowElement " 
			+" ON xref_WorkflowElement.id = WorkflowElementParameter.WorkflowElement"
			
			//label for Parameter=name
//path==Parameter. type==xref.
//path==Parameter_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN ObservationElement AS xref_Parameter " 
			+" ON xref_Parameter.id = WorkflowElementParameter.Parameter"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM WorkflowElementParameter "
			
			//label for WorkflowElement=name
//WorkflowElement
//WorkflowElement_Name
		   	+" LEFT JOIN WorkflowElement AS xref_WorkflowElement " 
			+" ON xref_WorkflowElement.id = WorkflowElementParameter.WorkflowElement"
			
			//label for Parameter=name
//Parameter
//Parameter_Name
		   	+" LEFT JOIN ObservationElement AS xref_Parameter " 
			+" ON xref_Parameter.id = WorkflowElementParameter.Parameter"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "WorkflowElementParameter.id";
		if("WorkflowElementParameter_id".equalsIgnoreCase(fieldName)) return "WorkflowElementParameter.id";
		if("WorkflowElement".equalsIgnoreCase(fieldName)) return "WorkflowElementParameter.WorkflowElement";
		if("WorkflowElementParameter_WorkflowElement".equalsIgnoreCase(fieldName)) return "WorkflowElementParameter.WorkflowElement";
		if("Parameter".equalsIgnoreCase(fieldName)) return "WorkflowElementParameter.Parameter";
		if("WorkflowElementParameter_Parameter".equalsIgnoreCase(fieldName)) return "WorkflowElementParameter.Parameter";
		if("Value".equalsIgnoreCase(fieldName)) return "WorkflowElementParameter.Value";
		if("WorkflowElementParameter_Value".equalsIgnoreCase(fieldName)) return "WorkflowElementParameter.Value";
		if("WorkflowElement_id".equalsIgnoreCase(fieldName)) return "WorkflowElementParameter.WorkflowElement";
		if("WorkflowElementParameter_WorkflowElement_id".equalsIgnoreCase(fieldName)) return "WorkflowElementParameter.WorkflowElement";
		if("WorkflowElement_Name".equalsIgnoreCase(fieldName)) return "xref_WorkflowElement.name";	
		if("WorkflowElementParameter_WorkflowElement_Name".equalsIgnoreCase(fieldName)) return "xref_WorkflowElement.name";
		if("Parameter_id".equalsIgnoreCase(fieldName)) return "WorkflowElementParameter.Parameter";
		if("WorkflowElementParameter_Parameter_id".equalsIgnoreCase(fieldName)) return "WorkflowElementParameter.Parameter";
		if("Parameter_Name".equalsIgnoreCase(fieldName)) return "xref_Parameter.name";	
		if("WorkflowElementParameter_Parameter_Name".equalsIgnoreCase(fieldName)) return "xref_Parameter.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.protocol.WorkflowElementParameter> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.protocol.WorkflowElementParameter>(size); 
	}			

	public org.molgenis.protocol.WorkflowElementParameter create()
	{
		return new org.molgenis.protocol.WorkflowElementParameter();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.protocol.WorkflowElementParameter> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'workflowElement' to workflowElement.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> workflowElementRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'parameter' to observableFeature.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> parameterRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.protocol.WorkflowElementParameter object: entities)
		{
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
			//create xref/mref rule filtering ObservableFeature on the label name
			if(object.getParameter_Id() == null && object.getParameter_Name() != null)
			{
				Object label = object.getParameter_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !parameterRules.containsKey(label))
					{
						parameterRules.put(""+label, xrefFilter);
						parameterRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
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
		//resolve foreign key field 'parameter' to observableFeature.id using name)
		final java.util.Map<String,Integer> parameter_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(parameterRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.ObservableFeature> parameterList = null;
			try
			{
				parameterList = getDatabase().find(org.molgenis.pheno.ObservableFeature.class, parameterRules.values().toArray(new org.molgenis.framework.db.QueryRule[parameterRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.ObservableFeature xref :  parameterList)
			{
				String key = "";
				key += 	xref.getName();
				
				parameter_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.protocol.WorkflowElementParameter object = entities.get(i);		
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
			//update object using label fields name
			if(object.getParameter_Id() == null )
			{
					String key = "";
					if(object.getParameter_Name() != null)
						key += 	object.getParameter_Name();
					
					if(!"".equals(key) && parameter_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Parameter_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setParameter_Id(parameter_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "workflowElementParameter.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("workflowElement".equalsIgnoreCase(fieldName) || "workflowElementParameter.workflowElement".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("parameter".equalsIgnoreCase(fieldName) || "workflowElementParameter.parameter".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("value".equalsIgnoreCase(fieldName) || "workflowElementParameter.value".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, WorkflowElementParameter entity)
	{
		entity.setId(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		
		{
			return rule;
		}
	}

//Generated by MapperFileAttachments.java.ftl
	public void prepareFileAttachements(java.util.List<org.molgenis.protocol.WorkflowElementParameter> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.protocol.WorkflowElementParameter> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<WorkflowElementParameter> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<WorkflowElementParameter> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<WorkflowElementParameter> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
