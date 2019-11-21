package com.ananas.backendapi.gatewayReader;
import com.ananas.backendapi.entities.Location;

import java.util.ArrayList;

public class GatewayTask implements Runnable {


    @Override
    public void run() {
        System.out.println("GatewayService running");
        ArrayList<Location> locations = DataStoreReader.getLocations();
        if(!locations.isEmpty()) DataStoreSaver.PostList(locations); }
}
