package com.example.mycommerce.model.api.own;

import com.example.mycommerce.bean.homebean.SubjectListBean;
import com.example.mycommerce.bean.ownbean.VerticalBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface OwnTpApi {
    // home/subjectList  根据分类获取专题
    @GET("catalog/index")
    Flowable<VerticalBean> getVertical();




}
