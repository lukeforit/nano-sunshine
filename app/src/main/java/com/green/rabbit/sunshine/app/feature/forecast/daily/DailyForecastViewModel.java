package com.green.rabbit.sunshine.app.feature.forecast.daily;

import android.databinding.BaseObservable;

import com.green.rabbit.sunshine.app.data.model.Forecast;

import javax.inject.Inject;

/**
 * Created by Łukasz on 16.11.2017.
 */

public class DailyForecastViewModel extends BaseObservable{

    private Forecast forecast;

    @Inject
    public DailyForecastViewModel() {
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
        notifyChange();
    }
}
