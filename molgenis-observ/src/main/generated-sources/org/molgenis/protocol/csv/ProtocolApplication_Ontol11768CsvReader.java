
/* File:        observ/model/ProtocolApplication_ontol11768.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.protocol.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.log4j.Logger;
import org.molgenis.framework.db.CsvToDatabase;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.Query;
import org.molgenis.framework.db.Database.DatabaseAction;
import org.molgenis.util.CsvReader;
import org.molgenis.util.Tuple;

import org.molgenis.core.OntologyTerm;
import org.molgenis.protocol.ProtocolApplication;
import org.molgenis.protocol.ProtocolApplication_Ontol11768;


/**
 * Reads ProtocolApplication_Ontol11768 from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class ProtocolApplication_Ontol11768CsvReader extends CsvToDatabase<ProtocolApplication_Ontol11768>
{
	public static final transient Logger logger = Logger.getLogger(ProtocolApplication_Ontol11768CsvReader.class);
	
	//foreign key map for xref 'ontologyReference' (maps ontologyTerm.name -> ontologyTerm.id)			
	final Map<String,Integer> ontologyReferenceKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'investigationElement' (maps protocolApplication.name -> protocolApplication.id)			
	final Map<String,Integer> investigationElementKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports ProtocolApplication_Ontol11768 from tab/comma delimited File
	 * @param db database to import into
	 * @param reader csv reader to load data from
	 * @param defaults to set default values for each row
	 * @param dbAction indicating wether to add,update,remove etc
	 * @param missingValues indicating what value in the csv is treated as 'null' (e.g. "" or "NA")
	 * @return number of elements imported
	 */
	public int importCsv(final Database db, CsvReader reader, final Tuple defaults, final DatabaseAction dbAction, final String missingValues) throws DatabaseException, IOException, Exception 
	{
		//cache for entities of which xrefs couldn't be resolved (e.g. if there is a self-refence)
		//these entities can be updated with their xrefs in a second round when all entities are in the database
		final List<ProtocolApplication_Ontol11768> protocolApplication_ontol11768sMissingRefs = new ArrayList<ProtocolApplication_Ontol11768>();
	
		//cache for objects to be imported from file (in batch)
		final List<ProtocolApplication_Ontol11768> protocolApplication_ontol11768List = new ArrayList<ProtocolApplication_Ontol11768>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			ProtocolApplication_Ontol11768 object = new ProtocolApplication_Ontol11768();
			object.set(defaults, false); 
			object.set(tuple, false);				
			protocolApplication_ontol11768List.add(object);		
			
			//add to db when batch size is reached
			if(protocolApplication_ontol11768List.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				protocolApplication_ontol11768sMissingRefs.addAll(resolveForeignKeys(db, protocolApplication_ontol11768List));
				
				//update objects in the database using xref_label defined secondary key(s) 'ontologyReference,InvestigationElement' defined in xref_label
				db.update(protocolApplication_ontol11768List,dbAction, "ontologyReference", "InvestigationElement");
				
				//clear for next batch						
				protocolApplication_ontol11768List.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!protocolApplication_ontol11768List.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			protocolApplication_ontol11768sMissingRefs.addAll(resolveForeignKeys(db, protocolApplication_ontol11768List));
			//update objects in the database using xref_label defined secondary key(s) 'ontologyReference,InvestigationElement' defined in xref_label
			db.update(protocolApplication_ontol11768List,dbAction, "ontologyReference", "InvestigationElement");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<ProtocolApplication_Ontol11768> protocolApplication_ontol11768sStillMissingRefs = resolveForeignKeys(db, protocolApplication_ontol11768sMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(protocolApplication_ontol11768sStillMissingRefs.size() > 0){
			throw new Exception("Import of 'ProtocolApplication_Ontol11768' objects failed: attempting to resolve in-list references, but there are still ProtocolApplication_Ontol11768s referring to ProtocolApplication_Ontol11768s that are neither in the database nor in the list of to-be imported ProtocolApplication_Ontol11768s. (the first one being: "+protocolApplication_ontol11768sStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(protocolApplication_ontol11768sMissingRefs,DatabaseAction.UPDATE, "ontologyReference", "InvestigationElement");
		
			//output count
			total.set(total.get() + protocolApplication_ontol11768List.size());
			logger.info("imported "+total.get()+" protocolApplication_ontol11768 from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param protocolApplication_ontol11768List 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<ProtocolApplication_Ontol11768> resolveForeignKeys(Database db, List<ProtocolApplication_Ontol11768> protocolApplication_ontol11768List) throws Exception
	{
		//keep a list of ProtocolApplication_ontol11768 instances that miss a reference which might be resolvable later
		List<ProtocolApplication_Ontol11768> protocolApplication_ontol11768sMissingRefs = new ArrayList<ProtocolApplication_Ontol11768>();
	
		//resolve xref 'ontologyReference' from ontologyTerm.name -> ontologyTerm.id
		for(ProtocolApplication_Ontol11768 o: protocolApplication_ontol11768List) 
		{
			if(o.getOntologyReference_Name() != null) 
				ontologyReferenceKeymap.put(o.getOntologyReference_Name(), null);
		}
		
		if(ontologyReferenceKeymap.size() > 0) 
		{
			List<OntologyTerm> ontologyReferenceList = db.query(OntologyTerm.class).in("name",new ArrayList<Object>(ontologyReferenceKeymap.keySet())).find();
			for(OntologyTerm xref :  ontologyReferenceList)
			{
				ontologyReferenceKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'investigationElement' from protocolApplication.name -> protocolApplication.id
		for(ProtocolApplication_Ontol11768 o: protocolApplication_ontol11768List) 
		{
			if(o.getInvestigationElement_Name() != null) 
				investigationElementKeymap.put(o.getInvestigationElement_Name(), null);
		}
		
		if(investigationElementKeymap.size() > 0) 
		{
			List<ProtocolApplication> investigationElementList = db.query(ProtocolApplication.class).in("name",new ArrayList<Object>(investigationElementKeymap.keySet())).find();
			for(ProtocolApplication xref :  investigationElementList)
			{
				investigationElementKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(ProtocolApplication_Ontol11768 o:  protocolApplication_ontol11768List)
		{
			while(true){
				//update xref ontologyReference
				if(o.getOntologyReference_Name() != null) 
				{
					String key = o.getOntologyReference_Name();
					if(ontologyReferenceKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ProtocolApplication_ontol11768' objects failed: cannot find OntologyTerm for ontologyReference_name='"+o.getOntologyReference_Name()+"'");
					}
					o.setOntologyReference_Id(ontologyReferenceKeymap.get(key));
				}
				//update xref InvestigationElement
				if(o.getInvestigationElement_Name() != null) 
				{
					String key = o.getInvestigationElement_Name();
					if(investigationElementKeymap.get(key) == null)
					{
						throw new Exception("Import of 'ProtocolApplication_ontol11768' objects failed: cannot find ProtocolApplication for investigationElement_name='"+o.getInvestigationElement_Name()+"'");
					}
					o.setInvestigationElement_Id(investigationElementKeymap.get(key));
				}
				break;
			}
		}
		
		ontologyReferenceKeymap.clear();
		investigationElementKeymap.clear();
		
		return protocolApplication_ontol11768sMissingRefs;
	}
}

