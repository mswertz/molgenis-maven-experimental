
/* File:        Observ/html/Investigation_contacts.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.organization.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.auth.Person;
import org.molgenis.organization.Investigation;
import org.molgenis.organization.Investigation_Contacts;

import org.molgenis.auth.csv.PersonCsvReader;
import org.molgenis.organization.csv.InvestigationCsvReader;
import org.molgenis.organization.csv.Investigation_ContactsCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity Investigation_Contacts
 * @see EntityForm
 */
public class Investigation_ContactsForm extends EntityForm<Investigation_Contacts>
{
	private static final long serialVersionUID = 1L;
	
	public Investigation_ContactsForm()
	{
		super();
	}
	
	public Investigation_ContactsForm(Investigation_Contacts entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Investigation_Contacts> getEntityClass()
	{
		return Investigation_Contacts.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("autoid");
		headers.add("contacts");
		headers.add("Investigation");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Autoid: Field(entity=Investigation_contacts, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("Investigation_contacts_autoid",getEntity().getAutoid());
			
			input.setLabel("autoid");
			input.setDescription("automatic id field to ensure ordering of mrefs");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			input.setHidden(!isNewRecord());
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Contacts: Field(entity=Investigation_contacts, name=contacts, type=xref[Person.id], xref_label='name', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Investigation_contacts_contacts", getEntity().getContacts());
			//create xref dummy object
			Person dummy = null;
			if(getEntity().getContacts_Id() != null)
			{
			 	dummy = new Person();
				dummy.setId(getEntity().getContacts_Id());
				dummy.setName( getEntity().getContacts_Name() ); 
			}
			XrefInput input = new XrefInput("Investigation_contacts_contacts", org.molgenis.auth.Person.class, dummy);
			
			input.setLabel("contacts");
			input.setDescription("");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(!isNewRecord());
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Investigation: Field(entity=Investigation_contacts, name=Investigation, type=xref[Investigation.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Investigation_contacts_Investigation", getEntity().getInvestigation());
			//create xref dummy object
			Investigation dummy = null;
			if(getEntity().getInvestigation_Id() != null)
			{
			 	dummy = new Investigation();
				dummy.setId(getEntity().getInvestigation_Id());
				dummy.setName( getEntity().getInvestigation_Name() ); 
			}
			XrefInput input = new XrefInput("Investigation_contacts_Investigation", org.molgenis.organization.Investigation.class, dummy);
			
			input.setLabel("Investigation");
			input.setDescription("");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(!isNewRecord());
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


