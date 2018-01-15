package com.chinaitop.linxia.demo.activity.JianGuan;

import android.os.Bundle;
import android.widget.GridView;

import com.chinaitop.linxia.demo.Menus;
import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;
import com.chinaitop.linxia.demo.adapter.MenuAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KuJiJianGuanActivity extends BaseActivity {

    @BindView(R.id.module_grid_view)
    GridView moduleGridView;
    private MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ku_ji_jian_guan);
        ButterKnife.bind(this);
        setTitle("库级監管");

        adapter = new MenuAdapter(Menus.modulesKuJiGuanLi, this);
        moduleGridView.setAdapter(adapter);

    }
}
