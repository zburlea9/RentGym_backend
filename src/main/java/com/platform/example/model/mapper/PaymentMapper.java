package com.platform.example.model.mapper;

import com.platform.example.model.DTO.PaymentDTO;
import com.platform.example.model.DTO.UserDTO;
import com.platform.example.model.entity.Payment;
import com.platform.example.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

@Mapper
public abstract class PaymentMapper {

    @Autowired
    EntityManager entityManager;

    public abstract PaymentDTO toDTO(Payment payment);

    public abstract Payment toEntity(PaymentDTO paymentDTO);

    public abstract void toEntityUpdate(@MappingTarget Payment payment, PaymentDTO PaymentDTO);
}
