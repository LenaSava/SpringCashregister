package com.cashregister.controller;

import com.cashregister.domain.Invoice;
import com.cashregister.domain.Product;
import com.cashregister.service.InvoiceService;
import com.cashregister.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class SeniorCashierPageController {
    @Autowired
    private ProductService productService;
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") String id, Model model) {
        invoiceService.delete(Integer.parseInt(id));
        List<Invoice> invoices = invoiceService.getAllInvoices();
        model.addAttribute("invoices", invoices);
        return "seniorCashier";
    }

    @GetMapping("/delete_all")
    public String deleteAll(Model model) {
        invoiceService.deleteAll();
        List<Invoice> invoices = invoiceService.getAllInvoices();
        model.addAttribute("invoices", invoices);
        return "seniorCashier";
    }
}
