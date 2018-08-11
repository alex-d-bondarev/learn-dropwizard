package com.learn.dropwizard;

import com.learn.dropwizard.health.HelloHealthCheck;
import com.learn.dropwizard.resources.HelloWorldResource;
import com.learn.dropwizard.resources.Custom404Resource;
import com.learn.dropwizard.resources.SummingResource;
import com.learn.dropwizard.resources.WaitingResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class LearnDWApplication extends Application<LearnDWConfiguration> {

    public static void main(final String[] args) throws Exception {
        new LearnDWApplication().run(args);
    }

    @Override
    public String getName() {
        return "LearnDW";
    }

    @Override
    public void initialize(final Bootstrap<LearnDWConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final LearnDWConfiguration configuration,
                    final Environment environment) {

        final HelloHealthCheck healthCheck =
                new HelloHealthCheck(configuration.getTemplate());
        final Custom404Resource custom404 = new Custom404Resource();
        final SummingResource summing = new SummingResource();
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final WaitingResource waitingResource = new WaitingResource(
                configuration.getDefaultWaitTimeout()
        );



        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(custom404);
        environment.jersey().register(resource);
        environment.jersey().register(summing);
        environment.jersey().register(waitingResource);
    }

}
