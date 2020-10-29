package com.example.earthquake;

import com.google.gson.annotations.SerializedName;

public class EarthquakeProperties {
    /** Magnitude of the earthquake */
    @SerializedName("mag")
    private double mMagnitude;

    /** Location of the earthquake */
    @SerializedName("place")
    private String mLocation;

    /** Time of the earthquake */
    @SerializedName("time")
    private long mTimeInMilliseconds;

    /** Website URL of the earthquake */
    @SerializedName("url")
    private String mUrl;


    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param location is the location where the earthquake happened
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
     *                           earthquake happened
     * @param url is the website URL to find more details about the earthquake
     */
    public EarthquakeProperties(double magnitude, String location, long timeInMilliseconds, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    /**
     * Returns the magnitude of the earthquake.
     */
    public double getMagnitude() {
        return mMagnitude;
    }

    /**
     * Returns the location of the earthquake.
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * Returns the time of the earthquake.
     */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    /**
     * Returns the website URL to find more information about the earthquake.
     */
    public String getUrl() {
        return mUrl;
    }

    public void setmMagnitude(double mMagnitude) {
        this.mMagnitude = mMagnitude;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public void setmTimeInMilliseconds(long mTimeInMilliseconds) {
        this.mTimeInMilliseconds = mTimeInMilliseconds;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}


