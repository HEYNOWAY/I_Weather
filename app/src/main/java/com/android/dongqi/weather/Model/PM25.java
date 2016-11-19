package com.android.dongqi.weather.Model;

import java.io.Serializable;

/**
 * Created by luos on 2016/11/16.
 */

public class PM25 implements Serializable {
    private int pm25;
    private int pm10;
    private int level;
    private String quality;
    private String describe;

    public PM25(int pm25, int pm10, int level, String quality, String describe) {
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.level = level;
        this.quality = quality;
        this.describe = describe;
    }

    public int getPm25() {
        return pm25;
    }

    public void setPm25(int pm25) {
        this.pm25 = pm25;
    }

    public int getPm10() {
        return pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
