package com.green.rabbit.sunshine.app.data.source.net;

import com.green.rabbit.sunshine.app.data.model.CityForecast;
import com.green.rabbit.sunshine.app.data.source.IWeatherDataSource;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * Created by Łukasz on 11.11.2017.
 */
//TODO Implement cache with DB usage
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
