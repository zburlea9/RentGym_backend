package com.platform.example.controller;

import com.platform.example.model.DTO.GymDTO;
import com.platform.example.model.DTO.UserBankDTO;
import com.platform.example.model.DTO.UserDTO;
import com.platform.example.service.UserService;
import com.platform.example.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping( value = "/user")
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;

    @Autowired
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping(value ="/all")
    public List<UserDTO> printUsers() {
        return userService.findAllUsersDTO();
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody @Valid UserDTO userDTO, BindingResult result){
        userValidator.validateUser(userDTO,result);
        if(result.hasErrors()) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }

        UserDTO save = userService.save(userDTO);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/find/{id}")
    public UserDTO findById(@PathVariable Long id){return userService.findById(id);}

    @PostMapping("/login")
    public ResponseEntity<Object> logIn(@RequestBody UserDTO userDTO){
        UserBankDTO user = userService.logIn(userDTO.getUsername(),userDTO.getPassword());
        System.out.println(user);
        if(userDTO!=null){

            return ResponseEntity.ok(user);
        }

        else return null;
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        userService.deleteUser(id);
    }
}
