package com.example.mycommerce.ui.special.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.mycommerce.R;
import com.example.mycommerce.base.BaseActivity;
import com.example.mycommerce.bean.specialbean.AddCartInfoBean;
import com.example.mycommerce.bean.specialbean.GoodDetailBean;
import com.example.mycommerce.model.api.special.cart.ICart;
import com.example.mycommerce.persenter.special.cart.CartPersenter;
import com.example.mycommerce.utils.CartCustomView;
import com.example.mycommerce.utils.SpUtils;
import com.example.mycommerce.utils.SystemUtils;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailGoodActivity extends BaseActivity<ICart.IPersenter> implements ICart.IView {


    @BindView(R.id.layout_back)
    RelativeLayout layoutBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_des)
    TextView txtDes;
    @BindView(R.id.txt_price)
    TextView txtPrice;
    @BindView(R.id.txt_product)
    TextView txtProduct;
    @BindView(R.id.layout_norms)
    FrameLayout layoutNorms;
    @BindView(R.id.layout_comment)
    FrameLayout layoutComment;
    @BindView(R.id.layout_imgs)
    LinearLayout layoutImgs;
    @BindView(R.id.layout_parameter)
    LinearLayout layoutParameter;
    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.layout_collect)
    RelativeLayout layoutCollect;
    @BindView(R.id.img_cart)
    ImageView imgCart;
    @BindView(R.id.layout_cart)
    RelativeLayout layoutCart;
    @BindView(R.id.txt_buy)
    TextView txtBuy;
    @BindView(R.id.tv_tv_comment)
    TextView tvTvComment;
    @BindView(R.id.layout_parameter2)
    LinearLayout layoutParameter2;
    @BindView(R.id.layout_bottom)
    LinearLayout layoutBottom;
    @BindView(R.id.gouwuche)
    TextView gouwuche;
    private String html = "<html>\n" +
            "            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\"/>\n" +
            "            <head>\n" +
            "                <style>\n" +
            "                    p{\n" +
            "                        margin:0px;\n" +
            "                    }\n" +
            "                    img{\n" +
            "                        width:100%;\n" +
            "                        height:auto;\n" +
            "                    }\n" +
            "                </style>\n" +
            "            </head>\n" +
            "            <body>\n" +
            "                $\n" +
            "            </body>\n" +
            "        </html>";
    private PopupWindow mPopWindow;
    private String img_url;
    private int currentNum = 1;
    private GoodDetailBean goodDetailBean;

    @Override
    protected int getLayout() {
        return R.layout.activity_detail_good;
    }//layout_norms img_cart  layout_cart

    @Override
    protected void initView() {

    }

    @Override
    protected ICart.IPersenter initPersenter() {
        return new CartPersenter();
    }

    @Override
    protected void initData() {
        int id = getIntent().getIntExtra("id", 0);

        persenter.getGoodDetail(id);
    }

    @Override
    public void getGoodDetailReturn(GoodDetailBean result) {

        goodDetailBean = result;
        //banner刷新
        updateBanner(result.getData().getGallery());
        //评论
        if (result.getData().getComment().getCount() > 0) {
            layoutComment.setVisibility(View.VISIBLE);
            updateComment(result.getData().getComment());
        } else {
            layoutComment.setVisibility(View.GONE);
        }
        //设置参数
        updateParameter(result.getData().getAttribute());
        //详情信息的展示
        updateDetailInfo(result.getData().getInfo());
        //常见问题
        updateCommonInfo(result.getData().getIssue());
        String name = getIntent().getStringExtra("name");
        String des = getIntent().getStringExtra("des");
        String price = getIntent().getStringExtra("price");
        // 名字txt_name 内容txt_des 价格txt_price
        txtName.setText(name);
        txtDes.setText(des);
        txtPrice.setText("￥" + price);


    }

    @Override
    public void addCartInfoReturn(AddCartInfoBean result) {

    }

    private void updateCommonInfo(List<GoodDetailBean.DataBeanX.IssueBean> issue) {
        layoutParameter2.removeAllViews(); //清空
        for (GoodDetailBean.DataBeanX.IssueBean item : issue) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.layout_conmment, null);
            TextView txtName = inflate.findViewById(R.id.title_comment_tv);
            TextView txtValues = inflate.findViewById(R.id.nerrong_comment_tv);
            txtName.setText(item.getQuestion());
            txtValues.setText(item.getAnswer());
            layoutParameter2.addView(inflate);
        }
    }

    /**
     * 刷新banner
     */
    private void updateBanner(List<GoodDetailBean.DataBeanX.GalleryBean> gallery) {
        img_url = gallery.get(1).getImg_url();
        if (banner.getTag() == null || (int) banner.getTag() == 0) {
            List<String> imgs = new ArrayList<>();
            for (GoodDetailBean.DataBeanX.GalleryBean item : gallery) {

                imgs.add(item.getImg_url());
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
                    .setIndicator(new CircleIndicator(this));
        }
    }

    /**
     * 刷新评论
     *
     * @param commentBean
     */
    private void updateComment(GoodDetailBean.DataBeanX.CommentBean commentBean) {

    }

    /**
     * 刷新参数的布局
     *
     * @param attributeBean
     */
    private void updateParameter(List<GoodDetailBean.DataBeanX.AttributeBean> attributeBean) {
        layoutParameter.removeAllViews(); //清空
        for (GoodDetailBean.DataBeanX.AttributeBean item : attributeBean) {
            View view = LayoutInflater.from(this).inflate(R.layout.layout_parameter, null);
            View inflate = LayoutInflater.from(this).inflate(R.layout.layout_parameter, null);
            TextView txtName = inflate.findViewById(R.id.txt_parameter_name);
            TextView txtValues = inflate.findViewById(R.id.txt_parameter_value);
            txtName.setText(item.getName());
            txtValues.setText(item.getValue());
            layoutParameter.addView(inflate);
        }
    }

    private void updateDetailInfo(GoodDetailBean.DataBeanX.InfoBean infoBean) {
        if (!TextUtils.isEmpty(infoBean.getGoods_desc())) {
            String h5 = infoBean.getGoods_desc();
            html = html.replace("$", h5);
            webView.loadDataWithBaseURL("about:blank", html, "text/html", "utf-8", null);
            //webView.loadData(html,"text/html","utf-8");
        }
    }


    private void addCart() {
        String token = SpUtils.getInstance().getString("token");
        Log.e("TAG", "addCart: "+token);
        if(!TextUtils.isEmpty(token)){
            //判断当前的规格弹框是否打开
            if(mPopWindow != null && mPopWindow.isShowing()){
                //添加到购物车的操作
                if(goodDetailBean != null && goodDetailBean.getData().getProductList().size() > 0){
                    int goodsId = goodDetailBean.getData().getProductList().get(0).getGoods_id();
                    int productId = goodDetailBean.getData().getProductList().get(0).getId();
                    persenter.addCart(goodsId,currentNum,productId);
                    Toast.makeText(this,"加入到购物车",Toast.LENGTH_SHORT).show();
                    mPopWindow.dismiss();
                    mPopWindow = null;
                    //已经加入完成
                }else{
                    Toast.makeText(this,"没有产品数据",Toast.LENGTH_SHORT).show();
                }
            }else{
                showPopWindow();
            }
        }else{
            Toast.makeText(this, "未登录", Toast.LENGTH_SHORT).show();
            //Intent跳转到登录
        }

    }

    private void showPopWindow() {
        if (mPopWindow != null && mPopWindow.isShowing()) {

        } else {
            View contentView = LayoutInflater.from(this).inflate(R.layout.layout_popwindow_good, null);
            int height = SystemUtils.dp2px(this, 250);
            mPopWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, height);
            mPopWindow.setFocusable(false);
            mPopWindow.setOutsideTouchable(false);
            mPopWindow.setContentView(contentView);
            contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            CartCustomView cartCustomView = contentView.findViewById(R.id.layout_cartwindow);
            TextView txtClose = contentView.findViewById(R.id.txt_close);
            TextView txtprice = contentView.findViewById(R.id.txt_price);
            String price = getIntent().getStringExtra("price");
            ImageView img_good = contentView.findViewById(R.id.img_good);
            Glide.with(this).load(img_url).into(img_good);
            txtprice.setText("￥" + price);
            txtClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPopWindow.dismiss();
                    mPopWindow = null;
                }
            });
            int[] pt = new int[2];
            //获取到的屏幕宽高(除开了当前组件的宽高）
            layoutBottom.getLocationInWindow(pt);
            // Display display = getWindowManager().getDefaultDisplay();
            // int activityheight = display.getHeight();
            mPopWindow.showAtLocation(layoutBottom, Gravity.NO_GRAVITY, 0, pt[1] - height);
            cartCustomView.initView();
            cartCustomView.setOnClickListener(new CartCustomView.IClick() {
                @Override
                public void clickCB(int value) {
                    //value
                    Toast.makeText(DetailGoodActivity.this, "" + value, Toast.LENGTH_SHORT).show();
                    currentNum = value;
                }
            });
        }

    }




    @OnClick({R.id.layout_norms, R.id.layout_cart, R.id.gouwuche})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_norms:
                showPopWindow();
                break;
            case R.id.layout_cart:
                Toast.makeText(this,"选购",Toast.LENGTH_SHORT).show();
                setResult(1000);
                finish();
                break;
            case R.id.gouwuche:
                Toast.makeText(this,"点击",Toast.LENGTH_SHORT).show();
                //购物车  判断当前是否弹出 若已经弹出添加进购物车
                addCart();

                break;
        }
    }
}