package com.green.rabbit.sunshine.app.di;

import com.green.rabbit.sunshine.app.feature.forecast.daily.DailyForecastActivity;
import com.green.rabbit.sunshine.app.feature.forecast.ForecastActivity;
import com.green.rabbit.sunshine.app.feature.forecast.ForecastModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Łukasz on 12.11.2017.
 */
@Module
public abstract class ActivityContributorModule {

    @ContributesAndroidInjector(modules = ForecastModule.class)
    abstract ForecastActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract DailyForecastActivity contributeDetailActivity();

}
