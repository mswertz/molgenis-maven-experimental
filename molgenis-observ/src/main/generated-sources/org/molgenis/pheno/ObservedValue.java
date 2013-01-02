
/* File:        observ/model/ObservedValue.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.pheno;

/**
 * ObservedValue: 
				Generic storage of values, relationships and optional ontology
				mapping of the value/relation. Values can be atomatic observations,
				e.g., length (feature) of individual 1 (target) = 179cm (value).
				Values can also be relationship values, e.g., extract (feature) of
				sample 1 (target) = derived sample (relation).
				<br/>
				Discussion: how to model sample pooling in this model?
				<br/>
				More Discussion: do we want to have type specific subclasses? No,
				because you can solve this by casting during querying?
			
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "ObservedValue"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.pheno.db.ObservedValueEntityListener.class})
public class ObservedValue extends org.molgenis.util.AbstractEntity implements org.molgenis.pheno.Observation
{
	// fieldname constants
	public final static String ID = "id";
	public final static String INVESTIGATION = "Investigation";
	public final static String INVESTIGATION_NAME = "Investigation_name";
	public final static String PROTOCOLAPPLICATION = "protocolApplication";
	public final static String PROTOCOLAPPLICATION_NAME = "protocolApplication_name";
	public final static String FEATURE = "Feature";
	public final static String FEATURE_NAME = "Feature_name";
	public final static String TARGET = "Target";
	public final static String TARGET_NAME = "Target_name";
	public final static String ONTOLOGYREFERENCE = "ontologyReference";
	public final static String ONTOLOGYREFERENCE_NAME = "ontologyReference_name";
	public final static String VALUE = "value";
	public final static String RELATION = "relation";
	public final static String RELATION_NAME = "relation_name";
	public final static String TIME = "time";
	public final static String ENDTIME = "endtime";
	
	//static methods
	/**
	 * Shorthand for db.query(ObservedValue.class).
	 */
	public static org.molgenis.framework.db.Query<? extends ObservedValue> query(org.molgenis.framework.db.Database db)
	{
		return db.query(ObservedValue.class);
	}
	
	/**
	 * Shorthand for db.find(ObservedValue.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends ObservedValue> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(ObservedValue.class, rules);
	}	
	
	/**
	 * 
	 */
	public static ObservedValue findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservedValue> q = db.query(ObservedValue.class);
		q.eq(ObservedValue.ID, id);
		java.util.List<ObservedValue> result = q.find();
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


	//Investigation[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Investigation")   	
	
				

	private org.molgenis.organization.Investigation investigation = null;
	@javax.persistence.Transient
	private Integer investigation_id = null;	
	@javax.persistence.Transient
	private String investigation_name = null;						


	//Reference to the protocol application that was used to produce this observation. For example a particular patient visit or the application of a microarray or the calculation of a QTL model[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="protocolApplication")   	
	
				

	private org.molgenis.protocol.ProtocolApplication protocolApplication = null;
	@javax.persistence.Transient
	private Integer protocolApplication_id = null;	
	@javax.persistence.Transient
	private String protocolApplication_name = null;						


	//References the ObservableFeature that this observation was made on. For example 'probe123'. Can be ommited for 1D data (i.e., a data list).[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Feature", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.pheno.ObservationElement feature = null;
	@javax.persistence.Transient
	private Integer feature_id = null;	
	@javax.persistence.Transient
	private String feature_name = null;						


	//References the ObservationTarget that this feature was made on. For example 'individual1'. In a correlation matrix this could be also 'probe123'.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Target", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.pheno.ObservationElement target = null;
	@javax.persistence.Transient
	private Integer target_id = null;	
	@javax.persistence.Transient
	private String target_name = null;						


	//(Optional) Reference to the     ontology definition or 'code' for this value (recommended for non-numeric     values such as codes)[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="ontologyReference")   	
	
				

	private org.molgenis.core.OntologyTerm ontologyReference = null;
	@javax.persistence.Transient
	private Integer ontologyReference_id = null;	
	@javax.persistence.Transient
	private String ontologyReference_name = null;						


	//The value observed[type=string]
	@javax.persistence.Column(name="value")
	@javax.xml.bind.annotation.XmlElement(name="value")
	
				

	private String value =  null;


	//Reference to other end of the relationship, if any. For example to a 'brother' or from 'sample' to 'derivedSample'.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="relation")   	
	
				

	private org.molgenis.pheno.ObservationElement relation = null;
	@javax.persistence.Transient
	private Integer relation_id = null;	
	@javax.persistence.Transient
	private String relation_name = null;						


	//(Optional) Time when the value was observed. For example in time series or if feature is time-dependent like 'age'[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="time")
	@javax.xml.bind.annotation.XmlElement(name="time")
	
				

	private java.util.Date time =  null;


	//(Optional) Time when the value's validity ended[type=datetime]
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@javax.persistence.Column(name="endtime")
	@javax.xml.bind.annotation.XmlElement(name="endtime")
	
				

	private java.util.Date endtime =  null;

	//constructors
	public ObservedValue()
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
	 * Get the Investigation.
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
	 * Set the Investigation.
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
	 * Get the Reference to the protocol application that was used to produce this observation. For example a particular patient visit or the application of a microarray or the calculation of a QTL model.
	 * @return protocolApplication.
	 */
	public org.molgenis.protocol.ProtocolApplication getProtocolApplication()
	{
		return this.protocolApplication;
	}
	
	@Deprecated
	public org.molgenis.protocol.ProtocolApplication getProtocolApplication(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Reference to the protocol application that was used to produce this observation. For example a particular patient visit or the application of a microarray or the calculation of a QTL model.
	 * @param protocolApplication
	 */
	public void setProtocolApplication( org.molgenis.protocol.ProtocolApplication protocolApplication)
	{
		
		this.protocolApplication = protocolApplication;
	}

	
	
	/**
	 * Set foreign key for field protocolApplication.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setProtocolApplication_Id(Integer protocolApplication_id)
	{
		this.protocolApplication_id = protocolApplication_id;
	}	

	public void setProtocolApplication(Integer protocolApplication_id)
	{
		this.protocolApplication_id = protocolApplication_id;
	}
	
	public Integer getProtocolApplication_Id()
	{
		
		if(protocolApplication != null) 
		{
			return protocolApplication.getId();
		}
		else
		{
			return protocolApplication_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference ProtocolApplication to ProtocolApplication.Id.
	 */
	public String getProtocolApplication_Name()
	{		
		//FIXME should we auto-load based on getProtocolApplication()?	
		if(protocolApplication != null) {
			return protocolApplication.getName();
		} else {
			return protocolApplication_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference ProtocolApplication to <a href="ProtocolApplication.html#Id">ProtocolApplication.Id</a>.
	 * Implies setProtocolApplication(null) until save
	 */
	public void setProtocolApplication_Name(String protocolApplication_name)
	{
		this.protocolApplication_name = protocolApplication_name;
	}		
	 
	

	/**
	 * Get the References the ObservableFeature that this observation was made on. For example 'probe123'. Can be ommited for 1D data (i.e., a data list)..
	 * @return feature.
	 */
	public org.molgenis.pheno.ObservationElement getFeature()
	{
		return this.feature;
	}
	
	@Deprecated
	public org.molgenis.pheno.ObservationElement getFeature(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the References the ObservableFeature that this observation was made on. For example 'probe123'. Can be ommited for 1D data (i.e., a data list)..
	 * @param feature
	 */
	public void setFeature( org.molgenis.pheno.ObservationElement feature)
	{
		
		this.feature = feature;
	}

	
	
	/**
	 * Set foreign key for field feature.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setFeature_Id(Integer feature_id)
	{
		this.feature_id = feature_id;
	}	

	public void setFeature(Integer feature_id)
	{
		this.feature_id = feature_id;
	}
	
	public Integer getFeature_Id()
	{
		
		if(feature != null) 
		{
			return feature.getId();
		}
		else
		{
			return feature_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Feature to ObservationElement.Id.
	 */
	public String getFeature_Name()
	{		
		//FIXME should we auto-load based on getFeature()?	
		if(feature != null) {
			return feature.getName();
		} else {
			return feature_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Feature to <a href="ObservationElement.html#Id">ObservationElement.Id</a>.
	 * Implies setFeature(null) until save
	 */
	public void setFeature_Name(String feature_name)
	{
		this.feature_name = feature_name;
	}		
	 
	

	/**
	 * Get the References the ObservationTarget that this feature was made on. For example 'individual1'. In a correlation matrix this could be also 'probe123'..
	 * @return target.
	 */
	public org.molgenis.pheno.ObservationElement getTarget()
	{
		return this.target;
	}
	
	@Deprecated
	public org.molgenis.pheno.ObservationElement getTarget(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the References the ObservationTarget that this feature was made on. For example 'individual1'. In a correlation matrix this could be also 'probe123'..
	 * @param target
	 */
	public void setTarget( org.molgenis.pheno.ObservationElement target)
	{
		
		this.target = target;
	}

	
	
	/**
	 * Set foreign key for field target.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setTarget_Id(Integer target_id)
	{
		this.target_id = target_id;
	}	

	public void setTarget(Integer target_id)
	{
		this.target_id = target_id;
	}
	
	public Integer getTarget_Id()
	{
		
		if(target != null) 
		{
			return target.getId();
		}
		else
		{
			return target_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Target to ObservationElement.Id.
	 */
	public String getTarget_Name()
	{		
		//FIXME should we auto-load based on getTarget()?	
		if(target != null) {
			return target.getName();
		} else {
			return target_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Target to <a href="ObservationElement.html#Id">ObservationElement.Id</a>.
	 * Implies setTarget(null) until save
	 */
	public void setTarget_Name(String target_name)
	{
		this.target_name = target_name;
	}		
	 
	

	/**
	 * Get the (Optional) Reference to the     ontology definition or 'code' for this value (recommended for non-numeric     values such as codes).
	 * @return ontologyReference.
	 */
	public org.molgenis.core.OntologyTerm getOntologyReference()
	{
		return this.ontologyReference;
	}
	
	@Deprecated
	public org.molgenis.core.OntologyTerm getOntologyReference(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) Reference to the     ontology definition or 'code' for this value (recommended for non-numeric     values such as codes).
	 * @param ontologyReference
	 */
	public void setOntologyReference( org.molgenis.core.OntologyTerm ontologyReference)
	{
		
		this.ontologyReference = ontologyReference;
	}

	
	
	/**
	 * Set foreign key for field ontologyReference.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setOntologyReference_Id(Integer ontologyReference_id)
	{
		this.ontologyReference_id = ontologyReference_id;
	}	

	public void setOntologyReference(Integer ontologyReference_id)
	{
		this.ontologyReference_id = ontologyReference_id;
	}
	
	public Integer getOntologyReference_Id()
	{
		
		if(ontologyReference != null) 
		{
			return ontologyReference.getId();
		}
		else
		{
			return ontologyReference_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference OntologyReference to OntologyTerm.Id.
	 */
	public String getOntologyReference_Name()
	{		
		//FIXME should we auto-load based on getOntologyReference()?	
		if(ontologyReference != null) {
			return ontologyReference.getName();
		} else {
			return ontologyReference_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference OntologyReference to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setOntologyReference(null) until save
	 */
	public void setOntologyReference_Name(String ontologyReference_name)
	{
		this.ontologyReference_name = ontologyReference_name;
	}		
	 
	

	/**
	 * Get the The value observed.
	 * @return value.
	 */
	public String getValue()
	{
		return this.value;
	}
	
	@Deprecated
	public String getValue(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The value observed.
	 * @param value
	 */
	public void setValue( String value)
	{
		
		this.value = value;
	}

	

	/**
	 * Get the Reference to other end of the relationship, if any. For example to a 'brother' or from 'sample' to 'derivedSample'..
	 * @return relation.
	 */
	public org.molgenis.pheno.ObservationElement getRelation()
	{
		return this.relation;
	}
	
	@Deprecated
	public org.molgenis.pheno.ObservationElement getRelation(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Reference to other end of the relationship, if any. For example to a 'brother' or from 'sample' to 'derivedSample'..
	 * @param relation
	 */
	public void setRelation( org.molgenis.pheno.ObservationElement relation)
	{
		
		this.relation = relation;
	}

	
	
	/**
	 * Set foreign key for field relation.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setRelation_Id(Integer relation_id)
	{
		this.relation_id = relation_id;
	}	

	public void setRelation(Integer relation_id)
	{
		this.relation_id = relation_id;
	}
	
	public Integer getRelation_Id()
	{
		
		if(relation != null) 
		{
			return relation.getId();
		}
		else
		{
			return relation_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Relation to ObservationElement.Id.
	 */
	public String getRelation_Name()
	{		
		//FIXME should we auto-load based on getRelation()?	
		if(relation != null) {
			return relation.getName();
		} else {
			return relation_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Relation to <a href="ObservationElement.html#Id">ObservationElement.Id</a>.
	 * Implies setRelation(null) until save
	 */
	public void setRelation_Name(String relation_name)
	{
		this.relation_name = relation_name;
	}		
	 
	

	/**
	 * Get the (Optional) Time when the value was observed. For example in time series or if feature is time-dependent like 'age'.
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
	 * Set the (Optional) Time when the value was observed. For example in time series or if feature is time-dependent like 'age'.
	 * @param time
	 */
	public void setTime( java.util.Date time)
	{
		
		this.time = time;
	}

	

	/**
	 * Get the (Optional) Time when the value's validity ended.
	 * @return endtime.
	 */
	public java.util.Date getEndtime()
	{
		return this.endtime;
	}
	
	@Deprecated
	public java.util.Date getEndtime(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) Time when the value's validity ended.
	 * @param endtime
	 */
	public void setEndtime( java.util.Date endtime)
	{
		
		this.endtime = endtime;
	}

	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("investigation"))
			return getInvestigation();
		if(name.toLowerCase().equals("investigation_id"))
			return getInvestigation_Id();
		if(name.toLowerCase().equals("investigation_name"))
			return getInvestigation_Name();
		if (name.toLowerCase().equals("protocolapplication"))
			return getProtocolApplication();
		if(name.toLowerCase().equals("protocolapplication_id"))
			return getProtocolApplication_Id();
		if(name.toLowerCase().equals("protocolapplication_name"))
			return getProtocolApplication_Name();
		if (name.toLowerCase().equals("feature"))
			return getFeature();
		if(name.toLowerCase().equals("feature_id"))
			return getFeature_Id();
		if(name.toLowerCase().equals("feature_name"))
			return getFeature_Name();
		if (name.toLowerCase().equals("target"))
			return getTarget();
		if(name.toLowerCase().equals("target_id"))
			return getTarget_Id();
		if(name.toLowerCase().equals("target_name"))
			return getTarget_Name();
		if (name.toLowerCase().equals("ontologyreference"))
			return getOntologyReference();
		if(name.toLowerCase().equals("ontologyreference_id"))
			return getOntologyReference_Id();
		if(name.toLowerCase().equals("ontologyreference_name"))
			return getOntologyReference_Name();
		if (name.toLowerCase().equals("value"))
			return getValue();
		if (name.toLowerCase().equals("relation"))
			return getRelation();
		if(name.toLowerCase().equals("relation_id"))
			return getRelation_Id();
		if(name.toLowerCase().equals("relation_name"))
			return getRelation_Name();
		if (name.toLowerCase().equals("time"))
			return getTime();
		if (name.toLowerCase().equals("endtime"))
			return getEndtime();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getFeature() == null) throw new org.molgenis.framework.db.DatabaseException("required field feature is null");
		if(this.getTarget() == null) throw new org.molgenis.framework.db.DatabaseException("required field target is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Id
			this.setId(tuple.getInt("id"));
			//set Investigation
			this.setInvestigation(tuple.getInt("Investigation"));
			//set label name for xref field Investigation
			this.setInvestigation_Name(tuple.getString("Investigation_name"));	
			//set ProtocolApplication
			this.setProtocolApplication(tuple.getInt("protocolApplication"));
			//set label name for xref field ProtocolApplication
			this.setProtocolApplication_Name(tuple.getString("protocolApplication_name"));	
			//set Feature
			this.setFeature(tuple.getInt("Feature"));
			//set label name for xref field Feature
			this.setFeature_Name(tuple.getString("Feature_name"));	
			//set Target
			this.setTarget(tuple.getInt("Target"));
			//set label name for xref field Target
			this.setTarget_Name(tuple.getString("Target_name"));	
			//set OntologyReference
			this.setOntologyReference(tuple.getInt("ontologyReference"));
			//set label name for xref field OntologyReference
			this.setOntologyReference_Name(tuple.getString("ontologyReference_name"));	
			//set Value
			this.setValue(tuple.getString("value"));
			//set Relation
			this.setRelation(tuple.getInt("relation"));
			//set label name for xref field Relation
			this.setRelation_Name(tuple.getString("relation_name"));	
			//set Time
			this.setTime(tuple.getTimestamp("time"));
			//set Endtime
			this.setEndtime(tuple.getTimestamp("endtime"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("ObservedValue_id") != null) this.setId(tuple.getInt("ObservedValue_id"));
			//set Investigation
			if( strict || tuple.getInt("Investigation_id") != null) this.setInvestigation(tuple.getInt("Investigation_id"));
			if( tuple.getInt("ObservedValue_Investigation_id") != null) this.setInvestigation(tuple.getInt("ObservedValue_Investigation_id"));
			//alias of xref
			if( tuple.getObject("Investigation") != null) this.setInvestigation(tuple.getInt("Investigation"));
			if( tuple.getObject("ObservedValue_Investigation") != null) this.setInvestigation(tuple.getInt("ObservedValue_Investigation"));
			//set label for field Investigation
			if( strict || tuple.getObject("Investigation_name") != null) this.setInvestigation_Name(tuple.getString("Investigation_name"));			
			if( tuple.getObject("ObservedValue_Investigation_name") != null ) this.setInvestigation_Name(tuple.getString("ObservedValue_Investigation_name"));		
			//set ProtocolApplication
			if( strict || tuple.getInt("protocolApplication_id") != null) this.setProtocolApplication(tuple.getInt("protocolApplication_id"));
			if( tuple.getInt("ObservedValue_protocolApplication_id") != null) this.setProtocolApplication(tuple.getInt("ObservedValue_protocolApplication_id"));
			//alias of xref
			if( tuple.getObject("protocolApplication") != null) this.setProtocolApplication(tuple.getInt("protocolApplication"));
			if( tuple.getObject("ObservedValue_protocolApplication") != null) this.setProtocolApplication(tuple.getInt("ObservedValue_protocolApplication"));
			//set label for field ProtocolApplication
			if( strict || tuple.getObject("protocolApplication_name") != null) this.setProtocolApplication_Name(tuple.getString("protocolApplication_name"));			
			if( tuple.getObject("ObservedValue_protocolApplication_name") != null ) this.setProtocolApplication_Name(tuple.getString("ObservedValue_protocolApplication_name"));		
			//set Feature
			if( strict || tuple.getInt("Feature_id") != null) this.setFeature(tuple.getInt("Feature_id"));
			if( tuple.getInt("ObservedValue_Feature_id") != null) this.setFeature(tuple.getInt("ObservedValue_Feature_id"));
			//alias of xref
			if( tuple.getObject("Feature") != null) this.setFeature(tuple.getInt("Feature"));
			if( tuple.getObject("ObservedValue_Feature") != null) this.setFeature(tuple.getInt("ObservedValue_Feature"));
			//set label for field Feature
			if( strict || tuple.getObject("Feature_name") != null) this.setFeature_Name(tuple.getString("Feature_name"));			
			if( tuple.getObject("ObservedValue_Feature_name") != null ) this.setFeature_Name(tuple.getString("ObservedValue_Feature_name"));		
			//set Target
			if( strict || tuple.getInt("Target_id") != null) this.setTarget(tuple.getInt("Target_id"));
			if( tuple.getInt("ObservedValue_Target_id") != null) this.setTarget(tuple.getInt("ObservedValue_Target_id"));
			//alias of xref
			if( tuple.getObject("Target") != null) this.setTarget(tuple.getInt("Target"));
			if( tuple.getObject("ObservedValue_Target") != null) this.setTarget(tuple.getInt("ObservedValue_Target"));
			//set label for field Target
			if( strict || tuple.getObject("Target_name") != null) this.setTarget_Name(tuple.getString("Target_name"));			
			if( tuple.getObject("ObservedValue_Target_name") != null ) this.setTarget_Name(tuple.getString("ObservedValue_Target_name"));		
			//set OntologyReference
			if( strict || tuple.getInt("ontologyReference_id") != null) this.setOntologyReference(tuple.getInt("ontologyReference_id"));
			if( tuple.getInt("ObservedValue_ontologyReference_id") != null) this.setOntologyReference(tuple.getInt("ObservedValue_ontologyReference_id"));
			//alias of xref
			if( tuple.getObject("ontologyReference") != null) this.setOntologyReference(tuple.getInt("ontologyReference"));
			if( tuple.getObject("ObservedValue_ontologyReference") != null) this.setOntologyReference(tuple.getInt("ObservedValue_ontologyReference"));
			//set label for field OntologyReference
			if( strict || tuple.getObject("ontologyReference_name") != null) this.setOntologyReference_Name(tuple.getString("ontologyReference_name"));			
			if( tuple.getObject("ObservedValue_ontologyReference_name") != null ) this.setOntologyReference_Name(tuple.getString("ObservedValue_ontologyReference_name"));		
			//set Value
			if( strict || tuple.getString("value") != null) this.setValue(tuple.getString("value"));
			if( tuple.getString("ObservedValue_value") != null) this.setValue(tuple.getString("ObservedValue_value"));
			//set Relation
			if( strict || tuple.getInt("relation_id") != null) this.setRelation(tuple.getInt("relation_id"));
			if( tuple.getInt("ObservedValue_relation_id") != null) this.setRelation(tuple.getInt("ObservedValue_relation_id"));
			//alias of xref
			if( tuple.getObject("relation") != null) this.setRelation(tuple.getInt("relation"));
			if( tuple.getObject("ObservedValue_relation") != null) this.setRelation(tuple.getInt("ObservedValue_relation"));
			//set label for field Relation
			if( strict || tuple.getObject("relation_name") != null) this.setRelation_Name(tuple.getString("relation_name"));			
			if( tuple.getObject("ObservedValue_relation_name") != null ) this.setRelation_Name(tuple.getString("ObservedValue_relation_name"));		
			//set Time
			if( strict || tuple.getTimestamp("time") != null) this.setTime(tuple.getTimestamp("time"));
			if( tuple.getTimestamp("ObservedValue_time") != null) this.setTime(tuple.getTimestamp("ObservedValue_time"));
			//set Endtime
			if( strict || tuple.getTimestamp("endtime") != null) this.setEndtime(tuple.getTimestamp("endtime"));
			if( tuple.getTimestamp("ObservedValue_endtime") != null) this.setEndtime(tuple.getTimestamp("ObservedValue_endtime"));
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
		String result = "ObservedValue(";
		result+= "id='" + getId()+"' ";	
		result+= " investigation_id='" + getInvestigation_Id()+"' ";	
		result+= " investigation_name='" + getInvestigation_Name()+"' ";
		result+= " protocolApplication_id='" + getProtocolApplication_Id()+"' ";	
		result+= " protocolApplication_name='" + getProtocolApplication_Name()+"' ";
		result+= " feature_id='" + getFeature_Id()+"' ";	
		result+= " feature_name='" + getFeature_Name()+"' ";
		result+= " target_id='" + getTarget_Id()+"' ";	
		result+= " target_name='" + getTarget_Name()+"' ";
		result+= " ontologyReference_id='" + getOntologyReference_Id()+"' ";	
		result+= " ontologyReference_name='" + getOntologyReference_Name()+"' ";
		result+= "value='" + getValue()+"' ";	
		result+= " relation_id='" + getRelation_Id()+"' ";	
		result+= " relation_name='" + getRelation_Name()+"' ";
		result+= "time='" + (getTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getTime()))+"' ";
		result+= "time='" + (getTime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getTime()))+"' ";		
		result+= "endtime='" + (getEndtime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy, HH:mm:ss", java.util.Locale.US).format(getEndtime()))+"'";
		result+= "endtime='" + (getEndtime() == null ? "" : new java.text.SimpleDateFormat("MMMM d, yyyy", java.util.Locale.US).format(getEndtime()))+"'";		
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of ObservedValue.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("investigation_id");
		}
		fields.add("investigation_name");
		{
			fields.add("protocolApplication_id");
		}
		fields.add("protocolApplication_name");
		{
			fields.add("feature_id");
		}
		fields.add("feature_name");
		{
			fields.add("target_id");
		}
		fields.add("target_name");
		{
			fields.add("ontologyReference_id");
		}
		fields.add("ontologyReference_name");
		{
			fields.add("value");
		}
		{
			fields.add("relation_id");
		}
		fields.add("relation_name");
		{
			fields.add("time");
		}
		{
			fields.add("endtime");
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
		+ "investigation" +sep
		+ "protocolApplication" +sep
		+ "feature" +sep
		+ "target" +sep
		+ "ontologyReference" +sep
		+ "value" +sep
		+ "relation" +sep
		+ "time" +sep
		+ "endtime" 
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
        if (fieldName.equalsIgnoreCase("protocolApplication")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("feature")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("target")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("ontologyReference")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("relation")) {
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
		ObservedValue rhs = (ObservedValue) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
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
			Object valueO = getProtocolApplication();
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
			Object valueO = getFeature();
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
			Object valueO = getTarget();
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
			Object valueO = getValue();
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
			Object valueO = getRelation();
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
			Object valueO = getEndtime();
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
	public ObservedValue create(org.molgenis.util.Tuple tuple) throws Exception
	{
		ObservedValue e = new ObservedValue();
		e.set(tuple);
		return e;
	}
	

	
}

