
/* Date:        October 22, 2012
 * 
 * generator:   org.molgenis.generators.csv.CsvExportGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package app;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.Query;
import org.molgenis.framework.db.QueryRule;
import org.molgenis.framework.db.QueryRule.Operator;
import org.molgenis.model.MolgenisModelException;
import org.molgenis.util.Entity;
import org.molgenis.util.CsvFileWriter;


	import org.molgenis.auth.MolgenisRole;
	import org.molgenis.auth.MolgenisGroup;
	import org.molgenis.auth.Institute;
	import org.molgenis.core.Ontology;
	import org.molgenis.core.OntologyTerm;
	import org.molgenis.auth.Person;
	import org.molgenis.auth.MolgenisUser;
	import org.molgenis.auth.MolgenisRoleGroupLink;
	import org.molgenis.core.MolgenisFile;
	import org.molgenis.core.RuntimeProperty;
	import org.molgenis.core.Publication;
	import org.molgenis.core.UseCase;
	import org.molgenis.core.MolgenisEntity;
	import org.molgenis.auth.MolgenisPermission;

public class CsvExport
{
	static Logger logger = Logger.getLogger(CsvExport.class.getSimpleName());
		
		/**
	 * Default export all using a target directory and a database to export
	 * @param directory
	 * @param db
	 * @throws Exception
	 */
	public void exportAll(File directory, Database db) throws Exception
	{
		exportAll(directory, db, true, new QueryRule[]{});
	}
	
	/**
	 * Export all using a set of QueryRules used for all entities if applicable to that entity
	 * @param directory
	 * @param db
	 * @param rules
	 * @throws Exception
	 */
	public void exportAll(File directory, Database db, QueryRule ... rules) throws Exception
	{
		exportAll(directory, db, true, rules);
	}
	
	/**
	 * Export all where a boolean skip autoid fields forces an ignore of the auto id field ("id")
	 * @param directory
	 * @param db
	 * @param skipAutoId
	 * @throws Exception
	 */
	public void exportAll(File directory, Database db, boolean skipAutoId) throws Exception
	{
		exportAll(directory, db, skipAutoId, new QueryRule[]{});
	}
	
	/**
	 * Export all with both a boolean skipAutoId and a set of QueryRules to specify both the skipping of auto id, and applying of a filter
	 * @param directory
	 * @param db
	 * @param skipAutoId
	 * @param rules
	 * @throws Exception
	 */
	public void exportAll(File directory, Database db, boolean skipAutoId, QueryRule ... rules) throws Exception
	{				
		exportMolgenisRole(db, new File(directory+"/molgenisrole.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name"}) : null, rules);		
		exportMolgenisGroup(db, new File(directory+"/molgenisgroup.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name"}) : null, rules);		
		exportInstitute(db, new File(directory+"/institute.txt"), skipAutoId ? Arrays.asList(new String[]{"Address","Phone","Email","Fax","tollFreePhone","City","Country","name"}) : null, rules);		
		exportOntology(db, new File(directory+"/ontology.txt"), skipAutoId ? Arrays.asList(new String[]{"name","ontologyAccession","ontologyURI"}) : null, rules);		
		exportOntologyTerm(db, new File(directory+"/ontologyterm.txt"), skipAutoId ? Arrays.asList(new String[]{"name","ontology_name","termAccession","definition","termPath"}) : null, rules);		
		exportPerson(db, new File(directory+"/person.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name","Address","Phone","Email","Fax","tollFreePhone","City","Country","FirstName","MidInitials","LastName","Title","Affiliation_name","Department","Roles_name"}) : null, rules);		
		exportMolgenisUser(db, new File(directory+"/molgenisuser.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name","Address","Phone","Email","Fax","tollFreePhone","City","Country","FirstName","MidInitials","LastName","Title","Affiliation_name","Department","Roles_name","password_","activationCode","active","superuser"}) : null, rules);		
		exportMolgenisRoleGroupLink(db, new File(directory+"/molgenisrolegrouplink.txt"), skipAutoId ? Arrays.asList(new String[]{"group__name","role__name"}) : null, rules);		
		exportMolgenisFile(db, new File(directory+"/molgenisfile.txt"), skipAutoId ? Arrays.asList(new String[]{"name","Extension"}) : null, rules);		
		exportRuntimeProperty(db, new File(directory+"/runtimeproperty.txt"), skipAutoId ? Arrays.asList(new String[]{"name","Value"}) : null, rules);		
		exportPublication(db, new File(directory+"/publication.txt"), skipAutoId ? Arrays.asList(new String[]{"name","PubmedID_name","DOI_name","authorList","Title","Status_name","Year","Journal"}) : null, rules);		
		exportUseCase(db, new File(directory+"/usecase.txt"), skipAutoId ? Arrays.asList(new String[]{"UseCaseName","SearchType"}) : null, rules);		
		exportMolgenisEntity(db, new File(directory+"/molgenisentity.txt"), skipAutoId ? Arrays.asList(new String[]{"name","type_","className"}) : null, rules);		
		exportMolgenisPermission(db, new File(directory+"/molgenispermission.txt"), skipAutoId ? Arrays.asList(new String[]{"role__name","entity_className","permission"}) : null, rules);		
			
		logger.debug("done");
	}
	
   /**
	* Export without system tables.
	*/
	public void exportRegular(File directory, Database db, boolean skipAutoId) throws Exception
	{
		exportRegular(directory, db, skipAutoId, new QueryRule[]{});
	}
	
   /**
	* Export without system tables.
	*/
	public void exportRegular(File directory, Database db, boolean skipAutoId, QueryRule ... rules) throws Exception
	{				
		exportInstitute(db, new File(directory+"/institute.txt"), skipAutoId ? Arrays.asList(new String[]{"Address","Phone","Email","Fax","tollFreePhone","City","Country","name"}) : null, rules);		
		exportOntology(db, new File(directory+"/ontology.txt"), skipAutoId ? Arrays.asList(new String[]{"name","ontologyAccession","ontologyURI"}) : null, rules);		
		exportOntologyTerm(db, new File(directory+"/ontologyterm.txt"), skipAutoId ? Arrays.asList(new String[]{"name","ontology_name","termAccession","definition","termPath"}) : null, rules);		
		exportPerson(db, new File(directory+"/person.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name","Address","Phone","Email","Fax","tollFreePhone","City","Country","FirstName","MidInitials","LastName","Title","Affiliation_name","Department","Roles_name"}) : null, rules);		
		exportMolgenisFile(db, new File(directory+"/molgenisfile.txt"), skipAutoId ? Arrays.asList(new String[]{"name","Extension"}) : null, rules);		
		exportRuntimeProperty(db, new File(directory+"/runtimeproperty.txt"), skipAutoId ? Arrays.asList(new String[]{"name","Value"}) : null, rules);		
		exportPublication(db, new File(directory+"/publication.txt"), skipAutoId ? Arrays.asList(new String[]{"name","PubmedID_name","DOI_name","authorList","Title","Status_name","Year","Journal"}) : null, rules);		
		exportUseCase(db, new File(directory+"/usecase.txt"), skipAutoId ? Arrays.asList(new String[]{"UseCaseName","SearchType"}) : null, rules);		
			
		logger.debug("done");
	}
	
	public void exportAll(File directory, List ... entityLists) throws Exception
	{				
		for(List<? extends Entity> l: entityLists) if(l.size()>0)
		{
			if(l.get(0).getClass().equals(MolgenisRole.class))
				exportMolgenisRole(l, new File(directory+"/molgenisrole.txt"));		
			if(l.get(0).getClass().equals(MolgenisGroup.class))
				exportMolgenisGroup(l, new File(directory+"/molgenisgroup.txt"));		
			if(l.get(0).getClass().equals(Institute.class))
				exportInstitute(l, new File(directory+"/institute.txt"));		
			if(l.get(0).getClass().equals(Ontology.class))
				exportOntology(l, new File(directory+"/ontology.txt"));		
			if(l.get(0).getClass().equals(OntologyTerm.class))
				exportOntologyTerm(l, new File(directory+"/ontologyterm.txt"));		
			if(l.get(0).getClass().equals(Person.class))
				exportPerson(l, new File(directory+"/person.txt"));		
			if(l.get(0).getClass().equals(MolgenisUser.class))
				exportMolgenisUser(l, new File(directory+"/molgenisuser.txt"));		
			if(l.get(0).getClass().equals(MolgenisRoleGroupLink.class))
				exportMolgenisRoleGroupLink(l, new File(directory+"/molgenisrolegrouplink.txt"));		
			if(l.get(0).getClass().equals(MolgenisFile.class))
				exportMolgenisFile(l, new File(directory+"/molgenisfile.txt"));		
			if(l.get(0).getClass().equals(RuntimeProperty.class))
				exportRuntimeProperty(l, new File(directory+"/runtimeproperty.txt"));		
			if(l.get(0).getClass().equals(Publication.class))
				exportPublication(l, new File(directory+"/publication.txt"));		
			if(l.get(0).getClass().equals(UseCase.class))
				exportUseCase(l, new File(directory+"/usecase.txt"));		
			if(l.get(0).getClass().equals(MolgenisEntity.class))
				exportMolgenisEntity(l, new File(directory+"/molgenisentity.txt"));		
			if(l.get(0).getClass().equals(MolgenisPermission.class))
				exportMolgenisPermission(l, new File(directory+"/molgenispermission.txt"));		
		}
			
		logger.debug("done");
	}
	
	/**
	* Export while excluding or including certain entity types. Defaults set: skip autoId, no QueryRules.
	* If exclusion is set to true, the specialCases are used to exlude those entities from the export (entities not in list are exported).
	* If exclusion is set to false, the specialCases are used to include those entities in the export (only entities in list are exported).
	*/
	public void exportSpecial(File directory, Database db, List<Class<? extends Entity>> specialCases, boolean exclusion) throws Exception
	{
		exportSpecial(directory, db, true, specialCases, exclusion, new QueryRule[]{});
	}
	
	/**
	* Export while excluding or including certain entity types.
	* If exclusion is set to true, the specialCases are used to exlude those entities from the export (entities not in list are exported).
	* If exclusion is set to false, the specialCases are used to include those entities in the export (only entities in list are exported).
	* TODO: Could maybe replace exportAll(File directory, List ... entityLists) ?
	*/
	public void exportSpecial(File directory, Database db, boolean skipAutoId, List<Class<? extends Entity>> specialCases, boolean exclusion, QueryRule ... rules) throws Exception
	{
		if((exclusion && !specialCases.contains(MolgenisRole.class)) || (!exclusion && specialCases.contains(MolgenisRole.class)))
			{ exportMolgenisRole(db, new File(directory+"/molgenisrole.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisGroup.class)) || (!exclusion && specialCases.contains(MolgenisGroup.class)))
			{ exportMolgenisGroup(db, new File(directory+"/molgenisgroup.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name"}) : null, rules); }
		if((exclusion && !specialCases.contains(Institute.class)) || (!exclusion && specialCases.contains(Institute.class)))
			{ exportInstitute(db, new File(directory+"/institute.txt"), skipAutoId ? Arrays.asList(new String[]{"Address","Phone","Email","Fax","tollFreePhone","City","Country","name"}) : null, rules); }
		if((exclusion && !specialCases.contains(Ontology.class)) || (!exclusion && specialCases.contains(Ontology.class)))
			{ exportOntology(db, new File(directory+"/ontology.txt"), skipAutoId ? Arrays.asList(new String[]{"name","ontologyAccession","ontologyURI"}) : null, rules); }
		if((exclusion && !specialCases.contains(OntologyTerm.class)) || (!exclusion && specialCases.contains(OntologyTerm.class)))
			{ exportOntologyTerm(db, new File(directory+"/ontologyterm.txt"), skipAutoId ? Arrays.asList(new String[]{"name","ontology_name","termAccession","definition","termPath"}) : null, rules); }
		if((exclusion && !specialCases.contains(Person.class)) || (!exclusion && specialCases.contains(Person.class)))
			{ exportPerson(db, new File(directory+"/person.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name","Address","Phone","Email","Fax","tollFreePhone","City","Country","FirstName","MidInitials","LastName","Title","Affiliation_name","Department","Roles_name"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisUser.class)) || (!exclusion && specialCases.contains(MolgenisUser.class)))
			{ exportMolgenisUser(db, new File(directory+"/molgenisuser.txt"), skipAutoId ? Arrays.asList(new String[]{"__Type","name","Address","Phone","Email","Fax","tollFreePhone","City","Country","FirstName","MidInitials","LastName","Title","Affiliation_name","Department","Roles_name","password_","activationCode","active","superuser"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisRoleGroupLink.class)) || (!exclusion && specialCases.contains(MolgenisRoleGroupLink.class)))
			{ exportMolgenisRoleGroupLink(db, new File(directory+"/molgenisrolegrouplink.txt"), skipAutoId ? Arrays.asList(new String[]{"group__name","role__name"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisFile.class)) || (!exclusion && specialCases.contains(MolgenisFile.class)))
			{ exportMolgenisFile(db, new File(directory+"/molgenisfile.txt"), skipAutoId ? Arrays.asList(new String[]{"name","Extension"}) : null, rules); }
		if((exclusion && !specialCases.contains(RuntimeProperty.class)) || (!exclusion && specialCases.contains(RuntimeProperty.class)))
			{ exportRuntimeProperty(db, new File(directory+"/runtimeproperty.txt"), skipAutoId ? Arrays.asList(new String[]{"name","Value"}) : null, rules); }
		if((exclusion && !specialCases.contains(Publication.class)) || (!exclusion && specialCases.contains(Publication.class)))
			{ exportPublication(db, new File(directory+"/publication.txt"), skipAutoId ? Arrays.asList(new String[]{"name","PubmedID_name","DOI_name","authorList","Title","Status_name","Year","Journal"}) : null, rules); }
		if((exclusion && !specialCases.contains(UseCase.class)) || (!exclusion && specialCases.contains(UseCase.class)))
			{ exportUseCase(db, new File(directory+"/usecase.txt"), skipAutoId ? Arrays.asList(new String[]{"UseCaseName","SearchType"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisEntity.class)) || (!exclusion && specialCases.contains(MolgenisEntity.class)))
			{ exportMolgenisEntity(db, new File(directory+"/molgenisentity.txt"), skipAutoId ? Arrays.asList(new String[]{"name","type_","className"}) : null, rules); }
		if((exclusion && !specialCases.contains(MolgenisPermission.class)) || (!exclusion && specialCases.contains(MolgenisPermission.class)))
			{ exportMolgenisPermission(db, new File(directory+"/molgenispermission.txt"), skipAutoId ? Arrays.asList(new String[]{"role__name","entity_className","permission"}) : null, rules); }
	
		logger.debug("done");
	}
	
		private QueryRule[] matchQueryRulesToEntity(org.molgenis.model.elements.Entity e, QueryRule ... rules) throws MolgenisModelException
	{
		ArrayList<QueryRule> tmpResult = new ArrayList<QueryRule>();
		for(QueryRule q : rules){
			if(!(e.getAllField(q.getField()) == null)){
				tmpResult.add(q); //field is okay for this entity
			}
			//special case: eg. investigation.name -> if current entity is 'investigation', use field 'name'
			String[] splitField = q.getField().split("\\.");
			if(splitField.length == 2){
				if(e.getName().equals(splitField[0])){
					QueryRule copy = new QueryRule(q);
					copy.setField(splitField[1]);
					tmpResult.add(copy);
				}
			}
		}
		QueryRule[] result = new QueryRule[tmpResult.size()];
		for(int i=0; i<result.length; i++){
			result[i] = tmpResult.get(i);
		}
		return result;
	}

	/**
	 *	export MolgenisRole to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisRole(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisRole.class, new QueryRule("__Type",Operator.EQUALS, "MolgenisRole")) > 0)
		{
			
			Query<MolgenisRole> query = db.query(MolgenisRole.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "MolgenisRole");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisRole"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisRoleWriter = new CsvFileWriter(f);
				query.find(molgenisRoleWriter, fieldsToExport);
				molgenisRoleWriter.close();
			}
		}
	}
	
	public void exportMolgenisRole(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisRoleWriter = new CsvFileWriter(file, notNulls);
			molgenisRoleWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisRoleWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisRoleWriter.close();
		}
	}
	/**
	 *	export MolgenisGroup to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisGroup(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisGroup.class, new QueryRule("__Type",Operator.EQUALS, "MolgenisGroup")) > 0)
		{
			
			Query<MolgenisGroup> query = db.query(MolgenisGroup.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "MolgenisGroup");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisGroup"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisGroupWriter = new CsvFileWriter(f);
				query.find(molgenisGroupWriter, fieldsToExport);
				molgenisGroupWriter.close();
			}
		}
	}
	
	public void exportMolgenisGroup(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisGroupWriter = new CsvFileWriter(file, notNulls);
			molgenisGroupWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisGroupWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisGroupWriter.close();
		}
	}
	/**
	 *	export Institute to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportInstitute(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Institute.class) > 0)
		{
			
			Query<Institute> query = db.query(Institute.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Institute"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter instituteWriter = new CsvFileWriter(f);
				query.find(instituteWriter, fieldsToExport);
				instituteWriter.close();
			}
		}
	}
	
	public void exportInstitute(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter instituteWriter = new CsvFileWriter(file, notNulls);
			instituteWriter.writeHeader();
			for(Entity e: entities)
			{
				instituteWriter.writeRow((org.molgenis.util.Entity)e);
			}
			instituteWriter.close();
		}
	}
	/**
	 *	export Ontology to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportOntology(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Ontology.class) > 0)
		{
			
			Query<Ontology> query = db.query(Ontology.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Ontology"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter ontologyWriter = new CsvFileWriter(f);
				query.find(ontologyWriter, fieldsToExport);
				ontologyWriter.close();
			}
		}
	}
	
	public void exportOntology(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter ontologyWriter = new CsvFileWriter(file, notNulls);
			ontologyWriter.writeHeader();
			for(Entity e: entities)
			{
				ontologyWriter.writeRow((org.molgenis.util.Entity)e);
			}
			ontologyWriter.close();
		}
	}
	/**
	 *	export OntologyTerm to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportOntologyTerm(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(OntologyTerm.class) > 0)
		{
			
			Query<OntologyTerm> query = db.query(OntologyTerm.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("OntologyTerm"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter ontologyTermWriter = new CsvFileWriter(f);
				query.find(ontologyTermWriter, fieldsToExport);
				ontologyTermWriter.close();
			}
		}
	}
	
	public void exportOntologyTerm(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter ontologyTermWriter = new CsvFileWriter(file, notNulls);
			ontologyTermWriter.writeHeader();
			for(Entity e: entities)
			{
				ontologyTermWriter.writeRow((org.molgenis.util.Entity)e);
			}
			ontologyTermWriter.close();
		}
	}
	/**
	 *	export Person to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportPerson(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Person.class, new QueryRule("__Type",Operator.EQUALS, "Person")) > 0)
		{
			
			Query<Person> query = db.query(Person.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "Person");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Person"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter personWriter = new CsvFileWriter(f);
				query.find(personWriter, fieldsToExport);
				personWriter.close();
			}
		}
	}
	
	public void exportPerson(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter personWriter = new CsvFileWriter(file, notNulls);
			personWriter.writeHeader();
			for(Entity e: entities)
			{
				personWriter.writeRow((org.molgenis.util.Entity)e);
			}
			personWriter.close();
		}
	}
	/**
	 *	export MolgenisUser to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisUser(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisUser.class, new QueryRule("__Type",Operator.EQUALS, "MolgenisUser")) > 0)
		{
			
			Query<MolgenisUser> query = db.query(MolgenisUser.class);
			QueryRule type = new QueryRule("__Type",Operator.EQUALS, "MolgenisUser");
			query.addRules(type);
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisUser"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisUserWriter = new CsvFileWriter(f);
				query.find(molgenisUserWriter, fieldsToExport);
				molgenisUserWriter.close();
			}
		}
	}
	
	public void exportMolgenisUser(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisUserWriter = new CsvFileWriter(file, notNulls);
			molgenisUserWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisUserWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisUserWriter.close();
		}
	}
	/**
	 *	export MolgenisRoleGroupLink to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisRoleGroupLink(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisRoleGroupLink.class) > 0)
		{
			
			Query<MolgenisRoleGroupLink> query = db.query(MolgenisRoleGroupLink.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisRoleGroupLink"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisRoleGroupLinkWriter = new CsvFileWriter(f);
				query.find(molgenisRoleGroupLinkWriter, fieldsToExport);
				molgenisRoleGroupLinkWriter.close();
			}
		}
	}
	
	public void exportMolgenisRoleGroupLink(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisRoleGroupLinkWriter = new CsvFileWriter(file, notNulls);
			molgenisRoleGroupLinkWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisRoleGroupLinkWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisRoleGroupLinkWriter.close();
		}
	}
	/**
	 *	export MolgenisFile to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisFile(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisFile.class) > 0)
		{
			
			Query<MolgenisFile> query = db.query(MolgenisFile.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisFile"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisFileWriter = new CsvFileWriter(f);
				query.find(molgenisFileWriter, fieldsToExport);
				molgenisFileWriter.close();
			}
		}
	}
	
	public void exportMolgenisFile(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisFileWriter = new CsvFileWriter(file, notNulls);
			molgenisFileWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisFileWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisFileWriter.close();
		}
	}
	/**
	 *	export RuntimeProperty to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportRuntimeProperty(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(RuntimeProperty.class) > 0)
		{
			
			Query<RuntimeProperty> query = db.query(RuntimeProperty.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("RuntimeProperty"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter runtimePropertyWriter = new CsvFileWriter(f);
				query.find(runtimePropertyWriter, fieldsToExport);
				runtimePropertyWriter.close();
			}
		}
	}
	
	public void exportRuntimeProperty(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter runtimePropertyWriter = new CsvFileWriter(file, notNulls);
			runtimePropertyWriter.writeHeader();
			for(Entity e: entities)
			{
				runtimePropertyWriter.writeRow((org.molgenis.util.Entity)e);
			}
			runtimePropertyWriter.close();
		}
	}
	/**
	 *	export Publication to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportPublication(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(Publication.class) > 0)
		{
			
			Query<Publication> query = db.query(Publication.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("Publication"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter publicationWriter = new CsvFileWriter(f);
				query.find(publicationWriter, fieldsToExport);
				publicationWriter.close();
			}
		}
	}
	
	public void exportPublication(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter publicationWriter = new CsvFileWriter(file, notNulls);
			publicationWriter.writeHeader();
			for(Entity e: entities)
			{
				publicationWriter.writeRow((org.molgenis.util.Entity)e);
			}
			publicationWriter.close();
		}
	}
	/**
	 *	export UseCase to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportUseCase(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(UseCase.class) > 0)
		{
			
			Query<UseCase> query = db.query(UseCase.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("UseCase"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter useCaseWriter = new CsvFileWriter(f);
				query.find(useCaseWriter, fieldsToExport);
				useCaseWriter.close();
			}
		}
	}
	
	public void exportUseCase(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter useCaseWriter = new CsvFileWriter(file, notNulls);
			useCaseWriter.writeHeader();
			for(Entity e: entities)
			{
				useCaseWriter.writeRow((org.molgenis.util.Entity)e);
			}
			useCaseWriter.close();
		}
	}
	/**
	 *	export MolgenisEntity to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisEntity(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisEntity.class) > 0)
		{
			
			Query<MolgenisEntity> query = db.query(MolgenisEntity.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisEntity"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisEntityWriter = new CsvFileWriter(f);
				query.find(molgenisEntityWriter, fieldsToExport);
				molgenisEntityWriter.close();
			}
		}
	}
	
	public void exportMolgenisEntity(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisEntityWriter = new CsvFileWriter(file, notNulls);
			molgenisEntityWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisEntityWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisEntityWriter.close();
		}
	}
	/**
	 *	export MolgenisPermission to file.
	 *  @param db the database to export from.
	 *  @param f the file to export to.
	 */
	public void exportMolgenisPermission(Database db, File f, List<String> fieldsToExport, QueryRule ... rules) throws DatabaseException, IOException, ParseException, MolgenisModelException
	{
		if(db.count(MolgenisPermission.class) > 0)
		{
			
			Query<MolgenisPermission> query = db.query(MolgenisPermission.class);
			
			QueryRule[] newRules = matchQueryRulesToEntity(db.getMetaData().getEntity("MolgenisPermission"), rules);
			query.addRules(newRules);
			int count = query.count();
			if(count > 0){
				CsvFileWriter molgenisPermissionWriter = new CsvFileWriter(f);
				query.find(molgenisPermissionWriter, fieldsToExport);
				molgenisPermissionWriter.close();
			}
		}
	}
	
	public void exportMolgenisPermission(List<? extends Entity> entities, File file) throws IOException, MolgenisModelException
	{
		if(entities.size()>0)
		{
			//filter nulls
			List<String> fields = entities.get(0).getFields();
			List<String> notNulls = new ArrayList<String>();
			
			for(String f: fields)
			{
				for(Entity e: entities)
				{
					if(e.get(f) != null)
					{
						notNulls.add(f);
						break;
					}
				}
			}			
			
			//write
			CsvFileWriter molgenisPermissionWriter = new CsvFileWriter(file, notNulls);
			molgenisPermissionWriter.writeHeader();
			for(Entity e: entities)
			{
				molgenisPermissionWriter.writeRow((org.molgenis.util.Entity)e);
			}
			molgenisPermissionWriter.close();
		}
	}
}