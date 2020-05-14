package com.ananas.backendapi.controllers;

import com.ananas.backendapi.entities.Device;
import com.ananas.backendapi.services.DeviceService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService service;

    @GetMapping()
    public List<Device> getAllDevices(){
        return service.getAllDevices();
    }

    @PostMapping()
    public List<Device> save(@RequestBody String devices){
        Gson gson = new Gson();
        Device[] dev = gson.fromJson(devices, Device[].class);
        return service.saveAll(Arrays.asList(dev));
    }
}
