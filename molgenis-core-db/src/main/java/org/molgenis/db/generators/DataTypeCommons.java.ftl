	
	
	//@Implements
	public void set( org.molgenis.db.Tuple tuple, boolean strict )  throws Exception
	{
		if(tuple != null)
		{
	<#list allFields(entity) as f>
		<#assign type_label = f.getType().toString()>
		<#if f.type == "mref">
			//set ${JavaName(f)}
			if( tuple.getObject("${f.name}")!= null || tuple.getObject("${entity.name}_${f.name}")!= null) 
			{
				java.util.List<${type(f.xrefField)}> values = new java.util.ArrayList<${type(f.xrefField)}>();
				java.util.List<?> mrefs = tuple.getList("${f.name}");
				if(tuple.getObject("${entity.name}_${f.name}")!= null) mrefs = tuple.getList("${entity.name}_${f.name}");
				if(mrefs != null) for(Object ref: mrefs)
				{
				<#if databaseImp == "JPA">
					if(ref instanceof String)
						values.add(${type(xrefField(model,f))}.parse${settertype(xrefField(model,f))}((String)ref));
					else if(ref instanceof org.molgenis.util.AbstractEntity) 	
						values.add((${type(xrefField(model,f))})((org.molgenis.util.AbstractEntity)ref).getIdValue() );
					else
						values.add((${type(xrefField(model,f))})ref);		
				<#else>
				  	<#if JavaType(f.xrefField) == "String" >
				  		values.add((${JavaType(f.xrefField)})ref);
				  	<#else>
				  		values.add(${type(f.xrefField)}.parse${settertype(f.xrefField)}((ref.toString())));
				  	</#if>
			  	</#if>
				}											
				this.set${JavaName(f)}_${JavaName(f.xrefField)}( values );
			}
			<#if f.xrefLabel.name != f.xrefFieldName>
			//set label ${f.xrefLabel.name} for mref field ${JavaName(f)}	
			if( tuple.getObject("${f.name}_${f.xrefLabel.name}")!= null || tuple.getObject("${entity.name}_${f.name}_${f.xrefLabel.name}")!= null) 
			{
				java.util.List<${type(f.xrefLabel)}> values = new java.util.ArrayList<${type(f.xrefLabel)}>();
				java.util.List<?> mrefs = tuple.getList("${f.name}_${f.xrefLabel.name}");
				if(tuple.getObject("${entity.name}_${f.name}_${f.xrefLabel.name}")!= null) mrefs = tuple.getList("${entity.name}_${f.name}_${f.xrefLabel.name}");
				
				if(mrefs != null) 
					for(Object ref: mrefs)
					{
					<#if type(f.xrefLabel) == "String">
						String[] refs = ref.toString().split("\\|");
						for(String r : refs) {
							values.add(r);	
						}						
					<#else>
				  		<#if JavaType(f.xrefField) =="String" >
				  		values.add((${JavaType(f.xrefField)})ref);
				  		<#else>
				  		values.add(${type(f.xrefField)}.parse${settertype(f.xrefField)}((ref.toString())));
				  		</#if>						
					</#if>
					}							
				this.set${JavaName(f)}_${JavaName(f.xrefLabel)}( values );			
			}	
			</#if>					
		<#else>
			//set ${JavaName(f)}
			<#if f.type == "xref">	
			if( strict || tuple.get${settertype(f)}("${f.name}_${f.xrefField.name}") != null) this.set${JavaName(f)}(tuple.get${settertype(f)}("${f.name}_${f.xrefField.name}"));
			if( tuple.get${settertype(f)}("${entity.name}_${f.name}_${f.xrefField.name}") != null) this.set${JavaName(f)}(tuple.get${settertype(f)}("${entity.name}_${f.name}_${f.xrefField.name}"));
			//alias of xref
			<#if databaseImp == "JPA">
			if( tuple.getObject("${f.name}") != null) { 
				if(org.molgenis.util.AbstractEntity.isObjectRepresentation(tuple.getObject("${f.name}").toString())) {
					${f.xrefEntity.namespace}.${JavaName(f.xrefEntity)} instance = org.molgenis.util.AbstractEntity.setValuesFromString((String)tuple.getObject("${f.name}"), ${f.xrefEntity.namespace}.${JavaName(f.xrefEntity)}.class);
					this.set${JavaName(f)}(instance);				
				} else {
					this.set${JavaName(f)}_${JavaName(f.xrefField)}(tuple.get${settertype(f.xrefField)}("investigation"));
				}
			}
			if( tuple.getObject("${entity.name}_${f.name}") != null)
				this.set${JavaName(f)}_${JavaName(f.xrefField)}(tuple.get${settertype(f.xrefField)}("${entity.name}_${f.name}"));			
			
			if( tuple.getObject("${entity.name}.${f.name}") != null) 
				this.set${JavaName(f)}((${f.xrefEntity.namespace}.${JavaName(f.xrefEntity)})tuple.getObject("${entity.name}.${f.name}_${f.xrefField.name}"));
			<#else>			
			if( tuple.getObject("${f.name}") != null) this.set${JavaName(f)}(tuple.get${settertype(f)}("${f.name}"));
			if( tuple.getObject("${entity.name}_${f.name}") != null) this.set${JavaName(f)}(tuple.get${settertype(f)}("${entity.name}_${f.name}"));
			</#if>
			//set label for field ${JavaName(f)}
			<#if f.xrefLabel.name != f.xrefFieldName>
			if( strict || tuple.getObject("${f.name}_${f.xrefLabel.name}") != null) this.set${JavaName(f)}_${JavaName(f.xrefLabel)}(tuple.get${settertype(f.xrefLabel)}("${f.name}_${f.xrefLabel.name}"));			
			if( tuple.getObject("${entity.name}_${f.name}_${f.xrefLabel}") != null ) this.set${JavaName(f)}_${JavaName(f.xrefLabel)}(tuple.get${settertype(f.xrefLabel)}("${entity.name}_${f.name}_${f.xrefLabel.name}"));		
			</#if>
			<#elseif f.type == "nsequence">
			if( strict || tuple.getNSequence("${f.name}") != null)this.set${JavaName(f)}(tuple.getNSequence("${f.name}"));
			if(tuple.getNSequence("${entity.name}_${f.name}") != null) this.set${JavaName(f)}(tuple.getNSequence("${entity.name}_${f.name}"));
			<#elseif f.type == "onoff">
			if( strict || tuple.getOnoff("${f.name}") != null) this.set${JavaName(f)}(tuple.getOnoff("${f.name}"));
			if( tuple.getOnoff("${entity.name}_${f.name}") != null) this.set${JavaName(f)}(tuple.getOnoff("${entity.name}_${f.name}"));
			<#else>
			if( strict || tuple.get${settertype(f)}("${f.name}") != null) this.set${JavaName(f)}(tuple.get${settertype(f)}("${f.name}"));
			if( tuple.get${settertype(f)}("${entity.name}_${f.name}") != null) this.set${JavaName(f)}(tuple.get${settertype(f)}("${entity.name}_${f.name}"));
			</#if>
			<#if f.type == "file" || f.type=="image">
			this.set${JavaName(f)}AttachedFile(tuple.getFile("filefor_${f.name}"));
			if(tuple.getFile("filefor_${entity.name}_${f.name}") != null) this.set${JavaName(f)}AttachedFile(tuple.getFile("filefor_${entity.name}_${f.name}"));
			</#if>						
		</#if>
	</#list>
		}
		//org.apache.log4j.Logger.getLogger("test").debug("set "+this);
	}
	
	
	
	
	