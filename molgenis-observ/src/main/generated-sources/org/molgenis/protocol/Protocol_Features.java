
/* File:        observ/model/Protocol_Features.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.protocol;

/**
 * Protocol_Features: Link table for many-to-many relationship 'Protocol.Features'..
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.protocol.db.Protocol_FeaturesEntityListener.class})
public class Protocol_Features extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String AUTOID = "autoid";
	public final static String FEATURES = "Features";
	public final static String FEATURES_NAME = "Features_name";
	public final static String PROTOCOL = "Protocol";
	public final static String PROTOCOL_NAME = "Protocol_name";
	
	//static methods
	/**
	 * Shorthand for db.query(Protocol_Features.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Protocol_Features> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Protocol_Features.class);
	}
	
	/**
	 * Shorthand for db.find(Protocol_Features.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Protocol_Features> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Protocol_Features.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Protocol_Features findByAutoid(org.molgenis.framework.db.Database db, Integer autoid) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Protocol_Features> q = db.query(Protocol_Features.class);
		q.eq(Protocol_Features.AUTOID, autoid);
		java.util.List<Protocol_Features> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Protocol_Features findByFeaturesProtocol(org.molgenis.framework.db.Database db, Integer features, Integer protocol) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Protocol_Features> q = db.query(Protocol_Features.class);
		q.eq(Protocol_Features.FEATURES, features);q.eq(Protocol_Features.PROTOCOL, protocol);
		java.util.List<Protocol_Features> result = q.find();
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
    @javax.persistence.JoinColumn(name="Features", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.pheno.ObservableFeature features = null;
	@javax.persistence.Transient
	private Integer features_id = null;	
	@javax.persistence.Transient
	private String features_name = null;						


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Protocol", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.protocol.Protocol protocol = null;
	@javax.persistence.Transient
	private Integer protocol_id = null;	
	@javax.persistence.Transient
	private String protocol_name = null;						

	//constructors
	public Protocol_Features()
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
	 * @return features.
	 */
	public org.molgenis.pheno.ObservableFeature getFeatures()
	{
		return this.features;
	}
	
	@Deprecated
	public org.molgenis.pheno.ObservableFeature getFeatures(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param features
	 */
	public void setFeatures( org.molgenis.pheno.ObservableFeature features)
	{
		
		this.features = features;
	}

	
	
	/**
	 * Set foreign key for field features.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setFeatures_Id(Integer features_id)
	{
		this.features_id = features_id;
	}	

	public void setFeatures(Integer features_id)
	{
		this.features_id = features_id;
	}
	
	public Integer getFeatures_Id()
	{
		
		if(features != null) 
		{
			return features.getId();
		}
		else
		{
			return features_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Features to ObservableFeature.Id.
	 */
	public String getFeatures_Name()
	{		
		//FIXME should we auto-load based on getFeatures()?	
		if(features != null) {
			return features.getName();
		} else {
			return features_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Features to <a href="ObservableFeature.html#Id">ObservableFeature.Id</a>.
	 * Implies setFeatures(null) until save
	 */
	public void setFeatures_Name(String features_name)
	{
		this.features_name = features_name;
	}		
	 
	

	/**
	 * Get the .
	 * @return protocol.
	 */
	public org.molgenis.protocol.Protocol getProtocol()
	{
		return this.protocol;
	}
	
	@Deprecated
	public org.molgenis.protocol.Protocol getProtocol(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param protocol
	 */
	public void setProtocol( org.molgenis.protocol.Protocol protocol)
	{
		
		this.protocol = protocol;
	}

	
	
	/**
	 * Set foreign key for field protocol.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setProtocol_Id(Integer protocol_id)
	{
		this.protocol_id = protocol_id;
	}	

	public void setProtocol(Integer protocol_id)
	{
		this.protocol_id = protocol_id;
	}
	
	public Integer getProtocol_Id()
	{
		
		if(protocol != null) 
		{
			return protocol.getId();
		}
		else
		{
			return protocol_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Protocol to Protocol.Id.
	 */
	public String getProtocol_Name()
	{		
		//FIXME should we auto-load based on getProtocol()?	
		if(protocol != null) {
			return protocol.getName();
		} else {
			return protocol_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Protocol to <a href="Protocol.html#Id">Protocol.Id</a>.
	 * Implies setProtocol(null) until save
	 */
	public void setProtocol_Name(String protocol_name)
	{
		this.protocol_name = protocol_name;
	}		
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("autoid"))
			return getAutoid();
		if (name.toLowerCase().equals("features"))
			return getFeatures();
		if(name.toLowerCase().equals("features_id"))
			return getFeatures_Id();
		if(name.toLowerCase().equals("features_name"))
			return getFeatures_Name();
		if (name.toLowerCase().equals("protocol"))
			return getProtocol();
		if(name.toLowerCase().equals("protocol_id"))
			return getProtocol_Id();
		if(name.toLowerCase().equals("protocol_name"))
			return getProtocol_Name();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getAutoid() == null) throw new org.molgenis.framework.db.DatabaseException("required field autoid is null");
		if(this.getFeatures() == null) throw new org.molgenis.framework.db.DatabaseException("required field features is null");
		if(this.getProtocol() == null) throw new org.molgenis.framework.db.DatabaseException("required field protocol is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Autoid
			this.setAutoid(tuple.getInt("autoid"));
			//set Features
			this.setFeatures(tuple.getInt("Features"));
			//set label name for xref field Features
			this.setFeatures_Name(tuple.getString("Features_name"));	
			//set Protocol
			this.setProtocol(tuple.getInt("Protocol"));
			//set label name for xref field Protocol
			this.setProtocol_Name(tuple.getString("Protocol_name"));	
		}
		else if(tuple != null)
		{
			//set Autoid
			if( strict || tuple.getInt("autoid") != null) this.setAutoid(tuple.getInt("autoid"));
			if( tuple.getInt("Protocol_Features_autoid") != null) this.setAutoid(tuple.getInt("Protocol_Features_autoid"));
			//set Features
			if( strict || tuple.getInt("Features_id") != null) this.setFeatures(tuple.getInt("Features_id"));
			if( tuple.getInt("Protocol_Features_Features_id") != null) this.setFeatures(tuple.getInt("Protocol_Features_Features_id"));
			//alias of xref
			if( tuple.getObject("Features") != null) this.setFeatures(tuple.getInt("Features"));
			if( tuple.getObject("Protocol_Features_Features") != null) this.setFeatures(tuple.getInt("Protocol_Features_Features"));
			//set label for field Features
			if( strict || tuple.getObject("Features_name") != null) this.setFeatures_Name(tuple.getString("Features_name"));			
			if( tuple.getObject("Protocol_Features_Features_name") != null ) this.setFeatures_Name(tuple.getString("Protocol_Features_Features_name"));		
			//set Protocol
			if( strict || tuple.getInt("Protocol_id") != null) this.setProtocol(tuple.getInt("Protocol_id"));
			if( tuple.getInt("Protocol_Features_Protocol_id") != null) this.setProtocol(tuple.getInt("Protocol_Features_Protocol_id"));
			//alias of xref
			if( tuple.getObject("Protocol") != null) this.setProtocol(tuple.getInt("Protocol"));
			if( tuple.getObject("Protocol_Features_Protocol") != null) this.setProtocol(tuple.getInt("Protocol_Features_Protocol"));
			//set label for field Protocol
			if( strict || tuple.getObject("Protocol_name") != null) this.setProtocol_Name(tuple.getString("Protocol_name"));			
			if( tuple.getObject("Protocol_Features_Protocol_name") != null ) this.setProtocol_Name(tuple.getString("Protocol_Features_Protocol_name"));		
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
		String result = "Protocol_Features(";
		result+= "autoid='" + getAutoid()+"' ";	
		result+= " features_id='" + getFeatures_Id()+"' ";	
		result+= " features_name='" + getFeatures_Name()+"' ";
		result+= " protocol_id='" + getProtocol_Id()+"' ";	
		result+= " protocol_name='" + getProtocol_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Protocol_Features.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("autoid");
		}
		{
			fields.add("features_id");
		}
		fields.add("features_name");
		{
			fields.add("protocol_id");
		}
		fields.add("protocol_name");
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
		result.add("Features");
		result.add("Protocol");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "autoid" +sep
		+ "features" +sep
		+ "protocol" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("features")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("protocol")) {
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
		Protocol_Features rhs = (Protocol_Features) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//features
		//protocol
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
			Object valueO = getFeatures();
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
			Object valueO = getProtocol();
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
	public Protocol_Features create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Protocol_Features e = new Protocol_Features();
		e.set(tuple);
		return e;
	}
	

	
}

