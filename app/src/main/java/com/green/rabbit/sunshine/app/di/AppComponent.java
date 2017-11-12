package com.green.rabbit.sunshine.app.di;

import com.green.rabbit.sunshine.app.SunshineApp;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Łukasz on 12.11.2017.
 */
@Component(modules = {
        ApiModule.class,
        ActivityContributorModule.class,
        AndroidInjectionModule.class
})
public interface AppComponent {
    void inject(SunshineApp app);
}
