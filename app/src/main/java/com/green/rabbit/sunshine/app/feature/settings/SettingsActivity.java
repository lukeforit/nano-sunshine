package com.green.rabbit.sunshine.app.feature.settings;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.MenuItem;

import com.green.rabbit.sunshine.app.R;
import com.green.rabbit.sunshine.app.feature.BaseActivity;

/**
 * Created by Łukasz on 21.01.2016.
 */
public class SettingsActivity extends BaseActivity /*implements Preference.OnPreferenceChangeListener*/ {

    //public static final String PREF_CELSIUS_LBL    = "Metric";
    //public static final String PREF_KELVIN_LBL     = "Kelvin";
    //public static final String PREF_FAHRENHEIT_LBL = "Imperial";

    //public static final String PREF_CELSIUS_VAL    = "Celsius";
    //public static final String PREF_KELVIN_VAL     = "Kelvin";
    //public static final String PREF_FAHRENHEIT_VAL = "Fahrenheit";

    private static final String TAG = SettingsActivity.class.getSimpleName();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        // Add 'general' preferences, defined in the XML file
//        addPreferencesFromResource(R.xml.pref_forecast);

        //Arrays declared in @array/
        //ListPreference lp = (ListPreference) findPreference(getString(R.string.pref_units_key));
        //lp.setEntries(new CharSequence[] {PREF_CELSIUS_LBL,/*PREF_KELVIN_LBL,*/PREF_FAHRENHEIT_LBL});
        //lp.setEntryValues(new CharSequence[] {PREF_CELSIUS_VAL,/*PREF_KELVIN_VAL,*/PREF_FAHRENHEIT_VAL});

        // For all preferences, attach an OnPreferenceChangeListener so the UI summary can be
        // updated when the preference changes.
//        bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_location_key)));
//        bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_units_key)));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.support.v7.appcompat.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Attaches a listener so the summary is always updated with the preference value.
     * Also fires the listener once, to initialize the summary (so it shows up before the value
     * is changed.)
     */
//    private void bindPreferenceSummaryToValue(Preference preference) {
//        // Set the listener to watch for value changes.
//        preference.setOnPreferenceChangeListener(this);
//
//        // Trigger the listener immediately with the preference's
//        // current value.
//        onPreferenceChange(preference,
//                PreferenceManager
//                        .getDefaultSharedPreferences(preference.getContext())
//                        .getString(preference.getKey(), ""));
//    }
//
//    @Override
//    public boolean onPreferenceChange(Preference preference, Object newValue) {
//        String stringValue = newValue.toString();
//
//        Log.d(TAG, "onPreferenceChange " + stringValue);
//
//        if (preference instanceof ListPreference) {
//            // For list preferences, look up the correct display value in
//            // the preference's 'entries' list (since they have separate labels/values).
//            ListPreference listPreference = (ListPreference) preference;
//            int prefIndex = listPreference.findIndexOfValue(stringValue);
//            if (prefIndex >= 0) {
//                preference.setSummary(listPreference.getEntries()[prefIndex]);
//            }
//        } else {
//            // For other preferences, set the summary to the value's simple string representation.
//            preference.setSummary(stringValue);
//        }
//        return true;
//    }
}
