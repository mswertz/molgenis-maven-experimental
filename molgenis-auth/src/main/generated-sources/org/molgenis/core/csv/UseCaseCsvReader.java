
/* File:        auth/model/UseCase.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
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

import org.molgenis.core.UseCase;


/**
 * Reads UseCase from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class UseCaseCsvReader extends CsvToDatabase<UseCase>
{
	public static final transient Logger logger = Logger.getLogger(UseCaseCsvReader.class);
	
			
	/**
	 * Imports UseCase from tab/comma delimited File
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
		final List<UseCase> useCasesMissingRefs = new ArrayList<UseCase>();
	
		//cache for objects to be imported from file (in batch)
		final List<UseCase> useCaseList = new ArrayList<UseCase>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			UseCase object = new UseCase();
			object.set(defaults, false); 
			object.set(tuple, false);				
			useCaseList.add(object);		
			
			//add to db when batch size is reached
			if(useCaseList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				useCasesMissingRefs.addAll(resolveForeignKeys(db, useCaseList));
				
				//update objects in the database using xref_label defined secondary key(s) 'UseCaseName' defined in xref_label
				db.update(useCaseList,dbAction, "UseCaseName");
				
				//clear for next batch						
				useCaseList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!useCaseList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			useCasesMissingRefs.addAll(resolveForeignKeys(db, useCaseList));
			//update objects in the database using xref_label defined secondary key(s) 'UseCaseName' defined in xref_label
			db.update(useCaseList,dbAction, "UseCaseName");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<UseCase> useCasesStillMissingRefs = resolveForeignKeys(db, useCasesMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(useCasesStillMissingRefs.size() > 0){
			throw new Exception("Import of 'UseCase' objects failed: attempting to resolve in-list references, but there are still UseCases referring to UseCases that are neither in the database nor in the list of to-be imported UseCases. (the first one being: "+useCasesStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(useCasesMissingRefs,DatabaseAction.UPDATE, "UseCaseName");
		
			//output count
			total.set(total.get() + useCaseList.size());
			logger.info("imported "+total.get()+" useCase from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param useCaseList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<UseCase> resolveForeignKeys(Database db, List<UseCase> useCaseList) throws Exception
	{
		//keep a list of UseCase instances that miss a reference which might be resolvable later
		List<UseCase> useCasesMissingRefs = new ArrayList<UseCase>();
	
		//update objects with foreign key values
		for(UseCase o:  useCaseList)
		{
			while(true){
				break;
			}
		}
		
		
		return useCasesMissingRefs;
	}
}

