package org.molgenis.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public interface View
{
	/** ContentType. E.g. html/text */
	public abstract String getContentType();

	/** ContentLength in bytes. Default 0 */
	public abstract int getContentLength();

	public abstract Map<String, String> getHeaders();

	/** Renders the view to the output */
	public abstract void render(PrintWriter out) throws IOException;

}