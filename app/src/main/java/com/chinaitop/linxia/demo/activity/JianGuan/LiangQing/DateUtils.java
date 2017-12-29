package com.chinaitop.linxia.demo.activity.JianGuan.LiangQing;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yaoju on 2017/4/11.
 */

public class DateUtils {


    public static String formatDateTime(Date date, String formatter) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatter);
        return sdf.format(date);
    }

    public static String formatDateTime(Date date) {
        String formatter = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(formatter);
        return sdf.format(date);
    }

    public static String formatDateTime(String timeInMillis) {
        try {
            Long time = Long.valueOf(timeInMillis);
            Date date = new Date(time);
            return formatDateTime(date);
        } catch (Exception e) {
            return "";
        }
    }

    public static String formatDate(Date date, String formatter) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatter);
        return sdf.format(date);
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        String formatter = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(formatter);
        return sdf.format(date);
    }
    public static String formatDate(String timeInMillis) {
        try {
            Long time = Long.valueOf(timeInMillis);
            Date date = new Date(time);
            return formatDate(date);
        } catch (Exception e) {
            return "";
        }
    }
    public static String addDays(String dateStr, int days) {
        return addDays(dateStr, null, days);
    }

    public static String addDays(String dateStr, String formatter, int days) {
        if (TextUtils.isEmpty(dateStr)) {
            return "";
        }
        if (TextUtils.isEmpty(formatter)) {
            formatter = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatter);
        try {
            Date date = sdf.parse(dateStr);
            return addDays(date, formatter, days);
        } catch (Exception ex) {
            return "";
        }

    }

    public static String addDays(Date date, String formatter, int days) {
        if (TextUtils.isEmpty(formatter)) {
            return addDays(date, days);
        } else {
            return formatDate(addDaysToDate(date, days), formatter);
        }
    }

    public static String addDays(Date date, int days) {
        return formatDate(addDaysToDate(date, days));
    }

    public static Date addDaysToDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    //录入生日 获取年龄
    public static String getAge(long birthday) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String b = format.format(new Date(birthday));
        String b2 = format.format(Calendar.getInstance().getTime());
        try {
            int age = Integer.valueOf(b2) - Integer.valueOf(b);
            if (age == 0)
                return "1";
            else
                return age + "";
        } catch (Exception e) {
        }
        return "";
    }
}
