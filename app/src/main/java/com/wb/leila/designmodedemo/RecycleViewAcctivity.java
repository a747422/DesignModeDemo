package com.wb.leila.designmodedemo;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wb.leila.designmodedemo.adapter.RecyclerSectionAdapter;
import com.wb.leila.designmodedemo.base.BaseActivity;
import com.wb.leila.designmodedemo.bean.BaseBean;
import com.wb.leila.designmodedemo.bean.DataBean;
import com.wb.leila.designmodedemo.model.RecycleViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Leila
 * @version V1.0
 * @date 2018/4/18 11:38
 * className  RecycleViewAcctivity
 * email leila329@163.com
 * description
 */
public class RecycleViewAcctivity extends BaseActivity {
    @BindView(R.id.recy_section_entity)
    RecyclerView recy;

    RecyclerSectionAdapter recyclerSectionAdapter;
    /**
     * 带分组功能
     */
    List<Section> list;
    DataBean dataBean;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_rec);
        ButterKnife.bind(this);

//        list = new ArrayList<>();
//        dataBean = new DataBean();
//        dataBean.setUsername("cute");
//        dataBean.setMsg("可爱");
//        list.add(new Section(true, "cute"));
//        list.add(new Section(dataBean));
//        list.add(new Section(dataBean));
//        dataBean.setUsername("cut");
//        dataBean.setMsg("剪");
//        list.add(new Section(true, "cut"));
//        list.add(new Section(dataBean));
//        //布局管理器，垂直布局显示
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
//        //适配器初始化
//        recyclerSectionAdapter = new RecyclerSectionAdapter(R.layout.main_item, R.layout.rec_item, list);
//        //RecyclerView 添加管理器和适配器
//        recy.setLayoutManager(layoutManager);
//        recy.setAdapter(recyclerSectionAdapter);
//        //QuickAdapter提供的加载动画，当前为缩放
//        recyclerSectionAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
    }

    @Override
    protected void initData() {
        new RecycleViewUtils(this, recy).section();
        //recyclerSectionAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initCilck() {

    }
}
