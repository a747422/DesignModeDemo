package com.wb.leila.designmodedemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leila
 * @version V1.0
 * @date 2018/4/13 11:40
 * className  Observable
 * email leila329@163.com
 * description 被观察者
 */
public class Observable<T> {

    List<Observer<T>> observers = new ArrayList<Observer<T>>();

    /**
     * 观察者订阅
     */
    public void register(Observer<T> observer) {
        //空的时候抛出异常
        if (observers == null) {
            throw new NullPointerException("observers ==null");
        }
        //同步，不存在的时候再添加，避免重复
        synchronized (this) {
            if (!observers.contains(observer)) {
                observers.add(observer);
            }
        }
    }

    /**
     * 观察者取消订阅
     *
     * @param observer
     */
    public synchronized void unregister(Observer<T> observer) {
        observers.remove(observer);
    }

    public void notifyObservers(List<T> data) {
        //向订阅了的观察者更新数据
        for (Observer<T> observer : observers) {
            observer.onUpdate(this, data);
        }
    }
}
