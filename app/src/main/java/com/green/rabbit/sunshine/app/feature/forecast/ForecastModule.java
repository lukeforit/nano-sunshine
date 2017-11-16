package com.green.rabbit.sunshine.app.feature.forecast;

import com.green.rabbit.sunshine.app.feature.BaseActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Łukasz on 13.11.2017.
 */
@Module
public class ForecastModule {
    @Provides
    public BaseActivity provideContext(ForecastActivity activity) {
        return activity;
    }
}
