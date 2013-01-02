
/* File:        Observ/html/Panel_Individuals.java
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


import org.molgenis.pheno.Individual;
import org.molgenis.pheno.Panel;
import org.molgenis.pheno.Panel_Individuals;

import org.molgenis.pheno.csv.IndividualCsvReader;
import org.molgenis.pheno.csv.PanelCsvReader;
import org.molgenis.pheno.csv.Panel_IndividualsCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity Panel_Individuals
 * @see EntityForm
 */
public class Panel_IndividualsForm extends EntityForm<Panel_Individuals>
{
	private static final long serialVersionUID = 1L;
	
	public Panel_IndividualsForm()
	{
		super();
	}
	
	public Panel_IndividualsForm(Panel_Individuals entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Panel_Individuals> getEntityClass()
	{
		return Panel_Individuals.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("autoid");
		headers.add("Individuals");
		headers.add("Panel");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Autoid: Field(entity=Panel_Individuals, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("Panel_Individuals_autoid",getEntity().getAutoid());
			
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
		//Individuals: Field(entity=Panel_Individuals, name=Individuals, type=xref[Individual.id], xref_label='name', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Panel_Individuals_Individuals", getEntity().getIndividuals());
			//create xref dummy object
			Individual dummy = null;
			if(getEntity().getIndividuals_Id() != null)
			{
			 	dummy = new Individual();
				dummy.setId(getEntity().getIndividuals_Id());
				dummy.setName( getEntity().getIndividuals_Name() ); 
			}
			XrefInput input = new XrefInput("Panel_Individuals_Individuals", org.molgenis.pheno.Individual.class, dummy);
			
			input.setLabel("Individuals");
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
		//Panel: Field(entity=Panel_Individuals, name=Panel, type=xref[Panel.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Panel_Individuals_Panel", getEntity().getPanel());
			//create xref dummy object
			Panel dummy = null;
			if(getEntity().getPanel_Id() != null)
			{
			 	dummy = new Panel();
				dummy.setId(getEntity().getPanel_Id());
				dummy.setName( getEntity().getPanel_Name() ); 
			}
			XrefInput input = new XrefInput("Panel_Individuals_Panel", org.molgenis.pheno.Panel.class, dummy);
			
			input.setLabel("Panel");
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


