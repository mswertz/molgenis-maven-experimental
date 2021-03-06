
/* File:        Test/html/DextendsB.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * 
 * generator:   org.molgenis.ui.generators.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package test.inheritance.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;


// molgenis
import org.molgenis.ui.widgets.*;


import test.inheritance.DextendsB;


/**
 * A HtmlForm that is preloaded with all inputs for entity DextendsB
 * @see EntityForm
 */
public class DextendsBForm extends EntityForm<DextendsB>
{
	
	public DextendsBForm()
	{
		super();
	}
	
	public DextendsBForm(DextendsB entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<DextendsB> getEntityClass()
	{
		return DextendsB.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("__type");
		headers.add("id");
		headers.add("fieldA");
		headers.add("fieldB");
		headers.add("fieldD");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?,?>> getInputs()
	{	
		List<HtmlInput<?,?>> inputs = new ArrayList<HtmlInput<?,?>>();	
				
		//__type
		EnumInput __type = new EnumInput("__type");
		__type.label("__type");
		inputs.add(__type);
		
		//id
		IntInput id = new IntInput("id");
		id.label("id");
		inputs.add(id);
		
		//fieldA
		StringInput fieldA = new StringInput("fieldA");
		fieldA.label("fieldA");
		inputs.add(fieldA);
		
		//fieldB
		StringInput fieldB = new StringInput("fieldB");
		fieldB.label("fieldB");
		inputs.add(fieldB);
		
		//fieldD
		StringInput fieldD = new StringInput("fieldD");
		fieldD.label("fieldD");
		inputs.add(fieldD);
		

		return inputs;
	}
}


