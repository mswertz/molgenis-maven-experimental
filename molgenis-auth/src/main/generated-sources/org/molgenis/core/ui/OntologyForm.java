
/* File:        Auth/html/Ontology.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
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

import org.molgenis.core.csv.OntologyCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity Ontology
 * @see EntityForm
 */
public class OntologyForm extends EntityForm<Ontology>
{
	private static final long serialVersionUID = 1L;
	
	public OntologyForm()
	{
		super();
	}
	
	public OntologyForm(Ontology entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Ontology> getEntityClass()
	{
		return Ontology.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("id");
		headers.add("name");
		headers.add("ontologyAccession");
		headers.add("ontologyURI");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Ontology, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Ontology_id",getEntity().getId());
			
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
		//Name: Field(entity=Ontology, name=name, type=string[127], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Ontology_name",getEntity().getName());
			
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
		//OntologyAccession: Field(entity=Ontology, name=ontologyAccession, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Ontology_ontologyAccession",getEntity().getOntologyAccession());
			
			input.setLabel("ontologyAccession");
			input.setDescription("A identifier that uniquely identifies the ontology (typically an acronym). E.g. GO, MeSH, HPO.");
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
		//OntologyURI: Field(entity=Ontology, name=ontologyURI, type=hyperlink, auto=false, nillable=true, readonly=false, default=)
		{
			HyperlinkInput input = new HyperlinkInput("Ontology_ontologyURI",getEntity().getOntologyURI());
			
			input.setLabel("ontologyURI");
			input.setDescription("(Optional) A URI that references the location of the ontology.");
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


