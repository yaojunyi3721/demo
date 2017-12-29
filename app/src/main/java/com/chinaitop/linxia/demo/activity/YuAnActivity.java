package com.chinaitop.linxia.demo.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.utils.AMapUtil;
import com.chinaitop.linxia.demo.utils.KeyBoardUtils;
import com.chinaitop.linxia.demo.utils.LogUtils;
import com.chinaitop.linxia.demo.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class YuAnActivity extends BaseActivity implements LocationSource, AMapLocationListener, GeocodeSearch.OnGeocodeSearchListener, AMap.OnCameraChangeListener {
    private static final LatLng HEBEI = new LatLng(114.530, 38.037);
    private MarkerOptions markerOption;
    private AMap aMap;
    private MapView mapView;
    private OnLocationChangedListener mListener;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    private LatLng[][] latLngs = new LatLng[][]{
            new LatLng[]{new LatLng(0.5, 0.05), new LatLng(0.7, 0.2)},
            new LatLng[]{new LatLng(0.089, 0.12), new LatLng(0.8, 0.2)},
            new LatLng[]{new LatLng(1.2, 0.2), new LatLng(0.861, 0.635)},
            new LatLng[]{new LatLng(0.022, 0.004), new LatLng(0.441, 0.213)},
            new LatLng[]{new LatLng(0.814, 0.682), new LatLng(0.747, 0.484)}
    };
    private String[] messages=new String[]{
            "单位名称:中央储备粮石家庄直属库\n" +
                    "单位性质:共有\n"+
                    "仓房个数:24\n"+
                    "储量性质:中央储备粮\n"+
                    "储量数量:750吨",
            "单位名称:中央储备粮石家庄直属库\n" +
                    "单位性质:共有\n"+
                    "仓房个数:24\n"+
                    "储量性质:中央储备粮\n"+
                    "储量数量:750吨"

    };
    private LatLng center = new LatLng(39.761, 116.434);
    private PopupWindow popupWindow;
    private View rootView;
    private String cityCode = "010";
    private GeocodeSearch geocoderSearch;
    LatLngBounds.Builder boundsBuilder = new LatLngBounds.Builder();//存放所有marker的经纬度
    float zoom = 18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yu_an);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("应急预案");
        final SearchView searchView = (SearchView) findViewById(R.id.search_view);
        searchView.setIconifiedByDefault(false);
        searchView.setSubmitButtonEnabled(true);
        EditText textView = searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        textView.setHintTextColor(ContextCompat.getColor(this, R.color.halfWhite));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getLatlon(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        /*
         * 设置离线地图存储目录，在下载离线地图或初始化地图设置; 使用过程中可自行设置, 若自行设置了离线地图存储的路径，
		 * 则需要在离线地图下载和使用地图页面都进行路径设置
		 */
        // Demo中为了其他界面可以使用下载的离线地图，使用默认位置存储，屏蔽了自定义设置
        // MapsInitializer.sdcardDir =OffLineMapUtils.getSdCacheDir(this);
        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState); // 此方法必须重写
        init();
    }

    public void openPop() {
        if (popupWindow == null) {
            View popView = LayoutInflater.from(this).inflate(
                    R.layout.pop_right, null);
            rootView = findViewById(R.id.root_main); // 當前頁面的根佈局
            popupWindow = new PopupWindow(popView,
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            popupWindow.setOutsideTouchable(false);//触摸外部不关闭
            // 设置弹出动画
//        popupWindow.setAnimationStyle(R.style.AnimationFadeBottom);
            popupWindow.setBackgroundDrawable(new BitmapDrawable());

//            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//                @Override
//                public void onDismiss() {
//                    // popupWindow隐藏时恢复屏幕正常透明度
//                    setBackgroundAlpha(1.0f);
//                }
//            });
            Button bt1 = popView.findViewById(R.id.bt_yjps);
            Button bt2 = popView.findViewById(R.id.bt_yjzhxz);
            Button bt3 = popView.findViewById(R.id.bt_zhfb);
            Button bt4 = popView.findViewById(R.id.bt_yjgyd);
            Button bt5 = popView.findViewById(R.id.bt_lsgyd);
            Button bt6 = popView.findViewById(R.id.bt_yjspjc);
            bt1.setOnClickListener(popButtonListener);
            bt2.setOnClickListener(popButtonListener);
            bt3.setOnClickListener(popButtonListener);
            bt4.setOnClickListener(popButtonListener);
            bt5.setOnClickListener(popButtonListener);
            bt6.setOnClickListener(popButtonListener);
        }
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        } else {
            KeyBoardUtils.closeKeybord(this);
//            setBackgroundAlpha(0.5f);//设置屏幕透明度
            popupWindow.showAtLocation(rootView, Gravity.CENTER | Gravity.RIGHT, 0,
                    0);
        }
    }

    View.OnClickListener popButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_yjps:
                    addMarkersToMap(latLngs[0],messages);
