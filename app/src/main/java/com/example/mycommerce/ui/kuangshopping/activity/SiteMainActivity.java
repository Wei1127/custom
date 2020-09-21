package com.example.mycommerce.ui.kuangshopping.activity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mycommerce.R;
import com.example.mycommerce.base.BaseActivity;
import com.example.mycommerce.bean.specialbean.AdressBean;
import com.example.mycommerce.model.api.special.cart.ICart;
import com.example.mycommerce.persenter.own.AdressPersenter;
import com.example.mycommerce.utils.SystemUtils;
import com.weigan.loopview.LoopView;
import com.weigan.loopview.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//R.layout.activity_site_main
public class SiteMainActivity extends BaseActivity<ICart.IAdressPersenter> implements ICart.IAdressView {
    @BindView(R.id.shouhuodizhi)
    TextView shouhuodizhi;
    @BindView(R.id.xianshidizhi)
    TextView xianshidizhi;
    @BindView(R.id.shouhuodizhijinru)
    ImageView shouhuodizhijinru;
    @BindView(R.id.xiangxidizhi)
    RelativeLayout xiangxidizhi;
    @BindView(R.id.youhuijuan)
    TextView youhuijuan;
    @BindView(R.id.youhuijuangeshu)
    TextView youhuijuangeshu;
    @BindView(R.id.youhuijuanjinru)
    ImageView youhuijuanjinru;
    @BindView(R.id.youhuiquan)
    RelativeLayout youhuiquan;
    @BindView(R.id.heji)
    TextView heji;
    @BindView(R.id.jiaqian)
    TextView jiaqian;
    @BindView(R.id.layout_adress)
    LinearLayout layoutAdress;
    private PopupWindow mPopWindow;
    //xiangxidizhi    youhuiquan
    private Map<Integer, List<AdressBean.DataBean>> addressMap;

    private LoopView province, city, area;
    private TextView txtProvince, txtCity, txtArea;

    private int curProvinceId, curCityId, curAreaId; //当前省市区的ID


    @Override
    protected int getLayout() {
        return R.layout.activity_site_main;
    }

    @Override
    protected void initView() {
        addressMap = new HashMap<>();
    }

    @Override
    protected ICart.IAdressPersenter initPersenter() {
        return new AdressPersenter();
    }


    @Override
    protected void initData() {
        //加载省份数据
        persenter.getAdressById(1);
    }

    @OnClick({R.id.xiangxidizhi, R.id.youhuiquan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xiangxidizhi:
                openAdressSelect();

                break;
            case R.id.youhuiquan:


                break;
        }
    }

    private void openAdressSelect() {
        if (mPopWindow != null && mPopWindow.isShowing()) {

        } else {
            View contentView = LayoutInflater.from(this).inflate(R.layout.layout_popwindow_adress, null);
            int height = SystemUtils.dp2px(this, 250);
            mPopWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, height);
            mPopWindow.setBackgroundDrawable(new BitmapDrawable());
            mPopWindow.setFocusable(false);
            mPopWindow.setOutsideTouchable(false);
            mPopWindow.setContentView(contentView);
            contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            province = contentView.findViewById(R.id.adress_province);
            city = contentView.findViewById(R.id.adress_city);
            area = contentView.findViewById(R.id.adress_area);
            txtProvince = contentView.findViewById(R.id.txt_province);
            txtCity = contentView.findViewById(R.id.txt_city);
            txtArea = contentView.findViewById(R.id.txt_area);
            TextView txt_submit = contentView.findViewById(R.id.txt_submit);
            txt_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPopWindow.dismiss();
                    mPopWindow = null;
                }
            });
            mPopWindow.showAtLocation(layoutAdress, Gravity.BOTTOM, 0, 0);

            //省份
            province.setListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(int index) {
                    List<AdressBean.DataBean> proviceList = addressMap.get(1); //key为1固定为省的数据
                    AdressBean.DataBean dataBean = proviceList.get(index);
                    curProvinceId = dataBean.getId();
                    persenter.getAdressById(curProvinceId);
                    List<String> items = new ArrayList<>();
                    items.add("请选择");
                    city.setItems(items);
                    txtProvince.setText(dataBean.getName());
                    txtCity.setText("请选择城市");
                    txtArea.setText("请选中区域");
                }
            });

            city.setListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(int index) {
                    List<AdressBean.DataBean> cityList = addressMap.get(curProvinceId); //key省份id
                    AdressBean.DataBean dataBean = cityList.get(index);
                    curCityId = dataBean.getId();
                    persenter.getAdressById(curCityId);
                    area.setItems(new ArrayList<>());
                    txtCity.setText(dataBean.getName());
                    txtArea.setText("请选中区域");
                }
            });

            area.setListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(int index) {
                    List<AdressBean.DataBean> areaList = addressMap.get(curCityId); //key省份id
                    AdressBean.DataBean dataBean = areaList.get(index);
                    curAreaId = dataBean.getId();
                    txtArea.setText(dataBean.getName());
                }
            });

            //初始化省份的数据
            List<AdressBean.DataBean> pList = addressMap.get(1);
            if (pList == null) return;
            List<String> adresses = getAdressStrings(pList);
            if (pList == null || adresses.size() == 0) {
                persenter.getAdressById(1);
            } else {
                province.setItems(adresses);
                curProvinceId = pList.get(0).getId();
                txtProvince.setText(adresses.get(0));
            }

        }
    }

    @Override
    public void getAdressByIdReturn(AdressBean result) {
        List<AdressBean.DataBean> list = null;
        int type = 0;
        for (AdressBean.DataBean item : result.getData()) {
            int key = item.getParent_id();
            list = addressMap.get(key);
            if (list == null) {
                list = new ArrayList<>();
                addressMap.put(key, list);
            }
            boolean bool = hasList(item.getId(), list);
            if (!bool) list.add(item);
            if (type == 0) {
                type = item.getType();
            }
        }
        if (list == null) return;
        List<String> adresses = getAdressStrings(list);
        if (type == 1) {
            //刷新省的数据
            if (province != null) {
                curProvinceId = list.get(0).getId();
                txtProvince.setText(list.get(0).getName());
                province.setItems(adresses);
            }
        } else if (type == 2) {
            //刷新市的数据
            if (city != null) {
                curCityId = list.get(0).getId();
                txtCity.setText(list.get(0).getName());
                city.setItems(adresses);
            }
        } else {
            //区
            if (area != null) {
                curAreaId = list.get(0).getId();
                txtArea.setText(list.get(0).getName());
                area.setItems(adresses);
            }
        }
    }

    private boolean hasList(int id, List<AdressBean.DataBean> list) {
        boolean bool = false;
        for (AdressBean.DataBean item : list) {
            if (item.getId() == id) {
                bool = true;
                break;
            }
        }
        return bool;
    }

    private List<String> getAdressStrings(List<AdressBean.DataBean> list) {
        List<String> adresses = new ArrayList<>();
        for (AdressBean.DataBean item : list) {
            adresses.add(item.getName());
        }
        return adresses;
    }


    private AdressBean.DataBean getDataBeanById(int id, List<AdressBean.DataBean> list) {
        for (AdressBean.DataBean item : list) {
            if (item.getId() == id) return item;
        }
        return null;
    }


}