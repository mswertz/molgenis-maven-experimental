
/* File:        observ/model/Measurement_categories.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.pheno;

/**
 * Measurement_categories: Link table for many-to-many relationship 'Measurement.categories'..
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.pheno.db.Measurement_CategoriesEntityListener.class})
public class Measurement_Categories extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String AUTOID = "autoid";
	public final static String CATEGORIES = "categories";
	public final static String CATEGORIES_NAME = "categories_name";
	public final static String MEASUREMENT = "Measurement";
	public final static String MEASUREMENT_NAME = "Measurement_name";
	
	//static methods
	/**
	 * Shorthand for db.query(Measurement_Categories.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Measurement_Categories> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Measurement_Categories.class);
	}
	
	/**
	 * Shorthand for db.find(Measurement_Categories.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Measurement_Categories> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Measurement_Categories.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Measurement_Categories findByAutoid(org.molgenis.framework.db.Database db, Integer autoid) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Measurement_Categories> q = db.query(Measurement_Categories.class);
		q.eq(Measurement_Categories.AUTOID, autoid);
		java.util.List<Measurement_Categories> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Measurement_Categories findByCategoriesMeasurement(org.molgenis.framework.db.Database db, Integer categories, Integer measurement) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Measurement_Categories> q = db.query(Measurement_Categories.class);
		q.eq(Measurement_Categories.CATEGORIES, categories);q.eq(Measurement_Categories.MEASUREMENT, measurement);
		java.util.List<Measurement_Categories> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatic id field to ensure ordering of mrefs[type=int]
    @javax.persistence.Id @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Column(name="autoid", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="autoid")
	
	//@javax.validation.constraints.NotNull
	private Integer autoid =  null;


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="categories", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.pheno.Category categories = null;
	@javax.persistence.Transient
	private Integer categories_id = null;	
	@javax.persistence.Transient
	private String categories_name = null;						


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Measurement", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.pheno.Measurement measurement = null;
	@javax.persistence.Transient
	private Integer measurement_id = null;	
	@javax.persistence.Transient
	private String measurement_name = null;						

	//constructors
	public Measurement_Categories()
	{
	
	}
	
	//getters and setters
	/**
	 * Get the automatic id field to ensure ordering of mrefs.
	 * @return autoid.
	 */
	public Integer getAutoid()
	{
		return this.autoid;
	}
	
	
	/**
	 * Set the automatic id field to ensure ordering of mrefs.
	 * @param autoid
	 */
	public void setAutoid( Integer autoid)
	{
		this.autoid = autoid;
	}

	

	/**
	 * Get the .
	 * @return categories.
	 */
	public org.molgenis.pheno.Category getCategories()
	{
		return this.categories;
	}
	
	@Deprecated
	public org.molgenis.pheno.Category getCategories(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param categories
	 */
	public void setCategories( org.molgenis.pheno.Category categories)
	{
		
		this.categories = categories;
	}

	
	
	/**
	 * Set foreign key for field categories.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setCategories_Id(Integer categories_id)
	{
		this.categories_id = categories_id;
	}	

	public void setCategories(Integer categories_id)
	{
		this.categories_id = categories_id;
	}
	
	public Integer getCategories_Id()
	{
		
		if(categories != null) 
		{
			return categories.getId();
		}
		else
		{
			return categories_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Categories to Category.Id.
	 */
	public String getCategories_Name()
	{		
		//FIXME should we auto-load based on getCategories()?	
		if(categories != null) {
			return categories.getName();
		} else {
			return categories_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Categories to <a href="Category.html#Id">Category.Id</a>.
	 * Implies setCategories(null) until save
	 */
	public void setCategories_Name(String categories_name)
	{
		this.categories_name = categories_name;
	}		
	 
	

	/**
	 * Get the .
	 * @return measurement.
	 */
	public org.molgenis.pheno.Measurement getMeasurement()
	{
		return this.measurement;
	}
	
	@Deprecated
	public org.molgenis.pheno.Measurement getMeasurement(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param measurement
	 */
	public void setMeasurement( org.molgenis.pheno.Measurement measurement)
	{
		
		this.measurement = measurement;
	}

	
	
	/**
	 * Set foreign key for field measurement.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setMeasurement_Id(Integer measurement_id)
	{
		this.measurement_id = measurement_id;
	}	

	public void setMeasurement(Integer measurement_id)
	{
		this.measurement_id = measurement_id;
	}
	
	public Integer getMeasurement_Id()
	{
		
		if(measurement != null) 
		{
			return measurement.getId();
		}
		else
		{
			return measurement_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Measurement to Measurement.Id.
	 */
	public String getMeasurement_Name()
	{		
		//FIXME should we auto-load based on getMeasurement()?	
		if(measurement != null) {
			return measurement.getName();
		} else {
			return measurement_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Measurement to <a href="Measurement.html#Id">Measurement.Id</a>.
	 * Implies setMeasurement(null) until save
	 */
	public void setMeasurement_Name(String measurement_name)
	{
		this.measurement_name = measurement_name;
	}		
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("autoid"))
			return getAutoid();
		if (name.toLowerCase().equals("categories"))
			return getCategories();
		if(name.toLowerCase().equals("categories_id"))
			return getCategories_Id();
		if(name.toLowerCase().equals("categories_name"))
			return getCategories_Name();
		if (name.toLowerCase().equals("measurement"))
			return getMeasurement();
		if(name.toLowerCase().equals("measurement_id"))
			return getMeasurement_Id();
		if(name.toLowerCase().equals("measurement_name"))
			return getMeasurement_Name();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getAutoid() == null) throw new org.molgenis.framework.db.DatabaseException("required field autoid is null");
		if(this.getCategories() == null) throw new org.molgenis.framework.db.DatabaseException("required field categories is null");
		if(this.getMeasurement() == null) throw new org.molgenis.framework.db.DatabaseException("required field measurement is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Autoid
			this.setAutoid(tuple.getInt("autoid"));
			//set Categories
			this.setCategories(tuple.getInt("categories"));
			//set label name for xref field Categories
			this.setCategories_Name(tuple.getString("categories_name"));	
			//set Measurement
			this.setMeasurement(tuple.getInt("Measurement"));
			//set label name for xref field Measurement
			this.setMeasurement_Name(tuple.getString("Measurement_name"));	
		}
		else if(tuple != null)
		{
			//set Autoid
			if( strict || tuple.getInt("autoid") != null) this.setAutoid(tuple.getInt("autoid"));
			if( tuple.getInt("Measurement_categories_autoid") != null) this.setAutoid(tuple.getInt("Measurement_categories_autoid"));
			//set Categories
			if( strict || tuple.getInt("categories_id") != null) this.setCategories(tuple.getInt("categories_id"));
			if( tuple.getInt("Measurement_categories_categories_id") != null) this.setCategories(tuple.getInt("Measurement_categories_categories_id"));
			//alias of xref
			if( tuple.getObject("categories") != null) this.setCategories(tuple.getInt("categories"));
			if( tuple.getObject("Measurement_categories_categories") != null) this.setCategories(tuple.getInt("Measurement_categories_categories"));
			//set label for field Categories
			if( strict || tuple.getObject("categories_name") != null) this.setCategories_Name(tuple.getString("categories_name"));			
			if( tuple.getObject("Measurement_categories_categories_name") != null ) this.setCategories_Name(tuple.getString("Measurement_categories_categories_name"));		
			//set Measurement
			if( strict || tuple.getInt("Measurement_id") != null) this.setMeasurement(tuple.getInt("Measurement_id"));
			if( tuple.getInt("Measurement_categories_Measurement_id") != null) this.setMeasurement(tuple.getInt("Measurement_categories_Measurement_id"));
			//alias of xref
			if( tuple.getObject("Measurement") != null) this.setMeasurement(tuple.getInt("Measurement"));
			if( tuple.getObject("Measurement_categories_Measurement") != null) this.setMeasurement(tuple.getInt("Measurement_categories_Measurement"));
			//set label for field Measurement
			if( strict || tuple.getObject("Measurement_name") != null) this.setMeasurement_Name(tuple.getString("Measurement_name"));			
			if( tuple.getObject("Measurement_categories_Measurement_name") != null ) this.setMeasurement_Name(tuple.getString("Measurement_categories_Measurement_name"));		
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
		String result = "Measurement_Categories(";
		result+= "autoid='" + getAutoid()+"' ";	
		result+= " categories_id='" + getCategories_Id()+"' ";	
		result+= " categories_name='" + getCategories_Name()+"' ";
		result+= " measurement_id='" + getMeasurement_Id()+"' ";	
		result+= " measurement_name='" + getMeasurement_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Measurement_Categories.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("autoid");
		}
		{
			fields.add("categories_id");
		}
		fields.add("categories_name");
		{
			fields.add("measurement_id");
		}
		fields.add("measurement_name");
		return fields;
	}	

	public java.util.Vector<String> getFields()
	{
		return getFields(false);
	}

	@Override
	public String getIdField()
	{
		return "autoid";
	}
	

	
	@Override
	public java.util.List<String> getLabelFields()
	{
		java.util.List<String> result = new java.util.ArrayList<String>();
		result.add("categories");
		result.add("Measurement");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "autoid" +sep
		+ "categories" +sep
		+ "measurement" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("categories")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("measurement")) {
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
		Measurement_Categories rhs = (Measurement_Categories) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//categories
		//measurement
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
			Object valueO = getAutoid();
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
			Object valueO = getMeasurement();
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
	public Measurement_Categories create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Measurement_Categories e = new Measurement_Categories();
		e.set(tuple);
		return e;
	}
	

	
}

