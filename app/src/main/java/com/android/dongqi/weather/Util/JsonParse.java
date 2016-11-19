package com.android.dongqi.weather.Util;

import android.util.Log;

import com.android.dongqi.weather.Model.CurrentWeather;
import com.android.dongqi.weather.Model.F3h;
import com.android.dongqi.weather.Model.Life;
import com.android.dongqi.weather.Model.PM25;
import com.android.dongqi.weather.Model.Precipitation;
import com.android.dongqi.weather.Model.Realtime;
import com.android.dongqi.weather.Model.ResponseData;
import com.android.dongqi.weather.Model.ResultSet;
import com.android.dongqi.weather.Model.Temperature;
import com.android.dongqi.weather.Model.Weather;
import com.android.dongqi.weather.Model.Wind;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * 用于json解析
 * Created by luos on 2016/11/17.
 */

public class JsonParse {

    public ResponseData parseJson(String datas) throws JSONException {
        JSONObject object = new JSONObject(datas);
        String reason = object.getString("reason");
        int error_code = object.getInt("error_code");

        ResultSet resultSet = null;
        String result= object.getString("result");
        //如果返回的result不为空，再继续解析result里面的内容
        if(StringUtil.isNotEmpty(result)){
            JSONObject datasJson = object.getJSONObject("result").getJSONObject("data");
            JSONObject realtimeJson = datasJson.getJSONObject("realtime");
            JSONObject lifeJson = datasJson.getJSONObject("life");
            JSONArray currentWeatherArray = datasJson.getJSONArray("weather");

            Realtime realtime = parseRealtime(realtimeJson);
            Life life = parseLife(lifeJson);
            ArrayList<Weather> weatherList = parseWeather(currentWeatherArray);
            resultSet = new ResultSet(realtime,life,weatherList,null,null);
        }
        ResponseData responseData = new ResponseData(reason,resultSet,error_code);
        return responseData;

    }

    private Realtime parseRealtime(JSONObject realtimeJson) throws JSONException {
        String city_code = realtimeJson.getString("city_code");
        String cityname = realtimeJson.getString("city_name");
        String date = realtimeJson.getString("date");
        String updatetime = realtimeJson.getString("time");
        String week = realtimeJson.getString("week");
        String moon = realtimeJson.getString("moon");

        JSONObject weather = realtimeJson.getJSONObject("weather");
        int temperature = weather.getInt("temperature");
        int humidity = weather.getInt("humidity");
        String info = weather.getString("info");
        int img = weather.getInt("img");
        CurrentWeather currentWeather = new CurrentWeather(temperature,humidity,info,img);

        JSONObject windJson = realtimeJson.getJSONObject("wind");
        String direct = windJson.getString("direct");
        String power = windJson.getString("power");
        String offset = windJson.getString("offset");
        String windspeed = windJson.getString("windspeed");
        Wind wind = new Wind(direct,power,offset,windspeed);

        Realtime realtime = new Realtime(city_code,cityname,date,updatetime,week,moon,currentWeather,wind);
        return realtime;
    }

    private Life parseLife(JSONObject liefJson) throws JSONException {
        JSONObject infoArry = liefJson.getJSONObject("info");
        String chuanyi = infoArry.getString("chuanyi");
        String ganmao=infoArry.getString("ganmao");
        String kongtiao=infoArry.getString("kongtiao");
        String xiche=infoArry.getString("xiche");
        String yundong=infoArry.getString("yundong");
        String ziwaixian = infoArry.getString("ziwaixian");
        Life life = new Life(chuanyi,ganmao,kongtiao,xiche,yundong,ziwaixian);
        return life;
    }

    private ArrayList<Weather> parseWeather(JSONArray weatherArray) throws JSONException {
        ArrayList<Weather> weatherList = new ArrayList<>();
       for(int i = 0; i < weatherArray.length();i++){

           JSONObject dataJson = weatherArray.getJSONObject(i);
           String date = dataJson.getString("date");
           String week = dataJson.getString("week");
           String nongli = dataJson.getString("nongli");
           JSONObject infoJson = dataJson.getJSONObject("info");
           String dawn = null;
           String day = null;
           String night = null;
           if(i==0){
               day = infoJson.getString("day");
               night = infoJson.getString("night");
           } else {
               dawn = infoJson.getString("dawn");
               day = infoJson.getString("day");
               night = infoJson.getString("night");
           }
           Weather weather = new Weather(date,dawn,day,night,week,nongli);
           weatherList.add(weather);
       }
        return weatherList;
    }

    private F3h parseF3h( JSONObject f3hJson) throws JSONException {
        JSONArray temperature = f3hJson.getJSONArray("temperature");
        JSONArray precipitation = f3hJson.getJSONArray("precipitation");
        ArrayList<Temperature> temperatureList = new ArrayList<>();
        ArrayList<Precipitation> preciptitationList = new ArrayList<>();
        for(int i = 0; i < temperature.length(); i++){
            JSONObject info = temperature.getJSONObject(i);
            String jg = info.getString("jg");
            int jb = info.getInt("jb");
            Temperature tempe = new Temperature(jg,jb);
            temperatureList.add(tempe);
        }
        for(int i = 0; i < precipitation.length(); i++){
            JSONObject info = precipitation.getJSONObject(i);
            String jg = info.getString("jg");
            int jf = info.getInt("jf");
            Precipitation prec = new  Precipitation(jg,jf);
            preciptitationList.add(prec);
        }
        F3h f3h = new F3h(temperatureList,preciptitationList);
        return  f3h;
    }

    private PM25 parsePm25(JSONObject pm25Json) throws JSONException {
        JSONObject json = pm25Json.getJSONObject("pm25");
        int pm25 = json.getInt("pm25");
        int pm10 = json.getInt("pm10");
        int level = json.getInt("level");
        String quality = json.getString("quality");
        String describe = json.getString("describe");
        PM25 myPm25 = new PM25(pm25,pm10,level,quality,describe);
        return myPm25;
    }
}
