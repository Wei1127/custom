package com.example.mycommerce.ui.own;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mycommerce.R;
import com.example.mycommerce.base.BaseFragment;
import com.example.mycommerce.bean.ownbean.VerticalBean;
import com.example.mycommerce.interfaces.IBasePersenter;
import com.example.mycommerce.interfaces.own.IOwn;
import com.example.mycommerce.interfaces.sort.ISort;
import com.example.mycommerce.persenter.own.OwnPersenter;
import com.example.mycommerce.persenter.sort.HomePersenter;
import com.example.mycommerce.ui.own.fragment.vcount2;
import com.example.mycommerce.ui.sort.vcount;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;

public class OwnFragment extends BaseFragment<IOwn.Persenter> implements IOwn.View {
    @BindView(R.id.tablayout)
    VerticalTabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected int getLayout() {
        return R.layout.fragment_own;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected IOwn.Persenter initPersenter() {
        return new OwnPersenter();
    }


    @Override
    protected void initData() {
 //       persenter.getSubjectone();
    }

    @Override
    public void getVertical(VerticalBean userBean) {
        ArrayList<Fragment> list = new ArrayList<>();
        List<VerticalBean.DataBean.CurrentCategoryBean> currentCategoryBeans = new ArrayList<>();
        for (int i = 0; i < userBean.getData().getCategoryList().size(); i++) {
            currentCategoryBeans.add(userBean.getData().getCurrentCategory());
            list.add(new vcount2(currentCategoryBeans));
        }
        tablayout.setTabHeight(90);
        viewpager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return userBean.getData().getCategoryList().get(position).getName();

            }
        });
        tablayout.setupWithViewPager(viewpager);
    }
}