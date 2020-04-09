package com.ananas.backendapi.services;

import com.ananas.backendapi.entities.Device;
import com.ananas.backendapi.mock.MockUtil;
import com.ananas.backendapi.repositories.DeviceRepository;
import com.ananas.backendapi.util.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository repository;

    @Autowired
    private ConfigProperties properties;

    public List<Device> getDevicesByLocation(@PathVariable String location){
        if(properties.isDebug()){
            ArrayList<Device> devices = new ArrayList<>();
            MockUtil.listOfDevices().forEach(dd -> {
                if(dd.getLocation().getUnit().equals(location)){
                 devices.add(dd);
                }});
            return devices;
        }

        return repository.findAllByLocation_Unit(location);
    }

    public List<Device> getAllDevices(){
        if(properties.isDebug()){
            return MockUtil.listOfDevices();
        }

        return repository.findAll();
    }
}
