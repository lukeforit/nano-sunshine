package com.green.rabbit.sunshine.app.di;

import com.green.rabbit.sunshine.app.data.source.IWeatherDataSource;
import com.green.rabbit.sunshine.app.data.source.IWeatherDataSourceRest;
import com.green.rabbit.sunshine.app.data.source.RetrofitWeatherDataSource;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Łukasz on 12.11.2017.
 */
@Module
public class ApiModule {
    @Provides
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://andfun-weather.udacity.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    public IWeatherDataSource provideWeatherDataSource(Retrofit retrofit) {
        return new RetrofitWeatherDataSource(retrofit.create(IWeatherDataSourceRest.class));
    }
}
