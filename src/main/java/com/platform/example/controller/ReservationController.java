package com.platform.example.controller;


import com.platform.example.model.DTO.PaymentDTO;
import com.platform.example.model.DTO.ReservationDTO;
import com.platform.example.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping( value = "/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody @Valid ReservationDTO reservationDTO, BindingResult result) {

        if(result.hasErrors()) {
            return new ResponseEntity<Object>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        ReservationDTO save = reservationService.save(reservationDTO);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        reservationService.deleteReservation(id);
    }

    @GetMapping("/all")
    public List<ReservationDTO> findAll(){
        return reservationService.findAllReservationsDTO();
    }

    @GetMapping("/allReservationUser/{id}")
    public List<ReservationDTO> findAllReservationForUser(@PathVariable Long id){
        return reservationService.findAllReservationsDTOForUser(id);
    }

    @GetMapping("/findById")
    public ReservationDTO findById(@RequestParam Long id){return reservationService.findById(id);}

}
