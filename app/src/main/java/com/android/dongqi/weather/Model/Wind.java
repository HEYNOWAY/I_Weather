package com.android.dongqi.weather.Model;

import java.io.Serializable;

/**
 * Created by luos on 2016/11/16.
 */

public class Wind implements Serializable {
    private String direct; //风向
    private String power; //风力
    private String offset;
    private String windspeed;

    public Wind(String direct,String power,String offset,String windspeed){
        this.direct = direct;
        this.power = power;
        this.offset = offset;
        this.windspeed = windspeed;
    }
    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
    }
}
