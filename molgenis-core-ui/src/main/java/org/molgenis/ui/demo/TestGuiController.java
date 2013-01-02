package org.molgenis.ui.demo;

import java.sql.Date;

import org.molgenis.db.Tuple;
import org.molgenis.db.common.SimpleTuple;
import org.molgenis.ui.Controller;
import org.molgenis.ui.Request;
import org.molgenis.ui.View;
import org.molgenis.ui.view.GuiView;
import org.molgenis.ui.view.StringView;
import org.molgenis.ui.widgets.Button;
import org.molgenis.ui.widgets.ButtonDropdown;
import org.molgenis.ui.widgets.Danger;
import org.molgenis.ui.widgets.DateInput;
import org.molgenis.ui.widgets.Form;
import org.molgenis.ui.widgets.Info;
import org.molgenis.ui.widgets.MenuItem;
import org.molgenis.ui.widgets.Navigation;
import org.molgenis.ui.widgets.Pager;
import org.molgenis.ui.widgets.Progress;
import org.molgenis.ui.widgets.StringInput;
import org.molgenis.ui.widgets.Success;
import org.molgenis.ui.widgets.Table;
import org.molgenis.ui.widgets.Warning;

public class TestGuiController extends Controller
{
	public TestGuiController(String path)
	{
		super(path);
	}

	public View index(Request request)
	{
		
		Navigation menu = new Navigation("tab");

		menu.add(new MenuItem("item1").setLabel("Item 1").setContents("This is item 1"));
		menu.add(new MenuItem("item2").setLabel("Item 2").setHref("hello"));

		Form f = new Form("main");

		f.add(new StringInput("teststring"));
		f.add(new StringInput("__action").value("hello"));
		f.add(new Button("submit"));

		// simulate a table
		Table t = new Table("testtable");
		for (int i = 0; i < 10; i++)
		{
			Tuple row = new SimpleTuple();

			for (int j = 0; j < 10; j++)
			{
				row.set("col" + j, "row" + i + "," + j);
			}

			t.addRow(row);
		}

		Pager p = new Pager().next("?next").prev("?prev");

		ButtonDropdown d = new ButtonDropdown("myDropdown").add(new Button("test1")).add(new Button("test2"))
				.add(new ButtonDropdown("submenu").add(new Button("test3")));
		
		Progress pg = new Progress().warn(10,"warning").success(20).danger(60).info(10);

		DateInput date = new DateInput("mydate").value(new Date(System.currentTimeMillis()));
		
		return new GuiView().add(date).add(pg).add(new Warning("warning!")).add(new Success("success!")).add(new Info("info")).add(new Danger("error!")).add(menu).add(d).add(f).add(t).add(p);
	}

	public View hello(Request request)
	{
		debug("hello! " + request);

		return new StringView("you found the hello(Request) method");
	}
}
