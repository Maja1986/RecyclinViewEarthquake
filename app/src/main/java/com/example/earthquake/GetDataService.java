package com.example.earthquake;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&limit=20")
    Call<EarthquakeResponse> getAllEarthquakes();
}
