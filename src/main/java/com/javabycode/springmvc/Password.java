package com.javabycode.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/getpassword")
public class Password {

    @RequestMapping(method = RequestMethod.GET)
    public String getPassword() {
        return "forgottPassword";
    }
}
