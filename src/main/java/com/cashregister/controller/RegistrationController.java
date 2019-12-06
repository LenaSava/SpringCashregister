package com.cashregister.controller;

import com.cashregister.domain.type.Role;
import com.cashregister.repository.UserRepo;

import com.cashregister.domain.User;
import com.cashregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class RegistrationController {
    private static final Logger logger = Logger.getLogger(String.valueOf(RegistrationController.class));
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {

        return userService.addUser(user);
    }
}