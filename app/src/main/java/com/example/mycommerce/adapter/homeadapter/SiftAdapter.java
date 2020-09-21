package com.example.mycommerce.adapter.homeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.mycommerce.R;

import java.util.ArrayList;
import java.util.List;

public class SiftAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutHelper mHelper;


    public SiftAdapter(LayoutHelper helper, Context context) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sift_adapter, parent, false);
        return new RecyclerViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {



        SiftAdapter.RecyclerViewItemHolder recyclerViewHolder = (SiftAdapter.RecyclerViewItemHolder) holder;
        List<Integer> integers = new ArrayList<>();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recyclerViewHolder.rvDirectSupply.setLayoutManager(linearLayoutManager);
        //设置适配器
        SiftRVAdapter gridHelperAdapter = new SiftRVAdapter( context,integers);
        recyclerViewHolder.rvDirectSupply.setAdapter(gridHelperAdapter);
        gridHelperAdapter.notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        return 1;
    }



    public class RecyclerViewItemHolder extends RecyclerView.ViewHolder {

        View view;
        RelativeLayout relativeLayout;
        TextView tvDirectSupply;
        ImageView jinruV;
        RecyclerView rvDirectSupply;

        public RecyclerViewItemHolder(View itemView) {
            super(itemView);
            view = (View) itemView.findViewById(R.id.view);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
            tvDirectSupply = (TextView) itemView.findViewById(R.id.tv_direct_supply);
            jinruV = (ImageView) itemView.findViewById(R.id.jinru_v);
            rvDirectSupply = (RecyclerView) itemView.findViewById(R.id.rv_direct_supply);
        }
    }
}
