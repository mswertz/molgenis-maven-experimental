package org.molgenis.db.generators;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.molgenis.MolgenisModel;
import org.molgenis.MolgenisOptions;
import org.molgenis.model.EntityModel;

import freemarker.template.Template;

public class CopyMemoryToDatabaseGen extends MySqlCreateClassPerTableGen
{
	public static final transient Logger logger = Logger.getLogger(CopyMemoryToDatabaseGen.class);

	@Override
	public String getDescription()
	{
		return "Generates CopyMemoryToDatabase tool";
	}

	@Override
	public void generate(MolgenisModel model, MolgenisOptions options) throws Exception
	{
		Template template = createTemplate("/" + this.getClass().getSimpleName() + ".java.ftl");
		Map<String, Object> templateArgs = createTemplateArguments(options);

		List<EntityModel> entityList = model.getEntities();
		MolgenisModel.sortEntitiesByDependency(entityList, model); // side
																	// effect?
		String packageName = "app";

		File target = new File(this.getSourcePath(options) + "/app/CopyMemoryToDatabase.java");
		boolean created = target.getParentFile().mkdirs();
		if (!created && !target.getParentFile().exists())
		{
			throw new IOException("could not create " + target.getParentFile());
		}

		templateArgs.put("model", model);
		templateArgs.put("entities", entityList);
		templateArgs.put("package", packageName);
		OutputStream targetOut = new FileOutputStream(target);
		template.process(templateArgs, new OutputStreamWriter(targetOut, Charset.forName("UTF-8")));
		targetOut.close();

		logger.info("generated " + target);
	}

}
