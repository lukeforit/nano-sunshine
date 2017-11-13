package com.green.rabbit.sunshine.app.feature.forecast.list;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import javax.inject.Inject;

/**
 * Created by Łukasz on 13.11.2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastViewHolder> {

    @Inject
    public ForecastAdapter() {
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
