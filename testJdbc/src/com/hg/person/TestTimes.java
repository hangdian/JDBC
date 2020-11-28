package com.hg.person;

import java.text.SimpleDateFormat;

public class TestTimes {
    public static void main(String[] args) throws Exception {
       System.out.println(new java.util.Date());//系统当前日期
       String str="2020-11-11";
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       java.util.Date date=sdf.parse(str);//字符串转为util日期
       System.out.println(date);//Wed Nov 11 00:00:00 CST 2020
       String dates=sdf.format(date);//util日期转为字符串
       System.out.println(dates);//2020-11-11
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        System.out.println(sqlDate);//2020-11-11
    }
}
