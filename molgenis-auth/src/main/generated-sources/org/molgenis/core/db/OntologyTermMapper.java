/* File:        auth/model/OntologyTerm.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
 * Template:	MultiqueryMapperGen.java.ftl
 * generator:   org.molgenis.generators.db.MultiqueryMapperGen 4.0.0-testing
 *
 * Using "subclass per table" strategy
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.core.db;

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
import org.molgenis.core.OntologyTerm;

import org.molgenis.core.Ontology;

public class OntologyTermMapper extends AbstractJDBCMapper<OntologyTerm>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends OntologyTerm> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO OntologyTerm (name,ontology,termAccession,definition,termPath) VALUES ");
		{
		
			boolean first = true;
			for(OntologyTerm e: entities)
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
				//ontology
				if(e.getOntology_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getOntology_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//termAccession
				if(e.getTermAccession() != null){
								
					sql.append("'"+this.escapeSql(e.getTermAccession().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//definition
				if(e.getDefinition() != null){
								
					sql.append("'"+this.escapeSql(e.getDefinition().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//termPath
				if(e.getTermPath() != null){
								
					sql.append("'"+this.escapeSql(e.getTermPath().toString())+"'"
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
	public int executeUpdate(List<? extends OntologyTerm> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO OntologyTerm (id,name,ontology,termAccession,definition,termPath) VALUES ");		
		boolean first = true;
		for(OntologyTerm e: entities)
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
		
			//ontology


			if(e.getOntology_Id() != null){
                sql.append("'"+this.escapeSql(e.getOntology_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//termAccession


			if(e.getTermAccession() != null){
                sql.append("'"+this.escapeSql(e.getTermAccession()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//definition


			if(e.getDefinition() != null){
                sql.append("'"+this.escapeSql(e.getDefinition()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//termPath


			if(e.getTermPath() != null){
                sql.append("'"+this.escapeSql(e.getTermPath()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE ontology=VALUES(ontology),termAccession=VALUES(termAccession),definition=VALUES(definition),termPath=VALUES(termPath),name=VALUES(name),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends OntologyTerm> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM OntologyTerm WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(OntologyTerm e: entities)
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
	
	public OntologyTermMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT OntologyTerm.id"
			+", OntologyTerm.name"
			+", OntologyTerm.ontology"
			+", OntologyTerm.termAccession"
			+", OntologyTerm.definition"
			+", OntologyTerm.termPath"
			//parent is SimpleTree(name='ontology')
			+", xref_ontology.name AS ontology_Name"
			+" FROM OntologyTerm "

			
			//label for ontology=name
//path==ontology. type==xref.
//path==ontology_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Ontology AS xref_ontology " 
			+" ON xref_ontology.id = OntologyTerm.ontology"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM OntologyTerm "
			
			//label for ontology=name
//ontology
//ontology_Name
		   	+" LEFT JOIN Ontology AS xref_ontology " 
			+" ON xref_ontology.id = OntologyTerm.ontology"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "OntologyTerm.id";
		if("OntologyTerm_id".equalsIgnoreCase(fieldName)) return "OntologyTerm.id";
		if("name".equalsIgnoreCase(fieldName)) return "OntologyTerm.name";
		if("OntologyTerm_name".equalsIgnoreCase(fieldName)) return "OntologyTerm.name";
		if("ontology".equalsIgnoreCase(fieldName)) return "OntologyTerm.ontology";
		if("OntologyTerm_ontology".equalsIgnoreCase(fieldName)) return "OntologyTerm.ontology";
		if("termAccession".equalsIgnoreCase(fieldName)) return "OntologyTerm.termAccession";
		if("OntologyTerm_termAccession".equalsIgnoreCase(fieldName)) return "OntologyTerm.termAccession";
		if("definition".equalsIgnoreCase(fieldName)) return "OntologyTerm.definition";
		if("OntologyTerm_definition".equalsIgnoreCase(fieldName)) return "OntologyTerm.definition";
		if("termPath".equalsIgnoreCase(fieldName)) return "OntologyTerm.termPath";
		if("OntologyTerm_termPath".equalsIgnoreCase(fieldName)) return "OntologyTerm.termPath";
		if("ontology_id".equalsIgnoreCase(fieldName)) return "OntologyTerm.ontology";
		if("OntologyTerm_ontology_id".equalsIgnoreCase(fieldName)) return "OntologyTerm.ontology";
		if("ontology_Name".equalsIgnoreCase(fieldName)) return "xref_ontology.name";	
		if("OntologyTerm_ontology_Name".equalsIgnoreCase(fieldName)) return "xref_ontology.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.core.OntologyTerm> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.core.OntologyTerm>(size); 
	}			

	public org.molgenis.core.OntologyTerm create()
	{
		return new org.molgenis.core.OntologyTerm();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.core.OntologyTerm> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'ontology' to ontology.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> ontologyRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.core.OntologyTerm object: entities)
		{
			//create xref/mref rule filtering Ontology on the label name
			if(object.getOntology_Id() == null && object.getOntology_Name() != null)
			{
				Object label = object.getOntology_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !ontologyRules.containsKey(label))
					{
						ontologyRules.put(""+label, xrefFilter);
						ontologyRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'ontology' to ontology.id using name)
		final java.util.Map<String,Integer> ontology_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(ontologyRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.core.Ontology> ontologyList = null;
			try
			{
				ontologyList = getDatabase().find(org.molgenis.core.Ontology.class, ontologyRules.values().toArray(new org.molgenis.framework.db.QueryRule[ontologyRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.core.Ontology xref :  ontologyList)
			{
				String key = "";
				key += 	xref.getName();
				
				ontology_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.core.OntologyTerm object = entities.get(i);		
			//update object using label fields name
			if(object.getOntology_Id() == null )
			{
					String key = "";
					if(object.getOntology_Name() != null)
						key += 	object.getOntology_Name();
					
					if(!"".equals(key) && ontology_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("ontology_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setOntology_Id(ontology_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "ontologyTerm.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("name".equalsIgnoreCase(fieldName) || "ontologyTerm.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("ontology".equalsIgnoreCase(fieldName) || "ontologyTerm.ontology".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("termAccession".equalsIgnoreCase(fieldName) || "ontologyTerm.termAccession".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("definition".equalsIgnoreCase(fieldName) || "ontologyTerm.definition".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("termPath".equalsIgnoreCase(fieldName) || "ontologyTerm.termPath".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, OntologyTerm entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.core.OntologyTerm> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.core.OntologyTerm> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<OntologyTerm> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<OntologyTerm> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<OntologyTerm> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
