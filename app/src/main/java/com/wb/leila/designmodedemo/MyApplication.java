package com.wb.leila.designmodedemo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.wb.leila.designmodedemo.utils.LogUtil;


/**
 * Created by admin on 2018/1/29.
 */

public class MyApplication extends Application {
    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        //debug下日志打开
        if (BuildConfig.LOG_DEBUG) {
            LogUtil.init(true, Log.VERBOSE);
        } else {
            LogUtil.init(false);
        }

    }

    public static Context getContext() {
        return context;
    }


}
