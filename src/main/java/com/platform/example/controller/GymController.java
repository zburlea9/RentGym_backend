package com.platform.example.controller;


import com.platform.example.model.DTO.GymDTO;
import com.platform.example.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( value = "/gym")
public class GymController {

    private final GymService gymService;

    @Autowired
    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody @Valid GymDTO gymDTO, BindingResult result) {

        if(result.hasErrors()) {
            return new ResponseEntity<Object>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        GymDTO save = gymService.save(gymDTO);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        gymService.deleteGym(id);
    }

    @GetMapping("/all")
    public List<GymDTO> findAll(){
        return gymService.findAllGymsDTO();
    }

    @GetMapping("/find/{id}")
    public GymDTO findById(@PathVariable Long id){return gymService.findById(id);}

    @GetMapping("/findBasket")
    public List<GymDTO> findAllBasket(){
        List<GymDTO> allGyms = findAll();
        List<GymDTO> basketGyms = new ArrayList<>();
        for(GymDTO g : allGyms){
            if(g.getType().contains("basketball")){
                basketGyms.add(g);
            }
        }
        return basketGyms;
    }

    @GetMapping("/findVolley")
    public List<GymDTO> findAllVolley(){
        List<GymDTO> allGyms = findAll();
        List<GymDTO> volleyGyms = new ArrayList<>();
        for(GymDTO g : allGyms){
            if(g.getType().contains("volleyball")){
                volleyGyms.add(g);
            }
        }
        return volleyGyms;
    }

    @GetMapping("/findTennis")
    public List<GymDTO> findAllTennis(){
        List<GymDTO> allGyms = findAll();
        List<GymDTO> tennisGyms = new ArrayList<>();
        for(GymDTO g : allGyms){
            if(g.getType().contains("tennis")){
                tennisGyms.add(g);
            }
        }
        return tennisGyms;
    }

    @GetMapping("/findHandball")
    public List<GymDTO> findAllHandball(){
        List<GymDTO> allGyms = findAll();
        List<GymDTO> handballGyms = new ArrayList<>();
        for(GymDTO g : allGyms){
            if(g.getType().contains("handball")){
                handballGyms.add(g);
            }
        }
        return handballGyms;
    }
}
