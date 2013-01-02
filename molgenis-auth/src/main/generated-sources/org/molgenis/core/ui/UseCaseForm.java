
/* File:        Auth/html/UseCase.java
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


import org.molgenis.core.UseCase;

import org.molgenis.core.csv.UseCaseCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity UseCase
 * @see EntityForm
 */
public class UseCaseForm extends EntityForm<UseCase>
{
	private static final long serialVersionUID = 1L;
	
	public UseCaseForm()
	{
		super();
	}
	
	public UseCaseForm(UseCase entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<UseCase> getEntityClass()
	{
		return UseCase.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("UseCaseId");
		headers.add("UseCaseName");
		headers.add("SearchType");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//UseCaseId: Field(entity=UseCase, name=UseCaseId, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("UseCase_UseCaseId",getEntity().getUseCaseId());
			
			input.setLabel("UseCaseId");
			input.setDescription("UseCaseId");
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
		//UseCaseName: Field(entity=UseCase, name=UseCaseName, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("UseCase_UseCaseName",getEntity().getUseCaseName());
			
			input.setLabel("UseCaseName");
			input.setDescription("UseCaseName");
			input.setNillable(false);
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
		//SearchType: Field(entity=UseCase, name=SearchType, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("UseCase_SearchType",getEntity().getSearchType());
			
			input.setLabel("SearchType");
			input.setDescription("SearchType");
			input.setNillable(false);
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


