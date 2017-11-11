package com.green.rabbit.sunshine.app.data.source;

import com.green.rabbit.sunshine.app.data.model.CityForecast;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by Łukasz on 11.11.2017.
 */

public interface IWeatherDataSourceRest {
    @GET("weather")
    Single<Response<CityForecast>> dynamicWeather();

    @GET("staticweather")
    Single<Response<CityForecast>> staticWeather();
}
