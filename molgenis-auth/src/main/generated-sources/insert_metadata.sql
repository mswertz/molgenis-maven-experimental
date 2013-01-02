INSERT INTO MolgenisRole (__Type, id, name) values ('MolgenisGroup', 1, 'system');
INSERT INTO MolgenisRole (__Type, id, name) values ('MolgenisUser', 2, 'admin');
INSERT INTO MolgenisRole (__Type, id, name) values ('MolgenisUser', 3, 'anonymous');
INSERT INTO MolgenisRole (__Type, id, name) values ('MolgenisGroup', 4, 'AllUsers');

INSERT INTO MolgenisGroup (id) values (1);
INSERT INTO MolgenisGroup (id) values (4);

INSERT INTO Person (id, Email, FirstName, LastName) values (2, 'put_something_here@somewhere.com', 'admin', 'admin');
INSERT INTO Person (id, Email, FirstName, LastName) values (3, 'put_something_here@somewhere.com', 'anonymous','anonymous');
INSERT INTO MolgenisUser (id, password_, active, superuser) values (2, 'md5_21232f297a57a5a743894a0e4a801fc3', true, true);
INSERT INTO MolgenisUser (id, password_, active) values (3, 'md5_294de3557d9d00b3d2d8a1e6aab028cf', true);


INSERT INTO MolgenisRoleGroupLink (group_, role_) values (1, 2);
INSERT INTO MolgenisRoleGroupLink (group_, role_) values (4, 2);
INSERT INTO MolgenisRoleGroupLink (group_, role_) values (1, 3);
INSERT INTO MolgenisRoleGroupLink (group_, role_) values (4, 3);

INSERT INTO MolgenisEntity(name, type_, classname) values ('MolgenisRole', 'ENTITY', 'org.molgenis.auth.MolgenisRole');
INSERT INTO MolgenisEntity(name, type_, classname) values ('MolgenisGroup', 'ENTITY', 'org.molgenis.auth.MolgenisGroup');
INSERT INTO MolgenisEntity(name, type_, classname) values ('MolgenisRoleGroupLink', 'ENTITY', 'org.molgenis.auth.MolgenisRoleGroupLink');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Person', 'ENTITY', 'org.molgenis.auth.Person');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Institute', 'ENTITY', 'org.molgenis.auth.Institute');
INSERT INTO MolgenisEntity(name, type_, classname) values ('MolgenisUser', 'ENTITY', 'org.molgenis.auth.MolgenisUser');
INSERT INTO MolgenisEntity(name, type_, classname) values ('MolgenisPermission', 'ENTITY', 'org.molgenis.auth.MolgenisPermission');
INSERT INTO MolgenisEntity(name, type_, classname) values ('OntologyTerm', 'ENTITY', 'org.molgenis.core.OntologyTerm');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Ontology', 'ENTITY', 'org.molgenis.core.Ontology');
INSERT INTO MolgenisEntity(name, type_, classname) values ('MolgenisFile', 'ENTITY', 'org.molgenis.core.MolgenisFile');
INSERT INTO MolgenisEntity(name, type_, classname) values ('RuntimeProperty', 'ENTITY', 'org.molgenis.core.RuntimeProperty');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Publication', 'ENTITY', 'org.molgenis.core.Publication');
INSERT INTO MolgenisEntity(name, type_, classname) values ('UseCase', 'ENTITY', 'org.molgenis.core.UseCase');
INSERT INTO MolgenisEntity(name, type_, classname) values ('MolgenisEntity', 'ENTITY', 'org.molgenis.core.MolgenisEntity');


INSERT INTO MolgenisPermission (role_, entity, permission) SELECT 3, id, 'read' FROM MolgenisEntity WHERE MolgenisEntity.name = 'UserLoginPlugin';
