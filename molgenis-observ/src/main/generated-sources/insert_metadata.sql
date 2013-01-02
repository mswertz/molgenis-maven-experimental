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

INSERT INTO MolgenisEntity(name, type_, classname) values ('Species', 'ENTITY', 'org.molgenis.pheno.Species');
INSERT INTO MolgenisEntity(name, type_, classname) values ('AlternateId', 'ENTITY', 'org.molgenis.pheno.AlternateId');
INSERT INTO MolgenisEntity(name, type_, classname) values ('ObservationElement', 'ENTITY', 'org.molgenis.pheno.ObservationElement');
INSERT INTO MolgenisEntity(name, type_, classname) values ('ObservationTarget', 'ENTITY', 'org.molgenis.pheno.ObservationTarget');
INSERT INTO MolgenisEntity(name, type_, classname) values ('ObservableFeature', 'ENTITY', 'org.molgenis.pheno.ObservableFeature');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Measurement', 'ENTITY', 'org.molgenis.pheno.Measurement');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Category', 'ENTITY', 'org.molgenis.pheno.Category');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Individual', 'ENTITY', 'org.molgenis.pheno.Individual');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Location', 'ENTITY', 'org.molgenis.pheno.Location');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Panel', 'ENTITY', 'org.molgenis.pheno.Panel');
INSERT INTO MolgenisEntity(name, type_, classname) values ('ObservedValue', 'ENTITY', 'org.molgenis.pheno.ObservedValue');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Investigation', 'ENTITY', 'org.molgenis.organization.Investigation');
INSERT INTO MolgenisEntity(name, type_, classname) values ('OntologyTerm', 'ENTITY', 'org.molgenis.core.OntologyTerm');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Ontology', 'ENTITY', 'org.molgenis.core.Ontology');
INSERT INTO MolgenisEntity(name, type_, classname) values ('MolgenisFile', 'ENTITY', 'org.molgenis.core.MolgenisFile');
INSERT INTO MolgenisEntity(name, type_, classname) values ('RuntimeProperty', 'ENTITY', 'org.molgenis.core.RuntimeProperty');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Publication', 'ENTITY', 'org.molgenis.core.Publication');
INSERT INTO MolgenisEntity(name, type_, classname) values ('UseCase', 'ENTITY', 'org.molgenis.core.UseCase');
INSERT INTO MolgenisEntity(name, type_, classname) values ('MolgenisEntity', 'ENTITY', 'org.molgenis.core.MolgenisEntity');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Protocol', 'ENTITY', 'org.molgenis.protocol.Protocol');
INSERT INTO MolgenisEntity(name, type_, classname) values ('ProtocolApplication', 'ENTITY', 'org.molgenis.protocol.ProtocolApplication');
INSERT INTO MolgenisEntity(name, type_, classname) values ('ProtocolDocument', 'ENTITY', 'org.molgenis.protocol.ProtocolDocument');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Workflow', 'ENTITY', 'org.molgenis.protocol.Workflow');
INSERT INTO MolgenisEntity(name, type_, classname) values ('WorkflowElement', 'ENTITY', 'org.molgenis.protocol.WorkflowElement');
INSERT INTO MolgenisEntity(name, type_, classname) values ('WorkflowElementParameter', 'ENTITY', 'org.molgenis.protocol.WorkflowElementParameter');
INSERT INTO MolgenisEntity(name, type_, classname) values ('MolgenisRole', 'ENTITY', 'org.molgenis.auth.MolgenisRole');
INSERT INTO MolgenisEntity(name, type_, classname) values ('MolgenisGroup', 'ENTITY', 'org.molgenis.auth.MolgenisGroup');
INSERT INTO MolgenisEntity(name, type_, classname) values ('MolgenisRoleGroupLink', 'ENTITY', 'org.molgenis.auth.MolgenisRoleGroupLink');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Person', 'ENTITY', 'org.molgenis.auth.Person');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Institute', 'ENTITY', 'org.molgenis.auth.Institute');
INSERT INTO MolgenisEntity(name, type_, classname) values ('MolgenisUser', 'ENTITY', 'org.molgenis.auth.MolgenisUser');
INSERT INTO MolgenisEntity(name, type_, classname) values ('MolgenisPermission', 'ENTITY', 'org.molgenis.auth.MolgenisPermission');
INSERT INTO MolgenisEntity(name, type_, classname) values ('ObservationElement_Ontolo12449', 'ENTITY', 'org.molgenis.pheno.ObservationElement_Ontolo12449');
INSERT INTO MolgenisEntity(name, type_, classname) values ('ObservationElement_AlternateId', 'ENTITY', 'org.molgenis.pheno.ObservationElement_AlternateId');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Measurement_Categories', 'ENTITY', 'org.molgenis.pheno.Measurement_Categories');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Panel_Individuals', 'ENTITY', 'org.molgenis.pheno.Panel_Individuals');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Panel_FounderPanels', 'ENTITY', 'org.molgenis.pheno.Panel_FounderPanels');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Investigation_Contacts', 'ENTITY', 'org.molgenis.organization.Investigation_Contacts');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Protocol_OntologyReference', 'ENTITY', 'org.molgenis.protocol.Protocol_OntologyReference');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Protocol_Features', 'ENTITY', 'org.molgenis.protocol.Protocol_Features');
INSERT INTO MolgenisEntity(name, type_, classname) values ('Protocol_Subprotocols', 'ENTITY', 'org.molgenis.protocol.Protocol_Subprotocols');
INSERT INTO MolgenisEntity(name, type_, classname) values ('ProtocolApplication_Ontol11768', 'ENTITY', 'org.molgenis.protocol.ProtocolApplication_Ontol11768');
INSERT INTO MolgenisEntity(name, type_, classname) values ('ProtocolApplication_Performer', 'ENTITY', 'org.molgenis.protocol.ProtocolApplication_Performer');
INSERT INTO MolgenisEntity(name, type_, classname) values ('WorkflowElement_PreviousSteps', 'ENTITY', 'org.molgenis.protocol.WorkflowElement_PreviousSteps');


INSERT INTO MolgenisPermission (role_, entity, permission) SELECT 3, id, 'read' FROM MolgenisEntity WHERE MolgenisEntity.name = 'UserLoginPlugin';
