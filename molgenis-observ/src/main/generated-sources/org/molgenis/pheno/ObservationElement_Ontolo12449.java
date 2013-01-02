
/* File:        observ/model/ObservationElement_ontolo12449.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.pheno;

/**
 * ObservationElement_ontolo12449: Link table for many-to-many relationship 'ObservationElement.ontologyReference'..
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.pheno.db.ObservationElement_Ontolo12449EntityListener.class})
public class ObservationElement_Ontolo12449 extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String AUTOID = "autoid";
	public final static String ONTOLOGYREFERENCE = "ontologyReference";
	public final static String ONTOLOGYREFERENCE_NAME = "ontologyReference_name";
	public final static String INVESTIGATIONELEMENT = "InvestigationElement";
	public final static String INVESTIGATIONELEMENT_NAME = "InvestigationElement_name";
	
	//static methods
	/**
	 * Shorthand for db.query(ObservationElement_Ontolo12449.class).
	 */
	public static org.molgenis.framework.db.Query<? extends ObservationElement_Ontolo12449> query(org.molgenis.framework.db.Database db)
	{
		return db.query(ObservationElement_Ontolo12449.class);
	}
	
	/**
	 * Shorthand for db.find(ObservationElement_Ontolo12449.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends ObservationElement_Ontolo12449> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(ObservationElement_Ontolo12449.class, rules);
	}	
	
	/**
	 * 
	 */
	public static ObservationElement_Ontolo12449 findByAutoid(org.molgenis.framework.db.Database db, Integer autoid) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservationElement_Ontolo12449> q = db.query(ObservationElement_Ontolo12449.class);
		q.eq(ObservationElement_Ontolo12449.AUTOID, autoid);
		java.util.List<ObservationElement_Ontolo12449> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static ObservationElement_Ontolo12449 findByOntologyReferenceInvestigationElement(org.molgenis.framework.db.Database db, Integer ontologyReference, Integer investigationElement) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservationElement_Ontolo12449> q = db.query(ObservationElement_Ontolo12449.class);
		q.eq(ObservationElement_Ontolo12449.ONTOLOGYREFERENCE, ontologyReference);q.eq(ObservationElement_Ontolo12449.INVESTIGATIONELEMENT, investigationElement);
		java.util.List<ObservationElement_Ontolo12449> result = q.find();
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
    @javax.persistence.JoinColumn(name="ontologyReference", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.core.OntologyTerm ontologyReference = null;
	@javax.persistence.Transient
	private Integer ontologyReference_id = null;	
	@javax.persistence.Transient
	private String ontologyReference_name = null;						


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="InvestigationElement", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.pheno.ObservationElement investigationElement = null;
	@javax.persistence.Transient
	private Integer investigationElement_id = null;	
	@javax.persistence.Transient
	private String investigationElement_name = null;						

	//constructors
	public ObservationElement_Ontolo12449()
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
	 * Set the .
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
	 * Get the .
	 * @return investigationElement.
	 */
	public org.molgenis.pheno.ObservationElement getInvestigationElement()
	{
		return this.investigationElement;
	}
	
	@Deprecated
	public org.molgenis.pheno.ObservationElement getInvestigationElement(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param investigationElement
	 */
	public void setInvestigationElement( org.molgenis.pheno.ObservationElement investigationElement)
	{
		
		this.investigationElement = investigationElement;
	}

	
	
	/**
	 * Set foreign key for field investigationElement.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setInvestigationElement_Id(Integer investigationElement_id)
	{
		this.investigationElement_id = investigationElement_id;
	}	

	public void setInvestigationElement(Integer investigationElement_id)
	{
		this.investigationElement_id = investigationElement_id;
	}
	
	public Integer getInvestigationElement_Id()
	{
		
		if(investigationElement != null) 
		{
			return investigationElement.getId();
		}
		else
		{
			return investigationElement_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference InvestigationElement to ObservationElement.Id.
	 */
	public String getInvestigationElement_Name()
	{		
		//FIXME should we auto-load based on getInvestigationElement()?	
		if(investigationElement != null) {
			return investigationElement.getName();
		} else {
			return investigationElement_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference InvestigationElement to <a href="ObservationElement.html#Id">ObservationElement.Id</a>.
	 * Implies setInvestigationElement(null) until save
	 */
	public void setInvestigationElement_Name(String investigationElement_name)
	{
		this.investigationElement_name = investigationElement_name;
	}		
	 
	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("autoid"))
			return getAutoid();
		if (name.toLowerCase().equals("ontologyreference"))
			return getOntologyReference();
		if(name.toLowerCase().equals("ontologyreference_id"))
			return getOntologyReference_Id();
		if(name.toLowerCase().equals("ontologyreference_name"))
			return getOntologyReference_Name();
		if (name.toLowerCase().equals("investigationelement"))
			return getInvestigationElement();
		if(name.toLowerCase().equals("investigationelement_id"))
			return getInvestigationElement_Id();
		if(name.toLowerCase().equals("investigationelement_name"))
			return getInvestigationElement_Name();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getAutoid() == null) throw new org.molgenis.framework.db.DatabaseException("required field autoid is null");
		if(this.getOntologyReference() == null) throw new org.molgenis.framework.db.DatabaseException("required field ontologyReference is null");
		if(this.getInvestigationElement() == null) throw new org.molgenis.framework.db.DatabaseException("required field investigationElement is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Autoid
			this.setAutoid(tuple.getInt("autoid"));
			//set OntologyReference
			this.setOntologyReference(tuple.getInt("ontologyReference"));
			//set label name for xref field OntologyReference
			this.setOntologyReference_Name(tuple.getString("ontologyReference_name"));	
			//set InvestigationElement
			this.setInvestigationElement(tuple.getInt("InvestigationElement"));
			//set label name for xref field InvestigationElement
			this.setInvestigationElement_Name(tuple.getString("InvestigationElement_name"));	
		}
		else if(tuple != null)
		{
			//set Autoid
			if( strict || tuple.getInt("autoid") != null) this.setAutoid(tuple.getInt("autoid"));
			if( tuple.getInt("ObservationElement_ontolo12449_autoid") != null) this.setAutoid(tuple.getInt("ObservationElement_ontolo12449_autoid"));
			//set OntologyReference
			if( strict || tuple.getInt("ontologyReference_id") != null) this.setOntologyReference(tuple.getInt("ontologyReference_id"));
			if( tuple.getInt("ObservationElement_ontolo12449_ontologyReference_id") != null) this.setOntologyReference(tuple.getInt("ObservationElement_ontolo12449_ontologyReference_id"));
			//alias of xref
			if( tuple.getObject("ontologyReference") != null) this.setOntologyReference(tuple.getInt("ontologyReference"));
			if( tuple.getObject("ObservationElement_ontolo12449_ontologyReference") != null) this.setOntologyReference(tuple.getInt("ObservationElement_ontolo12449_ontologyReference"));
			//set label for field OntologyReference
			if( strict || tuple.getObject("ontologyReference_name") != null) this.setOntologyReference_Name(tuple.getString("ontologyReference_name"));			
			if( tuple.getObject("ObservationElement_ontolo12449_ontologyReference_name") != null ) this.setOntologyReference_Name(tuple.getString("ObservationElement_ontolo12449_ontologyReference_name"));		
			//set InvestigationElement
			if( strict || tuple.getInt("InvestigationElement_id") != null) this.setInvestigationElement(tuple.getInt("InvestigationElement_id"));
			if( tuple.getInt("ObservationElement_ontolo12449_InvestigationElement_id") != null) this.setInvestigationElement(tuple.getInt("ObservationElement_ontolo12449_InvestigationElement_id"));
			//alias of xref
			if( tuple.getObject("InvestigationElement") != null) this.setInvestigationElement(tuple.getInt("InvestigationElement"));
			if( tuple.getObject("ObservationElement_ontolo12449_InvestigationElement") != null) this.setInvestigationElement(tuple.getInt("ObservationElement_ontolo12449_InvestigationElement"));
			//set label for field InvestigationElement
			if( strict || tuple.getObject("InvestigationElement_name") != null) this.setInvestigationElement_Name(tuple.getString("InvestigationElement_name"));			
			if( tuple.getObject("ObservationElement_ontolo12449_InvestigationElement_name") != null ) this.setInvestigationElement_Name(tuple.getString("ObservationElement_ontolo12449_InvestigationElement_name"));		
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
		String result = "ObservationElement_Ontolo12449(";
		result+= "autoid='" + getAutoid()+"' ";	
		result+= " ontologyReference_id='" + getOntologyReference_Id()+"' ";	
		result+= " ontologyReference_name='" + getOntologyReference_Name()+"' ";
		result+= " investigationElement_id='" + getInvestigationElement_Id()+"' ";	
		result+= " investigationElement_name='" + getInvestigationElement_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of ObservationElement_Ontolo12449.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("autoid");
		}
		{
			fields.add("ontologyReference_id");
		}
		fields.add("ontologyReference_name");
		{
			fields.add("investigationElement_id");
		}
		fields.add("investigationElement_name");
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
		result.add("ontologyReference");
		result.add("InvestigationElement");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "autoid" +sep
		+ "ontologyReference" +sep
		+ "investigationElement" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("ontologyReference")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("investigationElement")) {
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
		ObservationElement_Ontolo12449 rhs = (ObservationElement_Ontolo12449) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//ontologyReference
		//investigationElement
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
			Object valueO = getInvestigationElement();
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
	public ObservationElement_Ontolo12449 create(org.molgenis.util.Tuple tuple) throws Exception
	{
		ObservationElement_Ontolo12449 e = new ObservationElement_Ontolo12449();
		e.set(tuple);
		return e;
	}
	

	
}

