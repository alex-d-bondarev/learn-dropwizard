package com.learn.dropwizard;

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
        // TODO: implement application
    }

}
