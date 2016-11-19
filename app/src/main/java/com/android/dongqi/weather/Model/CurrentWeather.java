package com.android.dongqi.weather.Model;

import java.io.Serializable;

/**
 * 当前的天气状况
 * Created by luos on 2016/11/16.
 */

public class CurrentWeather implements Serializable {
    private int temperature; //温度
    private int humidity; //湿度
    private String info; //天气类型，比如雾
    private int img; //天气对应图片id

    public CurrentWeather(int temperature,int humidity,String info,int img){
        this.temperature =temperature;
        this.humidity = humidity;
        this.info = info;
        this.img = img;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
