package com.green.rabbit.sunshine.app.feature.forecast;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;

import com.green.rabbit.sunshine.app.R;
import com.green.rabbit.sunshine.app.common.ContextUtils;
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

    private ContextUtils contextUtils;

    @Inject
    ForecastPresenter(IWeatherDataSource dataSource, ForecastViewModel forecastViewModel,
                      ContextUtils contextUtils) {
        this.dataSource = dataSource;
        this.forecastViewModel = forecastViewModel;
        this.contextUtils = contextUtils;
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
        contextUtils.startDailyForecastActivity(item);
    }

    ForecastViewModel getForecastViewModel() {
        return forecastViewModel;
    }

    void showRawDataInBrowser() {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://andfun-weather.udacity.com/weather"));
        if (contextUtils.resolveActivity(intent)) {
            contextUtils.startActivityByIntent(intent);
        }
    }

    void showOnMap() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = new Uri.Builder()
                .scheme("geo").path("37.386051,-122.08384")
                .appendQueryParameter("z", "1")
                .build();
        intent.setData(uri);
        if (contextUtils.resolveActivity(intent)) {
            contextUtils.startActivityByIntent(intent);
        }
    }

    //TODO move to details to share the content passed to the activity
    void share() {
        Intent intent = ShareCompat.IntentBuilder.from(contextUtils.getActivityContext())
                .setChooserTitle(R.string.action_share_title)
                .setType("text/plain")
                .setText("weather data").getIntent();
        if (contextUtils.resolveActivity(intent)) {
            contextUtils.startActivityByIntent(intent);
        }
    }

    public void navigateToSettings() {
        contextUtils.startSettingsActivity();
    }
}
