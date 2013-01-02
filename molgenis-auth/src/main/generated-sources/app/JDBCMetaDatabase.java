/* File:        auth/model/JDBCDatabase
 * Copyright:   Inventory 2000-2012, GBIC 2002-2012, all rights reserved
 * Date:        October 22, 2012
 * 
 * generator:   org.molgenis.generators.db.JDBCMetaDatabaseGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
package app;

import java.util.Arrays;
import java.util.Vector;

import org.molgenis.framework.db.DatabaseException;
import org.molgenis.MolgenisFieldTypes;
import org.molgenis.model.elements.Entity;
import org.molgenis.model.elements.Model;
import org.molgenis.model.elements.Field;
import org.molgenis.model.MolgenisModelException;
import org.molgenis.model.MolgenisModelValidator;
import org.molgenis.MolgenisOptions;

/**
 * This class is an in memory representation of the contents of your *_db.xml file
 * Utility of this class is to allow for dynamic querying and/or user interfacing
 * for example within a query tool or a security module.
 */
public class JDBCMetaDatabase extends Model
{
	public JDBCMetaDatabase() throws DatabaseException
	{
		super("auth");
		try
		{
			//MolgenisRole
			Entity molgenisRole_entity = new Entity("MolgenisRole",this.getDatabase());
			molgenisRole_entity.setSystem(true);
			molgenisRole_entity.setAbstract(false);
			molgenisRole_entity.setImplements(new String[]{"Identifiable"});
			molgenisRole_entity.setDescription("");
			molgenisRole_entity.setXrefLabels(Arrays.asList(new String[]{"name"}));
			Field molgenisRole_name_field = new Field(molgenisRole_entity, "name", MolgenisFieldTypes.getType("string"));
			molgenisRole_name_field.setDescription("name");
			molgenisRole_name_field.setNillable(false);
			molgenisRole_entity.addField(molgenisRole_name_field);
			Field molgenisRole_id_field = new Field(molgenisRole_entity, "id", MolgenisFieldTypes.getType("int"));
			molgenisRole_id_field.setAuto(true);
			molgenisRole_id_field.setDescription("automatically generated id");
			molgenisRole_id_field.setNillable(false);
			molgenisRole_entity.addField(molgenisRole_id_field);
			molgenisRole_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			molgenisRole_entity.addKey(Arrays.asList(new String[]{"name"}),false,"");
			
			//MolgenisGroup
			Entity molgenisGroup_entity = new Entity("MolgenisGroup",this.getDatabase());
			molgenisGroup_entity.setSystem(true);
			molgenisGroup_entity.setAbstract(false);
			molgenisGroup_entity.setParents(new String[]{"MolgenisRole"});
			molgenisGroup_entity.setDescription("");
			molgenisGroup_entity.setXrefLabels(Arrays.asList(new String[]{"name"}));
			Field molgenisGroup_id_field = new Field(molgenisGroup_entity, "id", MolgenisFieldTypes.getType("int"));
			molgenisGroup_id_field.setAuto(true);
			molgenisGroup_id_field.setDescription("automatically generated id");
			molgenisGroup_id_field.setNillable(false);
			molgenisGroup_entity.addField(molgenisGroup_id_field);
			molgenisGroup_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			
			//Contact
			Entity contact_entity = new Entity("Contact",this.getDatabase());
			contact_entity.setSystem(false);
			contact_entity.setAbstract(true);
			contact_entity.setImplements(new String[]{"Identifiable"});
			contact_entity.setDescription(" A contact is either a person or an organization. Copied\n\t\t\t\tfrom FuGE::Contact.\n");
			contact_entity.setXrefLabels(Arrays.asList(new String[]{"id"}));
			Field contact_address_field = new Field(contact_entity, "Address", MolgenisFieldTypes.getType("text"));
			contact_address_field.setDescription("The address of the Contact.");
			contact_address_field.setNillable(true);
			contact_entity.addField(contact_address_field);
			Field contact_phone_field = new Field(contact_entity, "Phone", MolgenisFieldTypes.getType("string"));
			contact_phone_field.setDescription("The telephone number of the Contact including the suitable area codes.");
			contact_phone_field.setNillable(true);
			contact_entity.addField(contact_phone_field);
			Field contact_email_field = new Field(contact_entity, "Email", MolgenisFieldTypes.getType("string"));
			contact_email_field.setDescription("The email address of the Contact.");
			contact_email_field.setNillable(true);
			contact_entity.addField(contact_email_field);
			Field contact_fax_field = new Field(contact_entity, "Fax", MolgenisFieldTypes.getType("string"));
			contact_fax_field.setDescription("The fax number of the Contact.");
			contact_fax_field.setNillable(true);
			contact_entity.addField(contact_fax_field);
			Field contact_tollFreePhone_field = new Field(contact_entity, "tollFreePhone", MolgenisFieldTypes.getType("string"));
			contact_tollFreePhone_field.setDescription("A toll free phone number for the Contact, including suitable area codes.");
			contact_tollFreePhone_field.setNillable(true);
			contact_entity.addField(contact_tollFreePhone_field);
			Field contact_city_field = new Field(contact_entity, "City", MolgenisFieldTypes.getType("string"));
			contact_city_field.setDescription("Added from the old definition of MolgenisUser. City of this contact.");
			contact_city_field.setNillable(true);
			contact_entity.addField(contact_city_field);
			Field contact_country_field = new Field(contact_entity, "Country", MolgenisFieldTypes.getType("string"));
			contact_country_field.setDescription("Added from the old definition of MolgenisUser. Country of this contact.");
			contact_country_field.setNillable(true);
			contact_entity.addField(contact_country_field);
			Field contact_id_field = new Field(contact_entity, "id", MolgenisFieldTypes.getType("int"));
			contact_id_field.setAuto(true);
			contact_id_field.setDescription("automatically generated id");
			contact_id_field.setNillable(false);
			contact_entity.addField(contact_id_field);
			contact_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			
			//Institute
			Entity institute_entity = new Entity("Institute",this.getDatabase());
			institute_entity.setSystem(false);
			institute_entity.setAbstract(false);
			institute_entity.setImplements(new String[]{"Contact"});
			institute_entity.setDescription(" A contact is either a person or an organization. Copied\n\t\t\t\tfrom FuGE::Contact.\n");
			institute_entity.setXrefLabels(Arrays.asList(new String[]{"name"}));
			Field institute_name_field = new Field(institute_entity, "name", MolgenisFieldTypes.getType("string"));
			institute_name_field.setDescription("name");
			institute_name_field.setNillable(false);
			institute_entity.addField(institute_name_field);
			Field institute_address_field = new Field(institute_entity, "Address", MolgenisFieldTypes.getType("text"));
			institute_address_field.setDescription("The address of the Contact.");
			institute_address_field.setNillable(true);
			institute_entity.addField(institute_address_field);
			Field institute_phone_field = new Field(institute_entity, "Phone", MolgenisFieldTypes.getType("string"));
			institute_phone_field.setDescription("The telephone number of the Contact including the suitable area codes.");
			institute_phone_field.setNillable(true);
			institute_entity.addField(institute_phone_field);
			Field institute_email_field = new Field(institute_entity, "Email", MolgenisFieldTypes.getType("string"));
			institute_email_field.setDescription("The email address of the Contact.");
			institute_email_field.setNillable(true);
			institute_entity.addField(institute_email_field);
			Field institute_fax_field = new Field(institute_entity, "Fax", MolgenisFieldTypes.getType("string"));
			institute_fax_field.setDescription("The fax number of the Contact.");
			institute_fax_field.setNillable(true);
			institute_entity.addField(institute_fax_field);
			Field institute_tollFreePhone_field = new Field(institute_entity, "tollFreePhone", MolgenisFieldTypes.getType("string"));
			institute_tollFreePhone_field.setDescription("A toll free phone number for the Contact, including suitable area codes.");
			institute_tollFreePhone_field.setNillable(true);
			institute_entity.addField(institute_tollFreePhone_field);
			Field institute_city_field = new Field(institute_entity, "City", MolgenisFieldTypes.getType("string"));
			institute_city_field.setDescription("Added from the old definition of MolgenisUser. City of this contact.");
			institute_city_field.setNillable(true);
			institute_entity.addField(institute_city_field);
			Field institute_country_field = new Field(institute_entity, "Country", MolgenisFieldTypes.getType("string"));
			institute_country_field.setDescription("Added from the old definition of MolgenisUser. Country of this contact.");
			institute_country_field.setNillable(true);
			institute_entity.addField(institute_country_field);
			Field institute_id_field = new Field(institute_entity, "id", MolgenisFieldTypes.getType("int"));
			institute_id_field.setAuto(true);
			institute_id_field.setDescription("automatically generated id");
			institute_id_field.setNillable(false);
			institute_entity.addField(institute_id_field);
			institute_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			institute_entity.addKey(Arrays.asList(new String[]{"name"}),false,"");
			
			//Identifiable
			Entity identifiable_entity = new Entity("Identifiable",this.getDatabase());
			identifiable_entity.setSystem(true);
			identifiable_entity.setAbstract(true);
			identifiable_entity.setDescription("This interface assigns an automatic 'id' field to every\n\t\t\t\tobject.\n");
			identifiable_entity.setXrefLabels(Arrays.asList(new String[]{"id"}));
			Field identifiable_id_field = new Field(identifiable_entity, "id", MolgenisFieldTypes.getType("int"));
			identifiable_id_field.setAuto(true);
			identifiable_id_field.setDescription("automatically generated id");
			identifiable_id_field.setNillable(false);
			identifiable_entity.addField(identifiable_id_field);
			identifiable_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			
			//Nameable
			Entity nameable_entity = new Entity("Nameable",this.getDatabase());
			nameable_entity.setSystem(false);
			nameable_entity.setAbstract(true);
			nameable_entity.setImplements(new String[]{"Identifiable"});
			nameable_entity.setDescription("This interface extends Identifiable with a unique 'name'\n\t\t\t\tfield. The name length can be stored in one byte. (Java has signed\n\t\t\t\tintegers) The name is by itself not unique, this should be enforced\n\t\t\t\twithin a certain context. For example, unique(name, study) to make\n\t\t\t\tthe name unique within one single study. The NameableDecorator\n\t\t\t\tensures that names don't lead to problems in R and other script\n\t\t\t\tenvironments.\n");
			nameable_entity.setXrefLabels(Arrays.asList(new String[]{"id"}));
			Field nameable_name_field = new Field(nameable_entity, "name", MolgenisFieldTypes.getType("string"));
			nameable_name_field.setDescription("human-readable name.");
			nameable_name_field.setNillable(false);
			nameable_entity.addField(nameable_name_field);
			Field nameable_id_field = new Field(nameable_entity, "id", MolgenisFieldTypes.getType("int"));
			nameable_id_field.setAuto(true);
			nameable_id_field.setDescription("automatically generated id");
			nameable_id_field.setNillable(false);
			nameable_entity.addField(nameable_id_field);
			nameable_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			
			//Describable
			Entity describable_entity = new Entity("Describable",this.getDatabase());
			describable_entity.setSystem(true);
			describable_entity.setAbstract(true);
			describable_entity.setDescription("This interface adds a description field to all entities\n\t\t\t\tthe implement it.\n");
			Field describable_description_field = new Field(describable_entity, "description", MolgenisFieldTypes.getType("text"));
			describable_description_field.setDescription("description field");
			describable_description_field.setNillable(true);
			describable_entity.addField(describable_description_field);
			
			//Ontology
			Entity ontology_entity = new Entity("Ontology",this.getDatabase());
			ontology_entity.setSystem(false);
			ontology_entity.setAbstract(false);
			ontology_entity.setImplements(new String[]{"Nameable"});
			ontology_entity.setDescription(" Ontology defines a reference to a an ontology or\n\t\t\t\tcontrolled vocabulary from which well-defined and stable (ontology)\n\t\t\t\tterms can be obtained. Each Ontology should have a unique name, for\n\t\t\t\tinstance: Gene Ontology, Mammalian Phenotype, Human Phenotype\n\t\t\t\tOntology, Unified Medical Language System, Medical Subject Headings,\n\t\t\t\tetc. Also a abbreviation is required, for instance: GO, MP, HPO,\n\t\t\t\tUMLS, MeSH, etc. Use of existing ontologies/vocabularies is\n\t\t\t\trecommended to harmonize phenotypic feature and value descriptions.\n\t\t\t\tBut one can also create a 'local' Ontology. The Ontology class maps\n\t\t\t\tto FuGE::Ontology, MAGE-TAB::TermSourceREF.\n");
			ontology_entity.setXrefLabels(Arrays.asList(new String[]{"name"}));
			Field ontology_ontologyAccession_field = new Field(ontology_entity, "ontologyAccession", MolgenisFieldTypes.getType("string"));
			ontology_ontologyAccession_field.setDescription("A identifier that uniquely identifies the ontology (typically an acronym). E.g. GO, MeSH, HPO.");
			ontology_ontologyAccession_field.setNillable(true);
			ontology_entity.addField(ontology_ontologyAccession_field);
			Field ontology_ontologyURI_field = new Field(ontology_entity, "ontologyURI", MolgenisFieldTypes.getType("hyperlink"));
			ontology_ontologyURI_field.setDescription("(Optional) A URI that references the location of the ontology.");
			ontology_ontologyURI_field.setNillable(true);
			ontology_entity.addField(ontology_ontologyURI_field);
			Field ontology_name_field = new Field(ontology_entity, "name", MolgenisFieldTypes.getType("string"));
			ontology_name_field.setDescription("human-readable name.");
			ontology_name_field.setNillable(false);
			ontology_entity.addField(ontology_name_field);
			Field ontology_id_field = new Field(ontology_entity, "id", MolgenisFieldTypes.getType("int"));
			ontology_id_field.setAuto(true);
			ontology_id_field.setDescription("automatically generated id");
			ontology_id_field.setNillable(false);
			ontology_entity.addField(ontology_id_field);
			ontology_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			ontology_entity.addKey(Arrays.asList(new String[]{"name"}),false,"");
			
			//OntologyTerm
			Entity ontologyTerm_entity = new Entity("OntologyTerm",this.getDatabase());
			ontologyTerm_entity.setSystem(false);
			ontologyTerm_entity.setAbstract(false);
			ontologyTerm_entity.setImplements(new String[]{"Nameable"});
			ontologyTerm_entity.setDescription("\n\t\t\t\tOntologyTerm defines a single entry (term) from an ontology or a\n\t\t\t\tcontrolled vocabulary (defined by Ontology). The name is the\n\t\t\t\tontology term which is unique within an ontology source, such as\n\t\t\t\t[examples here]. Other data entities can reference to this\n\t\t\t\tOntologyTerm to harmonize naming of concepts. Each term should have\n\t\t\t\ta local, unique label within the Investigation. If no suitable\n\t\t\t\tontology term exists then one can define new terms locally (in which\n\t\t\t\tcase there is no formal accession for the term limiting its use for\n\t\t\t\tcross-Investigation queries). In those cases the local name should\n\t\t\t\tbe repeated in both term and termAccession. Maps to\n\t\t\t\tFuGE::OntologyIndividual; in MAGE-TAB there is no separate entity to\n\t\t\t\tmodel terms.\n\t\t\t\t<br/>\n\t\t\t\tOptionally a local controlled vocabulary or ontology can be defined,\n\t\t\t\tfor example to represent 'Codelists' often used in questionaires.\n\t\t\t\tNote: this is not a InvestigationElement because of the additional\n\t\t\t\txref_label and unique constraint.This class defines a single entry\n\t\t\t\tfrom an ontology or a controlled vocabulary.\n\t\t\t\t<br/>\n\t\t\t\tIf it is a simple controlled vocabulary, there may be no formal\n\t\t\t\taccession for the term. In these cases the local name should be\n\t\t\t\trepeated in both term and termAccession. If the term has a value,\n\t\t\t\tthe OntologyTerm will have a single DataProperty whose value was the\n\t\t\t\tvalue for the property. For instance, for an OntologyIndividual\n\t\t\t\tbased on the MO ontology the attributes might be: The term would be\n\t\t\t\twhat is usually called the local name in the Ontology, for instance\n\t\t\t\t'Age'; The termAccession could be\n\t\t\t\t'http://mged.sourceforge.net/ontologies/MGEDOntology.owl#Age' or a\n\t\t\t\tan arbitrary accession if one exists; The identifier is a unique\n\t\t\t\tidentifier for individuals in the scope of the FuGE instance; The\n\t\t\t\tinherited name attribute should not be used; The ontologyURI of\n\t\t\t\tOntologySource could be\n\t\t\t\t'http://mged.sourceforge.net/ontologies/MGEDOntology.owl\". The\n\t\t\t\tOntologyTerm subclasses are instances of Ontology classes and\n\t\t\t\tproperties, not the actual terms themselves. An OntologyIndividual,\n\t\t\t\tif based on an existing Ontology, can be considered a statement that\n\t\t\t\tcan be validated against the referenced ontology. The subclasses and\n\t\t\t\ttheir associations are based on the Ontology Definition Model,\n\t\t\t\tad/2005-04-13, submitted to the OMG as a response to RFP\n\t\t\t\tad/2003-03-40, Copyright 2005 DSTC Pty Ltd. Copyright 2005 IBM\n\t\t\t\tCopyright 2005 Sandpiper Software, Inc under the standard OMG\n\t\t\t\tlicense terms. \n\t\t\t\n");
			ontologyTerm_entity.setXrefLabels(Arrays.asList(new String[]{"name"}));
			Field ontologyTerm_ontology_field = new Field(ontologyTerm_entity, "ontology", MolgenisFieldTypes.getType("xref"));
			ontologyTerm_ontology_field.setDescription("(Optional) The source ontology or controlled vocabulary list that ontology terms have been obtained from.");
			ontologyTerm_ontology_field.setNillable(true);
			ontologyTerm_ontology_field.setXRefVariables("Ontology", "id",Arrays.asList(new String[]{"name"}));
			ontologyTerm_entity.addField(ontologyTerm_ontology_field);
			Field ontologyTerm_termAccession_field = new Field(ontologyTerm_entity, "termAccession", MolgenisFieldTypes.getType("string"));
			ontologyTerm_termAccession_field.setDescription("(Optional) The accession number assigned to the ontology term in its source ontology. If empty it is assumed to be a locally defined term.");
			ontologyTerm_termAccession_field.setNillable(true);
			ontologyTerm_entity.addField(ontologyTerm_termAccession_field);
			Field ontologyTerm_definition_field = new Field(ontologyTerm_entity, "definition", MolgenisFieldTypes.getType("string"));
			ontologyTerm_definition_field.setDescription("(Optional) The definition of the term.");
			ontologyTerm_definition_field.setNillable(true);
			ontologyTerm_entity.addField(ontologyTerm_definition_field);
			Field ontologyTerm_termPath_field = new Field(ontologyTerm_entity, "termPath", MolgenisFieldTypes.getType("string"));
			ontologyTerm_termPath_field.setDescription("EXTENSION. The Ontology Lookup Service path that contains this term.");
			ontologyTerm_termPath_field.setNillable(true);
			ontologyTerm_entity.addField(ontologyTerm_termPath_field);
			Field ontologyTerm_name_field = new Field(ontologyTerm_entity, "name", MolgenisFieldTypes.getType("string"));
			ontologyTerm_name_field.setDescription("human-readable name.");
			ontologyTerm_name_field.setNillable(false);
			ontologyTerm_entity.addField(ontologyTerm_name_field);
			Field ontologyTerm_id_field = new Field(ontologyTerm_entity, "id", MolgenisFieldTypes.getType("int"));
			ontologyTerm_id_field.setAuto(true);
			ontologyTerm_id_field.setDescription("automatically generated id");
			ontologyTerm_id_field.setNillable(false);
			ontologyTerm_entity.addField(ontologyTerm_id_field);
			ontologyTerm_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			ontologyTerm_entity.addKey(Arrays.asList(new String[]{"ontology","termAccession"}),false,"");
			ontologyTerm_entity.addKey(Arrays.asList(new String[]{"ontology","name"}),false,"");
			
			//Person
			Entity person_entity = new Entity("Person",this.getDatabase());
			person_entity.setSystem(false);
			person_entity.setAbstract(false);
			person_entity.setImplements(new String[]{"Contact"});
			person_entity.setParents(new String[]{"MolgenisRole"});
			person_entity.setDescription("\n\n\t\t\t\tPerson represents one or more people involved with an Investigation.\n\t\t\t\tThis may include authors on a paper, lab personnel or PIs. Person\n\t\t\t\thas last name, firstname, mid initial, address, contact and email. A\n\t\t\t\tPerson role is included to represent how a Person is involved with\n\t\t\t\tan investigation. For submission to repository purposes an allowed\n\t\t\t\tvalue is 'submitter' and the term is present in the MGED Ontology,\n\t\t\t\tan alternative use could represent job title. An Example from\n\t\t\t\tArrayExpress is E-MTAB-506\n\t\t\t\t<a href=\"ftp://ftp.ebi.ac.uk/pub/databases/microarray/data/experiment/TABM/E-TABM-506/E-TABM-506.idf.txt\">\n\t\t\t\t\tftp://ftp.ebi.ac.uk/pub/databases/microarray/data/experiment/TABM/E-TABM-506/E-TABM-506.idf.txt.\n\t\t\t\t</a>\n\t\t\t\t.\n\t\t\t\t<br/>\n\t\t\t\tThe FUGE equivalent to Person is FuGE::Person.\n\t\t\t\n");
			person_entity.setXrefLabels(Arrays.asList(new String[]{"name"}));
			Field person_firstName_field = new Field(person_entity, "FirstName", MolgenisFieldTypes.getType("string"));
			person_firstName_field.setDescription("First Name");
			person_firstName_field.setNillable(true);
			person_entity.addField(person_firstName_field);
			Field person_midInitials_field = new Field(person_entity, "MidInitials", MolgenisFieldTypes.getType("string"));
			person_midInitials_field.setDescription("Mid Initials");
			person_midInitials_field.setNillable(true);
			person_entity.addField(person_midInitials_field);
			Field person_lastName_field = new Field(person_entity, "LastName", MolgenisFieldTypes.getType("string"));
			person_lastName_field.setDescription("Last Name");
			person_lastName_field.setNillable(true);
			person_entity.addField(person_lastName_field);
			Field person_title_field = new Field(person_entity, "Title", MolgenisFieldTypes.getType("string"));
			person_title_field.setDescription("An academic title, e.g. Prof.dr, PhD");
			person_title_field.setNillable(true);
			person_entity.addField(person_title_field);
			Field person_affiliation_field = new Field(person_entity, "Affiliation", MolgenisFieldTypes.getType("xref"));
			person_affiliation_field.setDescription("Affiliation");
			person_affiliation_field.setNillable(true);
			person_affiliation_field.setXRefVariables("Institute", "id",Arrays.asList(new String[]{"name"}));
			person_entity.addField(person_affiliation_field);
			Field person_department_field = new Field(person_entity, "Department", MolgenisFieldTypes.getType("string"));
			person_department_field.setDescription("Added from the old definition of MolgenisUser. Department of this contact.");
			person_department_field.setNillable(true);
			person_entity.addField(person_department_field);
			Field person_roles_field = new Field(person_entity, "Roles", MolgenisFieldTypes.getType("xref"));
			person_roles_field.setDescription("Indicate role of the contact, e.g. lab worker or PI. Changed from mref to xref in oct 2011.");
			person_roles_field.setNillable(true);
			person_roles_field.setXRefVariables("OntologyTerm", "id",Arrays.asList(new String[]{"name"}));
			person_entity.addField(person_roles_field);
			Field person_address_field = new Field(person_entity, "Address", MolgenisFieldTypes.getType("text"));
			person_address_field.setDescription("The address of the Contact.");
			person_address_field.setNillable(true);
			person_entity.addField(person_address_field);
			Field person_phone_field = new Field(person_entity, "Phone", MolgenisFieldTypes.getType("string"));
			person_phone_field.setDescription("The telephone number of the Contact including the suitable area codes.");
			person_phone_field.setNillable(true);
			person_entity.addField(person_phone_field);
			Field person_email_field = new Field(person_entity, "Email", MolgenisFieldTypes.getType("string"));
			person_email_field.setDescription("The email address of the Contact.");
			person_email_field.setNillable(true);
			person_entity.addField(person_email_field);
			Field person_fax_field = new Field(person_entity, "Fax", MolgenisFieldTypes.getType("string"));
			person_fax_field.setDescription("The fax number of the Contact.");
			person_fax_field.setNillable(true);
			person_entity.addField(person_fax_field);
			Field person_tollFreePhone_field = new Field(person_entity, "tollFreePhone", MolgenisFieldTypes.getType("string"));
			person_tollFreePhone_field.setDescription("A toll free phone number for the Contact, including suitable area codes.");
			person_tollFreePhone_field.setNillable(true);
			person_entity.addField(person_tollFreePhone_field);
			Field person_city_field = new Field(person_entity, "City", MolgenisFieldTypes.getType("string"));
			person_city_field.setDescription("Added from the old definition of MolgenisUser. City of this contact.");
			person_city_field.setNillable(true);
			person_entity.addField(person_city_field);
			Field person_country_field = new Field(person_entity, "Country", MolgenisFieldTypes.getType("string"));
			person_country_field.setDescription("Added from the old definition of MolgenisUser. Country of this contact.");
			person_country_field.setNillable(true);
			person_entity.addField(person_country_field);
			Field person_id_field = new Field(person_entity, "id", MolgenisFieldTypes.getType("int"));
			person_id_field.setAuto(true);
			person_id_field.setDescription("automatically generated id");
			person_id_field.setNillable(false);
			person_entity.addField(person_id_field);
			person_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			person_entity.addKey(Arrays.asList(new String[]{"FirstName","MidInitials","LastName"}),false,"");
			
			//MolgenisUser
			Entity molgenisUser_entity = new Entity("MolgenisUser",this.getDatabase());
			molgenisUser_entity.setSystem(true);
			molgenisUser_entity.setAbstract(false);
			molgenisUser_entity.setParents(new String[]{"Person"});
			molgenisUser_entity.setDescription("Anyone who can login\n");
			molgenisUser_entity.setXrefLabels(Arrays.asList(new String[]{"name"}));
			Field molgenisUser_password__field = new Field(molgenisUser_entity, "password_", MolgenisFieldTypes.getType("string"));
			molgenisUser_password__field.setDevaultValue("secret");
			molgenisUser_password__field.setDescription("big fixme: password type");
			molgenisUser_password__field.setNillable(false);
			molgenisUser_entity.addField(molgenisUser_password__field);
			Field molgenisUser_activationCode_field = new Field(molgenisUser_entity, "activationCode", MolgenisFieldTypes.getType("string"));
			molgenisUser_activationCode_field.setDescription("Used as alternative authentication mechanism to verify user email and/or if user has lost password.");
			molgenisUser_activationCode_field.setNillable(true);
			molgenisUser_entity.addField(molgenisUser_activationCode_field);
			Field molgenisUser_active_field = new Field(molgenisUser_entity, "active", MolgenisFieldTypes.getType("bool"));
			molgenisUser_active_field.setDevaultValue("false");
			molgenisUser_active_field.setDescription("Boolean to indicate if this account can be used to login");
			molgenisUser_active_field.setNillable(false);
			molgenisUser_entity.addField(molgenisUser_active_field);
			Field molgenisUser_superuser_field = new Field(molgenisUser_entity, "superuser", MolgenisFieldTypes.getType("bool"));
			molgenisUser_superuser_field.setDevaultValue("false");
			molgenisUser_superuser_field.setDescription("superuser");
			molgenisUser_superuser_field.setNillable(false);
			molgenisUser_entity.addField(molgenisUser_superuser_field);
			Field molgenisUser_id_field = new Field(molgenisUser_entity, "id", MolgenisFieldTypes.getType("int"));
			molgenisUser_id_field.setAuto(true);
			molgenisUser_id_field.setDescription("automatically generated id");
			molgenisUser_id_field.setNillable(false);
			molgenisUser_entity.addField(molgenisUser_id_field);
			molgenisUser_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			
			//MolgenisRoleGroupLink
			Entity molgenisRoleGroupLink_entity = new Entity("MolgenisRoleGroupLink",this.getDatabase());
			molgenisRoleGroupLink_entity.setSystem(true);
			molgenisRoleGroupLink_entity.setAbstract(false);
			molgenisRoleGroupLink_entity.setImplements(new String[]{"Identifiable"});
			molgenisRoleGroupLink_entity.setDescription("");
			molgenisRoleGroupLink_entity.setXrefLabels(Arrays.asList(new String[]{"id"}));
			Field molgenisRoleGroupLink_group__field = new Field(molgenisRoleGroupLink_entity, "group_", MolgenisFieldTypes.getType("xref"));
			molgenisRoleGroupLink_group__field.setDescription("group_");
			molgenisRoleGroupLink_group__field.setNillable(false);
			molgenisRoleGroupLink_group__field.setXRefVariables("MolgenisGroup", "id",Arrays.asList(new String[]{"name"}));
			molgenisRoleGroupLink_entity.addField(molgenisRoleGroupLink_group__field);
			Field molgenisRoleGroupLink_role__field = new Field(molgenisRoleGroupLink_entity, "role_", MolgenisFieldTypes.getType("xref"));
			molgenisRoleGroupLink_role__field.setDescription("role_");
			molgenisRoleGroupLink_role__field.setNillable(false);
			molgenisRoleGroupLink_role__field.setXRefVariables("MolgenisRole", "id",Arrays.asList(new String[]{"name"}));
			molgenisRoleGroupLink_entity.addField(molgenisRoleGroupLink_role__field);
			Field molgenisRoleGroupLink_id_field = new Field(molgenisRoleGroupLink_entity, "id", MolgenisFieldTypes.getType("int"));
			molgenisRoleGroupLink_id_field.setAuto(true);
			molgenisRoleGroupLink_id_field.setDescription("automatically generated id");
			molgenisRoleGroupLink_id_field.setNillable(false);
			molgenisRoleGroupLink_entity.addField(molgenisRoleGroupLink_id_field);
			molgenisRoleGroupLink_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			molgenisRoleGroupLink_entity.addKey(Arrays.asList(new String[]{"group_","role_"}),false,"");
			
			//Authorizable
			Entity authorizable_entity = new Entity("Authorizable",this.getDatabase());
			authorizable_entity.setSystem(false);
			authorizable_entity.setAbstract(true);
			authorizable_entity.setDescription("Interface for row level security\n");
			Field authorizable_canRead_field = new Field(authorizable_entity, "canRead", MolgenisFieldTypes.getType("xref"));
			authorizable_canRead_field.setDescription("canRead");
			authorizable_canRead_field.setNillable(true);
			authorizable_canRead_field.setXRefVariables("MolgenisRole", "id",Arrays.asList(new String[]{"name"}));
			authorizable_entity.addField(authorizable_canRead_field);
			Field authorizable_canWrite_field = new Field(authorizable_entity, "canWrite", MolgenisFieldTypes.getType("xref"));
			authorizable_canWrite_field.setDescription("canWrite");
			authorizable_canWrite_field.setNillable(true);
			authorizable_canWrite_field.setXRefVariables("MolgenisRole", "id",Arrays.asList(new String[]{"name"}));
			authorizable_entity.addField(authorizable_canWrite_field);
			Field authorizable_owns_field = new Field(authorizable_entity, "owns", MolgenisFieldTypes.getType("xref"));
			authorizable_owns_field.setDescription("owns");
			authorizable_owns_field.setNillable(false);
			authorizable_owns_field.setXRefVariables("MolgenisRole", "id",Arrays.asList(new String[]{"name"}));
			authorizable_entity.addField(authorizable_owns_field);
			
			//MolgenisFile
			Entity molgenisFile_entity = new Entity("MolgenisFile",this.getDatabase());
			molgenisFile_entity.setSystem(false);
			molgenisFile_entity.setAbstract(false);
			molgenisFile_entity.setImplements(new String[]{"Nameable"});
			molgenisFile_entity.setDescription("\n\t\t\t\tHelper entity to deal with files. Has a decorator to regulate\n\t\t\t\tstorage and coupling to an Entity. Do not make abstract because of\n\t\t\t\tsubtyping. This means the names of the subclasses will be used to\n\t\t\t\tdistinguish MolgenisFiles and place them in the correct folders.\n\t\t\t\t<br/>\n\t\t\t\tMS: make it use the &lt;field type=\"file\" property under the hood. \n\t\t\t\t<br/>\n\t\t\t\tMS: where do the mimetypes go? I mean, I don't see the added value\n\t\t\t\tnow.\n\t\t\t\n");
			molgenisFile_entity.setXrefLabels(Arrays.asList(new String[]{"name"}));
			Field molgenisFile_extension_field = new Field(molgenisFile_entity, "Extension", MolgenisFieldTypes.getType("string"));
			molgenisFile_extension_field.setDescription("The file extension. This will be mapped to MIME type at runtime. For example, a type 'png' will be served out as 'image/png'.");
			molgenisFile_extension_field.setNillable(false);
			molgenisFile_entity.addField(molgenisFile_extension_field);
			Field molgenisFile_name_field = new Field(molgenisFile_entity, "name", MolgenisFieldTypes.getType("string"));
			molgenisFile_name_field.setDescription("human-readable name.");
			molgenisFile_name_field.setNillable(false);
			molgenisFile_entity.addField(molgenisFile_name_field);
			Field molgenisFile_id_field = new Field(molgenisFile_entity, "id", MolgenisFieldTypes.getType("int"));
			molgenisFile_id_field.setAuto(true);
			molgenisFile_id_field.setDescription("automatically generated id");
			molgenisFile_id_field.setNillable(false);
			molgenisFile_entity.addField(molgenisFile_id_field);
			molgenisFile_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			molgenisFile_entity.addKey(Arrays.asList(new String[]{"name"}),false,"");
			
			//RuntimeProperty
			Entity runtimeProperty_entity = new Entity("RuntimeProperty",this.getDatabase());
			runtimeProperty_entity.setSystem(false);
			runtimeProperty_entity.setAbstract(false);
			runtimeProperty_entity.setImplements(new String[]{"Nameable"});
			runtimeProperty_entity.setDescription("");
			runtimeProperty_entity.setXrefLabels(Arrays.asList(new String[]{"name"}));
			Field runtimeProperty_value_field = new Field(runtimeProperty_entity, "Value", MolgenisFieldTypes.getType("string"));
			runtimeProperty_value_field.setDescription("Value");
			runtimeProperty_value_field.setNillable(false);
			runtimeProperty_entity.addField(runtimeProperty_value_field);
			Field runtimeProperty_name_field = new Field(runtimeProperty_entity, "name", MolgenisFieldTypes.getType("string"));
			runtimeProperty_name_field.setDescription("human-readable name.");
			runtimeProperty_name_field.setNillable(false);
			runtimeProperty_entity.addField(runtimeProperty_name_field);
			Field runtimeProperty_id_field = new Field(runtimeProperty_entity, "id", MolgenisFieldTypes.getType("int"));
			runtimeProperty_id_field.setAuto(true);
			runtimeProperty_id_field.setDescription("automatically generated id");
			runtimeProperty_id_field.setNillable(false);
			runtimeProperty_entity.addField(runtimeProperty_id_field);
			runtimeProperty_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			runtimeProperty_entity.addKey(Arrays.asList(new String[]{"name"}),false,"");
			
			//Publication
			Entity publication_entity = new Entity("Publication",this.getDatabase());
			publication_entity.setSystem(false);
			publication_entity.setAbstract(false);
			publication_entity.setImplements(new String[]{"Nameable"});
			publication_entity.setDescription("\n\n\t\t\t\tPublication is part of the Investigation package and is used to\n\t\t\t\trepresent information about one or more publications related to an\n\t\t\t\tInvestigation. The publication need not only be primary publication\n\t\t\t\tfor an Investigation but may also represent other related\n\t\t\t\tinformation- though this use is less common. Publications have\n\t\t\t\tattributes of publications Authors and also DOI and Pubmed\n\t\t\t\tidentifiers (when these are available). These are represented as\n\t\t\t\tOntologyTerms as in the MAGE-TAB model all 'xrefs' (cross\n\t\t\t\treferences) for ontologies and accession numbers are handled\n\t\t\t\tgenerically. An example of a publication is available in an IDF file\n\t\t\t\tfrom ArrayExpress is experiment E-MTAB-506\n\t\t\t\t<a href=\"ftp://ftp.ebi.ac.uk/pub/databases/microarray/data/experiment/TABM/E-TABM-506/E-TABM-506.idf.txt\">ftp://ftp.ebi.ac.uk/pub/databases/microarray/data/experiment/TABM/E-TABM-506/E-TABM-506.idf.txt\n\t\t\t\t</a>\n\t\t\t\t.\n\t\t\t\t<br/>\n\t\t\t\tThe FuGE equivalent to Publication is FuGE::Bibliographic Reference.\n\t\t\t\n");
			publication_entity.setXrefLabels(Arrays.asList(new String[]{"id"}));
			Field publication_pubmedID_field = new Field(publication_entity, "PubmedID", MolgenisFieldTypes.getType("xref"));
			publication_pubmedID_field.setDescription("Pubmed ID");
			publication_pubmedID_field.setNillable(true);
			publication_pubmedID_field.setXRefVariables("OntologyTerm", "id",Arrays.asList(new String[]{"name"}));
			publication_entity.addField(publication_pubmedID_field);
			Field publication_dOI_field = new Field(publication_entity, "DOI", MolgenisFieldTypes.getType("xref"));
			publication_dOI_field.setDescription("Publication DOI");
			publication_dOI_field.setNillable(true);
			publication_dOI_field.setXRefVariables("OntologyTerm", "id",Arrays.asList(new String[]{"name"}));
			publication_entity.addField(publication_dOI_field);
			Field publication_authorList_field = new Field(publication_entity, "authorList", MolgenisFieldTypes.getType("text"));
			publication_authorList_field.setDescription("The names of the authors of the publication");
			publication_authorList_field.setNillable(true);
			publication_entity.addField(publication_authorList_field);
			Field publication_title_field = new Field(publication_entity, "Title", MolgenisFieldTypes.getType("string"));
			publication_title_field.setDescription("The title of the Publication");
			publication_title_field.setNillable(false);
			publication_entity.addField(publication_title_field);
			Field publication_status_field = new Field(publication_entity, "Status", MolgenisFieldTypes.getType("xref"));
			publication_status_field.setDescription("The status of the Publication");
			publication_status_field.setNillable(true);
			publication_status_field.setXRefVariables("OntologyTerm", "id",Arrays.asList(new String[]{"name"}));
			publication_entity.addField(publication_status_field);
			Field publication_year_field = new Field(publication_entity, "Year", MolgenisFieldTypes.getType("string"));
			publication_year_field.setDescription("The year of the Publication");
			publication_year_field.setNillable(true);
			publication_entity.addField(publication_year_field);
			Field publication_journal_field = new Field(publication_entity, "Journal", MolgenisFieldTypes.getType("string"));
			publication_journal_field.setDescription("The title of the Journal");
			publication_journal_field.setNillable(true);
			publication_entity.addField(publication_journal_field);
			Field publication_name_field = new Field(publication_entity, "name", MolgenisFieldTypes.getType("string"));
			publication_name_field.setDescription("human-readable name.");
			publication_name_field.setNillable(false);
			publication_entity.addField(publication_name_field);
			Field publication_id_field = new Field(publication_entity, "id", MolgenisFieldTypes.getType("int"));
			publication_id_field.setAuto(true);
			publication_id_field.setDescription("automatically generated id");
			publication_id_field.setNillable(false);
			publication_entity.addField(publication_id_field);
			publication_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			publication_entity.addKey(Arrays.asList(new String[]{"name"}),false,"");
			
			//UseCase
			Entity useCase_entity = new Entity("UseCase",this.getDatabase());
			useCase_entity.setSystem(false);
			useCase_entity.setAbstract(false);
			useCase_entity.setDescription(" All the use cases send to the server are stored in this\n\t\t\t\tentity .\n");
			useCase_entity.setXrefLabels(Arrays.asList(new String[]{"UseCaseName"}));
			Field useCase_useCaseId_field = new Field(useCase_entity, "UseCaseId", MolgenisFieldTypes.getType("int"));
			useCase_useCaseId_field.setAuto(true);
			useCase_useCaseId_field.setDescription("UseCaseId");
			useCase_useCaseId_field.setNillable(false);
			useCase_entity.addField(useCase_useCaseId_field);
			Field useCase_useCaseName_field = new Field(useCase_entity, "UseCaseName", MolgenisFieldTypes.getType("string"));
			useCase_useCaseName_field.setDescription("UseCaseName");
			useCase_useCaseName_field.setNillable(false);
			useCase_entity.addField(useCase_useCaseName_field);
			Field useCase_searchType_field = new Field(useCase_entity, "SearchType", MolgenisFieldTypes.getType("string"));
			useCase_searchType_field.setDescription("SearchType");
			useCase_searchType_field.setNillable(false);
			useCase_entity.addField(useCase_searchType_field);
			useCase_entity.addKey(Arrays.asList(new String[]{"UseCaseId"}),false,"");
			useCase_entity.addKey(Arrays.asList(new String[]{"UseCaseName"}),false,"");
			
			//MolgenisEntity
			Entity molgenisEntity_entity = new Entity("MolgenisEntity",this.getDatabase());
			molgenisEntity_entity.setSystem(true);
			molgenisEntity_entity.setAbstract(false);
			molgenisEntity_entity.setImplements(new String[]{"Identifiable"});
			molgenisEntity_entity.setDescription("Referenceable catalog of entity names, menus, forms and\n\t\t\t\tplugins.\n");
			molgenisEntity_entity.setXrefLabels(Arrays.asList(new String[]{"className"}));
			Field molgenisEntity_name_field = new Field(molgenisEntity_entity, "name", MolgenisFieldTypes.getType("string"));
			molgenisEntity_name_field.setDescription("Name of the entity");
			molgenisEntity_name_field.setNillable(false);
			molgenisEntity_entity.addField(molgenisEntity_name_field);
			Field molgenisEntity_type__field = new Field(molgenisEntity_entity, "type_", MolgenisFieldTypes.getType("string"));
			molgenisEntity_type__field.setDescription("Type of the entity");
			molgenisEntity_type__field.setNillable(false);
			molgenisEntity_entity.addField(molgenisEntity_type__field);
			Field molgenisEntity_className_field = new Field(molgenisEntity_entity, "className", MolgenisFieldTypes.getType("string"));
			molgenisEntity_className_field.setDescription("Full name of the entity");
			molgenisEntity_className_field.setNillable(false);
			molgenisEntity_entity.addField(molgenisEntity_className_field);
			Field molgenisEntity_id_field = new Field(molgenisEntity_entity, "id", MolgenisFieldTypes.getType("int"));
			molgenisEntity_id_field.setAuto(true);
			molgenisEntity_id_field.setDescription("automatically generated id");
			molgenisEntity_id_field.setNillable(false);
			molgenisEntity_entity.addField(molgenisEntity_id_field);
			molgenisEntity_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			molgenisEntity_entity.addKey(Arrays.asList(new String[]{"className"}),false,"");
			molgenisEntity_entity.addKey(Arrays.asList(new String[]{"name","type_"}),false,"");
			
			//MolgenisPermission
			Entity molgenisPermission_entity = new Entity("MolgenisPermission",this.getDatabase());
			molgenisPermission_entity.setSystem(true);
			molgenisPermission_entity.setAbstract(false);
			molgenisPermission_entity.setImplements(new String[]{"Identifiable"});
			molgenisPermission_entity.setDescription("");
			molgenisPermission_entity.setXrefLabels(Arrays.asList(new String[]{"id"}));
			Field molgenisPermission_role__field = new Field(molgenisPermission_entity, "role_", MolgenisFieldTypes.getType("xref"));
			molgenisPermission_role__field.setDescription("role_");
			molgenisPermission_role__field.setNillable(false);
			molgenisPermission_role__field.setXRefVariables("MolgenisRole", "id",Arrays.asList(new String[]{"name"}));
			molgenisPermission_entity.addField(molgenisPermission_role__field);
			Field molgenisPermission_entity_field = new Field(molgenisPermission_entity, "entity", MolgenisFieldTypes.getType("xref"));
			molgenisPermission_entity_field.setDescription("entity");
			molgenisPermission_entity_field.setNillable(false);
			molgenisPermission_entity_field.setXRefVariables("MolgenisEntity", "id",Arrays.asList(new String[]{"className"}));
			molgenisPermission_entity.addField(molgenisPermission_entity_field);
			Field molgenisPermission_permission_field = new Field(molgenisPermission_entity, "permission", MolgenisFieldTypes.getType("enum"));
			Vector<String> molgenisPermission_permission_field_enumoptions = new Vector<String>();
			molgenisPermission_permission_field_enumoptions.add("read");
			molgenisPermission_permission_field_enumoptions.add("write");
			molgenisPermission_permission_field_enumoptions.add("own");
			molgenisPermission_permission_field.setEnumOptions(molgenisPermission_permission_field_enumoptions);
			molgenisPermission_permission_field.setDescription("permission");
			molgenisPermission_permission_field.setNillable(false);
			molgenisPermission_entity.addField(molgenisPermission_permission_field);
			Field molgenisPermission_id_field = new Field(molgenisPermission_entity, "id", MolgenisFieldTypes.getType("int"));
			molgenisPermission_id_field.setAuto(true);
			molgenisPermission_id_field.setDescription("automatically generated id");
			molgenisPermission_id_field.setNillable(false);
			molgenisPermission_entity.addField(molgenisPermission_id_field);
			molgenisPermission_entity.addKey(Arrays.asList(new String[]{"id"}),false,"");
			molgenisPermission_entity.addKey(Arrays.asList(new String[]{"role_","entity","permission"}),false,"");
			
			
			//disabled validation, this means above must be perfect!
			//new MolgenisModelValidator();
			//MolgenisModelValidator.validate(this, new MolgenisOptions());

		} catch (MolgenisModelException e)
		{
			throw new DatabaseException(e);
		}
	}
}