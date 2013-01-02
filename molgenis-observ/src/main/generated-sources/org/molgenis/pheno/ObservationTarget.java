
/* File:        observ/model/ObservationTarget.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.pheno;

/**
 * ObservationTarget:  An ObservationTarget class defines the subjects of
				observation. For instance: individual 1 from Investigation x. The
				ObservationTarget class maps to XGAP:Subject, METABASE:Patient and
				maps to Page:Abstract_Observation_Target. The name of
				observationTargets is unique.
			
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "ObservationTarget"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.pheno.db.ObservationTargetEntityListener.class})
public class ObservationTarget extends org.molgenis.pheno.ObservationElement 
{
	// fieldname constants
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(ObservationTarget.class).
	 */
	public static org.molgenis.framework.db.Query<? extends ObservationTarget> query(org.molgenis.framework.db.Database db)
	{
		return db.query(ObservationTarget.class);
	}
	
	/**
	 * Shorthand for db.find(ObservationTarget.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends ObservationTarget> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(ObservationTarget.class, rules);
	}	
	
	/**
	 * 
	 */
	public static ObservationTarget findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservationTarget> q = db.query(ObservationTarget.class);
		q.eq(ObservationTarget.ID, id);
		java.util.List<ObservationTarget> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static ObservationTarget findByNameInvestigation(org.molgenis.framework.db.Database db, String name, Integer investigation) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservationTarget> q = db.query(ObservationTarget.class);
		q.eq(ObservationTarget.NAME, name);q.eq(ObservationTarget.INVESTIGATION, investigation);
		java.util.List<ObservationTarget> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static ObservationTarget findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ObservationTarget> q = db.query(ObservationTarget.class);
		q.eq(ObservationTarget.NAME, name);
		java.util.List<ObservationTarget> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatically generated id[type=int]
	

	//constructors
	public ObservationTarget()
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
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("ObservationTarget_id") != null) this.setId(tuple.getInt("ObservationTarget_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("ObservationTarget_name") != null) this.setName(tuple.getString("ObservationTarget_name"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("ObservationTarget_description") != null) this.setDescription(tuple.getString("ObservationTarget_description"));
			//set Investigation
			if( strict || tuple.getInt("Investigation_id") != null) this.setInvestigation(tuple.getInt("Investigation_id"));
			if( tuple.getInt("ObservationTarget_Investigation_id") != null) this.setInvestigation(tuple.getInt("ObservationTarget_Investigation_id"));
			//alias of xref
			if( tuple.getObject("Investigation") != null) this.setInvestigation(tuple.getInt("Investigation"));
			if( tuple.getObject("ObservationTarget_Investigation") != null) this.setInvestigation(tuple.getInt("ObservationTarget_Investigation"));
			//set label for field Investigation
			if( strict || tuple.getObject("Investigation_name") != null) this.setInvestigation_Name(tuple.getString("Investigation_name"));			
			if( tuple.getObject("ObservationTarget_Investigation_name") != null ) this.setInvestigation_Name(tuple.getString("ObservationTarget_Investigation_name"));		
			//set OntologyReference
			if( tuple.getObject("ontologyReference")!= null || tuple.getObject("ObservationTarget_ontologyReference")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference");
				if(tuple.getObject("ObservationTarget_ontologyReference")!= null) mrefs = tuple.getList("ObservationTarget_ontologyReference");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setOntologyReference_Id( values );
			}
			//set labels name for mref field OntologyReference	
			if( tuple.getObject("ontologyReference_name")!= null || tuple.getObject("ObservationTarget_ontologyReference_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference_name");
				if(tuple.getObject("ObservationTarget_ontologyReference_name")!= null) mrefs = tuple.getList("ObservationTarget_ontologyReference_name");
				
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
			if( tuple.getString("ObservationTarget___Type") != null) this.set__Type(tuple.getString("ObservationTarget___Type"));
			//set AlternateId
			if( tuple.getObject("AlternateId")!= null || tuple.getObject("ObservationTarget_AlternateId")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("AlternateId");
				if(tuple.getObject("ObservationTarget_AlternateId")!= null) mrefs = tuple.getList("ObservationTarget_AlternateId");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setAlternateId_Id( values );
			}
			//set labels name for mref field AlternateId	
			if( tuple.getObject("AlternateId_name")!= null || tuple.getObject("ObservationTarget_AlternateId_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("AlternateId_name");
				if(tuple.getObject("ObservationTarget_AlternateId_name")!= null) mrefs = tuple.getList("ObservationTarget_AlternateId_name");
				
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
			if( tuple.getString("ObservationTarget_label") != null) this.setLabel(tuple.getString("ObservationTarget_label"));
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
		String result = "ObservationTarget(";
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
		result+= "label='" + getLabel()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of ObservationTarget.
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
		+ "label" 
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
		ObservationTarget rhs = (ObservationTarget) obj;
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
			out.write(valueS);
		}
		return out.toString();
	}
	
	@Override
	public ObservationTarget create(org.molgenis.util.Tuple tuple) throws Exception
	{
		ObservationTarget e = new ObservationTarget();
		e.set(tuple);
		return e;
	}
	

	
}

