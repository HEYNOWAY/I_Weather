package com.android.dongqi.weather.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 * Json返回的result里面的数据模型
 * 结果集
 * Created by luos on 2016/11/16.
 */

public class ResultSet implements Serializable {
    private Realtime realtime;
    private Life life;
    private ArrayList<Weather> weatherList;
    private F3h f3h;
    private PM25 pm25;

    public ResultSet(){}

    public ResultSet(Realtime realtime, Life life, ArrayList<Weather>
            weatherList, F3h f3h, PM25 pm25) {
        this.realtime = realtime;
        this.life = life;
        this.weatherList = weatherList;
        this.f3h = f3h;
        this.pm25 = pm25;
    }

    public Realtime getRealtime() {
        return realtime;
    }

    public void setRealtime(Realtime realtime) {
        this.realtime = realtime;
    }

    public Life getLife() {
        return life;
    }

    public void setLife(Life life) {
        this.life = life;
    }


    public ArrayList<Weather> getWeatherList() {
        return weatherList;
    }

    public F3h getF3h() {
        return f3h;
    }

    public void setF3h(F3h f3h) {
        this.f3h = f3h;
    }
    public void setWeatherList(ArrayList<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public PM25 getPm25() {
        return pm25;
    }

    public void setPm25(PM25 pm25) {
        this.pm25 = pm25;
    }

}
