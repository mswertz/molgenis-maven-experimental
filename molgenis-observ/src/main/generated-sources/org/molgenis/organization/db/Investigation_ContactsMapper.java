/* File:        observ/model/Investigation_contacts.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Template:	MultiqueryMapperGen.java.ftl
 * generator:   org.molgenis.generators.db.MultiqueryMapperGen 4.0.0-testing
 *
 * Using "subclass per table" strategy
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.organization.db;

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
import org.molgenis.organization.Investigation_Contacts;

import org.molgenis.auth.Person;
import org.molgenis.organization.Investigation;

public class Investigation_ContactsMapper extends AbstractJDBCMapper<Investigation_Contacts>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Investigation_Contacts> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Investigation_contacts (contacts,Investigation) VALUES ");
		{
		
			boolean first = true;
			for(Investigation_Contacts e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//contacts
				if(e.getContacts_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getContacts_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//investigation
				if(e.getInvestigation_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getInvestigation_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Investigation_Contacts> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Investigation_contacts (autoid,contacts,Investigation) VALUES ");		
		boolean first = true;
		for(Investigation_Contacts e: entities)
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
		
			//contacts


			if(e.getContacts_Id() != null){
                sql.append("'"+this.escapeSql(e.getContacts_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//investigation


			if(e.getInvestigation_Id() != null){
                sql.append("'"+this.escapeSql(e.getInvestigation_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE autoid=LAST_INSERT_ID(autoid),contacts=VALUES(contacts),Investigation=VALUES(Investigation)");

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
	public int executeRemove(List<? extends Investigation_Contacts> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Investigation_contacts WHERE ");
		
		//key $f_index: autoid
		{
			sql.append("autoid in (");
			boolean first = true;
			for(Investigation_Contacts e: entities)
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
	
	public Investigation_ContactsMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Investigation_contacts.autoid"
			+", Investigation_contacts.contacts"
			+", Investigation_contacts.Investigation"
			//parent is SimpleTree(name='contacts')
			+", xref_contacts.name AS contacts_Name"
			//parent is SimpleTree(name='Investigation')
			+", xref_Investigation.name AS Investigation_Name"
			+" FROM Investigation_contacts "

			
			//label for contacts=name
//path==contacts. type==xref.
//path==contacts_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN MolgenisRole AS xref_contacts " 
			+" ON xref_contacts.id = Investigation_contacts.contacts"
			
			//label for Investigation=name
//path==Investigation. type==xref.
//path==Investigation_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Investigation AS xref_Investigation " 
			+" ON xref_Investigation.id = Investigation_contacts.Investigation"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Investigation_contacts "
			
			//label for contacts=name
//contacts
//contacts_Name
		   	+" LEFT JOIN MolgenisRole AS xref_contacts " 
			+" ON xref_contacts.id = Investigation_contacts.contacts"
			
			//label for Investigation=name
//Investigation
//Investigation_Name
		   	+" LEFT JOIN Investigation AS xref_Investigation " 
			+" ON xref_Investigation.id = Investigation_contacts.Investigation"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("autoid".equalsIgnoreCase(fieldName)) return "Investigation_contacts.autoid";
		if("Investigation_contacts_autoid".equalsIgnoreCase(fieldName)) return "Investigation_contacts.autoid";
		if("contacts".equalsIgnoreCase(fieldName)) return "Investigation_contacts.contacts";
		if("Investigation_contacts_contacts".equalsIgnoreCase(fieldName)) return "Investigation_contacts.contacts";
		if("Investigation".equalsIgnoreCase(fieldName)) return "Investigation_contacts.Investigation";
		if("Investigation_contacts_Investigation".equalsIgnoreCase(fieldName)) return "Investigation_contacts.Investigation";
		if("contacts_id".equalsIgnoreCase(fieldName)) return "Investigation_contacts.contacts";
		if("Investigation_contacts_contacts_id".equalsIgnoreCase(fieldName)) return "Investigation_contacts.contacts";
		if("contacts_Name".equalsIgnoreCase(fieldName)) return "xref_contacts.name";	
		if("Investigation_contacts_contacts_Name".equalsIgnoreCase(fieldName)) return "xref_contacts.name";
		if("Investigation_id".equalsIgnoreCase(fieldName)) return "Investigation_contacts.Investigation";
		if("Investigation_contacts_Investigation_id".equalsIgnoreCase(fieldName)) return "Investigation_contacts.Investigation";
		if("Investigation_Name".equalsIgnoreCase(fieldName)) return "xref_Investigation.name";	
		if("Investigation_contacts_Investigation_Name".equalsIgnoreCase(fieldName)) return "xref_Investigation.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.organization.Investigation_Contacts> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.organization.Investigation_Contacts>(size); 
	}			

	public org.molgenis.organization.Investigation_Contacts create()
	{
		return new org.molgenis.organization.Investigation_Contacts();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.organization.Investigation_Contacts> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'contacts' to person.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> contactsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'investigation' to investigation.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> investigationRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.organization.Investigation_Contacts object: entities)
		{
			//create xref/mref rule filtering Person on the label name
			if(object.getContacts_Id() == null && object.getContacts_Name() != null)
			{
				Object label = object.getContacts_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !contactsRules.containsKey(label))
					{
						contactsRules.put(""+label, xrefFilter);
						contactsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Investigation on the label name
			if(object.getInvestigation_Id() == null && object.getInvestigation_Name() != null)
			{
				Object label = object.getInvestigation_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !investigationRules.containsKey(label))
					{
						investigationRules.put(""+label, xrefFilter);
						investigationRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'contacts' to person.id using name)
		final java.util.Map<String,Integer> contacts_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(contactsRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.auth.Person> contactsList = null;
			try
			{
				contactsList = getDatabase().find(org.molgenis.auth.Person.class, contactsRules.values().toArray(new org.molgenis.framework.db.QueryRule[contactsRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.auth.Person xref :  contactsList)
			{
				String key = "";
				key += 	xref.getName();
				
				contacts_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'investigation' to investigation.id using name)
		final java.util.Map<String,Integer> investigation_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(investigationRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.organization.Investigation> investigationList = null;
			try
			{
				investigationList = getDatabase().find(org.molgenis.organization.Investigation.class, investigationRules.values().toArray(new org.molgenis.framework.db.QueryRule[investigationRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.organization.Investigation xref :  investigationList)
			{
				String key = "";
				key += 	xref.getName();
				
				investigation_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.organization.Investigation_Contacts object = entities.get(i);		
			//update object using label fields name
			if(object.getContacts_Id() == null )
			{
					String key = "";
					if(object.getContacts_Name() != null)
						key += 	object.getContacts_Name();
					
					if(!"".equals(key) && contacts_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("contacts_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setContacts_Id(contacts_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getInvestigation_Id() == null )
			{
					String key = "";
					if(object.getInvestigation_Name() != null)
						key += 	object.getInvestigation_Name();
					
					if(!"".equals(key) && investigation_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Investigation_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setInvestigation_Id(investigation_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("autoid".equalsIgnoreCase(fieldName) || "investigation_contacts.autoid".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("contacts".equalsIgnoreCase(fieldName) || "investigation_contacts.contacts".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("investigation".equalsIgnoreCase(fieldName) || "investigation_contacts.investigation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Investigation_Contacts entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.organization.Investigation_Contacts> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.organization.Investigation_Contacts> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Investigation_Contacts> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Investigation_Contacts> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Investigation_Contacts> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
