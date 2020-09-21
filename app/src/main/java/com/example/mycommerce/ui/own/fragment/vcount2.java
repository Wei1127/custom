package com.example.mycommerce.ui.own.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycommerce.R;
import com.example.mycommerce.adapter.sortadapter.RvAdapter;
import com.example.mycommerce.bean.ownbean.VerticalBean;
import com.example.mycommerce.bean.sortbean.CategoryTreeListBean;

import java.util.List;

public class vcount2  extends Fragment {


    private RecyclerView rv;
    private List<VerticalBean.DataBean.CurrentCategoryBean> type;

    public vcount2(List<VerticalBean.DataBean.CurrentCategoryBean> type) {
        this.type = type;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getActivity(), R.layout.vcountlayout, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
//        rv = (RecyclerView) inflate.findViewById(R.id.rv);
//        rv.setLayoutManager(new GridLayoutManager(getActivity(),3));
//        RvAdapter rvAdapter = new RvAdapter(getContext(), type);
//        rv.setAdapter(rvAdapter);
//        rvAdapter.notifyDataSetChanged();
    }
}
