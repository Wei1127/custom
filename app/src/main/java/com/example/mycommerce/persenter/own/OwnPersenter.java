package com.example.mycommerce.persenter.own;

import com.example.mycommerce.base.BasePersenter;
import com.example.mycommerce.bean.homebean.ProductCateListBean;
import com.example.mycommerce.bean.homebean.SubjectListBean;
import com.example.mycommerce.bean.ownbean.VerticalBean;
import com.example.mycommerce.bean.sortbean.CategoryTreeListBean;
import com.example.mycommerce.common.CommonSubscriber;
import com.example.mycommerce.interfaces.own.IOwn;
import com.example.mycommerce.interfaces.sort.ISort;
import com.example.mycommerce.model.HttpManager;
import com.example.mycommerce.utils.RxUtils;


public class OwnPersenter extends BasePersenter<IOwn.View> implements IOwn.Persenter {


    @Override
    public void getSubjectone() {
        addSubscribe(HttpManager.getInstance().getStApi().getVertical()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<VerticalBean>(mView) {
                    @Override
                    public void onNext(VerticalBean hanFuDaBean) {
                        mView.getVertical(hanFuDaBean);
                    }
                }));
    }
}
