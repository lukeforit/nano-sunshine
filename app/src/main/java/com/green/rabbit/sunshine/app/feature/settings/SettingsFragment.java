package com.green.rabbit.sunshine.app.feature.settings;

import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.widget.Toast;

import com.green.rabbit.sunshine.app.R;

/**
 * Created by Łukasz on 09.12.2017.
 */

public class SettingsFragment extends PreferenceFragmentCompat
        implements Preference.OnPreferenceChangeListener {

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.pref_forecast);
        Preference preference = findPreference(getString(R.string.pref_location_key));
        preference.setOnPreferenceChangeListener(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (newValue.toString().matches("\\d+")) {
            return true;
        } else {
            Toast.makeText(getContext(), R.string.error_location_format_invalid, Toast.LENGTH_SHORT)
                    .show();
            return false;
        }
    }
}
