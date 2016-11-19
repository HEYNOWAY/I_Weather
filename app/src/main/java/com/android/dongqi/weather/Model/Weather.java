package com.android.dongqi.weather.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by luos on 2016/11/16.
 */

public class Weather implements Serializable {
    private String date; //日期
    private String dawn; //黎明
    private String day; //白天
    private String night; //晚上
    private String week; //星期
    private String nongli; //农历

    public Weather(String date, String dawn, String day, String night, String week, String nongli) {
        this.date = date;
        this.dawn = dawn;
        this.day = day;
        this.night = night;
        this.week = week;
        this.nongli = nongli;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDawn() {
        return dawn;
    }

    public void setDawn(String dawn) {
        this.dawn = dawn;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getNongli() {
        return nongli;
    }

    public void setNongli(String nongli) {
        this.nongli = nongli;
    }
}
