package org.molgenis.ui.widgets;

import java.util.UUID;

import org.apache.commons.lang.StringEscapeUtils;
import org.molgenis.db.Tuple;
import org.molgenis.ui.render.RenderDecorator;

/**
 * An HtmlInput allows a user to enter data. Thus, HtmlInput is the base-class
 * for html inputs, such as button, textareas, calendars.
 * 
 * 
 */
public abstract class HtmlInput<T extends FormElement<T>, E> extends FormElement<T>
{
	/** String constants for property name 'value' */
	public static final String VALUE = "value";

	/** String constants for property name 'nillable' */
	public static final String NILLABLE = "nillable";

	/** String constants for property name 'readonly' */
	public static final String READONLY = "readonly";

	/** String constants for property name 'description' */
	public static final String DESCRIPTION = "decription";

	/** String constants for property name 'hidden' */
	public static final String HIDDEN = "hidden";

	// PROPERTIES

	/** The value of the input */
	private E value;

	/** Flag indicating whether this input is readonly ( default: false) */
	private boolean readonly;

	/** Flag indicating whether this input is hidden ( default: false ) */
	protected boolean hidden;

	/** indicate if this is required form field */
	private boolean nillable = false;
	
	/** placeholder */
	private String placeholder = "";

	/** indicate if this input should be hidden in 'compact' view */
	private boolean collapse = false;

	/** String with a one-line description of the input ( optional ) */
	private String tooltip;

	/** variable to validate size */
	private Integer size;

	/** Description. Defaults to 'name'. */
	private String description = "";

	protected RenderDecorator renderDecorator = HtmlSettings.defaultRenderDecorator;

	/**
	 * Standard constructor, which sets the name and value of the input
	 * 
	 * @param name
	 *            The name of the html-input.
	 * @param value
	 *            The value of the html-input.
	 */
	public HtmlInput(String name)
	{
		super(name);

		if (name == null) name = UUID.randomUUID().toString().replace("-", "");
		this.setId(name.replace(" ", ""));
		this.setName(name.replace(" ", ""));
	}

	@SuppressWarnings("unchecked")
	@Override
	public void set(Tuple t) throws HtmlInputException
	{
		this.setId(t.getString(ID));
		this.name = t.getString(NAME);
		// this.label = t.getString(LABEL);
		this.value = (E) t.getObject(VALUE);
		if (t.getBool(NILLABLE) != null) this.nillable = t.getBool(NILLABLE);
		if (t.getBool(READONLY) != null) this.readonly = t.getBool(READONLY);
		this.description = t.getString(DESCRIPTION);
		if (t.getBool(HIDDEN) != null) this.hidden = t.getBool(HIDDEN);
	}

	/** No arguments constructor. Use with caution */
	protected HtmlInput()
	{
		this(randomId());
	}

	// TODO: This *needs* to be renamed to getValue()
	public E getObject()
	{
		return value;
	}

	public String getObjectString()
	{
		if (this.value == null) return "";
		else
			return value.toString();
	}

	// TODO: This *needs* to be renamed to getValueToString() or removed!!!
	public String getValue()
	{
		return getValue(false);
	}

	/**
	 * Get the value of the input as a String, optionally replacing special
	 * characters like \\n and &gt;
	 * 
	 * @param replaceSpecialChars
	 * @return
	 */
	public String getValue(boolean replaceSpecialChars)
	{
		if (getObject() == null)
		{
			return "";
		}

		// todo: why different from getHtmlValue()??
		// if (replaceSpechialChars)
		// {
		// return
		// this.renderDecorator.render(getObject().toString().replace("\n",
		// "<br>")
		// .replace("\r", "").replace(">", "&gt;")
		// .replace("<", "&lt;"));
		// }
		// else
		// {
		return getObject().toString();
		// }
	}

	public String getHtmlValue(int maxLength)
	{
		// we render all tags, but we stop rendering text outside tags after
		// maxLength
		String result = "";
		boolean inTag = false;
		int count = 0;
		for (char c : this.getHtmlValue().toCharArray())
		{
			// check if we go into tag
			if ('<' == c)
			{
				inTag = true;

			}

			if (inTag || count < maxLength)
			{
				result += c;
			}

			if ('>' == c)
			{
				inTag = false;
			}

			if (!inTag) count++;
		}

		return result;
	}

	public String getHtmlValue()
	{
		String value = null;
		value = this.getValue();
		// .replace("\n", "<br>").replace("\r", "")
		// .replace(">", "&gt;").replace("<", "&lt;");
		return this.renderDecorator.render(value);
	}

	public String getJavaScriptValue()
	{
		String value = StringEscapeUtils.escapeXml(StringEscapeUtils.escapeJavaScript(this.getValue()));
		return value;
	}

	// BORING PROPERTIES
	@SuppressWarnings("unchecked")
	public T value(E value)
	{
		this.value = value;
		return (T) this;
	}

	public boolean isReadonly()
	{
		return readonly;
	}

	public FormElement<T> setReadonly(boolean readonly)
	{
		this.readonly = readonly;
		return this;
	}

	public boolean isHidden()
	{
		return hidden;
	}

	public FormElement<T> setHidden(boolean hidden)
	{
		this.hidden = hidden;
		return this;
	}

	public String getTooltip()
	{
		return tooltip;
	}

	@SuppressWarnings("unchecked")
	public T setTooltip(String tooltip)
	{
		this.tooltip = tooltip;
		return (T) this;
	}

	public String getDescription()
	{
		return description;
	}

	@SuppressWarnings("unchecked")
	public T setDescription(String description)
	{
		this.description = description;
		return (T) this;
	}

	public boolean isNillable()
	{
		return nillable;
	}

	public FormElement<T> nillable(boolean required)
	{
		this.nillable = required;
		return this;
	}

	public boolean isCollapse()
	{
		return collapse;
	}

	public void setCollapse(boolean collapse)
	{
		this.collapse = collapse;
	}

	public synchronized Integer getSize()
	{
		return size;
	}

	public synchronized FormElement<T> setSize(Integer size)
	{
		this.size = size;
		return this;
	}

	public String getPlaceholder()
	{
		return placeholder;
	}

	public FormElement<T> placeholder(String placeholder)
	{
		this.placeholder = placeholder;
		return this;
	}
}