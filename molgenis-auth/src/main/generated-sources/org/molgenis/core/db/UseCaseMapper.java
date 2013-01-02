/* File:        auth/model/UseCase.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
 * Template:	MultiqueryMapperGen.java.ftl
 * generator:   org.molgenis.generators.db.MultiqueryMapperGen 4.0.0-testing
 *
 * Using "subclass per table" strategy
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.core.db;

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
import org.molgenis.core.UseCase;


public class UseCaseMapper extends AbstractJDBCMapper<UseCase>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends UseCase> entities) throws DatabaseException
	{	
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO UseCase (UseCaseName,SearchType) VALUES ");
		{
		
			boolean first = true;
			for(UseCase e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//useCaseName
				if(e.getUseCaseName() != null){
								
					sql.append("'"+this.escapeSql(e.getUseCaseName().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//searchType
				if(e.getSearchType() != null){
								
					sql.append("'"+this.escapeSql(e.getSearchType().toString())+"'"
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
	public int executeUpdate(List<? extends UseCase> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO UseCase (UseCaseId,UseCaseName,SearchType) VALUES ");		
		boolean first = true;
		for(UseCase e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//useCaseId


			if(e.getUseCaseId() != null){
                sql.append("'"+this.escapeSql(e.getUseCaseId()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//useCaseName


			if(e.getUseCaseName() != null){
                sql.append("'"+this.escapeSql(e.getUseCaseName()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//searchType


			if(e.getSearchType() != null){
                sql.append("'"+this.escapeSql(e.getSearchType()).toString()+"'");
			} else {
				sql.append("null");
            }
		
			sql.append(")");
		}
		sql.append(" ON DUPLICATE KEY UPDATE UseCaseId=LAST_INSERT_ID(UseCaseId),UseCaseName=VALUES(UseCaseName),SearchType=VALUES(SearchType)");

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
	public int executeRemove(List<? extends UseCase> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM UseCase WHERE ");
		
		//key $f_index: useCaseId
		{
			sql.append("UseCaseId in (");
			boolean first = true;
			for(UseCase e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");			
				sql.append("'"+this.escapeSql(e.getUseCaseId().toString())+"'");
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
	
	public UseCaseMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT UseCase.UseCaseId"
			+", UseCase.UseCaseName"
			+", UseCase.SearchType"
			+" FROM UseCase "

;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM UseCase "
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("UseCaseId".equalsIgnoreCase(fieldName)) return "UseCase.UseCaseId";
		if("UseCase_UseCaseId".equalsIgnoreCase(fieldName)) return "UseCase.UseCaseId";
		if("UseCaseName".equalsIgnoreCase(fieldName)) return "UseCase.UseCaseName";
		if("UseCase_UseCaseName".equalsIgnoreCase(fieldName)) return "UseCase.UseCaseName";
		if("SearchType".equalsIgnoreCase(fieldName)) return "UseCase.SearchType";
		if("UseCase_SearchType".equalsIgnoreCase(fieldName)) return "UseCase.SearchType";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.core.UseCase> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.core.UseCase>(size); 
	}			

	public org.molgenis.core.UseCase create()
	{
		return new org.molgenis.core.UseCase();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.core.UseCase> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("useCaseId".equalsIgnoreCase(fieldName) || "useCase.useCaseId".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("useCaseName".equalsIgnoreCase(fieldName) || "useCase.useCaseName".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("searchType".equalsIgnoreCase(fieldName) || "useCase.searchType".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, UseCase entity)
	{
		entity.setUseCaseId(i);
	}
	
	@Override
	public QueryRule rewriteMrefRule(Database db, QueryRule rule) throws DatabaseException
	{
		
		{
			return rule;
		}
	}

//Generated by MapperFileAttachments.java.ftl
	public void prepareFileAttachements(java.util.List<org.molgenis.core.UseCase> entities, java.io.File baseDir) throws java.io.IOException
	{
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.core.UseCase> entities, java.io.File baseDir) throws java.io.IOException
	{
		return false;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<UseCase> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<UseCase> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<UseCase> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
