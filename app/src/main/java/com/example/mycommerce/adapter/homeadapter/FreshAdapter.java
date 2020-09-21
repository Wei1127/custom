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

import java.util.ArrayList;
import java.util.List;

public class FreshAdapter  extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutHelper mHelper;

    public FreshAdapter(LayoutHelper helper, Context context) {
        this.mHelper = helper;
        this.context = context;
    }


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_layout, parent, false);
        return new FreshAdapter.RecyclerViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        FreshAdapter.RecyclerViewItemHolder recyclerViewHolder = (FreshAdapter.RecyclerViewItemHolder) holder;
        List<Integer> integers = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        integers.add(8);
        recyclerViewHolder.rvDirectSupply.setLayoutManager(linearLayoutManager);
        //设置适配器
        FreshRvAdapter gridHelperAdapter = new FreshRvAdapter( context,integers);
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
