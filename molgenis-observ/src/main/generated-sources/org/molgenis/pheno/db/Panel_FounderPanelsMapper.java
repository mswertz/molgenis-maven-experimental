/* File:        observ/model/Panel_FounderPanels.java
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
import org.molgenis.pheno.Panel_FounderPanels;

import org.molgenis.pheno.Panel;
import org.molgenis.pheno.Panel;

public class Panel_FounderPanelsMapper extends AbstractJDBCMapper<Panel_FounderPanels>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Panel_FounderPanels> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Panel_FounderPanels (FounderPanels,Panel) VALUES ");
		{
		
			boolean first = true;
			for(Panel_FounderPanels e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//founderPanels
				if(e.getFounderPanels_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getFounderPanels_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//panel
				if(e.getPanel_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getPanel_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Panel_FounderPanels> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Panel_FounderPanels (autoid,FounderPanels,Panel) VALUES ");		
		boolean first = true;
		for(Panel_FounderPanels e: entities)
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
		
			//founderPanels


			if(e.getFounderPanels_Id() != null){
                sql.append("'"+this.escapeSql(e.getFounderPanels_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//panel


			if(e.getPanel_Id() != null){
                sql.append("'"+this.escapeSql(e.getPanel_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE autoid=LAST_INSERT_ID(autoid),FounderPanels=VALUES(FounderPanels),Panel=VALUES(Panel)");

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
	public int executeRemove(List<? extends Panel_FounderPanels> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Panel_FounderPanels WHERE ");
		
		//key $f_index: autoid
		{
			sql.append("autoid in (");
			boolean first = true;
			for(Panel_FounderPanels e: entities)
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
	
	public Panel_FounderPanelsMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Panel_FounderPanels.autoid"
			+", Panel_FounderPanels.FounderPanels"
			+", Panel_FounderPanels.Panel"
			//parent is SimpleTree(name='FounderPanels')
			+", xref_FounderPanels.name AS FounderPanels_Name"
			//parent is SimpleTree(name='Panel')
			+", xref_Panel.name AS Panel_Name"
			+" FROM Panel_FounderPanels "

			
			//label for FounderPanels=name
//path==FounderPanels. type==xref.
//path==FounderPanels_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN ObservationElement AS xref_FounderPanels " 
			+" ON xref_FounderPanels.id = Panel_FounderPanels.FounderPanels"
			
			//label for Panel=name
//path==Panel. type==xref.
//path==Panel_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN ObservationElement AS xref_Panel " 
			+" ON xref_Panel.id = Panel_FounderPanels.Panel"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Panel_FounderPanels "
			
			//label for FounderPanels=name
//FounderPanels
//FounderPanels_Name
		   	+" LEFT JOIN ObservationElement AS xref_FounderPanels " 
			+" ON xref_FounderPanels.id = Panel_FounderPanels.FounderPanels"
			
			//label for Panel=name
//Panel
//Panel_Name
		   	+" LEFT JOIN ObservationElement AS xref_Panel " 
			+" ON xref_Panel.id = Panel_FounderPanels.Panel"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("autoid".equalsIgnoreCase(fieldName)) return "Panel_FounderPanels.autoid";
		if("Panel_FounderPanels_autoid".equalsIgnoreCase(fieldName)) return "Panel_FounderPanels.autoid";
		if("FounderPanels".equalsIgnoreCase(fieldName)) return "Panel_FounderPanels.FounderPanels";
		if("Panel_FounderPanels_FounderPanels".equalsIgnoreCase(fieldName)) return "Panel_FounderPanels.FounderPanels";
		if("Panel".equalsIgnoreCase(fieldName)) return "Panel_FounderPanels.Panel";
		if("Panel_FounderPanels_Panel".equalsIgnoreCase(fieldName)) return "Panel_FounderPanels.Panel";
		if("FounderPanels_id".equalsIgnoreCase(fieldName)) return "Panel_FounderPanels.FounderPanels";
		if("Panel_FounderPanels_FounderPanels_id".equalsIgnoreCase(fieldName)) return "Panel_FounderPanels.FounderPanels";
		if("FounderPanels_Name".equalsIgnoreCase(fieldName)) return "xref_FounderPanels.name";	
		if("Panel_FounderPanels_FounderPanels_Name".equalsIgnoreCase(fieldName)) return "xref_FounderPanels.name";
		if("Panel_id".equalsIgnoreCase(fieldName)) return "Panel_FounderPanels.Panel";
		if("Panel_FounderPanels_Panel_id".equalsIgnoreCase(fieldName)) return "Panel_FounderPanels.Panel";
		if("Panel_Name".equalsIgnoreCase(fieldName)) return "xref_Panel.name";	
		if("Panel_FounderPanels_Panel_Name".equalsIgnoreCase(fieldName)) return "xref_Panel.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.pheno.Panel_FounderPanels> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.pheno.Panel_FounderPanels>(size); 
	}			

	public org.molgenis.pheno.Panel_FounderPanels create()
	{
		return new org.molgenis.pheno.Panel_FounderPanels();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.pheno.Panel_FounderPanels> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'founderPanels' to panel.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> founderPanelsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'panel' to panel.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> panelRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.pheno.Panel_FounderPanels object: entities)
		{
			//create xref/mref rule filtering Panel on the label name
			if(object.getFounderPanels_Id() == null && object.getFounderPanels_Name() != null)
			{
				Object label = object.getFounderPanels_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !founderPanelsRules.containsKey(label))
					{
						founderPanelsRules.put(""+label, xrefFilter);
						founderPanelsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Panel on the label name
			if(object.getPanel_Id() == null && object.getPanel_Name() != null)
			{
				Object label = object.getPanel_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !panelRules.containsKey(label))
					{
						panelRules.put(""+label, xrefFilter);
						panelRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'founderPanels' to panel.id using name)
		final java.util.Map<String,Integer> founderPanels_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(founderPanelsRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.Panel> founderPanelsList = null;
			try
			{
				founderPanelsList = getDatabase().find(org.molgenis.pheno.Panel.class, founderPanelsRules.values().toArray(new org.molgenis.framework.db.QueryRule[founderPanelsRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.Panel xref :  founderPanelsList)
			{
				String key = "";
				key += 	xref.getName();
				
				founderPanels_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'panel' to panel.id using name)
		final java.util.Map<String,Integer> panel_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(panelRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.Panel> panelList = null;
			try
			{
				panelList = getDatabase().find(org.molgenis.pheno.Panel.class, panelRules.values().toArray(new org.molgenis.framework.db.QueryRule[panelRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.Panel xref :  panelList)
			{
				String key = "";
				key += 	xref.getName();
				
				panel_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.pheno.Panel_FounderPanels object = entities.get(i);		
			//update object using label fields name
			if(object.getFounderPanels_Id() == null )
			{
					String key = "";
					if(object.getFounderPanels_Name() != null)
						key += 	object.getFounderPanels_Name();
					
					if(!"".equals(key) && founderPanels_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("FounderPanels_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setFounderPanels_Id(founderPanels_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getPanel_Id() == null )
			{
					String key = "";
					if(object.getPanel_Name() != null)
						key += 	object.getPanel_Name();
					
					if(!"".equals(key) && panel_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Panel_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setPanel_Id(panel_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("autoid".equalsIgnoreCase(fieldName) || "panel_FounderPanels.autoid".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("founderPanels".equalsIgnoreCase(fieldName) || "panel_FounderPanels.founderPanels".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("panel".equalsIgnoreCase(fieldName) || "panel_FounderPanels.panel".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Panel_FounderPanels entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.pheno.Panel_FounderPanels> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.pheno.Panel_FounderPanels> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Panel_FounderPanels> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Panel_FounderPanels> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Panel_FounderPanels> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
