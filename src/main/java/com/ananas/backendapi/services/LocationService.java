package com.ananas.backendapi.services;

import com.ananas.backendapi.entities.Device;
import com.ananas.backendapi.entities.Location;
import com.ananas.backendapi.mock.MockUtil;
import com.ananas.backendapi.repositories.DeviceRepository;
import com.ananas.backendapi.repositories.LocationRepository;
import com.ananas.backendapi.util.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
    @Autowired
    LocationRepository repository;

    @Autowired
    private ConfigProperties properties;

    public Location save(Location l){ return repository.save(l); }

    public void saveAll(ArrayList<Location> locations){
        repository.saveAll(locations);
    }

    public Location get(int id) {
        return  repository.findById(id).get();
    }

    public List<Location> getAll() {
        // Return list of test items else return actual database values
        if (properties.isDebug()) return MockUtil.listOfLocations();
        return repository.findAll();
    }
}
