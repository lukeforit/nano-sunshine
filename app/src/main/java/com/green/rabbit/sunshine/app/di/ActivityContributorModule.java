package com.green.rabbit.sunshine.app.di;

import com.green.rabbit.sunshine.app.DetailActivity;
import com.green.rabbit.sunshine.app.feature.forecast.ForecastActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Łukasz on 12.11.2017.
 */
@Module
public abstract class ActivityContributorModule {

    @ContributesAndroidInjector
    abstract ForecastActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract DetailActivity contributeDetailActivity();

}
