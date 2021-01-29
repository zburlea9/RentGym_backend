package com.platform.example.controller;


import com.platform.example.model.DTO.BankAccountDTO;
import com.platform.example.service.BankAccountService;
import com.platform.example.validator.BankAccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping( value = "/bankAccount")
public class BankAccountController {

    private final BankAccountService bankAccountService;
    private final BankAccountValidator bankAccountValidator;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService, BankAccountValidator bankAccountValidator) {
        this.bankAccountService = bankAccountService;
        this.bankAccountValidator = bankAccountValidator;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody @Valid BankAccountDTO bankAccountDTO, BindingResult result) {
        bankAccountValidator.validateBankAccount(bankAccountDTO,result);

        if(result.hasErrors()) {
            return new ResponseEntity<Object>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        BankAccountDTO save = bankAccountService.save(bankAccountDTO);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        bankAccountService.deleteBankAccount(id);
    }

    @GetMapping("/all")
    public List<BankAccountDTO> findAll(){
        return bankAccountService.findAllBankAccountsDTO();
    }

    @GetMapping("/byUser")
    public BankAccountDTO findByUser(@RequestParam Long id){return bankAccountService.findBankAccountByUserId(id);}

    @GetMapping("/find/{id}")
    public BankAccountDTO findById(@RequestParam Long id){return bankAccountService.findById(id);}
}
