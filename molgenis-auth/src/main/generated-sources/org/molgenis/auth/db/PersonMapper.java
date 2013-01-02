/* File:        auth/model/Person.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
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
import org.molgenis.auth.Person;

import org.molgenis.auth.MolgenisRole;
import org.molgenis.auth.db.MolgenisRoleMapper;
import org.molgenis.auth.Institute;
import org.molgenis.core.OntologyTerm;

public class PersonMapper extends AbstractJDBCMapper<Person>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Person> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.auth.MolgenisRole.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Person (id,Address,Phone,Email,Fax,tollFreePhone,City,Country,FirstName,MidInitials,LastName,Title,Affiliation,Department,Roles) VALUES ");
		{
		
			boolean first = true;
			for(Person e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//id
				if(e.getId() != null){
								
					sql.append("'"+this.escapeSql(e.getId().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//address
				if(e.getAddress() != null){
								
					sql.append("'"+this.escapeSql(e.getAddress().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//phone
				if(e.getPhone() != null){
								
					sql.append("'"+this.escapeSql(e.getPhone().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//email
				if(e.getEmail() != null){
								
					sql.append("'"+this.escapeSql(e.getEmail().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//fax
				if(e.getFax() != null){
								
					sql.append("'"+this.escapeSql(e.getFax().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//tollFreePhone
				if(e.getTollFreePhone() != null){
								
					sql.append("'"+this.escapeSql(e.getTollFreePhone().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//city
				if(e.getCity() != null){
								
					sql.append("'"+this.escapeSql(e.getCity().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//country
				if(e.getCountry() != null){
								
					sql.append("'"+this.escapeSql(e.getCountry().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//firstName
				if(e.getFirstName() != null){
								
					sql.append("'"+this.escapeSql(e.getFirstName().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//midInitials
				if(e.getMidInitials() != null){
								
					sql.append("'"+this.escapeSql(e.getMidInitials().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//lastName
				if(e.getLastName() != null){
								
					sql.append("'"+this.escapeSql(e.getLastName().toString())+"'"
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
				//affiliation
				if(e.getAffiliation_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getAffiliation_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//department
				if(e.getDepartment() != null){
								
					sql.append("'"+this.escapeSql(e.getDepartment().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//roles
				if(e.getRoles_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getRoles_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Person> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.auth.MolgenisRole.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Person (id,Address,Phone,Email,Fax,tollFreePhone,City,Country,FirstName,MidInitials,LastName,Title,Affiliation,Department,Roles) VALUES ");		
		boolean first = true;
		for(Person e: entities)
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
		
			//address


			if(e.getAddress() != null){
                sql.append("'"+this.escapeSql(e.getAddress()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//phone


			if(e.getPhone() != null){
                sql.append("'"+this.escapeSql(e.getPhone()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//email


			if(e.getEmail() != null){
                sql.append("'"+this.escapeSql(e.getEmail()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//fax


			if(e.getFax() != null){
                sql.append("'"+this.escapeSql(e.getFax()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//tollFreePhone


			if(e.getTollFreePhone() != null){
                sql.append("'"+this.escapeSql(e.getTollFreePhone()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//city


			if(e.getCity() != null){
                sql.append("'"+this.escapeSql(e.getCity()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//country


			if(e.getCountry() != null){
                sql.append("'"+this.escapeSql(e.getCountry()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//firstName


			if(e.getFirstName() != null){
                sql.append("'"+this.escapeSql(e.getFirstName()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//midInitials


			if(e.getMidInitials() != null){
                sql.append("'"+this.escapeSql(e.getMidInitials()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//lastName


			if(e.getLastName() != null){
                sql.append("'"+this.escapeSql(e.getLastName()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//title


			if(e.getTitle() != null){
                sql.append("'"+this.escapeSql(e.getTitle()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//affiliation


			if(e.getAffiliation_Id() != null){
                sql.append("'"+this.escapeSql(e.getAffiliation_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//department


			if(e.getDepartment() != null){
                sql.append("'"+this.escapeSql(e.getDepartment()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//roles


			if(e.getRoles_Id() != null){
                sql.append("'"+this.escapeSql(e.getRoles_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE FirstName=VALUES(FirstName),MidInitials=VALUES(MidInitials),LastName=VALUES(LastName),Title=VALUES(Title),Affiliation=VALUES(Affiliation),Department=VALUES(Department),Roles=VALUES(Roles),Address=VALUES(Address),Phone=VALUES(Phone),Email=VALUES(Email),Fax=VALUES(Fax),tollFreePhone=VALUES(tollFreePhone),City=VALUES(City),Country=VALUES(Country),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Person> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Person WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Person e: entities)
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
		this.getDatabase().getMapperFor(org.molgenis.auth.MolgenisRole.class).executeRemove(entities);
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public PersonMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Person.id"
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
			//parent is SimpleTree(name='Affiliation')
			+", xref_Affiliation.name AS Affiliation_Name"
			//parent is SimpleTree(name='Roles')
			+", xref_Roles.name AS Roles_Name"
			+" FROM Person "
			+" INNER JOIN MolgenisRole ON (Person.id = MolgenisRole.id)"

			
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
			  +" FROM Person "
			  +" INNER JOIN MolgenisRole ON (Person.id = MolgenisRole.id)"
			
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
		if("id".equalsIgnoreCase(fieldName)) return "Person.id";
		if("Person_id".equalsIgnoreCase(fieldName)) return "Person.id";
		if("__Type".equalsIgnoreCase(fieldName)) return "MolgenisRole.__Type";
		if("Person___Type".equalsIgnoreCase(fieldName)) return "MolgenisRole.__Type";
		if("name".equalsIgnoreCase(fieldName)) return "MolgenisRole.name";
		if("Person_name".equalsIgnoreCase(fieldName)) return "MolgenisRole.name";
		if("Address".equalsIgnoreCase(fieldName)) return "Person.Address";
		if("Person_Address".equalsIgnoreCase(fieldName)) return "Person.Address";
		if("Phone".equalsIgnoreCase(fieldName)) return "Person.Phone";
		if("Person_Phone".equalsIgnoreCase(fieldName)) return "Person.Phone";
		if("Email".equalsIgnoreCase(fieldName)) return "Person.Email";
		if("Person_Email".equalsIgnoreCase(fieldName)) return "Person.Email";
		if("Fax".equalsIgnoreCase(fieldName)) return "Person.Fax";
		if("Person_Fax".equalsIgnoreCase(fieldName)) return "Person.Fax";
		if("tollFreePhone".equalsIgnoreCase(fieldName)) return "Person.tollFreePhone";
		if("Person_tollFreePhone".equalsIgnoreCase(fieldName)) return "Person.tollFreePhone";
		if("City".equalsIgnoreCase(fieldName)) return "Person.City";
		if("Person_City".equalsIgnoreCase(fieldName)) return "Person.City";
		if("Country".equalsIgnoreCase(fieldName)) return "Person.Country";
		if("Person_Country".equalsIgnoreCase(fieldName)) return "Person.Country";
		if("FirstName".equalsIgnoreCase(fieldName)) return "Person.FirstName";
		if("Person_FirstName".equalsIgnoreCase(fieldName)) return "Person.FirstName";
		if("MidInitials".equalsIgnoreCase(fieldName)) return "Person.MidInitials";
		if("Person_MidInitials".equalsIgnoreCase(fieldName)) return "Person.MidInitials";
		if("LastName".equalsIgnoreCase(fieldName)) return "Person.LastName";
		if("Person_LastName".equalsIgnoreCase(fieldName)) return "Person.LastName";
		if("Title".equalsIgnoreCase(fieldName)) return "Person.Title";
		if("Person_Title".equalsIgnoreCase(fieldName)) return "Person.Title";
		if("Affiliation".equalsIgnoreCase(fieldName)) return "Person.Affiliation";
		if("Person_Affiliation".equalsIgnoreCase(fieldName)) return "Person.Affiliation";
		if("Department".equalsIgnoreCase(fieldName)) return "Person.Department";
		if("Person_Department".equalsIgnoreCase(fieldName)) return "Person.Department";
		if("Roles".equalsIgnoreCase(fieldName)) return "Person.Roles";
		if("Person_Roles".equalsIgnoreCase(fieldName)) return "Person.Roles";
		if("Affiliation_id".equalsIgnoreCase(fieldName)) return "Person.Affiliation";
		if("Person_Affiliation_id".equalsIgnoreCase(fieldName)) return "Person.Affiliation";
		if("Affiliation_Name".equalsIgnoreCase(fieldName)) return "xref_Affiliation.name";	
		if("Person_Affiliation_Name".equalsIgnoreCase(fieldName)) return "xref_Affiliation.name";
		if("Roles_id".equalsIgnoreCase(fieldName)) return "Person.Roles";
		if("Person_Roles_id".equalsIgnoreCase(fieldName)) return "Person.Roles";
		if("Roles_Name".equalsIgnoreCase(fieldName)) return "xref_Roles.name";	
		if("Person_Roles_Name".equalsIgnoreCase(fieldName)) return "xref_Roles.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.auth.Person> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.auth.Person>(size); 
	}			

	public org.molgenis.auth.Person create()
	{
		return new org.molgenis.auth.Person();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.auth.Person> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'affiliation' to institute.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> affiliationRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'roles' to ontologyTerm.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> rolesRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.auth.Person object: entities)
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
			org.molgenis.auth.Person object = entities.get(i);		
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
			if("id".equalsIgnoreCase(fieldName) || "person.id".equalsIgnoreCase(fieldName)) 
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
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Person entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.auth.Person> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.auth.Person> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Person> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Person> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Person> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
