package com.platform.example.service.impl;

import com.platform.example.model.DTO.BankAccountDTO;
import com.platform.example.model.DTO.UserDTO;
import com.platform.example.model.entity.BankAccount;
import com.platform.example.model.mapper.BankAccountMapper;
import com.platform.example.model.mapper.UserMapper;
import com.platform.example.repository.BankAccountRepository;
import com.platform.example.repository.UserRepository;
import com.platform.example.service.BankAccountService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;
    private final UserMapper userMapper;


    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, BankAccountMapper bankAccountMapper, UserMapper userMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapper = bankAccountMapper;
        this.userMapper = userMapper;
    }

    @Override
    public BankAccountDTO save(BankAccountDTO bankAccountDTO) {
        BankAccount bankAccount;
        if(bankAccountDTO.getId()!=null){
            bankAccount = bankAccountRepository.findById(bankAccountDTO.getId())
                    .orElseThrow(() -> { throw new EntityNotFoundException("Cannot find bankAccount with ID: " + bankAccountDTO.getId()); } );
            bankAccountDTO.setUser(userMapper.toDTO(bankAccount.getUser()));
        }else{
            bankAccount = new BankAccount();
        }
        bankAccountMapper.toEntityUpdate(bankAccount,bankAccountDTO);
        return bankAccountMapper.toDTO(bankAccountRepository.save(bankAccount));
    }

    @Override
    public List<BankAccountDTO> findAllBankAccountsDTO() {
        return bankAccountRepository.findAll().
                stream().
                map(bankAccountMapper::toDTO).
                collect(Collectors.toList());
    }

    @Override
    public void deleteBankAccount(Long id) {

        final BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> { throw new EntityNotFoundException("Cannot find bank account with ID: " + id); } );

        bankAccountRepository.delete(bankAccount);
    }

    @Override
    public BankAccountDTO findBankAccountByUserId(Long userId) {
        return bankAccountMapper.toDTO(bankAccountRepository.findByUserId(userId));
    }

    @Override
    public BankAccountDTO findById(Long id) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> { throw new EntityNotFoundException("Cannot find bank account with ID: " + id); } );
        return bankAccountMapper.toDTO(bankAccount);
    }
}
