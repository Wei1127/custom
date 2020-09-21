package com.example.mycommerce.persenter.home;

import android.util.Log;

import com.example.mycommerce.base.BasePersenter;
import com.example.mycommerce.bean.homebean.BannerBean;
import com.example.mycommerce.bean.homebean.HotProductListBean;
import com.example.mycommerce.bean.homebean.NewProductListBean;
import com.example.mycommerce.bean.homebean.ProductCateListBean;
import com.example.mycommerce.bean.homebean.RecommendProductListBean;
import com.example.mycommerce.bean.homebean.SubjectListBean;
import com.example.mycommerce.common.CommonSubscriber;
import com.example.mycommerce.interfaces.home.IHome;
import com.example.mycommerce.model.HttpManager;
import com.example.mycommerce.utils.RxUtils;


public class HomePersenter extends BasePersenter<IHome.View> implements IHome.Persenter {


    //首页banner的网络请求
    @Override
    public void homebanner() {
        addSubscribe(HttpManager.getInstance().getTpApi().getBanner()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<BannerBean>(mView) {
                    @Override
                    public void onNext(BannerBean hanFuDaBean) {
                        mView.homebanner(hanFuDaBean);
                    }
                }));
    }
    ///   home/hotProductList  分页获取人气推荐商品
    @Override
    public void getHotProductList() {
        addSubscribe(HttpManager.getInstance().getTpApi().getHotProductList()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<HotProductListBean>(mView) {
                    @Override
                    public void onNext(HotProductListBean hanFuDaBean) {
                        mView.getHotProductList(hanFuDaBean);
                    }
                }));
    }

    @Override
    public void getNewProductList() {

    }



    // home/recommendProductList     分页获取推荐商品
    @Override
    public void getRecommendProductList() {
        addSubscribe(HttpManager.getInstance().getTpApi().getRecommendProductList()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<RecommendProductListBean>(mView) {
                    @Override
                    public void onNext(RecommendProductListBean hanFuDaBean) {
                        mView.getRecommendProductList(hanFuDaBean);
                    }
                }));
    }



}
