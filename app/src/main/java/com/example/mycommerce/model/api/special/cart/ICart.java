package com.example.mycommerce.model.api.special.cart;

import com.example.mycommerce.bean.GoWoChe.CartBean;
import com.example.mycommerce.bean.GoWoChe.DeleteCartBean;
import com.example.mycommerce.bean.specialbean.AddCartInfoBean;
import com.example.mycommerce.bean.specialbean.AdressBean;
import com.example.mycommerce.bean.specialbean.GoodDetailBean;
import com.example.mycommerce.interfaces.IBasePersenter;
import com.example.mycommerce.interfaces.IBaseView;
import com.example.mycommerce.interfaces.Kuangown.IKuangOwn;

public interface ICart {
    interface IView extends IBaseView {

        void getGoodDetailReturn(GoodDetailBean result);
        void addCartInfoReturn(AddCartInfoBean result);

    }

    interface IPersenter extends IBasePersenter<IView> {
        void getGoodDetail(int id);
        void addCart(int goodsId,int number,int productId);
    }


    interface ICartView extends IBaseView{
        void getCartListReturn(CartBean result);

        void deleteCartListReturn(DeleteCartBean result);
    }

    interface ICartPersenter extends IBasePersenter<ICartView>{

        //获取购物车的数据
        void getCartList();

        //删除购物车数据
        void deleteCartList(String productIds);

    }

    interface IAdressView extends IBaseView{
        void getAdressByIdReturn(AdressBean result);
    }

    interface IAdressPersenter extends IBasePersenter<IAdressView>{
        void getAdressById(int parentId);
    }


}
