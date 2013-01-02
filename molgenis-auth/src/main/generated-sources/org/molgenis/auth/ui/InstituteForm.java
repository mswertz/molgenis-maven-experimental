
/* File:        Auth/html/Institute.java
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

import org.molgenis.auth.csv.InstituteCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity Institute
 * @see EntityForm
 */
public class InstituteForm extends EntityForm<Institute>
{
	private static final long serialVersionUID = 1L;
	
	public InstituteForm()
	{
		super();
	}
	
	public InstituteForm(Institute entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Institute> getEntityClass()
	{
		return Institute.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("id");
		headers.add("Address");
		headers.add("Phone");
		headers.add("Email");
		headers.add("Fax");
		headers.add("tollFreePhone");
		headers.add("City");
		headers.add("Country");
		headers.add("name");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Institute, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Institute_id",getEntity().getId());
			
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
		//Address: Field(entity=Institute, name=Address, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("Institute_Address",getEntity().getAddress());
			
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
		//Phone: Field(entity=Institute, name=Phone, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Institute_Phone",getEntity().getPhone());
			
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
		//Email: Field(entity=Institute, name=Email, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Institute_Email",getEntity().getEmail());
			
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
		//Fax: Field(entity=Institute, name=Fax, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Institute_Fax",getEntity().getFax());
			
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
		//TollFreePhone: Field(entity=Institute, name=tollFreePhone, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Institute_tollFreePhone",getEntity().getTollFreePhone());
			
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
		//City: Field(entity=Institute, name=City, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Institute_City",getEntity().getCity());
			
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
		//Country: Field(entity=Institute, name=Country, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Institute_Country",getEntity().getCountry());
			
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
		//Name: Field(entity=Institute, name=name, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Institute_name",getEntity().getName());
			
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

		return inputs;
	}
}


