package com.chinaitop.linxia.demo.activity.AnQuan;

import android.os.Bundle;
import android.widget.GridView;

import com.chinaitop.linxia.demo.Menus;
import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;
import com.chinaitop.linxia.demo.adapter.MenuAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnquanActivity extends BaseActivity {

    @BindView(R.id.grid1)
    GridView grid1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anquan);
        ButterKnife.bind(this);
        setTitle("质量安全管理");
        grid1.setAdapter(new MenuAdapter(Menus.moduleZhiliang,this));

    }
}
