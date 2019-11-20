package com.cashregister.controller;

import com.cashregister.domain.Bill;
import com.cashregister.domain.type.BillStatus;
import com.cashregister.service.BillService;
import com.cashregister.service.InvoiceService;
import com.cashregister.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/billsPage")
public class BillsPageController {
    private static final Logger logger = Logger.getLogger(String.valueOf(BillsPageController.class));

    @Autowired
    private BillService billService;

    @GetMapping("/x_report")
    public String xReport(Model model) {
        List<Bill> bills = billService.Report(BillStatus.CANCEL.name());
        return "xReport";
    }

    @GetMapping("/y_report")
    public String yReport(Model model) {
        List<Bill> bills = billService.Report(BillStatus.CONFIRM.name());
        return "yReport";
    }

    @GetMapping("/confirm_bill")
    public String confirmBill(@RequestParam(name = "id") String id, Model model) {
        billService.confirm(Integer.parseInt(id));
        return "billPage";
    }
}
