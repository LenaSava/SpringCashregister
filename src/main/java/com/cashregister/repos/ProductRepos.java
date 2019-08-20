package com.cashregister.repos;

import com.cashregister.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepos extends JpaRepository<Product, Integer> {
//    List<Product> findByTag(String tag);
    List<Product> findAll();

    List<Product> findByCode(int code);

//    Void create(Product product);
}
