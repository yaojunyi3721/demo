package com.chinaitop.linxia.demo.activity.JianGuan.liangkudongtaiguanli;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LunHuanXinXiActivity extends BaseActivity {

    @BindView(R.id.tv_chaxun)
    TextView tvChaxun;
    @BindView(R.id.btn_chaxun)
    Button btnChaxun;
    @BindView(R.id.list_view)
    ListView listView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lun_huan_xin_xi);
        ButterKnife.bind(this);
        mContext = getApplicationContext();

        setTitle("轮换信息");

        initData();
    }

    private void initData() {
        List<MingXiBead> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Random rand = new Random();
            int cangfang = rand.nextInt(30) + 1;
            int huowei = rand.nextInt(5) + 1;
            int index = rand.nextInt(5);
            String[] xhArr = {"001-JH-20171220-05", "001-JH-20171210-01", "001-JH-20171202-06",
                    "001-JH-20171110-03", "001-JH-20170918-07", "001-JH-20170320-07"};
            String[] kdmcArr = {"0000001", "000123", "000234234", "0007878234", "000123123", "0009896"};
            String[] cfmcArr = {"石家庄市", "保定市", "邢台市", "张家口市", "邯郸市", "衡水市"};
            String[] hwmcArr = {"10237181", "2423435565345", "23482934", "234234234234", "456456", "234u302934u234"};
            String[] pinzhongArr = {"00001", "00002", "00003", "00004", "00005", "00006"};
            String[] clxzArr = {"地方储备粮", "中央储备粮", "中央储备粮", "地方储备粮", "储备粮", "地方储备粮"};
            String[] djArr = {"", "", "", "", "", ""};
            String[] sjslArr = {"", "", "", "", "", ""};
            String[] rqArr = {"", "", "", "", "", ""};

            String xh = xhArr[index];
            String kdmc = kdmcArr[index];
            String cfmc = cfmcArr[index];
            String hwmc = hwmcArr[index];

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

    @OnClick(R.id.btn_chaxun)
    public void onViewClicked() {
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
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_lunhuanjihua, parent, false);
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
            @BindView(R.id.tv_kdmc)
            TextView tvKdmc;
            @BindView(R.id.tv_cfmc)
            TextView tvCfmc;
            @BindView(R.id.tv_hwh)
            TextView tvHwh;
            @BindView(R.id.tv_pz)
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
