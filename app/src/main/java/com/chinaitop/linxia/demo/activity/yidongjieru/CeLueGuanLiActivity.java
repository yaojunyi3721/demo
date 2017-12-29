package com.chinaitop.linxia.demo.activity.yidongjieru;

import android.os.Bundle;
import android.widget.ListView;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CeLueGuanLiActivity extends BaseActivity {

    @BindView(R.id.lv_main)
    ListView lvMain;
    JieRu[] data=new JieRu[]{
            new JieRu("IP","接入群体","接入时间段","端口号","是否开放"),
            new JieRu("192.168.80.151","","2017/2/3","1520","是"),
            new JieRu("192.168.80.184","","2017/3/19","8081","否"),
            new JieRu("192.168.80.123","","2017/6/23","1588","是"),
            new JieRu("192.168.80.199","","2017/7/16","9999","否"),
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ce_lue_guan_li);
        ButterKnife.bind(this);
        setTitle("策略管理");
        lvMain.setAdapter(new JieruAdapter(data,this));
    }
}
