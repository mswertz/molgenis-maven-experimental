
/* File:        Observ/html/Protocol.java
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
import org.molgenis.pheno.ObservableFeature;
import org.molgenis.auth.Person;
import org.molgenis.protocol.Protocol;

import org.molgenis.organization.csv.InvestigationCsvReader;
import org.molgenis.core.csv.OntologyTermCsvReader;
import org.molgenis.pheno.csv.ObservableFeatureCsvReader;
import org.molgenis.auth.csv.PersonCsvReader;
import org.molgenis.protocol.csv.ProtocolCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity Protocol
 * @see EntityForm
 */
public class ProtocolForm extends EntityForm<Protocol>
{
	private static final long serialVersionUID = 1L;
	
	public ProtocolForm()
	{
		super();
	}
	
	public ProtocolForm(Protocol entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Protocol> getEntityClass()
	{
		return Protocol.class;
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
		headers.add("__Type");
		headers.add("ProtocolType");
		headers.add("Features");
		headers.add("TargetFilter");
		headers.add("Contact");
		headers.add("subprotocols");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Protocol, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Protocol_id",getEntity().getId());
			
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
		//Name: Field(entity=Protocol, name=name, type=string[127], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Protocol_name",getEntity().getName());
			
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
		//Description: Field(entity=Protocol, name=description, type=richtext, auto=false, nillable=true, readonly=false, default=)
		{
			RichtextInput input = new RichtextInput("Protocol_description",getEntity().getDescription());
			
			input.setLabel("description");
			input.setDescription("Description, or reference to a description, of the protocol");
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
		//Investigation: Field(entity=Protocol, name=Investigation, type=xref[Investigation.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Protocol_Investigation", getEntity().getInvestigation());
			//create xref dummy object
			Investigation dummy = null;
			if(getEntity().getInvestigation_Id() != null)
			{
			 	dummy = new Investigation();
				dummy.setId(getEntity().getInvestigation_Id());
				dummy.setName( getEntity().getInvestigation_Name() ); 
			}
			XrefInput input = new XrefInput("Protocol_Investigation", org.molgenis.organization.Investigation.class, dummy);
			
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
		//OntologyReference: Field(entity=Protocol, name=ontologyReference, type=mref[OntologyTerm.id], mref_name=Protocol_ontologyReference, mref_localid=InvestigationElement, mref_remoteid=ontologyReference, xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("Protocol_ontologyReference", getEntity().getOntologyReference());
			//create xref dummy list of references
			List<OntologyTerm> dummyList = new ArrayList<OntologyTerm>();
			if(getEntity().getOntologyReference_Id() != null) for(int i = 0; i < getEntity().getOntologyReference_Id().size(); i++ )
			{
				OntologyTerm dummy = new OntologyTerm();
				dummy.setId(getEntity().getOntologyReference_Id().get(i));
				dummy.setName( getEntity().getOntologyReference_Name().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput input = new MrefInput("Protocol_ontologyReference", org.molgenis.core.OntologyTerm.class, dummyList);
			
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
		//__Type: Field(entity=Protocol, name=__Type, type=enum, auto=true, nillable=false, readonly=true, default=null, enum_options=[Protocol, Workflow])
		{
			EnumInput input = new EnumInput("Protocol___Type",getEntity().get__Type());
			
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
		//ProtocolType: Field(entity=Protocol, name=ProtocolType, type=xref[OntologyTerm.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Protocol_ProtocolType", getEntity().getProtocolType());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getProtocolType_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getProtocolType_Id());
				dummy.setName( getEntity().getProtocolType_Name() ); 
			}
			XrefInput input = new XrefInput("Protocol_ProtocolType", org.molgenis.core.OntologyTerm.class, dummy);
			
			input.setLabel("ProtocolType");
			input.setDescription("annotation of the protocol to a well-defined ontological class.");
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
		//Features: Field(entity=Protocol, name=Features, type=mref[ObservableFeature.id], mref_name=Protocol_Features, mref_localid=Protocol, mref_remoteid=Features, xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("Protocol_Features", getEntity().getFeatures());
			//create xref dummy list of references
			List<ObservableFeature> dummyList = new ArrayList<ObservableFeature>();
			if(getEntity().getFeatures_Id() != null) for(int i = 0; i < getEntity().getFeatures_Id().size(); i++ )
			{
				ObservableFeature dummy = new ObservableFeature();
				dummy.setId(getEntity().getFeatures_Id().get(i));
				dummy.setName( getEntity().getFeatures_Name().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput input = new MrefInput("Protocol_Features", org.molgenis.pheno.ObservableFeature.class, dummyList);
			
			input.setLabel("Features");
			input.setDescription("The features that can be observed using this protocol. For example &apos;length&apos; or &apos;rs123534&apos; or &apos;probe123&apos;. Also protocol parameters are considered observable features as they are important to the interpretation of the observed values.");
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
		//TargetFilter: Field(entity=Protocol, name=TargetFilter, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Protocol_TargetFilter",getEntity().getTargetFilter());
			
			input.setLabel("TargetFilter");
			input.setDescription("Expression that filters the InvestigationElements that can be targetted using this protocol.     This helps the user to only select from targets that matter when setting observedvalues. For example: type=&apos;individual&apos; AND species = &apos;human&apos;");
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
		//Contact: Field(entity=Protocol, name=Contact, type=xref[Person.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Protocol_Contact", getEntity().getContact());
			//create xref dummy object
			Person dummy = null;
			if(getEntity().getContact_Id() != null)
			{
			 	dummy = new Person();
				dummy.setId(getEntity().getContact_Id());
				dummy.setName( getEntity().getContact_Name() ); 
			}
			XrefInput input = new XrefInput("Protocol_Contact", org.molgenis.auth.Person.class, dummy);
			
			input.setLabel("Contact");
			input.setDescription("TODO Check if there can be multiple contacts.");
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
		//Subprotocols: Field(entity=Protocol, name=subprotocols, type=mref[Protocol.id], mref_name=Protocol_subprotocols, mref_localid=Protocol, mref_remoteid=subprotocols, xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("Protocol_subprotocols", getEntity().getSubprotocols());
			//create xref dummy list of references
			List<Protocol> dummyList = new ArrayList<Protocol>();
			if(getEntity().getSubprotocols_Id() != null) for(int i = 0; i < getEntity().getSubprotocols_Id().size(); i++ )
			{
				Protocol dummy = new Protocol();
				dummy.setId(getEntity().getSubprotocols_Id().get(i));
				dummy.setName( getEntity().getSubprotocols_Name().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput input = new MrefInput("Protocol_subprotocols", org.molgenis.protocol.Protocol.class, dummyList);
			
			input.setLabel("subprotocols");
			input.setDescription("Subprotocols of this protocol");
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


