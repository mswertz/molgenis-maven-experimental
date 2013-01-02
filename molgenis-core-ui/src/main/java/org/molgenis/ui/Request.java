package org.molgenis.ui;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.molgenis.db.common.SimpleTuple;

public class Request extends SimpleTuple
{
	private String servicePath; // e.g. "/api/R/"
	private String requestPath; // e.g. "/api/R/source.R"
	private String appLocation; // e.g. "http://localhost:8080/xqtl"

	// counter for the amount of files in the request
	private int fileCtr = 0;
	private String previousFieldName = "";

	/** errors are logged. */
	private static final transient Logger logger = Logger.getLogger(Request.class.getSimpleName());

	public Request(HttpServletRequest request) throws Exception
	{
		if (ServletFileUpload.isMultipartContent(request))
		{
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			logger.info("Current upload max size: " + upload.getSizeMax());
			upload.setSizeMax(Long.MAX_VALUE);
			try
			{
				List<?> multipart = upload.parseRequest(request);

				int i;
				FileItem item;
				// get the separate elements
				for (i = 0; i < multipart.size(); i++)
				{
					item = (FileItem) multipart.get(i);

					if (item.isFormField())
					{
						getFormFieldValues(multipart, i, item);
					}
					else
					// is a file
					{
						getAttachedFileValues(item);
					}
				}
			}
			catch (Exception e)
			{
				logger.error(e);
				throw e;
			}
		}
		else
		{
			for (Object key : request.getParameterMap().keySet())
			{
				this.set((String) key, request.getParameter((String) key));
			}
			logger.debug("Converted HTTP get/non-multipart request into Tuple:" + this.toString());
		}
	}

	private void getAttachedFileValues(FileItem item) throws IOException, Exception
	{
		// http://jakarta.apache.org/commons/fileupload/using.html
		if (item.getSize() != 0)
		{
			// copy the file to a tempfile
			String filename = item.getName();
			String fileNumber;

			// handle multiple files in a filefield and multiple filefields in a
			// form
			if (item.getFieldName().equals(this.previousFieldName))
			{
				// increase the filecounter
				this.fileCtr++;
				fileNumber = Integer.toString(this.fileCtr);

			}
			else
			{

				// for backwards compatibility reasons there should not be a
				// filenumber added in the string if there is only 1 file.
				fileNumber = "";

				// reset the file counter in case there is more then one file
				// field in the form
				this.fileCtr = 0;

			}
			this.previousFieldName = item.getFieldName();

			// copy the file to a tempfile
			String extension = "text"; // default extension
			if (filename.lastIndexOf('.') > 0)
			{
				extension = filename.substring(filename.lastIndexOf('.'));
			}

			File uploadedFile = File.createTempFile("molgenis", extension);
			item.write(uploadedFile);

			// add the file to the tuple
			this.set(item.getFieldName() + fileNumber, uploadedFile);

			// also add the original filename
			this.set(item.getFieldName() + fileNumber + "OriginalFileName", filename);
		}
	}

	private void getFormFieldValues(List<?> multipart, int i, FileItem item)
	{
		// try to find if there are more of this name
		String name = item.getFieldName();
		Vector<String> elements = new Vector<String>();

		elements.add(item.getString());
		for (int j = i + 1; j < multipart.size(); j++)
		{
			FileItem item2 = (FileItem) multipart.get(j);
			if (item2.getFieldName().equals(name))
			{
				elements.add(item2.getString());
				multipart.remove(j--);
			}
		}

		if (elements.size() == 1)
		{
			if (item.getString().equals("")) this.set(item.getFieldName(), null);
			else
				this.set(item.getFieldName(), item.getString());
		}
		else
		{
			// strip out null values
			for (int j = 0; j < elements.size(); j++)
			{
				if (elements.get(j) == null || elements.get(j).equals("")) elements.remove(j);
			}
			this.set(item.getFieldName(), elements);
		}
	}

	public String getServicePath()
	{
		return servicePath;
	}

	protected void setServicePath(String servicePath)
	{
		this.servicePath = servicePath;
	}

	public String getRequestPath()
	{
		return requestPath;
	}

	protected void setRequestPath(String requestPath)
	{
		this.requestPath = requestPath;
	}

	public String getAppLocation()
	{
		return appLocation;
	}

	protected void setAppLocation(String appLocation)
	{
		this.appLocation = appLocation;
	}
}
