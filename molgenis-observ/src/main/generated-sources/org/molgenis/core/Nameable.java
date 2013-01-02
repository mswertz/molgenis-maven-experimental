
/* File:        observ/model/Nameable.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.core;

/**
 * Nameable: This interface extends Identifiable with a unique 'name'
				field. The name length can be stored in one byte. (Java has signed
				integers) The name is by itself not unique, this should be enforced
				within a certain context. For example, unique(name, study) to make
				the name unique within one single study. The NameableDecorator
				ensures that names don't lead to problems in R and other script
				environments.
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
public interface Nameable extends  org.molgenis.core.Identifiable
{
	public Integer getId();
	public void setId(Integer id);
	public String getName();
	public void setName(String name);
}

