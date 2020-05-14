package com.ananas.backendapi.repositories;

import com.ananas.backendapi.entities.Device;
import com.ananas.backendapi.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
    List<Device> findAllByLocation(Location unit);
    List<Device> findDevicesByTime(Timestamp time);
}
