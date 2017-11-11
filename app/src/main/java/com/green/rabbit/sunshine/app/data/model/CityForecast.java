package com.green.rabbit.sunshine.app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Łukasz on 11.11.2017.
 */

public class CityForecast {
    private City city;
    private String cod;
    private double message;
    @SerializedName("cnt")
    private int count;
    @SerializedName("list")
    private Forecast[] forecasts;

    public CityForecast(City city, String cod, double message, int count, Forecast[] forecasts) {
        this.city = city;
        this.cod = cod;
        this.message = message;
        this.count = count;
        this.forecasts = forecasts;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Forecast[] getForecasts() {
        return forecasts;
    }

    public void setForecasts(Forecast[] forecasts) {
        this.forecasts = forecasts;
    }
}
