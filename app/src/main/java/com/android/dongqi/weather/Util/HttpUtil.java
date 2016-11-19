package com.android.dongqi.weather.Util;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 网络请求
 * Created by luos on 2016/11/16.
 */

public class HttpUtil {
    public static final String CHARSET = "UTF-8";
    private static final String TAG = "HttpUtil";

    public static String doGet(String address) throws IOException {

        URL url = new URL(address);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        try {
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection
                        .getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }

                reader.close();
                Log.d(TAG, response.toString());
                return response.toString();
            } else {
                throw new IOException("Network Error - response code: " + connection
                        .getResponseCode());
            }
        } finally {
            connection.disconnect();
        }
    }

    public static String doGet(String baseUrl, String cityname) throws IOException {
        Log.d(TAG, baseUrl + "?" + Constants.firstKey + "=" + cityname + "&" + Constants
                .secondKey + "=" + Constants.appKey);
        return doGet(baseUrl + "?" + Constants.firstKey + "=" + cityname + "&" + Constants
                .secondKey + "=" + Constants.appKey);

    }

    public static String doGet(String baseUrl, String key, String value) throws IOException {
            return doGet(baseUrl + "?" + encodeString(key) + "=" + encodeString(value));
    }

    private static String encodeString(String str) {
        try {
            return URLEncoder.encode(str, CHARSET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
