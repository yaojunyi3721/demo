package com.chinaitop.linxia.demo.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.chinaitop.linxia.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BaoSongActivity extends BaseActivity {

    @BindView(R.id.image_view)
    ImageView imageView;
    @BindView(R.id.btn_xiaomai)
    Button btnXiaomai;
    @BindView(R.id.btn_yumi)
    Button btnYumi;
    @BindView(R.id.btn_mianfen)
    Button btnMianfen;
    @BindView(R.id.btn_dami)
    Button btnDami;
    @BindView(R.id.btn_huashengyou)
    Button btnHuashengyou;
    @BindView(R.id.btn_douyou)
    Button btnDouyou;
    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.tv_end)
    TextView tvEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_song);
        ButterKnife.bind(this);

        setTitle("价格报送");
    }

    @OnClick(R.id.btn_xiaomai)
    public void onBtnXiaomaiClicked() {
        imageView.setImageResource(R.mipmap.jgbs_1xiaomai);
    }

    @OnClick(R.id.btn_yumi)
    public void onBtnYumiClicked() {
        imageView.setImageResource(R.mipmap.jgbs_2yumi);
    }

    @OnClick(R.id.btn_mianfen)
    public void onBtnMianfenClicked() {
        imageView.setImageResource(R.mipmap.jgbs_3mianfen);
    }

    @OnClick(R.id.btn_dami)
    public void onBtnDamiClicked() {
        imageView.setImageResource(R.mipmap.jgbs_4dami);
    }

    @OnClick(R.id.btn_huashengyou)
    public void onBtnHuashengyouClicked() {
        imageView.setImageResource(R.mipmap.jgbs_5huashengyou);
    }

    @OnClick(R.id.btn_douyou)
    public void onBtnDouyouClicked() {
        imageView.setImageResource(R.mipmap.jgbs_6douyou);
    }


    int year = 2018;
    int month = 1;
    int day = 2;

    @OnClick(R.id.tv_start)
    public void onTvStartClicked() {
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                BaoSongActivity.this.year = year;
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
                BaoSongActivity.this.year = year;
                month = monthOfYear;
                day = dayOfMonth;
                tvEnd.setText(year + "-" + month + "-" + day);
            }
        }, 2018, 1, 2).show();

        tvEnd.setText(year + "-" + month + "-" + day);
    }
}
