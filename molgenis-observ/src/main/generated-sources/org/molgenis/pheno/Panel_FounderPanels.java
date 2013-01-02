
/* File:        observ/model/Panel_FounderPanels.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.pheno;

/**
 * Panel_FounderPanels: Link table for many-to-many relationship 'Panel.FounderPanels'..
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.pheno.db.Panel_FounderPanelsEntityListener.class})
public class Panel_FounderPanels extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String AUTOID = "autoid";
	public final static String FOUNDERPANELS = "FounderPanels";
	public final static String FOUNDERPANELS_NAME = "FounderPanels_name";
	public final static String PANEL = "Panel";
	public final static String PANEL_NAME = "Panel_name";
	
	//static methods
	/**
	 * Shorthand for db.query(Panel_FounderPanels.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Panel_FounderPanels> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Panel_FounderPanels.class);
	}
	
	/**
	 * Shorthand for db.find(Panel_FounderPanels.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Panel_FounderPanels> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Panel_FounderPanels.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Panel_FounderPanels findByAutoid(org.molgenis.framework.db.Database db, Integer autoid) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Panel_FounderPanels> q = db.query(Panel_FounderPanels.class);
		q.eq(Panel_FounderPanels.AUTOID, autoid);
		java.util.List<Panel_FounderPanels> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Panel_FounderPanels findByFounderPanelsPanel(org.molgenis.framework.db.Database db, Integer founderPanels, Integer panel) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Panel_FounderPanels> q = db.query(Panel_FounderPanels.class);
		q.eq(Panel_FounderPanels.FOUNDERPANELS, founderPanels);q.eq(Panel_FounderPanels.PANEL, panel);
		java.util.List<Panel_FounderPanels> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatic id field to ensure ordering of mrefs[type=int]
    @javax.persistence.Id @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Column(name="autoid", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="autoid")
	
	//@javax.validation.constraints.NotNull
	private Integer autoid =  null;


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="FounderPanels", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.pheno.Panel founderPanels = null;
	@javax.persistence.Transient
	private Integer founderPanels_id = null;	
	@javax.persistence.Transient
	private String founderPanels_name = null;						


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Panel", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.pheno.Panel panel = null;
	@javax.persistence.Transient
	private Integer panel_id = null;	
	@javax.persistence.Transient
	private String panel_name = null;						

	//constructors
	public Panel_FounderPanels()
	{
	
	}
	
	//getters and setters
	/**
	 * Get the automatic id field to ensure ordering of mrefs.
	 * @return autoid.
	 */
	public Integer getAutoid()
	{
		return this.autoid;
	}
	
	
	/**
	 * Set the automatic id field to ensure ordering of mrefs.
	 * @param autoid
	 */
	public void setAutoid( Integer autoid)
	{
		this.autoid = autoid;
	}

	

	/**
	 * Get the .
	 * @return founderPanels.
	 */
	public org.molgenis.pheno.Panel getFounderPanels()
	{
		return this.founderPanels;
	}
	
	@Deprecated
	public org.molgenis.pheno.Panel getFounderPanels(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param founderPanels
	 */
	public void setFounderPanels( org.molgenis.pheno.Panel founderPanels)
	{
		
		this.founderPanels = founderPanels;
	}

	
	
	/**
	 * Set foreign key for field founderPanels.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setFounderPanels_Id(Integer founderPanels_id)
	{
		this.founderPanels_id = founderPanels_id;
	}	

	public void setFounderPanels(Integer founderPanels_id)
	{
		this.founderPanels_id = founderPanels_id;
	}
	
	public Integer getFounderPanels_Id()
	{
		
		if(founderPanels != null) 
		{
			return founderPanels.getId();
		}
		else
		{
			return founderPanels_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference FounderPanels to Panel.Id.
	 */
	public String getFounderPanels_Name()
	{		
		//FIXME should we auto-load based on getFounderPanels()?	
		if(founderPanels != null) {
			return founderPanels.getName();
		} else {
			return founderPanels_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference FounderPanels to <a href="Panel.html#Id">Panel.Id</a>.
	 * Implies setFounderPanels(null) until save
	 */
	public void setFounderPanels_Name(String founderPanels_name)
	{
		this.founderPanels_name = founderPanels_name;
	}		
	 
	

	/**
	 * Get the .
	 * @return panel.
	 */
	public org.molgenis.pheno.Panel getPanel()
	{
		return this.panel;
	}
	
	@Deprecated
	public org.molgenis.pheno.Panel getPanel(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param panel
	 */
	public void setPanel( org.molgenis.pheno.Panel panel)
	{
		
		this.panel = panel;
	}

	
	
	/**
	 * Set foreign key for field panel.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setPanel_Id(Integer panel_id)
	{
		this.panel_id = panel_id;
	}	

	public void setPanel(Integer panel_id)
	{
		this.panel_id = panel_id;
	}
	
	public Integer getPanel_Id()
	{
		
		if(panel != null) 
		{
			return panel.getId();
		}
		else
		{
			return panel_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Panel to Panel.Id.
	 */
	public String getPanel_Name()
	{		
		//FIXME should we auto-load based on getPanel()?	
		if(panel != null) {
			return panel.getName();
		} else {
			return panel_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Panel to <a href="Panel.html#Id">Panel.Id</a>.
	 * Implies setPanel(null) until save
	 */
	public void setPanel_Name(String panel_name)
	{
		this.panel_name = panel_name;
	}		
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("autoid"))
			return getAutoid();
		if (name.toLowerCase().equals("founderpanels"))
			return getFounderPanels();
		if(name.toLowerCase().equals("founderpanels_id"))
			return getFounderPanels_Id();
		if(name.toLowerCase().equals("founderpanels_name"))
			return getFounderPanels_Name();
		if (name.toLowerCase().equals("panel"))
			return getPanel();
		if(name.toLowerCase().equals("panel_id"))
			return getPanel_Id();
		if(name.toLowerCase().equals("panel_name"))
			return getPanel_Name();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getAutoid() == null) throw new org.molgenis.framework.db.DatabaseException("required field autoid is null");
		if(this.getFounderPanels() == null) throw new org.molgenis.framework.db.DatabaseException("required field founderPanels is null");
		if(this.getPanel() == null) throw new org.molgenis.framework.db.DatabaseException("required field panel is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Autoid
			this.setAutoid(tuple.getInt("autoid"));
			//set FounderPanels
			this.setFounderPanels(tuple.getInt("FounderPanels"));
			//set label name for xref field FounderPanels
			this.setFounderPanels_Name(tuple.getString("FounderPanels_name"));	
			//set Panel
			this.setPanel(tuple.getInt("Panel"));
			//set label name for xref field Panel
			this.setPanel_Name(tuple.getString("Panel_name"));	
		}
		else if(tuple != null)
		{
			//set Autoid
			if( strict || tuple.getInt("autoid") != null) this.setAutoid(tuple.getInt("autoid"));
			if( tuple.getInt("Panel_FounderPanels_autoid") != null) this.setAutoid(tuple.getInt("Panel_FounderPanels_autoid"));
			//set FounderPanels
			if( strict || tuple.getInt("FounderPanels_id") != null) this.setFounderPanels(tuple.getInt("FounderPanels_id"));
			if( tuple.getInt("Panel_FounderPanels_FounderPanels_id") != null) this.setFounderPanels(tuple.getInt("Panel_FounderPanels_FounderPanels_id"));
			//alias of xref
			if( tuple.getObject("FounderPanels") != null) this.setFounderPanels(tuple.getInt("FounderPanels"));
			if( tuple.getObject("Panel_FounderPanels_FounderPanels") != null) this.setFounderPanels(tuple.getInt("Panel_FounderPanels_FounderPanels"));
			//set label for field FounderPanels
			if( strict || tuple.getObject("FounderPanels_name") != null) this.setFounderPanels_Name(tuple.getString("FounderPanels_name"));			
			if( tuple.getObject("Panel_FounderPanels_FounderPanels_name") != null ) this.setFounderPanels_Name(tuple.getString("Panel_FounderPanels_FounderPanels_name"));		
			//set Panel
			if( strict || tuple.getInt("Panel_id") != null) this.setPanel(tuple.getInt("Panel_id"));
			if( tuple.getInt("Panel_FounderPanels_Panel_id") != null) this.setPanel(tuple.getInt("Panel_FounderPanels_Panel_id"));
			//alias of xref
			if( tuple.getObject("Panel") != null) this.setPanel(tuple.getInt("Panel"));
			if( tuple.getObject("Panel_FounderPanels_Panel") != null) this.setPanel(tuple.getInt("Panel_FounderPanels_Panel"));
			//set label for field Panel
			if( strict || tuple.getObject("Panel_name") != null) this.setPanel_Name(tuple.getString("Panel_name"));			
			if( tuple.getObject("Panel_FounderPanels_Panel_name") != null ) this.setPanel_Name(tuple.getString("Panel_FounderPanels_Panel_name"));		
		}
		//org.apache.log4j.Logger.getLogger("test").debug("set "+this);
	}
	
	
	
	

	@Override
	public String toString()
	{
		return this.toString(false);
	}
	
	public String toString(boolean verbose)
	{
		String result = "Panel_FounderPanels(";
		result+= "autoid='" + getAutoid()+"' ";	
		result+= " founderPanels_id='" + getFounderPanels_Id()+"' ";	
		result+= " founderPanels_name='" + getFounderPanels_Name()+"' ";
		result+= " panel_id='" + getPanel_Id()+"' ";	
		result+= " panel_name='" + getPanel_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Panel_FounderPanels.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("autoid");
		}
		{
			fields.add("founderPanels_id");
		}
		fields.add("founderPanels_name");
		{
			fields.add("panel_id");
		}
		fields.add("panel_name");
		return fields;
	}	

	public java.util.Vector<String> getFields()
	{
		return getFields(false);
	}

	@Override
	public String getIdField()
	{
		return "autoid";
	}
	

	
	@Override
	public java.util.List<String> getLabelFields()
	{
		java.util.List<String> result = new java.util.ArrayList<String>();
		result.add("FounderPanels");
		result.add("Panel");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "autoid" +sep
		+ "founderPanels" +sep
		+ "panel" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("founderPanels")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("panel")) {
            return "id";
        }
        
        return null;
    }	

	@Override
	public boolean equals(Object obj) {
   		if (obj == null) { return false; }
   		if (obj == this) { return true; }
   		if (obj.getClass() != getClass()) {
     		return false;
   		}
		Panel_FounderPanels rhs = (Panel_FounderPanels) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//founderPanels
		//panel
                .isEquals();
  	}

  	@Override
    public int hashCode() {
    	int firstNumber = this.getClass().getName().hashCode();
    	int secondNumber = this.getClass().getSimpleName().hashCode();
    	if(firstNumber % 2 == 0) {
    	  firstNumber += 1;
    	}
    	if(secondNumber % 2 == 0) {
    		secondNumber += 1;
    	}
    
		return new org.apache.commons.lang.builder.HashCodeBuilder(firstNumber, secondNumber)
   			.toHashCode();
    }  	
  	


	@Deprecated
	public String getValues(String sep)
	{
		java.io.StringWriter out = new java.io.StringWriter();
		{
			Object valueO = getAutoid();
			String valueS;
			if (valueO != null)
				valueS = valueO.toString();
			else 
				valueS = "";
			valueS = valueS.replaceAll("\r\n"," ").replaceAll("\n"," ").replaceAll("\r"," ");
			valueS = valueS.replaceAll("\t"," ").replaceAll(sep," ");
			out.write(valueS+sep);
		}
		{
			Object valueO = getFounderPanels();
			String valueS;
			if (valueO != null)
				valueS = valueO.toString();
			else 
				valueS = "";
			valueS = valueS.replaceAll("\r\n"," ").replaceAll("\n"," ").replaceAll("\r"," ");
			valueS = valueS.replaceAll("\t"," ").replaceAll(sep," ");
			out.write(valueS+sep);
		}
		{
			Object valueO = getPanel();
			String valueS;
			if (valueO != null)
				valueS = valueO.toString();
			else 
				valueS = "";
			valueS = valueS.replaceAll("\r\n"," ").replaceAll("\n"," ").replaceAll("\r"," ");
			valueS = valueS.replaceAll("\t"," ").replaceAll(sep," ");
			out.write(valueS);
		}
		return out.toString();
	}
	
	@Override
	public Panel_FounderPanels create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Panel_FounderPanels e = new Panel_FounderPanels();
		e.set(tuple);
		return e;
	}
	

	
}

