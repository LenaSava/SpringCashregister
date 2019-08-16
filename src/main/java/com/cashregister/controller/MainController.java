package com.cashregister.controller;


import com.cashregister.domain.Product;
import com.cashregister.repos.ProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private ProductRepos productRepos;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "index";
    }
    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Product> messages = productRepos.findAll();
        model.put("messages", messages);
        return "main";
    }
    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model ) {
        Product product = new Product(text, tag);
        productRepos.save(product);
        Iterable <Product> products = productRepos.findAll();
        model.put("products", products);
        return "main";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model ) {
        Iterable<Product> products;
        if( filter!= null && !filter.isEmpty()) {
            products =productRepos.findByTag(filter);
        } else {
            products = productRepos.findAll();
        }

        model.put("products" , products);
        return "main";
    }
}
