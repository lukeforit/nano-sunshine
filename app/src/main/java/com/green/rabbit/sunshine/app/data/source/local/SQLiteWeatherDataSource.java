package com.green.rabbit.sunshine.app.data.source.local;

import com.green.rabbit.sunshine.app.data.model.CityForecast;
import com.green.rabbit.sunshine.app.data.source.IWeatherDataSource;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * Created by Łukasz on 05.01.2018.
 */

public class SQLiteWeatherDataSource implements IWeatherDataSource {
    //TODO Implement queries for retrieving and extracting data from the db
    @Override
    public Single<Response<CityForecast>> weather() {
        return null;
    }
}
