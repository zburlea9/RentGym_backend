package com.platform.example.service.impl;


import com.platform.example.model.DTO.GymDTO;
import com.platform.example.model.entity.Gym;
import com.platform.example.model.entity.User;
import com.platform.example.model.mapper.GymMapper;
import com.platform.example.model.mapper.UserMapper;
import com.platform.example.repository.GymRepository;
import com.platform.example.repository.UserRepository;
import com.platform.example.service.GymService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GymServiceImpl implements GymService {

    private final GymRepository gymRepository;
    private final GymMapper gymMapper;

    public GymServiceImpl(GymRepository gymRepository, GymMapper gymMapper) {
        this.gymRepository = gymRepository;
        this.gymMapper = gymMapper;
    }


    @Override
    public GymDTO save(GymDTO gymDTO) {
        Gym gym;
        if(gymDTO.getId()!=null){
            gym = gymRepository.findById(gymDTO.getId())
                    .orElseThrow(() -> { throw new EntityNotFoundException("Cannot find gym with ID: " + gymDTO.getId()); } );

        }else{
            gym = new Gym();
        }
        gymMapper.toEntityUpdate(gym,gymDTO);
        return gymMapper.toDTO(gymRepository.save(gym));
    }

    @Override
    public List<GymDTO> findAllGymsDTO() {
        return gymRepository.findAll().
                stream().
                map(gymMapper::toDTO).
                collect(Collectors.toList());
    }

    @Override
    public void deleteGym(Long id) {
        final Gym gym = gymRepository.findById(id)
                .orElseThrow(() -> { throw new EntityNotFoundException("Cannot find gym with ID: " + id); } );

        gymRepository.delete(gym);
    }

    @Override
    public GymDTO findById(Long id) {
        Gym gym = gymRepository.findById(id)
                .orElseThrow(() -> { throw new EntityNotFoundException("Cannot find gym with ID: " + id); } );
        return gymMapper.toDTO(gym);
    }
}
