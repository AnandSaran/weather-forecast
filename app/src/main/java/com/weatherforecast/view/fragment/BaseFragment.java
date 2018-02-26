package com.weatherforecast.view.fragment;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;

import com.weatherforecast.presenter.ipresenter.IPresenter;
import com.weatherforecast.view.iview.IView;


public abstract class BaseFragment extends Fragment implements IView {

    protected String TAG = getClass().getSimpleName();

    @Override
    public void bindPresenter(IPresenter iPresenter) {
        // nothing to implement here!
    }

    @Override
    public void showMessage(String message) {
        try {
            ((IView) getActivity()).showMessage(message);
        }catch (Exception e){
        }
    }

    @Override
    public void showMessage(int resId) {
        ((IView)getActivity()).showMessage(resId);
    }


    @Override
    public void showProgressbar() {
        ((IView)getActivity()).showProgressbar();
    }

    @Override
    public void dismissProgressbar() {
        try {


            ((IView) getActivity()).dismissProgressbar();
        }catch (Exception e){
        }
    }
    @Override
    public void showSnackBar(String message) {
        ((IView)getActivity()).showSnackBar(message);
    }

    @Override
    public void showNetworkMessage() {
        ((IView)getActivity()).showNetworkMessage();
    }

     @Override
    public void showSnackBar(@NonNull View view, String message) {
        ((IView)getActivity()).showSnackBar(view,message);
    }
    @Override
    public boolean checkNetWork() {
      return   ((IView)getActivity()).checkNetWork();

    }

}
