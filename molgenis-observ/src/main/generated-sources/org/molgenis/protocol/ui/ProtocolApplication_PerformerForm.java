
/* File:        Observ/html/ProtocolApplication_Performer.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.protocol.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.auth.Person;
import org.molgenis.protocol.ProtocolApplication;
import org.molgenis.protocol.ProtocolApplication_Performer;

import org.molgenis.auth.csv.PersonCsvReader;
import org.molgenis.protocol.csv.ProtocolApplicationCsvReader;
import org.molgenis.protocol.csv.ProtocolApplication_PerformerCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity ProtocolApplication_Performer
 * @see EntityForm
 */
public class ProtocolApplication_PerformerForm extends EntityForm<ProtocolApplication_Performer>
{
	private static final long serialVersionUID = 1L;
	
	public ProtocolApplication_PerformerForm()
	{
		super();
	}
	
	public ProtocolApplication_PerformerForm(ProtocolApplication_Performer entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<ProtocolApplication_Performer> getEntityClass()
	{
		return ProtocolApplication_Performer.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("autoid");
		headers.add("Performer");
		headers.add("ProtocolApplication");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Autoid: Field(entity=ProtocolApplication_Performer, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("ProtocolApplication_Performer_autoid",getEntity().getAutoid());
			
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
		//Performer: Field(entity=ProtocolApplication_Performer, name=Performer, type=xref[Person.id], xref_label='name', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ProtocolApplication_Performer_Performer", getEntity().getPerformer());
			//create xref dummy object
			Person dummy = null;
			if(getEntity().getPerformer_Id() != null)
			{
			 	dummy = new Person();
				dummy.setId(getEntity().getPerformer_Id());
				dummy.setName( getEntity().getPerformer_Name() ); 
			}
			XrefInput input = new XrefInput("ProtocolApplication_Performer_Performer", org.molgenis.auth.Person.class, dummy);
			
			input.setLabel("Performer");
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
		//ProtocolApplication: Field(entity=ProtocolApplication_Performer, name=ProtocolApplication, type=xref[ProtocolApplication.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ProtocolApplication_Performer_ProtocolApplication", getEntity().getProtocolApplication());
			//create xref dummy object
			ProtocolApplication dummy = null;
			if(getEntity().getProtocolApplication_Id() != null)
			{
			 	dummy = new ProtocolApplication();
				dummy.setId(getEntity().getProtocolApplication_Id());
				dummy.setName( getEntity().getProtocolApplication_Name() ); 
			}
			XrefInput input = new XrefInput("ProtocolApplication_Performer_ProtocolApplication", org.molgenis.protocol.ProtocolApplication.class, dummy);
			
			input.setLabel("ProtocolApplication");
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


