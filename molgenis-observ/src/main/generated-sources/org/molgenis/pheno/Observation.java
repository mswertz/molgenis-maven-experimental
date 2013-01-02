
/* File:        observ/model/Observation.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.pheno;

/**
 * Observation: FIXME: change to ObservationTarget?
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
public interface Observation extends  org.molgenis.core.Identifiable
{
	public Integer getId();
	public void setId(Integer id);
	public org.molgenis.organization.Investigation getInvestigation();
	public void setInvestigation(org.molgenis.organization.Investigation investigation);
        public Integer getInvestigation_Id();
        public void setInvestigation_Id(Integer investigation);

	public String getInvestigation_Name();
	public void setInvestigation_Name(String investigation_name);
	public org.molgenis.protocol.ProtocolApplication getProtocolApplication();
	public void setProtocolApplication(org.molgenis.protocol.ProtocolApplication protocolApplication);
        public Integer getProtocolApplication_Id();
        public void setProtocolApplication_Id(Integer protocolApplication);

	public String getProtocolApplication_Name();
	public void setProtocolApplication_Name(String protocolApplication_name);
	public org.molgenis.pheno.ObservationElement getFeature();
	public void setFeature(org.molgenis.pheno.ObservationElement feature);
        public Integer getFeature_Id();
        public void setFeature_Id(Integer feature);

	public String getFeature_Name();
	public void setFeature_Name(String feature_name);
	public org.molgenis.pheno.ObservationElement getTarget();
	public void setTarget(org.molgenis.pheno.ObservationElement target);
        public Integer getTarget_Id();
        public void setTarget_Id(Integer target);

	public String getTarget_Name();
	public void setTarget_Name(String target_name);
}

