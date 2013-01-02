/* File:        app/JUnitTest.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.tests.TestDataSetGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import org.molgenis.Molgenis;
import org.molgenis.util.Entity;
import org.molgenis.util.SimpleTuple;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.Query;
import org.molgenis.framework.db.DatabaseException;

import static  org.testng.AssertJUnit.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import org.molgenis.pheno.Species;
import org.molgenis.pheno.AlternateId;
import org.molgenis.pheno.ObservationElement;
import org.molgenis.pheno.ObservationTarget;
import org.molgenis.pheno.ObservableFeature;
import org.molgenis.pheno.Measurement;
import org.molgenis.pheno.Category;
import org.molgenis.pheno.Individual;
import org.molgenis.pheno.Location;
import org.molgenis.pheno.Panel;
import org.molgenis.pheno.Observation;
import org.molgenis.pheno.ObservedValue;
import org.molgenis.organization.Investigation;
import org.molgenis.organization.InvestigationElement;
import org.molgenis.core.Identifiable;
import org.molgenis.core.Nameable;
import org.molgenis.core.Describable;
import org.molgenis.core.OntologyTerm;
import org.molgenis.core.Ontology;
import org.molgenis.core.MolgenisFile;
import org.molgenis.core.RuntimeProperty;
import org.molgenis.core.Publication;
import org.molgenis.core.UseCase;
import org.molgenis.core.MolgenisEntity;
import org.molgenis.protocol.Protocol;
import org.molgenis.protocol.ProtocolApplication;
import org.molgenis.protocol.ProtocolDocument;
import org.molgenis.protocol.Workflow;
import org.molgenis.protocol.WorkflowElement;
import org.molgenis.protocol.WorkflowElementParameter;
import org.molgenis.auth.MolgenisRole;
import org.molgenis.auth.MolgenisGroup;
import org.molgenis.auth.MolgenisRoleGroupLink;
import org.molgenis.auth.Contact;
import org.molgenis.auth.Person;
import org.molgenis.auth.Institute;
import org.molgenis.auth.MolgenisUser;
import org.molgenis.auth.MolgenisPermission;
import org.molgenis.auth.Authorizable;
import org.molgenis.pheno.ObservationElement_Ontolo12449;
import org.molgenis.pheno.ObservationElement_AlternateId;
import org.molgenis.pheno.Measurement_Categories;
import org.molgenis.pheno.Panel_Individuals;
import org.molgenis.pheno.Panel_FounderPanels;
import org.molgenis.organization.Investigation_Contacts;
import org.molgenis.protocol.Protocol_OntologyReference;
import org.molgenis.protocol.Protocol_Features;
import org.molgenis.protocol.Protocol_Subprotocols;
import org.molgenis.protocol.ProtocolApplication_Ontol11768;
import org.molgenis.protocol.ProtocolApplication_Performer;
import org.molgenis.protocol.WorkflowElement_PreviousSteps;


/**
 * This class produces a random data set
 */
public class TestDataSet
{
	//private static Database db;
	public static final transient Logger logger = Logger.getLogger(TestCsv.class);
	DateFormat dateFormat = new SimpleDateFormat(SimpleTuple.DATEFORMAT, Locale.US);
	DateFormat dateTimeFormat = new SimpleDateFormat(SimpleTuple.DATETIMEFORMAT, Locale.US);	 
	
	/**
	 * An empty set
	 */	
	public TestDataSet()
	{	
	}
		
	

