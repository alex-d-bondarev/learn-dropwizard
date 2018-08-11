package com.learn.dropwizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Waiting {
    private long sleepTimeout;
    private String message = "Waited %d milliseconds";

    public Waiting(){
        // Jackson deserialization
    }

    public Waiting(long sleepTimeout){
        this.sleepTimeout = sleepTimeout;
        this.message = String.format(this.message, sleepTimeout);

        try {
            Thread.sleep(sleepTimeout);
        }
        catch (InterruptedException iex){
            System.out.println("Timeout failed");
            iex.printStackTrace();
        }
    }

    @JsonProperty
    public long getSleepTimeout() {
        return sleepTimeout;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }
}
