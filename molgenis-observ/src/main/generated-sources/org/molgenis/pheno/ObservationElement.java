
/* File:        observ/model/ObservationElement.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.pheno;

/**
 * ObservationElement:  Elements that are the targets or features we are
				looking at of our research.
			
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "ObservationElement", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "name", "Investigation" }), @javax.persistence.UniqueConstraint( columnNames={ "name" } ) }
)


@javax.persistence.Inheritance(strategy=javax.persistence.InheritanceType.JOINED)
@javax.persistence.DiscriminatorColumn(name="DType", discriminatorType=javax.persistence.DiscriminatorType.STRING)
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.pheno.db.ObservationElementEntityListener.class})
public class ObservationElement extends org.molgenis.util.AbstractEntity implements org.molgenis.organization.InvestigationElement
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
	public final static String ALTERNATEID = "AlternateId";
	public final static String ALTERNATEID_NAME = "AlternateId_name";
	public final static String LABEL = "label";
	
	//static methods
	/**
	 * Shorthand for db.query(ObservationElement.class).
	 */
	public static org.molgenis.framework.db.Query<? extends ObservationElement> query(org.molgenis.framework.db.Database db)
	{
		return db.query(ObservationElement.class);
	}
	
	/**
	 * Shorthand for db.find(ObservationElement.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends ObservationElement> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(ObservationElement.class, rules);
	}	
	
	/**
	 * 
	 */
	public static ObservationElement findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservationElement> q = db.query(ObservationElement.class);
		q.eq(ObservationElement.ID, id);
		java.util.List<ObservationElement> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static ObservationElement findByNameInvestigation(org.molgenis.framework.db.Database db, String name, Integer investigation) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservationElement> q = db.query(ObservationElement.class);
		q.eq(ObservationElement.NAME, name);q.eq(ObservationElement.INVESTIGATION, investigation);
		java.util.List<ObservationElement> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static ObservationElement findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservationElement> q = db.query(ObservationElement.class);
		q.eq(ObservationElement.NAME, name);
		java.util.List<ObservationElement> result = q.find();
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
	@javax.persistence.JoinTable(name="ObservationElement_ontologyReference", 
			joinColumns=@javax.persistence.JoinColumn(name="ObservationElement"), inverseJoinColumns=@javax.persistence.JoinColumn(name="ontologyReference"))
	
				

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


	//Alternative identifiers or symbols that this element is known by.[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="AlternateId", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="ObservationElement_AlternateId", 
			joinColumns=@javax.persistence.JoinColumn(name="ObservationElement"), inverseJoinColumns=@javax.persistence.JoinColumn(name="AlternateId"))
	
				

	private java.util.List<org.molgenis.pheno.AlternateId> alternateId = new java.util.ArrayList<org.molgenis.pheno.AlternateId>();
	@javax.persistence.Transient
	private java.util.List<Integer> alternateId_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> alternateId_name = new java.util.ArrayList<String>();


	//User friendly textual representation of this ObservationElement. For example: 'male',     'mouse 3 in cage 7' or 'TRA-2 like protein'. Label allows for human-readable name that is potentially not unique.[type=string]
	@javax.persistence.Column(name="label")
	@javax.xml.bind.annotation.XmlElement(name="label")
	
				

	private String label =  null;

	//constructors
	public ObservationElement()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
		//options for enum __Type
		__Type_options.add(new org.molgenis.util.ValueLabel("ObservationElement","ObservationElement"));
		__Type_options.add(new org.molgenis.util.ValueLabel("Individual","Individual"));
		__Type_options.add(new org.molgenis.util.ValueLabel("Location","Location"));
		__Type_options.add(new org.molgenis.util.ValueLabel("Panel","Panel"));
		__Type_options.add(new org.molgenis.util.ValueLabel("ObservationTarget","ObservationTarget"));
		__Type_options.add(new org.molgenis.util.ValueLabel("Measurement","Measurement"));
		__Type_options.add(new org.molgenis.util.ValueLabel("ObservableFeature","ObservableFeature"));
		__Type_options.add(new org.molgenis.util.ValueLabel("Category","Category"));
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
	 * Get the Alternative identifiers or symbols that this element is known by..
	 * @return alternateId.
	 */
	public java.util.List<org.molgenis.pheno.AlternateId> getAlternateId()
	{
		return this.alternateId;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.pheno.AlternateId> getAlternateId(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Alternative identifiers or symbols that this element is known by..
	 * @param alternateId
	 */
	public void setAlternateId( java.util.List<org.molgenis.pheno.AlternateId> alternateId)
	{
		
		this.alternateId = alternateId;
	}

	
	public void setAlternateId_Id(Integer ... alternateId)
	{
		this.setAlternateId_Id(java.util.Arrays.asList(alternateId));
	}	
	
	public void setAlternateId(org.molgenis.pheno.AlternateId ... alternateId)
	{
		this.setAlternateId(java.util.Arrays.asList(alternateId));
	}	
	
	/**
	 * Set foreign key for field alternateId.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setAlternateId_Id(java.util.List<Integer> alternateId_id)
	{
		this.alternateId_id = alternateId_id;
	}	
	
	public java.util.List<Integer> getAlternateId_Id()
	{
		return alternateId_id;
	}	
	
	/**
	 * Get a pretty label for cross reference AlternateId to <a href="AlternateId.html#Id">AlternateId.Id</a>.
	 */
	public java.util.List<String> getAlternateId_Name()
	{
		return alternateId_name;
	}
	
	/**
	 * Update the foreign key AlternateId
	 * This sets alternateId to null until next database transaction.
	 */
	public void setAlternateId_Name(java.util.List<String> alternateId_name)
	{
		this.alternateId_name = alternateId_name;
	}		
	

	/**
	 * Get the User friendly textual representation of this ObservationElement. For example: 'male',     'mouse 3 in cage 7' or 'TRA-2 like protein'. Label allows for human-readable name that is potentially not unique..
	 * @return label.
	 */
	public String getLabel()
	{
		return this.label;
	}
	
	@Deprecated
	public String getLabel(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the User friendly textual representation of this ObservationElement. For example: 'male',     'mouse 3 in cage 7' or 'TRA-2 like protein'. Label allows for human-readable name that is potentially not unique..
	 * @param label
	 */
	public void setLabel( String label)
	{
		
		this.label = label;
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
		if (name.toLowerCase().equals("alternateid"))
			return getAlternateId();
		if(name.toLowerCase().equals("alternateid_id"))
			return getAlternateId_Id();
		if(name.toLowerCase().equals("alternateid_name"))
			return getAlternateId_Name();
		if (name.toLowerCase().equals("label"))
			return getLabel();
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
			//mrefs can not be directly retrieved
			//set AlternateId			
			//set Label
			this.setLabel(tuple.getString("label"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("ObservationElement_id") != null) this.setId(tuple.getInt("ObservationElement_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("ObservationElement_name") != null) this.setName(tuple.getString("ObservationElement_name"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("ObservationElement_description") != null) this.setDescription(tuple.getString("ObservationElement_description"));
			//set Investigation
			if( strict || tuple.getInt("Investigation_id") != null) this.setInvestigation(tuple.getInt("Investigation_id"));
			if( tuple.getInt("ObservationElement_Investigation_id") != null) this.setInvestigation(tuple.getInt("ObservationElement_Investigation_id"));
			//alias of xref
			if( tuple.getObject("Investigation") != null) this.setInvestigation(tuple.getInt("Investigation"));
			if( tuple.getObject("ObservationElement_Investigation") != null) this.setInvestigation(tuple.getInt("ObservationElement_Investigation"));
			//set label for field Investigation
			if( strict || tuple.getObject("Investigation_name") != null) this.setInvestigation_Name(tuple.getString("Investigation_name"));			
			if( tuple.getObject("ObservationElement_Investigation_name") != null ) this.setInvestigation_Name(tuple.getString("ObservationElement_Investigation_name"));		
			//set OntologyReference
			if( tuple.getObject("ontologyReference")!= null || tuple.getObject("ObservationElement_ontologyReference")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference");
				if(tuple.getObject("ObservationElement_ontologyReference")!= null) mrefs = tuple.getList("ObservationElement_ontologyReference");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setOntologyReference_Id( values );
			}
			//set labels name for mref field OntologyReference	
			if( tuple.getObject("ontologyReference_name")!= null || tuple.getObject("ObservationElement_ontologyReference_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference_name");
				if(tuple.getObject("ObservationElement_ontologyReference_name")!= null) mrefs = tuple.getList("ObservationElement_ontologyReference_name");
				
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
			if( tuple.getString("ObservationElement___Type") != null) this.set__Type(tuple.getString("ObservationElement___Type"));
			//set AlternateId
			if( tuple.getObject("AlternateId")!= null || tuple.getObject("ObservationElement_AlternateId")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("AlternateId");
				if(tuple.getObject("ObservationElement_AlternateId")!= null) mrefs = tuple.getList("ObservationElement_AlternateId");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setAlternateId_Id( values );
			}
			//set labels name for mref field AlternateId	
			if( tuple.getObject("AlternateId_name")!= null || tuple.getObject("ObservationElement_AlternateId_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("AlternateId_name");
				if(tuple.getObject("ObservationElement_AlternateId_name")!= null) mrefs = tuple.getList("ObservationElement_AlternateId_name");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setAlternateId_Name( values );			
			}	
			//set Label
			if( strict || tuple.getString("label") != null) this.setLabel(tuple.getString("label"));
			if( tuple.getString("ObservationElement_label") != null) this.setLabel(tuple.getString("ObservationElement_label"));
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
		String result = "ObservationElement(";
		result+= "id='" + getId()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " investigation_id='" + getInvestigation_Id()+"' ";	
		result+= " investigation_name='" + getInvestigation_Name()+"' ";
		result+= " ontologyReference_id='" + getOntologyReference_Id()+"' ";	
		result+= " ontologyReference_name='" + getOntologyReference_Name()+"' ";
		result+= "__Type='" + get__Type()+"' ";	
		result+= " alternateId_id='" + getAlternateId_Id()+"' ";	
		result+= " alternateId_name='" + getAlternateId_Name()+"' ";
		result+= "label='" + getLabel()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of ObservationElement.
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
			fields.add("alternateId_id");
		}
		fields.add("alternateId_name");
		{
			fields.add("label");
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
		+ "investigation" +sep
		+ "ontologyReference" +sep
		+ "__Type" +sep
		+ "alternateId" +sep
		+ "label" 
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
        if (fieldName.equalsIgnoreCase("alternateId")) {
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
		ObservationElement rhs = (ObservationElement) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//name
				.append(name, rhs.getName())
		//investigation
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
			Object valueO = getLabel();
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
	public ObservationElement create(org.molgenis.util.Tuple tuple) throws Exception
	{
		ObservationElement e = new ObservationElement();
		e.set(tuple);
		return e;
	}
	
//7
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="feature"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.pheno.ObservedValue> featureObservedValueCollection = new java.util.ArrayList<org.molgenis.pheno.ObservedValue>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.ObservedValue> getFeatureObservedValueCollection()
	{
            return featureObservedValueCollection;
	}

    public void setFeatureObservedValueCollection(java.util.Collection<org.molgenis.pheno.ObservedValue> collection)
    {
        for (org.molgenis.pheno.ObservedValue observedValue : collection) {
            observedValue.setFeature(this);
        }
        featureObservedValueCollection = collection;
    }	
//7
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="target"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.pheno.ObservedValue> targetObservedValueCollection = new java.util.ArrayList<org.molgenis.pheno.ObservedValue>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.ObservedValue> getTargetObservedValueCollection()
	{
            return targetObservedValueCollection;
	}

    public void setTargetObservedValueCollection(java.util.Collection<org.molgenis.pheno.ObservedValue> collection)
    {
        for (org.molgenis.pheno.ObservedValue observedValue : collection) {
            observedValue.setTarget(this);
        }
        targetObservedValueCollection = collection;
    }	
//7
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="relation"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.pheno.ObservedValue> relationObservedValueCollection = new java.util.ArrayList<org.molgenis.pheno.ObservedValue>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.ObservedValue> getRelationObservedValueCollection()
	{
            return relationObservedValueCollection;
	}

    public void setRelationObservedValueCollection(java.util.Collection<org.molgenis.pheno.ObservedValue> collection)
    {
        for (org.molgenis.pheno.ObservedValue observedValue : collection) {
            observedValue.setRelation(this);
        }
        relationObservedValueCollection = collection;
    }	

	
}

