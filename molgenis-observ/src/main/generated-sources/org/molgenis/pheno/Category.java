
/* File:        observ/model/Category.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.pheno;

/**
 * Category: Special kind of ObservationElement to define categorical answer codes such as are
				often used in Questionaires. A list of categories can be attached to an
				Measurement using Measurement.categories. For example the
				Measurement 'sex' has {code_string = 1, label=male} and {code_string = 2,
				label=female}. Categories can be linked to well-defined ontology terms
				via the ontologyReference. Category extends ObservationElement such that
				it can be referenced by ObservedValue.value. The Category class maps
				to METABASE::Category
			
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Category"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.pheno.db.CategoryEntityListener.class})
public class Category extends org.molgenis.pheno.ObservationElement 
{
	// fieldname constants
	public final static String CODE_STRING = "code_string";
	public final static String DESCRIPTION = "description";
	public final static String ISMISSING = "isMissing";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(Category.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Category> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Category.class);
	}
	
	/**
	 * Shorthand for db.find(Category.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Category> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Category.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Category findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Category> q = db.query(Category.class);
		q.eq(Category.ID, id);
		java.util.List<Category> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Category findByNameInvestigation(org.molgenis.framework.db.Database db, String name, Integer investigation) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Category> q = db.query(Category.class);
		q.eq(Category.NAME, name);q.eq(Category.INVESTIGATION, investigation);
		java.util.List<Category> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Category findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Category> q = db.query(Category.class);
		q.eq(Category.NAME, name);
		java.util.List<Category> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//The code used to represent this category. For example: { '1' codes for 'male', '2'-'female'}[type=string]
	@javax.persistence.Column(name="code_string", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="code_string")
	
				

	@javax.validation.constraints.NotNull
	private String code_string =  null;


	//Description of the code.     Use of ontology terms references to establish unambigious descriptions is     recommended[type=text]
//	@javax.persistence.Lob()
	@javax.persistence.Column(name="description", length=16777216, nullable=false)
	
				

	@javax.validation.constraints.NotNull
	private String description =  null;


	//whether this code should be treated as missing value.[type=bool]
	@javax.persistence.Column(name="isMissing", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="isMissing")
	
				

	@javax.validation.constraints.NotNull
	private Boolean isMissing =  false;


	//automatically generated id[type=int]
	

	//constructors
	public Category()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the The code used to represent this category. For example: { '1' codes for 'male', '2'-'female'}.
	 * @return code_string.
	 */
	public String getCode_String()
	{
		return this.code_string;
	}
	
	@Deprecated
	public String getCode_String(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the The code used to represent this category. For example: { '1' codes for 'male', '2'-'female'}.
	 * @param code_string
	 */
	public void setCode_String( String code_string)
	{
		
		this.code_string = code_string;
	}

	

	/**
	 * Get the Description of the code.     Use of ontology terms references to establish unambigious descriptions is     recommended.
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
	 * Set the Description of the code.     Use of ontology terms references to establish unambigious descriptions is     recommended.
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
	 * Get the whether this code should be treated as missing value..
	 * @return isMissing.
	 */
	public Boolean getIsMissing()
	{
		return this.isMissing;
	}
	
	@Deprecated
	public Boolean getIsMissing(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the whether this code should be treated as missing value..
	 * @param isMissing
	 */
	public void setIsMissing( Boolean isMissing)
	{
		
		this.isMissing = isMissing;
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
		if (name.toLowerCase().equals("code_string"))
			return getCode_String();
		if (name.toLowerCase().equals("ismissing"))
			return getIsMissing();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.getDescription() == null) throw new org.molgenis.framework.db.DatabaseException("required field description is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getCode_String() == null) throw new org.molgenis.framework.db.DatabaseException("required field code_string is null");
		if(this.getIsMissing() == null) throw new org.molgenis.framework.db.DatabaseException("required field isMissing is null");
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
			//set Code_String
			this.setCode_String(tuple.getString("code_string"));
			//set IsMissing
			this.setIsMissing(tuple.getBoolean("isMissing"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Category_id") != null) this.setId(tuple.getInt("Category_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("Category_name") != null) this.setName(tuple.getString("Category_name"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Category_description") != null) this.setDescription(tuple.getString("Category_description"));
			//set Investigation
			if( strict || tuple.getInt("Investigation_id") != null) this.setInvestigation(tuple.getInt("Investigation_id"));
			if( tuple.getInt("Category_Investigation_id") != null) this.setInvestigation(tuple.getInt("Category_Investigation_id"));
			//alias of xref
			if( tuple.getObject("Investigation") != null) this.setInvestigation(tuple.getInt("Investigation"));
			if( tuple.getObject("Category_Investigation") != null) this.setInvestigation(tuple.getInt("Category_Investigation"));
			//set label for field Investigation
			if( strict || tuple.getObject("Investigation_name") != null) this.setInvestigation_Name(tuple.getString("Investigation_name"));			
			if( tuple.getObject("Category_Investigation_name") != null ) this.setInvestigation_Name(tuple.getString("Category_Investigation_name"));		
			//set OntologyReference
			if( tuple.getObject("ontologyReference")!= null || tuple.getObject("Category_ontologyReference")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference");
				if(tuple.getObject("Category_ontologyReference")!= null) mrefs = tuple.getList("Category_ontologyReference");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setOntologyReference_Id( values );
			}
			//set labels name for mref field OntologyReference	
			if( tuple.getObject("ontologyReference_name")!= null || tuple.getObject("Category_ontologyReference_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference_name");
				if(tuple.getObject("Category_ontologyReference_name")!= null) mrefs = tuple.getList("Category_ontologyReference_name");
				
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
			if( tuple.getString("Category___Type") != null) this.set__Type(tuple.getString("Category___Type"));
			//set AlternateId
			if( tuple.getObject("AlternateId")!= null || tuple.getObject("Category_AlternateId")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("AlternateId");
				if(tuple.getObject("Category_AlternateId")!= null) mrefs = tuple.getList("Category_AlternateId");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setAlternateId_Id( values );
			}
			//set labels name for mref field AlternateId	
			if( tuple.getObject("AlternateId_name")!= null || tuple.getObject("Category_AlternateId_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("AlternateId_name");
				if(tuple.getObject("Category_AlternateId_name")!= null) mrefs = tuple.getList("Category_AlternateId_name");
				
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
			if( tuple.getString("Category_label") != null) this.setLabel(tuple.getString("Category_label"));
			//set Code_String
			if( strict || tuple.getString("code_string") != null) this.setCode_String(tuple.getString("code_string"));
			if( tuple.getString("Category_code_string") != null) this.setCode_String(tuple.getString("Category_code_string"));
			//set IsMissing
			if( strict || tuple.getBoolean("isMissing") != null) this.setIsMissing(tuple.getBoolean("isMissing"));
			if( tuple.getBoolean("Category_isMissing") != null) this.setIsMissing(tuple.getBoolean("Category_isMissing"));
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
		String result = "Category(";
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
		result+= "code_string='" + getCode_String()+"' ";	
		result+= "isMissing='" + getIsMissing()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Category.
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
			fields.add("code_string");
		}
		{
			fields.add("isMissing");
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
		+ "code_string" +sep
		+ "isMissing" 
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
		Category rhs = (Category) obj;
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
			Object valueO = getCode_String();
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
			Object valueO = getIsMissing();
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
	public Category create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Category e = new Category();
		e.set(tuple);
		return e;
	}
	
	//2
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="categories"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.pheno.Measurement> categoriesMeasurementCollection = new java.util.ArrayList<org.molgenis.pheno.Measurement>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.Measurement> getCategoriesMeasurementCollection()
	{
        return categoriesMeasurementCollection;
	}

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.Measurement> getCategoriesMeasurementCollection(org.molgenis.framework.db.Database db)
	{
        return getCategoriesMeasurementCollection();
	}

    public void setCategoriesMeasurementCollection(java.util.Collection<org.molgenis.pheno.Measurement> collection)
    {
    	categoriesMeasurementCollection.addAll(collection);
    }	

	
}

