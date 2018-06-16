package com.learn.dropwizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Custom404Error {
    private final static int NOT_IMPLEMENTED_CODE = 404;
    private final static String NOT_IMPLEMENTED_MESSAGE = "Custom page not found error";


    @JsonProperty
    public long getCode() {
        return NOT_IMPLEMENTED_CODE;
    }

    @JsonProperty
    public String getMessage() {
        return NOT_IMPLEMENTED_MESSAGE;
    }
}
