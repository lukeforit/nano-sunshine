package com.green.rabbit.sunshine.app.feature.forecast;

import com.green.rabbit.sunshine.app.data.model.CityForecast;
import com.green.rabbit.sunshine.app.data.source.IWeatherDataSource;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by Łukasz on 12.11.2017.
 */

public class ForecastPresenter {

    @Inject
    IWeatherDataSource dataSource;

    @Inject
    ForecastViewModel forecastViewModel;

    @Inject
    ForecastPresenter() {
    }

    void loadData() {
        dataSource.weather()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new SingleObserver<Response<CityForecast>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                    }

                    @Override
                    public void onSuccess(Response<CityForecast> cityForecastResponse) {
                        if (cityForecastResponse.isSuccessful()) {
                            forecastViewModel.update(cityForecastResponse.body());
                        } else {
                            forecastViewModel.showError();
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        forecastViewModel.showError();
                    }
                });
    }
}
