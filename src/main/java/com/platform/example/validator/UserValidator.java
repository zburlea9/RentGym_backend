package com.platform.example.validator;

import com.platform.example.model.DTO.UserDTO;
import com.platform.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.apache.commons.lang3.StringUtils;

@Component
public class UserValidator {

    private final UserRepository userRepository;

    @Autowired
    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateUser(UserDTO userDTO, BindingResult result){
        if(!StringUtils.containsOnly(userDTO.getPhone_number(),"0123456789"))
            result.rejectValue("phone","Phone is not valid");
    }
}
