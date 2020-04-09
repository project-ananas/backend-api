package com.ananas.backendapi.repositories;

import com.ananas.backendapi.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
    Location getByUnit(String unit);
}
