package com.platform.example.service.impl;

import com.platform.example.model.DTO.BankAccountDTO;
import com.platform.example.model.DTO.UserBankDTO;
import com.platform.example.model.DTO.UserDTO;
import com.platform.example.model.entity.BankAccount;
import com.platform.example.model.entity.User;
import com.platform.example.model.mapper.UserMapper;
import com.platform.example.repository.BankAccountRepository;
import com.platform.example.repository.UserRepository;
import com.platform.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BankAccountRepository bankAccountRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BankAccountRepository bankAccountRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO register(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user;
        if(userDTO.getId()!=null){
            user = userRepository.findById(userDTO.getId())
                    .orElseThrow(() -> { throw new EntityNotFoundException("Cannot find bank account with ID: " + userDTO.getId()); } );

        }else{
            user = new User();
        }
        userMapper.toEntityUpdate(user,userDTO);
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> { throw new EntityNotFoundException("Cannot find user with ID: " + id); } );

        userRepository.delete(user);
    }

    @Override
    public List<UserDTO> findAllUsersDTO() {
        return userRepository.findAll().
                stream().
                map(userMapper::toDTO).
                collect(Collectors.toList());

    }

    @Override
    public UserBankDTO logIn(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username,password);
        if(user==null){
            return null;
        }else{
            UserDTO uu = userMapper.toDTO(user);
            BankAccount bank = bankAccountRepository.findByUserId(uu.getId());
            if(bank == null && uu.getIs_admin()){
                UserBankDTO userBank = new UserBankDTO();
                userBank.setUser_id(uu.getId());
                userBank.setUsername(uu.getUsername());
                userBank.setEmail(uu.getEmail());
                userBank.setFirst_name(uu.getFirst_name());
                userBank.setLast_name(uu.getLast_name());
                userBank.setPhone_number(uu.getPhone_number());
                userBank.setPassword(uu.getPassword());
                userBank.setIs_admin(true);
                return userBank;
            } else
                if(bank == null && !uu.getIs_admin())
                    return null;
                else{
                    UserBankDTO userBank = new UserBankDTO();
                    userBank.setUser_id(uu.getId());
                    userBank.setUsername(uu.getUsername());
                    userBank.setEmail(uu.getEmail());
                    userBank.setFirst_name(uu.getFirst_name());
                    userBank.setLast_name(uu.getLast_name());
                    userBank.setPhone_number(uu.getPhone_number());
                    userBank.setPassword(uu.getPassword());
                    userBank.setIs_admin(false);
                    userBank.setAmount(bank.getAmount());
                    userBank.setBank_number(bank.getBank_number());
                    userBank.setSecurity_number(bank.getSecurity_number());
                    userBank.setBank_id(bank.getId());
                    return userBank;
                }

        }

    }

    @Override
    public UserDTO findByUsername(String username) {
        return userMapper.toDTO(userRepository.findByUsername(username));
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> { throw new EntityNotFoundException("Cannot find user with ID: " + id); } );
        return userMapper.toDTO(user);
    }
}
