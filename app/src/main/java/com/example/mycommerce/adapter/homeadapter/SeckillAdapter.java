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
import com.example.mycommerce.bean.homebean.BannerBean;

import java.util.List;

public class SeckillAdapter extends RecyclerView.Adapter<SeckillAdapter.ViewHolder> {
    private Context context;
    private List<BannerBean.DataBean.HotProductListBean> rvBeans;


    public SeckillAdapter(Context context, List<BannerBean.DataBean.HotProductListBean> list) {
        this.context = context;
        this.rvBeans = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_seckill, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        SeckillAdapter.ViewHolder recyclerViewHolder = (SeckillAdapter.ViewHolder) holder;
        recyclerViewHolder.seckillTvName.setText("秒杀价￥"+rvBeans.get(position).getPrice());
        recyclerViewHolder.neirongTv.setText(rvBeans.get(position).getName());
        recyclerViewHolder.tvRedJiage.setText(rvBeans.get(position).getPrice() + "￥");
        Glide.with(context).load(rvBeans.get(position).getPic()).into(recyclerViewHolder.seckllTu);

    }

    @Override
    public int getItemCount() {
        return rvBeans.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView seckllTu;
        private TextView tvRedJiage;
        private TextView seckillTvName;
        private TextView neirongTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            seckllTu = (ImageView) itemView.findViewById(R.id.seckll_tu);
            tvRedJiage = (TextView) itemView.findViewById(R.id.tv_red_jiage);
            seckillTvName = (TextView) itemView.findViewById(R.id.seckill_tv_name);
            neirongTv = (TextView) itemView.findViewById(R.id.neirong_tv);
        }
    }
}
