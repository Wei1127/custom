package com.example.mycommerce.model.api.sort;

import com.example.mycommerce.bean.homebean.ProductCateListBean;
import com.example.mycommerce.bean.homebean.SubjectListBean;
import com.example.mycommerce.bean.ownbean.VerticalBean;
import com.example.mycommerce.bean.sortbean.CategoryTreeListBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SortTpApi {
    // home/subjectList  根据分类获取专题
    @GET("home/subjectList")
    Flowable<SubjectListBean> getSubjectList();


    //  home/productCateList/{parentId}  获取首页商品分类
    @GET("home/productCateList/{parentId}")
    Flowable<ProductCateListBean> getNewProductCateList(@Path("type") int type);



    ///product/categoryTreeList
    @GET("product/categoryTreeList")
    Flowable<CategoryTreeListBean> getCategoryTreeListB();

    @GET("catalog/index")
    Flowable<VerticalBean> getVertical();


}
