package org.molgenis.ui.widgets;

public class Danger extends Alert<Danger>
{
	public Danger(String message)
	{
		super(message, Type.ERROR);
	}
}
