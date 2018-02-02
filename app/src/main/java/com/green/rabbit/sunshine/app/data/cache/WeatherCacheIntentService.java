package com.green.rabbit.sunshine.app.data.cache;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by Łukasz on 02.02.2018.
 */

public class WeatherCacheIntentService extends IntentService {

    public static final String ACTION_WEATHER_CACHE = WeatherCacheIntentService.class.getName()
            + ".WEATHER_CACHE";

    public WeatherCacheIntentService() {
        super(WeatherCacheIntentService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null && intent.getAction().equalsIgnoreCase(ACTION_WEATHER_CACHE)) {
            //TODO access content provider and save data
        }
    }
}
