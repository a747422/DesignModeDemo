package com.wb.leila.designmodedemo;


import com.chad.library.adapter.base.entity.SectionEntity;
import com.wb.leila.designmodedemo.bean.DataBean;

/**
 * @author Leila
 * @version V1.0
 * @date 2018/4/18 11:43
 * className  Section
 * email leila329@163.com
 * description
 */
public class Section extends SectionEntity<DataBean> {
    private boolean isHeader;

    public Section(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public Section(DataBean t) {
        super(t);
    }
}
