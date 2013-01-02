
/* File:        observ/model/Protocol.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.protocol;

/**
 * Protocol: 

				The Protocol class defines parameterizable descriptions of methods;
				each protocol has a unique name within an Study. Each
				ProtocolApplication can define the ObservableFeatures it can
				observe. Also the protocol parameters can be modeled using
				ObservableFeatures (Users are expected to 'tag' the observeable
				feature by setting ObserveableFeature type as 'ProtocolParameter'.
				Examples of protocols are: SOP for blood pressure measurement used
				by UK biobank, or 'R/qtl' as protocol for statistical analysis.
				Protocol is a high level object that represents the details of
				protocols used during the investigation. The uses of Protocols to
				process BioMaterials and Data are referenced by ProtocolApplication
				(in the SDRF part of the format). Protocol has an association to
				OntologyTerm to represent the type of protocol. Protocols are
				associated with Hardware, Software and Parameters used in the
				Protocol. An example from ArrayExpress is E-MTAB-506
				<a href="ftp://ftp.ebi.ac.uk/pub/databases/microarray/data/experiment/TABM/E-TABM-506/E-TABM-506.idf.txt">
					ftp://ftp.ebi.ac.uk/pub/databases/microarray/data/experiment/TABM/E-TABM-506/E-TABM-506.idf.txt.
				</a>
    <br/>
				The FUGE equivalent to Protocol is FuGE::Protocol.
				<br/>
				The Protocol class maps to FuGE/XGAP/MageTab Protocol, but in
				contrast to FuGE it is not required to extend protocol before use.
				The Protocol class also maps to METABASE:Form (note that components
				are solved during METABASE:Visit which can be nested). Has no
				equivalent in PaGE.
			
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Protocol", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "name", "Investigation" } ) }
)


@javax.persistence.Inheritance(strategy=javax.persistence.InheritanceType.JOINED)
@javax.persistence.DiscriminatorColumn(name="DType", discriminatorType=javax.persistence.DiscriminatorType.STRING)
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.protocol.db.ProtocolEntityListener.class})
public class Protocol extends org.molgenis.util.AbstractEntity implements org.molgenis.organization.InvestigationElement
{
	// fieldname constants
	public final static String ID = "id";
	public final static String NAME = "name";
	public final static String DESCRIPTION = "description";
	public final static String INVESTIGATION = "Investigation";
	public final static String INVESTIGATION_NAME = "Investigation_name";
	public final static String ONTOLOGYREFERENCE = "ontologyReference";
	public final static String ONTOLOGYREFERENCE_NAME = "ontologyReference_name";
	public final static String __TYPE = "__Type";
	public final static String PROTOCOLTYPE = "ProtocolType";
	public final static String PROTOCOLTYPE_NAME = "ProtocolType_name";
	public final static String FEATURES = "Features";
	public final static String FEATURES_NAME = "Features_name";
	public final static String TARGETFILTER = "TargetFilter";
	public final static String CONTACT = "Contact";
	public final static String CONTACT_NAME = "Contact_name";
	public final static String SUBPROTOCOLS = "subprotocols";
	public final static String SUBPROTOCOLS_NAME = "subprotocols_name";
	
	//static methods
	/**
	 * Shorthand for db.query(Protocol.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Protocol> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Protocol.class);
	}
	
	/**
	 * Shorthand for db.find(Protocol.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Protocol> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Protocol.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Protocol findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Protocol> q = db.query(Protocol.class);
		q.eq(Protocol.ID, id);
		java.util.List<Protocol> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Protocol findByNameInvestigation(org.molgenis.framework.db.Database db, String name, Integer investigation) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Protocol> q = db.query(Protocol.class);
		q.eq(Protocol.NAME, name);q.eq(Protocol.INVESTIGATION, investigation);
		java.util.List<Protocol> result = q.find();
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


	//Description, or reference to a description, of the protocol[type=richtext]
	@javax.persistence.Column(name="description")
	@javax.xml.bind.annotation.XmlElement(name="description")
	
				

	private String description =  null;


	//Reference to the Study that this data element is part of[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Investigation")   	
	
				

	private org.molgenis.organization.Investigation investigation = null;
	@javax.persistence.Transient
	private Integer investigation_id = null;	
	@javax.persistence.Transient
	private String investigation_name = null;						


	//(Optional) Reference to the formal ontology definition for this element, e.g. 'Animal' or 'GWAS protocol'[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="ontologyReference", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="Protocol_ontologyReference", 
			joinColumns=@javax.persistence.JoinColumn(name="Protocol"), inverseJoinColumns=@javax.persistence.JoinColumn(name="ontologyReference"))
	
				

	private java.util.List<org.molgenis.core.OntologyTerm> ontologyReference = new java.util.ArrayList<org.molgenis.core.OntologyTerm>();
	@javax.persistence.Transient
	private java.util.List<Integer> ontologyReference_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> ontologyReference_name = new java.util.ArrayList<String>();


	//Subtypes have to be set to allow searching[type=enum]
	@javax.persistence.Column(name="DType", nullable=false)            
	@javax.xml.bind.annotation.XmlElement(name="__Type")
	
				

	@javax.validation.constraints.NotNull
	private String __Type =  null;
	@javax.persistence.Transient
	private String __Type_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.util.ValueLabel> __Type_options = new java.util.ArrayList<org.molgenis.util.ValueLabel>();


	//annotation of the protocol to a well-defined ontological class.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="ProtocolType")   	
	
				

	private org.molgenis.core.OntologyTerm protocolType = null;
	@javax.persistence.Transient
	private Integer protocolType_id = null;	
	@javax.persistence.Transient
	private String protocolType_name = null;						


	//The features that can be observed using this protocol. For example 'length' or 'rs123534' or 'probe123'. Also protocol parameters are considered observable features as they are important to the interpretation of the observed values.[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Features", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="Protocol_Features", 
			joinColumns=@javax.persistence.JoinColumn(name="Protocol"), inverseJoinColumns=@javax.persistence.JoinColumn(name="Features"))
	
				

	private java.util.List<org.molgenis.pheno.ObservableFeature> features = new java.util.ArrayList<org.molgenis.pheno.ObservableFeature>();
	@javax.persistence.Transient
	private java.util.List<Integer> features_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> features_name = new java.util.ArrayList<String>();


	//Expression that filters the InvestigationElements that can be targetted using this protocol.     This helps the user to only select from targets that matter when setting observedvalues. For example: type='individual' AND species = 'human'[type=string]
	@javax.persistence.Column(name="TargetFilter")
	@javax.xml.bind.annotation.XmlElement(name="targetFilter")
	
				

	private String targetFilter =  null;


	//TODO Check if there can be multiple contacts.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Contact")   	
	
				

	private org.molgenis.auth.Person contact = null;
	@javax.persistence.Transient
	private Integer contact_id = null;	
	@javax.persistence.Transient
	private String contact_name = null;						


	//Subprotocols of this protocol[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="subprotocols", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="Protocol_subprotocols", 
			joinColumns=@javax.persistence.JoinColumn(name="Protocol"), inverseJoinColumns=@javax.persistence.JoinColumn(name="subprotocols"))
	
				

	private java.util.List<org.molgenis.protocol.Protocol> subprotocols = new java.util.ArrayList<org.molgenis.protocol.Protocol>();
	@javax.persistence.Transient
	private java.util.List<Integer> subprotocols_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> subprotocols_name = new java.util.ArrayList<String>();

	//constructors
	public Protocol()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
		//options for enum __Type
		__Type_options.add(new org.molgenis.util.ValueLabel("Protocol","Protocol"));
		__Type_options.add(new org.molgenis.util.ValueLabel("Workflow","Workflow"));
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
	 * Get the Description, or reference to a description, of the protocol.
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
	 * Set the Description, or reference to a description, of the protocol.
	 * @param description
	 */
	public void setDescription( String description)
	{
		
		this.description = description;
	}

	

	/**
	 * Get the Reference to the Study that this data element is part of.
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
	 * Set the Reference to the Study that this data element is part of.
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
	 * Get the (Optional) Reference to the formal ontology definition for this element, e.g. 'Animal' or 'GWAS protocol'.
	 * @return ontologyReference.
	 */
	public java.util.List<org.molgenis.core.OntologyTerm> getOntologyReference()
	{
		return this.ontologyReference;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.core.OntologyTerm> getOntologyReference(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) Reference to the formal ontology definition for this element, e.g. 'Animal' or 'GWAS protocol'.
	 * @param ontologyReference
	 */
	public void setOntologyReference( java.util.List<org.molgenis.core.OntologyTerm> ontologyReference)
	{
		
		this.ontologyReference = ontologyReference;
	}

	
	public void setOntologyReference_Id(Integer ... ontologyReference)
	{
		this.setOntologyReference_Id(java.util.Arrays.asList(ontologyReference));
	}	
	
	public void setOntologyReference(org.molgenis.core.OntologyTerm ... ontologyReference)
	{
		this.setOntologyReference(java.util.Arrays.asList(ontologyReference));
	}	
	
	/**
	 * Set foreign key for field ontologyReference.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setOntologyReference_Id(java.util.List<Integer> ontologyReference_id)
	{
		this.ontologyReference_id = ontologyReference_id;
	}	
	
	public java.util.List<Integer> getOntologyReference_Id()
	{
		return ontologyReference_id;
	}	
	
	/**
	 * Get a pretty label for cross reference OntologyReference to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 */
	public java.util.List<String> getOntologyReference_Name()
	{
		return ontologyReference_name;
	}
	
	/**
	 * Update the foreign key OntologyReference
	 * This sets ontologyReference to null until next database transaction.
	 */
	public void setOntologyReference_Name(java.util.List<String> ontologyReference_name)
	{
		this.ontologyReference_name = ontologyReference_name;
	}		
	

	/**
	 * Get the Subtypes have to be set to allow searching.
	 * @return __Type.
	 */
	public String get__Type()
	{
		return this.__Type;
	}
	
	@Deprecated
	public String get__Type(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Subtypes have to be set to allow searching.
	 * @param __Type
	 */
	public void set__Type( String __Type)
	{
		
		this.__Type = __Type;
	}

	
	/**
	 * Get tha label for enum __Type.
	 */
	public String get__TypeLabel()
	{
		return this.__Type_label;
	}
	
	/**
	 * __Type is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.util.ValueLabel> get__TypeOptions()
	{
		return __Type_options;
	}	
	

	/**
	 * Get the annotation of the protocol to a well-defined ontological class..
	 * @return protocolType.
	 */
	public org.molgenis.core.OntologyTerm getProtocolType()
	{
		return this.protocolType;
	}
	
	@Deprecated
	public org.molgenis.core.OntologyTerm getProtocolType(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the annotation of the protocol to a well-defined ontological class..
	 * @param protocolType
	 */
	public void setProtocolType( org.molgenis.core.OntologyTerm protocolType)
	{
		
		this.protocolType = protocolType;
	}

	
	
	/**
	 * Set foreign key for field protocolType.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setProtocolType_Id(Integer protocolType_id)
	{
		this.protocolType_id = protocolType_id;
	}	

	public void setProtocolType(Integer protocolType_id)
	{
		this.protocolType_id = protocolType_id;
	}
	
	public Integer getProtocolType_Id()
	{
		
		if(protocolType != null) 
		{
			return protocolType.getId();
		}
		else
		{
			return protocolType_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference ProtocolType to OntologyTerm.Id.
	 */
	public String getProtocolType_Name()
	{		
		//FIXME should we auto-load based on getProtocolType()?	
		if(protocolType != null) {
			return protocolType.getName();
		} else {
			return protocolType_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference ProtocolType to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setProtocolType(null) until save
	 */
	public void setProtocolType_Name(String protocolType_name)
	{
		this.protocolType_name = protocolType_name;
	}		
	 
	

	/**
	 * Get the The features that can be observed using this protocol. For example 'length' or 'rs123534' or 'probe123'. Also protocol parameters are considered observable features as they are important to the interpretation of the observed values..
	 * @return features.
	 */
	public java.util.List<org.molgenis.pheno.ObservableFeature> getFeatures()
	{
		return this.features;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.pheno.ObservableFeature> getFeatures(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The features that can be observed using this protocol. For example 'length' or 'rs123534' or 'probe123'. Also protocol parameters are considered observable features as they are important to the interpretation of the observed values..
	 * @param features
	 */
	public void setFeatures( java.util.List<org.molgenis.pheno.ObservableFeature> features)
	{
		
		this.features = features;
	}

	
	public void setFeatures_Id(Integer ... features)
	{
		this.setFeatures_Id(java.util.Arrays.asList(features));
	}	
	
	public void setFeatures(org.molgenis.pheno.ObservableFeature ... features)
	{
		this.setFeatures(java.util.Arrays.asList(features));
	}	
	
	/**
	 * Set foreign key for field features.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setFeatures_Id(java.util.List<Integer> features_id)
	{
		this.features_id = features_id;
	}	
	
	public java.util.List<Integer> getFeatures_Id()
	{
		return features_id;
	}	
	
	/**
	 * Get a pretty label for cross reference Features to <a href="ObservableFeature.html#Id">ObservableFeature.Id</a>.
	 */
	public java.util.List<String> getFeatures_Name()
	{
		return features_name;
	}
	
	/**
	 * Update the foreign key Features
	 * This sets features to null until next database transaction.
	 */
	public void setFeatures_Name(java.util.List<String> features_name)
	{
		this.features_name = features_name;
	}		
	

	/**
	 * Get the Expression that filters the InvestigationElements that can be targetted using this protocol.     This helps the user to only select from targets that matter when setting observedvalues. For example: type='individual' AND species = 'human'.
	 * @return targetFilter.
	 */
	public String getTargetFilter()
	{
		return this.targetFilter;
	}
	
	@Deprecated
	public String getTargetFilter(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Expression that filters the InvestigationElements that can be targetted using this protocol.     This helps the user to only select from targets that matter when setting observedvalues. For example: type='individual' AND species = 'human'.
	 * @param targetFilter
	 */
	public void setTargetFilter( String targetFilter)
	{
		
		this.targetFilter = targetFilter;
	}

	

	/**
	 * Get the TODO Check if there can be multiple contacts..
	 * @return contact.
	 */
	public org.molgenis.auth.Person getContact()
	{
		return this.contact;
	}
	
	@Deprecated
	public org.molgenis.auth.Person getContact(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the TODO Check if there can be multiple contacts..
	 * @param contact
	 */
	public void setContact( org.molgenis.auth.Person contact)
	{
		
		this.contact = contact;
	}

	
	
	/**
	 * Set foreign key for field contact.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setContact_Id(Integer contact_id)
	{
		this.contact_id = contact_id;
	}	

	public void setContact(Integer contact_id)
	{
		this.contact_id = contact_id;
	}
	
	public Integer getContact_Id()
	{
		
		if(contact != null) 
		{
			return contact.getId();
		}
		else
		{
			return contact_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Contact to Person.Id.
	 */
	public String getContact_Name()
	{		
		//FIXME should we auto-load based on getContact()?	
		if(contact != null) {
			return contact.getName();
		} else {
			return contact_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Contact to <a href="Person.html#Id">Person.Id</a>.
	 * Implies setContact(null) until save
	 */
	public void setContact_Name(String contact_name)
	{
		this.contact_name = contact_name;
	}		
	 
	

	/**
	 * Get the Subprotocols of this protocol.
	 * @return subprotocols.
	 */
	public java.util.List<org.molgenis.protocol.Protocol> getSubprotocols()
	{
		return this.subprotocols;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.protocol.Protocol> getSubprotocols(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Subprotocols of this protocol.
	 * @param subprotocols
	 */
	public void setSubprotocols( java.util.List<org.molgenis.protocol.Protocol> subprotocols)
	{
		
		this.subprotocols = subprotocols;
	}

	
	public void setSubprotocols_Id(Integer ... subprotocols)
	{
		this.setSubprotocols_Id(java.util.Arrays.asList(subprotocols));
	}	
	
	public void setSubprotocols(org.molgenis.protocol.Protocol ... subprotocols)
	{
		this.setSubprotocols(java.util.Arrays.asList(subprotocols));
	}	
	
	/**
	 * Set foreign key for field subprotocols.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setSubprotocols_Id(java.util.List<Integer> subprotocols_id)
	{
		this.subprotocols_id = subprotocols_id;
	}	
	
	public java.util.List<Integer> getSubprotocols_Id()
	{
		return subprotocols_id;
	}	
	
	/**
	 * Get a pretty label for cross reference Subprotocols to <a href="Protocol.html#Id">Protocol.Id</a>.
	 */
	public java.util.List<String> getSubprotocols_Name()
	{
		return subprotocols_name;
	}
	
	/**
	 * Update the foreign key Subprotocols
	 * This sets subprotocols to null until next database transaction.
	 */
	public void setSubprotocols_Name(java.util.List<String> subprotocols_name)
	{
		this.subprotocols_name = subprotocols_name;
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
		if (name.toLowerCase().equals("investigation"))
			return getInvestigation();
		if(name.toLowerCase().equals("investigation_id"))
			return getInvestigation_Id();
		if(name.toLowerCase().equals("investigation_name"))
			return getInvestigation_Name();
		if (name.toLowerCase().equals("ontologyreference"))
			return getOntologyReference();
		if(name.toLowerCase().equals("ontologyreference_id"))
			return getOntologyReference_Id();
		if(name.toLowerCase().equals("ontologyreference_name"))
			return getOntologyReference_Name();
		if (name.toLowerCase().equals("__type"))
			return get__Type();
		if(name.toLowerCase().equals("__type_label"))
			return get__TypeLabel();
		if (name.toLowerCase().equals("protocoltype"))
			return getProtocolType();
		if(name.toLowerCase().equals("protocoltype_id"))
			return getProtocolType_Id();
		if(name.toLowerCase().equals("protocoltype_name"))
			return getProtocolType_Name();
		if (name.toLowerCase().equals("features"))
			return getFeatures();
		if(name.toLowerCase().equals("features_id"))
			return getFeatures_Id();
		if(name.toLowerCase().equals("features_name"))
			return getFeatures_Name();
		if (name.toLowerCase().equals("targetfilter"))
			return getTargetFilter();
		if (name.toLowerCase().equals("contact"))
			return getContact();
		if(name.toLowerCase().equals("contact_id"))
			return getContact_Id();
		if(name.toLowerCase().equals("contact_name"))
			return getContact_Name();
		if (name.toLowerCase().equals("subprotocols"))
			return getSubprotocols();
		if(name.toLowerCase().equals("subprotocols_id"))
			return getSubprotocols_Id();
		if(name.toLowerCase().equals("subprotocols_name"))
			return getSubprotocols_Name();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
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
			//set Investigation
			this.setInvestigation(tuple.getInt("Investigation"));
			//set label name for xref field Investigation
			this.setInvestigation_Name(tuple.getString("Investigation_name"));	
			//mrefs can not be directly retrieved
			//set OntologyReference			
			//set __Type
			this.set__Type(tuple.getString("__Type"));
			//set ProtocolType
			this.setProtocolType(tuple.getInt("ProtocolType"));
			//set label name for xref field ProtocolType
			this.setProtocolType_Name(tuple.getString("ProtocolType_name"));	
			//mrefs can not be directly retrieved
			//set Features			
			//set TargetFilter
			this.setTargetFilter(tuple.getString("TargetFilter"));
			//set Contact
			this.setContact(tuple.getInt("Contact"));
			//set label name for xref field Contact
			this.setContact_Name(tuple.getString("Contact_name"));	
			//mrefs can not be directly retrieved
			//set Subprotocols			
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Protocol_id") != null) this.setId(tuple.getInt("Protocol_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("Protocol_name") != null) this.setName(tuple.getString("Protocol_name"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Protocol_description") != null) this.setDescription(tuple.getString("Protocol_description"));
			//set Investigation
			if( strict || tuple.getInt("Investigation_id") != null) this.setInvestigation(tuple.getInt("Investigation_id"));
			if( tuple.getInt("Protocol_Investigation_id") != null) this.setInvestigation(tuple.getInt("Protocol_Investigation_id"));
			//alias of xref
			if( tuple.getObject("Investigation") != null) this.setInvestigation(tuple.getInt("Investigation"));
			if( tuple.getObject("Protocol_Investigation") != null) this.setInvestigation(tuple.getInt("Protocol_Investigation"));
			//set label for field Investigation
			if( strict || tuple.getObject("Investigation_name") != null) this.setInvestigation_Name(tuple.getString("Investigation_name"));			
			if( tuple.getObject("Protocol_Investigation_name") != null ) this.setInvestigation_Name(tuple.getString("Protocol_Investigation_name"));		
			//set OntologyReference
			if( tuple.getObject("ontologyReference")!= null || tuple.getObject("Protocol_ontologyReference")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference");
				if(tuple.getObject("Protocol_ontologyReference")!= null) mrefs = tuple.getList("Protocol_ontologyReference");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setOntologyReference_Id( values );
			}
			//set labels name for mref field OntologyReference	
			if( tuple.getObject("ontologyReference_name")!= null || tuple.getObject("Protocol_ontologyReference_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference_name");
				if(tuple.getObject("Protocol_ontologyReference_name")!= null) mrefs = tuple.getList("Protocol_ontologyReference_name");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setOntologyReference_Name( values );			
			}	
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("Protocol___Type") != null) this.set__Type(tuple.getString("Protocol___Type"));
			//set ProtocolType
			if( strict || tuple.getInt("ProtocolType_id") != null) this.setProtocolType(tuple.getInt("ProtocolType_id"));
			if( tuple.getInt("Protocol_ProtocolType_id") != null) this.setProtocolType(tuple.getInt("Protocol_ProtocolType_id"));
			//alias of xref
			if( tuple.getObject("ProtocolType") != null) this.setProtocolType(tuple.getInt("ProtocolType"));
			if( tuple.getObject("Protocol_ProtocolType") != null) this.setProtocolType(tuple.getInt("Protocol_ProtocolType"));
			//set label for field ProtocolType
			if( strict || tuple.getObject("ProtocolType_name") != null) this.setProtocolType_Name(tuple.getString("ProtocolType_name"));			
			if( tuple.getObject("Protocol_ProtocolType_name") != null ) this.setProtocolType_Name(tuple.getString("Protocol_ProtocolType_name"));		
			//set Features
			if( tuple.getObject("Features")!= null || tuple.getObject("Protocol_Features")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("Features");
				if(tuple.getObject("Protocol_Features")!= null) mrefs = tuple.getList("Protocol_Features");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setFeatures_Id( values );
			}
			//set labels name for mref field Features	
			if( tuple.getObject("Features_name")!= null || tuple.getObject("Protocol_Features_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("Features_name");
				if(tuple.getObject("Protocol_Features_name")!= null) mrefs = tuple.getList("Protocol_Features_name");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setFeatures_Name( values );			
			}	
			//set TargetFilter
			if( strict || tuple.getString("TargetFilter") != null) this.setTargetFilter(tuple.getString("TargetFilter"));
			if( tuple.getString("Protocol_TargetFilter") != null) this.setTargetFilter(tuple.getString("Protocol_TargetFilter"));
			//set Contact
			if( strict || tuple.getInt("Contact_id") != null) this.setContact(tuple.getInt("Contact_id"));
			if( tuple.getInt("Protocol_Contact_id") != null) this.setContact(tuple.getInt("Protocol_Contact_id"));
			//alias of xref
			if( tuple.getObject("Contact") != null) this.setContact(tuple.getInt("Contact"));
			if( tuple.getObject("Protocol_Contact") != null) this.setContact(tuple.getInt("Protocol_Contact"));
			//set label for field Contact
			if( strict || tuple.getObject("Contact_name") != null) this.setContact_Name(tuple.getString("Contact_name"));			
			if( tuple.getObject("Protocol_Contact_name") != null ) this.setContact_Name(tuple.getString("Protocol_Contact_name"));		
			//set Subprotocols
			if( tuple.getObject("subprotocols")!= null || tuple.getObject("Protocol_subprotocols")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("subprotocols");
				if(tuple.getObject("Protocol_subprotocols")!= null) mrefs = tuple.getList("Protocol_subprotocols");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setSubprotocols_Id( values );
			}
			//set labels name for mref field Subprotocols	
			if( tuple.getObject("subprotocols_name")!= null || tuple.getObject("Protocol_subprotocols_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("subprotocols_name");
				if(tuple.getObject("Protocol_subprotocols_name")!= null) mrefs = tuple.getList("Protocol_subprotocols_name");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setSubprotocols_Name( values );			
			}	
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
		String result = "Protocol(";
		result+= "id='" + getId()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " investigation_id='" + getInvestigation_Id()+"' ";	
		result+= " investigation_name='" + getInvestigation_Name()+"' ";
		result+= " ontologyReference_id='" + getOntologyReference_Id()+"' ";	
		result+= " ontologyReference_name='" + getOntologyReference_Name()+"' ";
		result+= "__Type='" + get__Type()+"' ";	
		result+= " protocolType_id='" + getProtocolType_Id()+"' ";	
		result+= " protocolType_name='" + getProtocolType_Name()+"' ";
		result+= " features_id='" + getFeatures_Id()+"' ";	
		result+= " features_name='" + getFeatures_Name()+"' ";
		result+= "targetFilter='" + getTargetFilter()+"' ";	
		result+= " contact_id='" + getContact_Id()+"' ";	
		result+= " contact_name='" + getContact_Name()+"' ";
		result+= " subprotocols_id='" + getSubprotocols_Id()+"' ";	
		result+= " subprotocols_name='" + getSubprotocols_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Protocol.
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
			fields.add("investigation_id");
		}
		fields.add("investigation_name");
		{
			fields.add("ontologyReference_id");
		}
		fields.add("ontologyReference_name");
		{
			fields.add("__Type");
		}
		{
			fields.add("protocolType_id");
		}
		fields.add("protocolType_name");
		{
			fields.add("features_id");
		}
		fields.add("features_name");
		{
			fields.add("targetFilter");
		}
		{
			fields.add("contact_id");
		}
		fields.add("contact_name");
		{
			fields.add("subprotocols_id");
		}
		fields.add("subprotocols_name");
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
		+ "investigation" +sep
		+ "ontologyReference" +sep
		+ "__Type" +sep
		+ "protocolType" +sep
		+ "features" +sep
		+ "targetFilter" +sep
		+ "contact" +sep
		+ "subprotocols" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("investigation")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("ontologyReference")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("protocolType")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("features")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("contact")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("subprotocols")) {
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
		Protocol rhs = (Protocol) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//name
				.append(name, rhs.getName())
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
			Object valueO = getInvestigation();
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
			Object valueO = getOntologyReference();
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
			Object valueO = getProtocolType();
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
			Object valueO = getTargetFilter();
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
			Object valueO = getContact();
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
			Object valueO = getSubprotocols();
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
	public Protocol create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Protocol e = new Protocol();
		e.set(tuple);
		return e;
	}
	
//8
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="protocol"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.protocol.ProtocolApplication> protocolProtocolApplicationCollection = new java.util.ArrayList<org.molgenis.protocol.ProtocolApplication>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.protocol.ProtocolApplication> getProtocolProtocolApplicationCollection()
	{
            return protocolProtocolApplicationCollection;
	}

    public void setProtocolProtocolApplicationCollection(java.util.Collection<org.molgenis.protocol.ProtocolApplication> collection)
    {
        for (org.molgenis.protocol.ProtocolApplication protocolApplication : collection) {
            protocolApplication.setProtocol(this);
        }
        protocolProtocolApplicationCollection = collection;
    }	
//8
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="protocol"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.protocol.ProtocolDocument> protocolProtocolDocumentCollection = new java.util.ArrayList<org.molgenis.protocol.ProtocolDocument>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.protocol.ProtocolDocument> getProtocolProtocolDocumentCollection()
	{
            return protocolProtocolDocumentCollection;
	}

    public void setProtocolProtocolDocumentCollection(java.util.Collection<org.molgenis.protocol.ProtocolDocument> collection)
    {
        for (org.molgenis.protocol.ProtocolDocument protocolDocument : collection) {
            protocolDocument.setProtocol(this);
        }
        protocolProtocolDocumentCollection = collection;
    }	
//8
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="protocol"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.protocol.WorkflowElement> protocolWorkflowElementCollection = new java.util.ArrayList<org.molgenis.protocol.WorkflowElement>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.protocol.WorkflowElement> getProtocolWorkflowElementCollection()
	{
            return protocolWorkflowElementCollection;
	}

    public void setProtocolWorkflowElementCollection(java.util.Collection<org.molgenis.protocol.WorkflowElement> collection)
    {
        for (org.molgenis.protocol.WorkflowElement workflowElement : collection) {
            workflowElement.setProtocol(this);
        }
        protocolWorkflowElementCollection = collection;
    }	
	//8
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="subprotocols"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.protocol.Protocol> subprotocolsProtocolCollection = new java.util.ArrayList<org.molgenis.protocol.Protocol>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.protocol.Protocol> getSubprotocolsProtocolCollection()
	{
        return subprotocolsProtocolCollection;
	}

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.protocol.Protocol> getSubprotocolsProtocolCollection(org.molgenis.framework.db.Database db)
	{
        return getSubprotocolsProtocolCollection();
	}

    public void setSubprotocolsProtocolCollection(java.util.Collection<org.molgenis.protocol.Protocol> collection)
    {
    	subprotocolsProtocolCollection.addAll(collection);
    }	

	
}

