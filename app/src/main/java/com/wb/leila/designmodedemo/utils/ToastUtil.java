package com.wb.leila.designmodedemo.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.wb.leila.designmodedemo.base.BaseApplication;

/**
 * @author Leila
 * @version V1.0
 * @date 2018/4/16 14:44
 * className  ToastUtil
 * email leila329@163.com
 * description
 */
public class ToastUtil {
    private Context context;
    public static Toast toast;

    /**
     * 获取全局上下文
     */
    private void getContext() {
        if (context == null) {
            this.context = BaseApplication.getBaseApplication();
        }
    }

    /**
     * @param text
     */
    public void showToast(String text) {
        if (toast == null) {
            // 如果Toast对象为空了，那么需要创建一个新的Toast对象
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            // 如果toast对象还存在，那么就不再创建新的Toast对象
            toast.setText(text);
        }
        // 最后调用show方法吐丝
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

}
