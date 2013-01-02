/* File:        observ/model/Panel.java
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
import org.molgenis.pheno.Panel;

import org.molgenis.pheno.ObservationTarget;
import org.molgenis.pheno.db.ObservationTargetMapper;
import org.molgenis.organization.Investigation;
import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.ObservationElement_Ontolo12449;
import org.molgenis.pheno.AlternateId;
import org.molgenis.pheno.ObservationElement_AlternateId;
import org.molgenis.pheno.Individual;
import org.molgenis.pheno.Panel_Individuals;
import org.molgenis.pheno.Species;
import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.Panel;
import org.molgenis.pheno.Panel_FounderPanels;

public class PanelMapper extends AbstractJDBCMapper<Panel>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Panel> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.pheno.ObservationTarget.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Panel (Species,PanelType,id) VALUES ");
		{
		
			boolean first = true;
			for(Panel e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//species
				if(e.getSpecies_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getSpecies_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//panelType
				if(e.getPanelType_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getPanelType_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Panel> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.pheno.ObservationTarget.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Panel (Species,PanelType,id) VALUES ");		
		boolean first = true;
		for(Panel e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//species


			if(e.getSpecies_Id() != null){
                sql.append("'"+this.escapeSql(e.getSpecies_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//panelType


			if(e.getPanelType_Id() != null){
                sql.append("'"+this.escapeSql(e.getPanelType_Id()).toString()+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE Species=VALUES(Species),PanelType=VALUES(PanelType),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends Panel> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Panel WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(Panel e: entities)
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
	
	public PanelMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Panel.id"
			+", ObservationElement.name"
			+", ObservationElement.description"
			+", ObservationElement.Investigation"
			+", ObservationElement.__Type"
			+", ObservationElement.label"
			+", Panel.Species"
			+", Panel.PanelType"
			//parent is SimpleTree(name='Investigation')
			+", xref_Investigation.name AS Investigation_Name"
			//parent is SimpleTree(name='Species')
			+", xref_Species.name AS Species_Name"
			//parent is SimpleTree(name='PanelType')
			+", xref_PanelType.name AS PanelType_Name"
			+" FROM Panel "
			+" INNER JOIN ObservationTarget ON (Panel.id = ObservationTarget.id)"
			+" INNER JOIN ObservationElement ON (Panel.id = ObservationElement.id)"

			
			//label for Investigation=name
//path==Investigation. type==xref.
//path==Investigation_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Investigation AS xref_Investigation " 
			+" ON xref_Investigation.id = ObservationElement.Investigation"
			
			//label for Species=name
//path==Species. type==xref.
//path==Species_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_Species " 
			+" ON xref_Species.id = Panel.Species"
			
			//label for PanelType=name
//path==PanelType. type==xref.
//path==PanelType_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN OntologyTerm AS xref_PanelType " 
			+" ON xref_PanelType.id = Panel.PanelType"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Panel "
			  +" INNER JOIN ObservationTarget ON (Panel.id = ObservationTarget.id)"
			  +" INNER JOIN ObservationElement ON (Panel.id = ObservationElement.id)"
			
			//label for Investigation=name
//Investigation
//Investigation_Name
		   	+" LEFT JOIN Investigation AS xref_Investigation " 
			+" ON xref_Investigation.id = ObservationElement.Investigation"
			
			//label for Species=name
//Species
//Species_Name
		   	+" LEFT JOIN OntologyTerm AS xref_Species " 
			+" ON xref_Species.id = Panel.Species"
			
			//label for PanelType=name
//PanelType
//PanelType_Name
		   	+" LEFT JOIN OntologyTerm AS xref_PanelType " 
			+" ON xref_PanelType.id = Panel.PanelType"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "Panel.id";
		if("Panel_id".equalsIgnoreCase(fieldName)) return "Panel.id";
		if("name".equalsIgnoreCase(fieldName)) return "ObservationElement.name";
		if("Panel_name".equalsIgnoreCase(fieldName)) return "ObservationElement.name";
		if("description".equalsIgnoreCase(fieldName)) return "ObservationElement.description";
		if("Panel_description".equalsIgnoreCase(fieldName)) return "ObservationElement.description";
		if("Investigation".equalsIgnoreCase(fieldName)) return "ObservationElement.Investigation";
		if("Panel_Investigation".equalsIgnoreCase(fieldName)) return "ObservationElement.Investigation";
		if("__Type".equalsIgnoreCase(fieldName)) return "ObservationElement.__Type";
		if("Panel___Type".equalsIgnoreCase(fieldName)) return "ObservationElement.__Type";
		if("label".equalsIgnoreCase(fieldName)) return "ObservationElement.label";
		if("Panel_label".equalsIgnoreCase(fieldName)) return "ObservationElement.label";
		if("Species".equalsIgnoreCase(fieldName)) return "Panel.Species";
		if("Panel_Species".equalsIgnoreCase(fieldName)) return "Panel.Species";
		if("PanelType".equalsIgnoreCase(fieldName)) return "Panel.PanelType";
		if("Panel_PanelType".equalsIgnoreCase(fieldName)) return "Panel.PanelType";
		if("Investigation_id".equalsIgnoreCase(fieldName)) return "ObservationElement.Investigation";
		if("Panel_Investigation_id".equalsIgnoreCase(fieldName)) return "ObservationElement.Investigation";
		if("Investigation_Name".equalsIgnoreCase(fieldName)) return "xref_Investigation.name";	
		if("Panel_Investigation_Name".equalsIgnoreCase(fieldName)) return "xref_Investigation.name";
		if("Species_id".equalsIgnoreCase(fieldName)) return "Panel.Species";
		if("Panel_Species_id".equalsIgnoreCase(fieldName)) return "Panel.Species";
		if("Species_Name".equalsIgnoreCase(fieldName)) return "xref_Species.name";	
		if("Panel_Species_Name".equalsIgnoreCase(fieldName)) return "xref_Species.name";
		if("PanelType_id".equalsIgnoreCase(fieldName)) return "Panel.PanelType";
		if("Panel_PanelType_id".equalsIgnoreCase(fieldName)) return "Panel.PanelType";
		if("PanelType_Name".equalsIgnoreCase(fieldName)) return "xref_PanelType.name";	
		if("Panel_PanelType_Name".equalsIgnoreCase(fieldName)) return "xref_PanelType.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.pheno.Panel> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.pheno.Panel>(size); 
	}			

	public org.molgenis.pheno.Panel create()
	{
		return new org.molgenis.pheno.Panel();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.pheno.Panel> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
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
		//create foreign key map for field 'individuals' to individual.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> individualsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'species' to species.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> speciesRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'panelType' to ontologyTerm.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> panelTypeRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'founderPanels' to panel.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> founderPanelsRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.pheno.Panel object: entities)
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
			if(object.getIndividuals_Id().size() == 0 && object.getIndividuals_Name().size() > 0)
			{
				for(String label: object.getIndividuals_Name())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !individualsRules.containsKey(label))
					{
						individualsRules.put(""+label, xrefFilter);
						individualsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Species on the label name
			if(object.getSpecies_Id() == null && object.getSpecies_Name() != null)
			{
				Object label = object.getSpecies_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !speciesRules.containsKey(label))
					{
						speciesRules.put(""+label, xrefFilter);
						speciesRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering OntologyTerm on the label name
			if(object.getPanelType_Id() == null && object.getPanelType_Name() != null)
			{
				Object label = object.getPanelType_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !panelTypeRules.containsKey(label))
					{
						panelTypeRules.put(""+label, xrefFilter);
						panelTypeRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Panel on the label name
			if(object.getFounderPanels_Id().size() == 0 && object.getFounderPanels_Name().size() > 0)
			{
				for(String label: object.getFounderPanels_Name())
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !founderPanelsRules.containsKey(label))
					{
						founderPanelsRules.put(""+label, xrefFilter);
						founderPanelsRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
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
		//resolve foreign key field 'individuals' to individual.id using name)
		final java.util.Map<String,Integer> individuals_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(individualsRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.Individual> individualsList = null;
			try
			{
				individualsList = getDatabase().find(org.molgenis.pheno.Individual.class, individualsRules.values().toArray(new org.molgenis.framework.db.QueryRule[individualsRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.Individual xref :  individualsList)
			{
				String key = "";
				key += 	xref.getName();
				
				individuals_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'species' to species.id using name)
		final java.util.Map<String,Integer> species_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(speciesRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.Species> speciesList = null;
			try
			{
				speciesList = getDatabase().find(org.molgenis.pheno.Species.class, speciesRules.values().toArray(new org.molgenis.framework.db.QueryRule[speciesRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.Species xref :  speciesList)
			{
				String key = "";
				key += 	xref.getName();
				
				species_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'panelType' to ontologyTerm.id using name)
		final java.util.Map<String,Integer> panelType_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(panelTypeRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.core.OntologyTerm> panelTypeList = null;
			try
			{
				panelTypeList = getDatabase().find(org.molgenis.core.OntologyTerm.class, panelTypeRules.values().toArray(new org.molgenis.framework.db.QueryRule[panelTypeRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.core.OntologyTerm xref :  panelTypeList)
			{
				String key = "";
				key += 	xref.getName();
				
				panelType_Labels_to_IdMap.put(key, xref.getId());
			}
		}
		//resolve foreign key field 'founderPanels' to panel.id using name)
		final java.util.Map<String,Integer> founderPanels_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(founderPanelsRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.Panel> founderPanelsList = null;
			try
			{
				founderPanelsList = getDatabase().find(org.molgenis.pheno.Panel.class, founderPanelsRules.values().toArray(new org.molgenis.framework.db.QueryRule[founderPanelsRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.Panel xref :  founderPanelsList)
			{
				String key = "";
				key += 	xref.getName();
				
				founderPanels_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.pheno.Panel object = entities.get(i);		
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
			if(object.getIndividuals_Id() == null || object.getIndividuals_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getIndividuals_Name().size(); j++)
				{
					String key = "";
					if(object.getIndividuals_Name().get(j) != null)
						key += 	object.getIndividuals_Name().get(j);
					
					if(!"".equals(key) && individuals_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Individuals_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(individuals_Labels_to_IdMap.get(key));
					}
				}
				object.setIndividuals_Id(idList);
			}
			//update object using label fields name
			if(object.getSpecies_Id() == null )
			{
					String key = "";
					if(object.getSpecies_Name() != null)
						key += 	object.getSpecies_Name();
					
					if(!"".equals(key) && species_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Species_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setSpecies_Id(species_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getPanelType_Id() == null )
			{
					String key = "";
					if(object.getPanelType_Name() != null)
						key += 	object.getPanelType_Name();
					
					if(!"".equals(key) && panelType_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("PanelType_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setPanelType_Id(panelType_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getFounderPanels_Id() == null || object.getFounderPanels_Id().size() == 0)
			{
				java.util.List<Integer> idList = new java.util.ArrayList<Integer>();
				for(int j = 0; j < object.getFounderPanels_Name().size(); j++)
				{
					String key = "";
					if(object.getFounderPanels_Name().get(j) != null)
						key += 	object.getFounderPanels_Name().get(j);
					
					if(!"".equals(key) && founderPanels_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("FounderPanels_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						idList.add(founderPanels_Labels_to_IdMap.get(key));
					}
				}
				object.setFounderPanels_Id(idList);
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "panel.id".equalsIgnoreCase(fieldName)) 
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
			if("species".equalsIgnoreCase(fieldName) || "panel.species".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("panelType".equalsIgnoreCase(fieldName) || "panel.panelType".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Panel entity)
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
		else if("Individuals".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Panel_Individuals
			List<Panel_Individuals> mref_mapping_entities = db.find(Panel_Individuals.class, new QueryRule(
					"Individuals", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Panel_Individuals mref : mref_mapping_entities) mref_ids.add(mref.getPanel_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("Individuals_name".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Panel_Individuals
			List<Panel_Individuals> mref_mapping_entities = db.find(Panel_Individuals.class, new QueryRule(
					"Individuals_name", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Panel_Individuals mref : mref_mapping_entities) mref_ids.add(mref.getPanel_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}
		}
		else if("FounderPanels".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Panel_FounderPanels
			List<Panel_FounderPanels> mref_mapping_entities = db.find(Panel_FounderPanels.class, new QueryRule(
					"FounderPanels", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Panel_FounderPanels mref : mref_mapping_entities) mref_ids.add(mref.getPanel_Id());
				return new QueryRule("id", Operator.IN, mref_ids);
			}		
			else
			{
				// no records to be shown
				return new QueryRule("id", Operator.EQUALS, Integer.MIN_VALUE);
			}			
		}
		else if("FounderPanels_name".equalsIgnoreCase(rule.getField()))
		{
			// replace with id filter based on the many-to-many links in
			// Panel_FounderPanels
			List<Panel_FounderPanels> mref_mapping_entities = db.find(Panel_FounderPanels.class, new QueryRule(
					"FounderPanels_name", rule.getOperator(), rule.getValue()));
			if (mref_mapping_entities.size() > 0)
			{
				List<Integer> mref_ids = new ArrayList<Integer>();
				for (Panel_FounderPanels mref : mref_mapping_entities) mref_ids.add(mref.getPanel_Id());
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
	public void prepareFileAttachements(java.util.List<org.molgenis.pheno.Panel> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.pheno.Panel> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Panel> entities ) throws DatabaseException			
	{
		try
		{
			//list the panel ids to query
			List<Integer> panelIds = new ArrayList<Integer>();
			for(Panel entity: entities)
			{
				panelIds.add(entity.getId());
			}
			
			//map the ontologyReference mrefs
			List<ObservationElement_Ontolo12449> ontologyReference_mrefs = this.getDatabase().query(ObservationElement_Ontolo12449.class).in("InvestigationElement", panelIds).sortASC("autoid").find();
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
			List<ObservationElement_AlternateId> alternateId_mrefs = this.getDatabase().query(ObservationElement_AlternateId.class).in("ObservationElement", panelIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> alternateId_alternateId_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> alternateId_name_map = new LinkedHashMap<Integer,List<String>>();
			
			for(ObservationElement_AlternateId ref: alternateId_mrefs)
			{
				if(alternateId_alternateId_map.get(ref.getObservationElement_Id()) == null) alternateId_alternateId_map.put(ref.getObservationElement_Id(),new ArrayList<Integer>()); 
				alternateId_alternateId_map.get(ref.getObservationElement_Id()).add(ref.getAlternateId_Id());
				if(alternateId_name_map.get(ref.getObservationElement_Id()) == null)	alternateId_name_map.put(ref.getObservationElement_Id(),new ArrayList<String>());
				alternateId_name_map.get(ref.getObservationElement_Id()).add(ref.getAlternateId_Name());
			}
			//map the Individuals mrefs
			List<Panel_Individuals> individuals_mrefs = this.getDatabase().query(Panel_Individuals.class).in("Panel", panelIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> individuals_individuals_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> individuals_name_map = new LinkedHashMap<Integer,List<String>>();
			
			for(Panel_Individuals ref: individuals_mrefs)
			{
				if(individuals_individuals_map.get(ref.getPanel_Id()) == null) individuals_individuals_map.put(ref.getPanel_Id(),new ArrayList<Integer>()); 
				individuals_individuals_map.get(ref.getPanel_Id()).add(ref.getIndividuals_Id());
				if(individuals_name_map.get(ref.getPanel_Id()) == null)	individuals_name_map.put(ref.getPanel_Id(),new ArrayList<String>());
				individuals_name_map.get(ref.getPanel_Id()).add(ref.getIndividuals_Name());
			}
			//map the FounderPanels mrefs
			List<Panel_FounderPanels> founderPanels_mrefs = this.getDatabase().query(Panel_FounderPanels.class).in("Panel", panelIds).sortASC("autoid").find();
			Map<Integer,List<Integer>> founderPanels_founderPanels_map = new LinkedHashMap<Integer,List<Integer>>();
			Map<Integer,List<String>> founderPanels_name_map = new LinkedHashMap<Integer,List<String>>();
			
			for(Panel_FounderPanels ref: founderPanels_mrefs)
			{
				if(founderPanels_founderPanels_map.get(ref.getPanel_Id()) == null) founderPanels_founderPanels_map.put(ref.getPanel_Id(),new ArrayList<Integer>()); 
				founderPanels_founderPanels_map.get(ref.getPanel_Id()).add(ref.getFounderPanels_Id());
				if(founderPanels_name_map.get(ref.getPanel_Id()) == null)	founderPanels_name_map.put(ref.getPanel_Id(),new ArrayList<String>());
				founderPanels_name_map.get(ref.getPanel_Id()).add(ref.getFounderPanels_Name());
			}
			
			//load the mapped data into the entities
			for(Panel entity: entities)
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
				if(individuals_individuals_map.get(id) != null)
				{
					entity.setIndividuals_Id(individuals_individuals_map.get(id));
				}
				if(individuals_name_map.get(id) != null)
				{
					entity.setIndividuals_Name(individuals_name_map.get(id));
				}
				if(founderPanels_founderPanels_map.get(id) != null)
				{
					entity.setFounderPanels_Id(founderPanels_founderPanels_map.get(id));
				}
				if(founderPanels_name_map.get(id) != null)
				{
					entity.setFounderPanels_Name(founderPanels_name_map.get(id));
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
	public void storeMrefs( List<Panel> entities ) throws DatabaseException, IOException, ParseException	
	{
		//create an List of Panel ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Panel entity : entities) 
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
		getDatabase().remove(getDatabase().query( Panel_Individuals.class).in("Panel", entityIds).find());
		List<Panel_Individuals> panel_IndividualsToAdd = new ArrayList<Panel_Individuals>();

		//delete existing mrefs
		getDatabase().remove(getDatabase().query( Panel_FounderPanels.class).in("Panel", entityIds).find());
		List<Panel_FounderPanels> panel_FounderPanelsToAdd = new ArrayList<Panel_FounderPanels>();


		//check for each mref what needs to be added
		for(Panel entity: entities)
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
			entity.setIndividuals(new ArrayList(new LinkedHashSet(entity.getIndividuals_Id())));
			for(Integer id: entity.getIndividuals_Id())
			{
				Panel_Individuals new_mref = new Panel_Individuals();
				new_mref.setPanel( entity.getId() );
				new_mref.setIndividuals( id );
				panel_IndividualsToAdd.add(new_mref);
			}
			
			//remove duplicates using Set
			entity.setFounderPanels(new ArrayList(new LinkedHashSet(entity.getFounderPanels_Id())));
			for(Integer id: entity.getFounderPanels_Id())
			{
				Panel_FounderPanels new_mref = new Panel_FounderPanels();
				new_mref.setPanel( entity.getId() );
				new_mref.setFounderPanels( id );
				panel_FounderPanelsToAdd.add(new_mref);
			}
			
		}
		
		//process changes to ObservationElement_ontolo12449
		getDatabase().add( observationElement_ontolo12449ToAdd );
		//process changes to ObservationElement_AlternateId
		getDatabase().add( observationElement_AlternateIdToAdd );
		//process changes to Panel_Individuals
		getDatabase().add( panel_IndividualsToAdd );
		//process changes to Panel_FounderPanels
		getDatabase().add( panel_FounderPanelsToAdd );
	}
		
	
	public void removeMrefs( List<Panel> entities ) throws DatabaseException, IOException, ParseException
	{
		//create an list of Panel ids to query for
		List<Integer> entityIds = new ArrayList<Integer>(); 
		for (Panel entity : entities) 
		{
			entityIds.add(entity.getId());		
		}	
	
		//remove all ObservationElement_ontolo12449 elements for field entity.ontologyReference
		getDatabase().remove( getDatabase().query( ObservationElement_Ontolo12449.class).in("InvestigationElement", entityIds).find() );
		//remove all ObservationElement_AlternateId elements for field entity.AlternateId
		getDatabase().remove( getDatabase().query( ObservationElement_AlternateId.class).in("ObservationElement", entityIds).find() );
		//remove all Panel_Individuals elements for field entity.Individuals
		getDatabase().remove( getDatabase().query( Panel_Individuals.class).in("Panel", entityIds).find() );
		//remove all Panel_FounderPanels elements for field entity.FounderPanels
		getDatabase().remove( getDatabase().query( Panel_FounderPanels.class).in("Panel", entityIds).find() );
	}	
}
