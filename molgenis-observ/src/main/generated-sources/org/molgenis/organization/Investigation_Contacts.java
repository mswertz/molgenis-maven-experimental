
/* File:        observ/model/Investigation_contacts.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.organization;

/**
 * Investigation_contacts: Link table for many-to-many relationship 'Investigation.contacts'..
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.organization.db.Investigation_ContactsEntityListener.class})
public class Investigation_Contacts extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String AUTOID = "autoid";
	public final static String CONTACTS = "contacts";
	public final static String CONTACTS_NAME = "contacts_name";
	public final static String INVESTIGATION = "Investigation";
	public final static String INVESTIGATION_NAME = "Investigation_name";
	
	//static methods
	/**
	 * Shorthand for db.query(Investigation_Contacts.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Investigation_Contacts> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Investigation_Contacts.class);
	}
	
	/**
	 * Shorthand for db.find(Investigation_Contacts.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Investigation_Contacts> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Investigation_Contacts.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Investigation_Contacts findByAutoid(org.molgenis.framework.db.Database db, Integer autoid) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Investigation_Contacts> q = db.query(Investigation_Contacts.class);
		q.eq(Investigation_Contacts.AUTOID, autoid);
		java.util.List<Investigation_Contacts> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Investigation_Contacts findByContactsInvestigation(org.molgenis.framework.db.Database db, Integer contacts, Integer investigation) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Investigation_Contacts> q = db.query(Investigation_Contacts.class);
		q.eq(Investigation_Contacts.CONTACTS, contacts);q.eq(Investigation_Contacts.INVESTIGATION, investigation);
		java.util.List<Investigation_Contacts> result = q.find();
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
    @javax.persistence.JoinColumn(name="contacts", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.auth.Person contacts = null;
	@javax.persistence.Transient
	private Integer contacts_id = null;	
	@javax.persistence.Transient
	private String contacts_name = null;						


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Investigation", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.organization.Investigation investigation = null;
	@javax.persistence.Transient
	private Integer investigation_id = null;	
	@javax.persistence.Transient
	private String investigation_name = null;						

	//constructors
	public Investigation_Contacts()
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
	 * @return contacts.
	 */
	public org.molgenis.auth.Person getContacts()
	{
		return this.contacts;
	}
	
	@Deprecated
	public org.molgenis.auth.Person getContacts(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param contacts
	 */
	public void setContacts( org.molgenis.auth.Person contacts)
	{
		
		this.contacts = contacts;
	}

	
	
	/**
	 * Set foreign key for field contacts.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setContacts_Id(Integer contacts_id)
	{
		this.contacts_id = contacts_id;
	}	

	public void setContacts(Integer contacts_id)
	{
		this.contacts_id = contacts_id;
	}
	
	public Integer getContacts_Id()
	{
		
		if(contacts != null) 
		{
			return contacts.getId();
		}
		else
		{
			return contacts_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Contacts to Person.Id.
	 */
	public String getContacts_Name()
	{		
		//FIXME should we auto-load based on getContacts()?	
		if(contacts != null) {
			return contacts.getName();
		} else {
			return contacts_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Contacts to <a href="Person.html#Id">Person.Id</a>.
	 * Implies setContacts(null) until save
	 */
	public void setContacts_Name(String contacts_name)
	{
		this.contacts_name = contacts_name;
	}		
	 
	

	/**
	 * Get the .
	 * @return investigation.
	 */
	public org.molgenis.organization.Investigation getInvestigation()
	{
		return this.investigation;
	}
	
	@Deprecated
	public org.molgenis.organization.Investigation getInvestigation(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param investigation
	 */
	public void setInvestigation( org.molgenis.organization.Investigation investigation)
	{
		
		this.investigation = investigation;
	}

	
	
	/**
	 * Set foreign key for field investigation.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setInvestigation_Id(Integer investigation_id)
	{
		this.investigation_id = investigation_id;
	}	

	public void setInvestigation(Integer investigation_id)
	{
		this.investigation_id = investigation_id;
	}
	
	public Integer getInvestigation_Id()
	{
		
		if(investigation != null) 
		{
			return investigation.getId();
		}
		else
		{
			return investigation_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Investigation to Investigation.Id.
	 */
	public String getInvestigation_Name()
	{		
		//FIXME should we auto-load based on getInvestigation()?	
		if(investigation != null) {
			return investigation.getName();
		} else {
			return investigation_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Investigation to <a href="Investigation.html#Id">Investigation.Id</a>.
	 * Implies setInvestigation(null) until save
	 */
	public void setInvestigation_Name(String investigation_name)
	{
		this.investigation_name = investigation_name;
	}		
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("autoid"))
			return getAutoid();
		if (name.toLowerCase().equals("contacts"))
			return getContacts();
		if(name.toLowerCase().equals("contacts_id"))
			return getContacts_Id();
		if(name.toLowerCase().equals("contacts_name"))
			return getContacts_Name();
		if (name.toLowerCase().equals("investigation"))
			return getInvestigation();
		if(name.toLowerCase().equals("investigation_id"))
			return getInvestigation_Id();
		if(name.toLowerCase().equals("investigation_name"))
			return getInvestigation_Name();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getAutoid() == null) throw new org.molgenis.framework.db.DatabaseException("required field autoid is null");
		if(this.getContacts() == null) throw new org.molgenis.framework.db.DatabaseException("required field contacts is null");
		if(this.getInvestigation() == null) throw new org.molgenis.framework.db.DatabaseException("required field investigation is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Autoid
			this.setAutoid(tuple.getInt("autoid"));
			//set Contacts
			this.setContacts(tuple.getInt("contacts"));
			//set label name for xref field Contacts
			this.setContacts_Name(tuple.getString("contacts_name"));	
			//set Investigation
			this.setInvestigation(tuple.getInt("Investigation"));
			//set label name for xref field Investigation
			this.setInvestigation_Name(tuple.getString("Investigation_name"));	
		}
		else if(tuple != null)
		{
			//set Autoid
			if( strict || tuple.getInt("autoid") != null) this.setAutoid(tuple.getInt("autoid"));
			if( tuple.getInt("Investigation_contacts_autoid") != null) this.setAutoid(tuple.getInt("Investigation_contacts_autoid"));
			//set Contacts
			if( strict || tuple.getInt("contacts_id") != null) this.setContacts(tuple.getInt("contacts_id"));
			if( tuple.getInt("Investigation_contacts_contacts_id") != null) this.setContacts(tuple.getInt("Investigation_contacts_contacts_id"));
			//alias of xref
			if( tuple.getObject("contacts") != null) this.setContacts(tuple.getInt("contacts"));
			if( tuple.getObject("Investigation_contacts_contacts") != null) this.setContacts(tuple.getInt("Investigation_contacts_contacts"));
			//set label for field Contacts
			if( strict || tuple.getObject("contacts_name") != null) this.setContacts_Name(tuple.getString("contacts_name"));			
			if( tuple.getObject("Investigation_contacts_contacts_name") != null ) this.setContacts_Name(tuple.getString("Investigation_contacts_contacts_name"));		
			//set Investigation
			if( strict || tuple.getInt("Investigation_id") != null) this.setInvestigation(tuple.getInt("Investigation_id"));
			if( tuple.getInt("Investigation_contacts_Investigation_id") != null) this.setInvestigation(tuple.getInt("Investigation_contacts_Investigation_id"));
			//alias of xref
			if( tuple.getObject("Investigation") != null) this.setInvestigation(tuple.getInt("Investigation"));
			if( tuple.getObject("Investigation_contacts_Investigation") != null) this.setInvestigation(tuple.getInt("Investigation_contacts_Investigation"));
			//set label for field Investigation
			if( strict || tuple.getObject("Investigation_name") != null) this.setInvestigation_Name(tuple.getString("Investigation_name"));			
			if( tuple.getObject("Investigation_contacts_Investigation_name") != null ) this.setInvestigation_Name(tuple.getString("Investigation_contacts_Investigation_name"));		
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
		String result = "Investigation_Contacts(";
		result+= "autoid='" + getAutoid()+"' ";	
		result+= " contacts_id='" + getContacts_Id()+"' ";	
		result+= " contacts_name='" + getContacts_Name()+"' ";
		result+= " investigation_id='" + getInvestigation_Id()+"' ";	
		result+= " investigation_name='" + getInvestigation_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Investigation_Contacts.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("autoid");
		}
		{
			fields.add("contacts_id");
		}
		fields.add("contacts_name");
		{
			fields.add("investigation_id");
		}
		fields.add("investigation_name");
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
		result.add("contacts");
		result.add("Investigation");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "autoid" +sep
		+ "contacts" +sep
		+ "investigation" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("contacts")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("investigation")) {
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
		Investigation_Contacts rhs = (Investigation_Contacts) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//contacts
		//investigation
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
			Object valueO = getContacts();
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
			Object valueO = getInvestigation();
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
	public Investigation_Contacts create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Investigation_Contacts e = new Investigation_Contacts();
		e.set(tuple);
		return e;
	}
	

	
}

