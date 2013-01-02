package org.molgenis.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

@XmlAccessorType(XmlAccessType.FIELD)
public class UiModel
{
	@XmlElements( { //
	    @XmlElement(name = "menu", type = MenuModel.class),
	        @XmlElement(name = "form", type = FormModel.class), 
	        @XmlElement(name = "plugin", type = PluginModel.class),        
	    })
	List<UiModel> screens;
	
	@XmlAttribute
	String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	
}
