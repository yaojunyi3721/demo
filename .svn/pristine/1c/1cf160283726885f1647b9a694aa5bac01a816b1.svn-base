package com.chinaitop.linxia.demo.activity.AnQuan.LuJing;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;

public class LujingItemActivity extends BaseActivity {
    private FragmentPagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private TabLayout.Tab one, two;

    public String parentId = "1";
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lujing_item);
        parentId = getIntent().getStringExtra("parentId");
        bundle = new Bundle();
        bundle.putString("parentId", parentId);
        setTitle("粮食流通路径");
        initViews();
    }

    private void initViews() {
        TabLayout mTablayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            private String[] mTitles = new String[]{"入库信息", "出库信息"};
            Fragment fragment;

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        fragment = new LujingLeftFragment();
                        fragment.setArguments(bundle);
                        break;
                    default:
                        fragment = new LujingRightFragment();
                        fragment.setArguments(bundle);
                        break;
                }
                return fragment;
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
        if (one != null) {
            one.select();
        }

        one.setIcon(getResources().getDrawable(R.drawable.guanlian));
        two.setIcon(getResources().getDrawable(R.drawable.pandian));
    }
}
