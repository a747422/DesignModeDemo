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
     * context
     **/
    protected Context mContext;

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
        mContext = this;
        ActivityStackManager.getInstance().pushActivity(this);
    }


    /**
     * 跳转Activity
     * skip Another Activity
     *
     * @param activity
     * @param cls
     */
    public static void skipAnotherActivity(Activity activity,
                                           Class<? extends Activity> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
        activity.finish();
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
