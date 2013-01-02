/* File:        observ/model/ProtocolDocument.java
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

import org.apache.commons.io.FileUtils;

import org.molgenis.framework.db.jdbc.JDBCDatabase;
import org.molgenis.framework.db.QueryRule;
import org.molgenis.util.ValueLabel;
import org.molgenis.protocol.ProtocolDocument;

import org.molgenis.core.MolgenisFile;
import org.molgenis.core.db.MolgenisFileMapper;
import org.molgenis.protocol.Protocol;

public class ProtocolDocumentMapper extends AbstractJDBCMapper<ProtocolDocument>
{	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int executeAdd(List<? extends ProtocolDocument> entities) throws DatabaseException
	{	
		//add superclass first
		this.getDatabase().getMapperFor(org.molgenis.core.MolgenisFile.class).executeAdd(entities);
	
		Connection conn = getDatabase().getConnection();
		//create big mysql query
		StringBuffer sql = new StringBuffer("INSERT INTO ProtocolDocument (protocol,document,id) VALUES ");
		{
		
			boolean first = true;
			for(ProtocolDocument e: entities)
			{
				// put the ,
				if(first)
					first = false;
				else
					sql.append(",");
					
				sql.append("(");			
				//protocol
				if(e.getProtocol_Id() != null){
								
					sql.append("'"+this.escapeSql(e.getProtocol_Id().toString())+"'"
				+",");
				}
				else{
					sql.append("null,");
				}
				//document
				if(e.getDocument() != null){
								
					sql.append("'"+this.escapeSql(e.getDocument().toString())+"'"
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
	public int executeUpdate(List<? extends ProtocolDocument> entities) throws DatabaseException
	{
		//update superclass first
		this.getDatabase().getMapperFor(org.molgenis.core.MolgenisFile.class).executeUpdate(entities);
		Connection conn = getDatabase().getConnection();
		
		//create sql string
		StringBuffer sql = new StringBuffer("INSERT INTO ProtocolDocument (protocol,document,id) VALUES ");		
		boolean first = true;
		for(ProtocolDocument e: entities)
		{
			// put the ,
			if(first)
				first = false;
			else
				sql.append(",");

			sql.append("(");
			
			//protocol


			if(e.getProtocol_Id() != null){
                sql.append("'"+this.escapeSql(e.getProtocol_Id()).toString()+"'" +",");
			} else {
				sql.append("null,");
            }
		
			//document


			if(e.getDocument() != null){
                sql.append("'"+this.escapeSql(e.getDocument()).toString()+"'" +",");
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
		sql.append(" ON DUPLICATE KEY UPDATE protocol=VALUES(protocol),document=VALUES(document),id=LAST_INSERT_ID(id)");

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
	public int executeRemove(List<? extends ProtocolDocument> entities) throws DatabaseException
	{
		Connection conn = getDatabase().getConnection();
		int rowsAffected = 0;
		
		//create sql
		StringBuffer sql = new StringBuffer("DELETE FROM ProtocolDocument WHERE ");
		
		//key $f_index: id
		{
			sql.append("id in (");
			boolean first = true;
			for(ProtocolDocument e: entities)
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
		this.getDatabase().getMapperFor(org.molgenis.core.MolgenisFile.class).executeRemove(entities);
		return rowsAffected;
	}
	
//Generated by MapperCommons.subclass_per_table.java.ftl
	
	public ProtocolDocumentMapper(JDBCDatabase database)
	{
		super(database);
	}
	
	public String createFindSql(QueryRule ... rules) throws DatabaseException
	{	
	
			
		return "SELECT ProtocolDocument.id"
			+", MolgenisFile.name"
			+", MolgenisFile.__Type"
			+", MolgenisFile.Extension"
			+", ProtocolDocument.protocol"
			+", ProtocolDocument.document"
			//parent is SimpleTree(name='protocol')
			+", xref_protocol.name AS protocol_Name"
			+" FROM ProtocolDocument "
			+" INNER JOIN MolgenisFile ON (ProtocolDocument.id = MolgenisFile.id)"

			
			//label for protocol=name
//path==protocol. type==xref.
//path==protocol_Name. type==string.
//in if path.value.type != "xref" && !pathlist?seq_contains(path.getParent().name)
		   	+" LEFT JOIN Protocol AS xref_protocol " 
			+" ON xref_protocol.id = ProtocolDocument.protocol"
;

	}	

	public String createCountSql(QueryRule ... rules) throws DatabaseException
	{	
		return "select count(*) as num_rows " 
			  +" FROM ProtocolDocument "
			  +" INNER JOIN MolgenisFile ON (ProtocolDocument.id = MolgenisFile.id)"
			
			//label for protocol=name
//protocol
//protocol_Name
		   	+" LEFT JOIN Protocol AS xref_protocol " 
			+" ON xref_protocol.id = ProtocolDocument.protocol"
;		  	  
			  
	}
	
	@Override
	public String getTableFieldName(String fieldName)
	{
		if("id".equalsIgnoreCase(fieldName)) return "ProtocolDocument.id";
		if("ProtocolDocument_id".equalsIgnoreCase(fieldName)) return "ProtocolDocument.id";
		if("name".equalsIgnoreCase(fieldName)) return "MolgenisFile.name";
		if("ProtocolDocument_name".equalsIgnoreCase(fieldName)) return "MolgenisFile.name";
		if("__Type".equalsIgnoreCase(fieldName)) return "MolgenisFile.__Type";
		if("ProtocolDocument___Type".equalsIgnoreCase(fieldName)) return "MolgenisFile.__Type";
		if("Extension".equalsIgnoreCase(fieldName)) return "MolgenisFile.Extension";
		if("ProtocolDocument_Extension".equalsIgnoreCase(fieldName)) return "MolgenisFile.Extension";
		if("protocol".equalsIgnoreCase(fieldName)) return "ProtocolDocument.protocol";
		if("ProtocolDocument_protocol".equalsIgnoreCase(fieldName)) return "ProtocolDocument.protocol";
		if("document".equalsIgnoreCase(fieldName)) return "ProtocolDocument.document";
		if("ProtocolDocument_document".equalsIgnoreCase(fieldName)) return "ProtocolDocument.document";
		if("protocol_id".equalsIgnoreCase(fieldName)) return "ProtocolDocument.protocol";
		if("ProtocolDocument_protocol_id".equalsIgnoreCase(fieldName)) return "ProtocolDocument.protocol";
		if("protocol_Name".equalsIgnoreCase(fieldName)) return "xref_protocol.name";	
		if("ProtocolDocument_protocol_Name".equalsIgnoreCase(fieldName)) return "xref_protocol.name";
		return fieldName;
	}
	
	
	
	public java.util.List<org.molgenis.protocol.ProtocolDocument> createList(int size)
	{
		return new java.util.ArrayList<org.molgenis.protocol.ProtocolDocument>(size); 
	}			

	public org.molgenis.protocol.ProtocolDocument create()
	{
		return new org.molgenis.protocol.ProtocolDocument();
	}

	@Override
	//Resolve
	public void resolveForeignKeys(java.util.List<org.molgenis.protocol.ProtocolDocument> entities)  throws org.molgenis.framework.db.DatabaseException, java.text.ParseException
	{
		//create foreign key map for field 'protocol' to protocol.id using name)	
		//we will use a hash of the values to ensure that entities are only queried once	
		final java.util.Map<String, org.molgenis.framework.db.QueryRule> protocolRules = new java.util.LinkedHashMap<String, org.molgenis.framework.db.QueryRule>();
		//create all query rules	
		for(org.molgenis.protocol.ProtocolDocument object: entities)
		{
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

		//update objects with the keys
		for(int i = 0; i < entities.size(); i++)
		{
			org.molgenis.protocol.ProtocolDocument object = entities.get(i);		
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
						
		}
	}	
	
	@Override
	public org.molgenis.fieldtypes.FieldType getFieldType(String fieldName)
	{
			if("id".equalsIgnoreCase(fieldName) || "protocolDocument.id".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.IntField();
			if("name".equalsIgnoreCase(fieldName) || "molgenisFile.name".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("__Type".equalsIgnoreCase(fieldName) || "molgenisFile.__Type".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.EnumField();
			if("extension".equalsIgnoreCase(fieldName) || "molgenisFile.extension".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.StringField();
			if("protocol".equalsIgnoreCase(fieldName) || "protocolDocument.protocol".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.XrefField();
			if("document".equalsIgnoreCase(fieldName) || "protocolDocument.document".equalsIgnoreCase(fieldName)) 
				return new org.molgenis.fieldtypes.FileField();
		return new org.molgenis.fieldtypes.UnknownField();
	}		
	
	public void setAutogeneratedKey(int i, ProtocolDocument entity)
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
	public void prepareFileAttachements(java.util.List<org.molgenis.protocol.ProtocolDocument> entities, java.io.File baseDir) throws java.io.IOException
	{
		for(org.molgenis.protocol.ProtocolDocument entity: entities)
		{	
			//set a dummy for the file if it was attached (to evade not null exceptions)
			if(entity.getDocumentAttachedFile() != null)
			{
				entity.setDocument("dummy");
			}
		}
	}

	public boolean saveFileAttachements(java.util.List<org.molgenis.protocol.ProtocolDocument> entities, java.io.File baseDir) throws java.io.IOException
	{
		for(org.molgenis.protocol.ProtocolDocument entity: entities)
		{		
			//store a file attachement
			if(entity.getDocumentAttachedFile() != null)
			{
				String filename = entity.getDocumentAttachedFile().toString();
				String extension = filename.substring(filename.lastIndexOf('.'));
				filename = "ProtocolDocument/Document"+entity.getId()+extension;	
				entity.setDocument(filename);
		
				org.apache.commons.io.FileUtils.copyFile( entity.getDocumentAttachedFile(), new java.io.File( baseDir.toString()+"/"+ entity.getDocument() ) );
			}
		}
		return true;
	}
//Generated by MapperMrefs.java.ftl
	/** 
	 * This method queries the link tables to load mref fields. For performance reasons this is done for the whole batch.
	 * As a consequence the number of queries equals the number of mref fields. This may be memory hungry.
	 */
	public void mapMrefs( List<ProtocolDocument> entities ) throws DatabaseException			
	{
	}		
	
	/**
	 * This method updates the mref entity tables. It deletes existing and adds the new (this to ensure ordering).
	 */		
	public void storeMrefs( List<ProtocolDocument> entities ) throws DatabaseException, IOException, ParseException	
	{
	}
		
	
	public void removeMrefs( List<ProtocolDocument> entities ) throws DatabaseException, IOException, ParseException
	{
	}	
}
