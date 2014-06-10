package org.speedfirst.ws.resources;

import org.speedfirst.ws.model.Hello;
import org.speedfirst.ws.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloResource {

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Hello greeting() {
        Hello h = new Hello();
        h.setMessage("This is a test hello");
        return h;
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Hello postHello(Hello h) {
        if (h.getMessage() == null || h.getMessage().equals("")) {
            h.setMessage("Message Unset");
        } else {
            h.setMessage(h.getMessage() + " is posted");
        }

        return h;
    }

    /**
     * If you're using a Jackson based bean, you cannot output XML.
     * Otherwise jersey will complain "MessageBodyWriter not found for media type=application/xml"
     */
    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("name") String name) {
        User u = new User();
        u.name = name;
        u.age = (int)(Math.random() * 100);
        return u;
    }

    @PUT
    @Path("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User putUser(User user) {
        user.name = user.name.toUpperCase();
        user.age = -user.age;
        return user;
    }
}