//                    if (zoom >= 1) {
//                        zoom = zoom - 1;
//                    }else{
//                        Toast.makeText(YuAnActivity.this, "已经到头了", Toast.LENGTH_SHORT).show();
//                    }
                    break;
                case R.id.bt_yjzhxz:
                    addMarkersToMap(latLngs[1],messages);
                    break;
                case R.id.bt_zhfb:
                    addMarkersToMap(latLngs[2],messages);
                    break;
                case R.id.bt_yjgyd:
                    addMarkersToMap(latLngs[3],messages);
                    break;
                case R.id.bt_lsgyd:
                    addMarkersToMap(latLngs[4],messages);
                    break;
                case R.id.bt_yjspjc:
                    Toast.makeText(YuAnActivity.this, "视频播放", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    /**
     * 初始化AMap对象
     */
    private void init() {
        if (aMap == null) {
            aMap = mapView.getMap();
            setUpMap();
        }
        geocoderSearch = new GeocodeSearch(this);
        geocoderSearch.setOnGeocodeSearchListener(this);
    }

    private void setUpMap() {
        // 自定义系统定位小蓝点
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory
                .fromResource(R.mipmap.location_marker));// 设置小蓝点的图标
        myLocationStyle.strokeColor(Color.BLACK);// 设置圆形的边框颜色
        myLocationStyle.radiusFillColor(Color.argb(100, 0, 0, 180));// 设置圆形的填充颜色
//         myLocationStyle.anchor(int,int)//设置小蓝点的锚点
        myLocationStyle.strokeWidth(1.0f);// 设置圆形的边框粗细
        aMap.setMyLocationStyle(myLocationStyle);
        aMap.setLocationSource(this);// 设置定位监听
        aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
        aMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        if (Build.VERSION.SDK_INT >= 23) {
            checkPermission();
        } else {
            //定位
            try {
                mlocationClient.startLocation();
            } catch (Exception e) {
                Log.e("aaamap", null, e);
            }
        }

        aMap.setOnCameraChangeListener(this);
//        zoomOut();

    }

    private void zoomOut() {
        //public CameraPosition(LatLng target,
//        float zoom,
//        float tilt,
//        float bearing)
//        参数:
//        target - 目标位置的屏幕中心点经纬度坐标。
//        zoom - 目标可视区域的缩放级别。
//        tilt - 目标可视区域的倾斜度，以角度为单位。
//        bearing - 可视区域指向的方向，以角度为单位，从正北向顺时针方向计算，从0度到360度。
        aMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(
                HEBEI, zoom, 30, 0)));
    }

    /**
     * 响应地理编码
     */
    public void getLatlon(final String name) {
        showPd();
        aMap.clear();
        GeocodeQuery query = new GeocodeQuery(name, cityCode);// 第一个参数表示地址，第二个参数表示查询城市，中文或者中文全拼，citycode、adcode，
        geocoderSearch.getFromLocationNameAsyn(query);// 设置同步地理编码请求
    }

    private void checkPermission() {
        int checkPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (checkPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            Toast.makeText(this, "地图定位请允许授权", Toast.LENGTH_SHORT).show();
            return;
        } else {
            //定位
            try {
                mlocationClient.startLocation();
            } catch (Exception e) {
                Log.e("aaamap", null, e);
            }
        }
    }

    /**
     * 运行了权限之后立即就可以获取到位置信息
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //定位
                    try {
                        mlocationClient.startLocation();
                    } catch (Exception e) {
                        Log.e("aaamap", null, e);
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode,
                        permissions, grantResults);
        }
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    /**
     * 在地图上添加marker
     */
    private void addMarkersToMap(LatLng[] latlngs) {
        addMarkersToMap(latlngs, null);
    }

    /**
     * 在地图上添加marker
     */
    private void addMarkersToMap(LatLng[] latlngs, String[] messages) {
        aMap.clear();
        boundsBuilder = new LatLngBounds.Builder();//存放所有点的经纬度
        if (messages != null && messages.length >= latlngs.length) {
            for (int i = 0; i < latlngs.length; i++) {
                LatLng latlng = latlngs[i];
                latlng = new LatLng(center.latitude + latlng.latitude, center.longitude + latlng.longitude);
                boundsBuilder.include(latlng);//把所有点都include进去（LatLng类型）
                addMarkersToMap(AMapUtil.convertToLatLonPoint(latlng), messages[i]);
            }
        } else {
            for (LatLng latlng1 : latlngs) {
                LatLng latlng = latlng1;
                latlng = new LatLng(center.latitude + latlng.latitude, center.longitude + latlng.longitude);
                boundsBuilder.include(latlng);//把所有点都include进去（LatLng类型）
                addMarkersToMap(AMapUtil.convertToLatLonPoint(latlng), null);
            }
        }
        //多个Marker标记自动缩放全部显示在屏幕中
        aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(boundsBuilder.build(), 15));//第二个参数为四周留空宽度
    }

    private void addMarkersToMap(LatLonPoint latLonPoint, String address) {
        LatLng latlng = new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude());
        markerOption = new MarkerOptions().icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .position(latlng)
                .draggable(false);
        if (address != null) {
            markerOption.title(address);
        }
        Marker marker = aMap.addMarker(markerOption);
        if (address != null) {
            marker.showInfoWindow();
        }

    }

    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        getWindow().setAttributes(lp);
    }

    @Override
    public void activate(OnLocationChangedListener listener) {
        mListener = listener;
        if (mlocationClient == null) {
            mlocationClient = new AMapLocationClient(this);
            mLocationOption = new AMapLocationClientOption();
            //设置定位监听
            mlocationClient.setLocationListener(this);
            //设置为高精度定位模式
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //设置定位参数
            mlocationClient.setLocationOption(mLocationOption);
            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
            // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
            // 在定位结束后，在合适的生命周期调用onDestroy()方法
            // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
            mlocationClient.startLocation();
        }
    }

    @Override
    public void deactivate() {
        mListener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
    }

    /**
     * 定位成功后回调函数
     */
    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (mListener != null && amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                mListener.onLocationChanged(amapLocation);// 显示系统小蓝点
                //定位成功回调信息，设置相关消息
                center = new LatLng(amapLocation.getLatitude(), amapLocation.getLongitude());
                cityCode = amapLocation.getCityCode();
            } else {
                String errText = "定位失败," + amapLocation.getErrorCode() + ": " + amapLocation.getErrorInfo();
                Log.e("AmapErr", errText);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.yu_an, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_open_pannel:
                openPop();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 地理编码查询回调
     */
    @Override
    public void onGeocodeSearched(GeocodeResult result, int rCode) {
        cancelPd();
        if (rCode == AMapException.CODE_AMAP_SUCCESS) {
            if (result != null && result.getGeocodeAddressList() != null
                    && result.getGeocodeAddressList().size() > 0) {
                GeocodeAddress address = result.getGeocodeAddressList().get(0);//只取了第一个
                aMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                        AMapUtil.convertToLatLng(address.getLatLonPoint()), 15));
                addMarkersToMap(address.getLatLonPoint(), address.getFormatAddress());
            } else {
                ToastUtil.show(YuAnActivity.this, R.string.no_result);
            }
        } else {
            ToastUtil.showerror(this, rCode);
            switch (rCode) {
                case 1802:
                    Toast.makeText(this, "请先检查网络状况是否良好", Toast.LENGTH_SHORT).show();
                    break;
                case 1804:
                    Toast.makeText(this, "请检查网络连接是否畅通", Toast.LENGTH_SHORT).show();
                    break;
                case 1806:
                    Toast.makeText(this, "请检查网络状况以及网络的稳定性", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    /**
     * 逆地理编码回调
     */
    @Override
    public void onRegeocodeSearched(RegeocodeResult result, int rCode) {

    }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {

    }

    @Override
    public void onCameraChangeFinish(CameraPosition cameraPosition) {
//        Toast.makeText(this, "" + cameraPosition.zoom, Toast.LENGTH_SHORT).show();
    }
}
