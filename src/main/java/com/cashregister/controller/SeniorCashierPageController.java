package com.cashregister.controller;

import com.cashregister.service.InvoiceService;
import com.cashregister.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SeniorCashierPageController {
    @Autowired
    private ProductService productService;
    @Autowired
    private InvoiceService invoiceService;


}
