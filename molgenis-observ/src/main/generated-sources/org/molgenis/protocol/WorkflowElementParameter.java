
/* File:        observ/model/WorkflowElementParameter.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.protocol;

/**
 * WorkflowElementParameter: Element parameters are the way to link workflow elements
				together. It allows override of the parameters from the previous
				step.
			
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "WorkflowElementParameter", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "WorkflowElement", "Parameter" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.protocol.db.WorkflowElementParameterEntityListener.class})
public class WorkflowElementParameter extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Identifiable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String WORKFLOWELEMENT = "WorkflowElement";
	public final static String WORKFLOWELEMENT_NAME = "WorkflowElement_name";
	public final static String PARAMETER = "Parameter";
	public final static String PARAMETER_NAME = "Parameter_name";
	public final static String VALUE = "Value";
	
	//static methods
	/**
	 * Shorthand for db.query(WorkflowElementParameter.class).
	 */
	public static org.molgenis.framework.db.Query<? extends WorkflowElementParameter> query(org.molgenis.framework.db.Database db)
	{
		return db.query(WorkflowElementParameter.class);
	}
	
	/**
	 * Shorthand for db.find(WorkflowElementParameter.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends WorkflowElementParameter> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(WorkflowElementParameter.class, rules);
	}	
	
	/**
	 * 
	 */
	public static WorkflowElementParameter findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<WorkflowElementParameter> q = db.query(WorkflowElementParameter.class);
		q.eq(WorkflowElementParameter.ID, id);
		java.util.List<WorkflowElementParameter> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static WorkflowElementParameter findByWorkflowElementParameter(org.molgenis.framework.db.Database db, Integer workflowElement, Integer parameter) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<WorkflowElementParameter> q = db.query(WorkflowElementParameter.class);
		q.eq(WorkflowElementParameter.WORKFLOWELEMENT, workflowElement);q.eq(WorkflowElementParameter.PARAMETER, parameter);
		java.util.List<WorkflowElementParameter> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//automatically generated id[type=int]
    @javax.persistence.Id @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Column(name="id", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="id")
	
	//@javax.validation.constraints.NotNull
	private Integer id =  null;


	//To attach a parameter to a WorkflowElement[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="WorkflowElement", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.protocol.WorkflowElement workflowElement = null;
	@javax.persistence.Transient
	private Integer workflowElement_id = null;	
	@javax.persistence.Transient
	private String workflowElement_name = null;						


	//Parameter definition.[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Parameter", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.pheno.ObservableFeature parameter = null;
	@javax.persistence.Transient
	private Integer parameter_id = null;	
	@javax.persistence.Transient
	private String parameter_name = null;						


	//Value of this parameter. Can be a template of form ${other} refering to previous values in context.[type=string]
	@javax.persistence.Column(name="Value", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="value")
	
				

	@javax.validation.constraints.NotNull
	private String value =  null;

	//constructors
	public WorkflowElementParameter()
	{
	
	}
	
	//getters and setters
	/**
	 * Get the automatically generated id.
	 * @return id.
	 */
	public Integer getId()
	{
		return this.id;
	}
	
	
	/**
	 * Set the automatically generated id.
	 * @param id
	 */
	public void setId( Integer id)
	{
		this.id = id;
	}

	

	/**
	 * Get the To attach a parameter to a WorkflowElement.
	 * @return workflowElement.
	 */
	public org.molgenis.protocol.WorkflowElement getWorkflowElement()
	{
		return this.workflowElement;
	}
	
	@Deprecated
	public org.molgenis.protocol.WorkflowElement getWorkflowElement(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the To attach a parameter to a WorkflowElement.
	 * @param workflowElement
	 */
	public void setWorkflowElement( org.molgenis.protocol.WorkflowElement workflowElement)
	{
		
		this.workflowElement = workflowElement;
	}

	
	
	/**
	 * Set foreign key for field workflowElement.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setWorkflowElement_Id(Integer workflowElement_id)
	{
		this.workflowElement_id = workflowElement_id;
	}	

	public void setWorkflowElement(Integer workflowElement_id)
	{
		this.workflowElement_id = workflowElement_id;
	}
	
	public Integer getWorkflowElement_Id()
	{
		
		if(workflowElement != null) 
		{
			return workflowElement.getId();
		}
		else
		{
			return workflowElement_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference WorkflowElement to WorkflowElement.Id.
	 */
	public String getWorkflowElement_Name()
	{		
		//FIXME should we auto-load based on getWorkflowElement()?	
		if(workflowElement != null) {
			return workflowElement.getName();
		} else {
			return workflowElement_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference WorkflowElement to <a href="WorkflowElement.html#Id">WorkflowElement.Id</a>.
	 * Implies setWorkflowElement(null) until save
	 */
	public void setWorkflowElement_Name(String workflowElement_name)
	{
		this.workflowElement_name = workflowElement_name;
	}		
	 
	

	/**
	 * Get the Parameter definition..
	 * @return parameter.
	 */
	public org.molgenis.pheno.ObservableFeature getParameter()
	{
		return this.parameter;
	}
	
	@Deprecated
	public org.molgenis.pheno.ObservableFeature getParameter(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Parameter definition..
	 * @param parameter
	 */
	public void setParameter( org.molgenis.pheno.ObservableFeature parameter)
	{
		
		this.parameter = parameter;
	}

	
	
	/**
	 * Set foreign key for field parameter.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setParameter_Id(Integer parameter_id)
	{
		this.parameter_id = parameter_id;
	}	

	public void setParameter(Integer parameter_id)
	{
		this.parameter_id = parameter_id;
	}
	
	public Integer getParameter_Id()
	{
		
		if(parameter != null) 
		{
			return parameter.getId();
		}
		else
		{
			return parameter_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Parameter to ObservableFeature.Id.
	 */
	public String getParameter_Name()
	{		
		//FIXME should we auto-load based on getParameter()?	
		if(parameter != null) {
			return parameter.getName();
		} else {
			return parameter_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Parameter to <a href="ObservableFeature.html#Id">ObservableFeature.Id</a>.
	 * Implies setParameter(null) until save
	 */
	public void setParameter_Name(String parameter_name)
	{
		this.parameter_name = parameter_name;
	}		
	 
	

	/**
	 * Get the Value of this parameter. Can be a template of form ${other} refering to previous values in context..
	 * @return value.
	 */
	public String getValue()
	{
		return this.value;
	}
	
	@Deprecated
	public String getValue(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Value of this parameter. Can be a template of form ${other} refering to previous values in context..
	 * @param value
	 */
	public void setValue( String value)
	{
		
		this.value = value;
	}

	


	/**
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("id"))
			return getId();
		if (name.toLowerCase().equals("workflowelement"))
			return getWorkflowElement();
		if(name.toLowerCase().equals("workflowelement_id"))
			return getWorkflowElement_Id();
		if(name.toLowerCase().equals("workflowelement_name"))
			return getWorkflowElement_Name();
		if (name.toLowerCase().equals("parameter"))
			return getParameter();
		if(name.toLowerCase().equals("parameter_id"))
			return getParameter_Id();
		if(name.toLowerCase().equals("parameter_name"))
			return getParameter_Name();
		if (name.toLowerCase().equals("value"))
			return getValue();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getWorkflowElement() == null) throw new org.molgenis.framework.db.DatabaseException("required field workflowElement is null");
		if(this.getParameter() == null) throw new org.molgenis.framework.db.DatabaseException("required field parameter is null");
		if(this.getValue() == null) throw new org.molgenis.framework.db.DatabaseException("required field value is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Id
			this.setId(tuple.getInt("id"));
			//set WorkflowElement
			this.setWorkflowElement(tuple.getInt("WorkflowElement"));
			//set label name for xref field WorkflowElement
			this.setWorkflowElement_Name(tuple.getString("WorkflowElement_name"));	
			//set Parameter
			this.setParameter(tuple.getInt("Parameter"));
			//set label name for xref field Parameter
			this.setParameter_Name(tuple.getString("Parameter_name"));	
			//set Value
			this.setValue(tuple.getString("Value"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("WorkflowElementParameter_id") != null) this.setId(tuple.getInt("WorkflowElementParameter_id"));
			//set WorkflowElement
			if( strict || tuple.getInt("WorkflowElement_id") != null) this.setWorkflowElement(tuple.getInt("WorkflowElement_id"));
			if( tuple.getInt("WorkflowElementParameter_WorkflowElement_id") != null) this.setWorkflowElement(tuple.getInt("WorkflowElementParameter_WorkflowElement_id"));
			//alias of xref
			if( tuple.getObject("WorkflowElement") != null) this.setWorkflowElement(tuple.getInt("WorkflowElement"));
			if( tuple.getObject("WorkflowElementParameter_WorkflowElement") != null) this.setWorkflowElement(tuple.getInt("WorkflowElementParameter_WorkflowElement"));
			//set label for field WorkflowElement
			if( strict || tuple.getObject("WorkflowElement_name") != null) this.setWorkflowElement_Name(tuple.getString("WorkflowElement_name"));			
			if( tuple.getObject("WorkflowElementParameter_WorkflowElement_name") != null ) this.setWorkflowElement_Name(tuple.getString("WorkflowElementParameter_WorkflowElement_name"));		
			//set Parameter
			if( strict || tuple.getInt("Parameter_id") != null) this.setParameter(tuple.getInt("Parameter_id"));
			if( tuple.getInt("WorkflowElementParameter_Parameter_id") != null) this.setParameter(tuple.getInt("WorkflowElementParameter_Parameter_id"));
			//alias of xref
			if( tuple.getObject("Parameter") != null) this.setParameter(tuple.getInt("Parameter"));
			if( tuple.getObject("WorkflowElementParameter_Parameter") != null) this.setParameter(tuple.getInt("WorkflowElementParameter_Parameter"));
			//set label for field Parameter
			if( strict || tuple.getObject("Parameter_name") != null) this.setParameter_Name(tuple.getString("Parameter_name"));			
			if( tuple.getObject("WorkflowElementParameter_Parameter_name") != null ) this.setParameter_Name(tuple.getString("WorkflowElementParameter_Parameter_name"));		
			//set Value
			if( strict || tuple.getString("Value") != null) this.setValue(tuple.getString("Value"));
			if( tuple.getString("WorkflowElementParameter_Value") != null) this.setValue(tuple.getString("WorkflowElementParameter_Value"));
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
		String result = "WorkflowElementParameter(";
		result+= "id='" + getId()+"' ";	
		result+= " workflowElement_id='" + getWorkflowElement_Id()+"' ";	
		result+= " workflowElement_name='" + getWorkflowElement_Name()+"' ";
		result+= " parameter_id='" + getParameter_Id()+"' ";	
		result+= " parameter_name='" + getParameter_Name()+"' ";
		result+= "value='" + getValue()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of WorkflowElementParameter.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("id");
		}
		{
			fields.add("workflowElement_id");
		}
		fields.add("workflowElement_name");
		{
			fields.add("parameter_id");
		}
		fields.add("parameter_name");
		{
			fields.add("value");
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
		result.add("id");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "id" +sep
		+ "workflowElement" +sep
		+ "parameter" +sep
		+ "value" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("workflowElement")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("parameter")) {
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
		WorkflowElementParameter rhs = (WorkflowElementParameter) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//workflowElement
		//parameter
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
			Object valueO = getWorkflowElement();
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
			Object valueO = getParameter();
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
			Object valueO = getValue();
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
	public WorkflowElementParameter create(org.molgenis.util.Tuple tuple) throws Exception
	{
		WorkflowElementParameter e = new WorkflowElementParameter();
		e.set(tuple);
		return e;
	}
	

	
}

