package org.speedfirst.ws.controllers;

import org.speedfirst.ws.model.Hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Note, @RestController is only a short cut for original @Controller + @ResponseBody. To produce json, you still
 * have to 1) declare dependency to jackson libs (in spring 4, jackson 1.9.x is marked as deprecated, so better to
 * use jackson 2.x); 2) mark &lt;mvc:driven&gt; in the application context; 3) if you prefer to use JAXB, mark
 * JAXB annotations to your bean (Note, you have to add a constructor without arg to make JAXB work
 */
@RestController
public class HelloController {

    @RequestMapping(value = "rest", method = RequestMethod.GET)
    public Hello getHello(@RequestParam(value = "name", defaultValue = "defaultName") String name) {
        Hello h = new Hello(name);
        return h;
    }
}
