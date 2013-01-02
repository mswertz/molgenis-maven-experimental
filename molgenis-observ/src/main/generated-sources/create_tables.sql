/*
 * Created by: org.molgenis.generators.sql.MySqlCreateSubclassPerTableGen
 * Date: October 11, 2012
 */

/**********CREATE TABLES**********/
SET FOREIGN_KEY_CHECKS = 0; ##allows us to drop fkeyed tables

/*ontology implements nameable*/
DROP TABLE IF EXISTS Ontology;
CREATE TABLE Ontology (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, ontologyAccession VARCHAR(255) NULL
	, ontologyURI VARCHAR(255) NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*species extends ontologyTerm*/
DROP TABLE IF EXISTS Species;
CREATE TABLE Species (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*alternateId extends ontologyTerm*/
DROP TABLE IF EXISTS AlternateId;
CREATE TABLE AlternateId (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*ontologyTerm implements nameable*/
DROP TABLE IF EXISTS OntologyTerm;
CREATE TABLE OntologyTerm (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, __Type ENUM('OntologyTerm','Species','AlternateId') NOT NULL
	, ontology INTEGER NULL
	, termAccession VARCHAR(255) NULL
	, definition VARCHAR(255) NULL
	, termPath VARCHAR(1024) NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*molgenisFile implements nameable*/
DROP TABLE IF EXISTS MolgenisFile;
CREATE TABLE MolgenisFile (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, __Type ENUM('MolgenisFile','ProtocolDocument') NOT NULL
	, Extension VARCHAR(8) NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*runtimeProperty implements nameable*/
DROP TABLE IF EXISTS RuntimeProperty;
CREATE TABLE RuntimeProperty (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, Value VARCHAR(127) NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*publication implements nameable*/
DROP TABLE IF EXISTS Publication;
CREATE TABLE Publication (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, PubmedID INTEGER NULL
	, DOI INTEGER NULL
	, authorList TEXT NULL
	, Title VARCHAR(255) NOT NULL
	, Status INTEGER NULL
	, Year VARCHAR(255) NULL
	, Journal VARCHAR(255) NULL
	, PRIMARY KEY(id)
	, INDEX (Title)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*useCase*/
DROP TABLE IF EXISTS UseCase;
CREATE TABLE UseCase (
	UseCaseId INTEGER NOT NULL AUTO_INCREMENT
	, UseCaseName VARCHAR(255) NOT NULL
	, SearchType VARCHAR(255) NOT NULL
	, PRIMARY KEY(UseCaseId)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*molgenisEntity implements identifiable*/
DROP TABLE IF EXISTS MolgenisEntity;
CREATE TABLE MolgenisEntity (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(255) NOT NULL
	, type_ VARCHAR(255) NOT NULL
	, className VARCHAR(255) NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*molgenisRole implements identifiable*/
DROP TABLE IF EXISTS MolgenisRole;
CREATE TABLE MolgenisRole (
	id INTEGER NOT NULL AUTO_INCREMENT
	, __Type ENUM('MolgenisRole','MolgenisGroup','MolgenisUser','Person') NOT NULL
	, name VARCHAR(255) NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*molgenisGroup extends molgenisRole*/
DROP TABLE IF EXISTS MolgenisGroup;
CREATE TABLE MolgenisGroup (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*institute implements contact*/
DROP TABLE IF EXISTS Institute;
CREATE TABLE Institute (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Address TEXT NULL
	, Phone VARCHAR(255) NULL
	, Email VARCHAR(255) NULL
	, Fax VARCHAR(255) NULL
	, tollFreePhone VARCHAR(255) NULL
	, City VARCHAR(255) NULL
	, Country VARCHAR(255) NULL
	, name VARCHAR(255) NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*person extends molgenisRole implements contact*/
DROP TABLE IF EXISTS Person;
CREATE TABLE Person (
	id INTEGER NOT NULL
	, Address TEXT NULL
	, Phone VARCHAR(255) NULL
	, Email VARCHAR(255) NULL
	, Fax VARCHAR(255) NULL
	, tollFreePhone VARCHAR(255) NULL
	, City VARCHAR(255) NULL
	, Country VARCHAR(255) NULL
	, FirstName VARCHAR(255) NULL
	, MidInitials VARCHAR(255) NULL
	, LastName VARCHAR(255) NULL
	, Title VARCHAR(255) NULL
	, Affiliation INTEGER NULL
	, Department VARCHAR(255) NULL
	, Roles INTEGER NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*investigation implements nameable,describable*/
DROP TABLE IF EXISTS Investigation;
CREATE TABLE Investigation (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, description TEXT NULL
	, startDate DATETIME NULL
	, endDate DATETIME NULL
	, accession VARCHAR(255) NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*observationElement implements investigationElement*/
DROP TABLE IF EXISTS ObservationElement;
CREATE TABLE ObservationElement (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, description TEXT NULL
	, Investigation INTEGER NULL
	, __Type ENUM('ObservationElement','Individual','Location','Panel','ObservationTarget','Measurement','ObservableFeature','Category') NOT NULL
	, label VARCHAR(255) NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*observationTarget extends observationElement*/
DROP TABLE IF EXISTS ObservationTarget;
CREATE TABLE ObservationTarget (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*observableFeature extends observationElement*/
DROP TABLE IF EXISTS ObservableFeature;
CREATE TABLE ObservableFeature (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*category extends observationElement*/
DROP TABLE IF EXISTS Category;
CREATE TABLE Category (
	code_string VARCHAR(255) NOT NULL
	, description TEXT NOT NULL
	, isMissing BOOL NOT NULL DEFAULT false
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*measurement extends observableFeature*/
DROP TABLE IF EXISTS Measurement;
CREATE TABLE Measurement (
	unit INTEGER NULL
	, dataType ENUM('xref','string','categorical','date','datetime','int','code','image','decimal','bool','file','log','data','exe') NOT NULL DEFAULT "string"
	, temporal BOOL NOT NULL DEFAULT false
	, description TEXT NULL
	, targettypeAllowedForRelation INTEGER NULL
	, panelLabelAllowedForRelation VARCHAR(255) NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*individual extends observationTarget*/
DROP TABLE IF EXISTS Individual;
CREATE TABLE Individual (
	Mother INTEGER NULL
	, Father INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*location extends observationTarget*/
DROP TABLE IF EXISTS Location;
CREATE TABLE Location (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*panel extends observationTarget*/
DROP TABLE IF EXISTS Panel;
CREATE TABLE Panel (
	Species INTEGER NULL
	, PanelType INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*molgenisUser extends person*/
DROP TABLE IF EXISTS MolgenisUser;
CREATE TABLE MolgenisUser (
	password_ VARCHAR(255) NOT NULL DEFAULT "secret"
	, activationCode VARCHAR(255) NULL
	, active BOOL NOT NULL DEFAULT false
	, superuser BOOL NOT NULL DEFAULT false
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*protocol implements investigationElement*/
DROP TABLE IF EXISTS Protocol;
CREATE TABLE Protocol (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, description TEXT NULL
	, Investigation INTEGER NULL
	, __Type ENUM('Protocol','Workflow') NOT NULL
	, ProtocolType INTEGER NULL
	, TargetFilter VARCHAR(255) NULL
	, Contact INTEGER NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*workflow extends protocol implements identifiable,nameable*/
DROP TABLE IF EXISTS Workflow;
CREATE TABLE Workflow (
	id INTEGER NOT NULL
	, name VARCHAR(127) NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*protocolApplication implements investigationElement*/
DROP TABLE IF EXISTS ProtocolApplication;
CREATE TABLE ProtocolApplication (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, description TEXT NULL
	, Investigation INTEGER NULL
	, time DATETIME NOT NULL
	, protocol INTEGER NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*observedValue implements observation*/
DROP TABLE IF EXISTS ObservedValue;
CREATE TABLE ObservedValue (
	id INTEGER NOT NULL AUTO_INCREMENT
	, Investigation INTEGER NULL
	, protocolApplication INTEGER NULL
	, Feature INTEGER NOT NULL
	, Target INTEGER NOT NULL
	, ontologyReference INTEGER NULL
	, value VARCHAR(255) NULL
	, relation INTEGER NULL
	, time DATETIME NULL
	, endtime DATETIME NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*protocolDocument extends molgenisFile*/
DROP TABLE IF EXISTS ProtocolDocument;
CREATE TABLE ProtocolDocument (
	protocol INTEGER NOT NULL
	, document VARCHAR(1024) NOT NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*workflowElement implements nameable*/
DROP TABLE IF EXISTS WorkflowElement;
CREATE TABLE WorkflowElement (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, Workflow INTEGER NOT NULL
	, protocol INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*workflowElementParameter implements identifiable*/
DROP TABLE IF EXISTS WorkflowElementParameter;
CREATE TABLE WorkflowElementParameter (
	id INTEGER NOT NULL AUTO_INCREMENT
	, WorkflowElement INTEGER NOT NULL
	, Parameter INTEGER NOT NULL
	, Value VARCHAR(255) NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*molgenisRoleGroupLink implements identifiable*/
DROP TABLE IF EXISTS MolgenisRoleGroupLink;
CREATE TABLE MolgenisRoleGroupLink (
	id INTEGER NOT NULL AUTO_INCREMENT
	, group_ INTEGER NOT NULL
	, role_ INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*molgenisPermission implements identifiable*/
DROP TABLE IF EXISTS MolgenisPermission;
CREATE TABLE MolgenisPermission (
	id INTEGER NOT NULL AUTO_INCREMENT
	, role_ INTEGER NOT NULL
	, entity INTEGER NOT NULL
	, permission ENUM('read','write','own') NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*observationElement_ontolo12449*/
DROP TABLE IF EXISTS ObservationElement_ontolo12449;
CREATE TABLE ObservationElement_ontolo12449 (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, ontologyReference INTEGER NOT NULL
	, InvestigationElement INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*observationElement_AlternateId*/
DROP TABLE IF EXISTS ObservationElement_AlternateId;
CREATE TABLE ObservationElement_AlternateId (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, AlternateId INTEGER NOT NULL
	, ObservationElement INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*measurement_categories*/
DROP TABLE IF EXISTS Measurement_categories;
CREATE TABLE Measurement_categories (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, categories INTEGER NOT NULL
	, Measurement INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*panel_Individuals*/
DROP TABLE IF EXISTS Panel_Individuals;
CREATE TABLE Panel_Individuals (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, Individuals INTEGER NOT NULL
	, Panel INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*panel_FounderPanels*/
DROP TABLE IF EXISTS Panel_FounderPanels;
CREATE TABLE Panel_FounderPanels (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, FounderPanels INTEGER NOT NULL
	, Panel INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*investigation_contacts*/
DROP TABLE IF EXISTS Investigation_contacts;
CREATE TABLE Investigation_contacts (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, contacts INTEGER NOT NULL
	, Investigation INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*protocol_ontologyReference*/
DROP TABLE IF EXISTS Protocol_ontologyReference;
CREATE TABLE Protocol_ontologyReference (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, ontologyReference INTEGER NOT NULL
	, InvestigationElement INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*protocol_Features*/
DROP TABLE IF EXISTS Protocol_Features;
CREATE TABLE Protocol_Features (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, Features INTEGER NOT NULL
	, Protocol INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*protocol_subprotocols*/
DROP TABLE IF EXISTS Protocol_subprotocols;
CREATE TABLE Protocol_subprotocols (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, subprotocols INTEGER NOT NULL
	, Protocol INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*protocolApplication_ontol11768*/
DROP TABLE IF EXISTS ProtocolApplication_ontol11768;
CREATE TABLE ProtocolApplication_ontol11768 (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, ontologyReference INTEGER NOT NULL
	, InvestigationElement INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*protocolApplication_Performer*/
DROP TABLE IF EXISTS ProtocolApplication_Performer;
CREATE TABLE ProtocolApplication_Performer (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, Performer INTEGER NOT NULL
	, ProtocolApplication INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*workflowElement_PreviousSteps*/
DROP TABLE IF EXISTS WorkflowElement_PreviousSteps;
CREATE TABLE WorkflowElement_PreviousSteps (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, PreviousSteps INTEGER NOT NULL
	, WorkflowElement INTEGER NOT NULL
	, PRIMARY KEY(autoid)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;
SET FOREIGN_KEY_CHECKS = 1;

/**********ADD UNIQUE CONSTRANTS**********/
ALTER TABLE Ontology ADD UNIQUE name(name);
ALTER TABLE OntologyTerm ADD UNIQUE ontology_termAccession(ontology,termAccession);
ALTER TABLE OntologyTerm ADD UNIQUE ontology_name(ontology,name);
ALTER TABLE MolgenisFile ADD UNIQUE name(name);
ALTER TABLE RuntimeProperty ADD UNIQUE name(name);
ALTER TABLE Publication ADD UNIQUE name(name);
ALTER TABLE UseCase ADD UNIQUE UseCaseName(UseCaseName);
ALTER TABLE MolgenisEntity ADD UNIQUE className(className);
ALTER TABLE MolgenisEntity ADD UNIQUE name_type_(name,type_);
ALTER TABLE MolgenisRole ADD UNIQUE name(name);
ALTER TABLE Institute ADD UNIQUE name(name);
ALTER TABLE Person ADD UNIQUE FirstName_MidInitials_LastName(FirstName,MidInitials,LastName);
ALTER TABLE Investigation ADD UNIQUE name(name);
ALTER TABLE ObservationElement ADD UNIQUE name_Investigation(name,Investigation);
ALTER TABLE ObservationElement ADD UNIQUE name(name);
ALTER TABLE Protocol ADD UNIQUE name_Investigation(name,Investigation);
ALTER TABLE Workflow ADD UNIQUE name(name);
ALTER TABLE ProtocolApplication ADD UNIQUE name_Investigation(name,Investigation);
ALTER TABLE WorkflowElement ADD UNIQUE name(name);
ALTER TABLE WorkflowElementParameter ADD UNIQUE WorkflowElement_Parameter(WorkflowElement,Parameter);
ALTER TABLE MolgenisRoleGroupLink ADD UNIQUE group__role_(group_,role_);
ALTER TABLE MolgenisPermission ADD UNIQUE role__entity_permission(role_,entity,permission);
ALTER TABLE ObservationElement_ontolo12449 ADD UNIQUE ontologyReference_InvestigationElement(ontologyReference,InvestigationElement);
ALTER TABLE ObservationElement_AlternateId ADD UNIQUE AlternateId_ObservationElement(AlternateId,ObservationElement);
ALTER TABLE Measurement_categories ADD UNIQUE categories_Measurement(categories,Measurement);
ALTER TABLE Panel_Individuals ADD UNIQUE Individuals_Panel(Individuals,Panel);
ALTER TABLE Panel_FounderPanels ADD UNIQUE FounderPanels_Panel(FounderPanels,Panel);
ALTER TABLE Investigation_contacts ADD UNIQUE contacts_Investigation(contacts,Investigation);
ALTER TABLE Protocol_ontologyReference ADD UNIQUE ontologyReference_InvestigationElement(ontologyReference,InvestigationElement);
ALTER TABLE Protocol_Features ADD UNIQUE Features_Protocol(Features,Protocol);
ALTER TABLE Protocol_subprotocols ADD UNIQUE subprotocols_Protocol(subprotocols,Protocol);
ALTER TABLE ProtocolApplication_ontol11768 ADD UNIQUE ontologyReference_InvestigationElement(ontologyReference,InvestigationElement);
ALTER TABLE ProtocolApplication_Performer ADD UNIQUE Performer_ProtocolApplication(Performer,ProtocolApplication);
ALTER TABLE WorkflowElement_PreviousSteps ADD UNIQUE PreviousSteps_WorkflowElement(PreviousSteps,WorkflowElement);

/**********ADD FOREIGN KEYS**********/
ALTER TABLE Species ADD FOREIGN KEY (id) REFERENCES OntologyTerm (id) ON DELETE CASCADE;
ALTER TABLE AlternateId ADD FOREIGN KEY (id) REFERENCES OntologyTerm (id) ON DELETE CASCADE;
ALTER TABLE MolgenisGroup ADD FOREIGN KEY (id) REFERENCES MolgenisRole (id) ON DELETE CASCADE;
ALTER TABLE Person ADD FOREIGN KEY (id) REFERENCES MolgenisRole (id) ON DELETE CASCADE;
ALTER TABLE ObservationTarget ADD FOREIGN KEY (id) REFERENCES ObservationElement (id) ON DELETE CASCADE;
ALTER TABLE ObservableFeature ADD FOREIGN KEY (id) REFERENCES ObservationElement (id) ON DELETE CASCADE;
ALTER TABLE Category ADD FOREIGN KEY (id) REFERENCES ObservationElement (id) ON DELETE CASCADE;
ALTER TABLE Measurement ADD FOREIGN KEY (id) REFERENCES ObservableFeature (id) ON DELETE CASCADE;
ALTER TABLE Individual ADD FOREIGN KEY (id) REFERENCES ObservationTarget (id) ON DELETE CASCADE;
ALTER TABLE Location ADD FOREIGN KEY (id) REFERENCES ObservationTarget (id) ON DELETE CASCADE;
ALTER TABLE Panel ADD FOREIGN KEY (id) REFERENCES ObservationTarget (id) ON DELETE CASCADE;
ALTER TABLE MolgenisUser ADD FOREIGN KEY (id) REFERENCES Person (id) ON DELETE CASCADE;
ALTER TABLE Workflow ADD FOREIGN KEY (id) REFERENCES Protocol (id) ON DELETE CASCADE;
ALTER TABLE ProtocolDocument ADD FOREIGN KEY (id) REFERENCES MolgenisFile (id) ON DELETE CASCADE;

ALTER TABLE OntologyTerm ADD FOREIGN KEY (ontology) REFERENCES Ontology (id) ON DELETE RESTRICT;
ALTER TABLE Publication ADD FOREIGN KEY (PubmedID) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Publication ADD FOREIGN KEY (DOI) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Publication ADD FOREIGN KEY (Status) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Person ADD FOREIGN KEY (Affiliation) REFERENCES Institute (id) ON DELETE RESTRICT;
ALTER TABLE Person ADD FOREIGN KEY (Roles) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE ObservationElement ADD FOREIGN KEY (Investigation) REFERENCES Investigation (id) ON DELETE RESTRICT;
ALTER TABLE Measurement ADD FOREIGN KEY (unit) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Measurement ADD FOREIGN KEY (targettypeAllowedForRelation) REFERENCES MolgenisEntity (id) ON DELETE RESTRICT;
ALTER TABLE Individual ADD FOREIGN KEY (Mother) REFERENCES Individual (id) ON DELETE RESTRICT;
ALTER TABLE Individual ADD FOREIGN KEY (Father) REFERENCES Individual (id) ON DELETE RESTRICT;
ALTER TABLE Panel ADD FOREIGN KEY (Species) REFERENCES Species (id) ON DELETE RESTRICT;
ALTER TABLE Panel ADD FOREIGN KEY (PanelType) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Protocol ADD FOREIGN KEY (Investigation) REFERENCES Investigation (id) ON DELETE RESTRICT;
ALTER TABLE Protocol ADD FOREIGN KEY (ProtocolType) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Protocol ADD FOREIGN KEY (Contact) REFERENCES Person (id) ON DELETE RESTRICT;
ALTER TABLE ProtocolApplication ADD FOREIGN KEY (Investigation) REFERENCES Investigation (id) ON DELETE RESTRICT;
ALTER TABLE ProtocolApplication ADD FOREIGN KEY (protocol) REFERENCES Protocol (id) ON DELETE RESTRICT;
ALTER TABLE ObservedValue ADD FOREIGN KEY (Investigation) REFERENCES Investigation (id) ON DELETE RESTRICT;
ALTER TABLE ObservedValue ADD FOREIGN KEY (protocolApplication) REFERENCES ProtocolApplication (id) ON DELETE RESTRICT;
ALTER TABLE ObservedValue ADD FOREIGN KEY (Feature) REFERENCES ObservationElement (id) ON DELETE RESTRICT;
ALTER TABLE ObservedValue ADD FOREIGN KEY (Target) REFERENCES ObservationElement (id) ON DELETE RESTRICT;
ALTER TABLE ObservedValue ADD FOREIGN KEY (ontologyReference) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE ObservedValue ADD FOREIGN KEY (relation) REFERENCES ObservationElement (id) ON DELETE RESTRICT;
ALTER TABLE ProtocolDocument ADD FOREIGN KEY (protocol) REFERENCES Protocol (id) ON DELETE RESTRICT;
ALTER TABLE WorkflowElement ADD FOREIGN KEY (Workflow) REFERENCES Workflow (id) ON DELETE RESTRICT;
ALTER TABLE WorkflowElement ADD FOREIGN KEY (protocol) REFERENCES Protocol (id) ON DELETE RESTRICT;
ALTER TABLE WorkflowElementParameter ADD FOREIGN KEY (WorkflowElement) REFERENCES WorkflowElement (id) ON DELETE RESTRICT;
ALTER TABLE WorkflowElementParameter ADD FOREIGN KEY (Parameter) REFERENCES ObservableFeature (id) ON DELETE RESTRICT;
ALTER TABLE MolgenisRoleGroupLink ADD FOREIGN KEY (group_) REFERENCES MolgenisGroup (id) ON DELETE RESTRICT;
ALTER TABLE MolgenisRoleGroupLink ADD FOREIGN KEY (role_) REFERENCES MolgenisRole (id) ON DELETE RESTRICT;
ALTER TABLE MolgenisPermission ADD FOREIGN KEY (role_) REFERENCES MolgenisRole (id) ON DELETE RESTRICT;
ALTER TABLE MolgenisPermission ADD FOREIGN KEY (entity) REFERENCES MolgenisEntity (id) ON DELETE RESTRICT;
ALTER TABLE ObservationElement_ontolo12449 ADD FOREIGN KEY (ontologyReference) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE ObservationElement_ontolo12449 ADD FOREIGN KEY (InvestigationElement) REFERENCES ObservationElement (id) ON DELETE RESTRICT;
ALTER TABLE ObservationElement_AlternateId ADD FOREIGN KEY (AlternateId) REFERENCES AlternateId (id) ON DELETE RESTRICT;
ALTER TABLE ObservationElement_AlternateId ADD FOREIGN KEY (ObservationElement) REFERENCES ObservationElement (id) ON DELETE RESTRICT;
ALTER TABLE Measurement_categories ADD FOREIGN KEY (categories) REFERENCES Category (id) ON DELETE RESTRICT;
ALTER TABLE Measurement_categories ADD FOREIGN KEY (Measurement) REFERENCES Measurement (id) ON DELETE RESTRICT;
ALTER TABLE Panel_Individuals ADD FOREIGN KEY (Individuals) REFERENCES Individual (id) ON DELETE RESTRICT;
ALTER TABLE Panel_Individuals ADD FOREIGN KEY (Panel) REFERENCES Panel (id) ON DELETE RESTRICT;
ALTER TABLE Panel_FounderPanels ADD FOREIGN KEY (FounderPanels) REFERENCES Panel (id) ON DELETE RESTRICT;
ALTER TABLE Panel_FounderPanels ADD FOREIGN KEY (Panel) REFERENCES Panel (id) ON DELETE RESTRICT;
ALTER TABLE Investigation_contacts ADD FOREIGN KEY (contacts) REFERENCES Person (id) ON DELETE RESTRICT;
ALTER TABLE Investigation_contacts ADD FOREIGN KEY (Investigation) REFERENCES Investigation (id) ON DELETE RESTRICT;
ALTER TABLE Protocol_ontologyReference ADD FOREIGN KEY (ontologyReference) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Protocol_ontologyReference ADD FOREIGN KEY (InvestigationElement) REFERENCES Protocol (id) ON DELETE RESTRICT;
ALTER TABLE Protocol_Features ADD FOREIGN KEY (Features) REFERENCES ObservableFeature (id) ON DELETE RESTRICT;
ALTER TABLE Protocol_Features ADD FOREIGN KEY (Protocol) REFERENCES Protocol (id) ON DELETE RESTRICT;
ALTER TABLE Protocol_subprotocols ADD FOREIGN KEY (subprotocols) REFERENCES Protocol (id) ON DELETE RESTRICT;
ALTER TABLE Protocol_subprotocols ADD FOREIGN KEY (Protocol) REFERENCES Protocol (id) ON DELETE RESTRICT;
ALTER TABLE ProtocolApplication_ontol11768 ADD FOREIGN KEY (ontologyReference) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE ProtocolApplication_ontol11768 ADD FOREIGN KEY (InvestigationElement) REFERENCES ProtocolApplication (id) ON DELETE RESTRICT;
ALTER TABLE ProtocolApplication_Performer ADD FOREIGN KEY (Performer) REFERENCES Person (id) ON DELETE RESTRICT;
ALTER TABLE ProtocolApplication_Performer ADD FOREIGN KEY (ProtocolApplication) REFERENCES ProtocolApplication (id) ON DELETE RESTRICT;
ALTER TABLE WorkflowElement_PreviousSteps ADD FOREIGN KEY (PreviousSteps) REFERENCES WorkflowElement (id) ON DELETE RESTRICT;
ALTER TABLE WorkflowElement_PreviousSteps ADD FOREIGN KEY (WorkflowElement) REFERENCES WorkflowElement (id) ON DELETE RESTRICT;

