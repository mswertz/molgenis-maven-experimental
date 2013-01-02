/* File:        auth/model/Publication.java
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
import org.molgenis.core.Publication;

import org.molgenis.core.OntologyTerm;
import org.molgenis.core.OntologyTerm;
import org.molgenis.core.OntologyTerm;

public class PublicationMapper extends AbstractJDBCMapper<Publication>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Publication> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Publication (name,PubmedID,DOI,authorList,Title,Status,Year,Journal) VALUES ");
		{
		
			boolean first = true;
			for(Publication e: entities)
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
				//pubmedID
				if(e.getPubmedID_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getPubmedID_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//dOI
				if(e.getDOI_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getDOI_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//authorList
				if(e.getAuthorList() != null){
								
					sql.append("'"+this.escapeSql(e.getAuthorList().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//title
				if(e.getTitle() != null){
								
					sql.append("'"+this.escapeSql(e.getTitle().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//status
				if(e.getStatus_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getStatus_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//year
				if(e.getYear() != null){
								
					sql.append("'"+this.escapeSql(e.getYear().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//journal
				if(e.getJournal() != null){
								
					sql.append("'"+this.escapeSql(e.getJournal().toString())+"'"
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
	public int executeUpdate(List<? extends Publication> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Publication (id,name,PubmedID,DOI,authorList,Title,Status,Year,Journal) VALUES ");		
		boolean first = true;
		for(Publication e: entities)
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
		
			//pubmedID


			if(e.getPubmedID_Id() != null){
                sql.append("'"+this.escapeSql(e.getPubmedID_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//dOI


			if(e.getDOI_Id() != null){
                sql.append("'"+this.escapeSql(e.getDOI_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//authorList


			if(e.getAuthorList() != null){
                sql.append("'"+this.escapeSql(e.getAuthorList()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//title


			if(e.getTitle() != null){
                sql.append("'"+this.escapeSql(e.getTitle()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//status


			if(e.getStatus_Id() != null){
                sql.append("'"+this.escapeSql(e.getStatus_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//year


			if(e.getYear() != null){
                sql.append("'"+this.escapeSql(e.getYear()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//journal


			if(e.getJournal() != null){
                sql.append("'"+this.escapeSql(e.getJournal()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE PubmedID=VALUES(PubmedID),DOI=VALUES(DOI),authorList=VALUES(authorList),Title=VALUES(Title),Status=VALUES(Status),Year=VALUES(Year),Journal=VALUES(Journal),name=VALUES(name),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Publication> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Publication WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Publication e: entities)
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
	
	public PublicationMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Publication.id"
			+", Publication.name"
			+", Publication.PubmedID"
			+", Publication.DOI"
			+", Publication.authorList"
			+", Publication.Title"
			+", Publication.Status"
			+", Publication.Year"
			+", Publication.Journal"
			//parent is SimpleTree(name='PubmedID')
			+", xref_PubmedID.name AS PubmedID_Name"
			//parent is SimpleTree(name='DOI')
			+", xref_DOI.name AS DOI_Name"
			//parent is SimpleTree(name='Status')
			+", xref_Status.name AS Status_Name"
			+" FROM Publication "

			
			//label for PubmedID=name
//path==PubmedID. type==xref.
//path==PubmedID_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_PubmedID " 
			+" ON xref_PubmedID.id = Publication.PubmedID"
			
			//label for DOI=name
//path==DOI. type==xref.
//path==DOI_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_DOI " 
			+" ON xref_DOI.id = Publication.DOI"
			
			//label for Status=name
//path==Status. type==xref.
//path==Status_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_Status " 
			+" ON xref_Status.id = Publication.Status"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Publication "
			
			//label for PubmedID=name
//PubmedID
//PubmedID_Name
		   	+" LEFT JOIN OntologyTerm AS xref_PubmedID " 
			+" ON xref_PubmedID.id = Publication.PubmedID"
			
			//label for DOI=name
//DOI
//DOI_Name
		   	+" LEFT JOIN OntologyTerm AS xref_DOI " 
			+" ON xref_DOI.id = Publication.DOI"
			
			//label for Status=name
//Status
//Status_Name
		   	+" LEFT JOIN OntologyTerm AS xref_Status " 
			+" ON xref_Status.id = Publication.Status"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Publication.id";
		if("Publication_id".equalsIgnoreCase(fieldName)) return "Publication.id";
		if("name".equalsIgnoreCase(fieldName)) return "Publication.name";
		if("Publication_name".equalsIgnoreCase(fieldName)) return "Publication.name";
		if("PubmedID".equalsIgnoreCase(fieldName)) return "Publication.PubmedID";
		if("Publication_PubmedID".equalsIgnoreCase(fieldName)) return "Publication.PubmedID";
		if("DOI".equalsIgnoreCase(fieldName)) return "Publication.DOI";
		if("Publication_DOI".equalsIgnoreCase(fieldName)) return "Publication.DOI";
		if("authorList".equalsIgnoreCase(fieldName)) return "Publication.authorList";
		if("Publication_authorList".equalsIgnoreCase(fieldName)) return "Publication.authorList";
		if("Title".equalsIgnoreCase(fieldName)) return "Publication.Title";
		if("Publication_Title".equalsIgnoreCase(fieldName)) return "Publication.Title";
		if("Status".equalsIgnoreCase(fieldName)) return "Publication.Status";
		if("Publication_Status".equalsIgnoreCase(fieldName)) return "Publication.Status";
		if("Year".equalsIgnoreCase(fieldName)) return "Publication.Year";
		if("Publication_Year".equalsIgnoreCase(fieldName)) return "Publication.Year";
		if("Journal".equalsIgnoreCase(fieldName)) return "Publication.Journal";
		if("Publication_Journal".equalsIgnoreCase(fieldName)) return "Publication.Journal";
		if("PubmedID_id".equalsIgnoreCase(fieldName)) return "Publication.PubmedID";
		if("Publication_PubmedID_id".equalsIgnoreCase(fieldName)) return "Publication.PubmedID";
		if("PubmedID_Name".equalsIgnoreCase(fieldName)) return "xref_PubmedID.name";	
		if("Publication_PubmedID_Name".equalsIgnoreCase(fieldName)) return "xref_PubmedID.name";
		if("DOI_id".equalsIgnoreCase(fieldName)) return "Publication.DOI";
		if("Publication_DOI_id".equalsIgnoreCase(fieldName)) return "Publication.DOI";
		if("DOI_Name".equalsIgnoreCase(fieldName)) return "xref_DOI.name";	
		if("Publication_DOI_Name".equalsIgnoreCase(fieldName)) return "xref_DOI.name";
		if("Status_id".equalsIgnoreCase(fieldName)) return "Publication.Status";
		if("Publication_Status_id".equalsIgnoreCase(fieldName)) return "Publication.Status";
		if("Status_Name".equalsIgnoreCase(fieldName)) return "xref_Status.name";	
		if("Publication_Status_Name".equalsIgnoreCase(fieldName)) return "xref_Status.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.core.Publication> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.core.Publication>(size); 
	}			

	public org.molgenis.core.Publication create()
	{
		return new org.molgenis.core.Publication();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.core.Publication> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'pubmedID' to ontologyTerm.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> pubmedIDRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'dOI' to ontologyTerm.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> dOIRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'status' to ontologyTerm.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> statusRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.core.Publication object: entities)
		{
			//create xref/mref rule filtering OntologyTerm on the label name
			if(object.getPubmedID_Id() == null && object.getPubmedID_Name() != null)
			{
				Object label = object.getPubmedID_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !pubmedIDRules.containsKey(label))
					{
						pubmedIDRules.put(""+label, xrefFilter);
						pubmedIDRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering OntologyTerm on the label name
			if(object.getDOI_Id() == null && object.getDOI_Name() != null)
			{
				Object label = object.getDOI_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !dOIRules.containsKey(label))
					{
						dOIRules.put(""+label, xrefFilter);
						dOIRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering OntologyTerm on the label name
			if(object.getStatus_Id() == null && object.getStatus_Name() != null)
			{
				Object label = object.getStatus_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !statusRules.containsKey(label))
					{
						statusRules.put(""+label, xrefFilter);
						statusRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'pubmedID' to ontologyTerm.id using name)
		final java.util.Map<String,Integer> pubmedID_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(pubmedIDRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.core.OntologyTerm> pubmedIDList = null;
			try
			{
				pubmedIDList = getDatabase().find(org.molgenis.core.OntologyTerm.class, pubmedIDRules.values().toArray(new org.molgenis.framework.db.QueryRule[pubmedIDRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.core.OntologyTerm xref :  pubmedIDList)
			{
				String key = "";
				key += 	xref.getName();
				
				pubmedID_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'dOI' to ontologyTerm.id using name)
		final java.util.Map<String,Integer> dOI_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(dOIRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.core.OntologyTerm> dOIList = null;
			try
			{
				dOIList = getDatabase().find(org.molgenis.core.OntologyTerm.class, dOIRules.values().toArray(new org.molgenis.framework.db.QueryRule[dOIRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.core.OntologyTerm xref :  dOIList)
			{
				String key = "";
				key += 	xref.getName();
				
				dOI_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'status' to ontologyTerm.id using name)
		final java.util.Map<String,Integer> status_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(statusRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.core.OntologyTerm> statusList = null;
			try
			{
				statusList = getDatabase().find(org.molgenis.core.OntologyTerm.class, statusRules.values().toArray(new org.molgenis.framework.db.QueryRule[statusRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.core.OntologyTerm xref :  statusList)
			{
				String key = "";
				key += 	xref.getName();
				
				status_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.core.Publication object = entities.get(i);		
			//update object using label fields name
			if(object.getPubmedID_Id() == null )
			{
					String key = "";
					if(object.getPubmedID_Name() != null)
						key += 	object.getPubmedID_Name();
					
					if(!"".equals(key) && pubmedID_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("PubmedID_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setPubmedID_Id(pubmedID_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getDOI_Id() == null )
			{
					String key = "";
					if(object.getDOI_Name() != null)
						key += 	object.getDOI_Name();
					
					if(!"".equals(key) && dOI_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("DOI_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setDOI_Id(dOI_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getStatus_Id() == null )
			{
					String key = "";
					if(object.getStatus_Name() != null)
						key += 	object.getStatus_Name();
					
					if(!"".equals(key) && status_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Status_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setStatus_Id(status_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "publication.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("name".equalsIgnoreCase(fieldName) || "publication.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("pubmedID".equalsIgnoreCase(fieldName) || "publication.pubmedID".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("dOI".equalsIgnoreCase(fieldName) || "publication.dOI".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("authorList".equalsIgnoreCase(fieldName) || "publication.authorList".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("title".equalsIgnoreCase(fieldName) || "publication.title".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("status".equalsIgnoreCase(fieldName) || "publication.status".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("year".equalsIgnoreCase(fieldName) || "publication.year".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("journal".equalsIgnoreCase(fieldName) || "publication.journal".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Publication entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.core.Publication> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.core.Publication> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Publication> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Publication> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Publication> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
