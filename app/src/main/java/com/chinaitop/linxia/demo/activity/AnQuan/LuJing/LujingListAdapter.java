package com.chinaitop.linxia.demo.activity.AnQuan.LuJing;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chinaitop.linxia.demo.BaseModel;
import com.chinaitop.linxia.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yaoju on 2017/12/29.
 */

public class LujingListAdapter extends BaseAdapter {
    private LujingList[] data;
    private Context context;

    public LujingListAdapter(LujingList[] data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public LujingList getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemHolder itemHolder = null;
        TitleHolder titleHolder = null;
        final LujingList item = getItem(position);
        if (convertView == null) {
            if (item.modelType.equals(BaseModel.TYPE_TITLE)) {
                convertView = LayoutInflater.from(context).inflate(R.layout.work_title_layout, parent, false);
                titleHolder = new TitleHolder(convertView);
                convertView.setTag(titleHolder);
            } else {
                convertView = LayoutInflater.from(context).inflate(R.layout.lujing_item_layout, parent, false);
                itemHolder = new ItemHolder(convertView);
                convertView.setTag(itemHolder);
            }
        } else {
            if (item.modelType.equals(BaseModel.TYPE_TITLE)) {
                titleHolder = (TitleHolder) convertView.getTag();
            } else {
                itemHolder = (ItemHolder) convertView.getTag();
            }
        }
        if (item.modelType.equals(BaseModel.TYPE_TITLE)) {
            titleHolder.tv1.setText("序号");
            titleHolder.tv2.setText("库存识别码");
            titleHolder.tv3.setText("性质");
            titleHolder.tv4.setText("品种");
            titleHolder.tv5.setText("等级");
            titleHolder.tv6.setText("操作");
            titleHolder.tv7.setVisibility(View.GONE);
        } else {
            itemHolder.tv1.setText(position + "");
            itemHolder.tv2.setImageResource(item.erweimaRes);
            itemHolder.tv3.setText(item.xingzhi);
            itemHolder.tv4.setText(item.pinzhong);
            itemHolder.tv5.setText(item.dengji);
            itemHolder.tv6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, LujingItemActivity.class);
                    intent.putExtra("parentId", item.id);
                    context.startActivity(intent);
                }
            });
            itemHolder.tv7.setVisibility(View.GONE);
        }
        return convertView;
    }


    static class TitleHolder {
        @BindView(R.id.tv_1)
        TextView tv1;
        @BindView(R.id.tv_2)
        TextView tv2;
        @BindView(R.id.tv_3)
        TextView tv3;
        @BindView(R.id.tv_4)
        TextView tv4;
        @BindView(R.id.tv_5)
        TextView tv5;
        @BindView(R.id.tv_6)
        TextView tv6;
        @BindView(R.id.tv_7)
        TextView tv7;

        TitleHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ItemHolder {
        @BindView(R.id.tv_1)
        TextView tv1;
        @BindView(R.id.tv_2)
        ImageView tv2;
        @BindView(R.id.tv_3)
        TextView tv3;
        @BindView(R.id.tv_4)
        TextView tv4;
        @BindView(R.id.tv_5)
        TextView tv5;
        @BindView(R.id.tv_6)
        Button tv6;
        @BindView(R.id.tv_7)
        TextView tv7;

        ItemHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
