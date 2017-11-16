package com.green.rabbit.sunshine.app.feature.forecast;

import android.databinding.BaseObservable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.green.rabbit.sunshine.app.data.model.CityForecast;
import com.green.rabbit.sunshine.app.feature.BaseActivity;
import com.green.rabbit.sunshine.app.feature.forecast.list.ForecastAdapter;

import javax.inject.Inject;

/**
 * Created by Łukasz on 12.11.2017.
 */

public class ForecastViewModel extends BaseObservable {

    @Inject
    ForecastAdapter adapter;

    @Inject
    BaseActivity activityContext;

    private RecyclerView.LayoutManager layoutManager;

    @Inject
    public ForecastViewModel() {
        layoutManager = new LinearLayoutManager(activityContext);
    }

    public ForecastAdapter getAdapter() {
        return adapter;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setOnForecastItemClickListener(ForecastAdapter.OnItemClickListener listener) {
        adapter.setOnItemClickListener(listener);
    }

    void update(CityForecast body) {
        adapter.setData(body);
    }

    void showError() {

    }
}
