package com.chinaitop.linxia.demo.activity;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.chinaitop.linxia.demo.utils.KeyBoardUtils;
import com.chinaitop.linxia.demo.utils.LogUtils;

/*
Activity公共基类
封装ActionBar的常用方法
提供ProgressDialog
 */
public class BaseActivity extends AppCompatActivity {
    protected ProgressDialog sPd;
    private static final String TAG="BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);

        sPd = new ProgressDialog(this);
        sPd.setCanceledOnTouchOutside(false);
        KeyBoardUtils.closeKeybord(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    protected static void startActivity(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        setTitle(title, true);
    }

    protected void setTitle(CharSequence title, boolean displayHomeAsUp) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(displayHomeAsUp);
            getSupportActionBar().setDisplayShowHomeEnabled(displayHomeAsUp);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.i(TAG,getClass().getName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        KeyBoardUtils.closeKeybord(this);
    }

    public void showPd() {
        if (sPd == null) {
            return;
        }
        if (sPd.isShowing()) {
            return;
        }
        sPd.setMessage("请稍候...");
        sPd.show();
    }

    public void cancelPd() {
        if (sPd == null) {
            return;
        }
        sPd.cancel();
    }


}
