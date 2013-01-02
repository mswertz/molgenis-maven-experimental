
/* File:        observ/model/Workflow.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.protocol;

/**
 * Workflow: A workflow is a plan to execute a series of subprotocols
				in a particular order. Each workflow elements is another protocol as
				refered to via WorkflowElement. Because Workflow extends Protocol,
				workflows can be nested just as any other protocol.
			
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "Workflow", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "name" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.protocol.db.WorkflowEntityListener.class})
public class Workflow extends org.molgenis.protocol.Protocol implements org.molgenis.core.Identifiable, org.molgenis.core.Nameable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String NAME = "name";
	
	//static methods
	/**
	 * Shorthand for db.query(Workflow.class).
	 */
	public static org.molgenis.framework.db.Query<? extends Workflow> query(org.molgenis.framework.db.Database db)
	{
		return db.query(Workflow.class);
	}
	
	/**
	 * Shorthand for db.find(Workflow.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends Workflow> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(Workflow.class, rules);
	}	
	
	/**
	 * 
	 */
	public static Workflow findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Workflow> q = db.query(Workflow.class);
		q.eq(Workflow.ID, id);
		java.util.List<Workflow> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Workflow findByNameInvestigation(org.molgenis.framework.db.Database db, String name, Integer investigation) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Workflow> q = db.query(Workflow.class);
		q.eq(Workflow.NAME, name);q.eq(Workflow.INVESTIGATION, investigation);
		java.util.List<Workflow> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static Workflow findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<Workflow> q = db.query(Workflow.class);
		q.eq(Workflow.NAME, name);
		java.util.List<Workflow> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatically generated id[type=int]
	


	//human-readable name.[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="name", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="name")
	
				

	@javax.validation.constraints.NotNull
	private String name =  null;

	//constructors
	public Workflow()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	

	

	/**
	 * Get the human-readable name..
	 * @return name.
	 */
	public String getName()
	{
		return this.name;
	}
	
	@Deprecated
	public String getName(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the human-readable name..
	 * @param name
	 */
	public void setName( String name)
	{
				//hack to solve problem with variable hidden in supertype
				super.setName(name);
				//2222hack to solve problem with variable hidden in supertype
				super.setName(name);
		
		this.name = name;
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
		if (name.toLowerCase().equals("protocoltype"))
			return getProtocolType();
		if(name.toLowerCase().equals("protocoltype_id"))
			return getProtocolType_Id();
		if(name.toLowerCase().equals("protocoltype_name"))
			return getProtocolType_Name();
		if (name.toLowerCase().equals("features"))
			return getFeatures();
		if(name.toLowerCase().equals("features_id"))
			return getFeatures_Id();
		if(name.toLowerCase().equals("features_name"))
			return getFeatures_Name();
		if (name.toLowerCase().equals("targetfilter"))
			return getTargetFilter();
		if (name.toLowerCase().equals("contact"))
			return getContact();
		if(name.toLowerCase().equals("contact_id"))
			return getContact_Id();
		if(name.toLowerCase().equals("contact_name"))
			return getContact_Name();
		if (name.toLowerCase().equals("subprotocols"))
			return getSubprotocols();
		if(name.toLowerCase().equals("subprotocols_id"))
			return getSubprotocols_Id();
		if(name.toLowerCase().equals("subprotocols_name"))
			return getSubprotocols_Name();
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
			//set ProtocolType
			this.setProtocolType(tuple.getInt("ProtocolType"));
			//set label name for xref field ProtocolType
			this.setProtocolType_Name(tuple.getString("ProtocolType_name"));	
			//mrefs can not be directly retrieved
			//set Features			
			//set TargetFilter
			this.setTargetFilter(tuple.getString("TargetFilter"));
			//set Contact
			this.setContact(tuple.getInt("Contact"));
			//set label name for xref field Contact
			this.setContact_Name(tuple.getString("Contact_name"));	
			//mrefs can not be directly retrieved
			//set Subprotocols			
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("Workflow_id") != null) this.setId(tuple.getInt("Workflow_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("Workflow_name") != null) this.setName(tuple.getString("Workflow_name"));
			//set Description
			if( strict || tuple.getString("description") != null) this.setDescription(tuple.getString("description"));
			if( tuple.getString("Workflow_description") != null) this.setDescription(tuple.getString("Workflow_description"));
			//set Investigation
			if( strict || tuple.getInt("Investigation_id") != null) this.setInvestigation(tuple.getInt("Investigation_id"));
			if( tuple.getInt("Workflow_Investigation_id") != null) this.setInvestigation(tuple.getInt("Workflow_Investigation_id"));
			//alias of xref
			if( tuple.getObject("Investigation") != null) this.setInvestigation(tuple.getInt("Investigation"));
			if( tuple.getObject("Workflow_Investigation") != null) this.setInvestigation(tuple.getInt("Workflow_Investigation"));
			//set label for field Investigation
			if( strict || tuple.getObject("Investigation_name") != null) this.setInvestigation_Name(tuple.getString("Investigation_name"));			
			if( tuple.getObject("Workflow_Investigation_name") != null ) this.setInvestigation_Name(tuple.getString("Workflow_Investigation_name"));		
			//set OntologyReference
			if( tuple.getObject("ontologyReference")!= null || tuple.getObject("Workflow_ontologyReference")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference");
				if(tuple.getObject("Workflow_ontologyReference")!= null) mrefs = tuple.getList("Workflow_ontologyReference");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setOntologyReference_Id( values );
			}
			//set labels name for mref field OntologyReference	
			if( tuple.getObject("ontologyReference_name")!= null || tuple.getObject("Workflow_ontologyReference_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("ontologyReference_name");
				if(tuple.getObject("Workflow_ontologyReference_name")!= null) mrefs = tuple.getList("Workflow_ontologyReference_name");
				
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
			if( tuple.getString("Workflow___Type") != null) this.set__Type(tuple.getString("Workflow___Type"));
			//set ProtocolType
			if( strict || tuple.getInt("ProtocolType_id") != null) this.setProtocolType(tuple.getInt("ProtocolType_id"));
			if( tuple.getInt("Workflow_ProtocolType_id") != null) this.setProtocolType(tuple.getInt("Workflow_ProtocolType_id"));
			//alias of xref
			if( tuple.getObject("ProtocolType") != null) this.setProtocolType(tuple.getInt("ProtocolType"));
			if( tuple.getObject("Workflow_ProtocolType") != null) this.setProtocolType(tuple.getInt("Workflow_ProtocolType"));
			//set label for field ProtocolType
			if( strict || tuple.getObject("ProtocolType_name") != null) this.setProtocolType_Name(tuple.getString("ProtocolType_name"));			
			if( tuple.getObject("Workflow_ProtocolType_name") != null ) this.setProtocolType_Name(tuple.getString("Workflow_ProtocolType_name"));		
			//set Features
			if( tuple.getObject("Features")!= null || tuple.getObject("Workflow_Features")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("Features");
				if(tuple.getObject("Workflow_Features")!= null) mrefs = tuple.getList("Workflow_Features");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setFeatures_Id( values );
			}
			//set labels name for mref field Features	
			if( tuple.getObject("Features_name")!= null || tuple.getObject("Workflow_Features_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("Features_name");
				if(tuple.getObject("Workflow_Features_name")!= null) mrefs = tuple.getList("Workflow_Features_name");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setFeatures_Name( values );			
			}	
			//set TargetFilter
			if( strict || tuple.getString("TargetFilter") != null) this.setTargetFilter(tuple.getString("TargetFilter"));
			if( tuple.getString("Workflow_TargetFilter") != null) this.setTargetFilter(tuple.getString("Workflow_TargetFilter"));
			//set Contact
			if( strict || tuple.getInt("Contact_id") != null) this.setContact(tuple.getInt("Contact_id"));
			if( tuple.getInt("Workflow_Contact_id") != null) this.setContact(tuple.getInt("Workflow_Contact_id"));
			//alias of xref
			if( tuple.getObject("Contact") != null) this.setContact(tuple.getInt("Contact"));
			if( tuple.getObject("Workflow_Contact") != null) this.setContact(tuple.getInt("Workflow_Contact"));
			//set label for field Contact
			if( strict || tuple.getObject("Contact_name") != null) this.setContact_Name(tuple.getString("Contact_name"));			
			if( tuple.getObject("Workflow_Contact_name") != null ) this.setContact_Name(tuple.getString("Workflow_Contact_name"));		
			//set Subprotocols
			if( tuple.getObject("subprotocols")!= null || tuple.getObject("Workflow_subprotocols")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("subprotocols");
				if(tuple.getObject("Workflow_subprotocols")!= null) mrefs = tuple.getList("Workflow_subprotocols");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setSubprotocols_Id( values );
			}
			//set labels name for mref field Subprotocols	
			if( tuple.getObject("subprotocols_name")!= null || tuple.getObject("Workflow_subprotocols_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("subprotocols_name");
				if(tuple.getObject("Workflow_subprotocols_name")!= null) mrefs = tuple.getList("Workflow_subprotocols_name");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setSubprotocols_Name( values );			
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
		String result = "Workflow(";
		result+= "id='" + getId()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "description='" + getDescription()+"' ";	
		result+= " investigation_id='" + getInvestigation_Id()+"' ";	
		result+= " investigation_name='" + getInvestigation_Name()+"' ";
		result+= " ontologyReference_id='" + getOntologyReference_Id()+"' ";	
		result+= " ontologyReference_name='" + getOntologyReference_Name()+"' ";
		result+= "__Type='" + get__Type()+"' ";	
		result+= " protocolType_id='" + getProtocolType_Id()+"' ";	
		result+= " protocolType_name='" + getProtocolType_Name()+"' ";
		result+= " features_id='" + getFeatures_Id()+"' ";	
		result+= " features_name='" + getFeatures_Name()+"' ";
		result+= "targetFilter='" + getTargetFilter()+"' ";	
		result+= " contact_id='" + getContact_Id()+"' ";	
		result+= " contact_name='" + getContact_Name()+"' ";
		result+= " subprotocols_id='" + getSubprotocols_Id()+"' ";	
		result+= " subprotocols_name='" + getSubprotocols_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of Workflow.
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
			fields.add("protocolType_id");
		}
		fields.add("protocolType_name");
		{
			fields.add("features_id");
		}
		fields.add("features_name");
		{
			fields.add("targetFilter");
		}
		{
			fields.add("contact_id");
		}
		fields.add("contact_name");
		{
			fields.add("subprotocols_id");
		}
		fields.add("subprotocols_name");
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
		+ "protocolType" +sep
		+ "features" +sep
		+ "targetFilter" +sep
		+ "contact" +sep
		+ "subprotocols" 
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
        if (fieldName.equalsIgnoreCase("protocolType")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("features")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("contact")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("subprotocols")) {
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
		Workflow rhs = (Workflow) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
             	.appendSuper(super.equals(obj))
		//name
				.append(name, rhs.getName())
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
				.append(name)
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
			Object valueO = getProtocolType();
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
			Object valueO = getFeatures();
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
			Object valueO = getTargetFilter();
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
			Object valueO = getContact();
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
			Object valueO = getSubprotocols();
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
	public Workflow create(org.molgenis.util.Tuple tuple) throws Exception
	{
		Workflow e = new Workflow();
		e.set(tuple);
		return e;
	}
	
//1
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="workflow"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.protocol.WorkflowElement> workflowWorkflowElementCollection = new java.util.ArrayList<org.molgenis.protocol.WorkflowElement>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.protocol.WorkflowElement> getWorkflowWorkflowElementCollection()
	{
            return workflowWorkflowElementCollection;
	}

    public void setWorkflowWorkflowElementCollection(java.util.Collection<org.molgenis.protocol.WorkflowElement> collection)
    {
        for (org.molgenis.protocol.WorkflowElement workflowElement : collection) {
            workflowElement.setWorkflow(this);
        }
        workflowWorkflowElementCollection = collection;
    }	

	
}

