package com.learn.dropwizard;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class LearnDWConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @NotEmpty
    private String defaultWaitTimeout = "100";

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

    @JsonProperty
    public String getDefaultWaitTimeout() {
        return defaultWaitTimeout;
    }

    @JsonProperty
    public void setDefaultNameWaitTimeout(String newDefaultWaitTimeout) {
        this.defaultWaitTimeout = newDefaultWaitTimeout;
    }
}
