
/* File:        Observ/html/WorkflowElementParameter.java
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


import org.molgenis.protocol.WorkflowElement;
import org.molgenis.pheno.ObservableFeature;
import org.molgenis.protocol.WorkflowElementParameter;

import org.molgenis.protocol.csv.WorkflowElementCsvReader;
import org.molgenis.pheno.csv.ObservableFeatureCsvReader;
import org.molgenis.protocol.csv.WorkflowElementParameterCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity WorkflowElementParameter
 * @see EntityForm
 */
public class WorkflowElementParameterForm extends EntityForm<WorkflowElementParameter>
{
	private static final long serialVersionUID = 1L;
	
	public WorkflowElementParameterForm()
	{
		super();
	}
	
	public WorkflowElementParameterForm(WorkflowElementParameter entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<WorkflowElementParameter> getEntityClass()
	{
		return WorkflowElementParameter.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("id");
		headers.add("WorkflowElement");
		headers.add("Parameter");
		headers.add("Value");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=WorkflowElementParameter, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("WorkflowElementParameter_id",getEntity().getId());
			
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
		//WorkflowElement: Field(entity=WorkflowElementParameter, name=WorkflowElement, type=xref[WorkflowElement.id], xref_label='name', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("WorkflowElementParameter_WorkflowElement", getEntity().getWorkflowElement());
			//create xref dummy object
			WorkflowElement dummy = null;
			if(getEntity().getWorkflowElement_Id() != null)
			{
			 	dummy = new WorkflowElement();
				dummy.setId(getEntity().getWorkflowElement_Id());
				dummy.setName( getEntity().getWorkflowElement_Name() ); 
			}
			XrefInput input = new XrefInput("WorkflowElementParameter_WorkflowElement", org.molgenis.protocol.WorkflowElement.class, dummy);
			
			input.setLabel("WorkflowElement");
			input.setDescription("To attach a parameter to a WorkflowElement");
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
		//Parameter: Field(entity=WorkflowElementParameter, name=Parameter, type=xref[ObservableFeature.id], xref_label='name', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("WorkflowElementParameter_Parameter", getEntity().getParameter());
			//create xref dummy object
			ObservableFeature dummy = null;
			if(getEntity().getParameter_Id() != null)
			{
			 	dummy = new ObservableFeature();
				dummy.setId(getEntity().getParameter_Id());
				dummy.setName( getEntity().getParameter_Name() ); 
			}
			XrefInput input = new XrefInput("WorkflowElementParameter_Parameter", org.molgenis.pheno.ObservableFeature.class, dummy);
			
			input.setLabel("Parameter");
			input.setDescription("Parameter definition.");
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
		//Value: Field(entity=WorkflowElementParameter, name=Value, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("WorkflowElementParameter_Value",getEntity().getValue());
			
			input.setLabel("Value");
			input.setDescription("Value of this parameter. Can be a template of form ${other} refering to previous values in context.");
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


