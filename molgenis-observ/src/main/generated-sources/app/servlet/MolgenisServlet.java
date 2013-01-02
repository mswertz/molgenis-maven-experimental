/*
 * Created by: org.molgenis.generators.server.MolgenisServletGen
 * Date: October 11, 2012
 */

package app.servlet;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import org.molgenis.framework.security.Login;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.ui.ApplicationController;
import org.molgenis.framework.server.AbstractMolgenisServlet;
import org.apache.commons.dbcp.BasicDataSource;
import org.molgenis.framework.server.TokenFactory;
import org.molgenis.util.EmailService;
import org.molgenis.util.SimpleEmailService;
import org.apache.commons.dbcp.BasicDataSource;
import org.molgenis.framework.db.DatabaseException;

@Deprecated
public class MolgenisServlet extends AbstractMolgenisServlet
{
	private static final long serialVersionUID = 3141439968743510237L;

	public MolgenisServlet() {
		this.usedOptions = new UsedMolgenisOptions();
	}
	
	protected Database createDatabase() {
		try
		{
			//The datasource is created by the servletcontext	
			BasicDataSource data_src = new BasicDataSource();
			data_src.setDriverClassName("com.mysql.jdbc.Driver");
			data_src.setUsername("molgenis");
			data_src.setPassword("molgenis");
			data_src.setUrl("jdbc:mysql://localhost/animaldb_pheno?innodb_autoinc_lock_mode=2"); // a path within the src folder?
			data_src.setMaxIdle(10);
			data_src.setMaxWait(1000);
		
			DataSource dataSource = (DataSource)data_src;
			Database db = new app.JDBCDatabase(dataSource, new File("attachedfiles/"));
			return db;			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public Database getDatabase() throws Exception
	{
		return super.getDatabase();
	}
	

	public Login createLogin( Database db, HttpServletRequest request ) throws Exception
	{
		Login login = (Login)request.getSession().getAttribute("login");
		if(login == null) {
			login = new org.molgenis.framework.security.SimpleLogin(db, new TokenFactory());
			request.getSession().setAttribute("login", login);
		}
		db.setLogin(login);
		return login;	
	}

	public ApplicationController createUserInterface( Login userLogin )
	{
		//enhance the ApplicationController with a method to getDatabase 
		ApplicationController app = new ApplicationController( usedOptions, userLogin)
		{
			private static final long serialVersionUID = 6962189567229247434L;
		
			@Override
			public Database getDatabase()
			{
				BasicDataSource data_src = new BasicDataSource();
				data_src.setDriverClassName("com.mysql.jdbc.Driver");
				data_src.setUsername("molgenis");
				data_src.setPassword("molgenis");
				data_src.setUrl("jdbc:mysql://localhost/animaldb_pheno?innodb_autoinc_lock_mode=2"); // a path within the src folder?
				data_src.setMaxIdle(10);
				data_src.setMaxWait(1000);
				DataSource dataSource = (DataSource)data_src;
				Database db;
				try
				{
					db = new app.JDBCDatabase(dataSource, new File("./data/"));
					return db;
				}
				catch (DatabaseException e)
				{
					e.printStackTrace();
					return null;
				}
				
			}
		};
		app.getModel().setLabel("observ");
		app.getModel().setVersion("4.0.0-testing");
		
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
	
	public static String getMolgenisVariantID()
	{
		return "observ";
	}	
	
	@Override
	public Object getSoapImpl() throws Exception
	{
		return new app.servlet.SoapApi((Database)getDatabase());
	}
}
