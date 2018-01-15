package com.chinaitop.linxia.demo.utils;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * 系统提示
 * Created by by on 2017/4/14.
 */

public class DateTimeDialog {

    private Activity mContext;
    private Dialog dateDialog;
    private Dialog timeDialog;
    private String date, time;
    private DateTimeCallback dateTimeCallback;
    private DateCallback dateCallback;
    private TimeCallback timeCallback;

    public DateTimeDialog(Activity mContext) {
        this.mContext = mContext;
        initDialog();
    }

    //显示
    public void showDialog() {
        if (dateTimeCallback != null || dateCallback != null)
            dateDialog.show();
        else if (timeCallback != null)
            timeDialog.show();
    }

    //隐藏
    public void closeDialog() {
        dateDialog.dismiss();
    }

    //初始化对话框
    private void initDialog() {

        Calendar calendar = Calendar.getInstance();
        //时间对话框
        final TimePickerDialog.OnTimeSetListener timeListener =
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timerPicker,
                                          int hourOfDay, int minute) {
                        String sHour = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
                        String sMinutes = minute < 10 ? "0" + minute : ""
                                + minute;
                        time = sHour + ":" + sMinutes + ":" + "00";
                        if (timeCallback != null) {
                            timeCallback.onTimeClickListener(time);
                        } else if (dateTimeCallback != null) {
                            dateTimeCallback.onDateTimeClickListener(date, time);
                        }
                    }
                };
        //是否为二十四制
        timeDialog = new TimePickerDialog(mContext, timeListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                false);

        //日期对话框
        DatePickerDialog.OnDateSetListener dateListener =
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker,
                                          int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String sMonth = month < 10 ? "0" + month : month + "";
                        String sDay = dayOfMonth < 10 ? "0" + dayOfMonth : dayOfMonth + "";
                        date = year + "-" + sMonth + "-" + sDay;
                        if (dateCallback != null) {
                            dateCallback.onDateClickListener(date);
                        } else if (dateTimeCallback != null) {
                            timeDialog.show();//弹出时间对话框
                        }
                    }
                };
        dateDialog = new DatePickerDialog(mContext,
                dateListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));

    }

    public DateTimeDialog setDateTimeCallback(DateTimeCallback dateTimeCallback) {
        this.dateTimeCallback = dateTimeCallback;
        return this;
    }

    public DateTimeDialog setDateCallback(DateCallback dateCallback) {
        this.dateCallback = dateCallback;
        return this;
    }

    public DateTimeDialog setTimeCallback(TimeCallback timeCallback) {
        this.timeCallback = timeCallback;
        return this;
    }

    public interface DateTimeCallback {
        void onDateTimeClickListener(String date, String time);
    }

    public interface DateCallback {
        void onDateClickListener(String date);
    }

    public interface TimeCallback {
        void onTimeClickListener(String time);
    }

}
