package com.chinaitop.linxia.demo.activity.JianGuan.liangkudongtaiguanli;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;
import com.chinaitop.linxia.demo.utils.ToastUtils;
import com.example.zhouwei.library.CustomPopWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LiangKuCangChuQingKuangActivity extends BaseActivity {

    @BindView(R.id.tv_zhibiao)
    TextView tvZhibiao;
    @BindView(R.id.btn_zhibiao)
    Button btnZhibiao;
    @BindView(R.id.tv_diqu)
    TextView tvDiqu;
    @BindView(R.id.btn_diqu)
    Button btnDiqu;
    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.tv_end)
    TextView tvEnd;
    @BindView(R.id.btn_clear)
    Button btnClear;
    private CustomPopWindow mCustomPopWindow;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liang_ku_cang_chu_qing_kuang);
        ButterKnife.bind(this);
        mContext = getApplicationContext();

        setTitle("粮库仓储情况");
    }

    @OnClick(R.id.btn_zhibiao)
    public void onBtnZhibiaoClicked() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.btn_zhibiao, null);
        //处理popWindow 显示内容
        handleLogic(contentView);
        //创建并显示popWindow
        mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .create()
                .showAsDropDown(btnZhibiao, 0, 20);
    }

    /**
     * 处理弹出显示内容、点击事件等逻辑
     *
     * @param contentView
     */
    private void handleLogic(View contentView) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCustomPopWindow != null) {
                    mCustomPopWindow.dissmiss();
                }

                Button btn = (Button) v;

                String showContent = "";
                showContent = btn.getText().toString();
                tvZhibiao.setText(showContent);

                ToastUtils.showShort(mContext, "选择指标 " + showContent);
            }
        };
        contentView.findViewById(R.id.menu1).setOnClickListener(listener);
        contentView.findViewById(R.id.menu2).setOnClickListener(listener);
        contentView.findViewById(R.id.menu3).setOnClickListener(listener);
        contentView.findViewById(R.id.menu4).setOnClickListener(listener);
        contentView.findViewById(R.id.menu5).setOnClickListener(listener);
        contentView.findViewById(R.id.menu6).setOnClickListener(listener);
        contentView.findViewById(R.id.menu7).setOnClickListener(listener);
    }


    @OnClick(R.id.btn_diqu)
    public void onBtnDiquClicked() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.btn_diqu, null);
        //处理popWindow 显示内容
        handleLogic2(contentView);
        //创建并显示popWindow
        CustomPopWindow mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .create()
                .showAsDropDown(btnDiqu, 0, 20);
    }

    /**
     * 处理弹出显示内容、点击事件等逻辑
     *
     * @param contentView
     */
    private void handleLogic2(View contentView) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCustomPopWindow != null) {
                    mCustomPopWindow.dissmiss();
                }

                Button btn = (Button) v;

                String showContent = "";
                showContent = btn.getText().toString();
                tvDiqu.setText(showContent);

                ToastUtils.showShort(mContext, "选择地区 " + showContent);
            }
        };

        contentView.findViewById(R.id.menu11).setOnClickListener(listener);
        contentView.findViewById(R.id.menu12).setOnClickListener(listener);
        contentView.findViewById(R.id.menu13).setOnClickListener(listener);
        contentView.findViewById(R.id.menu14).setOnClickListener(listener);
        contentView.findViewById(R.id.menu15).setOnClickListener(listener);
        contentView.findViewById(R.id.menu16).setOnClickListener(listener);
        contentView.findViewById(R.id.menu17).setOnClickListener(listener);
        contentView.findViewById(R.id.menu18).setOnClickListener(listener);
        contentView.findViewById(R.id.menu19).setOnClickListener(listener);
        contentView.findViewById(R.id.menu20).setOnClickListener(listener);
        contentView.findViewById(R.id.menu21).setOnClickListener(listener);
        contentView.findViewById(R.id.menu22).setOnClickListener(listener);
    }


    int year = 2018;
    int month = 1;
    int day = 2;

    @OnClick(R.id.tv_start)
    public void onTvStartClicked() {
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                LiangKuCangChuQingKuangActivity.this.year = year;
                month = monthOfYear;
                day = dayOfMonth;
                tvStart.setText(year + "-" + month + "-" + day);
            }
        }, 2018, 1, 2).show();

        tvStart.setText(year + "-" + month + "-" + day);
    }

    @OnClick(R.id.tv_end)
    public void onTvEndClicked() {
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                LiangKuCangChuQingKuangActivity.this.year = year;
                month = monthOfYear;
                day = dayOfMonth;
                tvEnd.setText(year + "-" + month + "-" + day);
            }
        }, 2018, 1, 2).show();

        tvEnd.setText(year + "-" + month + "-" + day);
    }

    @OnClick(R.id.btn_clear)
    public void onViewClicked() {
        tvStart.setText("选择开始日期");
        tvEnd.setText("选择结束日期");
    }
}
