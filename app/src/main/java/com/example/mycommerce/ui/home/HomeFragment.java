package com.example.mycommerce.ui.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.mycommerce.R;
import com.example.mycommerce.adapter.homeadapter.FreshAdapter;
import com.example.mycommerce.adapter.homeadapter.GridHelperAdapter;
import com.example.mycommerce.adapter.homeadapter.LinearAdapter;
import com.example.mycommerce.adapter.homeadapter.RecommendAdapter;
import com.example.mycommerce.adapter.homeadapter.SiftAdapter;
import com.example.mycommerce.base.BaseFragment;
import com.example.mycommerce.bean.homebean.BannerBean;
import com.example.mycommerce.bean.homebean.HotProductListBean;
import com.example.mycommerce.bean.homebean.NewProductListBean;
import com.example.mycommerce.bean.homebean.ProductCateListBean;
import com.example.mycommerce.bean.homebean.RecommendProductListBean;
import com.example.mycommerce.bean.homebean.SubjectListBean;
import com.example.mycommerce.common.Constants;
import com.example.mycommerce.interfaces.home.IHome;
import com.example.mycommerce.persenter.home.HomePersenter;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class HomeFragment extends BaseFragment<IHome.Persenter> implements IHome.View {




    @BindView(R.id.bann)
    Banner bann;
    @BindView(R.id.vf)
    ViewFlipper vf;
    @BindView(R.id.huati)
    TextView huati;
    @BindView(R.id.youxuan)
    TextView youxuan;
    @BindView(R.id.tehui)
    TextView tehui;
    @BindView(R.id.qiandao)
    TextView qiandao;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.home_rv)
    RecyclerView homeRv;
    private List<BannerBean.DataBean.NewProductListBean> newProductListBeans;
    private List<RecommendProductListBean.DataBean> dataBeans;
    private List<BannerBean.DataBean.HotProductListBean> hotProductListBeans;


    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

        vf.addView(View.inflate(getActivity(), R.layout.view_advertisement01, null));
        vf.addView(View.inflate(getActivity(), R.layout.view_advertisement01, null));
        vf.addView(View.inflate(getActivity(), R.layout.view_advertisement01, null));
        // 创建RecyclerView对象
 /*
           默认通用布局实现，解耦所有的View和布局之间的关系: Linear, Grid, 吸顶, 浮动, 固定位置等。
            LinearLayoutHelper: 线性布局
            GridLayoutHelper: Grid布局， 支持横向的colspan
            FixLayoutHelper: 固定布局，始终在屏幕固定位置显示
            ScrollFixLayoutHelper: 固定布局，但之后当页面滑动到该图片区域才显示, 可以用来做返回顶部或其他书签等
            FloatLayoutHelper: 浮动布局，可以固定显示在屏幕上，但用户可以拖拽其位置
            ?./?
            SingleLayoutHelper: 通栏布局，只会显示一个组件View
            OnePlusNLayoutHelper: 一拖N布局，可以配置1-5个子元素
            StickyLayoutHelper: stikcy布局， 可以配置吸顶或者吸底
            StaggeredGridLayoutHelper: 瀑布流布局，可配置间隔高度/宽度
        * */
        //布局管理器
        VirtualLayoutManager linearLayoutManager = new VirtualLayoutManager(context){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        //开始
        DelegateAdapter delegateAdapter = new DelegateAdapter(linearLayoutManager, false);
        homeRv.setLayoutManager(linearLayoutManager);
        homeRv.setAdapter(delegateAdapter);
        List<Integer> integers = new ArrayList<>();
        integers.add(4);
        //item_1
//        GridLayoutHelper gridHelper = new GridLayoutHelper(2);
//        gridHelper.setMarginTop(30);
//        gridHelper.setWeights(new float[]{20.0f,20.0f,20.0f,20.0f,20.0f});
//        //设置垂直方向条目的间隔
//        gridHelper.setVGap(5);
//        //设置水平方向条目的间隔
//        gridHelper.setHGap(5);
//        gridHelper.setMarginLeft(30);
//        gridHelper.setMarginBottom(30);
//        //自动填充满布局，在设置完权重，若没有占满，自动填充满布局
//        gridHelper.setAutoExpand(true);


        //item_1
//        //Linear 布局
        LinearLayoutHelper linearHelper1 = new LinearLayoutHelper();
        //新鲜好物
        newProductListBeans = new ArrayList<>();
        //新鲜好物
        delegateAdapter.addAdapter(new GridHelperAdapter(newProductListBeans,linearHelper1,getActivity()));
        //秒杀专区
        hotProductListBeans = new ArrayList<>();
        delegateAdapter.addAdapter(new LinearAdapter(getActivity(),linearHelper1,hotProductListBeans));

        delegateAdapter.addAdapter(new FreshAdapter(linearHelper1,getActivity()));
        dataBeans = new ArrayList<>();
        //人气推荐
        delegateAdapter.addAdapter(new RecommendAdapter(linearHelper1,getActivity(),dataBeans));

        delegateAdapter.addAdapter(new SiftAdapter(linearHelper1,getActivity()));
    }

    @Override
    protected IHome.Persenter initPersenter() {
        return new HomePersenter();
    }


    @Override
    protected void initData() {
      persenter.homebanner();
      persenter.getRecommendProductList();
    }


    //点击事件
    @OnClick({R.id.huati, R.id.youxuan, R.id.tehui, R.id.qiandao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.huati: {
                break;
            }
            case R.id.youxuan: {
                break;
            }
            case R.id.tehui: {
                break;
            }
            case R.id.qiandao: {
                break;
            }
        }
    }

    //banner
    @Override
    public void homebanner(BannerBean userBean) {

        //人气推荐
        List<BannerBean.DataBean.NewProductListBean> newProductList = userBean.getData().getNewProductList();
        newProductListBeans.addAll(newProductList);
        //秒杀专区
        List<BannerBean.DataBean.HotProductListBean> hotProductList = userBean.getData().getHotProductList();
        hotProductListBeans.addAll(hotProductList);

        if (userBean.getCode() == 200) {
            //初始化banner
            List<String> bannerUrls = new ArrayList<>();
            if (userBean.getData().getAdvertiseList().size() > 0) {
                for (int i = 0; i < userBean.getData().getAdvertiseList().size(); i++) {
                    bannerUrls.add(userBean.getData().getAdvertiseList().get(i).getPic());
                }
            }

            bann.setAdapter(new BannerImageAdapter<String>(bannerUrls) {
                @Override
                public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                    //图片加载自己实现
                    Glide.with(holder.itemView)
                            .load(data)
                            .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                            .into(holder.imageView);
                }
            })
                    .addBannerLifecycleObserver(this)//添加生命周期观察者
                    .setIndicator(new CircleIndicator(context));
        }
    }

    ///   home/hotProductList  分页获取人气推荐商品
    @Override
    public void getHotProductList(HotProductListBean userBean) {



    }

    //  home/newProductList  分页获取新品推荐商品
    @Override
    public void getNewProductList(NewProductListBean userBean) {

    }


    // home/recommendProductList     分页获取推荐商品
    @Override
    public void getRecommendProductList(RecommendProductListBean userBean) {
        List<RecommendProductListBean.DataBean> data = userBean.getData();
        dataBeans.addAll(data);
    }

    // home/subjectList  根据分类获取专题


}