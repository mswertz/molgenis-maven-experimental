
/* File:        Observ/html/Measurement.java
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
import org.molgenis.core.OntologyTerm;
import org.molgenis.pheno.AlternateId;
import org.molgenis.pheno.Category;
import org.molgenis.core.MolgenisEntity;
import org.molgenis.pheno.Measurement;

import org.molgenis.organization.csv.InvestigationCsvReader;
import org.molgenis.core.csv.OntologyTermCsvReader;
import org.molgenis.pheno.csv.AlternateIdCsvReader;
import org.molgenis.pheno.csv.CategoryCsvReader;
import org.molgenis.core.csv.MolgenisEntityCsvReader;
import org.molgenis.pheno.csv.MeasurementCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity Measurement
 * @see EntityForm
 */
public class MeasurementForm extends EntityForm<Measurement>
{
	private static final long serialVersionUID = 1L;
	
	public MeasurementForm()
	{
		super();
	}
	
	public MeasurementForm(Measurement entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Measurement> getEntityClass()
	{
		return Measurement.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("id");
		headers.add("name");
		headers.add("description");
		headers.add("Investigation");
		headers.add("ontologyReference");
		headers.add("__Type");
		headers.add("Alternative identifiers");
		headers.add("label");
		headers.add("unit");
		headers.add("dataType");
		headers.add("temporal");
		headers.add("categories");
		headers.add("ObservationTarget type allowed for relation");
		headers.add("Panel label allowed for relation");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Measurement, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Measurement_id",getEntity().getId());
			
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
		//Name: Field(entity=ObservationElement, name=name, type=string[127], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Measurement_name",getEntity().getName());
			
			input.setLabel("name");
			input.setDescription("human-readable name.");
			input.setNillable(false);
			input.setSize(127);
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
		//Description: Field(entity=Measurement, name=description, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("Measurement_description",getEntity().getDescription());
			
			input.setLabel("description");
			input.setDescription("(Optional) Rudimentary meta data about the observable feature. Use of ontology       terms references to establish unambigious descriptions is recommended");
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
		//Investigation: Field(entity=ObservationElement, name=Investigation, type=xref[Investigation.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Measurement_Investigation", getEntity().getInvestigation());
			//create xref dummy object
			Investigation dummy = null;
			if(getEntity().getInvestigation_Id() != null)
			{
			 	dummy = new Investigation();
				dummy.setId(getEntity().getInvestigation_Id());
				dummy.setName( getEntity().getInvestigation_Name() ); 
			}
			XrefInput input = new XrefInput("Measurement_Investigation", org.molgenis.organization.Investigation.class, dummy);
			
			input.setLabel("Investigation");
			input.setDescription("Reference to the Study that this data element is part of");
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
		//OntologyReference: Field(entity=ObservationElement, name=ontologyReference, type=mref[OntologyTerm.id], mref_name=ObservationElement_ontolo12449, mref_localid=InvestigationElement, mref_remoteid=ontologyReference, xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("Measurement_ontologyReference", getEntity().getOntologyReference());
			//create xref dummy list of references
			List<OntologyTerm> dummyList = new ArrayList<OntologyTerm>();
			if(getEntity().getOntologyReference_Id() != null) for(int i = 0; i < getEntity().getOntologyReference_Id().size(); i++ )
			{
				OntologyTerm dummy = new OntologyTerm();
				dummy.setId(getEntity().getOntologyReference_Id().get(i));
				dummy.setName( getEntity().getOntologyReference_Name().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput input = new MrefInput("Measurement_ontologyReference", org.molgenis.core.OntologyTerm.class, dummyList);
			
			input.setLabel("ontologyReference");
			input.setDescription("(Optional) Reference to the formal ontology definition for this element, e.g. &apos;Animal&apos; or &apos;GWAS protocol&apos;");
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
		//__Type: Field(entity=ObservationElement, name=__Type, type=enum, auto=true, nillable=false, readonly=true, default=null, enum_options=[ObservationElement, Individual, Location, Panel, ObservationTarget, Measurement, ObservableFeature, Category])
		{
			EnumInput input = new EnumInput("Measurement___Type",getEntity().get__Type());
			
			input.setLabel("__Type");
			input.setDescription("Subtypes have to be set to allow searching");
			input.setNillable(false);
			input.setReadonly(true); //automatic fields that are readonly, are also readonly on newrecord
			input.setOptions(getEntity().get__TypeOptions());
			input.setHidden(true);
			if(this.getCompactView().size() > 0 && !this.getCompactView().contains(input.getName()))
			{
				input.setCollapse(true);
			}

			inputs.add(input);
		}
		//AlternateId: Field(entity=ObservationElement, name=AlternateId, type=mref[AlternateId.id], mref_name=ObservationElement_AlternateId, mref_localid=ObservationElement, mref_remoteid=AlternateId, xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("Measurement_AlternateId", getEntity().getAlternateId());
			//create xref dummy list of references
			List<AlternateId> dummyList = new ArrayList<AlternateId>();
			if(getEntity().getAlternateId_Id() != null) for(int i = 0; i < getEntity().getAlternateId_Id().size(); i++ )
			{
				AlternateId dummy = new AlternateId();
				dummy.setId(getEntity().getAlternateId_Id().get(i));
				dummy.setName( getEntity().getAlternateId_Name().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput input = new MrefInput("Measurement_AlternateId", org.molgenis.pheno.AlternateId.class, dummyList);
			
			input.setLabel("Alternative identifiers");
			input.setDescription("Alternative identifiers or symbols that this element is known by.");
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
		//Label: Field(entity=ObservationElement, name=label, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Measurement_label",getEntity().getLabel());
			
			input.setLabel("label");
			input.setDescription("User friendly textual representation of this ObservationElement. For example: &apos;male&apos;,     &apos;mouse 3 in cage 7&apos; or &apos;TRA-2 like protein&apos;. Label allows for human-readable name that is potentially not unique.");
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
		//Unit: Field(entity=Measurement, name=unit, type=xref[OntologyTerm.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Measurement_unit", getEntity().getUnit());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getUnit_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getUnit_Id());
				dummy.setName( getEntity().getUnit_Name() ); 
			}
			XrefInput input = new XrefInput("Measurement_unit", org.molgenis.core.OntologyTerm.class, dummy);
			
			input.setLabel("unit");
			input.setDescription("(Optional) Reference to the well-defined measurement unit used to observe this feature       (if feature is that concrete). E.g. mmHg");
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
		//DataType: Field(entity=Measurement, name=dataType, type=enum, auto=false, nillable=false, readonly=false, default=string, enum_options=[xref, string, categorical, date, datetime, int, code, image, decimal, bool, file, log, data, exe])
		{
			EnumInput input = new EnumInput("Measurement_dataType",getEntity().getDataType());
			
			input.setLabel("dataType");
			input.setDescription("(Optional) Reference to the technical data type. E.g. &apos;int&apos;");
			input.setNillable(false);
			input.setReadonly( isReadonly() || getEntity().isReadonly());
			input.setOptions(getEntity().getDataTypeOptions());
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
		//Temporal: Field(entity=Measurement, name=temporal, type=bool, auto=false, nillable=false, readonly=false, default=false)
		{
			BoolInput input = new BoolInput("Measurement_temporal",getEntity().getTemporal());
			
			input.setLabel("temporal");
			input.setDescription("Whether this feature is time dependent and can have different values when measured       on different times (e.g. weight, temporal=true) or generally only measured once (e.g. birth date,       temporal=false)");
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
		//Categories: Field(entity=Measurement, name=categories, type=mref[Category.id], mref_name=Measurement_categories, mref_localid=Measurement, mref_remoteid=categories, xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
			//TODO: when we have JPA this should become:
			//MrefInput input = new MrefInput("Measurement_categories", getEntity().getCategories());
			//create xref dummy list of references
			List<Category> dummyList = new ArrayList<Category>();
			if(getEntity().getCategories_Id() != null) for(int i = 0; i < getEntity().getCategories_Id().size(); i++ )
			{
				Category dummy = new Category();
				dummy.setId(getEntity().getCategories_Id().get(i));
				dummy.setName( getEntity().getCategories_Name().get(i) ); 
				dummyList.add(dummy);
			}   
			MrefInput input = new MrefInput("Measurement_categories", org.molgenis.pheno.Category.class, dummyList);
			
			input.setLabel("categories");
			input.setDescription("Translation of codes into categories if applicable");
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
		//TargettypeAllowedForRelation: Field(entity=Measurement, name=targettypeAllowedForRelation, type=xref[MolgenisEntity.id], xref_label='className', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Measurement_targettypeAllowedForRelation", getEntity().getTargettypeAllowedForRelation());
			//create xref dummy object
			MolgenisEntity dummy = null;
			if(getEntity().getTargettypeAllowedForRelation_Id() != null)
			{
			 	dummy = new MolgenisEntity();
				dummy.setId(getEntity().getTargettypeAllowedForRelation_Id());
				dummy.setClassName( getEntity().getTargettypeAllowedForRelation_ClassName() ); 
			}
			XrefInput input = new XrefInput("Measurement_targettypeAllowedForRelation", org.molgenis.core.MolgenisEntity.class, dummy);
			
			input.setLabel("ObservationTarget type allowed for relation");
			input.setDescription("Subclass of ObservationTarget (Individual, Panel or Location) that      can be linked to (through the &apos;relation&apos; field in ObservedValue) when using this       Measurement (example: a Measurement &apos;Species&apos; can only result in ObservedValues       that have relations to Panels)");
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
		//PanelLabelAllowedForRelation: Field(entity=Measurement, name=panelLabelAllowedForRelation, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Measurement_panelLabelAllowedForRelation",getEntity().getPanelLabelAllowedForRelation());
			
			input.setLabel("Panel label allowed for relation");
			input.setDescription("Label that must have been applied to the Panel that      can be linked to (through the &apos;relation&apos; field in ObservedValue) when using this       Measurement (example: a Measurement &apos;Species&apos; can only result      in ObservedValues that have relations to Panels labeled as &apos;Species&apos;)");
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

		return inputs;
	}
}


