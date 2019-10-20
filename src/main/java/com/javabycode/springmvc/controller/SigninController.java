package com.javabycode.springmvc.controller;

import com.javabycode.springmvc.helpers.StringRandom;
import com.javabycode.springmvc.model.AccessToken;
import com.javabycode.springmvc.model.Account;
import com.javabycode.springmvc.model.AuthForm;
import com.javabycode.springmvc.service.AccessTokenService;
import com.javabycode.springmvc.service.AccountService;
import com.javabycode.springmvc.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;


@Controller
@RequestMapping("/signin")
public class SigninController {

    @Autowired
    private AccessTokenService service;

    @Autowired
    private AccountService accountService;

    @Autowired
    private SecurityService securityService;

    @GetMapping
    public String getPage() {
        return "signin";
    }

    @PostMapping
    public String handleAuth(@ModelAttribute("authForm") AuthForm form, Model model, HttpServletResponse response) throws NoSuchAlgorithmException {
        String email = form.getEmail();
        Boolean isCorrectEmail = accountService.checkCorrectnessOfEmail(email);
        String password = form.getPassword();
        if (password.equals("") || !isCorrectEmail) {
            sendErrorToView(model, "fill out fields correctly");
            return "signin";
        }
        Account account = accountService.findByEmail(email);
        if (account == null) {
            sendErrorToView(model, "The User is not found");
            return "signin";
        }

        String correctedHashedPassword = account.getPassword();
        String currentHashedPassword = securityService.generateHashPassword(password + SecurityService.SALT);

        if (!correctedHashedPassword.equals(currentHashedPassword)) {
            sendErrorToView(model, "The User is not found");
            return "signin";
        }
        String tokenValue = StringRandom.generateRandomString(60);
        AccessToken accessToken = new AccessToken(AccessTokenService.TTL, account, tokenValue);
        response.setHeader("Authorization", tokenValue);
        service.save(accessToken);
        Cookie cookie = new Cookie("authentication", tokenValue);
        cookie.setMaxAge(3600000);
        response.addCookie(cookie);
        return "redirect: /userProfile/" + account.getId() ;
    }

    private void sendErrorToView(Model model, String message) {
        model.addAttribute("error", message);
    }
}
