
/* File:        observ/model/MolgenisFile.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.core.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.molgenis.framework.db.CsvToDatabase;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.Query;
import org.molgenis.framework.db.Database.DatabaseAction;
import org.molgenis.util.CsvReader;
import org.molgenis.util.Tuple;

import org.molgenis.core.MolgenisFile;


/**
 * Reads MolgenisFile from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class MolgenisFileCsvReader extends CsvToDatabase<MolgenisFile>
{
	public static final transient Logger logger = Logger.getLogger(MolgenisFileCsvReader.class);
	
			
	/**
	 * Imports MolgenisFile from tab/comma delimited File
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
		final List<MolgenisFile> molgenisFilesMissingRefs = new ArrayList<MolgenisFile>();
	
		//cache for objects to be imported from file (in batch)
		final List<MolgenisFile> molgenisFileList = new ArrayList<MolgenisFile>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			MolgenisFile object = new MolgenisFile();
			object.set(defaults, false); 
			object.set(tuple, false);				
			molgenisFileList.add(object);		
			
			//add to db when batch size is reached
			if(molgenisFileList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				molgenisFilesMissingRefs.addAll(resolveForeignKeys(db, molgenisFileList));
				
				//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
				db.update(molgenisFileList,dbAction, "name");
				
				//clear for next batch						
				molgenisFileList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!molgenisFileList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			molgenisFilesMissingRefs.addAll(resolveForeignKeys(db, molgenisFileList));
			//update objects in the database using xref_label defined secondary key(s) 'name' defined in xref_label
			db.update(molgenisFileList,dbAction, "name");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<MolgenisFile> molgenisFilesStillMissingRefs = resolveForeignKeys(db, molgenisFilesMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(molgenisFilesStillMissingRefs.size() > 0){
			throw new Exception("Import of 'MolgenisFile' objects failed: attempting to resolve in-list references, but there are still MolgenisFiles referring to MolgenisFiles that are neither in the database nor in the list of to-be imported MolgenisFiles. (the first one being: "+molgenisFilesStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(molgenisFilesMissingRefs,DatabaseAction.UPDATE, "name");
		
			//output count
			total.set(total.get() + molgenisFileList.size());
			logger.info("imported "+total.get()+" molgenisFile from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param molgenisFileList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<MolgenisFile> resolveForeignKeys(Database db, List<MolgenisFile> molgenisFileList) throws Exception
	{
		//keep a list of MolgenisFile instances that miss a reference which might be resolvable later
		List<MolgenisFile> molgenisFilesMissingRefs = new ArrayList<MolgenisFile>();
	
		//update objects with foreign key values
		for(MolgenisFile o:  molgenisFileList)
		{
			while(true){
				break;
			}
		}
		
		
		return molgenisFilesMissingRefs;
	}
}

