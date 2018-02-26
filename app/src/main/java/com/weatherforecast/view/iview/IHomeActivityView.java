package com.weatherforecast.view.iview;


import com.weatherforecast.model.dto.response.WeatherResponse;


public interface IHomeActivityView extends IView {

    void setAdapter(WeatherResponse mResponse);
}
