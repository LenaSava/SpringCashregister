package com.cashregister.controller;

import com.cashregister.domain.Bill;
import com.cashregister.domain.Invoice;
import com.cashregister.domain.Product;
import com.cashregister.service.BillService;
import com.cashregister.service.InvoiceService;
import com.cashregister.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class MenuPageController {
    private static final Logger logger = Logger.getLogger(String.valueOf(MenuPageController.class));
    @Autowired
    private ProductService productService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private BillService billService;


    @GetMapping("/cashier_page")
    public String cashierPage(Map<String, Object> model) {
        List<Product> products = productService.getAllProducts();
        model.put("products", products);
        return "cahierPage";
    }

    @GetMapping("/senior_cashier_list")
    public String seniorCashierPage(Map<String, Object> model) {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        model.put("invoices", invoices);
        System.out.println(invoices);
        return "seniorCashier";
    }

    @GetMapping("/manager_page")
    public String managerPage(Map<String, Object> model) {
        List<Product> products = productService.getAllProducts();
        model.put("products", products);
        return "manager";
    }

    @GetMapping("/bills_page")
    public String billsPage(Map<String, Object> model) {
        List<Bill> bills = billService.getAllBills();
        model.put("bills", bills);
        return "billsPage";
    }

    @GetMapping("/log_out")
    public String indexPage(Map<String, Object> model) {

        return "index";
    }




}
