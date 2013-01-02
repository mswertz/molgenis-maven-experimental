
/* File:        Observ/html/WorkflowElement_PreviousSteps.java
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
import org.molgenis.protocol.WorkflowElement_PreviousSteps;

import org.molgenis.protocol.csv.WorkflowElementCsvReader;
import org.molgenis.protocol.csv.WorkflowElement_PreviousStepsCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity WorkflowElement_PreviousSteps
 * @see EntityForm
 */
public class WorkflowElement_PreviousStepsForm extends EntityForm<WorkflowElement_PreviousSteps>
{
	private static final long serialVersionUID = 1L;
	
	public WorkflowElement_PreviousStepsForm()
	{
		super();
	}
	
	public WorkflowElement_PreviousStepsForm(WorkflowElement_PreviousSteps entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<WorkflowElement_PreviousSteps> getEntityClass()
	{
		return WorkflowElement_PreviousSteps.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("autoid");
		headers.add("PreviousSteps");
		headers.add("WorkflowElement");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Autoid: Field(entity=WorkflowElement_PreviousSteps, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("WorkflowElement_PreviousSteps_autoid",getEntity().getAutoid());
			
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
		//PreviousSteps: Field(entity=WorkflowElement_PreviousSteps, name=PreviousSteps, type=xref[WorkflowElement.id], xref_label='name', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("WorkflowElement_PreviousSteps_PreviousSteps", getEntity().getPreviousSteps());
			//create xref dummy object
			WorkflowElement dummy = null;
			if(getEntity().getPreviousSteps_Id() != null)
			{
			 	dummy = new WorkflowElement();
				dummy.setId(getEntity().getPreviousSteps_Id());
				dummy.setName( getEntity().getPreviousSteps_Name() ); 
			}
			XrefInput input = new XrefInput("WorkflowElement_PreviousSteps_PreviousSteps", org.molgenis.protocol.WorkflowElement.class, dummy);
			
			input.setLabel("PreviousSteps");
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
		//WorkflowElement: Field(entity=WorkflowElement_PreviousSteps, name=WorkflowElement, type=xref[WorkflowElement.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("WorkflowElement_PreviousSteps_WorkflowElement", getEntity().getWorkflowElement());
			//create xref dummy object
			WorkflowElement dummy = null;
			if(getEntity().getWorkflowElement_Id() != null)
			{
			 	dummy = new WorkflowElement();
				dummy.setId(getEntity().getWorkflowElement_Id());
				dummy.setName( getEntity().getWorkflowElement_Name() ); 
			}
			XrefInput input = new XrefInput("WorkflowElement_PreviousSteps_WorkflowElement", org.molgenis.protocol.WorkflowElement.class, dummy);
			
			input.setLabel("WorkflowElement");
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


