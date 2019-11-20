package com.cashregister.controller;


import com.cashregister.domain.Bill;
import com.cashregister.domain.Invoice;
import com.cashregister.domain.Product;
import com.cashregister.domain.User;
import com.cashregister.domain.type.BillStatus;
import com.cashregister.repository.UserRepo;
import com.cashregister.service.BillService;
import com.cashregister.service.InvoiceService;
import com.cashregister.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
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
    @Autowired
    private UserRepo userRepo;

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
    public String createInvoice(@RequestParam(name = "id") String id, @AuthenticationPrincipal UserDetails currentUser
                                ,Model model ) {
        User user = (User) userRepo.findByUsername(currentUser.getUsername());
        Invoice invoice = new Invoice();
        Bill bill2 = new Bill();
        Optional<Product> product = productService.findById(Integer.parseInt(id));

        bill2.setDates(Calendar.getInstance().getTime());
        bill2.setTotalCost(product.get().getCost());
        bill2.setUserId(user);
        bill2.setStatus(BillStatus.CREATE);

        billService.create(bill2);

        invoice.setCost(product.get().getCost());
        invoice.setProduct_id(product.get().getId());
        invoice.setQuantity(product.get().getQuantity());
        invoice.setBillId(bill2);
        invoice.setUserId(user);

        invoiceService.create(invoice);

        logger.info("Create invoice");
        model.addAttribute("products", productService.getAllProducts());
        logger.info("Get all products");
        return "cahierPage";

    }
}
