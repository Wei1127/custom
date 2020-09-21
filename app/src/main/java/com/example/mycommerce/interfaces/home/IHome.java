package com.example.mycommerce.interfaces.home;


import com.example.mycommerce.bean.homebean.BannerBean;
import com.example.mycommerce.bean.homebean.HotProductListBean;
import com.example.mycommerce.bean.homebean.NewProductListBean;
import com.example.mycommerce.bean.homebean.ProductCateListBean;
import com.example.mycommerce.bean.homebean.RecommendProductListBean;
import com.example.mycommerce.bean.homebean.SubjectListBean;
import com.example.mycommerce.interfaces.IBasePersenter;
import com.example.mycommerce.interfaces.IBaseView;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IHome {

    interface View extends IBaseView {
        //banner
        void homebanner(BannerBean userBean);

        ///   home/hotProductList  分页获取人气推荐商品
        void getHotProductList(HotProductListBean userBean);

        //  home/newProductList  分页获取新品推荐商品
        void getNewProductList(NewProductListBean userBean);

        // home/recommendProductList     分页获取推荐商品
        void getRecommendProductList(RecommendProductListBean userBean);




    }

    interface Persenter extends IBasePersenter<View> {
        //banner
        void homebanner();

        ///   home/hotProductList  分页获取人气推荐商品
        void getHotProductList();

        //  home/newProductList  分页获取新品推荐商品
        void getNewProductList();



        // home/recommendProductList     分页获取推荐商品
        void getRecommendProductList();


    }




}
