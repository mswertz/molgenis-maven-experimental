
/* File:        Observ/html/Protocol_subprotocols.java
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


import org.molgenis.protocol.Protocol;
import org.molgenis.protocol.Protocol_Subprotocols;

import org.molgenis.protocol.csv.ProtocolCsvReader;
import org.molgenis.protocol.csv.Protocol_SubprotocolsCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity Protocol_Subprotocols
 * @see EntityForm
 */
public class Protocol_SubprotocolsForm extends EntityForm<Protocol_Subprotocols>
{
	private static final long serialVersionUID = 1L;
	
	public Protocol_SubprotocolsForm()
	{
		super();
	}
	
	public Protocol_SubprotocolsForm(Protocol_Subprotocols entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Protocol_Subprotocols> getEntityClass()
	{
		return Protocol_Subprotocols.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("autoid");
		headers.add("subprotocols");
		headers.add("Protocol");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Autoid: Field(entity=Protocol_subprotocols, name=autoid, type=int, auto=true, nillable=false, readonly=false, default=null)
		{
			IntInput input = new IntInput("Protocol_subprotocols_autoid",getEntity().getAutoid());
			
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
		//Subprotocols: Field(entity=Protocol_subprotocols, name=subprotocols, type=xref[Protocol.id], xref_label='name', auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Protocol_subprotocols_subprotocols", getEntity().getSubprotocols());
			//create xref dummy object
			Protocol dummy = null;
			if(getEntity().getSubprotocols_Id() != null)
			{
			 	dummy = new Protocol();
				dummy.setId(getEntity().getSubprotocols_Id());
				dummy.setName( getEntity().getSubprotocols_Name() ); 
			}
			XrefInput input = new XrefInput("Protocol_subprotocols_subprotocols", org.molgenis.protocol.Protocol.class, dummy);
			
			input.setLabel("subprotocols");
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
		//Protocol: Field(entity=Protocol_subprotocols, name=Protocol, type=xref[Protocol.id], xref_label=, auto=false, nillable=false, readonly=false, default=null)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Protocol_subprotocols_Protocol", getEntity().getProtocol());
			//create xref dummy object
			Protocol dummy = null;
			if(getEntity().getProtocol_Id() != null)
			{
			 	dummy = new Protocol();
				dummy.setId(getEntity().getProtocol_Id());
				dummy.setName( getEntity().getProtocol_Name() ); 
			}
			XrefInput input = new XrefInput("Protocol_subprotocols_Protocol", org.molgenis.protocol.Protocol.class, dummy);
			
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


