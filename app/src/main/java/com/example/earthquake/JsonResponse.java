package com.example.earthquake;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonResponse {


    public static List<Earthquake> extractEarthquakes(String earthQuakeJSON) {
        List earthquakes = new ArrayList();
        try {

            JSONObject baseJsonResponse = new JSONObject(earthQuakeJSON);

            JSONArray earthquakeArray = baseJsonResponse.getJSONArray("features");

            for (int i = 0; i < earthquakeArray.length(); i++) {

                JSONObject currentEarthquake = earthquakeArray.getJSONObject(i);

                JSONObject properties = currentEarthquake.getJSONObject("properties");

                double magnitude = properties.getDouble("mag");

                String location = properties.getString("place");

                long time = properties.getLong("time");

                String url = properties.getString("url");

                Earthquake earthquake = new Earthquake(magnitude, location, time, url);


                earthquakes.add(earthquake);
            }

        } catch (JSONException e) {

            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }
        return earthquakes;
    }
}



