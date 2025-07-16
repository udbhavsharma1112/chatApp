package com.chat;
import io.dropwizard.Configuration;
// import io.dropwizard.db.DataSourceFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
// import javax.validation.constraints.NotNull;
// import javax.validation.Valid;

public class ChatAppConfiguration extends Configuration {
    @JsonProperty
    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }
}