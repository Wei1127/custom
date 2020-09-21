package com.example.mycommerce.persenter.special.cart;


import com.example.mycommerce.base.BasePersenter;
import com.example.mycommerce.bean.specialbean.AddCartInfoBean;
import com.example.mycommerce.bean.specialbean.GoodDetailBean;
import com.example.mycommerce.common.CommonSubscriber;
import com.example.mycommerce.model.HttpManager;
import com.example.mycommerce.model.api.special.cart.ICart;
import com.example.mycommerce.utils.RxUtils;

public class CartPersenter extends BasePersenter<ICart.IView> implements ICart.IPersenter {
    @Override
    public void getGoodDetail(int id) {
        addSubscribe(HttpManager.getInstance().getMallApi().getGoodDetail(id)
                .compose(RxUtils.<GoodDetailBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<GoodDetailBean>(mView) {
                    @Override
                    public void onNext(GoodDetailBean result) {
                        mView.getGoodDetailReturn(result);
                    }
                }));
    }

    @Override
    public void addCart(int goodsId, int number, int productId) {
        addSubscribe(HttpManager.getInstance().getMallApi().addCart(goodsId,number,productId)
                .compose(RxUtils.<AddCartInfoBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<AddCartInfoBean>(mView) {
                    @Override
                    public void onNext(AddCartInfoBean result) {
                        mView.addCartInfoReturn(result);
                    }
                }));
    }

}
