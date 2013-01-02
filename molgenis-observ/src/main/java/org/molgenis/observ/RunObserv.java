package org.molgenis.observ;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;

import app.servlet.UsedMolgenisOptions;

/**
 * TJWS wrapper for Molgenis. See http://tjws.sourceforge.net/ -> Embedded usage
 * 
 * @author joerivandervelde
 * 
 */
public class RunObserv {
	public RunObserv(int port) throws IOException {

		class MyServ extends Acme.Serve.Serve {
			private static final long serialVersionUID = -4687683036134257812L;

			public void setMappingTable(PathTreeDictionary mappingtable) {
				super.setMappingTable(mappingtable);
				try {
					this.init();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			protected void initMime() {
				super.initMime();
				mime = new Properties();
				try {
					mime.load(super
							.getClass()
							.getClassLoader()
							.getResourceAsStream(
									"Acme/Resource/mime.properties"));
				} catch (Exception ex) {
					log("MIME map can't be loaded:" + ex);
				}
			}
		}
		;

		// enable log
		BasicConfigurator.configure();

		// server
		final MyServ srv = new MyServ();

		// set WebContent alias
		Acme.Serve.Serve.PathTreeDictionary aliases = new Acme.Serve.Serve.PathTreeDictionary();
		
		System.out.println("workingdir: "+new java.io.File("").getAbsolutePath());
		
		aliases.put("/*", new java.io.File("src/main/webapp"));
		srv.setMappingTable(aliases);

		// set port
		java.util.Properties properties = new java.util.Properties();
		properties.put("port", port);
		properties.setProperty(Acme.Serve.Serve.ARG_NOHUP, "nohup");
		srv.arguments = properties;

		// add FrontController as the only servlet
		String variant = new UsedMolgenisOptions().appName;
		srv.addServlet("/"+variant + "/", new app.servlet.FrontController());

		// add shutdown hooks
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				try {
					srv.notifyStop();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				srv.destroyAllServlets();
			}
		}));

		// run server in new thread
		(new Thread() {
			public void run() {
				try {
					srv.serve();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

		// display app location
		System.out
				.println("*********************************************************");
		System.out.println("APPLICATION IS RUNNING AT: http://localhost:"
				+ port + "/" + variant + "/");
		System.out
				.println("*********************************************************");

	}

	public static void main(String[] args) throws IOException {
		int port;
		if (args.length == 0) {
			// check if the default 8080 port is free, if not, try the next 100
			port = getAvailablePort(8080, 100);
			new RunObserv(port);
		} else if (args.length == 1) {
			// run the app the selected port, and on this port only
			port = Integer.valueOf(args[0]);

			// if not available, throw error
			if (!isAvailable(port)) {
				throw new IOException("Port " + port + " already in use!");
			}
			new RunObserv(port);
		} else {
			throw new IOException(
					"Use either no arguments to select the default port (plus portscan if it is unavailable), or 1 argument as the port. (no further portscan)");
		}
	}

	public static boolean isAvailable(int port) throws IOException {
		ServerSocket socket = null;
		try {
			socket = new ServerSocket(port);
		} catch (IOException e) {
			return false;
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
		return true;
	}

	/**
	 * Return the initial port number if it was available. Otherwise, increase
	 * with 1 over a given range until a free port was found. If none are found,
	 * throws IOException.
	 * 
	 * @param initialPort
	 * @param range
	 * @return
	 * @throws IOException
	 */
	public static int getAvailablePort(int initialPort, int range)
			throws IOException {
		for (int port = initialPort; port < (initialPort + range); port++) {
			boolean portTaken = false;
			ServerSocket socket = null;
			try {
				socket = new ServerSocket(port);
			} catch (IOException e) {
				portTaken = true;
			} finally {
				if (socket != null) {
					socket.close();
				}
			}
			if (!portTaken) {
				return port;
			}
		}
		throw new IOException(
				"All ports in the range "
						+ initialPort
						+ "-"
						+ (initialPort + range)
						+ " were unavailable. Select a different initial port or increase the scanning range.");
	}

}