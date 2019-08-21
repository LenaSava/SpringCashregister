package com.cashregister.service.impl;

import com.cashregister.domain.Invoice;
import com.cashregister.repository.InvoiceRepo;
import com.cashregister.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepo invoiceRepo;

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepo.findAll();
    }

    @Override
    public void create(Invoice invoice) {
        invoiceRepo.save(invoice);
    }

    @Override
    public void update(Invoice invoice) {
        invoiceRepo.save(invoice);
    }

    @Override
    public void delete(Integer id) {
        invoiceRepo.deleteById(id);
    }

    @Override
    public void findById(int id) {
        invoiceRepo.findById(id);
    }

    @Override
    public void deleteAll() {
        invoiceRepo.deleteAll();

    }
}
