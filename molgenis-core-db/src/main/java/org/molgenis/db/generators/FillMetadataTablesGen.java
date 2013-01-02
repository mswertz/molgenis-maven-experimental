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

public class FillMetadataTablesGen extends MolgenisGenerator
{
	public static final transient Logger logger = Logger.getLogger(FillMetadataTablesGen.class);

	@Override
	public String getDescription()
	{
		return "Fills the metadata tables.";
	}

	@Override
	public void generate(MolgenisModel model, MolgenisOptions options) throws Exception
	{
		Template template = createTemplate(getClass().getSimpleName() + ".sql.ftl");
		Map<String, Object> templateArgs = createTemplateArguments(options);

		String packageName = DataTypeGen.class.getPackage().toString()
				.substring(MolgenisGenerator.class.getPackage().toString().length());
		File target = new File(this.getSqlPath(options) + "/insert_metadata.sql");
		boolean created = target.getParentFile().mkdirs();
		if (!created && !target.getParentFile().exists())
		{
			throw new IOException("could not create " + target.getParentFile());
		}

		templateArgs.put("model", model);
		templateArgs.put("package", model.getName().toLowerCase() + packageName);
		templateArgs.put("db_driver", options.db_driver);
		OutputStream targetOut = new FileOutputStream(target);
		template.process(templateArgs, new OutputStreamWriter(targetOut, Charset.forName("UTF-8")));
		targetOut.close();

		logger.info("generated " + target);
	}

}
