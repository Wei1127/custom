package com.example.mycommerce.persenter.kuangown;

import com.example.mycommerce.base.BasePersenter;
import com.example.mycommerce.bean.ownbean.DengLuBean;
import com.example.mycommerce.bean.ownbean.UserLogBean;
import com.example.mycommerce.bean.ownbean.VerticalBean;
import com.example.mycommerce.common.CommonSubscriber;
import com.example.mycommerce.interfaces.Kuangown.IKuangOwn;
import com.example.mycommerce.interfaces.own.IOwn;
import com.example.mycommerce.model.HttpManager;
import com.example.mycommerce.utils.RxUtils;

import java.util.Map;


public class KuangOwnPersenter extends BasePersenter<IKuangOwn.View> implements IKuangOwn.Persenter {

    @Override
    public void getUserLog(Map<String, String> map) {
        addSubscribe(HttpManager.getInstance().geIKuangOwnTpApi().getVertical(map)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<UserLogBean>(mView) {
                    @Override
                    public void onNext(UserLogBean hanFuDaBean) {
                        mView.getUserLog(hanFuDaBean);
                    }
                }));
    }

    @Override
    public void getDengLu(Map<String, String> map) {
        addSubscribe(HttpManager.getInstance().geIKuangOwnTpApi().getDengLu(map)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<UserLogBean>(mView) {
                    @Override
                    public void onNext(UserLogBean hanFuDaBean) {
                        mView.getDengLu(hanFuDaBean);
                    }
                }));
    }
}
