/*
 * Created by: org.molgenis.generators.sql.MySqlAlterSubclassPerTableGen
 * Date: October 22, 2012
 */

/**********CREATE TABLES**********/
SET FOREIGN_KEY_CHECKS = 0; ##allows us to drop fkeyed tables

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


/*ontologyTerm implements nameable*/
#create the table if not exists
CREATE TABLE OntologyTerm (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
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


/*molgenisFile implements nameable*/
#create the table if not exists
CREATE TABLE MolgenisFile (
	id INTEGER NOT NULL AUTO_INCREMENT
	, name VARCHAR(127) NOT NULL
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

SET FOREIGN_KEY_CHECKS = 1;

/**********ADD/UPDATE FOREIGN KEYS**********/
ALTER TABLE MolgenisGroup ADD FOREIGN KEY (id) REFERENCES MolgenisRole (id) ON DELETE RESTRICT;
ALTER TABLE Person ADD FOREIGN KEY (id) REFERENCES MolgenisRole (id) ON DELETE RESTRICT;
ALTER TABLE MolgenisUser ADD FOREIGN KEY (id) REFERENCES Person (id) ON DELETE RESTRICT;

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
