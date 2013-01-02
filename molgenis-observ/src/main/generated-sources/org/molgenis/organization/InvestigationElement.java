
/* File:        observ/model/InvestigationElement.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.organization;

/**
 * InvestigationElement: General superclass to use for all elements of an
				Investigation. The unique forces all of these elements to have
				unique names within one Investigation. (can be changed to
				Name,Study,Type by flipping a boolean in the molgenis 'Unique'
				class.)
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
public interface InvestigationElement extends  org.molgenis.core.Nameable, org.molgenis.core.Describable
{
	public Integer getId();
	public void setId(Integer id);
	public String getName();
	public void setName(String name);
	public String getDescription();
	public void setDescription(String description);
	public org.molgenis.organization.Investigation getInvestigation();
	public void setInvestigation(org.molgenis.organization.Investigation investigation);
        public Integer getInvestigation_Id();
        public void setInvestigation_Id(Integer investigation);

	public String getInvestigation_Name();
	public void setInvestigation_Name(String investigation_name);
}

