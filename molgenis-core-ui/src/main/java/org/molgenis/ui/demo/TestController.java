package org.molgenis.ui.demo;

import org.molgenis.ui.Controller;
import org.molgenis.ui.Request;
import org.molgenis.ui.View;
import org.molgenis.ui.view.StringView;

public class TestController extends Controller
{
	public TestController(String path)
	{
		super(path);
	}
	
	public View action1(Request request)
	{
		return new StringView("action1, request="+request);
	}

	@Override
	public View index(Request request)
	{
		return new StringView("hello world");
	}

}
