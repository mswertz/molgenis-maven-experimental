/*
 * Created by: org.molgenis.generators.server.MolgenisGuiServiceGen
 * Date: October 22, 2012
 */

package app.servlet;

import org.molgenis.framework.db.Database;
import org.molgenis.framework.server.MolgenisContext;
import org.molgenis.framework.server.MolgenisService;
import org.molgenis.framework.server.services.MolgenisGuiService;
import org.molgenis.framework.ui.ApplicationController;
import org.molgenis.util.EmailService;
import org.molgenis.util.SimpleEmailService;

public class GuiService extends MolgenisGuiService implements MolgenisService
{
	public GuiService(MolgenisContext mc)
	{
		super(mc);
	}

	public ApplicationController createUserInterface()
	{
		ApplicationController app = null;
		try {
			final Database dbForController = super.db;
			app = new ApplicationController(mc)
			{
				private static final long serialVersionUID = 6962189567229247434L;
			
				@Override
				public Database getDatabase()
				{
					return dbForController;
				}
			};
			app.getModel().setLabel("auth");
			app.getModel().setVersion("4.0.0-testing");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		EmailService service = new SimpleEmailService();
		service.setSmtpFromAddress("molgenis@gmail.com");	
		service.setSmtpProtocol("smtps");
		service.setSmtpHostname("smtp.gmail.com");
		service.setSmtpPort(465);
		service.setSmtpUser("molgenis");
		service.setSmtpAu("-5100.-7296.-7975.-8631.-5904.-7599.-8556.-8479.-8556.-4816.-6156.816");	
		app.setEmailService(service);
		
		return app;
	}
}
