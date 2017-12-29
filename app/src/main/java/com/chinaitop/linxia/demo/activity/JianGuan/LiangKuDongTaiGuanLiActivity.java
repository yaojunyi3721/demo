package com.chinaitop.linxia.demo.activity.JianGuan;

import android.os.Bundle;
import android.widget.GridView;

import com.chinaitop.linxia.demo.Menus;
import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;
import com.chinaitop.linxia.demo.adapter.MenuAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LiangKuDongTaiGuanLiActivity extends BaseActivity {

    @BindView(R.id.module_grid_view)
    GridView moduleGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liang_ku_dong_tai_guan_li);
        ButterKnife.bind(this);

        setTitle("粮库动态管理");

        MenuAdapter adapter = new MenuAdapter(Menus.modulesLiangKuDongTaiGuanLi, this);
        moduleGridView.setAdapter(adapter);
    }
}
