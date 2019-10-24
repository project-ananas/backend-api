package com.ananas.backendapi.repositories;

import com.ananas.backendapi.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer>{
    //  Place custom functions here
}
