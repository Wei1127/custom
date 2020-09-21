package com.example.mycommerce.adapter.homeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mycommerce.R;
import com.example.mycommerce.bean.homebean.RecommendProductListBean;

import java.util.List;

public class RecommendRvAdapter extends RecyclerView.Adapter<RecommendRvAdapter.ViewHolder> {


    private Context context;
    private List<RecommendProductListBean.DataBean> rvBeans;


    public RecommendRvAdapter(Context context, List<RecommendProductListBean.DataBean> rvBeans) {
        this.context = context;
        this.rvBeans = rvBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recommend_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder recyclerViewHolder = (ViewHolder) holder;
        recyclerViewHolder.recommendRvTvName.setText(rvBeans.get(position).getBrandName());
        recyclerViewHolder.recommendRvTvNeirong.setText(rvBeans.get(position).getSubTitle());
        recyclerViewHolder.recommendRvTvJiage.setText(rvBeans.get(position).getPrice() + "");
        Glide.with(context).load(rvBeans.get(position).getPic()).into(recyclerViewHolder.recommendRvIv);
    }

    @Override
    public int getItemCount() {
        return rvBeans.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView rvFreshTu;
         View view;
         ImageView recommendRvIv;
         TextView recommendRvTvName;
         TextView recommendRvTvNeirong;
         TextView recommendRvTvJiage;
         TextView recommendRvTvXuanze;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = (View) itemView.findViewById(R.id.view);
            recommendRvIv = (ImageView) itemView.findViewById(R.id.recommend_rv_iv);
            recommendRvTvName = (TextView) itemView.findViewById(R.id.recommend_rv_tv_name);
            recommendRvTvNeirong = (TextView) itemView.findViewById(R.id.recommend_rv_tv_neirong);
            recommendRvTvJiage = (TextView) itemView.findViewById(R.id.recommend_rv_tv_jiage);
            recommendRvTvXuanze = (TextView) itemView.findViewById(R.id.recommend_rv_tv_xuanze);
        }
    }
}
