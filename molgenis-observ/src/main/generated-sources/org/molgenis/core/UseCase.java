
/* File:        observ/model/UseCase.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.core;

/**
 * UseCase:  All the use cases send to the server are stored in this
				entity .
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "UseCase", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "UseCaseName" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.core.db.UseCaseEntityListener.class})
public class UseCase extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String USECASEID = "UseCaseId";
	public final static String USECASENAME = "UseCaseName";
	public final static String SEARCHTYPE = "SearchType";
	
	//static methods
	/**
	 * Shorthand for db.query(UseCase.class).
	 */
	public static org.molgenis.framework.db.Query<? extends UseCase> query(org.molgenis.framework.db.Database db)
	{
		return db.query(UseCase.class);
	}
	
	/**
	 * Shorthand for db.find(UseCase.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends UseCase> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(UseCase.class, rules);
	}	
	
	/**
	 * 
	 */
	public static UseCase findByUseCaseId(org.molgenis.framework.db.Database db, Integer useCaseId) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<UseCase> q = db.query(UseCase.class);
		q.eq(UseCase.USECASEID, useCaseId);
		java.util.List<UseCase> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static UseCase findByUseCaseName(org.molgenis.framework.db.Database db, String useCaseName) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<UseCase> q = db.query(UseCase.class);
		q.eq(UseCase.USECASENAME, useCaseName);
		java.util.List<UseCase> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//UseCaseId[type=int]
    @javax.persistence.Id @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Column(name="UseCaseId", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="useCaseId")
	
	//@javax.validation.constraints.NotNull
	private Integer useCaseId =  null;


	//UseCaseName[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="UseCaseName", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="useCaseName")
	
				

	@javax.validation.constraints.NotNull
	private String useCaseName =  null;


	//SearchType[type=string]
	@javax.persistence.Column(name="SearchType", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="searchType")
	
				

	@javax.validation.constraints.NotNull
	private String searchType =  null;

	//constructors
	public UseCase()
	{
	
	}
	
	//getters and setters
	/**
	 * Get the UseCaseId.
	 * @return useCaseId.
	 */
	public Integer getUseCaseId()
	{
		return this.useCaseId;
	}
	
	
	/**
	 * Set the UseCaseId.
	 * @param useCaseId
	 */
	public void setUseCaseId( Integer useCaseId)
	{
		this.useCaseId = useCaseId;
	}

	

	/**
	 * Get the UseCaseName.
	 * @return useCaseName.
	 */
	public String getUseCaseName()
	{
		return this.useCaseName;
	}
	
	@Deprecated
	public String getUseCaseName(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the UseCaseName.
	 * @param useCaseName
	 */
	public void setUseCaseName( String useCaseName)
	{
		
		this.useCaseName = useCaseName;
	}

	

	/**
	 * Get the SearchType.
	 * @return searchType.
	 */
	public String getSearchType()
	{
		return this.searchType;
	}
	
	@Deprecated
	public String getSearchType(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the SearchType.
	 * @param searchType
	 */
	public void setSearchType( String searchType)
	{
		
		this.searchType = searchType;
	}

	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("usecaseid"))
			return getUseCaseId();
		if (name.toLowerCase().equals("usecasename"))
			return getUseCaseName();
		if (name.toLowerCase().equals("searchtype"))
			return getSearchType();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getUseCaseId() == null) throw new org.molgenis.framework.db.DatabaseException("required field useCaseId is null");
		if(this.getUseCaseName() == null) throw new org.molgenis.framework.db.DatabaseException("required field useCaseName is null");
		if(this.getSearchType() == null) throw new org.molgenis.framework.db.DatabaseException("required field searchType is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set UseCaseId
			this.setUseCaseId(tuple.getInt("UseCaseId"));
			//set UseCaseName
			this.setUseCaseName(tuple.getString("UseCaseName"));
			//set SearchType
			this.setSearchType(tuple.getString("SearchType"));
		}
		else if(tuple != null)
		{
			//set UseCaseId
			if( strict || tuple.getInt("UseCaseId") != null) this.setUseCaseId(tuple.getInt("UseCaseId"));
			if( tuple.getInt("UseCase_UseCaseId") != null) this.setUseCaseId(tuple.getInt("UseCase_UseCaseId"));
			//set UseCaseName
			if( strict || tuple.getString("UseCaseName") != null) this.setUseCaseName(tuple.getString("UseCaseName"));
			if( tuple.getString("UseCase_UseCaseName") != null) this.setUseCaseName(tuple.getString("UseCase_UseCaseName"));
			//set SearchType
			if( strict || tuple.getString("SearchType") != null) this.setSearchType(tuple.getString("SearchType"));
			if( tuple.getString("UseCase_SearchType") != null) this.setSearchType(tuple.getString("UseCase_SearchType"));
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
		String result = "UseCase(";
		result+= "useCaseId='" + getUseCaseId()+"' ";	
		result+= "useCaseName='" + getUseCaseName()+"' ";	
		result+= "searchType='" + getSearchType()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of UseCase.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("useCaseId");
		}
		{
			fields.add("useCaseName");
		}
		{
			fields.add("searchType");
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
		return "useCaseId";
	}
	

	
	@Override
	public java.util.List<String> getLabelFields()
	{
		java.util.List<String> result = new java.util.ArrayList<String>();
		result.add("UseCaseName");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "useCaseId" +sep
		+ "useCaseName" +sep
		+ "searchType" 
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
		UseCase rhs = (UseCase) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//useCaseName
				.append(useCaseName, rhs.getUseCaseName())
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
				.append(useCaseName)
   			.toHashCode();
    }  	
  	


	@Deprecated
	public String getValues(String sep)
	{
		java.io.StringWriter out = new java.io.StringWriter();
		{
			Object valueO = getUseCaseId();
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
			Object valueO = getUseCaseName();
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
			Object valueO = getSearchType();
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
	public UseCase create(org.molgenis.util.Tuple tuple) throws Exception
	{
		UseCase e = new UseCase();
		e.set(tuple);
		return e;
	}
	

	
}

