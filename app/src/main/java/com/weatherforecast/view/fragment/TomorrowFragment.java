package com.weatherforecast.view.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.weatherforecast.databinding.FragmentTomorrowBinding;
import com.weatherforecast.presenter.TomorrowFragmentPresenter;

import com.weatherforecast.R;
import com.weatherforecast.model.dto.response.Forecastday;
import com.weatherforecast.presenter.ipresenter.ITomorrowFragmentPresenter;
import com.weatherforecast.util.CommonUtils;
import com.weatherforecast.view.iview.ITomorrowFragmentView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TomorrowFragment extends BaseFragment implements ITomorrowFragmentView {

    FragmentTomorrowBinding binding;
    private ITomorrowFragmentPresenter iTomorrowFragmentPresenter;

    public TomorrowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_tomorrow, container, false);
        View rootView = binding.getRoot();

        iTomorrowFragmentPresenter = new TomorrowFragmentPresenter(this);
        iTomorrowFragmentPresenter.onCreatePresenter(getArguments());
        return rootView;
    }

    @Override
    public void setData(Forecastday forecastday) {
        binding.date.setText(CommonUtils.getInstance().convertDateToMonthDateString(forecastday.getDate()));
        binding.temp.setText(forecastday.getDay().getAvgtemp_c()+ " "+getString(R.string.degree_c));
        binding.tempCondition.setText(forecastday.getDay().getCondition().getText());
        Glide.with(getActivity()).load("http:"+forecastday.getDay().getCondition().getIcon()).into(binding.tempImage);

        binding.windSpeed.setText(getString(R.string.wind_speed)+" "+forecastday.getDay().getMaxwind_kph()+" kph");
        binding.windDegree.setText(getString(R.string.wind_degree)+" "+forecastday.getDay().getAvgvis_km());
        binding.humidity.setText(getString(R.string.humidity)+" "+forecastday.getDay().getAvghumidity());


    }
}
