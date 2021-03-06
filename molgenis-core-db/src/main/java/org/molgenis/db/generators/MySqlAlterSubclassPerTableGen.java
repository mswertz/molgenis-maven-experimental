package org.molgenis.db.generators;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.molgenis.MolgenisGenerator;
import org.molgenis.MolgenisModel;
import org.molgenis.MolgenisOptions;
import org.molgenis.model.EntityModel;

import freemarker.template.Template;

public class MySqlAlterSubclassPerTableGen extends MolgenisGenerator
{
	public static final transient Logger logger = Logger.getLogger(MySqlAlterSubclassPerTableGen.class);

	@Override
	public String getDescription()
	{
		return "Generates create tables and views for each entity.";
	}

	@Override
	public void generate(MolgenisModel model, MolgenisOptions options) throws Exception
	{
		Template template = createTemplate("/" + this.getClass().getSimpleName() + ".mysql.ftl");
		Map<String, Object> templateArgs = createTemplateArguments(options);

		List<EntityModel> entityList = model.getEntities();
		entityList = MolgenisModel.sortEntitiesByDependency(entityList, model); // side
																				// effect?

		File target = new File(this.getSqlPath(options) + "/alter_tables.sql");
		target.getParentFile().mkdirs();

		templateArgs.put("model", model);
		templateArgs.put("entities", entityList);
		OutputStream targetOut = new FileOutputStream(target);
		template.process(templateArgs, new OutputStreamWriter(targetOut, Charset.forName("UTF-8")));
		targetOut.close();

		logger.info("generated " + target);
	}
}
