package com.example.mycommerce;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mycommerce.adapter.FragmentAdapter;
import com.example.mycommerce.ui.home.HomeFragment;
import com.example.mycommerce.ui.kuangown.KuangOwnFragment;
import com.example.mycommerce.ui.kuangshopping.KuangShoppFragment;
import com.example.mycommerce.ui.own.OwnFragment;
import com.example.mycommerce.ui.sort.SortFragment;
import com.example.mycommerce.ui.special.SpecialFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KuangActivity extends AppCompatActivity {


    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private ArrayList<Fragment> fragments;
    private FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuang);
        ButterKnife.bind(this);
        ButterKnife.bind(this);

        fragments = new ArrayList<>();
        //首页
        fragments.add(new SpecialFragment());
        //分类
        fragments.add(new OwnFragment());
        //专题
        fragments.add(new KuangShoppFragment());
        //我的
        fragments.add(new KuangOwnFragment());

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("首页").setIcon(R.drawable.tab4);
        tabLayout.getTabAt(1).setText("分类").setIcon(R.drawable.tab3);
        tabLayout.getTabAt(2).setText("专题").setIcon(R.drawable.tab2);
        tabLayout.getTabAt(3).setText("我的").setIcon(R.drawable.tab1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1000){
            tabLayout.getTabAt(2).select();
        }

    }


}