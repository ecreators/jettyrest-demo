package de.ecr.mysamples.service.model;

import de.mydata.rest.server.JettyRestServer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
