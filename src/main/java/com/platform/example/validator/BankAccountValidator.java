package com.platform.example.validator;

import com.platform.example.model.DTO.BankAccountDTO;
import com.platform.example.repository.BankAccountRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class BankAccountValidator {

    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountValidator(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public void validateBankAccount(BankAccountDTO bankAccountDTO, BindingResult result) {
        if(StringUtils.isNotEmpty(bankAccountDTO.getBank_number())
                && !StringUtils.containsOnly(bankAccountDTO.getBank_number(),"0123456789")
                && bankAccountDTO.getBank_number().length() != 16)
            result.rejectValue("bank_account","Bank account number is not valid");

        if(!StringUtils.containsOnly(bankAccountDTO.getSecurity_number().toString(),"0123456789")
                && bankAccountDTO.getSecurity_number().toString().length() != 3)
            result.rejectValue("security_number","Security number is not valid");
    }
}
