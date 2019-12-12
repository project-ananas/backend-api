package com.ananas.backendapi.controllers;

import com.ananas.backendapi.entities.Location;
import com.ananas.backendapi.repositories.LocationRepository;
import com.ananas.backendapi.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * RestController endpoint, this class receives the REST calls at /locations
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    LocationService service;

    @Autowired
    LocationRepository repository;


    // Adds a single location to dataStore
    @PostMapping()
    public Location create(@RequestBody Location location){
        return service.save(location);
    }


    // Adds a list of locations to the dataStore
    @PostMapping("/all")
    public ResponseEntity addAll(ArrayList<Location> locations){
        service.saveAll(locations);
        return ResponseEntity.ok().build();
    }


    // Gets one specific location by ID
    @GetMapping("/{id}")
    public ResponseEntity<Location> get(@PathVariable int id){
        if(service.get(id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(service.get(id));
    }

    // Gets a list of locations
    @GetMapping()
    public List<Location> getAll(){ return service.getAll(); }
}
