/*
 * Created by: org.molgenis.generators.sql.MySqlCreateSubclassPerTableGen
 * Date: October 22, 2012
 */

/**********CREATE TABLES**********/
SET FOREIGN_KEY_CHECKS = 0; ##allows us to drop fkeyed tables

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

/*ontology implements nameable*/
DROP TABLE IF EXISTS Ontology;
CREATE TABLE Ontology (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, ontologyAccession VARCHAR(255) NULL
	, ontologyURI VARCHAR(255) NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*ontologyTerm implements nameable*/
DROP TABLE IF EXISTS OntologyTerm;
CREATE TABLE OntologyTerm (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, ontology INTEGER NULL
	, termAccession VARCHAR(255) NULL
	, definition VARCHAR(255) NULL
	, termPath VARCHAR(1024) NULL
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

/*molgenisRoleGroupLink implements identifiable*/
DROP TABLE IF EXISTS MolgenisRoleGroupLink;
CREATE TABLE MolgenisRoleGroupLink (
	id INTEGER NOT NULL AUTO_INCREMENT
	, group_ INTEGER NOT NULL
	, role_ INTEGER NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;

/*molgenisFile implements nameable*/
DROP TABLE IF EXISTS MolgenisFile;
CREATE TABLE MolgenisFile (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
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

/*molgenisPermission implements identifiable*/
DROP TABLE IF EXISTS MolgenisPermission;
CREATE TABLE MolgenisPermission (
	id INTEGER NOT NULL AUTO_INCREMENT
	, role_ INTEGER NOT NULL
	, entity INTEGER NOT NULL
	, permission ENUM('read','write','own') NOT NULL
	, PRIMARY KEY(id)
) CHARACTER SET utf8 COLLATE utf8_unicode_ci ENGINE=InnoDB;
SET FOREIGN_KEY_CHECKS = 1;

/**********ADD UNIQUE CONSTRANTS**********/
ALTER TABLE MolgenisRole ADD UNIQUE name(name);
ALTER TABLE Institute ADD UNIQUE name(name);
ALTER TABLE Ontology ADD UNIQUE name(name);
ALTER TABLE OntologyTerm ADD UNIQUE ontology_termAccession(ontology,termAccession);
ALTER TABLE OntologyTerm ADD UNIQUE ontology_name(ontology,name);
ALTER TABLE Person ADD UNIQUE FirstName_MidInitials_LastName(FirstName,MidInitials,LastName);
ALTER TABLE MolgenisRoleGroupLink ADD UNIQUE group__role_(group_,role_);
ALTER TABLE MolgenisFile ADD UNIQUE name(name);
ALTER TABLE RuntimeProperty ADD UNIQUE name(name);
ALTER TABLE Publication ADD UNIQUE name(name);
ALTER TABLE UseCase ADD UNIQUE UseCaseName(UseCaseName);
ALTER TABLE MolgenisEntity ADD UNIQUE className(className);
ALTER TABLE MolgenisEntity ADD UNIQUE name_type_(name,type_);
ALTER TABLE MolgenisPermission ADD UNIQUE role__entity_permission(role_,entity,permission);

/**********ADD FOREIGN KEYS**********/
ALTER TABLE MolgenisGroup ADD FOREIGN KEY (id) REFERENCES MolgenisRole (id) ON DELETE CASCADE;
ALTER TABLE Person ADD FOREIGN KEY (id) REFERENCES MolgenisRole (id) ON DELETE CASCADE;
ALTER TABLE MolgenisUser ADD FOREIGN KEY (id) REFERENCES Person (id) ON DELETE CASCADE;

ALTER TABLE OntologyTerm ADD FOREIGN KEY (ontology) REFERENCES Ontology (id) ON DELETE RESTRICT;
ALTER TABLE Person ADD FOREIGN KEY (Affiliation) REFERENCES Institute (id) ON DELETE RESTRICT;
ALTER TABLE Person ADD FOREIGN KEY (Roles) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE MolgenisRoleGroupLink ADD FOREIGN KEY (group_) REFERENCES MolgenisGroup (id) ON DELETE RESTRICT;
ALTER TABLE MolgenisRoleGroupLink ADD FOREIGN KEY (role_) REFERENCES MolgenisRole (id) ON DELETE RESTRICT;
ALTER TABLE Publication ADD FOREIGN KEY (PubmedID) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Publication ADD FOREIGN KEY (DOI) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE Publication ADD FOREIGN KEY (Status) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE MolgenisPermission ADD FOREIGN KEY (role_) REFERENCES MolgenisRole (id) ON DELETE RESTRICT;
ALTER TABLE MolgenisPermission ADD FOREIGN KEY (entity) REFERENCES MolgenisEntity (id) ON DELETE RESTRICT;

