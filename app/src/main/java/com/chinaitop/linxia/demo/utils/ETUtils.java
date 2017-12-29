package com.chinaitop.linxia.demo.utils;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * EditText工具类
 * Created by mq on 2017/9/11 0011.
 */

public class ETUtils {

    public interface OnRightListener {
        void onRight(EditText et, MotionEvent event);
    }

    //EditText右侧图片点击事件
    public static void setOnRightClickListiner(final EditText et, final OnRightListener rightListener) {
        if (et != null) {
            et.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // et.getCompoundDrawables()得到一个长度为4的数组，分别表示左右上下四张图片
                    Drawable drawable = et.getCompoundDrawables()[2];
                    //如果右边没有图片，不再处理
                    if (drawable == null)
                        return false;
                    //如果不是按下事件，不再处理
                    if (event.getAction() != MotionEvent.ACTION_UP)
                        return false;
                    //点击了右侧
                    if (event.getX() > et.getWidth()
                            - et.getPaddingRight()
                            - drawable.getIntrinsicWidth()) {
                        if (rightListener != null) {
                            rightListener.onRight(et, event);
                        }else {
//                            et.setText("");
                        }
                    }
                    return false;
                }
            });
        }
    }

    //获取输入内容
    public static String getInputData(EditText et) {
        if (et != null) {
            return et.getText().toString().trim();
        }
        return "";
    }

    //文字控件赋值
    public static void setInputData(View view, String data) {
        if (view != null) {

            if (view instanceof EditText) {
                EditText et = (EditText) view;
                et.setText(data);
            } else if (view instanceof TextView) {
                TextView et = (TextView) view;
                et.setText(data);
            }

        }
    }


}
