package com.green.rabbit.sunshine.app.common;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.green.rabbit.sunshine.app.data.model.Forecast;
import com.green.rabbit.sunshine.app.feature.BaseActivity;
import com.green.rabbit.sunshine.app.feature.forecast.daily.DailyForecastActivity;
import com.green.rabbit.sunshine.app.feature.settings.SettingsActivity;

import org.parceler.Parcels;

import javax.inject.Inject;

/**
 * Created by Łukasz on 14.11.2017.
 */

public class ContextUtils {
    @Inject
    BaseActivity activityContext;

    @Inject
    ContextUtils() {
    }

    public void startDailyForecastActivity(Forecast forecast) {
        Intent intent = new Intent(activityContext, DailyForecastActivity.class);
        intent.putExtra(DailyForecastActivity.BUNDLE_KEY_FORECAST, Parcels.wrap(forecast));
        activityContext.startActivity(intent);
    }

    public void startSettingsActivity() {
        activityContext.startActivity(new Intent(activityContext, SettingsActivity.class));
    }

    public void startActivityByIntent(Intent intent) {
        activityContext.startActivity(intent);
    }

    public boolean resolveActivity(@NonNull Intent intent) {
        return intent.resolveActivity(activityContext.getPackageManager()) != null;
    }

    public BaseActivity getActivityContext() {
        return activityContext;
    }
}
