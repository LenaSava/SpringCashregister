package com.cashregister.service;


import com.cashregister.domain.Bill;

import java.util.List;

public interface BillService {

    List<Bill> getAllBills();

    Bill findOrCreate(int userId);

    void confirm(Integer id);


    void cancel(Integer id);

    List<Bill> Report(String status);

}

