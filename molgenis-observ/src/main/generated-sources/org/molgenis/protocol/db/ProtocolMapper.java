/* File:        observ/model/Protocol.java
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
import org.molgenis.protocol.Protocol;

import org.molgenis.organization.Investigation;
import org.molgenis.core.OntologyTerm;
import org.molgenis.protocol.Protocol_OntologyReference;
import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.ObservableFeature;
import org.molgenis.protocol.Protocol_Features;
import org.molgenis.auth.Person;
import org.molgenis.protocol.Protocol;
import org.molgenis.protocol.Protocol_Subprotocols;

public class ProtocolMapper extends AbstractJDBCMapper<Protocol>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Protocol> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Protocol (name,description,Investigation,__Type,ProtocolType,TargetFilter,Contact) VALUES ");
		{
		
			boolean first = true;
			for(Protocol e: entities)
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
				//investigation
				if(e.getInvestigation_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getInvestigation_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//__Type
				if(e.get__Type() != null){
								
					sql.append("'"+this.escapeSql(e.get__Type().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//protocolType
				if(e.getProtocolType_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getProtocolType_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//targetFilter
				if(e.getTargetFilter() != null){
								
					sql.append("'"+this.escapeSql(e.getTargetFilter().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//contact
				if(e.getContact_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getContact_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Protocol> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Protocol (id,name,description,Investigation,__Type,ProtocolType,TargetFilter,Contact) VALUES ");		
		boolean first = true;
		for(Protocol e: entities)
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
		
			//investigation


			if(e.getInvestigation_Id() != null){
                sql.append("'"+this.escapeSql(e.getInvestigation_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//__Type
			//readonly placeholder for insert-clause to prohibit not "null" errors: will be ignored in update
			sql.append("'Protocol' ,");	
		
			//protocolType


			if(e.getProtocolType_Id() != null){
                sql.append("'"+this.escapeSql(e.getProtocolType_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//targetFilter


			if(e.getTargetFilter() != null){
                sql.append("'"+this.escapeSql(e.getTargetFilter()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//contact


			if(e.getContact_Id() != null){
                sql.append("'"+this.escapeSql(e.getContact_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE ProtocolType=VALUES(ProtocolType),description=VALUES(description),TargetFilter=VALUES(TargetFilter),Contact=VALUES(Contact),Investigation=VALUES(Investigation),name=VALUES(name),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Protocol> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Protocol WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Protocol e: entities)
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
	
	public ProtocolMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Protocol.id"
			+", Protocol.name"
			+", Protocol.description"
			+", Protocol.Investigation"
			+", Protocol.__Type"
			+", Protocol.ProtocolType"
			+", Protocol.TargetFilter"
			+", Protocol.Contact"
			//parent is SimpleTree(name='Investigation')
			+", xref_Investigation.name AS Investigation_Name"
			//parent is SimpleTree(name='ProtocolType')
			+", xref_ProtocolType.name AS ProtocolType_Name"
			//parent is SimpleTree(name='Contact')
			+", xref_Contact.name AS Contact_Name"
			+" FROM Protocol "

			
			//label for Investigation=name
//path==Investigation. type==xref.
//path==Investigation_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Investigation AS xref_Investigation " 
			+" ON xref_Investigation.id = Protocol.Investigation"
			
			//label for ProtocolType=name
//path==ProtocolType. type==xref.
//path==ProtocolType_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_ProtocolType " 
			+" ON xref_ProtocolType.id = Protocol.ProtocolType"
			
			//label for Contact=name
//path==Contact. type==xref.
//path==Contact_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN MolgenisRole AS xref_Contact " 
			+" ON xref_Contact.id = Protocol.Contact"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Protocol "
			
			//label for Investigation=name
//Investigation
//Investigation_Name
		   	+" LEFT JOIN Investigation AS xref_Investigation " 
			+" ON xref_Investigation.id = Protocol.Investigation"
			
			//label for ProtocolType=name
//ProtocolType
//ProtocolType_Name
		   	+" LEFT JOIN OntologyTerm AS xref_ProtocolType " 
			+" ON xref_ProtocolType.id = Protocol.ProtocolType"
			
			//label for Contact=name
//Contact
//Contact_Name
		   	+" LEFT JOIN MolgenisRole AS xref_Contact " 
			+" ON xref_Contact.id = Protocol.Contact"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Protocol.id";
		if("Protocol_id".equalsIgnoreCase(fieldName)) return "Protocol.id";
		if("name".equalsIgnoreCase(fieldName)) return "Protocol.name";
		if("Protocol_name".equalsIgnoreCase(fieldName)) return "Protocol.name";
		if("description".equalsIgnoreCase(fieldName)) return "Protocol.description";
		if("Protocol_description".equalsIgnoreCase(fieldName)) return "Protocol.description";
		if("Investigation".equalsIgnoreCase(fieldName)) return "Protocol.Investigation";
		if("Protocol_Investigation".equalsIgnoreCase(fieldName)) return "Protocol.Investigation";
		if("__Type".equalsIgnoreCase(fieldName)) return "Protocol.__Type";
		if("Protocol___Type".equalsIgnoreCase(fieldName)) return "Protocol.__Type";
		if("ProtocolType".equalsIgnoreCase(fieldName)) return "Protocol.ProtocolType";
		if("Protocol_ProtocolType".equalsIgnoreCase(fieldName)) return "Protocol.ProtocolType";
		if("TargetFilter".equalsIgnoreCase(fieldName)) return "Protocol.TargetFilter";
		if("Protocol_TargetFilter".equalsIgnoreCase(fieldName)) return "Protocol.TargetFilter";
		if("Contact".equalsIgnoreCase(fieldName)) return "Protocol.Contact";
		if("Protocol_Contact".equalsIgnoreCase(fieldName)) return "Protocol.Contact";
		if("Investigation_id".equalsIgnoreCase(fieldName)) return "Protocol.Investigation";
		if("Protocol_Investigation_id".equalsIgnoreCase(fieldName)) return "Protocol.Investigation";
		if("Investigation_Name".equalsIgnoreCase(fieldName)) return "xref_Investigation.name";	
		if("Protocol_Investigation_Name".equalsIgnoreCase(fieldName)) return "xref_Investigation.name";
		if("ProtocolType_id".equalsIgnoreCase(fieldName)) return "Protocol.ProtocolType";
		if("Protocol_ProtocolType_id".equalsIgnoreCase(fieldName)) return "Protocol.ProtocolType";
		if("ProtocolType_Name".equalsIgnoreCase(fieldName)) return "xref_ProtocolType.name";	
		if("Protocol_ProtocolType_Name".equalsIgnoreCase(fieldName)) return "xref_ProtocolType.name";
		if("Contact_id".equalsIgnoreCase(fieldName)) return "Protocol.Contact";
		if("Protocol_Contact_id".equalsIgnoreCase(fieldName)) return "Protocol.Contact";
		if("Contact_Name".equalsIgnoreCase(fieldName)) return "xref_Contact.name";	
		if("Protocol_Contact_Name".equalsIgnoreCase(fieldName)) return "xref_Contact.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.protocol.Protocol> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.protocol.Protocol>(size); 
	}			

	public org.molgenis.protocol.Protocol create()
	{
		return new org.molgenis.protocol.Protocol();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.protocol.Protocol> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'investigation' to investigation.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> investigationRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'ontologyReference' to ontologyTerm.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> ontologyReferenceRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'protocolType' to ontologyTerm.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> protocolTypeRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'features' to observableFeature.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> featuresRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'contact' to person.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> contactRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'subprotocols' to protocol.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> subprotocolsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.protocol.Protocol object: entities)
		{
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
			//create xref/mref rule filtering OntologyTerm on the label name
			if(object.getOntologyReference_Id().size() == 0 && object.getOntologyReference_Name().size() > 0)
			{
				for(String label: object.getOntologyReference_Name())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !ontologyReferenceRules.containsKey(label))
					{
						ontologyReferenceRules.put(""+label, xrefFilter);
						ontologyReferenceRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering OntologyTerm on the label name
			if(object.getProtocolType_Id() == null && object.getProtocolType_Name() != null)
			{
				Object label = object.getProtocolType_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !protocolTypeRules.containsKey(label))
					{
						protocolTypeRules.put(""+label, xrefFilter);
						protocolTypeRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering ObservableFeature on the label name
			if(object.getFeatures_Id().size() == 0 && object.getFeatures_Name().size() > 0)
			{
				for(String label: object.getFeatures_Name())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !featuresRules.containsKey(label))
					{
						featuresRules.put(""+label, xrefFilter);
						featuresRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Person on the label name
			if(object.getContact_Id() == null && object.getContact_Name() != null)
			{
				Object label = object.getContact_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !contactRules.containsKey(label))
					{
						contactRules.put(""+label, xrefFilter);
						contactRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Protocol on the label name
			if(object.getSubprotocols_Id().size() == 0 && object.getSubprotocols_Name().size() > 0)
			{
				for(String label: object.getSubprotocols_Name())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !subprotocolsRules.containsKey(label))
					{
						subprotocolsRules.put(""+label, xrefFilter);
						subprotocolsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
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
		//resolve foreign key field 'protocolType' to ontologyTerm.id using name)
		final java.util.Map<String,Integer> protocolType_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(protocolTypeRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.core.OntologyTerm> protocolTypeList = null;
			try
			{
				protocolTypeList = getDatabase().find(org.molgenis.core.OntologyTerm.class, protocolTypeRules.values().toArray(new org.molgenis.framework.db.QueryRule[protocolTypeRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.core.OntologyTerm xref :  protocolTypeList)
			{
				String key = "";
				key += 	xref.getName();
				
				protocolType_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'features' to observableFeature.id using name)
		final java.util.Map<String,Integer> features_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(featuresRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.ObservableFeature> featuresList = null;
			try
			{
				featuresList = getDatabase().find(org.molgenis.pheno.ObservableFeature.class, featuresRules.values().toArray(new org.molgenis.framework.db.QueryRule[featuresRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.ObservableFeature xref :  featuresList)
			{
				String key = "";
				key += 	xref.getName();
				
				features_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'contact' to person.id using name)
		final java.util.Map<String,Integer> contact_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(contactRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.auth.Person> contactList = null;
			try
			{
				contactList = getDatabase().find(org.molgenis.auth.Person.class, contactRules.values().toArray(new org.molgenis.framework.db.QueryRule[contactRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.auth.Person xref :  contactList)
			{
				String key = "";
				key += 	xref.getName();
				
				contact_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'subprotocols' to protocol.id using name)
		final java.util.Map<String,Integer> subprotocols_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(subprotocolsRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.protocol.Protocol> subprotocolsList = null;
			try
			{
				subprotocolsList = getDatabase().find(org.molgenis.protocol.Protocol.class, subprotocolsRules.values().toArray(new org.molgenis.framework.db.QueryRule[subprotocolsRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.protocol.Protocol xref :  subprotocolsList)
			{
				String key = "";
				key += 	xref.getName();
				
				subprotocols_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.protocol.Protocol object = entities.get(i);		
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
			//update object using label fields name
			if(object.getOntologyReference_Id() == null || object.getOntologyReference_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getOntologyReference_Name().size(); j++)
				{
					String key = "";
					if(object.getOntologyReference_Name().get(j) != null)
						key += 	object.getOntologyReference_Name().get(j);
					
					if(!"".equals(key) && ontologyReference_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("ontologyReference_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(ontologyReference_Labels_to_IdMap.get(key));
					}
				}
				object.setOntologyReference_Id(idList);
			}
			//update object using label fields name
			if(object.getProtocolType_Id() == null )
			{
					String key = "";
					if(object.getProtocolType_Name() != null)
						key += 	object.getProtocolType_Name();
					
					if(!"".equals(key) && protocolType_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("ProtocolType_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setProtocolType_Id(protocolType_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getFeatures_Id() == null || object.getFeatures_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getFeatures_Name().size(); j++)
				{
					String key = "";
					if(object.getFeatures_Name().get(j) != null)
						key += 	object.getFeatures_Name().get(j);
					
					if(!"".equals(key) && features_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Features_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(features_Labels_to_IdMap.get(key));
					}
				}
				object.setFeatures_Id(idList);
			}
			//update object using label fields name
			if(object.getContact_Id() == null )
			{
					String key = "";
					if(object.getContact_Name() != null)
						key += 	object.getContact_Name();
					
					if(!"".equals(key) && contact_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Contact_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setContact_Id(contact_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getSubprotocols_Id() == null || object.getSubprotocols_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getSubprotocols_Name().size(); j++)
				{
					String key = "";
					if(object.getSubprotocols_Name().get(j) != null)
						key += 	object.getSubprotocols_Name().get(j);
					
					if(!"".equals(key) && subprotocols_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("subprotocols_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(subprotocols_Labels_to_IdMap.get(key));
					}
				}
				object.setSubprotocols_Id(idList);
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "protocol.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("name".equalsIgnoreCase(fieldName) || "protocol.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("description".equalsIgnoreCase(fieldName) || "protocol.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.RichtextField();
			if("investigation".equalsIgnoreCase(fieldName) || "protocol.investigation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("__Type".equalsIgnoreCase(fieldName) || "protocol.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("protocolType".equalsIgnoreCase(fieldName) || "protocol.protocolType".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("targetFilter".equalsIgnoreCase(fieldName) || "protocol.targetFilter".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("contact".equalsIgnoreCase(fieldName) || "protocol.contact".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Protocol entity)
	{
		entity.setId(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		if("ontologyReference".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Protocol_ontologyReference
			List<Protocol_OntologyReference> mref_mapping_entities = db.find(Protocol_OntologyReference.class, new QueryRule(
					"ontologyReference", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Protocol_OntologyReference mref : mref_mapping_entities) mref_ids.add(mref.getInvestigationElement_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("ontologyReference_name".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Protocol_ontologyReference
			List<Protocol_OntologyReference> mref_mapping_entities = db.find(Protocol_OntologyReference.class, new QueryRule(
					"ontologyReference_name", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Protocol_OntologyReference mref : mref_mapping_entities) mref_ids.add(mref.getInvestigationElement_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}
		}
		else if("Features".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Protocol_Features
			List<Protocol_Features> mref_mapping_entities = db.find(Protocol_Features.class, new QueryRule(
					"Features", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Protocol_Features mref : mref_mapping_entities) mref_ids.add(mref.getProtocol_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("Features_name".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Protocol_Features
			List<Protocol_Features> mref_mapping_entities = db.find(Protocol_Features.class, new QueryRule(
					"Features_name", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Protocol_Features mref : mref_mapping_entities) mref_ids.add(mref.getProtocol_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}
		}
		else if("subprotocols".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Protocol_subprotocols
			List<Protocol_Subprotocols> mref_mapping_entities = db.find(Protocol_Subprotocols.class, new QueryRule(
					"subprotocols", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Protocol_Subprotocols mref : mref_mapping_entities) mref_ids.add(mref.getProtocol_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("subprotocols_name".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Protocol_subprotocols
			List<Protocol_Subprotocols> mref_mapping_entities = db.find(Protocol_Subprotocols.class, new QueryRule(
					"subprotocols_name", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Protocol_Subprotocols mref : mref_mapping_entities) mref_ids.add(mref.getProtocol_Id());
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
	public void prepareFileAttachements(java.util.List<org.molgenis.protocol.Protocol> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.protocol.Protocol> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Protocol> entities ) throws DatabaseException			
	{
		try
		{
			//list the protocol ids to query
			List<Integer> protocolIds = new ArrayList<Integer>();
			for(Protocol entity: entities)
			{
				protocolIds.add(entity.getId());
			}
			
			//map the ontologyReference mrefs
			List<Protocol_OntologyReference> ontologyReference_mrefs = this.getDatabase().query(Protocol_OntologyReference.class).in("InvestigationElement", protocolIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> ontologyReference_ontologyReference_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> ontologyReference_name_map = new LinkedHashMap<Integer,List<String>>();
			
			for(Protocol_OntologyReference ref: ontologyReference_mrefs)
			{
				if(ontologyReference_ontologyReference_map.get(ref.getInvestigationElement_Id()) == null) ontologyReference_ontologyReference_map.put(ref.getInvestigationElement_Id(),new ArrayList<Integer>()); 
				ontologyReference_ontologyReference_map.get(ref.getInvestigationElement_Id()).add(ref.getOntologyReference_Id());
				if(ontologyReference_name_map.get(ref.getInvestigationElement_Id()) == null)	ontologyReference_name_map.put(ref.getInvestigationElement_Id(),new ArrayList<String>());
				ontologyReference_name_map.get(ref.getInvestigationElement_Id()).add(ref.getOntologyReference_Name());
			}
			//map the Features mrefs
			List<Protocol_Features> features_mrefs = this.getDatabase().query(Protocol_Features.class).in("Protocol", protocolIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> features_features_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> features_name_map = new LinkedHashMap<Integer,List<String>>();
			
			for(Protocol_Features ref: features_mrefs)
			{
				if(features_features_map.get(ref.getProtocol_Id()) == null) features_features_map.put(ref.getProtocol_Id(),new ArrayList<Integer>()); 
				features_features_map.get(ref.getProtocol_Id()).add(ref.getFeatures_Id());
				if(features_name_map.get(ref.getProtocol_Id()) == null)	features_name_map.put(ref.getProtocol_Id(),new ArrayList<String>());
				features_name_map.get(ref.getProtocol_Id()).add(ref.getFeatures_Name());
			}
			//map the subprotocols mrefs
			List<Protocol_Subprotocols> subprotocols_mrefs = this.getDatabase().query(Protocol_Subprotocols.class).in("Protocol", protocolIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> subprotocols_subprotocols_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> subprotocols_name_map = new LinkedHashMap<Integer,List<String>>();
			
			for(Protocol_Subprotocols ref: subprotocols_mrefs)
			{
				if(subprotocols_subprotocols_map.get(ref.getProtocol_Id()) == null) subprotocols_subprotocols_map.put(ref.getProtocol_Id(),new ArrayList<Integer>()); 
				subprotocols_subprotocols_map.get(ref.getProtocol_Id()).add(ref.getSubprotocols_Id());
				if(subprotocols_name_map.get(ref.getProtocol_Id()) == null)	subprotocols_name_map.put(ref.getProtocol_Id(),new ArrayList<String>());
				subprotocols_name_map.get(ref.getProtocol_Id()).add(ref.getSubprotocols_Name());
			}
			
			//load the mapped data into the entities
			for(Protocol entity: entities)
			{
				Integer id = entity.getId();
				if(ontologyReference_ontologyReference_map.get(id) != null)
				{
					entity.setOntologyReference_Id(ontologyReference_ontologyReference_map.get(id));
				}
				if(ontologyReference_name_map.get(id) != null)
				{
					entity.setOntologyReference_Name(ontologyReference_name_map.get(id));
				}
				if(features_features_map.get(id) != null)
				{
					entity.setFeatures_Id(features_features_map.get(id));
				}
				if(features_name_map.get(id) != null)
				{
					entity.setFeatures_Name(features_name_map.get(id));
				}
				if(subprotocols_subprotocols_map.get(id) != null)
				{
					entity.setSubprotocols_Id(subprotocols_subprotocols_map.get(id));
				}
				if(subprotocols_name_map.get(id) != null)
				{
					entity.setSubprotocols_Name(subprotocols_name_map.get(id));
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
	public void storeMrefs( List<Protocol> entities ) throws DatabaseException, IOException, ParseException	
	{
		//create an List of Protocol ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Protocol entity : entities) 
		{
			entityIds.add(entity.getId());		
		}
		
		//delete existing mrefs
		getDatabase().remove(getDatabase().query( Protocol_OntologyReference.class).in("InvestigationElement", entityIds).find());
		List<Protocol_OntologyReference> protocol_ontologyReferenceToAdd = new ArrayList<Protocol_OntologyReference>();

		//delete existing mrefs
		getDatabase().remove(getDatabase().query( Protocol_Features.class).in("Protocol", entityIds).find());
		List<Protocol_Features> protocol_FeaturesToAdd = new ArrayList<Protocol_Features>();

		//delete existing mrefs
		getDatabase().remove(getDatabase().query( Protocol_Subprotocols.class).in("Protocol", entityIds).find());
		List<Protocol_Subprotocols> protocol_subprotocolsToAdd = new ArrayList<Protocol_Subprotocols>();


		//check for each mref what needs to be added
		for(Protocol entity: entities)
		{
			//remove duplicates using Set
			entity.setOntologyReference(new ArrayList(new LinkedHashSet(entity.getOntologyReference_Id())));
			for(Integer id: entity.getOntologyReference_Id())
			{
				Protocol_OntologyReference new_mref = new Protocol_OntologyReference();
				new_mref.setInvestigationElement( entity.getId() );
				new_mref.setOntologyReference( id );
				protocol_ontologyReferenceToAdd.add(new_mref);
			}
			
			//remove duplicates using Set
			entity.setFeatures(new ArrayList(new LinkedHashSet(entity.getFeatures_Id())));
			for(Integer id: entity.getFeatures_Id())
			{
				Protocol_Features new_mref = new Protocol_Features();
				new_mref.setProtocol( entity.getId() );
				new_mref.setFeatures( id );
				protocol_FeaturesToAdd.add(new_mref);
			}
			
			//remove duplicates using Set
			entity.setSubprotocols(new ArrayList(new LinkedHashSet(entity.getSubprotocols_Id())));
			for(Integer id: entity.getSubprotocols_Id())
			{
				Protocol_Subprotocols new_mref = new Protocol_Subprotocols();
				new_mref.setProtocol( entity.getId() );
				new_mref.setSubprotocols( id );
				protocol_subprotocolsToAdd.add(new_mref);
			}
			
		}
		
		//process changes to Protocol_ontologyReference
		getDatabase().add( protocol_ontologyReferenceToAdd );
		//process changes to Protocol_Features
		getDatabase().add( protocol_FeaturesToAdd );
		//process changes to Protocol_subprotocols
		getDatabase().add( protocol_subprotocolsToAdd );
	}
		
	
	public void removeMrefs( List<Protocol> entities ) throws DatabaseException, IOException, ParseException
	{
		//create an list of Protocol ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Protocol entity : entities) 
		{
			entityIds.add(entity.getId());		
		}	
	
		//remove all Protocol_ontologyReference elements for field entity.ontologyReference
		getDatabase().remove( getDatabase().query( Protocol_OntologyReference.class).in("InvestigationElement", entityIds).find() );
		//remove all Protocol_Features elements for field entity.Features
		getDatabase().remove( getDatabase().query( Protocol_Features.class).in("Protocol", entityIds).find() );
		//remove all Protocol_subprotocols elements for field entity.subprotocols
		getDatabase().remove( getDatabase().query( Protocol_Subprotocols.class).in("Protocol", entityIds).find() );
	}	
}
