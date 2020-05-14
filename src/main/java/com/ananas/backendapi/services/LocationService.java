package com.ananas.backendapi.services;

import com.ananas.backendapi.entities.Location;
import com.ananas.backendapi.mock.MockUtil;
import com.ananas.backendapi.repositories.LocationRepository;
import com.ananas.backendapi.util.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    LocationRepository repository;

    @Autowired
    private ConfigProperties properties;

    public Location save(Location l){
        return repository.save(l);
    }

    public Optional<Location>getByName(String name){
        return repository.getByUnit(name);
    }


}
