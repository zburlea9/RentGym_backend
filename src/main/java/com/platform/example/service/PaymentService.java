package com.platform.example.service;

import com.platform.example.model.DTO.BankAccountDTO;
import com.platform.example.model.DTO.GymDTO;
import com.platform.example.model.DTO.PaymentDTO;
import com.platform.example.model.entity.Payment;

import java.util.List;

public interface PaymentService {

    PaymentDTO save(PaymentDTO paymentDTO);

    List<PaymentDTO> findAllPaymentsDTO();

    void deletePayment(Long id);

    PaymentDTO findById(Long id);

    PaymentDTO findPaymentByUserId(Long id);
}
