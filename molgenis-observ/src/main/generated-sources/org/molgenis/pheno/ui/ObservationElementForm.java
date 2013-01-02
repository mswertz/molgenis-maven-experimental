
/* File:        Observ/html/ObservationElement.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.pheno.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.organization.Investigation;
import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.AlternateId;
import org.molgenis.pheno.ObservationElement;

import org.molgenis.organization.csv.InvestigationCsvReader;
import org.molgenis.core.csv.OntologyTermCsvReader;
import org.molgenis.pheno.csv.AlternateIdCsvReader;
import org.molgenis.pheno.csv.ObservationElementCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity ObservationElement
 * @see EntityForm
 */
public class ObservationElementForm extends EntityForm<ObservationElement>
{
	private static final long serialVersionUID = 1L;
	
	public ObservationElementForm()
	{
		super();
	}
	
	public ObservationElementForm(ObservationElement entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<ObservationElement> getEntityClass()
	{
		return ObservationElement.class;
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
		headers.add("Alternative identifiers");
		headers.add("label");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=ObservationElement, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("ObservationElement_id",getEntity().getId());
			
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
		//Name: Field(entity=ObservationElement, name=name, type=string[127], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("ObservationElement_name",getEntity().getName());
			
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
		//Description: Field(entity=ObservationElement, name=description, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("ObservationElement_description",getEntity().getDescription());
			
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
		//Investigation: Field(entity=ObservationElement, name=Investigation, type=xref[Investigation.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ObservationElement_Investigation", getEntity().getInvestigation());
			//create xref dummy object
			Investigation dummy = null;
			if(getEntity().getInvestigation_Id() != null)
			{
			 	dummy = new Investigation();
				dummy.setId(getEntity().getInvestigation_Id());
				dummy.setName( getEntity().getInvestigation_Name() ); 
			}
			XrefInput input = new XrefInput("ObservationElement_Investigation", org.molgenis.organization.Investigation.class, dummy);
			
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
		//OntologyReference: Field(entity=ObservationElement, name=ontologyReference, type=mref[OntologyTerm.id], mref_name=ObservationElement_ontolo12449, mref_localid=InvestigationElement, mref_remoteid=ontologyReference, xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("ObservationElement_ontologyReference", getEntity().getOntologyReference());
			//create xref dummy list of references
			List<OntologyTerm> dummyList = new ArrayList<OntologyTerm>();
			if(getEntity().getOntologyReference_Id() != null) for(int i = 0; i < getEntity().getOntologyReference_Id().size(); i++ )
			{
				OntologyTerm dummy = new OntologyTerm();
				dummy.setId(getEntity().getOntologyReference_Id().get(i));
				dummy.setName( getEntity().getOntologyReference_Name().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput input = new MrefInput("ObservationElement_ontologyReference", org.molgenis.core.OntologyTerm.class, dummyList);
			
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
		//__Type: Field(entity=ObservationElement, name=__Type, type=enum, auto=true, nillable=false, readonly=true, default=null, enum_options=[ObservationElement, Individual, Location, Panel, ObservationTarget, Measurement, ObservableFeature, Category])
		{
			EnumInput input = new EnumInput("ObservationElement___Type",getEntity().get__Type());
			
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
		//AlternateId: Field(entity=ObservationElement, name=AlternateId, type=mref[AlternateId.id], mref_name=ObservationElement_AlternateId, mref_localid=ObservationElement, mref_remoteid=AlternateId, xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("ObservationElement_AlternateId", getEntity().getAlternateId());
			//create xref dummy list of references
			List<AlternateId> dummyList = new ArrayList<AlternateId>();
			if(getEntity().getAlternateId_Id() != null) for(int i = 0; i < getEntity().getAlternateId_Id().size(); i++ )
			{
				AlternateId dummy = new AlternateId();
				dummy.setId(getEntity().getAlternateId_Id().get(i));
				dummy.setName( getEntity().getAlternateId_Name().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput input = new MrefInput("ObservationElement_AlternateId", org.molgenis.pheno.AlternateId.class, dummyList);
			
			input.setLabel("Alternative identifiers");
			input.setDescription("Alternative identifiers or symbols that this element is known by.");
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
		//Label: Field(entity=ObservationElement, name=label, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("ObservationElement_label",getEntity().getLabel());
			
			input.setLabel("label");
			input.setDescription("User friendly textual representation of this ObservationElement. For example: &apos;male&apos;,     &apos;mouse 3 in cage 7&apos; or &apos;TRA-2 like protein&apos;. Label allows for human-readable name that is potentially not unique.");
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

		return inputs;
	}
}


