package com.chinaitop.linxia.demo.activity.anquanguanli;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;
import com.example.zhouwei.library.CustomPopWindow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 移动设备安全管理
 *
 * @author liu
 * @date 2017/12/26
 */
public class YiDongSheBeiAnQuanGuanLiActivity extends BaseActivity {

    @BindView(R.id.list_view)
    ListView listView;
    @BindView(R.id.btn_more)
    Button btnMore;
    private Context mContext;

    private TelephonyManager phone;
    private WifiManager wifi;
    private Display display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_bei_an_quan_guan_li);
        ButterKnife.bind(this);
        setTitle("移动设备安全管理");

        mContext = getApplicationContext();

        final List<SheBeiXinXi> list = new ArrayList<>();
        list.add(new SheBeiXinXi("华为平板", "DEF234NF", "817236496594823737", "Android 8.0", "097463527384765", "13875647890", "Android"));
        list.add(new SheBeiXinXi("iphone 6s", "QW1373MW1", "03897565735284956", "iOS 11", "23747458594393723617", "13875647890", "Apple"));
        list.add(new SheBeiXinXi("iphone X", "SN873SDF", "16374586595473647693", "iOS 11", "059573626748596069", "13875647890", "Apple"));
        list.add(new SheBeiXinXi("iPad 2", "GGH3454HADF", "034947846372847585", "iOS 10", "838374859382363475860", "13875647890", "Apple"));
        list.add(new SheBeiXinXi("iPad mini", "GGH3454H1H", "02349873498234575324", "Android 8.0", "023948745624243", "13875647890", "Apple"));
        list.add(new SheBeiXinXi("小米平板", "GGH3434HRTR234", "282384723482385968278304", "Android 7.0", "0585762352648", "13875647890", "Android"));

        final ListViewAdapter adapter = new ListViewAdapter(mContext, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setSelectItem(position);
                adapter.notifyDataSetChanged();
                initData(position, list);
            }
        });

        phone = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        display = getWindowManager().getDefaultDisplay();

        init();
        initData(0, list);

        adapter.setSelectItem(0);
        adapter.notifyDataSetChanged();

    }

    @OnClick(R.id.btn_more)
    public void onViewClicked() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.btn_more, null);
        //创建并显示popWindow
        CustomPopWindow mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .create()
                .showAsDropDown(btnMore, 0, 20);
    }

    private void initData(int position, List<SheBeiXinXi> list) {
        setEditText(R.id.lianwang, list.get(position).getMingcheng());
        setEditText(R.id.lianwangname, list.get(position).getXinghao());
        setEditText(R.id.imei, list.get(position).imei);
        setEditText(R.id.deviceversion, list.get(position).version);
        setEditText(R.id.imsi, list.get(position).imsi);
        setEditText(R.id.number, list.get(position).number);
        setEditText(R.id.simserial, list.get(position).imei);
        setEditText(R.id.simoperator, list.get(position).mingcheng);
        setEditText(R.id.simoperatorname, list.get(position).name);
    }

    /**
     * 初始化设备信息
     */
    private void init() {
        DisplayMetrics book = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(book);


        try {
            Class localClass = Class.forName("android.os.SystemProperties");
            Object localObject1 = localClass.newInstance();
            Object localObject2 = localClass.getMethod("get", new Class[]{String.class, String.class}).invoke(localObject1, new Object[]{"gsm.version.baseband", "no message"});
            Object localObject3 = localClass.getMethod("get", new Class[]{String.class, String.class}).invoke(localObject1, new Object[]{"ro.build.display.id", ""});


            setEditText(R.id.get, localObject2 + "");

            setEditText(R.id.osVersion, localObject3 + "");
        } catch (Exception e) {
            e.printStackTrace();
        }


        //获取网络连接管理者
        ConnectivityManager connectionManager = (ConnectivityManager)
                getSystemService(CONNECTIVITY_SERVICE);
        //获取网络的状态信息，有下面三种方式
        NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();

//        setEditText(R.id.lianwang, networkInfo.getType() + "");
//        setEditText(R.id.lianwangname, networkInfo.getTypeName());
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
//        setEditText(R.id.imei, phone.getDeviceId());
//        setEditText(R.id.deviceversion, phone.getDeviceSoftwareVersion());
//        setEditText(R.id.imsi, phone.getSubscriberId());
//        setEditText(R.id.number, phone.getLine1Number());
//        setEditText(R.id.simserial, phone.getSimSerialNumber());
//        setEditText(R.id.simoperator, phone.getSimOperator());
//        setEditText(R.id.simoperatorname, phone.getSimOperatorName());
        setEditText(R.id.simcountryiso, phone.getSimCountryIso());
        setEditText(R.id.workType, phone.getNetworkType() + "");
        setEditText(R.id.netcountryiso, phone.getNetworkCountryIso());
        setEditText(R.id.netoperator, phone.getNetworkOperator());
        setEditText(R.id.netoperatorname, phone.getNetworkOperatorName());


        setEditText(R.id.radiovis, Build.getRadioVersion());
        setEditText(R.id.wifimac, wifi.getConnectionInfo().getMacAddress());
        setEditText(R.id.getssid, wifi.getConnectionInfo().getSSID());
        setEditText(R.id.getbssid, wifi.getConnectionInfo().getBSSID());
        setEditText(R.id.ip, wifi.getConnectionInfo().getIpAddress() + "");

        setEditText(R.id.cpu, getCpuName());


        setEditText(R.id.andrlid_id,
                Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID));
        setEditText(R.id.serial, Build.SERIAL);
        setEditText(R.id.brand, Build.BRAND);
        setEditText(R.id.tags, Build.TAGS);
        setEditText(R.id.device, Build.DEVICE);
        setEditText(R.id.fingerprint, Build.FINGERPRINT);
        setEditText(R.id.bootloader, Build.BOOTLOADER);
        setEditText(R.id.release, Build.VERSION.RELEASE);
        setEditText(R.id.sdk, Build.VERSION.SDK);
        setEditText(R.id.sdk_INT, Build.VERSION.SDK_INT + "");
        setEditText(R.id.codename, Build.VERSION.CODENAME);
        setEditText(R.id.incremental, Build.VERSION.INCREMENTAL);
        setEditText(R.id.cpuabi, Build.CPU_ABI);
        setEditText(R.id.cpuabi2, Build.CPU_ABI2);
        setEditText(R.id.board, Build.BOARD);
        setEditText(R.id.model, Build.MODEL);
        setEditText(R.id.product, Build.PRODUCT);
        setEditText(R.id.type, Build.TYPE);
        setEditText(R.id.user, Build.USER);
        setEditText(R.id.disply, Build.DISPLAY);
        setEditText(R.id.hardware, Build.HARDWARE);
        setEditText(R.id.host, Build.HOST);
        setEditText(R.id.changshang, Build.MANUFACTURER);
        setEditText(R.id.phonetype, phone.getPhoneType() + "");
        setEditText(R.id.simstate, phone.getSimState() + "");
        setEditText(R.id.b_id, Build.ID);
        setEditText(R.id.gjtime, Build.TIME + "");
        setEditText(R.id.width, display.getWidth() + "");
        setEditText(R.id.height, display.getHeight() + "");
        setEditText(R.id.dpi, book.densityDpi + "");
        setEditText(R.id.density, book.density + "");
        setEditText(R.id.xdpi, book.xdpi + "");
        setEditText(R.id.ydpi, book.ydpi + "");
        setEditText(R.id.scaledDensity, book.scaledDensity + "");


        //setEditText(R.id.wl,getNetworkState(this)+"");
        // 方法2
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        setEditText(R.id.xwidth, width + "");
        setEditText(R.id.xheight, height + "");

    }

    private void setEditText(int id, String s) {
        ((TextView) this.findViewById(id)).setText(s);
    }

    /**
     * 获取CPU型号
     *
     * @return
     */
    public static String getCpuName() {

        String str1 = "/proc/cpuinfo";
        String str2 = "";

        try {
            FileReader fr = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(fr);
            while ((str2 = localBufferedReader.readLine()) != null) {
                if (str2.contains("Hardware")) {
                    return str2.split(":")[1];
                }
            }
            localBufferedReader.close();
        } catch (IOException e) {
        }
        return null;

    }

    public class SheBeiXinXi {
        private String mingcheng;
        private String xinghao;
        private String imei;
        private String version;
        private String imsi;
        private String number;
        private String name;

        public SheBeiXinXi(String mingcheng, String xinghao, String imei, String version, String imsi, String number, String name) {
            this.mingcheng = mingcheng;
            this.xinghao = xinghao;
            this.imei = imei;
            this.version = version;
            this.imsi = imsi;
            this.number = number;
            this.name = name;
        }

        public SheBeiXinXi(String mingcheng, String xinghao) {
            this.mingcheng = mingcheng;
            this.xinghao = xinghao;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getImsi() {
            return imsi;
        }

        public void setImsi(String imsi) {
            this.imsi = imsi;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMingcheng() {
            return mingcheng;
        }

        public void setMingcheng(String mingcheng) {
            this.mingcheng = mingcheng;
        }

        public String getXinghao() {
            return xinghao;
        }

        public void setXinghao(String xinghao) {
            this.xinghao = xinghao;
        }
    }

    public static class ListViewAdapter extends BaseAdapter {

        private List<SheBeiXinXi> mData;
        private Context mContext;

        public ListViewAdapter(Context context, List<SheBeiXinXi> data) {
            this.mData = data;
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_she_bei_xin_xi, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.mingCheng.setText(mData.get(position).getMingcheng());
            holder.xingHao.setText(mData.get(position).getXinghao());
            if (position == selectItem) {
                convertView.setBackgroundColor(Color.LTGRAY);
            } else {
                convertView.setBackgroundColor(Color.TRANSPARENT);
            }

            return convertView;
        }

        public void setSelectItem(int selectItem) {
            this.selectItem = selectItem;
        }

        private int selectItem = -1;

        static class ViewHolder {
            @BindView(R.id.icon)
            ImageView icon;
            @BindView(R.id.ming_cheng)
            TextView mingCheng;
            @BindView(R.id.xing_hao)
            TextView xingHao;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
