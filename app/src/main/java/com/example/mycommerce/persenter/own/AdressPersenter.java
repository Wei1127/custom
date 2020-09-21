package com.example.mycommerce.persenter.own;


import com.example.mycommerce.base.BasePersenter;
import com.example.mycommerce.bean.specialbean.AdressBean;
import com.example.mycommerce.common.CommonSubscriber;
import com.example.mycommerce.model.HttpManager;
import com.example.mycommerce.model.api.special.cart.ICart;
import com.example.mycommerce.utils.RxUtils;

public class AdressPersenter extends BasePersenter<ICart.IAdressView> implements ICart.IAdressPersenter {
    @Override
    public void getAdressById(int parentId) {
        addSubscribe(HttpManager.getInstance().getMallApi().getAdressById(parentId)
                .compose(RxUtils.<AdressBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<AdressBean>(mView) {
                    @Override
                    public void onNext(AdressBean result) {
                        mView.getAdressByIdReturn(result);
                    }
                }));
    }
}
