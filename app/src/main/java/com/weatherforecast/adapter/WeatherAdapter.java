package com.weatherforecast.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import com.weatherforecast.R;

import com.weatherforecast.model.dto.response.Forecastday;
import com.weatherforecast.util.CommonUtils;


public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder> {

    private List<Forecastday> forecasteList;
    private Context mContext;

    public WeatherAdapter(List<Forecastday> moviesList, Context context) {
        this.forecasteList = moviesList;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Forecastday forecast = forecasteList.get(position);
        holder.date.setText(CommonUtils.getInstance().convertDateToDayMonthDateString(forecast.getDate()));
        holder.tempMax.setText(forecast.getDay().getMaxtemp_c() + " " + mContext.getString(R.string.degree_c));
        holder.tempMin.setText(forecast.getDay().getMintemp_c() + " " + mContext.getString(R.string.degree_c));
        holder.tempCondition.setText(forecast.getDay().getCondition().getText());
        Glide.with(mContext).load("http:" + forecast.getDay().getCondition().getIcon()).into(holder.tempImage);

    }

    @Override
    public int getItemCount() {
        return forecasteList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView date, tempMax,tempMin,tempCondition;
        public ImageView tempImage;

        public MyViewHolder(View view) {
            super(view);
            date = view.findViewById(R.id.date);
            tempMax = view.findViewById(R.id.temp_max);
            tempMin= view.findViewById(R.id.temp_min);
            tempCondition= view.findViewById(R.id.temp_condition_name);
            tempImage = view.findViewById(R.id.temp_image);
        }
    }
}
