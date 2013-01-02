
/* File:        auth/model/Institute.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.auth;

/**
 * Institute:  A contact is either a person or an organization. Copied
				from FuGE::Contact.
.
 * @version October 22, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Institute", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "name" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.auth.db.InstituteEntityListener.class})
public class Institute extends org.molgenis.util.AbstractEntity implements org.molgenis.auth.Contact
{
	// fieldname constants
	public final static String ID = "id";
	public final static String ADDRESS = "Address";
	public final static String PHONE = "Phone";
	public final static String EMAIL = "Email";
	public final static String FAX = "Fax";
	public final static String TOLLFREEPHONE = "tollFreePhone";
	public final static String CITY = "City";
	public final static String COUNTRY = "Country";
	public final static String NAME = "name";
	
	//static methods
	/**
	 * Shorthand for db.query(Institute.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Institute> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Institute.class);
	}
	
	/**
	 * Shorthand for db.find(Institute.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Institute> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Institute.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Institute findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Institute> q = db.query(Institute.class);
		q.eq(Institute.ID, id);
		java.util.List<Institute> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Institute findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Institute> q = db.query(Institute.class);
		q.eq(Institute.NAME, name);
		java.util.List<Institute> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatically generated id[type=int]
    @javax.persistence.Id @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Column(name="id", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="id")
	
	//@javax.validation.constraints.NotNull
	private Integer id =  null;


	//The address of the Contact.[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="Address", length=16777216)
	
				

	private String address =  null;


	//The telephone number of the Contact including the suitable area codes.[type=string]
	@javax.persistence.Column(name="Phone")
	@javax.xml.bind.annotation.XmlElement(name="phone")
	
				

	private String phone =  null;


	//The email address of the Contact.[type=string]
	@javax.persistence.Column(name="Email")
	@javax.xml.bind.annotation.XmlElement(name="email")
	
				

	private String email =  null;


	//The fax number of the Contact.[type=string]
	@javax.persistence.Column(name="Fax")
	@javax.xml.bind.annotation.XmlElement(name="fax")
	
				

	private String fax =  null;


	//A toll free phone number for the Contact, including suitable area codes.[type=string]
	@javax.persistence.Column(name="tollFreePhone")
	@javax.xml.bind.annotation.XmlElement(name="tollFreePhone")
	
				

	private String tollFreePhone =  null;


	//Added from the old definition of MolgenisUser. City of this contact.[type=string]
	@javax.persistence.Column(name="City")
	@javax.xml.bind.annotation.XmlElement(name="city")
	
				

	private String city =  null;


	//Added from the old definition of MolgenisUser. Country of this contact.[type=string]
	@javax.persistence.Column(name="Country")
	@javax.xml.bind.annotation.XmlElement(name="country")
	
				

	private String country =  null;


	//name[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="name", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="name")
	
				

	@javax.validation.constraints.NotNull
	private String name =  null;

	//constructors
	public Institute()
	{
	
	}
	
	//getters and setters
	/**
	 * Get the automatically generated id.
	 * @return id.
	 */
	public Integer getId()
	{
		return this.id;
	}
	
	
	/**
	 * Set the automatically generated id.
	 * @param id
	 */
	public void setId( Integer id)
	{
		this.id = id;
	}

	

	/**
	 * Get the The address of the Contact..
	 * @return address.
	 */
	public String getAddress()
	{
		return this.address;
	}
	
	@Deprecated
	public String getAddress(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The address of the Contact..
	 * @param address
	 */
	public void setAddress( String address)
	{
		
		this.address = address;
	}

	

	/**
	 * Get the The telephone number of the Contact including the suitable area codes..
	 * @return phone.
	 */
	public String getPhone()
	{
		return this.phone;
	}
	
	@Deprecated
	public String getPhone(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The telephone number of the Contact including the suitable area codes..
	 * @param phone
	 */
	public void setPhone( String phone)
	{
		
		this.phone = phone;
	}

	

	/**
	 * Get the The email address of the Contact..
	 * @return email.
	 */
	public String getEmail()
	{
		return this.email;
	}
	
	@Deprecated
	public String getEmail(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The email address of the Contact..
	 * @param email
	 */
	public void setEmail( String email)
	{
		
		this.email = email;
	}

	

	/**
	 * Get the The fax number of the Contact..
	 * @return fax.
	 */
	public String getFax()
	{
		return this.fax;
	}
	
	@Deprecated
	public String getFax(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The fax number of the Contact..
	 * @param fax
	 */
	public void setFax( String fax)
	{
		
		this.fax = fax;
	}

	

	/**
	 * Get the A toll free phone number for the Contact, including suitable area codes..
	 * @return tollFreePhone.
	 */
	public String getTollFreePhone()
	{
		return this.tollFreePhone;
	}
	
	@Deprecated
	public String getTollFreePhone(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the A toll free phone number for the Contact, including suitable area codes..
	 * @param tollFreePhone
	 */
	public void setTollFreePhone( String tollFreePhone)
	{
		
		this.tollFreePhone = tollFreePhone;
	}

	

	/**
	 * Get the Added from the old definition of MolgenisUser. City of this contact..
	 * @return city.
	 */
	public String getCity()
	{
		return this.city;
	}
	
	@Deprecated
	public String getCity(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Added from the old definition of MolgenisUser. City of this contact..
	 * @param city
	 */
	public void setCity( String city)
	{
		
		this.city = city;
	}

	

	/**
	 * Get the Added from the old definition of MolgenisUser. Country of this contact..
	 * @return country.
	 */
	public String getCountry()
	{
		return this.country;
	}
	
	@Deprecated
	public String getCountry(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Added from the old definition of MolgenisUser. Country of this contact..
	 * @param country
	 */
	public void setCountry( String country)
	{
		
		this.country = country;
	}

	

	/**
	 * Get the name.
	 * @return name.
	 */
	public String getName()
	{
		return this.name;
	}
	
	@Deprecated
	public String getName(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the name.
	 * @param name
	 */
	public void setName( String name)
	{
		
		this.name = name;
	}

	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("address"))
			return getAddress();
		if (name.toLowerCase().equals("phone"))
			return getPhone();
		if (name.toLowerCase().equals("email"))
			return getEmail();
		if (name.toLowerCase().equals("fax"))
			return getFax();
		if (name.toLowerCase().equals("tollfreephone"))
			return getTollFreePhone();
		if (name.toLowerCase().equals("city"))
			return getCity();
		if (name.toLowerCase().equals("country"))
			return getCountry();
		if (name.toLowerCase().equals("name"))
			return getName();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Id
			this.setId(tuple.getInt("id"));
			//set Address
			this.setAddress(tuple.getString("Address"));
			//set Phone
			this.setPhone(tuple.getString("Phone"));
			//set Email
			this.setEmail(tuple.getString("Email"));
			//set Fax
			this.setFax(tuple.getString("Fax"));
			//set TollFreePhone
			this.setTollFreePhone(tuple.getString("tollFreePhone"));
			//set City
			this.setCity(tuple.getString("City"));
			//set Country
			this.setCountry(tuple.getString("Country"));
			//set Name
			this.setName(tuple.getString("name"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Institute_id") != null) this.setId(tuple.getInt("Institute_id"));
			//set Address
			if( strict || tuple.getString("Address") != null) this.setAddress(tuple.getString("Address"));
			if( tuple.getString("Institute_Address") != null) this.setAddress(tuple.getString("Institute_Address"));
			//set Phone
			if( strict || tuple.getString("Phone") != null) this.setPhone(tuple.getString("Phone"));
			if( tuple.getString("Institute_Phone") != null) this.setPhone(tuple.getString("Institute_Phone"));
			//set Email
			if( strict || tuple.getString("Email") != null) this.setEmail(tuple.getString("Email"));
			if( tuple.getString("Institute_Email") != null) this.setEmail(tuple.getString("Institute_Email"));
			//set Fax
			if( strict || tuple.getString("Fax") != null) this.setFax(tuple.getString("Fax"));
			if( tuple.getString("Institute_Fax") != null) this.setFax(tuple.getString("Institute_Fax"));
			//set TollFreePhone
			if( strict || tuple.getString("tollFreePhone") != null) this.setTollFreePhone(tuple.getString("tollFreePhone"));
			if( tuple.getString("Institute_tollFreePhone") != null) this.setTollFreePhone(tuple.getString("Institute_tollFreePhone"));
			//set City
			if( strict || tuple.getString("City") != null) this.setCity(tuple.getString("City"));
			if( tuple.getString("Institute_City") != null) this.setCity(tuple.getString("Institute_City"));
			//set Country
			if( strict || tuple.getString("Country") != null) this.setCountry(tuple.getString("Country"));
			if( tuple.getString("Institute_Country") != null) this.setCountry(tuple.getString("Institute_Country"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("Institute_name") != null) this.setName(tuple.getString("Institute_name"));
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
		String result = "Institute(";
		result+= "id='" + getId()+"' ";	
		result+= "address='" + getAddress()+"' ";	
		result+= "phone='" + getPhone()+"' ";	
		result+= "email='" + getEmail()+"' ";	
		result+= "fax='" + getFax()+"' ";	
		result+= "tollFreePhone='" + getTollFreePhone()+"' ";	
		result+= "city='" + getCity()+"' ";	
		result+= "country='" + getCountry()+"' ";	
		result+= "name='" + getName()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Institute.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("address");
		}
		{
			fields.add("phone");
		}
		{
			fields.add("email");
		}
		{
			fields.add("fax");
		}
		{
			fields.add("tollFreePhone");
		}
		{
			fields.add("city");
		}
		{
			fields.add("country");
		}
		{
			fields.add("name");
		}
		return fields;
	}	

	public java.util.Vector<String> getFields()
	{
		return getFields(false);
	}

	@Override
	public String getIdField()
	{
		return "id";
	}
	

	
	@Override
	public java.util.List<String> getLabelFields()
	{
		java.util.List<String> result = new java.util.ArrayList<String>();
		result.add("name");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "id" +sep
		+ "address" +sep
		+ "phone" +sep
		+ "email" +sep
		+ "fax" +sep
		+ "tollFreePhone" +sep
		+ "city" +sep
		+ "country" +sep
		+ "name" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        
        return null;
    }	

	@Override
	public boolean equals(Object obj) {
   		if (obj == null) { return false; }
   		if (obj == this) { return true; }
   		if (obj.getClass() != getClass()) {
     		return false;
   		}
		Institute rhs = (Institute) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//name
				.append(name, rhs.getName())
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
				.append(name)
   			.toHashCode();
    }  	
  	


	@Deprecated
	public String getValues(String sep)
	{
		java.io.StringWriter out = new java.io.StringWriter();
		{
			Object valueO = getId();
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
			Object valueO = getAddress();
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
			Object valueO = getPhone();
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
			Object valueO = getEmail();
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
			Object valueO = getFax();
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
			Object valueO = getTollFreePhone();
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
			Object valueO = getCity();
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
			Object valueO = getCountry();
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
			Object valueO = getName();
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
	public Institute create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Institute e = new Institute();
		e.set(tuple);
		return e;
	}
	
//1
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="affiliation"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.auth.Person> affiliationPersonCollection = new java.util.ArrayList<org.molgenis.auth.Person>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.auth.Person> getAffiliationPersonCollection()
	{
            return affiliationPersonCollection;
	}

    public void setAffiliationPersonCollection(java.util.Collection<org.molgenis.auth.Person> collection)
    {
        for (org.molgenis.auth.Person person : collection) {
            person.setAffiliation(this);
        }
        affiliationPersonCollection = collection;
    }	

	
}

