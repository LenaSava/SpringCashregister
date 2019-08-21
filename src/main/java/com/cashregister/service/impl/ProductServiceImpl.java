package com.cashregister.service.impl;

import com.cashregister.domain.Product;
import com.cashregister.repository.ProductRepos;
import com.cashregister.service.ProductService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepos productRepo;

    public ProductServiceImpl(ProductRepos productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public void create(Product product) {
 //       productRepo.create(product);
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Optional<Product> findById(int id) {
        return Optional.empty();
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
        return 0;
    }

    @Override
    public List<Product> findProducts(int currentPage, int rowsPerPage) {
        return null;
    }

    @Override
    public Product getProduct(int code, String name, String name_ua, Double cost, Integer quantity) {
        Product product = new Product();

        product.setCode(code);
        product.setName_En(name);
        product.setName_ua(name_ua);
        product.setCost(cost);
        product.setQuantity(quantity);

        return product;
    }
}
