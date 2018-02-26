package com.weatherforecast.retrofit;


import com.weatherforecast.model.dto.response.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

  //  http://api.apixu.com/v1/forecast.json?key=1db1f346c5ce46e7944161149182202   &q=bangal&days=4
    @GET("/v1/forecast.json")
    Call<WeatherResponse> forecast(@Query("key") String key, @Query("q") String place, @Query("days") int days);


}
