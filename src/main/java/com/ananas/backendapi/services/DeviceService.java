package com.ananas.backendapi.services;

import com.ananas.backendapi.entities.Device;
import com.ananas.backendapi.mock.MockUtil;
import com.ananas.backendapi.repositories.DeviceRepository;
import com.ananas.backendapi.util.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository repository;

    @Autowired
    private LocationService locationService;

    @Autowired
    private ConfigProperties properties;

    public List<Device> getAllDevices(){
        if(properties.isDebug()){
            return MockUtil.listOfDevices();
        }

        return repository.findAll();
    }

    public List<Device>saveAll(List<Device> devices){
        for (Device dev: devices)
        {
           if(locationService.getByName(dev.getLocation().getUnit()).isPresent()){
               dev.setLocation(locationService.getByName(dev.getLocation().getUnit()).get());

           }
           else{
               locationService.save(dev.getLocation());
           }
        }

        return repository.saveAll(devices);
    }

}
