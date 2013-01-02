
/* File:        observ/model/Person.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.auth;

/**
 * Person: 

				Person represents one or more people involved with an Investigation.
				This may include authors on a paper, lab personnel or PIs. Person
				has last name, firstname, mid initial, address, contact and email. A
				Person role is included to represent how a Person is involved with
				an investigation. For submission to repository purposes an allowed
				value is 'submitter' and the term is present in the MGED Ontology,
				an alternative use could represent job title. An Example from
				ArrayExpress is E-MTAB-506
				<a href="ftp://ftp.ebi.ac.uk/pub/databases/microarray/data/experiment/TABM/E-TABM-506/E-TABM-506.idf.txt">
					ftp://ftp.ebi.ac.uk/pub/databases/microarray/data/experiment/TABM/E-TABM-506/E-TABM-506.idf.txt.
				</a>
				.
				<br/>
				The FUGE equivalent to Person is FuGE::Person.
			
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Person", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "FirstName", "MidInitials", "LastName" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.auth.db.PersonEntityListener.class})
public class Person extends org.molgenis.auth.MolgenisRole implements org.molgenis.auth.Contact
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
	public final static String FIRSTNAME = "FirstName";
	public final static String MIDINITIALS = "MidInitials";
	public final static String LASTNAME = "LastName";
	public final static String TITLE = "Title";
	public final static String AFFILIATION = "Affiliation";
	public final static String AFFILIATION_NAME = "Affiliation_name";
	public final static String DEPARTMENT = "Department";
	public final static String ROLES = "Roles";
	public final static String ROLES_NAME = "Roles_name";
	
	//static methods
	/**
	 * Shorthand for db.query(Person.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Person> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Person.class);
	}
	
	/**
	 * Shorthand for db.find(Person.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Person> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Person.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Person findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Person> q = db.query(Person.class);
		q.eq(Person.ID, id);
		java.util.List<Person> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Person findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Person> q = db.query(Person.class);
		q.eq(Person.NAME, name);
		java.util.List<Person> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Person findByFirstNameMidInitialsLastName(org.molgenis.framework.db.Database db, String firstName, String midInitials, String lastName) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Person> q = db.query(Person.class);
		q.eq(Person.FIRSTNAME, firstName);q.eq(Person.MIDINITIALS, midInitials);q.eq(Person.LASTNAME, lastName);
		java.util.List<Person> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatically generated id[type=int]
	


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


	//First Name[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="FirstName")
	@javax.xml.bind.annotation.XmlElement(name="firstName")
	
				

	private String firstName =  null;


	//Mid Initials[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="MidInitials")
	@javax.xml.bind.annotation.XmlElement(name="midInitials")
	
				

	private String midInitials =  null;


	//Last Name[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="LastName")
	@javax.xml.bind.annotation.XmlElement(name="lastName")
	
				

	private String lastName =  null;


	//An academic title, e.g. Prof.dr, PhD[type=string]
	@javax.persistence.Column(name="Title")
	@javax.xml.bind.annotation.XmlElement(name="title")
	
				

	private String title =  null;


	//Affiliation[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Affiliation")   	
	
				

	private org.molgenis.auth.Institute affiliation = null;
	@javax.persistence.Transient
	private Integer affiliation_id = null;	
	@javax.persistence.Transient
	private String affiliation_name = null;						


	//Added from the old definition of MolgenisUser. Department of this contact.[type=string]
	@javax.persistence.Column(name="Department")
	@javax.xml.bind.annotation.XmlElement(name="department")
	
				

	private String department =  null;


	//Indicate role of the contact, e.g. lab worker or PI. Changed from mref to xref in oct 2011.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Roles")   	
	
				

	private org.molgenis.core.OntologyTerm roles = null;
	@javax.persistence.Transient
	private Integer roles_id = null;	
	@javax.persistence.Transient
	private String roles_name = null;						

	//constructors
	public Person()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	

	

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
	 * Get the First Name.
	 * @return firstName.
	 */
	public String getFirstName()
	{
		return this.firstName;
	}
	
	@Deprecated
	public String getFirstName(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the First Name.
	 * @param firstName
	 */
	public void setFirstName( String firstName)
	{
		
		this.firstName = firstName;
	}

	

	/**
	 * Get the Mid Initials.
	 * @return midInitials.
	 */
	public String getMidInitials()
	{
		return this.midInitials;
	}
	
	@Deprecated
	public String getMidInitials(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Mid Initials.
	 * @param midInitials
	 */
	public void setMidInitials( String midInitials)
	{
		
		this.midInitials = midInitials;
	}

	

	/**
	 * Get the Last Name.
	 * @return lastName.
	 */
	public String getLastName()
	{
		return this.lastName;
	}
	
	@Deprecated
	public String getLastName(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Last Name.
	 * @param lastName
	 */
	public void setLastName( String lastName)
	{
		
		this.lastName = lastName;
	}

	

	/**
	 * Get the An academic title, e.g. Prof.dr, PhD.
	 * @return title.
	 */
	public String getTitle()
	{
		return this.title;
	}
	
	@Deprecated
	public String getTitle(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the An academic title, e.g. Prof.dr, PhD.
	 * @param title
	 */
	public void setTitle( String title)
	{
		
		this.title = title;
	}

	

	/**
	 * Get the Affiliation.
	 * @return affiliation.
	 */
	public org.molgenis.auth.Institute getAffiliation()
	{
		return this.affiliation;
	}
	
	@Deprecated
	public org.molgenis.auth.Institute getAffiliation(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Affiliation.
	 * @param affiliation
	 */
	public void setAffiliation( org.molgenis.auth.Institute affiliation)
	{
		
		this.affiliation = affiliation;
	}

	
	
	/**
	 * Set foreign key for field affiliation.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setAffiliation_Id(Integer affiliation_id)
	{
		this.affiliation_id = affiliation_id;
	}	

	public void setAffiliation(Integer affiliation_id)
	{
		this.affiliation_id = affiliation_id;
	}
	
	public Integer getAffiliation_Id()
	{
		
		if(affiliation != null) 
		{
			return affiliation.getId();
		}
		else
		{
			return affiliation_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Affiliation to Institute.Id.
	 */
	public String getAffiliation_Name()
	{		
		//FIXME should we auto-load based on getAffiliation()?	
		if(affiliation != null) {
			return affiliation.getName();
		} else {
			return affiliation_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Affiliation to <a href="Institute.html#Id">Institute.Id</a>.
	 * Implies setAffiliation(null) until save
	 */
	public void setAffiliation_Name(String affiliation_name)
	{
		this.affiliation_name = affiliation_name;
	}		
	 
	

	/**
	 * Get the Added from the old definition of MolgenisUser. Department of this contact..
	 * @return department.
	 */
	public String getDepartment()
	{
		return this.department;
	}
	
	@Deprecated
	public String getDepartment(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Added from the old definition of MolgenisUser. Department of this contact..
	 * @param department
	 */
	public void setDepartment( String department)
	{
		
		this.department = department;
	}

	

	/**
	 * Get the Indicate role of the contact, e.g. lab worker or PI. Changed from mref to xref in oct 2011..
	 * @return roles.
	 */
	public org.molgenis.core.OntologyTerm getRoles()
	{
		return this.roles;
	}
	
	@Deprecated
	public org.molgenis.core.OntologyTerm getRoles(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Indicate role of the contact, e.g. lab worker or PI. Changed from mref to xref in oct 2011..
	 * @param roles
	 */
	public void setRoles( org.molgenis.core.OntologyTerm roles)
	{
		
		this.roles = roles;
	}

	
	
	/**
	 * Set foreign key for field roles.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setRoles_Id(Integer roles_id)
	{
		this.roles_id = roles_id;
	}	

	public void setRoles(Integer roles_id)
	{
		this.roles_id = roles_id;
	}
	
	public Integer getRoles_Id()
	{
		
		if(roles != null) 
		{
			return roles.getId();
		}
		else
		{
			return roles_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Roles to OntologyTerm.Id.
	 */
	public String getRoles_Name()
	{		
		//FIXME should we auto-load based on getRoles()?	
		if(roles != null) {
			return roles.getName();
		} else {
			return roles_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Roles to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setRoles(null) until save
	 */
	public void setRoles_Name(String roles_name)
	{
		this.roles_name = roles_name;
	}		
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("__type"))
			return get__Type();
		if(name.toLowerCase().equals("__type_label"))
			return get__TypeLabel();
		if (name.toLowerCase().equals("name"))
			return getName();
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
		if (name.toLowerCase().equals("firstname"))
			return getFirstName();
		if (name.toLowerCase().equals("midinitials"))
			return getMidInitials();
		if (name.toLowerCase().equals("lastname"))
			return getLastName();
		if (name.toLowerCase().equals("title"))
			return getTitle();
		if (name.toLowerCase().equals("affiliation"))
			return getAffiliation();
		if(name.toLowerCase().equals("affiliation_id"))
			return getAffiliation_Id();
		if(name.toLowerCase().equals("affiliation_name"))
			return getAffiliation_Name();
		if (name.toLowerCase().equals("department"))
			return getDepartment();
		if (name.toLowerCase().equals("roles"))
			return getRoles();
		if(name.toLowerCase().equals("roles_id"))
			return getRoles_Id();
		if(name.toLowerCase().equals("roles_name"))
			return getRoles_Name();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
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
			//set __Type
			this.set__Type(tuple.getString("__Type"));
			//set Name
			this.setName(tuple.getString("name"));
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
			//set FirstName
			this.setFirstName(tuple.getString("FirstName"));
			//set MidInitials
			this.setMidInitials(tuple.getString("MidInitials"));
			//set LastName
			this.setLastName(tuple.getString("LastName"));
			//set Title
			this.setTitle(tuple.getString("Title"));
			//set Affiliation
			this.setAffiliation(tuple.getInt("Affiliation"));
			//set label name for xref field Affiliation
			this.setAffiliation_Name(tuple.getString("Affiliation_name"));	
			//set Department
			this.setDepartment(tuple.getString("Department"));
			//set Roles
			this.setRoles(tuple.getInt("Roles"));
			//set label name for xref field Roles
			this.setRoles_Name(tuple.getString("Roles_name"));	
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Person_id") != null) this.setId(tuple.getInt("Person_id"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("Person___Type") != null) this.set__Type(tuple.getString("Person___Type"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("Person_name") != null) this.setName(tuple.getString("Person_name"));
			//set Address
			if( strict || tuple.getString("Address") != null) this.setAddress(tuple.getString("Address"));
			if( tuple.getString("Person_Address") != null) this.setAddress(tuple.getString("Person_Address"));
			//set Phone
			if( strict || tuple.getString("Phone") != null) this.setPhone(tuple.getString("Phone"));
			if( tuple.getString("Person_Phone") != null) this.setPhone(tuple.getString("Person_Phone"));
			//set Email
			if( strict || tuple.getString("Email") != null) this.setEmail(tuple.getString("Email"));
			if( tuple.getString("Person_Email") != null) this.setEmail(tuple.getString("Person_Email"));
			//set Fax
			if( strict || tuple.getString("Fax") != null) this.setFax(tuple.getString("Fax"));
			if( tuple.getString("Person_Fax") != null) this.setFax(tuple.getString("Person_Fax"));
			//set TollFreePhone
			if( strict || tuple.getString("tollFreePhone") != null) this.setTollFreePhone(tuple.getString("tollFreePhone"));
			if( tuple.getString("Person_tollFreePhone") != null) this.setTollFreePhone(tuple.getString("Person_tollFreePhone"));
			//set City
			if( strict || tuple.getString("City") != null) this.setCity(tuple.getString("City"));
			if( tuple.getString("Person_City") != null) this.setCity(tuple.getString("Person_City"));
			//set Country
			if( strict || tuple.getString("Country") != null) this.setCountry(tuple.getString("Country"));
			if( tuple.getString("Person_Country") != null) this.setCountry(tuple.getString("Person_Country"));
			//set FirstName
			if( strict || tuple.getString("FirstName") != null) this.setFirstName(tuple.getString("FirstName"));
			if( tuple.getString("Person_FirstName") != null) this.setFirstName(tuple.getString("Person_FirstName"));
			//set MidInitials
			if( strict || tuple.getString("MidInitials") != null) this.setMidInitials(tuple.getString("MidInitials"));
			if( tuple.getString("Person_MidInitials") != null) this.setMidInitials(tuple.getString("Person_MidInitials"));
			//set LastName
			if( strict || tuple.getString("LastName") != null) this.setLastName(tuple.getString("LastName"));
			if( tuple.getString("Person_LastName") != null) this.setLastName(tuple.getString("Person_LastName"));
			//set Title
			if( strict || tuple.getString("Title") != null) this.setTitle(tuple.getString("Title"));
			if( tuple.getString("Person_Title") != null) this.setTitle(tuple.getString("Person_Title"));
			//set Affiliation
			if( strict || tuple.getInt("Affiliation_id") != null) this.setAffiliation(tuple.getInt("Affiliation_id"));
			if( tuple.getInt("Person_Affiliation_id") != null) this.setAffiliation(tuple.getInt("Person_Affiliation_id"));
			//alias of xref
			if( tuple.getObject("Affiliation") != null) this.setAffiliation(tuple.getInt("Affiliation"));
			if( tuple.getObject("Person_Affiliation") != null) this.setAffiliation(tuple.getInt("Person_Affiliation"));
			//set label for field Affiliation
			if( strict || tuple.getObject("Affiliation_name") != null) this.setAffiliation_Name(tuple.getString("Affiliation_name"));			
			if( tuple.getObject("Person_Affiliation_name") != null ) this.setAffiliation_Name(tuple.getString("Person_Affiliation_name"));		
			//set Department
			if( strict || tuple.getString("Department") != null) this.setDepartment(tuple.getString("Department"));
			if( tuple.getString("Person_Department") != null) this.setDepartment(tuple.getString("Person_Department"));
			//set Roles
			if( strict || tuple.getInt("Roles_id") != null) this.setRoles(tuple.getInt("Roles_id"));
			if( tuple.getInt("Person_Roles_id") != null) this.setRoles(tuple.getInt("Person_Roles_id"));
			//alias of xref
			if( tuple.getObject("Roles") != null) this.setRoles(tuple.getInt("Roles"));
			if( tuple.getObject("Person_Roles") != null) this.setRoles(tuple.getInt("Person_Roles"));
			//set label for field Roles
			if( strict || tuple.getObject("Roles_name") != null) this.setRoles_Name(tuple.getString("Roles_name"));			
			if( tuple.getObject("Person_Roles_name") != null ) this.setRoles_Name(tuple.getString("Person_Roles_name"));		
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
		String result = "Person(";
		result+= "id='" + getId()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "address='" + getAddress()+"' ";	
		result+= "phone='" + getPhone()+"' ";	
		result+= "email='" + getEmail()+"' ";	
		result+= "fax='" + getFax()+"' ";	
		result+= "tollFreePhone='" + getTollFreePhone()+"' ";	
		result+= "city='" + getCity()+"' ";	
		result+= "country='" + getCountry()+"' ";	
		result+= "firstName='" + getFirstName()+"' ";	
		result+= "midInitials='" + getMidInitials()+"' ";	
		result+= "lastName='" + getLastName()+"' ";	
		result+= "title='" + getTitle()+"' ";	
		result+= " affiliation_id='" + getAffiliation_Id()+"' ";	
		result+= " affiliation_name='" + getAffiliation_Name()+"' ";
		result+= "department='" + getDepartment()+"' ";	
		result+= " roles_id='" + getRoles_Id()+"' ";	
		result+= " roles_name='" + getRoles_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Person.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("__Type");
		}
		{
			fields.add("name");
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
			fields.add("firstName");
		}
		{
			fields.add("midInitials");
		}
		{
			fields.add("lastName");
		}
		{
			fields.add("title");
		}
		{
			fields.add("affiliation_id");
		}
		fields.add("affiliation_name");
		{
			fields.add("department");
		}
		{
			fields.add("roles_id");
		}
		fields.add("roles_name");
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
		+ "__Type" +sep
		+ "name" +sep
		+ "address" +sep
		+ "phone" +sep
		+ "email" +sep
		+ "fax" +sep
		+ "tollFreePhone" +sep
		+ "city" +sep
		+ "country" +sep
		+ "firstName" +sep
		+ "midInitials" +sep
		+ "lastName" +sep
		+ "title" +sep
		+ "affiliation" +sep
		+ "department" +sep
		+ "roles" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("affiliation")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("roles")) {
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
		Person rhs = (Person) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
             	.appendSuper(super.equals(obj))
		//firstName
				.append(firstName, rhs.getFirstName())
		//midInitials
				.append(midInitials, rhs.getMidInitials())
		//lastName
				.append(lastName, rhs.getLastName())
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
             	.appendSuper(super.hashCode())
				.append(firstName)
				.append(midInitials)
				.append(lastName)
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
			Object valueO = get__Type();
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
			Object valueO = getFirstName();
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
			Object valueO = getMidInitials();
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
			Object valueO = getLastName();
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
			Object valueO = getTitle();
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
			Object valueO = getAffiliation();
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
			Object valueO = getDepartment();
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
			Object valueO = getRoles();
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
	public Person create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Person e = new Person();
		e.set(tuple);
		return e;
	}
	
//5
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="contact"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.protocol.Protocol> contactProtocolCollection = new java.util.ArrayList<org.molgenis.protocol.Protocol>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.protocol.Protocol> getContactProtocolCollection()
	{
            return contactProtocolCollection;
	}

    public void setContactProtocolCollection(java.util.Collection<org.molgenis.protocol.Protocol> collection)
    {
        for (org.molgenis.protocol.Protocol protocol : collection) {
            protocol.setContact(this);
        }
        contactProtocolCollection = collection;
    }	
	//5
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="contacts"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.organization.Investigation> contactsInvestigationCollection = new java.util.ArrayList<org.molgenis.organization.Investigation>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Investigation> getContactsInvestigationCollection()
	{
        return contactsInvestigationCollection;
	}

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.organization.Investigation> getContactsInvestigationCollection(org.molgenis.framework.db.Database db)
	{
        return getContactsInvestigationCollection();
	}

    public void setContactsInvestigationCollection(java.util.Collection<org.molgenis.organization.Investigation> collection)
    {
    	contactsInvestigationCollection.addAll(collection);
    }	
	//5
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="performer"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.protocol.ProtocolApplication> performerProtocolApplicationCollection = new java.util.ArrayList<org.molgenis.protocol.ProtocolApplication>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.protocol.ProtocolApplication> getPerformerProtocolApplicationCollection()
	{
        return performerProtocolApplicationCollection;
	}

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.protocol.ProtocolApplication> getPerformerProtocolApplicationCollection(org.molgenis.framework.db.Database db)
	{
        return getPerformerProtocolApplicationCollection();
	}

    public void setPerformerProtocolApplicationCollection(java.util.Collection<org.molgenis.protocol.ProtocolApplication> collection)
    {
    	performerProtocolApplicationCollection.addAll(collection);
    }	

	
}

