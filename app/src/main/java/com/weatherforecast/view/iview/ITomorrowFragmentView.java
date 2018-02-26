package com.weatherforecast.view.iview;


import com.weatherforecast.model.dto.response.Forecastday;


public interface ITomorrowFragmentView extends IView {

    void setData(Forecastday forecastday);
}
