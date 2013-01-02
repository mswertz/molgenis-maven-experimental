package org.molgenis.ui;

import org.testng.log4testng.Logger;

/**
 * Controller handles http requests of form
 * [APP_URL]/[CONTROLLER_PATH]/[ACTION]
 * 
 * <ul>
 * <li>
 * Action maps to method: Controller("home").foo(request) responds to
 * [APP_URL]/home/foo
 * <li>
 * Default action is 'index': Controller("home").index(request) responds to
 * [APP_URL]/home
 * <li>
 * Parameters are mapped to request, e.g. [APP_URL]/home/foo?bar=hello will
 * enable request.getString("hello")
 * <li>
 * Controllers can be nested: Controller("home").add(new Controller("sweet")) will reply to [APP_URL]/home/[ACTION]/sweet/[ACTION]
 * Parameters will be passed to both action handlers.
 * </ul>
 */
public abstract class Controller
{
	// logger
	private Logger logger = Logger.getLogger(this.getClass());

	// relative path of this controller
	private String path;

	// path to the application hosting this controller
	private Application application;

	public Controller(String path)
	{
		if (path == null || "".equals(path)) throw new RuntimeException("new " + this.getClass()
				+ "(path) failed: path cannot be null");
		this.path = path;
	}

	public String getPath()
	{
		return path;
	}

	protected void setApplication(Application application)
	{
		this.application = application;
	}

	public Application getApplication()
	{
		return application;
	}

	public void debug(Object message)
	{
		logger.debug(message);
	}

	/** Returns the default view */
	public abstract View index(Request request);
}
