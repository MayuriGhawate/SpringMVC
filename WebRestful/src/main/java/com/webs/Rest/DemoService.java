package com.webs.Rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.research.ws.wadl.Response;

@Path("/hello")
public class DemoService {
	/*@GET
	@Path("/{param}")
	public Response getDemoMessage(@PathParam("param") String msg) {
		 String op="Jersey say: "+msg;
		return Response.status(200).entity(op).build();
		 
	}*/
	
	@GET
	@Path("/getEmployees")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEMps(){
		Employee e1 =new Employee();
		e1.setEmpId(100);
		e1.setEmpName("dggd");
		return e1;
	
	}
	
	
	@GET
	@Path("/xml")
	@Produces(MediaType.TEXT_XML)
	public String getDemoMessage2() {
		return "<?xml version=\"1.0\"?>"+"<hello>welcome"+"</hello>";
	}
	@GET
	@Path("/html")
	@Produces(MediaType.TEXT_HTML)
	public String getDemoMessage3() {
		return "<html>"+"<body>"+"<h1>"+"Hello HTML5 to Jersy"+"</h1>"+"</body>"+"</html>";
	}
	
	@GET
	@Produces("{empId}")
	public javax.ws.rs.core.Response getDemomessage4(@PathParam("empId") String id){
		return javax.ws.rs.core.Response.status(200).entity("Get message").build();

		
	}
	/*@GET
	@Path("{empId}")
	public javax.ws.rs.core.Response getDemomessage5("year")int year,@PathParam("month")int month,@PathParam("day"))
    String date = year +"/"+month+"/"+day;
    return Response.status(200)
    		.entity("");
            .build();

}*/
}
