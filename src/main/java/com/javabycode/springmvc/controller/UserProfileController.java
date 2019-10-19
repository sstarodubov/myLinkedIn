package com.javabycode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/userProfile")
public class UserProfileController {

    @GetMapping(value = "/{userId}")

    public String getUserProfile(@PathVariable String userId, @RequestParam String accessToken) {
        if (accessToken == null) return "signin";
        return "userProfile";
    }
}
