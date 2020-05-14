package com.ananas.backendapi.gatewayReader;

import com.ananas.backendapi.entities.Device;
import com.ananas.backendapi.entities.Location;

import java.util.List;

import static com.ananas.backendapi.gatewayReader.DataStoreReader.getDevices;

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
        //List<Location> locations
        List<Device> devices = DataStoreReader.getDevices(url);
        if(devices.size() > 0) DataStoreSaver.postList(devices);
    }
}
