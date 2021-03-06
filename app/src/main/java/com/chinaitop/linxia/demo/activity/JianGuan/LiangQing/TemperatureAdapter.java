package com.chinaitop.linxia.demo.activity.JianGuan.LiangQing;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chinaitop.linxia.demo.R;

import java.util.List;

/**
 * Created by mq on 2017/10/23 0023.
 * 计划适配器
 */

public class TemperatureAdapter extends BaseQuickAdapter<FoodCardBean, BaseViewHolder> {

    public TemperatureAdapter(@Nullable List<FoodCardBean> data) {
        super(R.layout.temperature_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FoodCardBean item) {
        String barnName = item.getHouseId() + "";
        helper.setText(R.id.tv_2, barnName);//仓房名称
        String waresName = item.getWarehouseId() + "";
        helper.setText(R.id.tv_hwh, waresName);//货位号
        String foodType = item.getSubType();
        helper.setText(R.id.tv_3, foodType);//品种
        helper.setText(R.id.tv_xz, item.getQuality());//粮食性质
        helper.setText(R.id.tv_sl, item.getNumber() + "");//实际数量
        helper.setText(R.id.tv_tkdw,item.getRecordUnite());//填卡单位
//        helper.setText(R.id.tv_zyzt,"");//作业状态
    }
}
