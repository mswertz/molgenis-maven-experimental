SELECT 'Species' AS entity, count(*) AS count FROM species
 UNION 
SELECT 'AlternateId' AS entity, count(*) AS count FROM alternateId
 UNION 
SELECT 'ObservationElement' AS entity, count(*) AS count FROM observationElement
 UNION 
SELECT 'ObservationTarget' AS entity, count(*) AS count FROM observationTarget
 UNION 
SELECT 'ObservableFeature' AS entity, count(*) AS count FROM observableFeature
 UNION 
SELECT 'Measurement' AS entity, count(*) AS count FROM measurement
 UNION 
SELECT 'Category' AS entity, count(*) AS count FROM category
 UNION 
SELECT 'Individual' AS entity, count(*) AS count FROM individual
 UNION 
SELECT 'Location' AS entity, count(*) AS count FROM location
 UNION 
SELECT 'Panel' AS entity, count(*) AS count FROM panel
 UNION 
SELECT 'ObservedValue' AS entity, count(*) AS count FROM observedValue
 UNION 
SELECT 'Investigation' AS entity, count(*) AS count FROM investigation
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
 UNION 
SELECT 'Protocol' AS entity, count(*) AS count FROM protocol
 UNION 
SELECT 'ProtocolApplication' AS entity, count(*) AS count FROM protocolApplication
 UNION 
SELECT 'ProtocolDocument' AS entity, count(*) AS count FROM protocolDocument
 UNION 
SELECT 'Workflow' AS entity, count(*) AS count FROM workflow
 UNION 
SELECT 'WorkflowElement' AS entity, count(*) AS count FROM workflowElement
 UNION 
SELECT 'WorkflowElementParameter' AS entity, count(*) AS count FROM workflowElementParameter
 UNION 
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
SELECT 'ObservationElement_ontolo12449' AS entity, count(*) AS count FROM observationElement_ontolo12449
 UNION 
SELECT 'ObservationElement_AlternateId' AS entity, count(*) AS count FROM observationElement_AlternateId
 UNION 
SELECT 'Measurement_categories' AS entity, count(*) AS count FROM measurement_categories
 UNION 
SELECT 'Panel_Individuals' AS entity, count(*) AS count FROM panel_Individuals
 UNION 
SELECT 'Panel_FounderPanels' AS entity, count(*) AS count FROM panel_FounderPanels
 UNION 
SELECT 'Investigation_contacts' AS entity, count(*) AS count FROM investigation_contacts
 UNION 
SELECT 'Protocol_ontologyReference' AS entity, count(*) AS count FROM protocol_ontologyReference
 UNION 
SELECT 'Protocol_Features' AS entity, count(*) AS count FROM protocol_Features
 UNION 
SELECT 'Protocol_subprotocols' AS entity, count(*) AS count FROM protocol_subprotocols
 UNION 
SELECT 'ProtocolApplication_ontol11768' AS entity, count(*) AS count FROM protocolApplication_ontol11768
 UNION 
SELECT 'ProtocolApplication_Performer' AS entity, count(*) AS count FROM protocolApplication_Performer
 UNION 
SELECT 'WorkflowElement_PreviousSteps' AS entity, count(*) AS count FROM workflowElement_PreviousSteps

;