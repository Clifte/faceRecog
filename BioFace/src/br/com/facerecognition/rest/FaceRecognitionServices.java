package br.com.facerecognition.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.embeddable.EJBContainer;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.com.facerecognition.entity.GenericServiceBean;
import br.com.facerecognition.entity.Log;

@Path("service")
@Stateless
public class FaceRecognitionServices {
 
	
	private String rootPath = "c:";
 
	@RolesAllowed("App")
	@POST
	@Path("/register/face/{codEmp}/{codServ}/{codUsr}")
	@Produces("application/json;charset=UTF-8")
	@Consumes("multipart/form-data")  
	public Response registerFace(@MultipartForm FileUploadForm form,
								 @PathParam("codEmp") String codEmp,
								 @PathParam("codServ") String codServ,
								 @PathParam("codUsr") String codUsr){
		JsonObjectBuilder job = Json.createObjectBuilder();
		
		String fileName = String.format("%s/%s/%s/%s/%d.jpg",rootPath,
										codEmp,codServ,codUsr,
										Calendar.getInstance().getTime().getTime());
		
		System.out.println("filePath: " + fileName);
		try {
			writeFile(form.getData(), fileName);
			job.add("status", "1");
		} catch (IOException e) {
			e.printStackTrace();
			job.add("status", "0");
		}
		
		return Response.ok(job.build()).build();
	}
	 
	@RolesAllowed("App")
	@GET   
	@Path("/version") 
	@Produces("application/json;charset=UTF-8")	
	public Response version(){
		
		 
		
		//GenericServiceBean gsb = new GenericServiceBean();
		//gsb.createOrUpdate(new Log("Version Query","INFO"));
		 
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("version", "0.1"); 
		job.add("time", new Date().toString()); 
		return Response.ok(job.build()).build();
	}  
	  
	// save to somewhere
	private void writeFile(byte[] content, String filename) throws IOException {

		File file = new File(filename);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fop = new FileOutputStream(file);

		fop.write(content);
		fop.flush();
		fop.close();

	}
	
	
}
