package com.cashregister.domain;

import com.cashregister.domain.type.BillStatus;
import com.cashregister.domain.type.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name="totalCost")
    private Integer totalCost;
    @Column(name="dates")
    private Date dates;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "bill_status", joinColumns = @JoinColumn(name = "bill_id"))
    @Enumerated(value = EnumType.STRING)
    private Set<BillStatus> status;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Set<BillStatus> getStatus() {
        return status;
    }

    public void setStatus(Set<BillStatus> status) {
        this.status = status;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", totalCost=" + totalCost +
                ", dates=" + dates +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}