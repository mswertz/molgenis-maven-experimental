package org.molgenis.ui.demo;

import org.molgenis.ui.Controller;
import org.molgenis.ui.Request;
import org.molgenis.ui.View;
import org.molgenis.ui.view.GuiView;
import org.molgenis.ui.view.StringView;
import org.molgenis.ui.widgets.Button;
import org.molgenis.ui.widgets.Form;
import org.molgenis.ui.widgets.H1;
import org.molgenis.ui.widgets.MenuItem;
import org.molgenis.ui.widgets.Navigation;
import org.molgenis.ui.widgets.StringInput;

public class TestNavigationController extends Controller
{
	public TestNavigationController(String path)
	{
		super(path);
	}

	public View hello(Request request)
	{
		return new StringView("hello???");
	}

	@Override
	public View index(Request request)
	{
		Navigation menu = new Navigation("main");

		menu.add(new MenuItem("item1").setLabel("Item 1").setContents("This is item 1"));
		menu.add(new MenuItem("item2").setLabel("Item 2").setHref(action("hello")));

		Form form = new Form("mainform");
		form.setLayout(Form.FormLayout.INLINE);
		form.add(new StringInput("mystring").value("hello world"));
		form.add(new Button("hello"));

		return new GuiView().add(new H1("Test1")).add(menu).add(form);
	}

	public String action(String action)
	{
		return this.getPath() + "?__action=" + action;
	}
}
