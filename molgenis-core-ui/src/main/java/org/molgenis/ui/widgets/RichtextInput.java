package org.molgenis.ui.widgets;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Input for string data. Renders as a <code>textarea</code>.
 */
public class RichtextInput extends HtmlInput<RichtextInput, String>
{


	public RichtextInput(String name)
	{
		super(name);
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
			out.println("<input type=\"text\" name=\"" + this.getName()
					+ "\" value=\"" + getValue() + "\" placeholder=\""+getLabel()+"\"/>");
	}
}
