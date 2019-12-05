package com.ananas.backendapi.services;

import com.ananas.backendapi.entities.Location;
import com.ananas.backendapi.properties.ConfigProperties;
import com.ananas.backendapi.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Abstraction class to
 */

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
       if(!properties.isDebug()) return repository.findAll();

        ArrayList<Location> locations = new ArrayList<>();
        Location loc1 = new Location();
        loc1.setUnit("test");
        loc1.setTotal(42);
        locations.add(loc1);

        Location loc2 = new Location();
        loc2.setUnit("test1");
        loc2.setTotal(42);
        locations.add(loc2);

        return locations;
    }
}
