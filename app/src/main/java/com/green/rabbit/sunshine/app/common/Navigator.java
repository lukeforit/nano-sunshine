package com.green.rabbit.sunshine.app.common;

import android.content.Intent;

import com.green.rabbit.sunshine.app.feature.forecast.daily.DailyForecastActivity;
import com.green.rabbit.sunshine.app.data.model.Forecast;
import com.green.rabbit.sunshine.app.feature.BaseActivity;

import org.parceler.Parcel;
import org.parceler.Parcels;

import javax.inject.Inject;

/**
 * Created by Łukasz on 14.11.2017.
 */

public class Navigator {
    @Inject
    BaseActivity activityContext;

    @Inject
    Navigator() {
    }

    public void startDailyForecastActivity(Forecast forecast) {
        Intent intent = new Intent(activityContext, DailyForecastActivity.class);
        intent.putExtra(DailyForecastActivity.BUNDLE_KEY_FORECAST, Parcels.wrap(forecast));
        activityContext.startActivity(intent);
    }
}
