package com.hg.person.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 字符串转util日期
 * util日期转字符串
 * util转sql.date
 */
public class DateUtils {
    private  static final SimpleDateFormat SIMPLE_DATE_FORMAT=new SimpleDateFormat("yyyy-MM-dd");
    public  static  java.util.Date strToUtil(String str){
        try {
            return SIMPLE_DATE_FORMAT.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public static  java.sql.Date utilToSql(java.util.Date date){
        return new java.sql.Date(date.getTime());//拿到毫秒值就可以转换。
    }
    public static String utilToStr(java.util.Date date){
        return SIMPLE_DATE_FORMAT.format(date);
    }

}
