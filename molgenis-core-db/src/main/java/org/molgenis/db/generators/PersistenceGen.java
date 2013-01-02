package org.molgenis.db.generators;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.log4j.Logger;
import org.molgenis.MolgenisGenerator;
import org.molgenis.MolgenisModel;
import org.molgenis.MolgenisOptions;

import freemarker.template.Template;

public class PersistenceGen extends MolgenisGenerator
{
	public static final transient Logger logger = Logger.getLogger(PersistenceGen.class);

	@Override
	public String getDescription()
	{
		return "Generates persistence.xml";
	}

	@Override
	public void generate(MolgenisModel model, MolgenisOptions options) throws Exception
	{
		Template template = createTemplate("/" + getClass().getSimpleName() + ".xml.ftl");
		Map<String, Object> templateArgs = createTemplateArguments(options);

		File target = new File(this.getSourcePath(options) + "/META-INF/persistence.xml");
		boolean created = target.getParentFile().mkdirs();
		if (!created && !target.getParentFile().exists())
		{
			throw new IOException("could not create " + target.getParentFile());
		}

		templateArgs.put("options", options);
		templateArgs.put("model", model);

		OutputStream targetOut = new FileOutputStream(target);
		template.process(templateArgs, new OutputStreamWriter(targetOut, Charset.forName("UTF-8")));
		targetOut.close();

		logger.info("generated " + target);
	}
}
