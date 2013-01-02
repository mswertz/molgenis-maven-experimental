/* File:        observ/model/Measurement.java
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
import org.molgenis.pheno.Measurement;

import org.molgenis.pheno.ObservableFeature;
import org.molgenis.pheno.db.ObservableFeatureMapper;
import org.molgenis.organization.Investigation;
import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.ObservationElement_Ontolo12449;
import org.molgenis.pheno.AlternateId;
import org.molgenis.pheno.ObservationElement_AlternateId;
import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.Category;
import org.molgenis.pheno.Measurement_Categories;
import org.molgenis.core.MolgenisEntity;

public class MeasurementMapper extends AbstractJDBCMapper<Measurement>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Measurement> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.pheno.ObservableFeature.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Measurement (unit,dataType,temporal,description,targettypeAllowedForRelation,panelLabelAllowedForRelation,id) VALUES ");
		{
		
			boolean first = true;
			for(Measurement e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//unit
				if(e.getUnit_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getUnit_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//dataType
				if(e.getDataType() != null){
								
					sql.append("'"+this.escapeSql(e.getDataType().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//temporal
				if(e.getTemporal() != null){
								
					sql.append(e.getTemporal()
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
				//targettypeAllowedForRelation
				if(e.getTargettypeAllowedForRelation_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getTargettypeAllowedForRelation_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//panelLabelAllowedForRelation
				if(e.getPanelLabelAllowedForRelation() != null){
								
					sql.append("'"+this.escapeSql(e.getPanelLabelAllowedForRelation().toString())+"'"
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
	public int executeUpdate(List<? extends Measurement> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.pheno.ObservableFeature.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Measurement (unit,dataType,temporal,description,targettypeAllowedForRelation,panelLabelAllowedForRelation,id) VALUES ");		
		boolean first = true;
		for(Measurement e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//unit


			if(e.getUnit_Id() != null){
                sql.append("'"+this.escapeSql(e.getUnit_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//dataType


			if(e.getDataType() != null){
                sql.append("'"+this.escapeSql(e.getDataType())+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//temporal


			if(e.getTemporal() != null){
                sql.append(e.getTemporal() +",");
			} else {
				sql.append("null,");
            }
		
			//description


			if(e.getDescription() != null){
                sql.append("'"+this.escapeSql(e.getDescription()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//targettypeAllowedForRelation


			if(e.getTargettypeAllowedForRelation_Id() != null){
                sql.append("'"+this.escapeSql(e.getTargettypeAllowedForRelation_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//panelLabelAllowedForRelation


			if(e.getPanelLabelAllowedForRelation() != null){
                sql.append("'"+this.escapeSql(e.getPanelLabelAllowedForRelation()).toString()+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE unit=VALUES(unit),dataType=VALUES(dataType),temporal=VALUES(temporal),description=VALUES(description),targettypeAllowedForRelation=VALUES(targettypeAllowedForRelation),panelLabelAllowedForRelation=VALUES(panelLabelAllowedForRelation),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Measurement> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Measurement WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Measurement e: entities)
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
		this.getDatabase().getMapperFor(org.molgenis.pheno.ObservableFeature.class).executeRemove(entities);
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public MeasurementMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Measurement.id"
			+", ObservationElement.name"
			+", Measurement.description"
			+", ObservationElement.Investigation"
			+", ObservationElement.__Type"
			+", ObservationElement.label"
			+", Measurement.unit"
			+", Measurement.dataType"
			+", Measurement.temporal"
			+", Measurement.targettypeAllowedForRelation"
			+", Measurement.panelLabelAllowedForRelation"
			//parent is SimpleTree(name='Investigation')
			+", xref_Investigation.name AS Investigation_Name"
			//parent is SimpleTree(name='unit')
			+", xref_unit.name AS unit_Name"
			//parent is SimpleTree(name='targettypeAllowedForRelation')
			+", xref_targettypeAllowedForRelation.className AS targettypeAllowedForRelation_ClassName"
			+" FROM Measurement "
			+" INNER JOIN ObservableFeature ON (Measurement.id = ObservableFeature.id)"
			+" INNER JOIN ObservationElement ON (Measurement.id = ObservationElement.id)"

			
			//label for Investigation=name
//path==Investigation. type==xref.
//path==Investigation_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Investigation AS xref_Investigation " 
			+" ON xref_Investigation.id = ObservationElement.Investigation"
			
			//label for unit=name
//path==unit. type==xref.
//path==unit_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_unit " 
			+" ON xref_unit.id = Measurement.unit"
			
			//label for targettypeAllowedForRelation=className
//path==targettypeAllowedForRelation. type==xref.
//path==targettypeAllowedForRelation_ClassName. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN MolgenisEntity AS xref_targettypeAllowedForRelation " 
			+" ON xref_targettypeAllowedForRelation.id = Measurement.targettypeAllowedForRelation"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Measurement "
			  +" INNER JOIN ObservableFeature ON (Measurement.id = ObservableFeature.id)"
			  +" INNER JOIN ObservationElement ON (Measurement.id = ObservationElement.id)"
			
			//label for Investigation=name
//Investigation
//Investigation_Name
		   	+" LEFT JOIN Investigation AS xref_Investigation " 
			+" ON xref_Investigation.id = ObservationElement.Investigation"
			
			//label for unit=name
//unit
//unit_Name
		   	+" LEFT JOIN OntologyTerm AS xref_unit " 
			+" ON xref_unit.id = Measurement.unit"
			
			//label for targettypeAllowedForRelation=className
//targettypeAllowedForRelation
//targettypeAllowedForRelation_ClassName
		   	+" LEFT JOIN MolgenisEntity AS xref_targettypeAllowedForRelation " 
			+" ON xref_targettypeAllowedForRelation.id = Measurement.targettypeAllowedForRelation"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Measurement.id";
		if("Measurement_id".equalsIgnoreCase(fieldName)) return "Measurement.id";
		if("name".equalsIgnoreCase(fieldName)) return "ObservationElement.name";
		if("Measurement_name".equalsIgnoreCase(fieldName)) return "ObservationElement.name";
		if("description".equalsIgnoreCase(fieldName)) return "Measurement.description";
		if("Measurement_description".equalsIgnoreCase(fieldName)) return "Measurement.description";
		if("Investigation".equalsIgnoreCase(fieldName)) return "ObservationElement.Investigation";
		if("Measurement_Investigation".equalsIgnoreCase(fieldName)) return "ObservationElement.Investigation";
		if("__Type".equalsIgnoreCase(fieldName)) return "ObservationElement.__Type";
		if("Measurement___Type".equalsIgnoreCase(fieldName)) return "ObservationElement.__Type";
		if("label".equalsIgnoreCase(fieldName)) return "ObservationElement.label";
		if("Measurement_label".equalsIgnoreCase(fieldName)) return "ObservationElement.label";
		if("unit".equalsIgnoreCase(fieldName)) return "Measurement.unit";
		if("Measurement_unit".equalsIgnoreCase(fieldName)) return "Measurement.unit";
		if("dataType".equalsIgnoreCase(fieldName)) return "Measurement.dataType";
		if("Measurement_dataType".equalsIgnoreCase(fieldName)) return "Measurement.dataType";
		if("temporal".equalsIgnoreCase(fieldName)) return "Measurement.temporal";
		if("Measurement_temporal".equalsIgnoreCase(fieldName)) return "Measurement.temporal";
		if("targettypeAllowedForRelation".equalsIgnoreCase(fieldName)) return "Measurement.targettypeAllowedForRelation";
		if("Measurement_targettypeAllowedForRelation".equalsIgnoreCase(fieldName)) return "Measurement.targettypeAllowedForRelation";
		if("panelLabelAllowedForRelation".equalsIgnoreCase(fieldName)) return "Measurement.panelLabelAllowedForRelation";
		if("Measurement_panelLabelAllowedForRelation".equalsIgnoreCase(fieldName)) return "Measurement.panelLabelAllowedForRelation";
		if("Investigation_id".equalsIgnoreCase(fieldName)) return "ObservationElement.Investigation";
		if("Measurement_Investigation_id".equalsIgnoreCase(fieldName)) return "ObservationElement.Investigation";
		if("Investigation_Name".equalsIgnoreCase(fieldName)) return "xref_Investigation.name";	
		if("Measurement_Investigation_Name".equalsIgnoreCase(fieldName)) return "xref_Investigation.name";
		if("unit_id".equalsIgnoreCase(fieldName)) return "Measurement.unit";
		if("Measurement_unit_id".equalsIgnoreCase(fieldName)) return "Measurement.unit";
		if("unit_Name".equalsIgnoreCase(fieldName)) return "xref_unit.name";	
		if("Measurement_unit_Name".equalsIgnoreCase(fieldName)) return "xref_unit.name";
		if("targettypeAllowedForRelation_id".equalsIgnoreCase(fieldName)) return "Measurement.targettypeAllowedForRelation";
		if("Measurement_targettypeAllowedForRelation_id".equalsIgnoreCase(fieldName)) return "Measurement.targettypeAllowedForRelation";
		if("targettypeAllowedForRelation_ClassName".equalsIgnoreCase(fieldName)) return "xref_targettypeAllowedForRelation.className";	
		if("Measurement_targettypeAllowedForRelation_ClassName".equalsIgnoreCase(fieldName)) return "xref_targettypeAllowedForRelation.className";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.pheno.Measurement> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.pheno.Measurement>(size); 
	}			

	public org.molgenis.pheno.Measurement create()
	{
		return new org.molgenis.pheno.Measurement();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.pheno.Measurement> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'investigation' to investigation.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> investigationRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'ontologyReference' to ontologyTerm.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> ontologyReferenceRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'alternateId' to alternateId.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> alternateIdRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'unit' to ontologyTerm.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> unitRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'categories' to category.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> categoriesRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'targettypeAllowedForRelation' to molgenisEntity.id using className)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> targettypeAllowedForRelationRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.pheno.Measurement object: entities)
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
			//create xref/mref rule filtering AlternateId on the label name
			if(object.getAlternateId_Id().size() == 0 && object.getAlternateId_Name().size() > 0)
			{
				for(String label: object.getAlternateId_Name())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !alternateIdRules.containsKey(label))
					{
						alternateIdRules.put(""+label, xrefFilter);
						alternateIdRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering OntologyTerm on the label name
			if(object.getUnit_Id() == null && object.getUnit_Name() != null)
			{
				Object label = object.getUnit_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !unitRules.containsKey(label))
					{
						unitRules.put(""+label, xrefFilter);
						unitRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Category on the label name
			if(object.getCategories_Id().size() == 0 && object.getCategories_Name().size() > 0)
			{
				for(String label: object.getCategories_Name())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !categoriesRules.containsKey(label))
					{
						categoriesRules.put(""+label, xrefFilter);
						categoriesRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering MolgenisEntity on the label className
			if(object.getTargettypeAllowedForRelation_Id() == null && object.getTargettypeAllowedForRelation_ClassName() != null)
			{
				Object label = object.getTargettypeAllowedForRelation_ClassName();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("className", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !targettypeAllowedForRelationRules.containsKey(label))
					{
						targettypeAllowedForRelationRules.put(""+label, xrefFilter);
						targettypeAllowedForRelationRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
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
		//resolve foreign key field 'alternateId' to alternateId.id using name)
		final java.util.Map<String,Integer> alternateId_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(alternateIdRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.AlternateId> alternateIdList = null;
			try
			{
				alternateIdList = getDatabase().find(org.molgenis.pheno.AlternateId.class, alternateIdRules.values().toArray(new org.molgenis.framework.db.QueryRule[alternateIdRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.AlternateId xref :  alternateIdList)
			{
				String key = "";
				key += 	xref.getName();
				
				alternateId_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'unit' to ontologyTerm.id using name)
		final java.util.Map<String,Integer> unit_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(unitRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.core.OntologyTerm> unitList = null;
			try
			{
				unitList = getDatabase().find(org.molgenis.core.OntologyTerm.class, unitRules.values().toArray(new org.molgenis.framework.db.QueryRule[unitRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.core.OntologyTerm xref :  unitList)
			{
				String key = "";
				key += 	xref.getName();
				
				unit_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'categories' to category.id using name)
		final java.util.Map<String,Integer> categories_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(categoriesRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.Category> categoriesList = null;
			try
			{
				categoriesList = getDatabase().find(org.molgenis.pheno.Category.class, categoriesRules.values().toArray(new org.molgenis.framework.db.QueryRule[categoriesRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.Category xref :  categoriesList)
			{
				String key = "";
				key += 	xref.getName();
				
				categories_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'targettypeAllowedForRelation' to molgenisEntity.id using className)
		final java.util.Map<String,Integer> targettypeAllowedForRelation_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(targettypeAllowedForRelationRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.core.MolgenisEntity> targettypeAllowedForRelationList = null;
			try
			{
				targettypeAllowedForRelationList = getDatabase().find(org.molgenis.core.MolgenisEntity.class, targettypeAllowedForRelationRules.values().toArray(new org.molgenis.framework.db.QueryRule[targettypeAllowedForRelationRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.core.MolgenisEntity xref :  targettypeAllowedForRelationList)
			{
				String key = "";
				key += 	xref.getClassName();
				
				targettypeAllowedForRelation_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.pheno.Measurement object = entities.get(i);		
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
			if(object.getAlternateId_Id() == null || object.getAlternateId_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getAlternateId_Name().size(); j++)
				{
					String key = "";
					if(object.getAlternateId_Name().get(j) != null)
						key += 	object.getAlternateId_Name().get(j);
					
					if(!"".equals(key) && alternateId_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("AlternateId_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(alternateId_Labels_to_IdMap.get(key));
					}
				}
				object.setAlternateId_Id(idList);
			}
			//update object using label fields name
			if(object.getUnit_Id() == null )
			{
					String key = "";
					if(object.getUnit_Name() != null)
						key += 	object.getUnit_Name();
					
					if(!"".equals(key) && unit_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("unit_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setUnit_Id(unit_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getCategories_Id() == null || object.getCategories_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getCategories_Name().size(); j++)
				{
					String key = "";
					if(object.getCategories_Name().get(j) != null)
						key += 	object.getCategories_Name().get(j);
					
					if(!"".equals(key) && categories_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("categories_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(categories_Labels_to_IdMap.get(key));
					}
				}
				object.setCategories_Id(idList);
			}
			//update object using label fields className
			if(object.getTargettypeAllowedForRelation_Id() == null )
			{
					String key = "";
					if(object.getTargettypeAllowedForRelation_ClassName() != null)
						key += 	object.getTargettypeAllowedForRelation_ClassName();
					
					if(!"".equals(key) && targettypeAllowedForRelation_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("targettypeAllowedForRelation_className cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setTargettypeAllowedForRelation_Id(targettypeAllowedForRelation_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "measurement.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("name".equalsIgnoreCase(fieldName) || "observationElement.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("description".equalsIgnoreCase(fieldName) || "measurement.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("investigation".equalsIgnoreCase(fieldName) || "observationElement.investigation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("__Type".equalsIgnoreCase(fieldName) || "observationElement.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("label".equalsIgnoreCase(fieldName) || "observationElement.label".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("unit".equalsIgnoreCase(fieldName) || "measurement.unit".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("dataType".equalsIgnoreCase(fieldName) || "measurement.dataType".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("temporal".equalsIgnoreCase(fieldName) || "measurement.temporal".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.BoolField();
			if("targettypeAllowedForRelation".equalsIgnoreCase(fieldName) || "measurement.targettypeAllowedForRelation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("panelLabelAllowedForRelation".equalsIgnoreCase(fieldName) || "measurement.panelLabelAllowedForRelation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Measurement entity)
	{
		entity.setId(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		if("ontologyReference".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// ObservationElement_ontolo12449
			List<ObservationElement_Ontolo12449> mref_mapping_entities = db.find(ObservationElement_Ontolo12449.class, new QueryRule(
					"ontologyReference", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (ObservationElement_Ontolo12449 mref : mref_mapping_entities) mref_ids.add(mref.getInvestigationElement_Id());
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
			// ObservationElement_ontolo12449
			List<ObservationElement_Ontolo12449> mref_mapping_entities = db.find(ObservationElement_Ontolo12449.class, new QueryRule(
					"ontologyReference_name", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (ObservationElement_Ontolo12449 mref : mref_mapping_entities) mref_ids.add(mref.getInvestigationElement_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}
		}
		else if("AlternateId".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// ObservationElement_AlternateId
			List<ObservationElement_AlternateId> mref_mapping_entities = db.find(ObservationElement_AlternateId.class, new QueryRule(
					"AlternateId", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (ObservationElement_AlternateId mref : mref_mapping_entities) mref_ids.add(mref.getObservationElement_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("AlternateId_name".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// ObservationElement_AlternateId
			List<ObservationElement_AlternateId> mref_mapping_entities = db.find(ObservationElement_AlternateId.class, new QueryRule(
					"AlternateId_name", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (ObservationElement_AlternateId mref : mref_mapping_entities) mref_ids.add(mref.getObservationElement_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}
		}
		else if("categories".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Measurement_categories
			List<Measurement_Categories> mref_mapping_entities = db.find(Measurement_Categories.class, new QueryRule(
					"categories", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Measurement_Categories mref : mref_mapping_entities) mref_ids.add(mref.getMeasurement_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("categories_name".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Measurement_categories
			List<Measurement_Categories> mref_mapping_entities = db.find(Measurement_Categories.class, new QueryRule(
					"categories_name", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Measurement_Categories mref : mref_mapping_entities) mref_ids.add(mref.getMeasurement_Id());
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
	public void prepareFileAttachements(java.util.List<org.molgenis.pheno.Measurement> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.pheno.Measurement> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Measurement> entities ) throws DatabaseException			
	{
		try
		{
			//list the measurement ids to query
			List<Integer> measurementIds = new ArrayList<Integer>();
			for(Measurement entity: entities)
			{
				measurementIds.add(entity.getId());
			}
			
			//map the ontologyReference mrefs
			List<ObservationElement_Ontolo12449> ontologyReference_mrefs = this.getDatabase().query(ObservationElement_Ontolo12449.class).in("InvestigationElement", measurementIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> ontologyReference_ontologyReference_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> ontologyReference_name_map = new LinkedHashMap<Integer,List<String>>();
			
			for(ObservationElement_Ontolo12449 ref: ontologyReference_mrefs)
			{
				if(ontologyReference_ontologyReference_map.get(ref.getInvestigationElement_Id()) == null) ontologyReference_ontologyReference_map.put(ref.getInvestigationElement_Id(),new ArrayList<Integer>()); 
				ontologyReference_ontologyReference_map.get(ref.getInvestigationElement_Id()).add(ref.getOntologyReference_Id());
				if(ontologyReference_name_map.get(ref.getInvestigationElement_Id()) == null)	ontologyReference_name_map.put(ref.getInvestigationElement_Id(),new ArrayList<String>());
				ontologyReference_name_map.get(ref.getInvestigationElement_Id()).add(ref.getOntologyReference_Name());
			}
			//map the AlternateId mrefs
			List<ObservationElement_AlternateId> alternateId_mrefs = this.getDatabase().query(ObservationElement_AlternateId.class).in("ObservationElement", measurementIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> alternateId_alternateId_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> alternateId_name_map = new LinkedHashMap<Integer,List<String>>();
			
			for(ObservationElement_AlternateId ref: alternateId_mrefs)
			{
				if(alternateId_alternateId_map.get(ref.getObservationElement_Id()) == null) alternateId_alternateId_map.put(ref.getObservationElement_Id(),new ArrayList<Integer>()); 
				alternateId_alternateId_map.get(ref.getObservationElement_Id()).add(ref.getAlternateId_Id());
				if(alternateId_name_map.get(ref.getObservationElement_Id()) == null)	alternateId_name_map.put(ref.getObservationElement_Id(),new ArrayList<String>());
				alternateId_name_map.get(ref.getObservationElement_Id()).add(ref.getAlternateId_Name());
			}
			//map the categories mrefs
			List<Measurement_Categories> categories_mrefs = this.getDatabase().query(Measurement_Categories.class).in("Measurement", measurementIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> categories_categories_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> categories_name_map = new LinkedHashMap<Integer,List<String>>();
			
			for(Measurement_Categories ref: categories_mrefs)
			{
				if(categories_categories_map.get(ref.getMeasurement_Id()) == null) categories_categories_map.put(ref.getMeasurement_Id(),new ArrayList<Integer>()); 
				categories_categories_map.get(ref.getMeasurement_Id()).add(ref.getCategories_Id());
				if(categories_name_map.get(ref.getMeasurement_Id()) == null)	categories_name_map.put(ref.getMeasurement_Id(),new ArrayList<String>());
				categories_name_map.get(ref.getMeasurement_Id()).add(ref.getCategories_Name());
			}
			
			//load the mapped data into the entities
			for(Measurement entity: entities)
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
				if(alternateId_alternateId_map.get(id) != null)
				{
					entity.setAlternateId_Id(alternateId_alternateId_map.get(id));
				}
				if(alternateId_name_map.get(id) != null)
				{
					entity.setAlternateId_Name(alternateId_name_map.get(id));
				}
				if(categories_categories_map.get(id) != null)
				{
					entity.setCategories_Id(categories_categories_map.get(id));
				}
				if(categories_name_map.get(id) != null)
				{
					entity.setCategories_Name(categories_name_map.get(id));
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
	public void storeMrefs( List<Measurement> entities ) throws DatabaseException, IOException, ParseException	
	{
		//create an List of Measurement ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Measurement entity : entities) 
		{
			entityIds.add(entity.getId());		
		}
		
		//delete existing mrefs
		getDatabase().remove(getDatabase().query( ObservationElement_Ontolo12449.class).in("InvestigationElement", entityIds).find());
		List<ObservationElement_Ontolo12449> observationElement_ontolo12449ToAdd = new ArrayList<ObservationElement_Ontolo12449>();

		//delete existing mrefs
		getDatabase().remove(getDatabase().query( ObservationElement_AlternateId.class).in("ObservationElement", entityIds).find());
		List<ObservationElement_AlternateId> observationElement_AlternateIdToAdd = new ArrayList<ObservationElement_AlternateId>();

		//delete existing mrefs
		getDatabase().remove(getDatabase().query( Measurement_Categories.class).in("Measurement", entityIds).find());
		List<Measurement_Categories> measurement_categoriesToAdd = new ArrayList<Measurement_Categories>();


		//check for each mref what needs to be added
		for(Measurement entity: entities)
		{
			//remove duplicates using Set
			entity.setOntologyReference(new ArrayList(new LinkedHashSet(entity.getOntologyReference_Id())));
			for(Integer id: entity.getOntologyReference_Id())
			{
				ObservationElement_Ontolo12449 new_mref = new ObservationElement_Ontolo12449();
				new_mref.setInvestigationElement( entity.getId() );
				new_mref.setOntologyReference( id );
				observationElement_ontolo12449ToAdd.add(new_mref);
			}
			
			//remove duplicates using Set
			entity.setAlternateId(new ArrayList(new LinkedHashSet(entity.getAlternateId_Id())));
			for(Integer id: entity.getAlternateId_Id())
			{
				ObservationElement_AlternateId new_mref = new ObservationElement_AlternateId();
				new_mref.setObservationElement( entity.getId() );
				new_mref.setAlternateId( id );
				observationElement_AlternateIdToAdd.add(new_mref);
			}
			
			//remove duplicates using Set
			entity.setCategories(new ArrayList(new LinkedHashSet(entity.getCategories_Id())));
			for(Integer id: entity.getCategories_Id())
			{
				Measurement_Categories new_mref = new Measurement_Categories();
				new_mref.setMeasurement( entity.getId() );
				new_mref.setCategories( id );
				measurement_categoriesToAdd.add(new_mref);
			}
			
		}
		
		//process changes to ObservationElement_ontolo12449
		getDatabase().add( observationElement_ontolo12449ToAdd );
		//process changes to ObservationElement_AlternateId
		getDatabase().add( observationElement_AlternateIdToAdd );
		//process changes to Measurement_categories
		getDatabase().add( measurement_categoriesToAdd );
	}
		
	
	public void removeMrefs( List<Measurement> entities ) throws DatabaseException, IOException, ParseException
	{
		//create an list of Measurement ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Measurement entity : entities) 
		{
			entityIds.add(entity.getId());		
		}	
	
		//remove all ObservationElement_ontolo12449 elements for field entity.ontologyReference
		getDatabase().remove( getDatabase().query( ObservationElement_Ontolo12449.class).in("InvestigationElement", entityIds).find() );
		//remove all ObservationElement_AlternateId elements for field entity.AlternateId
		getDatabase().remove( getDatabase().query( ObservationElement_AlternateId.class).in("ObservationElement", entityIds).find() );
		//remove all Measurement_categories elements for field entity.categories
		getDatabase().remove( getDatabase().query( Measurement_Categories.class).in("Measurement", entityIds).find() );
	}	
}
