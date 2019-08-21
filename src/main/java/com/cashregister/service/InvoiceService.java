package com.cashregister.service;
import com.cashregister.domain.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    List<Invoice> getAllInvoices();


    void create(Invoice invoice);


    void update(Invoice invoice);


    void delete(Integer id);


    public void findById(int id);

    void deleteAll();

}
