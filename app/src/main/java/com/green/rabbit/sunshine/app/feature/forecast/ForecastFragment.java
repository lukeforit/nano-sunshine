package com.green.rabbit.sunshine.app.feature.forecast;

import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.green.rabbit.sunshine.app.BR;
import com.green.rabbit.sunshine.app.R;
import com.green.rabbit.sunshine.app.databinding.FragmentForecastBinding;

import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastFragment extends Fragment {

    @Inject
    ForecastPresenter presenter;

    @Inject
    public ForecastFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentForecastBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_forecast, container, false);
        binding.setVariable(BR.vm, presenter.getForecastViewModel());
        binding.executePendingBindings();

        presenter.loadData();

        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.forecastfragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_refresh) {
            updateWeather();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateWeather(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String location = sp.getString(getString(R.string.pref_location_key), getString(R.string.pref_location_default));
    }

    private String getReadableDateString(long time){
        return new SimpleDateFormat("EEEE MMM dd", Locale.ENGLISH).format(time*1000L);
    }

    private String formatHighLows(double high, double low) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String units = sp.getString(getString(R.string.pref_units_key), getString(R.string.pref_units_default));
        if(units.equalsIgnoreCase(getString(R.string.pref_units_default)))
            return Math.round(high) + "/" + Math.round(low);
        else
            return Math.round(high*1.8+32.0)  + "/" + Math.round(low*1.8+32.0);
    }
}
