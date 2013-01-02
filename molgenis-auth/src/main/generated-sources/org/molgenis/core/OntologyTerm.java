
/* File:        auth/model/OntologyTerm.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.core;

/**
 * OntologyTerm: 
				OntologyTerm defines a single entry (term) from an ontology or a
				controlled vocabulary (defined by Ontology). The name is the
				ontology term which is unique within an ontology source, such as
				[examples here]. Other data entities can reference to this
				OntologyTerm to harmonize naming of concepts. Each term should have
				a local, unique label within the Investigation. If no suitable
				ontology term exists then one can define new terms locally (in which
				case there is no formal accession for the term limiting its use for
				cross-Investigation queries). In those cases the local name should
				be repeated in both term and termAccession. Maps to
				FuGE::OntologyIndividual; in MAGE-TAB there is no separate entity to
				model terms.
				<br/>
				Optionally a local controlled vocabulary or ontology can be defined,
				for example to represent 'Codelists' often used in questionaires.
				Note: this is not a InvestigationElement because of the additional
				xref_label and unique constraint.This class defines a single entry
				from an ontology or a controlled vocabulary.
				<br/>
				If it is a simple controlled vocabulary, there may be no formal
				accession for the term. In these cases the local name should be
				repeated in both term and termAccession. If the term has a value,
				the OntologyTerm will have a single DataProperty whose value was the
				value for the property. For instance, for an OntologyIndividual
				based on the MO ontology the attributes might be: The term would be
				what is usually called the local name in the Ontology, for instance
				'Age'; The termAccession could be
				'http://mged.sourceforge.net/ontologies/MGEDOntology.owl#Age' or a
				an arbitrary accession if one exists; The identifier is a unique
				identifier for individuals in the scope of the FuGE instance; The
				inherited name attribute should not be used; The ontologyURI of
				OntologySource could be
				'http://mged.sourceforge.net/ontologies/MGEDOntology.owl". The
				OntologyTerm subclasses are instances of Ontology classes and
				properties, not the actual terms themselves. An OntologyIndividual,
				if based on an existing Ontology, can be considered a statement that
				can be validated against the referenced ontology. The subclasses and
				their associations are based on the Ontology Definition Model,
				ad/2005-04-13, submitted to the OMG as a response to RFP
				ad/2003-03-40, Copyright 2005 DSTC Pty Ltd. Copyright 2005 IBM
				Copyright 2005 Sandpiper Software, Inc under the standard OMG
				license terms. 
			
.
 * @version October 22, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "OntologyTerm", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "ontology", "termAccession" }), @javax.persistence.UniqueConstraint( columnNames={ "ontology", "name" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.core.db.OntologyTermEntityListener.class})
public class OntologyTerm extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Nameable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String NAME = "name";
	public final static String ONTOLOGY = "ontology";
	public final static String ONTOLOGY_NAME = "ontology_name";
	public final static String TERMACCESSION = "termAccession";
	public final static String DEFINITION = "definition";
	public final static String TERMPATH = "termPath";
	
	//static methods
	/**
	 * Shorthand for db.query(OntologyTerm.class).
	 */
	public static org.molgenis.framework.db.Query<? extends OntologyTerm> query(org.molgenis.framework.db.Database db)
	{
		return db.query(OntologyTerm.class);
	}
	
	/**
	 * Shorthand for db.find(OntologyTerm.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends OntologyTerm> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(OntologyTerm.class, rules);
	}	
	
	/**
	 * 
	 */
	public static OntologyTerm findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<OntologyTerm> q = db.query(OntologyTerm.class);
		q.eq(OntologyTerm.ID, id);
		java.util.List<OntologyTerm> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static OntologyTerm findByOntologyTermAccession(org.molgenis.framework.db.Database db, Integer ontology, String termAccession) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<OntologyTerm> q = db.query(OntologyTerm.class);
		q.eq(OntologyTerm.ONTOLOGY, ontology);q.eq(OntologyTerm.TERMACCESSION, termAccession);
		java.util.List<OntologyTerm> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static OntologyTerm findByOntologyName(org.molgenis.framework.db.Database db, Integer ontology, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<OntologyTerm> q = db.query(OntologyTerm.class);
		q.eq(OntologyTerm.ONTOLOGY, ontology);q.eq(OntologyTerm.NAME, name);
		java.util.List<OntologyTerm> result = q.find();
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


	//(Optional) The source ontology or controlled vocabulary list that ontology terms have been obtained from.[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="ontology")   	
	
				

	private org.molgenis.core.Ontology ontology = null;
	@javax.persistence.Transient
	private Integer ontology_id = null;	
	@javax.persistence.Transient
	private String ontology_name = null;						


	//(Optional) The accession number assigned to the ontology term in its source ontology. If empty it is assumed to be a locally defined term.[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="termAccession")
	@javax.xml.bind.annotation.XmlElement(name="termAccession")
	
				

	private String termAccession =  null;


	//(Optional) The definition of the term.[type=string]
	@javax.persistence.Column(name="definition")
	@javax.xml.bind.annotation.XmlElement(name="definition")
	
				

	private String definition =  null;


	//EXTENSION. The Ontology Lookup Service path that contains this term.[type=string]
	@javax.persistence.Column(name="termPath")
	@javax.xml.bind.annotation.XmlElement(name="termPath")
	
				

	private String termPath =  null;

	//constructors
	public OntologyTerm()
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
	 * Get the (Optional) The source ontology or controlled vocabulary list that ontology terms have been obtained from..
	 * @return ontology.
	 */
	public org.molgenis.core.Ontology getOntology()
	{
		return this.ontology;
	}
	
	@Deprecated
	public org.molgenis.core.Ontology getOntology(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) The source ontology or controlled vocabulary list that ontology terms have been obtained from..
	 * @param ontology
	 */
	public void setOntology( org.molgenis.core.Ontology ontology)
	{
		
		this.ontology = ontology;
	}

	
	
	/**
	 * Set foreign key for field ontology.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setOntology_Id(Integer ontology_id)
	{
		this.ontology_id = ontology_id;
	}	

	public void setOntology(Integer ontology_id)
	{
		this.ontology_id = ontology_id;
	}
	
	public Integer getOntology_Id()
	{
		
		if(ontology != null) 
		{
			return ontology.getId();
		}
		else
		{
			return ontology_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Ontology to Ontology.Id.
	 */
	public String getOntology_Name()
	{		
		//FIXME should we auto-load based on getOntology()?	
		if(ontology != null) {
			return ontology.getName();
		} else {
			return ontology_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Ontology to <a href="Ontology.html#Id">Ontology.Id</a>.
	 * Implies setOntology(null) until save
	 */
	public void setOntology_Name(String ontology_name)
	{
		this.ontology_name = ontology_name;
	}		
	 
	

	/**
	 * Get the (Optional) The accession number assigned to the ontology term in its source ontology. If empty it is assumed to be a locally defined term..
	 * @return termAccession.
	 */
	public String getTermAccession()
	{
		return this.termAccession;
	}
	
	@Deprecated
	public String getTermAccession(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) The accession number assigned to the ontology term in its source ontology. If empty it is assumed to be a locally defined term..
	 * @param termAccession
	 */
	public void setTermAccession( String termAccession)
	{
		
		this.termAccession = termAccession;
	}

	

	/**
	 * Get the (Optional) The definition of the term..
	 * @return definition.
	 */
	public String getDefinition()
	{
		return this.definition;
	}
	
	@Deprecated
	public String getDefinition(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) The definition of the term..
	 * @param definition
	 */
	public void setDefinition( String definition)
	{
		
		this.definition = definition;
	}

	

	/**
	 * Get the EXTENSION. The Ontology Lookup Service path that contains this term..
	 * @return termPath.
	 */
	public String getTermPath()
	{
		return this.termPath;
	}
	
	@Deprecated
	public String getTermPath(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the EXTENSION. The Ontology Lookup Service path that contains this term..
	 * @param termPath
	 */
	public void setTermPath( String termPath)
	{
		
		this.termPath = termPath;
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
		if (name.toLowerCase().equals("ontology"))
			return getOntology();
		if(name.toLowerCase().equals("ontology_id"))
			return getOntology_Id();
		if(name.toLowerCase().equals("ontology_name"))
			return getOntology_Name();
		if (name.toLowerCase().equals("termaccession"))
			return getTermAccession();
		if (name.toLowerCase().equals("definition"))
			return getDefinition();
		if (name.toLowerCase().equals("termpath"))
			return getTermPath();
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
			//set Ontology
			this.setOntology(tuple.getInt("ontology"));
			//set label name for xref field Ontology
			this.setOntology_Name(tuple.getString("ontology_name"));	
			//set TermAccession
			this.setTermAccession(tuple.getString("termAccession"));
			//set Definition
			this.setDefinition(tuple.getString("definition"));
			//set TermPath
			this.setTermPath(tuple.getString("termPath"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("OntologyTerm_id") != null) this.setId(tuple.getInt("OntologyTerm_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("OntologyTerm_name") != null) this.setName(tuple.getString("OntologyTerm_name"));
			//set Ontology
			if( strict || tuple.getInt("ontology_id") != null) this.setOntology(tuple.getInt("ontology_id"));
			if( tuple.getInt("OntologyTerm_ontology_id") != null) this.setOntology(tuple.getInt("OntologyTerm_ontology_id"));
			//alias of xref
			if( tuple.getObject("ontology") != null) this.setOntology(tuple.getInt("ontology"));
			if( tuple.getObject("OntologyTerm_ontology") != null) this.setOntology(tuple.getInt("OntologyTerm_ontology"));
			//set label for field Ontology
			if( strict || tuple.getObject("ontology_name") != null) this.setOntology_Name(tuple.getString("ontology_name"));			
			if( tuple.getObject("OntologyTerm_ontology_name") != null ) this.setOntology_Name(tuple.getString("OntologyTerm_ontology_name"));		
			//set TermAccession
			if( strict || tuple.getString("termAccession") != null) this.setTermAccession(tuple.getString("termAccession"));
			if( tuple.getString("OntologyTerm_termAccession") != null) this.setTermAccession(tuple.getString("OntologyTerm_termAccession"));
			//set Definition
			if( strict || tuple.getString("definition") != null) this.setDefinition(tuple.getString("definition"));
			if( tuple.getString("OntologyTerm_definition") != null) this.setDefinition(tuple.getString("OntologyTerm_definition"));
			//set TermPath
			if( strict || tuple.getString("termPath") != null) this.setTermPath(tuple.getString("termPath"));
			if( tuple.getString("OntologyTerm_termPath") != null) this.setTermPath(tuple.getString("OntologyTerm_termPath"));
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
		String result = "OntologyTerm(";
		result+= "id='" + getId()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= " ontology_id='" + getOntology_Id()+"' ";	
		result+= " ontology_name='" + getOntology_Name()+"' ";
		result+= "termAccession='" + getTermAccession()+"' ";	
		result+= "definition='" + getDefinition()+"' ";	
		result+= "termPath='" + getTermPath()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of OntologyTerm.
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
			fields.add("ontology_id");
		}
		fields.add("ontology_name");
		{
			fields.add("termAccession");
		}
		{
			fields.add("definition");
		}
		{
			fields.add("termPath");
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
		+ "ontology" +sep
		+ "termAccession" +sep
		+ "definition" +sep
		+ "termPath" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("ontology")) {
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
		OntologyTerm rhs = (OntologyTerm) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//ontology
		//termAccession
				.append(termAccession, rhs.getTermAccession())
		//ontology
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
				.append(termAccession)
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
			Object valueO = getOntology();
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
			Object valueO = getTermAccession();
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
			Object valueO = getDefinition();
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
			Object valueO = getTermPath();
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
	public OntologyTerm create(org.molgenis.util.Tuple tuple) throws Exception
	{
		OntologyTerm e = new OntologyTerm();
		e.set(tuple);
		return e;
	}
	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="roles"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.auth.Person> rolesPersonCollection = new java.util.ArrayList<org.molgenis.auth.Person>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.auth.Person> getRolesPersonCollection()
	{
            return rolesPersonCollection;
	}

    public void setRolesPersonCollection(java.util.Collection<org.molgenis.auth.Person> collection)
    {
        for (org.molgenis.auth.Person person : collection) {
            person.setRoles(this);
        }
        rolesPersonCollection = collection;
    }	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="pubmedID"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.core.Publication> pubmedIDPublicationCollection = new java.util.ArrayList<org.molgenis.core.Publication>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.core.Publication> getPubmedIDPublicationCollection()
	{
            return pubmedIDPublicationCollection;
	}

    public void setPubmedIDPublicationCollection(java.util.Collection<org.molgenis.core.Publication> collection)
    {
        for (org.molgenis.core.Publication publication : collection) {
            publication.setPubmedID(this);
        }
        pubmedIDPublicationCollection = collection;
    }	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="dOI"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.core.Publication> dOIPublicationCollection = new java.util.ArrayList<org.molgenis.core.Publication>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.core.Publication> getDOIPublicationCollection()
	{
            return dOIPublicationCollection;
	}

    public void setDOIPublicationCollection(java.util.Collection<org.molgenis.core.Publication> collection)
    {
        for (org.molgenis.core.Publication publication : collection) {
            publication.setDOI(this);
        }
        dOIPublicationCollection = collection;
    }	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="status"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.core.Publication> statusPublicationCollection = new java.util.ArrayList<org.molgenis.core.Publication>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.core.Publication> getStatusPublicationCollection()
	{
            return statusPublicationCollection;
	}

    public void setStatusPublicationCollection(java.util.Collection<org.molgenis.core.Publication> collection)
    {
        for (org.molgenis.core.Publication publication : collection) {
            publication.setStatus(this);
        }
        statusPublicationCollection = collection;
    }	

	
}

