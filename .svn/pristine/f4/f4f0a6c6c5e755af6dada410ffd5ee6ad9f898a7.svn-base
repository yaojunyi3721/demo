package com.chinaitop.linxia.demo.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mq on 2017/9/20 0020.
 * 验证器
 */

public class ValidatorUtils {

    private Context mContext;
    private boolean isShowDialog = false;
    private List<View> viewList = new ArrayList<>();
    private List<String> msgList = new ArrayList<>();
    private List<Boolean> errorList = new ArrayList<>();

    public ValidatorUtils(Context mContext) {
        this.mContext = mContext;
    }

    public boolean validator() {
        errorList.clear();
        //循环验证
        for (int i = 0; i < viewList.size(); i++) {
            View view = viewList.get(i);
            String msg = msgList.get(i);

            boolean isEmpty = isEmpty(view);

            if (isEmpty) {
                setError(view, msg);
            } else {
                setErrorClear(view);
            }

            errorList.add(isEmpty);
        }

        for (int i = 0; i < errorList.size(); i++) {
            Boolean b = errorList.get(i);
            if (b) {
                viewList.get(i).requestFocus();
                showDialog(msgList.get(i));//弹出第一个错误对话框
                return false;
            }
        }
        return true;
    }


    public ValidatorUtils addIsEmptyView(View view, String msg) {
        viewList.add(view);
        msgList.add(msg);
        return this;
    }

    //是否为空
    private boolean isEmpty(View view) {
        if (view instanceof EditText) {
            String content = ((EditText) view).getText().toString().trim();
            return TextUtils.isEmpty(content);
        } else if (view instanceof TextView) {
            String content = ((TextView) view).getText().toString().trim();
            return TextUtils.isEmpty(content);
        }else if (view instanceof AutoCompleteTextView) {
            String content = ((AutoCompleteTextView) view).getText().toString().trim();
            return TextUtils.isEmpty(content);
        }
        return false;
    }

    //设置错误信息
    private void setError(View view, String msg) {
        if (view instanceof EditText) {
            ((EditText) view).setError(msg);
            view.requestFocus();
        } else if (view instanceof TextView) {
            ((TextView) view).setError(msg);
            view.requestFocus();
        }else if (view instanceof AutoCompleteTextView) {
            ((AutoCompleteTextView) view).setError(msg);
            view.requestFocus();
        }
    }

    //清除错误信息
    private void setErrorClear(View view) {
        if (view instanceof EditText) {
            ((EditText) view).setError(null, null);
        } else if (view instanceof TextView) {
            ((TextView) view).setError(null, null);
        }
    }

    private void showDialog(String msg) {
        if (isShowDialog) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setTitle("系统消息");
            builder.setMessage(msg);
            builder.create().show();
        }
    }

    public void setIsShowDialog(boolean showDialog) {
        isShowDialog = showDialog;
    }

}
