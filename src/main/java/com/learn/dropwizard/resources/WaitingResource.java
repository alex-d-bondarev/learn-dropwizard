package com.learn.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.learn.dropwizard.api.Waiting;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/wait")
@Produces(MediaType.APPLICATION_JSON)
public class WaitingResource {
    private final String defaultWaitTimeout;

    public WaitingResource(String defaultWaitTimeout){
        this.defaultWaitTimeout = defaultWaitTimeout;
    }

    @GET
    @Timed
    public Waiting waitWithTimeout(@QueryParam("timeout") Optional<String> timeout){
        final String waitTimeout = !timeout.isPresent() || timeout.get().equals("")
                                                        ? defaultWaitTimeout
                                                        : timeout.get();
        return new Waiting(Long.parseLong(waitTimeout));
    }
}
