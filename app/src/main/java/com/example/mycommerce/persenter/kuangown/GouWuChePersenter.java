package com.example.mycommerce.persenter.kuangown;

import com.example.mycommerce.base.BasePersenter;
import com.example.mycommerce.bean.GoWoChe.CartBean;
import com.example.mycommerce.bean.GoWoChe.DeleteCartBean;
import com.example.mycommerce.common.CommonSubscriber;
import com.example.mycommerce.interfaces.Kuangown.IKuangOwn;
import com.example.mycommerce.model.HttpManager;
import com.example.mycommerce.model.api.special.cart.ICart;
import com.example.mycommerce.utils.RxUtils;

public class GouWuChePersenter extends BasePersenter<ICart.ICartView> implements ICart.ICartPersenter {

    @Override
    public void getCartList() {
        addSubscribe(HttpManager.getInstance().getMallApi().getCartList()
                .compose(RxUtils.<CartBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<CartBean>(mView) {
                    @Override
                    public void onNext(CartBean result) {
                        mView.getCartListReturn(result);
                    }
                }));
    }

    @Override
    public void deleteCartList(String productIds) {
        addSubscribe(HttpManager.getInstance().getMallApi().cartDelete(productIds)
                .compose(RxUtils.<DeleteCartBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<DeleteCartBean>(mView) {
                    @Override
                    public void onNext(DeleteCartBean result) {
                        mView.deleteCartListReturn(result);
                    }
                }));
    }
}
