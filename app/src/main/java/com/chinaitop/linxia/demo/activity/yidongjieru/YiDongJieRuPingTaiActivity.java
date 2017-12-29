package com.chinaitop.linxia.demo.activity.yidongjieru;

import android.os.Bundle;
import android.widget.GridView;

import com.chinaitop.linxia.demo.Menus;
import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;
import com.chinaitop.linxia.demo.adapter.MenuAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YiDongJieRuPingTaiActivity extends BaseActivity {

    @BindView(R.id.module_grid_view)
    GridView moduleGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yi_dong_jie_ru_ping_tai);
        ButterKnife.bind(this);

        setTitle("移动接入平台");

        MenuAdapter adapter = new MenuAdapter(Menus.modulesYiDongJieRuPingTai, this);
        moduleGridView.setAdapter(adapter);
    }
}
