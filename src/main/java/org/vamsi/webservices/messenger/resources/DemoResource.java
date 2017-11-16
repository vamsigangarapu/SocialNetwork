/**
 * 
 */
package org.vamsi.webservices.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * @author vamsi
 *
 */

@Path("/demo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class DemoResource {

	@GET
	public String sample(){
		return "this is to test if the link works";
	}
	
	@GET
	@Path("annotations")
	public String pathParamDemoClass(@MatrixParam ("param") String value, @HeaderParam ("authSessionID") String header, @CookieParam ("cookieName") String cookie){
		
		//Matrix Param have the URL as https://localhost:8080/demo/annotations;value=test
		//Here instead of & that we use in Query Param we use ; in Matrix Param
		
		//HeaderParam is generally used to get the Auth key(custom header) etc values from header
		
		//CookieParam is used to get the cookie value
		
		//Form Param is also one of the type of Path Param
		
		return "Matrix Param value is: "+value+" Header Param value is: "+header+" Cookie Param value is: "+cookie;
	}
	
	@GET
	@Path("/context")
	public String contextParamDemoClass(@Context UriInfo uriInfo){
		
		String path = uriInfo.getAbsolutePath().toString();
		return "path is:" +path;
	}
}
