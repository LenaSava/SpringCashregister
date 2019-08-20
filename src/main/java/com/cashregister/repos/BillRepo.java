package com.cashregister.repos;

import com.cashregister.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BillRepo extends JpaRepository<Bill, Integer> {
}
