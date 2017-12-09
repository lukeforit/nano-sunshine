package com.green.rabbit.sunshine.app.feature.settings;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.green.rabbit.sunshine.app.R;

/**
 * Created by Łukasz on 09.12.2017.
 */

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.pref_forecast);
    }
}
