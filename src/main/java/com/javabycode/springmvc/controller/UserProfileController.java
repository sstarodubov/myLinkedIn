package com.javabycode.springmvc.controller;

import com.javabycode.springmvc.model.AccessToken;
import com.javabycode.springmvc.model.Account;
import com.javabycode.springmvc.service.AccessTokenService;
import com.javabycode.springmvc.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/userProfile")
public class UserProfileController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private AccessTokenService accessTokenService;

    @GetMapping(value = "/{userId}")
    public String getUserProfile(@PathVariable String userId, HttpServletResponse response, HttpServletRequest request) {
        String accessTokenValue = securityService.checkAccessToken(request);
        if (accessTokenValue == null) {
            response.setStatus(401);
            return "redirect:/signin";
        }
        AccessToken accessToken = accessTokenService.getAccessTokenByValue(accessTokenValue);
        if (accessToken == null) {
            response.setStatus(422);
            return "redirect:/signin";
        }
        long createdTimestamp = accessToken.getCreated().getTime();
        Date date = new Date();
        long currentTimestamp = date.getTime();
        long difference = currentTimestamp - createdTimestamp;
        if (difference > AccessTokenService.TTL) {
            response.setStatus(422);
            accessTokenService.remove(accessToken);
            return "redirect:/signin";
        }
        Account currentAccount = accessToken.getAccount();
        return "userProfile";
    }
}
