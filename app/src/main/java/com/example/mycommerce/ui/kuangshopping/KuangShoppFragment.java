package com.example.mycommerce.ui.kuangshopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycommerce.R;
import com.example.mycommerce.base.BaseFragment;
import com.example.mycommerce.bean.GoWoChe.CartBean;
import com.example.mycommerce.bean.GoWoChe.DeleteCartBean;
import com.example.mycommerce.interfaces.IBasePersenter;
import com.example.mycommerce.model.api.special.cart.ICart;
import com.example.mycommerce.persenter.kuangown.GouWuChePersenter;
import com.example.mycommerce.ui.kuangshopping.activity.SiteMainActivity;
import com.example.mycommerce.ui.kuangshopping.adapter.CartListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class KuangShoppFragment extends BaseFragment<ICart.ICartPersenter> implements ICart.ICartView  {


    @BindView(R.id.layout_top)
    FrameLayout layoutTop;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.radio_select)
    CheckBox radioSelect;
    @BindView(R.id.txt_selectAll)
    TextView txtSelectAll;
    @BindView(R.id.txt_allPrice)
    TextView txtAllPrice;
    @BindView(R.id.txt_edit)
    TextView txtEdit;
    @BindView(R.id.txt_submit)
    TextView txtSubmit;
    @BindView(R.id.layout_bottom)
    RelativeLayout layoutBottom;

    CartListAdapter cartListAdapter;
    ArrayList<CartBean.DataBean.CartListBean> list;

    private int allNumber;
    private int allPrice;
    //R.layout.fragment_kuang_shopp,
    @Override
    protected int getLayout() {
        return R.layout.fragment_kuang_shopp;
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        cartListAdapter = new CartListAdapter(context,list);
        recyclerview.setLayoutManager(new LinearLayoutManager(context));
        recyclerview.setAdapter(cartListAdapter);
        txtSelectAll.setText("全选(0)");
        cartListAdapter.setOnItemCheckBoxClickListener(new CartListAdapter.CheckBoxClick() {
            @Override
            public void checkChange() {
                //判断当前是否全选
                boolean bool = CheckSelectAll();
                txtSelectAll.setText("全选("+allNumber+")");
                txtAllPrice.setText("￥"+allPrice);
                radioSelect.setSelected(bool);
                cartListAdapter.notifyDataSetChanged();
                //    你看得见而我的屏幕么

            }
        });
    }

    @Override
    protected ICart.ICartPersenter initPersenter() {
        return new GouWuChePersenter();
    }



    @Override
    protected void initData() {
        persenter.getCartList();
    }
    private boolean CheckSelectAll(){
        allNumber = 0;
        allPrice = 0;
        boolean isSelectAll = true;
        for(CartBean.DataBean.CartListBean item:list){
            if(item.select){
                allNumber += item.getNumber();
                allPrice += item.getNumber()*item.getRetail_price();
            }
            if(isSelectAll && !item.select){
                isSelectAll = false;
            }
        }
        return isSelectAll;
    }

    @Override
    public void getCartListReturn(CartBean result) {
        list.addAll(result.getData().getCartList());
        cartListAdapter.notifyDataSetChanged();
    }

    @Override
    public void deleteCartListReturn(DeleteCartBean result) {

    }

    @OnClick({R.id.radio_select, R.id.txt_edit, R.id.txt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radio_select:
                selectAll();
                break;
            case R.id.txt_edit:
                clickEdit();
                break;
            case R.id.txt_submit:
                submitData();
                break;
        }
    }

    /**
     * 全选状态的切换
     */
    private void selectAll(){
        //设置当前是否是权限
        resetSelect(!radioSelect.isChecked());
        radioSelect.setSelected(!radioSelect.isChecked());
        txtSelectAll.setText("全选("+allNumber+")");
        txtAllPrice.setText("￥"+allPrice);
        cartListAdapter.notifyDataSetChanged();
    }

    /**
     * 编辑状态的切换
     */
    private void clickEdit(){
        //当前是默认的状态---编辑状态
        if("编辑".equals(txtEdit.getText())){
            cartListAdapter.isEditor = true;
            txtEdit.setText("完成");
            txtSubmit.setText("删除所选");
            txtAllPrice.setVisibility(View.GONE);
        }else if("完成".equals(txtEdit.getText())){   //编辑状态进入默认状态
            cartListAdapter.isEditor = false;
            txtEdit.setText("编辑");
            txtSubmit.setText("下单");
            txtAllPrice.setVisibility(View.VISIBLE);
            txtAllPrice.setText("￥0");
        }
        resetSelect(false);
        cartListAdapter.notifyDataSetChanged();
    }

    /**
     * 提交
     */
    private void submitData(){
        if("下单".equals(txtSubmit.getText())){
            //提交数据
            Intent intent = new Intent(context, SiteMainActivity.class);
            startActivity(intent);

        }else if ("删除所选".equals(txtSubmit.getText())){
            StringBuilder sb = new StringBuilder();
            List<Integer> ids = getSelectProducts();
            for(Integer id:ids){
                sb.append(id);
                sb.append(",");
            }
            if(sb.length() > 0){
                sb.deleteCharAt(sb.length()-1);
                String productIds = sb.toString();
                persenter.deleteCartList(productIds);
            }else {
                Toast.makeText(context, "没有选中要删除的商品", Toast.LENGTH_SHORT).show();
            }
        }
    }
    /**
     * 重置选中状态
     * @param bool
     */
    private void resetSelect(boolean bool){
        allNumber = 0;
        allPrice = 0;
        for(CartBean.DataBean.CartListBean item:list){
            item.select = bool;
            if(bool){
                allNumber += item.getNumber();
                allPrice += item.getNumber()*item.getRetail_price();
            }
        }
        if(!bool){
            allNumber = 0;
            allPrice = 0;
        }
    }

    /**
     * 获取当前选中的商品
     * @return
     */
    private List<Integer> getSelectProducts(){
        List<Integer> ids = new ArrayList<>();
        for(CartBean.DataBean.CartListBean item:list){
            if(item.select){
                ids.add(item.getProduct_id());
            }
        }
        return ids;
    }


}