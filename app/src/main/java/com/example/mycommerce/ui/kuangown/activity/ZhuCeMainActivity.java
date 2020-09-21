package com.example.mycommerce.ui.kuangown.activity;

import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mycommerce.R;
import com.example.mycommerce.base.BaseActivity;
import com.example.mycommerce.bean.ownbean.DengLuBean;
import com.example.mycommerce.bean.ownbean.UserLogBean;
import com.example.mycommerce.interfaces.IBasePersenter;
import com.example.mycommerce.interfaces.Kuangown.IKuangOwn;
import com.example.mycommerce.persenter.kuangown.KuangOwnPersenter;
import com.example.mycommerce.utils.SpUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZhuCeMainActivity extends BaseActivity<IKuangOwn.Persenter> implements IKuangOwn.View {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.txt_username)
    EditText txtUsername;
    @BindView(R.id.et_paw)
    EditText etPaw;
    @BindView(R.id.eye)
    ImageView eye;
    @BindView(R.id.ll)
    RelativeLayout ll;
    @BindView(R.id.btn_register)
    Button btnRegister;
    private String name;
    private String paw;
    @Override
    protected int getLayout() {
        return R.layout.activity_zhu_ce_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected IKuangOwn.Persenter initPersenter() {
        return new KuangOwnPersenter();
    }


    @Override
    protected void initData() {

    }



    @OnClick({R.id.iv_back, R.id.eye, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.eye:
                //显示隐藏密码
                if (etPaw.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {  //不可见
                    eye.setImageResource(R.mipmap.eye_open);
                    etPaw.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                } else {  //可见
                    etPaw.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    eye.setImageResource(R.mipmap.eye_close);
                }
                break;
            case R.id.btn_register:

                register();
                break;
        }
    }

    private void register() {
        name = txtUsername.getText().toString().trim();
        paw = etPaw.getText().toString().trim();
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(paw)) {
            Map<String, String> stringStringMap = new HashMap<>();
            stringStringMap.put("username",name);
            stringStringMap.put("password",paw);
            persenter.getDengLu(stringStringMap);
        } else {
            Toast.makeText(this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void getUserLog(UserLogBean userBean) {

    }

    @Override
    public void getDengLu(UserLogBean userBean) {
        if (200==200){
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();

            SpUtils.getInstance().setValue("username",name);
            SpUtils.getInstance().setValue("token", userBean.getData().getToken());
            SpUtils.getInstance().setValue("password",paw);
            Log.d("TAG", "getRegisterReturn: "+name+"-------------------"+paw+"-------------"+name);
            finish();
        }else {
            Toast.makeText(this,userBean.getErrno() , Toast.LENGTH_SHORT).show();
        }
    }

}