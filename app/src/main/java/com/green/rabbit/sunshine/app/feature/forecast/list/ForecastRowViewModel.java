package com.green.rabbit.sunshine.app.feature.forecast.list;

import android.databinding.BaseObservable;

import com.green.rabbit.sunshine.app.data.model.Forecast;

import java.util.Date;

/**
 * Created by Łukasz on 13.11.2017.
 */

public class ForecastRowViewModel extends BaseObservable {
    private Forecast forecast;

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public String getText() {
        return forecast + "";
    }

    //TODO use it in data binding
    public String getDescription() {
        return forecast.getWeather()[0].getDescription();
    }

    public String getDay() {
        return new Date(forecast.getDateTime()).toString();
    }

    public String getLow() {
        return String.valueOf(forecast.getTemp().getMin());
    }

    public String getHigh() {
        return String.valueOf(forecast.getTemp().getMax());
    }
}
