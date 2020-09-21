package com.example.mycommerce.interfaces.own;

import com.example.mycommerce.bean.homebean.ProductCateListBean;
import com.example.mycommerce.bean.homebean.SubjectListBean;
import com.example.mycommerce.bean.ownbean.VerticalBean;
import com.example.mycommerce.bean.sortbean.CategoryTreeListBean;
import com.example.mycommerce.interfaces.IBasePersenter;
import com.example.mycommerce.interfaces.IBaseView;
import com.example.mycommerce.interfaces.sort.ISort;

public interface IOwn {

    interface View extends IBaseView {

        void getVertical(VerticalBean userBean);
    }


    interface Persenter extends IBasePersenter<IOwn.View> {

        void getSubjectone();
    }
}
