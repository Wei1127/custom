package com.example.mycommerce.adapter.homeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycommerce.R;

import java.util.List;

public class FreshRvAdapter extends RecyclerView.Adapter<FreshRvAdapter.ViewHolder> {
    private Context context;
    private List<Integer> rvBeans;


    public FreshRvAdapter(Context context, List<Integer> rvBeans) {
        this.context = context;
        this.rvBeans = rvBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_fresh_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView rvFreshTu;
         TextView directTvBiaoqian;
         TextView textView;
         TextView textView2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rvFreshTu = (ImageView) itemView.findViewById(R.id.rv_fresh_tu);
            directTvBiaoqian = (TextView) itemView.findViewById(R.id.direct_tv_biaoqian);
            textView = (TextView) itemView.findViewById(R.id.textView);
            textView2 = (TextView) itemView.findViewById(R.id.textView2);
        }
    }

}
