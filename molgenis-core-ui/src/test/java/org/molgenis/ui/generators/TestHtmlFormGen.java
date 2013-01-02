package org.molgenis.ui.generators;

import java.io.File;

import org.molgenis.MolgenisModel;
import org.molgenis.MolgenisOptions;
import org.molgenis.db.generators.DataTypeGen;
import org.testng.annotations.Test;

public class TestHtmlFormGen
{
	@Test
	public void test1() throws Exception
	{
		//parse model
		MolgenisModel m = MolgenisModel.parse(new File("src/test/resources/org/molgenis/model/test.xml"));
		
		//relevant options
		MolgenisOptions o = new MolgenisOptions();
		o.output_src = "src/test/generated-sources/";
		
		//generate
		new DataTypeGen().generate(m, o);
		new HtmlFormGen().generate(m, o);
	}
}
