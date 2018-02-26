package com.weatherforecast.presenter;

import android.os.Bundle;

import com.weatherforecast.model.dto.response.Forecastday;
import com.weatherforecast.presenter.ipresenter.ITomorrowFragmentPresenter;
import com.weatherforecast.util.Constants;
import com.weatherforecast.view.iview.ITomorrowFragmentView;


public class TomorrowFragmentPresenter extends BasePresenter implements ITomorrowFragmentPresenter {
    private ITomorrowFragmentView iTomorrowFragmentView;

    public TomorrowFragmentPresenter(ITomorrowFragmentView iTomorrowFragmentView) {
        super(iTomorrowFragmentView);
        this.iTomorrowFragmentView = iTomorrowFragmentView;
    }


    @Override
    public void onCreatePresenter(Bundle bundle) {
        Forecastday forecastday = (Forecastday) bundle.getSerializable(Constants.BundleKey.TOMORROW_WEATHER);
        if (forecastday != null) {
            iTomorrowFragmentView.setData(forecastday);
        }

    }
}
