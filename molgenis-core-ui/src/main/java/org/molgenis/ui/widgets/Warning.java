package org.molgenis.ui.widgets;

public class Warning extends Alert<Warning>
{
	public Warning(String message)
	{
		super(message, Type.WARNING);
	}
}
