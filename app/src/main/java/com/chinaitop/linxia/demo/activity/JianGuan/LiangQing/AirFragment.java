package com.chinaitop.linxia.demo.activity.JianGuan.LiangQing;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.chinaitop.linxia.demo.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
public class AirFragment extends BaseFragment{


    @BindView(R.id.listTitleLayout)
    FrameLayout listTitleLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;

    private AirAdapter mAdapter;

    private String headers[];
    private String depotId;
    private String houseId;


    public AirFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        String data="[{\"aerationTarget\":\"5233\",\"bearingUnit\":\"北京啊诺安\",\"depositoryUnit\":\"河北省直属库\",\"endAerationTime\":\"1512980764000\",\"goodsKinds\":\"2777\",\"goodsNum\":\"1000.00\",\"houseId\":\"2\",\"houseSize\":\"250.00\",\"houseType\":\"2971\",\"id\":\"27\",\"ladeLineHeight\":\"1.00\",\"orgId\":\"1\",\"startAerationTime\":\"1512894360000\",\"stopAerationTime\":\"0.00\",\"sumAerationTime\":\"24.00\",\"taskCode\":\"TF-TASK_20171211150319\",\"taskStatus\":\"5\"}]";
        Type type = new TypeToken<List<AirBean.ListBean>>() {
        }.getType();
        List<AirBean.ListBean> list= new Gson().fromJson(data, type);
        handleData(list);
        mAdapter.replaceData(list);
        return view;
    }

    private void initView() {
        //添加列表头
        listTitleLayout.addView(LayoutInflater.from(mContext).inflate(R.layout.work_title_layout, null));

        mAdapter = new AirAdapter(null);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));


    }

    void handleData(List<AirBean.ListBean> data){
        for (AirBean.ListBean bean : data) {
            bean.setHouseId(bean.getHouseId());
            bean.setDepotName("河北省粮食仓库");
            bean.setAerationTarget(bean.getAerationTarget());
            String start = DateUtils.formatDateTime(bean.getStartAerationTime());
            String end = DateUtils.formatDateTime(bean.getEndAerationTime());
            bean.setStartAerationTime(start);
            bean.setEndAerationTime(end);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
