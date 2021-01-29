package com.platform.example.service.impl;

import com.platform.example.model.DTO.BankAccountDTO;
import com.platform.example.model.DTO.PaymentDTO;
import com.platform.example.model.entity.Gym;
import com.platform.example.model.entity.Payment;
import com.platform.example.model.mapper.PaymentMapper;
import com.platform.example.repository.PaymentRepository;
import com.platform.example.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public PaymentDTO save(PaymentDTO paymentDTO) {
        Payment payment;
        if(paymentDTO.getId()!=null){
            payment = paymentRepository.findById(paymentDTO.getId())
                    .orElseThrow(() -> { throw new EntityNotFoundException("Cannot find gym with ID: " + paymentDTO.getId()); } );

        }else{
            payment = new Payment();
        }
        paymentMapper.toEntityUpdate(payment,paymentDTO);
        return paymentMapper.toDTO(paymentRepository.save(payment));
    }

    @Override
    public List<PaymentDTO> findAllPaymentsDTO() {
        return paymentRepository.findAll().
                stream().
                map(paymentMapper::toDTO).
                collect(Collectors.toList());
    }

    @Override
    public void deletePayment(Long id) {
        final Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> { throw new EntityNotFoundException("Cannot find payment with ID: " + id); } );

        paymentRepository.delete(payment);
    }

    @Override
    public PaymentDTO findById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> { throw new EntityNotFoundException("Cannot find payment with ID: " + id); } );
        return paymentMapper.toDTO(payment);
    }

    @Override
    public PaymentDTO findPaymentByUserId(Long userId) {
        return paymentMapper.toDTO(paymentRepository.findByUserId(userId));
    }
}
