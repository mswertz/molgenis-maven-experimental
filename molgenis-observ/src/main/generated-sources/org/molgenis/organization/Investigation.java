
/* File:        observ/model/Investigation.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.organization;

/**
 * Investigation: Investigation defines self-contained units of study. For
				example: Framingham study. Optionally a description and an accession
				to a data source can be provided. Each Investigation has a unique
				name and a group of subjects of observation (ObservableTarget),
				traits of observation (ObservableFeature), results (in
				ObservedValues), and optionally actions (Protocols,
				ProtoclApplications). 'Invetigation' maps to standard XGAP/FuGE
				Investigation, MAGE-TAB Experiment and METABASE:Study.
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Investigation", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "name" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.organization.db.InvestigationEntityListener.class})
public class Investigation extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Nameable, org.molgenis.core.Describable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String NAME = "name";
	public final static String DESCRIPTION = "description";
	public final static String STARTDATE = "startDate";
	public final static String ENDDATE = "endDate";
	public final static String CONTACTS = "contacts";
	public final static String CONTACTS_NAME = "contacts_name";
	public final static String ACCESSION = "accession";
	
	//static methods
	/**
	 * Shorthand for db.query(Investigation.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Investigation> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Investigation.class);
	}
	
	/**
	 * Shorthand for db.find(Investigation.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Investigation> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Investigation.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Investigation findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Investigation> q = db.query(Investigation.class);
		q.eq(Investigation.ID, id);
		java.util.List<Investigation> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Investigation findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Investigation> q = db.query(Investigation.class);
		q.eq(Investigation.NAME, name);
		java.util.List<Investigation> result = q.find();
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


	//human-readable name.[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="name", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="name")
	
				

	@javax.validation.constraints.NotNull
	private String name =  null;


	//description field[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="description", length=16777216)
	
				

	private String description =  null;


	//The start point of the study.[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="startDate")
	@javax.xml.bind.annotation.XmlElement(name="startDate")
	
				

	private java.util.Date startDate =  new java.sql.Date(new java.util.Date().getTime());


	//The end point of the study.[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="endDate")
	@javax.xml.bind.annotation.XmlElement(name="endDate")
	
				

	private java.util.Date endDate =  null;


	//Contact persons for this study[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="contacts", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="Investigation_contacts", 
			joinColumns=@javax.persistence.JoinColumn(name="Investigation"), inverseJoinColumns=@javax.persistence.JoinColumn(name="contacts"))
	
				

	private java.util.List<org.molgenis.auth.Person> contacts = new java.util.ArrayList<org.molgenis.auth.Person>();
	@javax.persistence.Transient
	private java.util.List<Integer> contacts_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> contacts_name = new java.util.ArrayList<String>();


	//(Optional) URI or accession number to indicate source of Study. E.g. arrayexpress:M-EXP-2345[type=hyperlink]
	@javax.persistence.Column(name="accession")
	@javax.xml.bind.annotation.XmlElement(name="accession")
	
				

	private String accession =  null;

	//constructors
	public Investigation()
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
	 * Get the human-readable name..
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
	 * Set the human-readable name..
	 * @param name
	 */
	public void setName( String name)
	{
		
		this.name = name;
	}

	

	/**
	 * Get the description field.
	 * @return description.
	 */
	public String getDescription()
	{
		return this.description;
	}
	
	@Deprecated
	public String getDescription(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the description field.
	 * @param description
	 */
	public void setDescription( String description)
	{
		
		this.description = description;
	}

	

	/**
	 * Get the The start point of the study..
	 * @return startDate.
	 */
	public java.util.Date getStartDate()
	{
		return this.startDate;
	}
	
	@Deprecated
	public java.util.Date getStartDate(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The start point of the study..
	 * @param startDate
	 */
	public void setStartDate( java.util.Date startDate)
	{
		
		this.startDate = startDate;
	}

	

	/**
	 * Get the The end point of the study..
	 * @return endDate.
	 */
	public java.util.Date getEndDate()
	{
		return this.endDate;
	}
	
	@Deprecated
	public java.util.Date getEndDate(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The end point of the study..
	 * @param endDate
	 */
	public void setEndDate( java.util.Date endDate)
	{
		
		this.endDate = endDate;
	}

	

	/**
	 * Get the Contact persons for this study.
	 * @return contacts.
	 */
	public java.util.List<org.molgenis.auth.Person> getContacts()
	{
		return this.contacts;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.auth.Person> getContacts(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Contact persons for this study.
	 * @param contacts
	 */
	public void setContacts( java.util.List<org.molgenis.auth.Person> contacts)
	{
		
		this.contacts = contacts;
	}

	
	public void setContacts_Id(Integer ... contacts)
	{
		this.setContacts_Id(java.util.Arrays.asList(contacts));
	}	
	
	public void setContacts(org.molgenis.auth.Person ... contacts)
	{
		this.setContacts(java.util.Arrays.asList(contacts));
	}	
	
	/**
	 * Set foreign key for field contacts.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setContacts_Id(java.util.List<Integer> contacts_id)
	{
		this.contacts_id = contacts_id;
	}	
	
	public java.util.List<Integer> getContacts_Id()
	{
		return contacts_id;
	}	
	
	/**
	 * Get a pretty label for cross reference Contacts to <a href="Person.html#Id">Person.Id</a>.
	 */
	public java.util.List<String> getContacts_Name()
	{
		return contacts_name;
	}
	
	/**
	 * Update the foreign key Contacts
	 * This sets contacts to null until next database transaction.
	 */
	public void setContacts_Name(java.util.List<String> contacts_name)
	{
		this.contacts_name = contacts_name;
	}		
	

	/**
	 * Get the (Optional) URI or accession number to indicate source of Study. E.g. arrayexpress:M-EXP-2345.
	 * @return accession.
	 */
	public String getAccession()
	{
		return this.accession;
	}
	
	@Deprecated
	public String getAccession(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) URI or accession number to indicate source of Study. E.g. arrayexpress:M-EXP-2345.
	 * @param accession
	 */
	public void setAccession( String accession)
	{
		
		this.accession = accession;
	}

	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("name"))
			return getName();
		if (name.toLowerCase().equals("description"))
			return getDescription();
		if (name.toLowerCase().equals("startdate"))
			return getStartDate();
		if (name.toLowerCase().equals("enddate"))
			return getEndDate();
		if (name.toLowerCase().equals("contacts"))
			return getContacts();
		if(name.toLowerCase().equals("contacts_id"))
			return getContacts_Id();
		if(name.toLowerCase().equals("contacts_name"))
			return getContacts_Name();
		if (name.toLowerCase().equals("accession"))
			return getAccession();
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
			//set Name
			this.setName(tuple.getString("name"));
			//set Description
			this.setDescription(tuple.getString("description"));
			//set StartDate
			this.setStartDate(tuple.getTimestamp("startDate"));
			//set EndDate
			this.setEndDate(tuple.getTimestamp("endDate"));
			//mrefs can not be directly retrieved
			//set Contacts			
			//set Accession
			this.setAccession(tuple.getString("accession"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Investigation_id") != null) this.setId(tuple.getInt("Investigation_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("Investigation_name") != null) this.setName(tuple.getString("Investigation_name"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Investigation_description") != null) this.setDescription(tuple.getString("Investigation_description"));
			//set StartDate
			if( strict || tuple.getTimestamp("startDate") != null) this.setStartDate(tuple.getTimestamp("startDate"));
			if( tuple.getTimestamp("Investigation_startDate") != null) this.setStartDate(tuple.getTimestamp("Investigation_startDate"));
			//set EndDate
			if( strict || tuple.getTimestamp("endDate") != null) this.setEndDate(tuple.getTimestamp("endDate"));
			if( tuple.getTimestamp("Investigation_endDate") != null) this.setEndDate(tuple.getTimestamp("Investigation_endDate"));
			//set Contacts
			if( tuple.getObject("contacts")!= null || tuple.getObject("Investigation_contacts")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("contacts");
				if(tuple.getObject("Investigation_contacts")!= null) mrefs = tuple.getList("Investigation_contacts");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setContacts_Id( values );
			}
			//set labels name for mref field Contacts	
			if( tuple.getObject("contacts_name")!= null || tuple.getObject("Investigation_contacts_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("contacts_name");
				if(tuple.getObject("Investigation_contacts_name")!= null) mrefs = tuple.getList("Investigation_contacts_name");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setContacts_Name( values );			
			}	
			//set Accession
			if( strict || tuple.getString("accession") != null) this.setAccession(tuple.getString("accession"));
			if( tuple.getString("Investigation_accession") != null) this.setAccession(tuple.getString("Investigation_accession"));
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
		String result = "Investigation(";
		result+= "id='" + getId()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= "startDate='" + (getStartDate() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getStartDate()))+"' ";
		result+= "startDate='" + (getStartDate() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getStartDate()))+"' ";		
		result+= "endDate='" + (getEndDate() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getEndDate()))+"' ";
		result+= "endDate='" + (getEndDate() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getEndDate()))+"' ";		
		result+= " contacts_id='" + getContacts_Id()+"' ";	
		result+= " contacts_name='" + getContacts_Name()+"' ";
		result+= "accession='" + getAccession()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Investigation.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("name");
		}
		{
			fields.add("description");
		}
		{
			fields.add("startDate");
		}
		{
			fields.add("endDate");
		}
		{
			fields.add("contacts_id");
		}
		fields.add("contacts_name");
		{
			fields.add("accession");
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
		+ "name" +sep
		+ "description" +sep
		+ "startDate" +sep
		+ "endDate" +sep
		+ "contacts" +sep
		+ "accession" 
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
        
        return null;
    }	

	@Override
	public boolean equals(Object obj) {
   		if (obj == null) { return false; }
   		if (obj == this) { return true; }
   		if (obj.getClass() != getClass()) {
     		return false;
   		}
		Investigation rhs = (Investigation) obj;
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
			Object valueO = getDescription();
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
			Object valueO = getStartDate();
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
			Object valueO = getEndDate();
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
			Object valueO = getAccession();
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
	public Investigation create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Investigation e = new Investigation();
		e.set(tuple);
		return e;
	}
	
//7
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="investigation"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.pheno.ObservationElement> investigationObservationElementCollection = new java.util.ArrayList<org.molgenis.pheno.ObservationElement>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.ObservationElement> getInvestigationObservationElementCollection()
	{
            return investigationObservationElementCollection;
	}

    public void setInvestigationObservationElementCollection(java.util.Collection<org.molgenis.pheno.ObservationElement> collection)
    {
        for (org.molgenis.pheno.ObservationElement observationElement : collection) {
            observationElement.setInvestigation(this);
        }
        investigationObservationElementCollection = collection;
    }	
//7
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="investigation"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.pheno.ObservedValue> investigationObservedValueCollection = new java.util.ArrayList<org.molgenis.pheno.ObservedValue>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.ObservedValue> getInvestigationObservedValueCollection()
	{
            return investigationObservedValueCollection;
	}

    public void setInvestigationObservedValueCollection(java.util.Collection<org.molgenis.pheno.ObservedValue> collection)
    {
        for (org.molgenis.pheno.ObservedValue observedValue : collection) {
            observedValue.setInvestigation(this);
        }
        investigationObservedValueCollection = collection;
    }	
//7
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="investigation"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.protocol.Protocol> investigationProtocolCollection = new java.util.ArrayList<org.molgenis.protocol.Protocol>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.protocol.Protocol> getInvestigationProtocolCollection()
	{
            return investigationProtocolCollection;
	}

    public void setInvestigationProtocolCollection(java.util.Collection<org.molgenis.protocol.Protocol> collection)
    {
        for (org.molgenis.protocol.Protocol protocol : collection) {
            protocol.setInvestigation(this);
        }
        investigationProtocolCollection = collection;
    }	
//7
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="investigation"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.protocol.ProtocolApplication> investigationProtocolApplicationCollection = new java.util.ArrayList<org.molgenis.protocol.ProtocolApplication>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.protocol.ProtocolApplication> getInvestigationProtocolApplicationCollection()
	{
            return investigationProtocolApplicationCollection;
	}

    public void setInvestigationProtocolApplicationCollection(java.util.Collection<org.molgenis.protocol.ProtocolApplication> collection)
    {
        for (org.molgenis.protocol.ProtocolApplication protocolApplication : collection) {
            protocolApplication.setInvestigation(this);
        }
        investigationProtocolApplicationCollection = collection;
    }	

	
}

