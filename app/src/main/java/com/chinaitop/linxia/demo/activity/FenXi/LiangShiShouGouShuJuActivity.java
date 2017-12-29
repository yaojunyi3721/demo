package com.chinaitop.linxia.demo.activity.FenXi;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LiangShiShouGouShuJuActivity extends BaseActivity {

    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.tv_end)
    TextView tvEnd;
    @BindView(R.id.btn_clear)
    Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liang_shi_shou_gou_shu_ju);
        ButterKnife.bind(this);

        setTitle("粮食收购数据");
    }

    int year1 = 2018;
    int month = 1;
    int day = 2;

    @OnClick(R.id.tv_start)
    public void onTvStartClicked() {
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                year1 = year;
                month = monthOfYear;
                day = dayOfMonth;
                tvStart.setText(year1 + "-" + month + "-" + day);
            }
        }, 2018, 1, 2).show();

        tvStart.setText(year1 + "-" + month + "-" + day);
    }

    @OnClick(R.id.tv_end)
    public void onTvEndClicked() {
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                year1 = year;
                month = monthOfYear;
                day = dayOfMonth;
                tvEnd.setText(year1 + "-" + month + "-" + day);
            }
        }, 2018, 1, 2).show();

        tvEnd.setText(year1 + "-" + month + "-" + day);
    }

    @OnClick(R.id.btn_clear)
    public void onViewClicked() {
        tvStart.setText("选择开始日期");
        tvEnd.setText("选择结束日期");
    }
}
