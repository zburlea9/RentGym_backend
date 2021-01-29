package com.platform.example.service;

import com.platform.example.model.DTO.GymDTO;
import com.platform.example.model.DTO.UserDTO;
import com.platform.example.model.entity.Gym;

import java.util.List;

public interface GymService {

    GymDTO save(GymDTO gymDTO);

    List<GymDTO> findAllGymsDTO();

    void deleteGym(Long id);

    GymDTO findById(Long id);
}
