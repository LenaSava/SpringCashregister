package com.cashregister.service.impl;

import com.cashregister.domain.Bill;
import com.cashregister.domain.User;
import com.cashregister.domain.type.BillStatus;
import com.cashregister.repository.BillRepo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class BillServiceImplTest {

    private static final Integer ID = 1;

    @Mock
    private BillRepo billRepo;

    @Mock
    private Bill bill;

    @InjectMocks
    private BillServiceImpl billService;

    @Before
    public void setUp() throws Exception {

    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllBills() {
        billService.getAllBills();
        Mockito.verify(billRepo, Mockito.times(1)).findAll();
    }

    @Test
    public void findOrCreate() {
    }

    @Test
    public void findById() {

    }

    @Test
    public void confirm() {

    }

    @Test
    public void cancel() {
    }

    @Test
    public void report() {
    }

    @Test
    public void create() {
    }

    private Bill createBill(Integer id, Date dates, Double totalCost, User userId, BillStatus status) {

        Bill bill = new Bill();
                bill.setId(id);
        bill.setDates(dates);
        bill.setTotalCost(totalCost);
        bill.setStatus(status);
        bill.setUserId(userId);

        return new Bill();
    }
}