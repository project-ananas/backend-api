package com.ananas.backendapi.gatewayReader;

import com.ananas.backendapi.entities.Device;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class DataStoreSaver {

    public static void postList(List<Device> devices) {
        final String uri = "http://localhost:8082/devices/";

        RestTemplate restTemplate = new RestTemplate();
        Gson gson = new Gson();
        String json = gson.toJson(devices);
        restTemplate.postForObject(uri, json, String.class);
    }
}
