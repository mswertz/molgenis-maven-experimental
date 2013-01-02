
/* File:        observ/model/AlternateId.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.pheno;

/**
 * AlternateId: 
				An external identifier for an annotation. For example: name='R13H8.1', ontology='ensembl' or name='WBgene00000912', ontology='wormbase'.
			
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "AlternateId"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.pheno.db.AlternateIdEntityListener.class})
public class AlternateId extends org.molgenis.core.OntologyTerm 
{
	// fieldname constants
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(AlternateId.class).
	 */
	public static org.molgenis.framework.db.Query<? extends AlternateId> query(org.molgenis.framework.db.Database db)
	{
		return db.query(AlternateId.class);
	}
	
	/**
	 * Shorthand for db.find(AlternateId.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends AlternateId> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(AlternateId.class, rules);
	}	
	
	/**
	 * 
	 */
	public static AlternateId findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<AlternateId> q = db.query(AlternateId.class);
		q.eq(AlternateId.ID, id);
		java.util.List<AlternateId> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static AlternateId findByOntologyTermAccession(org.molgenis.framework.db.Database db, Integer ontology, String termAccession) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<AlternateId> q = db.query(AlternateId.class);
		q.eq(AlternateId.ONTOLOGY, ontology);q.eq(AlternateId.TERMACCESSION, termAccession);
		java.util.List<AlternateId> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static AlternateId findByOntologyName(org.molgenis.framework.db.Database db, Integer ontology, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<AlternateId> q = db.query(AlternateId.class);
		q.eq(AlternateId.ONTOLOGY, ontology);q.eq(AlternateId.NAME, name);
		java.util.List<AlternateId> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatically generated id[type=int]
	

	//constructors
	public AlternateId()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	

	


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
		if (name.toLowerCase().equals("__type"))
			return get__Type();
		if(name.toLowerCase().equals("__type_label"))
			return get__TypeLabel();
		if (name.toLowerCase().equals("ontology"))
			return getOntology();
		if(name.toLowerCase().equals("ontology_id"))
			return getOntology_Id();
		if(name.toLowerCase().equals("ontology_name"))
			return getOntology_Name();
		if (name.toLowerCase().equals("termaccession"))
			return getTermAccession();
		if (name.toLowerCase().equals("definition"))
			return getDefinition();
		if (name.toLowerCase().equals("termpath"))
			return getTermPath();
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
			//set __Type
			this.set__Type(tuple.getString("__Type"));
			//set Ontology
			this.setOntology(tuple.getInt("ontology"));
			//set label name for xref field Ontology
			this.setOntology_Name(tuple.getString("ontology_name"));	
			//set TermAccession
			this.setTermAccession(tuple.getString("termAccession"));
			//set Definition
			this.setDefinition(tuple.getString("definition"));
			//set TermPath
			this.setTermPath(tuple.getString("termPath"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("AlternateId_id") != null) this.setId(tuple.getInt("AlternateId_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("AlternateId_name") != null) this.setName(tuple.getString("AlternateId_name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("AlternateId___Type") != null) this.set__Type(tuple.getString("AlternateId___Type"));
			//set Ontology
			if( strict || tuple.getInt("ontology_id") != null) this.setOntology(tuple.getInt("ontology_id"));
			if( tuple.getInt("AlternateId_ontology_id") != null) this.setOntology(tuple.getInt("AlternateId_ontology_id"));
			//alias of xref
			if( tuple.getObject("ontology") != null) this.setOntology(tuple.getInt("ontology"));
			if( tuple.getObject("AlternateId_ontology") != null) this.setOntology(tuple.getInt("AlternateId_ontology"));
			//set label for field Ontology
			if( strict || tuple.getObject("ontology_name") != null) this.setOntology_Name(tuple.getString("ontology_name"));			
			if( tuple.getObject("AlternateId_ontology_name") != null ) this.setOntology_Name(tuple.getString("AlternateId_ontology_name"));		
			//set TermAccession
			if( strict || tuple.getString("termAccession") != null) this.setTermAccession(tuple.getString("termAccession"));
			if( tuple.getString("AlternateId_termAccession") != null) this.setTermAccession(tuple.getString("AlternateId_termAccession"));
			//set Definition
			if( strict || tuple.getString("definition") != null) this.setDefinition(tuple.getString("definition"));
			if( tuple.getString("AlternateId_definition") != null) this.setDefinition(tuple.getString("AlternateId_definition"));
			//set TermPath
			if( strict || tuple.getString("termPath") != null) this.setTermPath(tuple.getString("termPath"));
			if( tuple.getString("AlternateId_termPath") != null) this.setTermPath(tuple.getString("AlternateId_termPath"));
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
		String result = "AlternateId(";
		result+= "id='" + getId()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= " ontology_id='" + getOntology_Id()+"' ";	
		result+= " ontology_name='" + getOntology_Name()+"' ";
		result+= "termAccession='" + getTermAccession()+"' ";	
		result+= "definition='" + getDefinition()+"' ";	
		result+= "termPath='" + getTermPath()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of AlternateId.
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
			fields.add("__Type");
		}
		{
			fields.add("ontology_id");
		}
		fields.add("ontology_name");
		{
			fields.add("termAccession");
		}
		{
			fields.add("definition");
		}
		{
			fields.add("termPath");
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
		+ "__Type" +sep
		+ "ontology" +sep
		+ "termAccession" +sep
		+ "definition" +sep
		+ "termPath" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("ontology")) {
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
		AlternateId rhs = (AlternateId) obj;
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
			Object valueO = getOntology();
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
			Object valueO = getTermAccession();
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
			Object valueO = getDefinition();
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
			Object valueO = getTermPath();
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
	public AlternateId create(org.molgenis.util.Tuple tuple) throws Exception
	{
		AlternateId e = new AlternateId();
		e.set(tuple);
		return e;
	}
	
	//2
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="alternateId"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.pheno.ObservationElement> alternateIdObservationElementCollection = new java.util.ArrayList<org.molgenis.pheno.ObservationElement>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.ObservationElement> getAlternateIdObservationElementCollection()
	{
        return alternateIdObservationElementCollection;
	}

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.pheno.ObservationElement> getAlternateIdObservationElementCollection(org.molgenis.framework.db.Database db)
	{
        return getAlternateIdObservationElementCollection();
	}

    public void setAlternateIdObservationElementCollection(java.util.Collection<org.molgenis.pheno.ObservationElement> collection)
    {
    	alternateIdObservationElementCollection.addAll(collection);
    }	

	
}

