package com.javabycode.springmvc.controller;

import com.javabycode.springmvc.model.Account;
import com.javabycode.springmvc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public String getPage() {
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerAccount(@ModelAttribute("account") Account account, Model model) {
        System.out.println(account.getEmail());
        model.addAttribute("name", account.getName());
        return "test";
    }
}
