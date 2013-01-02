
/* File:        observ/model/Measurement_categories.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.pheno.csv;

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

import org.molgenis.pheno.Category;
import org.molgenis.pheno.Measurement;
import org.molgenis.pheno.Measurement_Categories;


/**
 * Reads Measurement_Categories from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class Measurement_CategoriesCsvReader extends CsvToDatabase<Measurement_Categories>
{
	public static final transient Logger logger = Logger.getLogger(Measurement_CategoriesCsvReader.class);
	
	//foreign key map for xref 'categories' (maps category.name -> category.id)			
	final Map<String,Integer> categoriesKeymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'measurement' (maps measurement.name -> measurement.id)			
	final Map<String,Integer> measurementKeymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports Measurement_Categories from tab/comma delimited File
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
		final List<Measurement_Categories> measurement_categoriessMissingRefs = new ArrayList<Measurement_Categories>();
	
		//cache for objects to be imported from file (in batch)
		final List<Measurement_Categories> measurement_categoriesList = new ArrayList<Measurement_Categories>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			Measurement_Categories object = new Measurement_Categories();
			object.set(defaults, false); 
			object.set(tuple, false);				
			measurement_categoriesList.add(object);		
			
			//add to db when batch size is reached
			if(measurement_categoriesList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				measurement_categoriessMissingRefs.addAll(resolveForeignKeys(db, measurement_categoriesList));
				
				//update objects in the database using xref_label defined secondary key(s) 'categories,Measurement' defined in xref_label
				db.update(measurement_categoriesList,dbAction, "categories", "Measurement");
				
				//clear for next batch						
				measurement_categoriesList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!measurement_categoriesList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			measurement_categoriessMissingRefs.addAll(resolveForeignKeys(db, measurement_categoriesList));
			//update objects in the database using xref_label defined secondary key(s) 'categories,Measurement' defined in xref_label
			db.update(measurement_categoriesList,dbAction, "categories", "Measurement");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<Measurement_Categories> measurement_categoriessStillMissingRefs = resolveForeignKeys(db, measurement_categoriessMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(measurement_categoriessStillMissingRefs.size() > 0){
			throw new Exception("Import of 'Measurement_Categories' objects failed: attempting to resolve in-list references, but there are still Measurement_Categoriess referring to Measurement_Categoriess that are neither in the database nor in the list of to-be imported Measurement_Categoriess. (the first one being: "+measurement_categoriessStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(measurement_categoriessMissingRefs,DatabaseAction.UPDATE, "categories", "Measurement");
		
			//output count
			total.set(total.get() + measurement_categoriesList.size());
			logger.info("imported "+total.get()+" measurement_categories from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param measurement_categoriesList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<Measurement_Categories> resolveForeignKeys(Database db, List<Measurement_Categories> measurement_categoriesList) throws Exception
	{
		//keep a list of Measurement_categories instances that miss a reference which might be resolvable later
		List<Measurement_Categories> measurement_categoriessMissingRefs = new ArrayList<Measurement_Categories>();
	
		//resolve xref 'categories' from category.name -> category.id
		for(Measurement_Categories o: measurement_categoriesList) 
		{
			if(o.getCategories_Name() != null) 
				categoriesKeymap.put(o.getCategories_Name(), null);
		}
		
		if(categoriesKeymap.size() > 0) 
		{
			List<Category> categoriesList = db.query(Category.class).in("name",new ArrayList<Object>(categoriesKeymap.keySet())).find();
			for(Category xref :  categoriesList)
			{
				categoriesKeymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'measurement' from measurement.name -> measurement.id
		for(Measurement_Categories o: measurement_categoriesList) 
		{
			if(o.getMeasurement_Name() != null) 
				measurementKeymap.put(o.getMeasurement_Name(), null);
		}
		
		if(measurementKeymap.size() > 0) 
		{
			List<Measurement> measurementList = db.query(Measurement.class).in("name",new ArrayList<Object>(measurementKeymap.keySet())).find();
			for(Measurement xref :  measurementList)
			{
				measurementKeymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(Measurement_Categories o:  measurement_categoriesList)
		{
			while(true){
				//update xref categories
				if(o.getCategories_Name() != null) 
				{
					String key = o.getCategories_Name();
					if(categoriesKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Measurement_categories' objects failed: cannot find Category for categories_name='"+o.getCategories_Name()+"'");
					}
					o.setCategories_Id(categoriesKeymap.get(key));
				}
				//update xref Measurement
				if(o.getMeasurement_Name() != null) 
				{
					String key = o.getMeasurement_Name();
					if(measurementKeymap.get(key) == null)
					{
						throw new Exception("Import of 'Measurement_categories' objects failed: cannot find Measurement for measurement_name='"+o.getMeasurement_Name()+"'");
					}
					o.setMeasurement_Id(measurementKeymap.get(key));
				}
				break;
			}
		}
		
		categoriesKeymap.clear();
		measurementKeymap.clear();
		
		return measurement_categoriessMissingRefs;
	}
}

