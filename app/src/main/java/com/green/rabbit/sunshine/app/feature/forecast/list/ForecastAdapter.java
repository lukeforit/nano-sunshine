package com.green.rabbit.sunshine.app.feature.forecast.list;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.green.rabbit.sunshine.app.R;
import com.green.rabbit.sunshine.app.common.OnViewHolderClickListener;
import com.green.rabbit.sunshine.app.data.model.CityForecast;
import com.green.rabbit.sunshine.app.data.model.Forecast;
import com.green.rabbit.sunshine.app.databinding.ListItemForecastBinding;

import javax.inject.Inject;

/**
 * Created by Łukasz on 13.11.2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastViewHolder>
        implements OnViewHolderClickListener {

    private CityForecast cityForecast;
    private OnItemClickListener onItemClickListener;

    @Inject
    public ForecastAdapter() {
    }

    //TODO differentiate 1st item layout from the rest
    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemForecastBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.list_item_forecast,
                parent, false);
        return new ForecastViewHolder(binding, this);
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

    @Override
    public void onClick(int position) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(cityForecast.getForecasts()[position]);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(Forecast item);
    }
}
