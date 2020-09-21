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

public class SiftRVAdapter extends RecyclerView.Adapter<SiftRVAdapter.ViewHolder> {

    private Context context;
    private List<Integer> rvBeans;



    public SiftRVAdapter(Context context, List<Integer> rvBeans) {
        this.context = context;
        this.rvBeans = rvBeans;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_sift_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView siftRvTu;
         TextView recommendRvTvName;
         TextView recommendRvTvJiage;
         TextView recommendRvTvNeirong;
         ViewHolder(@NonNull View itemView) {
            super(itemView);
            siftRvTu = (ImageView) itemView.findViewById(R.id.sift_rv_tu);
            recommendRvTvName = (TextView) itemView.findViewById(R.id.recommend_rv_tv_name);
            recommendRvTvJiage = (TextView) itemView.findViewById(R.id.recommend_rv_tv_jiage);
            recommendRvTvNeirong = (TextView) itemView.findViewById(R.id.recommend_rv_tv_neirong);
        }
    }
}
