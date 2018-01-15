package com.chinaitop.linxia.demo.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.chinaitop.linxia.demo.MyApplication;

/**
 * SharedPreferences 辅助类
 * Created by mq on 2017/8/18 0018.
 */

public class SPUtils {

    public static final String name = "share_date";

    /**
     * 添加数据
     */
    public static void add(String key, String value) {

        SharedPreferences sp = getSP();
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value).commit();
    }

    /**
     * 添加数据
     */
    public static void add(String[] keys, String[] values) {
        SharedPreferences sp = getSP();
        SharedPreferences.Editor edit = sp.edit();
        for (int i = 0; i < keys.length; i++) {
            edit.putString(keys[i], values[i]);
        }
        edit.commit();
    }

    /**
     * 添加数据
     */
    public static void add(String key, long value) {

        SharedPreferences sp = getSP();
        SharedPreferences.Editor edit = sp.edit();
        edit.putLong(key, value).commit();
    }

    /**
     * 通过 key 获取数据
     */
    public static String get(String key) {
        SharedPreferences sp = getSP();
        return sp.getString(key, "");
    }

    /**
     * 通过 key 获取数据
     */
    public static long getLong(String key) {
        SharedPreferences sp = getSP();
        return sp.getLong(key, 0);
    }

    /**
     * 清空数据
     */
    public static void clear() {
        SharedPreferences sp = getSP();
        sp.edit().clear().commit();
    }

    //获取私有共享参数
    public static SharedPreferences getSP() {
        return MyApplication.instance.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

}
