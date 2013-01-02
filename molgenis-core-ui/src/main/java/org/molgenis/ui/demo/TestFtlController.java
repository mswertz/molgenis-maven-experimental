package org.molgenis.ui.demo;

import org.molgenis.ui.Controller;
import org.molgenis.ui.Request;
import org.molgenis.ui.View;
import org.molgenis.ui.view.FreemarkerView;

public class TestFtlController extends Controller
{
	public TestFtlController(String path)
	{
		super(path);
	}

	@Override
	public View index(Request request)
	{
		return new FreemarkerView("TestFtlView.ftl", this);
	}

}
