package org.molgenis.ui.widgets;


/**
 * Input for email values
 */
public class EmailInput extends ValidatingInput<EmailInput, String>
{
	public EmailInput(String name)
	{
		super(name, "email");
	}
}
