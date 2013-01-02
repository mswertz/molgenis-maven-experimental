
/* File:        observ/model/Measurement.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.pheno;

/**
 * Measurement: Generic obserable feature to flexibly define a
				measurement
			
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Measurement"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.pheno.db.MeasurementEntityListener.class})
public class Measurement extends org.molgenis.pheno.ObservableFeature 
{
	// fieldname constants
	public final static String UNIT = "unit";
	public final static String UNIT_NAME = "unit_name";
	public final static String DATATYPE = "dataType";
	public final static String TEMPORAL = "temporal";
	public final static String CATEGORIES = "categories";
	public final static String CATEGORIES_NAME = "categories_name";
	public final static String DESCRIPTION = "description";
	public final static String TARGETTYPEALLOWEDFORRELATION = "targettypeAllowedForRelation";
	public final static String TARGETTYPEALLOWEDFORRELATION_CLASSNAME = "targettypeAllowedForRelation_className";
	public final static String PANELLABELALLOWEDFORRELATION = "panelLabelAllowedForRelation";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(Measurement.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Measurement> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Measurement.class);
	}
	
	/**
	 * Shorthand for db.find(Measurement.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Measurement> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Measurement.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Measurement findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Measurement> q = db.query(Measurement.class);
		q.eq(Measurement.ID, id);
		java.util.List<Measurement> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Measurement findByNameInvestigation(org.molgenis.framework.db.Database db, String name, Integer investigation) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Measurement> q = db.query(Measurement.class);
		q.eq(Measurement.NAME, name);q.eq(Measurement.INVESTIGATION, investigation);
		java.util.List<Measurement> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Measurement findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Measurement> q = db.query(Measurement.class);
		q.eq(Measurement.NAME, name);
		java.util.List<Measurement> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//(Optional) Reference to the well-defined measurement unit used to observe this feature       (if feature is that concrete). E.g. mmHg[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="unit")   	
	
				

	private org.molgenis.core.OntologyTerm unit = null;
	@javax.persistence.Transient
	private Integer unit_id = null;	
	@javax.persistence.Transient
	private String unit_name = null;						


	//(Optional) Reference to the technical data type. E.g. 'int'[type=enum]
	@javax.persistence.Column(name="dataType", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="dataType")
	
				

	@javax.validation.constraints.NotNull
	private String dataType =  "string";
	@javax.persistence.Transient
	private String dataType_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.util.ValueLabel> dataType_options = new java.util.ArrayList<org.molgenis.util.ValueLabel>();


	//Whether this feature is time dependent and can have different values when measured       on different times (e.g. weight, temporal=true) or generally only measured once (e.g. birth date,       temporal=false)[type=bool]
	@javax.persistence.Column(name="temporal", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="temporal")
	
				

	@javax.validation.constraints.NotNull
	private Boolean temporal =  false;


	//Translation of codes into categories if applicable[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="categories", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="Measurement_categories", 
			joinColumns=@javax.persistence.JoinColumn(name="Measurement"), inverseJoinColumns=@javax.persistence.JoinColumn(name="categories"))
	
				

	private java.util.List<org.molgenis.pheno.Category> categories = new java.util.ArrayList<org.molgenis.pheno.Category>();
	@javax.persistence.Transient
	private java.util.List<Integer> categories_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> categories_name = new java.util.ArrayList<String>();


	//(Optional) Rudimentary meta data about the observable feature. Use of ontology       terms references to establish unambigious descriptions is recommended[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="description", length=16777216)
	
				

	private String description =  null;


	//Subclass of ObservationTarget (Individual, Panel or Location) that      can be linked to (through the 'relation' field in ObservedValue) when using this       Measurement (example: a Measurement 'Species' can only result in ObservedValues       that have relations to Panels)[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="targettypeAllowedForRelation")   	
	
				

	private org.molgenis.core.MolgenisEntity targettypeAllowedForRelation = null;
	@javax.persistence.Transient
	private Integer targettypeAllowedForRelation_id = null;	
	@javax.persistence.Transient
	private String targettypeAllowedForRelation_className = null;						


	//Label that must have been applied to the Panel that      can be linked to (through the 'relation' field in ObservedValue) when using this       Measurement (example: a Measurement 'Species' can only result      in ObservedValues that have relations to Panels labeled as 'Species')[type=string]
	@javax.persistence.Column(name="panelLabelAllowedForRelation")
	@javax.xml.bind.annotation.XmlElement(name="panelLabelAllowedForRelation")
	
				

	private String panelLabelAllowedForRelation =  null;


	//automatically generated id[type=int]
	

	//constructors
	public Measurement()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
		//options for enum DataType
		dataType_options.add(new org.molgenis.util.ValueLabel("xref","xref"));
		dataType_options.add(new org.molgenis.util.ValueLabel("string","string"));
		dataType_options.add(new org.molgenis.util.ValueLabel("categorical","categorical"));
		dataType_options.add(new org.molgenis.util.ValueLabel("date","date"));
		dataType_options.add(new org.molgenis.util.ValueLabel("datetime","datetime"));
		dataType_options.add(new org.molgenis.util.ValueLabel("int","int"));
		dataType_options.add(new org.molgenis.util.ValueLabel("code","code"));
		dataType_options.add(new org.molgenis.util.ValueLabel("image","image"));
		dataType_options.add(new org.molgenis.util.ValueLabel("decimal","decimal"));
		dataType_options.add(new org.molgenis.util.ValueLabel("bool","bool"));
		dataType_options.add(new org.molgenis.util.ValueLabel("file","file"));
		dataType_options.add(new org.molgenis.util.ValueLabel("log","log"));
		dataType_options.add(new org.molgenis.util.ValueLabel("data","data"));
		dataType_options.add(new org.molgenis.util.ValueLabel("exe","exe"));
	}
	
	//getters and setters
	/**
	 * Get the (Optional) Reference to the well-defined measurement unit used to observe this feature       (if feature is that concrete). E.g. mmHg.
	 * @return unit.
	 */
	public org.molgenis.core.OntologyTerm getUnit()
	{
		return this.unit;
	}
	
	@Deprecated
	public org.molgenis.core.OntologyTerm getUnit(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) Reference to the well-defined measurement unit used to observe this feature       (if feature is that concrete). E.g. mmHg.
	 * @param unit
	 */
	public void setUnit( org.molgenis.core.OntologyTerm unit)
	{
		
		this.unit = unit;
	}

	
	
	/**
	 * Set foreign key for field unit.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setUnit_Id(Integer unit_id)
	{
		this.unit_id = unit_id;
	}	

	public void setUnit(Integer unit_id)
	{
		this.unit_id = unit_id;
	}
	
	public Integer getUnit_Id()
	{
		
		if(unit != null) 
		{
			return unit.getId();
		}
		else
		{
			return unit_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Unit to OntologyTerm.Id.
	 */
	public String getUnit_Name()
	{		
		//FIXME should we auto-load based on getUnit()?	
		if(unit != null) {
			return unit.getName();
		} else {
			return unit_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Unit to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setUnit(null) until save
	 */
	public void setUnit_Name(String unit_name)
	{
		this.unit_name = unit_name;
	}		
	 
	

	/**
	 * Get the (Optional) Reference to the technical data type. E.g. 'int'.
	 * @return dataType.
	 */
	public String getDataType()
	{
		return this.dataType;
	}
	
	@Deprecated
	public String getDataType(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the (Optional) Reference to the technical data type. E.g. 'int'.
	 * @param dataType
	 */
	public void setDataType( String dataType)
	{
		
		this.dataType = dataType;
	}

	
	/**
	 * Get tha label for enum DataType.
	 */
	public String getDataTypeLabel()
	{
		return this.dataType_label;
	}
	
	/**
	 * DataType is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.util.ValueLabel> getDataTypeOptions()
	{
		return dataType_options;
	}	
	

	/**
	 * Get the Whether this feature is time dependent and can have different values when measured       on different times (e.g. weight, temporal=true) or generally only measured once (e.g. birth date,       temporal=false).
	 * @return temporal.
	 */
	public Boolean getTemporal()
	{
		return this.temporal;
	}
	
	@Deprecated
	public Boolean getTemporal(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Whether this feature is time dependent and can have different values when measured       on different times (e.g. weight, temporal=true) or generally only measured once (e.g. birth date,       temporal=false).
	 * @param temporal
	 */
	public void setTemporal( Boolean temporal)
	{
		
		this.temporal = temporal;
	}

	

	/**
	 * Get the Translation of codes into categories if applicable.
	 * @return categories.
	 */
	public java.util.List<org.molgenis.pheno.Category> getCategories()
	{
		return this.categories;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.pheno.Category> getCategories(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Translation of codes into categories if applicable.
	 * @param categories
	 */
	public void setCategories( java.util.List<org.molgenis.pheno.Category> categories)
	{
		
		this.categories = categories;
	}

	
	public void setCategories_Id(Integer ... categories)
	{
		this.setCategories_Id(java.util.Arrays.asList(categories));
	}	
	
	public void setCategories(org.molgenis.pheno.Category ... categories)
	{
		this.setCategories(java.util.Arrays.asList(categories));
	}	
	
	/**
	 * Set foreign key for field categories.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setCategories_Id(java.util.List<Integer> categories_id)
	{
		this.categories_id = categories_id;
	}	
	
	public java.util.List<Integer> getCategories_Id()
	{
		return categories_id;
	}	
	
	/**
	 * Get a pretty label for cross reference Categories to <a href="Category.html#Id">Category.Id</a>.
	 */
	public java.util.List<String> getCategories_Name()
	{
		return categories_name;
	}
	
	/**
	 * Update the foreign key Categories
	 * This sets categories to null until next database transaction.
	 */
	public void setCategories_Name(java.util.List<String> categories_name)
	{
		this.categories_name = categories_name;
	}		
	

	/**
	 * Get the (Optional) Rudimentary meta data about the observable feature. Use of ontology       terms references to establish unambigious descriptions is recommended.
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
	 * Set the (Optional) Rudimentary meta data about the observable feature. Use of ontology       terms references to establish unambigious descriptions is recommended.
	 * @param description
	 */
	public void setDescription( String description)
	{
				//hack to solve problem with variable hidden in supertype
				super.setDescription(description);
				//2222hack to solve problem with variable hidden in supertype
				super.setDescription(description);
		
		this.description = description;
	}

	

	/**
	 * Get the Subclass of ObservationTarget (Individual, Panel or Location) that      can be linked to (through the 'relation' field in ObservedValue) when using this       Measurement (example: a Measurement 'Species' can only result in ObservedValues       that have relations to Panels).
	 * @return targettypeAllowedForRelation.
	 */
	public org.molgenis.core.MolgenisEntity getTargettypeAllowedForRelation()
	{
		return this.targettypeAllowedForRelation;
	}
	
	@Deprecated
	public org.molgenis.core.MolgenisEntity getTargettypeAllowedForRelation(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Subclass of ObservationTarget (Individual, Panel or Location) that      can be linked to (through the 'relation' field in ObservedValue) when using this       Measurement (example: a Measurement 'Species' can only result in ObservedValues       that have relations to Panels).
	 * @param targettypeAllowedForRelation
	 */
	public void setTargettypeAllowedForRelation( org.molgenis.core.MolgenisEntity targettypeAllowedForRelation)
	{
		
		this.targettypeAllowedForRelation = targettypeAllowedForRelation;
	}

	
	
	/**
	 * Set foreign key for field targettypeAllowedForRelation.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setTargettypeAllowedForRelation_Id(Integer targettypeAllowedForRelation_id)
	{
		this.targettypeAllowedForRelation_id = targettypeAllowedForRelation_id;
	}	

	public void setTargettypeAllowedForRelation(Integer targettypeAllowedForRelation_id)
	{
		this.targettypeAllowedForRelation_id = targettypeAllowedForRelation_id;
	}
	
	public Integer getTargettypeAllowedForRelation_Id()
	{
		
		if(targettypeAllowedForRelation != null) 
		{
			return targettypeAllowedForRelation.getId();
		}
		else
		{
			return targettypeAllowedForRelation_id;
		}
	}	
	 
	/**
	 * Get a pretty label className for cross reference TargettypeAllowedForRelation to MolgenisEntity.Id.
	 */
	public String getTargettypeAllowedForRelation_ClassName()
	{		
		//FIXME should we auto-load based on getTargettypeAllowedForRelation()?	
		if(targettypeAllowedForRelation != null) {
			return targettypeAllowedForRelation.getClassName();
		} else {
			return targettypeAllowedForRelation_className;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference TargettypeAllowedForRelation to <a href="MolgenisEntity.html#Id">MolgenisEntity.Id</a>.
	 * Implies setTargettypeAllowedForRelation(null) until save
	 */
	public void setTargettypeAllowedForRelation_ClassName(String targettypeAllowedForRelation_className)
	{
		this.targettypeAllowedForRelation_className = targettypeAllowedForRelation_className;
	}		
	 
	

	/**
	 * Get the Label that must have been applied to the Panel that      can be linked to (through the 'relation' field in ObservedValue) when using this       Measurement (example: a Measurement 'Species' can only result      in ObservedValues that have relations to Panels labeled as 'Species').
	 * @return panelLabelAllowedForRelation.
	 */
	public String getPanelLabelAllowedForRelation()
	{
		return this.panelLabelAllowedForRelation;
	}
	
	@Deprecated
	public String getPanelLabelAllowedForRelation(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Label that must have been applied to the Panel that      can be linked to (through the 'relation' field in ObservedValue) when using this       Measurement (example: a Measurement 'Species' can only result      in ObservedValues that have relations to Panels labeled as 'Species').
	 * @param panelLabelAllowedForRelation
	 */
	public void setPanelLabelAllowedForRelation( String panelLabelAllowedForRelation)
	{
		
		this.panelLabelAllowedForRelation = panelLabelAllowedForRelation;
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
		if (name.toLowerCase().equals("unit"))
			return getUnit();
		if(name.toLowerCase().equals("unit_id"))
			return getUnit_Id();
		if(name.toLowerCase().equals("unit_name"))
			return getUnit_Name();
		if (name.toLowerCase().equals("datatype"))
			return getDataType();
		if(name.toLowerCase().equals("datatype_label"))
			return getDataTypeLabel();
		if (name.toLowerCase().equals("temporal"))
			return getTemporal();
		if (name.toLowerCase().equals("categories"))
			return getCategories();
		if(name.toLowerCase().equals("categories_id"))
			return getCategories_Id();
		if(name.toLowerCase().equals("categories_name"))
			return getCategories_Name();
		if (name.toLowerCase().equals("targettypeallowedforrelation"))
			return getTargettypeAllowedForRelation();
		if(name.toLowerCase().equals("targettypeallowedforrelation_id"))
			return getTargettypeAllowedForRelation_Id();
		if(name.toLowerCase().equals("targettypeallowedforrelation_classname"))
			return getTargettypeAllowedForRelation_ClassName();
		if (name.toLowerCase().equals("panellabelallowedforrelation"))
			return getPanelLabelAllowedForRelation();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getDataType() == null) throw new org.molgenis.framework.db.DatabaseException("required field dataType is null");
		if(this.getTemporal() == null) throw new org.molgenis.framework.db.DatabaseException("required field temporal is null");
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
			//set Unit
			this.setUnit(tuple.getInt("unit"));
			//set label name for xref field Unit
			this.setUnit_Name(tuple.getString("unit_name"));	
			//set DataType
			this.setDataType(tuple.getString("dataType"));
			//set Temporal
			this.setTemporal(tuple.getBoolean("temporal"));
			//mrefs can not be directly retrieved
			//set Categories			
			//set TargettypeAllowedForRelation
			this.setTargettypeAllowedForRelation(tuple.getInt("targettypeAllowedForRelation"));
			//set label className for xref field TargettypeAllowedForRelation
			this.setTargettypeAllowedForRelation_ClassName(tuple.getString("targettypeAllowedForRelation_className"));	
			//set PanelLabelAllowedForRelation
			this.setPanelLabelAllowedForRelation(tuple.getString("panelLabelAllowedForRelation"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Measurement_id") != null) this.setId(tuple.getInt("Measurement_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("Measurement_name") != null) this.setName(tuple.getString("Measurement_name"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Measurement_description") != null) this.setDescription(tuple.getString("Measurement_description"));
			//set Investigation
			if( strict || tuple.getInt("Investigation_id") != null) this.setInvestigation(tuple.getInt("Investigation_id"));
			if( tuple.getInt("Measurement_Investigation_id") != null) this.setInvestigation(tuple.getInt("Measurement_Investigation_id"));
			//alias of xref
			if( tuple.getObject("Investigation") != null) this.setInvestigation(tuple.getInt("Investigation"));
			if( tuple.getObject("Measurement_Investigation") != null) this.setInvestigation(tuple.getInt("Measurement_Investigation"));
			//set label for field Investigation
			if( strict || tuple.getObject("Investigation_name") != null) this.setInvestigation_Name(tuple.getString("Investigation_name"));			
			if( tuple.getObject("Measurement_Investigation_name") != null ) this.setInvestigation_Name(tuple.getString("Measurement_Investigation_name"));		
			//set OntologyReference
			if( tuple.getObject("ontologyReference")!= null || tuple.getObject("Measurement_ontologyReference")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference");
				if(tuple.getObject("Measurement_ontologyReference")!= null) mrefs = tuple.getList("Measurement_ontologyReference");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setOntologyReference_Id( values );
			}
			//set labels name for mref field OntologyReference	
			if( tuple.getObject("ontologyReference_name")!= null || tuple.getObject("Measurement_ontologyReference_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference_name");
				if(tuple.getObject("Measurement_ontologyReference_name")!= null) mrefs = tuple.getList("Measurement_ontologyReference_name");
				
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
			if( tuple.getString("Measurement___Type") != null) this.set__Type(tuple.getString("Measurement___Type"));
			//set AlternateId
			if( tuple.getObject("AlternateId")!= null || tuple.getObject("Measurement_AlternateId")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("AlternateId");
				if(tuple.getObject("Measurement_AlternateId")!= null) mrefs = tuple.getList("Measurement_AlternateId");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setAlternateId_Id( values );
			}
			//set labels name for mref field AlternateId	
			if( tuple.getObject("AlternateId_name")!= null || tuple.getObject("Measurement_AlternateId_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("AlternateId_name");
				if(tuple.getObject("Measurement_AlternateId_name")!= null) mrefs = tuple.getList("Measurement_AlternateId_name");
				
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
			if( tuple.getString("Measurement_label") != null) this.setLabel(tuple.getString("Measurement_label"));
			//set Unit
			if( strict || tuple.getInt("unit_id") != null) this.setUnit(tuple.getInt("unit_id"));
			if( tuple.getInt("Measurement_unit_id") != null) this.setUnit(tuple.getInt("Measurement_unit_id"));
			//alias of xref
			if( tuple.getObject("unit") != null) this.setUnit(tuple.getInt("unit"));
			if( tuple.getObject("Measurement_unit") != null) this.setUnit(tuple.getInt("Measurement_unit"));
			//set label for field Unit
			if( strict || tuple.getObject("unit_name") != null) this.setUnit_Name(tuple.getString("unit_name"));			
			if( tuple.getObject("Measurement_unit_name") != null ) this.setUnit_Name(tuple.getString("Measurement_unit_name"));		
			//set DataType
			if( strict || tuple.getString("dataType") != null) this.setDataType(tuple.getString("dataType"));
			if( tuple.getString("Measurement_dataType") != null) this.setDataType(tuple.getString("Measurement_dataType"));
			//set Temporal
			if( strict || tuple.getBoolean("temporal") != null) this.setTemporal(tuple.getBoolean("temporal"));
			if( tuple.getBoolean("Measurement_temporal") != null) this.setTemporal(tuple.getBoolean("Measurement_temporal"));
			//set Categories
			if( tuple.getObject("categories")!= null || tuple.getObject("Measurement_categories")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("categories");
				if(tuple.getObject("Measurement_categories")!= null) mrefs = tuple.getList("Measurement_categories");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setCategories_Id( values );
			}
			//set labels name for mref field Categories	
			if( tuple.getObject("categories_name")!= null || tuple.getObject("Measurement_categories_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("categories_name");
				if(tuple.getObject("Measurement_categories_name")!= null) mrefs = tuple.getList("Measurement_categories_name");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setCategories_Name( values );			
			}	
			//set TargettypeAllowedForRelation
			if( strict || tuple.getInt("targettypeAllowedForRelation_id") != null) this.setTargettypeAllowedForRelation(tuple.getInt("targettypeAllowedForRelation_id"));
			if( tuple.getInt("Measurement_targettypeAllowedForRelation_id") != null) this.setTargettypeAllowedForRelation(tuple.getInt("Measurement_targettypeAllowedForRelation_id"));
			//alias of xref
			if( tuple.getObject("targettypeAllowedForRelation") != null) this.setTargettypeAllowedForRelation(tuple.getInt("targettypeAllowedForRelation"));
			if( tuple.getObject("Measurement_targettypeAllowedForRelation") != null) this.setTargettypeAllowedForRelation(tuple.getInt("Measurement_targettypeAllowedForRelation"));
			//set label for field TargettypeAllowedForRelation
			if( strict || tuple.getObject("targettypeAllowedForRelation_className") != null) this.setTargettypeAllowedForRelation_ClassName(tuple.getString("targettypeAllowedForRelation_className"));			
			if( tuple.getObject("Measurement_targettypeAllowedForRelation_className") != null ) this.setTargettypeAllowedForRelation_ClassName(tuple.getString("Measurement_targettypeAllowedForRelation_className"));		
			//set PanelLabelAllowedForRelation
			if( strict || tuple.getString("panelLabelAllowedForRelation") != null) this.setPanelLabelAllowedForRelation(tuple.getString("panelLabelAllowedForRelation"));
			if( tuple.getString("Measurement_panelLabelAllowedForRelation") != null) this.setPanelLabelAllowedForRelation(tuple.getString("Measurement_panelLabelAllowedForRelation"));
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
		String result = "Measurement(";
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
		result+= "label='" + getLabel()+"' ";	
		result+= " unit_id='" + getUnit_Id()+"' ";	
		result+= " unit_name='" + getUnit_Name()+"' ";
		result+= "dataType='" + getDataType()+"' ";	
		result+= "temporal='" + getTemporal()+"' ";	
		result+= " categories_id='" + getCategories_Id()+"' ";	
		result+= " categories_name='" + getCategories_Name()+"' ";
		result+= " targettypeAllowedForRelation_id='" + getTargettypeAllowedForRelation_Id()+"' ";	
		result+= " targettypeAllowedForRelation_className='" + getTargettypeAllowedForRelation_ClassName()+"' ";
		result+= "panelLabelAllowedForRelation='" + getPanelLabelAllowedForRelation()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Measurement.
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
		{
			fields.add("unit_id");
		}
		fields.add("unit_name");
		{
			fields.add("dataType");
		}
		{
			fields.add("temporal");
		}
		{
			fields.add("categories_id");
		}
		fields.add("categories_name");
		{
			fields.add("targettypeAllowedForRelation_id");
		}
		fields.add("targettypeAllowedForRelation_className");
		{
			fields.add("panelLabelAllowedForRelation");
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
		+ "label" +sep
		+ "unit" +sep
		+ "dataType" +sep
		+ "temporal" +sep
		+ "categories" +sep
		+ "targettypeAllowedForRelation" +sep
		+ "panelLabelAllowedForRelation" 
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
        if (fieldName.equalsIgnoreCase("unit")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("categories")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("targettypeAllowedForRelation")) {
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
		Measurement rhs = (Measurement) obj;
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
			out.write(valueS+sep);
		}
		{
			Object valueO = getUnit();
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
			Object valueO = getDataType();
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
			Object valueO = getTemporal();
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
			Object valueO = getCategories();
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
			Object valueO = getTargettypeAllowedForRelation();
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
			Object valueO = getPanelLabelAllowedForRelation();
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
	public Measurement create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Measurement e = new Measurement();
		e.set(tuple);
		return e;
	}
	

	
}

