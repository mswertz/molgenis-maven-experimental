
/* File:        Observ/html/Protocol_Features.java
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


import org.molgenis.pheno.ObservableFeature;
import org.molgenis.protocol.Protocol;
import org.molgenis.protocol.Protocol_Features;

import org.molgenis.pheno.csv.ObservableFeatureCsvReader;
import org.molgenis.protocol.csv.ProtocolCsvReader;
import org.molgenis.protocol.csv.Protocol_FeaturesCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity Protocol_Features
 * @see EntityForm
 */
public class Protocol_FeaturesForm extends EntityForm<Protocol_Features>
{
	private static final long serialVersionUID = 1L;
	
	public Protocol_FeaturesForm()
	{
		super();
	}
	
	public Protocol_FeaturesForm(Protocol_Features entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Protocol_Features> getEntityClass()
	{
		return Protocol_Features.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("autoid");
		headers.add("Features");
		headers.add("Protocol");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Autoid: Field(entity=Protocol_Features, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("Protocol_Features_autoid",getEntity().getAutoid());
			
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
		//Features: Field(entity=Protocol_Features, name=Features, type=xref[ObservableFeature.id], xref_label='name', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Protocol_Features_Features", getEntity().getFeatures());
			//create xref dummy object
			ObservableFeature dummy = null;
			if(getEntity().getFeatures_Id() != null)
			{
			 	dummy = new ObservableFeature();
				dummy.setId(getEntity().getFeatures_Id());
				dummy.setName( getEntity().getFeatures_Name() ); 
			}
			XrefInput input = new XrefInput("Protocol_Features_Features", org.molgenis.pheno.ObservableFeature.class, dummy);
			
			input.setLabel("Features");
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
		//Protocol: Field(entity=Protocol_Features, name=Protocol, type=xref[Protocol.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Protocol_Features_Protocol", getEntity().getProtocol());
			//create xref dummy object
			Protocol dummy = null;
			if(getEntity().getProtocol_Id() != null)
			{
			 	dummy = new Protocol();
				dummy.setId(getEntity().getProtocol_Id());
				dummy.setName( getEntity().getProtocol_Name() ); 
			}
			XrefInput input = new XrefInput("Protocol_Features_Protocol", org.molgenis.protocol.Protocol.class, dummy);
			
			input.setLabel("Protocol");
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


