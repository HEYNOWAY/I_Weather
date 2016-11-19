package com.android.dongqi.weather.UI.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.dongqi.weather.Model.ResponseData;
import com.android.dongqi.weather.R;
import com.android.dongqi.weather.Util.Constants;
import com.android.dongqi.weather.Util.HttpUtil;
import com.android.dongqi.weather.Util.JsonParse;

import org.json.JSONException;
import java.io.IOException;

public class SearcActivity extends AppCompatActivity {
    public static final String EXTRADATE = "datas";
    private EditText cityEdt;
    private Button searchBtn;
    private ImageView delete;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }

    private void initView() {
        cityEdt = (EditText) findViewById(R.id.city_edt);
        searchBtn = (Button) findViewById(R.id.search_btn);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        delete = (ImageView) findViewById(R.id.search__delete);

        //监听搜索按钮点击事件
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入框里面的数据
                String cityname = cityEdt.getText().toString();
                setProgressBar(View.VISIBLE);
                //发起异步网络请求
                new HttpTask().execute(cityname);
            }
        });
    }


    /**
     * 异步线程
     * 进行网络请求
     */
    private class HttpTask extends AsyncTask<String,Integer,String> {


        @Override
        protected String doInBackground(String... params) {
            try {
                return HttpUtil.doGet(Constants.baseUrl,params[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

        }

        @Override
        protected void onPostExecute(String result) {
            JsonParse parse = new JsonParse();
            Log.d("SearchActivity",result);
            try {
                //对Json进行解析
                ResponseData responseData = parse.parseJson(result);
                //根据错误码来判断是否请求数据成功
                switch (responseData.getErrorCode()){
                    case 0:
                        //启动下一个Activity，并把 ResponseData对象传送过去
                        Intent intent = new Intent(SearcActivity.this, MainActivity.class);
                        intent.putExtra(EXTRADATE,responseData);
                        startActivity(intent);
                        setProgressBar(View.INVISIBLE);
                        cityEdt.setText("");
                        break;
                    case 207301:
                        builderDialo("查询错误",responseData.getReason());
                        setProgressBar(View.INVISIBLE);
                        break;
                    case 207302:
                        builderDialo("查询错误",responseData.getReason());
                        setProgressBar(View.INVISIBLE);
                        break;
                    case 207303:
                        builderDialo("网络错误",responseData.getReason());
                        setProgressBar(View.INVISIBLE);
                        break;

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 创建一个对话框
     * @param title
     * @param message
     */
    private void builderDialo(String title, String message){
        AlertDialog dialog = new AlertDialog.Builder(SearcActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
       dialog.show();
    }

    /**
     * 设置progressbar可见性
     * @param isVisiable
     */
    private void setProgressBar(int isVisiable){
        progressBar.setVisibility(isVisiable);
    }

}
