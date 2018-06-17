package com.learn.dropwizard.resources;


import com.learn.dropwizard.api.Custom404Error;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class Custom404Resource {

    @GET
    @Path("/{default: .*}")
    public Custom404Error throwError(){
        return new Custom404Error();
    }
}
