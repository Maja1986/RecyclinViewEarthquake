package com.example.earthquake;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/earthquakes")
    Call<List<Earthquake>> getAllEarthquakes();
}
