package org.molgenis.ui.widgets;


/**
 * Input for string data. Renders as a <code>textarea</code>.
 */
public class StringInput extends ValidatingInput<StringInput, String>
{


	public StringInput(String name)
	{
		super(name, "");
	}
}
