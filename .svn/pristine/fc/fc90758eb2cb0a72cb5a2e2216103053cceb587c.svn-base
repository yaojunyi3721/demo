package com.chinaitop.linxia.demo.activity.FenXi;

import android.os.Bundle;
import android.widget.GridView;

import com.chinaitop.linxia.demo.Menus;
import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;
import com.chinaitop.linxia.demo.adapter.MenuAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZongHeFenXiActivity extends BaseActivity {

    @BindView(R.id.module_grid_view)
    GridView moduleGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zong_he_fen_xi);
        ButterKnife.bind(this);

        setTitle("综合分析");

        MenuAdapter adapter = new MenuAdapter(Menus.modulesZongHeFenXi, this);
        moduleGridView.setAdapter(adapter);

    }
}
