package com.chinaitop.linxia.demo.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

import java.util.List;

/**
 * 获取App版本号
 * Created by mq on 2017/9/8 0008.
 */

public class VersionUtils {

    //获取应用程序名称
    public static String getAppName(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            //这种方式是可以的
            //String name = applicationInfo.loadLabel(pm).toString();
            int labelRes = applicationInfo.labelRes;
            String name = context.getResources().getString(labelRes);
            return name;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    //版本名
    public static String getVersionName(Context context) {
        PackageInfo pi = getPackageInfo(context);
        if (pi != null)
            return pi.versionName;
        else
            return "";
    }

    //版本号
    public static int getVersionCode(Context context) {
        PackageInfo pi = getPackageInfo(context);
        if (pi != null)
            return pi.versionCode;
        else
            return 0;
    }

    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;

        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);

            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pi;
    }

    /**
     * 程序是否在前台运行
     */
    public static boolean isAppOnForeground(Context context) {
        ActivityManager activityManager
                = (ActivityManager) context.getSystemService(
                Context.ACTIVITY_SERVICE);
        String packageName = context.getPackageName();

        List<ActivityManager.RunningAppProcessInfo> appProcesses
                = activityManager.getRunningAppProcesses();
        if (appProcesses == null) return false;

        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(packageName) &&
                    appProcess.importance ==
                            ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }

        return false;
    }

    public static boolean isRealDevice(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = telephonyManager.getDeviceId();
        // 如果 运行的 是一个 模拟器
        return !(deviceId == null || deviceId.trim().length() == 0
                || deviceId.matches("0+"));
    }

}
