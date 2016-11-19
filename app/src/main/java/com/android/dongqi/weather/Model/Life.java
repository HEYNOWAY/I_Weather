package com.android.dongqi.weather.Model;

import java.io.Serializable;

/**
 * 生活相关指数
 * Created by luos on 2016/11/19.
 */

public class Life implements Serializable {
    private String chuanyi; //穿衣
    private String ganmao; //感冒
    private String kongtiao; //空调
    private String xiche; //洗车
    private String yundong; //运动
    private String ziwaixian; //紫外线

    public Life(){}

    public Life(String chuangyi, String ganmao, String kongtiao, String xiche, String yundong,
                String ziwaixian) {
        this.chuanyi = chuangyi;
        this.ganmao = ganmao;
        this.kongtiao = kongtiao;
        this.xiche = xiche;
        this.yundong = yundong;
        this.ziwaixian = ziwaixian;
    }

    public String getChuanyi() {
        return chuanyi;
    }

    public void setChuanyi(String chuanyi) {
        this.chuanyi = chuanyi;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getKongtiao() {
        return kongtiao;
    }

    public void setKongtiao(String kongtiao) {
        this.kongtiao = kongtiao;
    }

    public String getXiche() {
        return xiche;
    }

    public void setXiche(String xiche) {
        this.xiche = xiche;
    }

    public String getYundong() {
        return yundong;
    }

    public void setYundong(String yundong) {
        this.yundong = yundong;
    }

    public String getZiwaixian() {
        return ziwaixian;
    }

    public void setZiwaixian(String ziwaixian) {
        this.ziwaixian = ziwaixian;
    }
}
