package com.ananas.backendapi.services;

import com.ananas.backendapi.entities.Location;
import com.ananas.backendapi.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraction class to
 */

@Service
public class LocationService {

    @Autowired
    LocationRepository repository;

    public Location save(Location l){ return repository.save(l); }

    public void saveAll(ArrayList<Location> locations){
        repository.saveAll(locations);
    }

    public Location get(int id) {
        return  repository.findById(id).get();
    }

    public List<Location> getAll() {
        return repository.findAll();
    }
}
