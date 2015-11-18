package restFul;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bson.Document;

import service.EmployeeService;
import service.EmployeeServiceImpl;

import com.mongodb.client.FindIterable;

@Path("/person")
public class Rest {

	private final EmployeeService employeeService = new EmployeeServiceImpl();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Document createDocument(final @QueryParam("name") String name,final Document document){
		employeeService.saveDocument(document,name);
		return document;
	}
	
	@PUT
	@Path("/detail")
	@Consumes(MediaType.APPLICATION_JSON)
	public Document updateDocument(final @QueryParam("name") String name,final Document document){
		employeeService.updateDocument(document,name);
		return document;
	}
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public FindIterable<Document> getAll(){		
		return employeeService.getDocuments();		
	}
	
	@GET
	@Path("/detail/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Document getPersonById(@PathParam("id") String id){	
		return employeeService.getDocumentById(id);		
	}
	
	@GET
	@Path("/count")
	public Long getCount() {
		return employeeService.getCount();
	}
	
}
