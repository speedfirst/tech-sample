package org.speedfirst.ws.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * This is a test bean annotated by Jackson annotations
 */
public class User {

    @JsonProperty("username")
    public String name;

    @JsonProperty
    public int age;
}
