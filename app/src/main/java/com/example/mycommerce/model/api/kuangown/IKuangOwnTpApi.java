package com.example.mycommerce.model.api.kuangown;

import com.example.mycommerce.bean.GoWoChe.DeleteCartBean;
import com.example.mycommerce.bean.ownbean.DengLuBean;
import com.example.mycommerce.bean.ownbean.UserLogBean;
import com.example.mycommerce.bean.ownbean.VerticalBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IKuangOwnTpApi {
    @POST("auth/login")
    @FormUrlEncoded
    Flowable<UserLogBean> getVertical(@FieldMap Map<String, String> map);



    @POST("auth/register")
    @FormUrlEncoded
    Flowable<UserLogBean> getDengLu(@FieldMap Map<String, String> map);



}
