package com.example.mycommerce.interfaces.Kuangown;

import com.example.mycommerce.bean.GoWoChe.CartBean;
import com.example.mycommerce.bean.GoWoChe.DeleteCartBean;
import com.example.mycommerce.bean.ownbean.DengLuBean;
import com.example.mycommerce.bean.ownbean.UserLogBean;
import com.example.mycommerce.bean.ownbean.VerticalBean;
import com.example.mycommerce.interfaces.IBasePersenter;
import com.example.mycommerce.interfaces.IBaseView;
import com.example.mycommerce.interfaces.own.IOwn;

import java.util.Map;

public interface IKuangOwn {
    interface View extends IBaseView {

        void getUserLog(UserLogBean userBean);
        void getDengLu(UserLogBean userBean);
    }


    interface Persenter extends IBasePersenter<IKuangOwn.View> {

        void getUserLog(Map<String,String> map);

        void getDengLu(Map<String,String> map);
    }

}
