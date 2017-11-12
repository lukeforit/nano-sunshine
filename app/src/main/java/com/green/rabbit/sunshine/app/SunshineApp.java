package com.green.rabbit.sunshine.app;

import android.app.Activity;
import android.app.Application;

import com.green.rabbit.sunshine.app.di.AppComponent;
import com.green.rabbit.sunshine.app.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by Łukasz on 12.11.2017.
 */

public class SunshineApp extends Application implements HasActivityInjector {

    private AppComponent daggerAppComponent;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        daggerAppComponent = DaggerAppComponent.create();
        daggerAppComponent.inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
