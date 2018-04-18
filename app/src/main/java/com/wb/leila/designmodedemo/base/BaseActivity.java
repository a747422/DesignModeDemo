package com.wb.leila.designmodedemo.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Toast;

import com.wb.leila.designmodedemo.manager.ActivityStackManager;
import com.wb.leila.designmodedemo.utils.LogUtil;

/**
 * @author leila
 * email leila329@163.com
 * create at 2018/4/4
 * description: 基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    /**
     * Context
     **/
    protected Context mContext;

    /**
     * Context全局上下文
     **/
    protected Context context;

    /**
     * 初始化界面
     **/
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化点击事件
     */
    protected abstract void initCilck();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.i(TAG, "--->onCreate()");

        initView();
        initData();
        initCilck();
        getContext();
        mContext = this;
        ActivityStackManager.getInstance().pushActivity(this);

    }

    /**
     * 获取全局上下文
     */
    private void getContext() {
        if (context == null) {
            this.context = BaseApplication.getBaseApplication();
        }
    }

    public static Toast toast;

    /**
     * @param text
     */
    public void showToast(String text) {
        if (toast == null) {
            // 如果Toast对象为空了，那么需要创建一个新的Toast对象
            toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        } else {
            // 如果toast对象还存在，那么就不再创建新的Toast对象
            toast.setText(text);
        }
        // 最后调用show方法吐丝
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 页面跳转
     */
    public void skipActivity(Class clazz) {
        skipActivity(clazz, null);
    }

    /**
     * 跳转activity 带参数
     */
    protected void skipActivity(Class clazz, Bundle bundle) {

        Intent intent = new Intent(context, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);

    }

    /**
     * 跳转activity无参 返回结果
     */
    public void skipForResult(Class clazz, int requestCode) {
        skipForResult(clazz, null, requestCode);
    }

    /**
     * 跳转activity带参 返回结果
     */
    public void skipForResult(Class clazz, Bundle bundle, int requestCode) {

        Intent intent = new Intent(context, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);

    }

    /**
     * [日志输出]
     *
     * @param msg
     */
    protected void $Log(String msg) {
        LogUtil.d(TAG, msg);
    }

    /**
     * 退出应用
     * called while exit app.
     */
    public void exitLogic() {
        //system exit
        ActivityStackManager.getInstance().popAllActivity();//remove all activity.
        System.exit(0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.i(TAG, "--->onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.i(TAG, "--->onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.i(TAG, "--->onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.i(TAG, "--->onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.i(TAG, "--->onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.i(TAG, "--->onDestroy()");
        ActivityStackManager.getInstance().popActivity(this);
    }
}
