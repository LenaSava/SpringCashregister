package com.cashregister.service;


import com.cashregister.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();


    void create(Product product);


    void update(Product product);


    Optional<Product> findById(int id);


    Optional<Product> findByCode(int code);


    Optional<Product> insertIntoInvoices(int id);

    int getNumberOfproducts();

    List<Product> findProducts(int currentPage, int rowsPerPage);

    Product getProduct(int code, String name, String name_ua, Double cost, Integer quantity);

}
