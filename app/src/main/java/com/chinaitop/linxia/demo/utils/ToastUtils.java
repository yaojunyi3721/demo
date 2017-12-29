package com.chinaitop.linxia.demo.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * 吐司工具类
 * Created by hupai on 2016/9/3.
 */
public class ToastUtils {

    private static Context context;

    private ToastUtils() {
    }

    public static final ToastUtils get() {
        return Holder.INSTANCE;
    }

    public static void showShort(CharSequence text) {
        if (context != null)
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(@StringRes int id) {
        if (context != null)
            Toast.makeText(context, id, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(CharSequence text) {
        if (context != null)
            Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    public static void showLong(@StringRes int id) {
        if (context != null)
            Toast.makeText(context, id, Toast.LENGTH_LONG).show();
    }

    public void init(Context context) {
        ToastUtils.context = context;
    }

    private static class Holder {
        private static final ToastUtils INSTANCE = new ToastUtils();
    }


    private static Toast toast;

    public static void showShort(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context,
                    content,
                    Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }

}
