package com.platform.example.model.DTO;

import java.time.LocalDate;

public class ReservationAndPaymentDTO {
    private String hour;
    private LocalDate date;
    private Long reservation_id;
    private Long payment_id;
    private Float value;
    private Long user_id;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "ReservationAndPaymentDTO{" +
                "hour='" + hour + '\'' +
                ", date=" + date +
                ", reservation_id=" + reservation_id +
                ", payment_id=" + payment_id +
                ", value=" + value +
                ", user_id=" + user_id +
                '}';
    }
}
