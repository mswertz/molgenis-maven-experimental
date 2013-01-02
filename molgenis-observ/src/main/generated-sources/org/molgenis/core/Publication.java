
/* File:        observ/model/Publication.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.core;

/**
 * Publication: 

				Publication is part of the Investigation package and is used to
				represent information about one or more publications related to an
				Investigation. The publication need not only be primary publication
				for an Investigation but may also represent other related
				information- though this use is less common. Publications have
				attributes of publications Authors and also DOI and Pubmed
				identifiers (when these are available). These are represented as
				OntologyTerms as in the MAGE-TAB model all 'xrefs' (cross
				references) for ontologies and accession numbers are handled
				generically. An example of a publication is available in an IDF file
				from ArrayExpress is experiment E-MTAB-506
				<a href="ftp://ftp.ebi.ac.uk/pub/databases/microarray/data/experiment/TABM/E-TABM-506/E-TABM-506.idf.txt">ftp://ftp.ebi.ac.uk/pub/databases/microarray/data/experiment/TABM/E-TABM-506/E-TABM-506.idf.txt
				</a>
				.
				<br/>
				The FuGE equivalent to Publication is FuGE::Bibliographic Reference.
			
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Publication", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "name" } ) }
)

@org.hibernate.annotations.Table(appliesTo="Publication", indexes={
    @org.hibernate.annotations.Index(name="Title", columnNames={
	"Title"
    })
})

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.core.db.PublicationEntityListener.class})
public class Publication extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Nameable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String NAME = "name";
	public final static String PUBMEDID = "PubmedID";
	public final static String PUBMEDID_NAME = "PubmedID_name";
	public final static String DOI = "DOI";
	public final static String DOI_NAME = "DOI_name";
	public final static String AUTHORLIST = "authorList";
	public final static String TITLE = "Title";
	public final static String STATUS = "Status";
	public final static String STATUS_NAME = "Status_name";
	public final static String YEAR = "Year";
	public final static String JOURNAL = "Journal";
	
	//static methods
	/**
	 * Shorthand for db.query(Publication.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Publication> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Publication.class);
	}
	
	/**
	 * Shorthand for db.find(Publication.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Publication> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Publication.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Publication findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Publication> q = db.query(Publication.class);
		q.eq(Publication.ID, id);
		java.util.List<Publication> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Publication findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Publication> q = db.query(Publication.class);
		q.eq(Publication.NAME, name);
		java.util.List<Publication> result = q.find();
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


	//Pubmed ID[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="PubmedID")   	
	
				

	private org.molgenis.core.OntologyTerm pubmedID = null;
	@javax.persistence.Transient
	private Integer pubmedID_id = null;	
	@javax.persistence.Transient
	private String pubmedID_name = null;						


	//Publication DOI[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="DOI")   	
	
				

	private org.molgenis.core.OntologyTerm dOI = null;
	@javax.persistence.Transient
	private Integer dOI_id = null;	
	@javax.persistence.Transient
	private String dOI_name = null;						


	//The names of the authors of the publication[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="authorList", length=16777216)
	
				

	private String authorList =  null;


	//The title of the Publication[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="Title", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="title")
	
				

	@javax.validation.constraints.NotNull
	private String title =  null;


	//The status of the Publication[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Status")   	
	
				

	private org.molgenis.core.OntologyTerm status = null;
	@javax.persistence.Transient
	private Integer status_id = null;	
	@javax.persistence.Transient
	private String status_name = null;						


	//The year of the Publication[type=string]
	@javax.persistence.Column(name="Year")
	@javax.xml.bind.annotation.XmlElement(name="year")
	
				

	private String year =  null;


	//The title of the Journal[type=string]
	@javax.persistence.Column(name="Journal")
	@javax.xml.bind.annotation.XmlElement(name="journal")
	
				

	private String journal =  null;

	//constructors
	public Publication()
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
	 * Get the Pubmed ID.
	 * @return pubmedID.
	 */
	public org.molgenis.core.OntologyTerm getPubmedID()
	{
		return this.pubmedID;
	}
	
	@Deprecated
	public org.molgenis.core.OntologyTerm getPubmedID(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Pubmed ID.
	 * @param pubmedID
	 */
	public void setPubmedID( org.molgenis.core.OntologyTerm pubmedID)
	{
		
		this.pubmedID = pubmedID;
	}

	
	
	/**
	 * Set foreign key for field pubmedID.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setPubmedID_Id(Integer pubmedID_id)
	{
		this.pubmedID_id = pubmedID_id;
	}	

	public void setPubmedID(Integer pubmedID_id)
	{
		this.pubmedID_id = pubmedID_id;
	}
	
	public Integer getPubmedID_Id()
	{
		
		if(pubmedID != null) 
		{
			return pubmedID.getId();
		}
		else
		{
			return pubmedID_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference PubmedID to OntologyTerm.Id.
	 */
	public String getPubmedID_Name()
	{		
		//FIXME should we auto-load based on getPubmedID()?	
		if(pubmedID != null) {
			return pubmedID.getName();
		} else {
			return pubmedID_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference PubmedID to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setPubmedID(null) until save
	 */
	public void setPubmedID_Name(String pubmedID_name)
	{
		this.pubmedID_name = pubmedID_name;
	}		
	 
	

	/**
	 * Get the Publication DOI.
	 * @return dOI.
	 */
	public org.molgenis.core.OntologyTerm getDOI()
	{
		return this.dOI;
	}
	
	@Deprecated
	public org.molgenis.core.OntologyTerm getDOI(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Publication DOI.
	 * @param dOI
	 */
	public void setDOI( org.molgenis.core.OntologyTerm dOI)
	{
		
		this.dOI = dOI;
	}

	
	
	/**
	 * Set foreign key for field dOI.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setDOI_Id(Integer dOI_id)
	{
		this.dOI_id = dOI_id;
	}	

	public void setDOI(Integer dOI_id)
	{
		this.dOI_id = dOI_id;
	}
	
	public Integer getDOI_Id()
	{
		
		if(dOI != null) 
		{
			return dOI.getId();
		}
		else
		{
			return dOI_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference DOI to OntologyTerm.Id.
	 */
	public String getDOI_Name()
	{		
		//FIXME should we auto-load based on getDOI()?	
		if(dOI != null) {
			return dOI.getName();
		} else {
			return dOI_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference DOI to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setDOI(null) until save
	 */
	public void setDOI_Name(String dOI_name)
	{
		this.dOI_name = dOI_name;
	}		
	 
	

	/**
	 * Get the The names of the authors of the publication.
	 * @return authorList.
	 */
	public String getAuthorList()
	{
		return this.authorList;
	}
	
	@Deprecated
	public String getAuthorList(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The names of the authors of the publication.
	 * @param authorList
	 */
	public void setAuthorList( String authorList)
	{
		
		this.authorList = authorList;
	}

	

	/**
	 * Get the The title of the Publication.
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
	 * Set the The title of the Publication.
	 * @param title
	 */
	public void setTitle( String title)
	{
		
		this.title = title;
	}

	

	/**
	 * Get the The status of the Publication.
	 * @return status.
	 */
	public org.molgenis.core.OntologyTerm getStatus()
	{
		return this.status;
	}
	
	@Deprecated
	public org.molgenis.core.OntologyTerm getStatus(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The status of the Publication.
	 * @param status
	 */
	public void setStatus( org.molgenis.core.OntologyTerm status)
	{
		
		this.status = status;
	}

	
	
	/**
	 * Set foreign key for field status.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setStatus_Id(Integer status_id)
	{
		this.status_id = status_id;
	}	

	public void setStatus(Integer status_id)
	{
		this.status_id = status_id;
	}
	
	public Integer getStatus_Id()
	{
		
		if(status != null) 
		{
			return status.getId();
		}
		else
		{
			return status_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Status to OntologyTerm.Id.
	 */
	public String getStatus_Name()
	{		
		//FIXME should we auto-load based on getStatus()?	
		if(status != null) {
			return status.getName();
		} else {
			return status_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Status to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setStatus(null) until save
	 */
	public void setStatus_Name(String status_name)
	{
		this.status_name = status_name;
	}		
	 
	

	/**
	 * Get the The year of the Publication.
	 * @return year.
	 */
	public String getYear()
	{
		return this.year;
	}
	
	@Deprecated
	public String getYear(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The year of the Publication.
	 * @param year
	 */
	public void setYear( String year)
	{
		
		this.year = year;
	}

	

	/**
	 * Get the The title of the Journal.
	 * @return journal.
	 */
	public String getJournal()
	{
		return this.journal;
	}
	
	@Deprecated
	public String getJournal(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The title of the Journal.
	 * @param journal
	 */
	public void setJournal( String journal)
	{
		
		this.journal = journal;
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
		if (name.toLowerCase().equals("pubmedid"))
			return getPubmedID();
		if(name.toLowerCase().equals("pubmedid_id"))
			return getPubmedID_Id();
		if(name.toLowerCase().equals("pubmedid_name"))
			return getPubmedID_Name();
		if (name.toLowerCase().equals("doi"))
			return getDOI();
		if(name.toLowerCase().equals("doi_id"))
			return getDOI_Id();
		if(name.toLowerCase().equals("doi_name"))
			return getDOI_Name();
		if (name.toLowerCase().equals("authorlist"))
			return getAuthorList();
		if (name.toLowerCase().equals("title"))
			return getTitle();
		if (name.toLowerCase().equals("status"))
			return getStatus();
		if(name.toLowerCase().equals("status_id"))
			return getStatus_Id();
		if(name.toLowerCase().equals("status_name"))
			return getStatus_Name();
		if (name.toLowerCase().equals("year"))
			return getYear();
		if (name.toLowerCase().equals("journal"))
			return getJournal();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.getTitle() == null) throw new org.molgenis.framework.db.DatabaseException("required field title is null");
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
			//set PubmedID
			this.setPubmedID(tuple.getInt("PubmedID"));
			//set label name for xref field PubmedID
			this.setPubmedID_Name(tuple.getString("PubmedID_name"));	
			//set DOI
			this.setDOI(tuple.getInt("DOI"));
			//set label name for xref field DOI
			this.setDOI_Name(tuple.getString("DOI_name"));	
			//set AuthorList
			this.setAuthorList(tuple.getString("authorList"));
			//set Title
			this.setTitle(tuple.getString("Title"));
			//set Status
			this.setStatus(tuple.getInt("Status"));
			//set label name for xref field Status
			this.setStatus_Name(tuple.getString("Status_name"));	
			//set Year
			this.setYear(tuple.getString("Year"));
			//set Journal
			this.setJournal(tuple.getString("Journal"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Publication_id") != null) this.setId(tuple.getInt("Publication_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("Publication_name") != null) this.setName(tuple.getString("Publication_name"));
			//set PubmedID
			if( strict || tuple.getInt("PubmedID_id") != null) this.setPubmedID(tuple.getInt("PubmedID_id"));
			if( tuple.getInt("Publication_PubmedID_id") != null) this.setPubmedID(tuple.getInt("Publication_PubmedID_id"));
			//alias of xref
			if( tuple.getObject("PubmedID") != null) this.setPubmedID(tuple.getInt("PubmedID"));
			if( tuple.getObject("Publication_PubmedID") != null) this.setPubmedID(tuple.getInt("Publication_PubmedID"));
			//set label for field PubmedID
			if( strict || tuple.getObject("PubmedID_name") != null) this.setPubmedID_Name(tuple.getString("PubmedID_name"));			
			if( tuple.getObject("Publication_PubmedID_name") != null ) this.setPubmedID_Name(tuple.getString("Publication_PubmedID_name"));		
			//set DOI
			if( strict || tuple.getInt("DOI_id") != null) this.setDOI(tuple.getInt("DOI_id"));
			if( tuple.getInt("Publication_DOI_id") != null) this.setDOI(tuple.getInt("Publication_DOI_id"));
			//alias of xref
			if( tuple.getObject("DOI") != null) this.setDOI(tuple.getInt("DOI"));
			if( tuple.getObject("Publication_DOI") != null) this.setDOI(tuple.getInt("Publication_DOI"));
			//set label for field DOI
			if( strict || tuple.getObject("DOI_name") != null) this.setDOI_Name(tuple.getString("DOI_name"));			
			if( tuple.getObject("Publication_DOI_name") != null ) this.setDOI_Name(tuple.getString("Publication_DOI_name"));		
			//set AuthorList
			if( strict || tuple.getString("authorList") != null) this.setAuthorList(tuple.getString("authorList"));
			if( tuple.getString("Publication_authorList") != null) this.setAuthorList(tuple.getString("Publication_authorList"));
			//set Title
			if( strict || tuple.getString("Title") != null) this.setTitle(tuple.getString("Title"));
			if( tuple.getString("Publication_Title") != null) this.setTitle(tuple.getString("Publication_Title"));
			//set Status
			if( strict || tuple.getInt("Status_id") != null) this.setStatus(tuple.getInt("Status_id"));
			if( tuple.getInt("Publication_Status_id") != null) this.setStatus(tuple.getInt("Publication_Status_id"));
			//alias of xref
			if( tuple.getObject("Status") != null) this.setStatus(tuple.getInt("Status"));
			if( tuple.getObject("Publication_Status") != null) this.setStatus(tuple.getInt("Publication_Status"));
			//set label for field Status
			if( strict || tuple.getObject("Status_name") != null) this.setStatus_Name(tuple.getString("Status_name"));			
			if( tuple.getObject("Publication_Status_name") != null ) this.setStatus_Name(tuple.getString("Publication_Status_name"));		
			//set Year
			if( strict || tuple.getString("Year") != null) this.setYear(tuple.getString("Year"));
			if( tuple.getString("Publication_Year") != null) this.setYear(tuple.getString("Publication_Year"));
			//set Journal
			if( strict || tuple.getString("Journal") != null) this.setJournal(tuple.getString("Journal"));
			if( tuple.getString("Publication_Journal") != null) this.setJournal(tuple.getString("Publication_Journal"));
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
		String result = "Publication(";
		result+= "id='" + getId()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= " pubmedID_id='" + getPubmedID_Id()+"' ";	
		result+= " pubmedID_name='" + getPubmedID_Name()+"' ";
		result+= " dOI_id='" + getDOI_Id()+"' ";	
		result+= " dOI_name='" + getDOI_Name()+"' ";
		result+= "authorList='" + getAuthorList()+"' ";	
		result+= "title='" + getTitle()+"' ";	
		result+= " status_id='" + getStatus_Id()+"' ";	
		result+= " status_name='" + getStatus_Name()+"' ";
		result+= "year='" + getYear()+"' ";	
		result+= "journal='" + getJournal()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Publication.
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
			fields.add("pubmedID_id");
		}
		fields.add("pubmedID_name");
		{
			fields.add("dOI_id");
		}
		fields.add("dOI_name");
		{
			fields.add("authorList");
		}
		{
			fields.add("title");
		}
		{
			fields.add("status_id");
		}
		fields.add("status_name");
		{
			fields.add("year");
		}
		{
			fields.add("journal");
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
		result.add("id");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "id" +sep
		+ "name" +sep
		+ "pubmedID" +sep
		+ "dOI" +sep
		+ "authorList" +sep
		+ "title" +sep
		+ "status" +sep
		+ "year" +sep
		+ "journal" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("pubmedID")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("dOI")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("status")) {
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
		Publication rhs = (Publication) obj;
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
			Object valueO = getPubmedID();
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
			Object valueO = getDOI();
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
			Object valueO = getAuthorList();
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
			Object valueO = getStatus();
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
			Object valueO = getYear();
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
			Object valueO = getJournal();
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
	public Publication create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Publication e = new Publication();
		e.set(tuple);
		return e;
	}
	

	
}

