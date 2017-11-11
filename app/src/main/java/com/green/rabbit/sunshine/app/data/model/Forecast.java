package com.green.rabbit.sunshine.app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Łukasz on 11.11.2017.
 */

public class Forecast {
    @SerializedName("dt")
    private int dateTime;
    private Temperature temp;
    private double pressure;
    private double humidity;
    private Weather[] weather = null;
    @SerializedName("speed")
    private double windSpeed;
    @SerializedName("deg")
    private int degrees;
    private int clouds;

    public Forecast(int dateTime, Temperature temp, double pressure, double humidity, Weather[] weather, double windSpeed, int degrees, int clouds) {
        this.dateTime = dateTime;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.weather = weather;
        this.windSpeed = windSpeed;
        this.degrees = degrees;
        this.clouds = clouds;
    }

    public int getDateTime() {
        return dateTime;
    }

    public void setDateTime(int dateTime) {
        this.dateTime = dateTime;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }
}
