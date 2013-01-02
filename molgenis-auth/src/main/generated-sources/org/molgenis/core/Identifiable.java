
/* File:        auth/model/Identifiable.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 22, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.core;

/**
 * Identifiable: This interface assigns an automatic 'id' field to every
				object.
.
 * @version October 22, 2012 
 * @author MOLGENIS generator
 */
public interface Identifiable extends org.molgenis.util.Entity
{
	public Integer getId();
	public void setId(Integer id);
}

