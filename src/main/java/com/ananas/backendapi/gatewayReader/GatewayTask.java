package com.ananas.backendapi.gatewayReader;
import com.ananas.backendapi.entities.Location;

import java.util.List;

/**
 * Task that gets data from
 */

public class GatewayTask implements Runnable {

    @Override
    public void run() {
        System.out.println("GatewayService running");
        List<Location> locations = DataStoreReader.getLocations();
        if(!locations.isEmpty()) DataStoreSaver.postList(locations); }
}
