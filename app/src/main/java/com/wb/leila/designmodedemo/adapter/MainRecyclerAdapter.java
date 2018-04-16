package com.wb.leila.designmodedemo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wb.leila.designmodedemo.R;
import com.wb.leila.designmodedemo.bean.BaseBean;

import java.util.List;

/**
 * @author Leila
 * @version V1.0
 * @date 2018/4/13 15:28
 * className  MainRecyclerAdapter
 * email leila329@163.com
 * description  基础适配器
 */
public class MainRecyclerAdapter extends BaseQuickAdapter<BaseBean, BaseViewHolder> {
    public MainRecyclerAdapter(int layoutResId, @Nullable List<BaseBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseBean item) {
        helper.setText(R.id.tv_item, item.code);
    }
}
