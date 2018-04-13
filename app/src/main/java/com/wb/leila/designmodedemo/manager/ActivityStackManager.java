package com.wb.leila.designmodedemo.manager;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import java.util.Stack;

/**
 * @author leila
 * email leila329@163.com
 * create at 2018/4/4
 * description: Activity 管理类
 */

public class ActivityStackManager {
    private static volatile Stack<AppCompatActivity> activityStack;
    private static ActivityStackManager instance;

    private ActivityStackManager() {
    }

    /**
     * 单例模式
     * volatile的一个语义是禁止指令重排序优化，也就保证了instance变量被赋值的时候对象已经是初始化过的
     *
     * @return
     */
    public synchronized static ActivityStackManager getInstance() {
        if (instance == null) {
            synchronized (ActivityStackManager.class) {
                if (instance == null) {
                    instance = new ActivityStackManager();
                }
            }

        }
        return instance;
    }

    /**
     * 关闭activity
     * finish the activity and remove it from stack.
     *
     * @param activity
     */
    public void popActivity(Activity activity) {
        if (activityStack == null) return;
        if (activity != null) {
            activity.finish();
            activity.overridePendingTransition(0, 0);
            activityStack.remove(activity);
            activity = null;
        }
    }

    /**
     * 获取当前的Activity
     * get the current activity.
     *
     * @return
     */
    public AppCompatActivity currentActivity() {
        if (activityStack == null || activityStack.isEmpty()) return null;
        AppCompatActivity activity = (AppCompatActivity) activityStack.lastElement();
        return activity;
    }

    /**
     * 获取最后一个的Activity
     * get the first activity in the stack.
     *
     * @return
     */
    public AppCompatActivity firstActivity() {
        if (activityStack == null || activityStack.isEmpty()) return null;
        AppCompatActivity activity = (AppCompatActivity) activityStack.firstElement();
        return activity;
    }


    /**
     * 添加activity到Stack
     * add the activity to the stack.
     *
     * @param activity
     */
    public void pushActivity(AppCompatActivity activity) {
        if (activityStack == null) {
            activityStack = new Stack<AppCompatActivity>();
        }
        activityStack.add(activity);
    }

    /**
     * remove所有Activity
     * remove all activity.
     */
    public void popAllActivity() {
        if (activityStack == null) return;
        while (true) {
            if (activityStack.empty()) {
                break;
            }
            Activity activity = currentActivity();
            popActivity(activity);
        }
    }

    /**
     * remove所有Activity但保持目前的Activity
     * remove all activity but keep the current activity.
     */
    public void popAllActivityWithOutCurrent() {
        Activity activity = currentActivity();
        while (true) {
            if (activityStack.size() == 1) {
                break;
            }
            if (firstActivity() == activity) {
                break;
            } else {
                popActivity(firstActivity());
            }
        }
    }
}
