
/* File:        Observ/html/ObservationElement_ontolo12449.java
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


import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.ObservationElement;
import org.molgenis.pheno.ObservationElement_Ontolo12449;

import org.molgenis.core.csv.OntologyTermCsvReader;
import org.molgenis.pheno.csv.ObservationElementCsvReader;
import org.molgenis.pheno.csv.ObservationElement_Ontolo12449CsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity ObservationElement_Ontolo12449
 * @see EntityForm
 */
public class ObservationElement_Ontolo12449Form extends EntityForm<ObservationElement_Ontolo12449>
{
	private static final long serialVersionUID = 1L;
	
	public ObservationElement_Ontolo12449Form()
	{
		super();
	}
	
	public ObservationElement_Ontolo12449Form(ObservationElement_Ontolo12449 entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<ObservationElement_Ontolo12449> getEntityClass()
	{
		return ObservationElement_Ontolo12449.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("autoid");
		headers.add("ontologyReference");
		headers.add("InvestigationElement");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Autoid: Field(entity=ObservationElement_ontolo12449, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("ObservationElement_ontolo12449_autoid",getEntity().getAutoid());
			
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
		//OntologyReference: Field(entity=ObservationElement_ontolo12449, name=ontologyReference, type=xref[OntologyTerm.id], xref_label='name', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ObservationElement_ontolo12449_ontologyReference", getEntity().getOntologyReference());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getOntologyReference_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getOntologyReference_Id());
				dummy.setName( getEntity().getOntologyReference_Name() ); 
			}
			XrefInput input = new XrefInput("ObservationElement_ontolo12449_ontologyReference", org.molgenis.core.OntologyTerm.class, dummy);
			
			input.setLabel("ontologyReference");
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
		//InvestigationElement: Field(entity=ObservationElement_ontolo12449, name=InvestigationElement, type=xref[ObservationElement.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ObservationElement_ontolo12449_InvestigationElement", getEntity().getInvestigationElement());
			//create xref dummy object
			ObservationElement dummy = null;
			if(getEntity().getInvestigationElement_Id() != null)
			{
			 	dummy = new ObservationElement();
				dummy.setId(getEntity().getInvestigationElement_Id());
				dummy.setName( getEntity().getInvestigationElement_Name() ); 
			}
			XrefInput input = new XrefInput("ObservationElement_ontolo12449_InvestigationElement", org.molgenis.pheno.ObservationElement.class, dummy);
			
			input.setLabel("InvestigationElement");
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


