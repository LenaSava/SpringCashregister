package com.cashregister.service;


import com.cashregister.domain.Bill;
import com.cashregister.domain.type.BillStatus;

import java.util.List;

public interface BillService {

    List<Bill> getAllBills();

    Iterable<Bill> findOrCreate(int userId);

    Bill findById(int id);

    void confirm(Integer id);


    void cancel(Integer id);


    void create(Bill bill);

    List<Bill> Report(BillStatus status);

}

