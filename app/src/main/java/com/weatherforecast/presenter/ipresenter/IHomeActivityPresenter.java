package com.weatherforecast.presenter.ipresenter;


public interface IHomeActivityPresenter extends IPresenter {
    void callForecastAPI(String cityName);

}
