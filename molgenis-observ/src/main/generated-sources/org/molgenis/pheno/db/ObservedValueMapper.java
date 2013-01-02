/* File:        observ/model/ObservedValue.java
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
import org.molgenis.pheno.ObservedValue;

import org.molgenis.organization.Investigation;
import org.molgenis.protocol.ProtocolApplication;
import org.molgenis.pheno.ObservationElement;
import org.molgenis.pheno.ObservationElement;
import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.ObservationElement;

public class ObservedValueMapper extends AbstractJDBCMapper<ObservedValue>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends ObservedValue> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO ObservedValue (Investigation,protocolApplication,Feature,Target,ontologyReference,value,relation,time,endtime) VALUES ");
		{
		
			boolean first = true;
			for(ObservedValue e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//investigation
				if(e.getInvestigation_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getInvestigation_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//protocolApplication
				if(e.getProtocolApplication_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getProtocolApplication_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//feature
				if(e.getFeature_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getFeature_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//target
				if(e.getTarget_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getTarget_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//ontologyReference
				if(e.getOntologyReference_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getOntologyReference_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//value
				if(e.getValue() != null){
								
					sql.append("'"+this.escapeSql(e.getValue().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//relation
				if(e.getRelation_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getRelation_Id().toString())+"'"
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
				//endtime
				if(e.getEndtime() != null){
								
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String mysqlDateTime = dateFormat.format(e.getEndtime());
					sql.append("'"+this.escapeSql(mysqlDateTime)+"'"
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
	public int executeUpdate(List<? extends ObservedValue> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO ObservedValue (id,Investigation,protocolApplication,Feature,Target,ontologyReference,value,relation,time,endtime) VALUES ");		
		boolean first = true;
		for(ObservedValue e: entities)
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
		
			//investigation


			if(e.getInvestigation_Id() != null){
                sql.append("'"+this.escapeSql(e.getInvestigation_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//protocolApplication


			if(e.getProtocolApplication_Id() != null){
                sql.append("'"+this.escapeSql(e.getProtocolApplication_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//feature


			if(e.getFeature_Id() != null){
                sql.append("'"+this.escapeSql(e.getFeature_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//target


			if(e.getTarget_Id() != null){
                sql.append("'"+this.escapeSql(e.getTarget_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//ontologyReference


			if(e.getOntologyReference_Id() != null){
                sql.append("'"+this.escapeSql(e.getOntologyReference_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//value


			if(e.getValue() != null){
                sql.append("'"+this.escapeSql(e.getValue()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//relation


			if(e.getRelation_Id() != null){
                sql.append("'"+this.escapeSql(e.getRelation_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//time


			if(e.getTime() != null){
                sql.append("'"+new java.sql.Timestamp(e.getTime().getTime()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//endtime


			if(e.getEndtime() != null){
                sql.append("'"+new java.sql.Timestamp(e.getEndtime().getTime()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE ontologyReference=VALUES(ontologyReference),value=VALUES(value),relation=VALUES(relation),time=VALUES(time),endtime=VALUES(endtime),Investigation=VALUES(Investigation),protocolApplication=VALUES(protocolApplication),Feature=VALUES(Feature),Target=VALUES(Target),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends ObservedValue> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM ObservedValue WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(ObservedValue e: entities)
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
	
	public ObservedValueMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT ObservedValue.id"
			+", ObservedValue.Investigation"
			+", ObservedValue.protocolApplication"
			+", ObservedValue.Feature"
			+", ObservedValue.Target"
			+", ObservedValue.ontologyReference"
			+", ObservedValue.value"
			+", ObservedValue.relation"
			+", ObservedValue.time"
			+", ObservedValue.endtime"
			//parent is SimpleTree(name='Investigation')
			+", xref_Investigation.name AS Investigation_Name"
			//parent is SimpleTree(name='protocolApplication')
			+", xref_protocolApplication.name AS protocolApplication_Name"
			//parent is SimpleTree(name='Feature')
			+", xref_Feature.name AS Feature_Name"
			//parent is SimpleTree(name='Target')
			+", xref_Target.name AS Target_Name"
			//parent is SimpleTree(name='ontologyReference')
			+", xref_ontologyReference.name AS ontologyReference_Name"
			//parent is SimpleTree(name='relation')
			+", xref_relation.name AS relation_Name"
			+" FROM ObservedValue "

			
			//label for Investigation=name
//path==Investigation. type==xref.
//path==Investigation_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Investigation AS xref_Investigation " 
			+" ON xref_Investigation.id = ObservedValue.Investigation"
			
			//label for protocolApplication=name
//path==protocolApplication. type==xref.
//path==protocolApplication_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN ProtocolApplication AS xref_protocolApplication " 
			+" ON xref_protocolApplication.id = ObservedValue.protocolApplication"
			
			//label for Feature=name
//path==Feature. type==xref.
//path==Feature_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN ObservationElement AS xref_Feature " 
			+" ON xref_Feature.id = ObservedValue.Feature"
			
			//label for Target=name
//path==Target. type==xref.
//path==Target_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN ObservationElement AS xref_Target " 
			+" ON xref_Target.id = ObservedValue.Target"
			
			//label for ontologyReference=name
//path==ontologyReference. type==xref.
//path==ontologyReference_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_ontologyReference " 
			+" ON xref_ontologyReference.id = ObservedValue.ontologyReference"
			
			//label for relation=name
//path==relation. type==xref.
//path==relation_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN ObservationElement AS xref_relation " 
			+" ON xref_relation.id = ObservedValue.relation"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM ObservedValue "
			
			//label for Investigation=name
//Investigation
//Investigation_Name
		   	+" LEFT JOIN Investigation AS xref_Investigation " 
			+" ON xref_Investigation.id = ObservedValue.Investigation"
			
			//label for protocolApplication=name
//protocolApplication
//protocolApplication_Name
		   	+" LEFT JOIN ProtocolApplication AS xref_protocolApplication " 
			+" ON xref_protocolApplication.id = ObservedValue.protocolApplication"
			
			//label for Feature=name
//Feature
//Feature_Name
		   	+" LEFT JOIN ObservationElement AS xref_Feature " 
			+" ON xref_Feature.id = ObservedValue.Feature"
			
			//label for Target=name
//Target
//Target_Name
		   	+" LEFT JOIN ObservationElement AS xref_Target " 
			+" ON xref_Target.id = ObservedValue.Target"
			
			//label for ontologyReference=name
//ontologyReference
//ontologyReference_Name
		   	+" LEFT JOIN OntologyTerm AS xref_ontologyReference " 
			+" ON xref_ontologyReference.id = ObservedValue.ontologyReference"
			
			//label for relation=name
//relation
//relation_Name
		   	+" LEFT JOIN ObservationElement AS xref_relation " 
			+" ON xref_relation.id = ObservedValue.relation"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "ObservedValue.id";
		if("ObservedValue_id".equalsIgnoreCase(fieldName)) return "ObservedValue.id";
		if("Investigation".equalsIgnoreCase(fieldName)) return "ObservedValue.Investigation";
		if("ObservedValue_Investigation".equalsIgnoreCase(fieldName)) return "ObservedValue.Investigation";
		if("protocolApplication".equalsIgnoreCase(fieldName)) return "ObservedValue.protocolApplication";
		if("ObservedValue_protocolApplication".equalsIgnoreCase(fieldName)) return "ObservedValue.protocolApplication";
		if("Feature".equalsIgnoreCase(fieldName)) return "ObservedValue.Feature";
		if("ObservedValue_Feature".equalsIgnoreCase(fieldName)) return "ObservedValue.Feature";
		if("Target".equalsIgnoreCase(fieldName)) return "ObservedValue.Target";
		if("ObservedValue_Target".equalsIgnoreCase(fieldName)) return "ObservedValue.Target";
		if("ontologyReference".equalsIgnoreCase(fieldName)) return "ObservedValue.ontologyReference";
		if("ObservedValue_ontologyReference".equalsIgnoreCase(fieldName)) return "ObservedValue.ontologyReference";
		if("value".equalsIgnoreCase(fieldName)) return "ObservedValue.value";
		if("ObservedValue_value".equalsIgnoreCase(fieldName)) return "ObservedValue.value";
		if("relation".equalsIgnoreCase(fieldName)) return "ObservedValue.relation";
		if("ObservedValue_relation".equalsIgnoreCase(fieldName)) return "ObservedValue.relation";
		if("time".equalsIgnoreCase(fieldName)) return "ObservedValue.time";
		if("ObservedValue_time".equalsIgnoreCase(fieldName)) return "ObservedValue.time";
		if("endtime".equalsIgnoreCase(fieldName)) return "ObservedValue.endtime";
		if("ObservedValue_endtime".equalsIgnoreCase(fieldName)) return "ObservedValue.endtime";
		if("Investigation_id".equalsIgnoreCase(fieldName)) return "ObservedValue.Investigation";
		if("ObservedValue_Investigation_id".equalsIgnoreCase(fieldName)) return "ObservedValue.Investigation";
		if("Investigation_Name".equalsIgnoreCase(fieldName)) return "xref_Investigation.name";	
		if("ObservedValue_Investigation_Name".equalsIgnoreCase(fieldName)) return "xref_Investigation.name";
		if("protocolApplication_id".equalsIgnoreCase(fieldName)) return "ObservedValue.protocolApplication";
		if("ObservedValue_protocolApplication_id".equalsIgnoreCase(fieldName)) return "ObservedValue.protocolApplication";
		if("protocolApplication_Name".equalsIgnoreCase(fieldName)) return "xref_protocolApplication.name";	
		if("ObservedValue_protocolApplication_Name".equalsIgnoreCase(fieldName)) return "xref_protocolApplication.name";
		if("Feature_id".equalsIgnoreCase(fieldName)) return "ObservedValue.Feature";
		if("ObservedValue_Feature_id".equalsIgnoreCase(fieldName)) return "ObservedValue.Feature";
		if("Feature_Name".equalsIgnoreCase(fieldName)) return "xref_Feature.name";	
		if("ObservedValue_Feature_Name".equalsIgnoreCase(fieldName)) return "xref_Feature.name";
		if("Target_id".equalsIgnoreCase(fieldName)) return "ObservedValue.Target";
		if("ObservedValue_Target_id".equalsIgnoreCase(fieldName)) return "ObservedValue.Target";
		if("Target_Name".equalsIgnoreCase(fieldName)) return "xref_Target.name";	
		if("ObservedValue_Target_Name".equalsIgnoreCase(fieldName)) return "xref_Target.name";
		if("ontologyReference_id".equalsIgnoreCase(fieldName)) return "ObservedValue.ontologyReference";
		if("ObservedValue_ontologyReference_id".equalsIgnoreCase(fieldName)) return "ObservedValue.ontologyReference";
		if("ontologyReference_Name".equalsIgnoreCase(fieldName)) return "xref_ontologyReference.name";	
		if("ObservedValue_ontologyReference_Name".equalsIgnoreCase(fieldName)) return "xref_ontologyReference.name";
		if("relation_id".equalsIgnoreCase(fieldName)) return "ObservedValue.relation";
		if("ObservedValue_relation_id".equalsIgnoreCase(fieldName)) return "ObservedValue.relation";
		if("relation_Name".equalsIgnoreCase(fieldName)) return "xref_relation.name";	
		if("ObservedValue_relation_Name".equalsIgnoreCase(fieldName)) return "xref_relation.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.pheno.ObservedValue> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.pheno.ObservedValue>(size); 
	}			

	public org.molgenis.pheno.ObservedValue create()
	{
		return new org.molgenis.pheno.ObservedValue();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.pheno.ObservedValue> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'investigation' to investigation.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> investigationRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'protocolApplication' to protocolApplication.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> protocolApplicationRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'feature' to observationElement.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> featureRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'target' to observationElement.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> targetRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'ontologyReference' to ontologyTerm.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> ontologyReferenceRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'relation' to observationElement.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> relationRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.pheno.ObservedValue object: entities)
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
			//create xref/mref rule filtering ProtocolApplication on the label name
			if(object.getProtocolApplication_Id() == null && object.getProtocolApplication_Name() != null)
			{
				Object label = object.getProtocolApplication_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !protocolApplicationRules.containsKey(label))
					{
						protocolApplicationRules.put(""+label, xrefFilter);
						protocolApplicationRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering ObservationElement on the label name
			if(object.getFeature_Id() == null && object.getFeature_Name() != null)
			{
				Object label = object.getFeature_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !featureRules.containsKey(label))
					{
						featureRules.put(""+label, xrefFilter);
						featureRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering ObservationElement on the label name
			if(object.getTarget_Id() == null && object.getTarget_Name() != null)
			{
				Object label = object.getTarget_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !targetRules.containsKey(label))
					{
						targetRules.put(""+label, xrefFilter);
						targetRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
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
			if(object.getRelation_Id() == null && object.getRelation_Name() != null)
			{
				Object label = object.getRelation_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !relationRules.containsKey(label))
					{
						relationRules.put(""+label, xrefFilter);
						relationRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
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
		//resolve foreign key field 'protocolApplication' to protocolApplication.id using name)
		final java.util.Map<String,Integer> protocolApplication_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(protocolApplicationRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.protocol.ProtocolApplication> protocolApplicationList = null;
			try
			{
				protocolApplicationList = getDatabase().find(org.molgenis.protocol.ProtocolApplication.class, protocolApplicationRules.values().toArray(new org.molgenis.framework.db.QueryRule[protocolApplicationRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.protocol.ProtocolApplication xref :  protocolApplicationList)
			{
				String key = "";
				key += 	xref.getName();
				
				protocolApplication_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'feature' to observationElement.id using name)
		final java.util.Map<String,Integer> feature_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(featureRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.ObservationElement> featureList = null;
			try
			{
				featureList = getDatabase().find(org.molgenis.pheno.ObservationElement.class, featureRules.values().toArray(new org.molgenis.framework.db.QueryRule[featureRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.ObservationElement xref :  featureList)
			{
				String key = "";
				key += 	xref.getName();
				
				feature_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'target' to observationElement.id using name)
		final java.util.Map<String,Integer> target_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(targetRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.ObservationElement> targetList = null;
			try
			{
				targetList = getDatabase().find(org.molgenis.pheno.ObservationElement.class, targetRules.values().toArray(new org.molgenis.framework.db.QueryRule[targetRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.ObservationElement xref :  targetList)
			{
				String key = "";
				key += 	xref.getName();
				
				target_Labels_to_IdMap.put(key, xref.getId());
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
		//resolve foreign key field 'relation' to observationElement.id using name)
		final java.util.Map<String,Integer> relation_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(relationRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.ObservationElement> relationList = null;
			try
			{
				relationList = getDatabase().find(org.molgenis.pheno.ObservationElement.class, relationRules.values().toArray(new org.molgenis.framework.db.QueryRule[relationRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.ObservationElement xref :  relationList)
			{
				String key = "";
				key += 	xref.getName();
				
				relation_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.pheno.ObservedValue object = entities.get(i);		
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
			if(object.getProtocolApplication_Id() == null )
			{
					String key = "";
					if(object.getProtocolApplication_Name() != null)
						key += 	object.getProtocolApplication_Name();
					
					if(!"".equals(key) && protocolApplication_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("protocolApplication_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setProtocolApplication_Id(protocolApplication_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getFeature_Id() == null )
			{
					String key = "";
					if(object.getFeature_Name() != null)
						key += 	object.getFeature_Name();
					
					if(!"".equals(key) && feature_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Feature_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setFeature_Id(feature_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getTarget_Id() == null )
			{
					String key = "";
					if(object.getTarget_Name() != null)
						key += 	object.getTarget_Name();
					
					if(!"".equals(key) && target_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Target_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setTarget_Id(target_Labels_to_IdMap.get(key));
					}
			}
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
			if(object.getRelation_Id() == null )
			{
					String key = "";
					if(object.getRelation_Name() != null)
						key += 	object.getRelation_Name();
					
					if(!"".equals(key) && relation_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("relation_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setRelation_Id(relation_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "observedValue.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("investigation".equalsIgnoreCase(fieldName) || "observedValue.investigation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("protocolApplication".equalsIgnoreCase(fieldName) || "observedValue.protocolApplication".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("feature".equalsIgnoreCase(fieldName) || "observedValue.feature".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("target".equalsIgnoreCase(fieldName) || "observedValue.target".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("ontologyReference".equalsIgnoreCase(fieldName) || "observedValue.ontologyReference".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("value".equalsIgnoreCase(fieldName) || "observedValue.value".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("relation".equalsIgnoreCase(fieldName) || "observedValue.relation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("time".equalsIgnoreCase(fieldName) || "observedValue.time".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DatetimeField();
			if("endtime".equalsIgnoreCase(fieldName) || "observedValue.endtime".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.DatetimeField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, ObservedValue entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.pheno.ObservedValue> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.pheno.ObservedValue> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<ObservedValue> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<ObservedValue> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<ObservedValue> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
