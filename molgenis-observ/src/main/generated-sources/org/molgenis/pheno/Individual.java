
/* File:        observ/model/Individual.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.pheno;

/**
 * Individual:  The Individuals class defines human cases that are used
				as observation target. The Individual class maps to XGAP:Individual
				and PaGE:Individual. Note that minimal information like 'sex' can be
				defined as ObservedValue, and that that basic relationships like
				'father' and 'mother' can also be defined via ObservedRelationship,
				using the 'relation' field. Groups of individuals can be defined via
				Panel.
			
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Individual"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.pheno.db.IndividualEntityListener.class})
public class Individual extends org.molgenis.pheno.ObservationTarget 
{
	// fieldname constants
	public final static String MOTHER = "Mother";
	public final static String MOTHER_NAME = "Mother_name";
	public final static String FATHER = "Father";
	public final static String FATHER_NAME = "Father_name";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(Individual.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Individual> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Individual.class);
	}
	
	/**
	 * Shorthand for db.find(Individual.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Individual> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Individual.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Individual findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Individual> q = db.query(Individual.class);
		q.eq(Individual.ID, id);
		java.util.List<Individual> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Individual findByNameInvestigation(org.molgenis.framework.db.Database db, String name, Integer investigation) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Individual> q = db.query(Individual.class);
		q.eq(Individual.NAME, name);q.eq(Individual.INVESTIGATION, investigation);
		java.util.List<Individual> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Individual findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Individual> q = db.query(Individual.class);
		q.eq(Individual.NAME, name);
		java.util.List<Individual> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//Refers to the mother of the individual.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Mother")   	
	
				

	private org.molgenis.pheno.Individual mother = null;
	@javax.persistence.Transient
	private Integer mother_id = null;	
	@javax.persistence.Transient
	private String mother_name = null;						


	//Refers to the father of the individual.[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Father")   	
	
				

	private org.molgenis.pheno.Individual father = null;
	@javax.persistence.Transient
	private Integer father_id = null;	
	@javax.persistence.Transient
	private String father_name = null;						


	//automatically generated id[type=int]
	

	//constructors
	public Individual()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the Refers to the mother of the individual..
	 * @return mother.
	 */
	public org.molgenis.pheno.Individual getMother()
	{
		return this.mother;
	}
	
	@Deprecated
	public org.molgenis.pheno.Individual getMother(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Refers to the mother of the individual..
	 * @param mother
	 */
	public void setMother( org.molgenis.pheno.Individual mother)
	{
		
		this.mother = mother;
	}

	
	
	/**
	 * Set foreign key for field mother.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setMother_Id(Integer mother_id)
	{
		this.mother_id = mother_id;
	}	

	public void setMother(Integer mother_id)
	{
		this.mother_id = mother_id;
	}
	
	public Integer getMother_Id()
	{
		
		if(mother != null) 
		{
			return mother.getId();
		}
		else
		{
			return mother_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Mother to Individual.Id.
	 */
	public String getMother_Name()
	{		
		//FIXME should we auto-load based on getMother()?	
		if(mother != null) {
			return mother.getName();
		} else {
			return mother_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Mother to <a href="Individual.html#Id">Individual.Id</a>.
	 * Implies setMother(null) until save
	 */
	public void setMother_Name(String mother_name)
	{
		this.mother_name = mother_name;
	}		
	 
	

	/**
	 * Get the Refers to the father of the individual..
	 * @return father.
	 */
	public org.molgenis.pheno.Individual getFather()
	{
		return this.father;
	}
	
	@Deprecated
	public org.molgenis.pheno.Individual getFather(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Refers to the father of the individual..
	 * @param father
	 */
	public void setFather( org.molgenis.pheno.Individual father)
	{
		
		this.father = father;
	}

	
	
	/**
	 * Set foreign key for field father.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setFather_Id(Integer father_id)
	{
		this.father_id = father_id;
	}	

	public void setFather(Integer father_id)
	{
		this.father_id = father_id;
	}
	
	public Integer getFather_Id()
	{
		
		if(father != null) 
		{
			return father.getId();
		}
		else
		{
			return father_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Father to Individual.Id.
	 */
	public String getFather_Name()
	{		
		//FIXME should we auto-load based on getFather()?	
		if(father != null) {
			return father.getName();
		} else {
			return father_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Father to <a href="Individual.html#Id">Individual.Id</a>.
	 * Implies setFather(null) until save
	 */
	public void setFather_Name(String father_name)
	{
		this.father_name = father_name;
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
		if (name.toLowerCase().equals("mother"))
			return getMother();
		if(name.toLowerCase().equals("mother_id"))
			return getMother_Id();
		if(name.toLowerCase().equals("mother_name"))
			return getMother_Name();
		if (name.toLowerCase().equals("father"))
			return getFather();
		if(name.toLowerCase().equals("father_id"))
			return getFather_Id();
		if(name.toLowerCase().equals("father_name"))
			return getFather_Name();
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
			//set Mother
			this.setMother(tuple.getInt("Mother"));
			//set label name for xref field Mother
			this.setMother_Name(tuple.getString("Mother_name"));	
			//set Father
			this.setFather(tuple.getInt("Father"));
			//set label name for xref field Father
			this.setFather_Name(tuple.getString("Father_name"));	
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Individual_id") != null) this.setId(tuple.getInt("Individual_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("Individual_name") != null) this.setName(tuple.getString("Individual_name"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Individual_description") != null) this.setDescription(tuple.getString("Individual_description"));
			//set Investigation
			if( strict || tuple.getInt("Investigation_id") != null) this.setInvestigation(tuple.getInt("Investigation_id"));
			if( tuple.getInt("Individual_Investigation_id") != null) this.setInvestigation(tuple.getInt("Individual_Investigation_id"));
			//alias of xref
			if( tuple.getObject("Investigation") != null) this.setInvestigation(tuple.getInt("Investigation"));
			if( tuple.getObject("Individual_Investigation") != null) this.setInvestigation(tuple.getInt("Individual_Investigation"));
			//set label for field Investigation
			if( strict || tuple.getObject("Investigation_name") != null) this.setInvestigation_Name(tuple.getString("Investigation_name"));			
			if( tuple.getObject("Individual_Investigation_name") != null ) this.setInvestigation_Name(tuple.getString("Individual_Investigation_name"));		
			//set OntologyReference
			if( tuple.getObject("ontologyReference")!= null || tuple.getObject("Individual_ontologyReference")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference");
				if(tuple.getObject("Individual_ontologyReference")!= null) mrefs = tuple.getList("Individual_ontologyReference");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setOntologyReference_Id( values );
			}
			//set labels name for mref field OntologyReference	
			if( tuple.getObject("ontologyReference_name")!= null || tuple.getObject("Individual_ontologyReference_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference_name");
				if(tuple.getObject("Individual_ontologyReference_name")!= null) mrefs = tuple.getList("Individual_ontologyReference_name");
				
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
			if( tuple.getString("Individual___Type") != null) this.set__Type(tuple.getString("Individual___Type"));
			//set AlternateId
			if( tuple.getObject("AlternateId")!= null || tuple.getObject("Individual_AlternateId")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("AlternateId");
				if(tuple.getObject("Individual_AlternateId")!= null) mrefs = tuple.getList("Individual_AlternateId");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setAlternateId_Id( values );
			}
			//set labels name for mref field AlternateId	
			if( tuple.getObject("AlternateId_name")!= null || tuple.getObject("Individual_AlternateId_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("AlternateId_name");
				if(tuple.getObject("Individual_AlternateId_name")!= null) mrefs = tuple.getList("Individual_AlternateId_name");
				
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
			if( tuple.getString("Individual_label") != null) this.setLabel(tuple.getString("Individual_label"));
			//set Mother
			if( strict || tuple.getInt("Mother_id") != null) this.setMother(tuple.getInt("Mother_id"));
			if( tuple.getInt("Individual_Mother_id") != null) this.setMother(tuple.getInt("Individual_Mother_id"));
			//alias of xref
			if( tuple.getObject("Mother") != null) this.setMother(tuple.getInt("Mother"));
			if( tuple.getObject("Individual_Mother") != null) this.setMother(tuple.getInt("Individual_Mother"));
			//set label for field Mother
			if( strict || tuple.getObject("Mother_name") != null) this.setMother_Name(tuple.getString("Mother_name"));			
			if( tuple.getObject("Individual_Mother_name") != null ) this.setMother_Name(tuple.getString("Individual_Mother_name"));		
			//set Father
			if( strict || tuple.getInt("Father_id") != null) this.setFather(tuple.getInt("Father_id"));
			if( tuple.getInt("Individual_Father_id") != null) this.setFather(tuple.getInt("Individual_Father_id"));
			//alias of xref
			if( tuple.getObject("Father") != null) this.setFather(tuple.getInt("Father"));
			if( tuple.getObject("Individual_Father") != null) this.setFather(tuple.getInt("Individual_Father"));
			//set label for field Father
			if( strict || tuple.getObject("Father_name") != null) this.setFather_Name(tuple.getString("Father_name"));			
			if( tuple.getObject("Individual_Father_name") != null ) this.setFather_Name(tuple.getString("Individual_Father_name"));		
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
		String result = "Individual(";
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
		result+= " mother_id='" + getMother_Id()+"' ";	
		result+= " mother_name='" + getMother_Name()+"' ";
		result+= " father_id='" + getFather_Id()+"' ";	
		result+= " father_name='" + getFather_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Individual.
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
			fields.add("mother_id");
		}
		fields.add("mother_name");
		{
			fields.add("father_id");
		}
		fields.add("father_name");
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
		+ "mother" +sep
		+ "father" 
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
        if (fieldName.equalsIgnoreCase("mother")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("father")) {
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
		Individual rhs = (Individual) obj;
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
			Object valueO = getMother();
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
			Object valueO = getFather();
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
	public Individual create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Individual e = new Individual();
		e.set(tuple);
		return e;
	}
	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="mother"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.pheno.Individual> motherIndividualCollection = new java.util.ArrayList<org.molgenis.pheno.Individual>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.Individual> getMotherIndividualCollection()
	{
            return motherIndividualCollection;
	}

    public void setMotherIndividualCollection(java.util.Collection<org.molgenis.pheno.Individual> collection)
    {
        for (org.molgenis.pheno.Individual individual : collection) {
            individual.setMother(this);
        }
        motherIndividualCollection = collection;
    }	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="father"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.pheno.Individual> fatherIndividualCollection = new java.util.ArrayList<org.molgenis.pheno.Individual>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.Individual> getFatherIndividualCollection()
	{
            return fatherIndividualCollection;
	}

    public void setFatherIndividualCollection(java.util.Collection<org.molgenis.pheno.Individual> collection)
    {
        for (org.molgenis.pheno.Individual individual : collection) {
            individual.setFather(this);
        }
        fatherIndividualCollection = collection;
    }	
	//4
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="individuals"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.pheno.Panel> individualsPanelCollection = new java.util.ArrayList<org.molgenis.pheno.Panel>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.Panel> getIndividualsPanelCollection()
	{
        return individualsPanelCollection;
	}

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.Panel> getIndividualsPanelCollection(org.molgenis.framework.db.Database db)
	{
        return getIndividualsPanelCollection();
	}

    public void setIndividualsPanelCollection(java.util.Collection<org.molgenis.pheno.Panel> collection)
    {
    	individualsPanelCollection.addAll(collection);
    }	

	
}

