package org.molgenis.db.generators;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Map;

import org.molgenis.MolgenisModel;
import org.molgenis.MolgenisOptions;
import org.molgenis.generate.ForEachEntityGenerator;
import org.molgenis.generate.GeneratorHelper;
import org.molgenis.model.EntityModel;

import freemarker.template.Template;

public class MapperSecurityDecoratorGen extends ForEachEntityGenerator
{
	@Override
	public String getDescription()
	{
		return "(Optional) Generates an authorization decorator.";
	}

	@Override
	public String getType()
	{
		return "";
	}

	// @Override
	public void generate(MolgenisModel model, MolgenisOptions options) throws Exception
	{
		Template template = this.createTemplate(this.getClass().getSimpleName() + getExtension() + ".ftl");
		Map<String, Object> templateArgs = createTemplateArguments(options);

		// apply generator to each entity
		for (EntityModel entity : model.getEntities())
		{
			try
			{
				if (entity.getAbstract()) continue;

				String fullKlazzName = entity.getNamespace() + ".db." + GeneratorHelper.getJavaName(entity.getName())
						+ "SecurityDecorator";

				String packageName = fullKlazzName;
				if (fullKlazzName.contains(".")) packageName = fullKlazzName.substring(0,
						fullKlazzName.lastIndexOf("."));

				String shortKlazzName = fullKlazzName;
				if (fullKlazzName.contains(".")) shortKlazzName = fullKlazzName.substring(fullKlazzName
						.lastIndexOf(".") + 1);

				File targetDir = new File(this.getSourcePath(options) + "/" + packageName.replace(".", "/"));
				targetDir.mkdirs();

				File targetFile = new File(targetDir + "/" + shortKlazzName + ".java");

				templateArgs.put("entityClass",
						entity.getNamespace() + "." + GeneratorHelper.getJavaName(entity.getName()));

				templateArgs.put("clazzName", shortKlazzName);
				templateArgs.put("entity", entity);
				templateArgs.put("model", model);
				// templateArgs.put("db_driver", options.db_driver);
				templateArgs.put("template", template.getName());
				templateArgs.put("file",
						packageName.replace(".", "/") + "/" + GeneratorHelper.getJavaName(entity.getName()) + getType()
								+ getExtension());
				templateArgs.put("package", packageName);
				templateArgs
						.put("databaseImp", options.mapper_implementation
								.equals(MolgenisOptions.MapperImplementation.JPA) ? "jpa" : "jdbc");

				templateArgs.remove("authorizable");
				for (EntityModel e : entity.getAllImplements())
				{
					if ("Authorizable".equals(e.getName()))
					{
						templateArgs.put("authorizable", true);
					}
				}

				OutputStream targetOut = new FileOutputStream(targetFile);

				template.process(templateArgs, new OutputStreamWriter(targetOut, Charset.forName("UTF-8")));
				targetOut.close();

				// logger.info("generated " +
				// targetFile.getAbsolutePath());
				logger.info("generated " + targetFile);
			}
			catch (Exception e)
			{
				logger.error("problem generating for " + entity.getName());
				throw e;
			}
		}
	}

}
