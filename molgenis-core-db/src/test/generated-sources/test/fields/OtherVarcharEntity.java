
/* File:        test/model/OtherVarcharEntity.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.fields;

/**
 * OtherVarcharEntity: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "OtherVarcharEntity", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "normalVarchar" }), @javax.persistence.UniqueConstraint( columnNames={ "normalVarchar" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.fields.db.OtherVarcharEntityEntityListener.class})
public class OtherVarcharEntity extends org.molgenis.db.common.AbstractEntity 
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String __TYPE = "__type";
	public final static String ID = "id";
	public final static String NORMALVARCHAR = "normalVarchar";
	public final static String READONLYVARCHAR = "readonlyVarchar";
	public final static String NILLABLEVARCHAR = "nillableVarchar";
	public final static String DEFAULTVARCHAR = "defaultVarchar";
	
	//static methods
	/**
	 * Shorthand for db.query(OtherVarcharEntity.class).
	 */
	public static org.molgenis.db.Query<? extends OtherVarcharEntity> query(org.molgenis.db.Database db)
	{
		return db.query(OtherVarcharEntity.class);
	}
	
	/**
	 * Shorthand for db.find(OtherVarcharEntity.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends OtherVarcharEntity> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(OtherVarcharEntity.class, rules);
	}	
	
	/**
	 * OtherVarcharEntity
	 */
	public static OtherVarcharEntity findById(org.molgenis.db.Database db, Integer id) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<OtherVarcharEntity> q = db.query(OtherVarcharEntity.class);
		q.eq(OtherVarcharEntity.ID, id);
		java.util.List<OtherVarcharEntity> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * OtherVarcharEntity
	 */
	public static OtherVarcharEntity findByNormalVarchar(org.molgenis.db.Database db, String normalVarchar) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<OtherVarcharEntity> q = db.query(OtherVarcharEntity.class);
		q.eq(OtherVarcharEntity.NORMALVARCHAR, normalVarchar);
		java.util.List<OtherVarcharEntity> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//Subtypes have to be set to allow searching[type=enum]
	@javax.persistence.Column(name="__type", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="__type")
	
				

	@javax.validation.constraints.NotNull
	private String __type =  null;
	@javax.persistence.Transient
	private String __type_label = null;
	@javax.persistence.Transient
	private java.util.List<org.molgenis.db.common.ValueLabel> __type_options = new java.util.ArrayList<org.molgenis.db.common.ValueLabel>();


	//No description provided[type=int]
    @javax.persistence.Id @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Column(name="id", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="id")
	
	//@javax.validation.constraints.NotNull
	private Integer id =  null;


	//No description provided[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="normalVarchar", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="normalVarchar")
	
				

	@javax.validation.constraints.NotNull
	private String normalVarchar =  null;


	//No description provided[type=string]
	@javax.persistence.Column(name="readonlyVarchar", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="readonlyVarchar")
	
				

	@javax.validation.constraints.NotNull
	private String readonlyVarchar =  "readonly default";


	//No description provided[type=string]
	@javax.persistence.Column(name="nillableVarchar")
	@javax.xml.bind.annotation.XmlElement(name="nillableVarchar")
	
				

	private String nillableVarchar =  null;


	//No description provided[type=string]
	@javax.persistence.Column(name="defaultVarchar", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="defaultVarchar")
	
				

	@javax.validation.constraints.NotNull
	private String defaultVarchar =  "1";

	//constructors
	public OtherVarcharEntity()
	{
	
		//options for enum __Type
		__type_options.add(new org.molgenis.db.common.ValueLabel("[OtherVarcharEntity]","[OtherVarcharEntity]"));
	}
	
	//getters and setters
	/**
	 * Get the Subtypes have to be set to allow searching.
	 * @return __type.
	 */
	public String get__Type()
	{
		return this.__type;
	}
	
	@Deprecated
	public String get__Type(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Subtypes have to be set to allow searching.
	 * @param __type
	 */
	public void set__Type( String __type)
	{
		
		this.__type = __type;
	}

	
	/**
	 * Get tha label for enum __Type.
	 */
	public String get__TypeLabel()
	{
		return this.__type_label;
	}
	
	/**
	 * __Type is enum. This method returns all available enum options.
	 */
	public java.util.List<org.molgenis.db.common.ValueLabel> get__TypeOptions()
	{
		return __type_options;
	}	
	

	/**
	 * Get the No description provided.
	 * @return id.
	 */
	public Integer getId()
	{
		return this.id;
	}
	
	
	/**
	 * Set the No description provided.
	 * @param id
	 */
	public void setId( Integer id)
	{
		this.id = id;
	}

	

	/**
	 * Get the No description provided.
	 * @return normalVarchar.
	 */
	public String getNormalVarchar()
	{
		return this.normalVarchar;
	}
	
	@Deprecated
	public String getNormalVarchar(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param normalVarchar
	 */
	public void setNormalVarchar( String normalVarchar)
	{
		
		this.normalVarchar = normalVarchar;
	}

	

	/**
	 * Get the No description provided.
	 * @return readonlyVarchar.
	 */
	public String getReadonlyVarchar()
	{
		return this.readonlyVarchar;
	}
	
	@Deprecated
	public String getReadonlyVarchar(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param readonlyVarchar
	 */
	public void setReadonlyVarchar( String readonlyVarchar)
	{
		
		this.readonlyVarchar = readonlyVarchar;
	}

	

	/**
	 * Get the No description provided.
	 * @return nillableVarchar.
	 */
	public String getNillableVarchar()
	{
		return this.nillableVarchar;
	}
	
	@Deprecated
	public String getNillableVarchar(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param nillableVarchar
	 */
	public void setNillableVarchar( String nillableVarchar)
	{
		
		this.nillableVarchar = nillableVarchar;
	}

	

	/**
	 * Get the No description provided.
	 * @return defaultVarchar.
	 */
	public String getDefaultVarchar()
	{
		return this.defaultVarchar;
	}
	
	@Deprecated
	public String getDefaultVarchar(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param defaultVarchar
	 */
	public void setDefaultVarchar( String defaultVarchar)
	{
		
		this.defaultVarchar = defaultVarchar;
	}

	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("__type"))
			return get__Type();
		if(name.toLowerCase().equals("__type_label"))
			return get__TypeLabel();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("normalvarchar"))
			return getNormalVarchar();
		if (name.toLowerCase().equals("readonlyvarchar"))
			return getReadonlyVarchar();
		if (name.toLowerCase().equals("nillablevarchar"))
			return getNillableVarchar();
		if (name.toLowerCase().equals("defaultvarchar"))
			return getDefaultVarchar();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getId() == null) throw new org.molgenis.db.common.DatabaseException("required field id is null");
		if(this.getNormalVarchar() == null) throw new org.molgenis.db.common.DatabaseException("required field normalVarchar is null");
		if(this.getReadonlyVarchar() == null) throw new org.molgenis.db.common.DatabaseException("required field readonlyVarchar is null");
		if(this.getDefaultVarchar() == null) throw new org.molgenis.db.common.DatabaseException("required field defaultVarchar is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("OtherVarcharEntity___type") != null) this.set__Type(tuple.getString("OtherVarcharEntity___type"));
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("OtherVarcharEntity_id") != null) this.setId(tuple.getInt("OtherVarcharEntity_id"));
			//set NormalVarchar
			if( strict || tuple.getString("normalVarchar") != null) this.setNormalVarchar(tuple.getString("normalVarchar"));
			if( tuple.getString("OtherVarcharEntity_normalVarchar") != null) this.setNormalVarchar(tuple.getString("OtherVarcharEntity_normalVarchar"));
			//set ReadonlyVarchar
			if( strict || tuple.getString("readonlyVarchar") != null) this.setReadonlyVarchar(tuple.getString("readonlyVarchar"));
			if( tuple.getString("OtherVarcharEntity_readonlyVarchar") != null) this.setReadonlyVarchar(tuple.getString("OtherVarcharEntity_readonlyVarchar"));
			//set NillableVarchar
			if( strict || tuple.getString("nillableVarchar") != null) this.setNillableVarchar(tuple.getString("nillableVarchar"));
			if( tuple.getString("OtherVarcharEntity_nillableVarchar") != null) this.setNillableVarchar(tuple.getString("OtherVarcharEntity_nillableVarchar"));
			//set DefaultVarchar
			if( strict || tuple.getString("defaultVarchar") != null) this.setDefaultVarchar(tuple.getString("defaultVarchar"));
			if( tuple.getString("OtherVarcharEntity_defaultVarchar") != null) this.setDefaultVarchar(tuple.getString("OtherVarcharEntity_defaultVarchar"));
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
		String result = "OtherVarcharEntity(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "id='" + getId()+"' ";	
		result+= "normalVarchar='" + getNormalVarchar()+"' ";	
		result+= "readonlyVarchar='" + getReadonlyVarchar()+"' ";	
		result+= "nillableVarchar='" + getNillableVarchar()+"' ";	
		result+= "defaultVarchar='" + getDefaultVarchar()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of OtherVarcharEntity.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		{
			fields.add("__type");
		}
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("normalVarchar");
		}
		{
			fields.add("readonlyVarchar");
		}
		{
			fields.add("nillableVarchar");
		}
		{
			fields.add("defaultVarchar");
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
		result.add("normalVarchar");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "__type" +sep
		+ "id" +sep
		+ "normalVarchar" +sep
		+ "readonlyVarchar" +sep
		+ "nillableVarchar" +sep
		+ "defaultVarchar" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        
        return null;
    }	

	@Override
	public boolean equals(Object obj) {
   		if (obj == null) { return false; }
   		if (obj == this) { return true; }
   		if (obj.getClass() != getClass()) {
     		return false;
   		}
		OtherVarcharEntity rhs = (OtherVarcharEntity) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//normalVarchar
				.append(normalVarchar, rhs.getNormalVarchar())
		//normalVarchar
				.append(normalVarchar, rhs.getNormalVarchar())
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
				.append(normalVarchar)
				.append(normalVarchar)
   			.toHashCode();
    }  	
  	


	@Deprecated
	public String getValues(String sep)
	{
		java.io.StringWriter out = new java.io.StringWriter();
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
			Object valueO = getNormalVarchar();
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
			Object valueO = getReadonlyVarchar();
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
			Object valueO = getNillableVarchar();
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
			Object valueO = getDefaultVarchar();
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
	public OtherVarcharEntity create(org.molgenis.db.Tuple tuple) throws Exception
	{
		OtherVarcharEntity e = new OtherVarcharEntity();
		e.set(tuple);
		return e;
	}
	
//1
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="nillableXref"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<test.fields.XrefEntity> nillableXrefXrefEntityCollection = new java.util.ArrayList<test.fields.XrefEntity>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<test.fields.XrefEntity> getNillableXrefXrefEntityCollection()
	{
            return nillableXrefXrefEntityCollection;
	}

    public void setNillableXrefXrefEntityCollection(java.util.Collection<test.fields.XrefEntity> collection)
    {
        for (test.fields.XrefEntity xrefEntity : collection) {
            xrefEntity.setNillableXref(this);
        }
        nillableXrefXrefEntityCollection = collection;
    }	


	
}

