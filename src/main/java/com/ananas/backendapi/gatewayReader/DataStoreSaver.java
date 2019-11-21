package com.ananas.backendapi.gatewayReader;


import com.ananas.backendapi.entities.Location;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;

public class DataStoreSaver {


    public static void PostList(ArrayList<Location> locations){
        final String uri = "http://localhost/locations/";

        for (Location location : locations)
        {
            RestTemplate restTemplate = new RestTemplate();
            Location result = restTemplate.postForObject( uri, location, Location.class);
        }
    }

}
