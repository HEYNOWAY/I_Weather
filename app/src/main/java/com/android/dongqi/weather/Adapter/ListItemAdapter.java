package com.android.dongqi.weather.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.dongqi.weather.Model.Weather;
import com.android.dongqi.weather.R;
import com.android.dongqi.weather.Util.StringUtil;

import java.util.List;

/**
 * ListView列表适配器
 * Created by luos on 2016/11/16.
 */

public class ListItemAdapter extends BaseAdapter {
    private Viewholder viewholder;
    private Context context;
    private List<Weather> weatherList;

    @Override
    public int getCount() {
        return weatherList.size();
    }

    @Override
    public Object getItem(int position) {
        return weatherList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public ListItemAdapter(Context context,List<Weather> weatherList){
        this.context = context;
        this.weatherList = weatherList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("TAG","getView()");
        //进行判断，若convertView为空才绘制画面，否则直接复用convertView
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate( R.layout.weather_list_item,null);
            //通过viewholder存储各个控件的id，避免重复查找id
            viewholder = new Viewholder();
            viewholder.date = (TextView) convertView.findViewById(R.id.list_item_date);
            viewholder.week = (TextView) convertView.findViewById(R.id.list_item_week);
            viewholder.temperature = (TextView) convertView.findViewById(R.id.list_item_temperature);
            viewholder.weather = (TextView) convertView.findViewById(R.id.list_item_weather);
            convertView.setTag(viewholder);
        } else {
            viewholder = (Viewholder) convertView.getTag();
        }
        Weather weather = weatherList.get(position);
        String[] datestr = StringUtil.splitStr(weather.getDate(),"-");
        String[] daystr = StringUtil.splitStr(weather.getDay(),",");
        viewholder.date.setText(datestr[1]+"月"+datestr[2]+"日");
        viewholder.week.setText("星期"+weather.getWeek());
        viewholder.temperature.setText(daystr[2].substring(1,3)+"°");
        viewholder.weather.setText(daystr[1]);
        return convertView;
    }

    public static class Viewholder{
        TextView date;
        TextView week;
        TextView temperature;
        TextView weather;
    }
}
