package com.example.hblolj.jjcoolweather.util;

import android.text.TextUtils;

import com.example.hblolj.jjcoolweather.db.City;
import com.example.hblolj.jjcoolweather.db.County;
import com.example.hblolj.jjcoolweather.db.Province;
import com.example.hblolj.jjcoolweather.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hblolj on 2017/1/5.
 */

public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     * @param response
     * @return
     */
    public static boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvince = new JSONArray(response);
                for (int i=0; i<allProvince.length(); i++){
                    JSONObject provinceObeject = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObeject.getString("name"));
                    province.setProvinceCode(provinceObeject.getString("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     * @param response
     * @param provinceId
     * @return
     */
    public static boolean handleCityResponse(String response, int provinceId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCity = new JSONArray(response);
                for (int i=0; i<allCity.length(); i++){
                    JSONObject cityObeject = allCity.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObeject.getString("name"));
                    city.setCityCode(cityObeject.getString("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     * @param response
     * @param cityId
     * @return
     */
    public static boolean handleCountyResponse(String response, int cityId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounty = new JSONArray(response);
                for (int i=0; i<allCounty.length(); i++){
                    JSONObject countyObeject = allCounty.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObeject.getString("name"));
                    county.setWeatherId(countyObeject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 将返回的json数据解析成Weather实体
     * @param response
     * @return
     */
    public static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
