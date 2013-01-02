
/* File:        Observ/html/ProtocolApplication.java
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


import org.molgenis.organization.Investigation;
import org.molgenis.core.OntologyTerm;
import org.molgenis.protocol.Protocol;
import org.molgenis.auth.Person;
import org.molgenis.protocol.ProtocolApplication;

import org.molgenis.organization.csv.InvestigationCsvReader;
import org.molgenis.core.csv.OntologyTermCsvReader;
import org.molgenis.protocol.csv.ProtocolCsvReader;
import org.molgenis.auth.csv.PersonCsvReader;
import org.molgenis.protocol.csv.ProtocolApplicationCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity ProtocolApplication
 * @see EntityForm
 */
public class ProtocolApplicationForm extends EntityForm<ProtocolApplication>
{
	private static final long serialVersionUID = 1L;
	
	public ProtocolApplicationForm()
	{
		super();
	}
	
	public ProtocolApplicationForm(ProtocolApplication entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<ProtocolApplication> getEntityClass()
	{
		return ProtocolApplication.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("id");
		headers.add("name");
		headers.add("description");
		headers.add("Investigation");
		headers.add("ontologyReference");
		headers.add("time");
		headers.add("protocol");
		headers.add("Performer");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=ProtocolApplication, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("ProtocolApplication_id",getEntity().getId());
			
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
		//Name: Field(entity=ProtocolApplication, name=name, type=string[127], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("ProtocolApplication_name",getEntity().getName());
			
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
		//Description: Field(entity=ProtocolApplication, name=description, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("ProtocolApplication_description",getEntity().getDescription());
			
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
		//Investigation: Field(entity=ProtocolApplication, name=Investigation, type=xref[Investigation.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ProtocolApplication_Investigation", getEntity().getInvestigation());
			//create xref dummy object
			Investigation dummy = null;
			if(getEntity().getInvestigation_Id() != null)
			{
			 	dummy = new Investigation();
				dummy.setId(getEntity().getInvestigation_Id());
				dummy.setName( getEntity().getInvestigation_Name() ); 
			}
			XrefInput input = new XrefInput("ProtocolApplication_Investigation", org.molgenis.organization.Investigation.class, dummy);
			
			input.setLabel("Investigation");
			input.setDescription("Reference to the Study that this data element is part of");
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
		//OntologyReference: Field(entity=ProtocolApplication, name=ontologyReference, type=mref[OntologyTerm.id], mref_name=ProtocolApplication_ontol11768, mref_localid=InvestigationElement, mref_remoteid=ontologyReference, xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("ProtocolApplication_ontologyReference", getEntity().getOntologyReference());
			//create xref dummy list of references
			List<OntologyTerm> dummyList = new ArrayList<OntologyTerm>();
			if(getEntity().getOntologyReference_Id() != null) for(int i = 0; i < getEntity().getOntologyReference_Id().size(); i++ )
			{
				OntologyTerm dummy = new OntologyTerm();
				dummy.setId(getEntity().getOntologyReference_Id().get(i));
				dummy.setName( getEntity().getOntologyReference_Name().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput input = new MrefInput("ProtocolApplication_ontologyReference", org.molgenis.core.OntologyTerm.class, dummyList);
			
			input.setLabel("ontologyReference");
			input.setDescription("(Optional) Reference to the formal ontology definition for this element, e.g. &apos;Animal&apos; or &apos;GWAS protocol&apos;");
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
		//Time: Field(entity=ProtocolApplication, name=time, type=datetime, auto=true, nillable=false, readonly=false, default=)
		{
			DatetimeInput input = new DatetimeInput("ProtocolApplication_time",getEntity().getTime());
			
			input.setLabel("time");
			input.setDescription("time when the protocol was applied.");
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
		//Protocol: Field(entity=ProtocolApplication, name=protocol, type=xref[Protocol.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ProtocolApplication_protocol", getEntity().getProtocol());
			//create xref dummy object
			Protocol dummy = null;
			if(getEntity().getProtocol_Id() != null)
			{
			 	dummy = new Protocol();
				dummy.setId(getEntity().getProtocol_Id());
				dummy.setName( getEntity().getProtocol_Name() ); 
			}
			XrefInput input = new XrefInput("ProtocolApplication_protocol", org.molgenis.protocol.Protocol.class, dummy);
			
			input.setLabel("protocol");
			input.setDescription("Reference to the protocol that is being used.");
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
		//Performer: Field(entity=ProtocolApplication, name=Performer, type=mref[Person.id], mref_name=ProtocolApplication_Performer, mref_localid=ProtocolApplication, mref_remoteid=Performer, xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("ProtocolApplication_Performer", getEntity().getPerformer());
			//create xref dummy list of references
			List<Person> dummyList = new ArrayList<Person>();
			if(getEntity().getPerformer_Id() != null) for(int i = 0; i < getEntity().getPerformer_Id().size(); i++ )
			{
				Person dummy = new Person();
				dummy.setId(getEntity().getPerformer_Id().get(i));
				dummy.setName( getEntity().getPerformer_Name().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput input = new MrefInput("ProtocolApplication_Performer", org.molgenis.auth.Person.class, dummyList);
			
			input.setLabel("Performer");
			input.setDescription("Performer");
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


