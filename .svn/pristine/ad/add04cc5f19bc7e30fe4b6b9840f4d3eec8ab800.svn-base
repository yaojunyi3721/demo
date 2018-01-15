package com.chinaitop.linxia.demo.activity.JianGuan.liangkudongtaiguanli;

import android.os.Bundle;
import android.widget.ListView;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;
import com.chinaitop.linxia.demo.activity.yidongjieru.JieRu;
import com.chinaitop.linxia.demo.activity.yidongjieru.JieruAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChuRuKuXinXiActivity extends BaseActivity {
    JieRu[] data = new JieRu[]{
            new JieRu("临时货位", "检斤时间", "性质", "客户名称", "地址", "身份证号", "承运人"),
            new JieRu("", "2017/12/12", "", "赵敏", "河北省邯郸市106号", "140729198902030545", "王涛"),

    };
    @BindView(R.id.lv_main)
    ListView lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chu_ru_ku_xin_xi);
        ButterKnife.bind(this);
        setTitle("出入库信息");
        lvMain.setAdapter(new JieruAdapter(data,this));
    }
}
