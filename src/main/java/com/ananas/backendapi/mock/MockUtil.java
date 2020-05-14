package com.ananas.backendapi.mock;

import com.ananas.backendapi.entities.Device;
import com.ananas.backendapi.entities.Location;

import java.sql.Timestamp;
import java.util.ArrayList;

public class MockUtil {
    public static ArrayList<Location> listOfLocations(){
        ArrayList<Location> locations = new ArrayList<>();
        Location loc1 = new Location();
        loc1.setUnit("Test unit 1");
        locations.add(loc1);

        Location loc2 = new Location();
        loc2.setUnit("Test unit 2");
        locations.add(loc2);

        Location loc3 = new Location();
        loc3.setUnit("Test unit 3");
        locations.add(loc3);

        Location loc4 = new Location();
        loc4.setUnit("Test unit 4");
        locations.add(loc4);

        return locations;
    }

    public static ArrayList<Device> listOfDevices(){
        ArrayList<Location> locations = listOfLocations();
        ArrayList<Device> devices = new ArrayList<>();
        for (int i = 0; i < locations.size(); i++) {
            Device dev = new Device();
            dev.setId(i);
            dev.setTime(new Timestamp(System.currentTimeMillis()));
            dev.setLocation(locations.get(i));
            dev.setVendor("Test vendor" + i);
            dev.setFirst_seen(new Timestamp(System.currentTimeMillis()));
            devices.add(dev);
        }

        return devices;
    }
}
