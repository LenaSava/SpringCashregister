package com.cashregister.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_id")
    private Integer product_id;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User userId;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_role_id")
//    private Role userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bill_id")
    private Bill billId;

    public Invoice() {
    }

    public Invoice(Integer product_id, Double cost, Integer quantity, User userId, Bill billId) {
        this.product_id = product_id;
        this.cost = cost;
        this.quantity = quantity;
        this.userId = userId;
//        this.userRoleId = userRoleId;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }


    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }
}