package com.weatherforecast.presenter;

import android.os.Bundle;
import android.util.Log;

import com.weatherforecast.model.ForecastModel;
import com.weatherforecast.model.dto.response.WeatherResponse;
import com.weatherforecast.presenter.ipresenter.IHomeActivityPresenter;
import com.weatherforecast.view.iview.IHomeActivityView;

import com.weatherforecast.R;

import com.weatherforecast.retrofit.ResponseListener;


public class HomeActivityPresenter extends BasePresenter implements IHomeActivityPresenter {
    private IHomeActivityView iHomeActivityView;

    public HomeActivityPresenter(IHomeActivityView iHomeActivityView) {
        super(iHomeActivityView);
        this.iHomeActivityView = iHomeActivityView;
    }

    @Override
    public void callForecastAPI(String cityName) {
        if (iHomeActivityView.checkNetWork()) {
            iHomeActivityView.showProgressbar();
            ForecastModel newsModel = new ForecastModel(getForecastListener);
            newsModel.getForecast(0,"1db1f346c5ce46e7944161149182202",cityName,5);
        } else {
            iHomeActivityView.showSnackBar(iHomeActivityView.getActivity().getString(R.string.no_network));

        }

    }
    private ResponseListener<WeatherResponse> getForecastListener = new ResponseListener<WeatherResponse>() {
        @Override
        public void onSuccess(WeatherResponse mResponse, long flag) {
            Log.e(TAG, "onSuccess" + mResponse.toString());
            iHomeActivityView.dismissProgressbar();

            iHomeActivityView.setAdapter(mResponse);

        }


        @Override
        public void onFailureApi(Throwable mThrowable) {
            iHomeActivityView.dismissProgressbar();
            iHomeActivityView.showMessage("Server error,try again!");

        }

        @Override
        public void showErrorDialog(WeatherResponse mResponse, long flag) {
            iHomeActivityView.dismissProgressbar();
            iHomeActivityView.showMessage("Server error, try again!");

        }
    };

    @Override
    public void onCreatePresenter(Bundle bundle) {

    }
}
