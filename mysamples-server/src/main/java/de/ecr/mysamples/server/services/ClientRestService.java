package de.ecr.mysamples.server.services;

import de.ecr.mysamples.service.model.Answer;
import de.ecr.mysamples.service.model.IClientRestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Bjoern Frohberg, mydata GmbH
 */
@Path("/mysamples")
public class ClientRestService implements IClientRestService {
    
    @Override
    @GET
    @Path("/status")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean ping() {
        return true;
    }
    
    @Override
    @GET
    @Path("/verions")
    @Produces(MediaType.APPLICATION_JSON)
    public Answer getAnswer() {
        Answer test = new Answer();
        test.setStatus(true);
        return test;
    }
}
