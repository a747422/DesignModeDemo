package com.wb.leila.designmodedemo.adapter;


import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wb.leila.designmodedemo.R;
import com.wb.leila.designmodedemo.Section;

import java.util.List;

/**
 * @author Leila
 * @version V1.0
 * @date 2018/4/18 11:46
 * className  RecyclerSectionAdapter
 * email leila329@163.com
 * description
 */
public class RecyclerSectionAdapter extends BaseSectionQuickAdapter<Section, BaseViewHolder> {


    /**
     * 第一个是item的，第二个是head的，
     * 在convert方法里面加载item数据，
     * 在convertHead方法里面加载head数据
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public RecyclerSectionAdapter(int layoutResId, int sectionHeadResId, List<Section> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Section item) {
        helper.setText(R.id.tv_title, item.t.getMsg());
    }

    @Override
    protected void convertHead(BaseViewHolder helper, Section item) {
        helper.setText(R.id.tv_more, item.t.getUsername());
    }


}
