package app.servlet;

//import java.io.File;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
//import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.molgenis.pheno.Species;
import org.molgenis.pheno.AlternateId;
import org.molgenis.pheno.ObservationElement;
import org.molgenis.pheno.ObservationTarget;
import org.molgenis.pheno.ObservableFeature;
import org.molgenis.pheno.Measurement;
import org.molgenis.pheno.Category;
import org.molgenis.pheno.Individual;
import org.molgenis.pheno.Location;
import org.molgenis.pheno.Panel;
import org.molgenis.pheno.ObservedValue;
import org.molgenis.organization.Investigation;
import org.molgenis.core.OntologyTerm;
import org.molgenis.core.Ontology;
import org.molgenis.core.MolgenisFile;
import org.molgenis.core.RuntimeProperty;
import org.molgenis.core.Publication;
import org.molgenis.core.UseCase;
import org.molgenis.core.MolgenisEntity;
import org.molgenis.protocol.Protocol;
import org.molgenis.protocol.ProtocolApplication;
import org.molgenis.protocol.ProtocolDocument;
import org.molgenis.protocol.Workflow;
import org.molgenis.protocol.WorkflowElement;
import org.molgenis.protocol.WorkflowElementParameter;
import org.molgenis.auth.MolgenisRole;
import org.molgenis.auth.MolgenisGroup;
import org.molgenis.auth.MolgenisRoleGroupLink;
import org.molgenis.auth.Person;
import org.molgenis.auth.Institute;
import org.molgenis.auth.MolgenisUser;
import org.molgenis.auth.MolgenisPermission;
import org.molgenis.pheno.ObservationElement_Ontolo12449;
import org.molgenis.pheno.ObservationElement_AlternateId;
import org.molgenis.pheno.Measurement_Categories;
import org.molgenis.pheno.Panel_Individuals;
import org.molgenis.pheno.Panel_FounderPanels;
import org.molgenis.organization.Investigation_Contacts;
import org.molgenis.protocol.Protocol_OntologyReference;
import org.molgenis.protocol.Protocol_Features;
import org.molgenis.protocol.Protocol_Subprotocols;
import org.molgenis.protocol.ProtocolApplication_Ontol11768;
import org.molgenis.protocol.ProtocolApplication_Performer;
import org.molgenis.protocol.WorkflowElement_PreviousSteps;

//import org.apache.commons.dbcp.BasicDataSource;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
//import org.molgenis.framework.db.jdbc.JndiDataSourceWrapper;
//import org.molgenis.framework.db.QueryRule;
import org.molgenis.framework.db.Query;
import org.molgenis.util.CsvWriter;





