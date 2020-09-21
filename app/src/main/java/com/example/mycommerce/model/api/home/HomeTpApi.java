package com.example.mycommerce.model.api.home;


import com.example.mycommerce.bean.homebean.BannerBean;
import com.example.mycommerce.bean.homebean.HotProductListBean;
import com.example.mycommerce.bean.homebean.NewProductListBean;
import com.example.mycommerce.bean.homebean.ProductCateListBean;
import com.example.mycommerce.bean.homebean.RecommendProductListBean;
import com.example.mycommerce.bean.homebean.SubjectListBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HomeTpApi {

    //home/content  banner
    @GET("home/content")
    Flowable<BannerBean> getBanner();

    ///   home/hotProductList  分页获取人气推荐商品
    @GET("home/hotProductList")
    Flowable<HotProductListBean> getHotProductList();

    //  home/newProductList  分页获取新品推荐商品
    @GET("home/newProductList")
    Flowable<NewProductListBean> getNewProductList();

    //  home/productCateList/{parentId}  获取首页商品分类
    @GET("home/productCateList/{parentId}")
    Flowable<ProductCateListBean> getNewProductCateList(@Path("type") int type);

    // home/recommendProductList     分页获取推荐商品
    @GET("home/recommendProductList")
    Flowable<RecommendProductListBean> getRecommendProductList();


}
