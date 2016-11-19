package com.android.dongqi.weather.Model;

import java.io.Serializable;

/**
 * 当前的时间
 * Created by luos on 2016/11/16.
 */

public class Realtime implements Serializable {
    private String cityCode; //城市码
    private String cityName; //城市名称
    private String currentDate; //当前日期
    private String updateTime; //更新时间
    private String week; //星期
    private String moon; //农历
    private CurrentWeather currentWeather; //当前天气
    private Wind wind; //风力

    public Realtime(){}

    public Realtime(String cityCode, String cityName, String currentDate, String updateTime, String
            week, String moon, CurrentWeather currentWeather, Wind wind) {
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.currentDate = currentDate;
        this.updateTime = updateTime;
        this.week =week;
        this.moon = moon;
        this.currentWeather = currentWeather;
        this.wind = wind;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getMoon() {
        return moon;
    }

    public void setMoon(String moon) {
        this.moon = moon;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
