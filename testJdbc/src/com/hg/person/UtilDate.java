package com.hg.person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateUtils的封装
 */
public class UtilDate {
   private  static  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    //字符产转util.Date
    public static java.util.Date strToUtil(String str){

        try {
            java.util.Date date= sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  null;
    }
    //util转为sql
    public static  java.sql.Date utilToSql(java.util.Date date){
        return new java.sql.Date(date.getTime());
    }
    //util转字符串
    public static String utilToString(java.util.Date date){

        return sdf.format(date);
    }
}
