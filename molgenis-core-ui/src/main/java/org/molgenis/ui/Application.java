package org.molgenis.ui;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.molgenis.ui.view.StringView;

/**
 * FrontController for the whole application. If not catched by a controller is
 * considered static file
 */
public class Application extends HttpServlet
{
	private static final long serialVersionUID = -353412212360611409L;

	/** Map of all controllers, sorted by key */
	Map<String, Controller> controllers = new TreeMap<String, Controller>();

	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		// same for every tested webserver: e.g.
		// "http://localhost:8080/xqtl/api/R"
		String requestURL = request.getRequestURL().toString();

		// same for every tested webserver: e.g. "/xqtl/api/R"
		String requestURI = request.getRequestURI();

		// empty for Apache Tomcat, but e.g. "/xqtl" for standalone
		String appName = request.getServletPath();
		if (appName.equals(""))
		{
			// empty for standalone, but e.g. "/xqtl" for Apache Tomcat
			appName = request.getContextPath();
		}

		// turns "http://localhost:8080/xqtl/api/R" into
		// "http://localhost:8080/xqtl"
		String appLocation = requestURL.substring(0, requestURL.length() - (requestURI.length() - appName.length()));

		// turns "http://localhost:8080/xqtl/api/R" into "/api/R"
		String requestPath = requestURL.substring(requestURL.length() - (requestURI.length() - appName.length()));

		try
		{
			for (String servicePath : controllers.keySet())
			{
				if (requestPath.startsWith(servicePath))
				{
					System.out.println("> serving: " + requestPath);
					long start = System.currentTimeMillis();

					// create request
					Request req = new Request(request);
					req.setAppLocation(appLocation);
					req.setServicePath(servicePath);
					req.setRequestPath(requestPath);

					// let controller handle request and produce view
					Controller controller = controllers.get(servicePath);
					View view = new StringView("path not found: " + requestPath);

					// cut of service path
					String actionName = "";
					if (requestPath.length() > servicePath.length()) actionName = requestPath.substring(servicePath
							.length() + 1);

					if ("".equals(actionName)) view = controller.index(req);
					else
					{
						try
						{
							final Method action = controller.getClass().getMethod(actionName, Request.class);
							view = (View) action.invoke(controller, request);

						}
						catch (Exception e)
						{
							e.printStackTrace();
							// return new StringView("Action '" + actionName +
							// "' unknown in " + this.getClass().getSimpleName()
							// + "("
							// + getPath() + ")");
						}
					}

					// create the view
					response.setContentType(view.getContentType());
					if (view.getContentLength() > 0) response.setContentLength(view.getContentLength());
					for (Entry<String, String> header : view.getHeaders().entrySet())
						response.setHeader(header.getKey(), header.getValue());

					// render the view
					PrintWriter writer = new PrintWriter(new BufferedWriter(response.getWriter()));
					try
					{
						view.render(writer);
					}
					finally
					{
						writer.flush();
						writer.close();
					}

					System.out.println("> complete in " + (System.currentTimeMillis() - start) + "ms : " + requestPath);
					return;
				}
			}

			// otherwise consider file
			super.service(request, response);
		}
		catch (Exception e)
		{
			try
			{
				response.getWriter().write(e.getMessage());
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public void addController(Controller controller)
	{
		this.controllers.put(controller.getPath(), controller);
	}
}
