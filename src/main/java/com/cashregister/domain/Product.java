package com.cashregister.domain;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="code")
    private Integer code;
    @Column(name="name_En")
    private String name_En;
    @Column(name="name_ua")
    private String name_ua;
    @Column(name="cost")
    private Double cost;
    @Column(name="quantity")
    private Integer quantity;
//    @Column(name="invoiceId")
//    private Integer invoiceId;
//    @Column(name="invoice")
//    private Invoice invoice;


    public Product() {}

    public Product(Integer id, Integer code, String name_En, String name_ua, Double cost, Integer quantity) {
        this.id = id;
        this.code = code;
        this.name_En = name_En;
        this.name_ua = name_ua;
        this.cost = cost;
        this.quantity = quantity;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName_En() {
        return name_En;
    }

    public void setName_En(String name_En) {
        this.name_En = name_En;
    }

    public String getName_ua() {
        return name_ua;
    }

    public void setName_ua(String name_ua) {
        this.name_ua = name_ua;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

//    public Integer getInvoiceId() {
//        return invoiceId;
//    }
//
//    public void setInvoiceId(Integer invoiceId) {
//        this.invoiceId = invoiceId;
//    }
//
//    public Invoice getInvoice() {
//        return invoice;
//    }
//
//    public void setInvoice(Invoice invoice) {
//        this.invoice = invoice;
    }
//}
