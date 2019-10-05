package com.javabycode.springmvc;

import com.javabycode.model.Loginer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class Login {

    @RequestMapping(method = RequestMethod.GET)
    public String login() {
        return "signin";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String checkLogin(@ModelAttribute("loginer") Loginer user, BindingResult result, Model model) {
        Map<String, String> db = new HashMap<String, String>();

        db.put("staroduber@yandex.ru", "1234");

        if (result.hasErrors()) {
            model.addAttribute("error", "Something gets wrong");
            return "signin";
        }

        Boolean isRealUser = db.containsKey(user.getEmail());
        String correctPassword = db.get(user.getEmail());
        Boolean isCorrectPassword = correctPassword.equals(user.getPassword());
        if (isRealUser && isCorrectPassword) return "userProfile";
        else {
            model.addAttribute("error", "email or password are wrong");
            return "signin";
        }

    }
}
