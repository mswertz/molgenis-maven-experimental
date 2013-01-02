
/* File:        observ/model/ProtocolDocument.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.protocol;

/**
 * ProtocolDocument: .
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
@javax.persistence.Entity
//@org.hibernate.search.annotations.Indexed
@javax.persistence.Table(name = "ProtocolDocument"
)


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
//@EntityListeners({org.molgenis.protocol.db.ProtocolDocumentEntityListener.class})
public class ProtocolDocument extends org.molgenis.core.MolgenisFile 
{
	// fieldname constants
	public final static String PROTOCOL = "protocol";
	public final static String PROTOCOL_NAME = "protocol_name";
	public final static String DOCUMENT = "document";
	public final static String ID = "id";
	
	//static methods
	/**
	 * Shorthand for db.query(ProtocolDocument.class).
	 */
	public static org.molgenis.framework.db.Query<? extends ProtocolDocument> query(org.molgenis.framework.db.Database db)
	{
		return db.query(ProtocolDocument.class);
	}
	
	/**
	 * Shorthand for db.find(ProtocolDocument.class, org.molgenis.framework.db.QueryRule ... rules).
	 */
	public static java.util.List<? extends ProtocolDocument> find(org.molgenis.framework.db.Database db, org.molgenis.framework.db.QueryRule ... rules) throws org.molgenis.framework.db.DatabaseException
	{
		return db.find(ProtocolDocument.class, rules);
	}	
	
	/**
	 * 
	 */
	public static ProtocolDocument findById(org.molgenis.framework.db.Database db, Integer id) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ProtocolDocument> q = db.query(ProtocolDocument.class);
		q.eq(ProtocolDocument.ID, id);
		java.util.List<ProtocolDocument> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	/**
	 * 
	 */
	public static ProtocolDocument findByName(org.molgenis.framework.db.Database db, String name) throws org.molgenis.framework.db.DatabaseException
	{
		org.molgenis.framework.db.Query<ProtocolDocument> q = db.query(ProtocolDocument.class);
		q.eq(ProtocolDocument.NAME, name);
		java.util.List<ProtocolDocument> result = q.find();
		if(result.size()>0) return result.get(0);
		else return null;
	}

	
	// member variables (including setters.getters for interface)


	//protocol[type=xref]
    @javax.persistence.ManyToOne(fetch=javax.persistence.FetchType.LAZY /*cascade={javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.REFRESH}*/)
    @javax.persistence.JoinColumn(name="protocol", nullable=false)   	
	
				

	@javax.validation.constraints.NotNull
	private org.molgenis.protocol.Protocol protocol = null;
	@javax.persistence.Transient
	private Integer protocol_id = null;	
	@javax.persistence.Transient
	private String protocol_name = null;						


	//document[type=file]
	@javax.persistence.Column(name="document", nullable=false)
	@javax.xml.bind.annotation.XmlElement(name="document")
	
				

	@javax.validation.constraints.NotNull
	private String document =  null;
	@javax.persistence.Lob
	private java.io.File document_file = null;


	//automatically generated id[type=int]
	

	//constructors
	public ProtocolDocument()
	{
		//set the type for a new instance
		set__Type(this.getClass().getSimpleName());
	
	}
	
	//getters and setters
	/**
	 * Get the protocol.
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
	 * Set the protocol.
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
	 * Get the document.
	 * @return document.
	 */
	public String getDocument()
	{
		return this.document;
	}
	
	@Deprecated
	public String getDocument(org.molgenis.framework.db.Database db)
	{
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * Set the document.
	 * @param document
	 */
	public void setDocument( String document)
	{
		
		this.document = document;
	}

	
	/**
	 * getDocument() is a textual pointer to a file. getDocumentAttachedFile() can be used to retrieve the full paht to this file.
	 */
	public java.io.File getDocumentAttachedFile()
	{
		return document_file;
	}
	
	/**
	 * Document is a pointer to a file. Use setDocumentAttachedFile() to attach this file so it can be 
	 * retrieved using getDocumentAttachedFile().
	 */
	public void setDocumentAttachedFile(java.io.File file)
	{
		document_file = file;
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
		if (name.toLowerCase().equals("__type"))
			return get__Type();
		if(name.toLowerCase().equals("__type_label"))
			return get__TypeLabel();
		if (name.toLowerCase().equals("extension"))
			return getExtension();
		if (name.toLowerCase().equals("protocol"))
			return getProtocol();
		if(name.toLowerCase().equals("protocol_id"))
			return getProtocol_Id();
		if(name.toLowerCase().equals("protocol_name"))
			return getProtocol_Name();
		if (name.toLowerCase().equals("document"))
			return getDocument();
		return "";
	}	
	
	public void validate() throws org.molgenis.framework.db.DatabaseException
	{
		if(this.getId() == null) throw new org.molgenis.framework.db.DatabaseException("required field id is null");
		if(this.getName() == null) throw new org.molgenis.framework.db.DatabaseException("required field name is null");
		if(this.get__Type() == null) throw new org.molgenis.framework.db.DatabaseException("required field __Type is null");
		if(this.getExtension() == null) throw new org.molgenis.framework.db.DatabaseException("required field extension is null");
		if(this.getProtocol() == null) throw new org.molgenis.framework.db.DatabaseException("required field protocol is null");
		if(this.getDocument() == null) throw new org.molgenis.framework.db.DatabaseException("required field document is null");
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
			//set Extension
			this.setExtension(tuple.getString("Extension"));
			//set Protocol
			this.setProtocol(tuple.getInt("protocol"));
			//set label name for xref field Protocol
			this.setProtocol_Name(tuple.getString("protocol_name"));	
			//set Document
			this.setDocument(tuple.getString("document"));
		}
		else if(tuple != null)
		{
			//set Id
			if( strict || tuple.getInt("id") != null) this.setId(tuple.getInt("id"));
			if( tuple.getInt("ProtocolDocument_id") != null) this.setId(tuple.getInt("ProtocolDocument_id"));
			//set Name
			if( strict || tuple.getString("name") != null) this.setName(tuple.getString("name"));
			if( tuple.getString("ProtocolDocument_name") != null) this.setName(tuple.getString("ProtocolDocument_name"));
			//set __Type
			if( strict || tuple.getString("__Type") != null) this.set__Type(tuple.getString("__Type"));
			if( tuple.getString("ProtocolDocument___Type") != null) this.set__Type(tuple.getString("ProtocolDocument___Type"));
			//set Extension
			if( strict || tuple.getString("Extension") != null) this.setExtension(tuple.getString("Extension"));
			if( tuple.getString("ProtocolDocument_Extension") != null) this.setExtension(tuple.getString("ProtocolDocument_Extension"));
			//set Protocol
			if( strict || tuple.getInt("protocol_id") != null) this.setProtocol(tuple.getInt("protocol_id"));
			if( tuple.getInt("ProtocolDocument_protocol_id") != null) this.setProtocol(tuple.getInt("ProtocolDocument_protocol_id"));
			//alias of xref
			if( tuple.getObject("protocol") != null) this.setProtocol(tuple.getInt("protocol"));
			if( tuple.getObject("ProtocolDocument_protocol") != null) this.setProtocol(tuple.getInt("ProtocolDocument_protocol"));
			//set label for field Protocol
			if( strict || tuple.getObject("protocol_name") != null) this.setProtocol_Name(tuple.getString("protocol_name"));			
			if( tuple.getObject("ProtocolDocument_protocol_name") != null ) this.setProtocol_Name(tuple.getString("ProtocolDocument_protocol_name"));		
			//set Document
			if( strict || tuple.getString("document") != null) this.setDocument(tuple.getString("document"));
			if( tuple.getString("ProtocolDocument_document") != null) this.setDocument(tuple.getString("ProtocolDocument_document"));
			this.setDocumentAttachedFile(tuple.getFile("filefor_document"));
			if(tuple.getFile("filefor_ProtocolDocument_document") != null) this.setDocumentAttachedFile(tuple.getFile("filefor_ProtocolDocument_document"));
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
		String result = "ProtocolDocument(";
		result+= "id='" + getId()+"' ";	
		result+= "name='" + getName()+"' ";	
		result+= "__Type='" + get__Type()+"' ";	
		result+= "extension='" + getExtension()+"' ";	
		result+= " protocol_id='" + getProtocol_Id()+"' ";	
		result+= " protocol_name='" + getProtocol_Name()+"' ";
		result+= "document='" + getDocument()+"'";	
		result += ");";
		return result;

	}

	/**
	 * Get the names of all public properties of ProtocolDocument.
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
			fields.add("extension");
		}
		{
			fields.add("protocol_id");
		}
		fields.add("protocol_name");
		{
			fields.add("document");
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
		+ "extension" +sep
		+ "protocol" +sep
		+ "document" 
		);
	}

	@Override
	public Object getIdValue()
	{
		return get(getIdField());
	}		
	
	
    public String getXrefIdFieldName(String fieldName) {
        if (fieldName.equalsIgnoreCase("protocol")) {
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
		ProtocolDocument rhs = (ProtocolDocument) obj;
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
			Object valueO = getExtension();
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
			Object valueO = getDocument();
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
	public ProtocolDocument create(org.molgenis.util.Tuple tuple) throws Exception
	{
		ProtocolDocument e = new ProtocolDocument();
		e.set(tuple);
		return e;
	}
	

	
}

