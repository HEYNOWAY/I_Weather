package com.android.dongqi.weather.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 温度和湿度
 * Created by luos on 2016/11/17.
 */

public class F3h implements Serializable {
    private ArrayList<Temperature> temperaturesList; //温度的列表
    private ArrayList<Precipitation> precipitationsList; //湿度的列表

    public F3h(ArrayList<Temperature> temperaturesList, ArrayList<Precipitation>
            precipitationsList) {
        this.temperaturesList = temperaturesList;
        this.precipitationsList = precipitationsList;
    }

    public ArrayList<Temperature> getTemperaturesList() {
        return temperaturesList;
    }

    public void setTemperaturesList(ArrayList<Temperature> temperaturesList) {
        this.temperaturesList = temperaturesList;
    }

    public ArrayList<Precipitation> getPrecipitationsList() {
        return precipitationsList;
    }

    public void setPrecipitationsList(ArrayList<Precipitation> precipitationsList) {
        this.precipitationsList = precipitationsList;
    }
}
