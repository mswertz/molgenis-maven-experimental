/* File:        observ/model/Investigation.java
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
import org.molgenis.organization.Investigation;

import org.molgenis.auth.Person;
import org.molgenis.organization.Investigation_Contacts;

public class InvestigationMapper extends AbstractJDBCMapper<Investigation>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Investigation> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Investigation (name,description,startDate,endDate,accession) VALUES ");
		{
		
			boolean first = true;
			for(Investigation e: entities)
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
				//description
				if(e.getDescription() != null){
								
					sql.append("'"+this.escapeSql(e.getDescription().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//startDate
				if(e.getStartDate() != null){
								
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String mysqlDateTime = dateFormat.format(e.getStartDate());
					sql.append("'"+this.escapeSql(mysqlDateTime)+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//endDate
				if(e.getEndDate() != null){
								
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String mysqlDateTime = dateFormat.format(e.getEndDate());
					sql.append("'"+this.escapeSql(mysqlDateTime)+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//accession
				if(e.getAccession() != null){
								
					sql.append("'"+this.escapeSql(e.getAccession().toString())+"'"
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
	public int executeUpdate(List<? extends Investigation> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Investigation (id,name,description,startDate,endDate,accession) VALUES ");		
		boolean first = true;
		for(Investigation e: entities)
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
		
			//description


			if(e.getDescription() != null){
                sql.append("'"+this.escapeSql(e.getDescription()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//startDate


			if(e.getStartDate() != null){
                sql.append("'"+new java.sql.Timestamp(e.getStartDate().getTime()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//endDate


			if(e.getEndDate() != null){
                sql.append("'"+new java.sql.Timestamp(e.getEndDate().getTime()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//accession


			if(e.getAccession() != null){
                sql.append("'"+this.escapeSql(e.getAccession()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE startDate=VALUES(startDate),endDate=VALUES(endDate),accession=VALUES(accession),name=VALUES(name),id=LAST_INSERT_ID(id),description=VALUES(description)");

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
	public int executeRemove(List<? extends Investigation> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Investigation WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Investigation e: entities)
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
	
	public InvestigationMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Investigation.id"
			+", Investigation.name"
			+", Investigation.description"
			+", Investigation.startDate"
			+", Investigation.endDate"
			+", Investigation.accession"
			+" FROM Investigation "

;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Investigation "
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Investigation.id";
		if("Investigation_id".equalsIgnoreCase(fieldName)) return "Investigation.id";
		if("name".equalsIgnoreCase(fieldName)) return "Investigation.name";
		if("Investigation_name".equalsIgnoreCase(fieldName)) return "Investigation.name";
		if("description".equalsIgnoreCase(fieldName)) return "Investigation.description";
		if("Investigation_description".equalsIgnoreCase(fieldName)) return "Investigation.description";
		if("startDate".equalsIgnoreCase(fieldName)) return "Investigation.startDate";
		if("Investigation_startDate".equalsIgnoreCase(fieldName)) return "Investigation.startDate";
		if("endDate".equalsIgnoreCase(fieldName)) return "Investigation.endDate";
		if("Investigation_endDate".equalsIgnoreCase(fieldName)) return "Investigation.endDate";
		if("accession".equalsIgnoreCase(fieldName)) return "Investigation.accession";
		if("Investigation_accession".equalsIgnoreCase(fieldName)) return "Investigation.accession";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.organization.Investigation> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.organization.Investigation>(size); 
	}			

	public org.molgenis.organization.Investigation create()
	{
		return new org.molgenis.organization.Investigation();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.organization.Investigation> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'contacts' to person.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> contactsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.organization.Investigation object: entities)
		{
			//create xref/mref rule filtering Person on the label name
			if(object.getContacts_Id().size() == 0 && object.getContacts_Name().size() > 0)
			{
				for(String label: object.getContacts_Name())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !contactsRules.containsKey(label))
					{
						contactsRules.put(""+label, xrefFilter);
						contactsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
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

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.organization.Investigation object = entities.get(i);		
			//update object using label fields name
			if(object.getContacts_Id() == null || object.getContacts_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getContacts_Name().size(); j++)
				{
					String key = "";
					if(object.getContacts_Name().get(j) != null)
						key += 	object.getContacts_Name().get(j);
					
					if(!"".equals(key) && contacts_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("contacts_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(contacts_Labels_to_IdMap.get(key));
					}
				}
				object.setContacts_Id(idList);
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "investigation.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("name".equalsIgnoreCase(fieldName) || "investigation.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("description".equalsIgnoreCase(fieldName) || "investigation.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("startDate".equalsIgnoreCase(fieldName) || "investigation.startDate".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DatetimeField();
			if("endDate".equalsIgnoreCase(fieldName) || "investigation.endDate".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DatetimeField();
			if("accession".equalsIgnoreCase(fieldName) || "investigation.accession".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.HyperlinkField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Investigation entity)
	{
		entity.setId(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		if("contacts".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Investigation_contacts
			List<Investigation_Contacts> mref_mapping_entities = db.find(Investigation_Contacts.class, new QueryRule(
					"contacts", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Investigation_Contacts mref : mref_mapping_entities) mref_ids.add(mref.getInvestigation_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("contacts_name".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Investigation_contacts
			List<Investigation_Contacts> mref_mapping_entities = db.find(Investigation_Contacts.class, new QueryRule(
					"contacts_name", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Investigation_Contacts mref : mref_mapping_entities) mref_ids.add(mref.getInvestigation_Id());
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
	public void prepareFileAttachements(java.util.List<org.molgenis.organization.Investigation> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.organization.Investigation> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Investigation> entities ) throws DatabaseException			
	{
		try
		{
			//list the investigation ids to query
			List<Integer> investigationIds = new ArrayList<Integer>();
			for(Investigation entity: entities)
			{
				investigationIds.add(entity.getId());
			}
			
			//map the contacts mrefs
			List<Investigation_Contacts> contacts_mrefs = this.getDatabase().query(Investigation_Contacts.class).in("Investigation", investigationIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> contacts_contacts_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> contacts_name_map = new LinkedHashMap<Integer,List<String>>();
			
			for(Investigation_Contacts ref: contacts_mrefs)
			{
				if(contacts_contacts_map.get(ref.getInvestigation_Id()) == null) contacts_contacts_map.put(ref.getInvestigation_Id(),new ArrayList<Integer>()); 
				contacts_contacts_map.get(ref.getInvestigation_Id()).add(ref.getContacts_Id());
				if(contacts_name_map.get(ref.getInvestigation_Id()) == null)	contacts_name_map.put(ref.getInvestigation_Id(),new ArrayList<String>());
				contacts_name_map.get(ref.getInvestigation_Id()).add(ref.getContacts_Name());
			}
			
			//load the mapped data into the entities
			for(Investigation entity: entities)
			{
				Integer id = entity.getId();
				if(contacts_contacts_map.get(id) != null)
				{
					entity.setContacts_Id(contacts_contacts_map.get(id));
				}
				if(contacts_name_map.get(id) != null)
				{
					entity.setContacts_Name(contacts_name_map.get(id));
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
	public void storeMrefs( List<Investigation> entities ) throws DatabaseException, IOException, ParseException	
	{
		//create an List of Investigation ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Investigation entity : entities) 
		{
			entityIds.add(entity.getId());		
		}
		
		//delete existing mrefs
		getDatabase().remove(getDatabase().query( Investigation_Contacts.class).in("Investigation", entityIds).find());
		List<Investigation_Contacts> investigation_contactsToAdd = new ArrayList<Investigation_Contacts>();


		//check for each mref what needs to be added
		for(Investigation entity: entities)
		{
			//remove duplicates using Set
			entity.setContacts(new ArrayList(new LinkedHashSet(entity.getContacts_Id())));
			for(Integer id: entity.getContacts_Id())
			{
				Investigation_Contacts new_mref = new Investigation_Contacts();
				new_mref.setInvestigation( entity.getId() );
				new_mref.setContacts( id );
				investigation_contactsToAdd.add(new_mref);
			}
			
		}
		
		//process changes to Investigation_contacts
		getDatabase().add( investigation_contactsToAdd );
	}
		
	
	public void removeMrefs( List<Investigation> entities ) throws DatabaseException, IOException, ParseException
	{
		//create an list of Investigation ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Investigation entity : entities) 
		{
			entityIds.add(entity.getId());		
		}	
	
		//remove all Investigation_contacts elements for field entity.contacts
		getDatabase().remove( getDatabase().query( Investigation_Contacts.class).in("Investigation", entityIds).find() );
	}	
}
