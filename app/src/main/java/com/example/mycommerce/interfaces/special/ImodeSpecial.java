package com.example.mycommerce.interfaces.special;

import com.example.mycommerce.bean.specialbean.HomeBean;
import com.example.mycommerce.interfaces.IBasePersenter;
import com.example.mycommerce.interfaces.IBaseView;

import java.util.List;

public interface ImodeSpecial {
    interface IView extends IBaseView {
        void getHomeDataReturn(List<HomeBean.HomeListBean> result);
    }

    interface IPersenter extends IBasePersenter<IView> {
        void getHomeData();
    }
}
