package com.chinaitop.linxia.demo.activity.JianGuan.LiangQing;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.ColorRes;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import com.google.gson.Gson;
import com.chinaitop.linxia.demo.utils.LogUtils;

/**
 * Created by mq on 2017/10/17 0017.
 * Fragment基类
 */

public abstract class BaseFragment extends Fragment {

    protected Context mContext;
    private ProgressDialog progressDialog;
    protected Gson gson;
    protected static void startActivity(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
        gson = new Gson();
        LogUtils.i("onAttach:"+this.getClass().getSimpleName());
    }
    public int getColorRes(@ColorRes int id) {
        return ContextCompat.getColor(mContext, id);
    }

    public void showLoading() {
        if (progressDialog == null)
            progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage("加载中...");
        progressDialog.show();
    }

    public void dismissLoading() {
        if (progressDialog != null)
            progressDialog.dismiss();
    }
}
