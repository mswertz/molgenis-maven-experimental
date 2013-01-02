/*
 * Created by: org.molgenis.generators.sql.MySqlAlterSubclassPerTableGen
 * Date: October 11, 2012
 */

/**********CREATE TABLES**********/
SET FOREIGN_KEY_CHECKS = 0; ##allows us to drop fkeyed tables

/*ontology implements nameable*/
#create the table if not exists
CREATE TABLE Ontology (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, ontologyAccession VARCHAR(255) NULL
	, ontologyURI VARCHAR(255) NULL
	, PRIMARY KEY(id)
	, UNIQUE(name)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Ontology MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Ontology ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Ontology , MODIFY COLUMN name VARCHAR(127) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Ontology , ADD COLUMN name VARCHAR(127) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Ontology , MODIFY COLUMN ontologyAccession VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Ontology , ADD COLUMN ontologyAccession VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Ontology , MODIFY COLUMN ontologyURI VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Ontology , ADD COLUMN ontologyURI VARCHAR(255) NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*species extends ontologyTerm*/
#create the table if not exists
CREATE TABLE Species (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Species MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Species ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*alternateId extends ontologyTerm*/
#create the table if not exists
CREATE TABLE AlternateId (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE AlternateId MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE AlternateId ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*ontologyTerm implements nameable*/
#create the table if not exists
CREATE TABLE OntologyTerm (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, __Type ENUM('OntologyTerm','Species','AlternateId') NOT NULL
	, ontology INTEGER NULL
	, termAccession VARCHAR(255) NULL
	, definition VARCHAR(255) NULL
	, termPath VARCHAR(1024) NULL
	, PRIMARY KEY(id)
	, UNIQUE(ontology,termAccession)
	, UNIQUE(ontology,name)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE OntologyTerm MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE OntologyTerm ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE OntologyTerm , MODIFY COLUMN name VARCHAR(127) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE OntologyTerm , ADD COLUMN name VARCHAR(127) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE OntologyTerm , MODIFY COLUMN __Type ENUM('OntologyTerm','Species','AlternateId') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE OntologyTerm , ADD COLUMN __Type ENUM('OntologyTerm','Species','AlternateId') NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE OntologyTerm , MODIFY COLUMN ontology INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE OntologyTerm , ADD COLUMN ontology INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE OntologyTerm , MODIFY COLUMN termAccession VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE OntologyTerm , ADD COLUMN termAccession VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE OntologyTerm , MODIFY COLUMN definition VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE OntologyTerm , ADD COLUMN definition VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE OntologyTerm , MODIFY COLUMN termPath VARCHAR(1024) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE OntologyTerm , ADD COLUMN termPath VARCHAR(1024) NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*molgenisFile implements nameable*/
#create the table if not exists
CREATE TABLE MolgenisFile (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, __Type ENUM('MolgenisFile','ProtocolDocument') NOT NULL
	, Extension VARCHAR(8) NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(name)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisFile MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisFile ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisFile , MODIFY COLUMN name VARCHAR(127) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisFile , ADD COLUMN name VARCHAR(127) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisFile , MODIFY COLUMN __Type ENUM('MolgenisFile','ProtocolDocument') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisFile , ADD COLUMN __Type ENUM('MolgenisFile','ProtocolDocument') NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisFile , MODIFY COLUMN Extension VARCHAR(8) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisFile , ADD COLUMN Extension VARCHAR(8) NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*runtimeProperty implements nameable*/
#create the table if not exists
CREATE TABLE RuntimeProperty (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, Value VARCHAR(127) NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(name)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE RuntimeProperty MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE RuntimeProperty ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE RuntimeProperty , MODIFY COLUMN name VARCHAR(127) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE RuntimeProperty , ADD COLUMN name VARCHAR(127) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE RuntimeProperty , MODIFY COLUMN Value VARCHAR(127) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE RuntimeProperty , ADD COLUMN Value VARCHAR(127) NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*publication implements nameable*/
#create the table if not exists
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
	, UNIQUE(name)
	, INDEX (Title)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Publication MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Publication ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Publication , MODIFY COLUMN name VARCHAR(127) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Publication , ADD COLUMN name VARCHAR(127) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Publication , MODIFY COLUMN PubmedID INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Publication , ADD COLUMN PubmedID INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Publication , MODIFY COLUMN DOI INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Publication , ADD COLUMN DOI INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Publication , MODIFY COLUMN authorList TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Publication , ADD COLUMN authorList TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Publication , MODIFY COLUMN Title VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Publication , ADD COLUMN Title VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Publication , MODIFY COLUMN Status INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Publication , ADD COLUMN Status INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Publication , MODIFY COLUMN Year VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Publication , ADD COLUMN Year VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Publication , MODIFY COLUMN Journal VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Publication , ADD COLUMN Journal VARCHAR(255) NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*useCase*/
#create the table if not exists
CREATE TABLE UseCase (
	UseCaseId INTEGER NOT NULL AUTO_INCREMENT
	, UseCaseName VARCHAR(255) NOT NULL
	, SearchType VARCHAR(255) NOT NULL
	, PRIMARY KEY(UseCaseId)
	, UNIQUE(UseCaseName)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE UseCase MODIFY COLUMN UseCaseId INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE UseCase ADD COLUMN UseCaseId INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE UseCase , MODIFY COLUMN UseCaseName VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE UseCase , ADD COLUMN UseCaseName VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE UseCase , MODIFY COLUMN SearchType VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE UseCase , ADD COLUMN SearchType VARCHAR(255) NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*molgenisEntity implements identifiable*/
#create the table if not exists
CREATE TABLE MolgenisEntity (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(255) NOT NULL
	, type_ VARCHAR(255) NOT NULL
	, className VARCHAR(255) NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(className)
	, UNIQUE(name,type_)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisEntity MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisEntity ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisEntity , MODIFY COLUMN name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisEntity , ADD COLUMN name VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisEntity , MODIFY COLUMN type_ VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisEntity , ADD COLUMN type_ VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisEntity , MODIFY COLUMN className VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisEntity , ADD COLUMN className VARCHAR(255) NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*molgenisRole implements identifiable*/
#create the table if not exists
CREATE TABLE MolgenisRole (
	id INTEGER NOT NULL AUTO_INCREMENT
	, __Type ENUM('MolgenisRole','MolgenisGroup','MolgenisUser','Person') NOT NULL
	, name VARCHAR(255) NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(name)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisRole MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisRole ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisRole , MODIFY COLUMN __Type ENUM('MolgenisRole','MolgenisGroup','MolgenisUser','Person') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisRole , ADD COLUMN __Type ENUM('MolgenisRole','MolgenisGroup','MolgenisUser','Person') NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisRole , MODIFY COLUMN name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisRole , ADD COLUMN name VARCHAR(255) NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*molgenisGroup extends molgenisRole*/
#create the table if not exists
CREATE TABLE MolgenisGroup (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisGroup MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisGroup ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*institute implements contact*/
#create the table if not exists
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
	, UNIQUE(name)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute , MODIFY COLUMN Address TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute , ADD COLUMN Address TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute , MODIFY COLUMN Phone VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute , ADD COLUMN Phone VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute , MODIFY COLUMN Email VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute , ADD COLUMN Email VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute , MODIFY COLUMN Fax VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute , ADD COLUMN Fax VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute , MODIFY COLUMN tollFreePhone VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute , ADD COLUMN tollFreePhone VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute , MODIFY COLUMN City VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute , ADD COLUMN City VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute , MODIFY COLUMN Country VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute , ADD COLUMN Country VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Institute , MODIFY COLUMN name VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Institute , ADD COLUMN name VARCHAR(255) NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*person extends molgenisRole implements contact*/
#create the table if not exists
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
	, UNIQUE(FirstName,MidInitials,LastName)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN Address TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN Address TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN Phone VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN Phone VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN Email VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN Email VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN Fax VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN Fax VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN tollFreePhone VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN tollFreePhone VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN City VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN City VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN Country VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN Country VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN FirstName VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN FirstName VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN MidInitials VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN MidInitials VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN LastName VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN LastName VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN Title VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN Title VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN Affiliation INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN Affiliation INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN Department VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN Department VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Person , MODIFY COLUMN Roles INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Person , ADD COLUMN Roles INTEGER NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*investigation implements nameable,describable*/
#create the table if not exists
CREATE TABLE Investigation (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, description TEXT NULL
	, startDate DATETIME NULL
	, endDate DATETIME NULL
	, accession VARCHAR(255) NULL
	, PRIMARY KEY(id)
	, UNIQUE(name)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation , MODIFY COLUMN name VARCHAR(127) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation , ADD COLUMN name VARCHAR(127) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation , MODIFY COLUMN description TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation , ADD COLUMN description TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation , MODIFY COLUMN startDate DATETIME NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation , ADD COLUMN startDate DATETIME NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation , MODIFY COLUMN endDate DATETIME NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation , ADD COLUMN endDate DATETIME NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation , MODIFY COLUMN accession VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation , ADD COLUMN accession VARCHAR(255) NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*observationElement implements investigationElement*/
#create the table if not exists
CREATE TABLE ObservationElement (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, description TEXT NULL
	, Investigation INTEGER NULL
	, __Type ENUM('ObservationElement','Individual','Location','Panel','ObservationTarget','Measurement','ObservableFeature','Category') NOT NULL
	, label VARCHAR(255) NULL
	, PRIMARY KEY(id)
	, UNIQUE(name,Investigation)
	, UNIQUE(name)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationElement MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationElement ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationElement , MODIFY COLUMN name VARCHAR(127) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationElement , ADD COLUMN name VARCHAR(127) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationElement , MODIFY COLUMN description TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationElement , ADD COLUMN description TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationElement , MODIFY COLUMN Investigation INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationElement , ADD COLUMN Investigation INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationElement , MODIFY COLUMN __Type ENUM('ObservationElement','Individual','Location','Panel','ObservationTarget','Measurement','ObservableFeature','Category') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationElement , ADD COLUMN __Type ENUM('ObservationElement','Individual','Location','Panel','ObservationTarget','Measurement','ObservableFeature','Category') NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationElement , MODIFY COLUMN label VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationElement , ADD COLUMN label VARCHAR(255) NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*observationTarget extends observationElement*/
#create the table if not exists
CREATE TABLE ObservationTarget (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationTarget MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationTarget ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*observableFeature extends observationElement*/
#create the table if not exists
CREATE TABLE ObservableFeature (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservableFeature MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservableFeature ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*category extends observationElement*/
#create the table if not exists
CREATE TABLE Category (
	code_string VARCHAR(255) NOT NULL
	, description TEXT NOT NULL
	, isMissing BOOL NOT NULL DEFAULT false
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Category MODIFY COLUMN code_string VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Category ADD COLUMN code_string VARCHAR(255) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Category , MODIFY COLUMN description TEXT NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Category , ADD COLUMN description TEXT NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Category , MODIFY COLUMN isMissing BOOL NOT NULL DEFAULT false IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Category , ADD COLUMN isMissing BOOL NOT NULL DEFAULT false IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Category , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Category , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*measurement extends observableFeature*/
#create the table if not exists
CREATE TABLE Measurement (
	unit INTEGER NULL
	, dataType ENUM('xref','string','categorical','date','datetime','int','code','image','decimal','bool','file','log','data','exe') NOT NULL DEFAULT "string"
	, temporal BOOL NOT NULL DEFAULT false
	, description TEXT NULL
	, targettypeAllowedForRelation INTEGER NULL
	, panelLabelAllowedForRelation VARCHAR(255) NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Measurement MODIFY COLUMN unit INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Measurement ADD COLUMN unit INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Measurement , MODIFY COLUMN dataType ENUM('xref','string','categorical','date','datetime','int','code','image','decimal','bool','file','log','data','exe') NOT NULL DEFAULT "string" IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Measurement , ADD COLUMN dataType ENUM('xref','string','categorical','date','datetime','int','code','image','decimal','bool','file','log','data','exe') NOT NULL DEFAULT "string" IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Measurement , MODIFY COLUMN temporal BOOL NOT NULL DEFAULT false IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Measurement , ADD COLUMN temporal BOOL NOT NULL DEFAULT false IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Measurement , MODIFY COLUMN description TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Measurement , ADD COLUMN description TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Measurement , MODIFY COLUMN targettypeAllowedForRelation INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Measurement , ADD COLUMN targettypeAllowedForRelation INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Measurement , MODIFY COLUMN panelLabelAllowedForRelation VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Measurement , ADD COLUMN panelLabelAllowedForRelation VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Measurement , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Measurement , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*individual extends observationTarget*/
#create the table if not exists
CREATE TABLE Individual (
	Mother INTEGER NULL
	, Father INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Individual MODIFY COLUMN Mother INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Individual ADD COLUMN Mother INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Individual , MODIFY COLUMN Father INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Individual , ADD COLUMN Father INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Individual , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Individual , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*location extends observationTarget*/
#create the table if not exists
CREATE TABLE Location (
	id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Location MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Location ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*panel extends observationTarget*/
#create the table if not exists
CREATE TABLE Panel (
	Species INTEGER NULL
	, PanelType INTEGER NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel MODIFY COLUMN Species INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel ADD COLUMN Species INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel , MODIFY COLUMN PanelType INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel , ADD COLUMN PanelType INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*molgenisUser extends person*/
#create the table if not exists
CREATE TABLE MolgenisUser (
	password_ VARCHAR(255) NOT NULL DEFAULT "secret"
	, activationCode VARCHAR(255) NULL
	, active BOOL NOT NULL DEFAULT false
	, superuser BOOL NOT NULL DEFAULT false
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisUser MODIFY COLUMN password_ VARCHAR(255) NOT NULL DEFAULT "secret" IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisUser ADD COLUMN password_ VARCHAR(255) NOT NULL DEFAULT "secret" IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisUser , MODIFY COLUMN activationCode VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisUser , ADD COLUMN activationCode VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisUser , MODIFY COLUMN active BOOL NOT NULL DEFAULT false IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisUser , ADD COLUMN active BOOL NOT NULL DEFAULT false IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisUser , MODIFY COLUMN superuser BOOL NOT NULL DEFAULT false IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisUser , ADD COLUMN superuser BOOL NOT NULL DEFAULT false IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisUser , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisUser , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*protocol implements investigationElement*/
#create the table if not exists
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
	, UNIQUE(name,Investigation)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol , MODIFY COLUMN name VARCHAR(127) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol , ADD COLUMN name VARCHAR(127) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol , MODIFY COLUMN description TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol , ADD COLUMN description TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol , MODIFY COLUMN Investigation INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol , ADD COLUMN Investigation INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol , MODIFY COLUMN __Type ENUM('Protocol','Workflow') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol , ADD COLUMN __Type ENUM('Protocol','Workflow') NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol , MODIFY COLUMN ProtocolType INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol , ADD COLUMN ProtocolType INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol , MODIFY COLUMN TargetFilter VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol , ADD COLUMN TargetFilter VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol , MODIFY COLUMN Contact INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol , ADD COLUMN Contact INTEGER NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*workflow extends protocol implements identifiable,nameable*/
#create the table if not exists
CREATE TABLE Workflow (
	id INTEGER NOT NULL
	, name VARCHAR(127) NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(name)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Workflow MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Workflow ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Workflow , MODIFY COLUMN name VARCHAR(127) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Workflow , ADD COLUMN name VARCHAR(127) NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*protocolApplication implements investigationElement*/
#create the table if not exists
CREATE TABLE ProtocolApplication (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, description TEXT NULL
	, Investigation INTEGER NULL
	, time DATETIME NOT NULL
	, protocol INTEGER NULL
	, PRIMARY KEY(id)
	, UNIQUE(name,Investigation)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProtocolApplication MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProtocolApplication ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProtocolApplication , MODIFY COLUMN name VARCHAR(127) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProtocolApplication , ADD COLUMN name VARCHAR(127) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProtocolApplication , MODIFY COLUMN description TEXT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProtocolApplication , ADD COLUMN description TEXT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProtocolApplication , MODIFY COLUMN Investigation INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProtocolApplication , ADD COLUMN Investigation INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProtocolApplication , MODIFY COLUMN time DATETIME NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProtocolApplication , ADD COLUMN time DATETIME NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProtocolApplication , MODIFY COLUMN protocol INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProtocolApplication , ADD COLUMN protocol INTEGER NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*observedValue implements observation*/
#create the table if not exists
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
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue , MODIFY COLUMN Investigation INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue , ADD COLUMN Investigation INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue , MODIFY COLUMN protocolApplication INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue , ADD COLUMN protocolApplication INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue , MODIFY COLUMN Feature INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue , ADD COLUMN Feature INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue , MODIFY COLUMN Target INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue , ADD COLUMN Target INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue , MODIFY COLUMN ontologyReference INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue , ADD COLUMN ontologyReference INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue , MODIFY COLUMN value VARCHAR(255) NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue , ADD COLUMN value VARCHAR(255) NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue , MODIFY COLUMN relation INTEGER NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue , ADD COLUMN relation INTEGER NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue , MODIFY COLUMN time DATETIME NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue , ADD COLUMN time DATETIME NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservedValue , MODIFY COLUMN endtime DATETIME NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservedValue , ADD COLUMN endtime DATETIME NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*protocolDocument extends molgenisFile*/
#create the table if not exists
CREATE TABLE ProtocolDocument (
	protocol INTEGER NOT NULL
	, document VARCHAR(1024) NOT NULL
	, id INTEGER NOT NULL
	, PRIMARY KEY(id)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProtocolDocument MODIFY COLUMN protocol INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProtocolDocument ADD COLUMN protocol INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProtocolDocument , MODIFY COLUMN document VARCHAR(1024) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProtocolDocument , ADD COLUMN document VARCHAR(1024) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProtocolDocument , MODIFY COLUMN id INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProtocolDocument , ADD COLUMN id INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*workflowElement implements nameable*/
#create the table if not exists
CREATE TABLE WorkflowElement (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
	, Workflow INTEGER NOT NULL
	, protocol INTEGER NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(name)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE WorkflowElement MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE WorkflowElement ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE WorkflowElement , MODIFY COLUMN name VARCHAR(127) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE WorkflowElement , ADD COLUMN name VARCHAR(127) NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE WorkflowElement , MODIFY COLUMN Workflow INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE WorkflowElement , ADD COLUMN Workflow INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE WorkflowElement , MODIFY COLUMN protocol INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE WorkflowElement , ADD COLUMN protocol INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*workflowElementParameter implements identifiable*/
#create the table if not exists
CREATE TABLE WorkflowElementParameter (
	id INTEGER NOT NULL AUTO_INCREMENT
	, WorkflowElement INTEGER NOT NULL
	, Parameter INTEGER NOT NULL
	, Value VARCHAR(255) NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(WorkflowElement,Parameter)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE WorkflowElementParameter MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE WorkflowElementParameter ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE WorkflowElementParameter , MODIFY COLUMN WorkflowElement INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE WorkflowElementParameter , ADD COLUMN WorkflowElement INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE WorkflowElementParameter , MODIFY COLUMN Parameter INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE WorkflowElementParameter , ADD COLUMN Parameter INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE WorkflowElementParameter , MODIFY COLUMN Value VARCHAR(255) NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE WorkflowElementParameter , ADD COLUMN Value VARCHAR(255) NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*molgenisRoleGroupLink implements identifiable*/
#create the table if not exists
CREATE TABLE MolgenisRoleGroupLink (
	id INTEGER NOT NULL AUTO_INCREMENT
	, group_ INTEGER NOT NULL
	, role_ INTEGER NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(group_,role_)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisRoleGroupLink MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisRoleGroupLink ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisRoleGroupLink , MODIFY COLUMN group_ INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisRoleGroupLink , ADD COLUMN group_ INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisRoleGroupLink , MODIFY COLUMN role_ INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisRoleGroupLink , ADD COLUMN role_ INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*molgenisPermission implements identifiable*/
#create the table if not exists
CREATE TABLE MolgenisPermission (
	id INTEGER NOT NULL AUTO_INCREMENT
	, role_ INTEGER NOT NULL
	, entity INTEGER NOT NULL
	, permission ENUM('read','write','own') NOT NULL
	, PRIMARY KEY(id)
	, UNIQUE(role_,entity,permission)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisPermission MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisPermission ADD COLUMN id INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisPermission , MODIFY COLUMN role_ INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisPermission , ADD COLUMN role_ INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisPermission , MODIFY COLUMN entity INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisPermission , ADD COLUMN entity INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE MolgenisPermission , MODIFY COLUMN permission ENUM('read','write','own') NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE MolgenisPermission , ADD COLUMN permission ENUM('read','write','own') NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*observationElement_ontolo12449*/
#create the table if not exists
CREATE TABLE ObservationElement_ontolo12449 (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, ontologyReference INTEGER NOT NULL
	, InvestigationElement INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(ontologyReference,InvestigationElement)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationElement_ontolo12449 MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationElement_ontolo12449 ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationElement_ontolo12449 , MODIFY COLUMN ontologyReference INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationElement_ontolo12449 , ADD COLUMN ontologyReference INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationElement_ontolo12449 , MODIFY COLUMN InvestigationElement INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationElement_ontolo12449 , ADD COLUMN InvestigationElement INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*observationElement_AlternateId*/
#create the table if not exists
CREATE TABLE ObservationElement_AlternateId (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, AlternateId INTEGER NOT NULL
	, ObservationElement INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(AlternateId,ObservationElement)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationElement_AlternateId MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationElement_AlternateId ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationElement_AlternateId , MODIFY COLUMN AlternateId INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationElement_AlternateId , ADD COLUMN AlternateId INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ObservationElement_AlternateId , MODIFY COLUMN ObservationElement INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ObservationElement_AlternateId , ADD COLUMN ObservationElement INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*measurement_categories*/
#create the table if not exists
CREATE TABLE Measurement_categories (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, categories INTEGER NOT NULL
	, Measurement INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(categories,Measurement)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Measurement_categories MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Measurement_categories ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Measurement_categories , MODIFY COLUMN categories INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Measurement_categories , ADD COLUMN categories INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Measurement_categories , MODIFY COLUMN Measurement INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Measurement_categories , ADD COLUMN Measurement INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*panel_Individuals*/
#create the table if not exists
CREATE TABLE Panel_Individuals (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, Individuals INTEGER NOT NULL
	, Panel INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(Individuals,Panel)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel_Individuals MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel_Individuals ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel_Individuals , MODIFY COLUMN Individuals INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel_Individuals , ADD COLUMN Individuals INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel_Individuals , MODIFY COLUMN Panel INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel_Individuals , ADD COLUMN Panel INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*panel_FounderPanels*/
#create the table if not exists
CREATE TABLE Panel_FounderPanels (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, FounderPanels INTEGER NOT NULL
	, Panel INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(FounderPanels,Panel)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel_FounderPanels MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel_FounderPanels ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel_FounderPanels , MODIFY COLUMN FounderPanels INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel_FounderPanels , ADD COLUMN FounderPanels INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Panel_FounderPanels , MODIFY COLUMN Panel INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Panel_FounderPanels , ADD COLUMN Panel INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*investigation_contacts*/
#create the table if not exists
CREATE TABLE Investigation_contacts (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, contacts INTEGER NOT NULL
	, Investigation INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(contacts,Investigation)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation_contacts MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation_contacts ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation_contacts , MODIFY COLUMN contacts INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation_contacts , ADD COLUMN contacts INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Investigation_contacts , MODIFY COLUMN Investigation INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Investigation_contacts , ADD COLUMN Investigation INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*protocol_ontologyReference*/
#create the table if not exists
CREATE TABLE Protocol_ontologyReference (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, ontologyReference INTEGER NOT NULL
	, InvestigationElement INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(ontologyReference,InvestigationElement)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol_ontologyReference MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol_ontologyReference ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol_ontologyReference , MODIFY COLUMN ontologyReference INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol_ontologyReference , ADD COLUMN ontologyReference INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol_ontologyReference , MODIFY COLUMN InvestigationElement INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol_ontologyReference , ADD COLUMN InvestigationElement INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*protocol_Features*/
#create the table if not exists
CREATE TABLE Protocol_Features (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, Features INTEGER NOT NULL
	, Protocol INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(Features,Protocol)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol_Features MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol_Features ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol_Features , MODIFY COLUMN Features INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol_Features , ADD COLUMN Features INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol_Features , MODIFY COLUMN Protocol INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol_Features , ADD COLUMN Protocol INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*protocol_subprotocols*/
#create the table if not exists
CREATE TABLE Protocol_subprotocols (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, subprotocols INTEGER NOT NULL
	, Protocol INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(subprotocols,Protocol)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol_subprotocols MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol_subprotocols ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol_subprotocols , MODIFY COLUMN subprotocols INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol_subprotocols , ADD COLUMN subprotocols INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE Protocol_subprotocols , MODIFY COLUMN Protocol INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE Protocol_subprotocols , ADD COLUMN Protocol INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*protocolApplication_ontol11768*/
#create the table if not exists
CREATE TABLE ProtocolApplication_ontol11768 (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, ontologyReference INTEGER NOT NULL
	, InvestigationElement INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(ontologyReference,InvestigationElement)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProtocolApplication_ontol11768 MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProtocolApplication_ontol11768 ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProtocolApplication_ontol11768 , MODIFY COLUMN ontologyReference INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProtocolApplication_ontol11768 , ADD COLUMN ontologyReference INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProtocolApplication_ontol11768 , MODIFY COLUMN InvestigationElement INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProtocolApplication_ontol11768 , ADD COLUMN InvestigationElement INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*protocolApplication_Performer*/
#create the table if not exists
CREATE TABLE ProtocolApplication_Performer (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, Performer INTEGER NOT NULL
	, ProtocolApplication INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(Performer,ProtocolApplication)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProtocolApplication_Performer MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProtocolApplication_Performer ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProtocolApplication_Performer , MODIFY COLUMN Performer INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProtocolApplication_Performer , ADD COLUMN Performer INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE ProtocolApplication_Performer , MODIFY COLUMN ProtocolApplication INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE ProtocolApplication_Performer , ADD COLUMN ProtocolApplication INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns


/*workflowElement_PreviousSteps*/
#create the table if not exists
CREATE TABLE WorkflowElement_PreviousSteps (
	autoid INTEGER NOT NULL AUTO_INCREMENT
	, PreviousSteps INTEGER NOT NULL
	, WorkflowElement INTEGER NOT NULL
	, PRIMARY KEY(autoid)
	, UNIQUE(PreviousSteps,WorkflowElement)
) ENGINE=InnoDB;

#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE WorkflowElement_PreviousSteps MODIFY COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE WorkflowElement_PreviousSteps ADD COLUMN autoid INTEGER NOT NULL AUTO_INCREMENT IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE WorkflowElement_PreviousSteps , MODIFY COLUMN PreviousSteps INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE WorkflowElement_PreviousSteps , ADD COLUMN PreviousSteps INTEGER NOT NULL IF NOT EXISTS;
#strip dropped columns from constraints (keep data to be sure)
ALTER TABLE 

#modify the existing columns, simply fail if missing
ALTER TABLE WorkflowElement_PreviousSteps , MODIFY COLUMN WorkflowElement INTEGER NOT NULL IF EXISTS;

#add missing columns, simply fail if exist
ALTER TABLE WorkflowElement_PreviousSteps , ADD COLUMN WorkflowElement INTEGER NOT NULL IF NOT EXISTS;


#else modify an existing table
#make dropped column names nullable, not auto


#add the new columns

SET FOREIGN_KEY_CHECKS = 1;

/**********ADD/UPDATE FOREIGN KEYS**********/
ALTER TABLE Species ADD FOREIGN KEY (id) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE AlternateId ADD FOREIGN KEY (id) REFERENCES OntologyTerm (id) ON DELETE RESTRICT;
ALTER TABLE MolgenisGroup ADD FOREIGN KEY (id) REFERENCES MolgenisRole (id) ON DELETE RESTRICT;
ALTER TABLE Person ADD FOREIGN KEY (id) REFERENCES MolgenisRole (id) ON DELETE RESTRICT;
ALTER TABLE ObservationTarget ADD FOREIGN KEY (id) REFERENCES ObservationElement (id) ON DELETE RESTRICT;
ALTER TABLE ObservableFeature ADD FOREIGN KEY (id) REFERENCES ObservationElement (id) ON DELETE RESTRICT;
ALTER TABLE Category ADD FOREIGN KEY (id) REFERENCES ObservationElement (id) ON DELETE RESTRICT;
ALTER TABLE Measurement ADD FOREIGN KEY (id) REFERENCES ObservableFeature (id) ON DELETE RESTRICT;
ALTER TABLE Individual ADD FOREIGN KEY (id) REFERENCES ObservationTarget (id) ON DELETE RESTRICT;
ALTER TABLE Location ADD FOREIGN KEY (id) REFERENCES ObservationTarget (id) ON DELETE RESTRICT;
ALTER TABLE Panel ADD FOREIGN KEY (id) REFERENCES ObservationTarget (id) ON DELETE RESTRICT;
ALTER TABLE MolgenisUser ADD FOREIGN KEY (id) REFERENCES Person (id) ON DELETE RESTRICT;
ALTER TABLE Workflow ADD FOREIGN KEY (id) REFERENCES Protocol (id) ON DELETE RESTRICT;
ALTER TABLE ProtocolDocument ADD FOREIGN KEY (id) REFERENCES MolgenisFile (id) ON DELETE RESTRICT;

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
