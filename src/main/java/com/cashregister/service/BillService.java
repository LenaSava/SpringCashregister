package com.cashregister.service;


import com.cashregister.domain.Bill;

import java.util.List;

public interface BillService {

    List<Bill> getAllBills();

    Iterable<Bill> findOrCreate(int userId);

    Bill findById(int id);

    void confirm(Integer id);


    void cancel(Integer id);

    List<Bill> Report(String status);

    void create(Bill bill);

}

