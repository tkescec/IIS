package com.codetome.iis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/xsd")
    public String xsd() {
        return "xsd";
    }

    @GetMapping("/rng")
    public String rng() {
        return "rng";
    }

    @GetMapping("/soap")
    public String soap() {
        return "soap";
    }

    @GetMapping("/jaxb")
    public String jaxb() {
        return "jaxb";
    }

    @GetMapping("/xmlrpc")
    public String xmlrpc() {
        return "xmlrpc";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
