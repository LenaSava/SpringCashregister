package com.cashregister.service.impl;

import com.cashregister.domain.Invoice;
import com.cashregister.repos.InvoiceRepo;
import com.cashregister.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepo invoiceRepo;

    @Override
    public List<Invoice> getAllInvoices() {
        return null;
    }

    @Override
    public void create(Invoice invoice) {

    }

    @Override
    public void update(Invoice invoice) {

    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Optional<Invoice> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void deleteAll() {

    }
}
