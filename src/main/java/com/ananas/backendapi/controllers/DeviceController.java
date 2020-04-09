package com.ananas.backendapi.controllers;

import com.ananas.backendapi.entities.Device;
import com.ananas.backendapi.repositories.DeviceRepository;
import com.ananas.backendapi.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public List<Device> getAllDevicesByLocation(@PathVariable String id){
        return service.getDevicesByLocation(id);
    }



}
