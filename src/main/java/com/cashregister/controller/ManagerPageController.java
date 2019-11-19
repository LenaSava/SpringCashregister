package com.cashregister.controller;

import com.cashregister.domain.Product;
import com.cashregister.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import static org.eclipse.jdt.internal.compiler.problem.ProblemSeverities.Optional;

@Controller
public class ManagerPageController {
    private static final Logger logger = Logger.getLogger(String.valueOf(ManagerPageController.class));

    @Autowired
    private ProductService productService;

    @GetMapping("/show_create")
    public String createUpdate(Map<String, Object> model) {
        return "createUpdate";
    }

    @GetMapping("/edit")
    public String Update(@RequestParam(name = "id") String id, Model model) {
        Optional<Product> product = productService.findById(Integer.parseInt(id));
        Product products = product.get();
        System.out.println(products);


        model.addAttribute("product" , products);
        return "update";
    }


    @GetMapping("/updateFromView")
    public String UpdateFromView(@RequestParam(name = "id") String id,
                                 @RequestParam(name = "code") String code,
                                 @RequestParam(name = "name") String nameEn,
                                 @RequestParam(name = "name_ua") String nameUa,
                                 @RequestParam(name = "cost") String cost,
                                 @RequestParam(name = "quantity") String quantity,
                                 @RequestParam(name = "invoiceId") String invoiceId,
                                 Model model) {

        Product productFromView = productService.getProduct( Integer.parseInt(code), nameEn, nameUa, Double.parseDouble(code), Integer.parseInt(quantity), 1 );
        productService.update(Integer.parseInt(id), productFromView);
        System.out.println(productFromView);

        return "manager";
    }
}
