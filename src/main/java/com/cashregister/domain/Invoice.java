package com.cashregister.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_id")
    private Integer product_id;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "userRoleId")
    private Integer userRoleId;

    @Column(name = "billId")
    private Integer billId;

    public Invoice() {
    }

    public Invoice(Integer product_id, Double cost, Integer quantity, Integer userId, Integer userRoleId, Integer billId) {
        this.product_id = product_id;
        this.cost = cost;
        this.quantity = quantity;
        this.userId = userId;
        this.userRoleId = userRoleId;
        this.billId = billId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }
}

