package com.example.mycommerce.ui.special;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mycommerce.R;
import com.example.mycommerce.base.BaseFragment;
import com.example.mycommerce.bean.specialbean.HomeBean;
import com.example.mycommerce.interfaces.special.ImodeSpecial;
import com.example.mycommerce.persenter.special.SpercialPersenter;
import com.example.mycommerce.ui.special.activity.DetailGoodActivity;
import com.example.mycommerce.ui.special.activity.HomeListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class SpecialFragment extends BaseFragment<ImodeSpecial.IPersenter> implements ImodeSpecial.IView {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    HomeListAdapter homeListAdapter;
    List<HomeBean.HomeListBean> list;
    @Override
    protected int getLayout() {
        return R.layout.fragment_special;
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        homeListAdapter = new HomeListAdapter(list,context);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2);

        homeListAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int i) {
                int type = list.get(i).currentType;
                switch (type){
                    case HomeBean.ITEM_TYPE_BANNER:
                    case HomeBean.ITEM_TYPE_TITLE:
                    case HomeBean.ITEM_TYPE_TITLETOP:
                    case HomeBean.ITEM_TYPE_TOPIC:
                    case HomeBean.ITEM_TYPE_HOT:
                        //用的最小公倍数   与2
                        return 2;
                    case HomeBean.ITEM_TYPE_BRAND:
                    case HomeBean.ITEM_TYPE_NEW:
                    case HomeBean.ITEM_TYPE_CATEGORY:

                        //用的最小公倍数与2
                        return 1;

                }
                return 0;
            }
        });
        recyclerview.setLayoutManager(gridLayoutManager);
        homeListAdapter.bindToRecyclerView(recyclerview);
        homeListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                int type = list.get(position).currentType;
                Intent intent = new Intent();
                switch (type){
                    case HomeBean.ITEM_TYPE_BANNER:

                        Toast.makeText(context, "banner", Toast.LENGTH_SHORT).show();
                        break;
                    case HomeBean.ITEM_TYPE_BRAND:

                        Toast.makeText(context, "品牌", Toast.LENGTH_SHORT).show();

                        break;
                    case HomeBean.ITEM_TYPE_HOT:
                        HomeBean.DataBean.HotGoodsListBean bean = (HomeBean.DataBean.HotGoodsListBean) list.get(position).data;
                        intent.putExtra("id",bean.getId());
                        intent.putExtra("name",bean.getName());
                        intent.putExtra("des",bean.getGoods_brief());
                        intent.putExtra("price",bean.getRetail_price()+"");
                        intent.setClass(context, DetailGoodActivity.class);
                        startActivityForResult(intent,2000);
                        break;
                    case HomeBean.ITEM_TYPE_TITLE:
                        Toast.makeText(context, "标题", Toast.LENGTH_SHORT).show();
                        break;
                    case HomeBean.ITEM_TYPE_TITLETOP:
                        Toast.makeText(context, "标题顶部就边距", Toast.LENGTH_SHORT).show();
                        break;
                    case HomeBean.ITEM_TYPE_TOPIC:

                        Toast.makeText(context, "专题", Toast.LENGTH_SHORT).show();
                        break;
                    case HomeBean.ITEM_TYPE_CATEGORY:
                        Toast.makeText(context, "类别", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    protected ImodeSpecial.IPersenter initPersenter() {
        return new SpercialPersenter();
    }

    @Override
    protected void initData() {
        persenter.getHomeData();
    }

    @Override
    public void getHomeDataReturn(List<HomeBean.HomeListBean> result) {
        list.addAll(result);
        homeListAdapter.notifyDataSetChanged();
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View inflate = inflater.inflate(R.layout.fragment_special, container, false);
//
//        return inflate;
//    }
}