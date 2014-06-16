package org.speedfirst.ws.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping("greeting")
    public String greetByView(@RequestParam(value = "name", defaultValue = "defaultName") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
