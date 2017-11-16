package com.green.rabbit.sunshine.app.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by Łukasz on 11.11.2017.
 */
@Parcel(Parcel.Serialization.BEAN)
public class Weather {
    private int id;
    @SerializedName("main")
    private String parameters;
    private String description;
    private String icon;

    public Weather() {
    }

    public Weather(int id, String parameters, String description, String icon) {
        this.id = id;
        this.parameters = parameters;
        this.description = description;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
