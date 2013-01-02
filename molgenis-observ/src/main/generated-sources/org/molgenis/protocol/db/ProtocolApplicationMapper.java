/* File:        observ/model/ProtocolApplication.java
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
import org.molgenis.protocol.ProtocolApplication;

import org.molgenis.organization.Investigation;
import org.molgenis.core.OntologyTerm;
import org.molgenis.protocol.ProtocolApplication_Ontol11768;
import org.molgenis.protocol.Protocol;
import org.molgenis.auth.Person;
import org.molgenis.protocol.ProtocolApplication_Performer;

public class ProtocolApplicationMapper extends AbstractJDBCMapper<ProtocolApplication>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends ProtocolApplication> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO ProtocolApplication (name,description,Investigation,time,protocol) VALUES ");
		{
		
			boolean first = true;
			for(ProtocolApplication e: entities)
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
				//time
				if(e.getTime() != null){
								
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String mysqlDateTime = dateFormat.format(e.getTime());
					sql.append("'"+this.escapeSql(mysqlDateTime)+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//protocol
				if(e.getProtocol_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getProtocol_Id().toString())+"'"
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
	public int executeUpdate(List<? extends ProtocolApplication> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO ProtocolApplication (id,name,description,Investigation,time,protocol) VALUES ");		
		boolean first = true;
		for(ProtocolApplication e: entities)
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
		
			//time


			if(e.getTime() != null){
                sql.append("'"+new java.sql.Timestamp(e.getTime().getTime()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//protocol


			if(e.getProtocol_Id() != null){
                sql.append("'"+this.escapeSql(e.getProtocol_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE time=VALUES(time),protocol=VALUES(protocol),Investigation=VALUES(Investigation),name=VALUES(name),id=LAST_INSERT_ID(id),description=VALUES(description)");

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
	public int executeRemove(List<? extends ProtocolApplication> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM ProtocolApplication WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(ProtocolApplication e: entities)
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
	
	public ProtocolApplicationMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT ProtocolApplication.id"
			+", ProtocolApplication.name"
			+", ProtocolApplication.description"
			+", ProtocolApplication.Investigation"
			+", ProtocolApplication.time"
			+", ProtocolApplication.protocol"
			//parent is SimpleTree(name='Investigation')
			+", xref_Investigation.name AS Investigation_Name"
			//parent is SimpleTree(name='protocol')
			+", xref_protocol.name AS protocol_Name"
			+" FROM ProtocolApplication "

			
			//label for Investigation=name
//path==Investigation. type==xref.
//path==Investigation_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Investigation AS xref_Investigation " 
			+" ON xref_Investigation.id = ProtocolApplication.Investigation"
			
			//label for protocol=name
//path==protocol. type==xref.
//path==protocol_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Protocol AS xref_protocol " 
			+" ON xref_protocol.id = ProtocolApplication.protocol"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM ProtocolApplication "
			
			//label for Investigation=name
//Investigation
//Investigation_Name
		   	+" LEFT JOIN Investigation AS xref_Investigation " 
			+" ON xref_Investigation.id = ProtocolApplication.Investigation"
			
			//label for protocol=name
//protocol
//protocol_Name
		   	+" LEFT JOIN Protocol AS xref_protocol " 
			+" ON xref_protocol.id = ProtocolApplication.protocol"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "ProtocolApplication.id";
		if("ProtocolApplication_id".equalsIgnoreCase(fieldName)) return "ProtocolApplication.id";
		if("name".equalsIgnoreCase(fieldName)) return "ProtocolApplication.name";
		if("ProtocolApplication_name".equalsIgnoreCase(fieldName)) return "ProtocolApplication.name";
		if("description".equalsIgnoreCase(fieldName)) return "ProtocolApplication.description";
		if("ProtocolApplication_description".equalsIgnoreCase(fieldName)) return "ProtocolApplication.description";
		if("Investigation".equalsIgnoreCase(fieldName)) return "ProtocolApplication.Investigation";
		if("ProtocolApplication_Investigation".equalsIgnoreCase(fieldName)) return "ProtocolApplication.Investigation";
		if("time".equalsIgnoreCase(fieldName)) return "ProtocolApplication.time";
		if("ProtocolApplication_time".equalsIgnoreCase(fieldName)) return "ProtocolApplication.time";
		if("protocol".equalsIgnoreCase(fieldName)) return "ProtocolApplication.protocol";
		if("ProtocolApplication_protocol".equalsIgnoreCase(fieldName)) return "ProtocolApplication.protocol";
		if("Investigation_id".equalsIgnoreCase(fieldName)) return "ProtocolApplication.Investigation";
		if("ProtocolApplication_Investigation_id".equalsIgnoreCase(fieldName)) return "ProtocolApplication.Investigation";
		if("Investigation_Name".equalsIgnoreCase(fieldName)) return "xref_Investigation.name";	
		if("ProtocolApplication_Investigation_Name".equalsIgnoreCase(fieldName)) return "xref_Investigation.name";
		if("protocol_id".equalsIgnoreCase(fieldName)) return "ProtocolApplication.protocol";
		if("ProtocolApplication_protocol_id".equalsIgnoreCase(fieldName)) return "ProtocolApplication.protocol";
		if("protocol_Name".equalsIgnoreCase(fieldName)) return "xref_protocol.name";	
		if("ProtocolApplication_protocol_Name".equalsIgnoreCase(fieldName)) return "xref_protocol.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.protocol.ProtocolApplication> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.protocol.ProtocolApplication>(size); 
	}			

	public org.molgenis.protocol.ProtocolApplication create()
	{
		return new org.molgenis.protocol.ProtocolApplication();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.protocol.ProtocolApplication> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'investigation' to investigation.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> investigationRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'ontologyReference' to ontologyTerm.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> ontologyReferenceRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'protocol' to protocol.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> protocolRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'performer' to person.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> performerRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.protocol.ProtocolApplication object: entities)
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
			//create xref/mref rule filtering Protocol on the label name
			if(object.getProtocol_Id() == null && object.getProtocol_Name() != null)
			{
				Object label = object.getProtocol_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !protocolRules.containsKey(label))
					{
						protocolRules.put(""+label, xrefFilter);
						protocolRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Person on the label name
			if(object.getPerformer_Id().size() == 0 && object.getPerformer_Name().size() > 0)
			{
				for(String label: object.getPerformer_Name())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !performerRules.containsKey(label))
					{
						performerRules.put(""+label, xrefFilter);
						performerRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
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
		//resolve foreign key field 'protocol' to protocol.id using name)
		final java.util.Map<String,Integer> protocol_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(protocolRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.protocol.Protocol> protocolList = null;
			try
			{
				protocolList = getDatabase().find(org.molgenis.protocol.Protocol.class, protocolRules.values().toArray(new org.molgenis.framework.db.QueryRule[protocolRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.protocol.Protocol xref :  protocolList)
			{
				String key = "";
				key += 	xref.getName();
				
				protocol_Labels_to_IdMap.put(key, xref.getId());
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

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.protocol.ProtocolApplication object = entities.get(i);		
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
			if(object.getProtocol_Id() == null )
			{
					String key = "";
					if(object.getProtocol_Name() != null)
						key += 	object.getProtocol_Name();
					
					if(!"".equals(key) && protocol_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("protocol_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setProtocol_Id(protocol_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getPerformer_Id() == null || object.getPerformer_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getPerformer_Name().size(); j++)
				{
					String key = "";
					if(object.getPerformer_Name().get(j) != null)
						key += 	object.getPerformer_Name().get(j);
					
					if(!"".equals(key) && performer_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Performer_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(performer_Labels_to_IdMap.get(key));
					}
				}
				object.setPerformer_Id(idList);
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "protocolApplication.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("name".equalsIgnoreCase(fieldName) || "protocolApplication.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("description".equalsIgnoreCase(fieldName) || "protocolApplication.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("investigation".equalsIgnoreCase(fieldName) || "protocolApplication.investigation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("time".equalsIgnoreCase(fieldName) || "protocolApplication.time".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DatetimeField();
			if("protocol".equalsIgnoreCase(fieldName) || "protocolApplication.protocol".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, ProtocolApplication entity)
	{
		entity.setId(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		if("ontologyReference".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// ProtocolApplication_ontol11768
			List<ProtocolApplication_Ontol11768> mref_mapping_entities = db.find(ProtocolApplication_Ontol11768.class, new QueryRule(
					"ontologyReference", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (ProtocolApplication_Ontol11768 mref : mref_mapping_entities) mref_ids.add(mref.getInvestigationElement_Id());
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
			// ProtocolApplication_ontol11768
			List<ProtocolApplication_Ontol11768> mref_mapping_entities = db.find(ProtocolApplication_Ontol11768.class, new QueryRule(
					"ontologyReference_name", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (ProtocolApplication_Ontol11768 mref : mref_mapping_entities) mref_ids.add(mref.getInvestigationElement_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}
		}
		else if("Performer".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// ProtocolApplication_Performer
			List<ProtocolApplication_Performer> mref_mapping_entities = db.find(ProtocolApplication_Performer.class, new QueryRule(
					"Performer", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (ProtocolApplication_Performer mref : mref_mapping_entities) mref_ids.add(mref.getProtocolApplication_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("Performer_name".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// ProtocolApplication_Performer
			List<ProtocolApplication_Performer> mref_mapping_entities = db.find(ProtocolApplication_Performer.class, new QueryRule(
					"Performer_name", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (ProtocolApplication_Performer mref : mref_mapping_entities) mref_ids.add(mref.getProtocolApplication_Id());
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
	public void prepareFileAttachements(java.util.List<org.molgenis.protocol.ProtocolApplication> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.protocol.ProtocolApplication> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<ProtocolApplication> entities ) throws DatabaseException			
	{
		try
		{
			//list the protocolApplication ids to query
			List<Integer> protocolApplicationIds = new ArrayList<Integer>();
			for(ProtocolApplication entity: entities)
			{
				protocolApplicationIds.add(entity.getId());
			}
			
			//map the ontologyReference mrefs
			List<ProtocolApplication_Ontol11768> ontologyReference_mrefs = this.getDatabase().query(ProtocolApplication_Ontol11768.class).in("InvestigationElement", protocolApplicationIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> ontologyReference_ontologyReference_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> ontologyReference_name_map = new LinkedHashMap<Integer,List<String>>();
			
			for(ProtocolApplication_Ontol11768 ref: ontologyReference_mrefs)
			{
				if(ontologyReference_ontologyReference_map.get(ref.getInvestigationElement_Id()) == null) ontologyReference_ontologyReference_map.put(ref.getInvestigationElement_Id(),new ArrayList<Integer>()); 
				ontologyReference_ontologyReference_map.get(ref.getInvestigationElement_Id()).add(ref.getOntologyReference_Id());
				if(ontologyReference_name_map.get(ref.getInvestigationElement_Id()) == null)	ontologyReference_name_map.put(ref.getInvestigationElement_Id(),new ArrayList<String>());
				ontologyReference_name_map.get(ref.getInvestigationElement_Id()).add(ref.getOntologyReference_Name());
			}
			//map the Performer mrefs
			List<ProtocolApplication_Performer> performer_mrefs = this.getDatabase().query(ProtocolApplication_Performer.class).in("ProtocolApplication", protocolApplicationIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> performer_performer_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> performer_name_map = new LinkedHashMap<Integer,List<String>>();
			
			for(ProtocolApplication_Performer ref: performer_mrefs)
			{
				if(performer_performer_map.get(ref.getProtocolApplication_Id()) == null) performer_performer_map.put(ref.getProtocolApplication_Id(),new ArrayList<Integer>()); 
				performer_performer_map.get(ref.getProtocolApplication_Id()).add(ref.getPerformer_Id());
				if(performer_name_map.get(ref.getProtocolApplication_Id()) == null)	performer_name_map.put(ref.getProtocolApplication_Id(),new ArrayList<String>());
				performer_name_map.get(ref.getProtocolApplication_Id()).add(ref.getPerformer_Name());
			}
			
			//load the mapped data into the entities
			for(ProtocolApplication entity: entities)
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
				if(performer_performer_map.get(id) != null)
				{
					entity.setPerformer_Id(performer_performer_map.get(id));
				}
				if(performer_name_map.get(id) != null)
				{
					entity.setPerformer_Name(performer_name_map.get(id));
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
	public void storeMrefs( List<ProtocolApplication> entities ) throws DatabaseException, IOException, ParseException	
	{
		//create an List of ProtocolApplication ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (ProtocolApplication entity : entities) 
		{
			entityIds.add(entity.getId());		
		}
		
		//delete existing mrefs
		getDatabase().remove(getDatabase().query( ProtocolApplication_Ontol11768.class).in("InvestigationElement", entityIds).find());
		List<ProtocolApplication_Ontol11768> protocolApplication_ontol11768ToAdd = new ArrayList<ProtocolApplication_Ontol11768>();

		//delete existing mrefs
		getDatabase().remove(getDatabase().query( ProtocolApplication_Performer.class).in("ProtocolApplication", entityIds).find());
		List<ProtocolApplication_Performer> protocolApplication_PerformerToAdd = new ArrayList<ProtocolApplication_Performer>();


		//check for each mref what needs to be added
		for(ProtocolApplication entity: entities)
		{
			//remove duplicates using Set
			entity.setOntologyReference(new ArrayList(new LinkedHashSet(entity.getOntologyReference_Id())));
			for(Integer id: entity.getOntologyReference_Id())
			{
				ProtocolApplication_Ontol11768 new_mref = new ProtocolApplication_Ontol11768();
				new_mref.setInvestigationElement( entity.getId() );
				new_mref.setOntologyReference( id );
				protocolApplication_ontol11768ToAdd.add(new_mref);
			}
			
			//remove duplicates using Set
			entity.setPerformer(new ArrayList(new LinkedHashSet(entity.getPerformer_Id())));
			for(Integer id: entity.getPerformer_Id())
			{
				ProtocolApplication_Performer new_mref = new ProtocolApplication_Performer();
				new_mref.setProtocolApplication( entity.getId() );
				new_mref.setPerformer( id );
				protocolApplication_PerformerToAdd.add(new_mref);
			}
			
		}
		
		//process changes to ProtocolApplication_ontol11768
		getDatabase().add( protocolApplication_ontol11768ToAdd );
		//process changes to ProtocolApplication_Performer
		getDatabase().add( protocolApplication_PerformerToAdd );
	}
		
	
	public void removeMrefs( List<ProtocolApplication> entities ) throws DatabaseException, IOException, ParseException
	{
		//create an list of ProtocolApplication ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (ProtocolApplication entity : entities) 
		{
			entityIds.add(entity.getId());		
		}	
	
		//remove all ProtocolApplication_ontol11768 elements for field entity.ontologyReference
		getDatabase().remove( getDatabase().query( ProtocolApplication_Ontol11768.class).in("InvestigationElement", entityIds).find() );
		//remove all ProtocolApplication_Performer elements for field entity.Performer
		getDatabase().remove( getDatabase().query( ProtocolApplication_Performer.class).in("ProtocolApplication", entityIds).find() );
	}	
}
