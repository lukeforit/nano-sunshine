package com.green.rabbit.sunshine.app.feature.forecast.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.green.rabbit.sunshine.app.common.OnViewHolderClickListener;
import com.green.rabbit.sunshine.app.data.model.Forecast;
import com.green.rabbit.sunshine.app.databinding.ListItemForecastBinding;

/**
 * Created by Łukasz on 13.11.2017.
 */

public class ForecastViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ForecastRowViewModel viewModel;
    private OnViewHolderClickListener forecastListener;

    public ForecastViewHolder(ListItemForecastBinding binding, OnViewHolderClickListener listener) {
        super(binding.getRoot());
        viewModel = new ForecastRowViewModel();
        forecastListener = listener;
        binding.setVariable(BR.vm, viewModel);
        binding.getRoot().setOnClickListener(this);
    }

    public void setData(Forecast forecast) {
        this.viewModel.setForecast(forecast);
        this.viewModel.notifyChange();
    }

    @Override
    public void onClick(View view) {
        forecastListener.onClick(getAdapterPosition());
    }
}
