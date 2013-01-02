package org.molgenis.ui.widgets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.molgenis.db.Tuple;
import org.molgenis.ui.view.AbstractView;

/**
 * MolgenisView is superclass for building user interfaces as if were a tree.
 * You can use add(GuiElement) to add child elements. Subclasses may limit the
 * types of GuiElement it accepts.
 * 
 * Optionally, components may specify headers. These are merged by the page
 * before rendering.
 */
public abstract class GuiElement<T extends GuiElement<T>> extends AbstractView
{
	public static final String ID = "id";
	public static final String CLASS = "class";
	public static int idCounter = 1;

	/** The id of current element */
	private String id;

	/** The css class of this input. */
	// private String clazz;

	/** Css/javascript headers */
	private Set<HtmlHeader> allHeaders = new LinkedHashSet<HtmlHeader>();

	/** map of tree elements (ordered) */
	protected Map<String, GuiElement<?>> allChildren = new LinkedHashMap<String, GuiElement<?>>();

	/** parent.id (or null if root element) */
	protected String parentId;

	/** Constructor using id only */
	public GuiElement(String id)
	{
		this.id = id;
		this.allChildren.put(id, this);
	}

	public void set(Tuple params) throws HtmlInputException
	{
		this.setId(params.getString(ID));
		// this.setClazz(params.getString(CLASS));
	}

	// PROPERTIES
	public String getId()
	{
		return this.id;
	}

	@SuppressWarnings("unchecked")
	protected T setId(String id)
	{
		this.id = id;
		return (T) this;
	}

	//
	// public String getClazz()
	// {
	// return this.clazz;
	// }
	//
	// @SuppressWarnings("unchecked")
	// public T setClazz(String clazz)
	// {
	// this.clazz = clazz;
	// return (T) this;
	// }

	public GuiElement<?> get(String name)
	{
		return allChildren.get(name);
	}

	@SuppressWarnings("unchecked")
	public T add(GuiElement<?>... elements)
	{
		for (GuiElement<?> element : elements)
		{
			// check if id exists
			if (this.allChildren.containsKey(element.getId()))
			{
				throw new RuntimeException("Cannot add " + element.getClass().getSimpleName() + "(id=" + element.getId() + "): id is already in use");
			}

			this.allChildren.put(element.getId(), element);
			element.parentId = this.getId();

			// if the element has children, then allChildren should be merged
			this.allChildren.putAll(element.allChildren);
			for (GuiElement<?> child : this.allChildren.values())
			{
				child.allChildren = this.allChildren;
			}

			// if the element has headers, merge
			this.allHeaders.addAll(element.allHeaders);
			for (GuiElement<?> child : this.allChildren.values())
			{
				child.allHeaders = this.allHeaders;
			}
		}

		return (T) this;
	}

	public List<GuiElement<?>> getChildren()
	{
		Vector<GuiElement<?>> children = new Vector<GuiElement<?>>();
		for (GuiElement<?> sc : allChildren.values())
		{
			if (sc.getParent() != null && sc.getParent() == this)
			{
				children.add(sc);
			}
		}
		return children;
	}

	public final GuiElement<?> getParent()
	{
		if (parentId != null) return allChildren.get(parentId);
		else
			return null;
	}

	public final GuiElement<?> getChild(String name)
	{
		GuiElement<?> child = allChildren.get(name);

		if (child != null && child.getParent().equals(this))
		{
			return child;
		}
		else
		{
			return null;
		}
	}

	/** This method is used if users don't want to specify ids themselves */
	public static String randomId()
	{
		return "molgenis_ui_" + (idCounter++);
	}

	public String toString()
	{
		return this.getClass().getSimpleName() + "(" + this.getId() + ", parentId=" + this.parentId + ")";
	}

	public Set<HtmlHeader> getHtmlHeaders()
	{
		return this.allHeaders;
	}

	public GuiElement<T> add(HtmlHeader header)
	{
		this.allHeaders.add(header);

		return this;
	}

	public abstract void render(PrintWriter out) throws IOException;
}
