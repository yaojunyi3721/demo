package com.chinaitop.linxia.demo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.allenliu.badgeview.BadgeFactory;
import com.allenliu.badgeview.BadgeView;
import com.chinaitop.linxia.demo.Menus;
import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.adapter.MenuAdapter;

import skin.support.SkinCompatManager;

public class MainActivity extends BaseActivity {
    GridView gd1, gd2, gd3;
    MenuAdapter adapter1, adapter2, adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        setTitle("移动门户", false);
        View ivBadge = findViewById(R.id.iv_badge);
        //未读信息
        BadgeFactory.create(this)
                .setTextColor(Color.WHITE)
                .setWidthAndHeight(25, 25)
                .setBadgeBackground(Color.RED)
                .setTextSize(10)
                .setBadgeGravity(Gravity.RIGHT | Gravity.TOP)
                .setBadgeCount(20)
                .setShape(BadgeView.SHAPE_CIRCLE)
                .setSpace(10, 10)
                .bind(ivBadge);
        ivBadge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "您有20条未读信息", Toast.LENGTH_SHORT).show();
            }
        });
        gd1 = (GridView) findViewById(R.id.grid1);
        gd2 = (GridView) findViewById(R.id.grid2);
        gd3 = (GridView) findViewById(R.id.grid3);
        adapter1 = new MenuAdapter(Menus.main1, this);
        adapter2 = new MenuAdapter(Menus.main2, this);
        adapter3 = new MenuAdapter(Menus.main3, this);
        gd1.setAdapter(adapter1);
        gd2.setAdapter(adapter2);
        gd3.setAdapter(adapter3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_theme_default:
                SkinCompatManager.getInstance().restoreDefaultTheme();
                break;
            case R.id.action_theme_dark:
                SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN); // load by suffix
                break;
            case R.id.action_quit:
                startActivity(this,LoginActivity.class);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
