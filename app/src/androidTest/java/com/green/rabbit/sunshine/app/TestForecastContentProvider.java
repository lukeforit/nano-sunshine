package com.green.rabbit.sunshine.app;

import android.content.UriMatcher;
import android.net.Uri;
import android.support.test.runner.AndroidJUnit4;

import com.green.rabbit.sunshine.app.data.source.local.ForecastContentProvider;
import com.green.rabbit.sunshine.app.data.source.local.ForecastContract;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Łukasz on 29.01.2018.
 */
@RunWith(AndroidJUnit4.class)
public class TestForecastContentProvider {

    private static final Uri TEST_FORECAST = ForecastContract.ForecastEntry.CONTENT_URI;
    private static final Uri TEST_FORECAST_WITH_ID = TEST_FORECAST.buildUpon().appendPath("1").build();

    @Test
    public void testUriMatcher() {
        UriMatcher testMatcher = ForecastContentProvider.buildUriMatcher();

        assertEquals("Error: URI matched incorrectly",
                testMatcher.match(TEST_FORECAST),
                ForecastContentProvider.FORECAST);

        assertEquals("Error: URI was matched incorrectly",
                testMatcher.match(TEST_FORECAST_WITH_ID),
                ForecastContentProvider.FORECAST_WITH_ID);
    }
}
