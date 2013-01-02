
/* File:        Observ/html/Investigation.java
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

import org.molgenis.auth.csv.PersonCsvReader;
import org.molgenis.organization.csv.InvestigationCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity Investigation
 * @see EntityForm
 */
public class InvestigationForm extends EntityForm<Investigation>
{
	private static final long serialVersionUID = 1L;
	
	public InvestigationForm()
	{
		super();
	}
	
	public InvestigationForm(Investigation entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Investigation> getEntityClass()
	{
		return Investigation.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("id");
		headers.add("name");
		headers.add("description");
		headers.add("startDate");
		headers.add("endDate");
		headers.add("contacts");
		headers.add("accession");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Investigation, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Investigation_id",getEntity().getId());
			
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
		//Name: Field(entity=Investigation, name=name, type=string[127], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Investigation_name",getEntity().getName());
			
			input.setLabel("name");
			input.setDescription("human-readable name.");
			input.setNillable(false);
			input.setSize(127);
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
		//Description: Field(entity=Investigation, name=description, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("Investigation_description",getEntity().getDescription());
			
			input.setLabel("description");
			input.setDescription("description field");
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
		//StartDate: Field(entity=Investigation, name=startDate, type=datetime, auto=true, nillable=true, readonly=false, default=)
		{
			DatetimeInput input = new DatetimeInput("Investigation_startDate",getEntity().getStartDate());
			
			input.setLabel("startDate");
			input.setDescription("The start point of the study.");
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
		//EndDate: Field(entity=Investigation, name=endDate, type=datetime, auto=false, nillable=true, readonly=false, default=)
		{
			DatetimeInput input = new DatetimeInput("Investigation_endDate",getEntity().getEndDate());
			
			input.setLabel("endDate");
			input.setDescription("The end point of the study.");
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
		//Contacts: Field(entity=Investigation, name=contacts, type=mref[Person.id], mref_name=Investigation_contacts, mref_localid=Investigation, mref_remoteid=contacts, xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("Investigation_contacts", getEntity().getContacts());
			//create xref dummy list of references
			List<Person> dummyList = new ArrayList<Person>();
			if(getEntity().getContacts_Id() != null) for(int i = 0; i < getEntity().getContacts_Id().size(); i++ )
			{
				Person dummy = new Person();
				dummy.setId(getEntity().getContacts_Id().get(i));
				dummy.setName( getEntity().getContacts_Name().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput input = new MrefInput("Investigation_contacts", org.molgenis.auth.Person.class, dummyList);
			
			input.setLabel("contacts");
			input.setDescription("Contact persons for this study");
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
		//Accession: Field(entity=Investigation, name=accession, type=hyperlink, auto=false, nillable=true, readonly=false, default=)
		{
			HyperlinkInput input = new HyperlinkInput("Investigation_accession",getEntity().getAccession());
			
			input.setLabel("accession");
			input.setDescription("(Optional) URI or accession number to indicate source of Study. E.g. arrayexpress:M-EXP-2345");
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

		return inputs;
	}
}


