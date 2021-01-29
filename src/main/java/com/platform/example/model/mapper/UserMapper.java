package com.platform.example.model.mapper;


import com.platform.example.model.DTO.UserDTO;
import com.platform.example.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

@Mapper
public abstract class UserMapper {
    @Autowired
    EntityManager entityManager;

    public abstract UserDTO toDTO(User user);

    public abstract User toEntity(UserDTO userDTO);

    public abstract void toEntityUpdate(@MappingTarget User user, UserDTO userDTO);

}
