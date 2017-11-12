package com.green.rabbit.sunshine.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.green.rabbit.sunshine.app.data.source.IWeatherDataSource;
import com.green.rabbit.sunshine.app.feature.BaseActivity;

import javax.inject.Inject;


public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    IWeatherDataSource weatherDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        } else if (item.getItemId() == R.id.action_location) {
            onPreferedLocationInMap();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void onPreferedLocationInMap() {
        Intent i = new Intent(Intent.ACTION_VIEW);
        Uri.Builder uriBuilder = new Uri.Builder();
        uriBuilder.scheme("geo").opaquePart("0,0").appendQueryParameter("q",
                PreferenceManager.getDefaultSharedPreferences(this)
                        .getString(getString(R.string.pref_location_key), getString(R.string.pref_location_default)));
        i.setData(uriBuilder.build());
        //Log.d(TAG, uriBuilder.build().toString());
        if (i.resolveActivity(getPackageManager()) != null)
            startActivity(i);
        else Log.d(TAG, "No map application");
    }
}
