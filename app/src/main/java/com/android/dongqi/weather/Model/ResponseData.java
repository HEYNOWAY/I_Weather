package com.android.dongqi.weather.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * 返回的结果数据
 * Created by luos on 2016/11/17.
 */

public class ResponseData implements Serializable{
    private String reason;
    private ResultSet resultSet;
    private int errorCode;

    public ResponseData(String reason, ResultSet resultSet, int errorCode) {
        this.reason = reason;
        this.resultSet = resultSet;
        this.errorCode = errorCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "reason:"+reason+
                "\nresultSet"+resultSet.toString()+
                "\nerrorCode"+errorCode;
    }


}
