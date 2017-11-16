package com.green.rabbit.sunshine.app.feature.forecast.daily;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.databinding.library.baseAdapters.BR;
import com.green.rabbit.sunshine.app.R;
import com.green.rabbit.sunshine.app.SettingsActivity;
import com.green.rabbit.sunshine.app.data.model.Forecast;
import com.green.rabbit.sunshine.app.databinding.FragmentDailyForecastBinding;
import com.green.rabbit.sunshine.app.feature.BaseActivity;

import org.parceler.Parcels;

import javax.inject.Inject;

public class DailyForecastActivity extends BaseActivity {

    public static final String BUNDLE_KEY_FORECAST =
            DailyForecastActivity.class.getSimpleName() + ".BUNDLE_KEY_FORECAST";

    @Inject
    PlaceholderFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail, menu);
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
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private static final String TAG = PlaceholderFragment.class.getSimpleName();
        private static final String CONST_TEXT = "#ShunshineApp";

        @Inject
        DailyForecastPresenter presenter;

        @Inject
        public PlaceholderFragment() {
            setHasOptionsMenu(true);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Intent intent = getActivity().getIntent();
            FragmentDailyForecastBinding binding = DataBindingUtil.inflate(inflater,
                    R.layout.fragment_daily_forecast, container, false);

            if (intent != null && intent.hasExtra(BUNDLE_KEY_FORECAST)){
                Forecast forecast = Parcels.unwrap(intent.getParcelableExtra(BUNDLE_KEY_FORECAST));
                presenter.viewModel.setForecast(forecast);
            }
            binding.setVariable(BR.vm, presenter.viewModel);
            binding.executePendingBindings();
            return binding.getRoot();
        }

        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            inflater.inflate(R.menu.detailfragment, menu);

//            Intent i = new Intent()
//                    .setAction(Intent.ACTION_SEND)
//                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
//                    .setType("text/plain")
//                    .putExtra(Intent.EXTRA_TEXT,mDetailText + " " + CONST_TEXT);
//            ShareActionProvider sap = (ShareActionProvider) MenuItemCompat.getActionProvider(menu.findItem(R.id.action_share));
//            if (sap != null) {
//                Log.d(TAG, "Set share: " + mDetailText + " " + CONST_TEXT);
//                sap.setShareIntent(i);
//            }
//            else
//                Log.d(TAG, "No action provider");
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            //int id = item.getItemId();
            return super.onOptionsItemSelected(item);
        }
    }
}
