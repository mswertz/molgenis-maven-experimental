package org.molgenis.ui.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


import com.google.gson.Gson;

/** A View that converts a payload to JSON using Gson */
public class JsonView extends AbstractView
{
	String payload;

	public JsonView(Object payload)
	{
		this.payload = new Gson().toJson(payload);
	}

	@Override
	public void render(PrintWriter out) throws IOException
	{
		out.write(payload);
	}

	@Override
	public String getContentType()
	{
		return "application/json";
	}

	@Override
	public Map<String, String> getHeaders()
	{
		return new HashMap<String, String>();
	}

	@Override
	public int getContentLength()
	{
		return payload.length();
	}
}
