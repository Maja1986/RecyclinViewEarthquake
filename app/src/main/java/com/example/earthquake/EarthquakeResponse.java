package com.example.earthquake;

import java.util.ArrayList;

public class EarthquakeResponse {

    ArrayList<Earthquake> features;
    public EarthquakeResponse(ArrayList<Earthquake>features){
        this.features = features;
    }

    public ArrayList<Earthquake> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<Earthquake> features) {
        this.features = features;
    }
}