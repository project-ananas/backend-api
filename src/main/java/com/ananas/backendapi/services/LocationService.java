package com.ananas.backendapi.services;

import com.ananas.backendapi.entities.Location;
import com.ananas.backendapi.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    LocationRepository repository;

    public Location get(int id) {
        return repository.findById(id).get();
    }
}
