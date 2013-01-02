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

import org.molgenis.auth.Person;
import org.molgenis.auth.Institute;
import org.molgenis.core.OntologyTerm;
import org.molgenis.core.Ontology;
import org.molgenis.core.MolgenisFile;
import org.molgenis.core.RuntimeProperty;
import org.molgenis.core.Publication;
import org.molgenis.core.UseCase;

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


	private Database getDatabase() throws DatabaseException, NamingException
	{
		//The datasource is created by the servletcontext!				
		DataSource dataSource = (DataSource)sc.getAttribute("DataSource");
		return app.DatabaseFactory.createInsecure(dataSource, new File("attachedfiles/"));
	}
}
