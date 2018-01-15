package com.chinaitop.linxia.demo.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.AppStore.AppInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yaoju on 2017/12/26.
 */

public class StoreAppsAdapter extends BaseAdapter {
    public AppInfo[] apps;
    public Context mContext;

    public StoreAppsAdapter(AppInfo[] apps, Context mContext) {
        this.apps = apps;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return apps.length;
    }

    @Override
    public AppInfo getItem(int position) {
        return apps[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_two_left, parent, false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        final AppInfo item = getItem(position);
        holder.ivIcon.setImageResource(item.iconRes);
        holder.tvTitle.setText(item.title);
        holder.tvTimes.setText(item.title);
        holder.tvSize.setText(item.size+"MB");
        if (TextUtils.isEmpty(item.time)){
            holder.tvTimes.setText(item.times+"次下载");
        }else{
            holder.tvTimes.setText(item.time);
        }
        holder.btn.setText(item.status);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, item.status, Toast.LENGTH_SHORT).show();
            }
        });
        switch (item.status){
            case AppInfo.DOWNLOAD:
                holder.btn.setEnabled(true);
                break;
            case AppInfo.OPEN:
                holder.btn.setEnabled(true);
                break;
            case AppInfo.YI_DOWNLOAD:
                holder.btn.setEnabled(false);
                break;
            case AppInfo.UPDATE:
                holder.btn.setEnabled(true);
                break;
        }

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_size)
        TextView tvSize;
        @BindView(R.id.tv_times)
        TextView tvTimes;
        @BindView(R.id.btn)
        Button btn;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
