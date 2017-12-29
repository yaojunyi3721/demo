package com.chinaitop.linxia.demo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chinaitop.linxia.demo.MenuItem;
import com.chinaitop.linxia.demo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yaoju on 2017/12/25.
 */

public class MenuAdapter extends BaseAdapter {
    private List<MenuItem> menus;
    private Context mContext;

    public MenuAdapter(List<MenuItem> menus, Context mContext) {
        this.menus = menus;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public MenuItem getItem(int position) {
        return menus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_default_new, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvTitle.setText(getItem(position).title);
        holder.defaultItemIcon.setImageResource(getItem(position).drawableRes);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getItem(position).clazz!=null) {
                    Intent intent = new Intent(mContext, getItem(position).clazz);
                    mContext.startActivity(intent);
                }else{
                    Toast.makeText(mContext, getItem(position).title, Toast.LENGTH_SHORT).show();
                }
            }
        });
        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.default_item_icon)
        ImageView defaultItemIcon;
        @BindView(R.id.tv_title)
        TextView tvTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
