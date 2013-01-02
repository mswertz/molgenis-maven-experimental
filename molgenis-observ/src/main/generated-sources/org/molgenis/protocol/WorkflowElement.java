
/* File:        observ/model/WorkflowElement.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.protocol;

/**
 * WorkflowElement: Elements of a workflow are references to protocols. The
				whole workflow is a directed graph with each element pointing to the
				previousSteps that the current workflow element depends on.
			
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "WorkflowElement", uniqueConstraints={ @javax.persistence.UniqueConstraint( columnNames={ "name" } ) }
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.protocol.db.WorkflowElementEntityListener.class})
public class WorkflowElement extends org.molgenis.util.AbstractEntity implements org.molgenis.core.Nameable
{
	// fieldname constants
	public final static String ID = "id";
	public final static String NAME = "name";
	public final static String WORKFLOW = "Workflow";
	public final static String WORKFLOW_NAME = "Workflow_name";
	public final static String PROTOCOL = "protocol";
	public final static String PROTOCOL_NAME = "protocol_name";
	public final static String PREVIOUSSTEPS = "PreviousSteps";
	public final static String PREVIOUSSTEPS_NAME = "PreviousSteps_name";
	
	//static methods
	/**
	 * Shorthand for db.query(WorkflowElement.class).
	 */
	public static org.molgenis.framework.db.Query<? extends WorkflowElement> query(org.molgenis.framework.db.Database db)
	{
		return db.query(WorkflowElement.class);
	}
	
	/**
	 * Shorthand for db.find(WorkflowElement.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends WorkflowElement> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(WorkflowElement.class, rules);
	}	
	
	/**
	 * 
	 */
	public static WorkflowElement findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<WorkflowElement> q = db.query(WorkflowElement.class);
		q.eq(WorkflowElement.ID, id);
		java.util.List<WorkflowElement> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static WorkflowElement findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<WorkflowElement> q = db.query(WorkflowElement.class);
		q.eq(WorkflowElement.NAME, name);
		java.util.List<WorkflowElement> result = q.find();
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


	//human-readable name.[type=string]
