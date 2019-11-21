package com.ananas.backendapi.controllers;

import com.ananas.backendapi.entities.Location;
import com.ananas.backendapi.repositories.LocationRepository;
import com.ananas.backendapi.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    LocationService service;

    @Autowired
    LocationRepository repository;


    @PostMapping()
    public Location create(@RequestBody Location location){
        return service.save(location);
    }



    @PostMapping("/all")
    public ResponseEntity addAll(ArrayList<Location> locations){
        service.saveAll(locations);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public List<Location> getAll(){ return service.getAll(); }
}
