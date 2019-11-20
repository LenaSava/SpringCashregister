package com.cashregister.service.impl;

import com.cashregister.domain.Bill;
import com.cashregister.domain.type.BillStatus;
import com.cashregister.repository.BillRepo;
import com.cashregister.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepo billRepo;

    @Override
    public List<Bill> getAllBills() {
        return (List<Bill>) billRepo.findAll();
    }

    @Override
    public Iterable<Bill> findOrCreate(int userId) {

        return billRepo.findAllById(Collections.singleton(1));
    }

    @Override
    public Bill findById(int id){
        return billRepo.findAllById(id);
    }

    @Override
    public void confirm(Integer id) {
       Bill billa = billRepo.findById(id).get();
       billa.setStatus(BillStatus.CONFIRM);
       billRepo.save(billa);
    }

    @Override
    public void cancel(Integer id) {
        Bill billa = billRepo.findById(id).get();
        billa.setStatus(BillStatus.CANCEL);
        billRepo.save(billa);
    }


    @Override
    public List<Bill> Report(BillStatus status) {
        List<Bill> list =  billRepo.findBillByStatus(status);
        return list;
    }

    @Override
    public void create(Bill bill) {
        billRepo.save(bill);
    }
}
