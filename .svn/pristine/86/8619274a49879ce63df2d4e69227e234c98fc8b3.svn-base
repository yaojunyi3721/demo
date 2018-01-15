package com.chinaitop.linxia.demo.activity.ZhiFa;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;
import com.chinaitop.linxia.demo.activity.ZhiFa.one.Zhifa1Fragment;
import com.chinaitop.linxia.demo.activity.ZhiFa.two.Zhifa2Fragment;

import butterknife.ButterKnife;

public class ZhifaActivity extends BaseActivity {
    Fragment oneFragment, twoFragment, threeFragment, fourFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhifa);
        ButterKnife.bind(this);
        setTitle("移动执法管理");
        initViews();
    }

    private void initViews() {
        TabLayout mTablayout = (TabLayout) findViewById(R.id.tabLayout);
        TabLayout.Tab one = mTablayout.newTab().setText("查询").setIcon(getResources().getDrawable(R.drawable.zhifa1));
        TabLayout.Tab two = mTablayout.newTab().setText("统计分析").setIcon(getResources().getDrawable(R.drawable.zhifa2));
        TabLayout.Tab three = mTablayout.newTab().setText("监控").setIcon(getResources().getDrawable(R.drawable.zhifa3));
        TabLayout.Tab four = mTablayout.newTab().setText("我的").setIcon(getResources().getDrawable(R.drawable.zhifa4));
        mTablayout.addTab(one);
        mTablayout.addTab(two);
        mTablayout.addTab(three);
        mTablayout.addTab(four);

        oneFragment = new Zhifa1Fragment();
        twoFragment = new Zhifa2Fragment();
        threeFragment = new Zhifa3Fragment();
        fourFragment = new Zhifa4Fragment();
        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout, oneFragment)
                                .commit();
                        break;
                    case 1:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout, twoFragment)
                                .commit();
                        break;
                    case 2:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout, threeFragment)
                                .commit();
                        break;
                    case 3:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout, fourFragment)
                                .commit();
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        two.select();
    }
}
