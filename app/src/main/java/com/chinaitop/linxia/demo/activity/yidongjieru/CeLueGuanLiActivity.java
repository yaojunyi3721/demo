package com.chinaitop.linxia.demo.activity.yidongjieru;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;
import com.example.zhouwei.library.CustomPopWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CeLueGuanLiActivity extends BaseActivity {

    @BindView(R.id.tv_kudian)
    TextView tvKudian;
    @BindView(R.id.btn_huangjingjiancha)
    Button btnHuangjingjiancha;
    @BindView(R.id.tv_pinzhong)
    TextView tvPinzhong;
    @BindView(R.id.btn_wenjianpeizhi)
    Button btnWenjianpeizhi;
    @BindView(R.id.tv_xingzhi)
    TextView tvXingzhi;
    @BindView(R.id.btn_zhunrujiancha)
    Button btnZhunrujiancha;
    @BindView(R.id.tv_dengji)
    TextView tvDengji;
    @BindView(R.id.btn_banben)
    Button btnBanben;
    @BindView(R.id.list_view)
    ListView listView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ce_lue_guan_li);
        ButterKnife.bind(this);
        setTitle("策略管理");

        mContext = getApplicationContext();

        List<AnQuanJianChaBean> list = new ArrayList<>();
        list.add(new AnQuanJianChaBean("192.168.50.164", "", "2017/2/3", "1520", "是", ""));
        list.add(new AnQuanJianChaBean("192.168.60.132", "", "2017/3/3", "8081", "否", ""));
        list.add(new AnQuanJianChaBean("192.168.50.184", "", "2017/8/6", "8008", "是", ""));
        list.add(new AnQuanJianChaBean("192.168.80.151", "", "2017/9/6", "9090", "是", ""));
        list.add(new AnQuanJianChaBean("192.168.70.123", "", "2017/7/16", "8090", "否", ""));
        list.add(new AnQuanJianChaBean("192.168.50.164", "", "2017/2/3", "8080", "是", ""));

        AnQuanJianChaAdapter adapter = new AnQuanJianChaAdapter(list, mContext);
        listView.setAdapter(adapter);
    }

    @OnClick(R.id.btn_huangjingjiancha)
    public void onBtnHuangjingjianchaClicked() {

    }

    @OnClick(R.id.btn_wenjianpeizhi)
    public void onBtnWenjianpeizhiClicked() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.btn_yes_no, null);
        //创建并显示popWindow
        CustomPopWindow mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .create()
                .showAsDropDown(btnWenjianpeizhi, 0, 20);
    }


    class AnQuanJianChaBean {
        AnQuanJianChaBean(String ip, String huangjingpeizhi, String weijianpeizhi, String pootjiancha, String zhunrujiancha, String banbenhege) {
            this.ip = ip;
            this.huangjingpeizhi = huangjingpeizhi;
            this.weijianpeizhi = weijianpeizhi;
            this.pootjiancha = pootjiancha;
            this.zhunrujiancha = zhunrujiancha;
            this.banbenhege = banbenhege;
        }

        String ip;
        String huangjingpeizhi;
        String weijianpeizhi;
        String pootjiancha;
        String zhunrujiancha;
        String banbenhege;

    }

    public static class AnQuanJianChaAdapter extends BaseAdapter {

        List<AnQuanJianChaBean> list = new ArrayList<>();
        Context mContext;

        public AnQuanJianChaAdapter(List<AnQuanJianChaBean> list, Context mContext) {
            this.list = list;
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_ce_lue_guan_li, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.tvIp.setText(list.get(position).ip);
            holder.tvHjjc.setText(list.get(position).huangjingpeizhi);
            holder.tvWjpz.setText(list.get(position).weijianpeizhi);
            holder.tvPoot.setText(list.get(position).pootjiancha);
            holder.tvZrjc.setText(list.get(position).zhunrujiancha);
            holder.tvBbhejc.setText(list.get(position).banbenhege);

            return convertView;
        }

        static class ViewHolder {
            @BindView(R.id.tv_ip)
            TextView tvIp;
            @BindView(R.id.tv_hjjc)
            TextView tvHjjc;
            @BindView(R.id.tv_wjpz)
            TextView tvWjpz;
            @BindView(R.id.tv_poot)
            TextView tvPoot;
            @BindView(R.id.tv_zrjc)
            TextView tvZrjc;
            @BindView(R.id.tv_bbhejc)
            TextView tvBbhejc;
            @BindView(R.id.line)
            View line;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
