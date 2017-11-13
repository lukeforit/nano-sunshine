package com.green.rabbit.sunshine.app.feature.forecast.list;

import android.databinding.BaseObservable;

import com.green.rabbit.sunshine.app.data.model.Forecast;

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
}
