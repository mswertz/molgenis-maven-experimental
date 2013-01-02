package org.molgenis.ui.demo;

import org.molgenis.ui.Controller;
import org.molgenis.ui.Request;
import org.molgenis.ui.View;
import org.molgenis.ui.view.GuiView;
import org.molgenis.ui.widgets.Button.Style;
import org.molgenis.ui.widgets.Form;
import org.molgenis.ui.widgets.FormLayout;
import org.molgenis.ui.widgets.H1;
import org.molgenis.ui.widgets.HorizontalLayout;
import org.molgenis.ui.widgets.InlineLayout;
import org.molgenis.ui.widgets.Legend;
import org.molgenis.ui.widgets.Success;
import org.molgenis.ui.widgets.VerticalLayout;

public class TestFormController extends Controller
{
	public TestFormController(String path)
	{
		super(path);
	}

	public View index(Request request)
	{

		Form f = new Form("main");

		InlineLayout il = new InlineLayout();
		
		il.add(new H1("Inline form:"));

		il.add(ExampleInputFactory.createInputs("il"));
		
		f.add(il);

		Form f2 = new Form("main2");

		f2.add(new H1("Vertical form:"));

		FormLayout<VerticalLayout> vl = new VerticalLayout();
		vl.add(new Legend("This is a form"));

		vl.add(ExampleInputFactory.createInputs("vl"));
		
		f2.add(vl);
		f2.button("save2").text("Save").style(Style.PRIMARY);
		f2.button("index2").text("Cancel").style(Style.DANGER);

		Form f3 = new Form("main3");

		HorizontalLayout hl = new HorizontalLayout();

		hl.add(new Legend("This is a form"));

		hl.add(ExampleInputFactory.createInputs("hl"));

		f3.add(new H1("Horizontal form:"));
		f3.add(hl);
		f3.button("save3").text("Save").setOnClick("$(this).closest('form').submit();");
		f3.button("index3").text("Cancel");

		return new GuiView().add().add(f).add(f2).add(f3);
	}

	public View save(Request request)
	{
		// pretend save is ok

		return new GuiView().add(new Success("save succesfull"));
	}
}
