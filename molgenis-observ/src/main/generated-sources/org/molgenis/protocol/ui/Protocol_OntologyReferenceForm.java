
/* File:        Observ/html/Protocol_ontologyReference.java
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


import org.molgenis.core.OntologyTerm;
import org.molgenis.protocol.Protocol;
import org.molgenis.protocol.Protocol_OntologyReference;

import org.molgenis.core.csv.OntologyTermCsvReader;
import org.molgenis.protocol.csv.ProtocolCsvReader;
import org.molgenis.protocol.csv.Protocol_OntologyReferenceCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity Protocol_OntologyReference
 * @see EntityForm
 */
public class Protocol_OntologyReferenceForm extends EntityForm<Protocol_OntologyReference>
{
	private static final long serialVersionUID = 1L;
	
	public Protocol_OntologyReferenceForm()
	{
		super();
	}
	
	public Protocol_OntologyReferenceForm(Protocol_OntologyReference entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Protocol_OntologyReference> getEntityClass()
	{
		return Protocol_OntologyReference.class;
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
		//Autoid: Field(entity=Protocol_ontologyReference, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("Protocol_ontologyReference_autoid",getEntity().getAutoid());
			
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
		//OntologyReference: Field(entity=Protocol_ontologyReference, name=ontologyReference, type=xref[OntologyTerm.id], xref_label='name', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Protocol_ontologyReference_ontologyReference", getEntity().getOntologyReference());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getOntologyReference_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getOntologyReference_Id());
				dummy.setName( getEntity().getOntologyReference_Name() ); 
			}
			XrefInput input = new XrefInput("Protocol_ontologyReference_ontologyReference", org.molgenis.core.OntologyTerm.class, dummy);
			
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
		//InvestigationElement: Field(entity=Protocol_ontologyReference, name=InvestigationElement, type=xref[Protocol.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Protocol_ontologyReference_InvestigationElement", getEntity().getInvestigationElement());
			//create xref dummy object
			Protocol dummy = null;
			if(getEntity().getInvestigationElement_Id() != null)
			{
			 	dummy = new Protocol();
				dummy.setId(getEntity().getInvestigationElement_Id());
				dummy.setName( getEntity().getInvestigationElement_Name() ); 
			}
			XrefInput input = new XrefInput("Protocol_ontologyReference_InvestigationElement", org.molgenis.protocol.Protocol.class, dummy);
			
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


