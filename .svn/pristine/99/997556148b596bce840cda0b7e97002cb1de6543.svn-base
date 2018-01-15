package com.chinaitop.linxia.demo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * 跳转界面工具类
 * Created by mQ on 2016/9/19.
 */
public class ActivityJump {


    /**
     * 普通跳转
     *
     * @param context
     * @param cls
     */
    public static void startActivity(Context context, Class<?> cls) {
        context.startActivity(new Intent().setClass(context, cls));
    }

    /**
     * 带数据普通跳转
     *
     * @param context
     * @param bundle
     * @param cls
     */
    public static void startActivity(Context context, Class<?> cls ,Bundle bundle) {
        context.startActivity(new Intent().setClass(context, cls).putExtras(bundle));
    }

    /**
     * 带回传的跳转
     *
     * @param context
     * @param cls
     * @param requestCode
     */
    public static void startActivityForResult(Activity context, Class<?> cls, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        context.startActivityForResult(intent, requestCode);
    }

    /**
     * 带数据带回传的跳转
     *
     * @param context
     * @param cls
     * @param bundle
     * @param requestCode
     */
    public static void startActivityForResult(Activity context, Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        intent.putExtras(bundle);
        context.startActivityForResult(intent, requestCode);
    }



}
