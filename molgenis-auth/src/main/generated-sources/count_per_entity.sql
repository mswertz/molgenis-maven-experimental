SELECT 'MolgenisRole' AS entity, count(*) AS count FROM MolgenisRole WHERE __Type = 'MolgenisRole'
 UNION 
SELECT 'MolgenisGroup' AS entity, count(*) AS count FROM MolgenisRole NATURAL JOIN MolgenisGroup WHERE __Type = 'MolgenisGroup'
 UNION 
SELECT 'MolgenisRoleGroupLink' AS entity, count(*) AS count FROM MolgenisRoleGroupLink
 UNION 
SELECT 'Person' AS entity, count(*) AS count FROM MolgenisRole NATURAL JOIN Person WHERE __Type = 'Person'
 UNION 
SELECT 'Institute' AS entity, count(*) AS count FROM Institute
 UNION 
SELECT 'MolgenisUser' AS entity, count(*) AS count FROM MolgenisRole NATURAL JOIN Person NATURAL JOIN MolgenisUser WHERE __Type = 'MolgenisUser'
 UNION 
SELECT 'MolgenisPermission' AS entity, count(*) AS count FROM MolgenisPermission
 UNION 
SELECT 'OntologyTerm' AS entity, count(*) AS count FROM OntologyTerm
 UNION 
SELECT 'Ontology' AS entity, count(*) AS count FROM Ontology
 UNION 
SELECT 'MolgenisFile' AS entity, count(*) AS count FROM MolgenisFile
 UNION 
SELECT 'RuntimeProperty' AS entity, count(*) AS count FROM RuntimeProperty
 UNION 
SELECT 'Publication' AS entity, count(*) AS count FROM Publication
 UNION 
SELECT 'UseCase' AS entity, count(*) AS count FROM UseCase
 UNION 
SELECT 'MolgenisEntity' AS entity, count(*) AS count FROM MolgenisEntity

;