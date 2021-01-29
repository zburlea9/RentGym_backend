package com.platform.example.model.entity;

import javax.persistence.*;


@Entity(name = "BankAccount")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bank_number;
    private String security_number;
    private Float amount;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBank_number() {
        return bank_number;
    }

    public void setBank_number(String bank_number) {
        this.bank_number = bank_number;
    }

    public String getSecurity_number() {
        return security_number;
    }

    public void setSecurity_number(String security_number) {
        this.security_number = security_number;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", bank_number='" + bank_number + '\'' +
                ", security_number='" + security_number + '\'' +
                ", amount=" + amount +
                ", user=" + user +
                '}';
    }
}
