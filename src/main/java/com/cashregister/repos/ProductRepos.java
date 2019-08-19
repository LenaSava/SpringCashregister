package com.cashregister.repos;

import com.cashregister.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProductRepos extends JpaRepository<Product, Integer> {
//    List<Product> findByTag(String tag);
    List<Product> findAll();

//    Void create(Product product);
}
