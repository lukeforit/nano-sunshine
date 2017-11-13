package com.green.rabbit.sunshine.app.feature.forecast;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Łukasz on 13.11.2017.
 */
@Module
public class ForecastModule {
    @Provides
    public Context provideContext(ForecastActivity activity) {
        return activity;
    }
}
