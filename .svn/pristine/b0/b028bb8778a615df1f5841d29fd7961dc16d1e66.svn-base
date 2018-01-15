package com.chinaitop.linxia.demo;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

import skin.support.SkinCompatManager;
import skin.support.app.SkinCardViewInflater;
import skin.support.constraint.app.SkinConstraintViewInflater;
import skin.support.design.app.SkinMaterialViewInflater;

/**
 * Created by yaoju on 2017/12/25.
 */

public class MyApplication extends Application {
    public static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        CrashReport.initCrashReport(getApplicationContext(), "41b7931425", false);
        SkinCompatManager.withoutActivity(this)                         // Basic Widget support
                .addInflater(new SkinMaterialViewInflater())            // material design support           [selectable]
                .addInflater(new SkinConstraintViewInflater())          // ConstraintLayout support          [selectable]
                .addInflater(new SkinCardViewInflater())                // CardView v7 support               [selectable]
                .setSkinStatusBarColorEnable(true)                     // Disable statusBarColor skin support，default true   [selectable]
                .setSkinWindowBackgroundEnable(true)                   // Disable windowBackground skin support，default true [selectable]
                .loadSkin();
    }


}
