package com.example.hblolj.jjcoolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hblolj on 2017/1/6.
 * forecast : 预报预测
 */

public class Forecast {
    public String date;

    @SerializedName("cond")
    public More more;

    public Temperature tmp;

    public class Temperature{
        public String max;
        public String min;
    }

    public class More{
        @SerializedName("txt_d")
        public String info;
    }
}
