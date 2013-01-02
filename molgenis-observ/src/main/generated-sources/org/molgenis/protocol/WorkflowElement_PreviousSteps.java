
/* File:        observ/model/WorkflowElement_PreviousSteps.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.protocol;

/**
 * WorkflowElement_PreviousSteps: Link table for many-to-many relationship 'WorkflowElement.PreviousSteps'..
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.protocol.db.WorkflowElement_PreviousStepsEntityListener.class})
public class WorkflowElement_PreviousSteps extends org.molgenis.util.AbstractEntity 
{
	// fieldname constants
	public final static String AUTOID = "autoid";
	public final static String PREVIOUSSTEPS = "PreviousSteps";
	public final static String PREVIOUSSTEPS_NAME = "PreviousSteps_name";
	public final static String WORKFLOWELEMENT = "WorkflowElement";
	public final static String WORKFLOWELEMENT_NAME = "WorkflowElement_name";
	
	//static methods
	/**
	 * Shorthand for db.query(WorkflowElement_PreviousSteps.class).
	 */
	public static org.molgenis.framework.db.Query<? extends WorkflowElement_PreviousSteps> query(org.molgenis.framework.db.Database db)
	{
		return db.query(WorkflowElement_PreviousSteps.class);
	}
	
	/**
	 * Shorthand for db.find(WorkflowElement_PreviousSteps.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends WorkflowElement_PreviousSteps> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(WorkflowElement_PreviousSteps.class, rules);
	}	
	
	/**
	 * 
	 */
	public static WorkflowElement_PreviousSteps findByAutoid(org.molgenis.framework.db.Database db, Integer autoid) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<WorkflowElement_PreviousSteps> q = db.query(WorkflowElement_PreviousSteps.class);
		q.eq(WorkflowElement_PreviousSteps.AUTOID, autoid);
		java.util.List<WorkflowElement_PreviousSteps> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static WorkflowElement_PreviousSteps findByPreviousStepsWorkflowElement(org.molgenis.framework.db.Database db, Integer previousSteps, Integer workflowElement) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<WorkflowElement_PreviousSteps> q = db.query(WorkflowElement_PreviousSteps.class);
		q.eq(WorkflowElement_PreviousSteps.PREVIOUSSTEPS, previousSteps);q.eq(WorkflowElement_PreviousSteps.WORKFLOWELEMENT, workflowElement);
		java.util.List<WorkflowElement_PreviousSteps> result = q.find();
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
    @javax.persistence.JoinColumn(name="PreviousSteps", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.protocol.WorkflowElement previousSteps = null;
	@javax.persistence.Transient
	private Integer previousSteps_id = null;	
	@javax.persistence.Transient
	private String previousSteps_name = null;						


	//[type=xref]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="WorkflowElement", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.protocol.WorkflowElement workflowElement = null;
	@javax.persistence.Transient
	private Integer workflowElement_id = null;	
	@javax.persistence.Transient
	private String workflowElement_name = null;						

	//constructors
	public WorkflowElement_PreviousSteps()
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
	 * @return previousSteps.
	 */
	public org.molgenis.protocol.WorkflowElement getPreviousSteps()
	{
		return this.previousSteps;
	}
	
	@Deprecated
	public org.molgenis.protocol.WorkflowElement getPreviousSteps(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the .
	 * @param previousSteps
	 */
	public void setPreviousSteps( org.molgenis.protocol.WorkflowElement previousSteps)
	{
		
		this.previousSteps = previousSteps;
	}

	
	
	/**
	 * Set foreign key for field previousSteps.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setPreviousSteps_Id(Integer previousSteps_id)
	{
		this.previousSteps_id = previousSteps_id;
	}	

	public void setPreviousSteps(Integer previousSteps_id)
	{
		this.previousSteps_id = previousSteps_id;
	}
	
	public Integer getPreviousSteps_Id()
	{
		
		if(previousSteps != null) 
		{
			return previousSteps.getId();
		}
		else
		{
			return previousSteps_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference PreviousSteps to WorkflowElement.Id.
	 */
	public String getPreviousSteps_Name()
	{		
		//FIXME should we auto-load based on getPreviousSteps()?	
		if(previousSteps != null) {
			return previousSteps.getName();
		} else {
			return previousSteps_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference PreviousSteps to <a href="WorkflowElement.html#Id">WorkflowElement.Id</a>.
	 * Implies setPreviousSteps(null) until save
	 */
	public void setPreviousSteps_Name(String previousSteps_name)
	{
		this.previousSteps_name = previousSteps_name;
	}		
	 
	

	/**
	 * Get the .
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
	 * Set the .
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
	 * Generic getter. Get the property by using the name.
	 */
	public Object get(String name)
	{
		name = name.toLowerCase();
		if (name.toLowerCase().equals("autoid"))
			return getAutoid();
		if (name.toLowerCase().equals("previoussteps"))
			return getPreviousSteps();
		if(name.toLowerCase().equals("previoussteps_id"))
			return getPreviousSteps_Id();
		if(name.toLowerCase().equals("previoussteps_name"))
			return getPreviousSteps_Name();
		if (name.toLowerCase().equals("workflowelement"))
			return getWorkflowElement();
		if(name.toLowerCase().equals("workflowelement_id"))
			return getWorkflowElement_Id();
		if(name.toLowerCase().equals("workflowelement_name"))
			return getWorkflowElement_Name();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getAutoid() == null) throw new org.molgenis.framework.db.DatabaseException("required field autoid is null");
		if(this.getPreviousSteps() == null) throw new org.molgenis.framework.db.DatabaseException("required field previousSteps is null");
		if(this.getWorkflowElement() == null) throw new org.molgenis.framework.db.DatabaseException("required field workflowElement is null");
	}
	
	
	
	//@Implements
	public void set( org.molgenis.util.Tuple tuple, boolean strict )  throws Exception
	{
		//optimization :-(
		if(tuple instanceof org.molgenis.util.ResultSetTuple)
		{
				//set Autoid
			this.setAutoid(tuple.getInt("autoid"));
			//set PreviousSteps
			this.setPreviousSteps(tuple.getInt("PreviousSteps"));
			//set label name for xref field PreviousSteps
			this.setPreviousSteps_Name(tuple.getString("PreviousSteps_name"));	
			//set WorkflowElement
			this.setWorkflowElement(tuple.getInt("WorkflowElement"));
			//set label name for xref field WorkflowElement
			this.setWorkflowElement_Name(tuple.getString("WorkflowElement_name"));	
		}
		else if(tuple != null)
		{
			//set Autoid
			if( strict || tuple.getInt("autoid") != null) this.setAutoid(tuple.getInt("autoid"));
			if( tuple.getInt("WorkflowElement_PreviousSteps_autoid") != null) this.setAutoid(tuple.getInt("WorkflowElement_PreviousSteps_autoid"));
			//set PreviousSteps
			if( strict || tuple.getInt("PreviousSteps_id") != null) this.setPreviousSteps(tuple.getInt("PreviousSteps_id"));
			if( tuple.getInt("WorkflowElement_PreviousSteps_PreviousSteps_id") != null) this.setPreviousSteps(tuple.getInt("WorkflowElement_PreviousSteps_PreviousSteps_id"));
			//alias of xref
			if( tuple.getObject("PreviousSteps") != null) this.setPreviousSteps(tuple.getInt("PreviousSteps"));
			if( tuple.getObject("WorkflowElement_PreviousSteps_PreviousSteps") != null) this.setPreviousSteps(tuple.getInt("WorkflowElement_PreviousSteps_PreviousSteps"));
			//set label for field PreviousSteps
			if( strict || tuple.getObject("PreviousSteps_name") != null) this.setPreviousSteps_Name(tuple.getString("PreviousSteps_name"));			
			if( tuple.getObject("WorkflowElement_PreviousSteps_PreviousSteps_name") != null ) this.setPreviousSteps_Name(tuple.getString("WorkflowElement_PreviousSteps_PreviousSteps_name"));		
			//set WorkflowElement
			if( strict || tuple.getInt("WorkflowElement_id") != null) this.setWorkflowElement(tuple.getInt("WorkflowElement_id"));
			if( tuple.getInt("WorkflowElement_PreviousSteps_WorkflowElement_id") != null) this.setWorkflowElement(tuple.getInt("WorkflowElement_PreviousSteps_WorkflowElement_id"));
			//alias of xref
			if( tuple.getObject("WorkflowElement") != null) this.setWorkflowElement(tuple.getInt("WorkflowElement"));
			if( tuple.getObject("WorkflowElement_PreviousSteps_WorkflowElement") != null) this.setWorkflowElement(tuple.getInt("WorkflowElement_PreviousSteps_WorkflowElement"));
			//set label for field WorkflowElement
			if( strict || tuple.getObject("WorkflowElement_name") != null) this.setWorkflowElement_Name(tuple.getString("WorkflowElement_name"));			
			if( tuple.getObject("WorkflowElement_PreviousSteps_WorkflowElement_name") != null ) this.setWorkflowElement_Name(tuple.getString("WorkflowElement_PreviousSteps_WorkflowElement_name"));		
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
		String result = "WorkflowElement_PreviousSteps(";
		result+= "autoid='" + getAutoid()+"' ";	
		result+= " previousSteps_id='" + getPreviousSteps_Id()+"' ";	
		result+= " previousSteps_name='" + getPreviousSteps_Name()+"' ";
		result+= " workflowElement_id='" + getWorkflowElement_Id()+"' ";	
		result+= " workflowElement_name='" + getWorkflowElement_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of WorkflowElement_PreviousSteps.
	 */
	public java.util.Vector<String> getFields(boolean skipAutoIds)
	{
		java.util.Vector<String> fields = new java.util.Vector<String>();
		if(!skipAutoIds)
		{
			fields.add("autoid");
		}
		{
			fields.add("previousSteps_id");
		}
		fields.add("previousSteps_name");
		{
			fields.add("workflowElement_id");
		}
		fields.add("workflowElement_name");
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
		result.add("PreviousSteps");
		result.add("WorkflowElement");
		return result;
	}

	@Deprecated
	public String getFields(String sep)
	{
		return (""
		+ "autoid" +sep
		+ "previousSteps" +sep
		+ "workflowElement" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("previousSteps")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("workflowElement")) {
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
		WorkflowElement_PreviousSteps rhs = (WorkflowElement_PreviousSteps) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
		//previousSteps
		//workflowElement
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
			Object valueO = getPreviousSteps();
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
			out.write(valueS);
		}
		return out.toString();
	}
	
	@Override
	public WorkflowElement_PreviousSteps create(org.molgenis.util.Tuple tuple) throws Exception
	{
		WorkflowElement_PreviousSteps e = new WorkflowElement_PreviousSteps();
		e.set(tuple);
		return e;
	}
	

	
}

