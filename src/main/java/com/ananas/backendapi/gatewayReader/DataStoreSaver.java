package com.ananas.backendapi.gatewayReader;


import com.ananas.backendapi.entities.Location;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;

public class DataStoreSaver {

    private DataStoreSaver(){}

    public static void PostList(ArrayList<Location> locations){
        final String uri = "http://localhost/locations/";

        for (Location location : locations)
        {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject( uri, location, Location.class);
        }
    }

}
