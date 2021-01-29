package com.platform.example.model.mapper;

import com.platform.example.model.DTO.BankAccountDTO;
import com.platform.example.model.DTO.UserDTO;
import com.platform.example.model.entity.BankAccount;
import com.platform.example.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

@Mapper
public abstract class BankAccountMapper {

    @Autowired
    EntityManager entityManager;

    public abstract BankAccountDTO toDTO(BankAccount bankAccount);

    public abstract BankAccount toEntity(BankAccountDTO bankAccountDTO);

    public abstract void toEntityUpdate(@MappingTarget BankAccount bankAccount, BankAccountDTO bankAccountDTO);
}
