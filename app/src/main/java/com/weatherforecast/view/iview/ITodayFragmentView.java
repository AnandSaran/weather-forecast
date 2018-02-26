package com.weatherforecast.view.iview;


import com.weatherforecast.model.dto.response.Current;


public interface ITodayFragmentView extends IView {

    void setData(Current forecastday);
}
