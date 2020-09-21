package com.example.mycommerce.adapter.homeadapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.mycommerce.R;
import com.example.mycommerce.bean.homebean.BannerBean;
import com.example.mycommerce.utils.DateUtil;

import java.util.List;

public class LinearAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private LayoutHelper mHelper;
    private List<BannerBean.DataBean.HotProductListBean> list;

    private static RecyclerViewItemHolder recyclerViewHolder;


    public LinearAdapter(Context context, LayoutHelper helper,List<BannerBean.DataBean.HotProductListBean> list) {
        this.mContext = context;
        this.mHelper = helper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_linear_layout, parent, false);
        return new RecyclerViewItemHolder(view);
    }
    private TimeThread timeThread;
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        recyclerViewHolder = (RecyclerViewItemHolder) holder;



//
//        initTime();
//         timeThread = new TimeThread();
//        timeThread.start();


        SeckillAdapter seckillAdapter = new SeckillAdapter(mContext,list);
        GridLayoutManager layoutManager = new GridLayoutManager(mContext,2){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerViewHolder.rclSeckill.setAdapter(seckillAdapter);
        recyclerViewHolder.rclSeckill.setLayoutManager(layoutManager);
        seckillAdapter.notifyDataSetChanged();
        recyclerViewHolder.txtNext.setText((position + ""));
        recyclerViewHolder.txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return 1;
    }

    private static void initTime() {
        String time = DateUtil.getTime();
        Log.i("shwTAG", "initTime: " + time);
        String[] timeSplit = time.split(":");
        if (timeSplit.length > 0){
            int hour = Integer.parseInt(timeSplit[0]);
            int minute = 60 - Integer.parseInt(timeSplit[1]);
            int second = 60 - Integer.parseInt(timeSplit[2]);
            if (recyclerViewHolder.txtNext != null && recyclerViewHolder.tvHour != null && recyclerViewHolder.tvSecond != null && recyclerViewHolder.tvMinute != null) {
                recyclerViewHolder.txtNext.setText("下一场" + (hour + 1) + "：00开始");
                recyclerViewHolder.tvHour.setText("00");
                recyclerViewHolder.tvMinute.setText(minute + "");
                recyclerViewHolder.tvSecond.setText(second + "");
                if (minute < 10) {
                    recyclerViewHolder.tvMinute.setText("0" + minute);
                }
                if (second < 10) {
                    recyclerViewHolder.tvSecond.setText("0" + second);
                }
                if (minute == 60) {
                    recyclerViewHolder.tvMinute.setText("00");
                }
                if (second == 60) {
                    recyclerViewHolder.tvSecond.setText("00");
                }
                if (minute == 0 && second == 0) {
                    recyclerViewHolder.tvHour.setText("01");
                    recyclerViewHolder.tvMinute.setText("00");
                    recyclerViewHolder.tvSecond.setText("00");
                }
            }
        }
    }
    private static final int msgKey1 = 1;
    private static Handler mHandler = new Handler() {
        @Override
        public void handleMessage (Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case msgKey1:
                    initTime();
                    break;
                default:
                    break;
            }
        }
    };
    private static class TimeThread extends Thread {
        @Override
        public void run () {
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = msgKey1;
                    mHandler.sendMessage(msg);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while(true);
        }
    }

    /**
     * 正常条目的item的ViewHolder
     */
    private class RecyclerViewItemHolder extends RecyclerView.ViewHolder {

        ConstraintLayout consSeckill;
        View view;
        TextView txtSeckill;
        TextView txtNext;
        TextView txtTimeLeft;
        LinearLayout lineaTime;
        TextView tvHour;
        TextView tvMinute;
        TextView tvSecond;
        RecyclerView rclSeckill;

        public RecyclerViewItemHolder(View itemView) {
            super(itemView);
            consSeckill = (ConstraintLayout) itemView.findViewById(R.id.cons_seckill);
            view = (View) itemView.findViewById(R.id.view);
            txtSeckill = (TextView) itemView.findViewById(R.id.txt_seckill);
            txtNext = (TextView) itemView.findViewById(R.id.txt_next);
            txtTimeLeft = (TextView) itemView.findViewById(R.id.txt_time_left);
            lineaTime = (LinearLayout) itemView.findViewById(R.id.linea_time);
            tvHour = (TextView) itemView.findViewById(R.id.tv_time_hour);
            tvMinute = (TextView) itemView.findViewById(R.id.tv_time_minute);
            tvSecond = (TextView) itemView.findViewById(R.id.tv_time_second);
            rclSeckill = (RecyclerView) itemView.findViewById(R.id.rcl_seckill);
        }


    }





}
