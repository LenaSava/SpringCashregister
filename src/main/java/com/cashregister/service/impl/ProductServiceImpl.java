package com.cashregister.service.impl;

import com.cashregister.domain.Product;
import com.cashregister.repository.ProductRepo;
import com.cashregister.service.ProductService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductService productService;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public void create(Product product) {
        productRepo.save(product);
    }

    @Override
    public void update(int toUpdate, Product product) {
        Product updated = productService.findById(toUpdate).get();
//        Product updated2 = updated.get();
        updated.setCost(product.getCost());
        updated.setName_En(product.getName_En());
        updated.setName_ua(product.getName_ua());
        updated.setCost(product.getCost());
        updated.setQuantity(product.getQuantity());

        productRepo.save(updated);
        System.out.println(updated);
    }


    @Override
    public Optional<Product> findById(int id) {
        try {
            Optional<Product> product = productRepo.findById(id);
            return product;
        } catch (RuntimeException e) {
            String errorMessage = String.format("cannot Products findById");
            throw new ServiceException(errorMessage);
        }
    }

    @Override
    public List<Product> findByCode(int code) {
        try {
            List<Product> product = productRepo.findByCode(code);
            return product;
        } catch (RuntimeException e) {
            String errorMessage = String.format("cannot Products findByCode");
            throw new ServiceException(errorMessage);
        }
    }

    @Override
    public Optional<Product> insertIntoInvoices(int id) {
        return Optional.empty();
    }

    @Override
    public int getNumberOfproducts() {
//        return productRepo.getNumberOfproducts();
        return 0;
    }

    @Override
    public List<Product> findProducts(int currentPage, int rowsPerPage) {
        return null;
    }

    @Override
    public Product getProduct(int code, String name, String name_ua, Double cost, Integer quantity, Integer invoiceId) {
        Product product = new Product();


        product.setCode(code);
        product.setName_En(name);
        product.setName_ua(name_ua);
        product.setCost(cost);
        product.setQuantity(quantity);
//        product.setInvoiceId(findById(invoiceId));

        System.out.println(product);
        return product;
    }
}
