/* File:        app/JUnitTest.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
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


import org.molgenis.auth.MolgenisRole;
import org.molgenis.auth.MolgenisGroup;
import org.molgenis.auth.MolgenisRoleGroupLink;
import org.molgenis.auth.Contact;
import org.molgenis.auth.Person;
import org.molgenis.auth.Institute;
import org.molgenis.auth.MolgenisUser;
import org.molgenis.auth.MolgenisPermission;
import org.molgenis.auth.Authorizable;
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
		
		return true;
	}
	
	@Override
 	public int hashCode() 
 	{ 
    	int hash = 1;
    	hash = hash * 31 + (this.molgenisRole == null ? 0 : molgenisRole.hashCode());
    	hash = hash * 31 + (this.molgenisGroup == null ? 0 : molgenisGroup.hashCode());
    	hash = hash * 31 + (this.molgenisRoleGroupLink == null ? 0 : molgenisRoleGroupLink.hashCode());
    	hash = hash * 31 + (this.contact == null ? 0 : contact.hashCode());
    	hash = hash * 31 + (this.person == null ? 0 : person.hashCode());
    	hash = hash * 31 + (this.institute == null ? 0 : institute.hashCode());
    	hash = hash * 31 + (this.molgenisUser == null ? 0 : molgenisUser.hashCode());
    	hash = hash * 31 + (this.molgenisPermission == null ? 0 : molgenisPermission.hashCode());
    	hash = hash * 31 + (this.authorizable == null ? 0 : authorizable.hashCode());
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
    	return hash;
  	}
	
	public List<MolgenisRole> molgenisRole = new ArrayList<MolgenisRole>();
	public List<MolgenisGroup> molgenisGroup = new ArrayList<MolgenisGroup>();
	public List<MolgenisRoleGroupLink> molgenisRoleGroupLink = new ArrayList<MolgenisRoleGroupLink>();
	public List<Contact> contact = new ArrayList<Contact>();
	public List<Person> person = new ArrayList<Person>();
	public List<Institute> institute = new ArrayList<Institute>();
	public List<MolgenisUser> molgenisUser = new ArrayList<MolgenisUser>();
	public List<MolgenisPermission> molgenisPermission = new ArrayList<MolgenisPermission>();
	public List<Authorizable> authorizable = new ArrayList<Authorizable>();
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
}