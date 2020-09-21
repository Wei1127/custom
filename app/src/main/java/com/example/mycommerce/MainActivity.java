package com.example.mycommerce;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mycommerce.adapter.FragmentAdapter;
import com.example.mycommerce.ui.home.HomeFragment;
import com.example.mycommerce.ui.own.OwnFragment;
import com.example.mycommerce.ui.sort.SortFragment;
import com.example.mycommerce.ui.special.SpecialFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar2)
    Toolbar toolbar2;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.tvneirong)
    TextView tvneirong;
    @BindView(R.id.shopping2)
    ImageView shopping;
    @BindView(R.id.dousuo)
    ImageView dousuo;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private ArrayList<Fragment> fragments;
    private FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragments = new ArrayList<>();
        //首页
        fragments.add(new HomeFragment());
        //分类
        fragments.add(new SortFragment());
        //专题
        fragments.add(new SpecialFragment());
        //我的
        fragments.add(new OwnFragment());

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("首页").setIcon(R.drawable.tab4);
        tabLayout.getTabAt(1).setText("分类").setIcon(R.drawable.tab3);
        tabLayout.getTabAt(2).setText("专题").setIcon(R.drawable.tab2);
        tabLayout.getTabAt(3).setText("我的").setIcon(R.drawable.tab1);

    }


    @OnClick({R.id.imageView, R.id.dousuo, R.id.shopping2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView:

                break;
            case R.id.dousuo:
                break;
            case R.id.shopping2:
                break;
        }
    }
}