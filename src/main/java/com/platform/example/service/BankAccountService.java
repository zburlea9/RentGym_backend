package com.platform.example.service;

import com.platform.example.model.DTO.BankAccountDTO;
import com.platform.example.model.DTO.GymDTO;
import com.platform.example.model.DTO.UserDTO;
import com.platform.example.model.entity.BankAccount;

import java.util.List;

public interface BankAccountService {

    BankAccountDTO save(BankAccountDTO bankAccountDTO);

    List<BankAccountDTO> findAllBankAccountsDTO();

    void deleteBankAccount(Long id);

    BankAccountDTO findBankAccountByUserId(Long user_id);

    BankAccountDTO findById(Long id);
}
