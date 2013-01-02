/* File:        observ/model/ProtocolApplication_Performer.java
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
import org.molgenis.protocol.ProtocolApplication_Performer;

import org.molgenis.auth.Person;
import org.molgenis.protocol.ProtocolApplication;

public class ProtocolApplication_PerformerMapper extends AbstractJDBCMapper<ProtocolApplication_Performer>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends ProtocolApplication_Performer> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO ProtocolApplication_Performer (Performer,ProtocolApplication) VALUES ");
		{
		
			boolean first = true;
			for(ProtocolApplication_Performer e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//performer
				if(e.getPerformer_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getPerformer_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//protocolApplication
				if(e.getProtocolApplication_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getProtocolApplication_Id().toString())+"'"
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
	public int executeUpdate(List<? extends ProtocolApplication_Performer> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO ProtocolApplication_Performer (autoid,Performer,ProtocolApplication) VALUES ");		
		boolean first = true;
		for(ProtocolApplication_Performer e: entities)
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
		
			//performer


			if(e.getPerformer_Id() != null){
                sql.append("'"+this.escapeSql(e.getPerformer_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//protocolApplication


			if(e.getProtocolApplication_Id() != null){
                sql.append("'"+this.escapeSql(e.getProtocolApplication_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE autoid=LAST_INSERT_ID(autoid),Performer=VALUES(Performer),ProtocolApplication=VALUES(ProtocolApplication)");

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
	public int executeRemove(List<? extends ProtocolApplication_Performer> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM ProtocolApplication_Performer WHERE ");
		
		//key $f_index: autoid
		{
			sql.append("autoid in (");
			boolean first = true;
			for(ProtocolApplication_Performer e: entities)
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
	
	public ProtocolApplication_PerformerMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT ProtocolApplication_Performer.autoid"
			+", ProtocolApplication_Performer.Performer"
			+", ProtocolApplication_Performer.ProtocolApplication"
			//parent is SimpleTree(name='Performer')
			+", xref_Performer.name AS Performer_Name"
			//parent is SimpleTree(name='ProtocolApplication')
			+", xref_ProtocolApplication.name AS ProtocolApplication_Name"
			+" FROM ProtocolApplication_Performer "

			
			//label for Performer=name
//path==Performer. type==xref.
//path==Performer_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN MolgenisRole AS xref_Performer " 
			+" ON xref_Performer.id = ProtocolApplication_Performer.Performer"
			
			//label for ProtocolApplication=name
//path==ProtocolApplication. type==xref.
//path==ProtocolApplication_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN ProtocolApplication AS xref_ProtocolApplication " 
			+" ON xref_ProtocolApplication.id = ProtocolApplication_Performer.ProtocolApplication"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM ProtocolApplication_Performer "
			
			//label for Performer=name
//Performer
//Performer_Name
		   	+" LEFT JOIN MolgenisRole AS xref_Performer " 
			+" ON xref_Performer.id = ProtocolApplication_Performer.Performer"
			
			//label for ProtocolApplication=name
//ProtocolApplication
//ProtocolApplication_Name
		   	+" LEFT JOIN ProtocolApplication AS xref_ProtocolApplication " 
			+" ON xref_ProtocolApplication.id = ProtocolApplication_Performer.ProtocolApplication"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("autoid".equalsIgnoreCase(fieldName)) return "ProtocolApplication_Performer.autoid";
		if("ProtocolApplication_Performer_autoid".equalsIgnoreCase(fieldName)) return "ProtocolApplication_Performer.autoid";
		if("Performer".equalsIgnoreCase(fieldName)) return "ProtocolApplication_Performer.Performer";
		if("ProtocolApplication_Performer_Performer".equalsIgnoreCase(fieldName)) return "ProtocolApplication_Performer.Performer";
		if("ProtocolApplication".equalsIgnoreCase(fieldName)) return "ProtocolApplication_Performer.ProtocolApplication";
		if("ProtocolApplication_Performer_ProtocolApplication".equalsIgnoreCase(fieldName)) return "ProtocolApplication_Performer.ProtocolApplication";
		if("Performer_id".equalsIgnoreCase(fieldName)) return "ProtocolApplication_Performer.Performer";
		if("ProtocolApplication_Performer_Performer_id".equalsIgnoreCase(fieldName)) return "ProtocolApplication_Performer.Performer";
		if("Performer_Name".equalsIgnoreCase(fieldName)) return "xref_Performer.name";	
		if("ProtocolApplication_Performer_Performer_Name".equalsIgnoreCase(fieldName)) return "xref_Performer.name";
		if("ProtocolApplication_id".equalsIgnoreCase(fieldName)) return "ProtocolApplication_Performer.ProtocolApplication";
		if("ProtocolApplication_Performer_ProtocolApplication_id".equalsIgnoreCase(fieldName)) return "ProtocolApplication_Performer.ProtocolApplication";
		if("ProtocolApplication_Name".equalsIgnoreCase(fieldName)) return "xref_ProtocolApplication.name";	
		if("ProtocolApplication_Performer_ProtocolApplication_Name".equalsIgnoreCase(fieldName)) return "xref_ProtocolApplication.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.protocol.ProtocolApplication_Performer> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.protocol.ProtocolApplication_Performer>(size); 
	}			

	public org.molgenis.protocol.ProtocolApplication_Performer create()
	{
		return new org.molgenis.protocol.ProtocolApplication_Performer();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.protocol.ProtocolApplication_Performer> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'performer' to person.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> performerRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'protocolApplication' to protocolApplication.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> protocolApplicationRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.protocol.ProtocolApplication_Performer object: entities)
		{
			//create xref/mref rule filtering Person on the label name
			if(object.getPerformer_Id() == null && object.getPerformer_Name() != null)
			{
				Object label = object.getPerformer_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !performerRules.containsKey(label))
					{
						performerRules.put(""+label, xrefFilter);
						performerRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering ProtocolApplication on the label name
			if(object.getProtocolApplication_Id() == null && object.getProtocolApplication_Name() != null)
			{
				Object label = object.getProtocolApplication_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !protocolApplicationRules.containsKey(label))
					{
						protocolApplicationRules.put(""+label, xrefFilter);
						protocolApplicationRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'performer' to person.id using name)
		final java.util.Map<String,Integer> performer_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(performerRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.auth.Person> performerList = null;
			try
			{
				performerList = getDatabase().find(org.molgenis.auth.Person.class, performerRules.values().toArray(new org.molgenis.framework.db.QueryRule[performerRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.auth.Person xref :  performerList)
			{
				String key = "";
				key += 	xref.getName();
				
				performer_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'protocolApplication' to protocolApplication.id using name)
		final java.util.Map<String,Integer> protocolApplication_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(protocolApplicationRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.protocol.ProtocolApplication> protocolApplicationList = null;
			try
			{
				protocolApplicationList = getDatabase().find(org.molgenis.protocol.ProtocolApplication.class, protocolApplicationRules.values().toArray(new org.molgenis.framework.db.QueryRule[protocolApplicationRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.protocol.ProtocolApplication xref :  protocolApplicationList)
			{
				String key = "";
				key += 	xref.getName();
				
				protocolApplication_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.protocol.ProtocolApplication_Performer object = entities.get(i);		
			//update object using label fields name
			if(object.getPerformer_Id() == null )
			{
					String key = "";
					if(object.getPerformer_Name() != null)
						key += 	object.getPerformer_Name();
					
					if(!"".equals(key) && performer_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Performer_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setPerformer_Id(performer_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getProtocolApplication_Id() == null )
			{
					String key = "";
					if(object.getProtocolApplication_Name() != null)
						key += 	object.getProtocolApplication_Name();
					
					if(!"".equals(key) && protocolApplication_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("ProtocolApplication_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setProtocolApplication_Id(protocolApplication_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("autoid".equalsIgnoreCase(fieldName) || "protocolApplication_Performer.autoid".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("performer".equalsIgnoreCase(fieldName) || "protocolApplication_Performer.performer".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("protocolApplication".equalsIgnoreCase(fieldName) || "protocolApplication_Performer.protocolApplication".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, ProtocolApplication_Performer entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.protocol.ProtocolApplication_Performer> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.protocol.ProtocolApplication_Performer> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<ProtocolApplication_Performer> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<ProtocolApplication_Performer> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<ProtocolApplication_Performer> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
