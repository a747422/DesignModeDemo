package com.wb.leila.designmodedemo.model;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wb.leila.designmodedemo.R;
import com.wb.leila.designmodedemo.Section;
import com.wb.leila.designmodedemo.adapter.MainRecyclerAdapter;
import com.wb.leila.designmodedemo.adapter.RecyclerSectionAdapter;
import com.wb.leila.designmodedemo.bean.BaseBean;
import com.wb.leila.designmodedemo.bean.DataBean;
import com.wb.leila.designmodedemo.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leila
 * @version V1.0
 * @date 2018/4/19 14:21
 * className  RecycleViewUtils
 * email leila329@163.com
 * description
 */
public class RecycleViewUtils {
    RecyclerSectionAdapter recyclerSectionAdapter;
    MainRecyclerAdapter mainRecyclerAdapter;
    /**
     * 带分组功能
     */
    public List<Section> list;
    /**
     * 普通列表
     */
    public List<DataBean> dataBeanList;
    DataBean dataBean;

    RecyclerView recy;
    Context mContext;

    public RecycleViewUtils(Context context, RecyclerView recy) {
        this.mContext = context;
        this.recy = recy;
    }

    public void section() {
        initSectionData();
        //布局管理器，垂直布局显示
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(mContext, 2);
        //适配器初始化
        recyclerSectionAdapter = new RecyclerSectionAdapter(R.layout.main_item, R.layout.rec_item, list);
        //RecyclerView 添加管理器和适配器
        recy.setLayoutManager(layoutManager);
        recy.setAdapter(recyclerSectionAdapter);
        //QuickAdapter提供的加载动画，当前为缩放
        recyclerSectionAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);

    }

    public MainRecyclerAdapter universal() {
        initUniversalData();
        if (mContext == null) {
            return null;
        }
        //布局管理器，垂直布局显示
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        //适配器初始化
        mainRecyclerAdapter = new MainRecyclerAdapter(R.layout.main_item, dataBeanList);
        //RecyclerView 添加管理器和适配器
        recy.setLayoutManager(layoutManager);
        recy.setAdapter(mainRecyclerAdapter);
        //QuickAdapter提供的加载动画，当前为缩放
        mainRecyclerAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);

        return mainRecyclerAdapter;

    }

    private void initUniversalOnClick() {
        mainRecyclerAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.showToast(dataBeanList.get(position).getMsg());
            }
        });

    }

    private void initSectionData() {
        list = new ArrayList<>();
        dataBean = new DataBean();
        dataBean.setUsername("cute");
        dataBean.setMsg("可爱");
        addListData(dataBean);
        addListHeadData(true, "c");
        dataBean.setUsername("cut");
        dataBean.setMsg("剪");
        addListData(dataBean);
        addListData(dataBean);
        addListHeadData(true, "b");
    }

    private void initUniversalData() {
        dataBeanList = new ArrayList<>();
        dataBean = new DataBean();
        for (int i = 0; i < 5; i++) {
            dataBean.setMsg("张韶涵" + i);
            dataBeanList.add(dataBean);
        }
    }

    private void addListHeadData(boolean isHeader, String header) {
        list.add(new Section(isHeader, header));
    }

    private void addListData(DataBean dataBean) {
        list.add(new Section(dataBean));
    }


}
