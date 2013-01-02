
/* File:        Auth/html/MolgenisUser.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.auth.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.auth.Institute;
import org.molgenis.core.OntologyTerm;
import org.molgenis.auth.MolgenisUser;

import org.molgenis.auth.csv.InstituteCsvReader;
import org.molgenis.core.csv.OntologyTermCsvReader;
import org.molgenis.auth.csv.MolgenisUserCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity MolgenisUser
 * @see EntityForm
 */
public class MolgenisUserForm extends EntityForm<MolgenisUser>
{
	private static final long serialVersionUID = 1L;
	
	public MolgenisUserForm()
	{
		super();
	}
	
	public MolgenisUserForm(MolgenisUser entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<MolgenisUser> getEntityClass()
	{
		return MolgenisUser.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("id");
		headers.add("__Type");
		headers.add("name");
		headers.add("Address");
		headers.add("Phone");
		headers.add("Email");
		headers.add("Fax");
		headers.add("tollFreePhone");
		headers.add("City");
		headers.add("Country");
		headers.add("First Name");
		headers.add("Mid Initials");
		headers.add("Last Name");
		headers.add("Title");
		headers.add("Affiliation");
		headers.add("Department");
		headers.add("Roles");
		headers.add("password_");
		headers.add("activationCode");
		headers.add("active");
		headers.add("superuser");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=MolgenisUser, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("MolgenisUser_id",getEntity().getId());
			
			input.setLabel("id");
			input.setDescription("automatically generated id");
			input.setNillable(false);
			input.setReadonly(true); //automatic fields that are readonly, are also readonly on newrecord
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//__Type: Field(entity=MolgenisRole, name=__Type, type=enum, auto=true, nillable=false, readonly=true, default=null, enum_options=[MolgenisRole, MolgenisGroup, MolgenisUser, Person])
		{
			EnumInput input = new EnumInput("MolgenisUser___Type",getEntity().get__Type());
			
			input.setLabel("__Type");
			input.setDescription("Subtypes have to be set to allow searching");
			input.setNillable(false);
			input.setReadonly(true); //automatic fields that are readonly, are also readonly on newrecord
			input.setOptions(getEntity().get__TypeOptions());
			input.setHidden(true);
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Name: Field(entity=MolgenisRole, name=name, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisUser_name",getEntity().getName());
			
			input.setLabel("name");
			input.setDescription("name");
			input.setNillable(false);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Address: Field(entity=Person, name=Address, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("MolgenisUser_Address",getEntity().getAddress());
			
			input.setLabel("Address");
			input.setDescription("The address of the Contact.");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Phone: Field(entity=Person, name=Phone, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisUser_Phone",getEntity().getPhone());
			
			input.setLabel("Phone");
			input.setDescription("The telephone number of the Contact including the suitable area codes.");
			input.setNillable(true);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Email: Field(entity=Person, name=Email, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisUser_Email",getEntity().getEmail());
			
			input.setLabel("Email");
			input.setDescription("The email address of the Contact.");
			input.setNillable(true);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Fax: Field(entity=Person, name=Fax, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisUser_Fax",getEntity().getFax());
			
			input.setLabel("Fax");
			input.setDescription("The fax number of the Contact.");
			input.setNillable(true);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//TollFreePhone: Field(entity=Person, name=tollFreePhone, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisUser_tollFreePhone",getEntity().getTollFreePhone());
			
			input.setLabel("tollFreePhone");
			input.setDescription("A toll free phone number for the Contact, including suitable area codes.");
			input.setNillable(true);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//City: Field(entity=Person, name=City, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisUser_City",getEntity().getCity());
			
			input.setLabel("City");
			input.setDescription("Added from the old definition of MolgenisUser. City of this contact.");
			input.setNillable(true);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Country: Field(entity=Person, name=Country, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisUser_Country",getEntity().getCountry());
			
			input.setLabel("Country");
			input.setDescription("Added from the old definition of MolgenisUser. Country of this contact.");
			input.setNillable(true);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//FirstName: Field(entity=Person, name=FirstName, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisUser_FirstName",getEntity().getFirstName());
			
			input.setLabel("First Name");
			input.setDescription("First Name");
			input.setNillable(true);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//MidInitials: Field(entity=Person, name=MidInitials, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisUser_MidInitials",getEntity().getMidInitials());
			
			input.setLabel("Mid Initials");
			input.setDescription("Mid Initials");
			input.setNillable(true);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//LastName: Field(entity=Person, name=LastName, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisUser_LastName",getEntity().getLastName());
			
			input.setLabel("Last Name");
			input.setDescription("Last Name");
			input.setNillable(true);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Title: Field(entity=Person, name=Title, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisUser_Title",getEntity().getTitle());
			
			input.setLabel("Title");
			input.setDescription("An academic title, e.g. Prof.dr, PhD");
			input.setNillable(true);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Affiliation: Field(entity=Person, name=Affiliation, type=xref[Institute.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("MolgenisUser_Affiliation", getEntity().getAffiliation());
			//create xref dummy object
			Institute dummy = null;
			if(getEntity().getAffiliation_Id() != null)
			{
			 	dummy = new Institute();
				dummy.setId(getEntity().getAffiliation_Id());
				dummy.setName( getEntity().getAffiliation_Name() ); 
			}
			XrefInput input = new XrefInput("MolgenisUser_Affiliation", org.molgenis.auth.Institute.class, dummy);
			
			input.setLabel("Affiliation");
			input.setDescription("Affiliation");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Department: Field(entity=Person, name=Department, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisUser_Department",getEntity().getDepartment());
			
			input.setLabel("Department");
			input.setDescription("Added from the old definition of MolgenisUser. Department of this contact.");
			input.setNillable(true);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Roles: Field(entity=Person, name=Roles, type=xref[OntologyTerm.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("MolgenisUser_Roles", getEntity().getRoles());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getRoles_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getRoles_Id());
				dummy.setName( getEntity().getRoles_Name() ); 
			}
			XrefInput input = new XrefInput("MolgenisUser_Roles", org.molgenis.core.OntologyTerm.class, dummy);
			
			input.setLabel("Roles");
			input.setDescription("Indicate role of the contact, e.g. lab worker or PI. Changed from mref to xref in oct 2011.");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Password: Field(entity=MolgenisUser, name=password_, type=string[255], auto=false, nillable=false, readonly=false, default=secret)
		{
			StringInput input = new StringInput("MolgenisUser_password_",getEntity().getPassword());
			
			input.setLabel("password_");
			input.setDescription("big fixme: password type");
			input.setNillable(false);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//ActivationCode: Field(entity=MolgenisUser, name=activationCode, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("MolgenisUser_activationCode",getEntity().getActivationCode());
			
			input.setLabel("activationCode");
			input.setDescription("Used as alternative authentication mechanism to verify user email and/or if user has lost password.");
			input.setNillable(true);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Active: Field(entity=MolgenisUser, name=active, type=bool, auto=false, nillable=false, readonly=false, default=false)
		{
			BoolInput input = new BoolInput("MolgenisUser_active",getEntity().getActive());
			
			input.setLabel("active");
			input.setDescription("Boolean to indicate if this account can be used to login");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Superuser: Field(entity=MolgenisUser, name=superuser, type=bool, auto=false, nillable=false, readonly=false, default=false)
		{
			BoolInput input = new BoolInput("MolgenisUser_superuser",getEntity().getSuperuser());
			
			input.setLabel("superuser");
			input.setDescription("superuser");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}

		return inputs;
	}
}


