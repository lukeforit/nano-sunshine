package com.green.rabbit.sunshine.app.feature.forecast.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.green.rabbit.sunshine.app.data.model.Forecast;
import com.green.rabbit.sunshine.app.databinding.ListItemForecastBinding;

/**
 * Created by Łukasz on 13.11.2017.
 */

public class ForecastViewHolder extends RecyclerView.ViewHolder {

    private ForecastRowViewModel viewModel;
    private ListItemForecastBinding binding;

    public ForecastViewHolder(ListItemForecastBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        this.viewModel = new ForecastRowViewModel();
        this.binding.setVariable(BR.vm, viewModel);
    }

    public void setData(Forecast forecast) {
        this.viewModel.setForecast(forecast);
        this.viewModel.notifyChange();
    }
}
