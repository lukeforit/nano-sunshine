package com.green.rabbit.sunshine.app.feature.forecast.daily;

import javax.inject.Inject;

/**
 * Created by Łukasz on 16.11.2017.
 */

public class DailyForecastPresenter {

    @Inject
    DailyForecastViewModel viewModel;

    @Inject
    public DailyForecastPresenter() {
    }

    public void onIconPrefChanged(boolean visible) {

    }

    public void onTempUnitsPrefChanged(String string) {

    }

    public void onLocationPrefChanged(String string) {

    }
}
