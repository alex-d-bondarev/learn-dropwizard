package com.learn.dropwizard.resources;

import com.learn.dropwizard.api.Summing;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sum")
@Produces(MediaType.APPLICATION_JSON)
public class SummingResource {

    @GET
    @Path("/{firstArg}/and/{secondArg}")
    public Summing sum(@PathParam("firstArg") int firstArg, @PathParam("secondArg") int secondArg){
        return new Summing(firstArg, secondArg);
    }
}
