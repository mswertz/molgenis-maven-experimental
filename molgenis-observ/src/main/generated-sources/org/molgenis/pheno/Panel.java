
/* File:        observ/model/Panel.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.pheno;

/**
 * Panel: The Panel class defines groups of individuals based on
				cohort design, case/controls, families, etc. For instance: LifeLines
				cohort, 'middle aged man', 'recombinant mouse inbred Line dba x b6'
				or 'Smith family'. A Panel can act as a single ObservationTarget.
				For example: average height (ObservedValue) in the LifeLines cohort
				(Panel) is 174cm. The Panel class maps to XGAP:Strain and PaGE:Panel
				classes. In METABASE this is assumed there is one panel per study.
			
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Panel"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.pheno.db.PanelEntityListener.class})
public class Panel extends org.molgenis.pheno.ObservationTarget 
{
	// fieldname constants
	public final static String INDIVIDUALS = "Individuals";
	public final static String INDIVIDUALS_NAME = "Individuals_name";
	public final static String SPECIES = "Species";
	public final static String SPECIES_NAME = "Species_name";
	public final static String PANELTYPE = "PanelType";
	public final static String PANELTYPE_NAME = "PanelType_name";
	public final static String FOUNDERPANELS = "FounderPanels";
	public final static String FOUNDERPANELS_NAME = "FounderPanels_name";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(Panel.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Panel> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Panel.class);
	}
	
	/**
	 * Shorthand for db.find(Panel.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Panel> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Panel.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Panel findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Panel> q = db.query(Panel.class);
		q.eq(Panel.ID, id);
		java.util.List<Panel> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Panel findByNameInvestigation(org.molgenis.framework.db.Database db, String name, Integer investigation) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Panel> q = db.query(Panel.class);
		q.eq(Panel.NAME, name);q.eq(Panel.INVESTIGATION, investigation);
		java.util.List<Panel> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Panel findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Panel> q = db.query(Panel.class);
		q.eq(Panel.NAME, name);
		java.util.List<Panel> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//The list of individuals in this panel[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Individuals", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="Panel_Individuals", 
			joinColumns=@javax.persistence.JoinColumn(name="Panel"), inverseJoinColumns=@javax.persistence.JoinColumn(name="Individuals"))
	
				

	private java.util.List<org.molgenis.pheno.Individual> individuals = new java.util.ArrayList<org.molgenis.pheno.Individual>();
	@javax.persistence.Transient
	private java.util.List<Integer> individuals_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> individuals_name = new java.util.ArrayList<String>();


	//The species this panel is an instance of/part of/extracted from.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Species")   	
	
				

	private org.molgenis.pheno.Species species = null;
	@javax.persistence.Transient
	private Integer species_id = null;	
	@javax.persistence.Transient
	private String species_name = null;						


	//Indicate the type of Panel (example: Natural=wild type, Parental=parents of a cross, F1=First generation of cross, RCC=Recombinant congenic, CSS=chromosome substitution)[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="PanelType")   	
	
				

	private org.molgenis.core.OntologyTerm panelType = null;
	@javax.persistence.Transient
	private Integer panelType_id = null;	
	@javax.persistence.Transient
	private String panelType_name = null;						


	//The panel(s) that were used to create this panel.[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="FounderPanels", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="Panel_FounderPanels", 
			joinColumns=@javax.persistence.JoinColumn(name="Panel"), inverseJoinColumns=@javax.persistence.JoinColumn(name="FounderPanels"))
	
				

	private java.util.List<org.molgenis.pheno.Panel> founderPanels = new java.util.ArrayList<org.molgenis.pheno.Panel>();
	@javax.persistence.Transient
	private java.util.List<Integer> founderPanels_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> founderPanels_name = new java.util.ArrayList<String>();


	//automatically generated id[type=int]
	

	//constructors
	public Panel()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the The list of individuals in this panel.
	 * @return individuals.
	 */
	public java.util.List<org.molgenis.pheno.Individual> getIndividuals()
	{
		return this.individuals;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.pheno.Individual> getIndividuals(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The list of individuals in this panel.
	 * @param individuals
	 */
	public void setIndividuals( java.util.List<org.molgenis.pheno.Individual> individuals)
	{
		
		this.individuals = individuals;
	}

	
	public void setIndividuals_Id(Integer ... individuals)
	{
		this.setIndividuals_Id(java.util.Arrays.asList(individuals));
	}	
	
	public void setIndividuals(org.molgenis.pheno.Individual ... individuals)
	{
		this.setIndividuals(java.util.Arrays.asList(individuals));
	}	
	
	/**
	 * Set foreign key for field individuals.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setIndividuals_Id(java.util.List<Integer> individuals_id)
	{
		this.individuals_id = individuals_id;
	}	
	
	public java.util.List<Integer> getIndividuals_Id()
	{
		return individuals_id;
	}	
	
	/**
	 * Get a pretty label for cross reference Individuals to <a href="Individual.html#Id">Individual.Id</a>.
	 */
	public java.util.List<String> getIndividuals_Name()
	{
		return individuals_name;
	}
	
	/**
	 * Update the foreign key Individuals
	 * This sets individuals to null until next database transaction.
	 */
	public void setIndividuals_Name(java.util.List<String> individuals_name)
	{
		this.individuals_name = individuals_name;
	}		
	

	/**
	 * Get the The species this panel is an instance of/part of/extracted from..
	 * @return species.
	 */
	public org.molgenis.pheno.Species getSpecies()
	{
		return this.species;
	}
	
	@Deprecated
	public org.molgenis.pheno.Species getSpecies(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The species this panel is an instance of/part of/extracted from..
	 * @param species
	 */
	public void setSpecies( org.molgenis.pheno.Species species)
	{
		
		this.species = species;
	}

	
	
	/**
	 * Set foreign key for field species.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setSpecies_Id(Integer species_id)
	{
		this.species_id = species_id;
	}	

	public void setSpecies(Integer species_id)
	{
		this.species_id = species_id;
	}
	
	public Integer getSpecies_Id()
	{
		
		if(species != null) 
		{
			return species.getId();
		}
		else
		{
			return species_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Species to Species.Id.
	 */
	public String getSpecies_Name()
	{		
		//FIXME should we auto-load based on getSpecies()?	
		if(species != null) {
			return species.getName();
		} else {
			return species_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Species to <a href="Species.html#Id">Species.Id</a>.
	 * Implies setSpecies(null) until save
	 */
	public void setSpecies_Name(String species_name)
	{
		this.species_name = species_name;
	}		
	 
	

	/**
	 * Get the Indicate the type of Panel (example: Natural=wild type, Parental=parents of a cross, F1=First generation of cross, RCC=Recombinant congenic, CSS=chromosome substitution).
	 * @return panelType.
	 */
	public org.molgenis.core.OntologyTerm getPanelType()
	{
		return this.panelType;
	}
	
	@Deprecated
	public org.molgenis.core.OntologyTerm getPanelType(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Indicate the type of Panel (example: Natural=wild type, Parental=parents of a cross, F1=First generation of cross, RCC=Recombinant congenic, CSS=chromosome substitution).
	 * @param panelType
	 */
	public void setPanelType( org.molgenis.core.OntologyTerm panelType)
	{
		
		this.panelType = panelType;
	}

	
	
	/**
	 * Set foreign key for field panelType.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setPanelType_Id(Integer panelType_id)
	{
		this.panelType_id = panelType_id;
	}	

	public void setPanelType(Integer panelType_id)
	{
		this.panelType_id = panelType_id;
	}
	
	public Integer getPanelType_Id()
	{
		
		if(panelType != null) 
		{
			return panelType.getId();
		}
		else
		{
			return panelType_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference PanelType to OntologyTerm.Id.
	 */
	public String getPanelType_Name()
	{		
		//FIXME should we auto-load based on getPanelType()?	
		if(panelType != null) {
			return panelType.getName();
		} else {
			return panelType_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference PanelType to <a href="OntologyTerm.html#Id">OntologyTerm.Id</a>.
	 * Implies setPanelType(null) until save
	 */
	public void setPanelType_Name(String panelType_name)
	{
		this.panelType_name = panelType_name;
	}		
	 
	

	/**
	 * Get the The panel(s) that were used to create this panel..
	 * @return founderPanels.
	 */
	public java.util.List<org.molgenis.pheno.Panel> getFounderPanels()
	{
		return this.founderPanels;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.pheno.Panel> getFounderPanels(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The panel(s) that were used to create this panel..
	 * @param founderPanels
	 */
	public void setFounderPanels( java.util.List<org.molgenis.pheno.Panel> founderPanels)
	{
		
		this.founderPanels = founderPanels;
	}

	
	public void setFounderPanels_Id(Integer ... founderPanels)
	{
		this.setFounderPanels_Id(java.util.Arrays.asList(founderPanels));
	}	
	
	public void setFounderPanels(org.molgenis.pheno.Panel ... founderPanels)
	{
		this.setFounderPanels(java.util.Arrays.asList(founderPanels));
	}	
	
	/**
	 * Set foreign key for field founderPanels.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setFounderPanels_Id(java.util.List<Integer> founderPanels_id)
	{
		this.founderPanels_id = founderPanels_id;
	}	
	
	public java.util.List<Integer> getFounderPanels_Id()
	{
		return founderPanels_id;
	}	
	
	/**
	 * Get a pretty label for cross reference FounderPanels to <a href="Panel.html#Id">Panel.Id</a>.
	 */
	public java.util.List<String> getFounderPanels_Name()
	{
		return founderPanels_name;
	}
	
	/**
	 * Update the foreign key FounderPanels
	 * This sets founderPanels to null until next database transaction.
	 */
	public void setFounderPanels_Name(java.util.List<String> founderPanels_name)
	{
		this.founderPanels_name = founderPanels_name;
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
		if (name.toLowerCase().equals("individuals"))
			return getIndividuals();
		if(name.toLowerCase().equals("individuals_id"))
			return getIndividuals_Id();
		if(name.toLowerCase().equals("individuals_name"))
			return getIndividuals_Name();
		if (name.toLowerCase().equals("species"))
			return getSpecies();
		if(name.toLowerCase().equals("species_id"))
			return getSpecies_Id();
		if(name.toLowerCase().equals("species_name"))
			return getSpecies_Name();
		if (name.toLowerCase().equals("paneltype"))
			return getPanelType();
		if(name.toLowerCase().equals("paneltype_id"))
			return getPanelType_Id();
		if(name.toLowerCase().equals("paneltype_name"))
			return getPanelType_Name();
		if (name.toLowerCase().equals("founderpanels"))
			return getFounderPanels();
		if(name.toLowerCase().equals("founderpanels_id"))
			return getFounderPanels_Id();
		if(name.toLowerCase().equals("founderpanels_name"))
			return getFounderPanels_Name();
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
			//mrefs can not be directly retrieved
			//set Individuals			
			//set Species
			this.setSpecies(tuple.getInt("Species"));
			//set label name for xref field Species
			this.setSpecies_Name(tuple.getString("Species_name"));	
			//set PanelType
			this.setPanelType(tuple.getInt("PanelType"));
			//set label name for xref field PanelType
			this.setPanelType_Name(tuple.getString("PanelType_name"));	
			//mrefs can not be directly retrieved
			//set FounderPanels			
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Panel_id") != null) this.setId(tuple.getInt("Panel_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("Panel_name") != null) this.setName(tuple.getString("Panel_name"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Panel_description") != null) this.setDescription(tuple.getString("Panel_description"));
			//set Investigation
			if( strict || tuple.getInt("Investigation_id") != null) this.setInvestigation(tuple.getInt("Investigation_id"));
			if( tuple.getInt("Panel_Investigation_id") != null) this.setInvestigation(tuple.getInt("Panel_Investigation_id"));
			//alias of xref
			if( tuple.getObject("Investigation") != null) this.setInvestigation(tuple.getInt("Investigation"));
			if( tuple.getObject("Panel_Investigation") != null) this.setInvestigation(tuple.getInt("Panel_Investigation"));
			//set label for field Investigation
			if( strict || tuple.getObject("Investigation_name") != null) this.setInvestigation_Name(tuple.getString("Investigation_name"));			
			if( tuple.getObject("Panel_Investigation_name") != null ) this.setInvestigation_Name(tuple.getString("Panel_Investigation_name"));		
			//set OntologyReference
			if( tuple.getObject("ontologyReference")!= null || tuple.getObject("Panel_ontologyReference")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference");
				if(tuple.getObject("Panel_ontologyReference")!= null) mrefs = tuple.getList("Panel_ontologyReference");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setOntologyReference_Id( values );
			}
			//set labels name for mref field OntologyReference	
			if( tuple.getObject("ontologyReference_name")!= null || tuple.getObject("Panel_ontologyReference_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference_name");
				if(tuple.getObject("Panel_ontologyReference_name")!= null) mrefs = tuple.getList("Panel_ontologyReference_name");
				
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
			if( tuple.getString("Panel___Type") != null) this.set__Type(tuple.getString("Panel___Type"));
			//set AlternateId
			if( tuple.getObject("AlternateId")!= null || tuple.getObject("Panel_AlternateId")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("AlternateId");
				if(tuple.getObject("Panel_AlternateId")!= null) mrefs = tuple.getList("Panel_AlternateId");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setAlternateId_Id( values );
			}
			//set labels name for mref field AlternateId	
			if( tuple.getObject("AlternateId_name")!= null || tuple.getObject("Panel_AlternateId_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("AlternateId_name");
				if(tuple.getObject("Panel_AlternateId_name")!= null) mrefs = tuple.getList("Panel_AlternateId_name");
				
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
			if( tuple.getString("Panel_label") != null) this.setLabel(tuple.getString("Panel_label"));
			//set Individuals
			if( tuple.getObject("Individuals")!= null || tuple.getObject("Panel_Individuals")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("Individuals");
				if(tuple.getObject("Panel_Individuals")!= null) mrefs = tuple.getList("Panel_Individuals");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setIndividuals_Id( values );
			}
			//set labels name for mref field Individuals	
			if( tuple.getObject("Individuals_name")!= null || tuple.getObject("Panel_Individuals_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("Individuals_name");
				if(tuple.getObject("Panel_Individuals_name")!= null) mrefs = tuple.getList("Panel_Individuals_name");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setIndividuals_Name( values );			
			}	
			//set Species
			if( strict || tuple.getInt("Species_id") != null) this.setSpecies(tuple.getInt("Species_id"));
			if( tuple.getInt("Panel_Species_id") != null) this.setSpecies(tuple.getInt("Panel_Species_id"));
			//alias of xref
			if( tuple.getObject("Species") != null) this.setSpecies(tuple.getInt("Species"));
			if( tuple.getObject("Panel_Species") != null) this.setSpecies(tuple.getInt("Panel_Species"));
			//set label for field Species
			if( strict || tuple.getObject("Species_name") != null) this.setSpecies_Name(tuple.getString("Species_name"));			
			if( tuple.getObject("Panel_Species_name") != null ) this.setSpecies_Name(tuple.getString("Panel_Species_name"));		
			//set PanelType
			if( strict || tuple.getInt("PanelType_id") != null) this.setPanelType(tuple.getInt("PanelType_id"));
			if( tuple.getInt("Panel_PanelType_id") != null) this.setPanelType(tuple.getInt("Panel_PanelType_id"));
			//alias of xref
			if( tuple.getObject("PanelType") != null) this.setPanelType(tuple.getInt("PanelType"));
			if( tuple.getObject("Panel_PanelType") != null) this.setPanelType(tuple.getInt("Panel_PanelType"));
			//set label for field PanelType
			if( strict || tuple.getObject("PanelType_name") != null) this.setPanelType_Name(tuple.getString("PanelType_name"));			
			if( tuple.getObject("Panel_PanelType_name") != null ) this.setPanelType_Name(tuple.getString("Panel_PanelType_name"));		
			//set FounderPanels
			if( tuple.getObject("FounderPanels")!= null || tuple.getObject("Panel_FounderPanels")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("FounderPanels");
				if(tuple.getObject("Panel_FounderPanels")!= null) mrefs = tuple.getList("Panel_FounderPanels");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setFounderPanels_Id( values );
			}
			//set labels name for mref field FounderPanels	
			if( tuple.getObject("FounderPanels_name")!= null || tuple.getObject("Panel_FounderPanels_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("FounderPanels_name");
				if(tuple.getObject("Panel_FounderPanels_name")!= null) mrefs = tuple.getList("Panel_FounderPanels_name");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setFounderPanels_Name( values );			
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
		String result = "Panel(";
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
		result+= " individuals_id='" + getIndividuals_Id()+"' ";	
		result+= " individuals_name='" + getIndividuals_Name()+"' ";
		result+= " species_id='" + getSpecies_Id()+"' ";	
		result+= " species_name='" + getSpecies_Name()+"' ";
		result+= " panelType_id='" + getPanelType_Id()+"' ";	
		result+= " panelType_name='" + getPanelType_Name()+"' ";
		result+= " founderPanels_id='" + getFounderPanels_Id()+"' ";	
		result+= " founderPanels_name='" + getFounderPanels_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Panel.
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
			fields.add("individuals_id");
		}
		fields.add("individuals_name");
		{
			fields.add("species_id");
		}
		fields.add("species_name");
		{
			fields.add("panelType_id");
		}
		fields.add("panelType_name");
		{
			fields.add("founderPanels_id");
		}
		fields.add("founderPanels_name");
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
		+ "individuals" +sep
		+ "species" +sep
		+ "panelType" +sep
		+ "founderPanels" 
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
        if (fieldName.equalsIgnoreCase("individuals")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("species")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("panelType")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("founderPanels")) {
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
		Panel rhs = (Panel) obj;
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
			Object valueO = getIndividuals();
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
			Object valueO = getSpecies();
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
			Object valueO = getPanelType();
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
			Object valueO = getFounderPanels();
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
	public Panel create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Panel e = new Panel();
		e.set(tuple);
		return e;
	}
	
	//4
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="founderPanels"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.pheno.Panel> founderPanelsPanelCollection = new java.util.ArrayList<org.molgenis.pheno.Panel>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.Panel> getFounderPanelsPanelCollection()
	{
        return founderPanelsPanelCollection;
	}

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.Panel> getFounderPanelsPanelCollection(org.molgenis.framework.db.Database db)
	{
        return getFounderPanelsPanelCollection();
	}

    public void setFounderPanelsPanelCollection(java.util.Collection<org.molgenis.pheno.Panel> collection)
    {
    	founderPanelsPanelCollection.addAll(collection);
    }	

	
}

