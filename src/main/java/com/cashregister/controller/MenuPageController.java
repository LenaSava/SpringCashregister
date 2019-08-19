package com.cashregister.controller;

import com.cashregister.domain.Product;
import com.cashregister.repos.ProductRepos;
import com.cashregister.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MenuPageController {

    @Autowired
    private ProductService productService;

    @GetMapping("/cashier_page")
    public String cashierPage(Map<String, Object> model) {
        List<Product> products = productService.getAllProducts();
        model.put("products", products);
        return "cahierPage";
    }

    @GetMapping("/senior_cashier_list")
    public String seniorCashierPage(Map<String, Object> model) {

        return "seniorCashier";
    }

    @GetMapping("/manager_page")
    public String managerPage(Map<String, Object> model) {

        return "manager";
    }

    @GetMapping("/bills_page")
    public String billsPage(Map<String, Object> model) {

        return "billsPage";
    }

    @GetMapping("/log_out")
    public String indexPage(Map<String, Object> model) {

        return "index";
    }




}
