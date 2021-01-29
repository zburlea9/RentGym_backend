package com.platform.example.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentDTO {

    private Long id;
    private Float value;
    private UserDTO user;

    public PaymentDTO() {
    }

    public PaymentDTO(@JsonProperty("id") Long id,
                      @JsonProperty("value") Float value,
                      @JsonProperty("user_id") Long userId) {
        this.id = id;
        this.value = value;
        this.user = new UserDTO();
        user.setId(userId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "id=" + id +
                ", value=" + value +
                ", user=" + user +
                '}';
    }
}
