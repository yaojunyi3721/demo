package com.chinaitop.linxia.demo.activity.AnQuan.LuJing;

import android.os.Bundle;
import android.widget.ListView;

import com.chinaitop.linxia.demo.BaseModel;
import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LujingListActivity extends BaseActivity {
    LujingList[] data=new LujingList[]{
            new LujingList(BaseModel.TYPE_TITLE),
            new LujingList("1",R.mipmap.erweima,"国家储备粮","小麦","一级"),
            new LujingList("2",R.mipmap.erweima,"地方储备粮","玉米","三级"),
    };
    @BindView(R.id.lv_main)
    ListView lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lujing_list);
        ButterKnife.bind(this);
        setTitle("粮食流通路径");
        lvMain.setAdapter(new LujingListAdapter(data,this));
    }
}
