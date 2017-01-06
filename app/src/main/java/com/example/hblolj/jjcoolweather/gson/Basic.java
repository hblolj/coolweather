package com.example.hblolj.jjcoolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hblolj on 2017/1/6.
 */

public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{

        @SerializedName("loc")
        public String updateTime;
    }
}
