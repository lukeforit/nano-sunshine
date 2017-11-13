package com.green.rabbit.sunshine.app.feature.forecast;

import android.databinding.BaseObservable;

import com.green.rabbit.sunshine.app.data.model.CityForecast;

import javax.inject.Inject;

/**
 * Created by Łukasz on 12.11.2017.
 */

public class ForecastViewModel extends BaseObservable {

    @Inject
    public ForecastViewModel() {
    }

    public void update(CityForecast body) {

    }

    public void showError() {

    }
}
