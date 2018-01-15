package com.chinaitop.linxia.demo.activity.JianGuan.LiangQing;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;

public class LiangQingCeKongActivity extends BaseActivity {
    private FragmentPagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private TabLayout.Tab one, two, three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liang_qing_ce_kong);
        setTitle("粮情测控");
        initViews();
    }

    private void initViews() {
        TabLayout mTablayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            private String[] mTitles = new String[]{"温湿度", "熏蒸作业", "通风作业"};

            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return new TemperatureFragment();
                    case 1:
                        return new XunzhengFragment();
                        default:
                            return new AirFragment();
                }
            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }

        };
        mViewPager.setAdapter(pagerAdapter);

        mTablayout.setupWithViewPager(mViewPager);

        one = mTablayout.getTabAt(0);
        two = mTablayout.getTabAt(1);
        if (two != null) {
            two.select();
        }
        three = mTablayout.getTabAt(2);

        one.setIcon(getResources().getDrawable(R.drawable.guanlian));
        two.setIcon(getResources().getDrawable(R.drawable.pandian));
        three.setIcon(getResources().getDrawable(R.drawable.user));
    }
}
