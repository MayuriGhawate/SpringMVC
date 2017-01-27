package com.saran.rest.inventory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import com.saran.dao.SchemaRest;


@Path("/v1/inventory") //removed * wildcard to make this more compatible with tomcat
public class V1_inventory {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnAllPcParts() throws Exception {
		
		String returnString = null;
		Response rb = null;	
		JSONArray json = new JSONArray();
		
		try {
			
			SchemaRest dao = new SchemaRest();
			
			json = dao.queryAllPcParts();
			returnString = json.toString();
			
			rb = Response.ok(returnString).build();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return rb;
	}
	
}
