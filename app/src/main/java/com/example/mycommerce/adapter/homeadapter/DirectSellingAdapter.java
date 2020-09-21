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
import com.example.mycommerce.base.BaseAdapter;
import com.example.mycommerce.bean.homebean.BannerBean;

import java.util.ArrayList;
import java.util.List;

public class DirectSellingAdapter extends RecyclerView.Adapter<DirectSellingAdapter.ViewHolder> {
    private Context context;
    private List<BannerBean.DataBean.NewProductListBean> mData;

    public DirectSellingAdapter(Context context, List<BannerBean.DataBean.NewProductListBean> rvBeans) {
        this.context = context;
        this.mData = rvBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_direct_selling, null);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DirectSellingAdapter.ViewHolder recyclerViewHolder = (DirectSellingAdapter.ViewHolder) holder;
        recyclerViewHolder.bg_tv.setText(mData.get(position).getBrandName());
        recyclerViewHolder.contentDescribe.setText(mData.get(position).getGiftGrowth()+"");
        Glide.with(context).load(mData.get(position).getPic()).into(recyclerViewHolder.bg);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bg;
        TextView bg_tv;
        TextView contentDescribe;
        TextView direct_tv_biaoqian;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //图片
            bg = (ImageView) itemView.findViewById(R.id.direct_iv_tu);
            //名字
            bg_tv = (TextView) itemView.findViewById(R.id.direct_tv_name);
            //起始价格
            contentDescribe = (TextView) itemView.findViewById(R.id.direct_tv_qijia);
            //上新标签
            direct_tv_biaoqian = (TextView) itemView.findViewById(R.id.direct_tv_biaoqian);
        }
    }

//    ImageView bg = (ImageView) vh.getViewById(R.id.direct_iv_tu);  //图片
//    TextView bg_tv = (TextView) vh.getViewById(R.id.direct_tv_name);             //名字
//    TextView contentDescribe = (TextView) vh.getViewById(R.id.direct_tv_qijia);  //起始价格
//    TextView direct_tv_biaoqian = (TextView) vh.getViewById(R.id.direct_tv_biaoqian);             //上新标签
//  return R.layout.adapter_direct_selling;

}
