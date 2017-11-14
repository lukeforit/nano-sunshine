package com.green.rabbit.sunshine.app.feature.forecast;

import com.green.rabbit.sunshine.app.common.Navigator;
import com.green.rabbit.sunshine.app.data.model.CityForecast;
import com.green.rabbit.sunshine.app.data.model.Forecast;
import com.green.rabbit.sunshine.app.data.source.IWeatherDataSource;
import com.green.rabbit.sunshine.app.feature.forecast.list.ForecastAdapter;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by Łukasz on 12.11.2017.
 */

public class ForecastPresenter implements ForecastAdapter.OnItemClickListener {

    private IWeatherDataSource dataSource;

    private ForecastViewModel forecastViewModel;

    private Navigator navigator;

    @Inject
    ForecastPresenter(IWeatherDataSource dataSource, ForecastViewModel forecastViewModel,
                      Navigator navigator) {
        this.dataSource = dataSource;
        this.forecastViewModel = forecastViewModel;
        this.navigator = navigator;
        this.forecastViewModel.setOnForecastItemClickListener(this);
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

    @Override
    public void onItemClick(Forecast item) {
        navigator.startDailyForecastActivity();
    }

    public ForecastViewModel getForecastViewModel() {
        return forecastViewModel;
    }
}
