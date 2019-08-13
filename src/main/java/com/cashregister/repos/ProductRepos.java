package com.cashregister.repos;

import com.cashregister.domain.Product;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepos extends CrudRepository<Product, Integer> {
    List<Product> findByTag(String tag);
}
