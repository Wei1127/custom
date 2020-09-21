package com.example.mycommerce.persenter.sort;

import com.example.mycommerce.base.BasePersenter;
import com.example.mycommerce.bean.homebean.BannerBean;
import com.example.mycommerce.bean.homebean.HotProductListBean;
import com.example.mycommerce.bean.homebean.NewProductListBean;
import com.example.mycommerce.bean.homebean.ProductCateListBean;
import com.example.mycommerce.bean.homebean.RecommendProductListBean;
import com.example.mycommerce.bean.homebean.SubjectListBean;
import com.example.mycommerce.bean.sortbean.CategoryTreeListBean;
import com.example.mycommerce.common.CommonSubscriber;
import com.example.mycommerce.interfaces.home.IHome;
import com.example.mycommerce.interfaces.sort.ISort;
import com.example.mycommerce.model.HttpManager;
import com.example.mycommerce.utils.RxUtils;


public class HomePersenter extends BasePersenter<ISort.View> implements ISort.Persenter {


    @Override
    public void getSubjectList() {
        addSubscribe(HttpManager.getInstance().getStApi().getSubjectList()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<SubjectListBean>(mView) {
                    @Override
                    public void onNext(SubjectListBean hanFuDaBean) {
                        mView.getSubjectList(hanFuDaBean);
                    }
                }));
    }

    @Override
    public void getNewProductCateList(int bytea) {
        addSubscribe(HttpManager.getInstance().getStApi().getNewProductCateList(bytea)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<ProductCateListBean>(mView) {
                    @Override
                    public void onNext(ProductCateListBean hanFuDaBean) {
                        mView.getNewProductCateList(hanFuDaBean);
                    }
                }));
    }

    @Override
    public void getCategoryTreeListB() {
        addSubscribe(HttpManager.getInstance().getStApi().getCategoryTreeListB()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<CategoryTreeListBean>(mView) {
                    @Override
                    public void onNext(CategoryTreeListBean hanFuDaBean) {
                        mView.getCategoryTreeListB(hanFuDaBean);
                    }
                }));
    }

}
