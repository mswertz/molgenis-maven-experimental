
/* File:        Observ/html/WorkflowElement.java
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


import org.molgenis.protocol.Workflow;
import org.molgenis.protocol.Protocol;
import org.molgenis.protocol.WorkflowElement;

import org.molgenis.protocol.csv.WorkflowCsvReader;
import org.molgenis.protocol.csv.ProtocolCsvReader;
import org.molgenis.protocol.csv.WorkflowElementCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity WorkflowElement
 * @see EntityForm
 */
public class WorkflowElementForm extends EntityForm<WorkflowElement>
{
	private static final long serialVersionUID = 1L;
	
	public WorkflowElementForm()
	{
		super();
	}
	
	public WorkflowElementForm(WorkflowElement entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<WorkflowElement> getEntityClass()
	{
		return WorkflowElement.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("id");
		headers.add("name");
		headers.add("Workflow");
		headers.add("protocol");
		headers.add("PreviousSteps");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=WorkflowElement, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("WorkflowElement_id",getEntity().getId());
			
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
		//Name: Field(entity=WorkflowElement, name=name, type=string[127], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("WorkflowElement_name",getEntity().getName());
			
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
		//Workflow: Field(entity=WorkflowElement, name=Workflow, type=xref[Workflow.id], xref_label='name', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("WorkflowElement_Workflow", getEntity().getWorkflow());
			//create xref dummy object
			Workflow dummy = null;
			if(getEntity().getWorkflow_Id() != null)
			{
			 	dummy = new Workflow();
				dummy.setId(getEntity().getWorkflow_Id());
				dummy.setName( getEntity().getWorkflow_Name() ); 
			}
			XrefInput input = new XrefInput("WorkflowElement_Workflow", org.molgenis.protocol.Workflow.class, dummy);
			
			input.setLabel("Workflow");
			input.setDescription("Workflow this element is part of");
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
		//Protocol: Field(entity=WorkflowElement, name=protocol, type=xref[Protocol.id], xref_label='name', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("WorkflowElement_protocol", getEntity().getProtocol());
			//create xref dummy object
			Protocol dummy = null;
			if(getEntity().getProtocol_Id() != null)
			{
			 	dummy = new Protocol();
				dummy.setId(getEntity().getProtocol_Id());
				dummy.setName( getEntity().getProtocol_Name() ); 
			}
			XrefInput input = new XrefInput("WorkflowElement_protocol", org.molgenis.protocol.Protocol.class, dummy);
			
			input.setLabel("protocol");
			input.setDescription("Protocol to be used at this workflow step");
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
		//PreviousSteps: Field(entity=WorkflowElement, name=PreviousSteps, type=mref[WorkflowElement.id], mref_name=WorkflowElement_PreviousSteps, mref_localid=WorkflowElement, mref_remoteid=PreviousSteps, xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("WorkflowElement_PreviousSteps", getEntity().getPreviousSteps());
			//create xref dummy list of references
			List<WorkflowElement> dummyList = new ArrayList<WorkflowElement>();
			if(getEntity().getPreviousSteps_Id() != null) for(int i = 0; i < getEntity().getPreviousSteps_Id().size(); i++ )
			{
				WorkflowElement dummy = new WorkflowElement();
				dummy.setId(getEntity().getPreviousSteps_Id().get(i));
				dummy.setName( getEntity().getPreviousSteps_Name().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput input = new MrefInput("WorkflowElement_PreviousSteps", org.molgenis.protocol.WorkflowElement.class, dummyList);
			
			input.setLabel("PreviousSteps");
			input.setDescription("Previous steps that need to be done before this protocol can be executed.");
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


