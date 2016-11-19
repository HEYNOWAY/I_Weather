package com.android.dongqi.weather.Util;

/**
 * Created by luos on 2016/11/16.
 */

public class StringUtil {

    public static boolean isEmpty(String str){
        if(str==null||"".equals(str)){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotEmpty(String str){
        if(str!=null&&!str.equals("null")&&!str.equals("")){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 拆分字符串
     * @param text
     * @param str
     * @return
     */
    public static String[] splitStr(String text,String str){
        return text.split(str);
    }

    /**
     * 拆分字符串后，获取第index个字符
     * @param text
     * @param str
     * @param index
     * @return
     */
    public static String splitStr(String text, String str, int index){
        String afferSplitStr[] = splitStr(text,str);
        return afferSplitStr[index];
    }
}
