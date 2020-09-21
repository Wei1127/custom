package com.example.mycommerce.adapter.homeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.mycommerce.R;
import com.example.mycommerce.bean.homebean.BannerBean;
import com.example.mycommerce.common.Constants;

import java.util.ArrayList;
import java.util.List;

public class GridHelperAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {

    private List<BannerBean.DataBean.NewProductListBean> mData;
    private View view;
    private RecyclerView rvDirectSupply;
    private RelativeLayout relativeLayout;
    private TextView tvDirectSupply;
    private ImageView jinruV;
    private Context context;
    private LayoutHelper mHelper;

    public GridHelperAdapter(List<BannerBean.DataBean.NewProductListBean> mData, LayoutHelper helper, Context context) {
        this.mData = mData;
        this.mHelper = helper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_layout, parent, false);
        return new RecyclerViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        rvDirectSupply = holder.itemView.findViewById(R.id.rv_direct_supply);
        relativeLayout = holder.itemView.findViewById(R.id.relativeLayout);
        List<Integer> integers = new ArrayList<>();
        GridLayoutManager layoutManager = new GridLayoutManager(context,2){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        integers.add(4);
        rvDirectSupply.setLayoutManager(layoutManager);
        DirectSellingAdapter gridHelperAdapter = new DirectSellingAdapter( context,mData);
        rvDirectSupply.setAdapter(gridHelperAdapter);
        gridHelperAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    /**
     * 正常条目的item的ViewHolder
     */
    public class RecyclerViewItemHolder extends RecyclerView.ViewHolder {

         RecyclerView rvDirectSupply;
         RelativeLayout relativeLayout;
        public RecyclerViewItemHolder(View itemView) {
            super(itemView);
            this.relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
            this.rvDirectSupply = (RecyclerView) itemView.findViewById(R.id.rv_direct_supply);
        }
    }
}
