package com.green.rabbit.sunshine.app.data.source;

import com.green.rabbit.sunshine.app.data.model.CityForecast;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * Created by Łukasz on 11.11.2017.
 */

public class RetrofitWeatherDataSource implements IWeatherDataSource {

    private IWeatherDataSourceRest restService;

    public RetrofitWeatherDataSource(IWeatherDataSourceRest restService) {
        this.restService = restService;
    }

    @Override
    public Single<Response<CityForecast>> weather() {
        return restService.dynamicWeather();
    }
}
