package com.chinaitop.linxia.demo.activity.AnQuan.LuJing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.chinaitop.linxia.demo.BaseModel;
import com.chinaitop.linxia.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yaoju on 2017/12/29.
 */

public class LujingItemAdapter extends BaseAdapter {
    LujingItem[] data;
    Context context;

    public LujingItemAdapter(LujingItem[] data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public LujingItem getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TitleHolder titleHolder = null;
        ItemHolder itemHolder = null;
        LujingItem item = getItem(position);
        if (convertView == null) {
            if (item.modelType.equals(BaseModel.TYPE_TITLE)) {
                convertView = LayoutInflater.from(context).inflate(R.layout.title_9, parent, false);
                titleHolder = new TitleHolder(convertView);
                convertView.setTag(titleHolder);
            } else {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_9, parent, false);
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
            if (item.type.equals(LujingItem.TYPE_RUKU)){
                titleHolder.tv1.setText("序号");
                titleHolder.tv2.setText("品种");
                titleHolder.tv3.setText("等级");
                titleHolder.tv4.setText("质量");
                titleHolder.tv5.setText("仓号");
                titleHolder.tv6.setText("货位号");
                titleHolder.tv7.setText("粮食性质");
                titleHolder.tv8.setText("产地");
                titleHolder.tv9.setText("入库时间");
            }else{
                titleHolder.tv1.setText("序号");
                titleHolder.tv2.setText("品种");
                titleHolder.tv3.setText("等级");
                titleHolder.tv4.setText("质量");
                titleHolder.tv5.setText("仓号");
                titleHolder.tv6.setText("货位号");
                titleHolder.tv7.setText("客户名称");
                titleHolder.tv8.setText("流向路径");
                titleHolder.tv9.setText("出库时间");
            }
        } else {
            itemHolder.tv1.setText(position+"");
            itemHolder.tv2.setText(item.pinzhong);
            itemHolder.tv3.setText(item.dengji);
            itemHolder.tv4.setText(item.zhiliang);
            itemHolder.tv5.setText(item.canghao);
            itemHolder.tv6.setText(item.huoweihao);
            itemHolder.tv7.setText(item.liangshixingzhi);
            itemHolder.tv8.setText(item.chandi);
            itemHolder.tv9.setText(item.date);
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
        @BindView(R.id.tv_8)
        TextView tv8;
        @BindView(R.id.tv_9)
        TextView tv9;

        TitleHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ItemHolder {
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
        @BindView(R.id.tv_8)
        TextView tv8;
        @BindView(R.id.tv_9)
        TextView tv9;

        ItemHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
