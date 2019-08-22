package com.cashregister.controller;


import com.cashregister.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(String.valueOf(UserController.class));
    @Autowired
    private UserRepo userRepo;

}
