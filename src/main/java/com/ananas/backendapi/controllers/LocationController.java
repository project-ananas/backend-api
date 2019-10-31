package com.ananas.backendapi.controllers;

import com.ananas.backendapi.entities.Location;
import com.ananas.backendapi.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    LocationService service;

    @GetMapping("/{amount}")
    public List<Location> getAll(@PathVariable int amount){ return service.getAll(amount); }
}
