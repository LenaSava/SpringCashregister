package com.cashregister.repository;

import com.cashregister.domain.Bill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BillRepo extends CrudRepository<Bill, Integer> {


}
