
/* File:        observ/model/ObservationElement_AlternateId.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.pheno;

/**
 * ObservationElement_AlternateId: Link table for many-to-many relationship 'ObservationElement.AlternateId'..
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.pheno.db.ObservationElement_AlternateIdEntityListener.class})
public class ObservationElement_AlternateId extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String AUTOID = "autoid";
	public final static String ALTERNATEID = "AlternateId";
	public final static String ALTERNATEID_NAME = "AlternateId_name";
	public final static String OBSERVATIONELEMENT = "ObservationElement";
	public final static String OBSERVATIONELEMENT_NAME = "ObservationElement_name";
	
	//static methods
	/**
	 * Shorthand for db.query(ObservationElement_AlternateId.class).
	 */
	public static org.molgenis.framework.db.Query<? extends ObservationElement_AlternateId> query(org.molgenis.framework.db.Database db)
	{
		return db.query(ObservationElement_AlternateId.class);
	}
	
	/**
	 * Shorthand for db.find(ObservationElement_AlternateId.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends ObservationElement_AlternateId> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(ObservationElement_AlternateId.class, rules);
	}	
	
	/**
	 * 
	 */
	public static ObservationElement_AlternateId findByAutoid(org.molgenis.framework.db.Database db, Integer autoid) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservationElement_AlternateId> q = db.query(ObservationElement_AlternateId.class);
		q.eq(ObservationElement_AlternateId.AUTOID, autoid);
		java.util.List<ObservationElement_AlternateId> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static ObservationElement_AlternateId findByAlternateIdObservationElement(org.molgenis.framework.db.Database db, Integer alternateId, Integer observationElement) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservationElement_AlternateId> q = db.query(ObservationElement_AlternateId.class);
		q.eq(ObservationElement_AlternateId.ALTERNATEID, alternateId);q.eq(ObservationElement_AlternateId.OBSERVATIONELEMENT, observationElement);
		java.util.List<ObservationElement_AlternateId> result = q.find();
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
    @javax.persistence.JoinColumn(name="AlternateId", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.pheno.AlternateId alternateId = null;
	@javax.persistence.Transient
	private Integer alternateId_id = null;	
	@javax.persistence.Transient
	private String alternateId_name = null;						


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="ObservationElement", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.pheno.ObservationElement observationElement = null;
	@javax.persistence.Transient
	private Integer observationElement_id = null;	
	@javax.persistence.Transient
	private String observationElement_name = null;						

	//constructors
	public ObservationElement_AlternateId()
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
	 * @return alternateId.
	 */
	public org.molgenis.pheno.AlternateId getAlternateId()
	{
		return this.alternateId;
	}
	
	@Deprecated
	public org.molgenis.pheno.AlternateId getAlternateId(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param alternateId
	 */
	public void setAlternateId( org.molgenis.pheno.AlternateId alternateId)
	{
		
		this.alternateId = alternateId;
	}

	
	
	/**
	 * Set foreign key for field alternateId.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setAlternateId_Id(Integer alternateId_id)
	{
		this.alternateId_id = alternateId_id;
	}	

	public void setAlternateId(Integer alternateId_id)
	{
		this.alternateId_id = alternateId_id;
	}
	
	public Integer getAlternateId_Id()
	{
		
		if(alternateId != null) 
		{
			return alternateId.getId();
		}
		else
		{
			return alternateId_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference AlternateId to AlternateId.Id.
	 */
	public String getAlternateId_Name()
	{		
		//FIXME should we auto-load based on getAlternateId()?	
		if(alternateId != null) {
			return alternateId.getName();
		} else {
			return alternateId_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference AlternateId to <a href="AlternateId.html#Id">AlternateId.Id</a>.
	 * Implies setAlternateId(null) until save
	 */
	public void setAlternateId_Name(String alternateId_name)
	{
		this.alternateId_name = alternateId_name;
	}		
	 
	

	/**
	 * Get the .
	 * @return observationElement.
	 */
	public org.molgenis.pheno.ObservationElement getObservationElement()
	{
		return this.observationElement;
	}
	
	@Deprecated
	public org.molgenis.pheno.ObservationElement getObservationElement(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param observationElement
	 */
	public void setObservationElement( org.molgenis.pheno.ObservationElement observationElement)
	{
		
		this.observationElement = observationElement;
	}

	
	
	/**
	 * Set foreign key for field observationElement.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setObservationElement_Id(Integer observationElement_id)
	{
		this.observationElement_id = observationElement_id;
	}	

	public void setObservationElement(Integer observationElement_id)
	{
		this.observationElement_id = observationElement_id;
	}
	
	public Integer getObservationElement_Id()
	{
		
		if(observationElement != null) 
		{
			return observationElement.getId();
		}
		else
		{
			return observationElement_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference ObservationElement to ObservationElement.Id.
	 */
	public String getObservationElement_Name()
	{		
		//FIXME should we auto-load based on getObservationElement()?	
		if(observationElement != null) {
			return observationElement.getName();
		} else {
			return observationElement_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference ObservationElement to <a href="ObservationElement.html#Id">ObservationElement.Id</a>.
	 * Implies setObservationElement(null) until save
	 */
	public void setObservationElement_Name(String observationElement_name)
	{
		this.observationElement_name = observationElement_name;
	}		
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("autoid"))
			return getAutoid();
		if (name.toLowerCase().equals("alternateid"))
			return getAlternateId();
		if(name.toLowerCase().equals("alternateid_id"))
			return getAlternateId_Id();
		if(name.toLowerCase().equals("alternateid_name"))
			return getAlternateId_Name();
		if (name.toLowerCase().equals("observationelement"))
			return getObservationElement();
		if(name.toLowerCase().equals("observationelement_id"))
			return getObservationElement_Id();
		if(name.toLowerCase().equals("observationelement_name"))
			return getObservationElement_Name();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getAutoid() == null) throw new org.molgenis.framework.db.DatabaseException("required field autoid is null");
		if(this.getAlternateId() == null) throw new org.molgenis.framework.db.DatabaseException("required field alternateId is null");
		if(this.getObservationElement() == null) throw new org.molgenis.framework.db.DatabaseException("required field observationElement is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Autoid
			this.setAutoid(tuple.getInt("autoid"));
			//set AlternateId
			this.setAlternateId(tuple.getInt("AlternateId"));
			//set label name for xref field AlternateId
			this.setAlternateId_Name(tuple.getString("AlternateId_name"));	
			//set ObservationElement
			this.setObservationElement(tuple.getInt("ObservationElement"));
			//set label name for xref field ObservationElement
			this.setObservationElement_Name(tuple.getString("ObservationElement_name"));	
		}
		else if(tuple != null)
		{
			//set Autoid
			if( strict || tuple.getInt("autoid") != null) this.setAutoid(tuple.getInt("autoid"));
			if( tuple.getInt("ObservationElement_AlternateId_autoid") != null) this.setAutoid(tuple.getInt("ObservationElement_AlternateId_autoid"));
			//set AlternateId
			if( strict || tuple.getInt("AlternateId_id") != null) this.setAlternateId(tuple.getInt("AlternateId_id"));
			if( tuple.getInt("ObservationElement_AlternateId_AlternateId_id") != null) this.setAlternateId(tuple.getInt("ObservationElement_AlternateId_AlternateId_id"));
			//alias of xref
			if( tuple.getObject("AlternateId") != null) this.setAlternateId(tuple.getInt("AlternateId"));
			if( tuple.getObject("ObservationElement_AlternateId_AlternateId") != null) this.setAlternateId(tuple.getInt("ObservationElement_AlternateId_AlternateId"));
			//set label for field AlternateId
			if( strict || tuple.getObject("AlternateId_name") != null) this.setAlternateId_Name(tuple.getString("AlternateId_name"));			
			if( tuple.getObject("ObservationElement_AlternateId_AlternateId_name") != null ) this.setAlternateId_Name(tuple.getString("ObservationElement_AlternateId_AlternateId_name"));		
			//set ObservationElement
			if( strict || tuple.getInt("ObservationElement_id") != null) this.setObservationElement(tuple.getInt("ObservationElement_id"));
			if( tuple.getInt("ObservationElement_AlternateId_ObservationElement_id") != null) this.setObservationElement(tuple.getInt("ObservationElement_AlternateId_ObservationElement_id"));
			//alias of xref
			if( tuple.getObject("ObservationElement") != null) this.setObservationElement(tuple.getInt("ObservationElement"));
			if( tuple.getObject("ObservationElement_AlternateId_ObservationElement") != null) this.setObservationElement(tuple.getInt("ObservationElement_AlternateId_ObservationElement"));
			//set label for field ObservationElement
			if( strict || tuple.getObject("ObservationElement_name") != null) this.setObservationElement_Name(tuple.getString("ObservationElement_name"));			
			if( tuple.getObject("ObservationElement_AlternateId_ObservationElement_name") != null ) this.setObservationElement_Name(tuple.getString("ObservationElement_AlternateId_ObservationElement_name"));		
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
		String result = "ObservationElement_AlternateId(";
		result+= "autoid='" + getAutoid()+"' ";	
		result+= " alternateId_id='" + getAlternateId_Id()+"' ";	
		result+= " alternateId_name='" + getAlternateId_Name()+"' ";
		result+= " observationElement_id='" + getObservationElement_Id()+"' ";	
		result+= " observationElement_name='" + getObservationElement_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of ObservationElement_AlternateId.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("autoid");
		}
		{
			fields.add("alternateId_id");
		}
		fields.add("alternateId_name");
		{
			fields.add("observationElement_id");
		}
		fields.add("observationElement_name");
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
		result.add("AlternateId");
		result.add("ObservationElement");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "autoid" +sep
		+ "alternateId" +sep
		+ "observationElement" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("alternateId")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("observationElement")) {
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
		ObservationElement_AlternateId rhs = (ObservationElement_AlternateId) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//alternateId
		//observationElement
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
			Object valueO = getAlternateId();
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
			Object valueO = getObservationElement();
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
	public ObservationElement_AlternateId create(org.molgenis.util.Tuple tuple) throws Exception
	{
		ObservationElement_AlternateId e = new ObservationElement_AlternateId();
		e.set(tuple);
		return e;
	}
	

	
}

