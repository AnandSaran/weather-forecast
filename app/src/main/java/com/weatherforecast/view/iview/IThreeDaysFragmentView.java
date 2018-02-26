package com.weatherforecast.view.iview;


import java.util.List;

import com.weatherforecast.model.dto.response.Forecastday;


public interface IThreeDaysFragmentView extends IView {

    void setData(List<Forecastday> forecastday);
}
