package com.wb.leila.designmodedemo.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.qmuiteam.qmui.widget.QMUIEmptyView;
import com.wb.leila.designmodedemo.R;
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

    private View view;
    private LinearLayout linearLayout;
    private LinearLayout parent;
    QMUIEmptyView qmuiEmptyView;

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
     * linearLayout下设置空布局
     *
     * @param linearLayout
     */
    public void initEmpty(LinearLayout linearLayout, View.OnClickListener onButtonClickListener) {
        //第一个参数指向的是你想要引进的布局资源ID。
        //第二个参数表示该布局的大小限制在root这个Viewgroup中。null作为第二个参数时，即表明inflate中的第一个参数传递进来的布局没有可以参考的parent viewGroup
        //如果设置第二个参数为null ，无法显示,参照文档null应该是可以的
        //第三个参数则表示是否将root作为该布局的Viewgroup。true表示该布局是附着在root中的，false表示该布局不附着在root中。
        view = getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) linearLayout.getParent(), true);
        //   this.parent = linearLayout;
        parent = (LinearLayout) view.findViewById(R.id.ll_empty);
        qmuiEmptyView = view.findViewById(R.id.empty_view);
        qmuiEmptyView.show(false, getResources().getString(R.string.emptyView_mode_desc_fail_title), getResources().getString(R.string.emptyView_mode_desc_fail_desc), getResources().getString(R.string.emptyView_mode_desc_retry), onButtonClickListener);

    }

    public void initEmpty(RelativeLayout relativeLayout) {
        if (view == null) {
            view = getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) relativeLayout.getParent(), true);
            QMUIEmptyView qmuiEmptyView = view.findViewById(R.id.empty_view);
            qmuiEmptyView.show(false, getResources().getString(R.string.emptyView_mode_desc_fail_title), getResources().getString(R.string.emptyView_mode_desc_fail_desc), getResources().getString(R.string.emptyView_mode_desc_retry), null);
        }
    }

    /**
     * 点击重新后刷新
     */
    public void refreshInit() {
        if (qmuiEmptyView != null) {
            qmuiEmptyView.show(true);
        }
    }

    /**
     * 隐藏无数据页面，用remove不生效，不懂为什么。
     */
    public void goneEmpty() {
        if (qmuiEmptyView != null) {
            qmuiEmptyView.setVisibility(View.GONE);
        }
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
     * 显示吐司
     * toast 会显示在屏幕上方的提示语句
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
