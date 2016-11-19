package com.android.dongqi.weather.UI.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.widget.ListView;
import android.widget.TextView;

import com.android.dongqi.weather.Adapter.ListItemAdapter;
import com.android.dongqi.weather.Model.Life;
import com.android.dongqi.weather.Model.Realtime;
import com.android.dongqi.weather.Model.ResponseData;
import com.android.dongqi.weather.Model.Weather;
import com.android.dongqi.weather.R;
import com.android.dongqi.weather.Util.StringUtil;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView cityName;
    private TextView weather;
    private TextView temperature;
    private TextView date;
    private TextView week;
    private TextView ziwaixian;
    private ListView weatherListView;
    private List<Weather> weatherArrayList;
    private ListItemAdapter adapter;
    private Realtime realtime = new Realtime();
    private Life life = new Life();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化界面
        initView();
        //初始化数据
        initDatas();
    }



    private void initView() {
        cityName = (TextView) findViewById(R.id.city_name);
        weather = (TextView) findViewById(R.id.weather);
        temperature = (TextView) findViewById(R.id.temperature);
        date = (TextView) findViewById(R.id.date);
        week = (TextView) findViewById(R.id.week);
        ziwaixian = (TextView) findViewById(R.id.ziwaixian);
        weatherListView = (ListView) findViewById(R.id.weather_list);
    }

    private void initDatas() {
        //获取数据
        Intent intent = getIntent();
        ResponseData responseData = (ResponseData) intent.getSerializableExtra(SearcActivity.EXTRADATE);
        realtime = responseData.getResultSet().getRealtime();
        life = responseData.getResultSet().getLife();
        weatherArrayList = responseData.getResultSet().getWeatherList();
        //因为weatherArrayList里面第一个数据和当前天气重复了，所有去掉第一个数据
        weatherArrayList.remove(0);

        //设置文本
        cityName.setText(realtime.getCityName());
        weather.setText(realtime.getCurrentWeather().getInfo());
        temperature.setText(realtime.getCurrentWeather().getTemperature()+"°");
        date.setText(realtime.getCurrentDate());
        week.setText(formatWeek(realtime.getWeek()));
        ziwaixian.setText(StringUtil.splitStr(life.getZiwaixian(),",",0)+"]");

        //ListView设置适配器
        adapter = new ListItemAdapter(this,weatherArrayList);
        weatherListView.setAdapter(adapter);
        setListViewAnimation();
    }

    /**
     * 设置ListView的渐入动画
     */
    private void setListViewAnimation(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_item);
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setDelay(0.5f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        controller.setInterpolator(new DecelerateInterpolator());
        weatherListView.setLayoutAnimation(controller);
    }

    private String formatWeek(String str) {
        String week = null;
        switch (str){
            case "1":
                week = "星期一";
                break;
            case "2":
                week = "星期二";
                break;
            case "3":
                week = "星期三";
                break;
            case "4":
                week = "星期四";
                break;
            case "5":
                week = "星期五";
                break;
            case "6":
                week = "星期六";
                break;
            case "7":
                week = "星期日";
                break;

        }
        return week;
    }
}
