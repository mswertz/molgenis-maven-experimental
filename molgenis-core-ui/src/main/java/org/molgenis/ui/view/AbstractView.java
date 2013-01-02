package org.molgenis.ui.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.molgenis.ui.View;

/**
 * View is responsible for rendering
 */
public abstract class AbstractView implements View
{
	String contentType;
	int contentLength;
	Map<String, String> headers = new LinkedHashMap<String, String>();

	/* (non-Javadoc)
	 * @see org.molgenis.core.View#getContentType()
	 */
	@Override
	public String getContentType()
	{
		return contentType;
	}

	protected void setContentType(String contentType)
	{
		this.contentType = contentType;
	}

	/* (non-Javadoc)
	 * @see org.molgenis.core.View#getContentLength()
	 */
	@Override
	public int getContentLength()
	{
		return contentLength;
	}

	protected void setContentLength(int contentLength)
	{
		this.contentLength = contentLength;
	}

	/* (non-Javadoc)
	 * @see org.molgenis.core.View#getHeaders()
	 */
	@Override
	public Map<String, String> getHeaders()
	{
		return headers;
	}

	protected void setHeader(String name, String value)
	{
		headers.put(name, value);
	}
	
	/* (non-Javadoc)
	 * @see org.molgenis.core.View#render(java.io.PrintWriter)
	 */
	@Override
	public abstract void render(PrintWriter out) throws IOException;
}
