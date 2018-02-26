package com.weatherforecast.model;


import com.weatherforecast.model.dto.response.WeatherResponse;
import com.weatherforecast.retrofit.ApiInterface;
import com.weatherforecast.retrofit.ApiClient;
import com.weatherforecast.retrofit.ResponseListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForecastModel{
    ResponseListener IResponseListener;
    protected long mCurrentTaskId = -1;
    protected String TAG = this.getClass().getSimpleName();


    public ForecastModel(ResponseListener iResponseListener) {

        IResponseListener = iResponseListener;
    }
    public void getForecast(int taskId, String key,String place, int days ) {
        this.mCurrentTaskId = taskId;
     ApiClient.getClient().create(ApiInterface.class).forecast(key,place,days).enqueue(new Callback<WeatherResponse>() {
         @Override
         public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
             switch (response.code()) {
                 case 200:

                     IResponseListener.onSuccess(response.body(), mCurrentTaskId);
                      break;

                 default:

                     IResponseListener.showErrorDialog(response.body(),mCurrentTaskId);


                     break;


             }

         }

         @Override
         public void onFailure(Call<WeatherResponse> call, Throwable t) {
             IResponseListener.onFailureApi(t);


         }
     });
    }


}
