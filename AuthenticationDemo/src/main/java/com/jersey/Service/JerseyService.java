package com.jersey.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jersey.Bean.Employee;
import com.jersey.Bean.Employees;

@Path("/employees")
public class JerseyService {
	
	@RolesAllowed("ADMIN")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public Employees getAllEmployees()
	{
		Employees list = new Employees();
		list.setEmployeeList(new ArrayList<Employee>());
		
		list.getEmployeeList().add(new Employee(1, "qwe  lastname"));
		list.getEmployeeList().add(new Employee(2, "gsa  lastname"));
		list.getEmployeeList().add(new Employee(3, "hfd lastname"));
		return list;
	}
	
	@RolesAllowed("ADMIN")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee e)throws URISyntaxException
	{
		if(e==null){
			return Response.status(400).entity("Please add Employee details!!").build();
		}
		if(e.getName()==null){
			return Response.status(400).entity("Please add Employee employee name!!").build();
		}
		return Response.created(new URI("/rest/employees"+e.getId())).build();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployeeById(@PathParam("id") Integer id)
	{
		if(id<0){
			return Response.noContent().build();
		}
		Employee emp = new Employee();
		emp.setId(id);
		emp.setName("Mayuri");
		GenericEntity<Employee>entity = new GenericEntity<Employee>(emp,Employee.class);
		return Response.ok().entity(entity).build();
	}
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployeeById(@PathParam("id") Integer id,Employee e)
	{
		Employee updatedEmployee = new Employee();
		
		if(e.getName()==null){
			return Response.status(400).entity("Please provide the employee name").build();
		}
		updatedEmployee.setId(id);
		updatedEmployee.setName(e.getName());
		
		return Response.ok().entity(updatedEmployee).build();
	}
	@DELETE
	@Path("/{id}")
	public Response deleteEmployeeById(@PathParam("id") Integer id){
		return Response.status(202).entity("Employees deleted").build();
	}

}
