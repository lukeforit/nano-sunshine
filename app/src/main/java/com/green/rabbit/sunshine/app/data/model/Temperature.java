package com.green.rabbit.sunshine.app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Łukasz on 11.11.2017.
 */

public class Temperature {
    private double day;
    private double min;
    private double max;
    private double night;
    @SerializedName("eve")
    private double evening;
    @SerializedName("morn")
    private double morning;

    public Temperature(double day, double min, double max, double night, double evening, double morning) {
        this.day = day;
        this.min = min;
        this.max = max;
        this.night = night;
        this.evening = evening;
        this.morning = morning;
    }

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getEvening() {
        return evening;
    }

    public void setEvening(double evening) {
        this.evening = evening;
    }

    public double getMorning() {
        return morning;
    }

    public void setMorning(double morning) {
        this.morning = morning;
    }
}
