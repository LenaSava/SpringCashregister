package com.cashregister.repos;

import com.cashregister.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface BillRepo extends CrudRepository<Bill, Integer> {


//    Bill createAndGet(Bill entity);

}
