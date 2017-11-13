package com.green.rabbit.sunshine.app.feature.forecast.list;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.green.rabbit.sunshine.app.R;
import com.green.rabbit.sunshine.app.data.model.CityForecast;
import com.green.rabbit.sunshine.app.databinding.ListItemForecastBinding;

import javax.inject.Inject;

/**
 * Created by Łukasz on 13.11.2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastViewHolder> {

    private CityForecast cityForecast;

    @Inject
    public ForecastAdapter() {
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemForecastBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.list_item_forecast,
                parent, false);
        return new ForecastViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        holder.setData(cityForecast.getForecasts()[position]);
    }

    @Override
    public int getItemCount() {
        return cityForecast == null ? 0 : cityForecast.getCount();
    }

    public void setData(CityForecast data) {
        cityForecast = data;
        notifyDataSetChanged();
    }
}
