package com.example.hblolj.jjcoolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hblolj on 2017/1/6.
 */

public class Weather {
    public String status;

    public Basic basic;

    public AQI aqi;

    public Now now;

    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
