package com.example.hblolj.jjcoolweather.gson;

/**
 * Created by hblolj on 2017/1/6.
 * aqi : 空气质量指数
 */

public class AQI {

    public AQICity city;

    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
