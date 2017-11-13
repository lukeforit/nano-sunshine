package com.green.rabbit.sunshine.app.feature.forecast;

import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.green.rabbit.sunshine.app.BR;
import com.green.rabbit.sunshine.app.DetailActivity;
import com.green.rabbit.sunshine.app.R;
import com.green.rabbit.sunshine.app.data.model.CityForecast;
import com.green.rabbit.sunshine.app.databinding.FragmentForecastBinding;

import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastFragment extends Fragment {

    private static final String TAG = ForecastFragment.class.getSimpleName();

    private ArrayAdapter<String> mArrayAdapter;

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
        binding.setVariable(BR.vm, presenter.forecastViewModel);
        binding.executePendingBindings();

        presenter.loadData();

//        View rootView = inflater.inflate(R.layout.fragment_forecast, container, false);

//        mArrayAdapter = new ArrayAdapter<String>(getActivity(),R.layout.list_item_forecast,R.id.list_item_forecast_textview);

//        ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
//        listView.setAdapter(mArrayAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getActivity().getApplicationContext(), mArrayAdapter.getItem(position), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getActivity(),DetailActivity.class);
//                intent.putExtra(Intent.EXTRA_TEXT, mArrayAdapter.getItem(position));
//                startActivity(intent);
//            }
//        });

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

    public void update(CityForecast forecast) {

    }

    public void showError() {

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
