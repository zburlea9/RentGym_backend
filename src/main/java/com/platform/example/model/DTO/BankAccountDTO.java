package com.platform.example.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankAccountDTO {

    private Long id;
    private String bank_number;
    private String security_number;
    private Float amount;
    private UserDTO user;

    public BankAccountDTO() {
    }

    public BankAccountDTO(@JsonProperty("id") Long id,
                          @JsonProperty("bank_number") String bankNumber,
                          @JsonProperty("security_number") String securityNumber,
                          @JsonProperty("amount") Float amount,
                          @JsonProperty("user_id") Long userId) {
        this.id = id;
        this.bank_number = bankNumber;
        this.security_number = securityNumber;
        this.amount = amount;
        this.user = new UserDTO();
        user.setId(userId);
    }

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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BankAccountDTO{" +
                "id=" + id +
                ", bank_number='" + bank_number + '\'' +
                ", security_number='" + security_number + '\'' +
                ", amount=" + amount +
                ", user=" + user +
                '}';
    }
}
