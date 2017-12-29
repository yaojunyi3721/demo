package com.chinaitop.linxia.demo.activity.yidongjieru;

import android.os.Bundle;
import android.widget.ListView;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JieRuGuanLiActivity extends BaseActivity {
    JieRu[] data = new JieRu[]{
            new JieRu("IP", "连接管理", "设备管理", "网络资源用量管理", "资费管理", "服务托管"),
            new JieRu("192.168.80.151", "激活", "移动", "正常量", "正常", "无"),
            new JieRu("192.168.80.153", "未激活", "PC", "正常量", "正常", "无"),
            new JieRu("192.168.80.186", "激活", "移动", "异常量", "正常", "无"),
            new JieRu("192.168.80.165", "激活", "移动", "正常量", "正常", "无"),
            new JieRu("192.168.80.203", "激活", "移动", "正常量", "正常", "无"),
    };
    @BindView(R.id.lv_main)
    ListView lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_ru_guan_li);
        ButterKnife.bind(this);
        setTitle("接入管理");
        lvMain.setAdapter(new JieruAdapter(data,this));
    }
}
