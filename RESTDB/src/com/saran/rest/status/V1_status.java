package com.saran.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.codehaus.jettison.json.JSONArray;

import com.saran.dao.*;


@Path("/v1/status") //removed * wildcard to make this more compatible with tomcat
public class V1_status {

	private static final String api_version = "00.02.00"; //version of the api
	
	/**
	 * This method sits at the root of the api.  It will return the name
	 * of this api.
	 * 
	 * @return String - Title of the api
	 */
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle() {
		return "<p>Java Web Service</p>";
	}
	
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion() {
		return "<p>Version:</p>" + api_version;
	}
	
	
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception {
		
		String myString = null;
		String returnString = null;
		JSONArray json = new JSONArray();
		
		try {
			
			SchemaRest dao = new SchemaRest();
			
			json = dao.queryCheckDbConnection();
			myString = json.toString();
			
			returnString = "<p>Database Status</p> " +
				"<p>Database Date/Time return: " + myString + "</p>";
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnString; 
	}
	
}
