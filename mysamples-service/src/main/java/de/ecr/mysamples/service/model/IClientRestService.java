package de.ecr.mysamples.service.model;

import de.mydata.http.RestRequest;
import de.mydata.rest.client.model.IResponseHandler;
import de.mydata.rest.server.JettyRestServer;
import org.apache.http.HttpResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Method;

/**
 * @author Bjoern Frohberg, mydata GmbH
 */
@Path("/mysamples")
public interface IClientRestService extends JettyRestServer.IRestService {
    
    @GET
    @Path("/status")
    @Produces(MediaType.TEXT_PLAIN)
    boolean ping();
    
    @GET
    @Path("/verions")
    @Produces(MediaType.APPLICATION_JSON)
    Answer getAnswer();
}
