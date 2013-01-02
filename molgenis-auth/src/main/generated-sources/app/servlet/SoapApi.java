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

import org.molgenis.auth.MolgenisRole;
import org.molgenis.auth.MolgenisGroup;
import org.molgenis.auth.MolgenisRoleGroupLink;
import org.molgenis.auth.Person;
import org.molgenis.auth.Institute;
import org.molgenis.auth.MolgenisUser;
import org.molgenis.auth.MolgenisPermission;
import org.molgenis.core.OntologyTerm;
import org.molgenis.core.Ontology;
import org.molgenis.core.MolgenisFile;
import org.molgenis.core.RuntimeProperty;
import org.molgenis.core.Publication;
import org.molgenis.core.UseCase;
import org.molgenis.core.MolgenisEntity;

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

//FIND SERVICES (for each entity)
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
	@WebResult(name = "ontologyTermList")
	public List<OntologyTerm> findOntologyTerm(	 
		@WebParam(name = "id") Integer id,	 
		@WebParam(name = "name") String name,	 
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
		@WebParam(name = "extension") String extension)
	{
		try
		{
			Query<MolgenisFile> q = getDatabase().query(MolgenisFile.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
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
		@WebParam(name = "extension") String extension)
	{
		try
		{
			ByteArrayOutputStream _result = new ByteArrayOutputStream();
			PrintWriter out = new PrintWriter(_result);
			Query<MolgenisFile> q = getDatabase().query(MolgenisFile.class);
			if(id != null) q.equals("id", id);
			if(name != null) q.equals("name", name);
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
