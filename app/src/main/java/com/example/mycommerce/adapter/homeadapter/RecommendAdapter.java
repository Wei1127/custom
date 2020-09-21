package com.example.mycommerce.adapter.homeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.mycommerce.R;
import com.example.mycommerce.bean.homebean.RecommendProductListBean;

import java.util.ArrayList;
import java.util.List;

public class RecommendAdapter  extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutHelper mHelper;
    private List<RecommendProductListBean.DataBean> rebann;
    public RecommendAdapter(LayoutHelper helper, Context context,List<RecommendProductListBean.DataBean> rebann) {
        this.mHelper = helper;
        this.context = context;
        this.rebann = rebann;
    }
    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adadter_recommend, parent, false);
        return new RecommendAdapter.RecyclerViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        RecommendAdapter.RecyclerViewItemHolder recyclerViewHolder = (RecommendAdapter.RecyclerViewItemHolder) holder;
        List<Integer> integers = new ArrayList<>();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };



        recyclerViewHolder.rvDirectSupply.setLayoutManager(linearLayoutManager);
        //设置适配器
        RecommendRvAdapter gridHelperAdapter = new RecommendRvAdapter(context,rebann);
        recyclerViewHolder.rvDirectSupply.setAdapter(gridHelperAdapter);
        gridHelperAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 1;
    }
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
