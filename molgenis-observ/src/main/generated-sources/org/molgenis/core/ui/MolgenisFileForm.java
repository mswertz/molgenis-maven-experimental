
/* File:        Observ/html/MolgenisFile.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
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


import org.molgenis.core.MolgenisFile;

import org.molgenis.core.csv.MolgenisFileCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity MolgenisFile
 * @see EntityForm
 */
public class MolgenisFileForm extends EntityForm<MolgenisFile>
{
	private static final long serialVersionUID = 1L;
	
	public MolgenisFileForm()
	{
		super();
	}
	
	public MolgenisFileForm(MolgenisFile entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<MolgenisFile> getEntityClass()
	{
		return MolgenisFile.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("id");
		headers.add("name");
		headers.add("__Type");
		headers.add("Extension");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=MolgenisFile, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("MolgenisFile_id",getEntity().getId());
			
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
			StringInput input = new StringInput("MolgenisFile_name",getEntity().getName());
			
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
			EnumInput input = new EnumInput("MolgenisFile___Type",getEntity().get__Type());
			
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
			StringInput input = new StringInput("MolgenisFile_Extension",getEntity().getExtension());
			
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

		return inputs;
	}
}


