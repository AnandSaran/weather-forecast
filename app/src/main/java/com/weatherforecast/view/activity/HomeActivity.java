package com.weatherforecast.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.widget.Toast;


import com.weatherforecast.adapter.ViewPagerAdapter;
import com.weatherforecast.databinding.ActivityHomeBinding;
import com.weatherforecast.model.dto.response.WeatherResponse;
import com.weatherforecast.presenter.ipresenter.IHomeActivityPresenter;
import com.weatherforecast.util.Constants;
import com.weatherforecast.view.fragment.TodayFragment;
import com.weatherforecast.view.iview.IHomeActivityView;

import com.weatherforecast.R;

import com.weatherforecast.presenter.HomeActivityPresenter;
import com.weatherforecast.view.fragment.ThreeDaysFragment;
import com.weatherforecast.view.fragment.TomorrowFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements IHomeActivityView, SearchView.OnQueryTextListener {
    private IHomeActivityPresenter iHomeActivityPresenter;
    private ActivityHomeBinding binding;
    private List<String> mTabHeaderList = new ArrayList<>();
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        initView();
        iHomeActivityPresenter = new HomeActivityPresenter(this);
        iHomeActivityPresenter.onCreatePresenter(getIntent().getExtras());
        iHomeActivityPresenter.callForecastAPI("Bangalore");
    }

    private void initView() {
        binding.svPlaceSearch.setOnQueryTextListener(this);
        binding.tabLayout.setupWithViewPager(binding.viewpager);
        binding.tabLayout.setTabTextColors(ContextCompat.getColorStateList(getActivity(), R.color.tab_selector));
        binding.tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(getActivity(), android.R.color.white));
        setTabHeader();
    }

    private void setTabHeader() {
        mTabHeaderList.add("Today");
        mTabHeaderList.add("Tomorrow");
        mTabHeaderList.add("Upcoming Days");

    }

    @Override
    public void setAdapter(WeatherResponse mResponse) {
        Log.e(TAG,"setAdapter:"+mResponse.getCurrent().getTemp_c());


            viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());

            if (mResponse != null ) {
                Toast.makeText(this, "Showing result of "+mResponse.getLocation().getName(), Toast.LENGTH_SHORT).show();
                for (int i = 0; i < mResponse.getForecast().getForecastday().size(); i++) {
                    switch (i) {
                        case 0:
                            Bundle bToday = new Bundle();
                            bToday.putSerializable(Constants.BundleKey.TODAY_WEATHER, mResponse.getCurrent());
                            TodayFragment todayFragment = new TodayFragment();
                            todayFragment.setArguments(bToday);
                            viewPagerAdapter.addFragment(todayFragment, mTabHeaderList.get(0));

                            break;
                        case 1:
                            Bundle bTomorrow = new Bundle();
                            bTomorrow.putSerializable(Constants.BundleKey.TOMORROW_WEATHER, mResponse.getForecast().getForecastday().get(1));
                            TomorrowFragment tomorrowFragment = new TomorrowFragment();
                            tomorrowFragment.setArguments(bTomorrow);
                            viewPagerAdapter.addFragment(tomorrowFragment, mTabHeaderList.get(1));

                            break;
                        case 4:
                            Bundle bThreeDays = new Bundle();
                            bThreeDays.putSerializable(Constants.BundleKey.THREE_DAYS_WEATHER, new ArrayList<>( mResponse.getForecast().getForecastday().subList(2,5)));
                            ThreeDaysFragment threeDaysFragment = new ThreeDaysFragment();
                            threeDaysFragment.setArguments(bThreeDays);
                            viewPagerAdapter.addFragment(threeDaysFragment, mTabHeaderList.get(2));

                            break;
                        default:
                            break;
                    }



                }
            setViewPagerAdapter();
            }


    }
    public void setViewPagerAdapter() {
        binding.viewpager.setAdapter(viewPagerAdapter);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e(TAG, "onQueryTextSubmit " + query);
        iHomeActivityPresenter.callForecastAPI(query);
        return true;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