//	@org.hibernate.search.annotations.Field(index=org.hibernate.search.annotations.Index.TOKENIZED, store=org.hibernate.search.annotations.Store.NO)
	@javax.persistence.Column(name="name", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="name")
	
				

	@javax.validation.constraints.NotNull
	private String name =  null;


	//Workflow this element is part of[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="Workflow", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.protocol.Workflow workflow = null;
	@javax.persistence.Transient
	private Integer workflow_id = null;	
	@javax.persistence.Transient
	private String workflow_name = null;						


	//Protocol to be used at this workflow step[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="protocol", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.protocol.Protocol protocol = null;
	@javax.persistence.Transient
	private Integer protocol_id = null;	
	@javax.persistence.Transient
	private String protocol_name = null;						


	//Previous steps that need to be done before this protocol can be executed.[type=mref]
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="PreviousSteps", insertable=true, updatable=true, nullable=true)
	@javax.persistence.JoinTable(name="WorkflowElement_PreviousSteps", 
			joinColumns=@javax.persistence.JoinColumn(name="WorkflowElement"), inverseJoinColumns=@javax.persistence.JoinColumn(name="PreviousSteps"))
	
				

	private java.util.List<org.molgenis.protocol.WorkflowElement> previousSteps = new java.util.ArrayList<org.molgenis.protocol.WorkflowElement>();
	@javax.persistence.Transient
	private java.util.List<Integer> previousSteps_id = new java.util.ArrayList<Integer>();		
	@javax.persistence.Transient
	private java.util.List<String> previousSteps_name = new java.util.ArrayList<String>();

	//constructors
	public WorkflowElement()
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
		
		this.name = name;
	}

	

	/**
	 * Get the Workflow this element is part of.
	 * @return workflow.
	 */
	public org.molgenis.protocol.Workflow getWorkflow()
	{
		return this.workflow;
	}
	
	@Deprecated
	public org.molgenis.protocol.Workflow getWorkflow(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Workflow this element is part of.
	 * @param workflow
	 */
	public void setWorkflow( org.molgenis.protocol.Workflow workflow)
	{
		
		this.workflow = workflow;
	}

	
	
	/**
	 * Set foreign key for field workflow.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setWorkflow_Id(Integer workflow_id)
	{
		this.workflow_id = workflow_id;
	}	

	public void setWorkflow(Integer workflow_id)
	{
		this.workflow_id = workflow_id;
	}
	
	public Integer getWorkflow_Id()
	{
		
		if(workflow != null) 
		{
			return workflow.getId();
		}
		else
		{
			return workflow_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Workflow to Workflow.Id.
	 */
	public String getWorkflow_Name()
	{		
		//FIXME should we auto-load based on getWorkflow()?	
		if(workflow != null) {
			return workflow.getName();
		} else {
			return workflow_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Workflow to <a href="Workflow.html#Id">Workflow.Id</a>.
	 * Implies setWorkflow(null) until save
	 */
	public void setWorkflow_Name(String workflow_name)
	{
		this.workflow_name = workflow_name;
	}		
	 
	

	/**
	 * Get the Protocol to be used at this workflow step.
	 * @return protocol.
	 */
	public org.molgenis.protocol.Protocol getProtocol()
	{
		return this.protocol;
	}
	
	@Deprecated
	public org.molgenis.protocol.Protocol getProtocol(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Protocol to be used at this workflow step.
	 * @param protocol
	 */
	public void setProtocol( org.molgenis.protocol.Protocol protocol)
	{
		
		this.protocol = protocol;
	}

	
	
	/**
	 * Set foreign key for field protocol.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setProtocol_Id(Integer protocol_id)
	{
		this.protocol_id = protocol_id;
	}	

	public void setProtocol(Integer protocol_id)
	{
		this.protocol_id = protocol_id;
	}
	
	public Integer getProtocol_Id()
	{
		
		if(protocol != null) 
		{
			return protocol.getId();
		}
		else
		{
			return protocol_id;
		}
	}	
	 
	/**
	 * Get a pretty label name for cross reference Protocol to Protocol.Id.
	 */
	public String getProtocol_Name()
	{		
		//FIXME should we auto-load based on getProtocol()?	
		if(protocol != null) {
			return protocol.getName();
		} else {
			return protocol_name;
		}
	}		
	
	/**
	 * Set a pretty label for cross reference Protocol to <a href="Protocol.html#Id">Protocol.Id</a>.
	 * Implies setProtocol(null) until save
	 */
	public void setProtocol_Name(String protocol_name)
	{
		this.protocol_name = protocol_name;
	}		
	 
	

	/**
	 * Get the Previous steps that need to be done before this protocol can be executed..
	 * @return previousSteps.
	 */
	public java.util.List<org.molgenis.protocol.WorkflowElement> getPreviousSteps()
	{
		return this.previousSteps;
	}
	
	@Deprecated
	public java.util.List<org.molgenis.protocol.WorkflowElement> getPreviousSteps(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the Previous steps that need to be done before this protocol can be executed..
	 * @param previousSteps
	 */
	public void setPreviousSteps( java.util.List<org.molgenis.protocol.WorkflowElement> previousSteps)
	{
		
		this.previousSteps = previousSteps;
	}

	
	public void setPreviousSteps_Id(Integer ... previousSteps)
	{
		this.setPreviousSteps_Id(java.util.Arrays.asList(previousSteps));
	}	
	
	public void setPreviousSteps(org.molgenis.protocol.WorkflowElement ... previousSteps)
	{
		this.setPreviousSteps(java.util.Arrays.asList(previousSteps));
	}	
	
	/**
	 * Set foreign key for field previousSteps.
	 * This will erase any foreign key objects currently set.
	 * FIXME: can we autoload the new object?
	 */
	public void setPreviousSteps_Id(java.util.List<Integer> previousSteps_id)
	{
		this.previousSteps_id = previousSteps_id;
	}	
	
	public java.util.List<Integer> getPreviousSteps_Id()
	{
		return previousSteps_id;
	}	
	
	/**
	 * Get a pretty label for cross reference PreviousSteps to <a href="WorkflowElement.html#Id">WorkflowElement.Id</a>.
	 */
	public java.util.List<String> getPreviousSteps_Name()
	{
		return previousSteps_name;
	}
	
	/**
	 * Update the foreign key PreviousSteps
	 * This sets previousSteps to null until next database transaction.
	 */
	public void setPreviousSteps_Name(java.util.List<String> previousSteps_name)
	{
		this.previousSteps_name = previousSteps_name;
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
		if (name.toLowerCase().equals("workflow"))
			return getWorkflow();
		if(name.toLowerCase().equals("workflow_id"))
			return getWorkflow_Id();
		if(name.toLowerCase().equals("workflow_name"))
			return getWorkflow_Name();
		if (name.toLowerCase().equals("protocol"))
			return getProtocol();
		if(name.toLowerCase().equals("protocol_id"))
			return getProtocol_Id();
		if(name.toLowerCase().equals("protocol_name"))
			return getProtocol_Name();
		if (name.toLowerCase().equals("previoussteps"))
			return getPreviousSteps();
		if(name.toLowerCase().equals("previoussteps_id"))
			return getPreviousSteps_Id();
		if(name.toLowerCase().equals("previoussteps_name"))
			return getPreviousSteps_Name();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.getWorkflow() == null) throw new org.molgenis.framework.db.DatabaseException("required field workflow is null");
		if(this.getProtocol() == null) throw new org.molgenis.framework.db.DatabaseException("required field protocol is null");
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
			//set Workflow
			this.setWorkflow(tuple.getInt("Workflow"));
			//set label name for xref field Workflow
			this.setWorkflow_Name(tuple.getString("Workflow_name"));	
			//set Protocol
			this.setProtocol(tuple.getInt("protocol"));
			//set label name for xref field Protocol
			this.setProtocol_Name(tuple.getString("protocol_name"));	
			//mrefs can not be directly retrieved
			//set PreviousSteps			
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("WorkflowElement_id") != null) this.setId(tuple.getInt("WorkflowElement_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("WorkflowElement_name") != null) this.setName(tuple.getString("WorkflowElement_name"));
			//set Workflow
			if( strict || tuple.getInt("Workflow_id") != null) this.setWorkflow(tuple.getInt("Workflow_id"));
			if( tuple.getInt("WorkflowElement_Workflow_id") != null) this.setWorkflow(tuple.getInt("WorkflowElement_Workflow_id"));
			//alias of xref
			if( tuple.getObject("Workflow") != null) this.setWorkflow(tuple.getInt("Workflow"));
			if( tuple.getObject("WorkflowElement_Workflow") != null) this.setWorkflow(tuple.getInt("WorkflowElement_Workflow"));
			//set label for field Workflow
			if( strict || tuple.getObject("Workflow_name") != null) this.setWorkflow_Name(tuple.getString("Workflow_name"));			
			if( tuple.getObject("WorkflowElement_Workflow_name") != null ) this.setWorkflow_Name(tuple.getString("WorkflowElement_Workflow_name"));		
			//set Protocol
			if( strict || tuple.getInt("protocol_id") != null) this.setProtocol(tuple.getInt("protocol_id"));
			if( tuple.getInt("WorkflowElement_protocol_id") != null) this.setProtocol(tuple.getInt("WorkflowElement_protocol_id"));
			//alias of xref
			if( tuple.getObject("protocol") != null) this.setProtocol(tuple.getInt("protocol"));
			if( tuple.getObject("WorkflowElement_protocol") != null) this.setProtocol(tuple.getInt("WorkflowElement_protocol"));
			//set label for field Protocol
			if( strict || tuple.getObject("protocol_name") != null) this.setProtocol_Name(tuple.getString("protocol_name"));			
			if( tuple.getObject("WorkflowElement_protocol_name") != null ) this.setProtocol_Name(tuple.getString("WorkflowElement_protocol_name"));		
			//set PreviousSteps
			if( tuple.getObject("PreviousSteps")!= null || tuple.getObject("WorkflowElement_PreviousSteps")!= null) 
			{
				java.util.List<Integer> values = new java.util.ArrayList<Integer>();
				java.util.List<?> mrefs = tuple.getList("PreviousSteps");
				if(tuple.getObject("WorkflowElement_PreviousSteps")!= null) mrefs = tuple.getList("WorkflowElement_PreviousSteps");
				if(mrefs != null) for(Object ref: mrefs)
				{
				  		values.add(Integer.parseInt((ref.toString())));
				}											
				this.setPreviousSteps_Id( values );
			}
			//set labels name for mref field PreviousSteps	
			if( tuple.getObject("PreviousSteps_name")!= null || tuple.getObject("WorkflowElement_PreviousSteps_name")!= null) 
			{
				java.util.List<String> values = new java.util.ArrayList<String>();
				java.util.List<?> mrefs = tuple.getList("PreviousSteps_name");
				if(tuple.getObject("WorkflowElement_PreviousSteps_name")!= null) mrefs = tuple.getList("WorkflowElement_PreviousSteps_name");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					}							
				this.setPreviousSteps_Name( values );			
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
		String result = "WorkflowElement(";
		result+= "id='" + getId()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= " workflow_id='" + getWorkflow_Id()+"' ";	
		result+= " workflow_name='" + getWorkflow_Name()+"' ";
		result+= " protocol_id='" + getProtocol_Id()+"' ";	
		result+= " protocol_name='" + getProtocol_Name()+"' ";
		result+= " previousSteps_id='" + getPreviousSteps_Id()+"' ";	
		result+= " previousSteps_name='" + getPreviousSteps_Name()+"' ";
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of WorkflowElement.
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
			fields.add("workflow_id");
		}
		fields.add("workflow_name");
		{
			fields.add("protocol_id");
		}
		fields.add("protocol_name");
		{
			fields.add("previousSteps_id");
		}
		fields.add("previousSteps_name");
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
		+ "workflow" +sep
		+ "protocol" +sep
		+ "previousSteps" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("workflow")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("protocol")) {
            return "id";
        }
        if (fieldName.equalsIgnoreCase("previousSteps")) {
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
		WorkflowElement rhs = (WorkflowElement) obj;
   		return new org.apache.commons.lang.builder.EqualsBuilder()
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
			Object valueO = getWorkflow();
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
			Object valueO = getProtocol();
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
			out.write(valueS);
		}
		return out.toString();
	}
	
	@Override
	public WorkflowElement create(org.molgenis.util.Tuple tuple) throws Exception
	{
		WorkflowElement e = new WorkflowElement();
		e.set(tuple);
		return e;
	}
	
//4
	@javax.persistence.OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="workflowElement"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.protocol.WorkflowElementParameter> workflowElementWorkflowElementParameterCollection = new java.util.ArrayList<org.molgenis.protocol.WorkflowElementParameter>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.protocol.WorkflowElementParameter> getWorkflowElementWorkflowElementParameterCollection()
	{
            return workflowElementWorkflowElementParameterCollection;
	}

    public void setWorkflowElementWorkflowElementParameterCollection(java.util.Collection<org.molgenis.protocol.WorkflowElementParameter> collection)
    {
        for (org.molgenis.protocol.WorkflowElementParameter workflowElementParameter : collection) {
            workflowElementParameter.setWorkflowElement(this);
        }
        workflowElementWorkflowElementParameterCollection = collection;
    }	
	//4
    @javax.persistence.ManyToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="previousSteps"/*, cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    private java.util.Collection<org.molgenis.protocol.WorkflowElement> previousStepsWorkflowElementCollection = new java.util.ArrayList<org.molgenis.protocol.WorkflowElement>();

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.protocol.WorkflowElement> getPreviousStepsWorkflowElementCollection()
	{
        return previousStepsWorkflowElementCollection;
	}

	@javax.xml.bind.annotation.XmlTransient
	public java.util.Collection<org.molgenis.protocol.WorkflowElement> getPreviousStepsWorkflowElementCollection(org.molgenis.framework.db.Database db)
	{
        return getPreviousStepsWorkflowElementCollection();
	}

    public void setPreviousStepsWorkflowElementCollection(java.util.Collection<org.molgenis.protocol.WorkflowElement> collection)
    {
    	previousStepsWorkflowElementCollection.addAll(collection);
    }	

	
}

