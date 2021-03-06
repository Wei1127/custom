package com.example.mycommerce.ui.kuangown;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mycommerce.R;
import com.example.mycommerce.base.BaseFragment;
import com.example.mycommerce.interfaces.IBasePersenter;
import com.example.mycommerce.ui.kuangown.activity.LoginActivity;
import com.example.mycommerce.utils.SpUtils;

import java.time.Instant;

import butterknife.BindView;
import butterknife.OnClick;


public class KuangOwnFragment extends BaseFragment {


    @BindView(R.id.iv_denglu)
    ImageView ivDenglu;
    @BindView(R.id.tv_denglv)
    TextView tvDenglv;
    @BindView(R.id.ll_denglu)
    LinearLayout llDenglu;
    @BindView(R.id.dindgan)
    LinearLayout dindgan;
    @BindView(R.id.youhui)
    LinearLayout youhui;
    @BindView(R.id.lipinka)
    LinearLayout lipinka;
    @BindView(R.id.linearLayout2)
    LinearLayout linearLayout2;
    @BindView(R.id.shoucang)
    LinearLayout shoucang;
    @BindView(R.id.zuji)
    LinearLayout zuji;
    @BindView(R.id.fuli)
    LinearLayout fuli;
    @BindView(R.id.linearLayout3)
    LinearLayout linearLayout3;
    @BindView(R.id.dizhi)
    LinearLayout dizhi;
    @BindView(R.id.anquan)
    LinearLayout anquan;
    @BindView(R.id.kefu)
    LinearLayout kefu;
    @BindView(R.id.linearLayout6)
    LinearLayout linearLayout6;
    @BindView(R.id.bangzhu)
    LinearLayout bangzhu;
    @BindView(R.id.yijian)
    LinearLayout yijian;

    @Override
    protected int getLayout() {
        return R.layout.fragment_kuang_own;
    }

    @Override
    protected void initView() {

            String username = SpUtils.getInstance().getString("username");
            tvDenglv.setText(username);


    }

    @Override
    protected IBasePersenter initPersenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.ll_denglu)
    public void onViewClicked() {
        Intent integer = new Intent(context, LoginActivity.class);
        startActivityForResult(integer, 2);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            String username = SpUtils.getInstance().getString("username");
            tvDenglv.setText(username);
        }
    }
}