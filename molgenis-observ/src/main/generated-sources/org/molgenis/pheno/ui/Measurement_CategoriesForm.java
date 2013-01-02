
/* File:        Observ/html/Measurement_categories.java
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


import org.molgenis.pheno.Category;
import org.molgenis.pheno.Measurement;
import org.molgenis.pheno.Measurement_Categories;

import org.molgenis.pheno.csv.CategoryCsvReader;
import org.molgenis.pheno.csv.MeasurementCsvReader;
import org.molgenis.pheno.csv.Measurement_CategoriesCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity Measurement_Categories
 * @see EntityForm
 */
public class Measurement_CategoriesForm extends EntityForm<Measurement_Categories>
{
	private static final long serialVersionUID = 1L;
	
	public Measurement_CategoriesForm()
	{
		super();
	}
	
	public Measurement_CategoriesForm(Measurement_Categories entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Measurement_Categories> getEntityClass()
	{
		return Measurement_Categories.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("autoid");
		headers.add("categories");
		headers.add("Measurement");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Autoid: Field(entity=Measurement_categories, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("Measurement_categories_autoid",getEntity().getAutoid());
			
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
		//Categories: Field(entity=Measurement_categories, name=categories, type=xref[Category.id], xref_label='name', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Measurement_categories_categories", getEntity().getCategories());
			//create xref dummy object
			Category dummy = null;
			if(getEntity().getCategories_Id() != null)
			{
			 	dummy = new Category();
				dummy.setId(getEntity().getCategories_Id());
				dummy.setName( getEntity().getCategories_Name() ); 
			}
			XrefInput input = new XrefInput("Measurement_categories_categories", org.molgenis.pheno.Category.class, dummy);
			
			input.setLabel("categories");
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
		//Measurement: Field(entity=Measurement_categories, name=Measurement, type=xref[Measurement.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Measurement_categories_Measurement", getEntity().getMeasurement());
			//create xref dummy object
			Measurement dummy = null;
			if(getEntity().getMeasurement_Id() != null)
			{
			 	dummy = new Measurement();
				dummy.setId(getEntity().getMeasurement_Id());
				dummy.setName( getEntity().getMeasurement_Name() ); 
			}
			XrefInput input = new XrefInput("Measurement_categories_Measurement", org.molgenis.pheno.Measurement.class, dummy);
			
			input.setLabel("Measurement");
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


