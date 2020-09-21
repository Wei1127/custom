package com.example.mycommerce.adapter.sortadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycommerce.R;
import com.example.mycommerce.adapter.homeadapter.RecommendRvAdapter;
import com.example.mycommerce.base.BaseAdapter;
import com.example.mycommerce.bean.homebean.RecommendProductListBean;
import com.example.mycommerce.bean.sortbean.CategoryTreeListBean;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>   {



    private Context context;
    private List<CategoryTreeListBean.DataBean.ChildrenBean> rvBeans;

    public RvAdapter(Context context, List<CategoryTreeListBean.DataBean.ChildrenBean> rvBeans) {
        this.context = context;
        this.rvBeans = rvBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sort_rv_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView recommendRvIv;
        TextView recommendRvTvName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recommendRvIv = (ImageView) itemView.findViewById(R.id.recommend_rv_iv);
            recommendRvTvName = (TextView) itemView.findViewById(R.id.recommend_rv_tv_name);
        }
    }
//R.layout.sort_rv_adapter  ImageView wenzi = (ImageView) vh.getViewById(R.id.iv_sort_tupian);
//        TextView sort_tv = (TextView) vh.getViewById(R.id.iv_sort_wenzi);             //图片上边的子
//        CategoryTreeListBean.DataBean.ChildrenBean data1 = (CategoryTreeListBean.DataBean.ChildrenBean) data;

}
