
/* File:        Observ/html/ObservationElement_AlternateId.java
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


import org.molgenis.pheno.AlternateId;
import org.molgenis.pheno.ObservationElement;
import org.molgenis.pheno.ObservationElement_AlternateId;

import org.molgenis.pheno.csv.AlternateIdCsvReader;
import org.molgenis.pheno.csv.ObservationElementCsvReader;
import org.molgenis.pheno.csv.ObservationElement_AlternateIdCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity ObservationElement_AlternateId
 * @see EntityForm
 */
public class ObservationElement_AlternateIdForm extends EntityForm<ObservationElement_AlternateId>
{
	private static final long serialVersionUID = 1L;
	
	public ObservationElement_AlternateIdForm()
	{
		super();
	}
	
	public ObservationElement_AlternateIdForm(ObservationElement_AlternateId entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<ObservationElement_AlternateId> getEntityClass()
	{
		return ObservationElement_AlternateId.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("autoid");
		headers.add("AlternateId");
		headers.add("ObservationElement");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Autoid: Field(entity=ObservationElement_AlternateId, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("ObservationElement_AlternateId_autoid",getEntity().getAutoid());
			
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
		//AlternateId: Field(entity=ObservationElement_AlternateId, name=AlternateId, type=xref[AlternateId.id], xref_label='name', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ObservationElement_AlternateId_AlternateId", getEntity().getAlternateId());
			//create xref dummy object
			AlternateId dummy = null;
			if(getEntity().getAlternateId_Id() != null)
			{
			 	dummy = new AlternateId();
				dummy.setId(getEntity().getAlternateId_Id());
				dummy.setName( getEntity().getAlternateId_Name() ); 
			}
			XrefInput input = new XrefInput("ObservationElement_AlternateId_AlternateId", org.molgenis.pheno.AlternateId.class, dummy);
			
			input.setLabel("AlternateId");
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
		//ObservationElement: Field(entity=ObservationElement_AlternateId, name=ObservationElement, type=xref[ObservationElement.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ObservationElement_AlternateId_ObservationElement", getEntity().getObservationElement());
			//create xref dummy object
			ObservationElement dummy = null;
			if(getEntity().getObservationElement_Id() != null)
			{
			 	dummy = new ObservationElement();
				dummy.setId(getEntity().getObservationElement_Id());
				dummy.setName( getEntity().getObservationElement_Name() ); 
			}
			XrefInput input = new XrefInput("ObservationElement_AlternateId_ObservationElement", org.molgenis.pheno.ObservationElement.class, dummy);
			
			input.setLabel("ObservationElement");
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


