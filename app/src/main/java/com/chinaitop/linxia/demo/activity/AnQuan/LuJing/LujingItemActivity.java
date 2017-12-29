package com.chinaitop.linxia.demo.activity.AnQuan.LuJing;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.JianGuan.LiangQing.TemperatureFragment;
import com.chinaitop.linxia.demo.activity.JianGuan.LiangQing.XunzhengFragment;

public class LujingItemActivity extends AppCompatActivity {
    private FragmentPagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private TabLayout.Tab one, two, three;

    public String parentId="1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lujing_item);
        parentId= getIntent().getStringExtra("parentId");
        setTitle("粮食流通路径");
        initViews();
    }

    private void initViews() {
        TabLayout mTablayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            private String[] mTitles = new String[]{"入库信息", "出库信息"};

            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return new TemperatureFragment();
                    default:
                        return new XunzhengFragment();
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
