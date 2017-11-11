package com.green.rabbit.sunshine.app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Łukasz on 11.11.2017.
 */

public class Coordinate {
    @SerializedName("lat")
    private double latitude;
    @SerializedName("lon")
    private double longitude;

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
