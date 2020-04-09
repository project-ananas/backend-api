package com.ananas.backendapi.gatewayReader;

import com.ananas.backendapi.entities.Location;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataStoreReader {
    private static final Logger logger = LoggerFactory.getLogger(DataStoreReader.class);
    private String URL;

    public DataStoreReader(){}

    public static List<Location> getLocations(String url){
        String json = getFromUrl(url);
        List<Location> locations = new ArrayList<>();
        JsonObject convertedObject = new Gson().fromJson(json, JsonObject.class);

        JsonArray ar = convertedObject.getAsJsonArray("locations");

        for (int i = 0; i < ar.size(); i++){
            Location loc = new Location();
            JsonObject s = ar.get(i).getAsJsonObject();

            loc.setUnit(s.get("location").getAsString());
            locations.add(loc);
        }

        return locations;
    }

    // Get Json from URL
    public static String getFromUrl(String uri){
        String s = "";
        StringBuilder sb = new StringBuilder();
        try {
            java.net.URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(10000);
            // If no player found or something other happened, return empty player
            if (conn.getResponseCode() != 200) {
                return s;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;

            while ((output = br.readLine()) != null) {
                sb.append(output);
            }

            conn.disconnect();
        }
        catch (SocketTimeoutException e)
        {
            logger.error("GATEWAY SERVICE DID NOT READ");
        }
        catch (MalformedURLException e) {
            logger.error("GATEWAY SERVICE DID NOT READ");

        } catch (IOException e) {
            logger.error("GATEWAY SERVICE DID NOT READ");
        }

        return sb.toString();
    }
}
