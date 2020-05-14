package com.ananas.backendapi.controllers;


import com.ananas.backendapi.entities.Device;
import com.ananas.backendapi.entities.Location;
import com.ananas.backendapi.repositories.DeviceRepository;
import com.ananas.backendapi.repositories.LocationRepository;
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
    private LocationRepository locationRepository;

    @Autowired
    private DeviceRepository deviceRepository;


    @GetMapping()
    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<Device> getByLocation(@PathVariable String name){
        if(locationRepository.getByUnit(name).isPresent()){
            Location location = locationRepository.getByUnit(name).get();
            return deviceRepository.findAllByLocation(location);
        }

        return null;
    }


}
