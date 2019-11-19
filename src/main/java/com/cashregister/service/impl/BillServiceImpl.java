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
    public Bill findOrCreate(int userId) {

        return null;
    }

    @Override
    public void confirm(Integer id) {
       Bill billa = billRepo.findById(id).get();
       billa.setStatus(Collections.singleton(BillStatus.CONFIRM));
       billRepo.save(billa);
    }

    @Override
    public void cancel(Integer id) {
        Bill billa = billRepo.findById(id).get();
        billa.setStatus(Collections.singleton(BillStatus.CANCEL));
        billRepo.save(billa);
    }

    @Override
    public List<Bill> Report(String status) {
        return (List<Bill>) billRepo.findAll();
    }
}
