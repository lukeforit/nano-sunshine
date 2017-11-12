package com.green.rabbit.sunshine.app.data.source;

import com.green.rabbit.sunshine.app.data.model.CityForecast;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * Created by Łukasz on 11.11.2017.
 */

public interface IWeatherDataSource {
    Single<Response<CityForecast>> weather();
}
