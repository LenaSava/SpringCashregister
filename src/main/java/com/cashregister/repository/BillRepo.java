package com.cashregister.repository;

import com.cashregister.domain.Bill;
import com.cashregister.domain.type.BillStatus;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BillRepo extends JpaRepository<Bill, Integer> {

    Bill findById(int id);


      List<Bill> findBillByStatus(BillStatus status);

}
