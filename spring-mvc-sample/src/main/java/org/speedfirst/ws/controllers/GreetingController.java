package org.speedfirst.ws.controllers;

import org.speedfirst.ws.model.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class GreetingController {
    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping("greeting")
    public String greetByView(@RequestParam(value = "name", defaultValue = "defaultName") String name, Model model) {
        model.addAttribute("name", name);

        Hello hello = new Hello(name);
        model.addAttribute("hello", hello);

        List<Integer> lists = Arrays.asList(1, 2, 3, 4, 5);
        model.addAttribute("lists", lists);
        return "greeting";
    }

    @RequestMapping(value = "text", produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String getText() {
        return "This is a text content directly returned by controller's @ResponseBody annotation";
    }
}
