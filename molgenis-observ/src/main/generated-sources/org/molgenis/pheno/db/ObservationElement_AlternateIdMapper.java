/* File:        observ/model/ObservationElement_AlternateId.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Template:	MultiqueryMapperGen.java.ftl
 * generator:   org.molgenis.generators.db.MultiqueryMapperGen 4.0.0-testing
 *
 * Using "subclass per table" strategy
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.pheno.db;

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
import org.molgenis.pheno.ObservationElement_AlternateId;

import org.molgenis.pheno.AlternateId;
import org.molgenis.pheno.ObservationElement;

public class ObservationElement_AlternateIdMapper extends AbstractJDBCMapper<ObservationElement_AlternateId>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends ObservationElement_AlternateId> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO ObservationElement_AlternateId (AlternateId,ObservationElement) VALUES ");
		{
		
			boolean first = true;
			for(ObservationElement_AlternateId e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//alternateId
				if(e.getAlternateId_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getAlternateId_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//observationElement
				if(e.getObservationElement_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getObservationElement_Id().toString())+"'"
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
	public int executeUpdate(List<? extends ObservationElement_AlternateId> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO ObservationElement_AlternateId (autoid,AlternateId,ObservationElement) VALUES ");		
		boolean first = true;
		for(ObservationElement_AlternateId e: entities)
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
		
			//alternateId


			if(e.getAlternateId_Id() != null){
                sql.append("'"+this.escapeSql(e.getAlternateId_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//observationElement


			if(e.getObservationElement_Id() != null){
                sql.append("'"+this.escapeSql(e.getObservationElement_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE autoid=LAST_INSERT_ID(autoid),AlternateId=VALUES(AlternateId),ObservationElement=VALUES(ObservationElement)");

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
	public int executeRemove(List<? extends ObservationElement_AlternateId> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM ObservationElement_AlternateId WHERE ");
		
		//key $f_index: autoid
		{
			sql.append("autoid in (");
			boolean first = true;
			for(ObservationElement_AlternateId e: entities)
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
	
	public ObservationElement_AlternateIdMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT ObservationElement_AlternateId.autoid"
			+", ObservationElement_AlternateId.AlternateId"
			+", ObservationElement_AlternateId.ObservationElement"
			//parent is SimpleTree(name='AlternateId')
			+", xref_AlternateId.name AS AlternateId_Name"
			//parent is SimpleTree(name='ObservationElement')
			+", xref_ObservationElement.name AS ObservationElement_Name"
			+" FROM ObservationElement_AlternateId "

			
			//label for AlternateId=name
//path==AlternateId. type==xref.
//path==AlternateId_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_AlternateId " 
			+" ON xref_AlternateId.id = ObservationElement_AlternateId.AlternateId"
			
			//label for ObservationElement=name
//path==ObservationElement. type==xref.
//path==ObservationElement_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN ObservationElement AS xref_ObservationElement " 
			+" ON xref_ObservationElement.id = ObservationElement_AlternateId.ObservationElement"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM ObservationElement_AlternateId "
			
			//label for AlternateId=name
//AlternateId
//AlternateId_Name
		   	+" LEFT JOIN OntologyTerm AS xref_AlternateId " 
			+" ON xref_AlternateId.id = ObservationElement_AlternateId.AlternateId"
			
			//label for ObservationElement=name
//ObservationElement
//ObservationElement_Name
		   	+" LEFT JOIN ObservationElement AS xref_ObservationElement " 
			+" ON xref_ObservationElement.id = ObservationElement_AlternateId.ObservationElement"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("autoid".equalsIgnoreCase(fieldName)) return "ObservationElement_AlternateId.autoid";
		if("ObservationElement_AlternateId_autoid".equalsIgnoreCase(fieldName)) return "ObservationElement_AlternateId.autoid";
		if("AlternateId".equalsIgnoreCase(fieldName)) return "ObservationElement_AlternateId.AlternateId";
		if("ObservationElement_AlternateId_AlternateId".equalsIgnoreCase(fieldName)) return "ObservationElement_AlternateId.AlternateId";
		if("ObservationElement".equalsIgnoreCase(fieldName)) return "ObservationElement_AlternateId.ObservationElement";
		if("ObservationElement_AlternateId_ObservationElement".equalsIgnoreCase(fieldName)) return "ObservationElement_AlternateId.ObservationElement";
		if("AlternateId_id".equalsIgnoreCase(fieldName)) return "ObservationElement_AlternateId.AlternateId";
		if("ObservationElement_AlternateId_AlternateId_id".equalsIgnoreCase(fieldName)) return "ObservationElement_AlternateId.AlternateId";
		if("AlternateId_Name".equalsIgnoreCase(fieldName)) return "xref_AlternateId.name";	
		if("ObservationElement_AlternateId_AlternateId_Name".equalsIgnoreCase(fieldName)) return "xref_AlternateId.name";
		if("ObservationElement_id".equalsIgnoreCase(fieldName)) return "ObservationElement_AlternateId.ObservationElement";
		if("ObservationElement_AlternateId_ObservationElement_id".equalsIgnoreCase(fieldName)) return "ObservationElement_AlternateId.ObservationElement";
		if("ObservationElement_Name".equalsIgnoreCase(fieldName)) return "xref_ObservationElement.name";	
		if("ObservationElement_AlternateId_ObservationElement_Name".equalsIgnoreCase(fieldName)) return "xref_ObservationElement.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.pheno.ObservationElement_AlternateId> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.pheno.ObservationElement_AlternateId>(size); 
	}			

	public org.molgenis.pheno.ObservationElement_AlternateId create()
	{
		return new org.molgenis.pheno.ObservationElement_AlternateId();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.pheno.ObservationElement_AlternateId> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'alternateId' to alternateId.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> alternateIdRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'observationElement' to observationElement.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> observationElementRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.pheno.ObservationElement_AlternateId object: entities)
		{
			//create xref/mref rule filtering AlternateId on the label name
			if(object.getAlternateId_Id() == null && object.getAlternateId_Name() != null)
			{
				Object label = object.getAlternateId_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !alternateIdRules.containsKey(label))
					{
						alternateIdRules.put(""+label, xrefFilter);
						alternateIdRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering ObservationElement on the label name
			if(object.getObservationElement_Id() == null && object.getObservationElement_Name() != null)
			{
				Object label = object.getObservationElement_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !observationElementRules.containsKey(label))
					{
						observationElementRules.put(""+label, xrefFilter);
						observationElementRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'alternateId' to alternateId.id using name)
		final java.util.Map<String,Integer> alternateId_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(alternateIdRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.AlternateId> alternateIdList = null;
			try
			{
				alternateIdList = getDatabase().find(org.molgenis.pheno.AlternateId.class, alternateIdRules.values().toArray(new org.molgenis.framework.db.QueryRule[alternateIdRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.AlternateId xref :  alternateIdList)
			{
				String key = "";
				key += 	xref.getName();
				
				alternateId_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'observationElement' to observationElement.id using name)
		final java.util.Map<String,Integer> observationElement_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(observationElementRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.ObservationElement> observationElementList = null;
			try
			{
				observationElementList = getDatabase().find(org.molgenis.pheno.ObservationElement.class, observationElementRules.values().toArray(new org.molgenis.framework.db.QueryRule[observationElementRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.ObservationElement xref :  observationElementList)
			{
				String key = "";
				key += 	xref.getName();
				
				observationElement_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.pheno.ObservationElement_AlternateId object = entities.get(i);		
			//update object using label fields name
			if(object.getAlternateId_Id() == null )
			{
					String key = "";
					if(object.getAlternateId_Name() != null)
						key += 	object.getAlternateId_Name();
					
					if(!"".equals(key) && alternateId_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("AlternateId_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setAlternateId_Id(alternateId_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getObservationElement_Id() == null )
			{
					String key = "";
					if(object.getObservationElement_Name() != null)
						key += 	object.getObservationElement_Name();
					
					if(!"".equals(key) && observationElement_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("ObservationElement_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setObservationElement_Id(observationElement_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("autoid".equalsIgnoreCase(fieldName) || "observationElement_AlternateId.autoid".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("alternateId".equalsIgnoreCase(fieldName) || "observationElement_AlternateId.alternateId".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("observationElement".equalsIgnoreCase(fieldName) || "observationElement_AlternateId.observationElement".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, ObservationElement_AlternateId entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.pheno.ObservationElement_AlternateId> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.pheno.ObservationElement_AlternateId> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<ObservationElement_AlternateId> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<ObservationElement_AlternateId> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<ObservationElement_AlternateId> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
