package com.green.rabbit.sunshine.app.feature.forecast;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.green.rabbit.sunshine.app.R;
import com.green.rabbit.sunshine.app.feature.BaseActivity;

import javax.inject.Inject;


public class ForecastActivity extends BaseActivity {

    private static final String TAG = ForecastActivity.class.getSimpleName();

    //FIXME: deliver fragment in a different way to fix app crashes on activity state changed (rotation)
    @Inject
    ForecastFragment forecastFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, forecastFragment)
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_forecast, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            forecastFragment.onSettingsItemSelected();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
