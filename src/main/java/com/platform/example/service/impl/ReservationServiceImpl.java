package com.platform.example.service.impl;

import com.platform.example.model.DTO.PaymentDTO;
import com.platform.example.model.DTO.ReservationDTO;
import com.platform.example.model.entity.Gym;
import com.platform.example.model.entity.Reservation;
import com.platform.example.model.mapper.PaymentMapper;
import com.platform.example.model.mapper.ReservationMapper;
import com.platform.example.repository.ReservationRepository;
import com.platform.example.service.ReservationService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final PaymentMapper paymentMapper;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper, PaymentMapper paymentMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public ReservationDTO save(ReservationDTO reservationDTO) {
        Reservation reservation;
        if(reservationDTO.getId()!=null){
            reservation = reservationRepository.findById(reservationDTO.getId())
                    .orElseThrow(() -> { throw new EntityNotFoundException("Cannot find gym with ID: " + reservationDTO.getId()); } );

        }else{
            reservation = new Reservation();
        }
        reservationMapper.toEntityUpdate(reservation,reservationDTO);
        return reservationMapper.toDTO(reservationRepository.save(reservation));
    }

    @Override
    public void deleteReservation(Long id) {
        final Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> { throw new EntityNotFoundException("Cannot find reservation with ID: " + id); } );

        reservationRepository.delete(reservation);
    }

    @Override
    public List<ReservationDTO> findAllReservationsDTO() {
        return reservationRepository.findAll().
                stream().
                map(reservationMapper::toDTO).
                collect(Collectors.toList());
    }

    @Override
    public List<ReservationDTO> findAllReservationsDTOForUser(Long id_user) {
        return reservationRepository.findAll()
                .stream()
                .filter(reservation -> reservation.getPayment().getUser().getId().equals(id_user))
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDTO findById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> { throw new EntityNotFoundException("Cannot find reservation with ID: " + id); } );
        return reservationMapper.toDTO(reservation);
    }


}
