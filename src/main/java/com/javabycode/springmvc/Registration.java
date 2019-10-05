package com.javabycode.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class Registration {

    @RequestMapping(method = RequestMethod.GET)
    public String register() {
        return "signup";
    }
}
