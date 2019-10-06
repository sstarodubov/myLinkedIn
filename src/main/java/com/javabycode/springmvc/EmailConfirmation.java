package com.javabycode.springmvc;

import com.javabycode.model.Loginer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/email")
public class EmailConfirmation {

    @RequestMapping(method = RequestMethod.GET)
    public String getEmail() {
        return "confirmEmail";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String checkEmail(@ModelAttribute("loginer")Loginer user, BindingResult result, Model model) {
        if (result.hasErrors()) return "confirmEmail";
        return "test";
    }

}
