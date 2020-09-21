package com.example.mycommerce.ui.sort;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mycommerce.R;
import com.example.mycommerce.base.BaseFragment;
import com.example.mycommerce.bean.homebean.ProductCateListBean;
import com.example.mycommerce.bean.homebean.SubjectListBean;
import com.example.mycommerce.bean.sortbean.CategoryTreeListBean;
import com.example.mycommerce.interfaces.sort.ISort;
import com.example.mycommerce.persenter.sort.HomePersenter;

import java.util.ArrayList;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;

public class SortFragment extends BaseFragment<ISort.Persenter> implements ISort.View {
    @BindView(R.id.tablayout)
    VerticalTabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected int getLayout() {
        return R.layout.fragment_sort;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected ISort.Persenter initPersenter() {
        return new HomePersenter();
    }

    @Override
    protected void initData() {
        persenter.getCategoryTreeListB();
    }

    @Override
    public void getSubjectList(SubjectListBean userBean) {


    }

    @Override
    public void getNewProductCateList(ProductCateListBean userBean) {

    }

    @Override
    public void getCategoryTreeListB(CategoryTreeListBean userBean) {
        ArrayList<Fragment> list = new ArrayList<>();
        for (int i = 0; i < userBean.getData().size(); i++) {
            list.add(new vcount(userBean.getData().get(i).getChildren()));
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
                return userBean.getData().get(position).getName();

            }
        });
        tablayout.setupWithViewPager(viewpager);


    }
}