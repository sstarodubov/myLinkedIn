package com.javabycode.springmvc.controller;

import com.javabycode.springmvc.service.EmailService;
import com.javabycode.springmvc.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;

@Controller
@RequestMapping("/getPassword")
public class ForgotPasswordController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public String getPassword() throws MessagingException {
        emailService.send("staroduber@yandex.ru", "123123123");
        return "test";
    }
}
