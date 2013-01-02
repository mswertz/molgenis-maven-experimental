
/* File:        observ/model/MolgenisUser.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.auth;

/**
 * MolgenisUser: Anyone who can login
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "MolgenisUser"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.auth.db.MolgenisUserEntityListener.class})
public class MolgenisUser extends org.molgenis.auth.Person 
{
	// fieldname constants
	public final static String PASSWORD_ = "password_";
	public final static String ACTIVATIONCODE = "activationCode";
	public final static String ACTIVE = "active";
	public final static String SUPERUSER = "superuser";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(MolgenisUser.class).
	 */
	public static org.molgenis.framework.db.Query<? extends MolgenisUser> query(org.molgenis.framework.db.Database db)
	{
		return db.query(MolgenisUser.class);
	}
	
	/**
	 * Shorthand for db.find(MolgenisUser.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends MolgenisUser> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(MolgenisUser.class, rules);
	}	
	
	/**
	 * 
	 */
	public static MolgenisUser findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<MolgenisUser> q = db.query(MolgenisUser.class);
		q.eq(MolgenisUser.ID, id);
		java.util.List<MolgenisUser> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static MolgenisUser findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<MolgenisUser> q = db.query(MolgenisUser.class);
		q.eq(MolgenisUser.NAME, name);
		java.util.List<MolgenisUser> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static MolgenisUser findByFirstNameMidInitialsLastName(org.molgenis.framework.db.Database db, String firstName, String midInitials, String lastName) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<MolgenisUser> q = db.query(MolgenisUser.class);
		q.eq(MolgenisUser.FIRSTNAME, firstName);q.eq(MolgenisUser.MIDINITIALS, midInitials);q.eq(MolgenisUser.LASTNAME, lastName);
		java.util.List<MolgenisUser> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//big fixme: password type[type=string]
	@javax.persistence.Column(name="password_", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="password_")
	
				

	@javax.validation.constraints.NotNull
	private String password_ =  "secret";


	//Used as alternative authentication mechanism to verify user email and/or if user has lost password.[type=string]
	@javax.persistence.Column(name="activationCode")
	@javax.xml.bind.annotation.XmlElement(name="activationCode")
	
				

	private String activationCode =  null;


	//Boolean to indicate if this account can be used to login[type=bool]
	@javax.persistence.Column(name="active", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="active")
	
				

	@javax.validation.constraints.NotNull
	private Boolean active =  false;


	//superuser[type=bool]
	@javax.persistence.Column(name="superuser", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="superuser")
	
				

	@javax.validation.constraints.NotNull
	private Boolean superuser =  false;


	//automatically generated id[type=int]
	

	//constructors
	public MolgenisUser()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the big fixme: password type.
	 * @return password_.
	 */
	public String getPassword()
	{
		return this.password_;
	}
	
	@Deprecated
	public String getPassword(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the big fixme: password type.
	 * @param password_
	 */
	public void setPassword( String password_)
	{
		
		this.password_ = password_;
	}

	

	/**
	 * Get the Used as alternative authentication mechanism to verify user email and/or if user has lost password..
	 * @return activationCode.
	 */
	public String getActivationCode()
	{
		return this.activationCode;
	}
	
	@Deprecated
	public String getActivationCode(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Used as alternative authentication mechanism to verify user email and/or if user has lost password..
	 * @param activationCode
	 */
	public void setActivationCode( String activationCode)
	{
		
		this.activationCode = activationCode;
	}

	

	/**
	 * Get the Boolean to indicate if this account can be used to login.
	 * @return active.
	 */
	public Boolean getActive()
	{
		return this.active;
	}
	
	@Deprecated
	public Boolean getActive(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Boolean to indicate if this account can be used to login.
	 * @param active
	 */
	public void setActive( Boolean active)
	{
		
		this.active = active;
	}

	

	/**
	 * Get the superuser.
	 * @return superuser.
	 */
	public Boolean getSuperuser()
	{
		return this.superuser;
	}
	
	@Deprecated
	public Boolean getSuperuser(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the superuser.
	 * @param superuser
	 */
	public void setSuperuser( Boolean superuser)
	{
		
		this.superuser = superuser;
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
		if (name.toLowerCase().equals("password_"))
			return getPassword();
		if (name.toLowerCase().equals("activationcode"))
			return getActivationCode();
		if (name.toLowerCase().equals("active"))
			return getActive();
		if (name.toLowerCase().equals("superuser"))
			return getSuperuser();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.getPassword() == null) throw new org.molgenis.framework.db.DatabaseException("required field password_ is null");
		if(this.getActive() == null) throw new org.molgenis.framework.db.DatabaseException("required field active is null");
		if(this.getSuperuser() == null) throw new org.molgenis.framework.db.DatabaseException("required field superuser is null");
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
			//set Password
			this.setPassword(tuple.getString("password_"));
			//set ActivationCode
			this.setActivationCode(tuple.getString("activationCode"));
			//set Active
			this.setActive(tuple.getBoolean("active"));
			//set Superuser
			this.setSuperuser(tuple.getBoolean("superuser"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("MolgenisUser_id") != null) this.setId(tuple.getInt("MolgenisUser_id"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("MolgenisUser___Type") != null) this.set__Type(tuple.getString("MolgenisUser___Type"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("MolgenisUser_name") != null) this.setName(tuple.getString("MolgenisUser_name"));
			//set Address
			if( strict || tuple.getString("Address") != null) this.setAddress(tuple.getString("Address"));
			if( tuple.getString("MolgenisUser_Address") != null) this.setAddress(tuple.getString("MolgenisUser_Address"));
			//set Phone
			if( strict || tuple.getString("Phone") != null) this.setPhone(tuple.getString("Phone"));
			if( tuple.getString("MolgenisUser_Phone") != null) this.setPhone(tuple.getString("MolgenisUser_Phone"));
			//set Email
			if( strict || tuple.getString("Email") != null) this.setEmail(tuple.getString("Email"));
			if( tuple.getString("MolgenisUser_Email") != null) this.setEmail(tuple.getString("MolgenisUser_Email"));
			//set Fax
			if( strict || tuple.getString("Fax") != null) this.setFax(tuple.getString("Fax"));
			if( tuple.getString("MolgenisUser_Fax") != null) this.setFax(tuple.getString("MolgenisUser_Fax"));
			//set TollFreePhone
			if( strict || tuple.getString("tollFreePhone") != null) this.setTollFreePhone(tuple.getString("tollFreePhone"));
			if( tuple.getString("MolgenisUser_tollFreePhone") != null) this.setTollFreePhone(tuple.getString("MolgenisUser_tollFreePhone"));
			//set City
			if( strict || tuple.getString("City") != null) this.setCity(tuple.getString("City"));
			if( tuple.getString("MolgenisUser_City") != null) this.setCity(tuple.getString("MolgenisUser_City"));
			//set Country
			if( strict || tuple.getString("Country") != null) this.setCountry(tuple.getString("Country"));
			if( tuple.getString("MolgenisUser_Country") != null) this.setCountry(tuple.getString("MolgenisUser_Country"));
			//set FirstName
			if( strict || tuple.getString("FirstName") != null) this.setFirstName(tuple.getString("FirstName"));
			if( tuple.getString("MolgenisUser_FirstName") != null) this.setFirstName(tuple.getString("MolgenisUser_FirstName"));
			//set MidInitials
			if( strict || tuple.getString("MidInitials") != null) this.setMidInitials(tuple.getString("MidInitials"));
			if( tuple.getString("MolgenisUser_MidInitials") != null) this.setMidInitials(tuple.getString("MolgenisUser_MidInitials"));
			//set LastName
			if( strict || tuple.getString("LastName") != null) this.setLastName(tuple.getString("LastName"));
			if( tuple.getString("MolgenisUser_LastName") != null) this.setLastName(tuple.getString("MolgenisUser_LastName"));
			//set Title
			if( strict || tuple.getString("Title") != null) this.setTitle(tuple.getString("Title"));
			if( tuple.getString("MolgenisUser_Title") != null) this.setTitle(tuple.getString("MolgenisUser_Title"));
			//set Affiliation
			if( strict || tuple.getInt("Affiliation_id") != null) this.setAffiliation(tuple.getInt("Affiliation_id"));
			if( tuple.getInt("MolgenisUser_Affiliation_id") != null) this.setAffiliation(tuple.getInt("MolgenisUser_Affiliation_id"));
			//alias of xref
			if( tuple.getObject("Affiliation") != null) this.setAffiliation(tuple.getInt("Affiliation"));
			if( tuple.getObject("MolgenisUser_Affiliation") != null) this.setAffiliation(tuple.getInt("MolgenisUser_Affiliation"));
			//set label for field Affiliation
			if( strict || tuple.getObject("Affiliation_name") != null) this.setAffiliation_Name(tuple.getString("Affiliation_name"));			
			if( tuple.getObject("MolgenisUser_Affiliation_name") != null ) this.setAffiliation_Name(tuple.getString("MolgenisUser_Affiliation_name"));		
			//set Department
			if( strict || tuple.getString("Department") != null) this.setDepartment(tuple.getString("Department"));
			if( tuple.getString("MolgenisUser_Department") != null) this.setDepartment(tuple.getString("MolgenisUser_Department"));
			//set Roles
			if( strict || tuple.getInt("Roles_id") != null) this.setRoles(tuple.getInt("Roles_id"));
			if( tuple.getInt("MolgenisUser_Roles_id") != null) this.setRoles(tuple.getInt("MolgenisUser_Roles_id"));
			//alias of xref
			if( tuple.getObject("Roles") != null) this.setRoles(tuple.getInt("Roles"));
			if( tuple.getObject("MolgenisUser_Roles") != null) this.setRoles(tuple.getInt("MolgenisUser_Roles"));
			//set label for field Roles
			if( strict || tuple.getObject("Roles_name") != null) this.setRoles_Name(tuple.getString("Roles_name"));			
			if( tuple.getObject("MolgenisUser_Roles_name") != null ) this.setRoles_Name(tuple.getString("MolgenisUser_Roles_name"));		
			//set Password
			if( strict || tuple.getString("password_") != null) this.setPassword(tuple.getString("password_"));
			if( tuple.getString("MolgenisUser_password_") != null) this.setPassword(tuple.getString("MolgenisUser_password_"));
			//set ActivationCode
			if( strict || tuple.getString("activationCode") != null) this.setActivationCode(tuple.getString("activationCode"));
			if( tuple.getString("MolgenisUser_activationCode") != null) this.setActivationCode(tuple.getString("MolgenisUser_activationCode"));
			//set Active
			if( strict || tuple.getBoolean("active") != null) this.setActive(tuple.getBoolean("active"));
			if( tuple.getBoolean("MolgenisUser_active") != null) this.setActive(tuple.getBoolean("MolgenisUser_active"));
			//set Superuser
			if( strict || tuple.getBoolean("superuser") != null) this.setSuperuser(tuple.getBoolean("superuser"));
			if( tuple.getBoolean("MolgenisUser_superuser") != null) this.setSuperuser(tuple.getBoolean("MolgenisUser_superuser"));
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
		String result = "MolgenisUser(";
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
		result+= "password_='" + getPassword()+"' ";	
		result+= "activationCode='" + getActivationCode()+"' ";	
		result+= "active='" + getActive()+"' ";	
		result+= "superuser='" + getSuperuser()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of MolgenisUser.
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
		{
			fields.add("password_");
		}
		{
			fields.add("activationCode");
		}
		{
			fields.add("active");
		}
		{
			fields.add("superuser");
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
		+ "roles" +sep
		+ "password_" +sep
		+ "activationCode" +sep
		+ "active" +sep
		+ "superuser" 
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
		MolgenisUser rhs = (MolgenisUser) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
             	.appendSuper(super.equals(obj))
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
			out.write(valueS+sep);
		}
		{
			Object valueO = getPassword();
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
			Object valueO = getActivationCode();
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
			Object valueO = getActive();
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
			Object valueO = getSuperuser();
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
	public MolgenisUser create(org.molgenis.util.Tuple tuple) throws Exception
	{
		MolgenisUser e = new MolgenisUser();
		e.set(tuple);
		return e;
	}
	

	
}

