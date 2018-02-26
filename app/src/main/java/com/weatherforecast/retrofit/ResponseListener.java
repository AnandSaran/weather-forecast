package com.weatherforecast.retrofit;



public interface ResponseListener<T> {
    void onSuccess(T mResponse, long flag);
    void onFailureApi(Throwable mThrowable);
   // void showDialog(T mResponse, long flag);
    void showErrorDialog(T mResponse, long flag);
   // void showInternalServerErrorDialog(T mResponse, long flag);
    //void logOut(long flag);

}
