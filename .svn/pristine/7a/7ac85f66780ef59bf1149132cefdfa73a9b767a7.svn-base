package com.chinaitop.linxia.demo.activity.anquanguanli;

import android.os.Bundle;
import android.widget.GridView;

import com.chinaitop.linxia.demo.Menus;
import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;
import com.chinaitop.linxia.demo.adapter.MenuAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 安全管理平台
 *
 * @author liu
 * @date 2017/12/26
 */

public class AnQuanGuanLiPingTaiActivity extends BaseActivity {

    @BindView(R.id.module_grid_view)
    GridView moduleGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_quan_guan_li_ping_tai);
        ButterKnife.bind(this);

        setTitle("安全管理平台");

        MenuAdapter adapter = new MenuAdapter(Menus.modulesAnQuanGuanLiPingTai, this);
        moduleGridView.setAdapter(adapter);
    }
}
