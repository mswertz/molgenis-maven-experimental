
/* File:        observ/model/ProtocolApplication_Performer.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.protocol;

/**
 * ProtocolApplication_Performer: Link table for many-to-many relationship 'ProtocolApplication.Performer'..
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.protocol.db.ProtocolApplication_PerformerEntityListener.class})
public class ProtocolApplication_Performer extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String AUTOID = "autoid";
	public final static String PERFORMER = "Performer";
	public final static String PERFORMER_NAME = "Performer_name";
	public final static String PROTOCOLAPPLICATION = "ProtocolApplication";
	public final static String PROTOCOLAPPLICATION_NAME = "ProtocolApplication_name";
	
	//static methods
	/**
	 * Shorthand for db.query(ProtocolApplication_Performer.class).
	 */
	public static org.molgenis.framework.db.Query<? extends ProtocolApplication_Performer> query(org.molgenis.framework.db.Database db)
	{
		return db.query(ProtocolApplication_Performer.class);
	}
	
	/**
	 * Shorthand for db.find(ProtocolApplication_Performer.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends ProtocolApplication_Performer> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(ProtocolApplication_Performer.class, rules);
	}	
	
	/**
	 * 
	 */
	public static ProtocolApplication_Performer findByAutoid(org.molgenis.framework.db.Database db, Integer autoid) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ProtocolApplication_Performer> q = db.query(ProtocolApplication_Performer.class);
		q.eq(ProtocolApplication_Performer.AUTOID, autoid);
		java.util.List<ProtocolApplication_Performer> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static ProtocolApplication_Performer findByPerformerProtocolApplication(org.molgenis.framework.db.Database db, Integer performer, Integer protocolApplication) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ProtocolApplication_Performer> q = db.query(ProtocolApplication_Performer.class);
		q.eq(ProtocolApplication_Performer.PERFORMER, performer);q.eq(ProtocolApplication_Performer.PROTOCOLAPPLICATION, protocolApplication);
		java.util.List<ProtocolApplication_Performer> result = q.find();
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
    @javax.persistence.JoinColumn(name="Performer", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.auth.Person performer = null;
	@javax.persistence.Transient
	private Integer performer_id = null;	
	@javax.persistence.Transient
	private String performer_name = null;						


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="ProtocolApplication", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.protocol.ProtocolApplication protocolApplication = null;
	@javax.persistence.Transient
	private Integer protocolApplication_id = null;	
	@javax.persistence.Transient
	private String protocolApplication_name = null;						

	//constructors
	public ProtocolApplication_Performer()
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
	 * @return performer.
	 */
	public org.molgenis.auth.Person getPerformer()
	{
		return this.performer;
	}
	
	@Deprecated
	public org.molgenis.auth.Person getPerformer(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param performer
	 */
	public void setPerformer( org.molgenis.auth.Person performer)
	{
		
		this.performer = performer;
	}

	
	
	/**
	 * Set foreign key for field performer.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setPerformer_Id(Integer performer_id)
	{
		this.performer_id = performer_id;
	}	

	public void setPerformer(Integer performer_id)
	{
		this.performer_id = performer_id;
	}
	
	public Integer getPerformer_Id()
	{
		
		if(performer != null) 
		{
			return performer.getId();
		}
		else
		{
			return performer_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Performer to Person.Id.
	 */
	public String getPerformer_Name()
	{		
		//FIXME should we auto-load based on getPerformer()?	
		if(performer != null) {
			return performer.getName();
		} else {
			return performer_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Performer to <a href="Person.html#Id">Person.Id</a>.
	 * Implies setPerformer(null) until save
	 */
	public void setPerformer_Name(String performer_name)
	{
		this.performer_name = performer_name;
	}		
	 
	

	/**
	 * Get the .
	 * @return protocolApplication.
	 */
	public org.molgenis.protocol.ProtocolApplication getProtocolApplication()
	{
		return this.protocolApplication;
	}
	
	@Deprecated
	public org.molgenis.protocol.ProtocolApplication getProtocolApplication(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param protocolApplication
	 */
	public void setProtocolApplication( org.molgenis.protocol.ProtocolApplication protocolApplication)
	{
		
		this.protocolApplication = protocolApplication;
	}

	
	
	/**
	 * Set foreign key for field protocolApplication.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setProtocolApplication_Id(Integer protocolApplication_id)
	{
		this.protocolApplication_id = protocolApplication_id;
	}	

	public void setProtocolApplication(Integer protocolApplication_id)
	{
		this.protocolApplication_id = protocolApplication_id;
	}
	
	public Integer getProtocolApplication_Id()
	{
		
		if(protocolApplication != null) 
		{
			return protocolApplication.getId();
		}
		else
		{
			return protocolApplication_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference ProtocolApplication to ProtocolApplication.Id.
	 */
	public String getProtocolApplication_Name()
	{		
		//FIXME should we auto-load based on getProtocolApplication()?	
		if(protocolApplication != null) {
			return protocolApplication.getName();
		} else {
			return protocolApplication_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference ProtocolApplication to <a href="ProtocolApplication.html#Id">ProtocolApplication.Id</a>.
	 * Implies setProtocolApplication(null) until save
	 */
	public void setProtocolApplication_Name(String protocolApplication_name)
	{
		this.protocolApplication_name = protocolApplication_name;
	}		
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("autoid"))
			return getAutoid();
		if (name.toLowerCase().equals("performer"))
			return getPerformer();
		if(name.toLowerCase().equals("performer_id"))
			return getPerformer_Id();
		if(name.toLowerCase().equals("performer_name"))
			return getPerformer_Name();
		if (name.toLowerCase().equals("protocolapplication"))
			return getProtocolApplication();
		if(name.toLowerCase().equals("protocolapplication_id"))
			return getProtocolApplication_Id();
		if(name.toLowerCase().equals("protocolapplication_name"))
			return getProtocolApplication_Name();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getAutoid() == null) throw new org.molgenis.framework.db.DatabaseException("required field autoid is null");
		if(this.getPerformer() == null) throw new org.molgenis.framework.db.DatabaseException("required field performer is null");
		if(this.getProtocolApplication() == null) throw new org.molgenis.framework.db.DatabaseException("required field protocolApplication is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Autoid
			this.setAutoid(tuple.getInt("autoid"));
			//set Performer
			this.setPerformer(tuple.getInt("Performer"));
			//set label name for xref field Performer
			this.setPerformer_Name(tuple.getString("Performer_name"));	
			//set ProtocolApplication
			this.setProtocolApplication(tuple.getInt("ProtocolApplication"));
			//set label name for xref field ProtocolApplication
			this.setProtocolApplication_Name(tuple.getString("ProtocolApplication_name"));	
		}
		else if(tuple != null)
		{
			//set Autoid
			if( strict || tuple.getInt("autoid") != null) this.setAutoid(tuple.getInt("autoid"));
			if( tuple.getInt("ProtocolApplication_Performer_autoid") != null) this.setAutoid(tuple.getInt("ProtocolApplication_Performer_autoid"));
			//set Performer
			if( strict || tuple.getInt("Performer_id") != null) this.setPerformer(tuple.getInt("Performer_id"));
			if( tuple.getInt("ProtocolApplication_Performer_Performer_id") != null) this.setPerformer(tuple.getInt("ProtocolApplication_Performer_Performer_id"));
			//alias of xref
			if( tuple.getObject("Performer") != null) this.setPerformer(tuple.getInt("Performer"));
			if( tuple.getObject("ProtocolApplication_Performer_Performer") != null) this.setPerformer(tuple.getInt("ProtocolApplication_Performer_Performer"));
			//set label for field Performer
			if( strict || tuple.getObject("Performer_name") != null) this.setPerformer_Name(tuple.getString("Performer_name"));			
			if( tuple.getObject("ProtocolApplication_Performer_Performer_name") != null ) this.setPerformer_Name(tuple.getString("ProtocolApplication_Performer_Performer_name"));		
			//set ProtocolApplication
			if( strict || tuple.getInt("ProtocolApplication_id") != null) this.setProtocolApplication(tuple.getInt("ProtocolApplication_id"));
			if( tuple.getInt("ProtocolApplication_Performer_ProtocolApplication_id") != null) this.setProtocolApplication(tuple.getInt("ProtocolApplication_Performer_ProtocolApplication_id"));
			//alias of xref
			if( tuple.getObject("ProtocolApplication") != null) this.setProtocolApplication(tuple.getInt("ProtocolApplication"));
			if( tuple.getObject("ProtocolApplication_Performer_ProtocolApplication") != null) this.setProtocolApplication(tuple.getInt("ProtocolApplication_Performer_ProtocolApplication"));
			//set label for field ProtocolApplication
			if( strict || tuple.getObject("ProtocolApplication_name") != null) this.setProtocolApplication_Name(tuple.getString("ProtocolApplication_name"));			
			if( tuple.getObject("ProtocolApplication_Performer_ProtocolApplication_name") != null ) this.setProtocolApplication_Name(tuple.getString("ProtocolApplication_Performer_ProtocolApplication_name"));		
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
		String result = "ProtocolApplication_Performer(";
		result+= "autoid='" + getAutoid()+"' ";	
		result+= " performer_id='" + getPerformer_Id()+"' ";	
		result+= " performer_name='" + getPerformer_Name()+"' ";
		result+= " protocolApplication_id='" + getProtocolApplication_Id()+"' ";	
		result+= " protocolApplication_name='" + getProtocolApplication_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of ProtocolApplication_Performer.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("autoid");
		}
		{
			fields.add("performer_id");
		}
		fields.add("performer_name");
		{
			fields.add("protocolApplication_id");
		}
		fields.add("protocolApplication_name");
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
		result.add("Performer");
		result.add("ProtocolApplication");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "autoid" +sep
		+ "performer" +sep
		+ "protocolApplication" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("performer")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("protocolApplication")) {
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
		ProtocolApplication_Performer rhs = (ProtocolApplication_Performer) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//performer
		//protocolApplication
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
			Object valueO = getPerformer();
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
			Object valueO = getProtocolApplication();
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
	public ProtocolApplication_Performer create(org.molgenis.util.Tuple tuple) throws Exception
	{
		ProtocolApplication_Performer e = new ProtocolApplication_Performer();
		e.set(tuple);
		return e;
	}
	

	
}

