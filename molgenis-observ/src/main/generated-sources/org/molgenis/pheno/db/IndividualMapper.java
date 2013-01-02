/* File:        observ/model/Individual.java
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
import org.molgenis.pheno.Individual;

import org.molgenis.pheno.ObservationTarget;
import org.molgenis.pheno.db.ObservationTargetMapper;
import org.molgenis.organization.Investigation;
import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.ObservationElement_Ontolo12449;
import org.molgenis.pheno.AlternateId;
import org.molgenis.pheno.ObservationElement_AlternateId;
import org.molgenis.pheno.Individual;
import org.molgenis.pheno.Individual;

public class IndividualMapper extends AbstractJDBCMapper<Individual>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Individual> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.pheno.ObservationTarget.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Individual (Mother,Father,id) VALUES ");
		{
		
			boolean first = true;
			for(Individual e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//mother
				if(e.getMother_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getMother_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//father
				if(e.getFather_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getFather_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Individual> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.pheno.ObservationTarget.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Individual (Mother,Father,id) VALUES ");		
		boolean first = true;
		for(Individual e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//mother


			if(e.getMother_Id() != null){
                sql.append("'"+this.escapeSql(e.getMother_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//father


			if(e.getFather_Id() != null){
                sql.append("'"+this.escapeSql(e.getFather_Id()).toString()+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE Mother=VALUES(Mother),Father=VALUES(Father),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Individual> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Individual WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Individual e: entities)
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
		this.getDatabase().getMapperFor(org.molgenis.pheno.ObservationTarget.class).executeRemove(entities);
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public IndividualMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Individual.id"
			+", ObservationElement.name"
			+", ObservationElement.description"
			+", ObservationElement.Investigation"
			+", ObservationElement.__Type"
			+", ObservationElement.label"
			+", Individual.Mother"
			+", Individual.Father"
			//parent is SimpleTree(name='Investigation')
			+", xref_Investigation.name AS Investigation_Name"
			//parent is SimpleTree(name='Mother')
			+", xref_Mother.name AS Mother_Name"
			//parent is SimpleTree(name='Father')
			+", xref_Father.name AS Father_Name"
			+" FROM Individual "
			+" INNER JOIN ObservationTarget ON (Individual.id = ObservationTarget.id)"
			+" INNER JOIN ObservationElement ON (Individual.id = ObservationElement.id)"

			
			//label for Investigation=name
//path==Investigation. type==xref.
//path==Investigation_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Investigation AS xref_Investigation " 
			+" ON xref_Investigation.id = ObservationElement.Investigation"
			
			//label for Mother=name
//path==Mother. type==xref.
//path==Mother_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN ObservationElement AS xref_Mother " 
			+" ON xref_Mother.id = Individual.Mother"
			
			//label for Father=name
//path==Father. type==xref.
//path==Father_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN ObservationElement AS xref_Father " 
			+" ON xref_Father.id = Individual.Father"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Individual "
			  +" INNER JOIN ObservationTarget ON (Individual.id = ObservationTarget.id)"
			  +" INNER JOIN ObservationElement ON (Individual.id = ObservationElement.id)"
			
			//label for Investigation=name
//Investigation
//Investigation_Name
		   	+" LEFT JOIN Investigation AS xref_Investigation " 
			+" ON xref_Investigation.id = ObservationElement.Investigation"
			
			//label for Mother=name
//Mother
//Mother_Name
		   	+" LEFT JOIN ObservationElement AS xref_Mother " 
			+" ON xref_Mother.id = Individual.Mother"
			
			//label for Father=name
//Father
//Father_Name
		   	+" LEFT JOIN ObservationElement AS xref_Father " 
			+" ON xref_Father.id = Individual.Father"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Individual.id";
		if("Individual_id".equalsIgnoreCase(fieldName)) return "Individual.id";
		if("name".equalsIgnoreCase(fieldName)) return "ObservationElement.name";
		if("Individual_name".equalsIgnoreCase(fieldName)) return "ObservationElement.name";
		if("description".equalsIgnoreCase(fieldName)) return "ObservationElement.description";
		if("Individual_description".equalsIgnoreCase(fieldName)) return "ObservationElement.description";
		if("Investigation".equalsIgnoreCase(fieldName)) return "ObservationElement.Investigation";
		if("Individual_Investigation".equalsIgnoreCase(fieldName)) return "ObservationElement.Investigation";
		if("__Type".equalsIgnoreCase(fieldName)) return "ObservationElement.__Type";
		if("Individual___Type".equalsIgnoreCase(fieldName)) return "ObservationElement.__Type";
		if("label".equalsIgnoreCase(fieldName)) return "ObservationElement.label";
		if("Individual_label".equalsIgnoreCase(fieldName)) return "ObservationElement.label";
		if("Mother".equalsIgnoreCase(fieldName)) return "Individual.Mother";
		if("Individual_Mother".equalsIgnoreCase(fieldName)) return "Individual.Mother";
		if("Father".equalsIgnoreCase(fieldName)) return "Individual.Father";
		if("Individual_Father".equalsIgnoreCase(fieldName)) return "Individual.Father";
		if("Investigation_id".equalsIgnoreCase(fieldName)) return "ObservationElement.Investigation";
		if("Individual_Investigation_id".equalsIgnoreCase(fieldName)) return "ObservationElement.Investigation";
		if("Investigation_Name".equalsIgnoreCase(fieldName)) return "xref_Investigation.name";	
		if("Individual_Investigation_Name".equalsIgnoreCase(fieldName)) return "xref_Investigation.name";
		if("Mother_id".equalsIgnoreCase(fieldName)) return "Individual.Mother";
		if("Individual_Mother_id".equalsIgnoreCase(fieldName)) return "Individual.Mother";
		if("Mother_Name".equalsIgnoreCase(fieldName)) return "xref_Mother.name";	
		if("Individual_Mother_Name".equalsIgnoreCase(fieldName)) return "xref_Mother.name";
		if("Father_id".equalsIgnoreCase(fieldName)) return "Individual.Father";
		if("Individual_Father_id".equalsIgnoreCase(fieldName)) return "Individual.Father";
		if("Father_Name".equalsIgnoreCase(fieldName)) return "xref_Father.name";	
		if("Individual_Father_Name".equalsIgnoreCase(fieldName)) return "xref_Father.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.pheno.Individual> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.pheno.Individual>(size); 
	}			

	public org.molgenis.pheno.Individual create()
	{
		return new org.molgenis.pheno.Individual();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.pheno.Individual> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
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
		//create foreign key map for field 'mother' to individual.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> motherRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'father' to individual.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> fatherRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.pheno.Individual object: entities)
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
			//create xref/mref rule filtering Individual on the label name
			if(object.getMother_Id() == null && object.getMother_Name() != null)
			{
				Object label = object.getMother_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !motherRules.containsKey(label))
					{
						motherRules.put(""+label, xrefFilter);
						motherRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Individual on the label name
			if(object.getFather_Id() == null && object.getFather_Name() != null)
			{
				Object label = object.getFather_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !fatherRules.containsKey(label))
					{
						fatherRules.put(""+label, xrefFilter);
						fatherRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
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
		//resolve foreign key field 'mother' to individual.id using name)
		final java.util.Map<String,Integer> mother_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(motherRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.Individual> motherList = null;
			try
			{
				motherList = getDatabase().find(org.molgenis.pheno.Individual.class, motherRules.values().toArray(new org.molgenis.framework.db.QueryRule[motherRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.Individual xref :  motherList)
			{
				String key = "";
				key += 	xref.getName();
				
				mother_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'father' to individual.id using name)
		final java.util.Map<String,Integer> father_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(fatherRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.Individual> fatherList = null;
			try
			{
				fatherList = getDatabase().find(org.molgenis.pheno.Individual.class, fatherRules.values().toArray(new org.molgenis.framework.db.QueryRule[fatherRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.Individual xref :  fatherList)
			{
				String key = "";
				key += 	xref.getName();
				
				father_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.pheno.Individual object = entities.get(i);		
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
			if(object.getMother_Id() == null )
			{
					String key = "";
					if(object.getMother_Name() != null)
						key += 	object.getMother_Name();
					
					if(!"".equals(key) && mother_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Mother_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setMother_Id(mother_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getFather_Id() == null )
			{
					String key = "";
					if(object.getFather_Name() != null)
						key += 	object.getFather_Name();
					
					if(!"".equals(key) && father_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Father_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setFather_Id(father_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "individual.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("name".equalsIgnoreCase(fieldName) || "observationElement.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("description".equalsIgnoreCase(fieldName) || "observationElement.description".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.TextField();
			if("investigation".equalsIgnoreCase(fieldName) || "observationElement.investigation".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("__Type".equalsIgnoreCase(fieldName) || "observationElement.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("label".equalsIgnoreCase(fieldName) || "observationElement.label".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("mother".equalsIgnoreCase(fieldName) || "individual.mother".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("father".equalsIgnoreCase(fieldName) || "individual.father".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Individual entity)
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
		else
		{
			return rule;
		}
	}

//Generated by MapperFileAttachments.java.ftl
	public void prepareFileAttachements(java.util.List<org.molgenis.pheno.Individual> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.pheno.Individual> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Individual> entities ) throws DatabaseException			
	{
		try
		{
			//list the individual ids to query
			List<Integer> individualIds = new ArrayList<Integer>();
			for(Individual entity: entities)
			{
				individualIds.add(entity.getId());
			}
			
			//map the ontologyReference mrefs
			List<ObservationElement_Ontolo12449> ontologyReference_mrefs = this.getDatabase().query(ObservationElement_Ontolo12449.class).in("InvestigationElement", individualIds).sortASC("autoid").find();
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
			List<ObservationElement_AlternateId> alternateId_mrefs = this.getDatabase().query(ObservationElement_AlternateId.class).in("ObservationElement", individualIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> alternateId_alternateId_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> alternateId_name_map = new LinkedHashMap<Integer,List<String>>();
			
			for(ObservationElement_AlternateId ref: alternateId_mrefs)
			{
				if(alternateId_alternateId_map.get(ref.getObservationElement_Id()) == null) alternateId_alternateId_map.put(ref.getObservationElement_Id(),new ArrayList<Integer>()); 
				alternateId_alternateId_map.get(ref.getObservationElement_Id()).add(ref.getAlternateId_Id());
				if(alternateId_name_map.get(ref.getObservationElement_Id()) == null)	alternateId_name_map.put(ref.getObservationElement_Id(),new ArrayList<String>());
				alternateId_name_map.get(ref.getObservationElement_Id()).add(ref.getAlternateId_Name());
			}
			
			//load the mapped data into the entities
			for(Individual entity: entities)
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
	public void storeMrefs( List<Individual> entities ) throws DatabaseException, IOException, ParseException	
	{
		//create an List of Individual ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Individual entity : entities) 
		{
			entityIds.add(entity.getId());		
		}
		
		//delete existing mrefs
		getDatabase().remove(getDatabase().query( ObservationElement_Ontolo12449.class).in("InvestigationElement", entityIds).find());
		List<ObservationElement_Ontolo12449> observationElement_ontolo12449ToAdd = new ArrayList<ObservationElement_Ontolo12449>();

		//delete existing mrefs
		getDatabase().remove(getDatabase().query( ObservationElement_AlternateId.class).in("ObservationElement", entityIds).find());
		List<ObservationElement_AlternateId> observationElement_AlternateIdToAdd = new ArrayList<ObservationElement_AlternateId>();


		//check for each mref what needs to be added
		for(Individual entity: entities)
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
			
		}
		
		//process changes to ObservationElement_ontolo12449
		getDatabase().add( observationElement_ontolo12449ToAdd );
		//process changes to ObservationElement_AlternateId
		getDatabase().add( observationElement_AlternateIdToAdd );
	}
		
	
	public void removeMrefs( List<Individual> entities ) throws DatabaseException, IOException, ParseException
	{
		//create an list of Individual ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Individual entity : entities) 
		{
			entityIds.add(entity.getId());		
		}	
	
		//remove all ObservationElement_ontolo12449 elements for field entity.ontologyReference
		getDatabase().remove( getDatabase().query( ObservationElement_Ontolo12449.class).in("InvestigationElement", entityIds).find() );
		//remove all ObservationElement_AlternateId elements for field entity.AlternateId
		getDatabase().remove( getDatabase().query( ObservationElement_AlternateId.class).in("ObservationElement", entityIds).find() );
	}	
}
