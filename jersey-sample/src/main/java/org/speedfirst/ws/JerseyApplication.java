package org.speedfirst.ws;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.internal.JerseyResourceContext;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.speedfirst.ws.resources.HelloResource;


public class JerseyApplication extends ResourceConfig {

    public JerseyApplication() {
        register(RequestContextFilter.class); // a Spring filter that provides a bridge between JAX-RS and Spring request attributes
        register(JerseyResourceContext.class); // The Jersey Implementation of Resource Context
        register(JacksonFeature.class); // use jackson to do all the json job
        register(HelloResource.class); // the main resource for api
    }
}
