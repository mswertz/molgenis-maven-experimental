/* File:        observ/model/ObservationElement_ontolo12449.java
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
import org.molgenis.pheno.ObservationElement_Ontolo12449;

import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.ObservationElement;

public class ObservationElement_Ontolo12449Mapper extends AbstractJDBCMapper<ObservationElement_Ontolo12449>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends ObservationElement_Ontolo12449> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO ObservationElement_ontolo12449 (ontologyReference,InvestigationElement) VALUES ");
		{
		
			boolean first = true;
			for(ObservationElement_Ontolo12449 e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//ontologyReference
				if(e.getOntologyReference_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getOntologyReference_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//investigationElement
				if(e.getInvestigationElement_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getInvestigationElement_Id().toString())+"'"
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
	public int executeUpdate(List<? extends ObservationElement_Ontolo12449> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO ObservationElement_ontolo12449 (autoid,ontologyReference,InvestigationElement) VALUES ");		
		boolean first = true;
		for(ObservationElement_Ontolo12449 e: entities)
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
		
			//ontologyReference


			if(e.getOntologyReference_Id() != null){
                sql.append("'"+this.escapeSql(e.getOntologyReference_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//investigationElement


			if(e.getInvestigationElement_Id() != null){
                sql.append("'"+this.escapeSql(e.getInvestigationElement_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE autoid=LAST_INSERT_ID(autoid),ontologyReference=VALUES(ontologyReference),InvestigationElement=VALUES(InvestigationElement)");

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
	public int executeRemove(List<? extends ObservationElement_Ontolo12449> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM ObservationElement_ontolo12449 WHERE ");
		
		//key $f_index: autoid
		{
			sql.append("autoid in (");
			boolean first = true;
			for(ObservationElement_Ontolo12449 e: entities)
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
	
	public ObservationElement_Ontolo12449Mapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT ObservationElement_ontolo12449.autoid"
			+", ObservationElement_ontolo12449.ontologyReference"
			+", ObservationElement_ontolo12449.InvestigationElement"
			//parent is SimpleTree(name='ontologyReference')
			+", xref_ontologyReference.name AS ontologyReference_Name"
			//parent is SimpleTree(name='InvestigationElement')
			+", xref_InvestigationElement.name AS InvestigationElement_Name"
			+" FROM ObservationElement_ontolo12449 "

			
			//label for ontologyReference=name
//path==ontologyReference. type==xref.
//path==ontologyReference_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_ontologyReference " 
			+" ON xref_ontologyReference.id = ObservationElement_ontolo12449.ontologyReference"
			
			//label for InvestigationElement=name
//path==InvestigationElement. type==xref.
//path==InvestigationElement_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN ObservationElement AS xref_InvestigationElement " 
			+" ON xref_InvestigationElement.id = ObservationElement_ontolo12449.InvestigationElement"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM ObservationElement_ontolo12449 "
			
			//label for ontologyReference=name
//ontologyReference
//ontologyReference_Name
		   	+" LEFT JOIN OntologyTerm AS xref_ontologyReference " 
			+" ON xref_ontologyReference.id = ObservationElement_ontolo12449.ontologyReference"
			
			//label for InvestigationElement=name
//InvestigationElement
//InvestigationElement_Name
		   	+" LEFT JOIN ObservationElement AS xref_InvestigationElement " 
			+" ON xref_InvestigationElement.id = ObservationElement_ontolo12449.InvestigationElement"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("autoid".equalsIgnoreCase(fieldName)) return "ObservationElement_ontolo12449.autoid";
		if("ObservationElement_ontolo12449_autoid".equalsIgnoreCase(fieldName)) return "ObservationElement_ontolo12449.autoid";
		if("ontologyReference".equalsIgnoreCase(fieldName)) return "ObservationElement_ontolo12449.ontologyReference";
		if("ObservationElement_ontolo12449_ontologyReference".equalsIgnoreCase(fieldName)) return "ObservationElement_ontolo12449.ontologyReference";
		if("InvestigationElement".equalsIgnoreCase(fieldName)) return "ObservationElement_ontolo12449.InvestigationElement";
		if("ObservationElement_ontolo12449_InvestigationElement".equalsIgnoreCase(fieldName)) return "ObservationElement_ontolo12449.InvestigationElement";
		if("ontologyReference_id".equalsIgnoreCase(fieldName)) return "ObservationElement_ontolo12449.ontologyReference";
		if("ObservationElement_ontolo12449_ontologyReference_id".equalsIgnoreCase(fieldName)) return "ObservationElement_ontolo12449.ontologyReference";
		if("ontologyReference_Name".equalsIgnoreCase(fieldName)) return "xref_ontologyReference.name";	
		if("ObservationElement_ontolo12449_ontologyReference_Name".equalsIgnoreCase(fieldName)) return "xref_ontologyReference.name";
		if("InvestigationElement_id".equalsIgnoreCase(fieldName)) return "ObservationElement_ontolo12449.InvestigationElement";
		if("ObservationElement_ontolo12449_InvestigationElement_id".equalsIgnoreCase(fieldName)) return "ObservationElement_ontolo12449.InvestigationElement";
		if("InvestigationElement_Name".equalsIgnoreCase(fieldName)) return "xref_InvestigationElement.name";	
		if("ObservationElement_ontolo12449_InvestigationElement_Name".equalsIgnoreCase(fieldName)) return "xref_InvestigationElement.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.pheno.ObservationElement_Ontolo12449> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.pheno.ObservationElement_Ontolo12449>(size); 
	}			

	public org.molgenis.pheno.ObservationElement_Ontolo12449 create()
	{
		return new org.molgenis.pheno.ObservationElement_Ontolo12449();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.pheno.ObservationElement_Ontolo12449> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'ontologyReference' to ontologyTerm.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> ontologyReferenceRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'investigationElement' to observationElement.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> investigationElementRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.pheno.ObservationElement_Ontolo12449 object: entities)
		{
			//create xref/mref rule filtering OntologyTerm on the label name
			if(object.getOntologyReference_Id() == null && object.getOntologyReference_Name() != null)
			{
				Object label = object.getOntologyReference_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !ontologyReferenceRules.containsKey(label))
					{
						ontologyReferenceRules.put(""+label, xrefFilter);
						ontologyReferenceRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering ObservationElement on the label name
			if(object.getInvestigationElement_Id() == null && object.getInvestigationElement_Name() != null)
			{
				Object label = object.getInvestigationElement_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !investigationElementRules.containsKey(label))
					{
						investigationElementRules.put(""+label, xrefFilter);
						investigationElementRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'ontologyReference' to ontologyTerm.id using name)
		final java.util.Map<String,Integer> ontologyReference_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(ontologyReferenceRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.core.OntologyTerm> ontologyReferenceList = null;
			try
			{
				ontologyReferenceList = getDatabase().find(org.molgenis.core.OntologyTerm.class, ontologyReferenceRules.values().toArray(new org.molgenis.framework.db.QueryRule[ontologyReferenceRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.core.OntologyTerm xref :  ontologyReferenceList)
			{
				String key = "";
				key += 	xref.getName();
				
				ontologyReference_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'investigationElement' to observationElement.id using name)
		final java.util.Map<String,Integer> investigationElement_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(investigationElementRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.ObservationElement> investigationElementList = null;
			try
			{
				investigationElementList = getDatabase().find(org.molgenis.pheno.ObservationElement.class, investigationElementRules.values().toArray(new org.molgenis.framework.db.QueryRule[investigationElementRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.ObservationElement xref :  investigationElementList)
			{
				String key = "";
				key += 	xref.getName();
				
				investigationElement_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.pheno.ObservationElement_Ontolo12449 object = entities.get(i);		
			//update object using label fields name
			if(object.getOntologyReference_Id() == null )
			{
					String key = "";
					if(object.getOntologyReference_Name() != null)
						key += 	object.getOntologyReference_Name();
					
					if(!"".equals(key) && ontologyReference_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("ontologyReference_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setOntologyReference_Id(ontologyReference_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getInvestigationElement_Id() == null )
			{
					String key = "";
					if(object.getInvestigationElement_Name() != null)
						key += 	object.getInvestigationElement_Name();
					
					if(!"".equals(key) && investigationElement_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("InvestigationElement_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setInvestigationElement_Id(investigationElement_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("autoid".equalsIgnoreCase(fieldName) || "observationElement_ontolo12449.autoid".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("ontologyReference".equalsIgnoreCase(fieldName) || "observationElement_ontolo12449.ontologyReference".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("investigationElement".equalsIgnoreCase(fieldName) || "observationElement_ontolo12449.investigationElement".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, ObservationElement_Ontolo12449 entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.pheno.ObservationElement_Ontolo12449> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.pheno.ObservationElement_Ontolo12449> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<ObservationElement_Ontolo12449> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<ObservationElement_Ontolo12449> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<ObservationElement_Ontolo12449> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
