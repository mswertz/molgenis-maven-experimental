package org.molgenis.ui.view;

/** DownloadView is a View where you can set the contentType yourself.*/
public abstract class DownloadView extends AbstractView
{	
	@Override
	public void setContentType(String contentType)
	{
		super.setContentType(contentType);
	}
	
	@Override
	public void setContentLength(int contentLength)
	{
		super.setContentLength(contentLength);
	}
}
