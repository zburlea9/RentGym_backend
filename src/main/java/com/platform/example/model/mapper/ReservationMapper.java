package com.platform.example.model.mapper;

import com.platform.example.model.DTO.ReservationDTO;
import com.platform.example.model.DTO.UserDTO;
import com.platform.example.model.entity.Reservation;
import com.platform.example.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

@Mapper
public abstract class ReservationMapper {

    @Autowired
    EntityManager entityManager;

    public abstract ReservationDTO toDTO(Reservation reservation);

    public abstract Reservation toEntity(ReservationDTO reservationDTO);

    public abstract void toEntityUpdate(@MappingTarget Reservation reservation, ReservationDTO reservationDTO);
}
