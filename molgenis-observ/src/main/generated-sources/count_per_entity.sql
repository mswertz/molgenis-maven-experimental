SELECT 'Species' AS entity, count(*) AS count FROM OntologyTerm NATURAL JOIN Species WHERE __Type = 'Species'
 UNION 
SELECT 'AlternateId' AS entity, count(*) AS count FROM OntologyTerm NATURAL JOIN AlternateId WHERE __Type = 'AlternateId'
 UNION 
SELECT 'ObservationElement' AS entity, count(*) AS count FROM ObservationElement WHERE __Type = 'ObservationElement'
 UNION 
SELECT 'ObservationTarget' AS entity, count(*) AS count FROM ObservationElement NATURAL JOIN ObservationTarget WHERE __Type = 'ObservationTarget'
 UNION 
SELECT 'ObservableFeature' AS entity, count(*) AS count FROM ObservationElement NATURAL JOIN ObservableFeature WHERE __Type = 'ObservableFeature'
 UNION 
SELECT 'Measurement' AS entity, count(*) AS count FROM ObservationElement NATURAL JOIN ObservableFeature NATURAL JOIN Measurement WHERE __Type = 'Measurement'
 UNION 
SELECT 'Category' AS entity, count(*) AS count FROM ObservationElement NATURAL JOIN Category WHERE __Type = 'Category'
 UNION 
SELECT 'Individual' AS entity, count(*) AS count FROM ObservationElement NATURAL JOIN ObservationTarget NATURAL JOIN Individual WHERE __Type = 'Individual'
 UNION 
SELECT 'Location' AS entity, count(*) AS count FROM ObservationElement NATURAL JOIN ObservationTarget NATURAL JOIN Location WHERE __Type = 'Location'
 UNION 
SELECT 'Panel' AS entity, count(*) AS count FROM ObservationElement NATURAL JOIN ObservationTarget NATURAL JOIN Panel WHERE __Type = 'Panel'
 UNION 
SELECT 'ObservedValue' AS entity, count(*) AS count FROM ObservedValue
 UNION 
SELECT 'Investigation' AS entity, count(*) AS count FROM Investigation
 UNION 
SELECT 'OntologyTerm' AS entity, count(*) AS count FROM OntologyTerm WHERE __Type = 'OntologyTerm'
 UNION 
SELECT 'Ontology' AS entity, count(*) AS count FROM Ontology
 UNION 
SELECT 'MolgenisFile' AS entity, count(*) AS count FROM MolgenisFile WHERE __Type = 'MolgenisFile'
 UNION 
SELECT 'RuntimeProperty' AS entity, count(*) AS count FROM RuntimeProperty
 UNION 
SELECT 'Publication' AS entity, count(*) AS count FROM Publication
 UNION 
SELECT 'UseCase' AS entity, count(*) AS count FROM UseCase
 UNION 
SELECT 'MolgenisEntity' AS entity, count(*) AS count FROM MolgenisEntity
 UNION 
SELECT 'Protocol' AS entity, count(*) AS count FROM Protocol WHERE __Type = 'Protocol'
 UNION 
SELECT 'ProtocolApplication' AS entity, count(*) AS count FROM ProtocolApplication
 UNION 
SELECT 'ProtocolDocument' AS entity, count(*) AS count FROM MolgenisFile NATURAL JOIN ProtocolDocument WHERE __Type = 'ProtocolDocument'
 UNION 
SELECT 'Workflow' AS entity, count(*) AS count FROM Protocol NATURAL JOIN Workflow WHERE __Type = 'Workflow'
 UNION 
SELECT 'WorkflowElement' AS entity, count(*) AS count FROM WorkflowElement
 UNION 
SELECT 'WorkflowElementParameter' AS entity, count(*) AS count FROM WorkflowElementParameter
 UNION 
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
SELECT 'ObservationElement_ontolo12449' AS entity, count(*) AS count FROM ObservationElement_ontolo12449
 UNION 
SELECT 'ObservationElement_AlternateId' AS entity, count(*) AS count FROM ObservationElement_AlternateId
 UNION 
SELECT 'Measurement_categories' AS entity, count(*) AS count FROM Measurement_categories
 UNION 
SELECT 'Panel_Individuals' AS entity, count(*) AS count FROM Panel_Individuals
 UNION 
SELECT 'Panel_FounderPanels' AS entity, count(*) AS count FROM Panel_FounderPanels
 UNION 
SELECT 'Investigation_contacts' AS entity, count(*) AS count FROM Investigation_contacts
 UNION 
SELECT 'Protocol_ontologyReference' AS entity, count(*) AS count FROM Protocol_ontologyReference
 UNION 
SELECT 'Protocol_Features' AS entity, count(*) AS count FROM Protocol_Features
 UNION 
SELECT 'Protocol_subprotocols' AS entity, count(*) AS count FROM Protocol_subprotocols
 UNION 
SELECT 'ProtocolApplication_ontol11768' AS entity, count(*) AS count FROM ProtocolApplication_ontol11768
 UNION 
SELECT 'ProtocolApplication_Performer' AS entity, count(*) AS count FROM ProtocolApplication_Performer
 UNION 
SELECT 'WorkflowElement_PreviousSteps' AS entity, count(*) AS count FROM WorkflowElement_PreviousSteps

;