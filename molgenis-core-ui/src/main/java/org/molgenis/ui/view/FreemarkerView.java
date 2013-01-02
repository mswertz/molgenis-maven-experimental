package org.molgenis.ui.view;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * A View that renders a model object using Freemarker.
 * 
 * If only one parameter is given it can be referenced using '${model}'.
 * Alternatively one can use addParameter(name,object) to add named ${name}
 * objects as Freemarker parameter
 */
public class FreemarkerView extends AbstractView
{
	// use static configuration so ftls are cached between views
	private static freemarker.template.Configuration conf = null;

	private String templatePath;
	private transient Logger logger = Logger.getLogger(FreemarkerView.class);
	private Map<String, Object> arguments = new LinkedHashMap<String, Object>();
	private Object model;

	public FreemarkerView(String templatePath, Object model)
	{
		this.templatePath = templatePath;
		this.model = model;
	}

	/**
	 * Assumes template to be klazzpath + ".ftl"
	 * 
	 * @param klazz
	 * @param templateArgs
	 */
	public FreemarkerView(Class<?> klazz, Map<String, Object> templateArgs)
	{
		this(klazz.getCanonicalName().replace(".", "/") + ".ftl", templateArgs);
	}

	public FreemarkerView(String templatePath, Map<String, Object> templateArgs)
	{
		this.templatePath = templatePath;
		this.arguments = templateArgs;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(PrintWriter writer)
	{
		logger.debug("trying to render " + templatePath);

		arguments.put("model", model);
		try
		{
			// keep configuration in session so we can reuse it
			if (conf == null)
			{
				logger.debug("create freemarker config");
				// create configuration
				if (conf == null)
				{
					conf = new freemarker.template.Configuration();
					conf.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
				}
				List<TemplateLoader> loaders = new ArrayList<TemplateLoader>();

				// create template loader
				// load templates from MOLGENIS
				//loaders.add(new ClassTemplateLoader(MolgenisOriginalStyle.class, ""));
				// load templates from plugins, can be anywere
				// (nb this method is deprecated but I can't see why)
				loaders.add(new ClassTemplateLoader());

				for (Object key : arguments.keySet())
				{
					if ("model".equals(key) && arguments.get(key) != null)
					{
						loaders.add(new ClassTemplateLoader(arguments.get(key).getClass()));

						// also add superclass because of generated code
						loaders.add(new ClassTemplateLoader(arguments.get(key).getClass().getSuperclass()));
					}
				}
				loaders.add(new FileTemplateLoader());
				loaders.add(new FileTemplateLoader(new File("/")));

				// ClassTemplateLoader loader1 = new ClassTemplateLoader(
				// Object.class, "");
				// ClassTemplateLoader loader2 = new ClassTemplateLoader(
				// getClass().getSuperclass(), "");
				MultiTemplateLoader mLoader = new MultiTemplateLoader(
						loaders.toArray(new TemplateLoader[loaders.size()]));
				conf.setTemplateLoader(mLoader);
				logger.debug("created freemarker config");
			}

			// merge template
			conf.addAutoInclude("ScreenViewHelper.ftl");

			//WidgetFactory.configure(conf);

			Template template = conf.getTemplate(templatePath);

			template.process(arguments, writer);
		}
		catch (Exception e)
		{
			logger.error("rendering of template " + templatePath + " failed:");
			e.printStackTrace();

			PrintWriter pw = new PrintWriter(writer, true);
			e.printStackTrace(pw);
			pw.flush();
		}
	}

	public String getTemplatePath()
	{
		return templatePath;
	}

	public void setTemplatePath(String templatePath)
	{
		this.templatePath = templatePath;
	}

	public void addParameter(String name, Object value)
	{
		this.arguments.put(name, value);
	}
}
