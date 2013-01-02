SELECT 'MolgenisRole' AS entity, count(*) AS count FROM molgenisRole
 UNION 
SELECT 'MolgenisGroup' AS entity, count(*) AS count FROM molgenisGroup
 UNION 
SELECT 'MolgenisRoleGroupLink' AS entity, count(*) AS count FROM molgenisRoleGroupLink
 UNION 
SELECT 'Person' AS entity, count(*) AS count FROM person
 UNION 
SELECT 'Institute' AS entity, count(*) AS count FROM institute
 UNION 
SELECT 'MolgenisUser' AS entity, count(*) AS count FROM molgenisUser
 UNION 
SELECT 'MolgenisPermission' AS entity, count(*) AS count FROM molgenisPermission
 UNION 
SELECT 'OntologyTerm' AS entity, count(*) AS count FROM ontologyTerm
 UNION 
SELECT 'Ontology' AS entity, count(*) AS count FROM ontology
 UNION 
SELECT 'MolgenisFile' AS entity, count(*) AS count FROM molgenisFile
 UNION 
SELECT 'RuntimeProperty' AS entity, count(*) AS count FROM runtimeProperty
 UNION 
SELECT 'Publication' AS entity, count(*) AS count FROM publication
 UNION 
SELECT 'UseCase' AS entity, count(*) AS count FROM useCase
 UNION 
SELECT 'MolgenisEntity' AS entity, count(*) AS count FROM molgenisEntity

;