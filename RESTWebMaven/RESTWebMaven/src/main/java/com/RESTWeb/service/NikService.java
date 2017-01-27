package com.RESTWeb.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.RESTWeb.model.Employee;
import com.sun.research.ws.wadl.Response;

@Path("/hello")
public class NikService {
	@GET
	@Path("/getEmployees")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee	getEmp() {
		Employee e =new Employee();
		e.setEmpId(100);
		e.setEmpName("Nikhil");	
		return e;
		}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/xml")
	public String getNikMessage2() {
		return "<?xml version=\"1.0\"?>"+"<hello>welcome"+"</hello>";
	}
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/html")
	public String getNikMessage3() {
		return "<html>"+"<body>"+"<h1>"+"Hello HTML5 to Jersy"+"</h1>"+"</body>"+"</html>";
	}
	
	@GET
	@Path("/{empId}")
	public javax.ws.rs.core.Response getNikMessage4(@PathParam("empId") String id){
		return javax.ws.rs.core.Response.status(200).entity("Get Nikhil Message for Emp empId"+id).build();
	}
	
	@GET
	@Path("/{year}/{month}/{day}")
	public javax.ws.rs.core.Response getNikMessage5(@PathParam("year") int year,@PathParam("month") int month,@PathParam("day") int day){
		String date=year+"/"+month+"/"+day; 
		return javax.ws.rs.core.Response.status(200).entity("Get Nikhil Message5 for year/month/day : "+date).build();
	}
}
