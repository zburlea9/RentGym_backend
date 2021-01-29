package com.platform.example.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ReservationDTO {

    private Long id;
    private String hour;
    private LocalDate date;
    private PaymentDTO payment;
    private GymDTO gym;

    public ReservationDTO() {
    }

    public ReservationDTO(@JsonProperty("id") Long id,
                          @JsonProperty("hour") String hour,
                          @JsonProperty("date") LocalDate date,
                          @JsonProperty("payment_id") Long paymentId,
                          @JsonProperty("gym_id") Long gymId) {
        this.id = id;
        this.hour = hour;
        this.date = date;
        this.payment = new PaymentDTO();
        payment.setId(paymentId);
        this.gym = new GymDTO();
        gym.setId(gymId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public GymDTO getGym() {
        return gym;
    }

    public void setGym(GymDTO gym) {
        this.gym = gym;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "id=" + id +
                ", hour='" + hour + '\'' +
                ", date=" + date +
                ", payment=" + payment +
                ", gym=" + gym +
                '}';
    }
}
