
/* File:        Observ/html/ProtocolApplication_ontol11768.java
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
import org.molgenis.protocol.ProtocolApplication;
import org.molgenis.protocol.ProtocolApplication_Ontol11768;

import org.molgenis.core.csv.OntologyTermCsvReader;
import org.molgenis.protocol.csv.ProtocolApplicationCsvReader;
import org.molgenis.protocol.csv.ProtocolApplication_Ontol11768CsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity ProtocolApplication_Ontol11768
 * @see EntityForm
 */
public class ProtocolApplication_Ontol11768Form extends EntityForm<ProtocolApplication_Ontol11768>
{
	private static final long serialVersionUID = 1L;
	
	public ProtocolApplication_Ontol11768Form()
	{
		super();
	}
	
	public ProtocolApplication_Ontol11768Form(ProtocolApplication_Ontol11768 entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<ProtocolApplication_Ontol11768> getEntityClass()
	{
		return ProtocolApplication_Ontol11768.class;
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
		//Autoid: Field(entity=ProtocolApplication_ontol11768, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("ProtocolApplication_ontol11768_autoid",getEntity().getAutoid());
			
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
		//OntologyReference: Field(entity=ProtocolApplication_ontol11768, name=ontologyReference, type=xref[OntologyTerm.id], xref_label='name', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ProtocolApplication_ontol11768_ontologyReference", getEntity().getOntologyReference());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getOntologyReference_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getOntologyReference_Id());
				dummy.setName( getEntity().getOntologyReference_Name() ); 
			}
			XrefInput input = new XrefInput("ProtocolApplication_ontol11768_ontologyReference", org.molgenis.core.OntologyTerm.class, dummy);
			
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
		//InvestigationElement: Field(entity=ProtocolApplication_ontol11768, name=InvestigationElement, type=xref[ProtocolApplication.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ProtocolApplication_ontol11768_InvestigationElement", getEntity().getInvestigationElement());
			//create xref dummy object
			ProtocolApplication dummy = null;
			if(getEntity().getInvestigationElement_Id() != null)
			{
			 	dummy = new ProtocolApplication();
				dummy.setId(getEntity().getInvestigationElement_Id());
				dummy.setName( getEntity().getInvestigationElement_Name() ); 
			}
			XrefInput input = new XrefInput("ProtocolApplication_ontol11768_InvestigationElement", org.molgenis.protocol.ProtocolApplication.class, dummy);
			
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


