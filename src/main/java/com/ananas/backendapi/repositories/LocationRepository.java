package com.ananas.backendapi.repositories;

import com.ananas.backendapi.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to get and send data to dataStore
 */

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
    //  Place custom functions here
}
