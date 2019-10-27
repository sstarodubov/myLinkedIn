package com.javabycode.springmvc.controller;

import com.javabycode.springmvc.model.AccessToken;
import com.javabycode.springmvc.model.Account;
import com.javabycode.springmvc.model.Profile;
import com.javabycode.springmvc.model.Skills;
import com.javabycode.springmvc.service.AccessTokenService;
import com.javabycode.springmvc.service.ProfileService;
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

    @Autowired
    private ProfileService profileService;


    @GetMapping(value = "/{userId}")
    public String getUserProfile(Model model, HttpServletResponse response, HttpServletRequest request) {
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
        String email = currentAccount.getEmail();
        String name = currentAccount.getName();
        String phone = currentAccount.getPhone();
        String lastname = currentAccount.getLastname();

        model.addAttribute("email", email);
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        model.addAttribute("lastname", lastname);

        Profile profile  = profileService.getProfileByAccountId(currentAccount);
        if (profile == null) {
            profile = new Profile();
            profile.setAccount(currentAccount);
            return "userProfile";
        }

        String photo = profile.getPhoto() == null ? "" : profile.getPhoto();
        model.addAttribute("photo", photo);

        Skills skills = profile.getSkills();
        if (skills == null) return "userProfile";
        String softSkills = profile.getSkills().getSoftskills() == null ? "" : profile.getSkills().getSoftskills();
        String hardSkills = profile.getSkills().getHardskills() == null ? "" : profile.getSkills().getHardskills();
        String position = profile.getSkills().getPosition() == null ? "" : profile.getSkills().getPosition();
        model.addAttribute("softSkills", softSkills);
        model.addAttribute("hardSkills", hardSkills);
        model.addAttribute("position", position);
        return "userProfile";
    }
}
