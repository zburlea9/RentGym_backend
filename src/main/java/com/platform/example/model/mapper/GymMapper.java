package com.platform.example.model.mapper;

import com.platform.example.model.DTO.GymDTO;
import com.platform.example.model.DTO.UserDTO;
import com.platform.example.model.entity.Gym;
import com.platform.example.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;


@Mapper
public abstract class GymMapper {

    @Autowired
    EntityManager entityManager;

    public abstract GymDTO toDTO(Gym gym);

    public abstract Gym toEntity(GymDTO gymDTO);

    public abstract void toEntityUpdate(@MappingTarget Gym gym, GymDTO gymDTO);
}
