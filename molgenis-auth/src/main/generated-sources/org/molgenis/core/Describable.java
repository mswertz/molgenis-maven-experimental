
/* File:        auth/model/Describable.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.core;

/**
 * Describable: This interface adds a description field to all entities
				the implement it.
.
 * @version October 22, 2012 
 * @author MOLGENIS generator
 */
public interface Describable extends org.molgenis.util.Entity
{
	public String getDescription();
	public void setDescription(String description);
}

