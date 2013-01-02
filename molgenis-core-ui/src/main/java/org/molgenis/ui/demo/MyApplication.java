package org.molgenis.ui.demo;

import org.molgenis.ui.Application;

public class MyApplication extends Application
{
	private static final long serialVersionUID = -1826676160404667428L;

	//construct
	public void init(javax.servlet.ServletConfig conf) throws javax.servlet.ServletException
	{
		super.init(conf);
		
		super.addController(new TestController("/test"));
		super.addController(new TestFtlController("/ftl"));
		super.addController(new TestGuiController("/gui"));
		super.addController(new TestFormController("/form"));
		super.addController(new TestNavigationController("/tab"));
		//super.addController(new TableLimitOffsetController("/list"));
	}
}
