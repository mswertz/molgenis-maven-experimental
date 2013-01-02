
/* File:        Observ/html/ProtocolDocument.java
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
import org.molgenis.protocol.ProtocolDocument;

import org.molgenis.protocol.csv.ProtocolCsvReader;
import org.molgenis.protocol.csv.ProtocolDocumentCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity ProtocolDocument
 * @see EntityForm
 */
public class ProtocolDocumentForm extends EntityForm<ProtocolDocument>
{
	private static final long serialVersionUID = 1L;
	
	public ProtocolDocumentForm()
	{
		super();
	}
	
	public ProtocolDocumentForm(ProtocolDocument entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<ProtocolDocument> getEntityClass()
	{
		return ProtocolDocument.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("id");
		headers.add("name");
		headers.add("__Type");
		headers.add("Extension");
		headers.add("protocol");
		headers.add("document");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=ProtocolDocument, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("ProtocolDocument_id",getEntity().getId());
			
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
		//Name: Field(entity=MolgenisFile, name=name, type=string[127], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("ProtocolDocument_name",getEntity().getName());
			
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
		//__Type: Field(entity=MolgenisFile, name=__Type, type=enum, auto=true, nillable=false, readonly=true, default=null, enum_options=[MolgenisFile, ProtocolDocument])
		{
			EnumInput input = new EnumInput("ProtocolDocument___Type",getEntity().get__Type());
			
			input.setLabel("__Type");
			input.setDescription("Subtypes have to be set to allow searching");
			input.setNillable(false);
			input.setReadonly(true); //automatic fields that are readonly, are also readonly on newrecord
			input.setOptions(getEntity().get__TypeOptions());
			input.setHidden(true);
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Extension: Field(entity=MolgenisFile, name=Extension, type=string[8], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("ProtocolDocument_Extension",getEntity().getExtension());
			
			input.setLabel("Extension");
			input.setDescription("The file extension. This will be mapped to MIME type at runtime. For example, a type &apos;png&apos; will be served out as &apos;image/png&apos;.");
			input.setNillable(false);
			input.setSize(8);
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
		//Protocol: Field(entity=ProtocolDocument, name=protocol, type=xref[Protocol.id], xref_label='name', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ProtocolDocument_protocol", getEntity().getProtocol());
			//create xref dummy object
			Protocol dummy = null;
			if(getEntity().getProtocol_Id() != null)
			{
			 	dummy = new Protocol();
				dummy.setId(getEntity().getProtocol_Id());
				dummy.setName( getEntity().getProtocol_Name() ); 
			}
			XrefInput input = new XrefInput("ProtocolDocument_protocol", org.molgenis.protocol.Protocol.class, dummy);
			
			input.setLabel("protocol");
			input.setDescription("protocol");
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
		//Document: Field(entity=ProtocolDocument, name=document, type=file, auto=false, nillable=false, readonly=false, default=)
		{
			FileInput input = new FileInput("ProtocolDocument_document",getEntity().getDocument());
			
			input.setLabel("document");
			input.setDescription("document");
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

		return inputs;
	}
}


