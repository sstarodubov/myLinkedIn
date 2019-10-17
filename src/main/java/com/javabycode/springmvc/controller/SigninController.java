package com.javabycode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/signin")
public class SigninController {

    @GetMapping
    public String getPage() {
        return "signin";
    }
}
