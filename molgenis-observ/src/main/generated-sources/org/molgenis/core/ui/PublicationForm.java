
/* File:        Observ/html/Publication.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.ui.HtmlFormGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package org.molgenis.core.ui;

// jdk
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// molgenis
import org.molgenis.framework.ui.html.*;


import org.molgenis.core.OntologyTerm;
import org.molgenis.core.Publication;

import org.molgenis.core.csv.OntologyTermCsvReader;
import org.molgenis.core.csv.PublicationCsvReader;


/**
 * A HtmlForm that is preloaded with all inputs for entity Publication
 * @see EntityForm
 */
public class PublicationForm extends EntityForm<Publication>
{
	private static final long serialVersionUID = 1L;
	
	public PublicationForm()
	{
		super();
	}
	
	public PublicationForm(Publication entity)
	{
		super(entity);
	}
	
	
	@Override
	public Class<Publication> getEntityClass()
	{
		return Publication.class;
	}
	
	@Override
	public Vector<String> getHeaders()
	{
		Vector<String> headers = new Vector<String>();
		headers.add("id");
		headers.add("name");
		headers.add("Pubmed ID");
		headers.add("Publication DOI");
		headers.add("authorList");
		headers.add("Publication Title");
		headers.add("Publication Status");
		headers.add("Publication Year");
		headers.add("Journal Title");
		return headers;
	}	
	
	@Override
	public List<HtmlInput<?>> getInputs()
	{	
		List<HtmlInput<?>> inputs = new ArrayList<HtmlInput<?>>();			
		//Id: Field(entity=Publication, name=id, type=int, auto=true, nillable=false, readonly=true, default=)
		{
			IntInput input = new IntInput("Publication_id",getEntity().getId());
			
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
		//Name: Field(entity=Publication, name=name, type=string[127], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Publication_name",getEntity().getName());
			
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
		//PubmedID: Field(entity=Publication, name=PubmedID, type=xref[OntologyTerm.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Publication_PubmedID", getEntity().getPubmedID());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getPubmedID_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getPubmedID_Id());
				dummy.setName( getEntity().getPubmedID_Name() ); 
			}
			XrefInput input = new XrefInput("Publication_PubmedID", org.molgenis.core.OntologyTerm.class, dummy);
			
			input.setLabel("Pubmed ID");
			input.setDescription("Pubmed ID");
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
		//DOI: Field(entity=Publication, name=DOI, type=xref[OntologyTerm.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Publication_DOI", getEntity().getDOI());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getDOI_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getDOI_Id());
				dummy.setName( getEntity().getDOI_Name() ); 
			}
			XrefInput input = new XrefInput("Publication_DOI", org.molgenis.core.OntologyTerm.class, dummy);
			
			input.setLabel("Publication DOI");
			input.setDescription("Publication DOI");
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
		//AuthorList: Field(entity=Publication, name=authorList, type=text, auto=false, nillable=true, readonly=false, default=)
		{
			TextInput input = new TextInput("Publication_authorList",getEntity().getAuthorList());
			
			input.setLabel("authorList");
			input.setDescription("The names of the authors of the publication");
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
		//Title: Field(entity=Publication, name=Title, type=string[255], auto=false, nillable=false, readonly=false, default=)
		{
			StringInput input = new StringInput("Publication_Title",getEntity().getTitle());
			
			input.setLabel("Publication Title");
			input.setDescription("The title of the Publication");
			input.setNillable(false);
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
		//Status: Field(entity=Publication, name=Status, type=xref[OntologyTerm.id], xref_label='name', auto=false, nillable=true, readonly=false, default=)
		{
		    //TODO: when we have JPA this should become:
			//XrefInput input = new XrefInput("Publication_Status", getEntity().getStatus());
			//create xref dummy object
			OntologyTerm dummy = null;
			if(getEntity().getStatus_Id() != null)
			{
			 	dummy = new OntologyTerm();
				dummy.setId(getEntity().getStatus_Id());
				dummy.setName( getEntity().getStatus_Name() ); 
			}
			XrefInput input = new XrefInput("Publication_Status", org.molgenis.core.OntologyTerm.class, dummy);
			
			input.setLabel("Publication Status");
			input.setDescription("The status of the Publication");
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
		//Year: Field(entity=Publication, name=Year, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Publication_Year",getEntity().getYear());
			
			input.setLabel("Publication Year");
			input.setDescription("The year of the Publication");
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
		//Journal: Field(entity=Publication, name=Journal, type=string[255], auto=false, nillable=true, readonly=false, default=)
		{
			StringInput input = new StringInput("Publication_Journal",getEntity().getJournal());
			
			input.setLabel("Journal Title");
			input.setDescription("The title of the Journal");
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


