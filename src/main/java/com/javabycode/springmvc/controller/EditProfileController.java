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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/editProfile")
public class EditProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private AccessTokenService accessTokenService;

    private static String UPLOADED_FOLDER = "/home/haxul/IdeaProjects/realProject/spring-mvc-hibernate-mysql-integration-crud-example/upload/";

    @GetMapping()
    public String getEditPage(HttpServletResponse response, HttpServletRequest request, Model model) {
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

        Boolean isAccessTokenLive = accessTokenService.checkAccessTokenTTL(accessToken);
        if (!isAccessTokenLive) {
            response.setStatus(422);
            accessTokenService.remove(accessToken);
            return "redirect:/signin";
        }
        Account currentAccount = accessToken.getAccount();
        model.addAttribute("name", currentAccount.getName());
        model.addAttribute("lastname", currentAccount.getLastname());
        model.addAttribute("phone", currentAccount.getPhone());
        model.addAttribute("email", currentAccount.getEmail());
        Profile profile = profileService.getProfileByAccountId(currentAccount);
        if (profile == null) return "editPage";
        model.addAttribute("photoSrc", profile.getPhoto());
        Skills skills = profile.getSkills();
        if (skills == null) return "editPage";
        String softSkills = profile.getSkills().getSoftskills() == null ? "" : profile.getSkills().getSoftskills();
        String hardSkills = profile.getSkills().getHardskills() == null ? "" : profile.getSkills().getHardskills();
        String position = profile.getSkills().getPosition() == null ? "" : profile.getSkills().getPosition();
        model.addAttribute("softSkills", softSkills);
        model.addAttribute("hardSkills", hardSkills);
        model.addAttribute("position", position);
        return "editPage";
    }

    @PostMapping
    public String saveSettings(
            @RequestParam("photo") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastname,
            @RequestParam("email") String email,
            @RequestParam("position") String position,
            @RequestParam("phone") String phone,
            @RequestParam("softSkills") String softSkills,
            @RequestParam("hardSkills") String hardSkills,
            HttpServletResponse response,
            HttpServletRequest request) throws IOException {

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

        Boolean isAccessTokenLive = accessTokenService.checkAccessTokenTTL(accessToken);
        if (!isAccessTokenLive) {
            response.setStatus(422);
            accessTokenService.remove(accessToken);
            return "redirect:/signin";
        }

        Account currentAccount = accessToken.getAccount();

        currentAccount.setName(name);
        currentAccount.setLastname(lastname);
        currentAccount.setPhone(phone);
        currentAccount.setEmail(email);

        Profile profile = profileService.getProfileByAccountId(currentAccount);
        if (profile == null) profile = new Profile();

        Skills skills = new Skills();
        skills.setHardskills(hardSkills);
        skills.setSoftskills(softSkills);
        skills.setPosition(position);

        profile.setAccount(currentAccount);
        profile.setSkills(skills);

        byte[] bytes = file.getBytes();
        if (!file.isEmpty()) {
            String fileSrc = UPLOADED_FOLDER + file.getOriginalFilename();
            Path path = Paths.get(fileSrc);
            Files.write(path, bytes);
            profile.setPhoto(fileSrc);
        }
        profileService.saveOrUpdateProfile(profile);
        return "test";
    }
}
