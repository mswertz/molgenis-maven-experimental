
/* File:        auth/model/MolgenisRoleGroupLink.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.auth.csv;

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

import org.molgenis.auth.MolgenisGroup;
import org.molgenis.auth.MolgenisRole;
import org.molgenis.auth.MolgenisRoleGroupLink;


/**
 * Reads MolgenisRoleGroupLink from a delimited (csv) file, resolving xrefs to ids where needed, that is the tricky bit ;-)
 */
public class MolgenisRoleGroupLinkCsvReader extends CsvToDatabase<MolgenisRoleGroupLink>
{
	public static final transient Logger logger = Logger.getLogger(MolgenisRoleGroupLinkCsvReader.class);
	
	//foreign key map for xref 'group_' (maps molgenisGroup.name -> molgenisGroup.id)			
	final Map<String,Integer> group_Keymap = new TreeMap<String,Integer>();	
	//foreign key map for xref 'role_' (maps molgenisRole.name -> molgenisRole.id)			
	final Map<String,Integer> role_Keymap = new TreeMap<String,Integer>();	
			
	/**
	 * Imports MolgenisRoleGroupLink from tab/comma delimited File
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
		final List<MolgenisRoleGroupLink> molgenisRoleGroupLinksMissingRefs = new ArrayList<MolgenisRoleGroupLink>();
	
		//cache for objects to be imported from file (in batch)
		final List<MolgenisRoleGroupLink> molgenisRoleGroupLinkList = new ArrayList<MolgenisRoleGroupLink>(BATCH_SIZE);
		//wrapper to count
		final IntegerWrapper total = new IntegerWrapper(0);
		reader.setMissingValues(missingValues);
		for(Tuple tuple: reader)
		{
			//parse object, setting defaults and values from file
			MolgenisRoleGroupLink object = new MolgenisRoleGroupLink();
			object.set(defaults, false); 
			object.set(tuple, false);				
			molgenisRoleGroupLinkList.add(object);		
			
			//add to db when batch size is reached
			if(molgenisRoleGroupLinkList.size() == BATCH_SIZE)
			{
				//resolve foreign keys and copy those entities that could not be resolved to the missingRefs list
				molgenisRoleGroupLinksMissingRefs.addAll(resolveForeignKeys(db, molgenisRoleGroupLinkList));
				
				//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
				db.update(molgenisRoleGroupLinkList,dbAction, "id");
				
				//clear for next batch						
				molgenisRoleGroupLinkList.clear();		
				
				//keep count
				total.set(total.get() + BATCH_SIZE);				
			}
		}
			
		//add remaining elements to the database
		if(!molgenisRoleGroupLinkList.isEmpty())
		{
			//resolve foreign keys, again keeping track of those entities that could not be solved
			molgenisRoleGroupLinksMissingRefs.addAll(resolveForeignKeys(db, molgenisRoleGroupLinkList));
			//update objects in the database using xref_label defined secondary key(s) 'id' defined in xref_label
			db.update(molgenisRoleGroupLinkList,dbAction, "id");
		}
		
		//second import round, try to resolve FK's for entities again as they might have referred to entities in the imported list
		List<MolgenisRoleGroupLink> molgenisRoleGroupLinksStillMissingRefs = resolveForeignKeys(db, molgenisRoleGroupLinksMissingRefs);
		
		//if there are still missing references, throw error and rollback
		if(molgenisRoleGroupLinksStillMissingRefs.size() > 0){
			throw new Exception("Import of 'MolgenisRoleGroupLink' objects failed: attempting to resolve in-list references, but there are still MolgenisRoleGroupLinks referring to MolgenisRoleGroupLinks that are neither in the database nor in the list of to-be imported MolgenisRoleGroupLinks. (the first one being: "+molgenisRoleGroupLinksStillMissingRefs.get(0)+")");
		}
		//else update the entities in the database with the found references and return total
		else
		{				
			db.update(molgenisRoleGroupLinksMissingRefs,DatabaseAction.UPDATE, "id");
		
			//output count
			total.set(total.get() + molgenisRoleGroupLinkList.size());
			logger.info("imported "+total.get()+" molgenisRoleGroupLink from CSV"); 
		
			return total.get();
		}
	}	
	
	/**
	 * This method tries to resolve foreign keys (i.e. xref_field) based on the secondary key/key (i.e. xref_labels).
	 *
	 * @param db database
	 * @param molgenisRoleGroupLinkList 
	 * @return the entities for which foreign keys cannot be resolved
	 */
	private List<MolgenisRoleGroupLink> resolveForeignKeys(Database db, List<MolgenisRoleGroupLink> molgenisRoleGroupLinkList) throws Exception
	{
		//keep a list of MolgenisRoleGroupLink instances that miss a reference which might be resolvable later
		List<MolgenisRoleGroupLink> molgenisRoleGroupLinksMissingRefs = new ArrayList<MolgenisRoleGroupLink>();
	
		//resolve xref 'group_' from molgenisGroup.name -> molgenisGroup.id
		for(MolgenisRoleGroupLink o: molgenisRoleGroupLinkList) 
		{
			if(o.getGroup_Name() != null) 
				group_Keymap.put(o.getGroup_Name(), null);
		}
		
		if(group_Keymap.size() > 0) 
		{
			List<MolgenisGroup> group_List = db.query(MolgenisGroup.class).in("name",new ArrayList<Object>(group_Keymap.keySet())).find();
			for(MolgenisGroup xref :  group_List)
			{
				group_Keymap.put(xref.getName(), xref.getId());
			}
		}
		//resolve xref 'role_' from molgenisRole.name -> molgenisRole.id
		for(MolgenisRoleGroupLink o: molgenisRoleGroupLinkList) 
		{
			if(o.getRole_Name() != null) 
				role_Keymap.put(o.getRole_Name(), null);
		}
		
		if(role_Keymap.size() > 0) 
		{
			List<MolgenisRole> role_List = db.query(MolgenisRole.class).in("name",new ArrayList<Object>(role_Keymap.keySet())).find();
			for(MolgenisRole xref :  role_List)
			{
				role_Keymap.put(xref.getName(), xref.getId());
			}
		}
		//update objects with foreign key values
		for(MolgenisRoleGroupLink o:  molgenisRoleGroupLinkList)
		{
			while(true){
				//update xref group_
				if(o.getGroup_Name() != null) 
				{
					String key = o.getGroup_Name();
					if(group_Keymap.get(key) == null)
					{
						throw new Exception("Import of 'MolgenisRoleGroupLink' objects failed: cannot find MolgenisGroup for group__name='"+o.getGroup_Name()+"'");
					}
					o.setGroup_Id(group_Keymap.get(key));
				}
				//update xref role_
				if(o.getRole_Name() != null) 
				{
					String key = o.getRole_Name();
					if(role_Keymap.get(key) == null)
					{
						throw new Exception("Import of 'MolgenisRoleGroupLink' objects failed: cannot find MolgenisRole for role__name='"+o.getRole_Name()+"'");
					}
					o.setRole_Id(role_Keymap.get(key));
				}
				break;
			}
		}
		
		group_Keymap.clear();
		role_Keymap.clear();
		
		return molgenisRoleGroupLinksMissingRefs;
	}
}

