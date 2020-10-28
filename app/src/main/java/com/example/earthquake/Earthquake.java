package com.example.earthquake;

public class Earthquake {

    private String type;
    private EarthquakeProperties properties;

    public Earthquake(String type, EarthquakeProperties properties){
        this.type = type;
        this.properties = properties;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EarthquakeProperties getProperties() {
        return properties;
    }

    public void setProperties(EarthquakeProperties properties) {
        this.properties = properties;
    }
}