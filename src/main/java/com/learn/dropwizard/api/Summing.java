package com.learn.dropwizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Summing {
    private int result;
    private String message = "Result of summing %d and %d";

    public Summing(int firsArg, int secondArg){
        result = firsArg + secondArg;
        message = String.format(message, firsArg, secondArg);
    }

    @JsonProperty
    public int getResult() {
        return result;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }

}
