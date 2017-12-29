package com.chinaitop.linxia.demo.activity.AnQuan;

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
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChuLiangJiZhiLiangXinXiActivity extends BaseActivity {

    @BindView(R.id.list_view)
    ListView listView;
    @BindView(R.id.tv_kudian)
    TextView tvKudian;
    @BindView(R.id.btn_kudian)
    Button btnKudian;
    @BindView(R.id.tv_pinzhong)
    TextView tvPinzhong;
    @BindView(R.id.btn_pinzhong)
    Button btnPinzhong;
    @BindView(R.id.tv_xingzhi)
    TextView tvXingzhi;
    @BindView(R.id.btn_xingzhi)
    Button btnXingzhi;
    @BindView(R.id.tv_dengji)
    TextView tvDengji;
    @BindView(R.id.btn_dengji)
    Button btnDengji;
    @BindView(R.id.tv_riqi)
    TextView tvRiqi;
    @BindView(R.id.btn_riqi)
    Button btnRiqi;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chu_liang_ji_zhi_liang_xin_xi);
        ButterKnife.bind(this);
        mContext = getApplicationContext();

        setTitle("储粮及质量信息");

        initData();

    }

    private void initData() {
        List<MingXiBead> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Random rand = new Random();
            int cangfang = rand.nextInt(30) + 1;
            int huowei = rand.nextInt(5) + 1;
            int index = rand.nextInt(5);
            String[] pinzhongArr = {"小麦", "玉米", "稻谷", "混合小麦", "玉米", "稻谷"};
            String[] clxzArr = {"地方储备粮", "中央储备粮", "中央储备粮", "地方储备粮", "储备粮", "地方储备粮"};
            String[] djArr = {"一等", "二等", "三等", "四等", "一等", "二等"};
            String[] sjslArr = {"7560.12", "8495.00", "5673.32", "8274.45", "6354.88", "2537.34"};
            String[] rqArr = {"2016-01-03", "2015-03-23", "2014-05-19", "2015-07-02", "2016-10-03", "2017-11-07"};

            String xh = (i + 1) + "";
            String kdmc = "石家庄库";
            String cfmc = cangfang + "号仓";
            String hwmc = huowei + "号货位";
            String pz = pinzhongArr[index];
            String clxz = clxzArr[index];
            String dj = djArr[index];
            String sjsl = sjslArr[index];
            String rcrq = rqArr[index];

            list.add(new MingXiBead(xh, kdmc, cfmc, hwmc, pz, clxz, dj, sjsl, rcrq));
        }

        ListViewAdapter adapter = new ListViewAdapter(list, mContext);
        listView.setAdapter(adapter);
    }

    @OnClick(R.id.btn_kudian)
    public void onBtnKudianClicked() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.btn_diqu, null);
        //创建并显示popWindow
        CustomPopWindow mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .create()
                .showAsDropDown(btnKudian, 0, 20);
    }

    @OnClick(R.id.btn_pinzhong)
    public void onBtnPinzhongClicked() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.btn_pinzhong, null);
        //创建并显示popWindow
        CustomPopWindow mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .create()
                .showAsDropDown(btnPinzhong, 0, 20);
    }


    @OnClick(R.id.btn_xingzhi)
    public void onBtnXingzhiClicked() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.btn_xingzhi, null);
        //创建并显示popWindow
        CustomPopWindow mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .create()
                .showAsDropDown(btnXingzhi, 0, 20);
    }

    @OnClick(R.id.btn_dengji)
    public void onBtnDengjiClicked() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.btn_dengji, null);
        //创建并显示popWindow
        CustomPopWindow mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .create()
                .showAsDropDown(btnDengji, 0, 20);
    }

    @OnClick(R.id.btn_riqi)
    public void onBtnRiqiClicked() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.btn_nianfen, null);
        //创建并显示popWindow
        CustomPopWindow mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .create()
                .showAsDropDown(btnRiqi, 0, 20);
    }

    public static class ListViewAdapter extends BaseAdapter {

        List<MingXiBead> list = new ArrayList<>();
        Context mContext;

        public ListViewAdapter(List<MingXiBead> list, Context mContext) {
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
                convertView = LayoutInflater.from(mContext).inflate(R.layout.food_item_layout, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.tvNum.setText(list.get(position).getXh());
            holder.tvKdmc.setText(list.get(position).getKdmc());
            holder.tvCfmc.setText(list.get(position).getCfmc());
            holder.tvHwh.setText(list.get(position).getHwmc());
            holder.tvPz.setText(list.get(position).getPz());
            holder.tvClxz.setText(list.get(position).getClxz());
            holder.tvDj.setText(list.get(position).getDj());
            holder.tvShijsl.setText(list.get(position).getSjsl());
            holder.tvRcrq.setText(list.get(position).getRcrq());

            return convertView;
        }

        static class ViewHolder {
            @BindView(R.id.tv_num)
            TextView tvNum;
            @BindView(R.id.tv_1)
            TextView tvKdmc;
            @BindView(R.id.tv_2)
            TextView tvCfmc;
            @BindView(R.id.tv_hwh)
            TextView tvHwh;
            @BindView(R.id.tv_3)
            TextView tvPz;
            @BindView(R.id.tv_clxz)
            TextView tvClxz;
            @BindView(R.id.tv_dj)
            TextView tvDj;
            @BindView(R.id.tv_shijsl)
            TextView tvShijsl;
            @BindView(R.id.tv_rcrq)
            TextView tvRcrq;
            @BindView(R.id.line)
            View line;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }

    public class MingXiBead {
        private String xh;
        private String kdmc;
        private String cfmc;
        private String hwmc;
        private String pz;
        private String clxz;
        private String dj;
        private String sjsl;
        private String rcrq;

        public MingXiBead(String xh, String kdmc, String cfmc, String hwmc, String pz, String clxz, String dj, String sjsl, String rcrq) {
            this.xh = xh;
            this.kdmc = kdmc;
            this.cfmc = cfmc;
            this.hwmc = hwmc;
            this.pz = pz;
            this.clxz = clxz;
            this.dj = dj;
            this.sjsl = sjsl;
            this.rcrq = rcrq;
        }

        public String getXh() {
            return xh;
        }

        public void setXh(String xh) {
            this.xh = xh;
        }

        public String getKdmc() {
            return kdmc;
        }

        public void setKdmc(String kdmc) {
            this.kdmc = kdmc;
        }

        public String getCfmc() {
            return cfmc;
        }

        public void setCfmc(String cfmc) {
            this.cfmc = cfmc;
        }

        public String getHwmc() {
            return hwmc;
        }

        public void setHwmc(String hwmc) {
            this.hwmc = hwmc;
        }

        public String getPz() {
            return pz;
        }

        public void setPz(String pz) {
            this.pz = pz;
        }

        public String getClxz() {
            return clxz;
        }

        public void setClxz(String clxz) {
            this.clxz = clxz;
        }

        public String getDj() {
            return dj;
        }

        public void setDj(String dj) {
            this.dj = dj;
        }

        public String getSjsl() {
            return sjsl;
        }

        public void setSjsl(String sjsl) {
            this.sjsl = sjsl;
        }

        public String getRcrq() {
            return rcrq;
        }

        public void setRcrq(String rcrq) {
            this.rcrq = rcrq;
        }
    }
}
