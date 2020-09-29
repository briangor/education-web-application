package com.brian.educationwebapp.config;

import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author brian
 */
public class MyApplication extends ResourceConfig {

    public MyApplication() {
        register(JerseyObjectMapperProvider.class);
        register(org.glassfish.jersey.media.multipart.MultiPartFeature.class);

        packages("com.brian.educationwebapp.api", "com.fasterxml.jackson.jaxrs");

        property("jersey.config.jsonFeature", "JacksonFeature");
        property("jersey.config.disableMoxyJson.server", true);
    }
}
