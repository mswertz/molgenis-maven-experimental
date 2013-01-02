package org.molgenis.ui.view;

import java.io.IOException;
import java.io.PrintWriter;


/** A View that simply renders a String */
public class StringView extends AbstractView
{
	String value;

	public StringView(String value)
	{
		this.value = value;
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.write(value);
	}

}
