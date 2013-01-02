
/* File:        test/model/BimplementsA.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        November 1, 2012
 * Generator:   org.molgenis.db.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package test.inheritance;

/**
 * BimplementsA: No description provided.
 * @version November 1, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "BimplementsA", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "fieldA" } ) }
)


@javax.persistence.Inheritance(strategy=javax.persistence.InheritanceType.JOINED)
@javax.persistence.DiscriminatorColumn(name="DType", discriminatorType=javax.persistence.DiscriminatorType.STRING)
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({test.inheritance.db.BimplementsAEntityListener.class})
public class BimplementsA extends org.molgenis.db.common.AbstractEntity implements test.inheritance.InterfaceA
{
	private static final long serialVersionUID = 1L;
	// fieldname constants
	public final static String __TYPE = "__type";
	public final static String ID = "id";
	public final static String FIELDA = "fieldA";
	public final static String FIELDB = "fieldB";
	public final static String ISSUETYPE = "IssueType";
	
	//static methods
	/**
	 * Shorthand for db.query(BimplementsA.class).
	 */
	public static org.molgenis.db.Query<? extends BimplementsA> query(org.molgenis.db.Database db)
	{
		return db.query(BimplementsA.class);
	}
	
	/**
	 * Shorthand for db.find(BimplementsA.class, org.molgenis.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends BimplementsA> find(org.molgenis.db.Database db, org.molgenis.db.QueryRule ... rules) throws org.molgenis.db.common.DatabaseException
	{
		return db.find(BimplementsA.class, rules);
	}	
	
	/**
	 * BimplementsA
	 */
	public static BimplementsA findByFieldA(org.molgenis.db.Database db, String fieldA) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<BimplementsA> q = db.query(BimplementsA.class);
		q.eq(BimplementsA.FIELDA, fieldA);
		java.util.List<BimplementsA> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * BimplementsA
	 */
	public static BimplementsA findById(org.molgenis.db.Database db, Integer id) throws org.molgenis.db.common.DatabaseException
	{
		org.molgenis.db.Query<BimplementsA> q = db.query(BimplementsA.class);
		q.eq(BimplementsA.ID, id);
		java.util.List<BimplementsA> result = q.find();
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
	@javax.persistence.Column(name="id", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="id")
	
				

	@javax.validation.constraints.NotNull
	private Integer id =  null;


	//No description provided[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="fieldA", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="fieldA")
	
				

	@javax.validation.constraints.NotNull
	private String fieldA =  null;


	//No description provided[type=string]
	@javax.persistence.Column(name="fieldB", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="fieldB")
	
				

	@javax.validation.constraints.NotNull
	private String fieldB =  null;


	//Issue[type=string]
	@javax.persistence.Column(name="IssueType", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="issueType")
	
				

	@javax.validation.constraints.NotNull
	private String issueType =  null;

	//constructors
	public BimplementsA()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
		//options for enum __Type
		__type_options.add(new org.molgenis.db.common.ValueLabel("[BimplementsA]","[BimplementsA]"));
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
	
	@Deprecated
	public Integer getId(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
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
	 * @return fieldA.
	 */
	public String getFieldA()
	{
		return this.fieldA;
	}
	
	@Deprecated
	public String getFieldA(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param fieldA
	 */
	public void setFieldA( String fieldA)
	{
		
		this.fieldA = fieldA;
	}

	

	/**
	 * Get the No description provided.
	 * @return fieldB.
	 */
	public String getFieldB()
	{
		return this.fieldB;
	}
	
	@Deprecated
	public String getFieldB(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the No description provided.
	 * @param fieldB
	 */
	public void setFieldB( String fieldB)
	{
		
		this.fieldB = fieldB;
	}

	

	/**
	 * Get the Issue.
	 * @return issueType.
	 */
	public String getIssueType()
	{
		return this.issueType;
	}
	
	@Deprecated
	public String getIssueType(org.molgenis.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Issue.
	 * @param issueType
	 */
	public void setIssueType( String issueType)
	{
		
		this.issueType = issueType;
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
		if (name.toLowerCase().equals("fielda"))
			return getFieldA();
		if (name.toLowerCase().equals("fieldb"))
			return getFieldB();
		if (name.toLowerCase().equals("issuetype"))
			return getIssueType();
		return "";
	}	
	
	public void validate() throws org.molgenis.db.common.DatabaseException
	{
		if(this.get__Type() == null) throw new org.molgenis.db.common.DatabaseException("required field __type is null");
		if(this.getId() == null) throw new org.molgenis.db.common.DatabaseException("required field id is null");
		if(this.getFieldA() == null) throw new org.molgenis.db.common.DatabaseException("required field fieldA is null");
		if(this.getFieldB() == null) throw new org.molgenis.db.common.DatabaseException("required field fieldB is null");
		if(this.getIssueType() == null) throw new org.molgenis.db.common.DatabaseException("required field issueType is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
				//set __Type
			if( strict || tuple.getString("__type") != null) this.set__Type(tuple.getString("__type"));
			if( tuple.getString("BimplementsA___type") != null) this.set__Type(tuple.getString("BimplementsA___type"));
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("BimplementsA_id") != null) this.setId(tuple.getInt("BimplementsA_id"));
			//set FieldA
			if( strict || tuple.getString("fieldA") != null) this.setFieldA(tuple.getString("fieldA"));
			if( tuple.getString("BimplementsA_fieldA") != null) this.setFieldA(tuple.getString("BimplementsA_fieldA"));
			//set FieldB
			if( strict || tuple.getString("fieldB") != null) this.setFieldB(tuple.getString("fieldB"));
			if( tuple.getString("BimplementsA_fieldB") != null) this.setFieldB(tuple.getString("BimplementsA_fieldB"));
			//set IssueType
			if( strict || tuple.getString("IssueType") != null) this.setIssueType(tuple.getString("IssueType"));
			if( tuple.getString("BimplementsA_IssueType") != null) this.setIssueType(tuple.getString("BimplementsA_IssueType"));
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
		String result = "BimplementsA(";
		result+= "__type='" + get__Type()+"' ";	
		result+= "id='" + getId()+"' ";	
		result+= "fieldA='" + getFieldA()+"' ";	
		result+= "fieldB='" + getFieldB()+"' ";	
		result+= "issueType='" + getIssueType()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of BimplementsA.
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
			fields.add("fieldA");
		}
		{
			fields.add("fieldB");
		}
		{
			fields.add("issueType");
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
		result.add("fieldA");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "__type" +sep
		+ "id" +sep
		+ "fieldA" +sep
		+ "fieldB" +sep
		+ "issueType" 
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
		BimplementsA rhs = (BimplementsA) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//fieldA
				.append(fieldA, rhs.getFieldA())
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
				.append(fieldA)
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
			Object valueO = getFieldA();
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
			Object valueO = getFieldB();
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
			Object valueO = getIssueType();
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
	public BimplementsA create(org.molgenis.db.Tuple tuple) throws Exception
	{
		BimplementsA e = new BimplementsA();
		e.set(tuple);
		return e;
	}
	


	
}

