package com.chinaitop.linxia.demo.activity.AppStore;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.AppStore.four.FourFragment;
import com.chinaitop.linxia.demo.activity.AppStore.one.OneFragment;
import com.chinaitop.linxia.demo.activity.AppStore.three.ThreeFragment;
import com.chinaitop.linxia.demo.activity.AppStore.two.TwoFragment;
import com.chinaitop.linxia.demo.activity.BaseActivity;

public class StoreActivity extends BaseActivity {
    Fragment oneFragment, twoFragment, threeFragment, fourFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_store);
        setTitle("应用商店");
        initViews();
    }

    private void initViews() {
        TabLayout mTablayout = (TabLayout) findViewById(R.id.tabLayout);
        TabLayout.Tab one = mTablayout.newTab().setText("我的应用").setIcon(getResources().getDrawable(R.drawable.store1));
        TabLayout.Tab two = mTablayout.newTab().setText("应用商店").setIcon(getResources().getDrawable(R.drawable.store2));
        TabLayout.Tab three = mTablayout.newTab().setText("内容管理").setIcon(getResources().getDrawable(R.drawable.store3));
        TabLayout.Tab four = mTablayout.newTab().setText("消息中心").setIcon(getResources().getDrawable(R.drawable.store4));
        mTablayout.addTab(one);
        mTablayout.addTab(two);
        mTablayout.addTab(three);
        mTablayout.addTab(four);

        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();
        fourFragment = new FourFragment();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.store, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
