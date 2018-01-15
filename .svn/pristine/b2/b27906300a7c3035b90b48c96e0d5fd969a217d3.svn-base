package com.chinaitop.linxia.demo.activity.JianGuan.LiangQing;

import android.support.annotation.Nullable;
import android.view.View;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chinaitop.linxia.demo.R;

import java.util.List;

public class XunzhengAdapter extends BaseQuickAdapter<FumigationBean.ListBean, BaseViewHolder> {

    public XunzhengAdapter(@Nullable List<FumigationBean.ListBean> data) {
        super(R.layout.work_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FumigationBean.ListBean item) {
        helper.setText(R.id.tv_1,item.getCreateDepot());//库点名称
        helper.setText(R.id.tv_2,item.getHouseId());//仓房名称
        helper.setText(R.id.tv_3,item.getGrainKind());//品种
        helper.setText(R.id.tv_4,"熏蒸");//作业类型
        helper.setText(R.id.tv_5,item.getFumigationChargePerson());//负责人
        helper.setText(R.id.tv_6,item.getTaskStartTime());//开始时间
        helper.setText(R.id.tv_7,item.getTaskEndTime());//结束时间

        if (helper.getLayoutPosition() == getData().size()-1)
            helper.getView(R.id.line).setVisibility(View.GONE);
        else
            helper.getView(R.id.line).setVisibility(View.VISIBLE);


    }
}
