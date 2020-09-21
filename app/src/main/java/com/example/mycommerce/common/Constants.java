package com.example.mycommerce.common;



import com.example.mycommerce.app.MyApp;
import com.example.mycommerce.bean.homebean.BannerBean;

import java.io.File;
import java.util.List;

public class Constants {
    ///http://169.254.96.147:8085home/content     http://169.254.111.136:8085
    public static final String Base_TPUrl = "http://cdwan.cn/api/";

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.app.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/commerce";

    public static List<BannerBean.DataBean.NewProductListBean> setablish;

    public static final String Base_Url = "http://cdwan.cn/api/";











}