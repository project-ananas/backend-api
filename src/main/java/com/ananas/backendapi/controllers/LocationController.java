package com.ananas.backendapi.controllers;

import com.ananas.backendapi.entities.Location;
import com.ananas.backendapi.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Locations")
public class LocationController {

    @Autowired
    LocationService service;

    @GetMapping
    public Location get(int id){
        return service.get(id);
    }
}
