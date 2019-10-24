package com.javabycode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editProfile")
public class EditProfileController {

    @GetMapping
    public String getEditPage() {
        return "editPage";
    }
}
