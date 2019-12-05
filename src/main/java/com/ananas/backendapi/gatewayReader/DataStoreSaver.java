package com.ananas.backendapi.gatewayReader;


import com.ananas.backendapi.entities.Location;
import org.springframework.web.client.RestTemplate;
import java.util.List;

/**
 * Sends POST requests to SPRING REST Server
 */

public class DataStoreSaver {

    private DataStoreSaver(){}

    public static void postList(List<Location> locations){
        final String uri = "http://localhost/locations/";

        for (Location location : locations)
        {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject( uri, location, Location.class);
        }
    }

}
