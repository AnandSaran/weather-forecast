package com.weatherforecast.view.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weatherforecast.adapter.WeatherAdapter;
import com.weatherforecast.databinding.FragmentThreeDaysBinding;
import com.weatherforecast.presenter.ThreeDaysFragmentPresenter;
import com.weatherforecast.presenter.ipresenter.IThreeDaysFragmentPresenter;
import com.weatherforecast.view.iview.IThreeDaysFragmentView;

import java.util.List;

import com.weatherforecast.R;
import com.weatherforecast.model.dto.response.Forecastday;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeDaysFragment extends BaseFragment implements IThreeDaysFragmentView {

private IThreeDaysFragmentPresenter iThreeDaysFragmentPresenter;
private FragmentThreeDaysBinding binding;
    public ThreeDaysFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_three_days, container, false);
        View rootView = binding.getRoot();

        iThreeDaysFragmentPresenter = new ThreeDaysFragmentPresenter(this);
        iThreeDaysFragmentPresenter.onCreatePresenter(getArguments());
        return rootView;
    }

    @Override
    public void setData(List<Forecastday> forecastday) {

       WeatherAdapter mAdapter = new WeatherAdapter(forecastday,getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerView.setLayoutManager(mLayoutManager);
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.setAdapter(mAdapter);


    }
}
