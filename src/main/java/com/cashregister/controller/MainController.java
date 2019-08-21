package com.cashregister.controller;


import com.cashregister.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "index";
    }

//    @GetMapping("/login")
//    public String login(Map<String, Object> model) {
//        return "login";
//    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model ) {

        return "cashierPage";
    }
}
