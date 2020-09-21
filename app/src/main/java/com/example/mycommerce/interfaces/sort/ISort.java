package com.example.mycommerce.interfaces.sort;

import com.example.mycommerce.bean.homebean.ProductCateListBean;
import com.example.mycommerce.bean.homebean.SubjectListBean;
import com.example.mycommerce.bean.sortbean.CategoryTreeListBean;
import com.example.mycommerce.interfaces.IBasePersenter;
import com.example.mycommerce.interfaces.IBaseView;
import com.example.mycommerce.interfaces.home.IHome;

public interface ISort {

    interface View extends IBaseView {
        // home/subjectList  根据分类获取专题
        void getSubjectList(SubjectListBean userBean);
        //  home/productCateList/{parentId}  获取首页商品分类
        void getNewProductCateList(ProductCateListBean userBean);

        void getCategoryTreeListB(CategoryTreeListBean userBean);

    }


    interface Persenter extends IBasePersenter<ISort.View> {
        // home/subjectList  根据分类获取专题
        void getSubjectList();
        //  home/productCateList/{parentId}  获取首页商品分类
        void getNewProductCateList(int bytea);

        void getCategoryTreeListB();

    }
}
