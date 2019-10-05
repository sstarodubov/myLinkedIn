package com.javabycode.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/email")
public class EmailConfirmation {

    @RequestMapping(method = RequestMethod.GET)
    public String confirmEmail() {
        return "confirmEmail";
    }
}
