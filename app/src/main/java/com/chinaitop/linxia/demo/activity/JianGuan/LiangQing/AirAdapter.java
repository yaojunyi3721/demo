package com.chinaitop.linxia.demo.activity.JianGuan.LiangQing;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chinaitop.linxia.demo.R;

import java.util.List;

/**
 * Created by yaoju on 2017/11/1.
 */

public class AirAdapter extends BaseQuickAdapter<AirBean.ListBean, BaseViewHolder> {

    public AirAdapter(@Nullable List<AirBean.ListBean> data) {
        super(R.layout.work_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AirBean.ListBean item) {
        helper.setText(R.id.tv_1,item.getDepotName());//库点名称
        helper.setText(R.id.tv_2,item.getHouseId());//仓房名称
        helper.setText(R.id.tv_3,item.getGoodsKinds());//品种
        helper.setText(R.id.tv_4,"通风");//作业类型
        helper.setText(R.id.tv_5,item.getPersonLiable());//负责人
        helper.setText(R.id.tv_6,item.getStartAerationTime());//开始日期
        helper.setText(R.id.tv_7,item.getEndAerationTime());//结束日期

        if (helper.getLayoutPosition() == getData().size()-1)
            helper.getView(R.id.line).setVisibility(View.GONE);
        else
            helper.getView(R.id.line).setVisibility(View.VISIBLE);

    }
}