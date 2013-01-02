package org.molgenis.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "form")
public class FormModel
{
	EntityModel entityModel;
	
	@XmlAttribute
	String name;
	
	@XmlAttribute
	String hide_fields;
	
	@XmlAttribute
	Boolean readonly = false;


	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getHideFields()
	{
		return hide_fields;
	}

	public void setHideFields(String hide_fields)
	{
		this.hide_fields = hide_fields;
	}

	public Boolean getReadonly()
	{
		return readonly;
	}

	public void setReadonly(Boolean readonly)
	{
		this.readonly = readonly;
	}

	public EntityModel getEntity()
	{
		return entityModel;
	}

	public void setEntityModel(EntityModel entityModel)
	{
		this.entityModel = entityModel;
	}

	public List<String> getHideFieldsNames()
	{
		throw new RuntimeException("TODO");
	}

}
