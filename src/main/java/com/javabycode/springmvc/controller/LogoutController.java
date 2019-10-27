package com.javabycode.springmvc.controller;

import com.javabycode.springmvc.model.AccessToken;
import com.javabycode.springmvc.service.AccessTokenService;
import com.javabycode.springmvc.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @Autowired
    private SecurityService securityService;

    @GetMapping()
    public String logout(HttpServletResponse response) {
    securityService.removeAccessToken(response);
    return "redirect:/signin";
    }
}
