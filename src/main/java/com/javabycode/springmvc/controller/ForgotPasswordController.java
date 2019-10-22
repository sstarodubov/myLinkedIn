package com.javabycode.springmvc.controller;

import com.javabycode.springmvc.helpers.StringRandom;
import com.javabycode.springmvc.model.Account;
import com.javabycode.springmvc.model.ResetPasswordForm;
import com.javabycode.springmvc.service.AccountService;
import com.javabycode.springmvc.service.EmailService;
import com.javabycode.springmvc.service.EmailService;
import com.javabycode.springmvc.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/getPassword")
public class ForgotPasswordController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private SecurityService securityService;

    @GetMapping
    public String getPassword() {
        return "forgottPassword";
    }

    @PostMapping
    public String sendPassword(@ModelAttribute ResetPasswordForm form, HttpServletResponse response, Model model) throws NoSuchAlgorithmException, MessagingException {
        String email = form.getEmail();
        Boolean isCorrectEmail = accountService.checkCorrectnessOfEmail(email);
        if (!isCorrectEmail) {
            response.setStatus(400);
            model.addAttribute("error", "Email is not correct");
            return "forgottPassword";
        }
        Account account = accountService.findByEmail(email);
        if (account == null) {
            response.setStatus(422);
            model.addAttribute("error", "the User is not found");
            return "forgottPassword";
        }
        String newPassword = StringRandom.generateRandomString(8);
        String hashedNewPassword = securityService.generateHashPassword(newPassword + SecurityService.SALT);
        emailService.generateAndSendEmailToResetPassword(email, newPassword);
        accountService.updatePasswordAccount(account, hashedNewPassword);
        response.setStatus(200);
        model.addAttribute("info", "new password is sent to your email");
        return "forgottPassword";
    }
}
