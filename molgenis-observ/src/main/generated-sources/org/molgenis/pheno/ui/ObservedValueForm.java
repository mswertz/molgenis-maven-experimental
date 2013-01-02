
/* File:        Observ/html/ObservedValue.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.pheno.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.organization.Investigation;
import org.molgenis.protocol.ProtocolApplication;
import org.molgenis.pheno.ObservationElement;
import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.ObservedValue;

import org.molgenis.organization.csv.InvestigationCsvReader;
import org.molgenis.protocol.csv.ProtocolApplicationCsvReader;
import org.molgenis.pheno.csv.ObservationElementCsvReader;
import org.molgenis.core.csv.OntologyTermCsvReader;
import org.molgenis.pheno.csv.ObservedValueCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity ObservedValue
 * @see EntityForm
 */
public class ObservedValueForm extends EntityForm<ObservedValue>
{
	private static final long serialVersionUID = 1L;
	
	public ObservedValueForm()
	{
		super();
	}
	
	public ObservedValueForm(ObservedValue entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<ObservedValue> getEntityClass()
	{
		return ObservedValue.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("id");
		headers.add("Investigation");
		headers.add("protocolApplication");
		headers.add("Feature");
		headers.add("Target");
		headers.add("ontologyReference");
		headers.add("value");
		headers.add("relation");
		headers.add("time");
		headers.add("endtime");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=ObservedValue, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("ObservedValue_id",getEntity().getId());
			
			input.setLabel("id");
			input.setDescription("automatically generated id");
			input.setNillable(false);
			input.setReadonly(true); //automatic fields that are readonly, are also readonly on newrecord
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Investigation: Field(entity=ObservedValue, name=Investigation, type=xref[Investigation.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ObservedValue_Investigation", getEntity().getInvestigation());
			//create xref dummy object
			Investigation dummy = null;
			if(getEntity().getInvestigation_Id() != null)
			{
			 	dummy = new Investigation();
				dummy.setId(getEntity().getInvestigation_Id());
				dummy.setName( getEntity().getInvestigation_Name() ); 
			}
			XrefInput input = new XrefInput("ObservedValue_Investigation", org.molgenis.organization.Investigation.class, dummy);
			
			input.setLabel("Investigation");
			input.setDescription("Investigation");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//ProtocolApplication: Field(entity=ObservedValue, name=protocolApplication, type=xref[ProtocolApplication.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ObservedValue_protocolApplication", getEntity().getProtocolApplication());
			//create xref dummy object
			ProtocolApplication dummy = null;
			if(getEntity().getProtocolApplication_Id() != null)
			{
			 	dummy = new ProtocolApplication();
				dummy.setId(getEntity().getProtocolApplication_Id());
				dummy.setName( getEntity().getProtocolApplication_Name() ); 
			}
			XrefInput input = new XrefInput("ObservedValue_protocolApplication", org.molgenis.protocol.ProtocolApplication.class, dummy);
			
			input.setLabel("protocolApplication");
			input.setDescription("Reference to the protocol application that was used to produce this observation. For example a particular patient visit or the application of a microarray or the calculation of a QTL model");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Feature: Field(entity=ObservedValue, name=Feature, type=xref[ObservationElement.id], xref_label='name', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ObservedValue_Feature", getEntity().getFeature());
			//create xref dummy object
			ObservationElement dummy = null;
			if(getEntity().getFeature_Id() != null)
			{
			 	dummy = new ObservationElement();
				dummy.setId(getEntity().getFeature_Id());
				dummy.setName( getEntity().getFeature_Name() ); 
			}
			XrefInput input = new XrefInput("ObservedValue_Feature", org.molgenis.pheno.ObservationElement.class, dummy);
			
			input.setLabel("Feature");
			input.setDescription("References the ObservableFeature that this observation was made on. For example &apos;probe123&apos;. Can be ommited for 1D data (i.e., a data list).");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Target: Field(entity=ObservedValue, name=Target, type=xref[ObservationElement.id], xref_label='name', auto=false, nillable=false, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ObservedValue_Target", getEntity().getTarget());
			//create xref dummy object
			ObservationElement dummy = null;
			if(getEntity().getTarget_Id() != null)
			{
			 	dummy = new ObservationElement();
				dummy.setId(getEntity().getTarget_Id());
				dummy.setName( getEntity().getTarget_Name() ); 
			}
			XrefInput input = new XrefInput("ObservedValue_Target", org.molgenis.pheno.ObservationElement.class, dummy);
			
			input.setLabel("Target");
			input.setDescription("References the ObservationTarget that this feature was made on. For example &apos;individual1&apos;. In a correlation matrix this could be also &apos;probe123&apos;.");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//OntologyReference: Field(entity=ObservedValue, name=ontologyReference, type=xref[OntologyTerm.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ObservedValue_ontologyReference", getEntity().getOntologyReference());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getOntologyReference_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getOntologyReference_Id());
				dummy.setName( getEntity().getOntologyReference_Name() ); 
			}
			XrefInput input = new XrefInput("ObservedValue_ontologyReference", org.molgenis.core.OntologyTerm.class, dummy);
			
			input.setLabel("ontologyReference");
			input.setDescription("(Optional) Reference to the     ontology definition or &apos;code&apos; for this value (recommended for non-numeric     values such as codes)");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Value: Field(entity=ObservedValue, name=value, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("ObservedValue_value",getEntity().getValue());
			
			input.setLabel("value");
			input.setDescription("The value observed");
			input.setNillable(true);
			input.setSize(255);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Relation: Field(entity=ObservedValue, name=relation, type=xref[ObservationElement.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("ObservedValue_relation", getEntity().getRelation());
			//create xref dummy object
			ObservationElement dummy = null;
			if(getEntity().getRelation_Id() != null)
			{
			 	dummy = new ObservationElement();
				dummy.setId(getEntity().getRelation_Id());
				dummy.setName( getEntity().getRelation_Name() ); 
			}
			XrefInput input = new XrefInput("ObservedValue_relation", org.molgenis.pheno.ObservationElement.class, dummy);
			
			input.setLabel("relation");
			input.setDescription("Reference to other end of the relationship, if any. For example to a &apos;brother&apos; or from &apos;sample&apos; to &apos;derivedSample&apos;.");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Time: Field(entity=ObservedValue, name=time, type=datetime, auto=false, nillable=true, readonly=false, default=)
		{
			DatetimeInput input = new DatetimeInput("ObservedValue_time",getEntity().getTime());
			
			input.setLabel("time");
			input.setDescription("(Optional) Time when the value was observed. For example in time series or if feature is time-dependent like &apos;age&apos;");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//Endtime: Field(entity=ObservedValue, name=endtime, type=datetime, auto=false, nillable=true, readonly=false, default=)
		{
			DatetimeInput input = new DatetimeInput("ObservedValue_endtime",getEntity().getEndtime());
			
			input.setLabel("endtime");
			input.setDescription("(Optional) Time when the value&apos;s validity ended");
			input.setNillable(true);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			if(this.getHiddenColumns().contains(input.getName()))
			{	
				input.setHidden(true);
			}
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}

		return inputs;
	}
}


