package com.cashregister.controller;


import com.cashregister.domain.Bill;
import com.cashregister.domain.Invoice;
import com.cashregister.domain.Product;
import com.cashregister.service.BillService;
import com.cashregister.service.InvoiceService;
import com.cashregister.service.ProductService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class CashierPageController {
    private static final Logger logger = Logger.getLogger(String.valueOf(CashierPageController.class));
    @Autowired
    private ProductService productService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private BillService billService;

    @GetMapping("find_product")
    public String filter(@RequestParam(name = "search") String search, Model model ) {
        List<Product> products;
        if( search!= null && !search.isEmpty()) {
            products =productService.findByCode(Integer.parseInt(search));
        } else {
            products = productService.getAllProducts();
        }
        model.addAttribute("products" , products);
        System.out.println(products);
        return "cahierPage";

    }

    @GetMapping("/create_invoice")
    public String createInvoice(@RequestParam(name = "id") String id, Model model ) {
        Invoice invoice = new Invoice();
//        Optional<Product> service = productService.findById(Integer.parseInt(id));
//        User user = request.getSession(true).getAttribute("User");
//        Bill bill = billService.findOrCreate(user.());
//
//        invoice.setProduct_id(service.get().getId());
//        invoice.setCost(service.get().getCost());
//        invoice.setQuantity(service.get().getQuantity());
//        invoice.setUserId(user.getId());
//        invoice.setUserRoleId(user.getRole());
//        invoice.setBillId(bill.getId());


        invoiceService.create(invoice);
        logger.info("Create invoice");
        model.addAttribute("products", productService.getAllProducts());
        logger.info("Get all products");
        return "cahierPage";

    }
}
