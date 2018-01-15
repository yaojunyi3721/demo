package com.chinaitop.linxia.demo.activity.JianGuan.LiangQing;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.chinaitop.linxia.demo.R;
import com.github.mikephil.charting.charts.LineChart;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class TemperatureFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.lineChart)
    LineChart lineChart;
    @BindView(R.id.listTitleLayout)
    FrameLayout listTitleLayout;

    Unbinder unbinder;
    private TemperatureAdapter mAdapter;
    private ThreeChartTwo chart;

    public TemperatureFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temperature, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        getData("", "", "7");
        return view;
    }

    List<ThreeChartBean> cnwdList = new ArrayList<>();
    List<ThreeChartBean> lswdList = new ArrayList<>();
    List<ThreeChartBean> cwwdList = new ArrayList<>();

    private void initView() {
        //添加列表头
        listTitleLayout.addView(LayoutInflater.from(mContext).inflate(R.layout.temperature_title_layout, null));

        mAdapter = new TemperatureAdapter(new ArrayList<FoodCardBean>());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        chart = new ThreeChartTwo(lineChart);
    }

    void getData(String orgId, String barnNumber, String dayCount) {
        //三温图请求
        handleThreeTempData("[{\"lswd\":21.5,\"cnwd\":26.4,\"days\":\"2017-12-28\",\"cwwd\":33.4},{\"lswd\":19.5,\"cnwd\":24.5,\"days\":\"2017-12-27\",\"cwwd\":33.1},{\"lswd\":19.0,\"cnwd\":26.3,\"days\":\"2017-12-26\",\"cwwd\":30.4},{\"lswd\":20.1,\"cnwd\":25.4,\"days\":\"2017-12-25\",\"cwwd\":32.4},{\"lswd\":21.2,\"cnwd\":20.4,\"days\":\"2017-12-24\",\"cwwd\":21.5},{\"lswd\":20.4,\"cnwd\":22.1,\"days\":\"2017-12-23\",\"cwwd\":25.4},{\"lswd\":22.4,\"cnwd\":22.4,\"days\":\"2017-12-22\",\"cwwd\":22.9}]");
        //下面的只有一条数据的列表
        newListData("[{\"id\":64,\"houseId\":3,\"warehouseId\":4,\"recordUnite\":\"地方储备粮\",\"keepUnite\":\"河北省粮食仓库\",\"locationNum\":\"01\",\"quality\":\"3047\",\"subType\":3164,\"htype\":\"0\",\"number\":7860.0,\"standNumber\":7.86,\"inputYear\":1511222400000,\"growYear\":3290,\"keepMethod\":\"密封\",\"level\":\"11\",\"weight\":\"800\",\"impurity\":\"0.41\",\"water\":\"2.1\",\"unsound\":\"10\",\"recorder\":\"测试用户\",\"houseType\":\"2971\",\"designHouseCapacity\":500.00,\"validHouseCapacity\":null,\"price\":\"10\",\"placeOfOrigin\":\"246\",\"storageLocation\":\"仓底\",\"disperseCapacity\":\"20\",\"length\":12.00,\"width\":12.00,\"height\":22.00,\"packNum\":\"10\",\"packAverageWeight\":\"2\",\"keeperIds\":null,\"glutenWaterCount\":null,\"eatScore\":null,\"fillingTime\":\"2017-11-30\",\"lineHeight\":null,\"sealStatus\":\"1\",\"authCode\":\"upload\\\\image/1719.png\",\"storehouseName\":\"P1库\",\"wareHouseName\":\"P1-2号货位\",\"keeperNames\":null},{\"id\":61,\"houseId\":3,\"warehouseId\":4,\"recordUnite\":\"中央\",\"keepUnite\":\"河北省粮食仓库\",\"locationNum\":null,\"quality\":\"3046\",\"subType\":3166,\"htype\":\"0\",\"number\":9500.0,\"standNumber\":null,\"inputYear\":1511827200000,\"growYear\":null,\"keepMethod\":\"散放\",\"level\":\"11\",\"weight\":\"780\",\"impurity\":\"1\",\"water\":\"1\",\"unsound\":\"1\",\"recorder\":\"测试用户\",\"houseType\":\"2971\",\"designHouseCapacity\":100.00,\"validHouseCapacity\":null,\"price\":\"2\",\"placeOfOrigin\":null,\"storageLocation\":\"33\",\"disperseCapacity\":\"20\",\"length\":null,\"width\":12.00,\"height\":12.00,\"packNum\":\"33\",\"packAverageWeight\":\"55\",\"keeperIds\":null,\"glutenWaterCount\":null,\"eatScore\":null,\"fillingTime\":\"2017-11-28\",\"lineHeight\":null,\"sealStatus\":\"1\",\"authCode\":\"upload\\\\image/34.png\",\"storehouseName\":\"P1库\",\"wareHouseName\":\"P1-2号货位\",\"keeperNames\":null}]");
    }
    void newListData(String json) {
        List<FoodCardBean> list = gson.fromJson(json, new TypeToken<List<FoodCardBean>>() {
        }.getType());
        if (list != null && list.size() > 0)
            mAdapter.replaceData(list);
        else {
            mAdapter.replaceData(new ArrayList<FoodCardBean>());
        }
    }
    void handleThreeTempData(String data) {
        try {
            Type type = new TypeToken<List<ThreeTemp>>() {
            }.getType();
            List<ThreeTemp> d = new Gson().fromJson(data, type);

            cnwdList.clear();
            cwwdList.clear();
            lswdList.clear();
            List<ThreeTemp> newList = new ArrayList<>();
            for (int i = d.size() - 1; i >= 0; i--) {
                newList.add(d.get(i));
            }
            for (int i = 0; i < newList.size(); i++) {
                try {
                    ThreeChartBean cnwdBean = new ThreeChartBean(i, newList.get(i).getCnwd());
                    ThreeChartBean cwwdBean = new ThreeChartBean(i, newList.get(i).getCwwd());
                    ThreeChartBean lswdBean = new ThreeChartBean(i, newList.get(i).getLswd());
                    cnwdList.add(cnwdBean);
                    cwwdList.add(cwwdBean);
                    lswdList.add(lswdBean);
                } catch (Exception e) {
                    continue;
                }
            }
            chart.setData(cnwdList, lswdList, cwwdList).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
