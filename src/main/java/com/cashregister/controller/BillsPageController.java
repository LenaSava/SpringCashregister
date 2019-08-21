package com.cashregister.controller;

import com.cashregister.service.BillService;
import com.cashregister.service.InvoiceService;
import com.cashregister.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
public class BillsPageController {
    private static final Logger logger = Logger.getLogger(String.valueOf(BillsPageController.class));

    @Autowired
    private BillService billService;

    @GetMapping("/x_report")
    public String xReport(Model model) {
        return "xReport";
    }

    @GetMapping("/y_report")
    public String yReport(Model model) {
        return "yReport";
    }

    @GetMapping("/confirm_bill")
    public String confirmBill(@RequestParam(name = "id") String id, Model model) {
        billService.confirm(Integer.parseInt(id));
        return "billPage";
    }
}
