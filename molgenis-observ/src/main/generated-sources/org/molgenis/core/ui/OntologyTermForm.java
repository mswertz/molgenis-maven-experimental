
/* File:        Observ/html/OntologyTerm.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.core.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.core.Ontology;
import org.molgenis.core.OntologyTerm;

import org.molgenis.core.csv.OntologyCsvReader;
import org.molgenis.core.csv.OntologyTermCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity OntologyTerm
 * @see EntityForm
 */
public class OntologyTermForm extends EntityForm<OntologyTerm>
{
	private static final long serialVersionUID = 1L;
	
	public OntologyTermForm()
	{
		super();
	}
	
	public OntologyTermForm(OntologyTerm entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<OntologyTerm> getEntityClass()
	{
		return OntologyTerm.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("id");
		headers.add("name");
		headers.add("__Type");
		headers.add("ontology");
		headers.add("termAccession");
		headers.add("definition");
		headers.add("termPath");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=OntologyTerm, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("OntologyTerm_id",getEntity().getId());
			
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
		//Name: Field(entity=OntologyTerm, name=name, type=string[127], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("OntologyTerm_name",getEntity().getName());
			
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
		//__Type: Field(entity=OntologyTerm, name=__Type, type=enum, auto=true, nillable=false, readonly=true, default=null, enum_options=[OntologyTerm, Species, AlternateId])
		{
			EnumInput input = new EnumInput("OntologyTerm___Type",getEntity().get__Type());
			
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
		//Ontology: Field(entity=OntologyTerm, name=ontology, type=xref[Ontology.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("OntologyTerm_ontology", getEntity().getOntology());
			//create xref dummy object
			Ontology dummy = null;
			if(getEntity().getOntology_Id() != null)
			{
			 	dummy = new Ontology();
				dummy.setId(getEntity().getOntology_Id());
				dummy.setName( getEntity().getOntology_Name() ); 
			}
			XrefInput input = new XrefInput("OntologyTerm_ontology", org.molgenis.core.Ontology.class, dummy);
			
			input.setLabel("ontology");
			input.setDescription("(Optional) The source ontology or controlled vocabulary list that ontology terms have been obtained from.");
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
		//TermAccession: Field(entity=OntologyTerm, name=termAccession, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("OntologyTerm_termAccession",getEntity().getTermAccession());
			
			input.setLabel("termAccession");
			input.setDescription("(Optional) The accession number assigned to the ontology term in its source ontology. If empty it is assumed to be a locally defined term.");
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
		//Definition: Field(entity=OntologyTerm, name=definition, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("OntologyTerm_definition",getEntity().getDefinition());
			
			input.setLabel("definition");
			input.setDescription("(Optional) The definition of the term.");
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
		//TermPath: Field(entity=OntologyTerm, name=termPath, type=string[1024], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("OntologyTerm_termPath",getEntity().getTermPath());
			
			input.setLabel("termPath");
			input.setDescription("EXTENSION. The Ontology Lookup Service path that contains this term.");
			input.setNillable(true);
			input.setSize(1024);
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


