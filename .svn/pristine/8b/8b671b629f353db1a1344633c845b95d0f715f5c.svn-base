package com.chinaitop.linxia.demo.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.utils.ETUtils;
import com.chinaitop.linxia.demo.utils.SPConstant;
import com.chinaitop.linxia.demo.utils.SPUtils;
import com.chinaitop.linxia.demo.utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.tv_name)
    EditText tvName;
    @BindView(R.id.tv_psw)
    EditText tvPsw;
    @BindView(R.id.cb_save)
    CheckBox cbSave;
    @BindView(R.id.btn_login)
    Button btnLogin;
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String name = ETUtils.getInputData(tvName);
            String psw = ETUtils.getInputData(tvPsw);
            //账号密码不为空
            btnLogin.setEnabled(!StringUtils.isEmpty(name) &&
                    !StringUtils.isEmpty(psw));
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在登录...");
    }

    private void initView() {
        getWindow().setBackgroundDrawable(null);
        //文字监听
        tvName.addTextChangedListener(textWatcher);
        tvPsw.addTextChangedListener(textWatcher);
        //是否记住密码
        cbSave.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    SPUtils.add(SPConstant.IS_SAVE, "1");
                } else {
                    SPUtils.add(SPConstant.IS_SAVE, "2");
                }
            }
        });

        //显示上次存储的账号密码
        tvName.setText(SPUtils.get(SPConstant.ACC_NUM));
        boolean isSave = "1".equals(SPUtils.get(SPConstant.IS_SAVE));
        if (isSave)
            tvPsw.setText(SPUtils.get(SPConstant.PSW));
        cbSave.setChecked(isSave);
        tvName.setText("admin");
        tvPsw.setText("admin");
    }

    @OnClick({R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                //登录并保存账号密码
                login();
                break;
        }
    }

    private void login() {
//        progressDialog.show();
        if (tvName.getText().toString().equals("admin") && tvPsw.getText().toString().equals("admin")) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show();
        }
    }

}
