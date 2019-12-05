package com.ananas.backendapi.gatewayReader;
import com.ananas.backendapi.entities.Location;

import java.util.List;

/**
 * Task that gets data from sensor gateway
 */

public class GatewayTask implements Runnable {

    private String url;
    private boolean debug;

    public GatewayTask(String url, boolean debug){
        this.url = url;
        this.debug = debug;
    }

    @Override
    public void run() {
        if(debug) return;
            System.out.println("Reading data from sensor gateway");
            List<Location> locations = DataStoreReader.getLocations(url);
            if(locations != null) DataStoreSaver.postList(locations);
    }
}
