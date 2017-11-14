package com.green.rabbit.sunshine.app.common;

import android.content.Intent;

import com.green.rabbit.sunshine.app.DetailActivity;
import com.green.rabbit.sunshine.app.feature.BaseActivity;

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

    public void startDailyForecastActivity() {
        activityContext.startActivity(new Intent(activityContext, DetailActivity.class));
    }
}
