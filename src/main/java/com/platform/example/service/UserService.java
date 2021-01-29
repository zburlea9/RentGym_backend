package com.platform.example.service;


import com.platform.example.model.DTO.UserBankDTO;
import com.platform.example.model.DTO.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO register(UserDTO userDTO);

    UserDTO save(UserDTO userDTO);

    void deleteUser(Long id);

    List<UserDTO> findAllUsersDTO();

    UserBankDTO logIn(String username, String password);

    UserDTO findByUsername(String username);

    UserDTO findById(Long id);
}