    public TestDataSet(int size, int mrefSize) 
	{
		//generating Ontology data:
		for(Integer i = 0; i < size; i++)
		{
			Ontology e = new Ontology();
			//assign field name
			e.setName(truncate("ontology_name_"+i, 127));			
			//assign field ontologyAccession
			e.setOntologyAccession(truncate("ontology_ontologyaccession_"+i, 255));			
			//assign field ontologyURI
			e.setOntologyURI("ontology_ontologyuri"+i);
			this.ontology.add(e);
		}		
		//generating Species data:
		for(Integer i = 0; i < size; i++)
		{
			Species e = new Species();
			//assign field name
			e.setName(truncate("species_name_"+i, 127));			
			//assign field ontology
			if( this.ontology.size() > 0  && i < this.ontology.size())
			{ 
				Ontology ref = this.ontology.get(i);
				e.setOntology_Name(ref.getName() );
			}
			//assign field termAccession
			e.setTermAccession(truncate("species_termaccession_"+i, 255));			
			//assign field definition
			e.setDefinition(truncate("species_definition_"+i, 255));			
			//assign field termPath
			e.setTermPath(truncate("species_termpath_"+i, 1024));			
			this.species.add(e);
		}		
		//generating AlternateId data:
		for(Integer i = 0; i < size; i++)
		{
			AlternateId e = new AlternateId();
			//assign field name
			e.setName(truncate("alternateid_name_"+i, 127));			
			//assign field ontology
			if( this.ontology.size() > 0  && i < this.ontology.size())
			{ 
				Ontology ref = this.ontology.get(i);
				e.setOntology_Name(ref.getName() );
			}
			//assign field termAccession
			e.setTermAccession(truncate("alternateid_termaccession_"+i, 255));			
			//assign field definition
			e.setDefinition(truncate("alternateid_definition_"+i, 255));			
			//assign field termPath
			e.setTermPath(truncate("alternateid_termpath_"+i, 1024));			
			this.alternateId.add(e);
		}		
		//generating OntologyTerm data:
		for(Integer i = 0; i < size; i++)
		{
			OntologyTerm e = new OntologyTerm();
			//assign field name
			e.setName(truncate("ontologyterm_name_"+i, 127));			
			//assign field ontology
			if( this.ontology.size() > 0  && i < this.ontology.size())
			{ 
				Ontology ref = this.ontology.get(i);
				e.setOntology_Name(ref.getName() );
			}
			//assign field termAccession
			e.setTermAccession(truncate("ontologyterm_termaccession_"+i, 255));			
			//assign field definition
			e.setDefinition(truncate("ontologyterm_definition_"+i, 255));			
			//assign field termPath
			e.setTermPath(truncate("ontologyterm_termpath_"+i, 1024));			
			this.ontologyTerm.add(e);
		}		
		//generating MolgenisFile data:
		for(Integer i = 0; i < size; i++)
		{
			MolgenisFile e = new MolgenisFile();
			//assign field name
			e.setName(truncate("molgenisfile_name_"+i, 127));			
			//assign field Extension
			e.setExtension(truncate("molgenisfile_extension_"+i, 8));			
			this.molgenisFile.add(e);
		}		
		//generating RuntimeProperty data:
		for(Integer i = 0; i < size; i++)
		{
			RuntimeProperty e = new RuntimeProperty();
			//assign field name
			e.setName(truncate("runtimeproperty_name_"+i, 127));			
			//assign field Value
			e.setValue(truncate("runtimeproperty_value_"+i, 127));			
			this.runtimeProperty.add(e);
		}		
		//generating Publication data:
		for(Integer i = 0; i < size; i++)
		{
			Publication e = new Publication();
			//assign field name
			e.setName(truncate("publication_name_"+i, 127));			
			//assign field PubmedID
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setPubmedID_Name(ref.getName() );
			}
			//assign field DOI
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setDOI_Name(ref.getName() );
			}
			//assign field authorList
			e.setAuthorList("publication_authorlist"+i);
			//assign field Title
			e.setTitle(truncate("publication_title_"+i, 255));			
			//assign field Status
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setStatus_Name(ref.getName() );
			}
			//assign field Year
			e.setYear(truncate("publication_year_"+i, 255));			
			//assign field Journal
			e.setJournal(truncate("publication_journal_"+i, 255));			
			this.publication.add(e);
		}		
		//generating UseCase data:
		for(Integer i = 0; i < size; i++)
		{
			UseCase e = new UseCase();
			//assign field UseCaseName
			e.setUseCaseName(truncate("usecase_usecasename_"+i, 255));			
			//assign field SearchType
			e.setSearchType(truncate("usecase_searchtype_"+i, 255));			
			this.useCase.add(e);
		}		
		//generating MolgenisEntity data:
		for(Integer i = 0; i < size; i++)
		{
			MolgenisEntity e = new MolgenisEntity();
			//assign field name
			e.setName(truncate("molgenisentity_name_"+i, 255));			
			//assign field type_
			e.setType(truncate("molgenisentity_type__"+i, 255));			
			//assign field className
			e.setClassName(truncate("molgenisentity_classname_"+i, 255));			
			this.molgenisEntity.add(e);
		}		
		//generating MolgenisRole data:
		for(Integer i = 0; i < size; i++)
		{
			MolgenisRole e = new MolgenisRole();
			//assign field name
			e.setName(truncate("molgenisrole_name_"+i, 255));			
			this.molgenisRole.add(e);
		}		
		//generating MolgenisGroup data:
		for(Integer i = 0; i < size; i++)
		{
			MolgenisGroup e = new MolgenisGroup();
			//assign field name
			e.setName(truncate("molgenisgroup_name_"+i, 255));			
			this.molgenisGroup.add(e);
		}		
		//generating Institute data:
		for(Integer i = 0; i < size; i++)
		{
			Institute e = new Institute();
			//assign field Address
			e.setAddress("institute_address"+i);
			//assign field Phone
			e.setPhone(truncate("institute_phone_"+i, 255));			
			//assign field Email
			e.setEmail(truncate("institute_email_"+i, 255));			
			//assign field Fax
			e.setFax(truncate("institute_fax_"+i, 255));			
			//assign field tollFreePhone
			e.setTollFreePhone(truncate("institute_tollfreephone_"+i, 255));			
			//assign field City
			e.setCity(truncate("institute_city_"+i, 255));			
			//assign field Country
			e.setCountry(truncate("institute_country_"+i, 255));			
			//assign field name
			e.setName(truncate("institute_name_"+i, 255));			
			this.institute.add(e);
		}		
		//generating Person data:
		for(Integer i = 0; i < size; i++)
		{
			Person e = new Person();
			//assign field name
			e.setName(truncate("person_name_"+i, 255));			
			//assign field Address
			e.setAddress("person_address"+i);
			//assign field Phone
			e.setPhone(truncate("person_phone_"+i, 255));			
			//assign field Email
			e.setEmail(truncate("person_email_"+i, 255));			
			//assign field Fax
			e.setFax(truncate("person_fax_"+i, 255));			
			//assign field tollFreePhone
			e.setTollFreePhone(truncate("person_tollfreephone_"+i, 255));			
			//assign field City
			e.setCity(truncate("person_city_"+i, 255));			
			//assign field Country
			e.setCountry(truncate("person_country_"+i, 255));			
			//assign field FirstName
			e.setFirstName(truncate("person_firstname_"+i, 255));			
			//assign field MidInitials
			e.setMidInitials(truncate("person_midinitials_"+i, 255));			
			//assign field LastName
			e.setLastName(truncate("person_lastname_"+i, 255));			
			//assign field Title
			e.setTitle(truncate("person_title_"+i, 255));			
			//assign field Affiliation
			if( this.institute.size() > 0  && i < this.institute.size())
			{ 
				Institute ref = this.institute.get(i);
				e.setAffiliation_Name(ref.getName() );
			}
			//assign field Department
			e.setDepartment(truncate("person_department_"+i, 255));			
			//assign field Roles
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setRoles_Name(ref.getName() );
			}
			this.person.add(e);
		}		
		//generating Investigation data:
		for(Integer i = 0; i < size; i++)
		{
			Investigation e = new Investigation();
			//assign field name
			e.setName(truncate("investigation_name_"+i, 127));			
			//assign field description
			e.setDescription("investigation_description"+i);
			//assign field endDate
			e.setEndDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			//assign field contacts
			if( this.person.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.person.size() ? j : this.person.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.person.get(index).getName() );
				}
				e.setContacts_Name( nameList );
			}
			//assign field accession
			e.setAccession("investigation_accession"+i);
			this.investigation.add(e);
		}		
		//generating ObservationElement data:
		for(Integer i = 0; i < size; i++)
		{
			ObservationElement e = new ObservationElement();
			//assign field name
			e.setName(truncate("observationelement_name_"+i, 127));			
			//assign field description
			e.setDescription("observationelement_description"+i);
			//assign field Investigation
			if( this.investigation.size() > 0  && i < this.investigation.size())
			{ 
				Investigation ref = this.investigation.get(i);
				e.setInvestigation_Name(ref.getName() );
			}
			//assign field ontologyReference
			if( this.ontologyTerm.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.ontologyTerm.size() ? j : this.ontologyTerm.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.ontologyTerm.get(index).getName() );
				}
				e.setOntologyReference_Name( nameList );
			}
			//assign field AlternateId
			if( this.alternateId.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.alternateId.size() ? j : this.alternateId.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.alternateId.get(index).getName() );
				}
				e.setAlternateId_Name( nameList );
			}
			//assign field label
			e.setLabel(truncate("observationelement_label_"+i, 255));			
			this.observationElement.add(e);
		}		
		//generating ObservationTarget data:
		for(Integer i = 0; i < size; i++)
		{
			ObservationTarget e = new ObservationTarget();
			//assign field name
			e.setName(truncate("observationtarget_name_"+i, 127));			
			//assign field description
			e.setDescription("observationtarget_description"+i);
			//assign field Investigation
			if( this.investigation.size() > 0  && i < this.investigation.size())
			{ 
				Investigation ref = this.investigation.get(i);
				e.setInvestigation_Name(ref.getName() );
			}
			//assign field ontologyReference
			if( this.ontologyTerm.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.ontologyTerm.size() ? j : this.ontologyTerm.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.ontologyTerm.get(index).getName() );
				}
				e.setOntologyReference_Name( nameList );
			}
			//assign field AlternateId
			if( this.alternateId.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.alternateId.size() ? j : this.alternateId.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.alternateId.get(index).getName() );
				}
				e.setAlternateId_Name( nameList );
			}
			//assign field label
			e.setLabel(truncate("observationtarget_label_"+i, 255));			
			this.observationTarget.add(e);
		}		
		//generating ObservableFeature data:
		for(Integer i = 0; i < size; i++)
		{
			ObservableFeature e = new ObservableFeature();
			//assign field name
			e.setName(truncate("observablefeature_name_"+i, 127));			
			//assign field description
			e.setDescription("observablefeature_description"+i);
			//assign field Investigation
			if( this.investigation.size() > 0  && i < this.investigation.size())
			{ 
				Investigation ref = this.investigation.get(i);
				e.setInvestigation_Name(ref.getName() );
			}
			//assign field ontologyReference
			if( this.ontologyTerm.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.ontologyTerm.size() ? j : this.ontologyTerm.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.ontologyTerm.get(index).getName() );
				}
				e.setOntologyReference_Name( nameList );
			}
			//assign field AlternateId
			if( this.alternateId.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.alternateId.size() ? j : this.alternateId.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.alternateId.get(index).getName() );
				}
				e.setAlternateId_Name( nameList );
			}
			//assign field label
			e.setLabel(truncate("observablefeature_label_"+i, 255));			
			this.observableFeature.add(e);
		}		
		//generating Category data:
		for(Integer i = 0; i < size; i++)
		{
			Category e = new Category();
			//assign field name
			e.setName(truncate("category_name_"+i, 127));			
			//assign field description
			e.setDescription("category_description"+i);
			//assign field Investigation
			if( this.investigation.size() > 0  && i < this.investigation.size())
			{ 
				Investigation ref = this.investigation.get(i);
				e.setInvestigation_Name(ref.getName() );
			}
			//assign field ontologyReference
			if( this.ontologyTerm.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.ontologyTerm.size() ? j : this.ontologyTerm.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.ontologyTerm.get(index).getName() );
				}
				e.setOntologyReference_Name( nameList );
			}
			//assign field AlternateId
			if( this.alternateId.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.alternateId.size() ? j : this.alternateId.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.alternateId.get(index).getName() );
				}
				e.setAlternateId_Name( nameList );
			}
			//assign field label
			e.setLabel(truncate("category_label_"+i, 255));			
			//assign field code_string
			e.setCode_String(truncate("category_code_string_"+i, 255));			
			//assign field isMissing
			e.setIsMissing(randomBool(i));
			this.category.add(e);
		}		
		//generating Measurement data:
		for(Integer i = 0; i < size; i++)
		{
			Measurement e = new Measurement();
			//assign field name
			e.setName(truncate("measurement_name_"+i, 127));			
			//assign field description
			e.setDescription("measurement_description"+i);
			//assign field Investigation
			if( this.investigation.size() > 0  && i < this.investigation.size())
			{ 
				Investigation ref = this.investigation.get(i);
				e.setInvestigation_Name(ref.getName() );
			}
			//assign field ontologyReference
			if( this.ontologyTerm.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.ontologyTerm.size() ? j : this.ontologyTerm.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.ontologyTerm.get(index).getName() );
				}
				e.setOntologyReference_Name( nameList );
			}
			//assign field AlternateId
			if( this.alternateId.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.alternateId.size() ? j : this.alternateId.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.alternateId.get(index).getName() );
				}
				e.setAlternateId_Name( nameList );
			}
			//assign field label
			e.setLabel(truncate("measurement_label_"+i, 255));			
			//assign field unit
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setUnit_Name(ref.getName() );
			}
			//assign field dataType
			e.setDataType(randomEnum(new String[]{"xref","string","categorical","date","datetime","int","code","image","decimal","bool","file","log","data","exe"}));
			//assign field temporal
			e.setTemporal(randomBool(i));
			//assign field categories
			if( this.category.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.category.size() ? j : this.category.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.category.get(index).getName() );
				}
				e.setCategories_Name( nameList );
			}
			//assign field targettypeAllowedForRelation
			if( this.molgenisEntity.size() > 0  && i < this.molgenisEntity.size())
			{ 
				MolgenisEntity ref = this.molgenisEntity.get(i);
				e.setTargettypeAllowedForRelation_ClassName(ref.getClassName() );
			}
			//assign field panelLabelAllowedForRelation
			e.setPanelLabelAllowedForRelation(truncate("measurement_panellabelallowedforrelation_"+i, 255));			
			this.measurement.add(e);
		}		
		//generating Individual data:
		for(Integer i = 0; i < size; i++)
		{
			Individual e = new Individual();
			//assign field name
			e.setName(truncate("individual_name_"+i, 127));			
			//assign field description
			e.setDescription("individual_description"+i);
			//assign field Investigation
			if( this.investigation.size() > 0  && i < this.investigation.size())
			{ 
				Investigation ref = this.investigation.get(i);
				e.setInvestigation_Name(ref.getName() );
			}
			//assign field ontologyReference
			if( this.ontologyTerm.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.ontologyTerm.size() ? j : this.ontologyTerm.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.ontologyTerm.get(index).getName() );
				}
				e.setOntologyReference_Name( nameList );
			}
			//assign field AlternateId
			if( this.alternateId.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.alternateId.size() ? j : this.alternateId.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.alternateId.get(index).getName() );
				}
				e.setAlternateId_Name( nameList );
			}
			//assign field label
			e.setLabel(truncate("individual_label_"+i, 255));			
			//assign field Mother
			if( this.individual.size() > 0  && i < this.individual.size())
			{ 
				Individual ref = this.individual.get(i);
				e.setMother_Name(ref.getName() );
			}
			//assign field Father
			if( this.individual.size() > 0  && i < this.individual.size())
			{ 
				Individual ref = this.individual.get(i);
				e.setFather_Name(ref.getName() );
			}
			this.individual.add(e);
		}		
		//generating Location data:
		for(Integer i = 0; i < size; i++)
		{
			Location e = new Location();
			//assign field name
			e.setName(truncate("location_name_"+i, 127));			
			//assign field description
			e.setDescription("location_description"+i);
			//assign field Investigation
			if( this.investigation.size() > 0  && i < this.investigation.size())
			{ 
				Investigation ref = this.investigation.get(i);
				e.setInvestigation_Name(ref.getName() );
			}
			//assign field ontologyReference
			if( this.ontologyTerm.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.ontologyTerm.size() ? j : this.ontologyTerm.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.ontologyTerm.get(index).getName() );
				}
				e.setOntologyReference_Name( nameList );
			}
			//assign field AlternateId
			if( this.alternateId.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.alternateId.size() ? j : this.alternateId.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.alternateId.get(index).getName() );
				}
				e.setAlternateId_Name( nameList );
			}
			//assign field label
			e.setLabel(truncate("location_label_"+i, 255));			
			this.location.add(e);
		}		
		//generating Panel data:
		for(Integer i = 0; i < size; i++)
		{
			Panel e = new Panel();
			//assign field name
			e.setName(truncate("panel_name_"+i, 127));			
			//assign field description
			e.setDescription("panel_description"+i);
			//assign field Investigation
			if( this.investigation.size() > 0  && i < this.investigation.size())
			{ 
				Investigation ref = this.investigation.get(i);
				e.setInvestigation_Name(ref.getName() );
			}
			//assign field ontologyReference
			if( this.ontologyTerm.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.ontologyTerm.size() ? j : this.ontologyTerm.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.ontologyTerm.get(index).getName() );
				}
				e.setOntologyReference_Name( nameList );
			}
			//assign field AlternateId
			if( this.alternateId.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.alternateId.size() ? j : this.alternateId.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.alternateId.get(index).getName() );
				}
				e.setAlternateId_Name( nameList );
			}
			//assign field label
			e.setLabel(truncate("panel_label_"+i, 255));			
			//assign field Individuals
			if( this.individual.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.individual.size() ? j : this.individual.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.individual.get(index).getName() );
				}
				e.setIndividuals_Name( nameList );
			}
			//assign field Species
			if( this.species.size() > 0  && i < this.species.size())
			{ 
				Species ref = this.species.get(i);
				e.setSpecies_Name(ref.getName() );
			}
			//assign field PanelType
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setPanelType_Name(ref.getName() );
			}
			//assign field FounderPanels
			if( this.panel.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.panel.size() ? j : this.panel.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.panel.get(index).getName() );
				}
				e.setFounderPanels_Name( nameList );
			}
			this.panel.add(e);
		}		
		//generating MolgenisUser data:
		for(Integer i = 0; i < size; i++)
		{
			MolgenisUser e = new MolgenisUser();
			//assign field name
			e.setName(truncate("molgenisuser_name_"+i, 255));			
			//assign field Address
			e.setAddress("molgenisuser_address"+i);
			//assign field Phone
			e.setPhone(truncate("molgenisuser_phone_"+i, 255));			
			//assign field Email
			e.setEmail(truncate("molgenisuser_email_"+i, 255));			
			//assign field Fax
			e.setFax(truncate("molgenisuser_fax_"+i, 255));			
			//assign field tollFreePhone
			e.setTollFreePhone(truncate("molgenisuser_tollfreephone_"+i, 255));			
			//assign field City
			e.setCity(truncate("molgenisuser_city_"+i, 255));			
			//assign field Country
			e.setCountry(truncate("molgenisuser_country_"+i, 255));			
			//assign field FirstName
			e.setFirstName(truncate("molgenisuser_firstname_"+i, 255));			
			//assign field MidInitials
			e.setMidInitials(truncate("molgenisuser_midinitials_"+i, 255));			
			//assign field LastName
			e.setLastName(truncate("molgenisuser_lastname_"+i, 255));			
			//assign field Title
			e.setTitle(truncate("molgenisuser_title_"+i, 255));			
			//assign field Affiliation
			if( this.institute.size() > 0  && i < this.institute.size())
			{ 
				Institute ref = this.institute.get(i);
				e.setAffiliation_Name(ref.getName() );
			}
			//assign field Department
			e.setDepartment(truncate("molgenisuser_department_"+i, 255));			
			//assign field Roles
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setRoles_Name(ref.getName() );
			}
			//assign field password_
			e.setPassword(truncate("molgenisuser_password__"+i, 255));			
			//assign field activationCode
			e.setActivationCode(truncate("molgenisuser_activationcode_"+i, 255));			
			//assign field active
			e.setActive(randomBool(i));
			//assign field superuser
			e.setSuperuser(randomBool(i));
			this.molgenisUser.add(e);
		}		
		//generating Protocol data:
		for(Integer i = 0; i < size; i++)
		{
			Protocol e = new Protocol();
			//assign field name
			e.setName(truncate("protocol_name_"+i, 127));			
			//assign field description
			e.setDescription("protocol_description"+i);
			//assign field Investigation
			if( this.investigation.size() > 0  && i < this.investigation.size())
			{ 
				Investigation ref = this.investigation.get(i);
				e.setInvestigation_Name(ref.getName() );
			}
			//assign field ontologyReference
			if( this.ontologyTerm.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.ontologyTerm.size() ? j : this.ontologyTerm.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.ontologyTerm.get(index).getName() );
				}
				e.setOntologyReference_Name( nameList );
			}
			//assign field ProtocolType
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setProtocolType_Name(ref.getName() );
			}
			//assign field Features
			if( this.observableFeature.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.observableFeature.size() ? j : this.observableFeature.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.observableFeature.get(index).getName() );
				}
				e.setFeatures_Name( nameList );
			}
			//assign field TargetFilter
			e.setTargetFilter(truncate("protocol_targetfilter_"+i, 255));			
			//assign field Contact
			if( this.person.size() > 0  && i < this.person.size())
			{ 
				Person ref = this.person.get(i);
				e.setContact_Name(ref.getName() );
			}
			//assign field subprotocols
			if( this.protocol.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.protocol.size() ? j : this.protocol.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.protocol.get(index).getName() );
				}
				e.setSubprotocols_Name( nameList );
			}
			this.protocol.add(e);
		}		
		//generating Workflow data:
		for(Integer i = 0; i < size; i++)
		{
			Workflow e = new Workflow();
			//assign field name
			e.setName(truncate("workflow_name_"+i, 127));			
			//assign field description
			e.setDescription("workflow_description"+i);
			//assign field Investigation
			if( this.investigation.size() > 0  && i < this.investigation.size())
			{ 
				Investigation ref = this.investigation.get(i);
				e.setInvestigation_Name(ref.getName() );
			}
			//assign field ontologyReference
			if( this.ontologyTerm.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.ontologyTerm.size() ? j : this.ontologyTerm.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.ontologyTerm.get(index).getName() );
				}
				e.setOntologyReference_Name( nameList );
			}
			//assign field ProtocolType
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setProtocolType_Name(ref.getName() );
			}
			//assign field Features
			if( this.observableFeature.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.observableFeature.size() ? j : this.observableFeature.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.observableFeature.get(index).getName() );
				}
				e.setFeatures_Name( nameList );
			}
			//assign field TargetFilter
			e.setTargetFilter(truncate("workflow_targetfilter_"+i, 255));			
			//assign field Contact
			if( this.person.size() > 0  && i < this.person.size())
			{ 
				Person ref = this.person.get(i);
				e.setContact_Name(ref.getName() );
			}
			//assign field subprotocols
			if( this.protocol.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.protocol.size() ? j : this.protocol.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.protocol.get(index).getName() );
				}
				e.setSubprotocols_Name( nameList );
			}
			this.workflow.add(e);
		}		
		//generating ProtocolApplication data:
		for(Integer i = 0; i < size; i++)
		{
			ProtocolApplication e = new ProtocolApplication();
			//assign field name
			e.setName(truncate("protocolapplication_name_"+i, 127));			
			//assign field description
			e.setDescription("protocolapplication_description"+i);
			//assign field Investigation
			if( this.investigation.size() > 0  && i < this.investigation.size())
			{ 
				Investigation ref = this.investigation.get(i);
				e.setInvestigation_Name(ref.getName() );
			}
			//assign field ontologyReference
			if( this.ontologyTerm.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.ontologyTerm.size() ? j : this.ontologyTerm.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.ontologyTerm.get(index).getName() );
				}
				e.setOntologyReference_Name( nameList );
			}
			//assign field protocol
			if( this.protocol.size() > 0  && i < this.protocol.size())
			{ 
				Protocol ref = this.protocol.get(i);
				e.setProtocol_Name(ref.getName() );
			}
			//assign field Performer
			if( this.person.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.person.size() ? j : this.person.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.person.get(index).getName() );
				}
				e.setPerformer_Name( nameList );
			}
			this.protocolApplication.add(e);
		}		
		//generating ObservedValue data:
		for(Integer i = 0; i < size; i++)
		{
			ObservedValue e = new ObservedValue();
			//assign field Investigation
			if( this.investigation.size() > 0  && i < this.investigation.size())
			{ 
				Investigation ref = this.investigation.get(i);
				e.setInvestigation_Name(ref.getName() );
			}
			//assign field protocolApplication
			if( this.protocolApplication.size() > 0  && i < this.protocolApplication.size())
			{ 
				ProtocolApplication ref = this.protocolApplication.get(i);
				e.setProtocolApplication_Name(ref.getName() );
			}
			//assign field Feature
			if( this.observationElement.size() > 0  && i < this.observationElement.size())
			{ 
				ObservationElement ref = this.observationElement.get(i);
				e.setFeature_Name(ref.getName() );
			}
			//assign field Target
			if( this.observationElement.size() > 0  && i < this.observationElement.size())
			{ 
				ObservationElement ref = this.observationElement.get(i);
				e.setTarget_Name(ref.getName() );
			}
			//assign field ontologyReference
			if( this.ontologyTerm.size() > 0  && i < this.ontologyTerm.size())
			{ 
				OntologyTerm ref = this.ontologyTerm.get(i);
				e.setOntologyReference_Name(ref.getName() );
			}
			//assign field value
			e.setValue(truncate("observedvalue_value_"+i, 255));			
			//assign field relation
			if( this.observationElement.size() > 0  && i < this.observationElement.size())
			{ 
				ObservationElement ref = this.observationElement.get(i);
				e.setRelation_Name(ref.getName() );
			}
			//assign field time
			e.setTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			//assign field endtime
			e.setEndtime(new java.sql.Timestamp(new java.util.Date().getTime()));
			this.observedValue.add(e);
		}		
		//generating ProtocolDocument data:
		for(Integer i = 0; i < size; i++)
		{
			ProtocolDocument e = new ProtocolDocument();
			//assign field name
			e.setName(truncate("protocoldocument_name_"+i, 127));			
			//assign field Extension
			e.setExtension(truncate("protocoldocument_extension_"+i, 8));			
			//assign field protocol
			if( this.protocol.size() > 0  && i < this.protocol.size())
			{ 
				Protocol ref = this.protocol.get(i);
				e.setProtocol_Name(ref.getName() );
			}
			//assign field document
			e.setDocument("protocoldocument_document"+i);
			this.protocolDocument.add(e);
		}		
		//generating WorkflowElement data:
		for(Integer i = 0; i < size; i++)
		{
			WorkflowElement e = new WorkflowElement();
			//assign field name
			e.setName(truncate("workflowelement_name_"+i, 127));			
			//assign field Workflow
			if( this.workflow.size() > 0  && i < this.workflow.size())
			{ 
				Workflow ref = this.workflow.get(i);
				e.setWorkflow_Name(ref.getName() );
			}
			//assign field protocol
			if( this.protocol.size() > 0  && i < this.protocol.size())
			{ 
				Protocol ref = this.protocol.get(i);
				e.setProtocol_Name(ref.getName() );
			}
			//assign field PreviousSteps
			if( this.workflowElement.size() > 0)
			{
				//get a set of unique entity indexes
				Set<Integer> indexes = new LinkedHashSet<Integer>();
				for(int j = 0; j < mrefSize; j++)
				{	
					indexes.add(j < this.workflowElement.size() ? j : this.workflowElement.size()-1);
				}
				List<String> nameList = new ArrayList<String>();
				for(Integer index: indexes)
				{
					nameList.add( this.workflowElement.get(index).getName() );
				}
				e.setPreviousSteps_Name( nameList );
			}
			this.workflowElement.add(e);
		}		
		//generating WorkflowElementParameter data:
		for(Integer i = 0; i < size; i++)
		{
			WorkflowElementParameter e = new WorkflowElementParameter();
			//assign field WorkflowElement
			if( this.workflowElement.size() > 0  && i < this.workflowElement.size())
			{ 
				WorkflowElement ref = this.workflowElement.get(i);
				e.setWorkflowElement_Name(ref.getName() );
			}
			//assign field Parameter
			if( this.observableFeature.size() > 0  && i < this.observableFeature.size())
			{ 
				ObservableFeature ref = this.observableFeature.get(i);
				e.setParameter_Name(ref.getName() );
			}
			//assign field Value
			e.setValue(truncate("workflowelementparameter_value_"+i, 255));			
			this.workflowElementParameter.add(e);
		}		
		//generating MolgenisRoleGroupLink data:
		for(Integer i = 0; i < size; i++)
		{
			MolgenisRoleGroupLink e = new MolgenisRoleGroupLink();
			//assign field group_
			if( this.molgenisGroup.size() > 0  && i < this.molgenisGroup.size())
			{ 
				MolgenisGroup ref = this.molgenisGroup.get(i);
				e.setGroup_Name(ref.getName() );
			}
			//assign field role_
			if( this.molgenisRole.size() > 0  && i < this.molgenisRole.size())
			{ 
				MolgenisRole ref = this.molgenisRole.get(i);
				e.setRole_Name(ref.getName() );
			}
			this.molgenisRoleGroupLink.add(e);
		}		
		//generating MolgenisPermission data:
		for(Integer i = 0; i < size; i++)
		{
			MolgenisPermission e = new MolgenisPermission();
			//assign field role_
			if( this.molgenisRole.size() > 0  && i < this.molgenisRole.size())
			{ 
				MolgenisRole ref = this.molgenisRole.get(i);
				e.setRole_Name(ref.getName() );
			}
			//assign field entity
			if( this.molgenisEntity.size() > 0  && i < this.molgenisEntity.size())
			{ 
				MolgenisEntity ref = this.molgenisEntity.get(i);
				e.setEntity_ClassName(ref.getClassName() );
			}
			//assign field permission
			e.setPermission(randomEnum(new String[]{"read","write","own"}));
			this.molgenisPermission.add(e);
		}		
	}	 
	
	public String truncate(String value, int length)
	{
	   if (value != null && value.length() > length)
          value = value.substring(0, length-1);
       return value;
	}	
	 
	 /** Helper to get random element from a list */
	private int random(int max)
	{
		return new Long(Math.round(Math.floor( Math.random() * max ))).intValue();
	}
	
	private Boolean randomBool(int i)
	{
		return i % 2 == 0 ? true : false;
	}
	
	private String randomEnum(String[] options)
	{
		Integer index = Long.valueOf(Math.round(Math.random() * (options.length - 1) )).intValue();
		return options[index];
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (other == null || !this.getClass().equals(other.getClass()))
			return false;
		TestDataSet set = (TestDataSet) other;
		
		if ( this.species == null ? set.species != null : !this.species.equals( set.species ) )
			return false;
		if ( this.alternateId == null ? set.alternateId != null : !this.alternateId.equals( set.alternateId ) )
			return false;
		if ( this.observationElement == null ? set.observationElement != null : !this.observationElement.equals( set.observationElement ) )
			return false;
		if ( this.observationTarget == null ? set.observationTarget != null : !this.observationTarget.equals( set.observationTarget ) )
			return false;
		if ( this.observableFeature == null ? set.observableFeature != null : !this.observableFeature.equals( set.observableFeature ) )
			return false;
		if ( this.measurement == null ? set.measurement != null : !this.measurement.equals( set.measurement ) )
			return false;
		if ( this.category == null ? set.category != null : !this.category.equals( set.category ) )
			return false;
		if ( this.individual == null ? set.individual != null : !this.individual.equals( set.individual ) )
			return false;
		if ( this.location == null ? set.location != null : !this.location.equals( set.location ) )
			return false;
		if ( this.panel == null ? set.panel != null : !this.panel.equals( set.panel ) )
			return false;
		if ( this.observation == null ? set.observation != null : !this.observation.equals( set.observation ) )
			return false;
		if ( this.observedValue == null ? set.observedValue != null : !this.observedValue.equals( set.observedValue ) )
			return false;
		if ( this.investigation == null ? set.investigation != null : !this.investigation.equals( set.investigation ) )
			return false;
		if ( this.investigationElement == null ? set.investigationElement != null : !this.investigationElement.equals( set.investigationElement ) )
			return false;
		if ( this.identifiable == null ? set.identifiable != null : !this.identifiable.equals( set.identifiable ) )
			return false;
		if ( this.nameable == null ? set.nameable != null : !this.nameable.equals( set.nameable ) )
			return false;
		if ( this.describable == null ? set.describable != null : !this.describable.equals( set.describable ) )
			return false;
		if ( this.ontologyTerm == null ? set.ontologyTerm != null : !this.ontologyTerm.equals( set.ontologyTerm ) )
			return false;
		if ( this.ontology == null ? set.ontology != null : !this.ontology.equals( set.ontology ) )
			return false;
		if ( this.molgenisFile == null ? set.molgenisFile != null : !this.molgenisFile.equals( set.molgenisFile ) )
			return false;
		if ( this.runtimeProperty == null ? set.runtimeProperty != null : !this.runtimeProperty.equals( set.runtimeProperty ) )
			return false;
		if ( this.publication == null ? set.publication != null : !this.publication.equals( set.publication ) )
			return false;
		if ( this.useCase == null ? set.useCase != null : !this.useCase.equals( set.useCase ) )
			return false;
		if ( this.molgenisEntity == null ? set.molgenisEntity != null : !this.molgenisEntity.equals( set.molgenisEntity ) )
			return false;
		if ( this.protocol == null ? set.protocol != null : !this.protocol.equals( set.protocol ) )
			return false;
		if ( this.protocolApplication == null ? set.protocolApplication != null : !this.protocolApplication.equals( set.protocolApplication ) )
			return false;
		if ( this.protocolDocument == null ? set.protocolDocument != null : !this.protocolDocument.equals( set.protocolDocument ) )
			return false;
		if ( this.workflow == null ? set.workflow != null : !this.workflow.equals( set.workflow ) )
			return false;
		if ( this.workflowElement == null ? set.workflowElement != null : !this.workflowElement.equals( set.workflowElement ) )
			return false;
		if ( this.workflowElementParameter == null ? set.workflowElementParameter != null : !this.workflowElementParameter.equals( set.workflowElementParameter ) )
			return false;
		if ( this.molgenisRole == null ? set.molgenisRole != null : !this.molgenisRole.equals( set.molgenisRole ) )
			return false;
		if ( this.molgenisGroup == null ? set.molgenisGroup != null : !this.molgenisGroup.equals( set.molgenisGroup ) )
			return false;
		if ( this.molgenisRoleGroupLink == null ? set.molgenisRoleGroupLink != null : !this.molgenisRoleGroupLink.equals( set.molgenisRoleGroupLink ) )
			return false;
		if ( this.contact == null ? set.contact != null : !this.contact.equals( set.contact ) )
			return false;
		if ( this.person == null ? set.person != null : !this.person.equals( set.person ) )
			return false;
		if ( this.institute == null ? set.institute != null : !this.institute.equals( set.institute ) )
			return false;
		if ( this.molgenisUser == null ? set.molgenisUser != null : !this.molgenisUser.equals( set.molgenisUser ) )
			return false;
		if ( this.molgenisPermission == null ? set.molgenisPermission != null : !this.molgenisPermission.equals( set.molgenisPermission ) )
			return false;
		if ( this.authorizable == null ? set.authorizable != null : !this.authorizable.equals( set.authorizable ) )
			return false;
		if ( this.observationElement_ontolo12449 == null ? set.observationElement_ontolo12449 != null : !this.observationElement_ontolo12449.equals( set.observationElement_ontolo12449 ) )
			return false;
		if ( this.observationElement_AlternateId == null ? set.observationElement_AlternateId != null : !this.observationElement_AlternateId.equals( set.observationElement_AlternateId ) )
			return false;
		if ( this.measurement_categories == null ? set.measurement_categories != null : !this.measurement_categories.equals( set.measurement_categories ) )
			return false;
		if ( this.panel_Individuals == null ? set.panel_Individuals != null : !this.panel_Individuals.equals( set.panel_Individuals ) )
			return false;
		if ( this.panel_FounderPanels == null ? set.panel_FounderPanels != null : !this.panel_FounderPanels.equals( set.panel_FounderPanels ) )
			return false;
		if ( this.investigation_contacts == null ? set.investigation_contacts != null : !this.investigation_contacts.equals( set.investigation_contacts ) )
			return false;
		if ( this.protocol_ontologyReference == null ? set.protocol_ontologyReference != null : !this.protocol_ontologyReference.equals( set.protocol_ontologyReference ) )
			return false;
		if ( this.protocol_Features == null ? set.protocol_Features != null : !this.protocol_Features.equals( set.protocol_Features ) )
			return false;
		if ( this.protocol_subprotocols == null ? set.protocol_subprotocols != null : !this.protocol_subprotocols.equals( set.protocol_subprotocols ) )
			return false;
		if ( this.protocolApplication_ontol11768 == null ? set.protocolApplication_ontol11768 != null : !this.protocolApplication_ontol11768.equals( set.protocolApplication_ontol11768 ) )
			return false;
		if ( this.protocolApplication_Performer == null ? set.protocolApplication_Performer != null : !this.protocolApplication_Performer.equals( set.protocolApplication_Performer ) )
			return false;
		if ( this.workflowElement_PreviousSteps == null ? set.workflowElement_PreviousSteps != null : !this.workflowElement_PreviousSteps.equals( set.workflowElement_PreviousSteps ) )
			return false;
		
		return true;
	}
	
	@Override
 	public int hashCode() 
 	{ 
    	int hash = 1;
    	hash = hash * 31 + (this.species == null ? 0 : species.hashCode());
    	hash = hash * 31 + (this.alternateId == null ? 0 : alternateId.hashCode());
    	hash = hash * 31 + (this.observationElement == null ? 0 : observationElement.hashCode());
    	hash = hash * 31 + (this.observationTarget == null ? 0 : observationTarget.hashCode());
    	hash = hash * 31 + (this.observableFeature == null ? 0 : observableFeature.hashCode());
    	hash = hash * 31 + (this.measurement == null ? 0 : measurement.hashCode());
    	hash = hash * 31 + (this.category == null ? 0 : category.hashCode());
    	hash = hash * 31 + (this.individual == null ? 0 : individual.hashCode());
    	hash = hash * 31 + (this.location == null ? 0 : location.hashCode());
    	hash = hash * 31 + (this.panel == null ? 0 : panel.hashCode());
    	hash = hash * 31 + (this.observation == null ? 0 : observation.hashCode());
    	hash = hash * 31 + (this.observedValue == null ? 0 : observedValue.hashCode());
    	hash = hash * 31 + (this.investigation == null ? 0 : investigation.hashCode());
    	hash = hash * 31 + (this.investigationElement == null ? 0 : investigationElement.hashCode());
    	hash = hash * 31 + (this.identifiable == null ? 0 : identifiable.hashCode());
    	hash = hash * 31 + (this.nameable == null ? 0 : nameable.hashCode());
    	hash = hash * 31 + (this.describable == null ? 0 : describable.hashCode());
    	hash = hash * 31 + (this.ontologyTerm == null ? 0 : ontologyTerm.hashCode());
    	hash = hash * 31 + (this.ontology == null ? 0 : ontology.hashCode());
    	hash = hash * 31 + (this.molgenisFile == null ? 0 : molgenisFile.hashCode());
    	hash = hash * 31 + (this.runtimeProperty == null ? 0 : runtimeProperty.hashCode());
    	hash = hash * 31 + (this.publication == null ? 0 : publication.hashCode());
    	hash = hash * 31 + (this.useCase == null ? 0 : useCase.hashCode());
    	hash = hash * 31 + (this.molgenisEntity == null ? 0 : molgenisEntity.hashCode());
    	hash = hash * 31 + (this.protocol == null ? 0 : protocol.hashCode());
    	hash = hash * 31 + (this.protocolApplication == null ? 0 : protocolApplication.hashCode());
    	hash = hash * 31 + (this.protocolDocument == null ? 0 : protocolDocument.hashCode());
    	hash = hash * 31 + (this.workflow == null ? 0 : workflow.hashCode());
    	hash = hash * 31 + (this.workflowElement == null ? 0 : workflowElement.hashCode());
    	hash = hash * 31 + (this.workflowElementParameter == null ? 0 : workflowElementParameter.hashCode());
    	hash = hash * 31 + (this.molgenisRole == null ? 0 : molgenisRole.hashCode());
    	hash = hash * 31 + (this.molgenisGroup == null ? 0 : molgenisGroup.hashCode());
    	hash = hash * 31 + (this.molgenisRoleGroupLink == null ? 0 : molgenisRoleGroupLink.hashCode());
    	hash = hash * 31 + (this.contact == null ? 0 : contact.hashCode());
    	hash = hash * 31 + (this.person == null ? 0 : person.hashCode());
    	hash = hash * 31 + (this.institute == null ? 0 : institute.hashCode());
    	hash = hash * 31 + (this.molgenisUser == null ? 0 : molgenisUser.hashCode());
    	hash = hash * 31 + (this.molgenisPermission == null ? 0 : molgenisPermission.hashCode());
    	hash = hash * 31 + (this.authorizable == null ? 0 : authorizable.hashCode());
    	hash = hash * 31 + (this.observationElement_ontolo12449 == null ? 0 : observationElement_ontolo12449.hashCode());
    	hash = hash * 31 + (this.observationElement_AlternateId == null ? 0 : observationElement_AlternateId.hashCode());
    	hash = hash * 31 + (this.measurement_categories == null ? 0 : measurement_categories.hashCode());
    	hash = hash * 31 + (this.panel_Individuals == null ? 0 : panel_Individuals.hashCode());
    	hash = hash * 31 + (this.panel_FounderPanels == null ? 0 : panel_FounderPanels.hashCode());
    	hash = hash * 31 + (this.investigation_contacts == null ? 0 : investigation_contacts.hashCode());
    	hash = hash * 31 + (this.protocol_ontologyReference == null ? 0 : protocol_ontologyReference.hashCode());
    	hash = hash * 31 + (this.protocol_Features == null ? 0 : protocol_Features.hashCode());
    	hash = hash * 31 + (this.protocol_subprotocols == null ? 0 : protocol_subprotocols.hashCode());
    	hash = hash * 31 + (this.protocolApplication_ontol11768 == null ? 0 : protocolApplication_ontol11768.hashCode());
    	hash = hash * 31 + (this.protocolApplication_Performer == null ? 0 : protocolApplication_Performer.hashCode());
    	hash = hash * 31 + (this.workflowElement_PreviousSteps == null ? 0 : workflowElement_PreviousSteps.hashCode());
    	return hash;
  	}
	
	public List<Species> species = new ArrayList<Species>();
	public List<AlternateId> alternateId = new ArrayList<AlternateId>();
	public List<ObservationElement> observationElement = new ArrayList<ObservationElement>();
	public List<ObservationTarget> observationTarget = new ArrayList<ObservationTarget>();
	public List<ObservableFeature> observableFeature = new ArrayList<ObservableFeature>();
	public List<Measurement> measurement = new ArrayList<Measurement>();
	public List<Category> category = new ArrayList<Category>();
	public List<Individual> individual = new ArrayList<Individual>();
	public List<Location> location = new ArrayList<Location>();
	public List<Panel> panel = new ArrayList<Panel>();
	public List<Observation> observation = new ArrayList<Observation>();
	public List<ObservedValue> observedValue = new ArrayList<ObservedValue>();
	public List<Investigation> investigation = new ArrayList<Investigation>();
	public List<InvestigationElement> investigationElement = new ArrayList<InvestigationElement>();
	public List<Identifiable> identifiable = new ArrayList<Identifiable>();
	public List<Nameable> nameable = new ArrayList<Nameable>();
	public List<Describable> describable = new ArrayList<Describable>();
	public List<OntologyTerm> ontologyTerm = new ArrayList<OntologyTerm>();
	public List<Ontology> ontology = new ArrayList<Ontology>();
	public List<MolgenisFile> molgenisFile = new ArrayList<MolgenisFile>();
	public List<RuntimeProperty> runtimeProperty = new ArrayList<RuntimeProperty>();
	public List<Publication> publication = new ArrayList<Publication>();
	public List<UseCase> useCase = new ArrayList<UseCase>();
	public List<MolgenisEntity> molgenisEntity = new ArrayList<MolgenisEntity>();
	public List<Protocol> protocol = new ArrayList<Protocol>();
	public List<ProtocolApplication> protocolApplication = new ArrayList<ProtocolApplication>();
	public List<ProtocolDocument> protocolDocument = new ArrayList<ProtocolDocument>();
	public List<Workflow> workflow = new ArrayList<Workflow>();
	public List<WorkflowElement> workflowElement = new ArrayList<WorkflowElement>();
	public List<WorkflowElementParameter> workflowElementParameter = new ArrayList<WorkflowElementParameter>();
	public List<MolgenisRole> molgenisRole = new ArrayList<MolgenisRole>();
	public List<MolgenisGroup> molgenisGroup = new ArrayList<MolgenisGroup>();
	public List<MolgenisRoleGroupLink> molgenisRoleGroupLink = new ArrayList<MolgenisRoleGroupLink>();
	public List<Contact> contact = new ArrayList<Contact>();
	public List<Person> person = new ArrayList<Person>();
	public List<Institute> institute = new ArrayList<Institute>();
	public List<MolgenisUser> molgenisUser = new ArrayList<MolgenisUser>();
	public List<MolgenisPermission> molgenisPermission = new ArrayList<MolgenisPermission>();
	public List<Authorizable> authorizable = new ArrayList<Authorizable>();
	public List<ObservationElement_Ontolo12449> observationElement_ontolo12449 = new ArrayList<ObservationElement_Ontolo12449>();
	public List<ObservationElement_AlternateId> observationElement_AlternateId = new ArrayList<ObservationElement_AlternateId>();
	public List<Measurement_Categories> measurement_categories = new ArrayList<Measurement_Categories>();
	public List<Panel_Individuals> panel_Individuals = new ArrayList<Panel_Individuals>();
	public List<Panel_FounderPanels> panel_FounderPanels = new ArrayList<Panel_FounderPanels>();
	public List<Investigation_Contacts> investigation_contacts = new ArrayList<Investigation_Contacts>();
	public List<Protocol_OntologyReference> protocol_ontologyReference = new ArrayList<Protocol_OntologyReference>();
	public List<Protocol_Features> protocol_Features = new ArrayList<Protocol_Features>();
	public List<Protocol_Subprotocols> protocol_subprotocols = new ArrayList<Protocol_Subprotocols>();
	public List<ProtocolApplication_Ontol11768> protocolApplication_ontol11768 = new ArrayList<ProtocolApplication_Ontol11768>();
	public List<ProtocolApplication_Performer> protocolApplication_Performer = new ArrayList<ProtocolApplication_Performer>();
	public List<WorkflowElement_PreviousSteps> workflowElement_PreviousSteps = new ArrayList<WorkflowElement_PreviousSteps>();
}