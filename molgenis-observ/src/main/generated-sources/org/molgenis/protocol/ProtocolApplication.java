
/* File:        observ/model/ProtocolApplication.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.protocol;

/**
 * ProtocolApplication: 
				A ProtocolApplication class defines the actual action of observation
				by refering to a protocol and optional ParameterValues. The name
				field can be used to label applications with a human understandeable
				tag. For example: the action of blood pressure measurement on 1000
				individuals, using a particular protocol, resulting in 1000
				associated observed values. If desired, protocols can be shared
				between Studys; in those cases one should simply refer to a protocol
				in another Study.
				<br/>
				ProtocolApplications are used in MAGE-TAB format to reference to
				protocols used, with optionally use of certain protocol parameter
				values. For example, a Source may be transformed into a Labeled
				Extract by the subsequent application of a Extraction and Labeling
				protocol. ProtocolApplication is associated with and Edge that links
				input/output, e.g. Source to Labeled Extract. The order of the
				application of protocols can be set in order to be able to
				reconstruct the left-to-right order of protocol references in
				MAGE-TAB format. The FuGE equivalent to ProtocolApplication is
				FuGE:ProtocolApplication, however input/output is modeled using
				Edge.
				<br/>
				The ProtocolApplication class maps to FuGE/XGAP ProtocolApplication,
				but in FuGE ProtocolApplications can take Material or Data (or both)
				as input and produce Material or Data (or both) as output. Similar
				to PaGE.ObservationMethod. Maps to METABASE:Visit (also note that
				METABASE:PlannedVisit allows for planning of protocol applications;
				this is outside scope for this model?).
			
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "ProtocolApplication", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "name", "Investigation" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.protocol.db.ProtocolApplicationEntityListener.class})
public class ProtocolApplication extends org.molgenis.util.AbstractEntity implements org.molgenis.organization.InvestigationElement
{
	// fieldname constants
	public final static String ID = "id";
	public final static String NAME = "name";
	public final static String DESCRIPTION = "description";
	public final static String INVESTIGATION = "Investigation";
	public final static String INVESTIGATION_NAME = "Investigation_name";
	public final static String ONTOLOGYREFERENCE = "ontologyReference";
	public final static String ONTOLOGYREFERENCE_NAME = "ontologyReference_name";
	public final static String TIME = "time";
	public final static String PROTOCOL = "protocol";
	public final static String PROTOCOL_NAME = "protocol_name";
	public final static String PERFORMER = "Performer";
	public final static String PERFORMER_NAME = "Performer_name";
	
	//static methods
	/**
	 * Shorthand for db.query(ProtocolApplication.class).
	 */
	public static org.molgenis.framework.db.Query<? extends ProtocolApplication> query(org.molgenis.framework.db.Database db)
	{
		return db.query(ProtocolApplication.class);
	}
	
	/**
	 * Shorthand for db.find(ProtocolApplication.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends ProtocolApplication> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(ProtocolApplication.class, rules);
	}	
	
	/**
	 * 
	 */
	public static ProtocolApplication findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ProtocolApplication> q = db.query(ProtocolApplication.class);
		q.eq(ProtocolApplication.ID, id);
		java.util.List<ProtocolApplication> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static ProtocolApplication findByNameInvestigation(org.molgenis.framework.db.Database db, String name, Integer investigation) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ProtocolApplication> q = db.query(ProtocolApplication.class);
		q.eq(ProtocolApplication.NAME, name);q.eq(ProtocolApplication.INVESTIGATION, investigation);
		java.util.List<ProtocolApplication> result = q.find();
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
	@javax.persistence.JoinTable(name="ProtocolApplication_ontologyReference", 
			joinColumns=@javax.persistence.JoinColumn(name="ProtocolApplication"), inverseJoinColumns=@javax.persistence.JoinColumn(name="ontologyReference"))
	
				

	private java.util.List<org.molgenis.core.OntologyTerm> ontologyReference = new java.util.ArrayList<org.molgenis.core.OntologyTerm>();
	@javax.persistence.Transient
	private java.util.List<Integer> ontologyReference_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> ontologyReference_name = new java.util.ArrayList<String>();


	//time when the protocol was applied.[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="time", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="time")
	
				

	@javax.validation.constraints.NotNull
	private java.util.Date time =  new java.sql.Date(new java.util.Date().getTime());


	//Reference to the protocol that is being used.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="protocol")   	
	
				

	private org.molgenis.protocol.Protocol protocol = null;
	@javax.persistence.Transient
	private Integer protocol_id = null;	
	@javax.persistence.Transient
	private String protocol_name = null;						


	//Performer[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Performer", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="ProtocolApplication_Performer", 
			joinColumns=@javax.persistence.JoinColumn(name="ProtocolApplication"), inverseJoinColumns=@javax.persistence.JoinColumn(name="Performer"))
	
				

	private java.util.List<org.molgenis.auth.Person> performer = new java.util.ArrayList<org.molgenis.auth.Person>();
	@javax.persistence.Transient
	private java.util.List<Integer> performer_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> performer_name = new java.util.ArrayList<String>();

	//constructors
	public ProtocolApplication()
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
	 * Get the time when the protocol was applied..
	 * @return time.
	 */
	public java.util.Date getTime()
	{
		return this.time;
	}
	
	@Deprecated
	public java.util.Date getTime(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the time when the protocol was applied..
	 * @param time
	 */
	public void setTime( java.util.Date time)
	{
		
		this.time = time;
	}

	

	/**
	 * Get the Reference to the protocol that is being used..
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
	 * Set the Reference to the protocol that is being used..
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
	 * Get the Performer.
	 * @return performer.
	 */
	public java.util.List<org.molgenis.auth.Person> getPerformer()
	{
		return this.performer;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.auth.Person> getPerformer(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Performer.
	 * @param performer
	 */
	public void setPerformer( java.util.List<org.molgenis.auth.Person> performer)
	{
		
		this.performer = performer;
	}

	
	public void setPerformer_Id(Integer ... performer)
	{
		this.setPerformer_Id(java.util.Arrays.asList(performer));
	}	
	
	public void setPerformer(org.molgenis.auth.Person ... performer)
	{
		this.setPerformer(java.util.Arrays.asList(performer));
	}	
	
	/**
	 * Set foreign key for field performer.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setPerformer_Id(java.util.List<Integer> performer_id)
	{
		this.performer_id = performer_id;
	}	
	
	public java.util.List<Integer> getPerformer_Id()
	{
		return performer_id;
	}	
	
	/**
	 * Get a pretty label for cross reference Performer to <a href="Person.html#Id">Person.Id</a>.
	 */
	public java.util.List<String> getPerformer_Name()
	{
		return performer_name;
	}
	
	/**
	 * Update the foreign key Performer
	 * This sets performer to null until next database transaction.
	 */
	public void setPerformer_Name(java.util.List<String> performer_name)
	{
		this.performer_name = performer_name;
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
		if (name.toLowerCase().equals("time"))
			return getTime();
		if (name.toLowerCase().equals("protocol"))
			return getProtocol();
		if(name.toLowerCase().equals("protocol_id"))
			return getProtocol_Id();
		if(name.toLowerCase().equals("protocol_name"))
			return getProtocol_Name();
		if (name.toLowerCase().equals("performer"))
			return getPerformer();
		if(name.toLowerCase().equals("performer_id"))
			return getPerformer_Id();
		if(name.toLowerCase().equals("performer_name"))
			return getPerformer_Name();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.getTime() == null) throw new org.molgenis.framework.db.DatabaseException("required field time is null");
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
			//set Time
			this.setTime(tuple.getTimestamp("time"));
			//set Protocol
			this.setProtocol(tuple.getInt("protocol"));
			//set label name for xref field Protocol
			this.setProtocol_Name(tuple.getString("protocol_name"));	
			//mrefs can not be directly retrieved
			//set Performer			
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("ProtocolApplication_id") != null) this.setId(tuple.getInt("ProtocolApplication_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("ProtocolApplication_name") != null) this.setName(tuple.getString("ProtocolApplication_name"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("ProtocolApplication_description") != null) this.setDescription(tuple.getString("ProtocolApplication_description"));
			//set Investigation
			if( strict || tuple.getInt("Investigation_id") != null) this.setInvestigation(tuple.getInt("Investigation_id"));
			if( tuple.getInt("ProtocolApplication_Investigation_id") != null) this.setInvestigation(tuple.getInt("ProtocolApplication_Investigation_id"));
			//alias of xref
			if( tuple.getObject("Investigation") != null) this.setInvestigation(tuple.getInt("Investigation"));
			if( tuple.getObject("ProtocolApplication_Investigation") != null) this.setInvestigation(tuple.getInt("ProtocolApplication_Investigation"));
			//set label for field Investigation
			if( strict || tuple.getObject("Investigation_name") != null) this.setInvestigation_Name(tuple.getString("Investigation_name"));			
			if( tuple.getObject("ProtocolApplication_Investigation_name") != null ) this.setInvestigation_Name(tuple.getString("ProtocolApplication_Investigation_name"));		
			//set OntologyReference
			if( tuple.getObject("ontologyReference")!= null || tuple.getObject("ProtocolApplication_ontologyReference")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference");
				if(tuple.getObject("ProtocolApplication_ontologyReference")!= null) mrefs = tuple.getList("ProtocolApplication_ontologyReference");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setOntologyReference_Id( values );
			}
			//set labels name for mref field OntologyReference	
			if( tuple.getObject("ontologyReference_name")!= null || tuple.getObject("ProtocolApplication_ontologyReference_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference_name");
				if(tuple.getObject("ProtocolApplication_ontologyReference_name")!= null) mrefs = tuple.getList("ProtocolApplication_ontologyReference_name");
				
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
			//set Time
			if( strict || tuple.getTimestamp("time") != null) this.setTime(tuple.getTimestamp("time"));
			if( tuple.getTimestamp("ProtocolApplication_time") != null) this.setTime(tuple.getTimestamp("ProtocolApplication_time"));
			//set Protocol
			if( strict || tuple.getInt("protocol_id") != null) this.setProtocol(tuple.getInt("protocol_id"));
			if( tuple.getInt("ProtocolApplication_protocol_id") != null) this.setProtocol(tuple.getInt("ProtocolApplication_protocol_id"));
			//alias of xref
			if( tuple.getObject("protocol") != null) this.setProtocol(tuple.getInt("protocol"));
			if( tuple.getObject("ProtocolApplication_protocol") != null) this.setProtocol(tuple.getInt("ProtocolApplication_protocol"));
			//set label for field Protocol
			if( strict || tuple.getObject("protocol_name") != null) this.setProtocol_Name(tuple.getString("protocol_name"));			
			if( tuple.getObject("ProtocolApplication_protocol_name") != null ) this.setProtocol_Name(tuple.getString("ProtocolApplication_protocol_name"));		
			//set Performer
			if( tuple.getObject("Performer")!= null || tuple.getObject("ProtocolApplication_Performer")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("Performer");
				if(tuple.getObject("ProtocolApplication_Performer")!= null) mrefs = tuple.getList("ProtocolApplication_Performer");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setPerformer_Id( values );
			}
			//set labels name for mref field Performer	
			if( tuple.getObject("Performer_name")!= null || tuple.getObject("ProtocolApplication_Performer_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("Performer_name");
				if(tuple.getObject("ProtocolApplication_Performer_name")!= null) mrefs = tuple.getList("ProtocolApplication_Performer_name");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setPerformer_Name( values );			
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
		String result = "ProtocolApplication(";
		result+= "id='" + getId()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " investigation_id='" + getInvestigation_Id()+"' ";	
		result+= " investigation_name='" + getInvestigation_Name()+"' ";
		result+= " ontologyReference_id='" + getOntologyReference_Id()+"' ";	
		result+= " ontologyReference_name='" + getOntologyReference_Name()+"' ";
		result+= "time='" + (getTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getTime()))+"' ";
		result+= "time='" + (getTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getTime()))+"' ";		
		result+= " protocol_id='" + getProtocol_Id()+"' ";	
		result+= " protocol_name='" + getProtocol_Name()+"' ";
		result+= " performer_id='" + getPerformer_Id()+"' ";	
		result+= " performer_name='" + getPerformer_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of ProtocolApplication.
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
			fields.add("time");
		}
		{
			fields.add("protocol_id");
		}
		fields.add("protocol_name");
		{
			fields.add("performer_id");
		}
		fields.add("performer_name");
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
		+ "time" +sep
		+ "protocol" +sep
		+ "performer" 
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
        if (fieldName.equalsIgnoreCase("protocol")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("performer")) {
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
		ProtocolApplication rhs = (ProtocolApplication) obj;
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
			Object valueO = getTime();
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
			out.write(valueS+sep);
		}
		{
			Object valueO = getPerformer();
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
	public ProtocolApplication create(org.molgenis.util.Tuple tuple) throws Exception
	{
		ProtocolApplication e = new ProtocolApplication();
		e.set(tuple);
		return e;
	}
	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="protocolApplication"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.pheno.ObservedValue> protocolApplicationObservedValueCollection = new java.util.ArrayList<org.molgenis.pheno.ObservedValue>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.ObservedValue> getProtocolApplicationObservedValueCollection()
	{
            return protocolApplicationObservedValueCollection;
	}

    public void setProtocolApplicationObservedValueCollection(java.util.Collection<org.molgenis.pheno.ObservedValue> collection)
    {
        for (org.molgenis.pheno.ObservedValue observedValue : collection) {
            observedValue.setProtocolApplication(this);
        }
        protocolApplicationObservedValueCollection = collection;
    }	

	
}

