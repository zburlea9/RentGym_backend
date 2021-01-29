package com.platform.example.service;

import com.platform.example.model.DTO.PaymentDTO;
import com.platform.example.model.DTO.ReservationDTO;
import com.platform.example.model.DTO.UserDTO;
import com.platform.example.model.entity.Reservation;

import java.util.List;

public interface ReservationService {

    ReservationDTO save(ReservationDTO reservationDTO);

    void deleteReservation(Long id);

    List<ReservationDTO> findAllReservationsDTO();

    List<ReservationDTO> findAllReservationsDTOForUser(Long id_user);

    ReservationDTO findById(Long id);

}
