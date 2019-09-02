package com.cashregister.controller;


import com.cashregister.domain.Bill;
import com.cashregister.domain.Invoice;
import com.cashregister.domain.Product;
import com.cashregister.domain.User;
import com.cashregister.service.BillService;
import com.cashregister.service.InvoiceService;
import com.cashregister.service.ProductService;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@PreAuthorize("hasAuthority('CASHIER')")
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
            System.out.println(products);
        }
        model.addAttribute("products" , products);
        System.out.println(products);
        return "cahierPage";

    }

    @GetMapping("/create_invoice")
    public String createInvoice(@PathVariable User user,
            @RequestParam(name = "id") String id, Model model ) {
        Invoice invoice = new Invoice();

        Optional<Product> product = productService.findById(Integer.parseInt(id));
        Bill bill = billService.findOrCreate(Integer.parseInt(id));
        invoice.setBillId(bill);
        invoice.setCost(product.get().getCost());
        invoice.setProduct_id(product.get().getId());
        invoice.setQuantity(product.get().getQuantity());
 //       invoice.setUserId(user);
        System.out.println(product);
        System.out.println(invoice);



        invoiceService.create(invoice);
        logger.info("Create invoice");
        model.addAttribute("products", productService.getAllProducts());
        logger.info("Get all products");
        return "cahierPage";

    }
}