@WebService()
@SOAPBinding(style = Style.DOCUMENT)
public class SoapApi
{
// GET SERVICES (for each entity)
	@WebMethod()
	@WebResult(name = "speciesList")
	public Species getSpecies(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<Species> _result = database.query(Species.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "alternateIdList")
	public AlternateId getAlternateId(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<AlternateId> _result = database.query(AlternateId.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "observationElementList")
	public ObservationElement getObservationElement(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<ObservationElement> _result = database.query(ObservationElement.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "observationTargetList")
	public ObservationTarget getObservationTarget(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<ObservationTarget> _result = database.query(ObservationTarget.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "observableFeatureList")
	public ObservableFeature getObservableFeature(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<ObservableFeature> _result = database.query(ObservableFeature.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "measurementList")
	public Measurement getMeasurement(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<Measurement> _result = database.query(Measurement.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "categoryList")
	public Category getCategory(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<Category> _result = database.query(Category.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "individualList")
	public Individual getIndividual(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<Individual> _result = database.query(Individual.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "locationList")
	public Location getLocation(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<Location> _result = database.query(Location.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "panelList")
	public Panel getPanel(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<Panel> _result = database.query(Panel.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "observedValueList")
	public ObservedValue getObservedValue(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<ObservedValue> _result = database.query(ObservedValue.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "investigationList")
	public Investigation getInvestigation(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<Investigation> _result = database.query(Investigation.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "ontologyTermList")
	public OntologyTerm getOntologyTerm(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<OntologyTerm> _result = database.query(OntologyTerm.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "ontologyList")
	public Ontology getOntology(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<Ontology> _result = database.query(Ontology.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "molgenisFileList")
	public MolgenisFile getMolgenisFile(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<MolgenisFile> _result = database.query(MolgenisFile.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "runtimePropertyList")
	public RuntimeProperty getRuntimeProperty(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<RuntimeProperty> _result = database.query(RuntimeProperty.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "publicationList")
	public Publication getPublication(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<Publication> _result = database.query(Publication.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "useCaseList")
	public UseCase getUseCase(@WebParam(name = "UseCaseId")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<UseCase> _result = database.query(UseCase.class).equals("UseCaseId", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "protocolList")
	public Protocol getProtocol(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<Protocol> _result = database.query(Protocol.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "protocolApplicationList")
	public ProtocolApplication getProtocolApplication(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<ProtocolApplication> _result = database.query(ProtocolApplication.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "protocolDocumentList")
	public ProtocolDocument getProtocolDocument(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<ProtocolDocument> _result = database.query(ProtocolDocument.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "workflowList")
	public Workflow getWorkflow(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<Workflow> _result = database.query(Workflow.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "workflowElementList")
	public WorkflowElement getWorkflowElement(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<WorkflowElement> _result = database.query(WorkflowElement.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "workflowElementParameterList")
	public WorkflowElementParameter getWorkflowElementParameter(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<WorkflowElementParameter> _result = database.query(WorkflowElementParameter.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "personList")
	public Person getPerson(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<Person> _result = database.query(Person.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod()
	@WebResult(name = "instituteList")
	public Institute getInstitute(@WebParam(name = "id")Integer pkey)
	{
		try
		{
			Database database = getDatabase();
			List<Institute> _result = database.query(Institute.class).equals("id", pkey).find();
			if(_result.size() == 1)
				return _result.get(0);//.toString()+"\n";
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

//FIND SERVICES (for each entity)
	@WebMethod()
	@WebResult(name = "speciesList")
	public List<Species> findSpecies(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "ontology") Integer ontology,
		@WebParam(name = "ontology_name") Integer ontology_name,	 
		@WebParam(name = "termAccession") String termAccession,	 
		@WebParam(name = "definition") String definition,	 
		@WebParam(name = "termPath") String termPath)
	{
		try
		{
			Query<Species> q = getDatabase().query(Species.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(__Type != null) q.equals("__Type", __Type);
			if(ontology != null) q.equals("ontology", ontology);
			if(termAccession != null) q.equals("termAccession", termAccession);
			if(definition != null) q.equals("definition", definition);
			if(termPath != null) q.equals("termPath", termPath);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "speciesCsv")
	public String findSpeciesCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "ontology") Integer ontology,
		@WebParam(name = "ontology_name") Integer ontology_name,	 
		@WebParam(name = "termAccession") String termAccession,	 
		@WebParam(name = "definition") String definition,	 
		@WebParam(name = "termPath") String termPath)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Species> q = getDatabase().query(Species.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(__Type != null) q.equals("__Type", __Type);
			if(ontology != null) q.equals("ontology", ontology);
			if(termAccession != null) q.equals("termAccession", termAccession);
			if(definition != null) q.equals("definition", definition);
			if(termPath != null) q.equals("termPath", termPath);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "alternateIdList")
	public List<AlternateId> findAlternateId(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "ontology") Integer ontology,
		@WebParam(name = "ontology_name") Integer ontology_name,	 
		@WebParam(name = "termAccession") String termAccession,	 
		@WebParam(name = "definition") String definition,	 
		@WebParam(name = "termPath") String termPath)
	{
		try
		{
			Query<AlternateId> q = getDatabase().query(AlternateId.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(__Type != null) q.equals("__Type", __Type);
			if(ontology != null) q.equals("ontology", ontology);
			if(termAccession != null) q.equals("termAccession", termAccession);
			if(definition != null) q.equals("definition", definition);
			if(termPath != null) q.equals("termPath", termPath);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "alternateIdCsv")
	public String findAlternateIdCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "ontology") Integer ontology,
		@WebParam(name = "ontology_name") Integer ontology_name,	 
		@WebParam(name = "termAccession") String termAccession,	 
		@WebParam(name = "definition") String definition,	 
		@WebParam(name = "termPath") String termPath)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<AlternateId> q = getDatabase().query(AlternateId.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(__Type != null) q.equals("__Type", __Type);
			if(ontology != null) q.equals("ontology", ontology);
			if(termAccession != null) q.equals("termAccession", termAccession);
			if(definition != null) q.equals("definition", definition);
			if(termPath != null) q.equals("termPath", termPath);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "observationElementList")
	public List<ObservationElement> findObservationElement(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label)
	{
		try
		{
			Query<ObservationElement> q = getDatabase().query(ObservationElement.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "observationElementCsv")
	public String findObservationElementCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<ObservationElement> q = getDatabase().query(ObservationElement.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "observationTargetList")
	public List<ObservationTarget> findObservationTarget(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label)
	{
		try
		{
			Query<ObservationTarget> q = getDatabase().query(ObservationTarget.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "observationTargetCsv")
	public String findObservationTargetCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<ObservationTarget> q = getDatabase().query(ObservationTarget.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "observableFeatureList")
	public List<ObservableFeature> findObservableFeature(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label)
	{
		try
		{
			Query<ObservableFeature> q = getDatabase().query(ObservableFeature.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "observableFeatureCsv")
	public String findObservableFeatureCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<ObservableFeature> q = getDatabase().query(ObservableFeature.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "measurementList")
	public List<Measurement> findMeasurement(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label,	 
		@WebParam(name = "unit") Integer unit,
		@WebParam(name = "unit_name") Integer unit_name,	 
		@WebParam(name = "dataType") String dataType,	 
		@WebParam(name = "temporal") Boolean temporal,	 
		@WebParam(name = "categories") java.util.List<Integer> categories,
		@WebParam(name = "categories_name") java.util.List<Integer> categories_name,	 
		@WebParam(name = "targettypeAllowedForRelation") Integer targettypeAllowedForRelation,
		@WebParam(name = "targettypeAllowedForRelation_className") Integer targettypeAllowedForRelation_className,	 
		@WebParam(name = "panelLabelAllowedForRelation") String panelLabelAllowedForRelation)
	{
		try
		{
			Query<Measurement> q = getDatabase().query(Measurement.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			if(unit != null) q.equals("unit", unit);
			if(dataType != null) q.equals("dataType", dataType);
			if(temporal != null) q.equals("temporal", temporal);
			if(categories != null) q.equals("categories", categories);
			if(targettypeAllowedForRelation != null) q.equals("targettypeAllowedForRelation", targettypeAllowedForRelation);
			if(panelLabelAllowedForRelation != null) q.equals("panelLabelAllowedForRelation", panelLabelAllowedForRelation);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "measurementCsv")
	public String findMeasurementCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label,	 
		@WebParam(name = "unit") Integer unit,
		@WebParam(name = "unit_name") Integer unit_name,	 
		@WebParam(name = "dataType") String dataType,	 
		@WebParam(name = "temporal") Boolean temporal,	 
		@WebParam(name = "categories") java.util.List<Integer> categories,
		@WebParam(name = "categories_name") java.util.List<Integer> categories_name,	 
		@WebParam(name = "targettypeAllowedForRelation") Integer targettypeAllowedForRelation,
		@WebParam(name = "targettypeAllowedForRelation_className") Integer targettypeAllowedForRelation_className,	 
		@WebParam(name = "panelLabelAllowedForRelation") String panelLabelAllowedForRelation)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Measurement> q = getDatabase().query(Measurement.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			if(unit != null) q.equals("unit", unit);
			if(dataType != null) q.equals("dataType", dataType);
			if(temporal != null) q.equals("temporal", temporal);
			if(categories != null) q.equals("categories", categories);
			if(targettypeAllowedForRelation != null) q.equals("targettypeAllowedForRelation", targettypeAllowedForRelation);
			if(panelLabelAllowedForRelation != null) q.equals("panelLabelAllowedForRelation", panelLabelAllowedForRelation);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "categoryList")
	public List<Category> findCategory(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label,	 
		@WebParam(name = "code_string") String code_string,	 
		@WebParam(name = "isMissing") Boolean isMissing)
	{
		try
		{
			Query<Category> q = getDatabase().query(Category.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			if(code_string != null) q.equals("code_string", code_string);
			if(isMissing != null) q.equals("isMissing", isMissing);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "categoryCsv")
	public String findCategoryCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label,	 
		@WebParam(name = "code_string") String code_string,	 
		@WebParam(name = "isMissing") Boolean isMissing)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Category> q = getDatabase().query(Category.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			if(code_string != null) q.equals("code_string", code_string);
			if(isMissing != null) q.equals("isMissing", isMissing);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "individualList")
	public List<Individual> findIndividual(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label,	 
		@WebParam(name = "mother") Integer mother,
		@WebParam(name = "mother_name") Integer mother_name,	 
		@WebParam(name = "father") Integer father,
		@WebParam(name = "father_name") Integer father_name)
	{
		try
		{
			Query<Individual> q = getDatabase().query(Individual.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			if(mother != null) q.equals("mother", mother);
			if(father != null) q.equals("father", father);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "individualCsv")
	public String findIndividualCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label,	 
		@WebParam(name = "mother") Integer mother,
		@WebParam(name = "mother_name") Integer mother_name,	 
		@WebParam(name = "father") Integer father,
		@WebParam(name = "father_name") Integer father_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Individual> q = getDatabase().query(Individual.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			if(mother != null) q.equals("mother", mother);
			if(father != null) q.equals("father", father);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "locationList")
	public List<Location> findLocation(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label)
	{
		try
		{
			Query<Location> q = getDatabase().query(Location.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "locationCsv")
	public String findLocationCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Location> q = getDatabase().query(Location.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "panelList")
	public List<Panel> findPanel(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label,	 
		@WebParam(name = "individuals") java.util.List<Integer> individuals,
		@WebParam(name = "individuals_name") java.util.List<Integer> individuals_name,	 
		@WebParam(name = "species") Integer species,
		@WebParam(name = "species_name") Integer species_name,	 
		@WebParam(name = "panelType") Integer panelType,
		@WebParam(name = "panelType_name") Integer panelType_name,	 
		@WebParam(name = "founderPanels") java.util.List<Integer> founderPanels,
		@WebParam(name = "founderPanels_name") java.util.List<Integer> founderPanels_name)
	{
		try
		{
			Query<Panel> q = getDatabase().query(Panel.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			if(individuals != null) q.equals("individuals", individuals);
			if(species != null) q.equals("species", species);
			if(panelType != null) q.equals("panelType", panelType);
			if(founderPanels != null) q.equals("founderPanels", founderPanels);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "panelCsv")
	public String findPanelCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "alternateId") java.util.List<Integer> alternateId,
		@WebParam(name = "alternateId_name") java.util.List<Integer> alternateId_name,	 
		@WebParam(name = "label") String label,	 
		@WebParam(name = "individuals") java.util.List<Integer> individuals,
		@WebParam(name = "individuals_name") java.util.List<Integer> individuals_name,	 
		@WebParam(name = "species") Integer species,
		@WebParam(name = "species_name") Integer species_name,	 
		@WebParam(name = "panelType") Integer panelType,
		@WebParam(name = "panelType_name") Integer panelType_name,	 
		@WebParam(name = "founderPanels") java.util.List<Integer> founderPanels,
		@WebParam(name = "founderPanels_name") java.util.List<Integer> founderPanels_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Panel> q = getDatabase().query(Panel.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(label != null) q.equals("label", label);
			if(individuals != null) q.equals("individuals", individuals);
			if(species != null) q.equals("species", species);
			if(panelType != null) q.equals("panelType", panelType);
			if(founderPanels != null) q.equals("founderPanels", founderPanels);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "observedValueList")
	public List<ObservedValue> findObservedValue(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "protocolApplication") Integer protocolApplication,
		@WebParam(name = "protocolApplication_name") Integer protocolApplication_name,	 
		@WebParam(name = "feature") Integer feature,
		@WebParam(name = "feature_name") Integer feature_name,	 
		@WebParam(name = "target") Integer target,
		@WebParam(name = "target_name") Integer target_name,	 
		@WebParam(name = "ontologyReference") Integer ontologyReference,
		@WebParam(name = "ontologyReference_name") Integer ontologyReference_name,	 
		@WebParam(name = "value") String value,	 
		@WebParam(name = "relation") Integer relation,
		@WebParam(name = "relation_name") Integer relation_name,	 
		@WebParam(name = "time") java.util.Date time,	 
		@WebParam(name = "endtime") java.util.Date endtime)
	{
		try
		{
			Query<ObservedValue> q = getDatabase().query(ObservedValue.class);
			if(id != null) q.equals("id", id);
			if(investigation != null) q.equals("investigation", investigation);
			if(protocolApplication != null) q.equals("protocolApplication", protocolApplication);
			if(feature != null) q.equals("feature", feature);
			if(target != null) q.equals("target", target);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(value != null) q.equals("value", value);
			if(relation != null) q.equals("relation", relation);
			if(time != null) q.equals("time", time);
			if(endtime != null) q.equals("endtime", endtime);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "observedValueCsv")
	public String findObservedValueCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "protocolApplication") Integer protocolApplication,
		@WebParam(name = "protocolApplication_name") Integer protocolApplication_name,	 
		@WebParam(name = "feature") Integer feature,
		@WebParam(name = "feature_name") Integer feature_name,	 
		@WebParam(name = "target") Integer target,
		@WebParam(name = "target_name") Integer target_name,	 
		@WebParam(name = "ontologyReference") Integer ontologyReference,
		@WebParam(name = "ontologyReference_name") Integer ontologyReference_name,	 
		@WebParam(name = "value") String value,	 
		@WebParam(name = "relation") Integer relation,
		@WebParam(name = "relation_name") Integer relation_name,	 
		@WebParam(name = "time") java.util.Date time,	 
		@WebParam(name = "endtime") java.util.Date endtime)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<ObservedValue> q = getDatabase().query(ObservedValue.class);
			if(id != null) q.equals("id", id);
			if(investigation != null) q.equals("investigation", investigation);
			if(protocolApplication != null) q.equals("protocolApplication", protocolApplication);
			if(feature != null) q.equals("feature", feature);
			if(target != null) q.equals("target", target);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(value != null) q.equals("value", value);
			if(relation != null) q.equals("relation", relation);
			if(time != null) q.equals("time", time);
			if(endtime != null) q.equals("endtime", endtime);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "investigationList")
	public List<Investigation> findInvestigation(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "startDate") java.util.Date startDate,	 
		@WebParam(name = "endDate") java.util.Date endDate,	 
		@WebParam(name = "contacts") java.util.List<Integer> contacts,
		@WebParam(name = "contacts_name") java.util.List<Integer> contacts_name,	 
		@WebParam(name = "accession") String accession)
	{
		try
		{
			Query<Investigation> q = getDatabase().query(Investigation.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(startDate != null) q.equals("startDate", startDate);
			if(endDate != null) q.equals("endDate", endDate);
			if(contacts != null) q.equals("contacts", contacts);
			if(accession != null) q.equals("accession", accession);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "investigationCsv")
	public String findInvestigationCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "startDate") java.util.Date startDate,	 
		@WebParam(name = "endDate") java.util.Date endDate,	 
		@WebParam(name = "contacts") java.util.List<Integer> contacts,
		@WebParam(name = "contacts_name") java.util.List<Integer> contacts_name,	 
		@WebParam(name = "accession") String accession)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Investigation> q = getDatabase().query(Investigation.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(startDate != null) q.equals("startDate", startDate);
			if(endDate != null) q.equals("endDate", endDate);
			if(contacts != null) q.equals("contacts", contacts);
			if(accession != null) q.equals("accession", accession);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "ontologyTermList")
	public List<OntologyTerm> findOntologyTerm(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "ontology") Integer ontology,
		@WebParam(name = "ontology_name") Integer ontology_name,	 
		@WebParam(name = "termAccession") String termAccession,	 
		@WebParam(name = "definition") String definition,	 
		@WebParam(name = "termPath") String termPath)
	{
		try
		{
			Query<OntologyTerm> q = getDatabase().query(OntologyTerm.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(__Type != null) q.equals("__Type", __Type);
			if(ontology != null) q.equals("ontology", ontology);
			if(termAccession != null) q.equals("termAccession", termAccession);
			if(definition != null) q.equals("definition", definition);
			if(termPath != null) q.equals("termPath", termPath);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "ontologyTermCsv")
	public String findOntologyTermCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "ontology") Integer ontology,
		@WebParam(name = "ontology_name") Integer ontology_name,	 
		@WebParam(name = "termAccession") String termAccession,	 
		@WebParam(name = "definition") String definition,	 
		@WebParam(name = "termPath") String termPath)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<OntologyTerm> q = getDatabase().query(OntologyTerm.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(__Type != null) q.equals("__Type", __Type);
			if(ontology != null) q.equals("ontology", ontology);
			if(termAccession != null) q.equals("termAccession", termAccession);
			if(definition != null) q.equals("definition", definition);
			if(termPath != null) q.equals("termPath", termPath);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "ontologyList")
	public List<Ontology> findOntology(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "ontologyAccession") String ontologyAccession,	 
		@WebParam(name = "ontologyURI") String ontologyURI)
	{
		try
		{
			Query<Ontology> q = getDatabase().query(Ontology.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(ontologyAccession != null) q.equals("ontologyAccession", ontologyAccession);
			if(ontologyURI != null) q.equals("ontologyURI", ontologyURI);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "ontologyCsv")
	public String findOntologyCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "ontologyAccession") String ontologyAccession,	 
		@WebParam(name = "ontologyURI") String ontologyURI)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Ontology> q = getDatabase().query(Ontology.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(ontologyAccession != null) q.equals("ontologyAccession", ontologyAccession);
			if(ontologyURI != null) q.equals("ontologyURI", ontologyURI);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "molgenisFileList")
	public List<MolgenisFile> findMolgenisFile(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "extension") String extension)
	{
		try
		{
			Query<MolgenisFile> q = getDatabase().query(MolgenisFile.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(__Type != null) q.equals("__Type", __Type);
			if(extension != null) q.equals("extension", extension);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "molgenisFileCsv")
	public String findMolgenisFileCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "extension") String extension)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<MolgenisFile> q = getDatabase().query(MolgenisFile.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(__Type != null) q.equals("__Type", __Type);
			if(extension != null) q.equals("extension", extension);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "runtimePropertyList")
	public List<RuntimeProperty> findRuntimeProperty(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "value") String value)
	{
		try
		{
			Query<RuntimeProperty> q = getDatabase().query(RuntimeProperty.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(value != null) q.equals("value", value);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "runtimePropertyCsv")
	public String findRuntimePropertyCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "value") String value)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<RuntimeProperty> q = getDatabase().query(RuntimeProperty.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(value != null) q.equals("value", value);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "publicationList")
	public List<Publication> findPublication(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "pubmedID") Integer pubmedID,
		@WebParam(name = "pubmedID_name") Integer pubmedID_name,	 
		@WebParam(name = "dOI") Integer dOI,
		@WebParam(name = "dOI_name") Integer dOI_name,	 
		@WebParam(name = "authorList") String authorList,	 
		@WebParam(name = "title") String title,	 
		@WebParam(name = "status") Integer status,
		@WebParam(name = "status_name") Integer status_name,	 
		@WebParam(name = "year") String year,	 
		@WebParam(name = "journal") String journal)
	{
		try
		{
			Query<Publication> q = getDatabase().query(Publication.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(pubmedID != null) q.equals("pubmedID", pubmedID);
			if(dOI != null) q.equals("dOI", dOI);
			if(authorList != null) q.equals("authorList", authorList);
			if(title != null) q.equals("title", title);
			if(status != null) q.equals("status", status);
			if(year != null) q.equals("year", year);
			if(journal != null) q.equals("journal", journal);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "publicationCsv")
	public String findPublicationCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "pubmedID") Integer pubmedID,
		@WebParam(name = "pubmedID_name") Integer pubmedID_name,	 
		@WebParam(name = "dOI") Integer dOI,
		@WebParam(name = "dOI_name") Integer dOI_name,	 
		@WebParam(name = "authorList") String authorList,	 
		@WebParam(name = "title") String title,	 
		@WebParam(name = "status") Integer status,
		@WebParam(name = "status_name") Integer status_name,	 
		@WebParam(name = "year") String year,	 
		@WebParam(name = "journal") String journal)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Publication> q = getDatabase().query(Publication.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(pubmedID != null) q.equals("pubmedID", pubmedID);
			if(dOI != null) q.equals("dOI", dOI);
			if(authorList != null) q.equals("authorList", authorList);
			if(title != null) q.equals("title", title);
			if(status != null) q.equals("status", status);
			if(year != null) q.equals("year", year);
			if(journal != null) q.equals("journal", journal);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "useCaseList")
	public List<UseCase> findUseCase(	 
		@WebParam(name = "useCaseId") Integer useCaseId,	 
		@WebParam(name = "useCaseName") String useCaseName,	 
		@WebParam(name = "searchType") String searchType)
	{
		try
		{
			Query<UseCase> q = getDatabase().query(UseCase.class);
			if(useCaseId != null) q.equals("useCaseId", useCaseId);
			if(useCaseName != null) q.equals("useCaseName", useCaseName);
			if(searchType != null) q.equals("searchType", searchType);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "useCaseCsv")
	public String findUseCaseCsv(	 
		@WebParam(name = "useCaseId") Integer useCaseId,	 
		@WebParam(name = "useCaseName") String useCaseName,	 
		@WebParam(name = "searchType") String searchType)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<UseCase> q = getDatabase().query(UseCase.class);
			if(useCaseId != null) q.equals("useCaseId", useCaseId);
			if(useCaseName != null) q.equals("useCaseName", useCaseName);
			if(searchType != null) q.equals("searchType", searchType);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "molgenisEntityList")
	public List<MolgenisEntity> findMolgenisEntity(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "type_") String type_,	 
		@WebParam(name = "className") String className)
	{
		try
		{
			Query<MolgenisEntity> q = getDatabase().query(MolgenisEntity.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(type_ != null) q.equals("type_", type_);
			if(className != null) q.equals("className", className);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "molgenisEntityCsv")
	public String findMolgenisEntityCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "type_") String type_,	 
		@WebParam(name = "className") String className)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<MolgenisEntity> q = getDatabase().query(MolgenisEntity.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(type_ != null) q.equals("type_", type_);
			if(className != null) q.equals("className", className);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "protocolList")
	public List<Protocol> findProtocol(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "protocolType") Integer protocolType,
		@WebParam(name = "protocolType_name") Integer protocolType_name,	 
		@WebParam(name = "features") java.util.List<Integer> features,
		@WebParam(name = "features_name") java.util.List<Integer> features_name,	 
		@WebParam(name = "targetFilter") String targetFilter,	 
		@WebParam(name = "contact") Integer contact,
		@WebParam(name = "contact_name") Integer contact_name,	 
		@WebParam(name = "subprotocols") java.util.List<Integer> subprotocols,
		@WebParam(name = "subprotocols_name") java.util.List<Integer> subprotocols_name)
	{
		try
		{
			Query<Protocol> q = getDatabase().query(Protocol.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(protocolType != null) q.equals("protocolType", protocolType);
			if(features != null) q.equals("features", features);
			if(targetFilter != null) q.equals("targetFilter", targetFilter);
			if(contact != null) q.equals("contact", contact);
			if(subprotocols != null) q.equals("subprotocols", subprotocols);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "protocolCsv")
	public String findProtocolCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "protocolType") Integer protocolType,
		@WebParam(name = "protocolType_name") Integer protocolType_name,	 
		@WebParam(name = "features") java.util.List<Integer> features,
		@WebParam(name = "features_name") java.util.List<Integer> features_name,	 
		@WebParam(name = "targetFilter") String targetFilter,	 
		@WebParam(name = "contact") Integer contact,
		@WebParam(name = "contact_name") Integer contact_name,	 
		@WebParam(name = "subprotocols") java.util.List<Integer> subprotocols,
		@WebParam(name = "subprotocols_name") java.util.List<Integer> subprotocols_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Protocol> q = getDatabase().query(Protocol.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(protocolType != null) q.equals("protocolType", protocolType);
			if(features != null) q.equals("features", features);
			if(targetFilter != null) q.equals("targetFilter", targetFilter);
			if(contact != null) q.equals("contact", contact);
			if(subprotocols != null) q.equals("subprotocols", subprotocols);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "protocolApplicationList")
	public List<ProtocolApplication> findProtocolApplication(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "time") java.util.Date time,	 
		@WebParam(name = "protocol") Integer protocol,
		@WebParam(name = "protocol_name") Integer protocol_name,	 
		@WebParam(name = "performer") java.util.List<Integer> performer,
		@WebParam(name = "performer_name") java.util.List<Integer> performer_name)
	{
		try
		{
			Query<ProtocolApplication> q = getDatabase().query(ProtocolApplication.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(time != null) q.equals("time", time);
			if(protocol != null) q.equals("protocol", protocol);
			if(performer != null) q.equals("performer", performer);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "protocolApplicationCsv")
	public String findProtocolApplicationCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "time") java.util.Date time,	 
		@WebParam(name = "protocol") Integer protocol,
		@WebParam(name = "protocol_name") Integer protocol_name,	 
		@WebParam(name = "performer") java.util.List<Integer> performer,
		@WebParam(name = "performer_name") java.util.List<Integer> performer_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<ProtocolApplication> q = getDatabase().query(ProtocolApplication.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(time != null) q.equals("time", time);
			if(protocol != null) q.equals("protocol", protocol);
			if(performer != null) q.equals("performer", performer);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "protocolDocumentList")
	public List<ProtocolDocument> findProtocolDocument(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "extension") String extension,	 
		@WebParam(name = "protocol") Integer protocol,
		@WebParam(name = "protocol_name") Integer protocol_name,	 
		@WebParam(name = "document") String document)
	{
		try
		{
			Query<ProtocolDocument> q = getDatabase().query(ProtocolDocument.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(__Type != null) q.equals("__Type", __Type);
			if(extension != null) q.equals("extension", extension);
			if(protocol != null) q.equals("protocol", protocol);
			if(document != null) q.equals("document", document);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "protocolDocumentCsv")
	public String findProtocolDocumentCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "extension") String extension,	 
		@WebParam(name = "protocol") Integer protocol,
		@WebParam(name = "protocol_name") Integer protocol_name,	 
		@WebParam(name = "document") String document)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<ProtocolDocument> q = getDatabase().query(ProtocolDocument.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(__Type != null) q.equals("__Type", __Type);
			if(extension != null) q.equals("extension", extension);
			if(protocol != null) q.equals("protocol", protocol);
			if(document != null) q.equals("document", document);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "workflowList")
	public List<Workflow> findWorkflow(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "protocolType") Integer protocolType,
		@WebParam(name = "protocolType_name") Integer protocolType_name,	 
		@WebParam(name = "features") java.util.List<Integer> features,
		@WebParam(name = "features_name") java.util.List<Integer> features_name,	 
		@WebParam(name = "targetFilter") String targetFilter,	 
		@WebParam(name = "contact") Integer contact,
		@WebParam(name = "contact_name") Integer contact_name,	 
		@WebParam(name = "subprotocols") java.util.List<Integer> subprotocols,
		@WebParam(name = "subprotocols_name") java.util.List<Integer> subprotocols_name)
	{
		try
		{
			Query<Workflow> q = getDatabase().query(Workflow.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(protocolType != null) q.equals("protocolType", protocolType);
			if(features != null) q.equals("features", features);
			if(targetFilter != null) q.equals("targetFilter", targetFilter);
			if(contact != null) q.equals("contact", contact);
			if(subprotocols != null) q.equals("subprotocols", subprotocols);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "workflowCsv")
	public String findWorkflowCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "description") String description,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name,	 
		@WebParam(name = "ontologyReference") java.util.List<Integer> ontologyReference,
		@WebParam(name = "ontologyReference_name") java.util.List<Integer> ontologyReference_name,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "protocolType") Integer protocolType,
		@WebParam(name = "protocolType_name") Integer protocolType_name,	 
		@WebParam(name = "features") java.util.List<Integer> features,
		@WebParam(name = "features_name") java.util.List<Integer> features_name,	 
		@WebParam(name = "targetFilter") String targetFilter,	 
		@WebParam(name = "contact") Integer contact,
		@WebParam(name = "contact_name") Integer contact_name,	 
		@WebParam(name = "subprotocols") java.util.List<Integer> subprotocols,
		@WebParam(name = "subprotocols_name") java.util.List<Integer> subprotocols_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Workflow> q = getDatabase().query(Workflow.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(description != null) q.equals("description", description);
			if(investigation != null) q.equals("investigation", investigation);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(__Type != null) q.equals("__Type", __Type);
			if(protocolType != null) q.equals("protocolType", protocolType);
			if(features != null) q.equals("features", features);
			if(targetFilter != null) q.equals("targetFilter", targetFilter);
			if(contact != null) q.equals("contact", contact);
			if(subprotocols != null) q.equals("subprotocols", subprotocols);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "workflowElementList")
	public List<WorkflowElement> findWorkflowElement(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "workflow") Integer workflow,
		@WebParam(name = "workflow_name") Integer workflow_name,	 
		@WebParam(name = "protocol") Integer protocol,
		@WebParam(name = "protocol_name") Integer protocol_name,	 
		@WebParam(name = "previousSteps") java.util.List<Integer> previousSteps,
		@WebParam(name = "previousSteps_name") java.util.List<Integer> previousSteps_name)
	{
		try
		{
			Query<WorkflowElement> q = getDatabase().query(WorkflowElement.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(workflow != null) q.equals("workflow", workflow);
			if(protocol != null) q.equals("protocol", protocol);
			if(previousSteps != null) q.equals("previousSteps", previousSteps);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "workflowElementCsv")
	public String findWorkflowElementCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "workflow") Integer workflow,
		@WebParam(name = "workflow_name") Integer workflow_name,	 
		@WebParam(name = "protocol") Integer protocol,
		@WebParam(name = "protocol_name") Integer protocol_name,	 
		@WebParam(name = "previousSteps") java.util.List<Integer> previousSteps,
		@WebParam(name = "previousSteps_name") java.util.List<Integer> previousSteps_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<WorkflowElement> q = getDatabase().query(WorkflowElement.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
			if(workflow != null) q.equals("workflow", workflow);
			if(protocol != null) q.equals("protocol", protocol);
			if(previousSteps != null) q.equals("previousSteps", previousSteps);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "workflowElementParameterList")
	public List<WorkflowElementParameter> findWorkflowElementParameter(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "workflowElement") Integer workflowElement,
		@WebParam(name = "workflowElement_name") Integer workflowElement_name,	 
		@WebParam(name = "parameter") Integer parameter,
		@WebParam(name = "parameter_name") Integer parameter_name,	 
		@WebParam(name = "value") String value)
	{
		try
		{
			Query<WorkflowElementParameter> q = getDatabase().query(WorkflowElementParameter.class);
			if(id != null) q.equals("id", id);
			if(workflowElement != null) q.equals("workflowElement", workflowElement);
			if(parameter != null) q.equals("parameter", parameter);
			if(value != null) q.equals("value", value);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "workflowElementParameterCsv")
	public String findWorkflowElementParameterCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "workflowElement") Integer workflowElement,
		@WebParam(name = "workflowElement_name") Integer workflowElement_name,	 
		@WebParam(name = "parameter") Integer parameter,
		@WebParam(name = "parameter_name") Integer parameter_name,	 
		@WebParam(name = "value") String value)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<WorkflowElementParameter> q = getDatabase().query(WorkflowElementParameter.class);
			if(id != null) q.equals("id", id);
			if(workflowElement != null) q.equals("workflowElement", workflowElement);
			if(parameter != null) q.equals("parameter", parameter);
			if(value != null) q.equals("value", value);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "molgenisRoleList")
	public List<MolgenisRole> findMolgenisRole(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "name") String name)
	{
		try
		{
			Query<MolgenisRole> q = getDatabase().query(MolgenisRole.class);
			if(id != null) q.equals("id", id);
			if(__Type != null) q.equals("__Type", __Type);
			if(name != null) q.equals("name", name);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "molgenisRoleCsv")
	public String findMolgenisRoleCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "name") String name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<MolgenisRole> q = getDatabase().query(MolgenisRole.class);
			if(id != null) q.equals("id", id);
			if(__Type != null) q.equals("__Type", __Type);
			if(name != null) q.equals("name", name);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "molgenisGroupList")
	public List<MolgenisGroup> findMolgenisGroup(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "name") String name)
	{
		try
		{
			Query<MolgenisGroup> q = getDatabase().query(MolgenisGroup.class);
			if(id != null) q.equals("id", id);
			if(__Type != null) q.equals("__Type", __Type);
			if(name != null) q.equals("name", name);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "molgenisGroupCsv")
	public String findMolgenisGroupCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "name") String name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<MolgenisGroup> q = getDatabase().query(MolgenisGroup.class);
			if(id != null) q.equals("id", id);
			if(__Type != null) q.equals("__Type", __Type);
			if(name != null) q.equals("name", name);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "molgenisRoleGroupLinkList")
	public List<MolgenisRoleGroupLink> findMolgenisRoleGroupLink(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "group_") Integer group_,
		@WebParam(name = "group__name") Integer group__name,	 
		@WebParam(name = "role_") Integer role_,
		@WebParam(name = "role__name") Integer role__name)
	{
		try
		{
			Query<MolgenisRoleGroupLink> q = getDatabase().query(MolgenisRoleGroupLink.class);
			if(id != null) q.equals("id", id);
			if(group_ != null) q.equals("group_", group_);
			if(role_ != null) q.equals("role_", role_);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "molgenisRoleGroupLinkCsv")
	public String findMolgenisRoleGroupLinkCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "group_") Integer group_,
		@WebParam(name = "group__name") Integer group__name,	 
		@WebParam(name = "role_") Integer role_,
		@WebParam(name = "role__name") Integer role__name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<MolgenisRoleGroupLink> q = getDatabase().query(MolgenisRoleGroupLink.class);
			if(id != null) q.equals("id", id);
			if(group_ != null) q.equals("group_", group_);
			if(role_ != null) q.equals("role_", role_);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "personList")
	public List<Person> findPerson(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "address") String address,	 
		@WebParam(name = "phone") String phone,	 
		@WebParam(name = "email") String email,	 
		@WebParam(name = "fax") String fax,	 
		@WebParam(name = "tollFreePhone") String tollFreePhone,	 
		@WebParam(name = "city") String city,	 
		@WebParam(name = "country") String country,	 
		@WebParam(name = "firstName") String firstName,	 
		@WebParam(name = "midInitials") String midInitials,	 
		@WebParam(name = "lastName") String lastName,	 
		@WebParam(name = "title") String title,	 
		@WebParam(name = "affiliation") Integer affiliation,
		@WebParam(name = "affiliation_name") Integer affiliation_name,	 
		@WebParam(name = "department") String department,	 
		@WebParam(name = "roles") Integer roles,
		@WebParam(name = "roles_name") Integer roles_name)
	{
		try
		{
			Query<Person> q = getDatabase().query(Person.class);
			if(id != null) q.equals("id", id);
			if(__Type != null) q.equals("__Type", __Type);
			if(name != null) q.equals("name", name);
			if(address != null) q.equals("address", address);
			if(phone != null) q.equals("phone", phone);
			if(email != null) q.equals("email", email);
			if(fax != null) q.equals("fax", fax);
			if(tollFreePhone != null) q.equals("tollFreePhone", tollFreePhone);
			if(city != null) q.equals("city", city);
			if(country != null) q.equals("country", country);
			if(firstName != null) q.equals("firstName", firstName);
			if(midInitials != null) q.equals("midInitials", midInitials);
			if(lastName != null) q.equals("lastName", lastName);
			if(title != null) q.equals("title", title);
			if(affiliation != null) q.equals("affiliation", affiliation);
			if(department != null) q.equals("department", department);
			if(roles != null) q.equals("roles", roles);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "personCsv")
	public String findPersonCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "address") String address,	 
		@WebParam(name = "phone") String phone,	 
		@WebParam(name = "email") String email,	 
		@WebParam(name = "fax") String fax,	 
		@WebParam(name = "tollFreePhone") String tollFreePhone,	 
		@WebParam(name = "city") String city,	 
		@WebParam(name = "country") String country,	 
		@WebParam(name = "firstName") String firstName,	 
		@WebParam(name = "midInitials") String midInitials,	 
		@WebParam(name = "lastName") String lastName,	 
		@WebParam(name = "title") String title,	 
		@WebParam(name = "affiliation") Integer affiliation,
		@WebParam(name = "affiliation_name") Integer affiliation_name,	 
		@WebParam(name = "department") String department,	 
		@WebParam(name = "roles") Integer roles,
		@WebParam(name = "roles_name") Integer roles_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Person> q = getDatabase().query(Person.class);
			if(id != null) q.equals("id", id);
			if(__Type != null) q.equals("__Type", __Type);
			if(name != null) q.equals("name", name);
			if(address != null) q.equals("address", address);
			if(phone != null) q.equals("phone", phone);
			if(email != null) q.equals("email", email);
			if(fax != null) q.equals("fax", fax);
			if(tollFreePhone != null) q.equals("tollFreePhone", tollFreePhone);
			if(city != null) q.equals("city", city);
			if(country != null) q.equals("country", country);
			if(firstName != null) q.equals("firstName", firstName);
			if(midInitials != null) q.equals("midInitials", midInitials);
			if(lastName != null) q.equals("lastName", lastName);
			if(title != null) q.equals("title", title);
			if(affiliation != null) q.equals("affiliation", affiliation);
			if(department != null) q.equals("department", department);
			if(roles != null) q.equals("roles", roles);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "instituteList")
	public List<Institute> findInstitute(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "address") String address,	 
		@WebParam(name = "phone") String phone,	 
		@WebParam(name = "email") String email,	 
		@WebParam(name = "fax") String fax,	 
		@WebParam(name = "tollFreePhone") String tollFreePhone,	 
		@WebParam(name = "city") String city,	 
		@WebParam(name = "country") String country,	 
		@WebParam(name = "name") String name)
	{
		try
		{
			Query<Institute> q = getDatabase().query(Institute.class);
			if(id != null) q.equals("id", id);
			if(address != null) q.equals("address", address);
			if(phone != null) q.equals("phone", phone);
			if(email != null) q.equals("email", email);
			if(fax != null) q.equals("fax", fax);
			if(tollFreePhone != null) q.equals("tollFreePhone", tollFreePhone);
			if(city != null) q.equals("city", city);
			if(country != null) q.equals("country", country);
			if(name != null) q.equals("name", name);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "instituteCsv")
	public String findInstituteCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "address") String address,	 
		@WebParam(name = "phone") String phone,	 
		@WebParam(name = "email") String email,	 
		@WebParam(name = "fax") String fax,	 
		@WebParam(name = "tollFreePhone") String tollFreePhone,	 
		@WebParam(name = "city") String city,	 
		@WebParam(name = "country") String country,	 
		@WebParam(name = "name") String name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Institute> q = getDatabase().query(Institute.class);
			if(id != null) q.equals("id", id);
			if(address != null) q.equals("address", address);
			if(phone != null) q.equals("phone", phone);
			if(email != null) q.equals("email", email);
			if(fax != null) q.equals("fax", fax);
			if(tollFreePhone != null) q.equals("tollFreePhone", tollFreePhone);
			if(city != null) q.equals("city", city);
			if(country != null) q.equals("country", country);
			if(name != null) q.equals("name", name);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "molgenisUserList")
	public List<MolgenisUser> findMolgenisUser(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "address") String address,	 
		@WebParam(name = "phone") String phone,	 
		@WebParam(name = "email") String email,	 
		@WebParam(name = "fax") String fax,	 
		@WebParam(name = "tollFreePhone") String tollFreePhone,	 
		@WebParam(name = "city") String city,	 
		@WebParam(name = "country") String country,	 
		@WebParam(name = "firstName") String firstName,	 
		@WebParam(name = "midInitials") String midInitials,	 
		@WebParam(name = "lastName") String lastName,	 
		@WebParam(name = "title") String title,	 
		@WebParam(name = "affiliation") Integer affiliation,
		@WebParam(name = "affiliation_name") Integer affiliation_name,	 
		@WebParam(name = "department") String department,	 
		@WebParam(name = "roles") Integer roles,
		@WebParam(name = "roles_name") Integer roles_name,	 
		@WebParam(name = "password_") String password_,	 
		@WebParam(name = "activationCode") String activationCode,	 
		@WebParam(name = "active") Boolean active,	 
		@WebParam(name = "superuser") Boolean superuser)
	{
		try
		{
			Query<MolgenisUser> q = getDatabase().query(MolgenisUser.class);
			if(id != null) q.equals("id", id);
			if(__Type != null) q.equals("__Type", __Type);
			if(name != null) q.equals("name", name);
			if(address != null) q.equals("address", address);
			if(phone != null) q.equals("phone", phone);
			if(email != null) q.equals("email", email);
			if(fax != null) q.equals("fax", fax);
			if(tollFreePhone != null) q.equals("tollFreePhone", tollFreePhone);
			if(city != null) q.equals("city", city);
			if(country != null) q.equals("country", country);
			if(firstName != null) q.equals("firstName", firstName);
			if(midInitials != null) q.equals("midInitials", midInitials);
			if(lastName != null) q.equals("lastName", lastName);
			if(title != null) q.equals("title", title);
			if(affiliation != null) q.equals("affiliation", affiliation);
			if(department != null) q.equals("department", department);
			if(roles != null) q.equals("roles", roles);
			if(password_ != null) q.equals("password_", password_);
			if(activationCode != null) q.equals("activationCode", activationCode);
			if(active != null) q.equals("active", active);
			if(superuser != null) q.equals("superuser", superuser);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "molgenisUserCsv")
	public String findMolgenisUserCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "__Type") String __Type,	 
		@WebParam(name = "name") String name,	 
		@WebParam(name = "address") String address,	 
		@WebParam(name = "phone") String phone,	 
		@WebParam(name = "email") String email,	 
		@WebParam(name = "fax") String fax,	 
		@WebParam(name = "tollFreePhone") String tollFreePhone,	 
		@WebParam(name = "city") String city,	 
		@WebParam(name = "country") String country,	 
		@WebParam(name = "firstName") String firstName,	 
		@WebParam(name = "midInitials") String midInitials,	 
		@WebParam(name = "lastName") String lastName,	 
		@WebParam(name = "title") String title,	 
		@WebParam(name = "affiliation") Integer affiliation,
		@WebParam(name = "affiliation_name") Integer affiliation_name,	 
		@WebParam(name = "department") String department,	 
		@WebParam(name = "roles") Integer roles,
		@WebParam(name = "roles_name") Integer roles_name,	 
		@WebParam(name = "password_") String password_,	 
		@WebParam(name = "activationCode") String activationCode,	 
		@WebParam(name = "active") Boolean active,	 
		@WebParam(name = "superuser") Boolean superuser)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<MolgenisUser> q = getDatabase().query(MolgenisUser.class);
			if(id != null) q.equals("id", id);
			if(__Type != null) q.equals("__Type", __Type);
			if(name != null) q.equals("name", name);
			if(address != null) q.equals("address", address);
			if(phone != null) q.equals("phone", phone);
			if(email != null) q.equals("email", email);
			if(fax != null) q.equals("fax", fax);
			if(tollFreePhone != null) q.equals("tollFreePhone", tollFreePhone);
			if(city != null) q.equals("city", city);
			if(country != null) q.equals("country", country);
			if(firstName != null) q.equals("firstName", firstName);
			if(midInitials != null) q.equals("midInitials", midInitials);
			if(lastName != null) q.equals("lastName", lastName);
			if(title != null) q.equals("title", title);
			if(affiliation != null) q.equals("affiliation", affiliation);
			if(department != null) q.equals("department", department);
			if(roles != null) q.equals("roles", roles);
			if(password_ != null) q.equals("password_", password_);
			if(activationCode != null) q.equals("activationCode", activationCode);
			if(active != null) q.equals("active", active);
			if(superuser != null) q.equals("superuser", superuser);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "molgenisPermissionList")
	public List<MolgenisPermission> findMolgenisPermission(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "role_") Integer role_,
		@WebParam(name = "role__name") Integer role__name,	 
		@WebParam(name = "entity") Integer entity,
		@WebParam(name = "entity_className") Integer entity_className,	 
		@WebParam(name = "permission") String permission)
	{
		try
		{
			Query<MolgenisPermission> q = getDatabase().query(MolgenisPermission.class);
			if(id != null) q.equals("id", id);
			if(role_ != null) q.equals("role_", role_);
			if(entity != null) q.equals("entity", entity);
			if(permission != null) q.equals("permission", permission);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "molgenisPermissionCsv")
	public String findMolgenisPermissionCsv(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "role_") Integer role_,
		@WebParam(name = "role__name") Integer role__name,	 
		@WebParam(name = "entity") Integer entity,
		@WebParam(name = "entity_className") Integer entity_className,	 
		@WebParam(name = "permission") String permission)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<MolgenisPermission> q = getDatabase().query(MolgenisPermission.class);
			if(id != null) q.equals("id", id);
			if(role_ != null) q.equals("role_", role_);
			if(entity != null) q.equals("entity", entity);
			if(permission != null) q.equals("permission", permission);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "observationElement_ontolo12449List")
	public List<ObservationElement_Ontolo12449> findObservationElement_Ontolo12449(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "ontologyReference") Integer ontologyReference,
		@WebParam(name = "ontologyReference_name") Integer ontologyReference_name,	 
		@WebParam(name = "investigationElement") Integer investigationElement,
		@WebParam(name = "investigationElement_name") Integer investigationElement_name)
	{
		try
		{
			Query<ObservationElement_Ontolo12449> q = getDatabase().query(ObservationElement_Ontolo12449.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(investigationElement != null) q.equals("investigationElement", investigationElement);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "observationElement_ontolo12449Csv")
	public String findObservationElement_Ontolo12449Csv(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "ontologyReference") Integer ontologyReference,
		@WebParam(name = "ontologyReference_name") Integer ontologyReference_name,	 
		@WebParam(name = "investigationElement") Integer investigationElement,
		@WebParam(name = "investigationElement_name") Integer investigationElement_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<ObservationElement_Ontolo12449> q = getDatabase().query(ObservationElement_Ontolo12449.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(investigationElement != null) q.equals("investigationElement", investigationElement);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "observationElement_AlternateIdList")
	public List<ObservationElement_AlternateId> findObservationElement_AlternateId(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "alternateId") Integer alternateId,
		@WebParam(name = "alternateId_name") Integer alternateId_name,	 
		@WebParam(name = "observationElement") Integer observationElement,
		@WebParam(name = "observationElement_name") Integer observationElement_name)
	{
		try
		{
			Query<ObservationElement_AlternateId> q = getDatabase().query(ObservationElement_AlternateId.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(observationElement != null) q.equals("observationElement", observationElement);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "observationElement_AlternateIdCsv")
	public String findObservationElement_AlternateIdCsv(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "alternateId") Integer alternateId,
		@WebParam(name = "alternateId_name") Integer alternateId_name,	 
		@WebParam(name = "observationElement") Integer observationElement,
		@WebParam(name = "observationElement_name") Integer observationElement_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<ObservationElement_AlternateId> q = getDatabase().query(ObservationElement_AlternateId.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(alternateId != null) q.equals("alternateId", alternateId);
			if(observationElement != null) q.equals("observationElement", observationElement);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "measurement_categoriesList")
	public List<Measurement_Categories> findMeasurement_Categories(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "categories") Integer categories,
		@WebParam(name = "categories_name") Integer categories_name,	 
		@WebParam(name = "measurement") Integer measurement,
		@WebParam(name = "measurement_name") Integer measurement_name)
	{
		try
		{
			Query<Measurement_Categories> q = getDatabase().query(Measurement_Categories.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(categories != null) q.equals("categories", categories);
			if(measurement != null) q.equals("measurement", measurement);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "measurement_categoriesCsv")
	public String findMeasurement_CategoriesCsv(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "categories") Integer categories,
		@WebParam(name = "categories_name") Integer categories_name,	 
		@WebParam(name = "measurement") Integer measurement,
		@WebParam(name = "measurement_name") Integer measurement_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Measurement_Categories> q = getDatabase().query(Measurement_Categories.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(categories != null) q.equals("categories", categories);
			if(measurement != null) q.equals("measurement", measurement);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "panel_IndividualsList")
	public List<Panel_Individuals> findPanel_Individuals(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "individuals") Integer individuals,
		@WebParam(name = "individuals_name") Integer individuals_name,	 
		@WebParam(name = "panel") Integer panel,
		@WebParam(name = "panel_name") Integer panel_name)
	{
		try
		{
			Query<Panel_Individuals> q = getDatabase().query(Panel_Individuals.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(individuals != null) q.equals("individuals", individuals);
			if(panel != null) q.equals("panel", panel);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "panel_IndividualsCsv")
	public String findPanel_IndividualsCsv(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "individuals") Integer individuals,
		@WebParam(name = "individuals_name") Integer individuals_name,	 
		@WebParam(name = "panel") Integer panel,
		@WebParam(name = "panel_name") Integer panel_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Panel_Individuals> q = getDatabase().query(Panel_Individuals.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(individuals != null) q.equals("individuals", individuals);
			if(panel != null) q.equals("panel", panel);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "panel_FounderPanelsList")
	public List<Panel_FounderPanels> findPanel_FounderPanels(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "founderPanels") Integer founderPanels,
		@WebParam(name = "founderPanels_name") Integer founderPanels_name,	 
		@WebParam(name = "panel") Integer panel,
		@WebParam(name = "panel_name") Integer panel_name)
	{
		try
		{
			Query<Panel_FounderPanels> q = getDatabase().query(Panel_FounderPanels.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(founderPanels != null) q.equals("founderPanels", founderPanels);
			if(panel != null) q.equals("panel", panel);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "panel_FounderPanelsCsv")
	public String findPanel_FounderPanelsCsv(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "founderPanels") Integer founderPanels,
		@WebParam(name = "founderPanels_name") Integer founderPanels_name,	 
		@WebParam(name = "panel") Integer panel,
		@WebParam(name = "panel_name") Integer panel_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Panel_FounderPanels> q = getDatabase().query(Panel_FounderPanels.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(founderPanels != null) q.equals("founderPanels", founderPanels);
			if(panel != null) q.equals("panel", panel);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "investigation_contactsList")
	public List<Investigation_Contacts> findInvestigation_Contacts(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "contacts") Integer contacts,
		@WebParam(name = "contacts_name") Integer contacts_name,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name)
	{
		try
		{
			Query<Investigation_Contacts> q = getDatabase().query(Investigation_Contacts.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(contacts != null) q.equals("contacts", contacts);
			if(investigation != null) q.equals("investigation", investigation);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "investigation_contactsCsv")
	public String findInvestigation_ContactsCsv(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "contacts") Integer contacts,
		@WebParam(name = "contacts_name") Integer contacts_name,	 
		@WebParam(name = "investigation") Integer investigation,
		@WebParam(name = "investigation_name") Integer investigation_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Investigation_Contacts> q = getDatabase().query(Investigation_Contacts.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(contacts != null) q.equals("contacts", contacts);
			if(investigation != null) q.equals("investigation", investigation);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "protocol_ontologyReferenceList")
	public List<Protocol_OntologyReference> findProtocol_OntologyReference(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "ontologyReference") Integer ontologyReference,
		@WebParam(name = "ontologyReference_name") Integer ontologyReference_name,	 
		@WebParam(name = "investigationElement") Integer investigationElement,
		@WebParam(name = "investigationElement_name") Integer investigationElement_name)
	{
		try
		{
			Query<Protocol_OntologyReference> q = getDatabase().query(Protocol_OntologyReference.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(investigationElement != null) q.equals("investigationElement", investigationElement);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "protocol_ontologyReferenceCsv")
	public String findProtocol_OntologyReferenceCsv(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "ontologyReference") Integer ontologyReference,
		@WebParam(name = "ontologyReference_name") Integer ontologyReference_name,	 
		@WebParam(name = "investigationElement") Integer investigationElement,
		@WebParam(name = "investigationElement_name") Integer investigationElement_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Protocol_OntologyReference> q = getDatabase().query(Protocol_OntologyReference.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(investigationElement != null) q.equals("investigationElement", investigationElement);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "protocol_FeaturesList")
	public List<Protocol_Features> findProtocol_Features(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "features") Integer features,
		@WebParam(name = "features_name") Integer features_name,	 
		@WebParam(name = "protocol") Integer protocol,
		@WebParam(name = "protocol_name") Integer protocol_name)
	{
		try
		{
			Query<Protocol_Features> q = getDatabase().query(Protocol_Features.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(features != null) q.equals("features", features);
			if(protocol != null) q.equals("protocol", protocol);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "protocol_FeaturesCsv")
	public String findProtocol_FeaturesCsv(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "features") Integer features,
		@WebParam(name = "features_name") Integer features_name,	 
		@WebParam(name = "protocol") Integer protocol,
		@WebParam(name = "protocol_name") Integer protocol_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Protocol_Features> q = getDatabase().query(Protocol_Features.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(features != null) q.equals("features", features);
			if(protocol != null) q.equals("protocol", protocol);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "protocol_subprotocolsList")
	public List<Protocol_Subprotocols> findProtocol_Subprotocols(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "subprotocols") Integer subprotocols,
		@WebParam(name = "subprotocols_name") Integer subprotocols_name,	 
		@WebParam(name = "protocol") Integer protocol,
		@WebParam(name = "protocol_name") Integer protocol_name)
	{
		try
		{
			Query<Protocol_Subprotocols> q = getDatabase().query(Protocol_Subprotocols.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(subprotocols != null) q.equals("subprotocols", subprotocols);
			if(protocol != null) q.equals("protocol", protocol);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "protocol_subprotocolsCsv")
	public String findProtocol_SubprotocolsCsv(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "subprotocols") Integer subprotocols,
		@WebParam(name = "subprotocols_name") Integer subprotocols_name,	 
		@WebParam(name = "protocol") Integer protocol,
		@WebParam(name = "protocol_name") Integer protocol_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<Protocol_Subprotocols> q = getDatabase().query(Protocol_Subprotocols.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(subprotocols != null) q.equals("subprotocols", subprotocols);
			if(protocol != null) q.equals("protocol", protocol);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "protocolApplication_ontol11768List")
	public List<ProtocolApplication_Ontol11768> findProtocolApplication_Ontol11768(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "ontologyReference") Integer ontologyReference,
		@WebParam(name = "ontologyReference_name") Integer ontologyReference_name,	 
		@WebParam(name = "investigationElement") Integer investigationElement,
		@WebParam(name = "investigationElement_name") Integer investigationElement_name)
	{
		try
		{
			Query<ProtocolApplication_Ontol11768> q = getDatabase().query(ProtocolApplication_Ontol11768.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(investigationElement != null) q.equals("investigationElement", investigationElement);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "protocolApplication_ontol11768Csv")
	public String findProtocolApplication_Ontol11768Csv(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "ontologyReference") Integer ontologyReference,
		@WebParam(name = "ontologyReference_name") Integer ontologyReference_name,	 
		@WebParam(name = "investigationElement") Integer investigationElement,
		@WebParam(name = "investigationElement_name") Integer investigationElement_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<ProtocolApplication_Ontol11768> q = getDatabase().query(ProtocolApplication_Ontol11768.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(ontologyReference != null) q.equals("ontologyReference", ontologyReference);
			if(investigationElement != null) q.equals("investigationElement", investigationElement);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "protocolApplication_PerformerList")
	public List<ProtocolApplication_Performer> findProtocolApplication_Performer(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "performer") Integer performer,
		@WebParam(name = "performer_name") Integer performer_name,	 
		@WebParam(name = "protocolApplication") Integer protocolApplication,
		@WebParam(name = "protocolApplication_name") Integer protocolApplication_name)
	{
		try
		{
			Query<ProtocolApplication_Performer> q = getDatabase().query(ProtocolApplication_Performer.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(performer != null) q.equals("performer", performer);
			if(protocolApplication != null) q.equals("protocolApplication", protocolApplication);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "protocolApplication_PerformerCsv")
	public String findProtocolApplication_PerformerCsv(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "performer") Integer performer,
		@WebParam(name = "performer_name") Integer performer_name,	 
		@WebParam(name = "protocolApplication") Integer protocolApplication,
		@WebParam(name = "protocolApplication_name") Integer protocolApplication_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<ProtocolApplication_Performer> q = getDatabase().query(ProtocolApplication_Performer.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(performer != null) q.equals("performer", performer);
			if(protocolApplication != null) q.equals("protocolApplication", protocolApplication);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	@WebMethod()
	@WebResult(name = "workflowElement_PreviousStepsList")
	public List<WorkflowElement_PreviousSteps> findWorkflowElement_PreviousSteps(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "previousSteps") Integer previousSteps,
		@WebParam(name = "previousSteps_name") Integer previousSteps_name,	 
		@WebParam(name = "workflowElement") Integer workflowElement,
		@WebParam(name = "workflowElement_name") Integer workflowElement_name)
	{
		try
		{
			Query<WorkflowElement_PreviousSteps> q = getDatabase().query(WorkflowElement_PreviousSteps.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(previousSteps != null) q.equals("previousSteps", previousSteps);
			if(workflowElement != null) q.equals("workflowElement", workflowElement);
			return q.limit(1000).find(); //safety net of 1000
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod()
	@WebResult(name = "workflowElement_PreviousStepsCsv")
	public String findWorkflowElement_PreviousStepsCsv(	 
		@WebParam(name = "autoid") Integer autoid,	 
		@WebParam(name = "previousSteps") Integer previousSteps,
		@WebParam(name = "previousSteps_name") Integer previousSteps_name,	 
		@WebParam(name = "workflowElement") Integer workflowElement,
		@WebParam(name = "workflowElement_name") Integer workflowElement_name)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<WorkflowElement_PreviousSteps> q = getDatabase().query(WorkflowElement_PreviousSteps.class);
			if(autoid != null) q.equals("autoid", autoid);
			if(previousSteps != null) q.equals("previousSteps", previousSteps);
			if(workflowElement != null) q.equals("workflowElement", workflowElement);
			q.limit(1000).find(new CsvWriter(out)); //safety net of 1000
			out.close();
			return _result.toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	
//CUSTOM SERVICES (defined by 'method' entries in MOLGENIS xml)

	public SoapApi(Database database)
	{
		this.database = database;
	}
	
	// data
	private Database getDatabase() throws DatabaseException, NamingException
	{
		return this.database;
	}
	
	
	private Database database = null;
}
