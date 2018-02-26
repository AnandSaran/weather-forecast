package com.weatherforecast.presenter;

import android.os.Bundle;

import com.weatherforecast.presenter.ipresenter.IThreeDaysFragmentPresenter;
import com.weatherforecast.util.Constants;

import java.util.List;

import com.weatherforecast.model.dto.response.Forecastday;
import com.weatherforecast.view.iview.IThreeDaysFragmentView;


public class ThreeDaysFragmentPresenter extends BasePresenter implements IThreeDaysFragmentPresenter {
    private IThreeDaysFragmentView iThreeDaysFragmentView;

    public ThreeDaysFragmentPresenter(IThreeDaysFragmentView iThreeDaysFragmentView) {
        super(iThreeDaysFragmentView);
        this.iThreeDaysFragmentView = iThreeDaysFragmentView;
    }


    @Override
    public void onCreatePresenter(Bundle bundle) {
        List<Forecastday> forecastdays = (List<Forecastday>) bundle.getSerializable(Constants.BundleKey.THREE_DAYS_WEATHER);
        if (forecastdays != null) {
            iThreeDaysFragmentView.setData(forecastdays);
        }

    }
}
