package com.cashregister.service.impl;

import com.cashregister.domain.Bill;
import com.cashregister.repository.BillRepo;
import com.cashregister.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
//        Bill bill = new Bill();
//        if ( billRepo.findById(userId) != null ) {
//            billRepo.save()
       // }
//        try {
////            return billRepo.findOrCreate(userId);
//        } catch (RuntimeException e) {
//            String errorMessage = String.format("cannot findOrCreate bill");
//            throw new ServiceException(errorMessage);
//        }
        return null;
    }

    @Override
    public void confirm(Integer id) {
 //       billRepo.confirm(id);
    }

    @Override
    public void cancel(Integer id) {

    }

    @Override
    public List<Bill> Report(String status) {
        return null;
    }
}
