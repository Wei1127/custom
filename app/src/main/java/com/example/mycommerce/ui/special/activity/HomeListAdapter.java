package com.example.mycommerce.ui.special.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mycommerce.R;
import com.example.mycommerce.bean.specialbean.HomeBean;
import com.example.mycommerce.utils.SystemUtils;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class HomeListAdapter extends BaseMultiItemQuickAdapter<HomeBean.HomeListBean, BaseViewHolder> {


    private Context context;
    private String priceWord;
    private TopicAdapter topicAdapter;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public HomeListAdapter(List<HomeBean.HomeListBean> data, Context context) {
        super(data);
        this.context = context;
        priceWord = context.getString(R.string.word_price_brand);
        //做UI绑定
        addItemType(HomeBean.ITEM_TYPE_BANNER, R.layout.layout_home_banner);
        addItemType(HomeBean.ITEM_TYPE_TAB, R.layout.layout_home_tab);
        addItemType(HomeBean.ITEM_TYPE_TITLETOP, R.layout.layout_title_top);
        addItemType(HomeBean.ITEM_TYPE_BRAND, R.layout.layout_home_brand);
        addItemType(HomeBean.ITEM_TYPE_TITLE, R.layout.layout_title);
        addItemType(HomeBean.ITEM_TYPE_NEW, R.layout.layout_home_newgood);
        addItemType(HomeBean.ITEM_TYPE_TITLETOP, R.layout.layout_title_top);
        addItemType(HomeBean.ITEM_TYPE_HOT, R.layout.layout_home_hot);
        addItemType(HomeBean.ITEM_TYPE_TITLETOP, R.layout.layout_title_top);
        addItemType(HomeBean.ITEM_TYPE_TOPIC, R.layout.layout_home_topiclist);
        addItemType(HomeBean.ITEM_TYPE_CATEGORY, R.layout.layout_home_category);
    }

    /**
     * 主要刷新数据，绑定数据  onbindviewholder
     *
     * @param helper viewholder 界面
     * @param item   数据
     */
    @Override
    protected void convert(BaseViewHolder helper, HomeBean.HomeListBean item) {
        switch (item.getItemType()) {
            case HomeBean.ITEM_TYPE_TITLE:
                updateTitle(helper, (String) item.data);
                break;
            case HomeBean.ITEM_TYPE_TITLETOP:
                updateTitle(helper, (String) item.data);
                break;
            case HomeBean.ITEM_TYPE_BANNER:
                updateBanner(helper, (List<HomeBean.DataBean.BannerBean>) item.data);
                break;
            case HomeBean.ITEM_TYPE_TAB:
                updateTab(helper, (List<HomeBean.DataBean.ChannelBean>) item.data);
                break;
            case HomeBean.ITEM_TYPE_BRAND:
                updateBrand(helper, (HomeBean.DataBean.BrandListBean) item.data);
                break;
            case HomeBean.ITEM_TYPE_NEW:
                updateNewGood(helper, (HomeBean.DataBean.NewGoodsListBean) item.data);
                break;
            case HomeBean.ITEM_TYPE_HOT:
                udpateHot(helper, (HomeBean.DataBean.HotGoodsListBean) item.data);
                break;
            case HomeBean.ITEM_TYPE_TOPIC:
                updateTopic(helper, (List<HomeBean.DataBean.TopicListBean>) item.data);
                break;
            case HomeBean.ITEM_TYPE_CATEGORY:
                updateCategory(helper, (HomeBean.DataBean.CategoryListBean.GoodsListBean) item.data);
                break;
        }
    }

    private void updateCategory(BaseViewHolder holder, HomeBean.DataBean.CategoryListBean.GoodsListBean data) {
        if (!TextUtils.isEmpty(data.getList_pic_url())){
            Glide.with(context).load(data.getList_pic_url()).into((ImageView)holder.getView(R.id.img_cover));
        }
        if (!TextUtils.isEmpty(data.getName())){
            ((TextView)holder.getView(R.id.tv_category_name)).setText(data.getName());
        }
        ((TextView)holder.getView(R.id.tv_category_price)).setText("￥"+(double)data.getRetail_price());
    }



    /**
     * 刷新title
     *
     * @param viewHolder
     * @param title
     */
    private void updateTitle(BaseViewHolder viewHolder, String title) {
        ((TextView)viewHolder.getView(R.id.txt_title)).setText(title);
    }

    /**
     * 刷新banner
     *
     * @param viewHolder
     * @param bannsers
     */
    private void updateBanner(BaseViewHolder viewHolder, List<HomeBean.DataBean.BannerBean> bannsers) {
        Banner banner = viewHolder.getView(R.id.banner);
        if(banner.getTag() == null || (int)banner.getTag() == 0){
            List<String> imgs = new ArrayList<>();
            for (HomeBean.DataBean.BannerBean item : bannsers) {
                imgs.add(item.getImage_url());
            }
            banner.setTag(1);
            banner.setAdapter(new BannerImageAdapter<String>(imgs) {
                @Override
                public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                    Glide.with(holder.itemView)
                            .load(data)
                            .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                            .into(holder.imageView);
                }

            })
                    //.addBannerLifecycleObserver(this)
                    .setIndicator(new CircleIndicator(context));
        }
//        if(banner.getTag() == null || (int)banner.getTag() == 0){
//            List<String> imgs = new ArrayList<>();
//            for (HomeBean.DataBean.BannerBean item : bannsers) {
//                imgs.add(item.getImage_url());
//            }
//            banner.setTag(1);
//            banner.setImageLoader(new GlideImageLoader());
//
//            banner.setImages(imgs);
//            banner.start();
//        }
//
//        List<String> bannerUrls = new ArrayList<>();
//        if (bannsers.size() > 0) {
//            for (int i = 0; i < bannsers.size(); i++) {
//                bannerUrls.add(bannsers.get(i).getImage_url());
//            }
//        }
//
//        banner.setAdapter(new BannerImageAdapter<String>(bannerUrls) {
//            @Override
//            public void onBindView(BannerImageHolder holder, String data, int position, int size) {
//                //图片加载自己实现
//                Glide.with(holder.itemView)
//                        .load(data)
//                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
//                        .into(holder.imageView);
//            }
//        }).addBannerLifecycleObserver((LifecycleOwner) this)//添加生命周期观察者
//                .setIndicator(new CircleIndicator(context));


    }


    /**
     * 刷新channel
     *
     * @param viewHolder
     * @param channels
     */
    private void updateTab(BaseViewHolder viewHolder, List<HomeBean.DataBean.ChannelBean> channels) {
        LinearLayout layoutChannels = viewHolder.getView(R.id.layout_tab);
        //只让当前的布局内容添加一次 only one
        if (layoutChannels.getChildCount() == 0) {
            for (HomeBean.DataBean.ChannelBean item : channels) {
                TextView tab = new TextView(context);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);
                int size = SystemUtils.dp2px(context, 14);
                tab.setTextSize(size);
                tab.setGravity(Gravity.CENTER);
                Drawable icon = context.getDrawable(R.mipmap.ic_channel1);
                tab.setCompoundDrawables(null, icon, null, null);
                layoutChannels.addView(tab);
            }
        }
    }

    /**
     * 刷新品牌
     *
     * @param viewHolder
     * @param brands
     */
    private void updateBrand(BaseViewHolder viewHolder, HomeBean.DataBean.BrandListBean brands) {
        if (!TextUtils.isEmpty(brands.getNew_pic_url())) {
            Glide.with(context).load(brands.getNew_pic_url()).into((ImageView) viewHolder.getView(R.id.img_brand));
        }
        viewHolder.setText(R.id.txt_brand_name, brands.getName());
        String price = priceWord.replace("$", String.valueOf(brands.getFloor_price()));
        viewHolder.setText(R.id.txt_brand_price, price);
    }

    /**
     * 刷新新品数据
     *
     * @param viewHolder
     * @param newGoods
     */
    private void updateNewGood(BaseViewHolder viewHolder, HomeBean.DataBean.NewGoodsListBean newGoods) {
        ImageView img_newgood = viewHolder.getView(R.id.img_newgood);
        TextView txt_newgood_name = viewHolder.getView(R.id.txt_newgood_name);
        TextView txt_newgood_price = viewHolder.getView(R.id.txt_newgood_price);
        Glide.with(context).load(newGoods.getList_pic_url()).into(img_newgood);
        txt_newgood_name.setText(newGoods.getName());
        txt_newgood_price.setText(newGoods.getRetail_price()+"");

    }

    /**
     * 刷新人气数据
     */
    private void udpateHot(BaseViewHolder viewHolder, HomeBean.DataBean.HotGoodsListBean hotGoods) {

        ImageView img_newgood = viewHolder.getView(R.id.img_hot);
        TextView txt_hot_name = viewHolder.getView(R.id.txt_hot_name);
        TextView txt_hot_title = viewHolder.getView(R.id.txt_hot_title);
        TextView txt_hot_price = viewHolder.getView(R.id.txt_hot_price);
        Glide.with(context).load(hotGoods.getList_pic_url()).into(img_newgood);
        txt_hot_name.setText(hotGoods.getName());
        txt_hot_title.setText(hotGoods.getGoods_brief());
        txt_hot_price.setText(hotGoods.getRetail_price()+"");




    }

    /**
     * 刷新专题
     *
     * @param viewHolder
     * @param topicGoods
     */
    private void updateTopic(BaseViewHolder viewHolder, List<HomeBean.DataBean.TopicListBean> topicGoods) {
        RecyclerView recyclerView = viewHolder.getView(R.id.recyclerviewTopic);
        if (topicAdapter == null) {
            topicAdapter = new TopicAdapter(context, topicGoods);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(topicAdapter);
        } else if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(topicAdapter);
        }
    }


}
