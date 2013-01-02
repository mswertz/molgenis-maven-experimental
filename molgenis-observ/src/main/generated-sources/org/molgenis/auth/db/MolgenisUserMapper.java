/* File:        observ/model/MolgenisUser.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Template:	MultiqueryMapperGen.java.ftl
 * generator:   org.molgenis.generators.db.MultiqueryMapperGen 4.0.0-testing
 *
 * Using "subclass per table" strategy
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.auth.db;

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
import org.molgenis.auth.MolgenisUser;

import org.molgenis.auth.Person;
import org.molgenis.auth.db.PersonMapper;
import org.molgenis.auth.Institute;
import org.molgenis.core.OntologyTerm;

public class MolgenisUserMapper extends AbstractJDBCMapper<MolgenisUser>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends MolgenisUser> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.auth.Person.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO MolgenisUser (password_,activationCode,active,superuser,id) VALUES ");
		{
		
			boolean first = true;
			for(MolgenisUser e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//password_
				if(e.getPassword() != null){
								
					sql.append("'"+this.escapeSql(e.getPassword().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//activationCode
				if(e.getActivationCode() != null){
								
					sql.append("'"+this.escapeSql(e.getActivationCode().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//active
				if(e.getActive() != null){
								
					sql.append(e.getActive()
				+",");
				}
				else{
					sql.append("null,");
				}
				//superuser
				if(e.getSuperuser() != null){
								
					sql.append(e.getSuperuser()
				+",");
				}
				else{
					sql.append("null,");
				}
				//id
				if(e.getId() != null){
								
					sql.append("'"+this.escapeSql(e.getId().toString())+"'"
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
	public int executeUpdate(List<? extends MolgenisUser> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.auth.Person.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO MolgenisUser (password_,activationCode,active,superuser,id) VALUES ");		
		boolean first = true;
		for(MolgenisUser e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//password_


			if(e.getPassword() != null){
                sql.append("'"+this.escapeSql(e.getPassword()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//activationCode


			if(e.getActivationCode() != null){
                sql.append("'"+this.escapeSql(e.getActivationCode()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//active


			if(e.getActive() != null){
                sql.append(e.getActive() +",");
			} else {
				sql.append("null,");
            }
		
			//superuser


			if(e.getSuperuser() != null){
                sql.append(e.getSuperuser() +",");
			} else {
				sql.append("null,");
            }
		
			//id


			if(e.getId() != null){
                sql.append("'"+this.escapeSql(e.getId()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE password_=VALUES(password_),activationCode=VALUES(activationCode),active=VALUES(active),superuser=VALUES(superuser),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends MolgenisUser> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM MolgenisUser WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(MolgenisUser e: entities)
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
		//remove superclass after
		this.getDatabase().getMapperFor(org.molgenis.auth.Person.class).executeRemove(entities);
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public MolgenisUserMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT MolgenisUser.id"
			+", MolgenisRole.__Type"
			+", MolgenisRole.name"
			+", Person.Address"
			+", Person.Phone"
			+", Person.Email"
			+", Person.Fax"
			+", Person.tollFreePhone"
			+", Person.City"
			+", Person.Country"
			+", Person.FirstName"
			+", Person.MidInitials"
			+", Person.LastName"
			+", Person.Title"
			+", Person.Affiliation"
			+", Person.Department"
			+", Person.Roles"
			+", MolgenisUser.password_"
			+", MolgenisUser.activationCode"
			+", MolgenisUser.active"
			+", MolgenisUser.superuser"
			//parent is SimpleTree(name='Affiliation')
			+", xref_Affiliation.name AS Affiliation_Name"
			//parent is SimpleTree(name='Roles')
			+", xref_Roles.name AS Roles_Name"
			+" FROM MolgenisUser "
			+" INNER JOIN Person ON (MolgenisUser.id = Person.id)"
			+" INNER JOIN MolgenisRole ON (MolgenisUser.id = MolgenisRole.id)"

			
			//label for Affiliation=name
//path==Affiliation. type==xref.
//path==Affiliation_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Institute AS xref_Affiliation " 
			+" ON xref_Affiliation.id = Person.Affiliation"
			
			//label for Roles=name
//path==Roles. type==xref.
//path==Roles_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_Roles " 
			+" ON xref_Roles.id = Person.Roles"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM MolgenisUser "
			  +" INNER JOIN Person ON (MolgenisUser.id = Person.id)"
			  +" INNER JOIN MolgenisRole ON (MolgenisUser.id = MolgenisRole.id)"
			
			//label for Affiliation=name
//Affiliation
//Affiliation_Name
		   	+" LEFT JOIN Institute AS xref_Affiliation " 
			+" ON xref_Affiliation.id = Person.Affiliation"
			
			//label for Roles=name
//Roles
//Roles_Name
		   	+" LEFT JOIN OntologyTerm AS xref_Roles " 
			+" ON xref_Roles.id = Person.Roles"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "MolgenisUser.id";
		if("MolgenisUser_id".equalsIgnoreCase(fieldName)) return "MolgenisUser.id";
		if("__Type".equalsIgnoreCase(fieldName)) return "MolgenisRole.__Type";
		if("MolgenisUser___Type".equalsIgnoreCase(fieldName)) return "MolgenisRole.__Type";
		if("name".equalsIgnoreCase(fieldName)) return "MolgenisRole.name";
		if("MolgenisUser_name".equalsIgnoreCase(fieldName)) return "MolgenisRole.name";
		if("Address".equalsIgnoreCase(fieldName)) return "Person.Address";
		if("MolgenisUser_Address".equalsIgnoreCase(fieldName)) return "Person.Address";
		if("Phone".equalsIgnoreCase(fieldName)) return "Person.Phone";
		if("MolgenisUser_Phone".equalsIgnoreCase(fieldName)) return "Person.Phone";
		if("Email".equalsIgnoreCase(fieldName)) return "Person.Email";
		if("MolgenisUser_Email".equalsIgnoreCase(fieldName)) return "Person.Email";
		if("Fax".equalsIgnoreCase(fieldName)) return "Person.Fax";
		if("MolgenisUser_Fax".equalsIgnoreCase(fieldName)) return "Person.Fax";
		if("tollFreePhone".equalsIgnoreCase(fieldName)) return "Person.tollFreePhone";
		if("MolgenisUser_tollFreePhone".equalsIgnoreCase(fieldName)) return "Person.tollFreePhone";
		if("City".equalsIgnoreCase(fieldName)) return "Person.City";
		if("MolgenisUser_City".equalsIgnoreCase(fieldName)) return "Person.City";
		if("Country".equalsIgnoreCase(fieldName)) return "Person.Country";
		if("MolgenisUser_Country".equalsIgnoreCase(fieldName)) return "Person.Country";
		if("FirstName".equalsIgnoreCase(fieldName)) return "Person.FirstName";
		if("MolgenisUser_FirstName".equalsIgnoreCase(fieldName)) return "Person.FirstName";
		if("MidInitials".equalsIgnoreCase(fieldName)) return "Person.MidInitials";
		if("MolgenisUser_MidInitials".equalsIgnoreCase(fieldName)) return "Person.MidInitials";
		if("LastName".equalsIgnoreCase(fieldName)) return "Person.LastName";
		if("MolgenisUser_LastName".equalsIgnoreCase(fieldName)) return "Person.LastName";
		if("Title".equalsIgnoreCase(fieldName)) return "Person.Title";
		if("MolgenisUser_Title".equalsIgnoreCase(fieldName)) return "Person.Title";
		if("Affiliation".equalsIgnoreCase(fieldName)) return "Person.Affiliation";
		if("MolgenisUser_Affiliation".equalsIgnoreCase(fieldName)) return "Person.Affiliation";
		if("Department".equalsIgnoreCase(fieldName)) return "Person.Department";
		if("MolgenisUser_Department".equalsIgnoreCase(fieldName)) return "Person.Department";
		if("Roles".equalsIgnoreCase(fieldName)) return "Person.Roles";
		if("MolgenisUser_Roles".equalsIgnoreCase(fieldName)) return "Person.Roles";
		if("password_".equalsIgnoreCase(fieldName)) return "MolgenisUser.password_";
		if("MolgenisUser_password_".equalsIgnoreCase(fieldName)) return "MolgenisUser.password_";
		if("activationCode".equalsIgnoreCase(fieldName)) return "MolgenisUser.activationCode";
		if("MolgenisUser_activationCode".equalsIgnoreCase(fieldName)) return "MolgenisUser.activationCode";
		if("active".equalsIgnoreCase(fieldName)) return "MolgenisUser.active";
		if("MolgenisUser_active".equalsIgnoreCase(fieldName)) return "MolgenisUser.active";
		if("superuser".equalsIgnoreCase(fieldName)) return "MolgenisUser.superuser";
		if("MolgenisUser_superuser".equalsIgnoreCase(fieldName)) return "MolgenisUser.superuser";
		if("Affiliation_id".equalsIgnoreCase(fieldName)) return "Person.Affiliation";
		if("MolgenisUser_Affiliation_id".equalsIgnoreCase(fieldName)) return "Person.Affiliation";
		if("Affiliation_Name".equalsIgnoreCase(fieldName)) return "xref_Affiliation.name";	
		if("MolgenisUser_Affiliation_Name".equalsIgnoreCase(fieldName)) return "xref_Affiliation.name";
		if("Roles_id".equalsIgnoreCase(fieldName)) return "Person.Roles";
		if("MolgenisUser_Roles_id".equalsIgnoreCase(fieldName)) return "Person.Roles";
		if("Roles_Name".equalsIgnoreCase(fieldName)) return "xref_Roles.name";	
		if("MolgenisUser_Roles_Name".equalsIgnoreCase(fieldName)) return "xref_Roles.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.auth.MolgenisUser> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.auth.MolgenisUser>(size); 
	}			

	public org.molgenis.auth.MolgenisUser create()
	{
		return new org.molgenis.auth.MolgenisUser();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.auth.MolgenisUser> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'affiliation' to institute.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> affiliationRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'roles' to ontologyTerm.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> rolesRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.auth.MolgenisUser object: entities)
		{
			//create xref/mref rule filtering Institute on the label name
			if(object.getAffiliation_Id() == null && object.getAffiliation_Name() != null)
			{
				Object label = object.getAffiliation_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !affiliationRules.containsKey(label))
					{
						affiliationRules.put(""+label, xrefFilter);
						affiliationRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering OntologyTerm on the label name
			if(object.getRoles_Id() == null && object.getRoles_Name() != null)
			{
				Object label = object.getRoles_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !rolesRules.containsKey(label))
					{
						rolesRules.put(""+label, xrefFilter);
						rolesRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
		}

		//resolve foreign key field 'affiliation' to institute.id using name)
		final java.util.Map<String,Integer> affiliation_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(affiliationRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.auth.Institute> affiliationList = null;
			try
			{
				affiliationList = getDatabase().find(org.molgenis.auth.Institute.class, affiliationRules.values().toArray(new org.molgenis.framework.db.QueryRule[affiliationRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.auth.Institute xref :  affiliationList)
			{
				String key = "";
				key += 	xref.getName();
				
				affiliation_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'roles' to ontologyTerm.id using name)
		final java.util.Map<String,Integer> roles_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(rolesRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.core.OntologyTerm> rolesList = null;
			try
			{
				rolesList = getDatabase().find(org.molgenis.core.OntologyTerm.class, rolesRules.values().toArray(new org.molgenis.framework.db.QueryRule[rolesRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.core.OntologyTerm xref :  rolesList)
			{
				String key = "";
				key += 	xref.getName();
				
				roles_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.auth.MolgenisUser object = entities.get(i);		
			//update object using label fields name
			if(object.getAffiliation_Id() == null )
			{
					String key = "";
					if(object.getAffiliation_Name() != null)
						key += 	object.getAffiliation_Name();
					
					if(!"".equals(key) && affiliation_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Affiliation_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setAffiliation_Id(affiliation_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getRoles_Id() == null )
			{
					String key = "";
					if(object.getRoles_Name() != null)
						key += 	object.getRoles_Name();
					
					if(!"".equals(key) && roles_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Roles_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setRoles_Id(roles_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "molgenisUser.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("__Type".equalsIgnoreCase(fieldName) || "molgenisRole.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("name".equalsIgnoreCase(fieldName) || "molgenisRole.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("address".equalsIgnoreCase(fieldName) || "person.address".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("phone".equalsIgnoreCase(fieldName) || "person.phone".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("email".equalsIgnoreCase(fieldName) || "person.email".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("fax".equalsIgnoreCase(fieldName) || "person.fax".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("tollFreePhone".equalsIgnoreCase(fieldName) || "person.tollFreePhone".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("city".equalsIgnoreCase(fieldName) || "person.city".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("country".equalsIgnoreCase(fieldName) || "person.country".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("firstName".equalsIgnoreCase(fieldName) || "person.firstName".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("midInitials".equalsIgnoreCase(fieldName) || "person.midInitials".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("lastName".equalsIgnoreCase(fieldName) || "person.lastName".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("title".equalsIgnoreCase(fieldName) || "person.title".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("affiliation".equalsIgnoreCase(fieldName) || "person.affiliation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("department".equalsIgnoreCase(fieldName) || "person.department".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("roles".equalsIgnoreCase(fieldName) || "person.roles".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("password_".equalsIgnoreCase(fieldName) || "molgenisUser.password_".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("activationCode".equalsIgnoreCase(fieldName) || "molgenisUser.activationCode".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("active".equalsIgnoreCase(fieldName) || "molgenisUser.active".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.BoolField();
			if("superuser".equalsIgnoreCase(fieldName) || "molgenisUser.superuser".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.BoolField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, MolgenisUser entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.auth.MolgenisUser> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.auth.MolgenisUser> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<MolgenisUser> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<MolgenisUser> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<MolgenisUser> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
