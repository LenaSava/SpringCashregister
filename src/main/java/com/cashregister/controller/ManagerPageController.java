package com.cashregister.controller;

import com.cashregister.domain.Product;
import com.cashregister.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ManagerPageController {

    @Autowired
    private ProductService productService;

    @GetMapping("/show_create")
    public String createUpdate(Map<String, Object> model) {
        return "createUpdate";
    }
}