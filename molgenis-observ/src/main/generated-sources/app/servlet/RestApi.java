package app.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;

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
import org.molgenis.protocol.Protocol;
import org.molgenis.protocol.ProtocolApplication;
import org.molgenis.protocol.ProtocolDocument;
import org.molgenis.protocol.Workflow;
import org.molgenis.protocol.WorkflowElement;
import org.molgenis.protocol.WorkflowElementParameter;
import org.molgenis.auth.Person;
import org.molgenis.auth.Institute;

/*
Needed

CRUD methods (json/xml/text)
Single item, and in batch
Create    ---->    PUT (difficulty is the autoid so we don't know path!)
Read      ---->    GET
Update    ---->    POST
Delete    ---->    DELETE

QUERY methods (json/xml/text)
List (incl pagination, filters, sort)

SHOW methods (html, precursor for AJAX services)
Show -> show a nice html presentation
New  -> show an edit box for a new record
Edit -> show an edit box for a selected record
List -> show a pagination box for the entity
The interactive methods can build on the CRUD stuff.

*/

@Path("/")
public class RestApi
{
	@Context 
    private ServletContext sc;
    
	@GET
	@Path("/json/species")
	@Produces("application/json")
	public SpeciesList findSpeciesJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new SpeciesList(getDatabase().find(Species.class));
	}
	
	@XmlRootElement(name="species")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class SpeciesList
	{
		public SpeciesList()
		{
		}
		public SpeciesList(List<Species> list)
		{
			this.list = list;
		}
		@XmlElement(name="species")
		public List<Species> list;
	}

	@POST
	@Path("/json/species")
	@Produces("application/json")
	public Species addSpeciesJson(@FormParam("") Species object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/species/{id}")
	@Produces("application/json")
	public Species getSpeciesJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(Species.class, id);
	}
	
	@PUT
	@Path("/json/species/{id}")
	@Produces("application/json")
	public Species updateSpeciesJson(@PathParam("id") Integer id, @FormParam("") Species object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/species/{id}")
	@Produces("application/json")
	public void removeSpeciesJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(Species.class, id));	
	}

	@GET
	@Path("/json/alternateId")
	@Produces("application/json")
	public AlternateIdList findAlternateIdJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new AlternateIdList(getDatabase().find(AlternateId.class));
	}
	
	@XmlRootElement(name="alternateId")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class AlternateIdList
	{
		public AlternateIdList()
		{
		}
		public AlternateIdList(List<AlternateId> list)
		{
			this.list = list;
		}
		@XmlElement(name="alternateId")
		public List<AlternateId> list;
	}

	@POST
	@Path("/json/alternateId")
	@Produces("application/json")
	public AlternateId addAlternateIdJson(@FormParam("") AlternateId object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/alternateId/{id}")
	@Produces("application/json")
	public AlternateId getAlternateIdJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(AlternateId.class, id);
	}
	
	@PUT
	@Path("/json/alternateId/{id}")
	@Produces("application/json")
	public AlternateId updateAlternateIdJson(@PathParam("id") Integer id, @FormParam("") AlternateId object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/alternateId/{id}")
	@Produces("application/json")
	public void removeAlternateIdJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(AlternateId.class, id));	
	}

	@GET
	@Path("/json/observationElement")
	@Produces("application/json")
	public ObservationElementList findObservationElementJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new ObservationElementList(getDatabase().find(ObservationElement.class));
	}
	
	@XmlRootElement(name="observationElement")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class ObservationElementList
	{
		public ObservationElementList()
		{
		}
		public ObservationElementList(List<ObservationElement> list)
		{
			this.list = list;
		}
		@XmlElement(name="observationElement")
		public List<ObservationElement> list;
	}

	@POST
	@Path("/json/observationElement")
	@Produces("application/json")
	public ObservationElement addObservationElementJson(@FormParam("") ObservationElement object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/observationElement/{id}")
	@Produces("application/json")
	public ObservationElement getObservationElementJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(ObservationElement.class, id);
	}
	
	@PUT
	@Path("/json/observationElement/{id}")
	@Produces("application/json")
	public ObservationElement updateObservationElementJson(@PathParam("id") Integer id, @FormParam("") ObservationElement object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/observationElement/{id}")
	@Produces("application/json")
	public void removeObservationElementJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(ObservationElement.class, id));	
	}

	@GET
	@Path("/json/observationTarget")
	@Produces("application/json")
	public ObservationTargetList findObservationTargetJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new ObservationTargetList(getDatabase().find(ObservationTarget.class));
	}
	
	@XmlRootElement(name="observationTarget")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class ObservationTargetList
	{
		public ObservationTargetList()
		{
		}
		public ObservationTargetList(List<ObservationTarget> list)
		{
			this.list = list;
		}
		@XmlElement(name="observationTarget")
		public List<ObservationTarget> list;
	}

	@POST
	@Path("/json/observationTarget")
	@Produces("application/json")
	public ObservationTarget addObservationTargetJson(@FormParam("") ObservationTarget object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/observationTarget/{id}")
	@Produces("application/json")
	public ObservationTarget getObservationTargetJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(ObservationTarget.class, id);
	}
	
	@PUT
	@Path("/json/observationTarget/{id}")
	@Produces("application/json")
	public ObservationTarget updateObservationTargetJson(@PathParam("id") Integer id, @FormParam("") ObservationTarget object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/observationTarget/{id}")
	@Produces("application/json")
	public void removeObservationTargetJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(ObservationTarget.class, id));	
	}

	@GET
	@Path("/json/observableFeature")
	@Produces("application/json")
	public ObservableFeatureList findObservableFeatureJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new ObservableFeatureList(getDatabase().find(ObservableFeature.class));
	}
	
	@XmlRootElement(name="observableFeature")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class ObservableFeatureList
	{
		public ObservableFeatureList()
		{
		}
		public ObservableFeatureList(List<ObservableFeature> list)
		{
			this.list = list;
		}
		@XmlElement(name="observableFeature")
		public List<ObservableFeature> list;
	}

	@POST
	@Path("/json/observableFeature")
	@Produces("application/json")
	public ObservableFeature addObservableFeatureJson(@FormParam("") ObservableFeature object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/observableFeature/{id}")
	@Produces("application/json")
	public ObservableFeature getObservableFeatureJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(ObservableFeature.class, id);
	}
	
	@PUT
	@Path("/json/observableFeature/{id}")
	@Produces("application/json")
	public ObservableFeature updateObservableFeatureJson(@PathParam("id") Integer id, @FormParam("") ObservableFeature object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/observableFeature/{id}")
	@Produces("application/json")
	public void removeObservableFeatureJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(ObservableFeature.class, id));	
	}

	@GET
	@Path("/json/measurement")
	@Produces("application/json")
	public MeasurementList findMeasurementJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new MeasurementList(getDatabase().find(Measurement.class));
	}
	
	@XmlRootElement(name="measurement")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class MeasurementList
	{
		public MeasurementList()
		{
		}
		public MeasurementList(List<Measurement> list)
		{
			this.list = list;
		}
		@XmlElement(name="measurement")
		public List<Measurement> list;
	}

	@POST
	@Path("/json/measurement")
	@Produces("application/json")
	public Measurement addMeasurementJson(@FormParam("") Measurement object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/measurement/{id}")
	@Produces("application/json")
	public Measurement getMeasurementJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(Measurement.class, id);
	}
	
	@PUT
	@Path("/json/measurement/{id}")
	@Produces("application/json")
	public Measurement updateMeasurementJson(@PathParam("id") Integer id, @FormParam("") Measurement object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/measurement/{id}")
	@Produces("application/json")
	public void removeMeasurementJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(Measurement.class, id));	
	}

	@GET
	@Path("/json/category")
	@Produces("application/json")
	public CategoryList findCategoryJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new CategoryList(getDatabase().find(Category.class));
	}
	
	@XmlRootElement(name="category")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class CategoryList
	{
		public CategoryList()
		{
		}
		public CategoryList(List<Category> list)
		{
			this.list = list;
		}
		@XmlElement(name="category")
		public List<Category> list;
	}

	@POST
	@Path("/json/category")
	@Produces("application/json")
	public Category addCategoryJson(@FormParam("") Category object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/category/{id}")
	@Produces("application/json")
	public Category getCategoryJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(Category.class, id);
	}
	
	@PUT
	@Path("/json/category/{id}")
	@Produces("application/json")
	public Category updateCategoryJson(@PathParam("id") Integer id, @FormParam("") Category object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/category/{id}")
	@Produces("application/json")
	public void removeCategoryJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(Category.class, id));	
	}

	@GET
	@Path("/json/individual")
	@Produces("application/json")
	public IndividualList findIndividualJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new IndividualList(getDatabase().find(Individual.class));
	}
	
	@XmlRootElement(name="individual")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class IndividualList
	{
		public IndividualList()
		{
		}
		public IndividualList(List<Individual> list)
		{
			this.list = list;
		}
		@XmlElement(name="individual")
		public List<Individual> list;
	}

	@POST
	@Path("/json/individual")
	@Produces("application/json")
	public Individual addIndividualJson(@FormParam("") Individual object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/individual/{id}")
	@Produces("application/json")
	public Individual getIndividualJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(Individual.class, id);
	}
	
	@PUT
	@Path("/json/individual/{id}")
	@Produces("application/json")
	public Individual updateIndividualJson(@PathParam("id") Integer id, @FormParam("") Individual object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/individual/{id}")
	@Produces("application/json")
	public void removeIndividualJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(Individual.class, id));	
	}

	@GET
	@Path("/json/location")
	@Produces("application/json")
	public LocationList findLocationJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new LocationList(getDatabase().find(Location.class));
	}
	
	@XmlRootElement(name="location")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class LocationList
	{
		public LocationList()
		{
		}
		public LocationList(List<Location> list)
		{
			this.list = list;
		}
		@XmlElement(name="location")
		public List<Location> list;
	}

	@POST
	@Path("/json/location")
	@Produces("application/json")
	public Location addLocationJson(@FormParam("") Location object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/location/{id}")
	@Produces("application/json")
	public Location getLocationJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(Location.class, id);
	}
	
	@PUT
	@Path("/json/location/{id}")
	@Produces("application/json")
	public Location updateLocationJson(@PathParam("id") Integer id, @FormParam("") Location object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/location/{id}")
	@Produces("application/json")
	public void removeLocationJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(Location.class, id));	
	}

	@GET
	@Path("/json/panel")
	@Produces("application/json")
	public PanelList findPanelJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new PanelList(getDatabase().find(Panel.class));
	}
	
	@XmlRootElement(name="panel")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class PanelList
	{
		public PanelList()
		{
		}
		public PanelList(List<Panel> list)
		{
			this.list = list;
		}
		@XmlElement(name="panel")
		public List<Panel> list;
	}

	@POST
	@Path("/json/panel")
	@Produces("application/json")
	public Panel addPanelJson(@FormParam("") Panel object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/panel/{id}")
	@Produces("application/json")
	public Panel getPanelJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(Panel.class, id);
	}
	
	@PUT
	@Path("/json/panel/{id}")
	@Produces("application/json")
	public Panel updatePanelJson(@PathParam("id") Integer id, @FormParam("") Panel object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/panel/{id}")
	@Produces("application/json")
	public void removePanelJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(Panel.class, id));	
	}

	@GET
	@Path("/json/observedValue")
	@Produces("application/json")
	public ObservedValueList findObservedValueJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new ObservedValueList(getDatabase().find(ObservedValue.class));
	}
	
	@XmlRootElement(name="observedValue")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class ObservedValueList
	{
		public ObservedValueList()
		{
		}
		public ObservedValueList(List<ObservedValue> list)
		{
			this.list = list;
		}
		@XmlElement(name="observedValue")
		public List<ObservedValue> list;
	}

	@POST
	@Path("/json/observedValue")
	@Produces("application/json")
	public ObservedValue addObservedValueJson(@FormParam("") ObservedValue object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/observedValue/{id}")
	@Produces("application/json")
	public ObservedValue getObservedValueJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(ObservedValue.class, id);
	}
	
	@PUT
	@Path("/json/observedValue/{id}")
	@Produces("application/json")
	public ObservedValue updateObservedValueJson(@PathParam("id") Integer id, @FormParam("") ObservedValue object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/observedValue/{id}")
	@Produces("application/json")
	public void removeObservedValueJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(ObservedValue.class, id));	
	}

	@GET
	@Path("/json/investigation")
	@Produces("application/json")
	public InvestigationList findInvestigationJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new InvestigationList(getDatabase().find(Investigation.class));
	}
	
	@XmlRootElement(name="investigation")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class InvestigationList
	{
		public InvestigationList()
		{
		}
		public InvestigationList(List<Investigation> list)
		{
			this.list = list;
		}
		@XmlElement(name="investigation")
		public List<Investigation> list;
	}

	@POST
	@Path("/json/investigation")
	@Produces("application/json")
	public Investigation addInvestigationJson(@FormParam("") Investigation object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/investigation/{id}")
	@Produces("application/json")
	public Investigation getInvestigationJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(Investigation.class, id);
	}
	
	@PUT
	@Path("/json/investigation/{id}")
	@Produces("application/json")
	public Investigation updateInvestigationJson(@PathParam("id") Integer id, @FormParam("") Investigation object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/investigation/{id}")
	@Produces("application/json")
	public void removeInvestigationJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(Investigation.class, id));	
	}

	@GET
	@Path("/json/ontologyTerm")
	@Produces("application/json")
	public OntologyTermList findOntologyTermJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new OntologyTermList(getDatabase().find(OntologyTerm.class));
	}
	
	@XmlRootElement(name="ontologyTerm")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class OntologyTermList
	{
		public OntologyTermList()
		{
		}
		public OntologyTermList(List<OntologyTerm> list)
		{
			this.list = list;
		}
		@XmlElement(name="ontologyTerm")
		public List<OntologyTerm> list;
	}

	@POST
	@Path("/json/ontologyTerm")
	@Produces("application/json")
	public OntologyTerm addOntologyTermJson(@FormParam("") OntologyTerm object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/ontologyTerm/{id}")
	@Produces("application/json")
	public OntologyTerm getOntologyTermJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(OntologyTerm.class, id);
	}
	
	@PUT
	@Path("/json/ontologyTerm/{id}")
	@Produces("application/json")
	public OntologyTerm updateOntologyTermJson(@PathParam("id") Integer id, @FormParam("") OntologyTerm object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/ontologyTerm/{id}")
	@Produces("application/json")
	public void removeOntologyTermJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(OntologyTerm.class, id));	
	}

	@GET
	@Path("/json/ontology")
	@Produces("application/json")
	public OntologyList findOntologyJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new OntologyList(getDatabase().find(Ontology.class));
	}
	
	@XmlRootElement(name="ontology")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class OntologyList
	{
		public OntologyList()
		{
		}
		public OntologyList(List<Ontology> list)
		{
			this.list = list;
		}
		@XmlElement(name="ontology")
		public List<Ontology> list;
	}

	@POST
	@Path("/json/ontology")
	@Produces("application/json")
	public Ontology addOntologyJson(@FormParam("") Ontology object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/ontology/{id}")
	@Produces("application/json")
	public Ontology getOntologyJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(Ontology.class, id);
	}
	
	@PUT
	@Path("/json/ontology/{id}")
	@Produces("application/json")
	public Ontology updateOntologyJson(@PathParam("id") Integer id, @FormParam("") Ontology object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/ontology/{id}")
	@Produces("application/json")
	public void removeOntologyJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(Ontology.class, id));	
	}

	@GET
	@Path("/json/molgenisFile")
	@Produces("application/json")
	public MolgenisFileList findMolgenisFileJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new MolgenisFileList(getDatabase().find(MolgenisFile.class));
	}
	
	@XmlRootElement(name="molgenisFile")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class MolgenisFileList
	{
		public MolgenisFileList()
		{
		}
		public MolgenisFileList(List<MolgenisFile> list)
		{
			this.list = list;
		}
		@XmlElement(name="molgenisFile")
		public List<MolgenisFile> list;
	}

	@POST
	@Path("/json/molgenisFile")
	@Produces("application/json")
	public MolgenisFile addMolgenisFileJson(@FormParam("") MolgenisFile object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/molgenisFile/{id}")
	@Produces("application/json")
	public MolgenisFile getMolgenisFileJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(MolgenisFile.class, id);
	}
	
	@PUT
	@Path("/json/molgenisFile/{id}")
	@Produces("application/json")
	public MolgenisFile updateMolgenisFileJson(@PathParam("id") Integer id, @FormParam("") MolgenisFile object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/molgenisFile/{id}")
	@Produces("application/json")
	public void removeMolgenisFileJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(MolgenisFile.class, id));	
	}

	@GET
	@Path("/json/runtimeProperty")
	@Produces("application/json")
	public RuntimePropertyList findRuntimePropertyJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new RuntimePropertyList(getDatabase().find(RuntimeProperty.class));
	}
	
	@XmlRootElement(name="runtimeProperty")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class RuntimePropertyList
	{
		public RuntimePropertyList()
		{
		}
		public RuntimePropertyList(List<RuntimeProperty> list)
		{
			this.list = list;
		}
		@XmlElement(name="runtimeProperty")
		public List<RuntimeProperty> list;
	}

	@POST
	@Path("/json/runtimeProperty")
	@Produces("application/json")
	public RuntimeProperty addRuntimePropertyJson(@FormParam("") RuntimeProperty object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/runtimeProperty/{id}")
	@Produces("application/json")
	public RuntimeProperty getRuntimePropertyJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(RuntimeProperty.class, id);
	}
	
	@PUT
	@Path("/json/runtimeProperty/{id}")
	@Produces("application/json")
	public RuntimeProperty updateRuntimePropertyJson(@PathParam("id") Integer id, @FormParam("") RuntimeProperty object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/runtimeProperty/{id}")
	@Produces("application/json")
	public void removeRuntimePropertyJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(RuntimeProperty.class, id));	
	}

	@GET
	@Path("/json/publication")
	@Produces("application/json")
	public PublicationList findPublicationJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new PublicationList(getDatabase().find(Publication.class));
	}
	
	@XmlRootElement(name="publication")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class PublicationList
	{
		public PublicationList()
		{
		}
		public PublicationList(List<Publication> list)
		{
			this.list = list;
		}
		@XmlElement(name="publication")
		public List<Publication> list;
	}

	@POST
	@Path("/json/publication")
	@Produces("application/json")
	public Publication addPublicationJson(@FormParam("") Publication object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/publication/{id}")
	@Produces("application/json")
	public Publication getPublicationJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(Publication.class, id);
	}
	
	@PUT
	@Path("/json/publication/{id}")
	@Produces("application/json")
	public Publication updatePublicationJson(@PathParam("id") Integer id, @FormParam("") Publication object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/publication/{id}")
	@Produces("application/json")
	public void removePublicationJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(Publication.class, id));	
	}

	@GET
	@Path("/json/useCase")
	@Produces("application/json")
	public UseCaseList findUseCaseJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new UseCaseList(getDatabase().find(UseCase.class));
	}
	
	@XmlRootElement(name="useCase")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class UseCaseList
	{
		public UseCaseList()
		{
		}
		public UseCaseList(List<UseCase> list)
		{
			this.list = list;
		}
		@XmlElement(name="useCase")
		public List<UseCase> list;
	}

	@POST
	@Path("/json/useCase")
	@Produces("application/json")
	public UseCase addUseCaseJson(@FormParam("") UseCase object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/useCase/{UseCaseId}")
	@Produces("application/json")
	public UseCase getUseCaseJson(@PathParam("UseCaseId") Integer UseCaseId) throws DatabaseException, NamingException
	{
		return getDatabase().findById(UseCase.class, UseCaseId);
	}
	
	@PUT
	@Path("/json/useCase/{UseCaseId}")
	@Produces("application/json")
	public UseCase updateUseCaseJson(@PathParam("UseCaseId") Integer UseCaseId, @FormParam("") UseCase object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/useCase/{UseCaseId}")
	@Produces("application/json")
	public void removeUseCaseJson(@PathParam("UseCaseId") Integer UseCaseId) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(UseCase.class, UseCaseId));	
	}

	@GET
	@Path("/json/protocol")
	@Produces("application/json")
	public ProtocolList findProtocolJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new ProtocolList(getDatabase().find(Protocol.class));
	}
	
	@XmlRootElement(name="protocol")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class ProtocolList
	{
		public ProtocolList()
		{
		}
		public ProtocolList(List<Protocol> list)
		{
			this.list = list;
		}
		@XmlElement(name="protocol")
		public List<Protocol> list;
	}

	@POST
	@Path("/json/protocol")
	@Produces("application/json")
	public Protocol addProtocolJson(@FormParam("") Protocol object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/protocol/{id}")
	@Produces("application/json")
	public Protocol getProtocolJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(Protocol.class, id);
	}
	
	@PUT
	@Path("/json/protocol/{id}")
	@Produces("application/json")
	public Protocol updateProtocolJson(@PathParam("id") Integer id, @FormParam("") Protocol object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/protocol/{id}")
	@Produces("application/json")
	public void removeProtocolJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(Protocol.class, id));	
	}

	@GET
	@Path("/json/protocolApplication")
	@Produces("application/json")
	public ProtocolApplicationList findProtocolApplicationJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new ProtocolApplicationList(getDatabase().find(ProtocolApplication.class));
	}
	
	@XmlRootElement(name="protocolApplication")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class ProtocolApplicationList
	{
		public ProtocolApplicationList()
		{
		}
		public ProtocolApplicationList(List<ProtocolApplication> list)
		{
			this.list = list;
		}
		@XmlElement(name="protocolApplication")
		public List<ProtocolApplication> list;
	}

	@POST
	@Path("/json/protocolApplication")
	@Produces("application/json")
	public ProtocolApplication addProtocolApplicationJson(@FormParam("") ProtocolApplication object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/protocolApplication/{id}")
	@Produces("application/json")
	public ProtocolApplication getProtocolApplicationJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(ProtocolApplication.class, id);
	}
	
	@PUT
	@Path("/json/protocolApplication/{id}")
	@Produces("application/json")
	public ProtocolApplication updateProtocolApplicationJson(@PathParam("id") Integer id, @FormParam("") ProtocolApplication object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/protocolApplication/{id}")
	@Produces("application/json")
	public void removeProtocolApplicationJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(ProtocolApplication.class, id));	
	}

	@GET
	@Path("/json/protocolDocument")
	@Produces("application/json")
	public ProtocolDocumentList findProtocolDocumentJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new ProtocolDocumentList(getDatabase().find(ProtocolDocument.class));
	}
	
	@XmlRootElement(name="protocolDocument")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class ProtocolDocumentList
	{
		public ProtocolDocumentList()
		{
		}
		public ProtocolDocumentList(List<ProtocolDocument> list)
		{
			this.list = list;
		}
		@XmlElement(name="protocolDocument")
		public List<ProtocolDocument> list;
	}

	@POST
	@Path("/json/protocolDocument")
	@Produces("application/json")
	public ProtocolDocument addProtocolDocumentJson(@FormParam("") ProtocolDocument object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/protocolDocument/{id}")
	@Produces("application/json")
	public ProtocolDocument getProtocolDocumentJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(ProtocolDocument.class, id);
	}
	
	@PUT
	@Path("/json/protocolDocument/{id}")
	@Produces("application/json")
	public ProtocolDocument updateProtocolDocumentJson(@PathParam("id") Integer id, @FormParam("") ProtocolDocument object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/protocolDocument/{id}")
	@Produces("application/json")
	public void removeProtocolDocumentJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(ProtocolDocument.class, id));	
	}

	@GET
	@Path("/json/workflow")
	@Produces("application/json")
	public WorkflowList findWorkflowJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new WorkflowList(getDatabase().find(Workflow.class));
	}
	
	@XmlRootElement(name="workflow")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class WorkflowList
	{
		public WorkflowList()
		{
		}
		public WorkflowList(List<Workflow> list)
		{
			this.list = list;
		}
		@XmlElement(name="workflow")
		public List<Workflow> list;
	}

	@POST
	@Path("/json/workflow")
	@Produces("application/json")
	public Workflow addWorkflowJson(@FormParam("") Workflow object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/workflow/{id}")
	@Produces("application/json")
	public Workflow getWorkflowJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(Workflow.class, id);
	}
	
	@PUT
	@Path("/json/workflow/{id}")
	@Produces("application/json")
	public Workflow updateWorkflowJson(@PathParam("id") Integer id, @FormParam("") Workflow object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/workflow/{id}")
	@Produces("application/json")
	public void removeWorkflowJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(Workflow.class, id));	
	}

	@GET
	@Path("/json/workflowElement")
	@Produces("application/json")
	public WorkflowElementList findWorkflowElementJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new WorkflowElementList(getDatabase().find(WorkflowElement.class));
	}
	
	@XmlRootElement(name="workflowElement")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class WorkflowElementList
	{
		public WorkflowElementList()
		{
		}
		public WorkflowElementList(List<WorkflowElement> list)
		{
			this.list = list;
		}
		@XmlElement(name="workflowElement")
		public List<WorkflowElement> list;
	}

	@POST
	@Path("/json/workflowElement")
	@Produces("application/json")
	public WorkflowElement addWorkflowElementJson(@FormParam("") WorkflowElement object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/workflowElement/{id}")
	@Produces("application/json")
	public WorkflowElement getWorkflowElementJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(WorkflowElement.class, id);
	}
	
	@PUT
	@Path("/json/workflowElement/{id}")
	@Produces("application/json")
	public WorkflowElement updateWorkflowElementJson(@PathParam("id") Integer id, @FormParam("") WorkflowElement object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/workflowElement/{id}")
	@Produces("application/json")
	public void removeWorkflowElementJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(WorkflowElement.class, id));	
	}

	@GET
	@Path("/json/workflowElementParameter")
	@Produces("application/json")
	public WorkflowElementParameterList findWorkflowElementParameterJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new WorkflowElementParameterList(getDatabase().find(WorkflowElementParameter.class));
	}
	
	@XmlRootElement(name="workflowElementParameter")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class WorkflowElementParameterList
	{
		public WorkflowElementParameterList()
		{
		}
		public WorkflowElementParameterList(List<WorkflowElementParameter> list)
		{
			this.list = list;
		}
		@XmlElement(name="workflowElementParameter")
		public List<WorkflowElementParameter> list;
	}

	@POST
	@Path("/json/workflowElementParameter")
	@Produces("application/json")
	public WorkflowElementParameter addWorkflowElementParameterJson(@FormParam("") WorkflowElementParameter object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/workflowElementParameter/{id}")
	@Produces("application/json")
	public WorkflowElementParameter getWorkflowElementParameterJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(WorkflowElementParameter.class, id);
	}
	
	@PUT
	@Path("/json/workflowElementParameter/{id}")
	@Produces("application/json")
	public WorkflowElementParameter updateWorkflowElementParameterJson(@PathParam("id") Integer id, @FormParam("") WorkflowElementParameter object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/workflowElementParameter/{id}")
	@Produces("application/json")
	public void removeWorkflowElementParameterJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(WorkflowElementParameter.class, id));	
	}

	@GET
	@Path("/json/person")
	@Produces("application/json")
	public PersonList findPersonJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new PersonList(getDatabase().find(Person.class));
	}
	
	@XmlRootElement(name="person")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class PersonList
	{
		public PersonList()
		{
		}
		public PersonList(List<Person> list)
		{
			this.list = list;
		}
		@XmlElement(name="person")
		public List<Person> list;
	}

	@POST
	@Path("/json/person")
	@Produces("application/json")
	public Person addPersonJson(@FormParam("") Person object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/person/{id}")
	@Produces("application/json")
	public Person getPersonJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(Person.class, id);
	}
	
	@PUT
	@Path("/json/person/{id}")
	@Produces("application/json")
	public Person updatePersonJson(@PathParam("id") Integer id, @FormParam("") Person object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/person/{id}")
	@Produces("application/json")
	public void removePersonJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(Person.class, id));	
	}

	@GET
	@Path("/json/institute")
	@Produces("application/json")
	public InstituteList findInstituteJson(String query) throws DatabaseException, NamingException, IOException
	{
		return new InstituteList(getDatabase().find(Institute.class));
	}
	
	@XmlRootElement(name="institute")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class InstituteList
	{
		public InstituteList()
		{
		}
		public InstituteList(List<Institute> list)
		{
			this.list = list;
		}
		@XmlElement(name="institute")
		public List<Institute> list;
	}

	@POST
	@Path("/json/institute")
	@Produces("application/json")
	public Institute addInstituteJson(@FormParam("") Institute object) throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().add(object) > 0)
			return object;
		return null;
	}
	
	@GET
	@Path("/json/institute/{id}")
	@Produces("application/json")
	public Institute getInstituteJson(@PathParam("id") Integer id) throws DatabaseException, NamingException
	{
		return getDatabase().findById(Institute.class, id);
	}
	
	@PUT
	@Path("/json/institute/{id}")
	@Produces("application/json")
	public Institute updateInstituteJson(@PathParam("id") Integer id, @FormParam("") Institute object)  throws DatabaseException, NamingException, IOException
	{
		if(getDatabase().update(object)>0) return object;
		return null;	
	}
	
	@DELETE
	@Path("/json/institute/{id}")
	@Produces("application/json")
	public void removeInstituteJson(@PathParam("id") Integer id) throws DatabaseException, NamingException, IOException
	{
		getDatabase().remove(getDatabase().findById(Institute.class, id));	
	}


	private Database getDatabase() throws DatabaseException, NamingException
	{
		//The datasource is created by the servletcontext!				
		DataSource dataSource = (DataSource)sc.getAttribute("DataSource");
		return app.DatabaseFactory.createInsecure(dataSource, new File("attachedfiles/"));
	}
}
