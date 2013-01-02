/* File:        observ/model/Measurement_categories.java
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
import org.molgenis.pheno.Measurement_Categories;

import org.molgenis.pheno.Category;
import org.molgenis.pheno.Measurement;

public class Measurement_CategoriesMapper extends AbstractJDBCMapper<Measurement_Categories>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends Measurement_Categories> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO Measurement_categories (categories,Measurement) VALUES ");
		{
		
			boolean first = true;
			for(Measurement_Categories e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//categories
				if(e.getCategories_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getCategories_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//measurement
				if(e.getMeasurement_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getMeasurement_Id().toString())+"'"
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
	public int executeUpdate(List<? extends Measurement_Categories> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO Measurement_categories (autoid,categories,Measurement) VALUES ");		
		boolean first = true;
		for(Measurement_Categories e: entities)
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
		
			//categories


			if(e.getCategories_Id() != null){
                sql.append("'"+this.escapeSql(e.getCategories_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//measurement


			if(e.getMeasurement_Id() != null){
                sql.append("'"+this.escapeSql(e.getMeasurement_Id()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE autoid=LAST_INSERT_ID(autoid),categories=VALUES(categories),Measurement=VALUES(Measurement)");

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
	public int executeRemove(List<? extends Measurement_Categories> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM Measurement_categories WHERE ");
		
		//key $f_index: autoid
		{
			sql.append("autoid in (");
			boolean first = true;
			for(Measurement_Categories e: entities)
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
	
	public Measurement_CategoriesMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT Measurement_categories.autoid"
			+", Measurement_categories.categories"
			+", Measurement_categories.Measurement"
			//parent is SimpleTree(name='categories')
			+", xref_categories.name AS categories_Name"
			//parent is SimpleTree(name='Measurement')
			+", xref_Measurement.name AS Measurement_Name"
			+" FROM Measurement_categories "

			
			//label for categories=name
//path==categories. type==xref.
//path==categories_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN ObservationElement AS xref_categories " 
			+" ON xref_categories.id = Measurement_categories.categories"
			
			//label for Measurement=name
//path==Measurement. type==xref.
//path==Measurement_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN ObservationElement AS xref_Measurement " 
			+" ON xref_Measurement.id = Measurement_categories.Measurement"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM Measurement_categories "
			
			//label for categories=name
//categories
//categories_Name
		   	+" LEFT JOIN ObservationElement AS xref_categories " 
			+" ON xref_categories.id = Measurement_categories.categories"
			
			//label for Measurement=name
//Measurement
//Measurement_Name
		   	+" LEFT JOIN ObservationElement AS xref_Measurement " 
			+" ON xref_Measurement.id = Measurement_categories.Measurement"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("autoid".equalsIgnoreCase(fieldName)) return "Measurement_categories.autoid";
		if("Measurement_categories_autoid".equalsIgnoreCase(fieldName)) return "Measurement_categories.autoid";
		if("categories".equalsIgnoreCase(fieldName)) return "Measurement_categories.categories";
		if("Measurement_categories_categories".equalsIgnoreCase(fieldName)) return "Measurement_categories.categories";
		if("Measurement".equalsIgnoreCase(fieldName)) return "Measurement_categories.Measurement";
		if("Measurement_categories_Measurement".equalsIgnoreCase(fieldName)) return "Measurement_categories.Measurement";
		if("categories_id".equalsIgnoreCase(fieldName)) return "Measurement_categories.categories";
		if("Measurement_categories_categories_id".equalsIgnoreCase(fieldName)) return "Measurement_categories.categories";
		if("categories_Name".equalsIgnoreCase(fieldName)) return "xref_categories.name";	
		if("Measurement_categories_categories_Name".equalsIgnoreCase(fieldName)) return "xref_categories.name";
		if("Measurement_id".equalsIgnoreCase(fieldName)) return "Measurement_categories.Measurement";
		if("Measurement_categories_Measurement_id".equalsIgnoreCase(fieldName)) return "Measurement_categories.Measurement";
		if("Measurement_Name".equalsIgnoreCase(fieldName)) return "xref_Measurement.name";	
		if("Measurement_categories_Measurement_Name".equalsIgnoreCase(fieldName)) return "xref_Measurement.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.pheno.Measurement_Categories> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.pheno.Measurement_Categories>(size); 
	}			

	public org.molgenis.pheno.Measurement_Categories create()
	{
		return new org.molgenis.pheno.Measurement_Categories();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.pheno.Measurement_Categories> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'categories' to category.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> categoriesRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create foreign key map for field 'measurement' to measurement.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> measurementRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.pheno.Measurement_Categories object: entities)
		{
			//create xref/mref rule filtering Category on the label name
			if(object.getCategories_Id() == null && object.getCategories_Name() != null)
			{
				Object label = object.getCategories_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !categoriesRules.containsKey(label))
					{
						categoriesRules.put(""+label, xrefFilter);
						categoriesRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
			}		
			//create xref/mref rule filtering Measurement on the label name
			if(object.getMeasurement_Id() == null && object.getMeasurement_Name() != null)
			{
				Object label = object.getMeasurement_Name();
				{
					org.molgenis.framework.db.QueryRule xrefFilter = new org.molgenis.framework.db.QueryRule("name", org.molgenis.framework.db.QueryRule.Operator.EQUALS, label);
					
					if(label != null && !measurementRules.containsKey(label))
					{
						measurementRules.put(""+label, xrefFilter);
						measurementRules.put(""+label+"_OR_", new org.molgenis.framework.db.QueryRule(org.molgenis.framework.db.QueryRule.Operator.OR));
					}
				}
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
		//resolve foreign key field 'measurement' to measurement.id using name)
		final java.util.Map<String,Integer> measurement_Labels_to_IdMap = new java.util.TreeMap<String,Integer>();
		if(measurementRules.size() > 0)
		{		
		
			java.util.List<org.molgenis.pheno.Measurement> measurementList = null;
			try
			{
				measurementList = getDatabase().find(org.molgenis.pheno.Measurement.class, measurementRules.values().toArray(new org.molgenis.framework.db.QueryRule[measurementRules.values().size()]));
			}
			catch(Exception e)
			{
				// something went wrong while querying for this entities' name field
				// we assume it has no such field, which should have been checked earlier ofcourse
				// regardless, just quit the function now
				throw new org.molgenis.framework.db.DatabaseException(e);
			}
		
			for(org.molgenis.pheno.Measurement xref :  measurementList)
			{
				String key = "";
				key += 	xref.getName();
				
				measurement_Labels_to_IdMap.put(key, xref.getId());
			}
		}

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.pheno.Measurement_Categories object = entities.get(i);		
			//update object using label fields name
			if(object.getCategories_Id() == null )
			{
					String key = "";
					if(object.getCategories_Name() != null)
						key += 	object.getCategories_Name();
					
					if(!"".equals(key) && categories_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("categories_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setCategories_Id(categories_Labels_to_IdMap.get(key));
					}
			}
			//update object using label fields name
			if(object.getMeasurement_Id() == null )
			{
					String key = "";
					if(object.getMeasurement_Name() != null)
						key += 	object.getMeasurement_Name();
					
					if(!"".equals(key) && measurement_Labels_to_IdMap.get(key) == null) 
					{
						throw new org.molgenis.framework.db.DatabaseException("Measurement_name cannot be resolved: unknown xref='"+key+"'");
					}
					else
					{
						object.setMeasurement_Id(measurement_Labels_to_IdMap.get(key));
					}
			}
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("autoid".equalsIgnoreCase(fieldName) || "measurement_categories.autoid".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("categories".equalsIgnoreCase(fieldName) || "measurement_categories.categories".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("measurement".equalsIgnoreCase(fieldName) || "measurement_categories.measurement".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, Measurement_Categories entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.pheno.Measurement_Categories> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.pheno.Measurement_Categories> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<Measurement_Categories> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<Measurement_Categories> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<Measurement_Categories> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
