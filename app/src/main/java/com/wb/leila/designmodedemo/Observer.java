package com.wb.leila.designmodedemo;

import java.util.List;

/**
 * @author Leila
 * @version V1.0
 * @date 2018/4/13 11:44
 * className  Observer
 * email leila329@163.com
 * description 观察者接口
 */
public interface Observer<T> {
    void onUpdate(Observable<T> observable, List<T> data);
}
