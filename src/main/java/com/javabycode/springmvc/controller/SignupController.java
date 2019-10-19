package com.javabycode.springmvc.controller;

import com.javabycode.springmvc.model.Account;
import com.javabycode.springmvc.service.AccountService;
import com.javabycode.springmvc.service.SecurityService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private AccountService service;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(method = RequestMethod.GET)
    public String getPage() {
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerAccount(@ModelAttribute("account") Account account, Model model) throws NoSuchAlgorithmException {
        Boolean isInputDataCorrect = service.checkInputFields(account);
        Boolean isEmailCorrect = service.checkCorrectnessOfEmail(account.getEmail());
        Boolean isPhoneCorrect = service.checkNumberPhone(account.getPhone());
        if (!isInputDataCorrect || !isEmailCorrect || !isPhoneCorrect) {
            model.addAttribute("error", "the field is not correct");
            return "signup";
        }
        String email = account.getEmail();
        Account accountInDataBase = service.findByEmail(email);
        if (accountInDataBase == null) {
            String currentPassword = account.getPassword();
            String saltedPassword = currentPassword + SecurityService.SALT;
            String hashedPassword = securityService.generateHashPassword(saltedPassword);
            account.setPassword(hashedPassword);
            service.saveAccount(account);
            return "redirect:/signin";
        }
        model.addAttribute("error", "email is used already");
        return "signup";
    }
}
