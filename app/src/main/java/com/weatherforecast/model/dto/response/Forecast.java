package com.weatherforecast.model.dto.response;

import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;
import java.util.List;

@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS_AND_ACCESSORS)

public class Forecast implements Serializable {
    private List<Forecastday> forecastday;

    public List<Forecastday> getForecastday ()
    {
        return forecastday;
    }

    public void setForecastday (List<Forecastday> forecastday)
    {
        this.forecastday = forecastday;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [forecastday = "+forecastday+"]";
    }
}
