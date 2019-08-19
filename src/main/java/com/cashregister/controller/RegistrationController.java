package com.cashregister.controller;


import com.cashregister.domain.Role;
import com.cashregister.repos.UserRepo;

import com.cashregister.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")

    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
//        User userFromDb = userRepo.findByUsername((String) model.get("username"));
        User user2 = new User((String) model.get("username"), (String) model.get("password"));

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

//        user2.setRoles(Collections.singleton(Role.USER));
        user.setRole(Role.VIZITOR);
        userRepo.save(user);

        return "redirect:/login";
    }
}